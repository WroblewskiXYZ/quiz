package pl.iosx.quiz4wp.model.data.baseData;

import android.support.test.InstrumentationRegistry;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.common.io.Resources;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizContent;
import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizItem;
import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizListResponse;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.services.DbManager.DbManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */
public class DataBaseQuizModelTest {

    String quizItemResource  = "all_quiz_list.txt";
    String quizContentResource  = "quiz_content_6234787811510401.txt";
    String quizContentResource2  = "quiz_content_6235418428905601.txt";

    List<ApiQuizItem> apiQuizList;
    List<QuizModel> quizModels;
    ApiQuizItem apiQuizItem;
    ApiQuizItem apiQuizItem2;
    ApiQuizContent apiQuizContent;
    ApiQuizContent apiQuizContent2;

    @Before
    @Test
    public void shouldReturnQuizList() throws Exception
    {

        Gson gson = new Gson();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(quizItemResource);
        String resTxtFileContent = CharStreams.toString(new InputStreamReader(inputStream, Charsets.UTF_8));
        ApiQuizListResponse apiQuizListResponse = gson.fromJson(resTxtFileContent,ApiQuizListResponse.class);

        assertEquals(apiQuizListResponse.getCount(), apiQuizListResponse.getApiQuizItemItems().size());
        apiQuizList = apiQuizListResponse.getApiQuizItemItems();
        quizModels = new ArrayList<>();
        for(ApiQuizItem item : apiQuizList)
        {
            quizModels.add(new QuizModel(item));
        }
        apiQuizItem = apiQuizListResponse.getApiQuizItemItems().get(0);

    }

    @Before
    @Test
    public void shouldReturnQuizContent() throws Exception
    {
        Gson gson = new Gson();
        URL url = Resources.getResource(quizContentResource);
        String text = Resources.toString(url, Charset.defaultCharset());
        apiQuizContent = gson.fromJson(text,ApiQuizContent.class);
    }

    @Before
    @Test
    public void shouldReturnQuizModel()
    {
        long specId = apiQuizContent.getId();
        ApiQuizItem specQuizItem = null;

        for(ApiQuizItem item : apiQuizList)
        {
            if(item.getId() == specId)
            {
                specQuizItem = item;
                break;
            }
        }
        QuizModel quizModel = new QuizModel(specQuizItem);

        quizModel.update(apiQuizContent);
    }

    @Test
    public void shouldClearDataBase()
    {
        DbManager dbManager = new DbManager(InstrumentationRegistry.getTargetContext());
        dbManager.clearDataBase();
        List<QuizModel> models = dbManager.getAllQuizModels(true);
        assertEquals(models.size(),0);
    }


    @Test
    public void shouldAddQuizTest() throws SQLException, IOException, CloneNotSupportedException {

        DbManager dbManager = new DbManager(InstrumentationRegistry.getTargetContext());
        dbManager.clearDataBase();
        List<QuizModel> newModels = dbManager.getAllQuizModels(true);

        dbManager.clearDataBase();

        Gson gson = new Gson();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(quizItemResource);
        String resTxtFileContent = CharStreams.toString(new InputStreamReader(inputStream, Charsets.UTF_8));
        ApiQuizListResponse apiQuizListResponse = gson.fromJson(resTxtFileContent,ApiQuizListResponse.class);
        apiQuizList = apiQuizListResponse.getApiQuizItemItems();

        URL url = Resources.getResource(quizContentResource);
        String text = Resources.toString(url, Charset.defaultCharset());
        apiQuizContent = gson.fromJson(text,ApiQuizContent.class);
        long specId1 = apiQuizContent.getId();

        url = Resources.getResource(quizContentResource2);
        text = Resources.toString(url, Charset.defaultCharset());
        apiQuizContent2 = gson.fromJson(text,ApiQuizContent.class);
        long specId2 = apiQuizContent2.getId();

        ApiQuizItem specQuizItem = null;
        ApiQuizItem specQuizItem2 = null;

        for(ApiQuizItem item : apiQuizList)
            if(item.getId() == specId1) specQuizItem = item;
            else if(item.getId() == specId2) specQuizItem2 = item;

        QuizModel quizModelExtended = new QuizModel(specQuizItem);
        quizModelExtended.update(apiQuizContent);

        QuizModel quizModelExtended2 = new QuizModel(specQuizItem2);
        quizModelExtended2.update(apiQuizContent2);
        quizModelExtended2.setQuestionsDone(5);
        quizModelExtended2.setQuestionsPoints(4);

        System.out.println("update 2 extended quiz");

        quizModels.clear();
        quizModels.add(quizModelExtended2);

        int quizCount = quizModelExtended2.getQuestions().size();

        dbManager.addQuizModels(quizModels);
        List<QuizModel> newModels2 = dbManager.getAllQuizModels(true);
        QuizModel quizModel = newModels2.get(0);

        assertNotNull(quizModel);
        assertNotNull(quizModel.getQuestions());
        assertEquals(quizModel.getQuestions().size(), quizCount);

        dbManager.clearDataBase();
        dbManager.addQuizModels(quizModels);
        List<QuizModel> newModels3 = dbManager.getAllQuizModels(true);
        QuizModel quizModel3 = newModels3.get(0);

        assertNotNull(quizModel3);
        assertNotNull(quizModel3.getQuestions());
        assertEquals(quizModel3.getQuestions().size(), quizCount);

        System.out.println("done");
    }

}