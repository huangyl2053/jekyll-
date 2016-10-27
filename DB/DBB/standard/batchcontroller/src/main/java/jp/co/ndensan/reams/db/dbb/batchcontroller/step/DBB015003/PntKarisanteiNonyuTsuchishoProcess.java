/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015003;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.business.core.karisanteiidotsuchisho.TsuchishoKyotsuEntity;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisantei.KarisanteiNonyuTsuchishoOutPutOrder;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSKigotoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB015003.TyouhyouEntity;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NotsuKozaShutsuryokuTaisho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdoOrZenkenFukaSelectParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt36002.KarisanteiIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSKigotoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvskigoto.KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidotsuchisho.KarisanteiIdoTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchisho.notsu.NonyuTsuchiShoJohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AtesakiShubetsu;
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
 * 「納入通知書（仮算定）の発行」処理クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class PntKarisanteiNonyuTsuchishoProcess extends BatchProcessBase<HonsanteiTsuchishoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "karisanteiidotsuchisho.IKarisanteiIdoFukaMapper.select全件賦課情報_納入");
    private static final ReportId 納入通知書仮算定_帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private static final RString キー_処理対象 = new RString("処理対象");
    private static final RString キー_通知書プリント条件 = new RString("通知書プリント条件");
    private static final RString 定値区分_0 = new RString("0");
    private static final RString 定値区分_1 = new RString("1");
    private static final RString ソート = new RString("order by");
    private static final RString 定値_生活保護区分 = new RString("生活保護区分");
    private static final RString ソート順_降順 = new RString("DESC");
    private static final RString ソート順_昇順 = new RString("ASC");
    private static final RString 口座区分 = new RString("dbT2015KeisangoJoho_kozaKubun");
    private static final RString FORMAT = new RString("\"");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId 納入_EUC_ENTITY_ID = new EucEntityId("DBB200007");
    private static final RString 納入_EUCファイル名 = new RString("KariNonyuTsuchishoHakkoIchiranData.csv");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString CSVファイル名_なし = new RString("なし");
    private static final RString CSVファイル名_納入一覧表 = new RString("保険料納入通知書（仮算定）発行一覧表");
    private static final ReportId 代行プリント送付票_帳票ID = new ReportId("URU000A10_DaikoPrintCheck");
    private KarisanteiIdoFukaProcessParameter processParameter;

    private int 連番;
    private int 総ページ数;
    private int 出力期AsInt;
    private RString 帳票タイプ;
    private TyouhyouEntity 出力帳票一覧;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;
    private RString 出力順;
    private List<RString> pageBreakKeys;
    private List<RString> 出力条件リスト;
    private boolean データ有無区分;
    private RString 帳票名;
    private Association 地方公共団体;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private TsuchishoKyotsuEntity 通知書共通情報entity;
    private int 山分け用スプール数;
    private List<Kitsuki> 出力期リスト;
    private IOutputOrder outputOrder;
    private KarisanteiIdoTsuchishoIkkatsuHakko manager;
    private KarisanteiIdoTsuchishoHakkoSyori karisanteiSyori;
    private IdoOrZenkenFukaSelectParameter myBatisParameter;
    private KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報;
    private NonyuTsuchiShoJohoFactory 仮算定納入通知書情報作成;
    private FileSpoolManager fileSpoolManager;
    private RString eucFilePath;
    private Map<String, ReportSourceWriter> スプール;
    private Map<String, BatchReportWriter> reportWriter;
    private NinshoshaSource dbb100014NinshoshaSource;
    private NinshoshaSource dbb100015NinshoshaSource;
    private NinshoshaSource dbb100018NinshoshaSource;
    private NinshoshaSource dbb100019NinshoshaSource;
    private NinshoshaSource dbb100020NinshoshaSource;
    private NinshoshaSource dbb100021NinshoshaSource;
    private NinshoshaSource dbb100022NinshoshaSource;
    private NinshoshaSource dbb100023NinshoshaSource;
    private NinshoshaSource dbb100024NinshoshaSource;
    private NinshoshaSource dbb100025NinshoshaSource;
    private NinshoshaSource dbb100026NinshoshaSource;
    private NinshoshaSource dbb100027NinshoshaSource;
    private NinshoshaSource dbb100028NinshoshaSource;
    private NinshoshaSource dbb100029NinshoshaSource;

    private BatchReportWriter<KarisanteiHokenryoNonyuTsuchishoKigotoSource> dbb100014ReportWriter;
    private ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoKigotoSource> dbb100014ReportSourceWriter;
    private BatchReportWriter<KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource> dbb100015ReportWriter;
    private ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource> dbb100015ReportSourceWriter;
    private BatchReportWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriSource> dbb100018ReportWriter;
    private ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriSource> dbb100018ReportSourceWriter;
    private BatchReportWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource> dbb100019ReportWriter;
    private ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource> dbb100019ReportSourceWriter;
    private BatchReportWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> dbb100020ReportWriter;
    private ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource> dbb100020ReportSourceWriter;
    private BatchReportWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> dbb100021ReportWriter;
    private ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource> dbb100021ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> dbb100022ReportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource> dbb100022ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100023ReportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource> dbb100023ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoCVSKakukoSource> dbb100024ReportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoSource> dbb100024ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> dbb100025ReportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource> dbb100025ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoCVSMultiSource> dbb100026ReportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiSource> dbb100026ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> dbb100027ReportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> dbb100027ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoCVSKigotoSource> dbb100028ReportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKigotoSource> dbb100028ReportSourceWriter;
    private BatchReportWriter<KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource> dbb100029ReportWriter;
    private ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource> dbb100029ReportSourceWriter;

    private BatchReportWriter<KariNonyuTsuchishoHakkoIchiranSource> 一覧表reportWriter;
    private ReportSourceWriter<KariNonyuTsuchishoHakkoIchiranSource> 一覧表ReportSourceWriter;

    private CsvListWriter csvListWriter;

    @BatchWriter
    private BatchPermanentTableWriter permanentTableWriter;

    @Override
    protected void initialize() {

        スプール = new HashMap<>();
        reportWriter = new HashMap<>();
        仮算定納入通知書情報作成 = InstanceProvider.create(NonyuTsuchiShoJohoFactory.class);
        manager = KarisanteiIdoTsuchishoIkkatsuHakko.createInstance();
        karisanteiSyori = new KarisanteiIdoTsuchishoHakkoSyori();
        出力帳票一覧 = processParameter.get出力帳票一覧();
        帳票名 = manager.get帳票名_納入(出力帳票一覧.get帳票ID().getColumnValue());
        通知書共通情報entity = manager.get通知書共通情報(processParameter.get調定年度(), processParameter.get納入_出力期());

        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

        get出力条件リスト();

        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
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

        myBatisParameter = IdoOrZenkenFukaSelectParameter.createSelectByKeyParam(出力期AsInt, 計算後情報_口座区分,
                普徴期情報.get(キー_処理対象.toString()), 普徴期情報.get(キー_通知書プリント条件.toString()), 出力順);

        帳票制御共通 = manager.load帳票制御共通(納入通知書仮算定_帳票分類ID);

        仮算定納入通知書制御情報 = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance().get仮算定納入通知書制御情報();

        帳票タイプ = manager.get帳票タイプBy通知書帳票ID(出力帳票一覧.get帳票ID());

        出力期リスト = manager.get出力期リスト(processParameter.get調定年度(), processParameter.get納入_出力方式(),
                帳票タイプ, 期月リスト_普徴, 仮算定期間, 出力期AsInt);

        List<NokiJoho> 期月List = manager.get期月リスト(processParameter.get調定年度(), processParameter.get納入_出力方式(),
                帳票タイプ, 期月リスト_普徴, 仮算定期間, 出力期AsInt);

        山分け用スプール数 = manager.get山分け用スプール数(帳票タイプ, 期月List, 出力期AsInt, processParameter.get納入_ページごとに山分け());

        if (定値区分_1.equals(processParameter.get納入_ページごとに山分け())) {
            通知書共通情報entity.set普徴納期情報リスト(期月List);
        }

    }

    @Override
    protected void createWriter() {

        一覧表reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200007.getReportId().value()).create();
        一覧表ReportSourceWriter = new ReportSourceWriter<>(一覧表reportWriter);

        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                納入_EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 納入_EUCファイル名);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(karisanteiSyori.get納入通知書発行一覧表タイトルList())
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
        連番 = 連番 + 1;
        HonsanteiTsuchishoTempResult tmpResult = new HonsanteiTsuchishoTempResult();
        try {
            tmpResult = manager.get賦課情報(tempEntity);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PntKarisanteiNonyuTsuchishoProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        KariSanteiTsuchiShoKyotsu 仮算定通知書情報 = new KariSanteiTsuchiShoKyotsu();
        仮算定通知書情報.set発行日(new FlexibleDate(processParameter.get納入_発行日().toDateString()));
        仮算定通知書情報.set帳票分類ID(納入通知書仮算定_帳票分類ID);
        仮算定通知書情報.set帳票ID(出力帳票一覧.get帳票ID());
        仮算定通知書情報.set処理区分(ShoriKubun.バッチ);
        仮算定通知書情報.set地方公共団体(地方公共団体);
        仮算定通知書情報.set賦課の情報_更正前(tmpResult.get賦課の情報_更正前());
        仮算定通知書情報.set賦課の情報_更正後(tmpResult.get賦課の情報_更正後());
        仮算定通知書情報.set納組情報(tmpResult.get納組情報());
        仮算定通知書情報.set普徴納期情報リスト(通知書共通情報entity.get普徴納期情報リスト());
        仮算定通知書情報.set特徴納期情報リスト(通知書共通情報entity.get特徴納期情報リスト());
        仮算定通知書情報.set宛先情報(tmpResult.get宛先情報());
        仮算定通知書情報.set口座情報(tmpResult.get口座情報());
        仮算定通知書情報.set徴収方法情報_更正前(tmpResult.get徴収方法情報_更正前());
        仮算定通知書情報.set徴収方法情報_更正後(tmpResult.get徴収方法情報_更正後());
        仮算定通知書情報.set対象者_追加含む_情報_更正前(tmpResult.get対象者_追加含む_情報_更正前());
        仮算定通知書情報.set対象者_追加含む_情報_更正後(tmpResult.get対象者_追加含む_情報_更正後());
        仮算定通知書情報.set収入情報(tmpResult.get収入情報());
        仮算定通知書情報.set帳票制御共通(帳票制御共通);
        IName 代納人氏名 = tmpResult.get宛先情報() != null && AtesakiShubetsu.代納人.equals(tmpResult.get宛先情報().get宛先種別())
                ? tmpResult.get宛先情報().get宛先名称() : null;
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報
                = 仮算定納入通知書情報作成.create仮算定納入通知書情報(仮算定通知書情報, 仮算定納入通知書制御情報, 出力期リスト, 代納人氏名);

        publish納入通知書(仮算定納入通知書情報);

        KariNonyuTsuchishoHakkoIchiranReport report = new KariNonyuTsuchishoHakkoIchiranReport(仮算定納入通知書情報,
                出力項目リスト, processParameter.get帳票作成日時(), 出力期AsInt, 地方公共団体, new Decimal(連番));
        report.writeBy(一覧表ReportSourceWriter);
        List<RString> bodyList = karisanteiSyori.get納入通知書発行一覧表bodyList(processParameter.get帳票作成日時().getRDateTime(),
                processParameter.get納入_出力期(), 仮算定納入通知書情報.get編集後仮算定通知書共通情報());
        csvListWriter.writeLine(bodyList);

        permanentTableWriter.insert(karisanteiSyori.insert通知書発行後異動者(processParameter.get帳票作成日時(),
                出力帳票一覧.get帳票ID(), tmpResult.get計算後情報_更正後(), 連番));

    }

    @Override
    protected void afterExecute() {
        if (!データ有無区分) {
            manager.loadバッチ出力条件リスト(出力条件リスト, 出力帳票一覧.get帳票ID(), 定値区分_0, CSV出力有無_なし, CSVファイル名_なし, 帳票名);
        } else {
            if (定値区分_1.equals(processParameter.get納入_ページごとに山分け())) {
                総ページ数 = スプール.get(String.valueOf(0)).pageCount().value();
            }
            manager.load代行プリント送付票(processParameter.get調定年度(), processParameter.get賦課年度(), 代行プリント送付票_帳票ID,
                    processParameter.get納入_発行日(), processParameter.get納入_出力期(), processParameter.get納入_対象者(),
                    processParameter.get納入_生活保護対象者(), processParameter.get納入_ページごとに山分け(),
                    帳票制御共通 == null ? null : 帳票制御共通.toEntity(), 地方公共団体, outputOrder, new Decimal(総ページ数));
            manager.loadバッチ出力条件リスト(出力条件リスト, 出力帳票一覧.get帳票ID(), new RString(総ページ数),
                    CSV出力有無_あり, CSVファイル名_納入一覧表, 帳票名);
        }

        close納入通知書();

        一覧表reportWriter.close();
        csvListWriter.close();
        fileSpoolManager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
    }

    private void get出力条件リスト() {

        出力条件リスト = manager.get出力条件リスト(processParameter.get納入_発行日(), processParameter.get納入_出力期(),
                processParameter.get納入_対象者(), processParameter.get納入_生活保護対象者(),
                processParameter.get納入_ページごとに山分け());

        出力順 = RString.EMPTY;
        出力項目リスト = new ArrayList();
        改頁項目リスト = new ArrayList();
        pageBreakKeys = new ArrayList<>();

        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        outputOrder = null;
        if (!RString.isNullOrEmpty(出力帳票一覧.get出力順ID())) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                    Long.parseLong(出力帳票一覧.get出力順ID().toString()));
        }
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(KarisanteiNonyuTsuchishoOutPutOrder.class, outputOrder);
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
        if (定値区分_0.equals(processParameter.get納入_生活保護対象者())) {
            orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(定値_生活保護区分).concat(FORMAT).concat(RString.HALF_SPACE)
                    .concat(ソート順_降順).concat(カンマ)
                    .concat(RString.HALF_SPACE).concat(FORMAT).concat(口座区分).concat(FORMAT)
                    .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        } else if (定値区分_1.equals(processParameter.get納入_生活保護対象者())) {
            orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(口座区分).concat(FORMAT)
                    .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        } else {
            orderByClause = new RStringBuilder(RString.EMPTY);
        }
        if (!RString.isNullOrEmpty(orderByClause.toRString()) && !RString.isNullOrEmpty(出力順)) {
            orderByClause.append(カンマ).append(RString.HALF_SPACE).append(出力順.replace(ソート, RString.EMPTY));
            出力順 = orderByClause.toRString();
        } else if (!RString.isNullOrEmpty(orderByClause.toRString()) && RString.isNullOrEmpty(出力順)) {
            出力順 = orderByClause.toRString();
        }
    }

    private void initializ納入通知書() {
        if (ReportIdDBB.DBB100014.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100014ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100014.getReportId().value()).create();
                dbb100014ReportSourceWriter = new ReportSourceWriter<>(dbb100014ReportWriter);
                スプール.put(String.valueOf(idex), dbb100014ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100014ReportWriter);
                dbb100014NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100014ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100015.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100015ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100015.getReportId().value()).create();
                dbb100015ReportSourceWriter = new ReportSourceWriter<>(dbb100015ReportWriter);
                スプール.put(String.valueOf(idex), dbb100015ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100015ReportWriter);
                dbb100015NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100015ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100018.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100018ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100018.getReportId().value()).create();
                dbb100018ReportSourceWriter = new ReportSourceWriter<>(dbb100018ReportWriter);
                スプール.put(String.valueOf(idex), dbb100018ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100018ReportWriter);
                dbb100018NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100018ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100019.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100019ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100019.getReportId().value()).create();
                dbb100019ReportSourceWriter = new ReportSourceWriter<>(dbb100019ReportWriter);
                スプール.put(String.valueOf(idex), dbb100019ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100019ReportWriter);
                dbb100019NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100019ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100020.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100020ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100020.getReportId().value()).create();
                dbb100020ReportSourceWriter = new ReportSourceWriter<>(dbb100020ReportWriter);
                スプール.put(String.valueOf(idex), dbb100020ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100020ReportWriter);
                dbb100020NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100020ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100021.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100021ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100021.getReportId().value()).create();
                dbb100021ReportSourceWriter = new ReportSourceWriter<>(dbb100021ReportWriter);
                スプール.put(String.valueOf(idex), dbb100021ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100021ReportWriter);
                dbb100021NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100021ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100022.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100022ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100022.getReportId().value()).create();
                dbb100022ReportSourceWriter = new ReportSourceWriter<>(dbb100022ReportWriter);
                スプール.put(String.valueOf(idex), dbb100022ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100022ReportWriter);
                dbb100022NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100022ReportSourceWriter);
            }
        } else {
            initializ納入通知書_部分();
        }
    }

    private void initializ納入通知書_部分() {
        if (ReportIdDBB.DBB100023.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100023ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100023.getReportId().value()).create();
                dbb100023ReportSourceWriter = new ReportSourceWriter<>(dbb100023ReportWriter);
                スプール.put(String.valueOf(idex), dbb100023ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100023ReportWriter);
                dbb100023NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100023ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100024.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100024ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100024.getReportId().value()).create();
                dbb100024ReportSourceWriter = new ReportSourceWriter<>(dbb100024ReportWriter);
                スプール.put(String.valueOf(idex), dbb100024ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100024ReportWriter);
                dbb100024NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100024ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100025.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100025ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100025.getReportId().value()).create();
                dbb100025ReportSourceWriter = new ReportSourceWriter<>(dbb100025ReportWriter);
                スプール.put(String.valueOf(idex), dbb100025ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100025ReportWriter);
                dbb100025NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100025ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100026.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100026ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100026.getReportId().value()).create();
                dbb100026ReportSourceWriter = new ReportSourceWriter<>(dbb100026ReportWriter);
                スプール.put(String.valueOf(idex), dbb100026ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100026ReportWriter);
                dbb100026NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100026ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100027.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100027ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100027.getReportId().value()).create();
                dbb100027ReportSourceWriter = new ReportSourceWriter<>(dbb100027ReportWriter);
                スプール.put(String.valueOf(idex), dbb100027ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100027ReportWriter);
                dbb100027NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100027ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100028.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100028ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100028.getReportId().value()).create();
                dbb100028ReportSourceWriter = new ReportSourceWriter<>(dbb100028ReportWriter);
                スプール.put(String.valueOf(idex), dbb100028ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100028ReportWriter);
                dbb100028NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100028ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100029.getReportId().equals(出力帳票一覧.get帳票ID())) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100029ReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100029.getReportId().value()).create();
                dbb100029ReportSourceWriter = new ReportSourceWriter<>(dbb100029ReportWriter);
                スプール.put(String.valueOf(idex), dbb100029ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100029ReportWriter);
                dbb100029NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID,
                        new FlexibleDate(processParameter.get納入_発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100029ReportSourceWriter);
            }
        }
    }

    private ReportSourceWriter getReportSourceWriter(int idex) {
        if (定値区分_1.equals(processParameter.get納入_ページごとに山分け())) {
            return スプール.get(String.valueOf(0));
        } else {
            return スプール.get(String.valueOf(idex));
        }
    }

    private void publish納入通知書(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        int ページ数 = 0;
        if (ReportIdDBB.DBB100014.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiHokenryoNonyuTsuchishoKigotoReport report
                    = new KarisanteiHokenryoNonyuTsuchishoKigotoReport(仮算定納入通知書情報, dbb100014NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoKigotoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100015.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport report
                    = new KarisanteiHokenryoNonyuTsuchishoKigotoRenchoReport(仮算定納入通知書情報, dbb100015NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100020.getReportId().equals(出力帳票一覧.get帳票ID())
                || ReportIdDBB.DBB100021.getReportId().equals(出力帳票一覧.get帳票ID())
                || ReportIdDBB.DBB100022.getReportId().equals(出力帳票一覧.get帳票ID())
                || ReportIdDBB.DBB100023.getReportId().equals(出力帳票一覧.get帳票ID())) {
            publish納入通知書_ブック(仮算定納入通知書情報);
        } else if (ReportIdDBB.DBB100024.getReportId().equals(出力帳票一覧.get帳票ID())
                || ReportIdDBB.DBB100025.getReportId().equals(出力帳票一覧.get帳票ID())
                || ReportIdDBB.DBB100026.getReportId().equals(出力帳票一覧.get帳票ID())
                || ReportIdDBB.DBB100027.getReportId().equals(出力帳票一覧.get帳票ID())) {
            publish納入通知書_コンビニ(仮算定納入通知書情報);
        } else if (ReportIdDBB.DBB100028.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiNonyuTsuchishoCVSKigotoReport report
                    = new KarisanteiNonyuTsuchishoCVSKigotoReport(仮算定納入通知書情報, dbb100028NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSKigotoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100029.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport report
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverReport(仮算定納入通知書情報, dbb100029NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSMultiRenchoCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else {
            publish納入通知書_銀振型(仮算定納入通知書情報);
        }
    }

    private void publish納入通知書_銀振型(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {

        int ページ数 = 0;
        if (ReportIdDBB.DBB100018.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiHokenryoNonyuTsuchishoGinfuriReport report
                    = new KarisanteiHokenryoNonyuTsuchishoGinfuriReport(仮算定納入通知書情報, dbb100018NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoGinfuriSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100019.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoReport report
                    = new KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoReport(仮算定納入通知書情報, dbb100019NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        }
    }

    private void publish納入通知書_ブック(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {

        int ページ数 = 0;
        if (ReportIdDBB.DBB100020.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport report
                    = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverReport(仮算定納入通知書情報, dbb100020NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100021.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport report
                    = new KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverReport(仮算定納入通知書情報, dbb100021NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100022.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport report
                    = new KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverReport(仮算定納入通知書情報, dbb100022NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoBookFuriKaeAriRenchoCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100023.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport report
                    = new KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(仮算定納入通知書情報, dbb100023NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        }
    }

    private void publish納入通知書_コンビニ(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {

        int ページ数 = 0;
        if (ReportIdDBB.DBB100024.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiNonyuTsuchishoCVSKakukoReport report
                    = new KarisanteiNonyuTsuchishoCVSKakukoReport(仮算定納入通知書情報, dbb100024NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSKakukoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100025.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiNonyuTsuchishoCVSKakukoRenchoReport report
                    = new KarisanteiNonyuTsuchishoCVSKakukoRenchoReport(仮算定納入通知書情報, dbb100025NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSKakukoRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100026.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiNonyuTsuchishoCVSMultiReport report
                    = new KarisanteiNonyuTsuchishoCVSMultiReport(仮算定納入通知書情報, dbb100026NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSMultiSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100027.getReportId().equals(出力帳票一覧.get帳票ID())) {
            KarisanteiNonyuTsuchishoCVSMultiRenchoReport report
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoReport(仮算定納入通知書情報, dbb100027NinshoshaSource);
            List<NonyuTsuchisho<KarisanteiNonyuTsuchishoCVSMultiRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        }
    }

    private void close納入通知書() {
        for (int idex = 0; idex < 山分け用スプール数; idex++) {
            reportWriter.get(String.valueOf(idex)).close();
        }
    }
}
