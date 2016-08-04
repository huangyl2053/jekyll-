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
import jp.co.ndensan.reams.ca.cax.entity.db.relate.TotalShunyuRelateEntity;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choshuyuyojoho.ChoshuYuyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukadaichodatahenshu.FukaDaichoInfo;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenjoho.GemmenJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.FukaDaityouInfo;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.KakushuTsuchishoCommonInfo;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.KakushuTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.business.core.kakushutsuchishosakusei.ReportSourceDataCollection;
import jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo.ChoshuYuyoTorikesiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.EditedHonSanteiFukaDaichoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.EditedKariSanteiFukaDaichoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.gemmen.GenmenKetteiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho.GemmenTorikesiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiKetteiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.ShunyuJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TsuchiSho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo.ChoshuYuyoJohoRelateSonotaMapperParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gemmen.GemmenJohoRelateSonotaMapperParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kakushutsuchishosakusei.KakushuTsuchishoEntityParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2018RealHakkoRirekiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei.KakushuTsuchishoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kakushutsuchishosakusei.KakushuTsuchishoFindEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2006ChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2018RealHakkoRirekiDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.kakushutsuchishosakusei.IKakushuTsuchishoSakuseiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo.choshuyuyojoho.ChoshuYuyoJohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.fukadaichodatahenshu.FukaDaichoDataHenshu;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho.FukaJohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.gemmen.gemmenjoho.GemmenJohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HonsanteiIkoHantei;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbb.service.report.choshuyuyo.ChoshuYuyoTorikesiTsuchiShoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.fukadaicho.FukaDaichoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.gemmen.GenmenKetteiTsuchiShoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.gemmentorikesitsuchisho.GemmenTorikesiTsuchiShoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.kanendohokenryononyutsuchishoginfuri.KanendoHokenryoNonyuTsuchishoGinfuriPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.kanendohokenryononyutsuchishokigoto.KanendoHokenryoNonyuTsuchishoKigotoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.kanendononyutsuchishobookfurikae.KanendoNonyuTsuchishoBookFuriKaePrintService;
import jp.co.ndensan.reams.db.dbb.service.report.kanendononyutsuchishocvskakuko.KanendoNonyuTsuchishoCVSKakukoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.kanendononyutsuchishocvskigoto.KanendoNonyuTsuchishoCVSKigotoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.kanendononyutsuchishocvsmulti.KanendoNonyuTsuchishoCVSMultiPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteifukadaicho.KarisanteiFukaDaichoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteihenkotsuchisho.KarisanteiHenkoTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteihokenryononyutsuchishobook.NonyuTsuchishoBookFuriKaePrintService;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteihokenryononyutsuchishoginfuri.KarisanteihokenryononyutsuchishoginfuriPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSKigotoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.nonyutsuchishocvskigoto.NonyuTsuchishoCVSKigotoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchisho.notsu.NonyuTsuchiShoJohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.hakkorireki.GyomuKoyuJoho;
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
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
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
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.reportprinthistory.ChohyoHakkoRirekiJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.HakkoRirekiManagerFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 各種通知書作成（個別）クラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
public class KakushuTsuchishoSakusei extends KakushuTsuchishoSakuseiFath {

