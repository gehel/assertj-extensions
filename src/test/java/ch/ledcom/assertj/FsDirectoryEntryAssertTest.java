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
import org.junit.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ch.ledcom.assertj.FsDirectoryEntryAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

public class FsDirectoryEntryAssertTest {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");

    @Test
    public final void assertModificationDateWithPrecisionOfZero() throws IOException {
        FsDirectoryEntry entry = mock(FsDirectoryEntry.class);
        when(entry.getLastModified()).thenReturn(1000L);
        when(entry.getName()).thenReturn("entry name");

        assertThat(entry).hasBeenModifiedAt(new Date(1000L), 0);
    }

    @Test
    public final void assertModificationDateWithPrecisionOfTen() throws IOException {
        FsDirectoryEntry entry = mock(FsDirectoryEntry.class);
        when(entry.getLastModified()).thenReturn(1000L);
        when(entry.getName()).thenReturn("entry name");

        assertThat(entry).hasBeenModifiedAt(new Date(1010L), 10);
    }

    @Test(expected = AssertionError.class)
    public final void failForDateOutOfPrecisionRange() throws IOException {
        FsDirectoryEntry entry = mock(FsDirectoryEntry.class);
        when(entry.getLastModified()).thenReturn(1000L);
        when(entry.getName()).thenReturn("entry name");

        assertThat(entry).hasBeenModifiedAt(new Date(1010L), 9);
    }

    @Test(expected = AssertionError.class)
    public final void failForNullEntry() throws IOException {
        assertThat((FsDirectoryEntry) null).hasBeenModifiedAt(new Date(1000L), 9);
    }

    @Test
    public final void errorMessageContainsAllNeededInformation() throws IOException {
        try {
            FsDirectoryEntry entry = mock(FsDirectoryEntry.class);
            when(entry.getLastModified()).thenReturn(1000L);
            when(entry.getName()).thenReturn("entry name");

            assertThat(entry).hasBeenModifiedAt(new Date(100000L), 0);
        } catch (AssertionError error) {
            assertThat(error).hasMessageContaining("Entry <\"entry name");
            assertThat(error).hasMessageContaining("has not been modified at <\"" + DATE_FORMAT.format(new Date(100000L)));
            assertThat(error).hasMessageContaining("Last modification was on <\"" + DATE_FORMAT.format(new Date(1000L)));
        }
    }

}
