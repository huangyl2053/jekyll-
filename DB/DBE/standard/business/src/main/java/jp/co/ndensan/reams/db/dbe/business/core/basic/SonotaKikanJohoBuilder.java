/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link SonotaKikanJoho}の編集を行うビルダークラスです。
 */
public class SonotaKikanJohoBuilder {

    private final DbT5914SonotaKikanJohoEntity entity;
    private final SonotaKikanJohoIdentifier id;

    /**
     * {@link DbT5914SonotaKikanJohoEntity}より{@link SonotaKikanJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5914SonotaKikanJohoEntity}
     * @param id {@link SonotaKikanJohoIdentifier}
     *
     */
    SonotaKikanJohoBuilder(
            DbT5914SonotaKikanJohoEntity entity,
            SonotaKikanJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * その他機関コードを設定します。
     *
     * @param その他機関コード その他機関コード
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder setその他機関コード(RString その他機関コード) {
        requireNonNull(その他機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("その他機関コード"));
        entity.setSonotaKikanCode(その他機関コード);
        return this;
    }

    /**
     * 機関名称を設定します。
     *
     * @param 機関名称 機関名称
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set機関名称(RString 機関名称) {
        requireNonNull(機関名称, UrSystemErrorMessages.値がnull.getReplacedMessage("機関名称"));
        entity.setKikanMeisho(機関名称);
        return this;
    }

    /**
     * 機関名称カナを設定します。
     *
     * @param 機関名称カナ 機関名称カナ
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set機関名称カナ(RString 機関名称カナ) {
        requireNonNull(機関名称カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("機関名称カナ"));
        entity.setKikanMeishoKana(機関名称カナ);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set住所(RString 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
        return this;
    }

    /**
     * 住所カナを設定します。
     *
     * @param 住所カナ 住所カナ
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set住所カナ(RString 住所カナ) {
        requireNonNull(住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("住所カナ"));
        entity.setJushoKana(住所カナ);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * 調査委託区分を設定します。
     *
     * @param 調査委託区分 調査委託区分
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set調査委託区分(RString 調査委託区分) {
        requireNonNull(調査委託区分, UrSystemErrorMessages.値がnull.getReplacedMessage("調査委託区分"));
        entity.setChosaItakuKubun(調査委託区分);
        return this;
    }

    /**
     * 割付定員を設定します。
     *
     * @param 割付定員 割付定員
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set割付定員(int 割付定員) {
        requireNonNull(割付定員, UrSystemErrorMessages.値がnull.getReplacedMessage("割付定員"));
        entity.setWaritsukeTeiin(割付定員);
        return this;
    }

    /**
     * 割付地区を設定します。
     *
     * @param 割付地区 割付地区
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set割付地区(ChikuCode 割付地区) {
        requireNonNull(割付地区, UrSystemErrorMessages.値がnull.getReplacedMessage("割付地区"));
        entity.setWaritsukeChiku(割付地区);
        return this;
    }

    /**
     * 機関の区分を設定します。
     *
     * @param 機関の区分 機関の区分
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set機関の区分(RString 機関の区分) {
        requireNonNull(機関の区分, UrSystemErrorMessages.値がnull.getReplacedMessage("機関の区分"));
        entity.setKikanKubun(機関の区分);
        return this;
    }

    /**
     * 廃止フラグを設定します。
     *
     * @param 廃止フラグ 廃止フラグ
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set廃止フラグ(boolean 廃止フラグ) {
        requireNonNull(廃止フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("廃止フラグ"));
        entity.setHaishiFlag(廃止フラグ);
        return this;
    }

    /**
     * {@link SonotaKikanJoho}のインスタンスを生成します。
     *
     * @return {@link SonotaKikanJoho}のインスタンス
     */
    public SonotaKikanJoho build() {
        return new SonotaKikanJoho(entity, id);
    }
}
