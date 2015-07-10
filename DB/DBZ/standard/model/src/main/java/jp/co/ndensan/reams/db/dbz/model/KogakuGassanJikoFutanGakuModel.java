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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算自己負担額のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuGassanJikoFutanGakuModel implements Serializable {

    private DbT3070KogakuGassanJikoFutanGakuEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuGassanJikoFutanGakuModel() {
        entity = new DbT3070KogakuGassanJikoFutanGakuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3070KogakuGassanJikoFutanGakuEntity
     */
    public KogakuGassanJikoFutanGakuModel(DbT3070KogakuGassanJikoFutanGakuEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3070KogakuGassanJikoFutanGakuEntityを返します。
     *
     * @return DbT3070KogakuGassanJikoFutanGakuEntity
     */
    public DbT3070KogakuGassanJikoFutanGakuEntity getEntity() {
        return entity;
    }

    /**
     * DbT3070KogakuGassanJikoFutanGakuEntityを設定します。
     *
     * @param entity DbT3070KogakuGassanJikoFutanGakuEntity
     */
    public void setEntity(DbT3070KogakuGassanJikoFutanGakuEntity entity) {
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
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return entity.getHokenshaNo();
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
     * 保険者名を返します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return entity.getHokenshaMei();
    }

    /**
     * 国保被保険者証記号を返します。
     *
     * @return 国保被保険者証記号
     */
    public RString get国保被保険者証記号() {
        return entity.getKokuho_HihokenshaShoKigo();
    }

    /**
     * 被保険者氏名カナを返します。
     *
     * @return 被保険者氏名カナ
     */
    public AtenaKanaMeisho get被保険者氏名カナ() {
        return entity.getHihokenshaShimeiKana();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.getHihokenshaShimei();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getUmareYMD();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Code get性別() {
        return entity.getSeibetsuCode();
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
     * 自己負担額証明書整理番号を返します。
     *
     * @return 自己負担額証明書整理番号
     */
    public RString get自己負担額証明書整理番号() {
        return entity.getJikoFutanSeiriNo();
    }

    /**
     * 後期保険者番号を返します。
     *
     * @return 後期保険者番号
     */
    public RString get後期保険者番号() {
        return entity.getKoki_HokenshaNo();
    }

    /**
     * 後期被保険者番号を返します。
     *
     * @return 後期被保険者番号
     */
    public RString get後期被保険者番号() {
        return entity.getKoki_HihokenshaNo();
    }

    /**
     * 国保保険者番号を返します。
     *
     * @return 国保保険者番号
     */
    public RString get国保保険者番号() {
        return entity.getKokuho_HokenshaNo();
    }

    /**
     * 国保被保険者証番号を返します。
     *
     * @return 国保被保険者証番号
     */
    public RString get国保被保険者証番号() {
        return entity.getKokuho_HihokenshaShoNo();
    }

    /**
     * 国保個人番号を返します。
     *
     * @return 国保個人番号
     */
    public RString get国保個人番号() {
        return entity.getKokuho_KojinNo();
    }

    /**
     * 異動区分を返します。
     *
     * @return 異動区分
     */
    public RString get異動区分() {
        return entity.getIdoKubun();
    }

    /**
     * 補正済自己負担額送付区分を返します。
     *
     * @return 補正済自己負担額送付区分
     */
    public RString get補正済自己負担額送付区分() {
        return entity.getHoseiZumiSofuKubun();
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
     * 被保険者期間開始年月日を返します。
     *
     * @return 被保険者期間開始年月日
     */
    public FlexibleDate get被保険者期間開始年月日() {
        return entity.getHihokenshaKaishiYMD();
    }

    /**
     * 被保険者期間終了年月日を返します。
     *
     * @return 被保険者期間終了年月日
     */
    public FlexibleDate get被保険者期間終了年月日() {
        return entity.getHihokenshaShuryoYMD();
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 合計_自己負担額を返します。
     *
     * @return 合計_自己負担額
     */
    public Decimal get合計_自己負担額() {
        return entity.getGokei_JikoFutanGaku();
    }

    /**
     * 合計_70_74自己負担額_内訳を返します。
     *
     * @return 合計_70_74自己負担額_内訳
     */
    public Decimal get合計_70_74自己負担額_内訳() {
        return entity.getGokei_70_74JikoFutanGaku();
    }

    /**
     * 合計_70未満高額支給額を返します。
     *
     * @return 合計_70未満高額支給額
     */
    public Decimal get合計_70未満高額支給額() {
        return entity.getGokei_Under70KogakuShikyuGaku();
    }

    /**
     * 合計_70_74高額支給額を返します。
     *
     * @return 合計_70_74高額支給額
     */
    public Decimal get合計_70_74高額支給額() {
        return entity.getGokei_70_74KogakuShikyuGaku();
    }

    /**
     * 補正済_合計_自己負担額を返します。
     *
     * @return 補正済_合計_自己負担額
     */
    public Decimal get補正済_合計_自己負担額() {
        return entity.getSumi_Gokei_JikoFutanGaku();
    }

    /**
     * 補正済_合計_70_74自己負担額_内訳を返します。
     *
     * @return 補正済_合計_70_74自己負担額_内訳
     */
    public Decimal get補正済_合計_70_74自己負担額_内訳() {
        return entity.getSumi_Gokei_70_74JikoFutanGaku();
    }

    /**
     * 補正済_合計_70未満高額支給額を返します。
     *
     * @return 補正済_合計_70未満高額支給額
     */
    public Decimal get補正済_合計_70未満高額支給額() {
        return entity.getSumi_Gokei_Under70KogakuShikyuGaku();
    }

    /**
     * 補正済_合計_70_74高額支給額を返します。
     *
     * @return 補正済_合計_70_74高額支給額
     */
    public Decimal get補正済_合計_70_74高額支給額() {
        return entity.getSumi_Gokei_70_74KogakuShikyuGaku();
    }

    /**
     * 宛先氏名を返します。
     *
     * @return 宛先氏名
     */
    public AtenaMeisho get宛先氏名() {
        return entity.getAtesakiShimei();
    }

    /**
     * 宛先郵便番号を返します。
     *
     * @return 宛先郵便番号
     */
    public YubinNo get宛先郵便番号() {
        return entity.getAtesakiYubinNo();
    }

    /**
     * 宛先住所を返します。
     *
     * @return 宛先住所
     */
    public RString get宛先住所() {
        return entity.getAtesakiJusho();
    }

    /**
     * 窓口払対象者判定コードを返します。
     *
     * @return 窓口払対象者判定コード
     */
    public RString get窓口払対象者判定コード() {
        return entity.getMadoguchi_TaishoshaHanteiCode();
    }

    /**
     * 支払場所を返します。
     *
     * @return 支払場所
     */
    public RString get支払場所() {
        return entity.getShiharaiBasho();
    }

    /**
     * 支払期間開始年月日を返します。
     *
     * @return 支払期間開始年月日
     */
    public FlexibleDate get支払期間開始年月日() {
        return entity.getShikaraiKaishiYMD();
    }

    /**
     * 支払期間終了年月日を返します。
     *
     * @return 支払期間終了年月日
     */
    public FlexibleDate get支払期間終了年月日() {
        return entity.getShiharaiShuryoYMD();
    }

    /**
     * 閉庁内容を返します。
     *
     * @return 閉庁内容
     */
    public RString get閉庁内容() {
        return entity.getHeichoNaiyo();
    }

    /**
     * 支払期間開始時間を返します。
     *
     * @return 支払期間開始時間
     */
    public RString get支払期間開始時間() {
        return entity.getShiharaiKaishiTime();
    }

    /**
     * 支払期間終了時間を返します。
     *
     * @return 支払期間終了時間
     */
    public RString get支払期間終了時間() {
        return entity.getShiharaiShuryoTime();
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
     * データ作成区分を返します。
     *
     * @return データ作成区分
     */
    public RString getデータ作成区分() {
        return entity.getDataSakuseiKubun();
    }

    /**
     * 自己負担額確認情報受取年月を返します。
     *
     * @return 自己負担額確認情報受取年月
     */
    public FlexibleYearMonth get自己負担額確認情報受取年月() {
        return entity.getKakunin_UketoriYM();
    }

    /**
     * 補正済自己負担額情報送付年月を返します。
     *
     * @return 補正済自己負担額情報送付年月
     */
    public FlexibleYearMonth get補正済自己負担額情報送付年月() {
        return entity.getHoseiZumi_SofuYM();
    }

    /**
     * 自己負担額証明書情報受取年月を返します。
     *
     * @return 自己負担額証明書情報受取年月
     */
    public FlexibleYearMonth get自己負担額証明書情報受取年月() {
        return entity.getShomeisho_UketoriYM();
    }

    /**
     * 再送フラグを返します。
     *
     * @return 再送フラグ
     */
    public RString get再送フラグ() {
        return entity.getSaisoFlag();
    }

    /**
     * 送付対象外フラグを返します。
     *
     * @return 送付対象外フラグ
     */
    public RString get送付対象外フラグ() {
        return entity.getSofuTaishoGaiFlag();
    }

    /**
     * 自己負担額計算年月日を返します。
     *
     * @return 自己負担額計算年月日
     */
    public FlexibleDate get自己負担額計算年月日() {
        return entity.getJikoFutanKeisanYMD();
    }

    /**
     * 自己負担額証明書作成年月日を返します。
     *
     * @return 自己負担額証明書作成年月日
     */
    public FlexibleDate get自己負担額証明書作成年月日() {
        return entity.getShomeiShoSakuseiYMD();
    }

    /**
     * 後期_国保処理区分を返します。
     *
     * @return 後期_国保処理区分
     */
    public RString get後期_国保処理区分() {
        return entity.getKoki_KokuhoShoriKubun();
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
     * 保険者番号を設定します。
     *
     * @param 保険者番号 保険者番号
     */
    public void set保険者番号(HokenshaNo 保険者番号) {
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        entity.setHokenshaNo(保険者番号);
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
     * 保険者名を設定します。
     *
     * @param 保険者名 保険者名
     */
    public void set保険者名(RString 保険者名) {
        requireNonNull(保険者名, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者名"));
        entity.setHokenshaMei(保険者名);
    }

    /**
     * 国保被保険者証記号を設定します。
     *
     * @param 国保被保険者証記号 国保被保険者証記号
     */
    public void set国保被保険者証記号(RString 国保被保険者証記号) {
        requireNonNull(国保被保険者証記号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保被保険者証記号"));
        entity.setKokuho_HihokenshaShoKigo(国保被保険者証記号);
    }

    /**
     * 被保険者氏名カナを設定します。
     *
     * @param 被保険者氏名カナ 被保険者氏名カナ
     */
    public void set被保険者氏名カナ(AtenaKanaMeisho 被保険者氏名カナ) {
        requireNonNull(被保険者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者氏名カナ"));
        entity.setHihokenshaShimeiKana(被保険者氏名カナ);
    }

    /**
     * 被保険者氏名を設定します。
     *
     * @param 被保険者氏名 被保険者氏名
     */
    public void set被保険者氏名(AtenaMeisho 被保険者氏名) {
        requireNonNull(被保険者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者氏名"));
        entity.setHihokenshaShimei(被保険者氏名);
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     */
    public void set生年月日(FlexibleDate 生年月日) {
        requireNonNull(生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("生年月日"));
        entity.setUmareYMD(生年月日);
    }

    /**
     * 性別を設定します。
     *
     * @param 性別 性別
     */
    public void set性別(Code 性別) {
        requireNonNull(性別, UrSystemErrorMessages.値がnull.getReplacedMessage("性別"));
        entity.setSeibetsuCode(性別);
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
        entity.setOver70_ShotokuKubun(_70歳以上の者に係る所得区分);
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
     * 後期保険者番号を設定します。
     *
     * @param 後期保険者番号 後期保険者番号
     */
    public void set後期保険者番号(RString 後期保険者番号) {
        requireNonNull(後期保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("後期保険者番号"));
        entity.setKoki_HokenshaNo(後期保険者番号);
    }

    /**
     * 後期被保険者番号を設定します。
     *
     * @param 後期被保険者番号 後期被保険者番号
     */
    public void set後期被保険者番号(RString 後期被保険者番号) {
        requireNonNull(後期被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("後期被保険者番号"));
        entity.setKoki_HihokenshaNo(後期被保険者番号);
    }

    /**
     * 国保保険者番号を設定します。
     *
     * @param 国保保険者番号 国保保険者番号
     */
    public void set国保保険者番号(RString 国保保険者番号) {
        requireNonNull(国保保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保保険者番号"));
        entity.setKokuho_HokenshaNo(国保保険者番号);
    }

    /**
     * 国保被保険者証番号を設定します。
     *
     * @param 国保被保険者証番号 国保被保険者証番号
     */
    public void set国保被保険者証番号(RString 国保被保険者証番号) {
        requireNonNull(国保被保険者証番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保被保険者証番号"));
        entity.setKokuho_HihokenshaShoNo(国保被保険者証番号);
    }

    /**
     * 国保個人番号を設定します。
     *
     * @param 国保個人番号 国保個人番号
     */
    public void set国保個人番号(RString 国保個人番号) {
        requireNonNull(国保個人番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保個人番号"));
        entity.setKokuho_KojinNo(国保個人番号);
    }

    /**
     * 異動区分を設定します。
     *
     * @param 異動区分 異動区分
     */
    public void set異動区分(RString 異動区分) {
        requireNonNull(異動区分, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分"));
        entity.setIdoKubun(異動区分);
    }

    /**
     * 補正済自己負担額送付区分を設定します。
     *
     * @param 補正済自己負担額送付区分 補正済自己負担額送付区分
     */
    public void set補正済自己負担額送付区分(RString 補正済自己負担額送付区分) {
        requireNonNull(補正済自己負担額送付区分, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済自己負担額送付区分"));
        entity.setHoseiZumiSofuKubun(補正済自己負担額送付区分);
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
     * 被保険者期間開始年月日を設定します。
     *
     * @param 被保険者期間開始年月日 被保険者期間開始年月日
     */
    public void set被保険者期間開始年月日(FlexibleDate 被保険者期間開始年月日) {
        requireNonNull(被保険者期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者期間開始年月日"));
        entity.setHihokenshaKaishiYMD(被保険者期間開始年月日);
    }

    /**
     * 被保険者期間終了年月日を設定します。
     *
     * @param 被保険者期間終了年月日 被保険者期間終了年月日
     */
    public void set被保険者期間終了年月日(FlexibleDate 被保険者期間終了年月日) {
        requireNonNull(被保険者期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者期間終了年月日"));
        entity.setHihokenshaShuryoYMD(被保険者期間終了年月日);
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     */
    public void set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
    }

    /**
     * 合計_自己負担額を設定します。
     *
     * @param 合計_自己負担額 合計_自己負担額
     */
    public void set合計_自己負担額(Decimal 合計_自己負担額) {
        requireNonNull(合計_自己負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("合計_自己負担額"));
        entity.setGokei_JikoFutanGaku(合計_自己負担額);
    }

    /**
     * 合計_70_74自己負担額_内訳を設定します。
     *
     * @param 合計_70_74自己負担額_内訳 合計_70_74自己負担額_内訳
     */
    public void set合計_70_74自己負担額_内訳(Decimal 合計_70_74自己負担額_内訳) {
        requireNonNull(合計_70_74自己負担額_内訳, UrSystemErrorMessages.値がnull.getReplacedMessage("合計_70_74自己負担額_内訳"));
        entity.setGokei_70_74JikoFutanGaku(合計_70_74自己負担額_内訳);
    }

    /**
     * 合計_70未満高額支給額を設定します。
     *
     * @param 合計_70未満高額支給額 合計_70未満高額支給額
     */
    public void set合計_70未満高額支給額(Decimal 合計_70未満高額支給額) {
        requireNonNull(合計_70未満高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("合計_70未満高額支給額"));
        entity.setGokei_Under70KogakuShikyuGaku(合計_70未満高額支給額);
    }

    /**
     * 合計_70_74高額支給額を設定します。
     *
     * @param 合計_70_74高額支給額 合計_70_74高額支給額
     */
    public void set合計_70_74高額支給額(Decimal 合計_70_74高額支給額) {
        requireNonNull(合計_70_74高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("合計_70_74高額支給額"));
        entity.setGokei_70_74KogakuShikyuGaku(合計_70_74高額支給額);
    }

    /**
     * 補正済_合計_自己負担額を設定します。
     *
     * @param 補正済_合計_自己負担額 補正済_合計_自己負担額
     */
    public void set補正済_合計_自己負担額(Decimal 補正済_合計_自己負担額) {
        requireNonNull(補正済_合計_自己負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済_合計_自己負担額"));
        entity.setSumi_Gokei_JikoFutanGaku(補正済_合計_自己負担額);
    }

    /**
     * 補正済_合計_70_74自己負担額_内訳を設定します。
     *
     * @param 補正済_合計_70_74自己負担額_内訳 補正済_合計_70_74自己負担額_内訳
     */
    public void set補正済_合計_70_74自己負担額_内訳(Decimal 補正済_合計_70_74自己負担額_内訳) {
        requireNonNull(補正済_合計_70_74自己負担額_内訳, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済_合計_70_74自己負担額_内訳"));
        entity.setSumi_Gokei_70_74JikoFutanGaku(補正済_合計_70_74自己負担額_内訳);
    }

    /**
     * 補正済_合計_70未満高額支給額を設定します。
     *
     * @param 補正済_合計_70未満高額支給額 補正済_合計_70未満高額支給額
     */
    public void set補正済_合計_70未満高額支給額(Decimal 補正済_合計_70未満高額支給額) {
        requireNonNull(補正済_合計_70未満高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済_合計_70未満高額支給額"));
        entity.setSumi_Gokei_Under70KogakuShikyuGaku(補正済_合計_70未満高額支給額);
    }

    /**
     * 補正済_合計_70_74高額支給額を設定します。
     *
     * @param 補正済_合計_70_74高額支給額 補正済_合計_70_74高額支給額
     */
    public void set補正済_合計_70_74高額支給額(Decimal 補正済_合計_70_74高額支給額) {
        requireNonNull(補正済_合計_70_74高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済_合計_70_74高額支給額"));
        entity.setSumi_Gokei_70_74KogakuShikyuGaku(補正済_合計_70_74高額支給額);
    }

    /**
     * 宛先氏名を設定します。
     *
     * @param 宛先氏名 宛先氏名
     */
    public void set宛先氏名(AtenaMeisho 宛先氏名) {
        requireNonNull(宛先氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("宛先氏名"));
        entity.setAtesakiShimei(宛先氏名);
    }

    /**
     * 宛先郵便番号を設定します。
     *
     * @param 宛先郵便番号 宛先郵便番号
     */
    public void set宛先郵便番号(YubinNo 宛先郵便番号) {
        requireNonNull(宛先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("宛先郵便番号"));
        entity.setAtesakiYubinNo(宛先郵便番号);
    }

    /**
     * 宛先住所を設定します。
     *
     * @param 宛先住所 宛先住所
     */
    public void set宛先住所(RString 宛先住所) {
        requireNonNull(宛先住所, UrSystemErrorMessages.値がnull.getReplacedMessage("宛先住所"));
        entity.setAtesakiJusho(宛先住所);
    }

    /**
     * 窓口払対象者判定コードを設定します。
     *
     * @param 窓口払対象者判定コード 窓口払対象者判定コード
     */
    public void set窓口払対象者判定コード(RString 窓口払対象者判定コード) {
        requireNonNull(窓口払対象者判定コード, UrSystemErrorMessages.値がnull.getReplacedMessage("窓口払対象者判定コード"));
        entity.setMadoguchi_TaishoshaHanteiCode(窓口払対象者判定コード);
    }

    /**
     * 支払場所を設定します。
     *
     * @param 支払場所 支払場所
     */
    public void set支払場所(RString 支払場所) {
        requireNonNull(支払場所, UrSystemErrorMessages.値がnull.getReplacedMessage("支払場所"));
        entity.setShiharaiBasho(支払場所);
    }

    /**
     * 支払期間開始年月日を設定します。
     *
     * @param 支払期間開始年月日 支払期間開始年月日
     */
    public void set支払期間開始年月日(FlexibleDate 支払期間開始年月日) {
        requireNonNull(支払期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支払期間開始年月日"));
        entity.setShikaraiKaishiYMD(支払期間開始年月日);
    }

    /**
     * 支払期間終了年月日を設定します。
     *
     * @param 支払期間終了年月日 支払期間終了年月日
     */
    public void set支払期間終了年月日(FlexibleDate 支払期間終了年月日) {
        requireNonNull(支払期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支払期間終了年月日"));
        entity.setShiharaiShuryoYMD(支払期間終了年月日);
    }

    /**
     * 閉庁内容を設定します。
     *
     * @param 閉庁内容 閉庁内容
     */
    public void set閉庁内容(RString 閉庁内容) {
        requireNonNull(閉庁内容, UrSystemErrorMessages.値がnull.getReplacedMessage("閉庁内容"));
        entity.setHeichoNaiyo(閉庁内容);
    }

    /**
     * 支払期間開始時間を設定します。
     *
     * @param 支払期間開始時間 支払期間開始時間
     */
    public void set支払期間開始時間(RString 支払期間開始時間) {
        requireNonNull(支払期間開始時間, UrSystemErrorMessages.値がnull.getReplacedMessage("支払期間開始時間"));
        entity.setShiharaiKaishiTime(支払期間開始時間);
    }

    /**
     * 支払期間終了時間を設定します。
     *
     * @param 支払期間終了時間 支払期間終了時間
     */
    public void set支払期間終了時間(RString 支払期間終了時間) {
        requireNonNull(支払期間終了時間, UrSystemErrorMessages.値がnull.getReplacedMessage("支払期間終了時間"));
        entity.setShiharaiShuryoTime(支払期間終了時間);
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
     * データ作成区分を設定します。
     *
     * @param データ作成区分 データ作成区分
     */
    public void setデータ作成区分(RString データ作成区分) {
        requireNonNull(データ作成区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ作成区分"));
        entity.setDataSakuseiKubun(データ作成区分);
    }

    /**
     * 自己負担額確認情報受取年月を設定します。
     *
     * @param 自己負担額確認情報受取年月 自己負担額確認情報受取年月
     */
    public void set自己負担額確認情報受取年月(FlexibleYearMonth 自己負担額確認情報受取年月) {
        requireNonNull(自己負担額確認情報受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額確認情報受取年月"));
        entity.setKakunin_UketoriYM(自己負担額確認情報受取年月);
    }

    /**
     * 補正済自己負担額情報送付年月を設定します。
     *
     * @param 補正済自己負担額情報送付年月 補正済自己負担額情報送付年月
     */
    public void set補正済自己負担額情報送付年月(FlexibleYearMonth 補正済自己負担額情報送付年月) {
        requireNonNull(補正済自己負担額情報送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済自己負担額情報送付年月"));
        entity.setHoseiZumi_SofuYM(補正済自己負担額情報送付年月);
    }

    /**
     * 自己負担額証明書情報受取年月を設定します。
     *
     * @param 自己負担額証明書情報受取年月 自己負担額証明書情報受取年月
     */
    public void set自己負担額証明書情報受取年月(FlexibleYearMonth 自己負担額証明書情報受取年月) {
        requireNonNull(自己負担額証明書情報受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書情報受取年月"));
        entity.setShomeisho_UketoriYM(自己負担額証明書情報受取年月);
    }

    /**
     * 再送フラグを設定します。
     *
     * @param 再送フラグ 再送フラグ
     */
    public void set再送フラグ(RString 再送フラグ) {
        requireNonNull(再送フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("再送フラグ"));
        entity.setSaisoFlag(再送フラグ);
    }

    /**
     * 送付対象外フラグを設定します。
     *
     * @param 送付対象外フラグ 送付対象外フラグ
     */
    public void set送付対象外フラグ(RString 送付対象外フラグ) {
        requireNonNull(送付対象外フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("送付対象外フラグ"));
        entity.setSofuTaishoGaiFlag(送付対象外フラグ);
    }

    /**
     * 自己負担額計算年月日を設定します。
     *
     * @param 自己負担額計算年月日 自己負担額計算年月日
     */
    public void set自己負担額計算年月日(FlexibleDate 自己負担額計算年月日) {
        requireNonNull(自己負担額計算年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額計算年月日"));
        entity.setJikoFutanKeisanYMD(自己負担額計算年月日);
    }

    /**
     * 自己負担額証明書作成年月日を設定します。
     *
     * @param 自己負担額証明書作成年月日 自己負担額証明書作成年月日
     */
    public void set自己負担額証明書作成年月日(FlexibleDate 自己負担額証明書作成年月日) {
        requireNonNull(自己負担額証明書作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書作成年月日"));
        entity.setShomeiShoSakuseiYMD(自己負担額証明書作成年月日);
    }

    /**
     * 後期_国保処理区分を設定します。
     *
     * @param 後期_国保処理区分 後期_国保処理区分
     */
    public void set後期_国保処理区分(RString 後期_国保処理区分) {
        requireNonNull(後期_国保処理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("後期_国保処理区分"));
        entity.setKoki_KokuhoShoriKubun(後期_国保処理区分);
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
