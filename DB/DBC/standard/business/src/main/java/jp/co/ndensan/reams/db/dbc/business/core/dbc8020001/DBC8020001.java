/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.dbc8020001;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.kozafurikomi.furikomigroup.FurikomiGroupItakushaRelateEntity;

/**
 * 事業合算・事業分振込明細書作成（一括）の前回処理情報を取得するのビジネス。
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class DBC8020001 {

    private final DbT7022ShoriDateKanriEntity entity;
    private final FurikomiGroupItakushaRelateEntity furikomiGroupItakushaRelateEntity;

    /**
     * コンストラクタです。
     *
     * @param entity DbT7022ShoriDateKanriEntity
     */
    public DBC8020001(DbT7022ShoriDateKanriEntity entity) {
        this.entity = entity;
        this.furikomiGroupItakushaRelateEntity = null;
    }

    /**
     * コンストラクタです。
     *
     * @param furikomiGroupItakushaRelateEntity FurikomiGroupItakushaRelateEntity
     */
    public DBC8020001(FurikomiGroupItakushaRelateEntity furikomiGroupItakushaRelateEntity) {
        this.entity = null;
        this.furikomiGroupItakushaRelateEntity = furikomiGroupItakushaRelateEntity;
    }

    /**
     * 処理時期管理entityを返します。
     *
     * @return entity DbT7022ShoriDateKanriEntity
     */
    public DbT7022ShoriDateKanriEntity getEntity() {
        return this.entity;
    }

    /**
     * FurikomiGroupItakushaRelateEntityを返します。
     *
     * @return entity DbT7022ShoriDateKanriEntity
     */
    public FurikomiGroupItakushaRelateEntity getFurikomiGroupItakushaRelateEntity() {
        return this.furikomiGroupItakushaRelateEntity;
    }
}
