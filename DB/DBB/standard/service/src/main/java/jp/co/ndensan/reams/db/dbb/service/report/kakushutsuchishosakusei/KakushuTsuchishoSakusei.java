/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.kakushutsuchishosakusei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.KakushuTsuchishoCommonInfo;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.KakushuTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.business.report.KarisanteiNonyuTsuchishoCVSKigoto.KarisanteiNonyuTsuchishoCVSKigotoItem;
import jp.co.ndensan.reams.db.dbb.business.report.KarisanteiNonyuTsuchishoCVSKigoto.KarisanteiNonyuTsuchishoCVSKigotoReport;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoItem;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateItem;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.EditedHonSanteiFukaDaichoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.EditedKariSanteiFukaDaichoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.gemmen.GenmenKetteiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookItem;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriItem;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoItem;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.ShunyuJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TsuchiSho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.GinfuriTsuchishoType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KigotoShutsuryoku;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KigotoTsuchishoType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.SonotaTsuchishoType;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kakushutsuchishosakusei.KakushuTsuchishoEntityParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2018RealHakkoRirekiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei.KakushuTsuchishoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei.KakushuTsuchishoFindEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.KarisanteiNonyuTsuchishoCVSKigoto.KarisanteiNonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2006ChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2018RealHakkoRirekiDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.kakushutsuchishosakusei.IKakushuTsuchishoSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho.FukaJohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HonsanteiIkoHantei;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbb.service.report.fukadaicho.FukaDaichoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.gemmen.GenmenKetteiTsuchiShoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteifukadaicho.KarisanteiFukaDaichoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchisho.notsu.NonyuTsuchiShoJohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.dainonin.DainoninRelate;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AtesakiShubetsu;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.dainonin.DainoninRelateFinderFactory;
import jp.co.ndensan.reams.ua.uax.service.core.koza.IKozaManager;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaService;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ue.uex.service.core.NenkinTokuchoKaifuJohoManager;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.reportprinthistory.ChohyoHakkoRirekiJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.reportprinthistory.ChohyoHakkoRirekiSearchDefault;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.HakkoRirekiManagerFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 各種通知書作成（個別）クラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
public class KakushuTsuchishoSakusei extends KakushuTsuchishoSakuseiFath {

    private static final int 定値 = -1;
    private static final int 定値_番号1 = 1;
    private static final int 定値_番号2 = 2;
    private static final int 設定値_番号0 = 0;
    private static final int 設定値_番号4 = 4;
    private static final int 設定値_番号5 = 5;
    private static final int 設定値_番号6 = 6;
    private static final int 設定値_番号9 = 9;
    private static final RString 定値_0 = new RString("0");
    private static final RString 算定区分_本算定 = new RString("本算定");
    private static final RString 算定区分_仮算定 = new RString("仮算定");
    private static final RString 年度区分_現年度 = new RString("現年度");
    private static final RString 年度区分_過年度 = new RString("過年度");
    private static final RString 徴収方法_普徴のみ = new RString("普徴のみ");
    private static final RString 徴収方法_特徴のみ = new RString("特徴のみ");
    private static final RString 徴収方法_併徴 = new RString("併徴");
    private static final RString 区分_承認 = new RString("1");
    private static final RString 区分_不承認 = new RString("2");
    private static final RString 区分_取消 = new RString("3");
    private static final RString 定値_帳票分類ID = new RString("帳票分類ID");
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
    private static final RString 括弧_左 = new RString("（");
    private static final RString 定値_期 = new RString("期");
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
    private static final ReportId 特別徴収開始通知書仮算定_帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final ReportId 仮算定額変更通知書_帳票分類ID = new ReportId("DBB100010_KarisanteiHenkoTsuchishoDaihyo");
    private static final ReportId 保険料納入通知書仮算定_帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private static final ReportId 賦課台帳仮算定_帳票分類ID = new ReportId("DBB100031_KarisanteiFukaDaicho");
    private static final ReportId 特別徴収開始通知書本算定_帳票分類ID = new ReportId("DBB100032_TokubetsuChoshuKaishiTsuchishoDaihyo");
    private static final ReportId 保険料納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final ReportId 決定通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final ReportId 介護保険料減免決定通知書_帳票分類ID
            = new ReportId("DBB100077_KaigoHokenHokenryoGenmenKetteiTsuchishoDaihyo");
    private static final ReportId 介護保険料減免取消通知書_帳票分類ID
            = new ReportId("DBB100079_KaigoHokenHokenryoGenmenTorikeshiTsuchishoDaihyo");
    private static final ReportId 介護保険料徴収猶予決定通知書_帳票分類ID
            = new ReportId("DBB100081_KaigoHokenHokenryoChoshuyoyoKetteiTsuchishoDaihyo");
    private static final ReportId 介護保険料徴収猶予取消通知書_帳票分類ID
            = new ReportId("DBB100083_KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoDaihyo");
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString 項目名 = new RString("通知書タイプ");
    private static final RString 通知書タイプ_B5横 = new RString("001");
    private static final RString 通知書タイプ_B5横オーバレイ = new RString("002");
    private static final RString 通知書タイプ_A4縦 = new RString("002");
    private static final RString 通知書タイプ_A4縦オーバレイ = new RString("003");
    private static final RString 通知書タイプ_シーラ = new RString("101");
    private static final RString キー_被保険者番号 = new RString("hihokenshaNo");
    private static final RString キー_賦課年度 = new RString("fukaNendo");
    private final MapperProvider mapperProvider;
    private final DbT2004GemmenDac 介護賦課減免Dac;
    private final DbT2006ChoshuYuyoDac 介護賦課徴収猶予Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private final DbT2018RealHakkoRirekiDac リアル発行履歴Dac;

