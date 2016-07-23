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
     * @param sharedFiles List<RString>
     * @return List<RString>
     */
    public List<RString> get存在したイメージファイル(List<RString> fileName, List<RString> sharedFiles) {
        List<RString> 存在するファイル = new ArrayList<>();
        for (RString file : sharedFiles) {
            for (RString name : fileName) {
                if (name.equals(file)) {
                    存在するファイル.add(name);
                }
            }
        }
        return 存在するファイル;
    }

    /**
     * 存在したイメージファイル名を取得します。
     *
     * @return 存在したイメージファイル名
     */
    public List<RString> getSharedFile() {
        List<RString> 存在したイメージファイル名 = new ArrayList<>();
        for (SharedFileEntryInfoEntity info : sharedFile) {
            if (info.getFilesEntity() == null) {
                continue;
            }
            存在したイメージファイル名.add(info.getFilesEntity().getPathname());
        }
        return 存在したイメージファイル名;
    }
}
