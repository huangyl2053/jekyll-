/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shoukanbaraishikyuketteitsuchisho;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho.KyufuSHurui;
import jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuketteiTsuuchisho;
import jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuketteiTsuuchishoOutputEntity;
import jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho.ZougenFushikyuRiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shoukanbaraishikyuketteitsuchisho.HihokenshaJyohoTaishoPSMFuka;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3043ShokanShokujiHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3045ShokanServicePlan200004Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3046ShokanServicePlan200604Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3047ShokanServicePlan200904Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shoukanbaraishikyuketteitsuchisho.IShoukanbaraiShikyuKetteiTsuchishoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4024ShiharaiHohoHenkoSashitomeDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.koza.IKozaManager;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMN12028_償還払い支給（不支給）決定通知書作成（単）のビジネス
 *
 * @reamsid_L DBC-5310-030 jinge
 */
public class ShoukanbaraiShikyuKetteiTsuchisho {

    private final DbT1001HihokenshaDaichoDac dbT1001dac;
    private final DbT4024ShiharaiHohoHenkoSashitomeDac dbT4024dac;
    private final DbT7130KaigoServiceShuruiDac dbT7130dac;
    private final DbT3053ShokanShukeiDac dbT3053dac;
    private final DbT3045ShokanServicePlan200004Dac dbT3045dac;
    private final DbT3046ShokanServicePlan200604Dac dbT3046dac;
    private final DbT3047ShokanServicePlan200904Dac dbT3047dac;
    private final DbT3043ShokanShokujiHiyoDac dbT3043dac;
    private final DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac dbT3050dac;
    private final MapperProvider mapperProvider;
    private static final RString あり = new RString("0");
    private static final RString なし = new RString("1");
    private static final ServiceShuruiCode 固定 = new ServiceShuruiCode("50");
    private static final ServiceShuruiCode 固定77 = new ServiceShuruiCode("77");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_10 = 10;
    private static final int NUM_12 = 12;
    private static final RString 間 = new RString("、");
    private static final RString その他 = new RString(" その他");
    private static final RString ワークの文言 = new RString(" 滞納保険料への控除が行われました");
    private static final int NUM_17 = 17;
    private static final int NUM_21 = 21;
    private static final int NUM_38 = 38;
    private static final int NUM_76 = 76;
    private static final int NUM_114 = 114;
    private static final RString ゼロ = new RString("0");
    private static final RString 支給 = ShikyuFushikyuKubun.支給.getコード();
    private static final RString 不支給 = ShikyuFushikyuKubun.不支給.getコード();
    private static final RString 窓口払 = ShiharaiHohoKubun.窓口払.getコード();
    private static final RString 口座払 = ShiharaiHohoKubun.口座払.getコード();
    private static final RString 一 = new RString("1");
    private static final ReportId 通知文情報帳票ID = new ReportId("DBC100002_ShokanKetteiTsuchiSho");
    private static final RString 項目名_取り消し線 = new RString("取り消し線");
    private static final RString 項目名_帳票タイトル = new RString("帳票タイトル");
    private static final RString 項目名_ゆうちょ銀行店名表示 = new RString("ゆうちょ銀行店名表示");
    private static final RString 項目名_帳票タイトル_抹消線あり１ = new RString("帳票タイトル_抹消線あり１");
    private static final RString 項目名_帳票タイトル_抹消線あり２ = new RString("帳票タイトル_抹消線あり２");
    private static final RString 項目名_帳票タイトル_抹消線あり３ = new RString("帳票タイトル_抹消線あり３");
    private static final RString 項目名_帳票タイトル_抹消線あり４ = new RString("帳票タイトル_抹消線あり４");
    private static final RString 帳票制御汎用キー_持ち物内容文言１ = new RString("持ち物内容文言１");
    private static final RString 帳票制御汎用キー_持ち物内容文言２ = new RString("持ち物内容文言２");
    private static final RString 帳票制御汎用キー_持ち物内容文言３ = new RString("持ち物内容文言３");
    private static final RString HOSHI_14 = new RString("**************");
    private static final RString 金融機関コード_郵便局 = new RString("9900");
    private static final RString 種別タイトル_口座種別 = new RString("口座種別");
    private static final RString 種別タイトル_店番 = new RString("店番");
    private static final RString 番号タイトル_口座番号 = new RString("口座番号");
    private static final RString KARA = new RString("～");
    private static final RString 午前 = new RString("午前");
    private static final RString 午後 = new RString("午後");
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString RSTRING_00 = new RString("00");
    private static final RString RSTRING_12 = new RString("12");
    private static final RString 複合型サービス = new RString("複合型サービス");
    private static final RString 看護小規模多機能型居宅介護 = new RString("看護小規模多機能型居宅介護");

