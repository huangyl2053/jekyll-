/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.core.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.externalcharacter.util._Base64Converter;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 *
 * @author n3423
 */
public class DBEImageUtil {
    
    public static RString copySharedFiles(RDateTime sharedFileId, RString sharedFileName) {
        RString toCopyPath = Directory.createTmpDirectory();
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(toCopyPath)).getCanonicalPath());
    }
    
    public static RString sanitizePath(RString imagePath) {
        RString DATAURI_BMP = new RString("data:image/png;base64,");
        return !imagePath.isEmpty() ? DATAURI_BMP.concat(base64encode(imagePath)) : RString.EMPTY;
    }

    private static RString base64encode(RString imagePath) {
        RString imgBase64 = RString.EMPTY;
        try {
            imgBase64 = _Base64Converter.encodeBase64RString(Files.readAllBytes(Paths.get(imagePath.toString())));
        } catch (IOException ex) {
            throw new SystemException(ex);
        }
        return imgBase64;
    }
}
