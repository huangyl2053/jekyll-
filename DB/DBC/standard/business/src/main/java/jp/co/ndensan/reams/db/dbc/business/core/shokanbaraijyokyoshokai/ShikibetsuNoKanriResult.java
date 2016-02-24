/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai;

import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;

/**
 * 識別番号管理データ取得の返却結果
 */
@lombok.Getter
@lombok.Setter
public class ShikibetsuNoKanriResult {

    private ShikibetsuNoKanri entity;

    /**
     * 識別番号管理データ取得の返却結果を生成します。
     *
     * @param entity ShikibetsuNoKanri
     */
    public ShikibetsuNoKanriResult(ShikibetsuNoKanri entity) {
        this.entity = entity;
    }
}
