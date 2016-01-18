/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import jp.co.ndensan.reams.db.dbz.entity.db.view.DbV2502KaigoShotokuEntity;

/**
 * {@link KaigoShotokuAlive}の編集を行うビルダークラスです。
 */
public class KaigoShotokuAliveBuilder {

    private final DbV2502KaigoShotokuEntity entity;
    private final KaigoShotokuAliveIdentifier id;

    /**
     * {@link DbV2502KaigoShotokuEntity}より{@link KaigoShotokuAlive}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbV2502KaigoShotokuEntity}
     * @param id {@link KaigoShotokuAliveIdentifier}
     *
     */
    KaigoShotokuAliveBuilder(DbV2502KaigoShotokuEntity entity, KaigoShotokuAliveIdentifier id) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * {@link KaigoShotokuAlive}のインスタンスを生成します。
     *
     * @return {@link KaigoShotokuAlive}のインスタンス
     */
    public KaigoShotokuAlive build() {
        return new KaigoShotokuAlive(entity, id);
    }
}
