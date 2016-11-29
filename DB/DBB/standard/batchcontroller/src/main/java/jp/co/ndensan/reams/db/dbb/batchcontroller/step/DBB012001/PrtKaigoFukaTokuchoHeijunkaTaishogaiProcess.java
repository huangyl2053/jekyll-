/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB012001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.DBB200003_HeijunkaKeisanJuneKekkaIchiran;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TkChoshuHeijunkaKeisanJuneKekkaIchiranPageBreak;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.HeijunkaTaishogaiRiyu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt35001.TokuchoHeinjunka6GatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001.TokuchoHeinjunka6GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaTaishogaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu.FukaJohoTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokuChoHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbx.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特別徴収平準化計算（特別徴収6月分）結果一覧表対象外の帳票出力クラスです。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
public class PrtKaigoFukaTokuchoHeijunkaTaishogaiProcess extends BatchKeyBreakBase<TokuchoHeijunkaRokuBatchTaishogaiEntity> {

    /**
     * OutputParameter用キー REPORT_FLAG
     */
    public static final RString PAGE_COUNT;
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchoheinjunka6gatsu.ITokuchoHeinjunka6GatsuBatchMapper.get対象外データ");
    private static final int NUM_0 = 0;
    private static final int NUM_3 = 3;
    private static final int NUM_6 = 6;
    private static final RString 対象外データテンプ_テーブル = new RString("対象外データ.");
    private static final RString 被保険者番号 = new RString("\"hihokenshaNo\"");
    private static final RString 賦課_被保険者番号 = new RString("\"hihokenshaNo\"");
    private static final RString CSVファイル = new RString(".csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200003"));
    private static final RString ファイル名_対象外一覧表 = new RString("介護保険特徴仮算定平準化対象外一覧表_");
    private static final RString タイトル_対象外一覧表 = new RString("介護保険　特徴仮算定平準化対象外一覧表");
    private TokuchoHeinjunka6GatsuProcessParameter parameter;
    private IOutputOrder outputOrder;
    private HokenryoDankaiManager 保険料段階取得;
    private Association 導入団体クラス;
    private CsvListWriter csvWriter;
    private RString eucFilePath;
    private RString 出力順;
    private FileSpoolManager manager;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private List<RString> pageBreakKeys;
    private static final ReportId 帳票ID = ReportIdDBB.DBB200003.getReportId();
    @BatchWriter
    private BatchReportWriter<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> batchReportWriter;
    private ReportSourceWriter<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> reportSourceWriter;

    static {
        PAGE_COUNT = new RString("count");
    }
    private OutputParameter<RString> count;

    @Override
    protected void initialize() {
        pageBreakKeys = new ArrayList<>();
        PrtKaigoFukaTokuchoHeijunkaCore core = new PrtKaigoFukaTokuchoHeijunkaCore();
        outputOrder = core.beforeExecuteCore(parameter.get出力帳票一覧().get出力順ID());
        導入団体クラス = core.getAssociation();
        出力順 = RString.EMPTY;
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(
                    DBB200003_HeijunkaKeisanJuneKekkaIchiran.class, outputOrder);
            for (ISetSortItem item : outputOrder.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    pageBreakKeys.add(item.get項目ID());
                }
            }
        }
    }

    @Override
    protected void beforeExecute() {
        count = new OutputParameter<>();
        保険料段階取得 = new HokenryoDankaiManager();
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200003.getReportId());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.getColumnValue()).
                addBreak(new TkChoshuHeijunkaKeisanJuneKekkaIchiranPageBreak(pageBreakKeys)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPathTaishogai = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPathTaishogai,
                ファイル名_対象外一覧表.concat(parameter.get調定日時().toString()).concat(CSVファイル));
        csvWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(false)
                .build();
    }

    @Override
    protected IBatchReader createReader() {
        TokuchoHeinjunka6GatsuMyBatisParameter myBatisParameter = new TokuchoHeinjunka6GatsuMyBatisParameter();
        myBatisParameter.set調定年度(parameter.get調定年度());
        myBatisParameter.set賦課年度(parameter.get賦課年度());
        myBatisParameter.set調定前年度(parameter.get調定前年度());
        myBatisParameter.set出力順(出力順再設定(出力順));
        myBatisParameter.setShikibetsutaishoParam(parameter.getShikibetsutaishoParam());
        return new BatchDbReader(MAPPERPATH, myBatisParameter);
    }

    @Override
    protected void usualProcess(TokuchoHeijunkaRokuBatchTaishogaiEntity entity) {
        TokuchoHeijyunkaTaishogaiEntity taishogaiEntity = get特徴平準化計算対象外entity(
                entity.get対象外データTemp(), entity, entity.get宛名());
        Optional<HokenryoDankai> 保険料段階 = 保険料段階取得.get保険料段階(parameter.get賦課年度(),
                taishogaiEntity.get保険料段階仮算定時());
        Decimal 今年度保険料率 = 今年度保険料率取得(保険料段階);
        int 調整金額 = 調整金額取得(今年度保険料率, parameter.get賦課年度());
        TokuchoHeijunkaRokuBatchTaishogaiIchiran taishogai = new TokuchoHeijunkaRokuBatchTaishogaiIchiran(
                taishogaiEntity, 今年度保険料率, new Decimal(調整金額));
        TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport report = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport(
                null, taishogai, parameter.get調定日時(),
                parameter.get賦課年度(), 導入団体クラス, outputOrder, 帳票制御共通);
        report.writeBy(reportSourceWriter);

        IKojin iKojin = ShikibetsuTaishoFactory.createKojin(taishogaiEntity.get宛名の情報());
        RString 編集後住所 = JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体クラス);
        List<RString> bodyList = new ArrayList<>();
        特徴平準化対象外CSV項目編集(bodyList, parameter.get調定日時(), parameter.get賦課年度(), taishogaiEntity,
                編集後住所, 今年度保険料率, 調整金額, taishogaiEntity.get備考コード(), entity.get宛名());
        toBodyList(bodyList);
        csvWriter.writeLine(bodyList);
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        count.setValue(new RString(batchReportWriter.getPageCount()));
    }

    private void 特徴平準化対象外CSV項目編集(List<RString> bodyList, YMDHMS 調定日時, FlexibleYear 賦課年度,
            TokuchoHeijyunkaTaishogaiEntity 特徴平準化結果対象外, RString 編集後住所, Decimal 今年度保険料率,
            int 調整金額, RString 編集備考, UaFt200FindShikibetsuTaishoEntity 宛名) {
        bodyList.add(調定日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
        bodyList.add(new RString(調定日時.toString()));
        bodyList.add(タイトル_対象外一覧表);
        bodyList.add(賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString());
        bodyList.add(特徴平準化結果対象外.get通知書番号().value());
        if (特徴平準化結果対象外.get識別コード() != null) {
            bodyList.add(特徴平準化結果対象外.get識別コード().value());
        } else {
            bodyList.add(RString.EMPTY);
        }
        final UaFt200FindShikibetsuTaishoEntity 宛名の情報 = 特徴平準化結果対象外.get宛名の情報();
        if (宛名の情報 != null) {
            GyoseikuCode 行政区コード = 宛名の情報.getGyoseikuCode();
            if (行政区コード != null) {
                bodyList.add(行政区コード.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (編集後住所 != null) {
            bodyList.add(編集後住所);
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (宛名の情報 != null) {
            AtenaJusho 住所 = 宛名の情報.getJusho();
            if (住所 != null) {
                bodyList.add(住所.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (宛名の情報 != null) {
            AtenaBanchi 番地 = 宛名の情報.getBanchi();
            if (番地 != null) {
                bodyList.add(番地.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        final RString 特別徴収業務者コード = 特徴平準化結果対象外.get特別徴収業務者コード();
        bodyList.add(特別徴収業務者コード);
        if (特別徴収業務者コード != null) {
            bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(特別徴収業務者コード), FlexibleDate.getNowDate()));
        } else {
            bodyList.add(RString.EMPTY);
        }
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(RString.EMPTY);
        bodyList.add(特徴平準化結果対象外.get保険料段階仮算定時());
        bodyList.add(DecimalFormatter.toコンマ区切りRString(今年度保険料率, 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(new Decimal(調整金額), 0));
        bodyList.add(編集備考);
        bodyList.add(特徴平準化結果対象外.get被保険者番号().value());
        SetaiCode 世帯コード = 宛名.getSetaiCode();
        if (世帯コード != null) {
            bodyList.add(世帯コード.getColumnValue());
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (宛名の情報 != null) {
            ChoikiCode 町域コード = 宛名の情報.getChoikiCode();
            if (町域コード != null) {
                bodyList.add(町域コード.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (宛名の情報 != null) {
            AtenaMeisho 氏名 = 宛名の情報.getKanjiShimei();
            if (氏名 != null) {
                bodyList.add(氏名.value());
            }
        } else {
            bodyList.add(RString.EMPTY);
        }
        RString 仮徴収年金コード = 特徴平準化結果対象外.get仮徴収年金コード();
        bodyList.add(仮徴収年金コード);
        if (仮徴収年金コード != null && (NUM_3 <= 仮徴収年金コード.length())) {
            bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                    new Code(仮徴収年金コード.substring(NUM_0, NUM_3)), FlexibleDate.getNowDate()));
        }
        特徴期期別金額設定(特徴平準化結果対象外, bodyList);
    }

    private void 特徴期期別金額設定(TokuchoHeijyunkaTaishogaiEntity 特徴平準化結果対象外, List<RString> bodyList) {
        if (特徴平準化結果対象外.get特徴期期別金額01() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get特徴期期別金額01(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象外.get特徴期期別金額02() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get特徴期期別金額02(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象外.get特徴期期別金額03() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get特徴期期別金額03(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象外.get特徴期期別金額04() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get特徴期期別金額04(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象外.get特徴期期別金額05() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get特徴期期別金額05(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象外.get特徴期期別金額06() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get特徴期期別金額06(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
    }

    private void toBodyList(List<RString> bodyList) {
        for (int i = NUM_0; i < bodyList.size(); i++) {
            if (bodyList.get(i) == null) {
                bodyList.remove(bodyList.get(i));
                bodyList.add(i, RString.EMPTY);
            }
        }
    }

    private int 調整金額取得(Decimal 今年度保険料率, FlexibleYear 賦課年度) {
        Decimal 調整金額 = 今年度保険料率.divide(NUM_6);
        RString 期別端数 = DbBusinessConfig.get(
                ConfigNameDBB.普通徴収_期別端数, new RDate(賦課年度.getYearValue()), SubGyomuCode.DBB介護賦課);
        int 期別端数int = 0;
        if (!RString.isNullOrEmpty(期別端数)) {
            期別端数int = Integer.parseInt(期別端数.toString());
        }
        return 調整金額.divide(期別端数int).intValue() * 期別端数int;
    }

    private Decimal 今年度保険料率取得(Optional<HokenryoDankai> 保険料段階) {
        Decimal 今年度保険料率 = Decimal.ZERO;
        if (保険料段階.isPresent()) {
            今年度保険料率 = 保険料段階.get().get保険料率();
        }
        return 今年度保険料率;
    }

    private TokuchoHeijyunkaTaishogaiEntity get特徴平準化計算対象外entity(FukaJohoTmpEntity 対象外データTemp,
            TokuchoHeijunkaRokuBatchTaishogaiEntity 対象外データ, UaFt200FindShikibetsuTaishoEntity 宛名) {
        TokuchoHeijyunkaTaishogaiEntity taishogaiEntity = new TokuchoHeijyunkaTaishogaiEntity();
        taishogaiEntity.set調定年度(対象外データTemp.getChoteiNendo());
        taishogaiEntity.set賦課年度(対象外データTemp.getFukaNendo());
        taishogaiEntity.set通知書番号(対象外データTemp.getTsuchishoNo());
        taishogaiEntity.set履歴番号(対象外データTemp.getRirekiNo());
        taishogaiEntity.set被保険者番号(対象外データTemp.getHihokenshaNo());
        taishogaiEntity.set識別コード(対象外データTemp.getShikibetsuCode());
        taishogaiEntity.set世帯コード(宛名.getSetaiCode());
        taishogaiEntity.set世帯員数(対象外データTemp.getSetaiInsu());
        taishogaiEntity.set資格取得日(対象外データTemp.getShikakuShutokuYMD());
        taishogaiEntity.set資格取得事由(対象外データTemp.getShikakuShutokuJiyu());
        taishogaiEntity.set資格喪失日(対象外データTemp.getShikakuSoshitsuYMD());
        taishogaiEntity.set資格喪失事由(対象外データTemp.getShikakuSoshitsuJiyu());
        taishogaiEntity.set生活保護扶助種類(対象外データTemp.getSeihofujoShurui());
        taishogaiEntity.set生保開始日(対象外データTemp.getSeihoKaishiYMD());
        taishogaiEntity.set生保廃止日(対象外データTemp.getSeihoHaishiYMD());
        taishogaiEntity.set老齢開始日(対象外データTemp.getRonenKaishiYMD());
        taishogaiEntity.set老齢廃止日(対象外データTemp.getRonenHaishiYMD());
        taishogaiEntity.set賦課期日(対象外データTemp.getFukaYMD());
        taishogaiEntity.set課税区分(対象外データTemp.getKazeiKubun());
        taishogaiEntity.set世帯課税区分(対象外データTemp.getSetaikazeiKubun());
        taishogaiEntity.set合計所得金額(対象外データTemp.getGokeiShotokuGaku());
        taishogaiEntity.set公的年金収入額(対象外データTemp.getNenkinShunyuGaku());
        taishogaiEntity.set保険料段階(対象外データTemp.getHokenryoDankai());
        taishogaiEntity.set保険料算定段階1(対象外データTemp.getHokenryoDankai1());
        taishogaiEntity.set算定年額保険料1(対象外データTemp.getNengakuHokenryo1());
        taishogaiEntity.set月割開始年月1(対象外データTemp.getTsukiwariStartYM1());
        taishogaiEntity.set月割終了年月1(対象外データTemp.getTsukiwariEndYM1());
        taishogaiEntity.set保険料算定段階2(対象外データTemp.getHokenryoDankai2());
        taishogaiEntity.set算定年額保険料2(対象外データTemp.getNengakuHokenryo2());
        taishogaiEntity.set月割開始年月2(対象外データTemp.getTsukiwariStartYM2());
        taishogaiEntity.set月割終了年月2(対象外データTemp.getTsukiwariEndYM2());
        taishogaiEntity.set調定日時(対象外データTemp.getChoteiNichiji());
        taishogaiEntity.set調定事由1(対象外データTemp.getChoteiJiyu1());
        taishogaiEntity.set調定事由2(対象外データTemp.getChoteiJiyu2());
        taishogaiEntity.set調定事由3(対象外データTemp.getChoteiJiyu3());
        taishogaiEntity.set調定事由4(対象外データTemp.getChoteiJiyu4());
        taishogaiEntity.set更正月(対象外データTemp.getKoseiM());
        taishogaiEntity.set減免前介護保険料年額(対象外データTemp.getGemmenMaeHokenryo());
        taishogaiEntity.set減免額(対象外データTemp.getGemmenGaku());
        taishogaiEntity.set確定介護保険料年額(対象外データTemp.getKakuteiHokenryo());
        taishogaiEntity.set保険料段階仮算定時(対象外データTemp.getHokenryoDankaiKarisanntei());
        taishogaiEntity.set徴収方法履歴番号(対象外データTemp.getChoshuHohoRirekiNo());
        taishogaiEntity.set異動基準日時(対象外データTemp.getIdoKijunNichiji());
        taishogaiEntity.set口座区分(対象外データTemp.getKazeiKubun());
        taishogaiEntity.set境界層区分(対象外データTemp.getKyokaisoKubun());
        taishogaiEntity.set職権区分(対象外データTemp.getShokkenKubun());
        taishogaiEntity.set賦課市町村コード(対象外データTemp.getFukaShichosonCode());
        taishogaiEntity.set特徴歳出還付額(対象外データTemp.getTkSaishutsuKampuGaku());
        taishogaiEntity.set普徴歳出還付額(対象外データTemp.getFuSaishutsuKampuGaku());
        taishogaiEntity.set特徴期期別金額01(対象外データTemp.getTkKibetsuGaku01());
        taishogaiEntity.set特徴期期別金額02(対象外データTemp.getTkKibetsuGaku02());
        taishogaiEntity.set特徴期期別金額03(対象外データTemp.getTkKibetsuGaku03());
        taishogaiEntity.set特徴期期別金額04(対象外データTemp.getTkKibetsuGaku04());
        taishogaiEntity.set特徴期期別金額05(対象外データTemp.getTkKibetsuGaku05());
        taishogaiEntity.set特徴期期別金額06(対象外データTemp.getTkKibetsuGaku06());
        taishogaiEntity.set普徴期期別金額01(対象外データTemp.getFuKibetsuGaku01());
        taishogaiEntity.set普徴期期別金額02(対象外データTemp.getFuKibetsuGaku02());
        taishogaiEntity.set普徴期期別金額03(対象外データTemp.getFuKibetsuGaku03());
        taishogaiEntity.set普徴期期別金額04(対象外データTemp.getFuKibetsuGaku04());
        taishogaiEntity.set普徴期期別金額05(対象外データTemp.getFuKibetsuGaku05());
        taishogaiEntity.set普徴期期別金額06(対象外データTemp.getFuKibetsuGaku06());
        taishogaiEntity.set普徴期期別金額07(対象外データTemp.getFuKibetsuGaku07());
        taishogaiEntity.set普徴期期別金額08(対象外データTemp.getFuKibetsuGaku08());
        taishogaiEntity.set普徴期期別金額09(対象外データTemp.getFuKibetsuGaku09());
        taishogaiEntity.set普徴期期別金額10(対象外データTemp.getFuKibetsuGaku10());
        taishogaiEntity.set普徴期期別金額11(対象外データTemp.getFuKibetsuGaku11());
        taishogaiEntity.set普徴期期別金額12(対象外データTemp.getFuKibetsuGaku12());
        taishogaiEntity.set普徴期期別金額13(対象外データTemp.getFuKibetsuGaku13());
        taishogaiEntity.set普徴期期別金額14(対象外データTemp.getFuKibetsuGaku14());
        taishogaiEntity.set備考コード(HeijunkaTaishogaiRiyu.toValue((対象外データ.get備考コード())).get名称());
        taishogaiEntity.set仮徴収年金コード(対象外データ.get徴収方法Newest_仮徴収_年金コード());
        taishogaiEntity.set宛名の情報(対象外データ.get宛名());
        taishogaiEntity.set特別徴収業務者コード(対象外データ.get特別徴収義務者コード());
        taishogaiEntity.set平準化済フラグ(false);
        return taishogaiEntity;
    }

    private RString 出力順再設定(RString 出力順) {
        if (出力順.contains(被保険者番号)) {
            出力順 = 出力順.replace(被保険者番号, 対象外データテンプ_テーブル.concat(賦課_被保険者番号));
        }
        return 出力順;
    }

    @Override
    protected void keyBreakProcess(TokuchoHeijunkaRokuBatchTaishogaiEntity t) {
    }
}
