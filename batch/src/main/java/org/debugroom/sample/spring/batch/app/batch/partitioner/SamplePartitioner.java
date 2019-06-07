package org.debugroom.sample.spring.batch.app.batch.partitioner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SamplePartitioner implements Partitioner {

    private String param;

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {

        Map<String, ExecutionContext> executionContextMap = new HashMap<>();

        try(InputStream inputStream = getClass().getResourceAsStream(param);
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);){
            String readLine;
            int index = 0;
            while ((readLine = bufferedReader.readLine()) != null){
                ExecutionContext executionContext = new ExecutionContext();
                executionContext.putString("partitionId", readLine);
                executionContextMap.put("partition" + index, executionContext);
                index++;
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return executionContextMap;
    }

}
