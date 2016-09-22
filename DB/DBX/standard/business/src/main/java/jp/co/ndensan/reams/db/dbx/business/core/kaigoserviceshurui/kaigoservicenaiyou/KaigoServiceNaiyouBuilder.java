/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KaigoServiceNaiyou}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBX-9999-011 sunhaidi
 */
public class KaigoServiceNaiyouBuilder {

    private final DbT7131KaigoServiceNaiyouEntity entity;
    private final KaigoServiceNaiyouIdentifier id;

    /**
     * {@link DbT7131KaigoServiceNaiyouEntity}より{@link KaigoServiceNaiyou}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7131KaigoServiceNaiyouEntity}
     * @param id {@link KaigoServiceNaiyouIdentifier}
     *
     */
    KaigoServiceNaiyouBuilder(
            DbT7131KaigoServiceNaiyouEntity entity,
            KaigoServiceNaiyouIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 提供終了年月を設定します。
     *
     * @param 提供終了年月 提供終了年月
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set提供終了年月(FlexibleYearMonth 提供終了年月) {
        requireNonNull(提供終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供終了年月"));
        entity.setTeikyoShuryoYM(提供終了年月);
        return this;
    }

    /**
     * サービス名称を設定します。
     *
     * @param サービス名称 サービス名称
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder setサービス名称(RString サービス名称) {
        requireNonNull(サービス名称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス名称"));
        entity.setServiceName(サービス名称);
        return this;
    }

    /**
     * サービス略称を設定します。
     *
     * @param サービス略称 サービス略称
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder setサービス略称(RString サービス略称) {
        requireNonNull(サービス略称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス略称"));
        entity.setServiceNameRyaku(サービス略称);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set単位数(int 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTaniSu(単位数);
        return this;
    }

    /**
     * isDeletedを設定します。
     *
     *
     * @param flag boolean
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder setIsDeleted(boolean flag) {
        entity.setIsDeleted(flag);
        return this;
    }

    /**
     * 単位数識別を設定します。
     *
     * @param 単位数識別 単位数識別
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set単位数識別(Code 単位数識別) {
        requireNonNull(単位数識別, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数識別"));
        entity.setTanisuShikibetsuCode(単位数識別);
        return this;
    }

    /**
     * 単位数算定単位を設定します。
     *
     * @param 単位数算定単位 単位数算定単位
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set単位数算定単位(Code 単位数算定単位) {
        requireNonNull(単位数算定単位, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数算定単位"));
        entity.setTanisuSanteiTaniCode(単位数算定単位);
        return this;
    }

    /**
     * 異動事由を設定します。
     *
     * @param 異動事由 異動事由
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set異動事由(Code 異動事由) {
        requireNonNull(異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由"));
        entity.setIdouJiyuCode(異動事由);
        return this;
    }

    /**
     * 限度額対象外フラグを設定します。
     *
     * @param 限度額対象外フラグ 限度額対象外フラグ
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set限度額対象外フラグ(RString 限度額対象外フラグ) {
        requireNonNull(限度額対象外フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額対象外フラグ"));
        entity.setGendogakuTaishogaiFlag(限度額対象外フラグ);
        return this;
    }

    /**
     * 外部サービス利用型区分を設定します。
     *
     * @param 外部サービス利用型区分 外部サービス利用型区分
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set外部サービス利用型区分(RString 外部サービス利用型区分) {
        requireNonNull(外部サービス利用型区分, UrSystemErrorMessages.値がnull.getReplacedMessage("外部サービス利用型区分"));
        entity.setGaibuServiceRiyoKataKubun(外部サービス利用型区分);
        return this;
    }

    /**
     * 特別地域加算フラグを設定します。
     *
     * @param 特別地域加算フラグ 特別地域加算フラグ
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set特別地域加算フラグ(RString 特別地域加算フラグ) {
        requireNonNull(特別地域加算フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("特別地域加算フラグ"));
        entity.setTokubetsuChiikiKasanFlag(特別地域加算フラグ);
        return this;
    }

    /**
     * 利用者負担定率・定額区分を設定します。
     *
     * @param 利用者負担定率_定額区分 RString
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set利用者負担定率_定額区分(RString 利用者負担定率_定額区分) {
        requireNonNull(利用者負担定率_定額区分, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担定率・定額区分"));
        entity.setRiyosyaFutanTeiritsuTeigakuKubun(利用者負担定率_定額区分);
        return this;
    }

    /**
     * 更新有無フラグを設定します。
     *
     * @param 更新有無フラグ 更新有無フラグ
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set更新有無フラグ(RString 更新有無フラグ) {
        requireNonNull(更新有無フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("更新有無フラグ"));
        entity.setKoshinUmuFoag(更新有無フラグ);
        return this;
    }

    /**
     * 元点数を設定します。
     *
     * @param 元点数 元点数
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set元点数(RString 元点数) {
        requireNonNull(元点数, UrSystemErrorMessages.値がnull.getReplacedMessage("元点数"));
        entity.setMotoTensu(元点数);
        return this;
    }

    /**
     * 元限度額対象外フラグを設定します。
     *
     * @param 元限度額対象外フラグ 元限度額対象外フラグ
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set元限度額対象外フラグ(RString 元限度額対象外フラグ) {
        requireNonNull(元限度額対象外フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("元限度額対象外フラグ"));
        entity.setMotoGendogakuTaishogaiFlag(元限度額対象外フラグ);
        return this;
    }

    /**
     * 元単位数識別コードを設定します。
     *
     * @param 元単位数識別コード 元単位数識別コード
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set元単位数識別コード(RString 元単位数識別コード) {
        requireNonNull(元単位数識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("元単位数識別コード"));
        entity.setMotoTaniShikibetsuCd(元単位数識別コード);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set利用者負担額(RString 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutanGaku(利用者負担額);
        return this;
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set給付率(RString 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuRitsu(給付率);
        return this;
    }

    /**
     * 二次予防事業対象者実施区分（非該当）を設定します。
     *
     * @param 二次予防事業対象者実施区分_非該当 RString
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set二次予防事業対象者実施区分_非該当(RString 二次予防事業対象者実施区分_非該当) {
        requireNonNull(二次予防事業対象者実施区分_非該当, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業対象者実施区分（非該当）"));
        entity.setNijiyoboJigyoTaishaJishiKubunHigaito(二次予防事業対象者実施区分_非該当);
        return this;
    }

    /**
     * 要支援１受給者実施区分を設定します。
     *
     * @param 要支援１受給者実施区分 要支援１受給者実施区分
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set要支援１受給者実施区分(RString 要支援１受給者実施区分) {
        requireNonNull(要支援１受給者実施区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要支援１受給者実施区分"));
        entity.setYoshien1JukyushaJishiKubun(要支援１受給者実施区分);
        return this;
    }

    /**
     * 要支援２受給者実施区分を設定します。
     *
     * @param 要支援２受給者実施区分 要支援２受給者実施区分
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set要支援２受給者実施区分(RString 要支援２受給者実施区分) {
        requireNonNull(要支援２受給者実施区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要支援２受給者実施区分"));
        entity.setYoshien2JukyushaJishiKubun(要支援２受給者実施区分);
        return this;
    }

    /**
     * 対象事業者実施区分を設定します。
     *
     * @param 対象事業者実施区分 対象事業者実施区分
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set対象事業者実施区分(RString 対象事業者実施区分) {
        requireNonNull(対象事業者実施区分, UrSystemErrorMessages.値がnull.getReplacedMessage("対象事業者実施区分"));
        entity.setTaishoJigyoJishiKubun(対象事業者実施区分);
        return this;
    }

    /**
     * 総合事業サービス区分を設定します。
     *
     * @param 総合事業サービス区分 総合事業サービス区分
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set総合事業サービス区分(RString 総合事業サービス区分) {
        requireNonNull(総合事業サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("総合事業サービス区分"));
        entity.setSogoJigyoServiceKubun(総合事業サービス区分);
        return this;
    }

    /**
     * 制限日数回数を設定します。
     *
     * @param 制限日数回数 制限日数回数
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set制限日数回数(RString 制限日数回数) {
        requireNonNull(制限日数回数, UrSystemErrorMessages.値がnull.getReplacedMessage("制限日数回数"));
        entity.setSeigenNissuKaisu(制限日数回数);
        return this;
    }

    /**
     * 算定回数制限期間区分を設定します。
     *
     * @param 算定回数制限期間区分 算定回数制限期間区分
     * @return {@link KaigoServiceNaiyouBuilder}
     */
    public KaigoServiceNaiyouBuilder set算定回数制限期間区分(RString 算定回数制限期間区分) {
        requireNonNull(算定回数制限期間区分, UrSystemErrorMessages.値がnull.getReplacedMessage("算定回数制限期間区分"));
        entity.setSanteiKaisuSeigenKikanKubun(算定回数制限期間区分);
        return this;
    }

    /**
     * {@link KaigoServiceNaiyou}のインスタンスを生成します。
     *
     * @return {@link KaigoServiceNaiyou}のインスタンス
     */
    public KaigoServiceNaiyou build() {
        return new KaigoServiceNaiyou(entity, id);
    }
}
