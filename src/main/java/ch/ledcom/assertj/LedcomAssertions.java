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
import org.assertj.core.api.Assertions;

import java.nio.ByteBuffer;
import java.nio.file.Path;

public class LedcomAssertions extends Assertions {

    public static ByteBufferAssert assertThat(ByteBuffer actual) {
        return new ByteBufferAssert(actual);
    }

    public static CpioArchiveInputStreamAssert assertThat(CpioArchiveInputStream actual) {
        return new CpioArchiveInputStreamAssert(actual);
    }

    public static FsDirectoryEntryAssert assertThat(FsDirectoryEntry actual) {
        return new FsDirectoryEntryAssert(actual);
    }

    public static PathAssert assertThat(Path actual) {
        return new PathAssert(actual);
    }
}
