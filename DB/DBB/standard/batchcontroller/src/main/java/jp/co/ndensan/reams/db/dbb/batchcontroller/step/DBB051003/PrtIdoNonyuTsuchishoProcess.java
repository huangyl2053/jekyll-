/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051003;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.HonsanteiTsuchishoIkkatsuHakkoSyori;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoInfo;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.gennendoidohakkoichiran.HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranReport;
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
import jp.co.ndensan.reams.db.dbb.business.report.honsantei.IdoNonyuTsuchishoOutPutOrder;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskigoto.NonyuTsuchishoCVSKigotoRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskigoto.NonyuTsuchishoCVSKigotoReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB051001.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NotsuKozaShutsuryokuTaisho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidogennendotsuchisyoikatsuhako.IdoNonyuTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44002.HonsanteiIdoProcessParameter;
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
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidogennendotsuchisyoikatsuhako.HonsanteiIdoGennendoTsuchisyoIkatsuHako;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchisho.notsu.NonyuTsuchiShoJohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 納入通知書の発行するクラスです。
 *
 * @reamsid_L DBB-0880-030 xicongwang
 */
public class PrtIdoNonyuTsuchishoProcess extends BatchProcessBase<HonsanteiTsuchishoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "honsanteiidogennendotsuchisyoikatsuhako.IHonsanteiIdoGennendoTsuchisyoIkatsuMapper.select全件賦課情報_納入");
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
    private static final RString CSVファイル名_納入一覧表 = new RString("保険料納入通知書（本算定現年度異動）発行一覧表");
    private static final RString 定値_ゼロ = new RString("0");
    private static final EucEntityId 納入_EUC_ENTITY_ID = new EucEntityId("DBB200016");
    private static final RString 納入_EUCファイル名 = new RString("HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranData.csv");
    private static final ReportId 代行プリント送付票_帳票ID = new ReportId("URU000A10_DaikoPrintCheck");
    private static final RString 帳票タイプ_期毎 = new RString("期毎タイプ");
    private static final RString 全件異動分区分_全件 = new RString("全件");
    private static final RString 全件対象 = new RString("1");
    private static final RString 全件異動分区分_異動分 = new RString("異動分");
    private static final RString 漢字_作成 = new RString("作成");
    private int 当初出力_中期開始期 = 0;
    private int 当初出力_後期開始期 = 0;
    private final RString 項目名１ = new RString("当初出力_中期開始期");
    private final RString 項目名２ = new RString("当初出力_後期開始期");
    private RString 並び順の1件目 = RString.EMPTY;
    private RString 並び順の2件目 = RString.EMPTY;
    private RString 並び順の3件目 = RString.EMPTY;
    private RString 並び順の4件目 = RString.EMPTY;
    private RString 並び順の5件目 = RString.EMPTY;
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;

    private HonsanteiIdoProcessParameter processParameter;
    private HonsanteiIdoGennendoTsuchisyoIkatsuHako manager;
    private HonsanteiTsuchishoIkkatsuHakkoSyori honsanteiSyori;
    private IdoNonyuTsuchishoParameter myBatisParameter;
    private NonyuTsuchiShoJohoFactory nonyuTsuchiShoJohoFactory;
    private FileSpoolManager fileSpoolManager;
    private RString eucFilePath;

    private Decimal 連番;
    private int 総ページ数;
    private int 出力期AsInt;
    private RString 帳票タイプ;
    private ChohyoResult 出力帳票一覧;
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
    private Map<String, BatchReportWriter> reportWriter;
    private NinshoshaSource dbb100045NinshoshaSource;
    private NinshoshaSource dbb100046NinshoshaSource;
    private NinshoshaSource dbb100051NinshoshaSource;
    private NinshoshaSource dbb100052NinshoshaSource;
    private NinshoshaSource dbb100053NinshoshaSource;
    private NinshoshaSource dbb100054NinshoshaSource;
    private NinshoshaSource dbb100055NinshoshaSource;
    private NinshoshaSource dbb100056NinshoshaSource;
    private NinshoshaSource dbb100057NinshoshaSource;
    private NinshoshaSource dbb100058NinshoshaSource;
    private NinshoshaSource dbb100059NinshoshaSource;
    private NinshoshaSource dbb100060NinshoshaSource;
    private NinshoshaSource dbb100061NinshoshaSource;
    private NinshoshaSource dbb100062NinshoshaSource;
    private NinshoshaSource dbb100063NinshoshaSource;
    private NinshoshaSource dbb100064NinshoshaSource;

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
        reportWriter = new HashMap<>();
        連番 = Decimal.ZERO;
        nonyuTsuchiShoJohoFactory = InstanceProvider.create(NonyuTsuchiShoJohoFactory.class);
        manager = HonsanteiIdoGennendoTsuchisyoIkatsuHako.createInstance();
        honsanteiSyori = new HonsanteiTsuchishoIkkatsuHakkoSyori();
        出力帳票一覧 = processParameter.get出力帳票一覧();
        帳票名 = manager.get帳票名_納入(出力帳票一覧.get帳票ID());
        通知書共通情報entity = manager.get通知書共通情報(processParameter.get調定年度(), processParameter.get納入_出力期());

        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

        get出力条件リスト();

        出力帳票entity();

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

        myBatisParameter = IdoNonyuTsuchishoParameter.createSelectByKeyParam(出力期AsInt, 計算後情報_口座区分,
                普徴期情報.get(キー_処理対象.toString()), 普徴期情報.get(キー_通知書プリント条件.toString()), 出力順);

        帳票制御共通 = manager.load帳票制御共通(納入通知書_帳票分類ID);

        NonyuTsuchiShoSeigyoJohoLoaderFinder finder = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance(processParameter.get調定年度());
        本算定納入通知書制御情報 = finder.get本算定納入通知書制御情報();

        帳票タイプ = manager.get帳票タイプ(new ReportId(出力帳票一覧.get帳票ID()));

        出力期リスト = manager.get出力期リスト(processParameter.get調定年度(), processParameter.get納入_出力方法(),
                帳票タイプ, 期月リスト_普徴, 本算定期間, 出力期AsInt, processParameter.is随時期フラグ());

        List<NokiJoho> 期月List = manager.get期月リスト(processParameter.get調定年度(), processParameter.get納入_出力方法(),
                帳票タイプ, 期月リスト_普徴, 本算定期間, 出力期AsInt, processParameter.is随時期フラグ());

        山分け用スプール数 = manager.get山分け用スプール数(帳票タイプ, 期月List, 本算定期間, 出力期AsInt,
                processParameter.get納入_ページごとに山分け(), processParameter.is随時期フラグ());
        if (定値区分_1.equals(processParameter.get納入_ページごとに山分け())) {
            通知書共通情報entity.set普徴納期情報リスト(期月List);
        }
        RString 全件異動分区分;
        if (帳票タイプ_期毎.equals(帳票タイプ) || 全件対象.equals(普徴期情報.get(キー_処理対象.toString()))) {
            全件異動分区分 = 全件異動分区分_全件;
        } else {
            全件異動分区分 = 全件異動分区分_異動分;
        }
        if (全件異動分区分_全件.equals(全件異動分区分)) {
            manager.getZenkenFukaJoho(processParameter.get調定年度(), processParameter.get調定年度());
        } else if (全件異動分区分_異動分.equals(全件異動分区分)) {
            manager.getIdoFukaJoho(processParameter.get調定年度(), processParameter.get調定年度(), processParameter.is一括発行起動フラグ());
        }

    }

    @Override
    protected void createWriter() {

        一覧表reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200016.getReportId().value()).create();
        一覧表ReportSourceWriter = new ReportSourceWriter<>(一覧表reportWriter);

        fileSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                納入_EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = fileSpoolManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 納入_EUCファイル名);
        csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(manager.get納入通知書発行一覧表タイトルList())
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
            Logger.getLogger(PrtIdoNonyuTsuchishoProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
        本算定通知書情報.set発行日(new RDate(processParameter.get納入_発行日().toString()));
        本算定通知書情報.set帳票分類ID(納入通知書_帳票分類ID);
        本算定通知書情報.set帳票ID(new ReportId(出力帳票一覧.get帳票ID()));
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

        IName 代納人氏名 = tmpResult.get宛先情報() != null && AtesakiShubetsu.代納人.equals(tmpResult.get宛先情報().get宛先種別())
                ? tmpResult.get宛先情報().get宛先名称() : null;
        HonSanteiNonyuTsuchiShoJoho 編集後本算定通知書共通情報
                = nonyuTsuchiShoJohoFactory.create本算定納入通知書情報(本算定通知書情報, 本算定納入通知書制御情報, 出力期リスト, 代納人氏名, false);

        publish納入通知書(編集後本算定通知書共通情報);

        List<RString> bodyList = manager.get納入通知書発行一覧表bodyList(processParameter.get賦課年度(),
                processParameter.get納入_出力期(), processParameter.get帳票作成日時().getRDateTime(),
                編集後本算定通知書共通情報.get編集後本算定通知書共通情報());
        csvListWriter.writeLine(bodyList);

        RString 年月日 = processParameter.get帳票作成日時().getRDateTime().getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 時刻 = processParameter.get帳票作成日時().getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        RString 作成日時 = new RString(年月日.concat(RString.HALF_SPACE).concat(時刻).concat(RString.HALF_SPACE).concat(漢字_作成).toString());
        HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranReport nonyuTsuchIchiranReport
                = new HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranReport(編集後本算定通知書共通情報.get編集後本算定通知書共通情報(),
                        processParameter.get賦課年度().toDateString(), processParameter.get納入_出力期(), 作成日時, 地方公共団体.get地方公共団体コード().value(),
                        地方公共団体.get市町村名(), 並び順の1件目, 並び順の2件目, 並び順の3件目, 並び順の4件目, 並び順の5件目, 連番.intValue());
        nonyuTsuchIchiranReport.writeBy(一覧表ReportSourceWriter);

        permanentTableWriter.insert(honsanteiSyori.insert通知書発行後異動者(processParameter.get帳票作成日時(),
                new ReportId(出力帳票一覧.get帳票ID()), tmpResult.get計算後情報_更正後(), 連番.intValue()));

    }

    @Override
    protected void afterExecute() {
        if (!データ有無区分) {
            manager.loadバッチ出力条件リスト(出力条件リスト, new ReportId(出力帳票一覧.get帳票ID()),
                    定値_ゼロ, CSV出力有無_なし, CSVファイル名_なし, 帳票名);
        } else {
            if (定値区分_1.equals(processParameter.get納入_ページごとに山分け())) {
                総ページ数 = スプール.get(String.valueOf(0)).pageCount().value();
            }
            manager.load代行プリント送付票(processParameter.get調定年度(), processParameter.get賦課年度(), 代行プリント送付票_帳票ID,
                    new RDate(processParameter.get納入_発行日().toString()), processParameter.get納入_出力期(), processParameter.get納入_対象者(),
                    processParameter.get納入_生活保護対象者をまとめて先頭に出力(), processParameter.get納入_ページごとに山分け(),
                    帳票制御共通 == null ? null : 帳票制御共通.toEntity(), 地方公共団体, outputOrder, new Decimal(総ページ数));
            manager.loadバッチ出力条件リスト(出力条件リスト, new ReportId(出力帳票一覧.get帳票ID()), new RString(総ページ数),
                    CSV出力有無_あり, CSVファイル名_納入一覧表, 帳票名);
        }

        close納入通知書();

        一覧表reportWriter.close();
        csvListWriter.close();
        fileSpoolManager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
    }

    private void 出力帳票entity() {
        並び順の1件目 = 出力項目リスト.size() <= NUM0 ? RString.EMPTY : 出力項目リスト.get(NUM0);
        並び順の2件目 = 出力項目リスト.size() <= NUM1 ? RString.EMPTY : 出力項目リスト.get(NUM1);
        並び順の3件目 = 出力項目リスト.size() <= NUM2 ? RString.EMPTY : 出力項目リスト.get(NUM2);
        並び順の4件目 = 出力項目リスト.size() <= NUM3 ? RString.EMPTY : 出力項目リスト.get(NUM3);
        並び順の5件目 = 出力項目リスト.size() <= NUM4 ? RString.EMPTY : 出力項目リスト.get(NUM4);
    }

    private void initializ納入通知書() {
        if (ReportIdDBB.DBB100045.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100045reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100045.getReportId().value()).create();
                dbb100045ReportSourceWriter = new ReportSourceWriter<>(dbb100045reportWriter);
                スプール.put(String.valueOf(idex), dbb100045ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100045reportWriter);
                dbb100045NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100045ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100046.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100046reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100046.getReportId().value()).create();
                dbb100046ReportSourceWriter = new ReportSourceWriter<>(dbb100046reportWriter);
                スプール.put(String.valueOf(idex), dbb100046ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100046reportWriter);
                dbb100046NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100046ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100051.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100051reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100051.getReportId().value()).create();
                dbb100051ReportSourceWriter = new ReportSourceWriter<>(dbb100051reportWriter);
                スプール.put(String.valueOf(idex), dbb100051ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100051reportWriter);
                dbb100051NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100051ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100052.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100052reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100052.getReportId().value()).create();
                dbb100052ReportSourceWriter = new ReportSourceWriter<>(dbb100052reportWriter);
                スプール.put(String.valueOf(idex), dbb100052ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100052reportWriter);
                dbb100052NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100052ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100053.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100053reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100053.getReportId().value()).create();
                dbb100053ReportSourceWriter = new ReportSourceWriter<>(dbb100053reportWriter);
                スプール.put(String.valueOf(idex), dbb100053ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100053reportWriter);
                dbb100053NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100053ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100054.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100054reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100054.getReportId().value()).create();
                dbb100054ReportSourceWriter = new ReportSourceWriter<>(dbb100054reportWriter);
                スプール.put(String.valueOf(idex), dbb100054ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100054reportWriter);
                dbb100054NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100054ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100055.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100055reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100055.getReportId().value()).create();
                dbb100055ReportSourceWriter = new ReportSourceWriter<>(dbb100055reportWriter);
                スプール.put(String.valueOf(idex), dbb100055ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100055reportWriter);
                dbb100055NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100055ReportSourceWriter);
            }
        } else {
            initializ納入通知書_部分();
        }
    }

    private void initializ納入通知書_部分() {
        if (ReportIdDBB.DBB100056.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100056reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100056.getReportId().value()).create();
                dbb100056ReportSourceWriter = new ReportSourceWriter<>(dbb100056reportWriter);
                スプール.put(String.valueOf(idex), dbb100056ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100056reportWriter);
                dbb100056NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100056ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100057.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100057reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100057.getReportId().value()).create();
                dbb100057ReportSourceWriter = new ReportSourceWriter<>(dbb100057reportWriter);
                スプール.put(String.valueOf(idex), dbb100057ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100057reportWriter);
                dbb100057NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100057ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100058.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100058reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100058.getReportId().value()).create();
                dbb100058ReportSourceWriter = new ReportSourceWriter<>(dbb100058reportWriter);
                スプール.put(String.valueOf(idex), dbb100058ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100058reportWriter);
                dbb100058NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100058ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100059.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100059reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100059.getReportId().value()).create();
                dbb100059ReportSourceWriter = new ReportSourceWriter<>(dbb100059reportWriter);
                スプール.put(String.valueOf(idex), dbb100059ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100059reportWriter);
                dbb100059NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100059ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100060.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100060reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100060.getReportId().value()).create();
                dbb100060ReportSourceWriter = new ReportSourceWriter<>(dbb100060reportWriter);
                スプール.put(String.valueOf(idex), dbb100060ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100060reportWriter);
                dbb100060NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100060ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100061.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100061reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100061.getReportId().value()).create();
                dbb100061ReportSourceWriter = new ReportSourceWriter<>(dbb100061reportWriter);
                スプール.put(String.valueOf(idex), dbb100061ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100061reportWriter);
                dbb100061NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100061ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100062.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100062reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100062.getReportId().value()).create();
                dbb100062ReportSourceWriter = new ReportSourceWriter<>(dbb100062reportWriter);
                スプール.put(String.valueOf(idex), dbb100062ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100062reportWriter);
                dbb100062NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100062ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100063.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100063reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100063.getReportId().value()).create();
                dbb100063ReportSourceWriter = new ReportSourceWriter<>(dbb100063reportWriter);
                スプール.put(String.valueOf(idex), dbb100063ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100063reportWriter);
                dbb100063NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100063ReportSourceWriter);
            }
        } else if (ReportIdDBB.DBB100064.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            for (int idex = 0; idex < 山分け用スプール数; idex++) {
                dbb100064reportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB100064.getReportId().value()).create();
                dbb100064ReportSourceWriter = new ReportSourceWriter<>(dbb100064reportWriter);
                スプール.put(String.valueOf(idex), dbb100064ReportSourceWriter);
                reportWriter.put(String.valueOf(idex), dbb100064reportWriter);
                dbb100064NinshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID,
                        processParameter.get納入_発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbb100064ReportSourceWriter);
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

    private void publish納入通知書(HonSanteiNonyuTsuchiShoJoho 編集後本算定通知書共通情報) {
        int ページ数 = 0;
        if (ReportIdDBB.DBB100045.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            HokenryoNonyuTsuchishoKigotoReport report
                    = new HokenryoNonyuTsuchishoKigotoReport(編集後本算定通知書共通情報, dbb100045NinshoshaSource);
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoKigotoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100046.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            HokenryoNonyuTsuchishoKigotoRenchoReport report
                    = new HokenryoNonyuTsuchishoKigotoRenchoReport(編集後本算定通知書共通情報, dbb100046NinshoshaSource);
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoKigotoRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100055.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))
                || ReportIdDBB.DBB100056.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))
                || ReportIdDBB.DBB100057.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))
                || ReportIdDBB.DBB100058.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            publish納入通知書_ブック(編集後本算定通知書共通情報);
        } else if (ReportIdDBB.DBB100059.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))
                || ReportIdDBB.DBB100060.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))
                || ReportIdDBB.DBB100061.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))
                || ReportIdDBB.DBB100062.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            publish納入通知書_コンビニ(編集後本算定通知書共通情報);
        } else if (ReportIdDBB.DBB100063.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            NonyuTsuchishoCVSKigotoReport report = new NonyuTsuchishoCVSKigotoReport(編集後本算定通知書共通情報, dbb100063NinshoshaSource);
            List<NonyuTsuchisho<NonyuTsuchishoCVSKigotoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100064.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            NonyuTsuchishoCVSKigotoRenchoReport report
                    = new NonyuTsuchishoCVSKigotoRenchoReport(編集後本算定通知書共通情報, dbb100064NinshoshaSource);
            List<NonyuTsuchisho<NonyuTsuchishoCVSKigotoRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else {
            publish納入通知書_銀振型(編集後本算定通知書共通情報);
        }
    }

    private void publish納入通知書_銀振型(HonSanteiNonyuTsuchiShoJoho 編集後本算定通知書共通情報) {

        set開始期(編集後本算定通知書共通情報);

        int ページ数 = 0;
        if (ReportIdDBB.DBB100051.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            HokenryoNonyuTsuchishoGinfuriFourKiReport report = new HokenryoNonyuTsuchishoGinfuriFourKiReport(編集後本算定通知書共通情報,
                    dbb100051NinshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFourKiSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100052.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport report = new HokenryoNonyuTsuchishoGinfuriFourKiRenchoReport(編集後本算定通知書共通情報,
                    dbb100052NinshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFourKiRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100053.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            HokenryoNonyuTsuchishoGinfuriFiveKiReport report = new HokenryoNonyuTsuchishoGinfuriFiveKiReport(編集後本算定通知書共通情報,
                    dbb100053NinshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFiveKiSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100054.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport report = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport(編集後本算定通知書共通情報,
                    dbb100054NinshoshaSource, 当初出力_中期開始期, 当初出力_後期開始期);
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        }
    }

    private void publish納入通知書_ブック(HonSanteiNonyuTsuchiShoJoho 編集後本算定通知書共通情報) {

        set開始期(編集後本算定通知書共通情報);
        int ページ数 = 0;
        if (ReportIdDBB.DBB100055.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            HokenryoNonyuTsuchishoBookFuriKaeAriCoverReport report = new HokenryoNonyuTsuchishoBookFuriKaeAriCoverReport(編集後本算定通知書共通情報,
                    dbb100055NinshoshaSource, new RString(当初出力_中期開始期), new RString(当初出力_後期開始期));
            List<NonyuTsuchisho<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100056.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            HokenryoNonyuTsuchishoBookFuriKaeNashiReport report = new HokenryoNonyuTsuchishoBookFuriKaeNashiReport(編集後本算定通知書共通情報,
                    dbb100056NinshoshaSource, new RString(当初出力_中期開始期), new RString(当初出力_後期開始期));
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100057.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverReport report
                    = new HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverReport(編集後本算定通知書共通情報,
                            dbb100057NinshoshaSource, new RString(当初出力_中期開始期), new RString(当初出力_後期開始期));
            List<NonyuTsuchisho<HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100058.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport report
                    = new HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverReport(編集後本算定通知書共通情報,
                            dbb100058NinshoshaSource, new RString(当初出力_中期開始期), new RString(当初出力_後期開始期));
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoBookFuriKaeNashiRenchoCoverSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        }
    }

    private void publish納入通知書_コンビニ(HonSanteiNonyuTsuchiShoJoho 編集後本算定通知書共通情報) {

        int ページ数 = 0;
        if (ReportIdDBB.DBB100059.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            NonyuTsuchishoCVSKakukoReport report = new NonyuTsuchishoCVSKakukoReport(編集後本算定通知書共通情報, dbb100059NinshoshaSource);
            List<NonyuTsuchisho<NonyuTsuchishoCVSKakukoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100060.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            NonyuTsuchishoCVSKakukoRenchoReport report
                    = new NonyuTsuchishoCVSKakukoRenchoReport(編集後本算定通知書共通情報, dbb100060NinshoshaSource);
            List<NonyuTsuchisho<NonyuTsuchishoCVSKakukoRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100061.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            NonyuTsuchishoCVSMultiReport report = new NonyuTsuchishoCVSMultiReport(編集後本算定通知書共通情報, dbb100061NinshoshaSource);
            List<NonyuTsuchisho<NonyuTsuchishoCVSMultiSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        } else if (ReportIdDBB.DBB100062.getReportId().equals(new ReportId(出力帳票一覧.get帳票ID()))) {
            NonyuTsuchishoCVSMultiRenchoReport report
                    = new NonyuTsuchishoCVSMultiRenchoReport(編集後本算定通知書共通情報, dbb100062NinshoshaSource);
            List<NonyuTsuchisho<NonyuTsuchishoCVSMultiRenchoSource>> nonyuTsuchishoList = report.devidedByPage();
            for (int idex = 0; idex < nonyuTsuchishoList.size(); idex++) {
                nonyuTsuchishoList.get(idex).writeBy(getReportSourceWriter(idex));
                ページ数 = ページ数 + getReportSourceWriter(idex).pageCount().value();
            }
            総ページ数 = ページ数;
        }
    }

    private void get出力条件リスト() {

        出力条件リスト = manager.get出力条件リスト(new RDate(processParameter.get納入_発行日().toString()), processParameter.get納入_出力期(),
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
            出力順 = MyBatisOrderByClauseCreator.create(IdoNonyuTsuchishoOutPutOrder.class, outputOrder);
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

    private void close納入通知書() {
        for (int idex = 0; idex < 山分け用スプール数; idex++) {
            reportWriter.get(String.valueOf(idex)).close();
        }
    }
}
