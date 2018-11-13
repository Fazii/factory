package com.nowakowski.fabryka;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;

class Serializer {

  static void serialize(File file) throws IOException {
    switch (FilenameUtils.getExtension(file.getAbsolutePath())) {
      case "json":
        System.out.println(
            new ObjectMapper().readValue(file, Entity.class)
        );
        break;
      case "xml":
        System.out.println(
            new XmlMapper().readValue(file, Entity.class)
        );
        break;
      case "csv":
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        ObjectReader oReader = mapper.reader(Entity.class).with(schema);

        try (java.io.Reader reader = new FileReader(file)) {
          MappingIterator<Entity> mi = oReader.readValues(reader);
          while (mi.hasNext()) {
            System.out.println(mi.next());
          }
        }

    }
  }
}
