/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraihishikyushinseikette.KyufujissekiKihonEntity;

/**
 * 給付実績基本情報リストのオブジェクトクラスです。
 *
 * @reamsid_L DBC-1030-200 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiKihonResult implements Serializable {

    private final KyufujissekiKihonEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public KyufujissekiKihonResult(KyufujissekiKihonEntity entity) {
        this.entity = entity;
    }
}
