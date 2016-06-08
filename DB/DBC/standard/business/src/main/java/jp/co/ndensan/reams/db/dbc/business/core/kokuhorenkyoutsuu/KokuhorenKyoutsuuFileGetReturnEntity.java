/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;

/**
 * 国保連情報取込共通処理（ファイル取得）の返すエンティティ
 *
 * @reamsid_L DBC-0980-525 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenKyoutsuuFileGetReturnEntity {

    private FilesystemPath 保存先フォルダのパス;
    private List<UzT0885SharedFileEntryEntity> entityList;

    /**
     * コンストラクタです。
     *
     */
    public KokuhorenKyoutsuuFileGetReturnEntity() {
    }

    /**
     * コンストラクタです。
     *
     * @param 保存先フォルダのパス FilesystemPath
     * @param entityList List<UzT0885SharedFileEntryEntity>
     */
    public KokuhorenKyoutsuuFileGetReturnEntity(FilesystemPath 保存先フォルダのパス, List<UzT0885SharedFileEntryEntity> entityList) {
        this.保存先フォルダのパス = 保存先フォルダのパス;
        this.entityList = entityList;
    }
}
