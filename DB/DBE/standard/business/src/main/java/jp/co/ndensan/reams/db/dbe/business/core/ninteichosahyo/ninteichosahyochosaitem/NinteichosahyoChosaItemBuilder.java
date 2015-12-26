/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link NinteichosahyoChosaItem}の編集を行うビルダークラスです。
 */
public class NinteichosahyoChosaItemBuilder {

    private final DbT5211NinteichosahyoChosaItemEntity entity;
    private final NinteichosahyoChosaItemIdentifier id;

    /**
     * {@link DbT5211NinteichosahyoChosaItemEntity}より{@link NinteichosahyoChosaItem}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5211NinteichosahyoChosaItemEntity}
     * @param id {@link NinteichosahyoChosaItemIdentifier}
     *
     */
    NinteichosahyoChosaItemBuilder(
            DbT5211NinteichosahyoChosaItemEntity entity,
            NinteichosahyoChosaItemIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosahyoChosaItemBuilder}
     */
    public NinteichosahyoChosaItemBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 調査項目を設定します。
     *
     * @param 調査項目 調査項目
     * @return {@link NinteichosahyoChosaItemBuilder}
     */
    public NinteichosahyoChosaItemBuilder set調査項目(RString 調査項目) {
        requireNonNull(調査項目, UrSystemErrorMessages.値がnull.getReplacedMessage("調査項目"));
        entity.setReserchItem(調査項目);
        return this;
    }

    /**
     * {@link NinteichosahyoChosaItem}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoChosaItem}のインスタンス
     */
    public NinteichosahyoChosaItem build() {
        return new NinteichosahyoChosaItem(entity, id);
    }
}