    /**
     * コンストラクタです。
     */
    public KakushuTsuchishoSakusei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護賦課減免Dac = InstanceProvider.create(DbT2004GemmenDac.class);
        this.介護賦課徴収猶予Dac = InstanceProvider.create(DbT2006ChoshuYuyoDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.リアル発行履歴Dac = InstanceProvider.create(DbT2018RealHakkoRirekiDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KakushuTsuchishoSakusei}のインスタンスを返します。
     *
     * @return KakushuTsuchishoSakusei
     */
    public static KakushuTsuchishoSakusei createInstance() {
        return InstanceProvider.create(KakushuTsuchishoSakusei.class);
    }

    /**
     * 発行可能通知書判定メソッドです。
     *
     * @param 賦課の情報 賦課の情報
     * @return 発行する帳票リスト
     */
    public List<RString> get帳票リスト(FukaJoho 賦課の情報) {

        if (賦課の情報 == null) {
            return null;
        }
        RString 算定区分;
        RString 年度区分;
        RString 徴収方法 = null;
        HonsanteiIkoHantei honsanteiIkoHantei = HonsanteiIkoHantei.createInstance();
        if (honsanteiIkoHantei.is本算定後(賦課の情報)) {
            算定区分 = 算定区分_本算定;
            if (賦課の情報.get賦課年度().isBefore(賦課の情報.get調定年度())) {
                年度区分 = 年度区分_過年度;
                徴収方法 = 徴収方法_普徴のみ;
            } else {
                年度区分 = 年度区分_現年度;
            }
        } else {
            算定区分 = 算定区分_仮算定;
            年度区分 = 年度区分_現年度;
        }
        if (年度区分_現年度.equals(年度区分)) {
            徴収方法 = get徴収方法(賦課の情報);
        }
        List<RString> 発行する帳票List = get通知書(算定区分, 年度区分, 徴収方法);

        RString 減免通知書 = get減免通知書(賦課の情報);
        if (減免通知書 != null) {
            発行する帳票List.add(減免通知書);
        }
        RString 徴収猶予通知書 = get徴収猶予通知書(賦課の情報);
        if (徴収猶予通知書 != null) {
            発行する帳票List.add(徴収猶予通知書);
        }
        return 発行する帳票List;
    }

    private RString get徴収方法(FukaJoho 賦課の情報) {

        List<Decimal> 特徴期別金額List = new ArrayList<>();
        特徴期別金額List.add(賦課の情報.get特徴期別金額01());
        特徴期別金額List.add(賦課の情報.get特徴期別金額02());
        特徴期別金額List.add(賦課の情報.get特徴期別金額03());
        特徴期別金額List.add(賦課の情報.get特徴期別金額04());
        特徴期別金額List.add(賦課の情報.get特徴期別金額05());
        特徴期別金額List.add(賦課の情報.get特徴期別金額06());
        List<Decimal> 普徴期別金額List = new ArrayList<>();
        普徴期別金額List.add(賦課の情報.get普徴期別金額01());
        普徴期別金額List.add(賦課の情報.get普徴期別金額02());
        普徴期別金額List.add(賦課の情報.get普徴期別金額03());
        普徴期別金額List.add(賦課の情報.get普徴期別金額04());
        普徴期別金額List.add(賦課の情報.get普徴期別金額05());
        普徴期別金額List.add(賦課の情報.get普徴期別金額06());
        普徴期別金額List.add(賦課の情報.get普徴期別金額07());
        普徴期別金額List.add(賦課の情報.get普徴期別金額08());
        普徴期別金額List.add(賦課の情報.get普徴期別金額09());
        普徴期別金額List.add(賦課の情報.get普徴期別金額10());
        普徴期別金額List.add(賦課の情報.get普徴期別金額11());
        普徴期別金額List.add(賦課の情報.get普徴期別金額12());
        普徴期別金額List.add(賦課の情報.get普徴期別金額13());
        普徴期別金額List.add(賦課の情報.get普徴期別金額14());
        boolean 特徴フラグ = get方法フラグ(特徴期別金額List);
        boolean 普徴フラグ = get方法フラグ(普徴期別金額List);
        if (特徴フラグ && 普徴フラグ) {
            return 徴収方法_併徴;
        } else if (特徴フラグ) {
            return 徴収方法_特徴のみ;
        }
        return 徴収方法_普徴のみ;
    }

    private boolean get方法フラグ(List<Decimal> 期別金額List) {

        for (Decimal 期別金額 : 期別金額List) {
            if (期別金額.compareTo(Decimal.ONE) != 定値) {
                return true;
            }
        }
        return false;
    }

    private List<RString> get通知書(RString 算定区分, RString 年度区分, RString 徴収方法) {

        List<RString> 発行する帳票List = new ArrayList<>();
        if (算定区分_仮算定.equals(算定区分)) {
            if (徴収方法_特徴のみ.equals(徴収方法)) {
                発行する帳票List.add(TsuchiSho.特別徴収開始通知書_仮算定.get名称());
                発行する帳票List.add(TsuchiSho.仮算定額変更通知書.get名称());
                発行する帳票List.add(TsuchiSho.賦課台帳_仮算定.get名称());
            } else if (徴収方法_普徴のみ.equals(徴収方法)) {
                発行する帳票List.add(TsuchiSho.仮算定額変更通知書.get名称());
                発行する帳票List.add(TsuchiSho.保険料納入通知書_仮算定.get名称());
                発行する帳票List.add(TsuchiSho.賦課台帳_仮算定.get名称());
                発行する帳票List.add(TsuchiSho.郵便振替納付書.get名称());
            } else if (徴収方法_併徴.equals(徴収方法)) {
                発行する帳票List.add(TsuchiSho.特別徴収開始通知書_仮算定.get名称());
                発行する帳票List.add(TsuchiSho.仮算定額変更通知書.get名称());
                発行する帳票List.add(TsuchiSho.保険料納入通知書_仮算定.get名称());
                発行する帳票List.add(TsuchiSho.賦課台帳_仮算定.get名称());
                発行する帳票List.add(TsuchiSho.郵便振替納付書.get名称());
            }
        } else if (算定区分_本算定.equals(算定区分) && 年度区分_現年度.equals(年度区分)) {
            if (徴収方法_特徴のみ.equals(徴収方法)) {
                発行する帳票List.add(TsuchiSho.特別徴収開始通知書_本算定.get名称());
                発行する帳票List.add(TsuchiSho.介護保険料額決定通知書.get名称());
                発行する帳票List.add(TsuchiSho.介護保険料額変更兼特別徴収中止通知書.get名称());
                発行する帳票List.add(TsuchiSho.賦課台帳_本算定.get名称());
            } else if (徴収方法_普徴のみ.equals(徴収方法)) {
                発行する帳票List.add(TsuchiSho.介護保険料額決定通知書.get名称());
                発行する帳票List.add(TsuchiSho.介護保険料額変更兼特別徴収中止通知書.get名称());
                発行する帳票List.add(TsuchiSho.保険料納入通知書_本算定.get名称());
                発行する帳票List.add(TsuchiSho.賦課台帳_本算定.get名称());
                発行する帳票List.add(TsuchiSho.郵便振替納付書.get名称());
            } else if (徴収方法_併徴.equals(徴収方法)) {
                発行する帳票List.add(TsuchiSho.特別徴収開始通知書_本算定.get名称());
                発行する帳票List.add(TsuchiSho.介護保険料額決定通知書.get名称());
                発行する帳票List.add(TsuchiSho.介護保険料額変更兼特別徴収中止通知書.get名称());
                発行する帳票List.add(TsuchiSho.賦課台帳_本算定.get名称());
                発行する帳票List.add(TsuchiSho.保険料納入通知書_本算定.get名称());
                発行する帳票List.add(TsuchiSho.郵便振替納付書.get名称());
            }
        } else if (算定区分_本算定.equals(算定区分) && 年度区分_過年度.equals(年度区分)) {
            発行する帳票List.add(TsuchiSho.保険料納入通知書_過年度.get名称());
            発行する帳票List.add(TsuchiSho.介護保険料額決定通知書_過年度.get名称());
            発行する帳票List.add(TsuchiSho.介護保険料額変更兼特別徴収中止通知書_過年度.get名称());
            発行する帳票List.add(TsuchiSho.郵便振替納付書.get名称());
        }
        return 発行する帳票List;
    }

    private RString get減免通知書(FukaJoho 賦課の情報) {

        DbT2004GemmenEntity entity
                = 介護賦課減免Dac.get減免の情報(賦課の情報.get調定年度(), 賦課の情報.get賦課年度(), 賦課の情報.get通知書番号());
        if (entity == null) {
            return null;
        }
        RString 減免状態区分 = entity.getJotaiKubun();
        RString 減免作成区分 = entity.getSakuseiKubun();
        if ((区分_承認.equals(減免状態区分) && 区分_承認.equals(減免作成区分))
                || (区分_不承認.equals(減免状態区分) && 区分_不承認.equals(減免作成区分))) {
            return TsuchiSho.介護保険料減免決定通知書.get名称();
        } else if ((区分_承認.equals(減免状態区分) || 区分_不承認.equals(減免状態区分))
                && 区分_取消.equals(減免作成区分)) {
            return TsuchiSho.介護保険料減免取消通知書.get名称();
        } else {
            return null;
        }
    }

    private RString get徴収猶予通知書(FukaJoho 賦課の情報) {
        DbT2006ChoshuYuyoEntity entity
                = 介護賦課徴収猶予Dac.get徴収猶予の情報(賦課の情報.get調定年度(), 賦課の情報.get賦課年度(), 賦課の情報.get通知書番号());
        if (entity == null) {
            return null;
        }
        RString 徴収猶予状態区分 = entity.getJotaiKubun();
        RString 徴収猶予作成区分 = entity.getSakuseiKubun();
        if ((区分_承認.equals(徴収猶予状態区分) && 区分_承認.equals(徴収猶予作成区分))
                || (区分_不承認.equals(徴収猶予状態区分) && 区分_不承認.equals(徴収猶予作成区分))) {
            return TsuchiSho.介護保険料徴収猶予決定通知書.get名称();
        } else if ((区分_承認.equals(徴収猶予状態区分) || 区分_不承認.equals(徴収猶予状態区分))
                && 区分_取消.equals(徴収猶予作成区分)) {
            return TsuchiSho.介護保険料徴収猶予取消通知書.get名称();
        } else {
            return null;
        }
    }

    /**
     * 通知書発行メソッドです。
     *
     * @param parameter parameter
     * @return SourceDataCollection
     */
    public SourceDataCollection publish(KakushuTsuchishoParameter parameter) {

        if (parameter == null || parameter.get発行する帳票List() == null || parameter.get発行する帳票List().isEmpty()) {
            return null;
        }
        KakushuTsuchishoCommonInfo 通知書共通情報 = search通知書共通情報(parameter);

        List<RString> 発行する帳票List = parameter.get発行する帳票List();
        for (RString 発行する帳票 : 発行する帳票List) {
            publish通知書発行(parameter, 発行する帳票, 通知書共通情報);
        }
        return null;
    }

    private void publish通知書発行(KakushuTsuchishoParameter parameter, RString 発行する帳票,
            KakushuTsuchishoCommonInfo 通知書共通情報) {
        if (TsuchiSho.特別徴収開始通知書_仮算定.get名称().equals(発行する帳票)) {
            publish特別徴収開始通知書仮算定(parameter, 通知書共通情報);
        } else if (TsuchiSho.仮算定額変更通知書.get名称().equals(発行する帳票)) {
            publish仮算定額変更通知書(parameter, 通知書共通情報);
        } else if (TsuchiSho.保険料納入通知書_仮算定.get名称().equals(発行する帳票)) {
            publish保険料納入通知書仮算定(parameter, 通知書共通情報);
        } else if (TsuchiSho.賦課台帳_仮算定.get名称().equals(発行する帳票)) {
            publish賦課台帳仮算定(parameter, 通知書共通情報);
        } else if (TsuchiSho.特別徴収開始通知書_本算定.get名称().equals(発行する帳票)) {
            publish特別徴収開始通知書本算定(parameter, 通知書共通情報);
        } else if (TsuchiSho.介護保険料額決定通知書.get名称().equals(発行する帳票)
                || TsuchiSho.介護保険料額決定通知書_過年度.get名称().equals(発行する帳票)) {
            publish介護保険料額決定通知書(parameter, 通知書共通情報);
        } else if (TsuchiSho.介護保険料額変更兼特別徴収中止通知書.get名称().equals(発行する帳票)
                || TsuchiSho.介護保険料額変更兼特別徴収中止通知書_過年度.get名称().equals(発行する帳票)) {
            publish介護保険料額変更兼特別徴収中止通知書(parameter, 通知書共通情報);
        } else if (TsuchiSho.保険料納入通知書_本算定.get名称().equals(発行する帳票)) {
            publish保険料納入通知書本算定(parameter, 通知書共通情報, 本算定_区分);
        } else if (TsuchiSho.保険料納入通知書_過年度.get名称().equals(発行する帳票)) {
            publish保険料納入通知書本算定(parameter, 通知書共通情報, 過年度_区分);
        } else if (TsuchiSho.賦課台帳_本算定.get名称().equals(発行する帳票)) {
            publish賦課台帳本算定(parameter, 通知書共通情報);
        } else if (TsuchiSho.介護保険料減免決定通知書.get名称().equals(発行する帳票)) {
            publish介護保険料減免決定通知書(parameter, 通知書共通情報);
        } else if (TsuchiSho.介護保険料減免取消通知書.get名称().equals(発行する帳票)) {
            publish介護保険料減免取消通知書(parameter, 通知書共通情報);
        } else if (TsuchiSho.介護保険料徴収猶予決定通知書.get名称().equals(発行する帳票)) {
            publish介護保険料徴収猶予決定通知書(parameter, 通知書共通情報);
        } else if (TsuchiSho.介護保険料徴収猶予取消通知書.get名称().equals(発行する帳票)) {
            publish介護保険料徴収猶予取消通知書(parameter, 通知書共通情報);
        }
    }

    /**
     * 特別徴収開始通知書（仮算定）発行メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return SourceDataCollection
     */
    public SourceDataCollection publish特別徴収開始通知書仮算定(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(特別徴収開始通知書仮算定_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return null;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100003.getReportId();
        } else if (通知書タイプ_B5横オーバレイ.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100009.getReportId();
        } else if (通知書タイプ_A4縦オーバレイ.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100008.getReportId();
        } else if (通知書タイプ_シーラ.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100005.getReportId();
        }
        if (帳票ID == null) {
            return null;
        }
        KariSanteiTsuchiShoKyotsu 仮算定通知書情報 = new KariSanteiTsuchiShoKyotsu();
        仮算定通知書情報.set発行日(parameter.get特徴開始通知書_発行日());
        仮算定通知書情報.set帳票分類ID(特別徴収開始通知書仮算定_帳票分類ID);
        仮算定通知書情報.set帳票ID(帳票ID);
        仮算定通知書情報.set処理区分(ShoriKubun.リアル);
        仮算定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        仮算定通知書情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前());
        仮算定通知書情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後());
        仮算定通知書情報.set納組情報(通知書共通情報.get納組情報());
        仮算定通知書情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報List());
        仮算定通知書情報.set特徴納期情報リスト(通知書共通情報.get特徴収入情報List());
        仮算定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        仮算定通知書情報.set前年度賦課情報(find前年度賦課(通知書共通情報.get賦課の情報_更正後().get賦課情報()));
        仮算定通知書情報.set口座情報(通知書共通情報.get口座情報());
        仮算定通知書情報.set徴収方法情報_更正前(通知書共通情報.get徴収方法情報_更正前());
        仮算定通知書情報.set徴収方法情報_更正後(通知書共通情報.get徴収方法情報_更正後());
        仮算定通知書情報.set対象者_追加含む_情報_更正前(通知書共通情報.get対象者_追加含む_の情報_更正前());
        仮算定通知書情報.set対象者_追加含む_情報_更正後(通知書共通情報.get対象者_追加含む_の情報_更正後());
        //仮算定通知書情報.set収入情報(通知書共通情報.get収入情報());
        DbT7065ChohyoSeigyoKyotsuEntity entity = load帳票制御共通(仮算定額変更通知書_帳票分類ID);
        if (entity != null) {
            仮算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(load帳票制御共通(特別徴収開始通知書仮算定_帳票分類ID)));
        }

        KariSanteiTsuchiShoKyotsuKomokuHenshu 賦課帳票共通項目編集 = InstanceProvider.create(KariSanteiTsuchiShoKyotsuKomokuHenshu.class);
        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 賦課帳票共通項目編集.create仮算定通知書共通情報(仮算定通知書情報);

        KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報 = new KariTokuchoKaishiTsuchisyoJoho();
        仮算定特徴開始通知書情報.set発行日(parameter.get特徴開始通知書_発行日());
        仮算定特徴開始通知書情報.set帳票分類ID(特別徴収開始通知書仮算定_帳票分類ID);
        仮算定特徴開始通知書情報.set帳票ID(帳票ID);
        仮算定特徴開始通知書情報.set編集後仮算定通知書共通情報(編集後仮算定通知書共通情報);
        仮算定特徴開始通知書情報.set宛先情報(通知書共通情報.get宛先情報());
