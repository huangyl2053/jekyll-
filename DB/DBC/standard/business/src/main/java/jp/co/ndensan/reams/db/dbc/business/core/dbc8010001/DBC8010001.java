/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.dbc8010001;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 振込明細・振込みデータ作成の前回処理情報を取得するのビジネス。
 *
 * @reamsid_L DBC-2180-010 x_liuwei
 */
public class DBC8010001 {

    private final DbT7022ShoriDateKanriEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity DbT7022ShoriDateKanriEntity
     */
    public DBC8010001(DbT7022ShoriDateKanriEntity entity) {
        this.entity = entity;
    }

    /**
     * 処理時期管理entityを返します。
     *
     * @return entity DbT7022ShoriDateKanriEntity
     */
    public DbT7022ShoriDateKanriEntity getEntity() {
        return this.entity;
    }

}
