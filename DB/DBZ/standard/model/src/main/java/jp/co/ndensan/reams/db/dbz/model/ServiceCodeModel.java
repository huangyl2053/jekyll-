/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7119ServiceCodeEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * サービスコードのモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class ServiceCodeModel implements Serializable {

    private DbT7119ServiceCodeEntity entity;

    /**
     * コンストラクタです。
     */
    public ServiceCodeModel() {
        entity = new DbT7119ServiceCodeEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7119ServiceCodeEntity
     */
    public ServiceCodeModel(DbT7119ServiceCodeEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7119ServiceCodeEntityを返します。
     *
     * @return DbT7119ServiceCodeEntity
     */
    public DbT7119ServiceCodeEntity getEntity() {
        return entity;
    }

    /**
     * DbT7119ServiceCodeEntityを設定します。
     *
     * @param entity DbT7119ServiceCodeEntity
     */
    public void setEntity(DbT7119ServiceCodeEntity entity) {
        this.entity = entity;
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getサービス項目コード() {
        return entity.getServiceKomokuCode();
    }

    /**
     * 適用開始年月を返します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.getTekiyoKaishiYM();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 適用終了年月を返します。
     *
     * @return 適用終了年月
     */
    public FlexibleYearMonth get適用終了年月() {
        return entity.getTekiyoShuryoYM();
    }

    /**
     * サービス名称を返します。
     *
     * @return サービス名称
     */
    public RString getサービス名称() {
        return entity.getServiceMeisho();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public Decimal get単位数() {
        return entity.getTaniSu();
    }

    /**
     * 限度額対象外フラグを返します。
     *
     * @return 限度額対象外フラグ
     */
    public RString get限度額対象外フラグ() {
        return entity.getGendoGakuTaishogaiFlag();
    }

    /**
     * 単位数識別コードを返します。
     *
     * @return 単位数識別コード
     */
    public RString get単位数識別コード() {
        return entity.getTaniSuShikibetsuCode();
    }

    /**
     * 外部サービス利用型区分を返します。
     *
     * @return 外部サービス利用型区分
     */
    public RString get外部サービス利用型区分() {
        return entity.getGaibuServiceRiyogataKubun();
    }

    /**
     * 特別地域加算フラグを返します。
     *
     * @return 特別地域加算フラグ
     */
    public RString get特別地域加算フラグ() {
        return entity.getTokubetsuChiikiKasanFlag();
    }

    /**
     * 利用者負担定率_定額区分を返します。
     *
     * @return 利用者負担定率_定額区分
     */
    public RString get利用者負担定率_定額区分() {
        return entity.getTeiRitsu_TeiGakuKubun();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public Decimal get利用者負担額() {
        return entity.getRiyoshaFutanGaku();
    }

    /**
     * 給付率を返します。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu get給付率() {
        return entity.getKyufuRitsu();
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     */
    public void setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     */
    public void setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     */
    public void set適用開始年月(FlexibleYearMonth 適用開始年月) {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYM(適用開始年月);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 適用終了年月を設定します。
     *
     * @param 適用終了年月 適用終了年月
     */
    public void set適用終了年月(FlexibleYearMonth 適用終了年月) {
        requireNonNull(適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月"));
        entity.setTekiyoShuryoYM(適用終了年月);
    }

    /**
     * サービス名称を設定します。
     *
     * @param サービス名称 サービス名称
     */
    public void setサービス名称(RString サービス名称) {
        requireNonNull(サービス名称, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス名称"));
        entity.setServiceMeisho(サービス名称);
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     */
    public void set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTaniSu(単位数);
    }

    /**
     * 限度額対象外フラグを設定します。
     *
     * @param 限度額対象外フラグ 限度額対象外フラグ
     */
    public void set限度額対象外フラグ(RString 限度額対象外フラグ) {
        requireNonNull(限度額対象外フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額対象外フラグ"));
        entity.setGendoGakuTaishogaiFlag(限度額対象外フラグ);
    }

    /**
     * 単位数識別コードを設定します。
     *
     * @param 単位数識別コード 単位数識別コード
     */
    public void set単位数識別コード(RString 単位数識別コード) {
        requireNonNull(単位数識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数識別コード"));
        entity.setTaniSuShikibetsuCode(単位数識別コード);
    }

    /**
     * 外部サービス利用型区分を設定します。
     *
     * @param 外部サービス利用型区分 外部サービス利用型区分
     */
    public void set外部サービス利用型区分(RString 外部サービス利用型区分) {
        requireNonNull(外部サービス利用型区分, UrSystemErrorMessages.値がnull.getReplacedMessage("外部サービス利用型区分"));
        entity.setGaibuServiceRiyogataKubun(外部サービス利用型区分);
    }

    /**
     * 特別地域加算フラグを設定します。
     *
     * @param 特別地域加算フラグ 特別地域加算フラグ
     */
    public void set特別地域加算フラグ(RString 特別地域加算フラグ) {
        requireNonNull(特別地域加算フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("特別地域加算フラグ"));
        entity.setTokubetsuChiikiKasanFlag(特別地域加算フラグ);
    }

    /**
     * 利用者負担定率_定額区分を設定します。
     *
     * @param 利用者負担定率_定額区分 利用者負担定率_定額区分
     */
    public void set利用者負担定率_定額区分(RString 利用者負担定率_定額区分) {
        requireNonNull(利用者負担定率_定額区分, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担定率_定額区分")
        );
        entity.setTeiRitsu_TeiGakuKubun(利用者負担定率_定額区分
        );
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     */
    public void set利用者負担額(Decimal 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutanGaku(利用者負担額);
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     */
    public void set給付率(HokenKyufuRitsu 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuRitsu(給付率);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
