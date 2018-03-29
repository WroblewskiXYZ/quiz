package pl.iosx.quiz4wp.jsonConversion;


import org.junit.Test;
import java.io.InputStream;

import static org.junit.Assert.*;
import com.google.gson.Gson;
//import org.apache.commons.io.IOUtils;

import pl.iosx.quiz4wp.model.data.apiData.QuizResponse;
import pl.iosx.quiz4wp.model.data.apiData.quiz.QuizItem;
import pl.iosx.quiz4wp.model.data.apiData.quizContent.QuizContent;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public class JsonConversionUnitTest {

    @Test
    public void shouldReturnQuizList() throws Exception
    {

        Gson gson = new Gson();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("all_quiz_list.txt");
        String resTxtFileContent = "";//IOUtils.toString(inputStream);
        QuizResponse quizResponse = gson.fromJson(resTxtFileContent,QuizResponse.class);

        assertEquals(quizResponse.getCount(),quizResponse.getQuizItemItems().size());

        QuizItem quizItem = quizResponse.getQuizItemItems().get(0);
        assertEquals(quizItem.getQuestions(),18);
        assertEquals(quizItem.getCreatedAt(),"2018-03-27T15:36:33+0000");
        assertEquals(quizItem.getId(),6234787811510401l);
        assertEquals(quizItem.getCategory().getId(),2);
    }

    @Test
    public void shouldReturnQuizContent() throws Exception
    {

        Gson gson = new Gson();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("quiz_content_6234787811510401.txt");
        String resTxtFileContent = "";//IOUtils.toString(inputStream);
        QuizContent quizContent = gson.fromJson(resTxtFileContent,QuizContent.class);

        assertEquals(quizContent.getId(),6234787811510401l);
        assertEquals(quizContent.getRates().get(1).getContent(),"Następnym razem musisz bardziej się postarać");
        assertEquals(quizContent.getQuestions().get(0).getOrder(),1);
        assertEquals(quizContent.getQuestions().get(0).getAnswers().get(1).getText(),"Wrocław");
        assertEquals(quizContent.isBattle(),false);
    }


}
