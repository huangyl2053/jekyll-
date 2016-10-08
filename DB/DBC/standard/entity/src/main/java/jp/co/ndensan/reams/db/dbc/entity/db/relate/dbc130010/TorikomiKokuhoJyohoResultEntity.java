/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010;

/**
 * 取込国保情報ResultEntityクラスです。
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorikomiKokuhoJyohoResultEntity {

    private int 件数;
    private TorikomiKokuhoJyohoEntity 取込国保情報Entity;
}
