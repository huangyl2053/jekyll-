/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyuikkatushinsa;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;

/**
 * 福祉用具購入費支給申請一括審査・決定Entityクラスです。
 *
 * @author 陳奥奇
 */
@lombok.Getter
@lombok.Setter
public class ShokanShinseiEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 償還払請求基本Entity。
     *
     * @return 償還払請求基本Entity -- SETTER -- 償還払請求基本Entity。
     *
     * @param 償還払請求基本Entity 償還払請求基本Entity
     */
    private DbT3038ShokanKihonEntity 償還払請求基本Entity;

    private DbT3034ShokanShinseiEntity 償還払支給申請Entity;

    private AtenaMeisho 氏名;

    /**
     * コンストラクタです。
     *
     * @param 償還払請求基本Entity 償還払請求基本Entity
     * @param 償還払支給申請Entity 償還払支給申請Entity
     * @param 氏名 氏名
     */
    public ShokanShinseiEntity(DbT3038ShokanKihonEntity 償還払請求基本Entity,
            DbT3034ShokanShinseiEntity 償還払支給申請Entity,
            AtenaMeisho 氏名) {
        this.償還払請求基本Entity = 償還払請求基本Entity;
        this.償還払支給申請Entity = 償還払支給申請Entity;
        this.氏名 = 氏名;
    }

    private void initializeMd5ToEntities() {
        this.償還払請求基本Entity.initializeMd5();

        this.償還払支給申請Entity.initializeMd5();
    }
}
