/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.dbc5140011main;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;

/**
 * サービスコード単位明細リストのクラスです。
 *
 * @reamsid_L DBC-3330-010 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC5140011MainResult {

    private final DbT7130KaigoServiceShuruiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity DbT7130KaigoServiceShuruiEntity
     */
    public DBC5140011MainResult(DbT7130KaigoServiceShuruiEntity entity) {
        this.entity = entity;
    }
}
