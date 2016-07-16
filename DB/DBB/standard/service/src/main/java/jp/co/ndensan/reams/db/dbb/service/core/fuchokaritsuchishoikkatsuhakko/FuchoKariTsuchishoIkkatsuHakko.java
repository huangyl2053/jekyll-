/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuchokaritsuchishoikkatsuhakko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.karisanteiidotsuchisho.TsuchishoKyotsuEntity;
import jp.co.ndensan.reams.db.dbb.business.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranProperty.DBB100014NonyuTsuchishoEnum;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.ShunyuJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NotsuKozaShutsuryokuTaisho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko.FuchNokumiParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko.FuchoInsTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko.FuchokaritsuchishoikkatsuhakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.FuchoKariTsuchishoIkkatsuHakkoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokaritsuchishoikkatsuhakko.IFuchoKariTsuchishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakkoFath;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbb.service.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSKigotoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchisho.notsu.NonyuTsuchiShoJohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AtesakiShubetsu;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 普徴仮算定通知書一括発行（バッチ）クラスです。
 *
 * @reamsid_L DBB-0710-040 yebangqiang
 */
public class FuchoKariTsuchishoIkkatsuHakko {

    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_4 = 4;
    private static final int NUM_7 = 7;
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString HYPHEN = new RString("-");
    private static final RString スペース = new RString(" ");
    private final RDate nowDate;
    private static final RString 帳票タイプ_期毎タイプ = new RString("期毎タイプ");
    private static final RString 帳票タイプ_銀振タイプ = new RString("銀振タイプ");
    private static final RString 帳票タイプ_ブックタイプ = new RString("ブックタイプ");
    private static final RString 帳票タイプ_コンビニタイプ = new RString("コンビニタイプ");
    private static final RString 帳票タイトル_期毎タイプ = new RString("保険料納入通知書（仮算定）【期毎タイプ】");
    private static final RString 帳票タイトル_期毎タイプ_連帳 = new RString("保険料納入通知書（仮算定）【期毎タイプ（連帳）】");
    private static final RString 帳票タイトル_銀振タイプ = new RString("保険料納入通知書（仮算定）【銀振4期タイプ】");
    private static final RString 帳票タイトル_銀振タイプ_連帳 = new RString("保険料納入通知書（仮算定）【銀振4期タイプ（連帳）】");
    private static final RString 帳票タイトル_ブックタイプ = new RString("保険料納入通知書（仮算定）【ブック（口振依頼あり通知書＋納付書）タイプ】");
    private static final RString 帳票タイトル_ブックタイプ_連帳 = new RString("保険料納入通知書（仮算定）【ブック（口振依頼あり通知書＋納付書）タイプ（連帳）】");
    private static final RString 帳票タイトル_ブックタイプ口振依頼な = new RString("保険料納入通知書（仮算定）【ブック（口振依頼なし通知書＋納付書）タイプ】");
    private static final RString 帳票タイトル_ブックタイプ口振依頼な_連帳 = new RString("保険料納入通知書（仮算定）【ブック（口振依頼なし通知書＋納付書）タイプ（連帳）】");
    private static final RString 帳票タイトル_コンビニタイプ = new RString("保険料納入通知書（仮算定）【コンビニマルチ収納タイプ通知書】");
    private static final RString 帳票タイトル_コンビニタイプ_連帳 = new RString("保険料納入通知書（仮算定）【コンビニマルチ収納タイプ通知書（連帳）】");
    private static final RString 帳票タイトル_コンビニタイプ_角公タイプ = new RString("保険料納入通知書（仮算定）【コンビニ角公タイプ】");
    private static final RString 帳票タイトル_コンビニタイプ_角公タイプ_連帳 = new RString("保険料納入通知書（仮算定）【コンビニ角公タイプ（連帳）】");
    private static final RString 帳票タイトル_コンビニ期毎タイプ = new RString("保険料納入通知書（仮算定）【コンビニ期毎タイプ】");
    private static final RString 帳票タイトル_コンビニ期毎タイプ_連帳 = new RString("保険料納入通知書（仮算定）【コンビニ期毎タイプ（連帳）】");
    private static final RString 出力期表示方法_1 = new RString("1");
    private static final RString 重複な期情報 = new RString("0");
    private static final RString ブック開始位置_1 = new RString("1");
    private static final RString ブック開始位置_2 = new RString("2");
    private static final RString ブック開始位置_3 = new RString("3");
    private static final RString ブック開始位置_4 = new RString("4");
    private static final RString ブック開始位置_5 = new RString("5");
    private static final RString 入力_調定前年度 = new RString("調定前年度");
    private static final RString 処理名 = new RString("普徴仮算定通知書一括発行");
    private static final RString 帳票名 = new RString("保険料納入通知書（仮算定）");
    private static final RString パラメータ名_調定年度 = new RString("調定年度");
    private static final RString パラメータ名_賦課年度 = new RString("賦課年度");
    private static final RString パラメータ名_対象者 = new RString("対象者");
    private static final RString パラメータ名_発行日 = new RString("発行日");
    private static final RString パラメータ名_出力期 = new RString("出力期");
    private static final RString パラメータ名_生活保護対象者をまとめて先頭に出力 = new RString("生活保護対象者をまとめて先頭に出力");
    private static final RString パラメータ名_ページごとに山分け = new RString("ページごとに山分け");
    private static final int 月_4 = 4;
    private static final int 月_5 = 5;
    private static final int 月_6 = 6;
    private static final int 月_7 = 7;
    private static final int 月_8 = 8;
    private static final int 月_9 = 9;
    private static final int 月_10 = 10;
    private static final int 月_11 = 11;
    private static final int 月_12 = 12;
    private static final int 月_1 = 1;
    private static final int 月_2 = 2;
    private static final int 月_3 = 3;
    private static final int 月_14 = 14;
    private static final int 月_15 = 15;
    private static final int 特徴納期_1期 = 1;
    private static final int 特徴納期_3期 = 3;
    private static final int 出力期リストのサイズ_1 = 1;
    private static final int 出力期リストのサイズ_2 = 2;
    private static final int 出力期リストのサイズ_3 = 3;
    private static final int 出力期リストのサイズ_4 = 4;
    private static final int 出力期リストのサイズ_5 = 5;
    private static final int 出力期リストのサイズ_6 = 6;
    private static final int 出力期リストのサイズ_7 = 7;
    private static final int 出力期リストのサイズ_8 = 8;
    private static final int 出力期リストのサイズ_9 = 9;
    private static final int 出力期リストのサイズ_10 = 10;
    private static final int 山分け用スプール数_1 = 1;
    private static final int 山分け用スプール数_2 = 2;
    private static final int 山分け用スプール数_3 = 3;
    private static final int 山分け用スプール数_4 = 4;
    private static final int 山分け用スプール数_5 = 5;
    private static final RString 山分け区分_する = new RString(0);
    private static final RString 山分け区分_しない = new RString("1");
    private static final RString 出力条件_左括弧 = new RString("【");
    private static final RString 出力条件_右括弧 = new RString("】");
    private static final RString タイトル_作成日時 = new RString("作成年月日");
    private static final RString タイトル_作成時刻 = new RString("作成時刻");
    private static final RString タイトル_通知書番号 = new RString("通知書番号");
    private static final RString タイトル_被保険者番号 = new RString("被保険者番号");
    private static final RString タイトル_世帯コード = new RString("世帯コード");
    private static final RString タイトル_表示コード名１ = new RString("表示コード名１");
    private static final RString タイトル_表示コード名２ = new RString("表示コード名２");
    private static final RString タイトル_表示コード名３ = new RString("表示コード名３");
    private static final RString タイトル_表示コード１ = new RString("表示コード1");
    private static final RString タイトル_表示コード２ = new RString("表示コード2");
    private static final RString タイトル_表示コード３ = new RString("表示コード3");
    private static final RString タイトル_行政区 = new RString("行政区");
    private static final RString タイトル_保険料額 = new RString("保険料額");
    private static final RString タイトル_当期 = new RString("当期");
    private static final RString タイトル_納付人_送付先 = new RString("代納人／送付先");
    private static final RString タイトル_生保開始日 = new RString("生保開始日");
    private static final RString タイトル_生保種別 = new RString("生保種別");
    private static final RString タイトル_氏名 = new RString("氏名");
    private static final RString タイトル_郵便番号 = new RString("郵便番号");
    private static final RString タイトル_住所 = new RString("住所");
    private static final RString タイトル_町域_管内_管外住所 = new RString("町域（管内）・管外住所");
    private static final RString タイトル_番地 = new RString("番地");
    private static final RString タイトル_所得段階 = new RString("前所得段階");
    private static final RString タイトル_仮特別徴収額 = new RString("仮特別徴収額");
    private static final RString タイトル_次期以降 = new RString("次期以降");
    private static final RString タイトル_口座情報 = new RString("口座情報");
    private static final ReportId 帳票ID_出力順 = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_14 = 14;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200029"));
    private static final RString 英数字ファイル名 = new RString("TokubetsuChoshuHeijunkaKakuteiData.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString LEFT_FORMAT = new RString("'{");
    private static final RString RIGHT_FORMAT = new RString("}'");
    private static final RString MIDDLE_FORMAT = new RString(",");
    private static final RString 生活保護者先頭出力フラグ_する = new RString("1");
    private static final RString 生活保護者先頭出力フラグ_しない = new RString("0");
    private static final RString 生活保護区分 = new RString("seikatsuHogoKubun");
    private static final RString 口座区分 = new RString("dbT2015KeisangoJoho_kozaKubun");
    private static final RString 降順 = new RString("DESC,");
    private static final RString 昇順 = new RString("ASC,");
    private static final RString 定数_特徴方法 = new RString("getTkKibetsuGaku");
    private static final RString 定数_普徴方法 = new RString("getFuKibetsuGaku");
    private static final RString 定値区分_0 = new RString("0");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public FuchoKariTsuchishoIkkatsuHakko() {
        nowDate = RDate.getNowDate();
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FuchoKariTsuchishoIkkatsuHakko}のインスタンスを返します。
     *
     * @return FuchoKariTsuchishoIkkatsuHakko
     */
    public static FuchoKariTsuchishoIkkatsuHakko createInstance() {
        return InstanceProvider.create(FuchoKariTsuchishoIkkatsuHakko.class);
    }

    /**
     * 賦課情報の取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 一括発行起動フラグ boolean
     * @param 帳票分類ID ReportId
     */
    public void getFukaJoho(FlexibleYear 調定年度, FlexibleYear 賦課年度, boolean 一括発行起動フラグ, ReportId 帳票分類ID) {
        IFuchoKariTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IFuchoKariTsuchishoIkkatsuHakkoMapper.class);
        mapper.creat異動賦課情報一時();
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
        FuchNokumiParameter param = FuchNokumiParameter.createSelectByKeyParam(
                調定年度, 調定年度.minusYear(NUM_1), 賦課年度, 処理日, kozaSearchKey, list, 科目コード);
        if (一括発行起動フラグ) {
            mapper.insert異動賦課情報一時_計算後情報一時(param);
            mapper.update異動賦課情報_計算後情報一時_計算後情報更正前();
        } else {
            mapper.insert異動賦課情報一時_計算後情報(param);
            mapper.update異動賦課情報_計算後情報_計算後情報更正前();
        }
        Map<RString, FlexibleYear> map = new HashMap<>();
        map.put(入力_調定前年度, 調定年度.minusYear(NUM_1));
        mapper.update異動賦課情報_対象者仮徴収更正前(map);
        mapper.update異動賦課情報_生活保護区分();
        mapper.insert前年度全ての賦課情報(map);
        mapper.update異動賦課情報_前年度賦課情報();
    }

