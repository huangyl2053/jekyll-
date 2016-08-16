/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakukeisankkarenrakuhyopanel;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity;

/**
 * 事業高額合算支給額計算結果情報のクラスです。
 *
 * @reamsid_L DBC-4840-010 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult implements Serializable {

    private JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity
     */
    public JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelResult(JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity entity) {
        this.entity = entity;
    }
}