    /**
     * コンストラクタです。
     */
    ShoukanbaraiShikyuKetteiTsuchisho() {
        this.dbT1001dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.dbT4024dac = InstanceProvider.create(DbT4024ShiharaiHohoHenkoSashitomeDac.class);
        this.dbT7130dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
        this.dbT3053dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.dbT3045dac = InstanceProvider.create(DbT3045ShokanServicePlan200004Dac.class);
        this.dbT3046dac = InstanceProvider.create(DbT3046ShokanServicePlan200604Dac.class);
        this.dbT3047dac = InstanceProvider.create(DbT3047ShokanServicePlan200904Dac.class);
        this.dbT3043dac = InstanceProvider.create(DbT3043ShokanShokujiHiyoDac.class);
        this.dbT3050dac = InstanceProvider.create(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * にて生成した{@link JukyushaTeiseiRenrakuhyoToroku}のインスタンスを返します。
     *
     * @return TokuchoHeijunkaKakutei
     */
    public static ShoukanbaraiShikyuKetteiTsuchisho createInstance() {
        return InstanceProvider.create(ShoukanbaraiShikyuKetteiTsuchisho.class);
    }

    /**
     * 被保険者情報検索のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     *
     * @return HihokenshaDaicho
     */
    public HihokenshaDaicho getShikaku(HihokenshaNo 被保険者番号) {
        DbT1001HihokenshaDaichoEntity hihokenshaEntity
                = dbT1001dac.select被保険者情報(被保険者番号);
        if (hihokenshaEntity == null) {
            return null;
        }
        return new HihokenshaDaicho(hihokenshaEntity);
    }

    /**
     * 支払方法変更差止検索のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     *
     * @return ShiharaiHohoHenkoSashitome
     */
    public ShiharaiHohoHenkoSashitome getSashitome(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        List<DbT4024ShiharaiHohoHenkoSashitomeEntity> entity = dbT4024dac.select支払方法変更差止(被保険者番号, サービス提供年月, 整理番号);
        if (entity.isEmpty()) {
            return null;
        }
        return new ShiharaiHohoHenkoSashitome(entity.get(NUM_0));
    }

    /**
     * 給付の種類設定です。
     *
     * @param 被保険者番号 被保険者番号
     * @param 整理番号 整理番号
     * @param 差額支給対象者区分 差額支給対象者区分
     * @param サービス提供年月 サービス提供年月
     *
     * @return {@link KyufuSHurui}
     */
    public KyufuSHurui getKyufuSHurui(HihokenshaNo 被保険者番号, RString 整理番号, FlexibleYearMonth サービス提供年月, RString 差額支給対象者区分) {
        List<DbT7130KaigoServiceShuruiEntity> dbt7130entitys = dbT7130dac.getサービス種類名称List(サービス提供年月);
        List<DbT3053ShokanShukeiEntity> dbt3053entitys = dbT3053dac.get給付の種類(被保険者番号, サービス提供年月, 整理番号);
        KyufuSHurui kyufuSHurui = new KyufuSHurui();
        List<DbT3043ShokanShokujiHiyoEntity> dbt3043entitys = dbT3043dac.select償還払請求食事費用(被保険者番号, サービス提供年月, 整理番号);
        List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> dbt3050entitys = dbT3050dac.select償還払請求特定入所者介護サービス費用(被保険者番号, サービス提供年月, 整理番号);
        int 償還計画費データ件数 = 0;
        int 償還集計データ件数 = 0;
        RString 給付の種類 = RString.EMPTY;
        RString 給付の種類Total = RString.EMPTY;
        if (!dbt3053entitys.isEmpty()) {
            for (DbT3053ShokanShukeiEntity entity3053 : dbt3053entitys) {
                if (固定77.equals(entity3053.getServiceShuruiCode())) {
                    給付の種類 = edit給付種類(サービス提供年月, 給付の種類);
                    償還集計データ件数++;
                }
                for (DbT7130KaigoServiceShuruiEntity entity7130 : dbt7130entitys) {
                    if (entity7130.getServiceShuruiCd().equals(entity3053.getServiceShuruiCode())) {
                        給付の種類 = edit給付の種類(entity7130.getServiceShuruiMeisho(), 給付の種類);
                        償還集計データ件数 = edit償還集計データ(給付の種類, 給付の種類Total, 償還集計データ件数);
                        給付の種類Total = 給付の種類;
                    }
                }
            }
        }
        給付の種類 = edit償還払請求サービス計画検索(dbt7130entitys, 被保険者番号, サービス提供年月, 整理番号, 給付の種類);
        if (!給付の種類.equals(給付の種類Total)) {
            償還計画費データ件数++;
        }
        if (!dbt3043entitys.isEmpty()) {
            for (DbT7130KaigoServiceShuruiEntity entity7130 : dbt7130entitys) {
                if (entity7130.getServiceShuruiCd().equals(固定)) {
                    給付の種類 = edit給付種類(entity7130.getServiceShuruiMeisho(), 給付の種類);
                }
            }
        }
        if (!dbt3050entitys.isEmpty()) {
            for (DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity3050 : dbt3050entitys) {
                for (DbT7130KaigoServiceShuruiEntity entity7130 : dbt7130entitys) {
                    if (entity7130.getServiceShuruiCd().equals(entity3050.getServiceShuruiCode())) {
                        給付の種類 = edit給付種類(entity7130.getServiceShuruiMeisho(), 給付の種類);
                    }
                }
            }
        }
        if (給付の種類.length() <= NUM_38) {
            kyufuSHurui.set給付の種類1(給付の種類);
        } else {
            kyufuSHurui.set給付の種類1(給付の種類.substring(0, NUM_38));
            if (給付の種類.length() <= NUM_76) {
                kyufuSHurui.set給付の種類2(給付の種類.substring(NUM_38, 給付の種類.length()));
            } else {
                kyufuSHurui.set給付の種類2(給付の種類.substring(NUM_38, NUM_76));
                kyufuSHurui.set給付の種類3(給付の種類.length() <= NUM_114
                        ? 給付の種類.substring(NUM_76, 給付の種類.length()) : 給付の種類.substring(NUM_76, NUM_114));
            }
        }
        if (差額支給対象者区分.equals(一)) {
            edit出力給付の種類(kyufuSHurui);
        }
        kyufuSHurui.set償還計画費データ件数(償還計画費データ件数);
        kyufuSHurui.set償還集計データ件数(償還集計データ件数);
        return kyufuSHurui;
    }

    private ZougenFushikyuRiyu getZougenFushikyuRiyu(HihokenshaNo 被保険者番号, RString 整理番号, FlexibleYearMonth サービス提供年月,
            RString 支給不支給決定区分, int 償還計画費データ件数, int 償還集計データ件数) {
        ZougenFushikyuRiyu zougenFushikyuRiyu = new ZougenFushikyuRiyu();
        RString 増減_不支給の理由 = RString.EMPTY;
        RString 増減理由 = RString.EMPTY;
        zougenFushikyuRiyu.set増減_不支給の理由1(RString.EMPTY);
        zougenFushikyuRiyu.set増減_不支給の理由2(RString.EMPTY);
        zougenFushikyuRiyu.set増減_不支給の理由3(RString.EMPTY);
        if (支給不支給決定区分.equals(一) && 償還計画費データ件数 > 0) {
            増減_不支給の理由 = edit増減_不支給の理由(被保険者番号, 整理番号, サービス提供年月);
            if (増減_不支給の理由.length() <= NUM_38) {
                zougenFushikyuRiyu.set増減_不支給の理由1(増減_不支給の理由.substring(0, 増減_不支給の理由.length()));
            } else {
                zougenFushikyuRiyu.set増減_不支給の理由1(増減_不支給の理由.substring(0, NUM_38));
                zougenFushikyuRiyu.set増減_不支給の理由2(増減_不支給の理由.substring(NUM_38, 増減_不支給の理由.length()));
            }
        }
        if (支給不支給決定区分.equals(一) && 償還集計データ件数 > 0) {
            List<DbT3053ShokanShukeiEntity> dbt3053entitys = dbT3053dac.select償還払請求集計(被保険者番号, サービス提供年月, 整理番号);
            if (!dbt3053entitys.isEmpty()) {
                RString 理由 = dbt3053entitys.get(0).getZougenRiyu();
                増減理由 = 理由 != null ? 増減理由.concat(理由) : 増減理由;
            }
            if (増減_不支給の理由.isEmpty()) {
                zougenFushikyuRiyu.set増減_不支給の理由1(増減理由);
            } else if (増減_不支給の理由.length() <= NUM_38) {
                zougenFushikyuRiyu.set増減_不支給の理由1(増減_不支給の理由);
                zougenFushikyuRiyu.set増減_不支給の理由2(増減理由);
            } else {
                zougenFushikyuRiyu.set増減_不支給の理由1(増減_不支給の理由.substring(0, NUM_38));
                zougenFushikyuRiyu.set増減_不支給の理由2(増減_不支給の理由.substring(NUM_38, 増減_不支給の理由.length()));
                zougenFushikyuRiyu.set増減_不支給の理由3(増減理由);
            }
        }
        if (支給不支給決定区分.equals(ゼロ) && 償還計画費データ件数 > 0) {
            増減_不支給の理由 = edit増減不支給の理由(被保険者番号, 整理番号, サービス提供年月);
            if (増減_不支給の理由.length() <= NUM_38) {
                zougenFushikyuRiyu.set増減_不支給の理由1(増減_不支給の理由.substring(0, 増減_不支給の理由.length()));
            } else {
                zougenFushikyuRiyu.set増減_不支給の理由1(増減_不支給の理由.substring(0, NUM_38));
                zougenFushikyuRiyu.set増減_不支給の理由2(増減_不支給の理由.substring(NUM_38, 増減_不支給の理由.length()));
            }
        }
        if (支給不支給決定区分.equals(ゼロ) && 償還集計データ件数 > 0) {
            List<DbT3053ShokanShukeiEntity> dbt3053entitys = dbT3053dac.select償還払請求集計(被保険者番号, サービス提供年月, 整理番号);
            if (!dbt3053entitys.isEmpty()) {
                RString 理由 = dbt3053entitys.get(0).getHushikyuRiyu();
                増減理由 = 理由 != null ? 増減理由.concat(理由) : 増減理由;
            }
            if (増減_不支給の理由.isEmpty()) {
                zougenFushikyuRiyu.set増減_不支給の理由1(増減理由);
            } else if (増減_不支給の理由.length() <= NUM_38) {
                zougenFushikyuRiyu.set増減_不支給の理由1(増減_不支給の理由);
                zougenFushikyuRiyu.set増減_不支給の理由2(増減理由);
            } else {
                zougenFushikyuRiyu.set増減_不支給の理由1(増減_不支給の理由.substring(0, NUM_38));
                zougenFushikyuRiyu.set増減_不支給の理由2(増減_不支給の理由.substring(NUM_38, 増減_不支給の理由.length()));
                zougenFushikyuRiyu.set増減_不支給の理由3(増減理由);
            }
        }
        return zougenFushikyuRiyu;

    }

    /**
     * 償還払支給決定情報取得です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 帳票ID 帳票ID
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 文書番号 文書番号
     * @param 発行日 発行日
     * @param 支払予定日 支払予定日
     * @param 口座ID 口座ID
     * @param 支給不支給決定区分 支給不支給決定区分
     * @param 差額支給対象者区分 差額支給対象者区分
     * @return {@link ShoukanbaraiShikyuketteiTsuuchishoOutputEntity}
     */
    public ShoukanbaraiShikyuketteiTsuuchishoOutputEntity editShoukanbaraiShikyuketteiTsuuchisho(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, ReportId 帳票ID, FlexibleYearMonth サービス提供年月, RString 整理番号,
            RString 文書番号, FlexibleDate 発行日, FlexibleDate 支払予定日, long 口座ID, RString 支給不支給決定区分, RString 差額支給対象者区分) {
        ShoukanbaraiShikyuketteiTsuuchishoOutputEntity target = new ShoukanbaraiShikyuketteiTsuuchishoOutputEntity();
        RString データ有無 = あり;
        IShikibetsuTaishoPSMSearchKey searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).
                setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード).
                set基準日(発行日).build();
        ShoukanbaraiShikyuKetteiTsuchishoParameter param = new ShoukanbaraiShikyuKetteiTsuchishoParameter(searchKey);
        param.setサービス提供年月(サービス提供年月);
        param.set整理番号(整理番号);
        param.set被保険者番号(被保険者番号);
        IShoukanbaraiShikyuKetteiTsuchishoMapper mapper = mapperProvider.create(IShoukanbaraiShikyuKetteiTsuchishoMapper.class);
        ShoukanbaraiShikyuEntity shoukanbaraiShikyuEntity = mapper.select償還払支給(param);
        HihokenshaJyohoTaishoPSMFuka hihokenshaJyohoTaishoPSMFuka = mapper.select被保険者宛名情報(param);
        ShoukanbaraiShikyuketteiTsuuchisho entity = new ShoukanbaraiShikyuketteiTsuuchisho();
        if (shoukanbaraiShikyuEntity == null) {
            target.setデータ有無(なし);
            return target;
        }
        if (hihokenshaJyohoTaishoPSMFuka != null && hihokenshaJyohoTaishoPSMFuka.getKanjiShimei() != null) {
            entity.set被保険者氏名(hihokenshaJyohoTaishoPSMFuka.getKanjiShimei().getColumnValue());
        }
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo 帳票制御汎用_ゆうちょ銀行店名表示
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_ゆうちょ銀行店名表示);
        setタイトル(entity, shoukanbaraiShikyuEntity);
        set通知文(entity);
        RString temp_被保険者番号 = 被保険者番号.value();
        temp_被保険者番号 = temp_被保険者番号.padRight(NUM_10);
        entity.set被保険者番号1(temp_被保険者番号.substring(NUM_0, NUM_1));
        entity.set被保険者番号2(temp_被保険者番号.substring(NUM_1, NUM_2));
        entity.set被保険者番号3(temp_被保険者番号.substring(NUM_2, NUM_3));
        entity.set被保険者番号4(temp_被保険者番号.substring(NUM_3, NUM_4));
        entity.set被保険者番号5(temp_被保険者番号.substring(NUM_4, NUM_5));
        entity.set被保険者番号6(temp_被保険者番号.substring(NUM_5, NUM_6));
        entity.set被保険者番号7(temp_被保険者番号.substring(NUM_6, NUM_7));
        entity.set被保険者番号8(temp_被保険者番号.substring(NUM_7, NUM_8));
        entity.set被保険者番号9(temp_被保険者番号.substring(NUM_8, NUM_9));
        entity.set被保険者番号10(temp_被保険者番号.substring(NUM_9));
        entity.setUketsukeYMD(shoukanbaraiShikyuEntity.get償還払支給申請().getUketsukeYMD());
        entity.setKetteiYMD(shoukanbaraiShikyuEntity.get償還払支給判定結果().getKetteiYMD());
        entity.setShiharaiKingakuRiyoshabun(shoukanbaraiShikyuEntity.get償還払支給申請().getShiharaiKingakuTotal());
        entity.setServiceTeikyoYM(shoukanbaraiShikyuEntity.get償還払支給判定結果().getServiceTeikyoYM());
        KyufuSHurui kyufuSHurui = getKyufuSHurui(被保険者番号, 整理番号, サービス提供年月, 差額支給対象者区分);
        entity.set給付の種類1(kyufuSHurui.get給付の種類1());
        entity.set給付の種類2(kyufuSHurui.get給付の種類2());
        entity.set給付の種類3(kyufuSHurui.get給付の種類3());
        entity.setShikyuHushikyuKetteiKubun(shoukanbaraiShikyuEntity.get償還払支給判定結果().getShikyuHushikyuKetteiKubun());
        entity.setShiharaiKingaku(shoukanbaraiShikyuEntity.get償還払支給判定結果().getShiharaiKingaku());
        RString shikyuHushikyuKetteiKubun = shoukanbaraiShikyuEntity.get償還払支給判定結果().getShikyuHushikyuKetteiKubun();
        if (支給.equals(shikyuHushikyuKetteiKubun)) {
            entity.set増減の理由Title(new RString("増減の理由"));
        } else {
            entity.set増減の理由Title(new RString("不支給の理由"));
        }
        set送付物宛先(entity, 識別コード);
        ZougenFushikyuRiyu zougenFushikyuRiyu = getZougenFushikyuRiyu(被保険者番号, 整理番号, サービス提供年月,
                支給不支給決定区分, kyufuSHurui.get償還計画費データ件数(), kyufuSHurui.get償還集計データ件数());
        entity.set増減の理由1(zougenFushikyuRiyu.get増減_不支給の理由1());
        entity.set増減の理由2(zougenFushikyuRiyu.get増減_不支給の理由2());
        entity.set増減の理由3(zougenFushikyuRiyu.get増減_不支給の理由3());
        if ((不支給.equals(shikyuHushikyuKetteiKubun) || 支給.equals(shikyuHushikyuKetteiKubun))
                && (口座払.equals(shoukanbaraiShikyuEntity.get償還払支給申請().getShiharaiHohoKubunCode()))) {
            entity.setTorikeshi1(HOSHI_14);
        } else if ((不支給.equals(shikyuHushikyuKetteiKubun) || 支給.equals(shikyuHushikyuKetteiKubun))
                && (窓口払.equals(shoukanbaraiShikyuEntity.get償還払支給申請().getShiharaiHohoKubunCode()))) {
            entity.setTorikeshi2(HOSHI_14);
        }
        setKoza(entity, 口座ID, 識別コード);
        if (窓口払.equals(shoukanbaraiShikyuEntity.get償還払支給申請().getShiharaiHohoKubunCode())) {
            entity.setMochimono1(manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 帳票制御汎用キー_持ち物内容文言１).get設定値());
            entity.setMochimono2(manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 帳票制御汎用キー_持ち物内容文言２).get設定値());
            entity.setMochimono3(manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 帳票制御汎用キー_持ち物内容文言３).get設定値());
            entity.setShiharaiBasho(shoukanbaraiShikyuEntity.get償還払支給申請().getShiharaiBasho());
            edit支払期間(entity, shoukanbaraiShikyuEntity);
        } else if (口座払.equals(shoukanbaraiShikyuEntity.get償還払支給申請().getShiharaiHohoKubunCode())) {
            entity.setTorikeshiMochimono1(HOSHI_14);
            entity.setTorikeshiMochimono2(HOSHI_14);
            entity.setTorikeshiShiharaibasho(HOSHI_14);
            entity.setTorikeshiShiharaikikan(HOSHI_14);
            entity.setBankName(entity.get口座情報().get金融機関().get金融機関名称());
            if ((!entity.get口座情報().get金融機関コード().value().equals(金融機関コード_郵便局))
                    || (entity.get口座情報().get金融機関コード().value().equals(金融機関コード_郵便局) && 一.equals(帳票制御汎用_ゆうちょ銀行店名表示.get設定値()))) {
                entity.setBranchBankName(entity.get口座情報().get支店().get支店名称());
            }
            if (金融機関コード_郵便局.equals(entity.get口座情報().get金融機関コード().value())) {
                entity.setShumokuTitle(種別タイトル_店番);
                entity.setKouzaShu(entity.get口座情報().get支店コード().value());
            } else {
                entity.setShumokuTitle(種別タイトル_口座種別);
                entity.setKouzaShu(entity.get口座情報().get預金種別().get預金種別名称());
            }
            entity.setBangoTitle(番号タイトル_口座番号);
            entity.setKouzaNo(entity.get口座情報().get口座番号());
            entity.setKouzaMeigi(entity.get口座情報().get口座名義人().value());
        }
        entity.set文書番号(文書番号);
        entity.set発行日(発行日);
        entity.set支払予定日(支払予定日);
        entity.setSeirino(shoukanbaraiShikyuEntity.get償還払支給判定結果().getSeiriNo());
        target.setデータ有無(データ有無);
        target.set償還払支給決定通知書(entity);
        return target;
    }

    /**
     * 送付物宛先取得です。
     *
     * @param entity ShoukanbaraiShikyuketteiTsuuchisho
     * @param 識別コード 識別コード
     *
     */
    private void set送付物宛先(ShoukanbaraiShikyuketteiTsuuchisho entity, ShikibetsuCode 識別コード) {
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        builder.set識別コード(識別コード);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());
        ChohyoSeigyoKyotsu 帳票共通情報
                = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, 通知文情報帳票ID);
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(宛先, 地方公共団体, 帳票共通情報);
        SofubutsuAtesakiSource 送付物宛先 = null;
        if (編集後宛先 != null && 編集後宛先.getSofubutsuAtesakiSource() != null) {
            送付物宛先 = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        }
        if (送付物宛先 != null) {
            送付物宛先.customerBarCode = ReportUtil.getCustomerBarCode(送付物宛先.yubinNo, 送付物宛先.jusho1);
            entity.setYubinNo(送付物宛先.yubinNo);
            entity.setGyoseiku2(送付物宛先.gyoseiku);
            entity.setJusho4(送付物宛先.jusho1);
            entity.setJushoText(送付物宛先.jushoText);
            entity.setJusho5(送付物宛先.jusho2);
            entity.setJusho6(送付物宛先.jusho3);
            entity.setKatagakiText(送付物宛先.katagakiText);
            entity.setKatagaki3(送付物宛先.katagaki1);
            entity.setKatagaki4(送付物宛先.katagaki2);
            entity.setKatagakiSmall2(送付物宛先.katagakiSmall2);
            entity.setKatagakiSmall1(送付物宛先.katagakiSmall1);
            entity.setShimeiSmall2(送付物宛先.shimeiSmall2);
            entity.setShimeiText(送付物宛先.shimeiText);
            entity.setMeishoFuyo2(送付物宛先.meishoFuyo2);
            entity.setShimeiSmall1(送付物宛先.shimeiSmall1);
            entity.setDainoKubunMei(送付物宛先.dainoKubunMei);
            entity.setShimei5(送付物宛先.shimei1);
            entity.setShimei6(送付物宛先.shimei2);
            entity.setMeishoFuyo1(送付物宛先.meishoFuyo1);
            entity.setSamabunShimeiText(送付物宛先.samabunShimeiText);
            entity.setSamaBun2(送付物宛先.samaBun2);
            entity.setKakkoLeft2(送付物宛先.kakkoLeft2);
            entity.setSamabunShimei2(送付物宛先.samabunShimei2);
            entity.setSamabunShimeiSmall2(送付物宛先.samabunShimeiSmall2);
            entity.setKakkoRight2(送付物宛先.kakkoRight2);
            entity.setKakkoLeft1(送付物宛先.kakkoLeft1);
            entity.setSamabunShimei1(送付物宛先.samabunShimei1);
            entity.setSamaBun1(送付物宛先.samaBun1);
            entity.setKakkoRight1(送付物宛先.kakkoRight1);
            entity.setSamabunShimeiSmall1(送付物宛先.samabunShimeiSmall1);
            entity.setCustomerBarCode(送付物宛先.customerBarCode);
        }
        entity.set送付物宛先(送付物宛先);
    }

    /**
     * 通知文文章です。
     *
     * @param entity ShoukanbaraiShikyuketteiTsuuchisho
     */
    public void set通知文(ShoukanbaraiShikyuketteiTsuuchisho entity) {
        Map<Integer, RString> レイヤ = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, KamokuCode.EMPTY, NUM_1);
        entity.set通知文1(レイヤ.get(NUM_1));
        entity.set通知文2(レイヤ.get(NUM_2));
        Map<Integer, RString> レイヤ大 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, KamokuCode.EMPTY, NUM_2);
        entity.set通知文3(レイヤ大.get(NUM_2));
        Map<Integer, RString> レイヤ混在 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, KamokuCode.EMPTY, NUM_3);
        entity.set通知文4(レイヤ混在.get(NUM_2));
        entity.set通知文5(レイヤ混在.get(NUM_3));
        Map<Integer, RString> レイヤ混在2 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, KamokuCode.EMPTY, NUM_4);
        entity.set通知文6(レイヤ混在2.get(NUM_2));
        entity.set通知文7(レイヤ混在2.get(NUM_3));
    }

    /**
     * タイトルです。
     *
     * @param entity ShoukanbaraiShikyuketteiTsuuchisho
     * @param shoukanbaraiShikyuEntity ShoukanbaraiShikyuEntity
     */
    public void setタイトル(ShoukanbaraiShikyuketteiTsuuchisho entity, ShoukanbaraiShikyuEntity shoukanbaraiShikyuEntity) {
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo 帳票制御汎用_取り消し線
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_取り消し線);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_帳票タイトル);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり１
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_帳票タイトル_抹消線あり１);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり２
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_帳票タイトル_抹消線あり２);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり３
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_帳票タイトル_抹消線あり３);
        ChohyoSeigyoHanyo 帳票制御汎用_帳票タイトル_抹消線あり４
                = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, 通知文情報帳票ID, FlexibleYear.MIN, 項目名_帳票タイトル_抹消線あり４);
        if (ゼロ.equals(帳票制御汎用_取り消し線.get設定値())) {
            entity.setTitle(帳票制御汎用_帳票タイトル.get設定値());
        } else if (一.equals(帳票制御汎用_取り消し線.get設定値())) {
            entity.setTitle2(帳票制御汎用_帳票タイトル_抹消線あり１.get設定値());
            entity.setTitle24(帳票制御汎用_帳票タイトル_抹消線あり４.get設定値());
            if (一.equals(shoukanbaraiShikyuEntity.get償還払支給判定結果().getShikyuHushikyuKetteiKubun())) {
                entity.setTitle221(帳票制御汎用_帳票タイトル_抹消線あり２.get設定値());
                entity.setTitle222(RString.EMPTY);
                entity.setTitle231(RString.EMPTY);
                entity.setTitle232(帳票制御汎用_帳票タイトル_抹消線あり３.get設定値());
            } else if (ゼロ.equals(shoukanbaraiShikyuEntity.get償還払支給判定結果().getShikyuHushikyuKetteiKubun())) {
                entity.setTitle221(RString.EMPTY);
                entity.setTitle222(帳票制御汎用_帳票タイトル_抹消線あり２.get設定値());
                entity.setTitle231(帳票制御汎用_帳票タイトル_抹消線あり３.get設定値());
                entity.setTitle232(RString.EMPTY);
            }
        }
    }

    private RString edit給付の種類Total(RString serviceShuruiRyakusho, RString 給付の種類) {
        if (給付の種類.isEmpty()) {
            給付の種類 = 給付の種類.concat(serviceShuruiRyakusho);
        } else if (給付の種類.indexOf(serviceShuruiRyakusho) == -1) {
            給付の種類 = 給付の種類.concat(間)
                    .concat(serviceShuruiRyakusho);
        }
        return 給付の種類;
    }

    private RString edit給付の種類(RString serviceShuruiRyakusho, RString 給付の種類) {
        if (給付の種類.isEmpty()) {
            給付の種類 = 給付の種類.concat(serviceShuruiRyakusho);
        } else if (給付の種類.indexOf(serviceShuruiRyakusho) == -1) {
            給付の種類 = 給付の種類.concat(間)
                    .concat(serviceShuruiRyakusho);
        }
        return 給付の種類;
    }

    private RString edit給付種類(RString serviceShuruiRyakusho, RString 給付の種類) {
        if (給付の種類.isEmpty()) {
            給付の種類 = 給付の種類.concat(serviceShuruiRyakusho);
        } else if (給付の種類.indexOf(serviceShuruiRyakusho) == -1) {
            給付の種類 = 給付の種類.concat(間)
                    .concat(serviceShuruiRyakusho);
        }
        return 給付の種類;
    }

    private void edit出力給付の種類(KyufuSHurui kyufuSHurui) {
        if (kyufuSHurui.get給付の種類1() == null || kyufuSHurui.get給付の種類1().isEmpty()) {
            kyufuSHurui.set給付の種類1(ワークの文言);
            return;
        }
        if (kyufuSHurui.get給付の種類2() == null || kyufuSHurui.get給付の種類2().isEmpty()) {
            if (kyufuSHurui.get給付の種類1().trim().length() <= NUM_21) {
                kyufuSHurui.set給付の種類1(kyufuSHurui.get給付の種類1().trim().concat(ワークの文言));
            } else {
                kyufuSHurui.set給付の種類2(ワークの文言);
            }
            return;
        }
        if (kyufuSHurui.get給付の種類3() == null || kyufuSHurui.get給付の種類3().isEmpty()) {
            if (kyufuSHurui.get給付の種類2().trim().length() <= NUM_21) {
                kyufuSHurui.set給付の種類2(kyufuSHurui.get給付の種類2().trim().concat(ワークの文言));
            } else {
                kyufuSHurui.set給付の種類3(ワークの文言);
            }
            return;
        }
        if (kyufuSHurui.get給付の種類3() != null && !kyufuSHurui.get給付の種類3().isEmpty()) {
            edit出力給付種類(kyufuSHurui);
        }
    }

    private void edit出力給付種類(KyufuSHurui kyufuSHurui) {
        if (kyufuSHurui.get給付の種類3().trim().length() <= NUM_21) {
            kyufuSHurui.set給付の種類3(kyufuSHurui.get給付の種類3().trim().concat(ワークの文言));
        } else {
            RString ワーク文言 = その他.concat(ワークの文言);
            if (kyufuSHurui.get給付の種類3().trim().indexOf(間) == -1) {
                kyufuSHurui.set給付の種類3(ワーク文言);
            } else {
                int i = NUM_38;
                while (i > NUM_17) {
                    i = kyufuSHurui.get給付の種類3().trim().lastIndexOf(間);
                    kyufuSHurui.set給付の種類3(kyufuSHurui.get給付の種類3().trim().substring(0, i));
                }
                kyufuSHurui.set給付の種類3(kyufuSHurui.get給付の種類3().trim().concat(ワーク文言));
            }
        }
    }

    private RString set時間(RString time) {
        if (time == null || time.isEmpty()) {
            return RString.EMPTY;
        }
        RString 時間;
        RString hh = time.substring(0, NUM_2);
        RString mm = time.substring(NUM_2, NUM_4);
        if (hh.compareTo(RSTRING_12) < 0) {
            時間 = 午前.concat(hh).concat(時);
        } else if (hh.equals(RSTRING_12)) {
            時間 = 午後.concat(new RString("零")).concat(時);
        } else {
            hh = new RString(Integer.parseInt(hh.toString()) - NUM_12);
            時間 = 午後.concat(hh).concat(時);
        }
        if (!RSTRING_00.equals(mm)) {
            時間 = 時間.concat(mm).concat(分);
        }
        return 時間;
    }

    private void setKoza(ShoukanbaraiShikyuketteiTsuuchisho entity, long 口座ID, ShikibetsuCode 識別コード) {
        IKoza 口座;
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder().setサブ業務コード(SubGyomuCode.DBC介護給付)
                .set業務コード(GyomuCode.DB介護保険).set識別コード(識別コード).set口座ID(口座ID).build();
        IKozaManager iKozaManager = KozaService.createKozaManager();
        if (chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, 通知文情報帳票ID).is口座マスク有無()) {
            口座 = iKozaManager.getマスク済口座(searchKey).isEmpty() ? null : iKozaManager.getマスク済口座(searchKey).get(0);
        } else {
            口座 = iKozaManager.get口座(searchKey).isEmpty() ? null : iKozaManager.get口座(searchKey).get(0);
        }
        entity.set口座情報(口座);
    }

    private RString edit償還払請求サービス計画検索(List<DbT7130KaigoServiceShuruiEntity> dbt7130entitys, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, RString 給付の種類) {
        List<DbT3045ShokanServicePlan200004Entity> dbt3045entitys = dbT3045dac.get償還払請求サービス計画(被保険者番号, サービス提供年月, 整理番号);
        List<DbT3046ShokanServicePlan200604Entity> dbt3046entitys = dbT3046dac.get償還払請求サービス計画(被保険者番号, サービス提供年月, 整理番号);
        List<DbT3047ShokanServicePlan200904Entity> dbt3047entitys = dbT3047dac.get償還払請求サービス計画(被保険者番号, サービス提供年月, 整理番号);
        if (サービス提供年月.isBefore(new FlexibleYearMonth("200604")) && !dbt3045entitys.isEmpty()) {
            for (DbT3045ShokanServicePlan200004Entity entity3045 : dbt3045entitys) {
                for (DbT7130KaigoServiceShuruiEntity entity7130 : dbt7130entitys) {
                    ServiceCode code = entity3045.getServiceCode();
                    if (code != null) {
                        給付の種類 = editServiceCode(entity7130, code, 給付の種類);
                    }
                }
            }
        } else if (サービス提供年月.isBefore(new FlexibleYearMonth("200903")) && new FlexibleYearMonth("200604").isBeforeOrEquals(サービス提供年月)
                && !dbt3046entitys.isEmpty()) {
            for (DbT3046ShokanServicePlan200604Entity entity3046 : dbt3046entitys) {
                for (DbT7130KaigoServiceShuruiEntity entity7130 : dbt7130entitys) {
                    ServiceCode code = entity3046.getServiceCode();
                    if (code != null) {
                        給付の種類 = editServiceCode(entity7130, code, 給付の種類);
                    }
                }
            }
        } else if (!dbt3047entitys.isEmpty()) {
            for (DbT3047ShokanServicePlan200904Entity entity3047 : dbt3047entitys) {
                for (DbT7130KaigoServiceShuruiEntity entity7130 : dbt7130entitys) {
                    ServiceCode code = entity3047.getServiceCode();
                    if (code != null) {
                        給付の種類 = editServiceCode(entity7130, code, 給付の種類);
                    }
                }
            }
        }
        return 給付の種類;
    }

    private RString editServiceCode(DbT7130KaigoServiceShuruiEntity entity7130, ServiceCode serviceCode, RString 給付の種類) {
        if (entity7130.getServiceShuruiCd().value().equals(serviceCode.value().substring(NUM_0, NUM_2))) {
            給付の種類 = edit給付の種類Total(entity7130.getServiceShuruiMeisho(), 給付の種類);
        }
        return 給付の種類;
    }

    private void edit支払期間(ShoukanbaraiShikyuketteiTsuuchisho entity, ShoukanbaraiShikyuEntity shoukanbaraiShikyuEntity) {
        FlexibleDate shiharaiKaishiYMD = shoukanbaraiShikyuEntity.get償還払支給申請().getShiharaiKaishiYMD();
        FlexibleDate shiharaiShuryoYMD = shoukanbaraiShikyuEntity.get償還払支給申請().getShiharaiShuryoYMD();
        RString shiharaiKaishiTime = shoukanbaraiShikyuEntity.get償還払支給申請().getShiharaiKaishiTime();
        RString shiharaiShuryoTime = shoukanbaraiShikyuEntity.get償還払支給申請().getShiharaiShuryoTime();
        entity.setShiharaiEndYMD(RString.EMPTY);
        if (shiharaiKaishiYMD != null && !shiharaiKaishiYMD.isEmpty()) {
            entity.setShiharaiStartYMD(shiharaiKaishiYMD.wareki().
                    eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString().
                    concat("（").
                    concat(shiharaiKaishiYMD.getDayOfWeek().getShortTerm()).concat("）").concat(KARA));
        } else if ((shiharaiKaishiYMD == null || shiharaiKaishiYMD.isEmpty()) && (shiharaiShuryoYMD != null && !shiharaiShuryoYMD.isEmpty())) {
            entity.setShiharaiStartYMD(KARA.concat(shiharaiShuryoYMD.wareki().
                    eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString().concat("（").concat(shiharaiShuryoYMD.getDayOfWeek().getShortTerm().concat("）"))));
        }
        if ((shiharaiKaishiYMD != null && !shiharaiKaishiYMD.isEmpty()) && (shiharaiShuryoYMD != null && !shiharaiShuryoYMD.isEmpty())) {
            entity.setShiharaiEndYMD(shiharaiShuryoYMD.wareki().
                    eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString().concat("（").concat(shiharaiShuryoYMD.getDayOfWeek().getShortTerm().concat("）")));
        }
        if (shiharaiKaishiYMD != null && !shiharaiKaishiYMD.isEmpty() || shiharaiShuryoYMD != null && !shiharaiShuryoYMD.isEmpty()) {
            entity.setShiharaiStart(set時間(shiharaiKaishiTime));
            entity.setShiharaiEnd(set時間(shiharaiShuryoTime));
            if (shiharaiKaishiTime != null && !shiharaiKaishiTime.isEmpty() || shiharaiShuryoTime != null && !shiharaiShuryoTime.isEmpty()) {
                entity.setKaraFugo(KARA);
            }
        } else {
            entity.setKaraFugo(RString.EMPTY);
            entity.setShiharaiStart(RString.EMPTY);
            entity.setShiharaiEnd(RString.EMPTY);
        }
    }

    private int edit償還集計データ(RString 給付の種類, RString 給付の種類Total, int 償還集計データ件数) {
        if (!給付の種類.equals(給付の種類Total)) {
            償還集計データ件数++;
        }
        return 償還集計データ件数;
    }

    private RString edit増減_不支給の理由(HihokenshaNo 被保険者番号, RString 整理番号, FlexibleYearMonth サービス提供年月) {
        RString 増減_不支給の理由 = RString.EMPTY;
        if (サービス提供年月.isBefore(new FlexibleYearMonth("200604"))) {
            List<DbT3045ShokanServicePlan200004Entity> dbt3045entitys = dbT3045dac.get償還払請求サービス計画(被保険者番号, サービス提供年月, 整理番号);
            if (!dbt3045entitys.isEmpty()) {
                RString 理由 = dbt3045entitys.get(0).getZougenRiyu();
                増減_不支給の理由 = 理由 != null ? 増減_不支給の理由.concat(理由) : 増減_不支給の理由;
            }
        } else if (サービス提供年月.isBefore(new FlexibleYearMonth("200903")) && new FlexibleYearMonth("200604").isBeforeOrEquals(サービス提供年月)) {
            List<DbT3046ShokanServicePlan200604Entity> dbt3046entitys = dbT3046dac.get償還払請求サービス計画(被保険者番号, サービス提供年月, 整理番号);
            if (!dbt3046entitys.isEmpty()) {
                RString 理由 = dbt3046entitys.get(0).getZougenRiyu();
                増減_不支給の理由 = 理由 != null ? 増減_不支給の理由.concat(理由) : 増減_不支給の理由;
            }
        } else {
            List<DbT3047ShokanServicePlan200904Entity> dbt3047entitys = dbT3047dac.get償還払請求サービス計画(被保険者番号, サービス提供年月, 整理番号);
            if (!dbt3047entitys.isEmpty()) {
                RString 理由 = dbt3047entitys.get(0).getZougenRiyu();
                増減_不支給の理由 = 理由 != null ? 増減_不支給の理由.concat(理由) : 増減_不支給の理由;
            }
        }
        return 増減_不支給の理由;
    }

    private RString edit増減不支給の理由(HihokenshaNo 被保険者番号, RString 整理番号, FlexibleYearMonth サービス提供年月) {
        RString 増減_不支給の理由 = RString.EMPTY;
        if (サービス提供年月.isBefore(new FlexibleYearMonth("200604"))) {
            List<DbT3045ShokanServicePlan200004Entity> dbt3045entitys = dbT3045dac.get償還払請求サービス計画(被保険者番号, サービス提供年月, 整理番号);
            if (!dbt3045entitys.isEmpty()) {
                RString 理由 = dbt3045entitys.get(0).getFushikyuRiyu();
                増減_不支給の理由 = 理由 != null ? 増減_不支給の理由.concat(理由) : 増減_不支給の理由;
            }
        } else if (サービス提供年月.isBefore(new FlexibleYearMonth("200903")) && new FlexibleYearMonth("200604").isBeforeOrEquals(サービス提供年月)) {
            List<DbT3046ShokanServicePlan200604Entity> dbt3046entitys = dbT3046dac.get償還払請求サービス計画(被保険者番号, サービス提供年月, 整理番号);
            if (!dbt3046entitys.isEmpty()) {
                RString 理由 = dbt3046entitys.get(0).getFushikyuRiyu();
                増減_不支給の理由 = 理由 != null ? 増減_不支給の理由.concat(理由) : 増減_不支給の理由;
            }
        } else {
            List<DbT3047ShokanServicePlan200904Entity> dbt3047entitys = dbT3047dac.get償還払請求サービス計画(被保険者番号, サービス提供年月, 整理番号);
            if (!dbt3047entitys.isEmpty()) {
                RString 理由 = dbt3047entitys.get(0).getFushikyuRiyu();
                増減_不支給の理由 = 理由 != null ? 増減_不支給の理由.concat(理由) : 増減_不支給の理由;
            }
        }
        return 増減_不支給の理由;
    }

    private RString edit給付種類(FlexibleYearMonth サービス提供年月, RString 給付の種類) {
        if (サービス提供年月.isBefore(new FlexibleYearMonth("201504"))) {
            if (給付の種類.isEmpty()) {
                給付の種類 = 給付の種類.concat(複合型サービス);
            } else {
                給付の種類 = 給付の種類.concat(間)
                        .concat(複合型サービス);
            }
        } else if (給付の種類.isEmpty()) {
            給付の種類 = 給付の種類.concat(看護小規模多機能型居宅介護);
        } else {
            給付の種類 = 給付の種類.concat(間)
                    .concat(看護小規模多機能型居宅介護);
        }
        return 給付の種類;
    }
}
