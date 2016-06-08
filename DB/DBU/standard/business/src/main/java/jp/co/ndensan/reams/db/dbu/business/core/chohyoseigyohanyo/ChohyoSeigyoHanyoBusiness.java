/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.chohyoseigyohanyo;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票制御汎用を設定です。
 *
 * @reamsid_L DBU-0420-010 yaodongsheng
 */
public class ChohyoSeigyoHanyoBusiness {

    private final DbT7067ChohyoSeigyoHanyoEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7067ChohyoSeigyoHanyoEntity}より{@link ChohyoSeigyoHanyoBusiness}を生成します。
     *
     * @param entity DBより取得した{@link DbT7067ChohyoSeigyoHanyoEntity}
     */
    public ChohyoSeigyoHanyoBusiness(DbT7067ChohyoSeigyoHanyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 項目名を返します。
     *
     * @return 項目名
     */
    public RString getkomokuValue() {
        return entity.getKomokuValue();
    }

}
