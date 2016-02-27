/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinseiikkatushinsa;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinseiikkatushinsa.MiShinsaSikyuShinseiEntity;

/**
 * 未審査支給申請情報用クラスです。
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MiShinsaSikyuShinsei implements Serializable {

    private final MiShinsaSikyuShinseiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public MiShinsaSikyuShinsei(MiShinsaSikyuShinseiEntity entity) {
        this.entity = entity;
    }
}