//        仮算定特徴開始通知書情報.set処理区分(ShoriKubun.リアル);
//        仮算定特徴開始通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());

        RString 通知文1 = RString.EMPTY;
        RString 通知文2 = RString.EMPTY;
        FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
        if (仮算定通知書情報.get帳票制御共通() != null
                && !nullTOEmpty(仮算定通知書情報.get帳票制御共通().get定型文文字サイズ()).isEmpty()) {
            int パターン番号 = Integer.parseInt(nullTOEmpty(仮算定通知書情報.get帳票制御共通().get定型文文字サイズ()).toString());
            TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
            TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo
                    = manager.get通知書定形文検索(SubGyomuCode.DBB介護賦課, 特別徴収開始通知書仮算定_帳票分類ID,
                            KamokuCode.EMPTY, パターン番号, 定値_番号1, システム日付);
            if (tsuchishoTeikeibunInfo != null) {
                通知文1 = tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
            }
            tsuchishoTeikeibunInfo = manager.get通知書定形文検索(SubGyomuCode.DBB介護賦課, 特別徴収開始通知書仮算定_帳票分類ID,
                    KamokuCode.EMPTY, パターン番号, 定値_番号2, システム日付);
            if (tsuchishoTeikeibunInfo != null) {
                通知文2 = tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
            }
        }
        SourceDataCollection sourceDataCollection;
        if (ReportIdDBB.DBB100003.getReportId().equals(帳票ID)) {
            sourceDataCollection
                    = new TokubetsuChoshuKaishiTsuchishoKariPrintService().printB5横タイプ(仮算定特徴開始通知書情報, 仮算定通知書情報, null);
        } else if (ReportIdDBB.DBB100005.getReportId().equals(帳票ID)) {
            sourceDataCollection
                    = new TokubetsuChoshuKaishiTsuchishoKariPrintService().printシーラタイプ(仮算定特徴開始通知書情報, 仮算定通知書情報);
        } else if (ReportIdDBB.DBB100008.getReportId().equals(帳票ID)) {
            sourceDataCollection
                    = new TokubetsuChoshuKaishiTsuchishoKariPrintService()
                    .printA4縦オーバーレイタイプ(仮算定特徴開始通知書情報, 仮算定通知書情報, 通知文1);
        } else {
            sourceDataCollection
                    = new TokubetsuChoshuKaishiTsuchishoKariPrintService()
                    .printB5横オーバレイタイプ(仮算定特徴開始通知書情報, 仮算定通知書情報, 通知文1, 通知文2);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()), new RString(帳票ID.value().toString()));
        save帳票発行履歴(sourceDataCollection, parameter.get特徴開始通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 特別徴収開始通知書仮算定_帳票分類ID);
        return sourceDataCollection;
    }

    /**
     * 仮算定額変更通知書発行メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return SourceDataCollection
     */
    public SourceDataCollection publish仮算定額変更通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {
        ChohyoSeigyoHanyo 帳票制御汎用
                = load帳票制御汎用ByKey(仮算定額変更通知書_帳票分類ID, parameter.get賦課の情報_更正後().get調定年度(), 項目名);
        if (帳票制御汎用 == null) {
            return null;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100010.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100011.getReportId();
        }
        if (帳票ID == null) {
            return null;
        }
        KariSanteiTsuchiShoKyotsu 仮算定通知書情報 = new KariSanteiTsuchiShoKyotsu();
        仮算定通知書情報.set発行日(parameter.get変更通知書_発行日());
        仮算定通知書情報.set帳票分類ID(仮算定額変更通知書_帳票分類ID);
        仮算定通知書情報.set帳票ID(帳票ID);
        仮算定通知書情報.set処理区分(ShoriKubun.リアル);
        仮算定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        仮算定通知書情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前());
        仮算定通知書情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後());
        仮算定通知書情報.set納組情報(通知書共通情報.get納組情報());
        仮算定通知書情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報List());
        仮算定通知書情報.set特徴納期情報リスト(通知書共通情報.get特徴収入情報List());
        仮算定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        仮算定通知書情報.set前年度賦課情報(find前年度賦課(通知書共通情報.get賦課の情報_更正後().get賦課情報()));
        仮算定通知書情報.set口座情報(通知書共通情報.get口座情報());
        仮算定通知書情報.set徴収方法情報_更正前(通知書共通情報.get徴収方法情報_更正前());
        仮算定通知書情報.set徴収方法情報_更正後(通知書共通情報.get徴収方法情報_更正後());
        仮算定通知書情報.set対象者_追加含む_情報_更正前(通知書共通情報.get対象者_追加含む_の情報_更正前());
        仮算定通知書情報.set対象者_追加含む_情報_更正後(通知書共通情報.get対象者_追加含む_の情報_更正後());
        //仮算定通知書情報.set収入情報(通知書共通情報.get収入情報());
        DbT7065ChohyoSeigyoKyotsuEntity entity = load帳票制御共通(仮算定額変更通知書_帳票分類ID);
        if (entity != null) {
            仮算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(load帳票制御共通(仮算定額変更通知書_帳票分類ID)));
        }

        KariSanteiTsuchiShoKyotsuKomokuHenshu 賦課帳票共通項目編集 = InstanceProvider.create(KariSanteiTsuchiShoKyotsuKomokuHenshu.class);
        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 賦課帳票共通項目編集.create仮算定通知書共通情報(仮算定通知書情報);

        KariTokuchoKaishiTsuchisyoJoho 仮算定額変更通知書情報 = new KariTokuchoKaishiTsuchisyoJoho();
        仮算定額変更通知書情報.set発行日(parameter.get変更通知書_発行日());
        仮算定額変更通知書情報.set帳票分類ID(仮算定額変更通知書_帳票分類ID);
        仮算定額変更通知書情報.set帳票ID(帳票ID);
        仮算定額変更通知書情報.set編集後仮算定通知書共通情報(編集後仮算定通知書共通情報);
        仮算定額変更通知書情報.set宛先情報(通知書共通情報.get宛先情報());

        SourceDataCollection sourceDataCollection;
        if (ReportIdDBB.DBB100010.getReportId().equals(帳票ID)) {
            //パラメータ：通知書タイプ 文書番号 仮算定特徴開始通知書情報
            List<KarisanteiHenkoTsuchishoB5YokoItem> items = new ArrayList<>();
            KarisanteiHenkoTsuchishoB5YokoReport report
                    = KarisanteiHenkoTsuchishoB5YokoReport.createFrom(items);
            //TokubetsuChoshuKaishiTsuchishoKariB5Property property = new TokubetsuChoshuKaishiTsuchishoKariB5Property();
            sourceDataCollection = new Printer<KarisanteiHenkoTsuchishoB5YokoReportSource>().spool(null, report);
        } else {
            //パラメータ：通知書タイプ 文書番号 仮算定特徴開始通知書情報
            List<KarisanteiHenkoTsuchishoA4TateItem> items = new ArrayList<>();
            KarisanteiHenkoTsuchishoA4TateReport report
                    = KarisanteiHenkoTsuchishoA4TateReport.createFrom(items);
            //TokubetsuChoshuKaishiTsuchishoKariB5Property property = new TokubetsuChoshuKaishiTsuchishoKariB5Property();
            sourceDataCollection = new Printer<KarisanteiHenkoTsuchishoA4TateReportSource>().spool(null, report);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()), new RString(帳票ID.value().toString()));
        save帳票発行履歴(sourceDataCollection, parameter.get変更通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 仮算定額変更通知書_帳票分類ID);
        return sourceDataCollection;
    }

    /**
     * 保険料納入通知書（仮算定）発行メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return SourceDataCollection
     */
    public SourceDataCollection publish保険料納入通知書仮算定(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {
        NonyuTsuchiShoSeigyoJohoLoaderFinder finder = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance();
        KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報 = finder.get仮算定納入通知書制御情報();
        RString 出力期 = parameter.get納入通知書_出力期();
        ReportId 帳票ID = judge納入通知書帳票ID(仮算定納入通知書制御情報.get納入通知書制御情報(), 出力期, 仮算定_区分);
        if (帳票ID == null) {
            return null;
        }

        KariSanteiTsuchiShoKyotsu 仮算定通知書情報 = new KariSanteiTsuchiShoKyotsu();
        仮算定通知書情報.set発行日(parameter.get納入通知書_発行日());
        仮算定通知書情報.set帳票分類ID(保険料納入通知書仮算定_帳票分類ID);
        仮算定通知書情報.set帳票ID(帳票ID);
        仮算定通知書情報.set処理区分(ShoriKubun.リアル);
        仮算定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        //仮算定通知書情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前().toEntity());
        //仮算定通知書情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後().toEntity());
        仮算定通知書情報.set納組情報(通知書共通情報.get納組情報());
        仮算定通知書情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報List());
        仮算定通知書情報.set特徴納期情報リスト(通知書共通情報.get特徴収入情報List());
        仮算定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        //仮算定通知書情報.set前年度賦課情報(find前年度賦課(通知書共通情報.get賦課の情報_更正後()));
        仮算定通知書情報.set口座情報(通知書共通情報.get口座情報());
//        仮算定通知書情報.set徴収方法情報_更正前(通知書共通情報.get徴収方法情報_更正前());
//        仮算定通知書情報.set徴収方法情報_更正後(通知書共通情報.get徴収方法情報_更正後());
        //TODO 対象者（追加含む）情報（更正前）
        //TODO 対象者（追加含む）情報（更正後）
        //仮算定通知書情報.set対象者_追加含む_の情報_更正前(通知書共通情報.get対象者_追加含む_の情報_更正前());
        //仮算定通知書情報.set対象者_追加含む_の情報_更正後(通知書共通情報.get対象者_追加含む_の情報_更正後());

        //TODO 収入情報
        ShunyuJoho 収入情報 = null;
        仮算定通知書情報.set収入情報(収入情報);
        仮算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(load帳票制御共通(保険料納入通知書仮算定_帳票分類ID)));

        //TODO 出力期リスト?
        List<Kitsuki> 出力期リスト = parameter.get納入通知書出力期リスト();
        IName 代納人氏名 = null;
        if (AtesakiShubetsu.代納人.equals(通知書共通情報.get宛先情報().get宛先種別())) {
            代納人氏名 = 通知書共通情報.get宛先情報().get宛先名称();
        } else if (AtesakiShubetsu.代納人送付先.equals(通知書共通情報.get宛先情報().get宛先種別())) {
            List<GyomuCode> list = new ArrayList<>();
            list.add(GyomuCode.DB介護保険);
            List<DainoninRelate> 代納人情報リスト = DainoninRelateFinderFactory.createInstance().get代納人byサブ業務コード(
                    通知書共通情報.get宛先情報().get識別コード(), list, SubGyomuCode.DBB介護賦課);
            if (代納人情報リスト != null && !代納人情報リスト.isEmpty()) {
                代納人氏名 = 代納人情報リスト.get(0).get識別対象().get名称();
            }
        }
        if (出力期リスト == null || 代納人氏名 == null) {
            return null;
        }
        NonyuTsuchiShoJohoFactory nonyuTsuchiShoJohoFactory = InstanceProvider.create(NonyuTsuchiShoJohoFactory.class);
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報
                = nonyuTsuchiShoJohoFactory.create仮算定納入通知書情報(仮算定通知書情報, 仮算定納入通知書制御情報, 出力期リスト, 代納人氏名);

        SourceDataCollection sourceDataCollection;
        if (ReportIdDBB.DBB100014.getReportId().equals(帳票ID)) {
            KarisanteiHokenryoNonyuTsuchishoKigotoItem item = new KarisanteiHokenryoNonyuTsuchishoKigotoItem(仮算定納入通知書情報, null);
            KarisanteiHokenryoNonyuTsuchishoKigotoReport report
                    = KarisanteiHokenryoNonyuTsuchishoKigotoReport.createFrom(item);
            sourceDataCollection = new Printer<KarisanteiHokenryoNonyuTsuchishoKigotoSource>().spool(null, report);
        } else if (ReportIdDBB.DBB100018.getReportId().equals(帳票ID)) {
            KarisanteiHokenryoNonyuTsuchishoGinfuriItem item = new KarisanteiHokenryoNonyuTsuchishoGinfuriItem(仮算定納入通知書情報, null);
            KarisanteiHokenryoNonyuTsuchishoGinfuriReport report
                    = KarisanteiHokenryoNonyuTsuchishoGinfuriReport.createFrom(item);
            sourceDataCollection = new Printer<KarisanteiHokenryoNonyuTsuchishoGinfuriSource>().spool(null, report);
        } else if (ReportIdDBB.DBB100021.getReportId().equals(帳票ID)) {
            HokenryoNonyuTsuchishoBookItem item = new HokenryoNonyuTsuchishoBookItem(仮算定納入通知書情報, null);
            KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport report
                    = KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport.createFrom(item);
            sourceDataCollection = new Printer<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource>().spool(null, report);
        } else if (ReportIdDBB.DBB100020.getReportId().equals(帳票ID)) {
            HokenryoNonyuTsuchishoBookItem item = new HokenryoNonyuTsuchishoBookItem(仮算定納入通知書情報, null);
            KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport report
                    = KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport.createFrom(item);
            sourceDataCollection = new Printer<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource>().spool(null, report);
        } else if (ReportIdDBB.DBB100026.getReportId().equals(帳票ID)) {
//            KarisanteiNonyuTsuchishoCVSMultiReport report
//                    = KarisanteiNonyuTsuchishoCVSMultiReport.createFrom(null);
            sourceDataCollection = null;
//            sourceDataCollection = new Printer<KarisanteiNonyuTsuchishoCVSMultiSource>().spool(null, report);
        } else if (ReportIdDBB.DBB100024.getReportId().equals(帳票ID)) {
            KarisanteiNonyuTsuchishoCVSKakukoReport report
                    = KarisanteiNonyuTsuchishoCVSKakukoReport.createFrom(null);
            sourceDataCollection = new Printer<KarisanteiNonyuTsuchishoCVSKakukoSource>().spool(null, report);
        } else {
            KarisanteiNonyuTsuchishoCVSKigotoItem item = new KarisanteiNonyuTsuchishoCVSKigotoItem(仮算定納入通知書情報, null);
            KarisanteiNonyuTsuchishoCVSKigotoReport report
                    = KarisanteiNonyuTsuchishoCVSKigotoReport.createFrom(item);
            sourceDataCollection = new Printer<KarisanteiNonyuTsuchishoCVSKigotoSource>().spool(null, report);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()), new RString(帳票ID.value().toString()));
        save帳票発行履歴(sourceDataCollection, parameter.get納入通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 保険料納入通知書仮算定_帳票分類ID);
        return sourceDataCollection;
    }

    /**
     * 賦課台帳（仮算定）発行メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return SourceDataCollection
     */
    public SourceDataCollection publish賦課台帳仮算定(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {

        //1.１　賦課台帳情報の作成
        //1.２　編集後仮算定賦課台帳情報の作成(FukaDaichoDataHenshu未製造)
        EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報 = null;
        SourceDataCollection sourceDataCollection = new KarisanteiFukaDaichoPrintService().print(編集後仮算定賦課台帳情報);

        FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()),
                new RString(ReportIdDBB.DBB100031.getReportId().value().toString()));
        save帳票発行履歴(sourceDataCollection, システム日付, 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 賦課台帳仮算定_帳票分類ID);
        return sourceDataCollection;
    }

    /**
     * 特別徴収開始通知書（本算定）発行メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return SourceDataCollection
     */
    public SourceDataCollection publish特別徴収開始通知書本算定(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(特別徴収開始通知書本算定_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return null;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100032.getReportId();
        } else if (通知書タイプ_B5横オーバレイ.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100036.getReportId();
        } else if (通知書タイプ_A4縦オーバレイ.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100038.getReportId();
        } else if (通知書タイプ_シーラ.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100034.getReportId();
        }
        if (帳票ID == null) {
            return null;
        }

        HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
        HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
        本算定通知書情報.set現年度_過年度区分(通知書共通情報.get年度区分());
        本算定通知書情報.set発行日(new RDate(parameter.get特徴開始通知書_発行日().toString()));
        本算定通知書情報.set帳票分類ID(特別徴収開始通知書本算定_帳票分類ID);
        本算定通知書情報.set帳票ID(帳票ID);
        本算定通知書情報.set処理区分(ShoriKubun.リアル);
        本算定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        //本算定通知書情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前().toEntity());
        //本算定通知書情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後().toEntity());
        本算定通知書情報.set納組情報(通知書共通情報.get納組情報());
        本算定通知書情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報List());
        本算定通知書情報.set特徴納期情報リスト(通知書共通情報.get特徴収入情報List());
        本算定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        本算定通知書情報.set口座情報(通知書共通情報.get口座情報());
