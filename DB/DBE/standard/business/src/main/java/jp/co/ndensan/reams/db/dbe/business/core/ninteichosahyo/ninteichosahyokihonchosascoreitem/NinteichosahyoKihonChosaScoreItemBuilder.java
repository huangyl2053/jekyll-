/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascoreitem;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5212NinteichosahyoKihonChosaScoreItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * {@link NinteichosahyoKihonChosaScoreItem}の編集を行うビルダークラスです。
 */
public class NinteichosahyoKihonChosaScoreItemBuilder {

    private final DbT5212NinteichosahyoKihonChosaScoreItemEntity entity;
    private final NinteichosahyoKihonChosaScoreItemIdentifier id;

    /**
     * {@link DbT5212NinteichosahyoKihonChosaScoreItemEntity}より{@link NinteichosahyoKihonChosaScoreItem}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5212NinteichosahyoKihonChosaScoreItemEntity}
     * @param id {@link NinteichosahyoKihonChosaScoreItemIdentifier}
     *
     */
    NinteichosahyoKihonChosaScoreItemBuilder(
            DbT5212NinteichosahyoKihonChosaScoreItemEntity entity,
            NinteichosahyoKihonChosaScoreItemIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosahyoKihonChosaScoreItemBuilder}
     */
    public NinteichosahyoKihonChosaScoreItemBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 素点項目を設定します。
     *
     * @param 素点項目 素点項目
     * @return {@link NinteichosahyoKihonChosaScoreItemBuilder}
     */
    public NinteichosahyoKihonChosaScoreItemBuilder set素点項目(int 素点項目) {
        requireNonNull(素点項目, UrSystemErrorMessages.値がnull.getReplacedMessage("素点項目"));
        entity.setReserchItem01(素点項目);
        return this;
    }

    /**
     * {@link NinteichosahyoKihonChosaScoreItem}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoKihonChosaScoreItem}のインスタンス
     */
    public NinteichosahyoKihonChosaScoreItem build() {
        return new NinteichosahyoKihonChosaScoreItem(entity, id);
    }
}
