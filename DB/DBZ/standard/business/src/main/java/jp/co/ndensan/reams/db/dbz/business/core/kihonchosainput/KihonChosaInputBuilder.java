/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.kihonchosainput.KihonChosaInputEntity;

/**
 * {@link KihonChosaInput}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public class KihonChosaInputBuilder {

    private final KihonChosaInputEntity entity;

    /**
     * {@link KihonChosaInputEntity}より{@link KihonChosaInput}の編集用Builderクラスを生成します。
     *
     * @param entity {@link KihonChosaInputEntity}
     *
     */
    KihonChosaInputBuilder(KihonChosaInputEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査依頼履歴番号を設定します。
     *
     * @param 特記事項有無 特記事項有無
     * @return {@link KihonChosaInputBuilder}
     */
    public KihonChosaInputBuilder set特記事項有無(boolean 特記事項有無) {
        entity.set特記事項有無(特記事項有無);
        return this;
    }

    /**
     * {@link KihonChosaInput}のインスタンスを生成します。
     *
     * @return {@link KihonChosaInput}のインスタンス
     */
    public KihonChosaInput build() {
        return new KihonChosaInput(entity);
    }

}
