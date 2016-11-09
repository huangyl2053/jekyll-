/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link JigyoKogakuGassanJikoFutanGakuShomeisho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-4820-010 sunhaidi
 */
public class JigyoKogakuGassanJikoFutanGakuShomeishoBuilder {

    private final DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity entity;
    private final JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier id;

    /**
     * {@link DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity}より{@link JigyoKogakuGassanJikoFutanGakuShomeisho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity}
     * @param id {@link JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier}
     *
     */
    JigyoKogakuGassanJikoFutanGakuShomeishoBuilder(
            DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity entity,
            JigyoKogakuGassanJikoFutanGakuShomeishoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 自己負担額証明書整理番号を設定します。
     *
     * @param 自己負担額証明書整理番号 自己負担額証明書整理番号
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set自己負担額証明書整理番号(RString 自己負担額証明書整理番号) {
        requireNonNull(自己負担額証明書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書整理番号"));
        entity.setJikoFutanSeiriNo(自己負担額証明書整理番号);
        return this;
    }

    /**
     * 転入前保険者名を設定します。
     *
     * @param 転入前保険者名 転入前保険者名
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set転入前保険者名(RString 転入前保険者名) {
        requireNonNull(転入前保険者名, UrSystemErrorMessages.値がnull.getReplacedMessage("転入前保険者名"));
        entity.setTennyumaeHokenshaMei(転入前保険者名);
        return this;
    }

    /**
     * 対象計算期間開始年月日を設定します。
     *
     * @param 対象計算期間開始年月日 対象計算期間開始年月日
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set対象計算期間開始年月日(FlexibleDate 対象計算期間開始年月日) {
        requireNonNull(対象計算期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("対象計算期間開始年月日"));
        entity.setTaishoKeisanKaishiYMD(対象計算期間開始年月日);
        return this;
    }

    /**
     * 対象計算期間終了年月日を設定します。
     *
     * @param 対象計算期間終了年月日 対象計算期間終了年月日
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set対象計算期間終了年月日(FlexibleDate 対象計算期間終了年月日) {
        requireNonNull(対象計算期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("対象計算期間終了年月日"));
        entity.setTaishoKeisanShuryoYMD(対象計算期間終了年月日);
        return this;
    }

    /**
     * 被保険者期間開始年月日を設定します。
     *
     * @param 被保険者期間開始年月日 被保険者期間開始年月日
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set被保険者期間開始年月日(FlexibleDate 被保険者期間開始年月日) {
        requireNonNull(被保険者期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者期間開始年月日"));
        entity.setHihokenshaKaishiYMD(被保険者期間開始年月日);
        return this;
    }

    /**
     * 被保険者期間終了年月日を設定します。
     *
     * @param 被保険者期間終了年月日 被保険者期間終了年月日
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set被保険者期間終了年月日(FlexibleDate 被保険者期間終了年月日) {
        requireNonNull(被保険者期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者期間終了年月日"));
        entity.setHihokenshaShuryoYMD(被保険者期間終了年月日);
        return this;
    }

    /**
     * 発行年月日を設定します。
     *
     * @param 発行年月日 発行年月日
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set発行年月日(FlexibleDate 発行年月日) {
        requireNonNull(発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("発行年月日"));
        entity.setHakkoDate(発行年月日);
        return this;
    }

    /**
     * 合計・自己負担額を設定します。
     *
     * @param 合計_自己負担額 合計・自己負担額
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set合計合計_自己負担額(Decimal 合計_自己負担額) {
        requireNonNull(合計_自己負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("合計・自己負担額"));
        entity.setGokei_JikoFutanGaku(合計_自己負担額);
        return this;
    }

    /**
     * 合計・70-74自己負担額（内訳）を設定します。
     *
     * @param 合計_70_74自己負担額_内訳 合計・70-74自己負担額（内訳）
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set合計_70_74自己負担額_内訳(Decimal 合計_70_74自己負担額_内訳) {
        requireNonNull(合計_70_74自己負担額_内訳, UrSystemErrorMessages.値がnull.getReplacedMessage("合計・70-74自己負担額（内訳）"));
        entity.setGokei_70_74JikoFutanGaku(合計_70_74自己負担額_内訳);
        return this;
    }

    /**
     * 合計・70未満高額支給額を設定します。
     *
     * @param 合計_70未満高額支給額 合計・70未満高額支給額
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set合計_70未満高額支給額(Decimal 合計_70未満高額支給額) {
        requireNonNull(合計_70未満高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("合計・70未満高額支給額"));
        entity.setGokei_Under70KogakuShikyuGaku(合計_70未満高額支給額);
        return this;
    }

    /**
     * 合計・70-74高額支給額を設定します。
     *
     * @param 合計_70_74高額支給額 合計・70-74高額支給額
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set合計_70_74高額支給額(Decimal 合計_70_74高額支給額) {
        requireNonNull(合計_70_74高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("合計・70-74高額支給額"));
        entity.setGokei_70_74KogakuShikyuGaku(合計_70_74高額支給額);
        return this;
    }

    /**
     * 支給額計算結果連絡先郵便番号を設定します。
     *
     * @param 支給額計算結果連絡先郵便番号 支給額計算結果連絡先郵便番号
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set支給額計算結果連絡先郵便番号(YubinNo 支給額計算結果連絡先郵便番号) {
        requireNonNull(支給額計算結果連絡先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡先郵便番号"));
        entity.setAtesakiYubinNo(支給額計算結果連絡先郵便番号);
        return this;
    }

    /**
     * 支給額計算結果連絡先住所を設定します。
     *
     * @param 支給額計算結果連絡先住所 支給額計算結果連絡先住所
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set支給額計算結果連絡先住所(RString 支給額計算結果連絡先住所) {
        requireNonNull(支給額計算結果連絡先住所, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡先住所"));
        entity.setAtesakiShimei(支給額計算結果連絡先住所);
        return this;
    }

    /**
     * 支給額計算結果連絡先名称1を設定します。
     *
     * @param 支給額計算結果連絡先名称1 支給額計算結果連絡先名称1
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set支給額計算結果連絡先名称1(RString 支給額計算結果連絡先名称1) {
        requireNonNull(支給額計算結果連絡先名称1, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡先名称1"));
        entity.setAtesakiJusho(支給額計算結果連絡先名称1);
        return this;
    }

    /**
     * 支給額計算結果連絡先名称2を設定します。
     *
     * @param 支給額計算結果連絡先名称2 支給額計算結果連絡先名称2
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set支給額計算結果連絡先名称2(RString 支給額計算結果連絡先名称2) {
        requireNonNull(支給額計算結果連絡先名称2, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算結果連絡先名称2"));
        entity.setMadoguchi_TaishoshaHanteiCode(支給額計算結果連絡先名称2);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeDate(受付年月日);
        return this;
    }

    /**
     * 支給額計算年月日を設定します。
     *
     * @param 支給額計算年月日 支給額計算年月日
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoBuilder}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoBuilder set支給額計算年月日(FlexibleDate 支給額計算年月日) {
        requireNonNull(支給額計算年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額計算年月日"));
        entity.setShikyugakuKeisanDate(支給額計算年月日);
        return this;
    }

    /**
     * {@link JigyoKogakuGassanJikoFutanGakuShomeisho}のインスタンスを生成します。
     *
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeisho}のインスタンス
     */
    public JigyoKogakuGassanJikoFutanGakuShomeisho build() {
        return new JigyoKogakuGassanJikoFutanGakuShomeisho(entity, id);
    }
}
