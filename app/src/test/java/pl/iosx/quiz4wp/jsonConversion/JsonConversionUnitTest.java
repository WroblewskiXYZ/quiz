package pl.iosx.quiz4wp.jsonConversion;


import org.junit.Test;
import java.io.InputStream;

import static org.junit.Assert.*;
import com.google.gson.Gson;
//import org.apache.commons.io.IOUtils;

import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizItem;
import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizListResponse;
import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizContent;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public class JsonConversionUnitTest {

    @Test
    public void shouldReturnQuizList() throws Exception
    {

        Gson gson = new Gson();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("all_quiz_list.txt");
        String resTxtFileContent = "";//CharStreams.toString(new InputStreamReader(inputStream, Charsets.UTF_8));
        ApiQuizListResponse apiQuizListResponse = gson.fromJson(resTxtFileContent,ApiQuizListResponse.class);

        assertEquals(apiQuizListResponse.getCount(), apiQuizListResponse.getApiQuizItemItems().size());

        ApiQuizItem apiQuizItem = apiQuizListResponse.getApiQuizItemItems().get(0);
        assertEquals(apiQuizItem.getQuestions(),18);
        assertEquals(apiQuizItem.getCreatedAt(),"2018-03-27T15:36:33+0000");
        assertEquals(apiQuizItem.getId(),6234787811510401l);
        assertEquals(apiQuizItem.getCategory().getId(),2);
    }

    @Test
    public void shouldReturnQuizContent() throws Exception
    {

        Gson gson = new Gson();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("quiz_content_6234787811510401.txt");
        String resTxtFileContent = "";//IOUtils.toString(inputStream);
        ApiQuizContent apiQuizContent = gson.fromJson(resTxtFileContent,ApiQuizContent.class);

        assertEquals(apiQuizContent.getId(),6234787811510401l);
        assertEquals(apiQuizContent.getRates().get(1).getContent(),"Następnym razem musisz bardziej się postarać");
        assertEquals(apiQuizContent.getQuestions().get(0).getOrder(),1);
        assertEquals(apiQuizContent.getQuestions().get(0).getAnswers().get(1).getText(),"Wrocław");
        assertEquals(apiQuizContent.isBattle(),false);
    }


}
