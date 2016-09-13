/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
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
 * {@link KogakuGassanShinseisho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-012 huzongcheng
 */
public class KogakuGassanShinseishoBuilder {

    private final DbT3068KogakuGassanShinseishoEntity entity;
    private final KogakuGassanShinseishoIdentifier id;

    /**
     * {@link DbT3068KogakuGassanShinseishoEntity}より{@link KogakuGassanShinseisho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3068KogakuGassanShinseishoEntity}
     * @param id {@link KogakuGassanShinseishoIdentifier}
     *
     */
    KogakuGassanShinseishoBuilder(
            DbT3068KogakuGassanShinseishoEntity entity,
            KogakuGassanShinseishoIdentifier id
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
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set対象年度(FlexibleYear 対象年度) {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        entity.setTaishoNendo(対象年度);
        return this;
    }

    /**
     * 保険者番号を設定します。
     *
     * @param 保険者番号 保険者番号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set保険者番号(HokenshaNo 保険者番号) {
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        entity.setHokenshaNo(保険者番号);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 申請状況区分を設定します。
     *
     * @param 申請状況区分 申請状況区分
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set申請状況区分(RString 申請状況区分) {
        entity.setShinseiJokyoKubun(申請状況区分);
        return this;
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set申請年月日(FlexibleDate 申請年月日) {
        entity.setShinseiYMD(申請年月日);
        return this;
    }

    /**
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set支給申請書整理番号(RString 支給申請書整理番号) {
        entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        return this;
    }

    /**
     * 国保支給申請書整理番号を設定します。
     *
     * @param 国保支給申請書整理番号 国保支給申請書整理番号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set国保支給申請書整理番号(RString 国保支給申請書整理番号) {
        entity.setKokuhoShikyuShinseishoSeiriNo(国保支給申請書整理番号);
        return this;
    }

    /**
     * 支給申請区分を設定します。
     *
     * @param 支給申請区分 支給申請区分
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set支給申請区分(RString 支給申請区分) {
        entity.setShikyuShinseiKubun(支給申請区分);
        return this;
    }

    /**
     * 対象計算期間開始年月日を設定します。
     *
     * @param 対象計算期間開始年月日 対象計算期間開始年月日
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set対象計算期間開始年月日(FlexibleDate 対象計算期間開始年月日) {
        entity.setTaishoKeisanKaishiYMD(対象計算期間開始年月日);
        return this;
    }

    /**
     * 対象計算期間終了年月日を設定します。
     *
     * @param 対象計算期間終了年月日 対象計算期間終了年月日
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set対象計算期間終了年月日(FlexibleDate 対象計算期間終了年月日) {
        entity.setTaishoKeisanShuryoYMD(対象計算期間終了年月日);
        return this;
    }

    /**
     * 支給申請形態を設定します。
     *
     * @param 支給申請形態 支給申請形態
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set支給申請形態(RString 支給申請形態) {
        entity.setShikyuShinseiKeitai(支給申請形態);
        return this;
    }

    /**
     * 自己負担額証明書交付申請の有無を設定します。
     *
     * @param 自己負担額証明書交付申請の有無 自己負担額証明書交付申請の有無
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set自己負担額証明書交付申請の有無(RString 自己負担額証明書交付申請の有無) {
        entity.setJikoFutanKofuUmu(自己負担額証明書交付申請の有無);
        return this;
    }

    /**
     * 申請代表者氏名を設定します。
     *
     * @param 申請代表者氏名 申請代表者氏名
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set申請代表者氏名(AtenaMeisho 申請代表者氏名) {
        entity.setShinseiDaihyoshaShimei(申請代表者氏名);
        return this;
    }

    /**
     * 申請代表者郵便番号を設定します。
     *
     * @param 申請代表者郵便番号 申請代表者郵便番号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set申請代表者郵便番号(YubinNo 申請代表者郵便番号) {
        entity.setShinseiDaihyoshaYubinNo(申請代表者郵便番号);
        return this;
    }

    /**
     * 申請代表者住所を設定します。
     *
     * @param 申請代表者住所 申請代表者住所
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set申請代表者住所(RString 申請代表者住所) {
        entity.setShinseiDaihyoshaJusho(申請代表者住所);
        return this;
    }

    /**
     * 申請代表者電話番号を設定します。
     *
     * @param 申請代表者電話番号 申請代表者電話番号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set申請代表者電話番号(TelNo 申請代表者電話番号) {
        entity.setShinseiDaihyoshaTelNo(申請代表者電話番号);
        return this;
    }

    /**
     * 所得区分を設定します。
     *
     * @param 所得区分 所得区分
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set所得区分(RString 所得区分) {
        entity.setShotokuKubun(所得区分);
        return this;
    }

    /**
     * 70歳以上の者に係る所得区分を設定します。
     *
     * @param 所得区分_70歳以上の者に係る 70歳以上の者に係る所得区分
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set所得区分_70歳以上の者に係る(RString 所得区分_70歳以上の者に係る) {
        entity.setOver70_ShotokuKubun(所得区分_70歳以上の者に係る);
        return this;
    }

    /**
     * 資格喪失年月日を設定します。
     *
     * @param 資格喪失年月日 資格喪失年月日
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set資格喪失年月日(FlexibleDate 資格喪失年月日) {
        entity.setShikakuSoshitsuYMD(資格喪失年月日);
        return this;
    }

    /**
     * 資格喪失事由を設定します。
     *
     * @param 資格喪失事由 資格喪失事由
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set資格喪失事由(RString 資格喪失事由) {
        entity.setShikakuSoshitsuJiyu(資格喪失事由);
        return this;
    }

    /**
     * 加入期間開始年月日を設定します。
     *
     * @param 加入期間開始年月日 加入期間開始年月日
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set加入期間開始年月日(FlexibleDate 加入期間開始年月日) {
        entity.setKanyuKaishiYMD(加入期間開始年月日);
        return this;
    }

    /**
     * 加入期間終了年月日を設定します。
     *
     * @param 加入期間終了年月日 加入期間終了年月日
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set加入期間終了年月日(FlexibleDate 加入期間終了年月日) {
        entity.setKanyuShuryoYMD(加入期間終了年月日);
        return this;
    }

    /**
     * 国保保険者番号を設定します。
     *
     * @param 国保保険者番号 国保保険者番号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set国保保険者番号(RString 国保保険者番号) {
        entity.setKokuho_HokenshaNo(国保保険者番号);
        return this;
    }

    /**
     * 国保保険者名称を設定します。
     *
     * @param 国保保険者名称 国保保険者名称
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set国保保険者名称(RString 国保保険者名称) {
        entity.setKokuho_HokenshaMeisho(国保保険者名称);
        return this;
    }

    /**
     * 国保被保険者証記号を設定します。
     *
     * @param 国保被保険者証記号 国保被保険者証記号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set国保被保険者証記号(RString 国保被保険者証記号) {
        entity.setKokuho_HihokenshaShoKigo(国保被保険者証記号);
        return this;
    }

    /**
     * 国保被保険者証番号を設定します。
     *
     * @param 国保被保険者証番号 国保被保険者証番号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set国保被保険者証番号(RString 国保被保険者証番号) {
        entity.setKokuho_HihokenshaShoNo(国保被保険者証番号);
        return this;
    }

    /**
     * 国保世帯番号を設定します。
     *
     * @param 国保世帯番号 国保世帯番号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set国保世帯番号(RString 国保世帯番号) {
        entity.setKokuho_SetaiNo(国保世帯番号);
        return this;
    }

    /**
     * 国保続柄を設定します。
     *
     * @param 国保続柄 国保続柄
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set国保続柄(RString 国保続柄) {
        entity.setKokuho_Zokugara(国保続柄);
        return this;
    }

    /**
     * 国保加入期間開始年月日を設定します。
     *
     * @param 国保加入期間開始年月日 国保加入期間開始年月日
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set国保加入期間開始年月日(FlexibleDate 国保加入期間開始年月日) {
        entity.setKokuho_KanyuKaishiYMD(国保加入期間開始年月日);
        return this;
    }

    /**
     * 国保加入期間終了年月日を設定します。
     *
     * @param 国保加入期間終了年月日 国保加入期間終了年月日
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set国保加入期間終了年月日(FlexibleDate 国保加入期間終了年月日) {
        entity.setKokuho_KanyuShuryoYMD(国保加入期間終了年月日);
        return this;
    }

    /**
     * 後期保険者番号を設定します。
     *
     * @param 後期保険者番号 後期保険者番号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set後期保険者番号(RString 後期保険者番号) {
        entity.setKoki_HokenshaNo(後期保険者番号);
        return this;
    }

    /**
     * 後期広域連合名称を設定します。
     *
     * @param 後期広域連合名称 後期広域連合名称
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set後期広域連合名称(RString 後期広域連合名称) {
        entity.setKoki_KoikiRengoMeisho(後期広域連合名称);
        return this;
    }

    /**
     * 後期被保険者番号を設定します。
     *
     * @param 後期被保険者番号 後期被保険者番号
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set後期被保険者番号(RString 後期被保険者番号) {
        entity.setKoki_HihokenshaNo(後期被保険者番号);
        return this;
    }

    /**
     * 後期加入期間開始年月日を設定します。
     *
     * @param 後期加入期間開始年月日 後期加入期間開始年月日
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set後期加入期間開始年月日(FlexibleDate 後期加入期間開始年月日) {
        entity.setKoki_KanyuKaishiYMD(後期加入期間開始年月日);
        return this;
    }

    /**
     * 後期加入期間終了年月日を設定します。
     *
     * @param 後期加入期間終了年月日 後期加入期間終了年月日
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set後期加入期間終了年月日(FlexibleDate 後期加入期間終了年月日) {
        entity.setKoki_KanyuShuryoYMD(後期加入期間終了年月日);
        return this;
    }

    /**
     * 支払方法区分を設定します。
     *
     * @param 支払方法区分 支払方法区分
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set支払方法区分(RString 支払方法区分) {
        entity.setShiharaiHohoKubun(支払方法区分);
        return this;
    }

    /**
     * 支払場所を設定します。
     *
     * @param 支払場所 支払場所
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set支払場所(RString 支払場所) {
        entity.setShiharaiBasho(支払場所);
        return this;
    }

    /**
     * 支払期間開始年月日を設定します。
     *
     * @param 支払期間開始年月日 支払期間開始年月日
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set支払期間開始年月日(FlexibleDate 支払期間開始年月日) {
        entity.setShiharaiKaishiYMD(支払期間開始年月日);
        return this;
    }

    /**
     * 支払期間終了年月日を設定します。
     *
     * @param 支払期間終了年月日 支払期間終了年月日
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set支払期間終了年月日(FlexibleDate 支払期間終了年月日) {
        entity.setShiharaiShuryoYMD(支払期間終了年月日);
        return this;
    }

    /**
     * 閉庁内容を設定します。
     *
     * @param 閉庁内容 閉庁内容
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set閉庁内容(RString 閉庁内容) {
        entity.setHeichoNaiyo(閉庁内容);
        return this;
    }

    /**
     * 支払期間開始時間を設定します。
     *
     * @param 支払期間開始時間 支払期間開始時間
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set支払期間開始時間(RString 支払期間開始時間) {
        entity.setShiharaiKaishiTime(支払期間開始時間);
        return this;
    }

    /**
     * 支払期間終了時間を設定します。
     *
     * @param 支払期間終了時間 支払期間終了時間
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set支払期間終了時間(RString 支払期間終了時間) {
        entity.setShiharaiShuryoTime(支払期間終了時間);
        return this;
    }

    /**
     * 口座IDを設定します。
     *
     * @param 口座ID 口座ID
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set口座ID(long 口座ID) {
        entity.setKozaID(口座ID);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set備考(RString 備考) {
        entity.setBiko(備考);
        return this;
    }

    /**
     * 支給申請書情報送付年月を設定します。
     *
     * @param 支給申請書情報送付年月 支給申請書情報送付年月
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set支給申請書情報送付年月(FlexibleYearMonth 支給申請書情報送付年月) {
        entity.setShikyuShinseisho_SofuYM(支給申請書情報送付年月);
        return this;
    }

    /**
     * 再送フラグを設定します。
     *
     * @param 再送フラグ 再送フラグ
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set再送フラグ(RString 再送フラグ) {
        entity.setSaiSofuFlag(再送フラグ);
        return this;
    }

    /**
     * 自己負担額計算年月を設定します。
     *
     * @param 自己負担額計算年月 自己負担額計算年月
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set自己負担額計算年月(FlexibleYearMonth 自己負担額計算年月) {
        entity.setJikoFutan_KeisanYM(自己負担額計算年月);
        return this;
    }

    /**
     * 再計算区分を設定します。
     *
     * @param 再計算区分 再計算区分
     * @return {@link KogakuGassanShinseishoBuilder}
     */
    public KogakuGassanShinseishoBuilder set再計算区分(RString 再計算区分) {
        entity.setSaiKeisanKubun(再計算区分);
        return this;
    }

    /**
     * {@link KogakuGassanShinseisho}のインスタンスを生成します。
     *
     * @return {@link KogakuGassanShinseisho}のインスタンス
     */
    public KogakuGassanShinseisho build() {
        return new KogakuGassanShinseisho(entity, id);
    }
}
