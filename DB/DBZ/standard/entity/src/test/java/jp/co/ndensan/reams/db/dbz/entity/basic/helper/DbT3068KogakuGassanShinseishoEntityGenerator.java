/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算申請書エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3068KogakuGassanShinseishoEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYear DEFAULT_対象年度 = new FlexibleYear("2014");
    public static final HokenshaNo DEFAULT_保険者番号 = new HokenshaNo(new RString("2"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_申請状況区分 = new RString("1");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_支給申請書整理番号 = new RString("1");
    public static final RString DEFAULT_国保支給申請書整理番号 = new RString("1");
    public static final RString DEFAULT_支給申請区分 = new RString("1");
    public static final FlexibleDate DEFAULT_対象計算期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_対象計算期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_支給申請形態 = new RString("1");
    public static final RString DEFAULT_自己負担額証明書交付申請の有無 = new RString("1");
    public static final AtenaMeisho DEFAULT_申請代表者氏名 = new AtenaMeisho("電算太郎");
    public static final YubinNo DEFAULT_申請代表者郵便番号 = new YubinNo(new RString("123-1234"));
    public static final RString DEFAULT_申請代表者住所 = new RString("1");
    public static final TelNo DEFAULT_申請代表者電話番号 = new TelNo("012-345-6789");
    public static final RString DEFAULT_所得区分 = new RString("1");
    public static final RString DEFAULT_70歳以上の者に係る所得区分 = new RString("1");
    public static final FlexibleDate DEFAULT_資格喪失年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_資格喪失事由 = new RString("1");
    public static final FlexibleDate DEFAULT_加入期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_加入期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_国保保険者番号 = new RString("1");
    public static final RString DEFAULT_国保保険者名称 = new RString("1");
    public static final RString DEFAULT_国保被保険者証記号 = new RString("1");
    public static final RString DEFAULT_国保被保険者証番号 = new RString("1");
    public static final RString DEFAULT_国保世帯番号 = new RString("1");
    public static final RString DEFAULT_国保続柄 = new RString("1");
    public static final FlexibleDate DEFAULT_国保加入期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_国保加入期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_後期保険者番号 = new RString("1");
    public static final RString DEFAULT_後期広域連合名称 = new RString("1");
    public static final RString DEFAULT_後期被保険者番号 = new RString("1");
    public static final FlexibleDate DEFAULT_後期加入期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_後期加入期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_支払方法区分 = new RString("1");
    public static final RString DEFAULT_支払場所 = new RString("1");
    public static final FlexibleDate DEFAULT_支払期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_支払期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_閉庁内容 = new RString("1");
    public static final RString DEFAULT_支払期間開始時間 = new RString("1");
    public static final RString DEFAULT_支払期間終了時間 = new RString("1");
    public static final RString DEFAULT_備考 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_支給申請書情報送付年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_再送フラグ = new RString("1");
    public static final FlexibleYearMonth DEFAULT_自己負担額計算年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_再計算区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3068KogakuGassanShinseishoEntityGenerator() {
    }

    public static DbT3068KogakuGassanShinseishoEntity createDbT3068KogakuGassanShinseishoEntity() {
        DbT3068KogakuGassanShinseishoEntity entity = new DbT3068KogakuGassanShinseishoEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoNendo(DEFAULT_対象年度);
        entity.setHokenshaNo(DEFAULT_保険者番号);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShinseiJokyoKubun(DEFAULT_申請状況区分);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setShikyuShinseishoSeiriNo(DEFAULT_支給申請書整理番号);
        entity.setKokuhoShikyuShinseishoSeiriNo(DEFAULT_国保支給申請書整理番号);
        entity.setShikyuShinseiKubun(DEFAULT_支給申請区分);
        entity.setTaishoKeisanKaishiYMD(DEFAULT_対象計算期間開始年月日);
        entity.setTaishoKeisanShuryoYMD(DEFAULT_対象計算期間終了年月日);
        entity.setShikyuShinseiKeitai(DEFAULT_支給申請形態);
        entity.setJikoFutanKofuUmu(DEFAULT_自己負担額証明書交付申請の有無);
        entity.setShinseiDaihyoshaShimei(DEFAULT_申請代表者氏名);
        entity.setShinseiDaihyoshaYubinNo(DEFAULT_申請代表者郵便番号);
        entity.setShinseiDaihyoshaJusho(DEFAULT_申請代表者住所);
        entity.setShinseiDaihyoshaTelNo(DEFAULT_申請代表者電話番号);
        entity.setShotokuKubun(DEFAULT_所得区分);
        entity.setOver70_ShotokuKubun(DEFAULT_70歳以上の者に係る所得区分);
        entity.setShikakuSoshitsuYMD(DEFAULT_資格喪失年月日);
        entity.setShikakuSoshitsuJiyu(DEFAULT_資格喪失事由);
        entity.setKanyuKaishiYMD(DEFAULT_加入期間開始年月日);
        entity.setKanyuShuryoYMD(DEFAULT_加入期間終了年月日);
        entity.setKokuho_HokenshaNo(DEFAULT_国保保険者番号);
        entity.setKokuho_HokenshaMeisho(DEFAULT_国保保険者名称);
        entity.setKokuho_HihokenshaShoKigo(DEFAULT_国保被保険者証記号);
        entity.setKokuho_HihokenshaShoNo(DEFAULT_国保被保険者証番号);
        entity.setKokuho_SetaiNo(DEFAULT_国保世帯番号);
        entity.setKokuho_Zokugara(DEFAULT_国保続柄);
        entity.setKokuho_KanyuKaishiYMD(DEFAULT_国保加入期間開始年月日);
        entity.setKokuho_KanyuShuryoYMD(DEFAULT_国保加入期間終了年月日);
        entity.setKoki_HokenshaNo(DEFAULT_後期保険者番号);
        entity.setKoki_KoikiRengoMeisho(DEFAULT_後期広域連合名称);
        entity.setKoki_HihokenshaNo(DEFAULT_後期被保険者番号);
        entity.setKoki_KanyuKaishiYMD(DEFAULT_後期加入期間開始年月日);
        entity.setKoki_KanyuShuryoYMD(DEFAULT_後期加入期間終了年月日);
        entity.setShiharaiHohoKubun(DEFAULT_支払方法区分);
        entity.setShiharaiBasho(DEFAULT_支払場所);
        entity.setShiharaiKaishiYMD(DEFAULT_支払期間開始年月日);
        entity.setShiharaiShuryoYMD(DEFAULT_支払期間終了年月日);
        entity.setHeichoNaiyo(DEFAULT_閉庁内容);
        entity.setShiharaiKaishiTime(DEFAULT_支払期間開始時間);
        entity.setShiharaiShuryoTime(DEFAULT_支払期間終了時間);
        entity.setBiko(DEFAULT_備考);
        entity.setShikyuShinseisho_SofuYM(DEFAULT_支給申請書情報送付年月);
        entity.setSaiSofuFlag(DEFAULT_再送フラグ);
        entity.setJikoFutan_KeisanYM(DEFAULT_自己負担額計算年月);
        entity.setSaiKeisanKubun(DEFAULT_再計算区分);
        return entity;
    }
}
