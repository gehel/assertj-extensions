/**
 * Copyright (C) 2014 LedCom (guillaume.lederrey@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.ledcom.assertj;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ch.ledcom.assertj.PathAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class PathAssertTest {

    @Test
    public void existingPath() throws IOException {
        assertThat(Paths.get("src/test/resources/test-archive.cpio")).exists();
    }

    @Test(expected = AssertionError.class)
    public void testingForExistenceOfNonExistingPathThrowsException() throws IOException {
        assertThat(Paths.get("non-existing")).exists();
    }

    @Test(expected = AssertionError.class)
    public void testingForExistenceOfNullPathThrowsException() throws IOException {
        assertThat((Path)null).exists();
    }

    @Test
    public void nonExistingPath() throws IOException {
        assertThat(Paths.get("non-existing")).doesNotExist();
    }

    @Test(expected = AssertionError.class)
    public void testingForNonExistenceOfExistingPathThrowsException() throws IOException {
        assertThat(Paths.get("src/test/resources/test-archive.cpio")).doesNotExist();
    }

    @Test(expected = AssertionError.class)
    public void testingForNonExistenceOfNullPathThrowsException() throws IOException {
        assertThat((Path)null).doesNotExist();
    }

    @Test
    public void matchingFileName() {
        assertThat(Paths.get("/tmp/toto.ext")).hasFileName("toto.ext");
    }

    @Test(expected = AssertionError.class)
    public void nonMatchingFileName() {
        assertThat(Paths.get("/tmp/toto.ext")).hasFileName("tutu.ext");
    }

    @Test
    public void nonMatchingFileNameErrorMessagesContainsAllNeededInformation() {
        try {
            assertThat(Paths.get("/tmp/toto.ext")).hasFileName("tutu.ext");
        } catch (AssertionError ae) {
            assertThat(ae).hasMessageContaining("Path </tmp/toto.ext");
            assertThat(ae).hasMessageContaining("file name <\"tutu.ext");
        }
    }

    @Test(expected = AssertionError.class)
    public void nullPathHasNoFileName() {
        assertThat((Path)null).hasFileName("");
    }

}
