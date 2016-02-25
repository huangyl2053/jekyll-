/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei.ShiharaiKekaEntity;

/**
 * 支払結果情報のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiKekkaResult implements Serializable {

    private final ShiharaiKekaEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public ShiharaiKekkaResult(ShiharaiKekaEntity entity) {
        this.entity = entity;
    }
}
