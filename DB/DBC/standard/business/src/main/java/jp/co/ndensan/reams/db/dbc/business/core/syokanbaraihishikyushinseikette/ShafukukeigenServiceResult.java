/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraihishikyushinseikette.ShafukukeigenServiceEntity;

/**
 * 社福軽減額サービス種類一覧のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShafukukeigenServiceResult implements Serializable {

    private final ShafukukeigenServiceEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public ShafukukeigenServiceResult(ShafukukeigenServiceEntity entity) {
        this.entity = entity;
    }
}
