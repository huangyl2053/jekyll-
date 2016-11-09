/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hokenshajohosoufu;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenshajohosoufu.HokenshaJoHoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者情報送付の共有ファイルエントリ情報クラスです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
public class HokenshaJoHoData {

    private final HokenshaJoHoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public HokenshaJoHoData(HokenshaJoHoEntity entity) {
        this.entity = entity;
    }

    /**
     * 共有ファイル名を取得します。
     *
     * @return 共有ファイル名
     */
    public RString getFileName() {
        return entity.getFileName();
    }

    /**
     * 共有ファイルIDを取得します。
     *
     * @return 共有ファイルID
     */
    public RDateTime getFileID() {
        return entity.getFileId();
    }

}
