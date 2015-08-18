/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * {@link NinteichosahyoShisetsuRiyo}の編集を行うビルダークラスです。
 */
public class NinteichosahyoShisetsuRiyoBuilder {

    private final DbT5210NinteichosahyoShisetsuRiyoEntity entity;
    private final NinteichosahyoShisetsuRiyoIdentifier id;

    /**
     * {@link DbT5210NinteichosahyoShisetsuRiyoEntity}より{@link NinteichosahyoShisetsuRiyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5210NinteichosahyoShisetsuRiyoEntity}
     * @param id {@link NinteichosahyoShisetsuRiyoIdentifier}
     *
     */
    NinteichosahyoShisetsuRiyoBuilder(
            DbT5210NinteichosahyoShisetsuRiyoEntity entity,
            NinteichosahyoShisetsuRiyoIdentifier id
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
     * @return {@link NinteichosahyoShisetsuRiyoBuilder}
     */
    public NinteichosahyoShisetsuRiyoBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 認定調査依頼履歴番号を設定します。
     *
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return {@link NinteichosahyoShisetsuRiyoBuilder}
     */
    public NinteichosahyoShisetsuRiyoBuilder set認定調査依頼履歴番号(int 認定調査依頼履歴番号) {
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link NinteichosahyoShisetsuRiyoBuilder}
     */
    public NinteichosahyoShisetsuRiyoBuilder set連番(int 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRemban(連番);
        return this;
    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosahyoShisetsuRiyoBuilder}
     */
    public NinteichosahyoShisetsuRiyoBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 施設利用フラグを設定します。
     *
     * @param 施設利用フラグ 施設利用フラグ
     * @return {@link NinteichosahyoShisetsuRiyoBuilder}
     */
    public NinteichosahyoShisetsuRiyoBuilder set施設利用フラグ(boolean 施設利用フラグ) {
        requireNonNull(施設利用フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("施設利用フラグ"));
        entity.setShisetsuRiyoFlag(施設利用フラグ);
        return this;
    }

    /**
     * {@link NinteichosahyoShisetsuRiyo}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoShisetsuRiyo}のインスタンス
     */
    public NinteichosahyoShisetsuRiyo build() {
        return new NinteichosahyoShisetsuRiyo(entity, id);
    }
}
