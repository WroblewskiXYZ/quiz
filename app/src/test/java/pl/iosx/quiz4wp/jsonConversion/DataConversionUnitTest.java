package pl.iosx.quiz4wp.jsonConversion;


import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import static org.junit.Assert.*;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.common.io.Resources;
import com.google.gson.Gson;
//import org.apache.commons.io.IOUtils;

import pl.iosx.quiz4wp.model.data.DataConverter;
import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizItem;
import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizListResponse;
import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizContent;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public class DataConversionUnitTest {

    String quizItemResource  = "all_quiz_list.txt";
    String quizContentResource  = "quiz_content_6234787811510401.txt";

    List<ApiQuizItem> apiQuizList;
    ApiQuizItem apiQuizItem;
    ApiQuizContent apiQuizContent;

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
        apiQuizItem = apiQuizListResponse.getApiQuizItemItems().get(0);

        assertEquals(apiQuizItem.getQuestionCount(),8);
        assertTrue(apiQuizItem.getCreatedAt().startsWith("2018-03-29T"));
        assertTrue(apiQuizItem.getMainPhoto().getSource().startsWith("East News"));
        assertEquals(apiQuizItem.getId(),6235476260304513l);
        assertEquals(apiQuizItem.getCategory().getId(),12);
    }

    @Before
    @Test
    public void shouldReturnQuizContent() throws Exception
    {
        Gson gson = new Gson();
        URL url = Resources.getResource(quizContentResource);
        String text = Resources.toString(url, Charset.defaultCharset());
        apiQuizContent = gson.fromJson(text,ApiQuizContent.class);

       assertEquals(apiQuizContent.getId(),6234787811510401l);
       assertEquals(apiQuizContent.getMainPhoto().getSource(),"PAP");
       assertEquals(apiQuizContent.getQuestions().size(),18);
       assertTrue(apiQuizContent.getCategory()!=null);
       assertEquals(apiQuizContent.getRates().get(0).getTo(),20);

    }

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

        assertEquals(quizModel.getId(),specId);
        assertTrue(quizModel.getTitle().startsWith("Rozpoznaj"));
        assertTrue(quizModel.getType().startsWith("KNOW"));
        assertTrue(quizModel.getContent().startsWith("Jeden"));
        assertEquals(quizModel.getMainPhoto(),specQuizItem.getMainPhoto());
        assertEquals(quizModel.getCategory(),specQuizItem.getCategory());
        assertEquals(quizModel.getMainPhoto(),specQuizItem.getMainPhoto());
        assertFalse(quizModel.isDownloaded());

        quizModel.update(apiQuizContent);

        assertEquals(quizModel.getId(),specId);
        assertTrue(quizModel.getTitle().startsWith("Rozpoznaj"));
        assertTrue(quizModel.getType().startsWith("KNOW"));
        assertTrue(quizModel.getContent().startsWith("Jeden"));
        assertEquals(quizModel.getMainPhoto(),apiQuizContent.getMainPhoto());
        assertEquals(quizModel.getCategory().compareTo(apiQuizContent.getCategory()),0);
        assertEquals(quizModel.getRates(),apiQuizContent.getRates());
        assertNotNull(quizModel.getQuestions());
        assertNotNull(quizModel.getMainPhoto());
        assertNotNull(quizModel.getCategory());
        assertNotNull(quizModel.getRates());
        assertEquals(quizModel.getQuestions(),apiQuizContent.getQuestions());
        assertTrue(quizModel.isDownloaded());
    }

}