//        本算定通知書情報.set徴収方法情報_更正前(通知書共通情報.get徴収方法情報_更正前());
//        本算定通知書情報.set徴収方法情報_更正後(通知書共通情報.get徴収方法情報_更正後());
        //本算定通知書情報.set対象者_追加含む_の情報_更正前(通知書共通情報.get対象者_追加含む_の情報_更正前());
        //本算定通知書情報.set対象者_追加含む_の情報_更正後(通知書共通情報.get対象者_追加含む_の情報_更正後());

        //TODO 収入情報
        ShunyuJoho 収入情報 = null;
        本算定通知書情報.set収入情報(収入情報);
        DbT7065ChohyoSeigyoKyotsuEntity entity = load帳票制御共通(特別徴収開始通知書本算定_帳票分類ID);
        if (entity != null) {
            本算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(entity));
        }
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定共通情報作成.create本算定通知書共通情報(本算定通知書情報);

        SourceDataCollection sourceDataCollection;
        if (ReportIdDBB.DBB100032.getReportId().equals(帳票ID)) {
            sourceDataCollection
                    = new TokubetsuChoshuKaishiTsuchishoPrintService().printB5横タイプ(編集後本算定通知書共通情報, null, 本算定通知書情報);
        } else if (ReportIdDBB.DBB100036.getReportId().equals(帳票ID)) {
            sourceDataCollection
                    = new TokubetsuChoshuKaishiTsuchishoPrintService().printB5横タイプ2(編集後本算定通知書共通情報, null, 本算定通知書情報);
        } else if (ReportIdDBB.DBB100038.getReportId().equals(帳票ID)) {
            sourceDataCollection
                    = new TokubetsuChoshuKaishiTsuchishoPrintService().printA4縦(編集後本算定通知書共通情報, null, 本算定通知書情報);
        } else {
            sourceDataCollection
                    = new TokubetsuChoshuKaishiTsuchishoPrintService().printシーラタイプ(編集後本算定通知書共通情報, 本算定通知書情報);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()), new RString(帳票ID.value().toString()));
        save帳票発行履歴(sourceDataCollection, parameter.get特徴開始通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 特別徴収開始通知書本算定_帳票分類ID);
        return sourceDataCollection;
    }

    /**
     * 介護保険料額決定通知書発行メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return SourceDataCollection
     */
    public SourceDataCollection publish介護保険料額決定通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(決定通知書_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return null;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100039.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100040.getReportId();
        }
        if (帳票ID == null) {
            return null;
        }

        HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
        本算定通知書情報.set現年度_過年度区分(通知書共通情報.get年度区分());
        本算定通知書情報.set発行日(new RDate(parameter.get決定通知書_発行日().toString()));
        本算定通知書情報.set帳票分類ID(決定通知書_帳票分類ID);
        本算定通知書情報.set帳票ID(帳票ID);
        本算定通知書情報.set処理区分(ShoriKubun.リアル);
        本算定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        //本算定通知書情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前().toEntity());
        //本算定通知書情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後().toEntity());
        本算定通知書情報.set納組情報(通知書共通情報.get納組情報());
        本算定通知書情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報List());
        本算定通知書情報.set特徴納期情報リスト(通知書共通情報.get特徴収入情報List());
        本算定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        本算定通知書情報.set口座情報(通知書共通情報.get口座情報());
