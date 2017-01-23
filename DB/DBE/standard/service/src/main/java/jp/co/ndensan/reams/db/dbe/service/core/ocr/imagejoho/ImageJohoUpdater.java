/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedAppendOption;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.SharedFileEntryInfoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ情報の更新、共有ファイルの追加・上書きを行います。
 */
public final class ImageJohoUpdater {

    private final FilesystemPath targetDirectoryPath;
    private final ShinseishoKanriNo 申請書管理番号;
    private final RString 証記載保険者番号;
    private final RString 被保険者番号;
    private final RDateTime 共有ファイルID;
    private final List<OcrImageClassification> 取込イメージ分類s;

    private ImageJohoUpdater(FilesystemPath targetDirectoryPath,
            ShinseishoKanriNo 申請書管理番号, RString 証記載保険者番号, RString 被保険者番号, RDateTime sharedFileID,
            Collection<? extends OcrImageClassification> 取込イメージ分類s) {
        this.targetDirectoryPath = targetDirectoryPath;
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.申請書管理番号 = 申請書管理番号;
        this.共有ファイルID = sharedFileID;
        this.取込イメージ分類s = new ArrayList(取込イメージ分類s);
    }

    /**
     * @param targetDirectoryPath イメージ情報に追加/上書きするイメージを保存したパス
     * @param 申請書管理番号 処理対象の申請書管理番号
     * @param 証記載保険者番号 処理対象の証記載保険者番号
     * @param 被保険者番号 処理対象の被保険者番号
     * @param nullOr共有ファイルID 処理対象の共有ファイルID、またイメージ情報が未登録の場合は{@code null}を指定する
     * @param 取込イメージ分類s 取り込むイメージの分類を{@code OcrImageClassification}で、すべて指定する
     * @return {@link  ImageJohoUpdater}
     */
    public static ImageJohoUpdater create(FilesystemPath targetDirectoryPath,
            ShinseishoKanriNo 申請書管理番号, RString 証記載保険者番号, RString 被保険者番号,
            RDateTime nullOr共有ファイルID, Collection<? extends OcrImageClassification> 取込イメージ分類s) {
        return new ImageJohoUpdater(targetDirectoryPath, 申請書管理番号, 証記載保険者番号, 被保険者番号,
                nullOr共有ファイルID, 取込イメージ分類s);
    }

    /**
     * @param targetDirectoryPath イメージ情報に追加/上書きするイメージを保存したパス
     * @param 申請書管理番号 処理対象の申請書管理番号
     * @param 証記載保険者番号 処理対象の証記載保険者番号
     * @param 被保険者番号 処理対象の被保険者番号
     * @param nullOr共有ファイルID 処理対象の共有ファイルID、またイメージ情報が未登録の場合は{@code null}を指定する
     * @param 取込イメージ分類s 取り込むイメージの分類を{@code OcrImageClassification}で、すべて指定する
     * @return {@link  ImageJohoUpdater}
     */
    public static ImageJohoUpdater create(FilesystemPath targetDirectoryPath,
            ShinseishoKanriNo 申請書管理番号, RString 証記載保険者番号, RString 被保険者番号,
            RDateTime nullOr共有ファイルID, OcrImageClassification... 取込イメージ分類s) {
        return new ImageJohoUpdater(targetDirectoryPath, 申請書管理番号, 証記載保険者番号, 被保険者番号,
                nullOr共有ファイルID, Arrays.asList(取込イメージ分類s));
    }

    /**
     * @param dbWriter イメージ情報を更新するための{@link BatchPermanentTableWriter}
     * @return 処理に成功した場合、{@code true}.
     */
    public boolean updateBy(IBatchTableWriter<? super DbT5115ImageEntity> dbWriter) {
        if (this.targetDirectoryPath == null) {
            return false;
        }
        if (this.共有ファイルID == null) {
            SharedFileEntryDescriptor sfed = defineAndCopyToSharedFile(this.targetDirectoryPath,
                    compose共有ファイル名(this.証記載保険者番号, this.被保険者番号));
            insertIntoImageJohoBy(dbWriter, this.申請書管理番号, sfed);
            return true;
        } else {
            ReadOnlySharedFileEntryDescriptor ro_sfd = new ReadOnlySharedFileEntryDescriptor(
                    compose共有ファイル名(this.証記載保険者番号, this.被保険者番号), this.共有ファイルID);
            deletePastFiles(ro_sfd, this.取込イメージ分類s);
            return SharedFile.appendNewFile(ro_sfd, this.targetDirectoryPath, RString.EMPTY.toString(),
                    new SharedAppendOption().overWrite(true));
        }
    }

    private static SharedFileEntryDescriptor defineAndCopyToSharedFile(FilesystemPath targetDirectoryPath, FilesystemName sharedFileName) {
        SharedFileDescriptor sfd = SharedFile.defineSharedFile(sharedFileName);
        CopyToSharedFileOpts option = new CopyToSharedFileOpts().dateToDelete(RDate.MAX);
        SharedFileEntryDescriptor sfed = SharedFile.copyToSharedFile(sfd, targetDirectoryPath, option);
        return sfed;
    }

    private static FilesystemName compose共有ファイル名(RString 証記載保険者番号1, RString 被保険者番号1) {
        return FilesystemName.fromString(証記載保険者番号1.concat(被保険者番号1));
    }

    private static void insertIntoImageJohoBy(IBatchTableWriter<? super DbT5115ImageEntity> dbWriter, ShinseishoKanriNo 申請書管理番号, SharedFileEntryDescriptor sfed) {
        DbT5115ImageEntity entityImage = new DbT5115ImageEntity();
        entityImage.setShinseishoKanriNo(申請書管理番号);
        entityImage.setImageSharedFileId(sfed.getSharedFileId());
        dbWriter.insert(entityImage);
    }

    private static void deletePastFiles(ReadOnlySharedFileEntryDescriptor ro_sfd, List<OcrImageClassification> targets) {
        List<RString> filePaths = listFilePathsInEntry(ro_sfd);
        for (final OcrImageClassification target : targets) {
            deletePastFilesInEntryPer(target, filePaths, ro_sfd);
        }
    }

    private static List<RString> listFilePathsInEntry(ReadOnlySharedFileEntryDescriptor ro_sfd) {
        List<RString> list = new ArrayList<>();
        for (SharedFileEntryInfoEntity entity : SharedFile.getEntryInfo(ro_sfd)) {
            if (entity.getFilesEntity() == null) {
                continue;
            }
            list.add(entity.getFilesEntity().getPathname());
        }
        return list;
    }

    private static void deletePastFilesInEntryPer(OcrImageClassification matcher, List<RString> filePaths,
            ReadOnlySharedFileEntryDescriptor ro_sfd) {
        for (RString filePath : filePaths) {
            if (matcher.fileNameMatcher(filePath).find()) {
                SharedFile.deleteFileInEntry(ro_sfd, filePath.toString());
            }
        }
    }
}