    /**
     * 特徴仮算定開始通知書帳票、特徴仮算定開始通知書一覧の帳票とＣＳＶを作成するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 RDateTime
     * @param 発行日 FlexibleDate
     * @param 出力方法 RString
     * @param 出力期表示方法 RString
     * @param 出力期 int
     * @param 納入通知書対象者 NotsuKozaShutsuryokuTaisho
     * @param 生活保護者先頭出力フラグ RString
     * @param 山分け区分 RString
     * @param 出力順ID Long
     * @param 帳票ID ReportId
     * @throws java.lang.reflect.InvocationTargetException 賦課情報が取得できない場合、Exception
     */
    public void printTsuchisho(FlexibleYear 調定年度, FlexibleYear 賦課年度, RDateTime 調定日時, FlexibleDate 発行日,
            RString 出力方法, RString 出力期表示方法, int 出力期, NotsuKozaShutsuryokuTaisho 納入通知書対象者,
            RString 生活保護者先頭出力フラグ, RString 山分け区分, Long 出力順ID, ReportId 帳票ID) throws InvocationTargetException {
        IFuchoKariTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IFuchoKariTsuchishoIkkatsuHakkoMapper.class);
        RString 帳票タイプ = 帳票タイプを取得する(帳票ID);
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, 帳票ID_出力順, 出力順ID);
        RString 出力順 = RString.EMPTY;
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(DBB100014NonyuTsuchishoEnum.class, outputOrder);
        }
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 普徴仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        int to出力期 = 普徴仮算定期間.getLast().get期AsInt();
        if (出力期表示方法_1.equals(出力期表示方法)) {
            to出力期 = 出力期;
        }
        KitsukiList 出力期の期月リスト = 期月リスト_普徴.subListBy期(出力期, to出力期);

        List<Noki> 普徴納期リスト = FukaNokiResearcher.createInstance().get普徴納期ALL();
        List<NokiJoho> 出力期の期月情報リスト = new ArrayList<>();
        for (Kitsuki 出力期の期月 : 出力期の期月リスト.toList()) {
            for (Noki 普徴納期 : 普徴納期リスト) {
                NokiJoho 期月情報 = new NokiJoho();
                if (出力期の期月.get期AsInt() == 普徴納期.get期別()) {
                    期月情報.set期月(出力期の期月);
                    期月情報.set納期(普徴納期);
                    出力期の期月情報リスト.add(期月情報);
                }
            }
        }
        TsuchishoKyotsuEntity 通知書共通情報 = get通知書共通情報(調定年度);
        KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報 = NonyuTsuchiShoSeigyoJohoLoaderFinder.
                createInstance().get仮算定納入通知書制御情報();
        int 普徴仮算定期間の最後の期 = 普徴仮算定期間.getLast().get期AsInt();
        RString 出力順_文字列 = 出力順文字列を取得(出力順, 生活保護者先頭出力フラグ);
        FuchokaritsuchishoikkatsuhakkoParameter param = FuchokaritsuchishoikkatsuhakkoParameter.createSelectByKeyParam(
                普徴仮算定期間の最後の期, 出力期, 納入通知書対象者.get名称(), 生活保護者先頭出力フラグ, 出力順_文字列);
        List<FuchoKariTsuchishoIkkatsuHakkoTempEntity> 出力対象データ = mapper.select出力対象データ(param);
        int 山分け用スプール数 = 0;
        if (山分け区分_する.equals(山分け区分)) {
            Kitsuki 今回の期月 = null;
            for (NokiJoho 出力期の期月情報 : 出力期の期月情報リスト) {
                final Kitsuki 期月 = 出力期の期月情報.get期月();
                if (期月.get期AsInt() == 出力期) {
                    今回の期月 = 期月;
                    break;
                }
            }
            if (帳票タイプ_期毎タイプ.equals(帳票タイプ)) {
                山分け用スプール数 = 出力期の期月情報リスト.size();
            } else if (帳票タイプ_銀振タイプ.equals(帳票タイプ)) {
                山分け用スプール数 = 1;
            } else if (帳票タイプ_ブックタイプ.equals(帳票タイプ)) {
                山分け用スプール数 = 今回出力期の印字位置を取得と山分け用スプール数の算出(
                        今回の期月, 出力期の期月情報リスト.size());
            } else if (帳票タイプ_コンビニタイプ.equals(帳票タイプ)) {
                山分け用スプール数 = コンビニカット印字位置を取得と山分け用スプール数の算出(今回の期月);
            }
        } else if (山分け区分_しない.equals(山分け区分)) {
            山分け用スプール数 = 1;
        }
        ChohyoSeigyoKyotsu 帳票制御共通情報 = new ChohyoSeigyoKyotsu(SubGyomuCode.DBB介護賦課, 帳票ID_出力順);
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        LasdecCode 市町村コード = 導入団体クラス.get地方公共団体コード();
        RString 市町村名 = 導入団体クラス.get市町村名();
        List<KariSanteiNonyuTsuchiShoJoho> 仮算定納入通知書情報リスト = new ArrayList<>();
        List<Kitsuki> 出力期リスト = get出力期リスト(出力期);
        SourceDataCollection sourceDataCollection;
        try (ReportManager reportManager = new ReportManager()) {
            for (FuchoKariTsuchishoIkkatsuHakkoTempEntity 異動賦課情報 : 出力対象データ) {
                KariSanteiTsuchiShoKyotsu 保険料納入通知書仮算定情報 = new KariSanteiTsuchiShoKyotsu();
                保険料納入通知書仮算定情報.set発行日(発行日);
                保険料納入通知書仮算定情報.set帳票分類ID(帳票ID_出力順);
                保険料納入通知書仮算定情報.set帳票ID(帳票ID);
                保険料納入通知書仮算定情報.set処理区分(ShoriKubun.バッチ);
                保険料納入通知書仮算定情報.set地方公共団体(導入団体クラス);
                FukaAtena 賦課情報_宛名_更正前 = new FukaAtena();
                賦課情報_宛名_更正前.set賦課情報(get賦課情報(異動賦課情報.get計算後情報_更正前()));
                FukaAtena 賦課情報_宛名_更正後 = new FukaAtena();
                賦課情報_宛名_更正後.set賦課情報(get賦課情報(異動賦課情報.get計算後情報_更正後()));
                保険料納入通知書仮算定情報.set賦課の情報_更正前(賦課情報_宛名_更正前);
                保険料納入通知書仮算定情報.set賦課の情報_更正後(賦課情報_宛名_更正後);
                保険料納入通知書仮算定情報.set納組情報(異動賦課情報.get納組());
                保険料納入通知書仮算定情報.set普徴納期情報リスト(通知書共通情報.get普徴納期情報リスト());
                保険料納入通知書仮算定情報.set特徴納期情報リスト(通知書共通情報.get特徴納期情報リスト());
                IAtesaki 宛先情報 = AtesakiFactory.createInstance(異動賦課情報.get宛先());
                保険料納入通知書仮算定情報.set宛先情報(宛先情報);
                保険料納入通知書仮算定情報.set前年度賦課情報(new FukaJoho(異動賦課情報.get賦課情報()));
                保険料納入通知書仮算定情報.set口座情報(new Koza(異動賦課情報.get口座()));
                保険料納入通知書仮算定情報.set徴収方法情報_更正前(get徴収方法情報(異動賦課情報.get計算後情報_更正前()));
                保険料納入通知書仮算定情報.set徴収方法情報_更正後(get徴収方法情報(異動賦課情報.get計算後情報_更正後()));
                保険料納入通知書仮算定情報.set対象者_追加含む_情報_更正前(new NenkinTokuchoKaifuJoho(
                        異動賦課情報.get年金特徴回付情報_更正前()));
                保険料納入通知書仮算定情報.set対象者_追加含む_情報_更正後(new NenkinTokuchoKaifuJoho(
                        異動賦課情報.get年金特徴回付情報_更正後()));
                保険料納入通知書仮算定情報.set収入情報(get収入情報(異動賦課情報.get計算後情報_更正後()));
                保険料納入通知書仮算定情報.set帳票制御共通(帳票制御共通情報);
                NonyuTsuchiShoJohoFactory 納入通知書情報作成サービス = new NonyuTsuchiShoJohoFactory();
                KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = 納入通知書情報作成サービス.create仮算定納入通知書情報(
                        保険料納入通知書仮算定情報, 仮算定納入通知書制御情報, 出力期リスト, 宛先情報.get宛先名称());
                仮算定納入通知書情報リスト.add(仮算定納入通知書情報);
                RString 口座情報 = 通知書の口座情報編集(仮算定納入通知書情報.get編集後仮算定通知書共通情報().get編集後口座());
                // TODO　QA913
                publish納入通知書仮算定(帳票ID, 仮算定納入通知書情報, reportManager);
            }
            sourceDataCollection = reportManager.publish();
        }
        // TODO
        List<EditedKariSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報List = new ArrayList<>();
        for (KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 : 仮算定納入通知書情報リスト) {
            編集後本算定通知書共通情報List.add(仮算定納入通知書情報.get編集後仮算定通知書共通情報());
        }
        KariNonyuTsuchishoHakkoIchiranPrintService printService = new KariNonyuTsuchishoHakkoIchiranPrintService();
        printService.print(仮算定納入通知書情報リスト, 出力順ID, YMDHMS.now(), 出力期);
        // TODO
        RString 文字コード = DbBusinessConfig.get(
                ConfigNameDBU.EUC共通_文字コード, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        publish納入通知書発行一覧表(調定日時, 編集後本算定通知書共通情報List, 出力期);
        RString 出力ページ数 = isNull(sourceDataCollection) ? 定値区分_0 : new RString(sourceDataCollection.iterator().next().getPageCount());
        if (帳票制御共通情報.is代行プリント有無()) {
            代行プリント送付票の出力(調定年度, 賦課年度, 納入通知書対象者, 出力順ID, 発行日, 出力期, 生活保護者先頭出力フラグ,
                    山分け区分, 市町村コード, 市町村名, 帳票ID, 出力ページ数);
        }
        バッチ出力条件リストの出力(発行日, 出力期, 生活保護者先頭出力フラグ, 山分け区分, 帳票ID, 市町村コード, 市町村名, 出力ページ数);
    }

    private List<Kitsuki> get出力期リスト(int 出力期) {

        List<Kitsuki> 出力期リスト = new ArrayList<>();
        KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト().filtered仮算定期間();
        for (Kitsuki 期月 : 期月リスト.toList()) {
            if (出力期 == 期月.get期AsInt()) {
                出力期リスト.add(期月);
                break;
            }
        }
        return 出力期リスト;
    }

    private void publish納入通知書仮算定(ReportId 帳票ID, KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, ReportManager reportManager) {

        if (ReportIdDBB.DBB100014.getReportId().equals(帳票ID)) {
            new KarisanteiHokenryoNonyuTsuchishoKigotoPrintService().print(仮算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100024.getReportId().equals(帳票ID)) {
            new KarisanteiNonyuTsuchishoCVSKakukoPrintService().print(仮算定納入通知書情報, reportManager);
        } else if (ReportIdDBB.DBB100025.getReportId().equals(帳票ID)) {
            new KarisanteiNonyuTsuchishoCVSKigotoPrintService().print(仮算定納入通知書情報, reportManager);
        }
    }

    private RString 出力順文字列を取得(RString 出力順, RString 生活保護者先頭出力フラグ) {
        if (!RString.isNullOrEmpty(出力順)) {
            List<RString> 出力順Arr = 出力順.split(RString.HALF_SPACE.toString());
            if (生活保護者先頭出力フラグ_する.equals(生活保護者先頭出力フラグ)) {
                出力順Arr.add(INDEX_2, EUC_WRITER_ENCLOSURE.concat(生活保護区分).concat(EUC_WRITER_ENCLOSURE));
                出力順Arr.add(INDEX_3, 降順);
                出力順Arr.add(INDEX_4, EUC_WRITER_ENCLOSURE.concat(口座区分).concat(EUC_WRITER_ENCLOSURE));
                出力順Arr.add(INDEX_5, 昇順);
            } else if (生活保護者先頭出力フラグ_しない.equals(生活保護者先頭出力フラグ)) {
                出力順Arr.add(INDEX_2, EUC_WRITER_ENCLOSURE.concat(口座区分).concat(EUC_WRITER_ENCLOSURE));
                出力順Arr.add(INDEX_3, 昇順);
            }
            RStringBuilder 出力順_文字列 = new RStringBuilder(RString.EMPTY);
            for (Object 出力順Obj1 : 出力順Arr.toArray()) {
                出力順_文字列.append(出力順Obj1).append(RString.HALF_SPACE);
            }
            return 出力順_文字列.toRString();
        }
        return RString.EMPTY;
    }

    private void publish納入通知書発行一覧表(RDateTime 帳票作成日時,
            List<EditedKariSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報List, int 出力期) {

        List<RString> headerList = new ArrayList<>();
        headerList.add(タイトル_作成日時);
        headerList.add(タイトル_作成時刻);
        headerList.add(タイトル_表示コード名１);
        headerList.add(タイトル_表示コード名２);
        headerList.add(タイトル_表示コード名３);
        headerList.add(タイトル_通知書番号);
        headerList.add(タイトル_被保険者番号);
        headerList.add(タイトル_世帯コード);
        headerList.add(タイトル_表示コード１);
        headerList.add(タイトル_表示コード２);
        headerList.add(タイトル_表示コード３);
        headerList.add(タイトル_行政区);
        headerList.add(タイトル_保険料額);
        headerList.add(タイトル_当期);
        headerList.add(タイトル_納付人_送付先);
        headerList.add(タイトル_生保開始日);
        headerList.add(タイトル_生保種別);
        headerList.add(タイトル_氏名);
        headerList.add(タイトル_郵便番号);
        headerList.add(タイトル_住所);
        headerList.add(タイトル_町域_管内_管外住所);
        headerList.add(タイトル_番地);
        headerList.add(タイトル_所得段階);
        headerList.add(タイトル_仮特別徴収額);
        headerList.add(タイトル_次期以降);
        headerList.add(タイトル_口座情報);

        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        //TODO Path.getTmpDirectoryPath()
        RString eucFilePath = Path.combinePath(spoolWorkPath, 英数字ファイル名);
        try (CsvListWriter csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(headerList)
                .build()) {
            for (EditedKariSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 : 編集後本算定通知書共通情報List) {
                List<RString> bodyList = new ArrayList<>();
                bodyList.add(帳票作成日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
                bodyList.add(帳票作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
                表示コード編集(編集後本算定通知書共通情報.get表示コード１名(), bodyList);
                表示コード編集(編集後本算定通知書共通情報.get表示コード２名(), bodyList);
                表示コード編集(編集後本算定通知書共通情報.get表示コード３名(), bodyList);
                bodyList.add(isNull(編集後本算定通知書共通情報.get通知書番号())
                        ? RString.EMPTY : 編集後本算定通知書共通情報.get通知書番号().getColumnValue());
                bodyList.add(isNull(編集後本算定通知書共通情報.get被保険者番号())
                        ? RString.EMPTY : 編集後本算定通知書共通情報.get被保険者番号().getColumnValue());
                if (isNull(編集後本算定通知書共通情報.get編集後個人())) {
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(isNull(編集後本算定通知書共通情報.get編集後個人().get世帯コード())
                            ? RString.EMPTY : 編集後本算定通知書共通情報.get編集後個人().get世帯コード().getColumnValue());
                }
                表示コード編集(編集後本算定通知書共通情報.get表示コード1(), bodyList);
                表示コード編集(編集後本算定通知書共通情報.get表示コード２(), bodyList);
                表示コード編集(編集後本算定通知書共通情報.get表示コード３(), bodyList);
                if (isNull(編集後本算定通知書共通情報.get編集後宛先())) {
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get行政区名());
                }
                if (isNull(編集後本算定通知書共通情報.get更正後())) {
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(isNull(編集後本算定通知書共通情報.get更正後().get保険料率())
                            ? RString.EMPTY : new RString(編集後本算定通知書共通情報.get更正後().get保険料率().toString()));
                }
                //TODO 当期: 　出力期より編集後本算定通知書共通情報.普徴期別金額リストに対応した期別金額
                if (isNull(編集後本算定通知書共通情報.get編集後宛先())
                        || isNull(編集後本算定通知書共通情報.get編集後宛先().get宛先種別())
                        || (!AtesakiShubetsu.本人.equals(編集後本算定通知書共通情報.get編集後宛先().get宛先種別()))) {
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get宛先名称().getName().value());

                }
                if (isNull(編集後本算定通知書共通情報.get更正後())) {
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(編集後本算定通知書共通情報.get更正後().get生保開始日_西暦());
                }
                if (isNull(編集後本算定通知書共通情報.get更正後())
                        || RString.isNullOrEmpty(編集後本算定通知書共通情報.get更正後().get生活保護扶助種類())) {
                    bodyList.add(RString.EMPTY);
                } else {
                    RString 生活保護扶助名称 = CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
                            URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                            new Code(編集後本算定通知書共通情報.get更正後().get生活保護扶助種類()));
                    bodyList.add(生活保護扶助名称);
                }

                if (isNull(編集後本算定通知書共通情報.get編集後宛先())) {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(isNull(編集後本算定通知書共通情報.get編集後宛先().get本人名称())
                            ? RString.EMPTY : 編集後本算定通知書共通情報.get編集後宛先().get本人名称().getName().value());
                    bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get郵便番号());
                    bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get編集後住所());
                    bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get町域());
                    bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get番地());
                }
                if (isNull(編集後本算定通知書共通情報.get更正後())) {
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(編集後本算定通知書共通情報.get更正後().get保険料段階());
                }
                bodyList.add(isNull(編集後本算定通知書共通情報.get今後納付すべき額())
                        ? RString.EMPTY : new RString(編集後本算定通知書共通情報.get今後納付すべき額().toString()));
                set次期以降(編集後本算定通知書共通情報, 出力期, bodyList);
                bodyList.add(get口座情報(編集後本算定通知書共通情報));
                csvListWriter.writeLine(bodyList);
            }
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        }
    }

    private void set次期以降(EditedKariSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報, int 出力期, List<RString> bodyList) {

        if (isNull(編集後本算定通知書共通情報.get更正後()) || isNull(編集後本算定通知書共通情報.get更正後().get更正後普徴期別金額リスト())
                || 編集後本算定通知書共通情報.get更正後().get更正後普徴期別金額リスト().isEmpty()) {
            bodyList.add(RString.EMPTY);
        } else {
            List<UniversalPhase> 普徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get更正後普徴期別金額リスト();
            for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
                if (出力期 == (普徴期別金額.get期() + NUM_1)) {
                    bodyList.add(isNull(普徴期別金額.get金額()) ? RString.EMPTY
                            : DecimalFormatter.toコンマ区切りRString(普徴期別金額.get金額(), 0));
                    break;
                }
            }
        }
    }

    private void 表示コード編集(RString 表示コード, List<RString> bodyList) {
        if (isNull(表示コード)) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(表示コード);
        }
    }

    private boolean isNull(Object object) {
        return object == null;
    }

    private RString get口座情報(EditedKariSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        RString 口座情報;
        EditedKoza 編集後口座 = 編集後本算定通知書共通情報.get編集後口座();
        RString 口座種別略称 = 編集後口座.get口座種別略称();
        if (口座種別略称.length() >= NUM_2) {
            口座種別略称 = 口座種別略称.substring(NUM_0, NUM_2);
        }
        RString 口座番号 = 編集後口座.get口座番号Or通帳記号番号();
        if (口座番号.length() >= NUM_7) {
            口座番号 = 口座番号.substring(NUM_0, NUM_7);
        }
        口座情報 = 編集後口座.get金融機関コードCombinedWith支店コード().concat(RString.HALF_SPACE).concat(
                口座種別略称).concat(HYPHEN).concat(口座番号).concat(RString.HALF_SPACE).concat(
                        編集後口座.get口座名義人漢字優先());
        if (ゆうちょ銀行.equals(編集後口座.get金融機関コードCombinedWith支店コード().subSequence(NUM_0, NUM_4))) {
            口座情報 = 編集後口座.get金融機関コードCombinedWith支店コード().concat(RString.HALF_SPACE)
                    .concat(編集後口座.get口座番号Or通帳記号番号()).concat(RString.HALF_SPACE)
                    .concat(編集後口座.get口座名義人漢字優先());
        }
        return 口座情報;
    }

    /**
     * 納入通知書発行後異動者の登録するメソッドです。
     *
     * @param 帳票作成日時 RDateTime
     * @param 出力期 int
     * @param 納入通知書対象者 NotsuKozaShutsuryokuTaisho
     * @param 生活保護者先頭出力フラグ RString
     * @param 出力順ID Long
     * @param 帳票ID ReportId
     */
    public void insTsuchishoHakkogoIdosha(YMDHMS 帳票作成日時, int 出力期, NotsuKozaShutsuryokuTaisho 納入通知書対象者,
            RString 生活保護者先頭出力フラグ, Long 出力順ID, ReportId 帳票ID) {
        IFuchoKariTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IFuchoKariTsuchishoIkkatsuHakkoMapper.class);
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, 帳票ID_出力順, 出力順ID);
        RString 出力順 = MyBatisOrderByClauseCreator.create(DBB100014NonyuTsuchishoEnum.class, outputOrder);
        RString 出力順_文字列 = 出力順文字列を取得(出力順, 生活保護者先頭出力フラグ);
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 普徴仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        int 普徴仮算定期間の最後の期 = 普徴仮算定期間.getLast().get期AsInt();
        FuchoInsTsuchishoParameter param = FuchoInsTsuchishoParameter.createSelectByKeyParam(
                普徴仮算定期間の最後の期, 出力期, 納入通知書対象者.get名称(), 出力順_文字列, 帳票ID, 帳票作成日時);
        mapper.insert通知書発行後異動者(param);
    }

    private void バッチ出力条件リストの出力(FlexibleDate 発行日, int 出力期, RString 生活保護者先頭出力フラグ,
            RString 山分け区分, ReportId 帳票ID, LasdecCode 市町村コード, RString 市町村名, RString ページ数) {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_発行日).concat(出力条件_右括弧).concat(
                発行日.wareki().toDateString()));
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_出力期).concat(出力条件_右括弧).concat(new RString(出力期)));
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_生活保護対象者をまとめて先頭に出力).concat(出力条件_右括弧)
                .concat(生活保護者先頭出力フラグ));
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_ページごとに山分け).concat(出力条件_右括弧).
                concat(山分け区分));
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                市町村コード.value(),
                市町村名,
                new RString(String.valueOf(JobContextHolder.getJobId())),
                RString.EMPTY,
                ページ数,
                RString.EMPTY,
                RString.EMPTY,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private void 代行プリント送付票の出力(FlexibleYear 調定年度, FlexibleYear 賦課年度,
            NotsuKozaShutsuryokuTaisho 納入通知書対象者, Long 出力順ID, FlexibleDate 発行日, int 出力期,
            RString 生活保護者先頭出力フラグ, RString 山分け区分, LasdecCode 市町村コード, RString 市町村名, ReportId 帳票ID,
            RString ページ数) {
        List<RString> 帳票名リスト = new ArrayList<>();
        帳票名リスト.add(帳票名);
        List<Decimal> ページ数リスト = new ArrayList<>();
        ページ数リスト.add(new Decimal(ページ数.toString()));
        List<RString> 抽出条件 = new ArrayList<>();
        抽出条件.add(パラメータ名_調定年度.concat(RString.FULL_SPACE).concat(調定年度.wareki().toDateString()));
        抽出条件.add(パラメータ名_賦課年度.concat(RString.FULL_SPACE).concat(賦課年度.wareki().toDateString()));
        抽出条件.add(パラメータ名_対象者.concat(RString.FULL_SPACE).concat(納入通知書対象者.get名称()));
        List<RString> 出力順リスト = new ArrayList<>();
        List<RString> 改頁条件リスト = new ArrayList<>();
        get出力順(出力順ID, 出力順リスト, 改頁条件リスト);
        List<RString> 詳細設定 = new ArrayList<>();
        詳細設定.add(パラメータ名_発行日.concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        詳細設定.add(パラメータ名_出力期.concat(RString.FULL_SPACE).concat(new RString(出力期)));
        詳細設定.add(パラメータ名_生活保護対象者をまとめて先頭に出力.concat(RString.FULL_SPACE).concat(
                生活保護者先頭出力フラグ));
        詳細設定.add(パラメータ名_ページごとに山分け.concat(RString.FULL_SPACE).concat(山分け区分));
        DaikoPrintItem item = new DaikoPrintItem(SubGyomuCode.DBB介護賦課, 市町村コード, 市町村名,
                new RString(String.valueOf(JobContextHolder.getJobId())),
                処理名, 帳票ID.value(), 帳票名リスト, ページ数リスト, 抽出条件, 出力順リスト, 改頁条件リスト, 詳細設定);
        DaikoPrintFactory.createInstance(item);
    }

    private void get出力順(Long 出力順ID, List<RString> 出力順リスト, List<RString> 改頁条件リスト) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200007.getReportId(), 出力順ID);
        int i = 0;
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁条件リスト.add(item.get項目名());
                }
                if (i == INDEX_0) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INDEX_1) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INDEX_2) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INDEX_3) {
                    出力順リスト.add(item.get項目名());
                } else if (i == INDEX_4) {
                    出力順リスト.add(item.get項目名());
                }
                i = i + 1;
            }
        }
    }

    private ShunyuJoho get収入情報(DbT2015KeisangoJohoEntity 計算後情報) {
        ShunyuJoho 収入情報 = new ShunyuJoho();
        収入情報.set調定年度(計算後情報.getChoteiNendo());
        収入情報.set賦課年度(計算後情報.getFukaNendo());
        収入情報.set通知書番号(計算後情報.getTsuchishoNo());
        収入情報.set特徴収入額01(計算後情報.getTkShunyuGaku01());
        収入情報.set特徴収入額02(計算後情報.getTkShunyuGaku02());
        収入情報.set特徴収入額03(計算後情報.getTkShunyuGaku03());
        収入情報.set特徴収入額04(計算後情報.getTkShunyuGaku04());
        収入情報.set特徴収入額05(計算後情報.getTkShunyuGaku05());
        収入情報.set特徴収入額06(計算後情報.getTkShunyuGaku06());
        収入情報.set普徴収入額01(計算後情報.getFuShunyuGaku01());
        収入情報.set普徴収入額02(計算後情報.getFuShunyuGaku02());
        収入情報.set普徴収入額03(計算後情報.getFuShunyuGaku03());
        収入情報.set普徴収入額04(計算後情報.getFuShunyuGaku04());
        収入情報.set普徴収入額05(計算後情報.getFuShunyuGaku05());
        収入情報.set普徴収入額06(計算後情報.getFuShunyuGaku06());
        収入情報.set普徴収入額07(計算後情報.getFuShunyuGaku07());
        収入情報.set普徴収入額08(計算後情報.getFuShunyuGaku08());
        収入情報.set普徴収入額09(計算後情報.getFuShunyuGaku09());
        収入情報.set普徴収入額10(計算後情報.getFuShunyuGaku10());
        収入情報.set普徴収入額11(計算後情報.getFuShunyuGaku11());
        収入情報.set普徴収入額12(計算後情報.getFuShunyuGaku12());
        収入情報.set普徴収入額13(計算後情報.getFuShunyuGaku13());
        収入情報.set普徴収入額14(計算後情報.getFuShunyuGaku14());

        return 収入情報;
    }

    private ChoshuHoho get徴収方法情報(DbT2015KeisangoJohoEntity 計算後情報) {
        DbT2001ChoshuHohoEntity choshuHohoEntity = new DbT2001ChoshuHohoEntity();
        choshuHohoEntity.setFukaNendo(計算後情報.getFukaNendo());
        choshuHohoEntity.setHihokenshaNo(計算後情報.getHihokenshaNo());
        choshuHohoEntity.setRirekiNo(計算後情報.getFukaRirekiNo());
        choshuHohoEntity.setChoshuHoho4gatsu(計算後情報.getChoshuHoho4gatsu());
        choshuHohoEntity.setChoshuHoho5gatsu(計算後情報.getChoshuHoho5gatsu());
        choshuHohoEntity.setChoshuHoho6gatsu(計算後情報.getChoshuHoho6gatsu());
        choshuHohoEntity.setChoshuHoho7gatsu(計算後情報.getChoshuHoho7gatsu());
        choshuHohoEntity.setChoshuHoho8gatsu(計算後情報.getChoshuHoho8gatsu());
        choshuHohoEntity.setChoshuHoho9gatsu(計算後情報.getChoshuHoho9gatsu());
        choshuHohoEntity.setChoshuHoho10gatsu(計算後情報.getChoshuHoho10gatsu());
        choshuHohoEntity.setChoshuHoho11gatsu(計算後情報.getChoshuHoho11gatsu());
        choshuHohoEntity.setChoshuHoho12gatsu(計算後情報.getChoshuHoho12gatsu());
        choshuHohoEntity.setChoshuHoho1gatsu(計算後情報.getChoshuHoho1gatsu());
        choshuHohoEntity.setChoshuHoho2gatsu(計算後情報.getChoshuHoho2gatsu());
        choshuHohoEntity.setChoshuHoho3gatsu(計算後情報.getChoshuHoho3gatsu());
        choshuHohoEntity.setChoshuHohoYoku4gatsu(計算後情報.getChoshuHohoYoku4gatsu());
        choshuHohoEntity.setChoshuHohoYoku5gatsu(計算後情報.getChoshuHohoYoku5gatsu());
        choshuHohoEntity.setChoshuHohoYoku6gatsu(計算後情報.getChoshuHohoYoku6gatsu());
        choshuHohoEntity.setChoshuHohoYoku7gatsu(計算後情報.getChoshuHohoYoku7gatsu());
        choshuHohoEntity.setChoshuHohoYoku8gatsu(計算後情報.getChoshuHohoYoku8gatsu());
        choshuHohoEntity.setChoshuHohoYoku9gatsu(計算後情報.getChoshuHohoYoku9gatsu());
        choshuHohoEntity.setKariNenkinNo(計算後情報.getKariNenkinNo());
        choshuHohoEntity.setKariNenkinCode(計算後情報.getKariNenkinCode());
        choshuHohoEntity.setKariHosokuM(計算後情報.getKariHosokuM());
        choshuHohoEntity.setHonNenkinNo(計算後情報.getHonNenkinNo());
        choshuHohoEntity.setHonNenkinCode(計算後情報.getHonNenkinCode());
        choshuHohoEntity.setHonHosokuM(計算後情報.getHonHosokuM());
        choshuHohoEntity.setYokunendoKariNenkinNo(計算後情報.getYokunendoKariNenkinNo());
        choshuHohoEntity.setYokunendoKariNenkinCode(計算後情報.getYokunendoKariNenkinCode());
        choshuHohoEntity.setYokunendoKariHosokuM(計算後情報.getYokunendoKariHosokuM());
        choshuHohoEntity.setIraiSohuzumiFlag(計算後情報.getIraiSohuzumiFlag());
        choshuHohoEntity.setTsuikaIraiSohuzumiFlag(計算後情報.getTsuikaIraiSohuzumiFlag());
        choshuHohoEntity.setTokuchoTeishiNichiji(計算後情報.getTokuchoTeishiNichiji());
        choshuHohoEntity.setTokuchoTeishiJiyuCode(計算後情報.getTokuchoTeishiJiyuCode());

        return new ChoshuHoho(choshuHohoEntity);
    }

    private FukaJoho get賦課情報(DbT2015KeisangoJohoEntity 計算後情報) throws InvocationTargetException {
        FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
        DbT2002FukaEntity fukaEntity = new DbT2002FukaEntity();
        fukaEntity.setChoteiNendo(計算後情報.getChoteiNendo());
        fukaEntity.setFukaNendo(計算後情報.getFukaNendo());
        fukaEntity.setTsuchishoNo(計算後情報.getTsuchishoNo());
        fukaEntity.setRirekiNo(計算後情報.getFukaRirekiNo());
        fukaEntity.setHihokenshaNo(計算後情報.getHihokenshaNo());
        fukaEntity.setShikibetsuCode(計算後情報.getShikibetsuCode());
        fukaEntity.setSetaiCode(計算後情報.getSetaiCode());
        fukaEntity.setSetaiInsu(計算後情報.getSetaiInsu());
        fukaEntity.setShikakuShutokuYMD(計算後情報.getShikakuShutokuYMD());
        fukaEntity.setShikakuShutokuJiyu(計算後情報.getShikakuShutokuJiyu());
        fukaEntity.setShikakuSoshitsuYMD(計算後情報.getShikakuSoshitsuYMD());
        fukaEntity.setShikakuSoshitsuJiyu(計算後情報.getShikakuSoshitsuJiyu());
        fukaEntity.setSeihofujoShurui(計算後情報.getSeihofujoShurui());
        fukaEntity.setSeihoKaishiYMD(計算後情報.getSeihoKaishiYMD());
        fukaEntity.setSeihoHaishiYMD(計算後情報.getSeihoHaishiYMD());
        fukaEntity.setRonenKaishiYMD(計算後情報.getRonenKaishiYMD());
        fukaEntity.setRonenHaishiYMD(計算後情報.getRonenHaishiYMD());
        fukaEntity.setFukaYMD(計算後情報.getFukaYMD());
        fukaEntity.setKazeiKubun(計算後情報.getKazeiKubun());
        fukaEntity.setSetaikazeiKubun(計算後情報.getSetaikazeiKubun());
        fukaEntity.setGokeiShotokuGaku(計算後情報.getGokeiShotokuGaku());
        fukaEntity.setNenkinShunyuGaku(計算後情報.getNenkinShunyuGaku());
        fukaEntity.setHokenryoDankai(計算後情報.getHokenryoDankai());
        fukaEntity.setHokenryoDankai1(計算後情報.getHokenryoDankai1());
        fukaEntity.setNengakuHokenryo1(計算後情報.getNengakuHokenryo1());
        fukaEntity.setTsukiwariStartYM1(計算後情報.getTsukiwariStartYM1());
        fukaEntity.setTsukiwariEndYM1(計算後情報.getTsukiwariEndYM1());
        fukaEntity.setHokenryoDankai2(計算後情報.getHokenryoDankai2());
        fukaEntity.setNengakuHokenryo2(計算後情報.getNengakuHokenryo2());
        fukaEntity.setTsukiwariStartYM2(計算後情報.getTsukiwariStartYM2());
        fukaEntity.setTsukiwariEndYM2(計算後情報.getTsukiwariEndYM2());
        fukaEntity.setChoteiNichiji(計算後情報.getChoteiNichiji());
        fukaEntity.setChoteiJiyu1(計算後情報.getChoteiJiyu1());
        fukaEntity.setChoteiJiyu2(計算後情報.getChoteiJiyu2());
        fukaEntity.setChoteiJiyu3(計算後情報.getChoteiJiyu3());
        fukaEntity.setChoteiJiyu4(計算後情報.getChoteiJiyu4());
        fukaEntity.setKoseiM(計算後情報.getKoseiM());
        fukaEntity.setGemmenMaeHokenryo(計算後情報.getGemmenMaeHokenryo());
        fukaEntity.setGemmenGaku(計算後情報.getGemmenGaku());
        fukaEntity.setKakuteiHokenryo(計算後情報.getKakuteiHokenryo());
        fukaEntity.setHokenryoDankaiKarisanntei(計算後情報.getHokenryoDankaiKarisanntei());
        fukaEntity.setChoshuHohoRirekiNo(計算後情報.getChoshuHohoRirekiNo());
        fukaEntity.setIdoKijunNichiji(計算後情報.getIdoKijunNichiji());
        fukaEntity.setKozaKubun(計算後情報.getKozaKubun());
        fukaEntity.setKyokaisoKubun(計算後情報.getKyokaisoKubun());
        fukaEntity.setShokkenKubun(計算後情報.getShokkenKubun());
        fukaEntity.setFukaShichosonCode(計算後情報.getFukaShichosonCode());
        fukaEntity.setTkSaishutsuKampuGaku(計算後情報.getTkSaishutsuKampuGaku());
        fukaEntity.setFuSaishutsuKampuGaku(計算後情報.getFuSaishutsuKampuGaku());

        fukaJohoRelateEntity.set介護賦課Entity(fukaEntity);
        List<KibetsuEntity> kibetsuEntityList = new ArrayList<>();
        for (int index = INDEX_1; index <= INDEX_6; index++) {
            KibetsuEntity 介護期別Relate = new KibetsuEntity();
            DbT2003KibetsuEntity 介護期別Entity = new DbT2003KibetsuEntity();
            介護期別Entity.setChoteiNendo(計算後情報.getChoteiNendo());
            介護期別Entity.setFukaNendo(計算後情報.getFukaNendo());
            介護期別Entity.setTsuchishoNo(計算後情報.getTsuchishoNo());
            介護期別Entity.setRirekiNo(計算後情報.getFukaRirekiNo());
            介護期別Entity.setChoteiId(new Decimal(index));
            介護期別Entity.setChoshuHouhou(ChoshuHohoKibetsu.特別徴収.getコード());
            介護期別Entity.setKi(index);
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            UrT0705ChoteiKyotsuEntity 調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            調定共通Entity.setChoteiId(new Decimal(index).longValue());
            調定共通Entity.setChoteigaku(get特徴調定額(計算後情報, index));
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            kibetsuEntityList.add(介護期別Relate);
        }
        for (int index = INDEX_1; index <= INDEX_14; index++) {
            KibetsuEntity 介護期別Relate = new KibetsuEntity();
            DbT2003KibetsuEntity 介護期別Entity = new DbT2003KibetsuEntity();
            介護期別Entity.setChoteiNendo(計算後情報.getChoteiNendo());
            介護期別Entity.setFukaNendo(計算後情報.getFukaNendo());
            介護期別Entity.setTsuchishoNo(計算後情報.getTsuchishoNo());
            介護期別Entity.setRirekiNo(計算後情報.getFukaRirekiNo());
            介護期別Entity.setChoteiId(new Decimal(index).add(Decimal.TEN));
            介護期別Entity.setChoshuHouhou(ChoshuHohoKibetsu.普通徴収.getコード());
            介護期別Entity.setKi(index);
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            UrT0705ChoteiKyotsuEntity 調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            調定共通Entity.setChoteiId(new Decimal(index).add(Decimal.TEN).longValue());
            調定共通Entity.setChoteigaku(get普通調定額(計算後情報, index));
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            kibetsuEntityList.add(介護期別Relate);
        }
        fukaJohoRelateEntity.set介護期別RelateEntity(kibetsuEntityList);
        return new FukaJoho(fukaJohoRelateEntity);
    }

    private Decimal get特徴調定額(DbT2015KeisangoJohoEntity entity, int index) throws InvocationTargetException {
        Decimal 特徴調定額 = Decimal.ZERO;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_特徴方法.toString());
        sb.append(new RString(index).padZeroToLeft(2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            特徴調定額 = (Decimal) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(FuchoKariTsuchishoIkkatsuHakko.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 特徴調定額;
    }

    private Decimal get普通調定額(DbT2015KeisangoJohoEntity entity, int index) {
        Decimal 普通調定額 = Decimal.ZERO;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_普徴方法.toString());
        sb.append(new RString(index).padZeroToLeft(2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            普通調定額 = (Decimal) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonsanteiTsuchishoIkkatsuHakkoFath.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 普通調定額;
    }

    private int コンビニカット印字位置を取得と山分け用スプール数の算出(final Kitsuki 期月) {
        RString コンビニカット印字位置 = RString.EMPTY;
        switch (期月.get月AsInt()) {
            case 月_4:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置1, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_5:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置2, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_6:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置3, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_7:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置4, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_8:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置5, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_9:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置6, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_10:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置7, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_11:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置8, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_12:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置9, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_1:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置10, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_2:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置11, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_3:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置12, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_14:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置13, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_15:
                コンビニカット印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_コンビニカット印字位置14, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        int 印字位置 = Integer.parseInt(コンビニカット印字位置.toString());
        return コンビニタイプ_山分け用スプール数算出(印字位置);
    }

    private int コンビニタイプ_山分け用スプール数算出(int 印字位置) {
        int 山分け用スプール数 = 0;
        if (出力期リストのサイズ_8 <= 印字位置) {
            山分け用スプール数 = 山分け用スプール数_4;
        } else if (出力期リストのサイズ_5 <= 印字位置 && 印字位置 <= 出力期リストのサイズ_7) {
            山分け用スプール数 = 山分け用スプール数_3;
        } else if (出力期リストのサイズ_2 <= 印字位置 && 印字位置 <= 出力期リストのサイズ_4) {
            山分け用スプール数 = 山分け用スプール数_2;
        } else if (印字位置 == 出力期リストのサイズ_1) {
            山分け用スプール数 = 山分け用スプール数_1;
        }
        return 山分け用スプール数;
    }

    private int 今回出力期の印字位置を取得と山分け用スプール数の算出(final Kitsuki 期月, int 出力期リストのサイズ) {
        RString 今回出力期の印字位置 = null;
        switch (期月.get月AsInt()) {
            case 月_4:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置1, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_5:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置2, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_6:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置3, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_7:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置4, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_8:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置5, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_9:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置6, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_10:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置7, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_11:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置8, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_12:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置9, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_1:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置10, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_2:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置11, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_3:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置12, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_14:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置13, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            case 月_15:
                今回出力期の印字位置 = DbBusinessConfig.get(
                        ConfigNameDBB.普徴期情報_ブック開始位置14, nowDate, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return 山分け用スプール数を算出(今回出力期の印字位置, 出力期リストのサイズ);
    }

    private int 山分け用スプール数を算出(RString 今回出力期の印字位置, int 出力期リストのサイズ) {
        int 山分け用スプール数 = 0;
        if (ブック開始位置_1.equals(今回出力期の印字位置)) {
            山分け用スプール数 = ブック開始位置1山分け用スプール数算出(出力期リストのサイズ, 山分け用スプール数);
        } else if (ブック開始位置_2.equals(今回出力期の印字位置)) {
            山分け用スプール数 = ブック開始位置2山分け用スプール数算出(出力期リストのサイズ, 山分け用スプール数);
        } else if (ブック開始位置_3.equals(今回出力期の印字位置)) {
            山分け用スプール数 = ブック開始位置3山分け用スプール数算出(出力期リストのサイズ, 山分け用スプール数);
        } else if (ブック開始位置_4.equals(今回出力期の印字位置)) {
            山分け用スプール数 = ブック開始位置4山分け用スプール数算出(出力期リストのサイズ, 山分け用スプール数);
        } else if (ブック開始位置_5.equals(今回出力期の印字位置)) {
            山分け用スプール数 = ブック開始位置5山分け用スプール数算出(出力期リストのサイズ, 山分け用スプール数);
        }
        return 山分け用スプール数;
    }

    private int ブック開始位置5山分け用スプール数算出(int 出力期リストのサイズ, int 山分け用スプール数) {
        if (出力期リストのサイズ_1 == 出力期リストのサイズ) {
            山分け用スプール数 = 山分け用スプール数_2;
        } else if (出力期リストのサイズ_2 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_5) {
            山分け用スプール数 = 山分け用スプール数_3;
        } else if (出力期リストのサイズ_6 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_9) {
            山分け用スプール数 = 山分け用スプール数_4;
        } else if (出力期リストのサイズ_10 <= 出力期リストのサイズ) {
            山分け用スプール数 = 山分け用スプール数_5;
        }
        return 山分け用スプール数;
    }

    private int ブック開始位置4山分け用スプール数算出(int 出力期リストのサイズ, int 山分け用スプール数) {
        if (出力期リストのサイズ_1 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_2) {
            山分け用スプール数 = 山分け用スプール数_2;
        } else if (出力期リストのサイズ_3 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_6) {
            山分け用スプール数 = 山分け用スプール数_3;
        } else if (出力期リストのサイズ_7 <= 出力期リストのサイズ) {
            山分け用スプール数 = 山分け用スプール数_4;
        }
        return 山分け用スプール数;
    }

    private int ブック開始位置3山分け用スプール数算出(int 出力期リストのサイズ, int 山分け用スプール数) {
        if (出力期リストのサイズ_1 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_3) {
            山分け用スプール数 = 山分け用スプール数_2;
        } else if (出力期リストのサイズ_4 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_7) {
            山分け用スプール数 = 山分け用スプール数_3;
        } else if (出力期リストのサイズ_8 <= 出力期リストのサイズ) {
            山分け用スプール数 = 山分け用スプール数_4;
        }
        return 山分け用スプール数;
    }

    private int ブック開始位置2山分け用スプール数算出(int 出力期リストのサイズ, int 山分け用スプール数) {
        if (出力期リストのサイズ_1 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_4) {
            山分け用スプール数 = 山分け用スプール数_2;
        } else if (出力期リストのサイズ_5 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_8) {
            山分け用スプール数 = 山分け用スプール数_3;
        } else if (出力期リストのサイズ_9 <= 出力期リストのサイズ) {
            山分け用スプール数 = 山分け用スプール数_4;
        }
        return 山分け用スプール数;
    }

    private int ブック開始位置1山分け用スプール数算出(int 出力期リストのサイズ, int 山分け用スプール数) {
        if (出力期リストのサイズ_1 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_5) {
            山分け用スプール数 = 山分け用スプール数_2;
        } else if (出力期リストのサイズ_6 <= 出力期リストのサイズ && 出力期リストのサイズ <= 出力期リストのサイズ_9) {
            山分け用スプール数 = 山分け用スプール数_3;
        } else if (出力期リストのサイズ_10 <= 出力期リストのサイズ) {
            山分け用スプール数 = 山分け用スプール数_4;
        }
        return 山分け用スプール数;
    }

    private RString 帳票タイプを取得する(ReportId 帳票ID) {
        RString 帳票タイプ = RString.EMPTY;
        if (ReportIdDBB.DBB100014.getReportId().equals(帳票ID) || ReportIdDBB.DBB100015.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100028.getReportId().equals(帳票ID) || ReportIdDBB.DBB100029.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_期毎タイプ;
        } else if (ReportIdDBB.DBB100018.getReportId().equals(帳票ID) || ReportIdDBB.DBB100019.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_銀振タイプ;
        } else if (ReportIdDBB.DBB100021.getReportId().equals(帳票ID) || ReportIdDBB.DBB100023.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100020.getReportId().equals(帳票ID) || ReportIdDBB.DBB100022.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_ブックタイプ;
        } else if (ReportIdDBB.DBB100026.getReportId().equals(帳票ID) || ReportIdDBB.DBB100027.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100024.getReportId().equals(帳票ID) || ReportIdDBB.DBB100025.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_コンビニタイプ;
        }
        return 帳票タイプ;
    }

    private RString 帳票タイトルを取得する(ReportId 帳票ID) {
        RString 帳票タイトル = null;
        if (ReportIdDBB.DBB100014.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_期毎タイプ;
        } else if (ReportIdDBB.DBB100015.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_期毎タイプ_連帳;
        } else if (ReportIdDBB.DBB100028.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_銀振タイプ;
        } else if (ReportIdDBB.DBB100029.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_銀振タイプ_連帳;
        } else if (ReportIdDBB.DBB100018.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_ブックタイプ;
        } else if (ReportIdDBB.DBB100019.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_ブックタイプ_連帳;
        } else if (ReportIdDBB.DBB100021.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_ブックタイプ口振依頼な;
        } else if (ReportIdDBB.DBB100023.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_ブックタイプ口振依頼な_連帳;
        } else if (ReportIdDBB.DBB100020.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_コンビニタイプ;
        } else if (ReportIdDBB.DBB100022.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_コンビニタイプ_連帳;
        } else if (ReportIdDBB.DBB100026.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_コンビニタイプ_角公タイプ;
        } else if (ReportIdDBB.DBB100027.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_コンビニタイプ_角公タイプ_連帳;
        } else if (ReportIdDBB.DBB100024.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_コンビニ期毎タイプ;
        } else if (ReportIdDBB.DBB100025.getReportId().equals(帳票ID)) {
            帳票タイトル = 帳票タイトル_コンビニ期毎タイプ_連帳;
        }
        return 帳票タイトル;
    }

    private TsuchishoKyotsuEntity get通知書共通情報(FlexibleYear 調定年度) {
        TsuchishoKyotsuEntity 通知書共通情報entity = new TsuchishoKyotsuEntity();
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 普徴仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(調定年度.toDateString()));
        List<Noki> 普徴納期リスト = fukaNokiResearcher.get普徴納期ALL();
        List<NokiJoho> 期月情報リスト = new ArrayList<>();
        for (Kitsuki 期月 : 普徴仮算定期間.toList()) {
            for (Noki 普徴納期 : 普徴納期リスト) {
                NokiJoho 期月情報 = new NokiJoho();
                if (期月.get期AsInt() == 普徴納期.get期別()) {
                    期月情報.set期月(期月);
                    期月情報.set納期(普徴納期);
                    期月情報リスト.add(期月情報);
                }
            }
        }
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        List<NokiJoho> 特徴期月情報リスト = new ArrayList<>();
        for (int i = 特徴納期_1期; i <= 特徴納期_3期; i++) {
            NokiJoho 特徴期月情報 = new NokiJoho();
            Kitsuki 期月情報 = 月期対応取得_特徴.get期月リスト().get期の最初月(i);
            特徴期月情報.set期月(期月情報);
            Noki 賦課納期 = fukaNokiResearcher.get特徴納期(i);
            特徴期月情報.set納期(賦課納期);
            特徴期月情報リスト.add(特徴期月情報);
        }
        重複な期情報を削除(期月情報リスト);
        通知書共通情報entity.set普徴納期情報リスト(期月情報リスト);
        通知書共通情報entity.set特徴納期情報リスト(特徴期月情報リスト);
        return 通知書共通情報entity;
    }

    private void 重複な期情報を削除(List<NokiJoho> 期月情報リスト) {
        for (NokiJoho 期月情報 : 期月情報リスト) {
            switch (期月情報.get期月().get月AsInt()) {
                case 月_4:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置1);
                    break;
                case 月_5:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置2);
                    break;
                case 月_6:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置3);
                    break;
                case 月_7:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置4);
                    break;
                case 月_8:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置5);
                    break;
                case 月_9:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置6);
                    break;
                case 月_10:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置7);
                    break;
                case 月_11:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置8);
                    break;
                case 月_12:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置9);
                    break;
                case 月_1:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置10);
                    break;
                case 月_2:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置11);
                    break;
                case 月_3:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置12);
                    break;
                case 月_14:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置13);
                    break;
                case 月_15:
                    重複な期情報を削除共通(nowDate, 期月情報リスト, 期月情報, ConfigNameDBB.普徴期情報_納付書の印字位置14);
                    break;
                default:
                    break;
            }
        }
    }

    private void 重複な期情報を削除共通(RDate nowDate, List<NokiJoho> 期月情報リスト, NokiJoho 期月情報,
            ConfigNameDBB 印字位置) {
        if (重複な期情報.equals(DbBusinessConfig.get(印字位置, nowDate, SubGyomuCode.DBB介護賦課))) {
            期月情報リスト.remove(期月情報);
        }
    }

    /**
     * 通知書の口座情報編集を取得するメソッドです。
     *
     * @param 編集後口座 EditedKoza
     * @return 口座情報
     */
    private RString 通知書の口座情報編集(EditedKoza 編集後口座) {
        RString 口座種別略称 = 編集後口座.get口座種別略称();
        if (口座種別略称.length() >= NUM_2) {
            口座種別略称 = 口座種別略称.substring(NUM_0, NUM_2);
        }
        RString 口座番号 = 編集後口座.get口座番号Or通帳記号番号();
        if (口座番号.length() >= NUM_7) {
            口座番号 = 口座番号.substring(NUM_0, NUM_7);
        }
        RString 口座情報 = 編集後口座.get金融機関コードCombinedWith支店コード().concat(スペース).concat(口座種別略称)
                .concat(HYPHEN).concat(口座番号).concat(スペース).concat(編集後口座.get口座名義人漢字優先());
        if (ゆうちょ銀行.equals(編集後口座.get金融機関コードCombinedWith支店コード().subSequence(NUM_0, NUM_4))) {
            口座情報 = 編集後口座.get金融機関コードCombinedWith支店コード().concat(スペース)
                    .concat(編集後口座.get口座番号Or通帳記号番号()).concat(スペース)
                    .concat(編集後口座.get口座名義人漢字優先());
        }
        return 口座情報;
    }
}