    private static final int 定値 = -1;
    private static final int 定値_番号1 = 1;
    private static final int 定値_番号2 = 2;
    private static final int 設定値_番号6 = 6;
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
    private static final RString 仮算定_区分 = new RString("1");
    private static final RString 本算定_区分 = new RString("2");
    private static final RString 過年度_区分 = new RString("3");
    private static final ReportId 特別徴収開始通知書仮算定_帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final ReportId 仮算定額変更通知書_帳票分類ID = new ReportId("DBB100010_KarisanteiHenkoTsuchishoDaihyo");
    private static final ReportId 保険料納入通知書仮算定_帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private static final ReportId 賦課台帳仮算定_帳票分類ID = new ReportId("DBB100031_FukaDaichoDaihyo");
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
    private static final ReportId 賦課台帳本算定_帳票分類ID = new ReportId("DBB100031_FukaDaichoDaihyo");
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString 項目名 = new RString("通知書タイプ");
    private static final RString 通知書タイプ_B5横 = new RString("001");
    private static final RString 通知書タイプ_B5横オーバレイ = new RString("002");
    private static final RString 通知書タイプ_A4縦 = new RString("002");
    private static final RString 通知書タイプ_A4縦オーバレイ = new RString("003");
    private static final RString 通知書タイプ_シーラ = new RString("101");
    private static final RString キー_被保険者番号 = new RString("hihokenshaNo");
    private static final RString キー_賦課年度 = new RString("fukaNendo");
    private static final RString LEFT_FORMAT = new RString("'{");
    private static final RString RIGHT_FORMAT = new RString("}'");
    private static final RString MIDDLE_FORMAT = new RString(",");
    private static final RString FORMAT = new RString(":");
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
        } else if (普徴フラグ) {
            return 徴収方法_普徴のみ;
        }
        return RString.EMPTY;
    }

    private boolean get方法フラグ(List<Decimal> 期別金額List) {

        for (Decimal 期別金額 : 期別金額List) {
            if (期別金額 == null) {
                continue;
            }
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
    @Transaction
    public SourceDataCollection publish(KakushuTsuchishoParameter parameter) {

        SourceDataCollection sourceDataCollection = new SourceDataCollection();
        if (parameter == null || parameter.get発行する帳票List() == null || parameter.get発行する帳票List().isEmpty()) {
            return sourceDataCollection;
        }
        KakushuTsuchishoCommonInfo 通知書共通情報 = search通知書共通情報(parameter);

        if (通知書共通情報 == null || 通知書共通情報.get賦課の情報_更正後() == null) {
            return sourceDataCollection;
        }
        List<ReportSourceDataCollection> reportSourceDataCollection = new ArrayList<>();
        List<RString> 発行する帳票List = parameter.get発行する帳票List();
        try (ReportManager reportManager = new ReportManager()) {
            for (RString 発行する帳票 : 発行する帳票List) {
                publish通知書発行(parameter, 発行する帳票, 通知書共通情報, reportManager, reportSourceDataCollection);
            }
            sourceDataCollection = reportManager.publish();
        }
        insert帳票発行履歴(sourceDataCollection, reportSourceDataCollection);
        return sourceDataCollection;
    }

    private void publish通知書発行(KakushuTsuchishoParameter parameter, RString 発行する帳票,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager,
            List<ReportSourceDataCollection> reportSourceDataCollection) {

        if (TsuchiSho.特別徴収開始通知書_仮算定.get名称().equals(発行する帳票)) {
            publish特別徴収開始通知書仮算定(parameter, 通知書共通情報, reportManager, reportSourceDataCollection);
        } else if (TsuchiSho.仮算定額変更通知書.get名称().equals(発行する帳票)) {
            publish仮算定額変更通知書(parameter, 通知書共通情報, reportManager, reportSourceDataCollection);
        } else if (TsuchiSho.保険料納入通知書_仮算定.get名称().equals(発行する帳票)) {
            publish保険料納入通知書仮算定(parameter, 通知書共通情報, reportManager, reportSourceDataCollection);
        } else if (TsuchiSho.賦課台帳_仮算定.get名称().equals(発行する帳票)) {
            publish賦課台帳仮算定(parameter, 通知書共通情報, reportManager);
        } else if (TsuchiSho.特別徴収開始通知書_本算定.get名称().equals(発行する帳票)) {
            publish特別徴収開始通知書本算定(parameter, 通知書共通情報, reportManager, reportSourceDataCollection);
        } else if (TsuchiSho.介護保険料額決定通知書.get名称().equals(発行する帳票)
                || TsuchiSho.介護保険料額決定通知書_過年度.get名称().equals(発行する帳票)) {
            publish介護保険料額決定通知書(parameter, 通知書共通情報, reportManager, reportSourceDataCollection);
        } else if (TsuchiSho.介護保険料額変更兼特別徴収中止通知書.get名称().equals(発行する帳票)
                || TsuchiSho.介護保険料額変更兼特別徴収中止通知書_過年度.get名称().equals(発行する帳票)) {
            publish介護保険料額変更兼特別徴収中止通知書(parameter, 通知書共通情報, reportManager, reportSourceDataCollection);
        } else if (TsuchiSho.保険料納入通知書_本算定.get名称().equals(発行する帳票)) {
            publish保険料納入通知書本算定(parameter, 通知書共通情報, 本算定_区分, reportManager, reportSourceDataCollection);
        } else if (TsuchiSho.保険料納入通知書_過年度.get名称().equals(発行する帳票)) {
            publish保険料納入通知書本算定(parameter, 通知書共通情報, 過年度_区分, reportManager, reportSourceDataCollection);
        } else if (TsuchiSho.賦課台帳_本算定.get名称().equals(発行する帳票)) {
            publish賦課台帳本算定(parameter, 通知書共通情報, reportManager);
        } else if (TsuchiSho.介護保険料減免決定通知書.get名称().equals(発行する帳票)) {
            publish介護保険料減免決定通知書(parameter, 通知書共通情報, reportManager, reportSourceDataCollection);
        } else if (TsuchiSho.介護保険料減免取消通知書.get名称().equals(発行する帳票)) {
            publish介護保険料減免取消通知書(parameter, 通知書共通情報, reportManager, reportSourceDataCollection);
        } else if (TsuchiSho.介護保険料徴収猶予決定通知書.get名称().equals(発行する帳票)) {
            publish介護保険料徴収猶予決定通知書(parameter, 通知書共通情報, reportManager, reportSourceDataCollection);
        } else if (TsuchiSho.介護保険料徴収猶予取消通知書.get名称().equals(発行する帳票)) {
            publish介護保険料徴収猶予取消通知書(parameter, 通知書共通情報, reportManager, reportSourceDataCollection);
        }
    }

    /**
     * 特別徴収開始通知書（仮算定）発行メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param reportManager ReportManager
     * @param reportSourceDataCollection List<ReportSourceDataCollection>
     */
    public void publish特別徴収開始通知書仮算定(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager,
            List<ReportSourceDataCollection> reportSourceDataCollection) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(特別徴収開始通知書仮算定_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return;
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
            return;
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
        仮算定通知書情報.set収入情報(通知書共通情報.get収入情報());
        DbT7065ChohyoSeigyoKyotsuEntity entity = load帳票制御共通(特別徴収開始通知書仮算定_帳票分類ID);
        if (entity != null) {
            仮算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(entity));
        }

        KariSanteiTsuchiShoKyotsuKomokuHenshu 賦課帳票共通項目編集 = InstanceProvider.create(KariSanteiTsuchiShoKyotsuKomokuHenshu.class);
        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 賦課帳票共通項目編集.create仮算定通知書共通情報(仮算定通知書情報);

        KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報 = new KariTokuchoKaishiTsuchisyoJoho();
        仮算定特徴開始通知書情報.set発行日(parameter.get特徴開始通知書_発行日());
        仮算定特徴開始通知書情報.set帳票分類ID(特別徴収開始通知書仮算定_帳票分類ID);
        仮算定特徴開始通知書情報.set帳票ID(帳票ID);
        仮算定特徴開始通知書情報.set編集後仮算定通知書共通情報(編集後仮算定通知書共通情報);
        仮算定特徴開始通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        仮算定特徴開始通知書情報.set処理区分(ShoriKubun.リアル);
        仮算定特徴開始通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());

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
        if (ReportIdDBB.DBB100003.getReportId().equals(帳票ID)) {
            new TokubetsuChoshuKaishiTsuchishoKariPrintService().printB5横タイプ(仮算定特徴開始通知書情報, 仮算定通知書情報, null, reportManager);
        } else if (ReportIdDBB.DBB100005.getReportId().equals(帳票ID)) {
            new TokubetsuChoshuKaishiTsuchishoKariPrintService().printシーラタイプ(仮算定特徴開始通知書情報, 仮算定通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100008.getReportId().equals(帳票ID)) {
            new TokubetsuChoshuKaishiTsuchishoKariPrintService()
                    .printA4縦オーバーレイタイプ(仮算定特徴開始通知書情報, 仮算定通知書情報, 通知文1, reportManager);
        } else {
            new TokubetsuChoshuKaishiTsuchishoKariPrintService()
                    .printB5横オーバレイタイプ(仮算定特徴開始通知書情報, 仮算定通知書情報, 通知文1, 通知文2, reportManager);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(GyomuKoyuJoho.被保番号.getコード()),
                parameter.get賦課の情報_更正後().get被保険者番号().getColumnValue());
        save帳票発行履歴(reportSourceDataCollection, 帳票ID, parameter.get特徴開始通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 特別徴収開始通知書仮算定_帳票分類ID);
    }

    /**
     * 仮算定額変更通知書発行メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param reportManager ReportManager
     * @param reportSourceDataCollection List<ReportSourceDataCollection>
     */
    public void publish仮算定額変更通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager,
            List<ReportSourceDataCollection> reportSourceDataCollection) {
        ChohyoSeigyoHanyo 帳票制御汎用
                = load帳票制御汎用ByKey(仮算定額変更通知書_帳票分類ID, parameter.get賦課の情報_更正後().get調定年度(), 項目名);
        if (帳票制御汎用 == null) {
            return;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100010.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100011.getReportId();
        }
        if (帳票ID == null) {
            return;
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
        仮算定通知書情報.set収入情報(通知書共通情報.get収入情報());
        DbT7065ChohyoSeigyoKyotsuEntity entity = load帳票制御共通(仮算定額変更通知書_帳票分類ID);
        if (entity != null) {
            仮算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(entity));
        }

        KariSanteiTsuchiShoKyotsuKomokuHenshu 賦課帳票共通項目編集 = InstanceProvider.create(KariSanteiTsuchiShoKyotsuKomokuHenshu.class);
        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 賦課帳票共通項目編集.create仮算定通知書共通情報(仮算定通知書情報);

        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = new KariSanteiNonyuTsuchiShoJoho();
        仮算定納入通知書情報.set発行日(parameter.get変更通知書_発行日());
        仮算定納入通知書情報.set帳票分類ID(仮算定額変更通知書_帳票分類ID);
        仮算定納入通知書情報.set帳票ID(帳票ID);
        仮算定納入通知書情報.set編集後仮算定通知書共通情報(編集後仮算定通知書共通情報);
        仮算定納入通知書情報.set処理区分(ShoriKubun.リアル);
        仮算定納入通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());

        new KarisanteiHenkoTsuchishoPrintService().print(仮算定納入通知書情報,
                parameter.get変更通知書_文書番号(), reportManager);

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(GyomuKoyuJoho.被保番号.getコード()),
                parameter.get賦課の情報_更正後().get被保険者番号().getColumnValue());
        save帳票発行履歴(reportSourceDataCollection, 帳票ID, parameter.get変更通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 仮算定額変更通知書_帳票分類ID);
    }

    /**
     * 保険料納入通知書（仮算定）発行メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param reportManager ReportManager
     * @param reportSourceDataCollection List<ReportSourceDataCollection>
     */
    public void publish保険料納入通知書仮算定(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager,
            List<ReportSourceDataCollection> reportSourceDataCollection) {
        NonyuTsuchiShoSeigyoJohoLoaderFinder finder = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance();
        KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報 = finder.get仮算定納入通知書制御情報();
        RString 出力期 = parameter.get納入通知書_出力期();
        ReportId 帳票ID = judge納入通知書帳票ID(仮算定納入通知書制御情報.get納入通知書制御情報(), 出力期, 仮算定_区分);
        if (帳票ID == null) {
            return;
        }

        KariSanteiTsuchiShoKyotsu 仮算定通知書情報 = new KariSanteiTsuchiShoKyotsu();
        仮算定通知書情報.set発行日(parameter.get納入通知書_発行日());
        仮算定通知書情報.set帳票分類ID(保険料納入通知書仮算定_帳票分類ID);
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
        仮算定通知書情報.set収入情報(通知書共通情報.get収入情報());
        DbT7065ChohyoSeigyoKyotsuEntity entity = load帳票制御共通(保険料納入通知書仮算定_帳票分類ID);
        if (entity != null) {
            仮算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(entity));
        }

        List<Kitsuki> 出力期リスト = get出力期リスト(出力期);
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
        if (出力期リスト == null) {
            return;
        }
        NonyuTsuchiShoJohoFactory nonyuTsuchiShoJohoFactory = InstanceProvider.create(NonyuTsuchiShoJohoFactory.class);
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報
                = nonyuTsuchiShoJohoFactory.create仮算定納入通知書情報(仮算定通知書情報, 仮算定納入通知書制御情報, 出力期リスト, 代納人氏名);

        if (ReportIdDBB.DBB100014.getReportId().equals(帳票ID)) {
            new KarisanteiHokenryoNonyuTsuchishoKigotoPrintService().print(仮算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100018.getReportId().equals(帳票ID)) {
            new KarisanteihokenryononyutsuchishoginfuriPrintService().print(仮算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100021.getReportId().equals(帳票ID) || ReportIdDBB.DBB100020.getReportId().equals(帳票ID)) {
            new NonyuTsuchishoBookFuriKaePrintService().print(仮算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100026.getReportId().equals(帳票ID)) {
            new KarisanteiNonyuTsuchishoCVSMultiPrintService().print(仮算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100024.getReportId().equals(帳票ID)) {
            new KarisanteiNonyuTsuchishoCVSKakukoPrintService().print(仮算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100028.getReportId().equals(帳票ID)) {
            new KarisanteiNonyuTsuchishoCVSKigotoPrintService().print(仮算定納入通知書情報, reportManager);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(GyomuKoyuJoho.被保番号.getコード()),
                parameter.get賦課の情報_更正後().get被保険者番号().getColumnValue());
        save帳票発行履歴(reportSourceDataCollection, 帳票ID, parameter.get納入通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 保険料納入通知書仮算定_帳票分類ID);
    }

    /**
     * 賦課台帳（仮算定）発行メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param reportManager ReportManager
     */
    public void publish賦課台帳仮算定(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager) {

        FukaDaityouInfo fukaDaityouInfo = load賦課台帳情報(parameter, 通知書共通情報);
        FukaJoho 前年度賦課 = find前年度賦課(通知書共通情報.get賦課の情報_更正後().get賦課情報());
        FukaDaichoInfo 賦課台帳情報 = new FukaDaichoInfo();
        賦課台帳情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後());
        賦課台帳情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前());
        賦課台帳情報.set口座情報(通知書共通情報.get口座情報());
        賦課台帳情報.set代納人情報_更正後(fukaDaityouInfo.get代納人情報());
        賦課台帳情報.set収入情報(通知書共通情報.get収入情報());
        賦課台帳情報.set被保険者台帳情報(fukaDaityouInfo.get被保険者台帳情報());
        賦課台帳情報.set世帯員所得情報(fukaDaityouInfo.get世帯員所得情報());
        賦課台帳情報.set前年度情報(前年度賦課);
        賦課台帳情報.set徴収方法情報(通知書共通情報.get徴収方法情報_更正後());
        賦課台帳情報.set対象者_追加含む_情報(通知書共通情報.get対象者_追加含む_の情報_更正後());
        賦課台帳情報.set納組情報(通知書共通情報.get納組情報());
        賦課台帳情報.set地方公共団体(通知書共通情報.get地方公共団体());
        DbT7065ChohyoSeigyoKyotsuEntity entity = load帳票制御共通(賦課台帳仮算定_帳票分類ID);
        if (entity != null) {
            賦課台帳情報.set帳票制御共通(new ChohyoSeigyoKyotsu(entity));
        }
        賦課台帳情報.set本人連絡先1(fukaDaityouInfo.get本人連絡先1());
        賦課台帳情報.set本人連絡先2(fukaDaityouInfo.get本人連絡先2());
        賦課台帳情報.set代納人連絡先1(fukaDaityouInfo.get代納人連絡先1());
        賦課台帳情報.set代納人連絡先2(fukaDaityouInfo.get代納人連絡先2());
        賦課台帳情報.set支払方法変更リスト(fukaDaityouInfo.get支払方法変更リスト());
        賦課台帳情報.set受給者台帳情報(fukaDaityouInfo.get受給者台帳情報());
        FukaDaichoDataHenshu fukaDaichoDataHenshu = FukaDaichoDataHenshu.createInstance();
        EditedKariSanteiFukaDaichoJoho 編集後仮算定賦課台帳情報 = fukaDaichoDataHenshu.create編集後仮算定賦課台帳情報(賦課台帳情報);
        new KarisanteiFukaDaichoPrintService().printSingle(編集後仮算定賦課台帳情報, reportManager);

        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 賦課台帳仮算定_帳票分類ID);
    }

    /**
     * 特別徴収開始通知書（本算定）発行メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param reportManager ReportManager
     * @param reportSourceDataCollection List<ReportSourceDataCollection>
     */
    public void publish特別徴収開始通知書本算定(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager,
            List<ReportSourceDataCollection> reportSourceDataCollection) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(特別徴収開始通知書本算定_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return;
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
            return;
        }

        HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
        HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
        本算定通知書情報.set現年度_過年度区分(通知書共通情報.get年度区分());
        本算定通知書情報.set発行日(get発行日(parameter.get特徴開始通知書_発行日()));
        本算定通知書情報.set帳票分類ID(特別徴収開始通知書本算定_帳票分類ID);
        本算定通知書情報.set帳票ID(帳票ID);
        本算定通知書情報.set処理区分(ShoriKubun.リアル);
        本算定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        本算定通知書情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前());
        本算定通知書情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後());
        本算定通知書情報.set納組情報(通知書共通情報.get納組情報());
        本算定通知書情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報List());
        本算定通知書情報.set特徴納期情報リスト(通知書共通情報.get特徴収入情報List());
        本算定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        本算定通知書情報.set口座情報(通知書共通情報.get口座情報());
        本算定通知書情報.set徴収方法情報_更正前(通知書共通情報.get徴収方法情報_更正前());
        本算定通知書情報.set徴収方法情報_更正後(通知書共通情報.get徴収方法情報_更正後());
        本算定通知書情報.set対象者_追加含む_情報_更正前(通知書共通情報.get対象者_追加含む_の情報_更正前());
        本算定通知書情報.set対象者_追加含む_情報_更正後(通知書共通情報.get対象者_追加含む_の情報_更正後());
        本算定通知書情報.set収入情報(通知書共通情報.get収入情報());
        DbT7065ChohyoSeigyoKyotsuEntity entity = load帳票制御共通(特別徴収開始通知書本算定_帳票分類ID);
        if (entity != null) {
            本算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(entity));
        }
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定共通情報作成.create本算定通知書共通情報(本算定通知書情報);

        if (ReportIdDBB.DBB100032.getReportId().equals(帳票ID)) {
            new TokubetsuChoshuKaishiTsuchishoPrintService().printB5横タイプ(編集後本算定通知書共通情報, null, 本算定通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100036.getReportId().equals(帳票ID)) {
            new TokubetsuChoshuKaishiTsuchishoPrintService().printB5横タイプ2(編集後本算定通知書共通情報, null, 本算定通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100038.getReportId().equals(帳票ID)) {
            new TokubetsuChoshuKaishiTsuchishoPrintService().printA4縦(編集後本算定通知書共通情報, null, 本算定通知書情報, reportManager);
        } else {
            new TokubetsuChoshuKaishiTsuchishoPrintService().printシーラタイプ(編集後本算定通知書共通情報, 本算定通知書情報, reportManager);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(GyomuKoyuJoho.被保番号.getコード()),
                parameter.get賦課の情報_更正後().get被保険者番号().getColumnValue());
        save帳票発行履歴(reportSourceDataCollection, 帳票ID, parameter.get特徴開始通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 特別徴収開始通知書本算定_帳票分類ID);
    }

    /**
     * 介護保険料額決定通知書発行メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param reportManager ReportManager
     * @param reportSourceDataCollection List<ReportSourceDataCollection>
     */
    public void publish介護保険料額決定通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager,
            List<ReportSourceDataCollection> reportSourceDataCollection) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(決定通知書_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100039.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100040.getReportId();
        }
        if (帳票ID == null) {
            return;
        }

        HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
        本算定通知書情報.set現年度_過年度区分(通知書共通情報.get年度区分());
        本算定通知書情報.set発行日(get発行日(parameter.get決定通知書_発行日()));
        本算定通知書情報.set帳票分類ID(決定通知書_帳票分類ID);
        本算定通知書情報.set帳票ID(帳票ID);
        本算定通知書情報.set処理区分(ShoriKubun.リアル);
        本算定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        本算定通知書情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前());
        本算定通知書情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後());
        本算定通知書情報.set納組情報(通知書共通情報.get納組情報());
        本算定通知書情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報List());
        本算定通知書情報.set特徴納期情報リスト(通知書共通情報.get特徴収入情報List());
        本算定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        本算定通知書情報.set口座情報(通知書共通情報.get口座情報());
        本算定通知書情報.set徴収方法情報_更正前(通知書共通情報.get徴収方法情報_更正前());
        本算定通知書情報.set徴収方法情報_更正後(通知書共通情報.get徴収方法情報_更正後());
        本算定通知書情報.set対象者_追加含む_情報_更正前(通知書共通情報.get対象者_追加含む_の情報_更正前());
        本算定通知書情報.set対象者_追加含む_情報_更正後(通知書共通情報.get対象者_追加含む_の情報_更正後());
        本算定通知書情報.set収入情報(通知書共通情報.get収入情報());
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = load帳票制御共通(決定通知書_帳票分類ID);
        if (帳票制御共通 != null) {
            本算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(帳票制御共通));
        }
        HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定共通情報作成.create本算定通知書共通情報(本算定通知書情報);

        HonSanteiKetteiTsuchiShoJoho 本算定決定通知書情報 = new HonSanteiKetteiTsuchiShoJoho();
        本算定決定通知書情報.set発行日(get発行日(parameter.get決定通知書_発行日()));
        本算定決定通知書情報.set帳票分類ID(決定通知書_帳票分類ID);
        本算定決定通知書情報.set帳票ID(帳票ID);
        本算定決定通知書情報.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
        本算定決定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        本算定決定通知書情報.set処理区分(ShoriKubun.リアル);
        本算定決定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());

        RString 通知書定型文 = RString.EMPTY;
        if (帳票制御共通 != null && !nullTOEmpty(帳票制御共通.getTeikeibunMojiSize()).isEmpty()) {
            int パターン番号 = Integer.parseInt(nullTOEmpty(帳票制御共通.getTeikeibunMojiSize()).toString());
            FlexibleDate システム日付 = FlexibleDate.getNowDate();
            TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
            TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo
                    = manager.get通知書定形文検索(SubGyomuCode.DBB介護賦課, 決定通知書_帳票分類ID,
                            KamokuCode.EMPTY, パターン番号, 定値_番号1, システム日付);
            if (tsuchishoTeikeibunInfo != null) {
                通知書定型文 = tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
            }
        }
        List<KaigoHokenHokenryogakuKetteiTsuchishoJoho> entities = new ArrayList<>();
        KaigoHokenHokenryogakuKetteiTsuchishoJoho 介護保険料額決定通知書 = new KaigoHokenHokenryogakuKetteiTsuchishoJoho();
        介護保険料額決定通知書.set文書番号(parameter.get決定通知書_文書番号());
        介護保険料額決定通知書.set本算定決定通知書情報(本算定決定通知書情報);
        List<RString> 調定事由リスト = new ArrayList<>();
        if (parameter.get調定事由List() != null) {
            if (!RString.isNullOrEmpty(parameter.get調定事由List().get調定事由_一番目())) {
                調定事由リスト.add(parameter.get調定事由List().get調定事由_一番目());
            }
            if (!RString.isNullOrEmpty(parameter.get調定事由List().get調定事由_二番目())) {
                調定事由リスト.add(parameter.get調定事由List().get調定事由_二番目());
            }
            if (!RString.isNullOrEmpty(parameter.get調定事由List().get調定事由_三番目())) {
                調定事由リスト.add(parameter.get調定事由List().get調定事由_三番目());
            }
            if (!RString.isNullOrEmpty(parameter.get調定事由List().get調定事由_四番目())) {
                調定事由リスト.add(parameter.get調定事由List().get調定事由_四番目());
            }
        }
        介護保険料額決定通知書.set調定事由リスト(調定事由リスト);
        介護保険料額決定通知書.set通知書定型文(通知書定型文);
        entities.add(介護保険料額決定通知書);

        if (ReportIdDBB.DBB100039.getReportId().equals(帳票ID)) {
            new KaigoHokenHokenryogakuKetteiTsuchishoPrintService().printB5Yoko(entities, reportManager);
        } else {
            new KaigoHokenHokenryogakuKetteiTsuchishoPrintService().printA4Tate(entities, reportManager);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(GyomuKoyuJoho.被保番号.getコード()),
                parameter.get賦課の情報_更正後().get被保険者番号().getColumnValue());
        save帳票発行履歴(reportSourceDataCollection, 帳票ID, parameter.get決定通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 決定通知書_帳票分類ID);
    }

    /**
     * 介護保険料額変更兼特別徴収中止通知書発行メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param reportManager ReportManager
     * @param reportSourceDataCollection List<ReportSourceDataCollection>
     */
    public void publish介護保険料額変更兼特別徴収中止通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager,
            List<ReportSourceDataCollection> reportSourceDataCollection) {
        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(決定通知書_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100042.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100043.getReportId();
        }
        if (帳票ID == null) {
            return;
        }

        HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
        本算定通知書情報.set現年度_過年度区分(通知書共通情報.get年度区分());
        本算定通知書情報.set発行日(get発行日(parameter.get変更通知書_発行日()));
        本算定通知書情報.set帳票分類ID(決定通知書_帳票分類ID);
        本算定通知書情報.set帳票ID(帳票ID);
        本算定通知書情報.set処理区分(ShoriKubun.リアル);
        本算定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        本算定通知書情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前());
        本算定通知書情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後());
        本算定通知書情報.set納組情報(通知書共通情報.get納組情報());
        本算定通知書情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報List());
        本算定通知書情報.set特徴納期情報リスト(通知書共通情報.get特徴収入情報List());
        本算定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        本算定通知書情報.set口座情報(通知書共通情報.get口座情報());
        本算定通知書情報.set徴収方法情報_更正前(通知書共通情報.get徴収方法情報_更正前());
        本算定通知書情報.set徴収方法情報_更正後(通知書共通情報.get徴収方法情報_更正後());
        本算定通知書情報.set対象者_追加含む_情報_更正前(通知書共通情報.get対象者_追加含む_の情報_更正前());
        本算定通知書情報.set対象者_追加含む_情報_更正後(通知書共通情報.get対象者_追加含む_の情報_更正後());
        本算定通知書情報.set収入情報(通知書共通情報.get収入情報());
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = load帳票制御共通(決定通知書_帳票分類ID);
        if (帳票制御共通 != null) {
            本算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(帳票制御共通));
        }
        HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定共通情報作成.create本算定通知書共通情報(本算定通知書情報);

        HonSanteiKetteiTsuchiShoJoho 本算定決定通知書情報 = new HonSanteiKetteiTsuchiShoJoho();
        本算定決定通知書情報.set発行日(get発行日(parameter.get変更通知書_発行日()));
        本算定決定通知書情報.set帳票分類ID(決定通知書_帳票分類ID);
        本算定決定通知書情報.set帳票ID(帳票ID);
        本算定決定通知書情報.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
        本算定決定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        本算定決定通知書情報.set処理区分(ShoriKubun.リアル);
        本算定決定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());

        List<KaigoHokenryogakuHenkoKenChushiTsuchishoJoho> entities = new ArrayList<>();
        KaigoHokenryogakuHenkoKenChushiTsuchishoJoho 決定通知書情報 = new KaigoHokenryogakuHenkoKenChushiTsuchishoJoho();
        決定通知書情報.set文書番号(parameter.get決定通知書_文書番号());
        決定通知書情報.set本算定決定通知書情報(本算定決定通知書情報);
        List<RString> 調定事由リスト = new ArrayList<>();
        if (parameter.get調定事由List() != null) {
            if (!RString.isNullOrEmpty(parameter.get調定事由List().get調定事由_一番目())) {
                調定事由リスト.add(parameter.get調定事由List().get調定事由_一番目());
            }
            if (!RString.isNullOrEmpty(parameter.get調定事由List().get調定事由_二番目())) {
                調定事由リスト.add(parameter.get調定事由List().get調定事由_二番目());
            }
            if (!RString.isNullOrEmpty(parameter.get調定事由List().get調定事由_三番目())) {
                調定事由リスト.add(parameter.get調定事由List().get調定事由_三番目());
            }
            if (!RString.isNullOrEmpty(parameter.get調定事由List().get調定事由_四番目())) {
                調定事由リスト.add(parameter.get調定事由List().get調定事由_四番目());
            }
        }
        決定通知書情報.set調定事由リスト(調定事由リスト);
        entities.add(決定通知書情報);

        if (ReportIdDBB.DBB100042.getReportId().equals(帳票ID)) {
            new KaigoHokenryogakuHenkoKenChushiTsuchishoPrintService().printB5Yoko(entities, reportManager);
        } else {
            new KaigoHokenryogakuHenkoKenChushiTsuchishoPrintService().printA4Tate(entities, reportManager);
        }
        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(GyomuKoyuJoho.被保番号.getコード()),
                parameter.get賦課の情報_更正後().get被保険者番号().getColumnValue());
        save帳票発行履歴(reportSourceDataCollection, 帳票ID, parameter.get変更通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 決定通知書_帳票分類ID);
    }

    /**
     * 保険料納入通知書（本算定と過年度）発行メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param 区分 RString
     * @param reportManager ReportManager
     * @param reportSourceDataCollection List<ReportSourceDataCollection>
     */
    public void publish保険料納入通知書本算定(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, RString 区分, ReportManager reportManager,
            List<ReportSourceDataCollection> reportSourceDataCollection) {

        NonyuTsuchiShoSeigyoJohoLoaderFinder finder = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance();
        HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報 = finder.get本算定納入通知書制御情報();
        RString 出力期 = parameter.get納入通知書_出力期();
        ReportId 帳票ID = judge納入通知書帳票ID(本算定納入通知書制御情報.get納入通知書制御情報(), 出力期, 区分);
        if (帳票ID == null) {
            return;
        }
        HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
        本算定通知書情報.set現年度_過年度区分(通知書共通情報.get年度区分());
        本算定通知書情報.set発行日(get発行日(parameter.get納入通知書_発行日()));
        本算定通知書情報.set帳票分類ID(保険料納入通知書_帳票分類ID);
        本算定通知書情報.set帳票ID(帳票ID);
        本算定通知書情報.set処理区分(ShoriKubun.リアル);
        本算定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        本算定通知書情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前());
        本算定通知書情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後());
        本算定通知書情報.set納組情報(通知書共通情報.get納組情報());
        本算定通知書情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報List());
        本算定通知書情報.set特徴納期情報リスト(通知書共通情報.get特徴収入情報List());
        本算定通知書情報.set宛先情報(通知書共通情報.get宛先情報());
        本算定通知書情報.set口座情報(通知書共通情報.get口座情報());
        本算定通知書情報.set徴収方法情報_更正前(通知書共通情報.get徴収方法情報_更正前());
        本算定通知書情報.set徴収方法情報_更正後(通知書共通情報.get徴収方法情報_更正後());
        本算定通知書情報.set対象者_追加含む_情報_更正前(通知書共通情報.get対象者_追加含む_の情報_更正前());
        本算定通知書情報.set対象者_追加含む_情報_更正後(通知書共通情報.get対象者_追加含む_の情報_更正後());
        本算定通知書情報.set収入情報(通知書共通情報.get収入情報());
        DbT7065ChohyoSeigyoKyotsuEntity entity = load帳票制御共通(保険料納入通知書_帳票分類ID);
        if (entity != null) {
            本算定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(entity));
        }

        List<Kitsuki> 出力期リスト = get出力期リスト(出力期);
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
        if (出力期リスト == null) {
            return;
        }
        NonyuTsuchiShoJohoFactory nonyuTsuchiShoJohoFactory = InstanceProvider.create(NonyuTsuchiShoJohoFactory.class);
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報
                = nonyuTsuchiShoJohoFactory.create本算定納入通知書情報(本算定通知書情報, 本算定納入通知書制御情報, 出力期リスト, 代納人氏名);

        if (本算定_区分.equals(区分)) {
            publish納入通知書本算定(帳票ID, 本算定納入通知書情報, reportManager);
        } else {
            publish納入通知書過年度(帳票ID, 本算定納入通知書情報, reportManager);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(GyomuKoyuJoho.被保番号.getコード()),
                parameter.get賦課の情報_更正後().get被保険者番号().getColumnValue());
        save帳票発行履歴(reportSourceDataCollection, 帳票ID, parameter.get納入通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 保険料納入通知書_帳票分類ID);
    }

    private void publish納入通知書本算定(ReportId 帳票ID, HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {

        if (ReportIdDBB.DBB100045.getReportId().equals(帳票ID)) {
            new HokenryoNonyuTsuchishoKigotoPrintService().print(本算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100051.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100053.getReportId().equals(帳票ID)) {
            new HokenryoNonyuTsuchishoGinfuriPrintService().print(本算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100055.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100056.getReportId().equals(帳票ID)) {
            new HokenryoNonyuTsuchishoBookPrintService().print(本算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100061.getReportId().equals(帳票ID)) {
            new NonyuTsuchishoCVSMultiPrintService().print(本算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100059.getReportId().equals(帳票ID)) {
            new NonyuTsuchishoCVSKakukoPrintService().print(本算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100063.getReportId().equals(帳票ID)) {
            new NonyuTsuchishoCVSKigotoPrintService().print(本算定納入通知書情報, reportManager);
        }
    }

    private void publish納入通知書過年度(ReportId 帳票ID, HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {

        if (ReportIdDBB.DBB100066.getReportId().equals(帳票ID)) {
            new KanendoHokenryoNonyuTsuchishoKigotoPrintService().print(本算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100069.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100070.getReportId().equals(帳票ID)) {
            new KanendoHokenryoNonyuTsuchishoGinfuriPrintService().print(本算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100071.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100072.getReportId().equals(帳票ID)) {
            new KanendoNonyuTsuchishoBookFuriKaePrintService().print(本算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100075.getReportId().equals(帳票ID)) {
            new KanendoNonyuTsuchishoCVSMultiPrintService().print(本算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100073.getReportId().equals(帳票ID)) {
            new KanendoNonyuTsuchishoCVSKakukoPrintService().print(本算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100076.getReportId().equals(帳票ID)) {
            new KanendoNonyuTsuchishoCVSKigotoPrintService().print(本算定納入通知書情報, reportManager);
        }
    }

    /**
     * 賦課台帳（本算定）発行メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param reportManager ReportManager
     */
    public void publish賦課台帳本算定(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager) {

        FukaDaityouInfo fukaDaityouInfo = load賦課台帳情報(parameter, 通知書共通情報);
        FukaJoho 前年度賦課 = find前年度賦課(通知書共通情報.get賦課の情報_更正後().get賦課情報());
        FukaDaichoInfo 賦課台帳情報 = new FukaDaichoInfo();
        賦課台帳情報.set基準日時(fukaDaityouInfo.get基準日時());
        賦課台帳情報.set賦課の情報_更正後(通知書共通情報.get賦課の情報_更正後());
        賦課台帳情報.set賦課の情報_更正前(通知書共通情報.get賦課の情報_更正前());
        賦課台帳情報.set口座情報(通知書共通情報.get口座情報());
        賦課台帳情報.set代納人情報_更正後(fukaDaityouInfo.get代納人情報());
        賦課台帳情報.set収入情報(通知書共通情報.get収入情報());
        賦課台帳情報.set被保険者台帳情報(fukaDaityouInfo.get被保険者台帳情報());
        賦課台帳情報.set世帯員所得情報(fukaDaityouInfo.get世帯員所得情報());
        賦課台帳情報.set前年度情報(前年度賦課);
        賦課台帳情報.set境界層当該者情報(fukaDaityouInfo.get境界層当該者情報());
        賦課台帳情報.set徴収方法情報(通知書共通情報.get徴収方法情報_更正後());
        賦課台帳情報.set対象者_追加含む_情報(通知書共通情報.get対象者_追加含む_の情報_更正後());
        賦課台帳情報.set納組情報(通知書共通情報.get納組情報());
        賦課台帳情報.set地方公共団体(通知書共通情報.get地方公共団体());
        DbT7065ChohyoSeigyoKyotsuEntity entity = load帳票制御共通(賦課台帳本算定_帳票分類ID);
        if (entity != null) {
            賦課台帳情報.set帳票制御共通(new ChohyoSeigyoKyotsu(entity));
        }
        賦課台帳情報.set本人連絡先1(fukaDaityouInfo.get本人連絡先1());
        賦課台帳情報.set本人連絡先2(fukaDaityouInfo.get本人連絡先2());
        賦課台帳情報.set代納人連絡先1(fukaDaityouInfo.get代納人連絡先1());
        賦課台帳情報.set代納人連絡先2(fukaDaityouInfo.get代納人連絡先2());
        賦課台帳情報.set支払方法変更リスト(fukaDaityouInfo.get支払方法変更リスト());
        賦課台帳情報.set受給者台帳情報(fukaDaityouInfo.get受給者台帳情報());
        FukaDaichoDataHenshu fukaDaichoDataHenshu = FukaDaichoDataHenshu.createInstance();
        EditedHonSanteiFukaDaichoJoho 編集後本算定賦課台帳情報 = fukaDaichoDataHenshu.create編集後本算定賦課台帳情報(賦課台帳情報);
        new FukaDaichoPrintService().printSingle(編集後本算定賦課台帳情報, reportManager);

        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 賦課台帳本算定_帳票分類ID);
    }

    /**
     * 介護保険料減免決定通知書発行メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param reportManager ReportManager
     * @param reportSourceDataCollection List<ReportSourceDataCollection>
     */
    public void publish介護保険料減免決定通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager,
            List<ReportSourceDataCollection> reportSourceDataCollection) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(介護保険料減免決定通知書_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100077.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100078.getReportId();
        }
        if (帳票ID == null) {
            return;
        }

        IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー
                = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 介護保険料減免決定通知書_帳票分類ID);
        GemmenJohoManager gemmenJohoManager = GemmenJohoManager.createInstance();
        GemmenJohoRelateSonotaMapperParameter paramt
                = GemmenJohoRelateSonotaMapperParameter.createSelectByKeyParam(通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定年度(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get賦課年度(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get通知書番号(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get履歴番号(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定日時());
        GemmenJoho 減免の情報_更正後 = gemmenJohoManager.get減免の情報_決定更正後(paramt);

        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = load帳票制御共通(介護保険料減免決定通知書_帳票分類ID);
        GenmenKetteiTsuchiShoJoho 減免決定通知書情報 = new GenmenKetteiTsuchiShoJoho();
        if (通知書共通情報.get賦課の情報_更正前() != null) {
            減免決定通知書情報.set賦課の情報更正前(通知書共通情報.get賦課の情報_更正前().get賦課情報());
        }
        減免決定通知書情報.set減免の情報更正後(減免の情報_更正後);
        減免決定通知書情報.set宛名(通知書共通情報.get宛名情報());
        減免決定通知書情報.set宛先(通知書共通情報.get宛先情報());
        減免決定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        減免決定通知書情報.set納組情報(通知書共通情報.get納組情報());
        if (帳票制御共通 != null) {
            減免決定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(帳票制御共通));
        }
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
        if (ReportIdDBB.DBB100077.getReportId().equals(帳票ID)) {
            new GenmenKetteiTsuchiShoPrintService().printB5横タイプ(parameter.get減免通知書_発行日(),
                    parameter.get減免通知書_文書番号(), 減免決定通知書情報, 通知書定型文, 介護問合せ先ソースビルダー, reportManager);
        } else {
            new GenmenKetteiTsuchiShoPrintService().printA4縦タイプ(parameter.get減免通知書_発行日(),
                    parameter.get減免通知書_文書番号(), 減免決定通知書情報, 通知書定型文, 介護問合せ先ソースビルダー, reportManager);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(GyomuKoyuJoho.被保番号.getコード()),
                parameter.get賦課の情報_更正後().get被保険者番号().getColumnValue());
        save帳票発行履歴(reportSourceDataCollection, 帳票ID, parameter.get減免通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 介護保険料減免決定通知書_帳票分類ID);
    }

    /**
     * 介護保険料減免取消通知書発行メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param reportManager ReportManager
     * @param reportSourceDataCollection List<ReportSourceDataCollection>
     */
    public void publish介護保険料減免取消通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager,
            List<ReportSourceDataCollection> reportSourceDataCollection) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(介護保険料減免取消通知書_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100079.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100080.getReportId();
        }
        if (帳票ID == null) {
            return;
        }

        IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー
                = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 介護保険料減免取消通知書_帳票分類ID);
        GemmenJohoManager gemmenJohoManager = GemmenJohoManager.createInstance();
        GemmenJohoRelateSonotaMapperParameter paramt
                = GemmenJohoRelateSonotaMapperParameter.createSelectByKeyParam(通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定年度(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get賦課年度(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get通知書番号(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get履歴番号(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定日時());
        GemmenJoho 減免の情報_更正後 = gemmenJohoManager.get減免の情報_取消更正後(paramt);

        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = load帳票制御共通(介護保険料減免取消通知書_帳票分類ID);
        GemmenTorikesiTsuchiShoJoho 減免取消通知書情報 = new GemmenTorikesiTsuchiShoJoho();
        if (通知書共通情報.get賦課の情報_更正前() != null) {
            減免取消通知書情報.set賦課の情報更正前(通知書共通情報.get賦課の情報_更正前().get賦課情報());
        }
        減免取消通知書情報.set減免の情報更正後(減免の情報_更正後);
        減免取消通知書情報.set宛名(通知書共通情報.get宛名情報());
        減免取消通知書情報.set宛先(通知書共通情報.get宛先情報());
        減免取消通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        減免取消通知書情報.set納組情報(通知書共通情報.get納組情報());
        if (帳票制御共通 != null) {
            減免取消通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(帳票制御共通));
        }
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
        if (ReportIdDBB.DBB100079.getReportId().equals(帳票ID)) {
            new GemmenTorikesiTsuchiShoPrintService().printB5横タイプ(parameter.get減免通知書_発行日(),
                    parameter.get減免通知書_文書番号(), 減免取消通知書情報, 通知書定型文, 介護問合せ先ソースビルダー, reportManager);
        } else {
            new GemmenTorikesiTsuchiShoPrintService().printA4縦タイプ(parameter.get減免通知書_発行日(),
                    parameter.get減免通知書_文書番号(), 減免取消通知書情報, 通知書定型文, 介護問合せ先ソースビルダー, reportManager);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(GyomuKoyuJoho.被保番号.getコード()),
                parameter.get賦課の情報_更正後().get被保険者番号().getColumnValue());
        save帳票発行履歴(reportSourceDataCollection, 帳票ID, parameter.get減免通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 介護保険料減免取消通知書_帳票分類ID);
    }

    /**
     * 介護保険料徴収猶予決定通知書メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param reportManager ReportManager
     * @param reportSourceDataCollection List<ReportSourceDataCollection>
     */
    public void publish介護保険料徴収猶予決定通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager,
            List<ReportSourceDataCollection> reportSourceDataCollection) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(介護保険料徴収猶予決定通知書_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100081.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100082.getReportId();
        }
        if (帳票ID == null) {
            return;
        }

        IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー
                = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 介護保険料徴収猶予決定通知書_帳票分類ID);
        ChoshuYuyoJohoRelateSonotaMapperParameter paramt
                = ChoshuYuyoJohoRelateSonotaMapperParameter.createSelectByKeyParam(
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定年度(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get賦課年度(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get通知書番号(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get履歴番号(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定日時());
        ChoshuYuyoJohoManager choshuYuyoJohoManager = ChoshuYuyoJohoManager.createInstance();
        ChoshuYuyoJoho 徴収猶予の情報 = choshuYuyoJohoManager.get徴収猶予の情報_決定更正後(paramt);
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
        KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報 = new KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho();
        徴収猶予決定通知書情報.set徴収猶予の情報(徴収猶予の情報);
        徴収猶予決定通知書情報.set宛名(通知書共通情報.get宛名情報());
        徴収猶予決定通知書情報.set宛先(通知書共通情報.get宛先情報());
        徴収猶予決定通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        徴収猶予決定通知書情報.set納組情報(通知書共通情報.get納組情報());
        if (帳票制御共通 != null) {
            徴収猶予決定通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(帳票制御共通));
        }
        if (ReportIdDBB.DBB100081.getReportId().equals(帳票ID)) {
            new KaigoHokenryoChoshuyuyoKetteiTsuchishoPrintService()
                    .printB5横タイプ(get発行日(parameter.get徴収猶予通知書_発行日()), parameter.get徴収猶予通知書_文書番号(),
                            徴収猶予決定通知書情報, 通知書定型文, 介護問合せ先ソースビルダー, reportManager);
        } else {
            new KaigoHokenryoChoshuyuyoKetteiTsuchishoPrintService()
                    .printA4縦タイプ(get発行日(parameter.get徴収猶予通知書_発行日()), parameter.get徴収猶予通知書_文書番号(),
                            徴収猶予決定通知書情報, 通知書定型文, 介護問合せ先ソースビルダー, reportManager);
        }
        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(GyomuKoyuJoho.被保番号.getコード()),
                parameter.get賦課の情報_更正後().get被保険者番号().getColumnValue());
        save帳票発行履歴(reportSourceDataCollection, 帳票ID, parameter.get徴収猶予通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 介護保険料徴収猶予決定通知書_帳票分類ID);
    }

    /**
     * 介護保険料徴収猶予取消通知書メソッドです。
     *
     * @param parameter KakushuTsuchishoParameter
     * @param 通知書共通情報 KakushuTsuchishoCommonInfo
     * @param reportManager ReportManager
     * @param reportSourceDataCollection List<ReportSourceDataCollection>
     */
    public void publish介護保険料徴収猶予取消通知書(KakushuTsuchishoParameter parameter,
            KakushuTsuchishoCommonInfo 通知書共通情報, ReportManager reportManager,
            List<ReportSourceDataCollection> reportSourceDataCollection) {

        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(介護保険料徴収猶予取消通知書_帳票分類ID, 管理年度, 項目名);
        if (帳票制御汎用 == null) {
            return;
        }
        RString 通知書タイプ = 帳票制御汎用.get設定値();
        ReportId 帳票ID = null;
        if (通知書タイプ_B5横.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100083.getReportId();
        } else if (通知書タイプ_A4縦.equals(通知書タイプ)) {
            帳票ID = ReportIdDBB.DBB100084.getReportId();
        }
        if (帳票ID == null) {
            return;
        }

        IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー
                = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 介護保険料徴収猶予取消通知書_帳票分類ID);
        ChoshuYuyoJohoRelateSonotaMapperParameter paramt
                = ChoshuYuyoJohoRelateSonotaMapperParameter.createSelectByKeyParam(
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定年度(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get賦課年度(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get通知書番号(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get履歴番号(),
                        通知書共通情報.get賦課の情報_更正後().get賦課情報().get調定日時());
        ChoshuYuyoJohoManager choshuYuyoJohoManager = ChoshuYuyoJohoManager.createInstance();
        ChoshuYuyoJoho 徴収猶予の情報 = choshuYuyoJohoManager.get徴収猶予の情報_取消更正後(paramt);
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
        ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報 = new ChoshuYuyoTorikesiTsuchiShoJoho();
        徴収猶予取消通知書情報.set徴収猶予の情報(徴収猶予の情報);
        徴収猶予取消通知書情報.set宛名(通知書共通情報.get宛名情報());
        徴収猶予取消通知書情報.set宛先(通知書共通情報.get宛先情報());
        徴収猶予取消通知書情報.set地方公共団体(通知書共通情報.get地方公共団体());
        徴収猶予取消通知書情報.set納組情報(通知書共通情報.get納組情報());
        if (帳票制御共通 != null) {
            徴収猶予取消通知書情報.set帳票制御共通(new ChohyoSeigyoKyotsu(帳票制御共通));
        }
        if (ReportIdDBB.DBB100083.getReportId().equals(帳票ID)) {
            new ChoshuYuyoTorikesiTsuchiShoPrintService()
                    .printB5横タイプ(parameter.get徴収猶予通知書_発行日(), parameter.get徴収猶予通知書_文書番号(),
                            徴収猶予取消通知書情報, 通知書定型文, 介護問合せ先ソースビルダー, reportManager);
        } else {
            new ChoshuYuyoTorikesiTsuchiShoPrintService()
                    .printA4縦タイプ(parameter.get徴収猶予通知書_発行日(), parameter.get徴収猶予通知書_文書番号(),
                            徴収猶予取消通知書情報, 通知書定型文, 介護問合せ先ソースビルダー, reportManager);
        }

        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        識別コードList.add(通知書共通情報.get賦課の情報_更正後().get賦課情報().get識別コード());
        Map<Code, RString> 業務固有情報 = new HashMap<>();
        業務固有情報.put(new Code(GyomuKoyuJoho.被保番号.getコード()),
                parameter.get賦課の情報_更正後().get被保険者番号().getColumnValue());
        save帳票発行履歴(reportSourceDataCollection, 帳票ID, parameter.get徴収猶予通知書_発行日(), 業務固有情報, 識別コードList);
        insertリアル発行履歴(通知書共通情報.get賦課の情報_更正後().get賦課情報(), 介護保険料徴収猶予取消通知書_帳票分類ID);
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
        entity.setTsuchishoPrintTimeStamp(new YMDHMS(RDate.getNowDate().toString()
                + RDate.getNowTime().toString().replaceAll(FORMAT.toString(), RString.EMPTY.toString()).substring(0, 設定値_番号6)));
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
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        builder.set業務コード(GyomuCode.DB介護保険);
        IKozaSearchKey kozaSearchKey = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        RStringBuilder rStringBuilder = new RStringBuilder();
        rStringBuilder.append(LEFT_FORMAT);
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                rStringBuilder.append(list.get(i) == null ? RString.EMPTY : list.get(i).getColumnValue());
                if (i != list.size() - 1) {
                    rStringBuilder.append(MIDDLE_FORMAT);
                }
            }
        }
        rStringBuilder.append(RIGHT_FORMAT);
        RString 科目コード = rStringBuilder.toRString();
        RString 処理日 = new RString(FlexibleDate.getNowDate().toString());
        KakushuTsuchishoEntityParameter 更正後
                = KakushuTsuchishoEntityParameter.createSelectByKeyParam(賦課の情報_更正後.get調定年度(),
                        賦課の情報_更正後.get賦課年度(), 賦課の情報_更正後.get通知書番号(),
                        賦課の情報_更正後.get履歴番号(), 賦課の情報_更正後.get調定日時(),
                        賦課の情報_更正後.get調定日時().getDate().toDateString(), 処理日, kozaSearchKey, list, 科目コード);
        KakushuTsuchishoEntity 更正後entity = mapper.get更正前後賦課の情報(更正後);
        KakushuTsuchishoEntity 更正前entity = get賦課の情報更正前(賦課の情報_更正前, 処理日, kozaSearchKey, list, 科目コード);
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
        boolean 本算定区分_更正後 = false;
        boolean 本算定区分_更正前 = false;
        if (賦課の情報更正後 != null && 賦課の情報更正前 != null) {
            本算定区分_更正後 = honsanteiIkoHantei.is本算定後(賦課の情報更正後.get賦課情報());
            本算定区分_更正前 = honsanteiIkoHantei.is本算定後(賦課の情報更正前.get賦課情報());
        }
        NenkinTokuchoKaifuJoho 対象者_追加含む_の情報_更正後 = get対象者_追加含む_の情報(本算定区分_更正後, 更正後entity, 賦課の情報_更正後);
        NenkinTokuchoKaifuJoho 対象者_追加含む_の情報_更正前 = get対象者_追加含む_の情報(本算定区分_更正前, 更正前entity, 賦課の情報_更正前);

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
            if (宛名納組宛先口座entity.get口座() != null) {
                通知書共通情報.set口座情報(new Koza(宛名納組宛先口座entity.get口座()));
            }
        }
        通知書共通情報.setマスク口座情報(マスク済み口座);
        set徴収方法情報(通知書共通情報, 更正前entity, 更正後entity);

        通知書共通情報.set対象者_追加含む_の情報_更正前(対象者_追加含む_の情報_更正前);
        通知書共通情報.set対象者_追加含む_の情報_更正後(対象者_追加含む_の情報_更正後);
        if (賦課の情報更正後 != null) {
            FukaJohoRelateEntity entity = new FukaJohoRelateEntity();
            entity.set介護賦課Entity(更正後entity.get介護賦課());
            entity.set介護期別RelateEntity(更正後entity.get介護期別RelateEntity());
            通知書共通情報.set収入情報(get収入情報(賦課の情報更正後.get賦課情報(), entity, 更正後entity));
        }
        通知書共通情報.set年度区分(年度区分);
        return 通知書共通情報;
    }

    private KakushuTsuchishoEntity get賦課の情報更正前(FukaJoho 賦課の情報_更正前, RString 処理日, IKozaSearchKey kozaSearchKey,
            List<KamokuCode> list, RString 科目コード) {

        if (賦課の情報_更正前 == null) {
            return null;
        }
        IKakushuTsuchishoSakuseiMapper mapper = mapperProvider.create(IKakushuTsuchishoSakuseiMapper.class);
        KakushuTsuchishoEntityParameter 更正前
                = KakushuTsuchishoEntityParameter.createSelectByKeyParam(賦課の情報_更正前.get調定年度(),
                        賦課の情報_更正前.get賦課年度(), 賦課の情報_更正前.get通知書番号(),
                        賦課の情報_更正前.get履歴番号(), 賦課の情報_更正前.get調定日時(),
                        賦課の情報_更正前.get調定日時().getDate().toDateString(), 処理日, kozaSearchKey, list, 科目コード);
        return mapper.get更正前後賦課の情報(更正前);
    }

    private void set徴収方法情報(KakushuTsuchishoCommonInfo 通知書共通情報, KakushuTsuchishoEntity 更正前entity,
            KakushuTsuchishoEntity 更正後entity) {

        if (更正前entity != null && 更正前entity.get介護徴収方法() != null) {
            通知書共通情報.set徴収方法情報_更正前(new ChoshuHoho(更正前entity.get介護徴収方法()));
        }
        if (更正後entity != null && 更正後entity.get介護徴収方法() != null) {
            通知書共通情報.set徴収方法情報_更正後(new ChoshuHoho(更正後entity.get介護徴収方法()));
        }
    }

    private ShunyuJoho get収入情報(FukaJoho 賦課の情報, FukaJohoRelateEntity 賦課,
            KakushuTsuchishoEntity 更正後entity) {

        if (更正後entity == null) {
            return null;
        }
        List<TotalShunyuRelateEntity> 収入情報取得PSM = 更正後entity.get収入情報取得PSM();
        if (収入情報取得PSM == null || 収入情報取得PSM.isEmpty() || 賦課 == null) {
            return null;
        }
        fukaJoho(賦課, 収入情報取得PSM);
        ShunyuJoho 収入情報 = new ShunyuJoho();
        if (賦課の情報 != null) {
            収入情報.set調定年度(賦課の情報.get調定年度());
            収入情報.set賦課年度(賦課の情報.get賦課年度());
            収入情報.set通知書番号(賦課の情報.get通知書番号());
        }
        収入情報.set普徴収入額01(get普徴収入額01());
        収入情報.set普徴収入額02(get普徴収入額02());
        収入情報.set普徴収入額03(get普徴収入額03());
        収入情報.set普徴収入額04(get普徴収入額04());
        収入情報.set普徴収入額05(get普徴収入額05());
        収入情報.set普徴収入額06(get普徴収入額06());
        収入情報.set普徴収入額07(get普徴収入額07());
        収入情報.set普徴収入額08(get普徴収入額08());
        収入情報.set普徴収入額09(get普徴収入額09());
        収入情報.set普徴収入額10(get普徴収入額10());
        収入情報.set普徴収入額11(get普徴収入額11());
        収入情報.set普徴収入額12(get普徴収入額12());
        収入情報.set普徴収入額13(get普徴収入額13());
        収入情報.set普徴収入額14(get普徴収入額14());
        収入情報.set特徴収入額01(get特徴収入額01());
        収入情報.set特徴収入額02(get特徴収入額02());
        収入情報.set特徴収入額03(get特徴収入額03());
        収入情報.set特徴収入額04(get特徴収入額04());
        収入情報.set特徴収入額05(get特徴収入額05());
        収入情報.set特徴収入額06(get特徴収入額06());
        return 収入情報;
    }

    private NenkinTokuchoKaifuJoho get対象者_追加含む_の情報(boolean 本算定区分,
            KakushuTsuchishoEntity 更正前後entity, FukaJoho 賦課の情報) {

        if (更正前後entity == null || 賦課の情報 == null) {
            return null;
        }
        NenkinTokuchoKaifuJohoManager nenkinTokuchoKaifuJohoManager = InstanceProvider.create(NenkinTokuchoKaifuJohoManager.class);
        if (本算定区分) {
            return nenkinTokuchoKaifuJohoManager.get年金特徴対象者情報(GyomuCode.DB介護保険,
                    賦課の情報.get賦課年度(), 更正前後entity.get介護徴収方法().getHonNenkinNo(),
                    更正前後entity.get介護徴収方法().getHonNenkinCode(), 更正前後entity.get介護徴収方法().getHonHosokuM());
        }
        return nenkinTokuchoKaifuJohoManager.get年金特徴対象者情報(GyomuCode.DB介護保険,
                賦課の情報.get賦課年度().minusYear(定値_番号1), 更正前後entity.get介護徴収方法().getKariNenkinNo(),
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

        if (賦課の情報 == null) {
            return null;
        }
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_被保険者番号.toString(), 賦課の情報.get被保険者番号());
        parameter.put(キー_賦課年度.toString(), 賦課の情報.get賦課年度().minusYear(定値_番号1));
        FukaJohoManager manager = FukaJohoManager.createInstance();
        return manager.get前年度賦課の情報(parameter);
    }

    /**
     * 発行履歴の登録メソッドです。
     *
     * @param sourceDataCollection sourceDataCollection
     * @param 通知書発行日 FlexibleDate
     * @param 業務固有情報 Map
     * @param 識別コードList List<ShikibetsuCode>
     */
    private void save帳票発行履歴(List<ReportSourceDataCollection> reportSourceDataCollection, ReportId 帳票ID, FlexibleDate 通知書発行日,
            Map<Code, RString> 業務固有情報, List<ShikibetsuCode> 識別コードList) {

        ReportSourceDataCollection reportSourceData = new ReportSourceDataCollection();
        reportSourceData.set帳票ID(帳票ID);
        reportSourceData.set通知書発行日(通知書発行日);
        reportSourceData.set業務固有情報(業務固有情報);
        reportSourceData.set識別コードList(識別コードList);
        reportSourceDataCollection.add(reportSourceData);
    }

    /**
     * 発行履歴の登録メソッドです。
     *
     * @param sourceDataCollection sourceDataCollection
     * @param 通知書発行日 FlexibleDate
     * @param 業務固有情報 Map
     * @param 識別コードList List<ShikibetsuCode>
     */
    private void insert帳票発行履歴(SourceDataCollection sourceDataCollection,
            List<ReportSourceDataCollection> reportSourceDataCollection) {

        if (sourceDataCollection == null || reportSourceDataCollection == null || reportSourceDataCollection.isEmpty()) {
            return;
        }
        Iterator<SourceData> sourceDataList = sourceDataCollection.iterator();
        while (sourceDataList.hasNext()) {
            SourceData sourceData = sourceDataList.next();
            for (ReportSourceDataCollection reportSourceData : reportSourceDataCollection) {
                if (sourceData.getReportId().equals(reportSourceData.get帳票ID().value())) {
                    HakkoRirekiManagerFactory.createInstance().insert帳票発行履歴(sourceData, reportSourceData.get通知書発行日(),
                            ChohyoHakkoRirekiJotai.新規作成, reportSourceData.get業務固有情報(), reportSourceData.get識別コードList());
                    break;
                }
            }
        }
    }
}
