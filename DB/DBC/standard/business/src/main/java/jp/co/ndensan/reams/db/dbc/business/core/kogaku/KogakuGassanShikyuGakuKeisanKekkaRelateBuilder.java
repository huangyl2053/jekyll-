/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogaku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuGakuKeisanKekkaIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyugakuKeisanKekkaMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
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
 * {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-2030-030 huzongcheng
 */
public class KogakuGassanShikyuGakuKeisanKekkaRelateBuilder {

    private final DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity;
    private final KogakuGassanShikyuGakuKeisanKekkaIdentifier id;
    private final Models<KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier, KogakuGassanShikyugakuKeisanKekkaMeisai> 高額合算支給額計算結果明細;

    /**
     * {@link DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity}より{@link KogakuGassanShikyuGakuKeisanKekkaRelate}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity}
     * @param id {@link KogakuGassanShikyuGakuKeisanKekkaIdentifier}
     *
     */
    KogakuGassanShikyuGakuKeisanKekkaRelateBuilder(
            DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity,
            KogakuGassanShikyuGakuKeisanKekkaIdentifier id,
            Models<KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier, KogakuGassanShikyugakuKeisanKekkaMeisai> 高額合算支給額計算結果明細
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.高額合算支給額計算結果明細 = 高額合算支給額計算結果明細;

    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set対象年度(FlexibleYear 対象年度) {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        entity.setTaishoNendo(対象年度);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set支給申請書整理番号(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 保険制度コードを設定します。
     *
     * @param 保険制度コード 保険制度コード
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set保険制度コード(RString 保険制度コード) {
        entity.setHokenSeidoCode(保険制度コード);
        return this;
    }

    /**
     * 自己負担額証明書整理番号を設定します。
     *
     * @param 自己負担額証明書整理番号 自己負担額証明書整理番号
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set自己負担額証明書整理番号(RString 自己負担額証明書整理番号) {
        entity.setJikoFutanSeiriNo(自己負担額証明書整理番号);
        return this;
    }

    /**
     * 対象計算期間開始年月日を設定します。
     *
     * @param 対象計算期間開始年月日 対象計算期間開始年月日
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set対象計算期間開始年月日(FlexibleDate 対象計算期間開始年月日) {
        entity.setTaishoKeisanKaishiYMD(対象計算期間開始年月日);
        return this;
    }

    /**
     * 対象計算期間終了年月日を設定します。
     *
     * @param 対象計算期間終了年月日 対象計算期間終了年月日
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set対象計算期間終了年月日(FlexibleDate 対象計算期間終了年月日) {
        entity.setTaishoKeisanShuryoYMD(対象計算期間終了年月日);
        return this;
    }

    /**
     * 世帯負担総額を設定します。
     *
     * @param 世帯負担総額 世帯負担総額
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set世帯負担総額(Decimal 世帯負担総額) {
        entity.setSetaiFutanSogaku(世帯負担総額);
        return this;
    }

    /**
     * 介護等合算一部負担金等世帯合算額を設定します。
     *
     * @param 介護等合算一部負担金等世帯合算額 介護等合算一部負担金等世帯合算額
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set介護等合算一部負担金等世帯合算額(Decimal 介護等合算一部負担金等世帯合算額) {
        entity.setSetaiGassanGaku(介護等合算一部負担金等世帯合算額);
        return this;
    }

    /**
     * 70歳以上介護等合算一部負担金等世帯合算額を設定します。
     *
     * @param 介護等合算一部負担金等世帯合算額_70歳以上 70歳以上介護等合算一部負担金等世帯合算額
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set70歳以上介護等合算一部負担金等世帯合算額(Decimal 介護等合算一部負担金等世帯合算額_70歳以上) {
        requireNonNull(介護等合算一部負担金等世帯合算額_70歳以上, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上介護等合算一部負担金等世帯合算額"));
        entity.setOver70_SetaiGassanGaku(介護等合算一部負担金等世帯合算額_70歳以上);
        return this;
    }

    /**
     * 所得区分を設定します。
     *
     * @param 所得区分 所得区分
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set所得区分(RString 所得区分) {
        entity.setShotokuKubun(所得区分);
        return this;
    }

    /**
     * 70歳以上の者に係る所得区分を設定します。
     *
     * @param 所得区分_70歳以上の者に係る 70歳以上の者に係る所得区分
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set70歳以上の者に係る所得区分(RString 所得区分_70歳以上の者に係る) {
        entity.setOver70_ShotokuKubun(所得区分_70歳以上の者に係る);
        return this;
    }

    /**
     * 介護等合算算定基準額を設定します。
     *
     * @param 介護等合算算定基準額 介護等合算算定基準額
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set介護等合算算定基準額(Decimal 介護等合算算定基準額) {
        entity.setSanteiKijunGaku(介護等合算算定基準額);
        return this;
    }

    /**
     * 70歳以上介護等合算算定基準額を設定します。
     *
     * @param 介護等合算算定基準額_70歳以上 70歳以上介護等合算算定基準額
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set70歳以上介護等合算算定基準額(Decimal 介護等合算算定基準額_70歳以上) {
        entity.setOver70_SanteiKijyunGaku(介護等合算算定基準額_70歳以上);
        return this;
    }

    /**
     * 世帯支給総額を設定します。
     *
     * @param 世帯支給総額 世帯支給総額
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set世帯支給総額(Decimal 世帯支給総額) {
        entity.setSetaiShikyuSogaku(世帯支給総額);
        return this;
    }

    /**
     * うち70歳以上分世帯支給総額を設定します。
     *
     * @param うち70歳以上分世帯支給総額 うち70歳以上分世帯支給総額
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder setうち70歳以上分世帯支給総額(Decimal うち70歳以上分世帯支給総額) {
        entity.setOver70_SetaiShikyuSogaku(うち70歳以上分世帯支給総額);
        return this;
    }

    /**
     * 按分後支給額を設定します。
     *
     * @param 按分後支給額 按分後支給額
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set按分後支給額(Decimal 按分後支給額) {
        entity.setHonninShikyugaku(按分後支給額);
        return this;
    }

    /**
     * うち70歳以上分按分後支給額を設定します。
     *
     * @param うち70歳以上分按分後支給額 うち70歳以上分按分後支給額
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder setうち70歳以上分按分後支給額(Decimal うち70歳以上分按分後支給額) {
        entity.setOver70_honninShikyugaku(うち70歳以上分按分後支給額);
        return this;
    }

    /**
     * 介護低所得者Ⅰ再計算実施の有無を設定します。
     *
     * @param 介護低所得者Ⅰ再計算実施の有無 介護低所得者Ⅰ再計算実施の有無
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set介護低所得者Ⅰ再計算実施の有無(RString 介護低所得者Ⅰ再計算実施の有無) {
        entity.setTeiShotoku_1_SaiKeisanUmu(介護低所得者Ⅰ再計算実施の有無);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set備考(RString 備考) {
        entity.setBiko(備考);
        return this;
    }

    /**
     * 支給額計算結果連絡先郵便番号を設定します。
     *
     * @param 支給額計算結果連絡先郵便番号 支給額計算結果連絡先郵便番号
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set支給額計算結果連絡先郵便番号(YubinNo 支給額計算結果連絡先郵便番号) {
        entity.setKekkaRenrakusakiYubinNo(支給額計算結果連絡先郵便番号);
        return this;
    }

    /**
     * 支給額計算結果連絡先住所を設定します。
     *
     * @param 支給額計算結果連絡先住所 支給額計算結果連絡先住所
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set支給額計算結果連絡先住所(RString 支給額計算結果連絡先住所) {
        entity.setKekkaRenrakusakiJusho(支給額計算結果連絡先住所);
        return this;
    }

    /**
     * 支給額計算結果連絡先名称1を設定します。
     *
     * @param 支給額計算結果連絡先名称1 支給額計算結果連絡先名称1
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set支給額計算結果連絡先名称1(RString 支給額計算結果連絡先名称1) {
        entity.setKetteRenrakusakiMeisho1(支給額計算結果連絡先名称1);
        return this;
    }

    /**
     * 支給額計算結果連絡先名称2を設定します。
     *
     * @param 支給額計算結果連絡先名称2 支給額計算結果連絡先名称2
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set支給額計算結果連絡先名称2(RString 支給額計算結果連絡先名称2) {
        entity.setKekkaRenrakusakiMeisho2(支給額計算結果連絡先名称2);
        return this;
    }

    /**
     * 通知年月日を設定します。
     *
     * @param 通知年月日 通知年月日
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set通知年月日(FlexibleDate 通知年月日) {
        entity.setTsuchiYMD(通知年月日);
        return this;
    }

    /**
     * 連絡票発行者名を設定します。
     *
     * @param 連絡票発行者名 連絡票発行者名
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set連絡票発行者名(AtenaMeisho 連絡票発行者名) {
        entity.setRenrakuhyoHakkoshaMei(連絡票発行者名);
        return this;
    }

    /**
     * 連絡票発行者郵便番号を設定します。
     *
     * @param 連絡票発行者郵便番号 連絡票発行者郵便番号
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set連絡票発行者郵便番号(YubinNo 連絡票発行者郵便番号) {
        entity.setRenrakuhyoHakkoshaYubinNo(連絡票発行者郵便番号);
        return this;
    }

    /**
     * 連絡票発行者住所を設定します。
     *
     * @param 連絡票発行者住所 連絡票発行者住所
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set連絡票発行者住所(RString 連絡票発行者住所) {
        entity.setRenrakuhyoHakkoshaJusho(連絡票発行者住所);
        return this;
    }

    /**
     * 問い合わせ先郵便番号を設定します。
     *
     * @param 問い合わせ先郵便番号 問い合わせ先郵便番号
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set問い合わせ先郵便番号(YubinNo 問い合わせ先郵便番号) {
        entity.setToiawasesakiYobinNo(問い合わせ先郵便番号);
        return this;
    }

    /**
     * 問い合わせ先住所を設定します。
     *
     * @param 問い合わせ先住所 問い合わせ先住所
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set問い合わせ先住所(RString 問い合わせ先住所) {
        entity.setToiawasesakiJusho(問い合わせ先住所);
        return this;
    }

    /**
     * 問い合わせ先名称1を設定します。
     *
     * @param 問い合わせ先名称1 問い合わせ先名称1
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set問い合わせ先名称1(RString 問い合わせ先名称1) {
        entity.setToiawasesakiMeisho1(問い合わせ先名称1);
        return this;
    }

    /**
     * 問い合わせ先名称2を設定します。
     *
     * @param 問い合わせ先名称2 問い合わせ先名称2
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set問い合わせ先名称2(RString 問い合わせ先名称2) {
        entity.setToiawasesakiMeisho2(問い合わせ先名称2);
        return this;
    }

    /**
     * 問い合わせ先電話番号を設定します。
     *
     * @param 問い合わせ先電話番号 問い合わせ先電話番号
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set問い合わせ先電話番号(TelNo 問い合わせ先電話番号) {
        entity.setToiawasesakiTelNo(問い合わせ先電話番号);
        return this;
    }

    /**
     * 70歳以上負担額合計を設定します。
     *
     * @param 負担額合計_70歳以上 70歳以上負担額合計
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set70歳以上負担額合計(Decimal 負担額合計_70歳以上) {
        entity.setOver70_FutangakuGokei(負担額合計_70歳以上);
        return this;
    }

    /**
     * 70歳以上支給額合計を設定します。
     *
     * @param 支給額合計_70歳以上 70歳以上支給額合計
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set70歳以上支給額合計(Decimal 支給額合計_70歳以上) {
        entity.setOver70_ShikyugakuGokei(支給額合計_70歳以上);
        return this;
    }

    /**
     * 70歳未満負担額合計を設定します。
     *
     * @param 負担額合計_70歳未満 70歳未満負担額合計
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set70歳未満負担額合計(Decimal 負担額合計_70歳未満) {
        entity.setUnder70_FutangakuGokei(負担額合計_70歳未満);
        return this;
    }

    /**
     * 負担額の合計額を設定します。
     *
     * @param 負担額の合計額 負担額の合計額
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set負担額の合計額(Decimal 負担額の合計額) {
        entity.setFutangakuGokei(負担額の合計額);
        return this;
    }

    /**
     * 70歳未満支給額合計を設定します。
     *
     * @param 支給額合計_70歳未満 70歳未満支給額合計
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set70歳未満支給額合計(Decimal 支給額合計_70歳未満) {
        entity.setUnder70_ShikyugakuGokei(支給額合計_70歳未満);
        return this;
    }

    /**
     * 支給額合計額を設定します。
     *
     * @param 支給額合計額 支給額合計額
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set支給額合計額(Decimal 支給額合計額) {
        entity.setShikyugakuGokei(支給額合計額);
        return this;
    }

    /**
     * データ区分を設定します。
     *
     * @param データ区分 データ区分
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder setデータ区分(RString データ区分) {
        entity.setDataKubun(データ区分);
        return this;
    }

    /**
     * 受取年月を設定します。
     *
     * @param 受取年月 受取年月
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set受取年月(FlexibleYearMonth 受取年月) {
        entity.setUketoriYM(受取年月);
        return this;
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set送付年月(FlexibleYearMonth 送付年月) {
        entity.setSofuYM(送付年月);
        return this;
    }

    /**
     * 再送フラグを設定します。
     *
     * @param 再送フラグ 再送フラグ
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set再送フラグ(RString 再送フラグ) {
        entity.setSaisoFG(再送フラグ);
        return this;
    }

    /**
     * 支給額計算結果連絡票作成年月日を設定します。
     *
     * @param 支給額計算結果連絡票作成年月日 支給額計算結果連絡票作成年月日
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelateBuilder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set送付年月(FlexibleDate 支給額計算結果連絡票作成年月日) {
        entity.setSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD(支給額計算結果連絡票作成年月日);
        return this;
    }

    /**
     * 高額合算支給額計算結果明細を追加します。
     *
     * @param 高額合算支給額計算結果明細 {@link KogakuGassanShikyugakuKeisanKekkaMeisai}
     * @return {@link Builder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder set高額合算支給額計算結果明細(KogakuGassanShikyugakuKeisanKekkaMeisai 高額合算支給額計算結果明細) {
        if (hasSameIdentifier(高額合算支給額計算結果明細.identifier())) {
            this.高額合算支給額計算結果明細.add(高額合算支給額計算結果明細);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 高額合算支給額計算結果明細を削除します。
     *
     * @param 高額合算支給額計算結果明細 {@link KogakuGassanShikyugakuKeisanKekkaMeisai}
     * @return {@link Builder}
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateBuilder delete高額合算支給額計算結果明細(KogakuGassanShikyugakuKeisanKekkaMeisai 高額合算支給額計算結果明細) {
        if (hasSameIdentifier(高額合算支給額計算結果明細.identifier())) {
            this.高額合算支給額計算結果明細.deleteOrRemove(高額合算支給額計算結果明細.identifier());
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(KogakuGassanShikyugakuKeisanKekkaMeisaiIdentifier 高額合算支給額計算結果明細識別子) {
        return id.get被保険者番号().equals(高額合算支給額計算結果明細識別子.get被保険者番号())
                && id.get対象年度().equals(高額合算支給額計算結果明細識別子.get対象年度())
                && id.get支給申請書整理番号().equals(高額合算支給額計算結果明細識別子.get支給申請書整理番号())
                && id.get証記載保険者番号().equals(高額合算支給額計算結果明細識別子.get証記載保険者番号())
                && id.get履歴番号() == 高額合算支給額計算結果明細識別子.get履歴番号().intValue();
    }

    /**
     * {@link FutanWariaiSokujiKouseiResult}のインスタンスを生成します。
     *
     * @return {@link KogakuGassanShikyuGakuKeisanKekkaRelate}のインスタンス
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelate build() {
        return new KogakuGassanShikyuGakuKeisanKekkaRelate(entity, id, 高額合算支給額計算結果明細);
    }
}
