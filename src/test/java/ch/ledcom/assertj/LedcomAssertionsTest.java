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

import de.waldheinz.fs.FsDirectoryEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.file.Path;

import static ch.ledcom.assertj.LedcomAssertions.assertThat;

public class LedcomAssertionsTest {

    @Test
    public final void assertionCreatedForByteBuffer() {
        assertThat(assertThat((ByteBuffer)null)).isNotNull();
    }

    @Test
    public final void assertionCreatedForCpioArchiveInputStream() {
        assertThat(assertThat((CpioArchiveInputStream)null)).isNotNull();
    }

    @Test
    public final void assertionCreatedForFsDirectoryEntry() {
        assertThat(assertThat((FsDirectoryEntry)null)).isNotNull();
    }

    @Test
    public final void assertionCreatedForPath() {
        assertThat(assertThat((Path)null)).isNotNull();
    }

    @Test
    public final void standardAssertionsAlsoAvailable() {
        assertThat(assertThat((Boolean)null)).isNotNull();
    }

    /**
     * Not really sure when it is useful to instantiate this class, but it seems to be part of the AssertJ examples.
     */
    @Test
    public final void ledcomAssertionsCanBeInstantiated() {
        assertThat(new LedcomAssertions()).isNotNull();
    }

}
