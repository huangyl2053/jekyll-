/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiEntity;

/**
 * 住宅改修費支給申請情報クラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakukaishuSikyuShinseiResult implements Serializable {

    private JutakukaishuSikyuShinseiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public JutakukaishuSikyuShinseiResult(JutakukaishuSikyuShinseiEntity entity) {
        this.entity = entity;
    }
}
