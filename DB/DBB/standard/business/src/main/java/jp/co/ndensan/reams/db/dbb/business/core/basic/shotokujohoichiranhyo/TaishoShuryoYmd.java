/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohoichiranhyo;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyo.TaishoShuryoYmdEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象終了日時
 *
 * @reamsid_L DBB-1650-030 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoShuryoYmd {

    private final TaishoShuryoYmdEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity TaishoShuryoYmdEntity
     */
    public TaishoShuryoYmd(TaishoShuryoYmdEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村コードを取得する。
     *
     * @return LasdecCode
     */
    public LasdecCode get市町村コード() {
        return entity.get市町村コード();
    }

    /**
     * 対象終了日時を取得する。
     *
     * @return YMDHMS
     */
    public YMDHMS get対象終了日時() {
        return entity.get対象終了日時();
    }

    /**
     * 年度内連番を取得する。
     *
     * @return RString
     */
    public RString get年度内連番() {
        return entity.get年度内連番();
    }

}
