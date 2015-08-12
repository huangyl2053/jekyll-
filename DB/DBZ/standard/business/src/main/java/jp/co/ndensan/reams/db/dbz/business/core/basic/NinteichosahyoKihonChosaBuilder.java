/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * {@link NinteichosahyoKihonChosa}の編集を行うビルダークラスです。
 */
public class NinteichosahyoKihonChosaBuilder {

    private final DbT5203NinteichosahyoKihonChosaEntity entity;
    private final NinteichosahyoKihonChosaIdentifier id;

    /**
     * {@link DbT5203NinteichosahyoKihonChosaEntity}より{@link NinteichosahyoKihonChosa}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5203NinteichosahyoKihonChosaEntity}
     * @param id {@link NinteichosahyoKihonChosaIdentifier}
     *
     */
    NinteichosahyoKihonChosaBuilder(
            DbT5203NinteichosahyoKihonChosaEntity entity,
            NinteichosahyoKihonChosaIdentifier id
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
     * @return {@link NinteichosahyoKihonChosaBuilder}
     */
    public NinteichosahyoKihonChosaBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 要介護認定調査履歴番号を設定します。
     *
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @return {@link NinteichosahyoKihonChosaBuilder}
     */
    public NinteichosahyoKihonChosaBuilder set要介護認定調査履歴番号(int 要介護認定調査履歴番号) {
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        entity.setNinteichosaRirekiNo(要介護認定調査履歴番号);
        return this;
    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosahyoKihonChosaBuilder}
     */
    public NinteichosahyoKihonChosaBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 認定調査_認知症高齢者の日常生活自立度コードを設定します。
     *
     * @param 認定調査_認知症高齢者の日常生活自立度コード 認定調査_認知症高齢者の日常生活自立度コード
     * @return {@link NinteichosahyoKihonChosaBuilder}
     */
    public NinteichosahyoKihonChosaBuilder set認定調査_認知症高齢者の日常生活自立度コード(Code 認定調査_認知症高齢者の日常生活自立度コード) {
        requireNonNull(認定調査_認知症高齢者の日常生活自立度コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査_認知症高齢者の日常生活自立度コード"));
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(認定調査_認知症高齢者の日常生活自立度コード);
        return this;
    }

    /**
     * 認定調査_障害高齢者の日常生活自立度コードを設定します。
     *
     * @param 認定調査_障害高齢者の日常生活自立度コード 認定調査_障害高齢者の日常生活自立度コード
     * @return {@link NinteichosahyoKihonChosaBuilder}
     */
    public NinteichosahyoKihonChosaBuilder set認定調査_障害高齢者の日常生活自立度コード(Code 認定調査_障害高齢者の日常生活自立度コード) {
        requireNonNull(認定調査_障害高齢者の日常生活自立度コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査_障害高齢者の日常生活自立度コード"));
        entity.setShogaiNichijoSeikatsuJiritsudoCode(認定調査_障害高齢者の日常生活自立度コード);
        return this;
    }

    /**
     * {@link NinteichosahyoKihonChosa}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoKihonChosa}のインスタンス
     */
    public NinteichosahyoKihonChosa build() {
        return new NinteichosahyoKihonChosa(entity, id);
    }
}