//        本算定通知書情報.set徴収方法情報_更正前(通知書共通情報.get徴収方法情報_更正前());
//        本算定通知書情報.set徴収方法情報_更正後(通知書共通情報.get徴収方法情報_更正後());
        //本算定通知書情報.set対象者_追加含む_の情報_更正前(通知書共通情報.get対象者_追加含む_の情報_更正前());
        //本算定通知書情報.set対象者_追加含む_の情報_更正後(通知書共通情報.get対象者_追加含む_の情報_更正後());

        //TODO 収入情報
        ShunyuJoho 収入情報 = null;
        本算定通知書情報.set収入情報(収入情報);
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = load帳票制御共通(決定通知書_帳票分類ID);
        if (帳票制御共通 != null) {
            本算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(帳票制御共通));
        }
//         HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
//        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定共通情報作成.create本算定通知書共通情報(本算定通知書情報);

        //TODO 1.2　本算定決定通知書情報を作成する。
        RString 通知書定型文 = RString.EMPTY;
        if (帳票制御共通 != null && !nullTOEmpty(帳票制御共通.getTeikeibunMojiSize()).isEmpty()) {
            int パターン番号 = Integer.parseInt(nullTOEmpty(帳票制御共通.getTeikeibunMojiSize()).toString());
            FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
            TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
            TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo
                    = manager.get通知書定形文検索(SubGyomuCode.DBB介護賦課, 決定通知書_帳票分類ID,
                            KamokuCode.EMPTY, パターン番号, 定値_番号1, システム日付);
            if (tsuchishoTeikeibunInfo != null) {
                通知書定型文 = tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
            }
        }
        nullTOEmpty(通知書定型文);
        //TODO 帳票設計_DBBRP00005_2_介護保険料額決定通知書未製造
        SourceDataCollection sourceDataCollection = null;
        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()), new RString(帳票ID.value().toString()));
        save帳票発行履歴(sourceDataCollection, parameter.get決定通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 決定通知書_帳票分類ID);
        return sourceDataCollection;
    }

    /**
     * 介護保険料額変更兼特別徴収中止通知書発行メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return SourceDataCollection
     */
    public SourceDataCollection publish介護保険料額変更兼特別徴収中止通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {
        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(決定通知書_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return null;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100042.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100043.getReportId();
        }
        if (帳票ID == null) {
            return null;
        }

        HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
        本算定通知書情報.set現年度_過年度区分(通知書共通情報.get年度区分());
        本算定通知書情報.set発行日(new RDate(parameter.get変更通知書_発行日().toString()));
        本算定通知書情報.set帳票分類ID(決定通知書_帳票分類ID);
        本算定通知書情報.set帳票ID(帳票ID);
        本算定通知書情報.set処理区分(ShoriKubun.リアル);
        本算定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        //本算定通知書情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前().toEntity());
        //本算定通知書情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後().toEntity());
        本算定通知書情報.set納組情報(通知書共通情報.get納組情報());
        本算定通知書情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報List());
        本算定通知書情報.set特徴納期情報リスト(通知書共通情報.get特徴収入情報List());
        本算定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        本算定通知書情報.set口座情報(通知書共通情報.get口座情報());
//        本算定通知書情報.set徴収方法情報_更正前(通知書共通情報.get徴収方法情報_更正前());
//        本算定通知書情報.set徴収方法情報_更正後(通知書共通情報.get徴収方法情報_更正後());
        //本算定通知書情報.set対象者_追加含む_の情報_更正前(通知書共通情報.get対象者_追加含む_の情報_更正前());
        //本算定通知書情報.set対象者_追加含む_の情報_更正後(通知書共通情報.get対象者_追加含む_の情報_更正後());

        //TODO 収入情報
        ShunyuJoho 収入情報 = null;
        本算定通知書情報.set収入情報(収入情報);
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = load帳票制御共通(決定通知書_帳票分類ID);
        if (帳票制御共通 != null) {
            本算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(帳票制御共通));
        }
