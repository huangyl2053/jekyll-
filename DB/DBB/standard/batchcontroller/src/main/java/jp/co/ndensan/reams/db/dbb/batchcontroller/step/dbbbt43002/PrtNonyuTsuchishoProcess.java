/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoInfo;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeAriCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeNashiReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoReport;
import jp.co.ndensan.reams.db.dbb.business.report.honsantei.NonyuTsuchIchiranOutPutOrder;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskigoto.NonyuTsuchishoCVSKigotoRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskigoto.NonyuTsuchishoCVSKigotoReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NotsuKozaShutsuryokuTaisho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.PrtNonyuTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002.HonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskigoto.NonyuTsuchishoCVSKigotoRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskigoto.NonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchisho.notsu.NonyuTsuchiShoJohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 納入通知書の発行するクラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class PrtNonyuTsuchishoProcess extends BatchProcessBase<HonsanteiTsuchishoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "honsanteitsuchishoikkatsuhakko.IHonsanteiTsuchishoIkkatsuHakkoMapper.select納入通知書");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final RString キー_処理対象 = new RString("処理対象");
    private static final RString キー_通知書プリント条件 = new RString("通知書プリント条件");
    private static final RString 定値_生活保護区分 = new RString("生活保護区分");
    private static final RString ソート順_降順 = new RString("DESC");
    private static final RString ソート順_昇順 = new RString("ASC");
    private static final RString 口座区分 = new RString("dbT2015KeisangoJoho_kozaKubun");
    private static final RString FORMAT = new RString("\"");
    private static final RString 定値区分_0 = new RString("0");
    private static final RString 定値区分_1 = new RString("1");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString ソート = new RString("order by");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString CSVファイル名_なし = new RString("なし");
    private static final RString CSVファイル名_納入一覧表 = new RString("保険料納入通知書（本算定）発行一覧表");
    private static final RString 定値_ゼロ = new RString("0");
    private static final EucEntityId 納入_EUC_ENTITY_ID = new EucEntityId("DBB200010");
    private static final RString 納入_EUCファイル名 = new RString("NonyuTsuchishoHonsanteiHakkoIchiranData.csv");
    private static final ReportId 代行プリント送付票_帳票ID = new ReportId("URU000A10_DaikoPrintCheck");
    private int 当初出力_中期開始期 = 0;
    private int 当初出力_後期開始期 = 0;
    private final RString 項目名１ = new RString("当初出力_中期開始期");
    private final RString 項目名２ = new RString("当初出力_後期開始期");

    private HonsanteifukaProcessParameter processParameter;
    private HonsanteiTsuchishoIkkatsuHakko manager;
    private HonsanteiTsuchishoIkkatsuHakkoSyori honsanteiSyori;
    private PrtNonyuTsuchishoParameter myBatisParameter;
    private NonyuTsuchiShoJohoFactory nonyuTsuchiShoJohoFactory;

    private Decimal 連番;
    private int 総ページ数;
    private int 出力期AsInt;
    private RString 帳票タイプ;
    private HonsanteifukaBatchTyouhyou 出力帳票一覧;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;
    private RString 出力順;
    private List<RString> pageBreakKeys;
    private List<RString> 出力条件リスト;
    private boolean データ有無区分;
    private RString 帳票名;
    private Association 地方公共団体;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private HonsanteiTsuchishoInfo 通知書共通情報entity;
    private int 山分け用スプール数;
    private List<Kitsuki> 出力期リスト;
    private HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報;
    private IOutputOrder outputOrder;
    private Map<String, ReportSourceWriter> スプール;
    private Map<String, NinshoshaSource> 認証者情報;

    private BatchReportWriter<HokenryoNonyuTsuchishoKigotoSource> dbb100045reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoKigotoSource> dbb100045ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100046reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100046ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100051reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100051ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100052reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100052ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100053reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100053ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100054reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100054ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100055reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100055ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100056reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100056ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100057reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100057ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100058reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100058ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100059reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100059ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100060reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100060ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100061reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100061ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100062reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100062ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100063reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100063ReportSourceWriter;
    private BatchReportWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100064reportWriter;
    private ReportSourceWriter<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100064ReportSourceWriter;

    private BatchReportWriter<NonyuTsuchIchiranSource> 一覧表reportWriter;
    private ReportSourceWriter<NonyuTsuchIchiranSource> 一覧表ReportSourceWriter;

    private CsvListWriter csvListWriter;

    @BatchWriter
    private BatchPermanentTableWriter permanentTableWriter;

    @Override
    protected void initialize() {

        スプール = new HashMap<>();
        認証者情報 = new HashMap<>();
        連番 = Decimal.ZERO;
        nonyuTsuchiShoJohoFactory = InstanceProvider.create(NonyuTsuchiShoJohoFactory.class);
        manager = HonsanteiTsuchishoIkkatsuHakko.createInstance();
        honsanteiSyori = new HonsanteiTsuchishoIkkatsuHakkoSyori();
        出力帳票一覧 = processParameter.get出力帳票一覧();
        帳票名 = manager.get帳票名_納入(出力帳票一覧.get帳票ID().getColumnValue());
        通知書共通情報entity = manager.get通知書共通情報(processParameter.get調定年度(), processParameter.get納入_出力期());
        出力帳票一覧 = processParameter.get出力帳票一覧();

        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

        get出力条件リスト();

        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 本算定期間 = 期月リスト_普徴.filtered本算定期間();
        出力期AsInt = Integer.parseInt(processParameter.get納入_出力期().toString());

        RString 計算後情報_口座区分 = null;
        if (NotsuKozaShutsuryokuTaisho.全て.getコード().equals(processParameter.get納入_対象者())) {
            計算後情報_口座区分 = null;
        } else if (NotsuKozaShutsuryokuTaisho.現金納付者.getコード().equals(processParameter.get納入_対象者())) {
            計算後情報_口座区分 = KozaKubun.現金納付.getコード();
        } else if (NotsuKozaShutsuryokuTaisho.口座振替者.getコード().equals(processParameter.get納入_対象者())) {
            計算後情報_口座区分 = KozaKubun.口座振替.getコード();
        }

        Map<String, RString> 普徴期情報 = manager.get普徴期情報(processParameter.get納入_出力期());

        myBatisParameter = PrtNonyuTsuchishoParameter.createSelectByKeyParam(出力期AsInt, 計算後情報_口座区分,
                普徴期情報.get(キー_処理対象.toString()), 普徴期情報.get(キー_通知書プリント条件.toString()), 出力順);

        帳票制御共通 = manager.load帳票制御共通(納入通知書_帳票分類ID);

        NonyuTsuchiShoSeigyoJohoLoaderFinder finder = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance(processParameter.get調定年度());
        本算定納入通知書制御情報 = finder.get本算定納入通知書制御情報();

        出力期リスト = manager.get出力期リスト(processParameter.get納入_出力期());

        List<NokiJoho> 期月List = manager.get期月リスト(processParameter.get調定年度(), processParameter.get納入_出力方法(),
                帳票タイプ, 期月リスト_普徴, 本算定期間, 出力期AsInt);

        山分け用スプール数 = manager.get山分け用スプール数(帳票タイプ, 期月List, 本算定期間, 出力期AsInt,
                processParameter.get納入_ページごとに山分け());
        if (定値区分_1.equals(processParameter.get納入_ページごとに山分け())) {
            通知書共通情報entity.set普徴納期情報リスト(期月List);
        }

    }

    @Override
    protected void createWriter() {

        一覧表reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200010.getReportId().value()).create();
        一覧表ReportSourceWriter = new ReportSourceWriter<>(一覧表reportWriter);

        FileSpoolManager fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                納入_EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, 納入_EUCファイル名);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(honsanteiSyori.get納入通知書発行一覧表タイトルList())
                .build();

        permanentTableWriter = new BatchPermanentTableWriter(DbT2017TsuchishoHakkogoIdoshaEntity.class);

        initializ納入通知書();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, myBatisParameter);
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void process(HonsanteiTsuchishoTempEntity tempEntity) {

        データ有無区分 = true;

        連番 = 連番.add(Decimal.ONE);

        HonsanteiTsuchishoTempResult tmpResult = new HonsanteiTsuchishoTempResult();
        try {
            tmpResult = manager.get賦課情報(tempEntity);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PrtTokuchoKaishiTsuchishoHonsanteiProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
        本算定通知書情報.set発行日(processParameter.get納入_発行日());
        本算定通知書情報.set帳票分類ID(納入通知書_帳票分類ID);
        本算定通知書情報.set帳票ID(出力帳票一覧.get帳票ID());
        本算定通知書情報.set処理区分(ShoriKubun.バッチ);
        本算定通知書情報.set地方公共団体(地方公共団体);
        本算定通知書情報.set賦課の情報_更正前(tmpResult.get賦課の情報_更正前());
        本算定通知書情報.set賦課の情報_更正後(tmpResult.get賦課の情報_更正後());
        本算定通知書情報.set納組情報(tmpResult.get納組情報());
        本算定通知書情報.set普徴納期情報リスト(通知書共通情報entity.get普徴納期情報リスト());
        本算定通知書情報.set特徴納期情報リスト(通知書共通情報entity.get特徴納期情報リスト());
        本算定通知書情報.set宛先情報(tmpResult.get宛先情報());
        本算定通知書情報.set口座情報(tmpResult.get口座情報());
        本算定通知書情報.set徴収方法情報_更正前(tmpResult.get徴収方法情報_更正前());
        本算定通知書情報.set徴収方法情報_更正後(tmpResult.get徴収方法情報_更正後());
        本算定通知書情報.set対象者_追加含む_情報_更正前(tmpResult.get対象者_追加含む_情報_更正前());
        本算定通知書情報.set対象者_追加含む_情報_更正後(tmpResult.get対象者_追加含む_情報_更正後());
        本算定通知書情報.set収入情報(tmpResult.get収入情報());
        本算定通知書情報.set帳票制御共通(帳票制御共通);

        IName 代納人氏名 = tmpResult.get宛先代納() != null ? tmpResult.get宛先代納().get宛先名称() : null;
        HonSanteiNonyuTsuchiShoJoho 編集後本算定通知書共通情報
                = nonyuTsuchiShoJohoFactory.create本算定納入通知書情報(本算定通知書情報, 本算定納入通知書制御情報, 出力期リスト, 代納人氏名);

        //TO QA913
        publish納入通知書(編集後本算定通知書共通情報);

        List<RString> bodyList = honsanteiSyori.get納入通知書発行一覧表bodyList(processParameter.get賦課年度(),
                processParameter.get納入_出力期(), processParameter.get帳票作成日時().getRDateTime(),
                編集後本算定通知書共通情報.get編集後本算定通知書共通情報());
        csvListWriter.writeLine(bodyList);

        NonyuTsuchIchiranReport nonyuTsuchIchiranReport = new NonyuTsuchIchiranReport(編集後本算定通知書共通情報.get編集後本算定通知書共通情報(),
                出力期AsInt, processParameter.get帳票作成日時().getRDateTime(), 地方公共団体, 出力項目リスト, 連番);
        nonyuTsuchIchiranReport.writeBy(一覧表ReportSourceWriter);

        permanentTableWriter.insert(honsanteiSyori.insert通知書発行後異動者(processParameter.get帳票作成日時(),
                出力帳票一覧.get帳票ID(), tmpResult.get計算後情報_更正後(), 連番.intValue()));

    }

    @Override
    protected void afterExecute() {

        if (!データ有無区分) {
            manager.loadバッチ出力条件リスト(出力条件リスト, 出力帳票一覧.get帳票ID(), 定値_ゼロ, CSV出力有無_なし, CSVファイル名_なし, 帳票名);
        } else {
            manager.load代行プリント送付票(processParameter.get調定年度(), processParameter.get賦課年度(), 代行プリント送付票_帳票ID,
                    processParameter.get納入_発行日(), processParameter.get納入_出力期(), processParameter.get納入_対象者(),
                    processParameter.get納入_生活保護対象者をまとめて先頭に出力(), processParameter.get納入_ページごとに山分け(),
                    帳票制御共通 == null ? null : 帳票制御共通.toEntity(), 地方公共団体, outputOrder, new Decimal(総ページ数));
            manager.loadバッチ出力条件リスト(出力条件リスト, 出力帳票一覧.get帳票ID(), new RString(総ページ数),
                    CSV出力有無_あり, CSVファイル名_納入一覧表, 帳票名);
        }
    }

    private void initializ納入通知書() {
        if (ReportIdDBB.DBB100045.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100045reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100045.getReportId().value()).create();
                dbb100045ReportSourceWriter = new ReportSourceWriter<>(dbb100045reportWriter);
                スプール.put(String.valueOf(idex), dbb100045ReportSourceWriter);
                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100045ReportSourceWriter);
                認証者情報.put(String.valueOf(idex), ninshoshaSource);
            }
        } else if (ReportIdDBB.DBB100046.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100046reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100046.getReportId().value()).create();
                dbb100046ReportSourceWriter = new ReportSourceWriter<>(dbb100046reportWriter);
                スプール.put(String.valueOf(idex), dbb100046ReportSourceWriter);
                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100046ReportSourceWriter);
                認証者情報.put(String.valueOf(idex), ninshoshaSource);
            }
        } else if (ReportIdDBB.DBB100051.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100051reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100051.getReportId().value()).create();
                dbb100051ReportSourceWriter = new ReportSourceWriter<>(dbb100051reportWriter);
                スプール.put(String.valueOf(idex), dbb100051ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100052.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100052reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100052.getReportId().value()).create();
                dbb100052ReportSourceWriter = new ReportSourceWriter<>(dbb100052reportWriter);
                スプール.put(String.valueOf(idex), dbb100052ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100053.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100053reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100053.getReportId().value()).create();
                dbb100053ReportSourceWriter = new ReportSourceWriter<>(dbb100053reportWriter);
                スプール.put(String.valueOf(idex), dbb100053ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100054.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100054reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100054.getReportId().value()).create();
                dbb100054ReportSourceWriter = new ReportSourceWriter<>(dbb100054reportWriter);
                スプール.put(String.valueOf(idex), dbb100054ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100055.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100055reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100055.getReportId().value()).create();
                dbb100055ReportSourceWriter = new ReportSourceWriter<>(dbb100055reportWriter);
                スプール.put(String.valueOf(idex), dbb100055ReportSourceWriter);
            }
        } else {
            initializ納入通知書_部分();
        }
    }

    private void initializ納入通知書_部分() {
        if (ReportIdDBB.DBB100056.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100056reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100056.getReportId().value()).create();
                dbb100056ReportSourceWriter = new ReportSourceWriter<>(dbb100056reportWriter);
                スプール.put(String.valueOf(idex), dbb100056ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100057.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100057reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100057.getReportId().value()).create();
                dbb100057ReportSourceWriter = new ReportSourceWriter<>(dbb100057reportWriter);
                スプール.put(String.valueOf(idex), dbb100057ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100058.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100058reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100058.getReportId().value()).create();
                dbb100058ReportSourceWriter = new ReportSourceWriter<>(dbb100058reportWriter);
                スプール.put(String.valueOf(idex), dbb100058ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100059.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100059reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100059.getReportId().value()).create();
                dbb100059ReportSourceWriter = new ReportSourceWriter<>(dbb100059reportWriter);
                スプール.put(String.valueOf(idex), dbb100059ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100060.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100060reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100060.getReportId().value()).create();
                dbb100060ReportSourceWriter = new ReportSourceWriter<>(dbb100060reportWriter);
                スプール.put(String.valueOf(idex), dbb100060ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100061.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100061reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100061.getReportId().value()).create();
                dbb100061ReportSourceWriter = new ReportSourceWriter<>(dbb100061reportWriter);
                スプール.put(String.valueOf(idex), dbb100061ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100062.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100062reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100062.getReportId().value()).create();
                dbb100062ReportSourceWriter = new ReportSourceWriter<>(dbb100062reportWriter);
                スプール.put(String.valueOf(idex), dbb100062ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100063.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100063reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100063.getReportId().value()).create();
                dbb100063ReportSourceWriter = new ReportSourceWriter<>(dbb100063reportWriter);
                スプール.put(String.valueOf(idex), dbb100063ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100064.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                dbb100064reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100064.getReportId().value()).create();
                dbb100064ReportSourceWriter = new ReportSourceWriter<>(dbb100064reportWriter);
                スプール.put(String.valueOf(idex), dbb100064ReportSourceWriter);
            }
        }
    }

    private void publish納入通知書(HonSanteiNonyuTsuchiShoJoho 編集後本算定通知書共通情報) {
        int ページ数 = 0;
        if (ReportIdDBB.DBB100045.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            HokenryoNonyuTsuchishoKigotoReport report = new HokenryoNonyuTsuchishoKigotoReport(編集後本算定通知書共通情報, ninshoshaSource);
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoKigotoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100046.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            HokenryoNonyuTsuchishoKigotoRenchoReport report
                    = new HokenryoNonyuTsuchishoKigotoRenchoReport(編集後本算定通知書共通情報, ninshoshaSource);
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoKigotoRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100055.getReportId().equals(出力帳票一覧.get帳票ID())
                || ReportIdDBB.DBB100056.getReportId().equals(出力帳票一覧.get帳票ID())
                || ReportIdDBB.DBB100057.getReportId().equals(出力帳票一覧.get帳票ID())
                || ReportIdDBB.DBB100058.getReportId().equals(出力帳票一覧.get帳票ID())) {
            publish納入通知書_ブック(編集後本算定通知書共通情報);
        } else if (ReportIdDBB.DBB100059.getReportId().equals(出力帳票一覧.get帳票ID())
                || ReportIdDBB.DBB100060.getReportId().equals(出力帳票一覧.get帳票ID())
                || ReportIdDBB.DBB100061.getReportId().equals(出力帳票一覧.get帳票ID())
                || ReportIdDBB.DBB100062.getReportId().equals(出力帳票一覧.get帳票ID())) {
            publish納入通知書_コンビニ(編集後本算定通知書共通情報);
        } else if (ReportIdDBB.DBB100063.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            NonyuTsuchishoCVSKigotoReport report = new NonyuTsuchishoCVSKigotoReport(編集後本算定通知書共通情報, ninshoshaSource);
            List<NonyuTsuchisho<NonyuTsuchishoCVSKigotoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100064.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            NonyuTsuchishoCVSKigotoRenchoReport report = new NonyuTsuchishoCVSKigotoRenchoReport(編集後本算定通知書共通情報, ninshoshaSource);
            List<NonyuTsuchisho<NonyuTsuchishoCVSKigotoRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else {
            publish納入通知書_銀振型(編集後本算定通知書共通情報);
        }
    }

    private void publish納入通知書_銀振型(HonSanteiNonyuTsuchiShoJoho 編集後本算定通知書共通情報) {

        set開始期(編集後本算定通知書共通情報);

        int ページ数 = 0;
        if (ReportIdDBB.DBB100051.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            HokenryoNonyuTsuchishoGinfuriFourKiReport report = new HokenryoNonyuTsuchishoGinfuriFourKiReport(編集後本算定通知書共通情報,
                    ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFourKiSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100052.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport report = new HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport(編集後本算定通知書共通情報,
                    ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100053.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            HokenryoNonyuTsuchishoGinfuriFiveKiReport report = new HokenryoNonyuTsuchishoGinfuriFiveKiReport(編集後本算定通知書共通情報,
                    ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFiveKiSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100054.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport report = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport(編集後本算定通知書共通情報,
                    ninshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        }
    }

    private void publish納入通知書_ブック(HonSanteiNonyuTsuchiShoJoho 編集後本算定通知書共通情報) {

        set開始期(編集後本算定通知書共通情報);
        int ページ数 = 0;
        if (ReportIdDBB.DBB100055.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            HokenryoNonyuTsuchishoBookFuriKaeAriCoverReport report = new HokenryoNonyuTsuchishoBookFuriKaeAriCoverReport(編集後本算定通知書共通情報,
                    ninshoshaSource, new RString(当初出力_中期開始期), new RString(当初出力_後期開始期));
            List<NonyuTsuchisho<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100056.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            HokenryoNonyuTsuchishoBookFuriKaeNashiReport report = new HokenryoNonyuTsuchishoBookFuriKaeNashiReport(編集後本算定通知書共通情報,
                    ninshoshaSource, new RString(当初出力_中期開始期), new RString(当初出力_後期開始期));
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100057.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverReport report
                    = new HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverReport(編集後本算定通知書共通情報,
                            ninshoshaSource, new RString(当初出力_中期開始期), new RString(当初出力_後期開始期));
            List<NonyuTsuchisho<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100058.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport report
                    = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(編集後本算定通知書共通情報,
                            ninshoshaSource, new RString(当初出力_中期開始期), new RString(当初出力_後期開始期));
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        }
    }

    private void publish納入通知書_コンビニ(HonSanteiNonyuTsuchiShoJoho 編集後本算定通知書共通情報) {

        int ページ数 = 0;
        if (ReportIdDBB.DBB100059.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            NonyuTsuchishoCVSKakukoReport report = new NonyuTsuchishoCVSKakukoReport(編集後本算定通知書共通情報, ninshoshaSource);
            List<NonyuTsuchisho<NonyuTsuchishoCVSKakukoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100060.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            NonyuTsuchishoCVSKakukoRenchoReport report = new NonyuTsuchishoCVSKakukoRenchoReport(編集後本算定通知書共通情報, ninshoshaSource);
            List<NonyuTsuchisho<NonyuTsuchishoCVSKakukoRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100061.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            NonyuTsuchishoCVSMultiReport report = new NonyuTsuchishoCVSMultiReport(編集後本算定通知書共通情報, ninshoshaSource);
            List<NonyuTsuchisho<NonyuTsuchishoCVSMultiSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100062.getReportId().equals(出力帳票一覧.get帳票ID())) {
            //TODO QA913実装確認中
            NinshoshaSource ninshoshaSource = null;
            NonyuTsuchishoCVSMultiRenchoReport report = new NonyuTsuchishoCVSMultiRenchoReport(編集後本算定通知書共通情報, ninshoshaSource);
            List<NonyuTsuchisho<NonyuTsuchishoCVSMultiRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex <= 山分け用スプール数; idex++) {
                nonyuTsuchishoList.get(idex).writeBy(スプール.get(String.valueOf(idex)));
                ページ数 = ページ数 + スプール.get(String.valueOf(idex)).pageCount().value();
            }
            総ページ数 = ページ数;
        }
    }

    private void get出力条件リスト() {

        出力条件リスト = manager.get出力条件リスト(processParameter.get納入_発行日(), processParameter.get納入_出力期(),
                processParameter.get納入_対象者(), processParameter.get納入_生活保護対象者をまとめて先頭に出力(),
                processParameter.get納入_ページごとに山分け());

        出力順 = RString.EMPTY;
        出力項目リスト = new ArrayList();
        改頁項目リスト = new ArrayList();
        pageBreakKeys = new ArrayList<>();

        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        outputOrder = null;
        if (!RString.isNullOrEmpty(出力帳票一覧.get出力順ID())) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                    Long.parseLong(出力帳票一覧.get出力順ID().toString()));
        }
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(NonyuTsuchIchiranOutPutOrder.class, outputOrder);
            List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
            for (ISetSortItem iSetSortItem : iSetSortItemList) {
                出力項目リスト.add(iSetSortItem.get項目名());
                if (iSetSortItem.is改頁項目()) {
                    pageBreakKeys.add(iSetSortItem.get項目ID());
                    改頁項目リスト.add(iSetSortItem.get項目名());
                }
            }
        }
        RStringBuilder orderByClause = new RStringBuilder(ソート);
        if (定値区分_0.equals(processParameter.get納入_生活保護対象者をまとめて先頭に出力())) {
            orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(定値_生活保護区分).concat(FORMAT).concat(RString.HALF_SPACE)
                    .concat(ソート順_降順).concat(カンマ)
                    .concat(RString.HALF_SPACE).concat(FORMAT).concat(口座区分).concat(FORMAT)
                    .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        } else if (定値区分_1.equals(processParameter.get納入_生活保護対象者をまとめて先頭に出力())) {
            orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(口座区分).concat(FORMAT)
                    .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        }
        if (!RString.isNullOrEmpty(出力順)) {
            orderByClause.append(カンマ).append(RString.HALF_SPACE).append(出力順.replace(ソート, RString.EMPTY));
        }
        出力順 = orderByClause.toRString();
    }

    private void set開始期(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        if (本算定納入通知書情報 != null && 本算定納入通知書情報.get納付書共通() != null) {
            ChohyoSeigyoHanyo 帳票制御汎用１
                    = manager.load帳票制御汎用ByKey(納入通知書_帳票分類ID, 本算定納入通知書情報.get納付書共通().get調定年度(), 項目名１);
            if (帳票制御汎用１ != null && !RString.isNullOrEmpty(帳票制御汎用１.get設定値())) {
                当初出力_中期開始期 = Integer.parseInt(帳票制御汎用１.get設定値().toString());
            }
            ChohyoSeigyoHanyo 帳票制御汎用２
                    = manager.load帳票制御汎用ByKey(納入通知書_帳票分類ID, 本算定納入通知書情報.get納付書共通().get調定年度(), 項目名２);
            if (帳票制御汎用２ != null && !RString.isNullOrEmpty(帳票制御汎用２.get設定値())) {
                当初出力_後期開始期 = Integer.parseInt(帳票制御汎用２.get設定値().toString());
            }
        }
    }
}
