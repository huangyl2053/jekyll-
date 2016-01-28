/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShujiiIkenshoKinyuItem}の編集を行うビルダークラスです。
 */
public class ShujiiIkenshoKinyuItemBuilder {

    private final DbT5303ShujiiIkenshoKinyuItemEntity entity;
    private final ShujiiIkenshoKinyuItemIdentifier id;

    /**
     * {@link DbT5303ShujiiIkenshoKinyuItemEntity}より{@link ShujiiIkenshoKinyuItem}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5303ShujiiIkenshoKinyuItemEntity}
     * @param id {@link ShujiiIkenshoKinyuItemIdentifier}
     *
     */
    ShujiiIkenshoKinyuItemBuilder(
            DbT5303ShujiiIkenshoKinyuItemEntity entity,
            ShujiiIkenshoKinyuItemIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 主治医意見書作成依頼履歴番号を設定します。
     *
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return {@link ShujiiIkenshoKinyuItemBuilder}
     */
    public ShujiiIkenshoKinyuItemBuilder set主治医意見書作成依頼履歴番号(int 主治医意見書作成依頼履歴番号) {
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link ShujiiIkenshoKinyuItemBuilder}
     */
    public ShujiiIkenshoKinyuItemBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRemban(連番);
        return this;
    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link ShujiiIkenshoKinyuItemBuilder}
     */
    public ShujiiIkenshoKinyuItemBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 記入項目を設定します。
     *
     * @param 記入項目 記入項目
     * @return {@link ShujiiIkenshoKinyuItemBuilder}
     */
    public ShujiiIkenshoKinyuItemBuilder set記入項目(RString 記入項目) {
        requireNonNull(記入項目, UrSystemErrorMessages.値がnull.getReplacedMessage("記入項目"));
        entity.setKinyuItem(記入項目);
        return this;
    }

    /**
     * 記入項目イメージ共有ファイルIDを設定します。
     *
     * @param 記入項目イメージ共有ファイルID 記入項目イメージ共有ファイルID
     * @return {@link ShujiiIkenshoKinyuItemBuilder}
     */
    public ShujiiIkenshoKinyuItemBuilder set記入項目イメージ共有ファイルID(RDateTime 記入項目イメージ共有ファイルID) {
        requireNonNull(記入項目イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("記入項目イメージ共有ファイルID"));
        entity.setKinyuItemImageSharedFileId(記入項目イメージ共有ファイルID);
        return this;
    }

    /**
     * {@link ShujiiIkenshoKinyuItem}のインスタンスを生成します。
     *
     * @return {@link ShujiiIkenshoKinyuItem}のインスタンス
     */
    public ShujiiIkenshoKinyuItem build() {
        return new ShujiiIkenshoKinyuItem(entity, id);
    }
}
