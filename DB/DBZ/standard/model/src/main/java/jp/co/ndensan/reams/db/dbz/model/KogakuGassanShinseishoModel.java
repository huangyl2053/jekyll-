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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算申請書のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuGassanShinseishoModel implements Serializable {

    private DbT3068KogakuGassanShinseishoEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuGassanShinseishoModel() {
        entity = new DbT3068KogakuGassanShinseishoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3068KogakuGassanShinseishoEntity
     */
    public KogakuGassanShinseishoModel(DbT3068KogakuGassanShinseishoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3068KogakuGassanShinseishoEntityを返します。
     *
     * @return DbT3068KogakuGassanShinseishoEntity
     */
    public DbT3068KogakuGassanShinseishoEntity getEntity() {
        return entity;
    }

    /**
     * DbT3068KogakuGassanShinseishoEntityを設定します。
     *
     * @param entity DbT3068KogakuGassanShinseishoEntity
     */
    public void setEntity(DbT3068KogakuGassanShinseishoEntity entity) {
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
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
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
     * 申請状況区分を返します。
     *
     * @return 申請状況区分
     */
    public RString get申請状況区分() {
        return entity.getShinseiJokyoKubun();
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
     * 支給申請書整理番号を返します。
     *
     * @return 支給申請書整理番号
     */
    public RString get支給申請書整理番号() {
        return entity.getShikyuShinseishoSeiriNo();
    }

    /**
     * 国保支給申請書整理番号を返します。
     *
     * @return 国保支給申請書整理番号
     */
    public RString get国保支給申請書整理番号() {
        return entity.getKokuhoShikyuShinseishoSeiriNo();
    }

    /**
     * 支給申請区分を返します。
     *
     * @return 支給申請区分
     */
    public RString get支給申請区分() {
        return entity.getShikyuShinseiKubun();
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
     * 支給申請形態を返します。
     *
     * @return 支給申請形態
     */
    public RString get支給申請形態() {
        return entity.getShikyuShinseiKeitai();
    }

    /**
     * 自己負担額証明書交付申請の有無を返します。
     *
     * @return 自己負担額証明書交付申請の有無
     */
    public RString get自己負担額証明書交付申請の有無() {
        return entity.getJikoFutanKofuUmu();
    }

    /**
     * 申請代表者氏名を返します。
     *
     * @return 申請代表者氏名
     */
    public AtenaMeisho get申請代表者氏名() {
        return entity.getShinseiDaihyoshaShimei();
    }

    /**
     * 申請代表者郵便番号を返します。
     *
     * @return 申請代表者郵便番号
     */
    public YubinNo get申請代表者郵便番号() {
        return entity.getShinseiDaihyoshaYubinNo();
    }

    /**
     * 申請代表者住所を返します。
     *
     * @return 申請代表者住所
     */
    public RString get申請代表者住所() {
        return entity.getShinseiDaihyoshaJusho();
    }

    /**
     * 申請代表者電話番号を返します。
     *
     * @return 申請代表者電話番号
     */
    public TelNo get申請代表者電話番号() {
        return entity.getShinseiDaihyoshaTelNo();
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
     * 資格喪失年月日を返します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失事由を返します。
     *
     * @return 資格喪失事由
     */
    public RString get資格喪失事由() {
        return entity.getShikakuSoshitsuJiyu();
    }

    /**
     * 加入期間開始年月日を返します。
     *
     * @return 加入期間開始年月日
     */
    public FlexibleDate get加入期間開始年月日() {
        return entity.getKanyuKaishiYMD();
    }

    /**
     * 加入期間終了年月日を返します。
     *
     * @return 加入期間終了年月日
     */
    public FlexibleDate get加入期間終了年月日() {
        return entity.getKanyuShuryoYMD();
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
     * 国保保険者名称を返します。
     *
     * @return 国保保険者名称
     */
    public RString get国保保険者名称() {
        return entity.getKokuho_HokenshaMeisho();
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
     * 国保被保険者証番号を返します。
     *
     * @return 国保被保険者証番号
     */
    public RString get国保被保険者証番号() {
        return entity.getKokuho_HihokenshaShoNo();
    }

    /**
     * 国保世帯番号を返します。
     *
     * @return 国保世帯番号
     */
    public RString get国保世帯番号() {
        return entity.getKokuho_SetaiNo();
    }

    /**
     * 国保続柄を返します。
     *
     * @return 国保続柄
     */
    public RString get国保続柄() {
        return entity.getKokuho_Zokugara();
    }

    /**
     * 国保加入期間開始年月日を返します。
     *
     * @return 国保加入期間開始年月日
     */
    public FlexibleDate get国保加入期間開始年月日() {
        return entity.getKokuho_KanyuKaishiYMD();
    }

    /**
     * 国保加入期間終了年月日を返します。
     *
     * @return 国保加入期間終了年月日
     */
    public FlexibleDate get国保加入期間終了年月日() {
        return entity.getKokuho_KanyuShuryoYMD();
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
     * 後期広域連合名称を返します。
     *
     * @return 後期広域連合名称
     */
    public RString get後期広域連合名称() {
        return entity.getKoki_KoikiRengoMeisho();
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
     * 後期加入期間開始年月日を返します。
     *
     * @return 後期加入期間開始年月日
     */
    public FlexibleDate get後期加入期間開始年月日() {
        return entity.getKoki_KanyuKaishiYMD();
    }

    /**
     * 後期加入期間終了年月日を返します。
     *
     * @return 後期加入期間終了年月日
     */
    public FlexibleDate get後期加入期間終了年月日() {
        return entity.getKoki_KanyuShuryoYMD();
    }

    /**
     * 支払方法区分を返します。
     *
     * @return 支払方法区分
     */
    public RString get支払方法区分() {
        return entity.getShiharaiHohoKubun();
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
        return entity.getShiharaiKaishiYMD();
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
     * 支給申請書情報送付年月を返します。
     *
     * @return 支給申請書情報送付年月
     */
    public FlexibleYearMonth get支給申請書情報送付年月() {
        return entity.getShikyuShinseisho_SofuYM();
    }

    /**
     * 再送フラグを返します。
     *
     * @return 再送フラグ
     */
    public RString get再送フラグ() {
        return entity.getSaiSofuFlag();
    }

    /**
     * 自己負担額計算年月を返します。
     *
     * @return 自己負担額計算年月
     */
    public FlexibleYearMonth get自己負担額計算年月() {
        return entity.getJikoFutan_KeisanYM();
    }

    /**
     * 再計算区分を返します。
     *
     * @return 再計算区分
     */
    public RString get再計算区分() {
        return entity.getSaiKeisanKubun();
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
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    public void set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
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
     * 申請状況区分を設定します。
     *
     * @param 申請状況区分 申請状況区分
     */
    public void set申請状況区分(RString 申請状況区分) {
        requireNonNull(申請状況区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請状況区分"));
        entity.setShinseiJokyoKubun(申請状況区分);
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
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     */
    public void set支給申請書整理番号(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
    }

    /**
     * 国保支給申請書整理番号を設定します。
     *
     * @param 国保支給申請書整理番号 国保支給申請書整理番号
     */
    public void set国保支給申請書整理番号(RString 国保支給申請書整理番号) {
        requireNonNull(国保支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保支給申請書整理番号"));
        entity.setKokuhoShikyuShinseishoSeiriNo(国保支給申請書整理番号);
    }

    /**
     * 支給申請区分を設定します。
     *
     * @param 支給申請区分 支給申請区分
     */
    public void set支給申請区分(RString 支給申請区分) {
        requireNonNull(支給申請区分, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請区分"));
        entity.setShikyuShinseiKubun(支給申請区分);
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
     * 支給申請形態を設定します。
     *
     * @param 支給申請形態 支給申請形態
     */
    public void set支給申請形態(RString 支給申請形態) {
        requireNonNull(支給申請形態, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請形態"));
        entity.setShikyuShinseiKeitai(支給申請形態);
    }

    /**
     * 自己負担額証明書交付申請の有無を設定します。
     *
     * @param 自己負担額証明書交付申請の有無 自己負担額証明書交付申請の有無
     */
    public void set自己負担額証明書交付申請の有無(RString 自己負担額証明書交付申請の有無) {
        requireNonNull(自己負担額証明書交付申請の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書交付申請の有無"));
        entity.setJikoFutanKofuUmu(自己負担額証明書交付申請の有無);
    }

    /**
     * 申請代表者氏名を設定します。
     *
     * @param 申請代表者氏名 申請代表者氏名
     */
    public void set申請代表者氏名(AtenaMeisho 申請代表者氏名) {
        requireNonNull(申請代表者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("申請代表者氏名"));
        entity.setShinseiDaihyoshaShimei(申請代表者氏名);
    }

    /**
     * 申請代表者郵便番号を設定します。
     *
     * @param 申請代表者郵便番号 申請代表者郵便番号
     */
    public void set申請代表者郵便番号(YubinNo 申請代表者郵便番号) {
        requireNonNull(申請代表者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請代表者郵便番号"));
        entity.setShinseiDaihyoshaYubinNo(申請代表者郵便番号);
    }

    /**
     * 申請代表者住所を設定します。
     *
     * @param 申請代表者住所 申請代表者住所
     */
    public void set申請代表者住所(RString 申請代表者住所) {
        requireNonNull(申請代表者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請代表者住所"));
        entity.setShinseiDaihyoshaJusho(申請代表者住所);
    }

    /**
     * 申請代表者電話番号を設定します。
     *
     * @param 申請代表者電話番号 申請代表者電話番号
     */
    public void set申請代表者電話番号(TelNo 申請代表者電話番号) {
        requireNonNull(申請代表者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請代表者電話番号"));
        entity.setShinseiDaihyoshaTelNo(申請代表者電話番号);
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
     * 資格喪失年月日を設定します。
     *
     * @param 資格喪失年月日 資格喪失年月日
     */
    public void set資格喪失年月日(FlexibleDate 資格喪失年月日) {
        requireNonNull(資格喪失年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失年月日"));
        entity.setShikakuSoshitsuYMD(資格喪失年月日);
    }

    /**
     * 資格喪失事由を設定します。
     *
     * @param 資格喪失事由 資格喪失事由
     */
    public void set資格喪失事由(RString 資格喪失事由) {
        requireNonNull(資格喪失事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失事由"));
        entity.setShikakuSoshitsuJiyu(資格喪失事由);
    }

    /**
     * 加入期間開始年月日を設定します。
     *
     * @param 加入期間開始年月日 加入期間開始年月日
     */
    public void set加入期間開始年月日(FlexibleDate 加入期間開始年月日) {
        requireNonNull(加入期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("加入期間開始年月日"));
        entity.setKanyuKaishiYMD(加入期間開始年月日);
    }

    /**
     * 加入期間終了年月日を設定します。
     *
     * @param 加入期間終了年月日 加入期間終了年月日
     */
    public void set加入期間終了年月日(FlexibleDate 加入期間終了年月日) {
        requireNonNull(加入期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("加入期間終了年月日"));
        entity.setKanyuShuryoYMD(加入期間終了年月日);
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
     * 国保保険者名称を設定します。
     *
     * @param 国保保険者名称 国保保険者名称
     */
    public void set国保保険者名称(RString 国保保険者名称) {
        requireNonNull(国保保険者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("国保保険者名称"));
        entity.setKokuho_HokenshaMeisho(国保保険者名称);
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
     * 国保被保険者証番号を設定します。
     *
     * @param 国保被保険者証番号 国保被保険者証番号
     */
    public void set国保被保険者証番号(RString 国保被保険者証番号) {
        requireNonNull(国保被保険者証番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保被保険者証番号"));
        entity.setKokuho_HihokenshaShoNo(国保被保険者証番号);
    }

    /**
     * 国保世帯番号を設定します。
     *
     * @param 国保世帯番号 国保世帯番号
     */
    public void set国保世帯番号(RString 国保世帯番号) {
        requireNonNull(国保世帯番号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保世帯番号"));
        entity.setKokuho_SetaiNo(国保世帯番号);
    }

    /**
     * 国保続柄を設定します。
     *
     * @param 国保続柄 国保続柄
     */
    public void set国保続柄(RString 国保続柄) {
        requireNonNull(国保続柄, UrSystemErrorMessages.値がnull.getReplacedMessage("国保続柄"));
        entity.setKokuho_Zokugara(国保続柄);
    }

    /**
     * 国保加入期間開始年月日を設定します。
     *
     * @param 国保加入期間開始年月日 国保加入期間開始年月日
     */
    public void set国保加入期間開始年月日(FlexibleDate 国保加入期間開始年月日) {
        requireNonNull(国保加入期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("国保加入期間開始年月日"));
        entity.setKokuho_KanyuKaishiYMD(国保加入期間開始年月日);
    }

    /**
     * 国保加入期間終了年月日を設定します。
     *
     * @param 国保加入期間終了年月日 国保加入期間終了年月日
     */
    public void set国保加入期間終了年月日(FlexibleDate 国保加入期間終了年月日) {
        requireNonNull(国保加入期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("国保加入期間終了年月日"));
        entity.setKokuho_KanyuShuryoYMD(国保加入期間終了年月日);
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
     * 後期広域連合名称を設定します。
     *
     * @param 後期広域連合名称 後期広域連合名称
     */
    public void set後期広域連合名称(RString 後期広域連合名称) {
        requireNonNull(後期広域連合名称, UrSystemErrorMessages.値がnull.getReplacedMessage("後期広域連合名称"));
        entity.setKoki_KoikiRengoMeisho(後期広域連合名称);
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
     * 後期加入期間開始年月日を設定します。
     *
     * @param 後期加入期間開始年月日 後期加入期間開始年月日
     */
    public void set後期加入期間開始年月日(FlexibleDate 後期加入期間開始年月日) {
        requireNonNull(後期加入期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("後期加入期間開始年月日"));
        entity.setKoki_KanyuKaishiYMD(後期加入期間開始年月日);
    }

    /**
     * 後期加入期間終了年月日を設定します。
     *
     * @param 後期加入期間終了年月日 後期加入期間終了年月日
     */
    public void set後期加入期間終了年月日(FlexibleDate 後期加入期間終了年月日) {
        requireNonNull(後期加入期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("後期加入期間終了年月日"));
        entity.setKoki_KanyuShuryoYMD(後期加入期間終了年月日);
    }

    /**
     * 支払方法区分を設定します。
     *
     * @param 支払方法区分 支払方法区分
     */
    public void set支払方法区分(RString 支払方法区分) {
        requireNonNull(支払方法区分, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法区分"));
        entity.setShiharaiHohoKubun(支払方法区分);
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
        entity.setShiharaiKaishiYMD(支払期間開始年月日);
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
     * 支給申請書情報送付年月を設定します。
     *
     * @param 支給申請書情報送付年月 支給申請書情報送付年月
     */
    public void set支給申請書情報送付年月(FlexibleYearMonth 支給申請書情報送付年月) {
        requireNonNull(支給申請書情報送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書情報送付年月"));
        entity.setShikyuShinseisho_SofuYM(支給申請書情報送付年月);
    }

    /**
     * 再送フラグを設定します。
     *
     * @param 再送フラグ 再送フラグ
     */
    public void set再送フラグ(RString 再送フラグ) {
        requireNonNull(再送フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("再送フラグ"));
        entity.setSaiSofuFlag(再送フラグ);
    }

    /**
     * 自己負担額計算年月を設定します。
     *
     * @param 自己負担額計算年月 自己負担額計算年月
     */
    public void set自己負担額計算年月(FlexibleYearMonth 自己負担額計算年月) {
        requireNonNull(自己負担額計算年月, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額計算年月"));
        entity.setJikoFutan_KeisanYM(自己負担額計算年月);
    }

    /**
     * 再計算区分を設定します。
     *
     * @param 再計算区分 再計算区分
     */
    public void set再計算区分(RString 再計算区分) {
        requireNonNull(再計算区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再計算区分"));
        entity.setSaiKeisanKubun(再計算区分);
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
