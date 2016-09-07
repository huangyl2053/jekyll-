/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.renrakuhyodatacreator;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;

/**
 * 介護保険連絡票作成のBusinessクラスです。
 *
 * @reamsid_L DBA-1290-020 linghuhang
 */
public class RiyoshaFutangakuBusiness {

    private final DbT4014RiyoshaFutangakuGengakuEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity RiyoshaFutangakuRelateEntity
     */
    public RiyoshaFutangakuBusiness(DbT4014RiyoshaFutangakuGengakuEntity entity) {
        this.entity = entity;
    }

    /**
     * 旧措置情報を取得します。
     *
     * @return 旧措置情報
     */
    public boolean is旧措置情報() {
        return entity.getKyuSochishaUmu();
    }

    /**
     * 給付率を取得します。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu get給付率() {
        return entity.getKyuhuritsu();
    }
}
