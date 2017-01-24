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
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 *
 * @author n3423
 */
public class DBEImageUtil {

    private static final RString ファイルBAK = new RString("_BAK");
    private static final RString png拡張子 = new RString(".png");

    /**
     * 共有ファイルをローカルフォルダにコピーします。
     *
     * @param sharedFileId 共有ファイルID
     * @param sharedFileName 共有ファイル名
     * @return ローカルコピー先フォルダパス
     */
    public static RString copySharedFiles(RDateTime sharedFileId, RString sharedFileName) {
        RString toCopyPath = Directory.createTmpDirectory();
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(toCopyPath)).getCanonicalPath());
    }

    /**
     * 共有ファイルを【指定したローカルフォルダ/共有ファイルID】配下にコピーします。
     *
     * @param sharedFileId 共有ファイルID
     * @param sharedFileName 共有ファイル名
     * @param batchImageFolderPath コピー先フォルダパス
     * @return ローカルコピー先フォルダパス
     */
    public static RString copySharedFilesBatch(RDateTime sharedFileId, RString sharedFileName, RString batchImageFolderPath) {
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(batchImageFolderPath)).getCanonicalPath());
    }

    /**
     * 原本イメージのパスを取得します。
     *
     * @param imageFilePath イメージフォルダパス
     * @param fileName イメージファイル名
     * @return 原本イメージファイルパス
     */
    public static RString getOriginalImageFilePath(RString imageFilePath, RString fileName) {
        RString イメージファイルパス;
        イメージファイルパス = getFilePath(imageFilePath, fileName.concat(ファイルBAK).concat(png拡張子));
        if (RString.isNullOrEmpty(イメージファイルパス)) {
            イメージファイルパス = getFilePath(imageFilePath, fileName.concat(png拡張子));
        }
        return イメージファイルパス;
    }

    /**
     * マスクイメージのパスを取得します。
     *
     * @param imageFilePath イメージフォルダパス
     * @param fileName イメージファイル名
     * @return マスクイメージファイルパス
     */
    public static RString getMaskImageFilePath(RString imageFilePath, RString fileName) {
        if (!RString.isNullOrEmpty(getFilePath(imageFilePath, fileName.concat(ファイルBAK).concat(png拡張子)))) {
            return getFilePath(imageFilePath, fileName.concat(png拡張子));
        }
        return RString.EMPTY;
    }

    /**
     * マスクイメージが存在する場合マスクイメージのパスを取得し、存在しなかった場合原本イメージのパスを取得します。
     *
     * @param imageFilePath イメージフォルダパス
     * @param imageFileName イメージファイル名
     * @return マスクor原本イメージファイルパス
     */
    public static RString getMaskOrOriginalImageFilePath(RString imageFilePath, RString imageFileName) {
        return getFilePath(imageFilePath, imageFileName.concat(png拡張子));
    }

    /**
     * 指定したイメージファイルのパスからイメージデータを取得します。
     *
     * @param imagePath イメージファイルパス
     * @return イメージデータ
     */
    public static RString sanitizePath(RString imagePath) {
        RString DATAURI_BMP = new RString("data:image/png;base64,");
        return !imagePath.isEmpty() ? DATAURI_BMP.concat(base64encode(imagePath)) : RString.EMPTY;
    }

    private static RString getFilePath(RString imageFilePath, RString ファイル名) {
        if (Directory.exists(Path.combinePath(imageFilePath, ファイル名))) {
            return Path.combinePath(imageFilePath, ファイル名);
        }
        return RString.EMPTY;
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
