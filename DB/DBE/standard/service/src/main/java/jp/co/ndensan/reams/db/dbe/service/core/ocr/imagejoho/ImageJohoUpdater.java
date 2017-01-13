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
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedAppendOption;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
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
            SharedFileDescriptor sfd = SharedFile.defineSharedFile(FilesystemName
                    .fromString(this.証記載保険者番号.concat(this.被保険者番号)));
            RDateTime newSharedFileID = SharedFile.copyToSharedFile(this.targetDirectoryPath, sfd.getSharedFileName());
            /* イメージ情報の更新 */
            DbT5115ImageEntity entityImage = new DbT5115ImageEntity();
            entityImage.setShinseishoKanriNo(this.申請書管理番号);
            entityImage.setImageSharedFileId(newSharedFileID);
            dbWriter.insert(entityImage);
            return true;
        } else {
            ReadOnlySharedFileEntryDescriptor ro_sfd = new ReadOnlySharedFileEntryDescriptor(FilesystemName
                    .fromString(this.証記載保険者番号.concat(this.被保険者番号)), this.共有ファイルID);
            deleteBackupFileIfExists(ro_sfd, this.取込イメージ分類s);
            SharedAppendOption option = new SharedAppendOption();
            option.overWrite(true);
            return SharedFile.appendNewFile(ro_sfd, this.targetDirectoryPath, RString.EMPTY.toString(), option);
        }
    }

    private static void deleteBackupFileIfExists(ReadOnlySharedFileEntryDescriptor ro_sfd, List<OcrImageClassification> targets) {
        RString tmpDirectoryPath = Directory.createTmpDirectory();
        SharedFile.copyToLocal(ro_sfd, new FilesystemPath(tmpDirectoryPath));
        java.io.File tmpDirectory = new java.io.File(tmpDirectoryPath.toString());
        for (final OcrImageClassification target : targets) {
            _deleteBackupFileIfExistsIn(tmpDirectory, target, ro_sfd);
        }
        tmpDirectory.delete();
    }

    private static void _deleteBackupFileIfExistsIn(java.io.File tmpDirectory, final OcrImageClassification matcher,
            ReadOnlySharedFileEntryDescriptor ro_sfd) {
        for (String fileName : tmpDirectory.list()) {
            if (matcher.matchesBackupFileName(fileName)) {
                SharedFile.deleteFileInEntry(ro_sfd, fileName);
            }
        }
    }
}
