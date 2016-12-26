/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5213GaikyoChosaTokkiMaskEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3509
 */
public class GaikyoChosaTokkiBuilder {

    private final DbT5213GaikyoChosaTokkiMaskEntity entity;
    private final GaikyoChosaTokkiIdentifier id;

    /**
     * {@link DbT5213GaikyoChosaTokkiMaskEntity}より{@link GaikyoChosaTokkiBuilder}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5202NinteichosahyoGaikyoChosaEntity}
     * @param id {@link NinteichosahyoGaikyoChosaIdentifier}
     *
     */
    GaikyoChosaTokkiBuilder(
            DbT5213GaikyoChosaTokkiMaskEntity entity,
            GaikyoChosaTokkiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;
    }

    /**
     * 特記を設定します。
     *
     * @param 特記 特記
     * @return {@link NinteichosahyoGaikyoChosaBuilder}
     */
    public GaikyoChosaTokkiBuilder set特記(RString 特記) {
        requireNonNull(特記, UrSystemErrorMessages.値がnull.getReplacedMessage("特記"));
        entity.setTokki(特記);
        return this;
    }

    /**
     * {@link GaikyoChosaTokki}のインスタンスを生成します。
     *
     * @return {@link GaikyoChosaTokki}のインスタンス
     */
    public GaikyoChosaTokki build() {
        return new GaikyoChosaTokki(entity, id);
    }

}
