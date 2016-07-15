/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagesyutsuryoku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.SharedFileEntryInfoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定イメージ情報出力のFinderクラスです。
 *
 * @reamsid_L DBE-1670-011 wangxiaodong
 */
public class YokaigoninteiimageShutsuryokuFinder {

    private final List<SharedFileEntryInfoEntity> sharedFile;

    /**
     * コンストラクタです。
     *
     * @param ro_sfed ReadOnlySharedFileEntryDescriptor
     */
    public YokaigoninteiimageShutsuryokuFinder(ReadOnlySharedFileEntryDescriptor ro_sfed) {
        sharedFile = SharedFile.getEntryInfo(ro_sfed);
    }

    /**
     * 存在するイメージファイル名を取得します。
     *
     * @param fileName List<RString>
     * @return List<RString>
     */
    public List<RString> getSharedFile(List<RString> fileName) {
        List<RString> 存在するファイル = new ArrayList<>();
        for (SharedFileEntryInfoEntity entity : sharedFile) {
            for (RString name : fileName) {
                if (name.equals(entity.getFileEntryEntity().getSharedFileName())) {
                    存在するファイル.add(name);
                }
            }
        }
        return 存在するファイル;
    }
}
