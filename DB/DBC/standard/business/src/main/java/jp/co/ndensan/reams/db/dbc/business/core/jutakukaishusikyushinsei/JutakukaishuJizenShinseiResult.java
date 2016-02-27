/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinsei.JutakukaishuJizenShinseiEntity;

/**
 * 住宅改修費事前申請情報クラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakukaishuJizenShinseiResult {

    private JutakukaishuJizenShinseiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public JutakukaishuJizenShinseiResult(JutakukaishuJizenShinseiEntity entity) {
        this.entity = entity;
    }
}
