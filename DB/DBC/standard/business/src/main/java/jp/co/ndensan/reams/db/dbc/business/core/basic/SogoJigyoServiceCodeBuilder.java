/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7122SogoJigyoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link SogoJigyoServiceCode}の編集を行うビルダークラスです。
 */
public class SogoJigyoServiceCodeBuilder {

    private final DbT7122SogoJigyoServiceCodeEntity entity;
    private final SogoJigyoServiceCodeIdentifier id;

    /**
     * {@link DbT7122SogoJigyoServiceCodeEntity}より{@link SogoJigyoServiceCode}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7122SogoJigyoServiceCodeEntity}
     * @param id {@link SogoJigyoServiceCodeIdentifier}
     *
     */
    SogoJigyoServiceCodeBuilder(
            DbT7122SogoJigyoServiceCodeEntity entity,
            SogoJigyoServiceCodeIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
        return this;
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set適用開始年月(FlexibleYearMonth 適用開始年月) {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYM(適用開始年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 適用終了年月を設定します。
     *
     * @param 適用終了年月 適用終了年月
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set適用終了年月(FlexibleYearMonth 適用終了年月) {
        requireNonNull(適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月"));
        entity.setTekiyoShuryoYM(適用終了年月);
        return this;
    }

    /**
     * サービス名称を設定します。
     *
     * @param サービス名称 サービス名称
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder setサービス名称(RString サービス名称) {
        requireNonNull(サービス名称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス名称"));
        entity.setServiceMeisho(サービス名称);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTaniSu(単位数);
        return this;
    }

    /**
     * 限度額対象外フラグを設定します。
     *
     * @param 限度額対象外フラグ 限度額対象外フラグ
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set限度額対象外フラグ(RString 限度額対象外フラグ) {
        requireNonNull(限度額対象外フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額対象外フラグ"));
        entity.setGendoGakuTaishogaiFlag(限度額対象外フラグ);
        return this;
    }

    /**
     * 単位数識別コードを設定します。
     *
     * @param 単位数識別コード 単位数識別コード
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set単位数識別コード(RString 単位数識別コード) {
        requireNonNull(単位数識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数識別コード"));
        entity.setTaniSuShikibetsuCode(単位数識別コード);
        return this;
    }

    /**
     * 外部サービス利用型区分を設定します。
     *
     * @param 外部サービス利用型区分 外部サービス利用型区分
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set外部サービス利用型区分(RString 外部サービス利用型区分) {
        requireNonNull(外部サービス利用型区分, UrSystemErrorMessages.値がnull.getReplacedMessage("外部サービス利用型区分"));
        entity.setGaibuServiceRiyoKubun(外部サービス利用型区分);
        return this;
    }

    /**
     * 特別地域加算フラグを設定します。
     *
     * @param 特別地域加算フラグ 特別地域加算フラグ
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set特別地域加算フラグ(RString 特別地域加算フラグ) {
        requireNonNull(特別地域加算フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("特別地域加算フラグ"));
        entity.setTokubetsuChiikiKasanFlag(特別地域加算フラグ);
        return this;
    }

    /**
     * 利用者負担定率／定額区分を設定します。
     *
     * @param 利用者負担定率／定額区分 利用者負担定率／定額区分
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set利用者負担定率

    ／定額区分(RString 利用者負担定率
        ／定額区分) {
        requireNonNull(利用者負担定率／定額区分
        , UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担定率／定額区分")
        );
        entity.setTeiRitsu_TeiGakuKubun(利用者負担定率／定額区分
        );
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set利用者負担額(Decimal 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutanGaku(利用者負担額);
        return this;
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set給付率(HokenKyufuRitsu 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuRitsu(給付率);
        return this;
    }

    /**
     * 二次予防事業対象者実施区分を設定します。
     *
     * @param 二次予防事業対象者実施区分 二次予防事業対象者実施区分
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set二次予防事業対象者実施区分(RString 二次予防事業対象者実施区分) {
        requireNonNull(二次予防事業対象者実施区分, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業対象者実施区分"));
        entity.setNijiYoboTaishosha_JissiKubun(二次予防事業対象者実施区分);
        return this;
    }

    /**
     * 要支援１受給者実施区分を設定します。
     *
     * @param 要支援１受給者実施区分 要支援１受給者実施区分
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set要支援１受給者実施区分(RString 要支援１受給者実施区分) {
        requireNonNull(要支援１受給者実施区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要支援１受給者実施区分"));
        entity.setYoShien1_JisshiKubun(要支援１受給者実施区分);
        return this;
    }

    /**
     * 要支援２受給者実施区分を設定します。
     *
     * @param 要支援２受給者実施区分 要支援２受給者実施区分
     * @return {@link SogoJigyoServiceCodeBuilder}
     */
    public SogoJigyoServiceCodeBuilder set要支援２受給者実施区分(RString 要支援２受給者実施区分) {
        requireNonNull(要支援２受給者実施区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要支援２受給者実施区分"));
        entity.setYoShien2_JisshiKubun(要支援２受給者実施区分);
        return this;
    }

    /**
     * {@link SogoJigyoServiceCode}のインスタンスを生成します。
     *
     * @return {@link SogoJigyoServiceCode}のインスタンス
     */
    public SogoJigyoServiceCode build() {
        return new SogoJigyoServiceCode(entity, id);
    }
}
