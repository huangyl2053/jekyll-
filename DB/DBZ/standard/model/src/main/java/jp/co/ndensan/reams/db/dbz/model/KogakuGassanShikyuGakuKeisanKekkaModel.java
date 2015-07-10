/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算支給額計算結果のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuGassanShikyuGakuKeisanKekkaModel implements Serializable {

    private DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuGassanShikyuGakuKeisanKekkaModel() {
        entity = new DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity
     */
    public KogakuGassanShikyuGakuKeisanKekkaModel(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityを返します。
     *
     * @return DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity
     */
    public DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity getEntity() {
        return entity;
    }

    /**
     * DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityを設定します。
     *
     * @param entity DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity
     */
    public void setEntity(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 対象年度を返します。
     *
     * @return 対象年度
     */
    public FlexibleYear get対象年度() {
        return entity.getTaishoNendo();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 支給申請書整理番号を返します。
     *
     * @return 支給申請書整理番号
     */
    public RString get支給申請書整理番号() {
        return entity.getShikyuShinseishoSeiriNo();
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
     * 保険制度コードを返します。
     *
     * @return 保険制度コード
     */
    public RString get保険制度コード() {
        return entity.getHokenSeidoCode();
    }

    /**
     * 自己負担額証明書整理番号を返します。
     *
     * @return 自己負担額証明書整理番号
     */
    public RString get自己負担額証明書整理番号() {
        return entity.getJikoFutanSeiriNo();
    }

    /**
     * 対象計算期間開始年月日を返します。
     *
     * @return 対象計算期間開始年月日
     */
    public FlexibleDate get対象計算期間開始年月日() {
        return entity.getTaishoKeisanKaishiYMD();
    }

    /**
     * 対象計算期間終了年月日を返します。
     *
     * @return 対象計算期間終了年月日
     */
    public FlexibleDate get対象計算期間終了年月日() {
        return entity.getTaishoKeisanShuryoYMD();
    }

    /**
     * 世帯負担総額を返します。
     *
     * @return 世帯負担総額
     */
    public Decimal get世帯負担総額() {
        return entity.getSetaiFutanSogaku();
    }

    /**
     * 介護等合算一部負担金等世帯合算額を返します。
     *
     * @return 介護等合算一部負担金等世帯合算額
     */
    public Decimal get介護等合算一部負担金等世帯合算額() {
        return entity.getSetaiGassanGaku();
    }

    /**
     * 70歳以上介護等合算一部負担金等世帯合算額を返します。
     *
     * @return 70歳以上介護等合算一部負担金等世帯合算額
     */
    public Decimal get70歳以上介護等合算一部負担金等世帯合算額() {
        return entity.getOver70_SetaiGassanGaku();
    }

    /**
     * 所得区分を返します。
     *
     * @return 所得区分
     */
    public RString get所得区分() {
        return entity.getShotokuKubun();
    }

    /**
     * 70歳以上の者に係る所得区分を返します。
     *
     * @return 70歳以上の者に係る所得区分
     */
    public RString get70歳以上の者に係る所得区分() {
        return entity.getOver70_ShotokuKubun();
    }

    /**
     * 介護等合算算定基準額を返します。
     *
     * @return 介護等合算算定基準額
     */
    public Decimal get介護等合算算定基準額() {
        return entity.getSanteiKijunGaku();
    }

    /**
     * 70歳以上介護等合算算定基準額を返します。
     *
     * @return 70歳以上介護等合算算定基準額
     */
    public Decimal get70歳以上介護等合算算定基準額() {
        return entity.getOver70_SanteiKijyunGaku();
    }

    /**
     * 世帯支給総額を返します。
     *
     * @return 世帯支給総額
     */
    public Decimal get世帯支給総額() {
        return entity.getSetaiShikyuSogaku();
    }

    /**
     * うち70歳以上分世帯支給総額を返します。
     *
     * @return うち70歳以上分世帯支給総額
     */
    public Decimal getうち70歳以上分世帯支給総額() {
        return entity.getOver70_SetaiShikyuSogaku();
    }

    /**
     * 按分後支給額を返します。
     *
     * @return 按分後支給額
     */
    public Decimal get按分後支給額() {
        return entity.getHonninShikyugaku();
    }

    /**
     * うち70歳以上分按分後支給額を返します。
     *
     * @return うち70歳以上分按分後支給額
     */
    public Decimal getうち70歳以上分按分後支給額() {
        return entity.getOver70_honninShikyugaku();
    }

    /**
     * 介護低所得者Ⅰ再計算実施の有無を返します。
     *
     * @return 介護低所得者Ⅰ再計算実施の有無
     */
    public RString get介護低所得者Ⅰ再計算実施の有無() {
        return entity.getTeiShotoku_1_SaiKeisanUmu();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * 支給額計算結果連絡先郵便番号を返します。
     *
     * @return 支給額計算結果連絡先郵便番号
     */
    public YubinNo get支給額計算結果連絡先郵便番号() {
        return entity.getKekkaRenrakusakiYubinNo();
    }

    /**
     * 支給額計算結果連絡先住所を返します。
     *
     * @return 支給額計算結果連絡先住所
     */
    public RString get支給額計算結果連絡先住所() {
        return entity.getKekkaRenrakusakiJusho();
    }

    /**
     * 支給額計算結果連絡先名称1を返します。
     *
     * @return 支給額計算結果連絡先名称1
     */
    public RString get支給額計算結果連絡先名称1() {
        return entity.getKetteRenrakusakiMeisho1();
    }

    /**
     * 支給額計算結果連絡先名称2を返します。
     *
     * @return 支給額計算結果連絡先名称2
     */
    public RString get支給額計算結果連絡先名称2() {
        return entity.getKekkaRenrakusakiMeisho2();
    }

    /**
     * 通知年月日を返します。
     *
     * @return 通知年月日
     */
    public FlexibleDate get通知年月日() {
        return entity.getTsuchiYMD();
    }

    /**
     * 連絡票発行者名を返します。
     *
     * @return 連絡票発行者名
     */
    public AtenaMeisho get連絡票発行者名() {
        return entity.getRenrakuhyoHakkoshaMei();
    }

    /**
     * 連絡票発行者郵便番号を返します。
     *
     * @return 連絡票発行者郵便番号
     */
    public YubinNo get連絡票発行者郵便番号() {
        return entity.getRenrakuhyoHakkoshaYubinNo();
    }

    /**
     * 連絡票発行者住所を返します。
     *
     * @return 連絡票発行者住所
     */
    public RString get連絡票発行者住所() {
        return entity.getRenrakuhyoHakkoshaJusho();
    }

    /**
     * 問い合わせ先郵便番号を返します。
     *
     * @return 問い合わせ先郵便番号
     */
    public YubinNo get問い合わせ先郵便番号() {
        return entity.getToiawasesakiYobinNo();
    }

    /**
     * 問い合わせ先住所を返します。
     *
     * @return 問い合わせ先住所
     */
    public RString get問い合わせ先住所() {
        return entity.getToiawasesakiJusho();
    }

    /**
     * 問い合わせ先名称1を返します。
     *
     * @return 問い合わせ先名称1
     */
    public RString get問い合わせ先名称1() {
        return entity.getToiawasesakiMeisho1();
    }

    /**
     * 問い合わせ先名称2を返します。
     *
     * @return 問い合わせ先名称2
     */
    public RString get問い合わせ先名称2() {
        return entity.getToiawasesakiMeisho2();
    }

    /**
     * 問い合わせ先電話番号を返します。
     *
     * @return 問い合わせ先電話番号
     */
    public TelNo get問い合わせ先電話番号() {
        return entity.getToiawasesakiTelNo();
    }

    /**
     * 70歳以上負担額合計を返します。
     *
     * @return 70歳以上負担額合計
     */
    public Decimal get70歳以上負担額合計() {
        return entity.getOver70_FutangakuGokei();
    }

    /**
     * 70歳以上支給額合計を返します。
     *
     * @return 70歳以上支給額合計
     */
    public Decimal get70歳以上支給額合計() {
        return entity.getOver70_ShikyugakuGokei();
    }

    /**
     * 70歳未満負担額合計を返します。
     *
     * @return 70歳未満負担額合計
     */
    public Decimal get70歳未満負担額合計() {
        return entity.getUnder70_FutangakuGokei();
    }

    /**
     * 負担額の合計額を返します。
     *
     * @return 負担額の合計額
     */
    public Decimal get負担額の合計額() {
        return entity.getFutangakuGokei();
    }

    /**
     * 70歳未満支給額合計を返します。
     *
     * @return 70歳未満支給額合計
     */
    public Decimal get70歳未満支給額合計() {
        return entity.getUnder70_ShikyugakuGokei();
    }

    /**
     * 支給額合計額を返します。
     *
     * @return 支給額合計額
     */
    public Decimal get支給額合計額() {
        return entity.getShikyugakuGokei();
    }

    /**
     * データ区分を返します。
     *
     * @return データ区分
     */
    public RString getデータ区分() {
        return entity.getDataKubun();
    }

    /**
     * 受取年月を返します。
     *
     * @return 受取年月
     */
    public FlexibleYearMonth get受取年月() {
        return entity.getUketoriYM();
    }

    /**
     * 送付年月を返します。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get送付年月() {
        return entity.getSofuYM();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     */
    public void set対象年度(FlexibleYear 対象年度) {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        entity.setTaishoNendo(対象年度);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     */
    public void set支給申請書整理番号(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
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
     * 保険制度コードを設定します。
     *
     * @param 保険制度コード 保険制度コード
     */
    public void set保険制度コード(RString 保険制度コード) {
        requireNonNull(保険制度コード, UrSystemErrorMessages.値がnull.getReplacedMessage("保険制度コード"));
        entity.setHokenSeidoCode(保険制度コード);
    }

    /**
     * 自己負担額証明書整理番号を設定します。
     *
     * @param 自己負担額証明書整理番号 自己負担額証明書整理番号
     */
    public void set自己負担額証明書整理番号(RString 自己負担額証明書整理番号) {
        requireNonNull(自己負担額証明書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書整理番号"));
        entity.setJikoFutanSeiriNo(自己負担額証明書整理番号);
    }

    /**
     * 対象計算期間開始年月日を設定します。
     *
     * @param 対象計算期間開始年月日 対象計算期間開始年月日
     */
    public void set対象計算期間開始年月日(FlexibleDate 対象計算期間開始年月日) {
        requireNonNull(対象計算期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("対象計算期間開始年月日"));
        entity.setTaishoKeisanKaishiYMD(対象計算期間開始年月日);
    }

    /**
     * 対象計算期間終了年月日を設定します。
     *
     * @param 対象計算期間終了年月日 対象計算期間終了年月日
     */
    public void set対象計算期間終了年月日(FlexibleDate 対象計算期間終了年月日) {
        requireNonNull(対象計算期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("対象計算期間終了年月日"));
        entity.setTaishoKeisanShuryoYMD(対象計算期間終了年月日);
    }

    /**
     * 世帯負担総額を設定します。
     *
     * @param 世帯負担総額 世帯負担総額
     */
    public void set世帯負担総額(Decimal 世帯負担総額) {
        requireNonNull(世帯負担総額, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯負担総額"));
        entity.setSetaiFutanSogaku(世帯負担総額);
    }

    /**
     * 介護等合算一部負担金等世帯合算額を設定します。
     *
     * @param 介護等合算一部負担金等世帯合算額 介護等合算一部負担金等世帯合算額
     */
    public void set介護等合算一部負担金等世帯合算額(Decimal 介護等合算一部負担金等世帯合算額) {
        requireNonNull(介護等合算一部負担金等世帯合算額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護等合算一部負担金等世帯合算額"));
        entity.setSetaiGassanGaku(介護等合算一部負担金等世帯合算額);
    }

    /**
     * 70歳以上介護等合算一部負担金等世帯合算額を設定します。
     *
     * @param _70歳以上介護等合算一部負担金等世帯合算額 70歳以上介護等合算一部負担金等世帯合算額
     */
    public void set70歳以上介護等合算一部負担金等世帯合算額(Decimal _70歳以上介護等合算一部負担金等世帯合算額) {
        requireNonNull(_70歳以上介護等合算一部負担金等世帯合算額, UrSystemErrorMessages.値がnull.
                getReplacedMessage("70歳以上介護等合算一部負担金等世帯合算額"));
        entity.setOver70_SetaiGassanGaku(_70歳以上介護等合算一部負担金等世帯合算額
        );
    }

    /**
     * 所得区分を設定します。
     *
     * @param 所得区分 所得区分
     */
    public void set所得区分(RString 所得区分) {
        requireNonNull(所得区分, UrSystemErrorMessages.値がnull.getReplacedMessage("所得区分"));
        entity.setShotokuKubun(所得区分);
    }

    /**
     * 70歳以上の者に係る所得区分を設定します。
     *
     * @param _70歳以上の者に係る所得区分 70歳以上の者に係る所得区分
     */
    public void set70歳以上の者に係る所得区分(RString _70歳以上の者に係る所得区分) {
        requireNonNull(_70歳以上の者に係る所得区分, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上の者に係る所得区分"));
        entity.setOver70_ShotokuKubun(_70歳以上の者に係る所得区分
        );
    }

    /**
     * 介護等合算算定基準額を設定します。
     *
     * @param 介護等合算算定基準額 介護等合算算定基準額
     */
    public void set介護等合算算定基準額(Decimal 介護等合算算定基準額) {
        requireNonNull(介護等合算算定基準額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護等合算算定基準額"));
        entity.setSanteiKijunGaku(介護等合算算定基準額);
    }

    /**
     * 70歳以上介護等合算算定基準額を設定します。
     *
     * @param _70歳以上介護等合算算定基準額 70歳以上介護等合算算定基準額
     */
    public void set70歳以上介護等合算算定基準額(Decimal _70歳以上介護等合算算定基準額) {
        requireNonNull(_70歳以上介護等合算算定基準額, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上介護等合算算定基準額"));
        entity.setOver70_SanteiKijyunGaku(_70歳以上介護等合算算定基準額
        );
    }

    /**
     * 世帯支給総額を設定します。
     *
     * @param 世帯支給総額 世帯支給総額
     */
    public void set世帯支給総額(Decimal 世帯支給総額) {
        requireNonNull(世帯支給総額, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯支給総額"));
        entity.setSetaiShikyuSogaku(世帯支給総額);
    }

    /**
     * うち70歳以上分世帯支給総額を設定します。
     *
     * @param うち70歳以上分世帯支給総額 うち70歳以上分世帯支給総額
     */
    public void setうち70歳以上分世帯支給総額(Decimal うち70歳以上分世帯支給総額) {
        requireNonNull(うち70歳以上分世帯支給総額, UrSystemErrorMessages.値がnull.getReplacedMessage("うち70歳以上分世帯支給総額"));
        entity.setOver70_SetaiShikyuSogaku(うち70歳以上分世帯支給総額);
    }

    /**
     * 按分後支給額を設定します。
     *
     * @param 按分後支給額 按分後支給額
     */
    public void set按分後支給額(Decimal 按分後支給額) {
        requireNonNull(按分後支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("按分後支給額"));
        entity.setHonninShikyugaku(按分後支給額);
    }

    /**
     * うち70歳以上分按分後支給額を設定します。
     *
     * @param うち70歳以上分按分後支給額 うち70歳以上分按分後支給額
     */
    public void setうち70歳以上分按分後支給額(Decimal うち70歳以上分按分後支給額) {
        requireNonNull(うち70歳以上分按分後支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("うち70歳以上分按分後支給額"));
        entity.setOver70_honninShikyugaku(うち70歳以上分按分後支給額);
    }

    /**
     * 介護低所得者Ⅰ再計算実施の有無を設定します。
     *
     * @param 介護低所得者Ⅰ再計算実施の有無 介護低所得者Ⅰ再計算実施の有無
     */
    public void set介護低所得者Ⅰ再計算実施の有無(RString 介護低所得者Ⅰ再計算実施の有無) {
        requireNonNull(介護低所得者Ⅰ再計算実施の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("介護低所得者Ⅰ再計算実施の有無"));
        entity.setTeiShotoku_1_SaiKeisanUmu(介護低所得者Ⅰ再計算実施の有無);
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     */
    public void set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
    }

    /**
     * 支給額計算結果連絡先郵便番号を設定します。
     *
     * @param 支給額計算結果連絡先郵便番号 支給額計算結果連絡先郵便番号
     */
    public void set支給額計算結果連絡先郵便番号(YubinNo 支給額計算結果連絡先郵便番号) {
        requireNonNull(支給額計算結果連絡先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡先郵便番号"));
        entity.setKekkaRenrakusakiYubinNo(支給額計算結果連絡先郵便番号);
    }

    /**
     * 支給額計算結果連絡先住所を設定します。
     *
     * @param 支給額計算結果連絡先住所 支給額計算結果連絡先住所
     */
    public void set支給額計算結果連絡先住所(RString 支給額計算結果連絡先住所) {
        requireNonNull(支給額計算結果連絡先住所, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡先住所"));
        entity.setKekkaRenrakusakiJusho(支給額計算結果連絡先住所);
    }

    /**
     * 支給額計算結果連絡先名称1を設定します。
     *
     * @param 支給額計算結果連絡先名称1 支給額計算結果連絡先名称1
     */
    public void set支給額計算結果連絡先名称1(RString 支給額計算結果連絡先名称1) {
        requireNonNull(支給額計算結果連絡先名称1, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡先名称1"));
        entity.setKetteRenrakusakiMeisho1(支給額計算結果連絡先名称1);
    }

    /**
     * 支給額計算結果連絡先名称2を設定します。
     *
     * @param 支給額計算結果連絡先名称2 支給額計算結果連絡先名称2
     */
    public void set支給額計算結果連絡先名称2(RString 支給額計算結果連絡先名称2) {
        requireNonNull(支給額計算結果連絡先名称2, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡先名称2"));
        entity.setKekkaRenrakusakiMeisho2(支給額計算結果連絡先名称2);
    }

    /**
     * 通知年月日を設定します。
     *
     * @param 通知年月日 通知年月日
     */
    public void set通知年月日(FlexibleDate 通知年月日) {
        requireNonNull(通知年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("通知年月日"));
        entity.setTsuchiYMD(通知年月日);
    }

    /**
     * 連絡票発行者名を設定します。
     *
     * @param 連絡票発行者名 連絡票発行者名
     */
    public void set連絡票発行者名(AtenaMeisho 連絡票発行者名) {
        requireNonNull(連絡票発行者名, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡票発行者名"));
        entity.setRenrakuhyoHakkoshaMei(連絡票発行者名);
    }

    /**
     * 連絡票発行者郵便番号を設定します。
     *
     * @param 連絡票発行者郵便番号 連絡票発行者郵便番号
     */
    public void set連絡票発行者郵便番号(YubinNo 連絡票発行者郵便番号) {
        requireNonNull(連絡票発行者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡票発行者郵便番号"));
        entity.setRenrakuhyoHakkoshaYubinNo(連絡票発行者郵便番号);
    }

    /**
     * 連絡票発行者住所を設定します。
     *
     * @param 連絡票発行者住所 連絡票発行者住所
     */
    public void set連絡票発行者住所(RString 連絡票発行者住所) {
        requireNonNull(連絡票発行者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("連絡票発行者住所"));
        entity.setRenrakuhyoHakkoshaJusho(連絡票発行者住所);
    }

    /**
     * 問い合わせ先郵便番号を設定します。
     *
     * @param 問い合わせ先郵便番号 問い合わせ先郵便番号
     */
    public void set問い合わせ先郵便番号(YubinNo 問い合わせ先郵便番号) {
        requireNonNull(問い合わせ先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("問い合わせ先郵便番号"));
        entity.setToiawasesakiYobinNo(問い合わせ先郵便番号);
    }

    /**
     * 問い合わせ先住所を設定します。
     *
     * @param 問い合わせ先住所 問い合わせ先住所
     */
    public void set問い合わせ先住所(RString 問い合わせ先住所) {
        requireNonNull(問い合わせ先住所, UrSystemErrorMessages.値がnull.getReplacedMessage("問い合わせ先住所"));
        entity.setToiawasesakiJusho(問い合わせ先住所);
    }

    /**
     * 問い合わせ先名称1を設定します。
     *
     * @param 問い合わせ先名称1 問い合わせ先名称1
     */
    public void set問い合わせ先名称1(RString 問い合わせ先名称1) {
        requireNonNull(問い合わせ先名称1, UrSystemErrorMessages.値がnull.getReplacedMessage("問い合わせ先名称1"));
        entity.setToiawasesakiMeisho1(問い合わせ先名称1);
    }

    /**
     * 問い合わせ先名称2を設定します。
     *
     * @param 問い合わせ先名称2 問い合わせ先名称2
     */
    public void set問い合わせ先名称2(RString 問い合わせ先名称2) {
        requireNonNull(問い合わせ先名称2, UrSystemErrorMessages.値がnull.getReplacedMessage("問い合わせ先名称2"));
        entity.setToiawasesakiMeisho2(問い合わせ先名称2);
    }

    /**
     * 問い合わせ先電話番号を設定します。
     *
     * @param 問い合わせ先電話番号 問い合わせ先電話番号
     */
    public void set問い合わせ先電話番号(TelNo 問い合わせ先電話番号) {
        requireNonNull(問い合わせ先電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("問い合わせ先電話番号"));
        entity.setToiawasesakiTelNo(問い合わせ先電話番号);
    }

    /**
     * 70歳以上負担額合計を設定します。
     *
     * @param _70歳以上負担額合計 70歳以上負担額合計
     */
    public void set70歳以上負担額合計(Decimal _70歳以上負担額合計) {
        requireNonNull(_70歳以上負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上負担額合計"));
        entity.setOver70_FutangakuGokei(_70歳以上負担額合計);
    }

    /**
     * 70歳以上支給額合計を設定します。
     *
     * @param _70歳以上支給額合計 70歳以上支給額合計
     */
    public void set70歳以上支給額合計(Decimal _70歳以上支給額合計) {
        requireNonNull(_70歳以上支給額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳以上支給額合計"));
        entity.setOver70_ShikyugakuGokei(_70歳以上支給額合計);
    }

    /**
     * 70歳未満負担額合計を設定します。
     *
     * @param _70歳未満負担額合計 70歳未満負担額合計
     */
    public void set70歳未満負担額合計(Decimal _70歳未満負担額合計) {
        requireNonNull(_70歳未満負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳未満負担額合計"));
        entity.setUnder70_FutangakuGokei(_70歳未満負担額合計);
    }

    /**
     * 負担額の合計額を設定します。
     *
     * @param 負担額の合計額 負担額の合計額
     */
    public void set負担額の合計額(Decimal 負担額の合計額) {
        requireNonNull(負担額の合計額, UrSystemErrorMessages.値がnull.getReplacedMessage("負担額の合計額"));
        entity.setFutangakuGokei(負担額の合計額);
    }

    /**
     * 70歳未満支給額合計を設定します。
     *
     * @param _70歳未満支給額合計 70歳未満支給額合計
     */
    public void set70歳未満支給額合計(Decimal _70歳未満支給額合計) {
        requireNonNull(_70歳未満支給額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("70歳未満支給額合計"));
        entity.setUnder70_ShikyugakuGokei(_70歳未満支給額合計);
    }

    /**
     * 支給額合計額を設定します。
     *
     * @param 支給額合計額 支給額合計額
     */
    public void set支給額合計額(Decimal 支給額合計額) {
        requireNonNull(支給額合計額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額合計額"));
        entity.setShikyugakuGokei(支給額合計額);
    }

    /**
     * データ区分を設定します。
     *
     * @param データ区分 データ区分
     */
    public void setデータ区分(RString データ区分) {
        requireNonNull(データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));
        entity.setDataKubun(データ区分);
    }

    /**
     * 受取年月を設定します。
     *
     * @param 受取年月 受取年月
     */
    public void set受取年月(FlexibleYearMonth 受取年月) {
        requireNonNull(受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("受取年月"));
        entity.setUketoriYM(受取年月);
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     */
    public void set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
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
