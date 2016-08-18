/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link JigyoKogakuGassanShikyuGakuKeisanKekka}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-012 chenyadong
 */
public class JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder {

    private final DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity entity;
    private final JigyoKogakuKekkaIdentifier id;

    /**
     * {@link DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity}より{@link JigyoKogakuGassanShikyuGakuKeisanKekka}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity}
     * @param id {@link JigyoKogakuKekkaIdentifier}
     *
     */
    JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder(
            DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity entity,
            JigyoKogakuKekkaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set対象年度(FlexibleYear 対象年度) {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        entity.setTaishoNendo(対象年度);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set支給申請書整理番号(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 保険制度コードを設定します。
     *
     * @param 保険制度コード 保険制度コード
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set保険制度コード(RString 保険制度コード) {
        requireNonNull(保険制度コード, UrSystemErrorMessages.値がnull.getReplacedMessage("保険制度コード"));
        entity.setHokenSeidoCode(保険制度コード);
        return this;
    }

    /**
     * 自己負担額証明書整理番号を設定します。
     *
     * @param 自己負担額証明書整理番号 自己負担額証明書整理番号
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set自己負担額証明書整理番号(RString 自己負担額証明書整理番号) {
        requireNonNull(自己負担額証明書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書整理番号"));
        entity.setJikoFutanSeiriNo(自己負担額証明書整理番号);
        return this;
    }

    /**
     * 対象計算期間開始年月日を設定します。
     *
     * @param 対象計算期間開始年月日 対象計算期間開始年月日
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set対象計算期間開始年月日(FlexibleDate 対象計算期間開始年月日) {
        requireNonNull(対象計算期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("対象計算期間開始年月日"));
        entity.setTaishoKeisanKaishiYMD(対象計算期間開始年月日);
        return this;
    }

    /**
     * 対象計算期間終了年月日を設定します。
     *
     * @param 対象計算期間終了年月日 対象計算期間終了年月日
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set対象計算期間終了年月日(FlexibleDate 対象計算期間終了年月日) {
        requireNonNull(対象計算期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("対象計算期間終了年月日"));
        entity.setTaishoKeisanShuryoYMD(対象計算期間終了年月日);
        return this;
    }

    /**
     * 世帯負担総額を設定します。
     *
     * @param 世帯負担総額 世帯負担総額
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set世帯負担総額(Decimal 世帯負担総額) {
        requireNonNull(世帯負担総額, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯負担総額"));
        entity.setSetaiFutanSogaku(世帯負担総額);
        return this;
    }

    /**
     * 介護等合算一部負担金等世帯合算額を設定します。
     *
     * @param 介護等合算一部負担金等世帯合算額 介護等合算一部負担金等世帯合算額
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set介護等合算一部負担金等世帯合算額(Decimal 介護等合算一部負担金等世帯合算額) {
        requireNonNull(介護等合算一部負担金等世帯合算額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護等合算一部負担金等世帯合算額"));
        entity.setSetaiGassanGaku(介護等合算一部負担金等世帯合算額);
        return this;
    }

    /**
     * 70歳以上介護等合算一部負担金等世帯合算額を設定します。
     *
     * @param 介護等合算一部負担金等世帯合算額_70歳以上 70歳以上介護等合算一部負担金等世帯合算額
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set70歳以上介護等合算一部負担金等世帯合算額(Decimal 介護等合算一部負担金等世帯合算額_70歳以上) {
        requireNonNull(介護等合算一部負担金等世帯合算額_70歳以上, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上介護等合算一部負担金等世帯合算額"));
        entity.setOver70_SetaiGassanGaku(介護等合算一部負担金等世帯合算額_70歳以上);
        return this;
    }

    /**
     * 所得区分を設定します。
     *
     * @param 所得区分 所得区分
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set所得区分(RString 所得区分) {
        requireNonNull(所得区分, UrSystemErrorMessages.値がnull.getReplacedMessage("所得区分"));
        entity.setShotokuKubun(所得区分);
        return this;
    }

    /**
     * 70歳以上の者に係る所得区分を設定します。
     *
     * @param 所得区分_70歳以上の者に係る 70歳以上の者に係る所得区分
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set70歳以上の者に係る所得区分(RString 所得区分_70歳以上の者に係る) {
        requireNonNull(所得区分_70歳以上の者に係る, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上の者に係る所得区分"));
        entity.setOver70_ShotokuKubun(所得区分_70歳以上の者に係る);
        return this;
    }

    /**
     * 介護等合算算定基準額を設定します。
     *
     * @param 介護等合算算定基準額 介護等合算算定基準額
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set介護等合算算定基準額(Decimal 介護等合算算定基準額) {
        requireNonNull(介護等合算算定基準額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護等合算算定基準額"));
        entity.setSanteiKijunGaku(介護等合算算定基準額);
        return this;
    }

    /**
     * 70歳以上介護等合算算定基準額を設定します。
     *
     * @param 介護等合算算定基準額_70歳以上 70歳以上介護等合算算定基準額
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set70歳以上介護等合算算定基準額(Decimal 介護等合算算定基準額_70歳以上) {
        requireNonNull(介護等合算算定基準額_70歳以上, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上介護等合算算定基準額"));
        entity.setOver70_SanteiKijyunGaku(介護等合算算定基準額_70歳以上);
        return this;
    }

    /**
     * 世帯支給総額を設定します。
     *
     * @param 世帯支給総額 世帯支給総額
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set世帯支給総額(Decimal 世帯支給総額) {
        requireNonNull(世帯支給総額, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯支給総額"));
        entity.setSetaiShikyuSogaku(世帯支給総額);
        return this;
    }

    /**
     * うち70歳以上分世帯支給総額を設定します。
     *
     * @param うち70歳以上分世帯支給総額 うち70歳以上分世帯支給総額
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder setうち70歳以上分世帯支給総額(Decimal うち70歳以上分世帯支給総額) {
        requireNonNull(うち70歳以上分世帯支給総額, UrSystemErrorMessages.値がnull.getReplacedMessage("うち70歳以上分世帯支給総額"));
        entity.setOver70_SetaiShikyuSogaku(うち70歳以上分世帯支給総額);
        return this;
    }

    /**
     * 按分後支給額を設定します。
     *
     * @param 按分後支給額 按分後支給額
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set按分後支給額(Decimal 按分後支給額) {
        requireNonNull(按分後支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("按分後支給額"));
        entity.setHonninShikyugaku(按分後支給額);
        return this;
    }

    /**
     * うち70歳以上分按分後支給額を設定します。
     *
     * @param うち70歳以上分按分後支給額 うち70歳以上分按分後支給額
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder setうち70歳以上分按分後支給額(Decimal うち70歳以上分按分後支給額) {
        requireNonNull(うち70歳以上分按分後支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("うち70歳以上分按分後支給額"));
        entity.setOver70_honninShikyugaku(うち70歳以上分按分後支給額);
        return this;
    }

    /**
     * 介護低所得者Ⅰ再計算実施の有無を設定します。
     *
     * @param 介護低所得者Ⅰ再計算実施の有無 介護低所得者Ⅰ再計算実施の有無
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set介護低所得者Ⅰ再計算実施の有無(RString 介護低所得者Ⅰ再計算実施の有無) {
        requireNonNull(介護低所得者Ⅰ再計算実施の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("介護低所得者Ⅰ再計算実施の有無"));
        entity.setTeiShotoku_1_SaiKeisanUmu(介護低所得者Ⅰ再計算実施の有無);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
        return this;
    }

    /**
     * 支給額計算結果連絡先郵便番号を設定します。
     *
     * @param 支給額計算結果連絡先郵便番号 支給額計算結果連絡先郵便番号
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set支給額計算結果連絡先郵便番号(YubinNo 支給額計算結果連絡先郵便番号) {
        requireNonNull(支給額計算結果連絡先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡先郵便番号"));
        entity.setKekkaRenrakusakiYubinNo(支給額計算結果連絡先郵便番号);
        return this;
    }

    /**
     * 支給額計算結果連絡先住所を設定します。
     *
     * @param 支給額計算結果連絡先住所 支給額計算結果連絡先住所
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set支給額計算結果連絡先住所(RString 支給額計算結果連絡先住所) {
        requireNonNull(支給額計算結果連絡先住所, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡先住所"));
        entity.setKekkaRenrakusakiJusho(支給額計算結果連絡先住所);
        return this;
    }

    /**
     * 支給額計算結果連絡先名称1を設定します。
     *
     * @param 支給額計算結果連絡先名称1 支給額計算結果連絡先名称1
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set支給額計算結果連絡先名称1(RString 支給額計算結果連絡先名称1) {
        requireNonNull(支給額計算結果連絡先名称1, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡先名称1"));
        entity.setKetteRenrakusakiMeisho1(支給額計算結果連絡先名称1);
        return this;
    }

    /**
     * 支給額計算結果連絡先名称2を設定します。
     *
     * @param 支給額計算結果連絡先名称2 支給額計算結果連絡先名称2
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set支給額計算結果連絡先名称2(RString 支給額計算結果連絡先名称2) {
        requireNonNull(支給額計算結果連絡先名称2, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡先名称2"));
        entity.setKekkaRenrakusakiMeisho2(支給額計算結果連絡先名称2);
        return this;
    }

    /**
     * 通知年月日を設定します。
     *
     * @param 通知年月日 通知年月日
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set通知年月日(FlexibleDate 通知年月日) {
        requireNonNull(通知年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("通知年月日"));
        entity.setTsuchiYMD(通知年月日);
        return this;
    }

    /**
     * 連絡票発行者名を設定します。
     *
     * @param 連絡票発行者名 連絡票発行者名
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set連絡票発行者名(AtenaMeisho 連絡票発行者名) {
        requireNonNull(連絡票発行者名, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡票発行者名"));
        entity.setRenrakuhyoHakkoshaMei(連絡票発行者名);
        return this;
    }

    /**
     * 連絡票発行者郵便番号を設定します。
     *
     * @param 連絡票発行者郵便番号 連絡票発行者郵便番号
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set連絡票発行者郵便番号(YubinNo 連絡票発行者郵便番号) {
        requireNonNull(連絡票発行者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡票発行者郵便番号"));
        entity.setRenrakuhyoHakkoshaYubinNo(連絡票発行者郵便番号);
        return this;
    }

    /**
     * 連絡票発行者住所を設定します。
     *
     * @param 連絡票発行者住所 連絡票発行者住所
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set連絡票発行者住所(RString 連絡票発行者住所) {
        requireNonNull(連絡票発行者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡票発行者住所"));
        entity.setRenrakuhyoHakkoshaJusho(連絡票発行者住所);
        return this;
    }

    /**
     * 問い合わせ先郵便番号を設定します。
     *
     * @param 問い合わせ先郵便番号 問い合わせ先郵便番号
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set問い合わせ先郵便番号(YubinNo 問い合わせ先郵便番号) {
        requireNonNull(問い合わせ先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("問い合わせ先郵便番号"));
        entity.setToiawasesakiYobinNo(問い合わせ先郵便番号);
        return this;
    }

    /**
     * 問い合わせ先住所を設定します。
     *
     * @param 問い合わせ先住所 問い合わせ先住所
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set問い合わせ先住所(RString 問い合わせ先住所) {
        requireNonNull(問い合わせ先住所, UrSystemErrorMessages.値がnull.getReplacedMessage("問い合わせ先住所"));
        entity.setToiawasesakiJusho(問い合わせ先住所);
        return this;
    }

    /**
     * 問い合わせ先名称1を設定します。
     *
     * @param 問い合わせ先名称1 問い合わせ先名称1
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set問い合わせ先名称1(RString 問い合わせ先名称1) {
        requireNonNull(問い合わせ先名称1, UrSystemErrorMessages.値がnull.getReplacedMessage("問い合わせ先名称1"));
        entity.setToiawasesakiMeisho1(問い合わせ先名称1);
        return this;
    }

    /**
     * 問い合わせ先名称2を設定します。
     *
     * @param 問い合わせ先名称2 問い合わせ先名称2
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set問い合わせ先名称2(RString 問い合わせ先名称2) {
        requireNonNull(問い合わせ先名称2, UrSystemErrorMessages.値がnull.getReplacedMessage("問い合わせ先名称2"));
        entity.setToiawasesakiMeisho2(問い合わせ先名称2);
        return this;
    }

    /**
     * 問い合わせ先電話番号を設定します。
     *
     * @param 問い合わせ先電話番号 問い合わせ先電話番号
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set問い合わせ先電話番号(TelNo 問い合わせ先電話番号) {
        requireNonNull(問い合わせ先電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("問い合わせ先電話番号"));
        entity.setToiawasesakiTelNo(問い合わせ先電話番号);
        return this;
    }

    /**
     * 70歳以上負担額合計を設定します。
     *
     * @param 負担額合計_70歳以上 70歳以上負担額合計
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set70歳以上負担額合計(Decimal 負担額合計_70歳以上) {
        requireNonNull(負担額合計_70歳以上, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上負担額合計"));
        entity.setOver70_FutangakuGokei(負担額合計_70歳以上);
        return this;
    }

    /**
     * 70歳以上支給額合計を設定します。
     *
     * @param 支給額合計_70歳以上 70歳以上支給額合計
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set70歳以上支給額合計(Decimal 支給額合計_70歳以上) {
        requireNonNull(支給額合計_70歳以上, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上支給額合計"));
        entity.setOver70_ShikyugakuGokei(支給額合計_70歳以上);
        return this;
    }

    /**
     * 70歳未満負担額合計を設定します。
     *
     * @param 負担額合計_70歳未満 70歳未満負担額合計
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set70歳未満負担額合計(Decimal 負担額合計_70歳未満) {
        requireNonNull(負担額合計_70歳未満, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳未満負担額合計"));
        entity.setUnder70_FutangakuGokei(負担額合計_70歳未満);
        return this;
    }

    /**
     * 負担額の合計額を設定します。
     *
     * @param 負担額の合計額 負担額の合計額
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set負担額の合計額(Decimal 負担額の合計額) {
        requireNonNull(負担額の合計額, UrSystemErrorMessages.値がnull.getReplacedMessage("負担額の合計額"));
        entity.setFutangakuGokei(負担額の合計額);
        return this;
    }

    /**
     * 70歳未満支給額合計を設定します。
     *
     * @param 支給額合計_70歳未満 70歳未満支給額合計
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set70歳未満支給額合計(Decimal 支給額合計_70歳未満) {
        requireNonNull(支給額合計_70歳未満, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳未満支給額合計"));
        entity.setUnder70_ShikyugakuGokei(支給額合計_70歳未満);
        return this;
    }

    /**
     * 支給額合計額を設定します。
     *
     * @param 支給額合計額 支給額合計額
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set支給額合計額(Decimal 支給額合計額) {
        requireNonNull(支給額合計額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額合計額"));
        entity.setShikyugakuGokei(支給額合計額);
        return this;
    }

    /**
     * データ区分を設定します。
     *
     * @param データ区分 データ区分
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder setデータ区分(RString データ区分) {
        requireNonNull(データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));
        entity.setDataKubun(データ区分);
        return this;
    }

    /**
     * 受取年月を設定します。
     *
     * @param 受取年月 受取年月
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set受取年月(FlexibleYearMonth 受取年月) {
        requireNonNull(受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("受取年月"));
        entity.setUketoriYM(受取年月);
        return this;
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
        return this;
    }

    /**
     * 再送フラグを設定します。
     *
     * @param 再送フラグ 再送フラグ
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set再送フラグ(RString 再送フラグ) {
        requireNonNull(再送フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("再送フラグ"));
        entity.setSaisoFG(再送フラグ);
        return this;
    }

    /**
     * 支給額計算結果連絡票作成年月日を設定します。
     *
     * @param 支給額計算結果連絡票作成年月日 支給額計算結果連絡票作成年月日
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder}
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaBuilder set支給額計算結果連絡票作成年月日(FlexibleDate 支給額計算結果連絡票作成年月日) {
        requireNonNull(支給額計算結果連絡票作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡票作成年月日"));
        entity.setSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD(支給額計算結果連絡票作成年月日);
        return this;
    }

    /**
     * {@link JigyoKogakuGassanShikyuGakuKeisanKekka}のインスタンスを生成します。
     *
     * @return {@link JigyoKogakuGassanShikyuGakuKeisanKekka}のインスタンス
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekka build() {
        return new JigyoKogakuGassanShikyuGakuKeisanKekka(entity, id);
    }
}