//        HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
//        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定共通情報作成.create本算定通知書共通情報(本算定通知書情報);

        //TODO 本算定決定通知書情報を作成する。
        //TODO 帳票設計_DBBRP00005_3_介護保険料額変更兼特別徴収中止通知書
        SourceDataCollection sourceDataCollection = null;
        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()), new RString(帳票ID.value().toString()));
        save帳票発行履歴(sourceDataCollection, parameter.get変更通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 決定通知書_帳票分類ID);
        return sourceDataCollection;
    }

    /**
     * 保険料納入通知書（本算定と過年度）発行メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @param 区分 区分
     * @return SourceDataCollection
     */
    public SourceDataCollection publish保険料納入通知書本算定(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, RString 区分) {

        NonyuTsuchiShoSeigyoJohoLoaderFinder finder = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance();
        HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報 = finder.get本算定納入通知書制御情報();
        RString 出力期 = parameter.get納入通知書_出力期();
        ReportId 帳票ID = judge納入通知書帳票ID(本算定納入通知書制御情報.get納入通知書制御情報(), 出力期, 区分);
        if (帳票ID == null) {
            return null;
        }
        HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
        本算定通知書情報.set現年度_過年度区分(通知書共通情報.get年度区分());
        本算定通知書情報.set発行日(new RDate(parameter.get納入通知書_発行日().toString()));
        本算定通知書情報.set帳票分類ID(保険料納入通知書_帳票分類ID);
        本算定通知書情報.set帳票ID(帳票ID);
        本算定通知書情報.set処理区分(ShoriKubun.リアル);
        本算定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        //本算定通知書情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前());
        //本算定通知書情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後());
        本算定通知書情報.set納組情報(通知書共通情報.get納組情報());
        本算定通知書情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報List());
        本算定通知書情報.set特徴納期情報リスト(通知書共通情報.get特徴収入情報List());
        本算定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        本算定通知書情報.set口座情報(通知書共通情報.get口座情報());
        //TODO HonSanteiTsuchiShoKyotsu違います。(徴収方法情報_更正前 徴収方法情報_更正後)
        //本算定通知書情報.get徴収方法情報_更正前(通知書共通情報.get徴収方法情報_更正前());
        //本算定通知書情報.set徴収方法情報_更正後(通知書共通情報.get徴収方法情報_更正後());
        //TODO 対象者（追加含む）情報（更正前）
        //TODO 対象者（追加含む）情報（更正後）
        //本算定通知書情報.set対象者_追加含む_の情報_更正前(通知書共通情報.get対象者_追加含む_の情報_更正前());
        //本算定通知書情報.set対象者_追加含む_の情報_更正後(通知書共通情報.get対象者_追加含む_の情報_更正後());

        //TODO 収入情報
        ShunyuJoho 収入情報 = new ShunyuJoho();
        本算定通知書情報.set収入情報(収入情報);
        DbT7065ChohyoSeigyoKyotsuEntity entity = load帳票制御共通(保険料納入通知書_帳票分類ID);
        if (entity != null) {
            本算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(entity));
        }

        //TODO 入力.各種通知書作成パラメータ.納入通知書.出力期リスト
        List<Kitsuki> 出力期リスト = parameter.get納入通知書出力期リスト();
        IName 代納人氏名 = null;
        if (AtesakiShubetsu.代納人.equals(通知書共通情報.get宛先情報().get宛先種別())) {
            代納人氏名 = 通知書共通情報.get宛先情報().get宛先名称();
        } else if (AtesakiShubetsu.代納人送付先.equals(通知書共通情報.get宛先情報().get宛先種別())) {
            List<GyomuCode> list = new ArrayList<>();
            list.add(GyomuCode.DB介護保険);
            List<DainoninRelate> 代納人情報リスト = DainoninRelateFinderFactory.createInstance().get代納人byサブ業務コード(
                    通知書共通情報.get宛先情報().get識別コード(), list, SubGyomuCode.DBB介護賦課);
            if (代納人情報リスト != null && !代納人情報リスト.isEmpty()) {
                代納人氏名 = 代納人情報リスト.get(0).get識別対象().get名称();
            }
        }
        if (出力期リスト == null || 代納人氏名 == null) {
            return null;
        }
        NonyuTsuchiShoJohoFactory nonyuTsuchiShoJohoFactory = InstanceProvider.create(NonyuTsuchiShoJohoFactory.class);
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報
                = nonyuTsuchiShoJohoFactory.create本算定納入通知書情報(本算定通知書情報, 本算定納入通知書制御情報, 出力期リスト, 代納人氏名);

        SourceDataCollection sourceDataCollection;
        if (本算定_区分.equals(区分)) {
            sourceDataCollection = publish納入通知書本算定(帳票ID, 本算定納入通知書情報);
        } else {
            sourceDataCollection = publish納入通知書過年度(帳票ID, 本算定納入通知書情報);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()), new RString(帳票ID.value().toString()));
        save帳票発行履歴(sourceDataCollection, parameter.get納入通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 保険料納入通知書_帳票分類ID);
        return sourceDataCollection;
    }

    private SourceDataCollection publish納入通知書本算定(ReportId 帳票ID, HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {

        if (本算定納入通知書情報 == null) {
            return null;
        }
        SourceDataCollection sourceDataCollection;
        if (ReportIdDBB.DBB100045.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariB5Source>().spool(property, report);
        } else if (ReportIdDBB.DBB100053.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariSealerSource>().spool(property, report);
        } else if (ReportIdDBB.DBB100051.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource>().spool(property, report);
        } else if (ReportIdDBB.DBB100056.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource>().spool(property, report);
        } else if (ReportIdDBB.DBB100055.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource>().spool(property, report);
        } else if (ReportIdDBB.DBB100061.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource>().spool(property, report);
        } else if (ReportIdDBB.DBB100059.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource>().spool(property, report);
        } else {
            sourceDataCollection = new SourceDataCollection();
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource>().spool(property, report);
        }
        return sourceDataCollection;
    }

    private SourceDataCollection publish納入通知書過年度(ReportId 帳票ID, HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {

        if (本算定納入通知書情報 == null) {
            return null;
        }
        SourceDataCollection sourceDataCollection;
        if (ReportIdDBB.DBB100066.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariB5Source>().spool(property, report);
        } else if (ReportIdDBB.DBB100070.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariSealerSource>().spool(property, report);
        } else if (ReportIdDBB.DBB100069.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource>().spool(property, report);
        } else if (ReportIdDBB.DBB100072.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource>().spool(property, report);
        } else if (ReportIdDBB.DBB100071.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource>().spool(property, report);
        } else if (ReportIdDBB.DBB100075.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource>().spool(property, report);
        } else if (ReportIdDBB.DBB100073.getReportId().equals(帳票ID)) {
            sourceDataCollection = null;
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource>().spool(property, report);
        } else {
            sourceDataCollection = new SourceDataCollection();
            //sourceDataCollection = new Printer<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource>().spool(property, report);
        }
        return sourceDataCollection;
    }

    /**
     * 賦課台帳（本算定）発行メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return SourceDataCollection
     */
    public SourceDataCollection publish賦課台帳本算定(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {

        //TODO １．事前処理（データ取得）ビジネス設計_DBBBZ00006_1_賦課台帳データ編集(未製造)
        EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報 = null;
        SourceDataCollection sourceDataCollection = new FukaDaichoPrintService().print(編集後本算定賦課台帳情報);

        FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()),
                new RString(ReportIdDBB.DBB100065.getReportId().value().toString()));
        save帳票発行履歴(sourceDataCollection, システム日付, 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), ReportIdDBB.DBB100065.getReportId());
        return sourceDataCollection;
    }

    /**
     * 介護保険料減免決定通知書発行メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return SourceDataCollection
     */
    public SourceDataCollection publish介護保険料減免決定通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(介護保険料減免決定通知書_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return null;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100077.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100078.getReportId();
        }
        if (帳票ID == null) {
            return null;
        }

        IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー
                = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 介護保険料減免決定通知書_帳票分類ID);
//        IKakushuTsuchishoSakuseiMapper mapper = mapperProvider.create(IKakushuTsuchishoSakuseiMapper.class);
//        KakushuTsuchishoEntityParameter paramt
//                = KakushuTsuchishoEntityParameter.createSelectByKeyParam(通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定年度(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get賦課年度(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get通知書番号(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get履歴番号(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定日時(), null);
//        GenmenInfoEntity 減免の情報_更正後 = mapper.get減免の情報更正後(paramt);

        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = load帳票制御共通(介護保険料減免決定通知書_帳票分類ID);
        //TODO 1.2.3 減免決定通知書情報を作成する。
        GenmenKetteiTsuchiShoJoho 減免決定通知書情報 = new GenmenKetteiTsuchiShoJoho();
        減免決定通知書情報.set賦課の情報更正前(null);
        減免決定通知書情報.set減免の情報更正後(null);
        減免決定通知書情報.set宛名(通知書共通情報.get宛名情報());
        減免決定通知書情報.set宛先(通知書共通情報.get宛先情報());
        減免決定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        減免決定通知書情報.set納組情報(通知書共通情報.get納組情報());
        減免決定通知書情報.set帳票制御共通(帳票制御共通 != null ? new ChohyoSeigyoKyotsu(帳票制御共通) : null);
        RString 通知書定型文 = RString.EMPTY;
        if (帳票制御共通 != null && !nullTOEmpty(帳票制御共通.getTeikeibunMojiSize()).isEmpty()) {
            int パターン番号 = Integer.parseInt(nullTOEmpty(帳票制御共通.getTeikeibunMojiSize()).toString());
            FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
            TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
            TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo
                    = manager.get通知書定形文検索(SubGyomuCode.DBB介護賦課, 介護保険料減免決定通知書_帳票分類ID,
                            KamokuCode.EMPTY, パターン番号, 定値_番号1, システム日付);
            if (tsuchishoTeikeibunInfo != null) {
                通知書定型文 = tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
            }
        }
        SourceDataCollection sourceDataCollection;
        if (ReportIdDBB.DBB100077.getReportId().equals(帳票ID)) {
            sourceDataCollection = new GenmenKetteiTsuchiShoPrintService().printB5横タイプ(parameter.get減免通知書_発行日(),
                    parameter.get減免通知書_文書番号(), 減免決定通知書情報, 通知書定型文, 介護問合せ先ソースビルダー);
        } else {
            sourceDataCollection = new GenmenKetteiTsuchiShoPrintService().printA4縦タイプ(parameter.get減免通知書_発行日(),
                    parameter.get減免通知書_文書番号(), 減免決定通知書情報, 通知書定型文, 介護問合せ先ソースビルダー);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()), new RString(帳票ID.value().toString()));
        save帳票発行履歴(sourceDataCollection, parameter.get減免通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 介護保険料減免決定通知書_帳票分類ID);
        return sourceDataCollection;
    }

    /**
     * 介護保険料減免取消通知書発行メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return SourceDataCollection
     */
    public SourceDataCollection publish介護保険料減免取消通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(介護保険料減免取消通知書_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return null;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100079.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100080.getReportId();
        }
        if (帳票ID == null) {
            return null;
        }

//        CompKaigoToiawasesakiSource 介護問合せ先ソースビルダー
//                = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 介護保険料減免取消通知書_帳票分類ID).buildSource();
//        IKakushuTsuchishoSakuseiMapper mapper = mapperProvider.create(IKakushuTsuchishoSakuseiMapper.class);
//        KakushuTsuchishoEntityParameter paramt
//                = KakushuTsuchishoEntityParameter.createSelectByKeyParam(通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定年度(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get賦課年度(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get通知書番号(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get履歴番号(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定日時(), null);
//        GenmenInfoEntity 減免の情報_更正後 = mapper.get減免の情報更正後_取消(paramt);
        //TODO 1.2.3 減免取消通知書情報を作成する。
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = load帳票制御共通(介護保険料減免取消通知書_帳票分類ID);
        RString 通知書定型文 = RString.EMPTY;
        if (帳票制御共通 != null && !nullTOEmpty(帳票制御共通.getTeikeibunMojiSize()).isEmpty()) {
            int パターン番号 = Integer.parseInt(nullTOEmpty(帳票制御共通.getTeikeibunMojiSize()).toString());
            FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
            TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
            TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo
                    = manager.get通知書定形文検索(SubGyomuCode.DBB介護賦課, 介護保険料減免取消通知書_帳票分類ID,
                            KamokuCode.EMPTY, パターン番号, 定値_番号1, システム日付);
            if (tsuchishoTeikeibunInfo != null) {
                通知書定型文 = tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
            }
        }
        nullTOEmpty(通知書定型文);
        //TODO 帳票設計_DBBRP12001_32_介護保険料減免決定通知書未製造
        SourceDataCollection sourceDataCollection = null;
        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()), new RString(帳票ID.value().toString()));
        save帳票発行履歴(sourceDataCollection, parameter.get減免通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 介護保険料減免取消通知書_帳票分類ID);
        return sourceDataCollection;
    }

    /**
     * 介護保険料徴収猶予決定通知書メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return SourceDataCollection
     */
    public SourceDataCollection publish介護保険料徴収猶予決定通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(介護保険料徴収猶予決定通知書_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return null;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100081.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100082.getReportId();
        }
        if (帳票ID == null) {
            return null;
        }

