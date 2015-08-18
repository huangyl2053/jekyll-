/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5211NinteichosahyoChosaItemEntity;
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

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link NinteichosahyoChosaItemBuilder}
     */
    public NinteichosahyoChosaItemBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 要介護認定調査履歴番号を設定します。
     *
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @return {@link NinteichosahyoChosaItemBuilder}
     */
    public NinteichosahyoChosaItemBuilder set要介護認定調査履歴番号(int 要介護認定調査履歴番号) {
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        entity.setNinteichosaRirekiNo(要介護認定調査履歴番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link NinteichosahyoChosaItemBuilder}
     */
    public NinteichosahyoChosaItemBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRemban(連番);
        return this;
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
