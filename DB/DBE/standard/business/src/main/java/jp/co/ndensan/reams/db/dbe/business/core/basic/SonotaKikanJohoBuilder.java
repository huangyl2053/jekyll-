/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link SonotaKikanJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-021 suguangjun
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
     * 金融機関コードを設定します。
     *
     * @param 金融機関コード 金融機関コード
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set金融機関コード(KinyuKikanCode 金融機関コード) {
        requireNonNull(金融機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("金融機関コード"));
        entity.setKinyuKikanCode(金融機関コード);
        return this;
    }

    /**
     * 金融機関支店コードを設定します。
     *
     * @param 金融機関支店コード 金融機関支店コード
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set金融機関支店コード(KinyuKikanShitenCode 金融機関支店コード) {
        requireNonNull(金融機関支店コード, UrSystemErrorMessages.値がnull.getReplacedMessage("金融機関支店コード"));
        entity.setKinyuKikanShitenCode(金融機関支店コード);
        return this;
    }

    /**
     * 預金種別を設定します。
     *
     * @param 預金種別 預金種別
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set預金種別(RString 預金種別) {
        requireNonNull(預金種別, UrSystemErrorMessages.値がnull.getReplacedMessage("預金種別"));
        entity.setYokinShubetsu(預金種別);
        return this;
    }

    /**
     * 口座番号を設定します。
     *
     * @param 口座番号 口座番号
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set口座番号(RString 口座番号) {
        requireNonNull(口座番号, UrSystemErrorMessages.値がnull.getReplacedMessage("口座番号"));
        entity.setKozaNo(口座番号);
        return this;
    }

    /**
     * 口座名義人カナを設定します。
     *
     * @param 口座名義人カナ 口座名義人カナ
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set口座名義人カナ(AtenaKanaMeisho 口座名義人カナ) {
        requireNonNull(口座名義人カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("口座名義人カナ"));
        entity.setKozaMeigininKana(口座名義人カナ);
        return this;
    }

    /**
     * 漢字名義人を設定します。
     *
     * @param 漢字名義人 漢字名義人
     * @return {@link SonotaKikanJohoBuilder}
     */
    public SonotaKikanJohoBuilder set漢字名義人(AtenaMeisho 漢字名義人) {
        requireNonNull(漢字名義人, UrSystemErrorMessages.値がnull.getReplacedMessage("漢字名義人"));
        entity.setKozaMeiginin(漢字名義人);
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
