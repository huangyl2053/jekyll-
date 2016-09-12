/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.kakushutsuchishosakusei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ca.cax.entity.db.relate.TotalShunyuRelateEntity;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsu;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.choteikyotsu.ChoteiKyotsuIdentifier;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.FukaDaityouInfo;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.KakushuTsuchishoCommonInfo;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.KakushuTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.GinfuriTsuchishoType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KigotoShutsuryoku;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KigotoTsuchishoType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SonotaTsuchishoType;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.kakushutsuchishosakusei.IKakushuTsuchishoSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1006KyokaisoGaitoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.service.core.setaiinshotokujoho.SetaiinShotokuJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dainonin.Dainonin;
import jp.co.ndensan.reams.ua.uax.business.core.dainonin.DainoninRelate;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.service.core.dainonin.DainoninRelateFinderFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 各種通知書作成（個別）クラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
public class KakushuTsuchishoSakuseiFath {

    private static final RString 処理名 = new RString("本算定賦課");
    private static final RString 番号 = new RString("0001");
    private static final RString キー_調定日 = new RString("調定日");
    private static final RString キー_識別コード = new RString("識別コード");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
    private static final int 定値_番号1 = 1;
    private static final int 定値_番号2 = 2;
    private static final int 設定値_番号0 = 0;
    private static final int 設定値_番号4 = 4;
    private static final int 設定値_番号5 = 5;
    private static final int 設定値_番号6 = 6;
    private static final int 設定値_番号9 = 9;
    private static final RString 定値_0 = new RString("0");
    private static final RString 定値_納入通知書制御情報 = new RString("納入通知書制御情報");
    private static final RString 定値_出力期 = new RString("出力期");
    private static final RString 定値_仮算定_本算定_過年度区分 = new RString("仮算定_本算定_過年度区分");
    private static final RString 仮算定_区分 = new RString("1");
    private static final RString 本算定_区分 = new RString("2");
    private static final RString 過年度_区分 = new RString("3");
    private static final RString 定値_期毎 = new RString("期毎タイプ");
    private static final RString 定値_銀振型5期 = new RString("銀振型5期タイプ");
    private static final RString 定値_銀振型4期 = new RString("銀振型4期タイプ");
    private static final RString 定値_ブック = new RString("ブックタイプ");
    private static final RString 定値_コンビニ収納 = new RString("コンビニ収納タイプ");
    private static final RString 定値_その他 = new RString("その他（カスタマイズ）");
    private static final int 定値_1期 = 1;
    private static final int 定値_2期 = 2;
    private static final int 定値_3期 = 3;
    private static final int 定値_4期 = 4;
    private static final int 定値_5期 = 5;
    private static final int 定値_6期 = 6;
    private static final int 定値_7期 = 7;
    private static final int 定値_8期 = 8;
    private static final int 定値_9期 = 9;
    private static final int 定値_10期 = 10;
    private static final int 定値_11期 = 11;
    private static final int 定値_12期 = 12;
    private static final int 定値_13期 = 13;
    private static final int 定値_14期 = 14;
    private List<Kibetsu> kibetsuList;
    private List<TotalShunyuRelateEntity> 収入情報取得PSM;
    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac;
    private final DbT4021ShiharaiHohoHenkoDac 支払方法変更Dac;
    private final DbV4001JukyushaDaichoAliveDac 受給者台帳Dac;
    private final DbT7022ShoriDateKanriDac 処理日付Dac;
    private final DbT1006KyokaisoGaitoshaDac 境界層該当者Dac;