//        CompKaigoToiawasesakiSource 介護問合せ先ソースビルダー
//                = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 介護保険料徴収猶予決定通知書_帳票分類ID).buildSource();
//        IKakushuTsuchishoSakuseiMapper mapper = mapperProvider.create(IKakushuTsuchishoSakuseiMapper.class);
//        KakushuTsuchishoEntityParameter paramt
//                = KakushuTsuchishoEntityParameter.createSelectByKeyParam(通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定年度(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get賦課年度(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get通知書番号(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get履歴番号(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定日時(), null);
//        ChoshuYuyoInfoEntity 徴収猶予の情報_更正後 = mapper.get徴収猶予の情報更正後(paramt);
        //TODO 1.2.3 徴収猶予決定通知書情報を作成する。
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = load帳票制御共通(介護保険料徴収猶予決定通知書_帳票分類ID);
        RString 通知書定型文 = RString.EMPTY;
        if (帳票制御共通 != null && !nullTOEmpty(帳票制御共通.getTeikeibunMojiSize()).isEmpty()) {
            int パターン番号 = Integer.parseInt(nullTOEmpty(帳票制御共通.getTeikeibunMojiSize()).toString());
            FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
            TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
            TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo
                    = manager.get通知書定形文検索(SubGyomuCode.DBB介護賦課, 介護保険料徴収猶予決定通知書_帳票分類ID,
                            KamokuCode.EMPTY, パターン番号, 定値_番号1, システム日付);
            if (tsuchishoTeikeibunInfo != null) {
                通知書定型文 = tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
            }
        }
        nullTOEmpty(通知書定型文);
        //TODO 帳票設計_DBBRP12001_33_介護保険料徴収猶予決定通知書未製造

        SourceDataCollection sourceDataCollection = null;
        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()), new RString(帳票ID.value().toString()));
        save帳票発行履歴(sourceDataCollection, parameter.get徴収猶予通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 介護保険料徴収猶予決定通知書_帳票分類ID);
        return sourceDataCollection;
    }

    /**
     * 介護保険料徴収猶予取消通知書メソッドです。
     *
     * @param parameter parameter
     * @param 通知書共通情報 通知書共通情報
     * @return SourceDataCollection
     */
    public SourceDataCollection publish介護保険料徴収猶予取消通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(介護保険料徴収猶予取消通知書_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return null;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100083.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100084.getReportId();
        }
        if (帳票ID == null) {
            return null;
        }

