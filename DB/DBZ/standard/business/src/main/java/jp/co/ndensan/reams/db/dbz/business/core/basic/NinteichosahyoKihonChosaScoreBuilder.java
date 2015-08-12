/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5204NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * {@link NinteichosahyoKihonChosaScore}の編集を行うビルダークラスです。
 */
public class NinteichosahyoKihonChosaScoreBuilder {

    private final DbT5204NinteichosahyoKihonChosaScoreEntity entity;
    private final NinteichosahyoKihonChosaScoreIdentifier id;

    /**
     * {@link DbT5204NinteichosahyoKihonChosaScoreEntity}より{@link NinteichosahyoKihonChosaScore}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5204NinteichosahyoKihonChosaScoreEntity}
     * @param id {@link NinteichosahyoKihonChosaScoreIdentifier}
     *
     */
    NinteichosahyoKihonChosaScoreBuilder(
            DbT5204NinteichosahyoKihonChosaScoreEntity entity,
            NinteichosahyoKihonChosaScoreIdentifier id
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
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 要介護認定調査履歴番号を設定します。
     *
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set要介護認定調査履歴番号(int 要介護認定調査履歴番号) {
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        entity.setNinteichosaRirekiNo(要介護認定調査履歴番号);
        return this;
    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 素点合計_第１郡を設定します。
     *
     * @param 素点合計_第１郡 素点合計_第１郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第１郡(int 素点合計_第１郡) {
        requireNonNull(素点合計_第１郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計_第１郡"));
        entity.setTokutenTotal1gun(素点合計_第１郡);
        return this;
    }

    /**
     * 素点合計_第２郡を設定します。
     *
     * @param 素点合計_第２郡 素点合計_第２郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第２郡(int 素点合計_第２郡) {
        requireNonNull(素点合計_第２郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計_第２郡"));
        entity.setTokutenTotal2gun(素点合計_第２郡);
        return this;
    }

    /**
     * 素点合計_第３郡を設定します。
     *
     * @param 素点合計_第３郡 素点合計_第３郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第３郡(int 素点合計_第３郡) {
        requireNonNull(素点合計_第３郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計_第３郡"));
        entity.setTokutenTotal3gun(素点合計_第３郡);
        return this;
    }

    /**
     * 素点合計_第４郡を設定します。
     *
     * @param 素点合計_第４郡 素点合計_第４郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第４郡(int 素点合計_第４郡) {
        requireNonNull(素点合計_第４郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計_第４郡"));
        entity.setTokutenTotal4gun(素点合計_第４郡);
        return this;
    }

    /**
     * 素点合計_第５郡を設定します。
     *
     * @param 素点合計_第５郡 素点合計_第５郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第５郡(int 素点合計_第５郡) {
        requireNonNull(素点合計_第５郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計_第５郡"));
        entity.setTokutenTotal5gun(素点合計_第５郡);
        return this;
    }

    /**
     * 素点合計_第６郡を設定します。
     *
     * @param 素点合計_第６郡 素点合計_第６郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第６郡(int 素点合計_第６郡) {
        requireNonNull(素点合計_第６郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計_第６郡"));
        entity.setTokutenTotal6gun(素点合計_第６郡);
        return this;
    }

    /**
     * 素点合計_第７郡を設定します。
     *
     * @param 素点合計_第７郡 素点合計_第７郡
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder set素点合計_第７郡(int 素点合計_第７郡) {
        requireNonNull(素点合計_第７郡, UrSystemErrorMessages.値がnull.getReplacedMessage("素点合計_第７郡"));
        entity.setTokutenTotal7gun(素点合計_第７郡);
        return this;
    }

    /**
     * {@link NinteichosahyoKihonChosaScore}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoKihonChosaScore}のインスタンス
     */
    public NinteichosahyoKihonChosaScore build() {
        return new NinteichosahyoKihonChosaScore(entity, id);
    }
}
