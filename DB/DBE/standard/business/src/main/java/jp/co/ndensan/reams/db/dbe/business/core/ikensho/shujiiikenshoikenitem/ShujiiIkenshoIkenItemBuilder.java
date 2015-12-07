/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShujiiIkenshoIkenItem}の編集を行うビルダークラスです。
 */
public class ShujiiIkenshoIkenItemBuilder {

    private final DbT5304ShujiiIkenshoIkenItemEntity entity;
    private final ShujiiIkenshoIkenItemIdentifier id;

    /**
     * {@link DbT5304ShujiiIkenshoIkenItemEntity}より{@link ShujiiIkenshoIkenItem}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5304ShujiiIkenshoIkenItemEntity}
     * @param id {@link ShujiiIkenshoIkenItemIdentifier}
     *
     */
    ShujiiIkenshoIkenItemBuilder(
            DbT5304ShujiiIkenshoIkenItemEntity entity,
            ShujiiIkenshoIkenItemIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 主治医意見書作成依頼履歴番号を設定します。
     *
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return {@link ShujiiIkenshoIkenItemBuilder}
     */
    public ShujiiIkenshoIkenItemBuilder set主治医意見書作成依頼履歴番号(int 主治医意見書作成依頼履歴番号) {
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link ShujiiIkenshoIkenItemBuilder}
     */
    public ShujiiIkenshoIkenItemBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRemban(連番);
        return this;
    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link ShujiiIkenshoIkenItemBuilder}
     */
    public ShujiiIkenshoIkenItemBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 意見項目を設定します。
     *
     * @param 意見項目 意見項目
     * @return {@link ShujiiIkenshoIkenItemBuilder}
     */
    public ShujiiIkenshoIkenItemBuilder set意見項目(RString 意見項目) {
        requireNonNull(意見項目, UrSystemErrorMessages.値がnull.getReplacedMessage("意見項目"));
        entity.setIkenItem(意見項目);
        return this;
    }

    /**
     * {@link ShujiiIkenshoIkenItem}のインスタンスを生成します。
     *
     * @return {@link ShujiiIkenshoIkenItem}のインスタンス
     */
    public ShujiiIkenshoIkenItem build() {
        return new ShujiiIkenshoIkenItem(entity, id);
    }
}
