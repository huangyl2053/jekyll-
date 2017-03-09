/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.tokkiimages;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.tokkiimages.TokkiRembanRenumberingResult;
import jp.co.ndensan.reams.db.dbe.business.core.tokkiimages.TokkiRembanRenumberingResult.FileNameBeforeAfter;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.business.util.Files;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedAppendOption;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 特記事項の連番振り直しとイメージの名前変更を行います。
 */
public class TokkiRembanRenumberingService {

    public static TokkiRembanRenumberingService createInstance() {
        return InstanceProvider.create(TokkiRembanRenumberingService.class);
    }

    /**
     * @param rosfed 共有ファイルエントリキー
     * @param currentImageDirectory 現在イメージが格納されているディレクトリ
     * @param result 連番変更結果
     */
    @Transaction
    public void save(ReadOnlySharedFileEntryDescriptor rosfed, RString currentImageDirectory, TokkiRembanRenumberingResult result) {
        NinteichosahyoTokkijikoManager manager = NinteichosahyoTokkijikoManager.createInstance();
        for (NinteichosahyoTokkijiko t : result.targetsToDelete()) {
            manager.save認定調査票_特記情報(t);
        }
        for (NinteichosahyoTokkijiko t : result.targetsToAdd()) {
            manager.save認定調査票_特記情報(t);
        }
        RString workDirectory = Directory.createTmpDirectory();
        Map<RString, RString> filePathByFileName = Files.filePathByFileName(currentImageDirectory);
        for (FileNameBeforeAfter ba : result.getRenamedImageNames()) {
            RString beforeFilePath = findFilePath(filePathByFileName, ba.getBeforeFileName());
            if (beforeFilePath.isEmpty()) {
                continue;
            }
            File.copy(beforeFilePath, ba.composeAfterPathAsIn(workDirectory));
            SharedFile.deleteFileInEntry(rosfed, ba.getBeforeFileName().toString());
        }
        SharedFile.appendNewFile(rosfed, FilesystemPath.fromString(workDirectory), "", overWrite());
    }

    private static RString findFilePath(Map<RString, RString> filePathByFileName, RString fileName) {
        for (Map.Entry<RString, RString> entry : filePathByFileName.entrySet()) {
            if (java.util.Objects.equals(entry.getKey().toLowerCase(), fileName.toLowerCase())) {
                return entry.getValue();
            }
        }
        return RString.EMPTY;
    }

    private static SharedAppendOption overWrite() {
        SharedAppendOption op = new SharedAppendOption();
        op.overWrite(true);
        return op;
    }
}