    /**
     * コンストラクタです。
     */
    public KakushuTsuchishoSakuseiFath() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.被保険者台帳管理Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.支払方法変更Dac = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
        this.受給者台帳Dac = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);
        this.処理日付Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.境界層該当者Dac = InstanceProvider.create(DbT1006KyokaisoGaitoshaDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KakushuTsuchishoSakuseiFath}のインスタンスを返します。
     *
     * @return KakushuTsuchishoSakusei
     */
    public static KakushuTsuchishoSakuseiFath createInstance() {
        return InstanceProvider.create(KakushuTsuchishoSakuseiFath.class);
    }

    /**
     *
     * 賦課台帳情報取得メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return FukaDaityouInfo
     */
    public FukaDaityouInfo load賦課台帳情報(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {

        FukaJoho 賦課の情報_更正後 = parameter.get賦課の情報_更正後();
        FukaJoho 賦課の情報更正後 = 通知書共通情報.get賦課の情報_更正後().get賦課情報();
        if (賦課の情報_更正後 == null || 賦課の情報更正後 == null) {
            return null;
        }
        FukaDaityouInfo 賦課台帳情報 = new FukaDaityouInfo();
        IShikibetsuTaisho 識別対象 = null;
        List<GyomuCode> list = new ArrayList<>();
        list.add(GyomuCode.DB介護保険);
        List<DainoninRelate> 代納人情報リスト = DainoninRelateFinderFactory.createInstance().get代納人byサブ業務コード(
                賦課の情報_更正後.get識別コード(), list, SubGyomuCode.DBB介護賦課);
        if (代納人情報リスト != null && !代納人情報リスト.isEmpty()) {
            for (DainoninRelate 代納人情報 : 代納人情報リスト) {
                Dainonin 代納人 = 代納人情報.get代納人();
                FlexibleDate 発行日 = new FlexibleDate(RDate.getNowDate().toDateString());
                if (代納人.get開始年月日().isBeforeOrEquals(発行日) && 発行日.isBeforeOrEquals(代納人.get終了年月日())) {
                    識別対象 = 代納人情報.get識別対象();
                    break;
                }
            }
        }
        賦課台帳情報.set代納人情報(識別対象);

        SetaiinShotokuJohoFinder 世帯員所得情報Finder = SetaiinShotokuJohoFinder.createInstance();
        List<SetaiinShotoku> 世帯員所得情報 = 世帯員所得情報Finder.get世帯員所得情報(賦課の情報_更正後.get識別コード(),
                賦課の情報_更正後.get賦課期日(), 賦課の情報_更正後.get賦課年度(), null, false);
        賦課台帳情報.set世帯員所得情報(世帯員所得情報);
        TelNo 本人連絡先1 = 通知書共通情報.get宛名情報().get連絡先１();
        TelNo 本人連絡先2 = 通知書共通情報.get宛名情報().get連絡先２();
        TelNo 代納人連絡先1 = TelNo.EMPTY;
        TelNo 代納人連絡先2 = TelNo.EMPTY;

        IKakushuTsuchishoSakuseiMapper mapper = mapperProvider.create(IKakushuTsuchishoSakuseiMapper.class);
        if (識別対象 != null) {
            Map<String, Object> para = new HashMap<>();
            para.put(キー_調定日.toString(), 賦課の情報_更正後.get調定日時().getDate().toDateString());
            para.put(キー_識別コード.toString(), 識別対象.get識別コード());
            UaFt200FindShikibetsuTaishoEntity 代納人の宛名情報 = mapper.get代納人の宛名情報(para);
            if (代納人の宛名情報 != null) {
                代納人連絡先1 = 代納人の宛名情報.getRenrakusaki1();
                代納人連絡先2 = 代納人の宛名情報.getRenrakusaki2();
            }
        }
        賦課台帳情報.set本人連絡先1(本人連絡先1);
        賦課台帳情報.set本人連絡先2(本人連絡先2);
        賦課台帳情報.set代納人連絡先1(代納人連絡先1);
        賦課台帳情報.set代納人連絡先2(代納人連絡先2);

        DbT1006KyokaisoGaitoshaEntity 境界層当該者情報 = 境界層該当者Dac.select境界層該当者情報(賦課の情報更正後.get被保険者番号());
        賦課台帳情報.set境界層当該者情報(境界層当該者情報);
        DbT1001HihokenshaDaichoEntity 被保険者台帳情報 = 被保険者台帳管理Dac.selectByHihokensha(賦課の情報更正後.get被保険者番号());
        賦課台帳情報.set被保険者台帳情報(被保険者台帳情報);
        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更リスト = 支払方法変更Dac.get支支払方法変更(賦課の情報更正後.get被保険者番号());
        賦課台帳情報.set支払方法変更リスト(支払方法変更リスト);
        DbV4001JukyushaDaichoEntity 受給者台帳情報 = 受給者台帳Dac.select受給者台帳情報(賦課の情報更正後.get被保険者番号());
        賦課台帳情報.set受給者台帳情報(受給者台帳情報);
        DbT7022ShoriDateKanriEntity 処理日付マスタ
                = 処理日付Dac.selectByKey(SubGyomuCode.DBB介護賦課, 通知書共通情報.get地方公共団体().getLasdecCode_(),
                        処理名, 番号, 賦課の情報更正後.get賦課年度(), 番号);
        if (処理日付マスタ != null) {
            賦課台帳情報.set基準日時(処理日付マスタ.getKijunTimestamp());
        }
        return 賦課台帳情報;
    }

    /**
     * 特徴収入額01を返します。
     *
     * @return 特徴収入額01
     */
    public Decimal get特徴収入額01() {

        return this.get収入額(INT_1, ChoshuHohoKibetsu.特別徴収.getコード());
    }

    /**
     * 特徴収入額02を返します。
     *
     * @return 特徴収入額02
     */
    public Decimal get特徴収入額02() {

        return this.get収入額(INT_2, ChoshuHohoKibetsu.特別徴収.getコード());
    }

    /**
     * 特徴収入額03を返します。
     *
     * @return 特徴収入額03
     */
    public Decimal get特徴収入額03() {

        return this.get収入額(INT_3, ChoshuHohoKibetsu.特別徴収.getコード());
    }

    /**
     * 特徴収入額04を返します。
     *
     * @return 特徴収入額04
     */
    public Decimal get特徴収入額04() {

        return this.get収入額(INT_4, ChoshuHohoKibetsu.特別徴収.getコード());
    }

    /**
     * 特徴収入額05を返します。
     *
     * @return 特徴収入額05
     */
    public Decimal get特徴収入額05() {

        return this.get収入額(INT_5, ChoshuHohoKibetsu.特別徴収.getコード());
    }

    /**
     * 特徴収入額06を返します。
     *
     * @return 特徴収入額06
     */
    public Decimal get特徴収入額06() {

        return this.get収入額(INT_6, ChoshuHohoKibetsu.特別徴収.getコード());
    }

    /**
     * 普徴収入額01を返します。
     *
     * @return 普徴収入額01
     */
    public Decimal get普徴収入額01() {

        return this.get収入額(INT_1, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額02を返します。
     *
     * @return 普徴収入額02
     */
    public Decimal get普徴収入額02() {

        return this.get収入額(INT_2, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額03を返します。
     *
     * @return 普徴収入額03
     */
    public Decimal get普徴収入額03() {

        return this.get収入額(INT_3, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額04を返します。
     *
     * @return 普徴収入額04
     */
    public Decimal get普徴収入額04() {

        return this.get収入額(INT_4, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額05を返します。
     *
     * @return 普徴収入額05
     */
    public Decimal get普徴収入額05() {

        return this.get収入額(INT_5, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額06を返します。
     *
     * @return 普徴収入額06
     */
    public Decimal get普徴収入額06() {

        return this.get収入額(INT_6, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額07を返します。
     *
     * @return 普徴収入額07
     */
    public Decimal get普徴収入額07() {

        return this.get収入額(INT_7, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額08を返します。
     *
     * @return 普徴収入額08
     */
    public Decimal get普徴収入額08() {

        return this.get収入額(INT_8, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額09を返します。
     *
     * @return 普徴収入額09
     */
    public Decimal get普徴収入額09() {

        return this.get収入額(INT_9, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額10を返します。
     *
     * @return 普徴収入額10
     */
    public Decimal get普徴収入額10() {

        return this.get収入額(INT_10, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額11を返します。
     *
     * @return 普徴収入額11
     */
    public Decimal get普徴収入額11() {

        return this.get収入額(INT_11, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額12を返します。
     *
     * @return 普徴収入額12
     */
    public Decimal get普徴収入額12() {

        return this.get収入額(INT_12, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額13を返します。
     *
     * @return 普徴収入額13
     */
    public Decimal get普徴収入額13() {

        return this.get収入額(INT_13, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * 普徴収入額14を返します。
     *
     * @return 普徴収入額14
     */
    public Decimal get普徴収入額14() {

        return this.get収入額(INT_14, ChoshuHohoKibetsu.普通徴収.getコード());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link FukaJohoRelateEntity}より{@link FukaJoho}を生成します。
     *
     * @param entity DBより取得した{@link FukaJohoRelateEntity}
     * @param 収入情報List List<TotalShunyuRelateEntity>
     */
    public void fukaJoho(FukaJohoRelateEntity entity, List<TotalShunyuRelateEntity> 収入情報List) {

        kibetsuList = new ArrayList<>();
        if (entity.get介護期別RelateEntity() != null && !entity.get介護期別RelateEntity().isEmpty()) {
            for (KibetsuEntity kibetsuEntity : entity.get介護期別RelateEntity()) {
                kibetsuList.add(new Kibetsu(kibetsuEntity));
            }
        }
        収入情報取得PSM = 収入情報List;
    }

    /**
     * 収入額を返します。
     *
     * @param 期 int
     * @param 徴収方法期別 RString
     * @return 収入額
     */
    private Decimal get収入額(int 期, RString 徴収方法期別) {

        for (Kibetsu thisKibetsu : kibetsuList) {
            if (徴収方法期別.equals(thisKibetsu.get徴収方法())
                    && 期 == thisKibetsu.get期()) {
                ChoteiKyotsuIdentifier identifier = new ChoteiKyotsuIdentifier(thisKibetsu.get調定ID().longValue());
                return get収入額(thisKibetsu.getChoteiKyotsu(identifier));
            }
        }
        return null;
    }

    private Decimal get収入額(ChoteiKyotsu 調定共通情報) {
        if (収入情報取得PSM == null || 収入情報取得PSM.isEmpty() || 調定共通情報 == null) {
            return null;
        }
        for (TotalShunyuRelateEntity 収入情報 : 収入情報取得PSM) {
            if (収入情報.get収納キーRelateEntity() == null || 収入情報.get収納キーRelateEntity().get収納管理Entity() == null) {
                continue;
            }
            if (調定共通情報.get収納ID().equals(収入情報.get収納キーRelateEntity().get収納管理Entity().getShunoId())) {
                return 収入情報.get最新収入Entity() == null ? null : 収入情報.get最新収入Entity().getShunyugaku();
            }
        }
        return null;
    }

    /**
     * 納入通知書帳票ID判定メソッドです。
     *
     * @param 納入通知書制御情報 納入通知書制御情報
     * @param 出力期 出力期
     * @param 仮算定_本算定_過年度区分 仮算定_本算定_過年度区分
     * @return 帳票ID
     * @throws NullPointerException 入力.納入通知書制御情報、出力期、仮算定_本算定_過年度区分が null の場合
     */
    public ReportId judge納入通知書帳票ID(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報,
            RString 出力期, RString 仮算定_本算定_過年度区分) throws NullPointerException {

        requireNonNull(納入通知書制御情報, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_納入通知書制御情報.toString()));
        requireNonNull(出力期, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_出力期.toString()));
        requireNonNull(仮算定_本算定_過年度区分, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_仮算定_本算定_過年度区分.toString()));

        RString 納入通知書タイプ = get納入通知書タイプ(出力期);
        RString 過年度納入通知書タイプ = get過年度納入通知書タイプ(出力期);
        if (仮算定_区分.equals(仮算定_本算定_過年度区分)) {
            return get仮算定帳票ID(納入通知書制御情報, 納入通知書タイプ);
        } else if (本算定_区分.equals(仮算定_本算定_過年度区分)) {
            return get本算定帳票ID(納入通知書制御情報, 納入通知書タイプ);
        } else if (過年度_区分.equals(仮算定_本算定_過年度区分)) {
            return get過年度帳票ID(納入通知書制御情報, 過年度納入通知書タイプ);
        }
        return null;
    }

    private ReportId get仮算定帳票ID(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, RString 納入通知書タイプ)
            throws ApplicationException {
        if (定値_期毎.equals(納入通知書タイプ)
                && KigotoTsuchishoType.標準版期毎タイプ.equals(納入通知書制御情報.get期毎納入通知書タイプ())) {
            return ReportIdDBB.DBB100014.getReportId();
        } else if (定値_銀振型4期.equals(納入通知書タイプ)
                && GinfuriTsuchishoType.標準版銀振タイプ.equals(納入通知書制御情報.get銀振納入通知書タイプ())) {
            return ReportIdDBB.DBB100018.getReportId();
        } else if (定値_ブック.equals(納入通知書タイプ)
                && SonotaTsuchishoType.標準版ブックタイプ.equals(納入通知書制御情報.getその他納入通知書タイプ())) {
            if (HyojiUmu.表示しない.equals(納入通知書制御情報.getブック口座振替依頼表示())) {
                return ReportIdDBB.DBB100021.getReportId();
            } else if (HyojiUmu.表示する.equals(納入通知書制御情報.getブック口座振替依頼表示())) {
                return ReportIdDBB.DBB100020.getReportId();
            }
        } else if (定値_コンビニ収納.equals(納入通知書タイプ)
                && KigotoShutsuryoku.期毎出力.equals(納入通知書制御情報.getコンビニ期毎出力())) {
            return ReportIdDBB.DBB100028.getReportId();
        } else if (定値_コンビニ収納.equals(納入通知書タイプ)
                && KigotoShutsuryoku.通常出力.equals(納入通知書制御情報.getコンビニ期毎出力())) {
            if (SonotaTsuchishoType.コンビニマルチ収納タイプ.equals(納入通知書制御情報.getその他納入通知書タイプ())) {
                return ReportIdDBB.DBB100026.getReportId();
            } else if (SonotaTsuchishoType.コンビニ角公タイプ.equals(納入通知書制御情報.getその他納入通知書タイプ())) {
                return ReportIdDBB.DBB100024.getReportId();
            }
        }
        return null;
    }

    private ReportId get本算定帳票ID(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, RString 納入通知書タイプ) {
        if (定値_期毎.equals(納入通知書タイプ)
                && KigotoTsuchishoType.標準版期毎タイプ.equals(納入通知書制御情報.get期毎納入通知書タイプ())) {
            return ReportIdDBB.DBB100045.getReportId();
        } else if (定値_銀振型5期.equals(納入通知書タイプ)
                && GinfuriTsuchishoType.標準版銀振タイプ.equals(納入通知書制御情報.get銀振納入通知書タイプ())) {
            return ReportIdDBB.DBB100053.getReportId();
        } else if (定値_銀振型4期.equals(納入通知書タイプ)
                && GinfuriTsuchishoType.標準版銀振タイプ.equals(納入通知書制御情報.get銀振納入通知書タイプ())) {
            return ReportIdDBB.DBB100051.getReportId();
        } else if (定値_ブック.equals(納入通知書タイプ)
                && SonotaTsuchishoType.標準版ブックタイプ.equals(納入通知書制御情報.getその他納入通知書タイプ())) {
            if (HyojiUmu.表示しない.equals(納入通知書制御情報.getブック口座振替依頼表示())) {
                return ReportIdDBB.DBB100056.getReportId();
            } else if (HyojiUmu.表示する.equals(納入通知書制御情報.getブック口座振替依頼表示())) {
                return ReportIdDBB.DBB100055.getReportId();
            }
        } else if (定値_コンビニ収納.equals(納入通知書タイプ)
                && KigotoShutsuryoku.期毎出力.equals(納入通知書制御情報.getコンビニ期毎出力())) {
            return ReportIdDBB.DBB100063.getReportId();
        } else if (定値_コンビニ収納.equals(納入通知書タイプ)
                && KigotoShutsuryoku.通常出力.equals(納入通知書制御情報.getコンビニ期毎出力())) {
            if (SonotaTsuchishoType.コンビニマルチ収納タイプ.equals(納入通知書制御情報.getその他納入通知書タイプ())) {
                return ReportIdDBB.DBB100061.getReportId();
            } else if (SonotaTsuchishoType.コンビニ角公タイプ.equals(納入通知書制御情報.getその他納入通知書タイプ())) {
                return ReportIdDBB.DBB100059.getReportId();
            }
        }
        return null;
    }

    private ReportId get過年度帳票ID(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, RString 納入通知書タイプ) {
        if (定値_期毎.equals(納入通知書タイプ)
                && KigotoTsuchishoType.標準版期毎タイプ.equals(納入通知書制御情報.get期毎納入通知書タイプ())) {
            return ReportIdDBB.DBB100066.getReportId();
        } else if (定値_銀振型5期.equals(納入通知書タイプ)
                && GinfuriTsuchishoType.標準版銀振タイプ.equals(納入通知書制御情報.get銀振納入通知書タイプ())) {
            return ReportIdDBB.DBB100070.getReportId();
        } else if (定値_銀振型4期.equals(納入通知書タイプ)
                && GinfuriTsuchishoType.標準版銀振タイプ.equals(納入通知書制御情報.get銀振納入通知書タイプ())) {
            return ReportIdDBB.DBB100069.getReportId();
        } else if (定値_ブック.equals(納入通知書タイプ)
                && SonotaTsuchishoType.標準版ブックタイプ.equals(納入通知書制御情報.getその他納入通知書タイプ())) {
            if (HyojiUmu.表示しない.equals(納入通知書制御情報.getブック口座振替依頼表示())) {
                return ReportIdDBB.DBB100072.getReportId();
            } else if (HyojiUmu.表示する.equals(納入通知書制御情報.getブック口座振替依頼表示())) {
                return ReportIdDBB.DBB100071.getReportId();
            }
        } else if (定値_コンビニ収納.equals(納入通知書タイプ)
                && KigotoShutsuryoku.期毎出力.equals(納入通知書制御情報.getコンビニ期毎出力())) {
            return ReportIdDBB.DBB100076.getReportId();
        } else if (定値_コンビニ収納.equals(納入通知書タイプ)
                && KigotoShutsuryoku.通常出力.equals(納入通知書制御情報.getコンビニ期毎出力())) {
            if (SonotaTsuchishoType.コンビニマルチ収納タイプ.equals(納入通知書制御情報.getその他納入通知書タイプ())) {
                return ReportIdDBB.DBB100075.getReportId();
            } else if (SonotaTsuchishoType.コンビニ角公タイプ.equals(納入通知書制御情報.getその他納入通知書タイプ())) {
                return ReportIdDBB.DBB100073.getReportId();
            }
        }
        return null;
    }

    private RString get過年度納入通知書タイプ(RString 出力期) {

        RString 設定値 = 定値_0;
        RDate 運用日 = RDate.getNowDate();
        switch (Integer.parseInt(出力期.toString())) {
            case 定値_1期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の型1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_2期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の型2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_3期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の型3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_4期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の型4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_5期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の型5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_6期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の型6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_7期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の型7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_8期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の型8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_9期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の型9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_10期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の型10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_11期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の型11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_12期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_納付書の型12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return set納入通知書タイプ(設定値);
    }

    private RString get納入通知書タイプ(RString 出力期) {

        RString 設定値 = 定値_0;
        RDate 運用日 = RDate.getNowDate();
        switch (Integer.parseInt(出力期.toString())) {
            case 定値_1期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_2期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_3期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_4期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_5期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_6期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_7期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_8期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_9期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_10期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_11期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_12期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_13期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型13, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_14期:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型14, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return set納入通知書タイプ(設定値);
    }

    private RString set納入通知書タイプ(RString 設定値) {

        switch (Integer.parseInt(設定値.toString())) {
            case 設定値_番号0:
                return RString.EMPTY;
            case 定値_番号1:
                return 定値_期毎;
            case 定値_番号2:
                return 定値_銀振型5期;
            case 設定値_番号4:
                return 定値_銀振型4期;
            case 設定値_番号5:
                return 定値_ブック;
            case 設定値_番号6:
                return 定値_コンビニ収納;
            case 設定値_番号9:
                return 定値_その他;
            default:
                return RString.EMPTY;
        }
    }

    /**
     * 発行日を取得メソッドです。
     *
     * @param 発行日 FlexibleDate
     * @return 発行日 RDate
     */
    public RDate get発行日(FlexibleDate 発行日) {
        if (発行日 == null || 発行日.isEmpty()) {
            return null;
        }
        return new RDate(発行日.toString());
    }

    /**
     * 発行日を取得メソッドです。
     *
     * @param 出力期 RString
     * @return 出力期リスト List<Kitsuki>
     */
    public List<Kitsuki> get出力期リスト(RString 出力期) {

        List<Kitsuki> 出力期リスト = new ArrayList<>();
        KoseiTsukiHantei koseiTsukiHantei = new KoseiTsukiHantei();
        FuchoKiUtil fuchoKiUtil = new FuchoKiUtil();
        Kitsuki 期月 = koseiTsukiHantei.find更正月(RDate.getNowDate());
        KitsukiList 期月リスト = fuchoKiUtil.get期月リスト().filteredLater期(期月.get期AsInt());
        for (Kitsuki 期と月 : 期月リスト.toList()) {
            if (出力期.equals(期と月.get期())) {
                出力期リスト.add(期と月);
                break;
            }
        }
        return 出力期リスト;
    }

    /**
     * 空値判断メソッドです。
     *
     * @param 項目 RString
     * @return 項目 RString
     */
    public RString nullTOEmpty(RString 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return RString.EMPTY;
        }
        return 項目;
    }
}