//        CompKaigoToiawasesakiSource 介護問合せ先ソースビルダー
//                = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 介護保険料徴収猶予取消通知書_帳票分類ID).buildSource();
//        IKakushuTsuchishoSakuseiMapper mapper = mapperProvider.create(IKakushuTsuchishoSakuseiMapper.class);
//        //TODO 入力．各種通知書発行パラメータ.調定年度?
//        KakushuTsuchishoEntityParameter paramt
//                = KakushuTsuchishoEntityParameter.createSelectByKeyParam(通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定年度(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get賦課年度(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get通知書番号(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get履歴番号(),
//                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定日時(), null);
//        ChoshuYuyoInfoEntity 徴収猶予の情報更正後_取消 = mapper.get徴収猶予の情報更正後_取消(paramt);
        //TODO 1.2.3 徴収猶予取消通知書情報を作成する。
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = load帳票制御共通(介護保険料徴収猶予取消通知書_帳票分類ID);
        RString 通知書定型文 = RString.EMPTY;
        if (帳票制御共通 != null && !nullTOEmpty(帳票制御共通.getTeikeibunMojiSize()).isEmpty()) {
            int パターン番号 = Integer.parseInt(nullTOEmpty(帳票制御共通.getTeikeibunMojiSize()).toString());
            FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
            TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
            TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo
                    = manager.get通知書定形文検索(SubGyomuCode.DBB介護賦課, 介護保険料徴収猶予取消通知書_帳票分類ID,
                            KamokuCode.EMPTY, パターン番号, 定値_番号1, システム日付);
            if (tsuchishoTeikeibunInfo != null) {
                通知書定型文 = tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
            }
        }
        nullTOEmpty(通知書定型文);
        //TODO 帳票設計_DBBRP12001_2_介護保険料徴収猶予取消通知書未製造

        SourceDataCollection sourceDataCollection = null;
        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(ChohyoHakkoRirekiSearchDefault.帳票ID.getCode().toString()), new RString(帳票ID.value().toString()));
        save帳票発行履歴(sourceDataCollection, parameter.get徴収猶予通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 介護保険料徴収猶予取消通知書_帳票分類ID);
        return sourceDataCollection;
    }

    /**
     * リアル発行履歴の登録メソッドです。
     *
     * @param 賦課の情報 賦課の情報
     * @param 帳票分類ID 帳票分類ID
     */
    private void insertリアル発行履歴(FukaJoho 賦課の情報, ReportId 帳票分類ID) {
        DbT2018RealHakkoRirekiEntity entity = new DbT2018RealHakkoRirekiEntity();
        entity.setChoteiNendo(賦課の情報.get調定年度());
        entity.setFukaNendo(賦課の情報.get賦課年度());
        entity.setTsuchishoNo(賦課の情報.get通知書番号());
        entity.setChohyoBunruiID(帳票分類ID);
        entity.setTsuchishoPrintTimeStamp(new YMDHMS(RDate.getNowDateTime().toString()));
        entity.setHihokenshaNo(賦課の情報.get被保険者番号());
        entity.setShikibetsuCode(賦課の情報.get識別コード());
        リアル発行履歴Dac.save(entity);
    }

    /**
     * 通知書共通情報取得メソッドです。
     *
     * @param parameter parameter
     * @return 通知書共通情報
     */
    public KakushuTsuchishoCommonInfo search通知書共通情報(KakushuTsuchishoParameter parameter) {

        FukaJoho 賦課の情報_更正後 = parameter.get賦課の情報_更正後();
        FukaJoho 賦課の情報_更正前 = parameter.get賦課の情報_更正前();
        if (賦課の情報_更正後 == null) {
            return null;
        }
        GennenKanen 年度区分 = GennenKanen.過年度;
        if (賦課の情報_更正後.get調定年度().equals(賦課の情報_更正後.get賦課年度())) {
            年度区分 = GennenKanen.現年度;
        }
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

        IKakushuTsuchishoSakuseiMapper mapper = mapperProvider.create(IKakushuTsuchishoSakuseiMapper.class);
        KakushuTsuchishoEntityParameter 更正後
                = KakushuTsuchishoEntityParameter.createSelectByKeyParam(賦課の情報_更正後.get調定年度(),
                        賦課の情報_更正後.get賦課年度(), 賦課の情報_更正後.get通知書番号(),
                        賦課の情報_更正後.get履歴番号(), 賦課の情報_更正後.get調定日時(),
                        賦課の情報_更正後.get調定日時().getDate().toDateString());
        KakushuTsuchishoEntity 更正後entity = mapper.get更正前後賦課の情報(更正後);
        KakushuTsuchishoEntityParameter 更正前
                = KakushuTsuchishoEntityParameter.createSelectByKeyParam(賦課の情報_更正前.get調定年度(),
                        賦課の情報_更正前.get賦課年度(), 賦課の情報_更正前.get通知書番号(),
                        賦課の情報_更正前.get履歴番号(), 賦課の情報_更正前.get調定日時(),
                        賦課の情報_更正前.get調定日時().getDate().toDateString());
        KakushuTsuchishoEntity 更正前entity = mapper.get更正前後賦課の情報(更正前);
        FukaAtena 賦課の情報更正後 = get賦課の情報_宛名(更正後entity);
        FukaAtena 賦課の情報更正前 = get賦課の情報_宛名(更正前entity);

        KakushuTsuchishoFindEntity 宛名納組宛先口座entity = mapper.get宛名納組宛先口座(更正後);

        List<NokiJoho> 普徴納期情報List = new ArrayList<>();
        if (GennenKanen.過年度.equals(年度区分)) {
            KanendoKiUtil 月期対応取得_過年度 = new KanendoKiUtil();
            KitsukiList 期月リスト_過年度 = 月期対応取得_過年度.get期月リスト();
            List<Kitsuki> 期月リスト = 期月リスト_過年度.toList();
            FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(賦課の情報_更正後.get調定年度().toDateString()));
            for (Kitsuki 期月 : 期月リスト) {
                NokiJoho nokiJoho = new NokiJoho();
                nokiJoho.set期月(期月);
                nokiJoho.set納期(fukaNokiResearcher.get過年度納期(期月.get期AsInt()));
                普徴納期情報List.add(nokiJoho);
            }
        } else {
            FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
            KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
            List<Kitsuki> 期月リスト = 期月リスト_普徴.toList();
            FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(賦課の情報_更正後.get調定年度().toDateString()));
            for (Kitsuki 期月 : 期月リスト) {
                NokiJoho nokiJoho = new NokiJoho();
                nokiJoho.set期月(期月);
                nokiJoho.set納期(fukaNokiResearcher.get普徴納期(期月.get期AsInt()));
                普徴納期情報List.add(nokiJoho);
            }
        }

        List<NokiJoho> 特徴収入情報List = new ArrayList<>();
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        KitsukiList 期月リスト_特徴 = 月期対応取得_特徴.get期月リスト();
        List<Kitsuki> 期月リスト = 期月リスト_特徴.toList();
        FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(賦課の情報_更正後.get調定年度().toDateString()));
        for (Kitsuki 期月 : 期月リスト) {
            NokiJoho nokiJoho = new NokiJoho();
            nokiJoho.set期月(期月);
            nokiJoho.set納期(fukaNokiResearcher.get特徴納期(期月.get期AsInt()));
            特徴収入情報List.add(nokiJoho);
        }

        HonsanteiIkoHantei honsanteiIkoHantei = HonsanteiIkoHantei.createInstance();
        boolean 本算定区分_更正後 = honsanteiIkoHantei.is本算定後(賦課の情報更正後 == null ? null : 賦課の情報更正後.get賦課情報());
        boolean 本算定区分_更正前 = honsanteiIkoHantei.is本算定後(賦課の情報更正前 == null ? null : 賦課の情報更正前.get賦課情報());
        //TODO QA.652:対象者（追加含む）の情報の取得
        NenkinTokuchoKaifuJoho 対象者_追加含む_の情報_更正後 = get対象者_追加含む_の情報(本算定区分_更正後, 更正後entity);
        NenkinTokuchoKaifuJoho 対象者_追加含む_の情報_更正前 = get対象者_追加含む_の情報(本算定区分_更正前, 更正前entity);

        IKozaManager iKozaManager = KozaService.createKozaManager();
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder().setサブ業務コード(SubGyomuCode.DBB介護賦課)
                .set基準日(FlexibleDate.getNowDate()).set識別コード(賦課の情報_更正後.get識別コード()).build();
        List<IKoza> マスク済み口座List = iKozaManager.getマスク済口座(searchKey);
        IKoza マスク済み口座 = null;
        if (マスク済み口座List != null && !マスク済み口座List.isEmpty()) {
            マスク済み口座 = マスク済み口座List.get(0);
        }

        KakushuTsuchishoCommonInfo 通知書共通情報 = new KakushuTsuchishoCommonInfo();
        通知書共通情報.set地方公共団体(地方公共団体);
        通知書共通情報.set賦課の情報_更正後(賦課の情報更正後);
        通知書共通情報.set賦課の情報_更正前(賦課の情報更正前);
        通知書共通情報.set普徴納期情報List(普徴納期情報List);
        通知書共通情報.set特徴収入情報List(特徴収入情報List);
        if (宛名納組宛先口座entity != null) {
            通知書共通情報.set納組情報(宛名納組宛先口座entity.get納組());
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(宛名納組宛先口座entity.get宛名());
            通知書共通情報.set宛名情報(宛名);
            IAtesaki 宛先 = AtesakiFactory.createInstance(宛名納組宛先口座entity.get宛先());
            通知書共通情報.set宛先情報(宛先);
            //TODO ３で取得した口座情報
            通知書共通情報.set口座情報(null);
        }
        通知書共通情報.setマスク口座情報(マスク済み口座);
        通知書共通情報.set徴収方法情報_更正前(new ChoshuHoho(更正前entity.get介護徴収方法()));
        通知書共通情報.set徴収方法情報_更正後(new ChoshuHoho(更正後entity.get介護徴収方法()));
        通知書共通情報.set対象者_追加含む_の情報_更正前(対象者_追加含む_の情報_更正前);
        通知書共通情報.set対象者_追加含む_の情報_更正後(対象者_追加含む_の情報_更正後);
        通知書共通情報.set収入情報(更正後entity.get収入情報取得PSM());
        通知書共通情報.set年度区分(年度区分);
        return 通知書共通情報;
    }

    private NenkinTokuchoKaifuJoho get対象者_追加含む_の情報(boolean 本算定区分, KakushuTsuchishoEntity 更正前後entity) {

        if (更正前後entity == null) {
            return null;
        }
        NenkinTokuchoKaifuJohoManager nenkinTokuchoKaifuJohoManager = InstanceProvider.create(NenkinTokuchoKaifuJohoManager.class);
        if (本算定区分) {
            return nenkinTokuchoKaifuJohoManager.get年金特徴対象者情報(GyomuCode.DB介護保険,
                    更正前後entity.get介護徴収方法().getFukaNendo(), 更正前後entity.get介護徴収方法().getHonNenkinNo(),
                    更正前後entity.get介護徴収方法().getHonNenkinCode(), 更正前後entity.get介護徴収方法().getHonHosokuM());
        }
        return nenkinTokuchoKaifuJohoManager.get年金特徴対象者情報(GyomuCode.DB介護保険,
                更正前後entity.get介護徴収方法().getFukaNendo().minusYear(定値_番号1), 更正前後entity.get介護徴収方法().getKariNenkinNo(),
                更正前後entity.get介護徴収方法().getKariNenkinCode(), 更正前後entity.get介護徴収方法().getKariHosokuM());
    }

    private FukaAtena get賦課の情報_宛名(KakushuTsuchishoEntity 更正前後entity) {

        if (更正前後entity == null) {
            return null;
        }
        FukaAtena fukaAtena = new FukaAtena();
        FukaJohoRelateEntity entity = new FukaJohoRelateEntity();
        entity.set介護賦課Entity(更正前後entity.get介護賦課());
        entity.set介護期別RelateEntity(更正前後entity.get介護期別RelateEntity());
        FukaJoho fukaJoho = new FukaJoho(entity);
        fukaAtena.set賦課情報(fukaJoho);
        fukaAtena.set宛名(ShikibetsuTaishoFactory.createKojin(更正前後entity.get宛名()));
        return fukaAtena;
    }

    /**
     * 帳票制御汎用取得メソッドです。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 管理年度 管理年度
     * @param 項目名 項目名
     * @return ChohyoSeigyoHanyo
     */
    public ChohyoSeigyoHanyo load帳票制御汎用ByKey(ReportId 帳票分類ID,
            FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.select帳票制御汎用キー(SubGyomuCode.DBB介護賦課, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(entity);
    }

    /**
     * 帳票制御共通取得メソッドです。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return DbT7065ChohyoSeigyoKyotsuEntity
     * @throws NullPointerException 入力.帳票分類ID が null の場合
     */
    public DbT7065ChohyoSeigyoKyotsuEntity load帳票制御共通(ReportId 帳票分類ID) throws NullPointerException {

        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_帳票分類ID.toString()));

        return 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID);
    }

    /**
     * 前年度賦課の情報取得メソッドです。
     *
     * @param 賦課の情報 賦課の情報
     * @return Fuka
     */
    public FukaJoho find前年度賦課(FukaJoho 賦課の情報) {

        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_被保険者番号.toString(), 賦課の情報.get被保険者番号());
        parameter.put(キー_賦課年度.toString(), 賦課の情報.get賦課年度().minusYear(定値_番号1));
        FukaJohoManager manager = FukaJohoManager.createInstance();
        return manager.get前年度賦課の情報(parameter);
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
        if (仮算定_区分.equals(仮算定_本算定_過年度区分)) {
            return get仮算定帳票ID(納入通知書制御情報, 納入通知書タイプ);
        } else if (本算定_区分.equals(仮算定_本算定_過年度区分)) {
            return get本算定帳票ID(納入通知書制御情報, 納入通知書タイプ);
        } else if (過年度_区分.equals(仮算定_本算定_過年度区分)) {
            return get過年度帳票ID(納入通知書制御情報, 納入通知書タイプ);
        }
        return null;
    }

    private ReportId get仮算定帳票ID(NonyuTsuchiShoSeigyoJoho 納入通知書制御情報, RString 納入通知書タイプ)
            throws ApplicationException {
        if (定値_期毎.equals(納入通知書タイプ)
                && KigotoTsuchishoType.標準版期毎タイプ.equals(納入通知書制御情報.get期毎納入通知書タイプ())) {
            return ReportIdDBB.DBB100014.getReportId();
        } else if (定値_銀振型5期.equals(納入通知書タイプ)) {
            throw new ApplicationException(UrErrorMessages.該当データなし
                    .getMessage().replace(定値_銀振型5期.toString()).evaluate());
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

    private RString get納入通知書タイプ(RString 出力期) {

        RString 設定値 = 定値_0;
        RDate 運用日 = RDate.getNowDate();
        出力期 = 出力期.split(括弧_左.toString()).get(0).replace(定値_期, RString.EMPTY);
        switch (Integer.parseInt(出力期.toString())) {
            case 定値_1期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_2期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_3期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_4期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_5期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_6期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_7期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_8期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_9期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_10期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_11期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_12期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_13期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型13, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case 定値_14期:
                設定値 = DbBusinessConifg.get(ConfigNameDBB.普徴期情報_納付書の型14, 運用日, SubGyomuCode.DBB介護賦課);
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
     * 発行履歴の登録メソッドです。
     *
     * @param sourceDataCollection sourceDataCollection
     * @param 通知書発行日 FlexibleDate
     * @param 業務固有情報 Map
     * @param 識別コードList List<ShikibetsuCode>
     */
    private void save帳票発行履歴(SourceDataCollection sourceDataCollection, FlexibleDate 通知書発行日,
            Map<Code, RString> 業務固有情報, List<ShikibetsuCode> 識別コードList) {

        if (sourceDataCollection == null) {
            return;
        }
        Iterator<SourceData> sourceDataList = sourceDataCollection.iterator();
        while (sourceDataList.hasNext()) {
            SourceData sourceData = sourceDataList.next();
            HakkoRirekiManagerFactory.createInstance().insert帳票発行履歴(sourceData, 通知書発行日,
                    ChohyoHakkoRirekiJotai.新規作成, 業務固有情報, 識別コードList);
        }
    }

    /**
     * 空値判断メソッドです。
     *
     * @param 項目 項目
     * @return RString
     */
    private RString nullTOEmpty(RString 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return RString.EMPTY;
        }
        return 項目;
    }
}
