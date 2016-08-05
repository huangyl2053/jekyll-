/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KogakuGassanJikoFutanGaku}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class KogakuGassanJikoFutanGakuBuilder {

    private final DbT3070KogakuGassanJikoFutanGakuEntity entity;
    private final KogakuGassanJikoFutanGakuIdentifier id;

    /**
     * {@link DbT3070KogakuGassanJikoFutanGakuEntity}より{@link KogakuGassanJikoFutanGaku}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3070KogakuGassanJikoFutanGakuEntity}
     * @param id {@link KogakuGassanJikoFutanGakuIdentifier}
     *
     */
    KogakuGassanJikoFutanGakuBuilder(
            DbT3070KogakuGassanJikoFutanGakuEntity entity,
            KogakuGassanJikoFutanGakuIdentifier id
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
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set対象年度(FlexibleYear 対象年度) {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        entity.setTaishoNendo(対象年度);
        return this;
    }

    /**
     * 保険者番号を設定します。
     *
     * @param 保険者番号 保険者番号
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set保険者番号(HokenshaNo 保険者番号) {
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        entity.setHokenshaNo(保険者番号);
        return this;
    }

    /**
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set支給申請書整理番号(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 保険制度コードを設定します。
     *
     * @param 保険制度コード 保険制度コード
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set保険制度コード(RString 保険制度コード) {
        entity.setHokenSeidoCode(保険制度コード);
        return this;
    }

    /**
     * 保険者名を設定します。
     *
     * @param 保険者名 保険者名
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set保険者名(RString 保険者名) {
        entity.setHokenshaMei(保険者名);
        return this;
    }

    /**
     * 国保被保険者証記号を設定します。
     *
     * @param 国保被保険者証記号 国保被保険者証記号
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set国保被保険者証記号(RString 国保被保険者証記号) {
        entity.setKokuho_HihokenshaShoKigo(国保被保険者証記号);
        return this;
    }

    /**
     * 被保険者氏名カナを設定します。
     *
     * @param 被保険者氏名カナ 被保険者氏名カナ
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set被保険者氏名カナ(AtenaKanaMeisho 被保険者氏名カナ) {
        entity.setHihokenshaShimeiKana(被保険者氏名カナ);
        return this;
    }

    /**
     * 被保険者氏名を設定します。
     *
     * @param 被保険者氏名 被保険者氏名
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set被保険者氏名(AtenaMeisho 被保険者氏名) {
        entity.setHihokenshaShimei(被保険者氏名);
        return this;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set生年月日(FlexibleDate 生年月日) {
        entity.setUmareYMD(生年月日);
        return this;
    }

    /**
     * 性別を設定します。
     *
     * @param 性別 性別
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set性別(Code 性別) {
        entity.setSeibetsuCode(性別);
        return this;
    }

    /**
     * 所得区分を設定します。
     *
     * @param 所得区分 所得区分
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set所得区分(RString 所得区分) {
        entity.setShotokuKubun(所得区分);
        return this;
    }

    /**
     * 70歳以上の者に係る所得区分を設定します。
     *
     * @param 所得区分_70歳以上の者に係る 70歳以上の者に係る所得区分
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set所得区分_70歳以上の者に係る(RString 所得区分_70歳以上の者に係る) {
        entity.setOver70_ShotokuKubun(所得区分_70歳以上の者に係る);
        return this;
    }

    /**
     * 自己負担額証明書整理番号を設定します。
     *
     * @param 自己負担額証明書整理番号 自己負担額証明書整理番号
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set自己負担額証明書整理番号(RString 自己負担額証明書整理番号) {
        entity.setJikoFutanSeiriNo(自己負担額証明書整理番号);
        return this;
    }

    /**
     * 後期保険者番号を設定します。
     *
     * @param 後期保険者番号 後期保険者番号
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set後期保険者番号(RString 後期保険者番号) {
        entity.setKoki_HokenshaNo(後期保険者番号);
        return this;
    }

    /**
     * 後期被保険者番号を設定します。
     *
     * @param 後期被保険者番号 後期被保険者番号
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set後期被保険者番号(RString 後期被保険者番号) {
        entity.setKoki_HihokenshaNo(後期被保険者番号);
        return this;
    }

    /**
     * 国保保険者番号を設定します。
     *
     * @param 国保保険者番号 国保保険者番号
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set国保保険者番号(RString 国保保険者番号) {
        entity.setKokuho_HokenshaNo(国保保険者番号);
        return this;
    }

    /**
     * 国保被保険者証番号を設定します。
     *
     * @param 国保被保険者証番号 国保被保険者証番号
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set国保被保険者証番号(RString 国保被保険者証番号) {
        entity.setKokuho_HihokenshaShoNo(国保被保険者証番号);
        return this;
    }

    /**
     * 国保個人番号を設定します。
     *
     * @param 国保個人番号 国保個人番号
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set国保個人番号(RString 国保個人番号) {
        entity.setKokuho_KojinNo(国保個人番号);
        return this;
    }

    /**
     * 異動区分を設定します。
     *
     * @param 異動区分 異動区分
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set異動区分(RString 異動区分) {
        entity.setIdoKubun(異動区分);
        return this;
    }

    /**
     * 補正済自己負担額送付区分を設定します。
     *
     * @param 補正済自己負担額送付区分 補正済自己負担額送付区分
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set補正済自己負担額送付区分(RString 補正済自己負担額送付区分) {
        entity.setHoseiZumiSofuKubun(補正済自己負担額送付区分);
        return this;
    }

    /**
     * 対象計算期間開始年月日を設定します。
     *
     * @param 対象計算期間開始年月日 対象計算期間開始年月日
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set対象計算期間開始年月日(FlexibleDate 対象計算期間開始年月日) {
        entity.setTaishoKeisanKaishiYMD(対象計算期間開始年月日);
        return this;
    }

    /**
     * 対象計算期間終了年月日を設定します。
     *
     * @param 対象計算期間終了年月日 対象計算期間終了年月日
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set対象計算期間終了年月日(FlexibleDate 対象計算期間終了年月日) {
        entity.setTaishoKeisanShuryoYMD(対象計算期間終了年月日);
        return this;
    }

    /**
     * 被保険者期間開始年月日を設定します。
     *
     * @param 被保険者期間開始年月日 被保険者期間開始年月日
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set被保険者期間開始年月日(FlexibleDate 被保険者期間開始年月日) {
        entity.setHihokenshaKaishiYMD(被保険者期間開始年月日);
        return this;
    }

    /**
     * 被保険者期間終了年月日を設定します。
     *
     * @param 被保険者期間終了年月日 被保険者期間終了年月日
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set被保険者期間終了年月日(FlexibleDate 被保険者期間終了年月日) {
        entity.setHihokenshaShuryoYMD(被保険者期間終了年月日);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set申請年月日(FlexibleDate 申請年月日) {
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 合計_自己負担額を設定します。
     *
     * @param 合計_自己負担額 合計_自己負担額
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set合計_自己負担額(Decimal 合計_自己負担額) {
        entity.setGokei_JikoFutanGaku(合計_自己負担額);
        return this;
    }

    /**
     * 合計_70_74自己負担額_内訳を設定します。
     *
     * @param 合計_70_74自己負担額_内訳 合計_70_74自己負担額_内訳
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set合計_70_74自己負担額_内訳(Decimal 合計_70_74自己負担額_内訳) {
        entity.setGokei_70_74JikoFutanGaku(合計_70_74自己負担額_内訳);
        return this;
    }

    /**
     * 合計_70未満高額支給額を設定します。
     *
     * @param 合計_70未満高額支給額 合計_70未満高額支給額
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set合計_70未満高額支給額(Decimal 合計_70未満高額支給額) {
        entity.setGokei_Under70KogakuShikyuGaku(合計_70未満高額支給額);
        return this;
    }

    /**
     * 合計_70_74高額支給額を設定します。
     *
     * @param 合計_70_74高額支給額 合計_70_74高額支給額
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set合計_70_74高額支給額(Decimal 合計_70_74高額支給額) {
        entity.setGokei_70_74KogakuShikyuGaku(合計_70_74高額支給額);
        return this;
    }

    /**
     * 補正済_合計_自己負担額を設定します。
     *
     * @param 補正済_合計_自己負担額 補正済_合計_自己負担額
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set補正済_合計_自己負担額(Decimal 補正済_合計_自己負担額) {
        entity.setSumi_Gokei_JikoFutanGaku(補正済_合計_自己負担額);
        return this;
    }

    /**
     * 補正済_合計_70_74自己負担額_内訳を設定します。
     *
     * @param 補正済_合計_70_74自己負担額_内訳 補正済_合計_70_74自己負担額_内訳
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set補正済_合計_70_74自己負担額_内訳(Decimal 補正済_合計_70_74自己負担額_内訳) {
        entity.setSumi_Gokei_70_74JikoFutanGaku(補正済_合計_70_74自己負担額_内訳);
        return this;
    }

    /**
     * 補正済_合計_70未満高額支給額を設定します。
     *
     * @param 補正済_合計_70未満高額支給額 補正済_合計_70未満高額支給額
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set補正済_合計_70未満高額支給額(Decimal 補正済_合計_70未満高額支給額) {
        entity.setSumi_Gokei_Under70KogakuShikyuGaku(補正済_合計_70未満高額支給額);
        return this;
    }

    /**
     * 補正済_合計_70_74高額支給額を設定します。
     *
     * @param 補正済_合計_70_74高額支給額 補正済_合計_70_74高額支給額
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set補正済_合計_70_74高額支給額(Decimal 補正済_合計_70_74高額支給額) {
        entity.setSumi_Gokei_70_74KogakuShikyuGaku(補正済_合計_70_74高額支給額);
        return this;
    }

    /**
     * 宛先氏名を設定します。
     *
     * @param 宛先氏名 宛先氏名
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set宛先氏名(AtenaMeisho 宛先氏名) {
        entity.setAtesakiShimei(宛先氏名);
        return this;
    }

    /**
     * 宛先郵便番号を設定します。
     *
     * @param 宛先郵便番号 宛先郵便番号
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set宛先郵便番号(YubinNo 宛先郵便番号) {
        entity.setAtesakiYubinNo(宛先郵便番号);
        return this;
    }

    /**
     * 宛先住所を設定します。
     *
     * @param 宛先住所 宛先住所
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set宛先住所(RString 宛先住所) {
        entity.setAtesakiJusho(宛先住所);
        return this;
    }

    /**
     * 窓口払対象者判定コードを設定します。
     *
     * @param 窓口払対象者判定コード 窓口払対象者判定コード
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set窓口払対象者判定コード(RString 窓口払対象者判定コード) {
        entity.setMadoguchi_TaishoshaHanteiCode(窓口払対象者判定コード);
        return this;
    }

    /**
     * 支払場所を設定します。
     *
     * @param 支払場所 支払場所
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set支払場所(RString 支払場所) {
        entity.setShiharaiBasho(支払場所);
        return this;
    }

    /**
     * 支払期間開始年月日を設定します。
     *
     * @param 支払期間開始年月日 支払期間開始年月日
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set支払期間開始年月日(FlexibleDate 支払期間開始年月日) {
        entity.setShikaraiKaishiYMD(支払期間開始年月日);
        return this;
    }

    /**
     * 支払期間終了年月日を設定します。
     *
     * @param 支払期間終了年月日 支払期間終了年月日
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set支払期間終了年月日(FlexibleDate 支払期間終了年月日) {
        entity.setShiharaiShuryoYMD(支払期間終了年月日);
        return this;
    }

    /**
     * 閉庁内容を設定します。
     *
     * @param 閉庁内容 閉庁内容
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set閉庁内容(RString 閉庁内容) {
        entity.setHeichoNaiyo(閉庁内容);
        return this;
    }

    /**
     * 支払期間開始時間を設定します。
     *
     * @param 支払期間開始時間 支払期間開始時間
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set支払期間開始時間(RString 支払期間開始時間) {
        entity.setShiharaiKaishiTime(支払期間開始時間);
        return this;
    }

    /**
     * 支払期間終了時間を設定します。
     *
     * @param 支払期間終了時間 支払期間終了時間
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set支払期間終了時間(RString 支払期間終了時間) {
        entity.setShiharaiShuryoTime(支払期間終了時間);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set備考(RString 備考) {
        entity.setBiko(備考);
        return this;
    }

    /**
     * データ作成区分を設定します。
     *
     * @param データ作成区分 データ作成区分
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder setデータ作成区分(RString データ作成区分) {
        entity.setDataSakuseiKubun(データ作成区分);
        return this;
    }

    /**
     * 自己負担額確認情報受取年月を設定します。
     *
     * @param 自己負担額確認情報受取年月 自己負担額確認情報受取年月
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set自己負担額確認情報受取年月(FlexibleYearMonth 自己負担額確認情報受取年月) {
        entity.setKakunin_UketoriYM(自己負担額確認情報受取年月);
        return this;
    }

    /**
     * 補正済自己負担額情報送付年月を設定します。
     *
     * @param 補正済自己負担額情報送付年月 補正済自己負担額情報送付年月
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set補正済自己負担額情報送付年月(FlexibleYearMonth 補正済自己負担額情報送付年月) {
        entity.setHoseiZumi_SofuYM(補正済自己負担額情報送付年月);
        return this;
    }

    /**
     * 自己負担額証明書情報受取年月を設定します。
     *
     * @param 自己負担額証明書情報受取年月 自己負担額証明書情報受取年月
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set自己負担額証明書情報受取年月(FlexibleYearMonth 自己負担額証明書情報受取年月) {
        entity.setShomeisho_UketoriYM(自己負担額証明書情報受取年月);
        return this;
    }

    /**
     * 再送フラグを設定します。
     *
     * @param 再送フラグ 再送フラグ
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set再送フラグ(RString 再送フラグ) {
        entity.setSaisoFlag(再送フラグ);
        return this;
    }

    /**
     * 送付対象外フラグを設定します。
     *
     * @param 送付対象外フラグ 送付対象外フラグ
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set送付対象外フラグ(RString 送付対象外フラグ) {
        entity.setSofuTaishoGaiFlag(送付対象外フラグ);
        return this;
    }

    /**
     * 自己負担額計算年月日を設定します。
     *
     * @param 自己負担額計算年月日 自己負担額計算年月日
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set自己負担額計算年月日(FlexibleDate 自己負担額計算年月日) {
        entity.setJikoFutanKeisanYMD(自己負担額計算年月日);
        return this;
    }

    /**
     * 自己負担額証明書作成年月日を設定します。
     *
     * @param 自己負担額証明書作成年月日 自己負担額証明書作成年月日
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set自己負担額証明書作成年月日(FlexibleDate 自己負担額証明書作成年月日) {
        entity.setShomeiShoSakuseiYMD(自己負担額証明書作成年月日);
        return this;
    }

    /**
     * 後期_国保処理区分を設定します。
     *
     * @param 後期_国保処理区分 後期_国保処理区分
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder set後期_国保処理区分(RString 後期_国保処理区分) {
        entity.setKoki_KokuhoShoriKubun(後期_国保処理区分);
        return this;
    }

    /**
     * リアル補正実施年月日を設定します。。
     *
     * @param リアル補正実施年月日 リアル補正実施年月日
     * @return {@link KogakuGassanJikoFutanGakuBuilder}
     */
    public KogakuGassanJikoFutanGakuBuilder setリアル補正実施年月日(FlexibleDate リアル補正実施年月日) {
        entity.setRealHoseiJissiYMD(リアル補正実施年月日);
        return this;
    }

    /**
     * {@link KogakuGassanJikoFutanGaku}のインスタンスを生成します。
     *
     * @return {@link KogakuGassanJikoFutanGaku}のインスタンス
     */
    public KogakuGassanJikoFutanGaku build() {
        return new KogakuGassanJikoFutanGaku(entity, id);
    }
}
