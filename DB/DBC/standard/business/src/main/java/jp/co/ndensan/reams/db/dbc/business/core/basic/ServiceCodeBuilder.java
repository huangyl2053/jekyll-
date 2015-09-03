/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7119ServiceCodeEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ServiceCode}の編集を行うビルダークラスです。
 */
public class ServiceCodeBuilder {

    private final DbT7119ServiceCodeEntity entity;
    private final ServiceCodeIdentifier id;

    /**
     * {@link DbT7119ServiceCodeEntity}より{@link ServiceCode}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7119ServiceCodeEntity}
     * @param id {@link ServiceCodeIdentifier}
     *
     */
    ServiceCodeBuilder(
            DbT7119ServiceCodeEntity entity,
            ServiceCodeIdentifier id
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
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
        return this;
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder set適用開始年月(FlexibleYearMonth 適用開始年月) {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYM(適用開始年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 適用終了年月を設定します。
     *
     * @param 適用終了年月 適用終了年月
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder set適用終了年月(FlexibleYearMonth 適用終了年月) {
        requireNonNull(適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月"));
        entity.setTekiyoShuryoYM(適用終了年月);
        return this;
    }

    /**
     * サービス名称を設定します。
     *
     * @param サービス名称 サービス名称
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder setサービス名称(RString サービス名称) {
        requireNonNull(サービス名称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス名称"));
        entity.setServiceMeisho(サービス名称);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTaniSu(単位数);
        return this;
    }

    /**
     * 限度額対象外フラグを設定します。
     *
     * @param 限度額対象外フラグ 限度額対象外フラグ
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder set限度額対象外フラグ(RString 限度額対象外フラグ) {
        requireNonNull(限度額対象外フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額対象外フラグ"));
        entity.setGendoGakuTaishogaiFlag(限度額対象外フラグ);
        return this;
    }

    /**
     * 単位数識別コードを設定します。
     *
     * @param 単位数識別コード 単位数識別コード
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder set単位数識別コード(RString 単位数識別コード) {
        requireNonNull(単位数識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数識別コード"));
        entity.setTaniSuShikibetsuCode(単位数識別コード);
        return this;
    }

    /**
     * 外部サービス利用型区分を設定します。
     *
     * @param 外部サービス利用型区分 外部サービス利用型区分
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder set外部サービス利用型区分(RString 外部サービス利用型区分) {
        requireNonNull(外部サービス利用型区分, UrSystemErrorMessages.値がnull.getReplacedMessage("外部サービス利用型区分"));
        entity.setGaibuServiceRiyogataKubun(外部サービス利用型区分);
        return this;
    }

    /**
     * 特別地域加算フラグを設定します。
     *
     * @param 特別地域加算フラグ 特別地域加算フラグ
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder set特別地域加算フラグ(RString 特別地域加算フラグ) {
        requireNonNull(特別地域加算フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("特別地域加算フラグ"));
        entity.setTokubetsuChiikiKasanFlag(特別地域加算フラグ);
        return this;
    }

    /**
     * 利用者負担定率_定額区分を設定します。
     *
     * @param 利用者負担定率_定額区分 利用者負担定率_定額区分
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder set利用者負担定率_定額区分(RString 利用者負担定率_定額区分) {
        requireNonNull(利用者負担定率_定額区分, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担定率_定額区分"));
        entity.setTeiRitsu_TeiGakuKubun(利用者負担定率_定額区分);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder set利用者負担額(Decimal 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutanGaku(利用者負担額);
        return this;
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     * @return {@link ServiceCodeBuilder}
     */
    public ServiceCodeBuilder set給付率(HokenKyufuRitsu 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuRitsu(給付率);
        return this;
    }

    /**
     * {@link ServiceCode}のインスタンスを生成します。
     *
     * @return {@link ServiceCode}のインスタンス
     */
    public ServiceCode build() {
        return new ServiceCode(entity, id);
    }
}
