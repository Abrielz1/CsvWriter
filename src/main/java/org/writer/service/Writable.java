package org.writer.service;

import java.util.List;

public interface Writable {

    void writeToFile(List<?> data, final String head, String fileName);
}
