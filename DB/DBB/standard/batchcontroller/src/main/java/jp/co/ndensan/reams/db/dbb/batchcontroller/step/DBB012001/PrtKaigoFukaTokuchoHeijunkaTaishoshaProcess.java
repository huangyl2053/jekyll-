/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB012001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.DBB200003_HeijunkaKeisanJuneKekkaIchiran;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TkChoshuHeijunkaKeisanJuneKekkaIchiranPageBreak;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt35001.TokuchoHeinjunka6GatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001.TokuchoHeinjunka6GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokuChoHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
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
 * 特別徴収平準化計算（特別徴収6月分）結果一覧表対象者の帳票出力クラスです。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
public class PrtKaigoFukaTokuchoHeijunkaTaishoshaProcess extends BatchKeyBreakBase<TokuchoHeijunkaRokuBatchTaishoshaEntity> {

    /**
     * OutputParameter用キー REPORT_FLAG
     */
    public static final RString PAGE_COUNT;
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchoheinjunka6gatsu.ITokuchoHeinjunka6GatsuBatchMapper.get対象者データ");
    private static final int NUM_0 = 0;
    private static final int NUM_3 = 3;
    private static final int NUM_6 = 6;
    private static final RString 計算後情報_テーブル = new RString("対象者データ.");
    private static final RString 被保険者番号 = new RString("\"hihokenshaNo\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200003"));
    private static final RString ファイル名_対象者一覧表 = new RString("介護保険特徴仮算定平準化対象者一覧表_");
    private static final RString CSVファイル = new RString(".csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString タイトル_対象者一覧表 = new RString("介護保険　特徴仮算定平準化対象者一覧表");
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
    protected IBatchReader createReader() {
        TokuchoHeinjunka6GatsuMyBatisParameter myBatisParameter = new TokuchoHeinjunka6GatsuMyBatisParameter();
        myBatisParameter.set調定年度(parameter.get調定年度());
        myBatisParameter.set賦課年度(parameter.get賦課年度());
        myBatisParameter.set調定前年度(parameter.get調定前年度());
        myBatisParameter.set出力順(出力順設定(出力順));
        myBatisParameter.setShikibetsutaishoParam(parameter.getShikibetsutaishoParam());
        return new BatchDbReader(MAPPERPATH, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.getColumnValue()).
                addBreak(new TkChoshuHeijunkaKeisanJuneKekkaIchiranPageBreak(pageBreakKeys)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath,
                ファイル名_対象者一覧表.concat(parameter.get調定日時().toString()).concat(CSVファイル));
        csvWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(false)
                .build();
    }

    @Override
    protected void usualProcess(TokuchoHeijunkaRokuBatchTaishoshaEntity entity) {
        TokuchoHeijyunkaTaishoshaEntity taishoshaEntity = new TokuchoHeijyunkaTaishoshaEntity();
        特徴平準化計算対象者entity作成(entity, taishoshaEntity);
        Optional<HokenryoDankai> 保険料段階 = 保険料段階取得.get保険料段階(parameter.get賦課年度(),
                taishoshaEntity.get保険料段階仮算定時());
        Decimal 今年度保険料率 = 今年度保険料率取得(保険料段階);
        int 調整金額 = 調整金額取得(今年度保険料率, parameter.get賦課年度());
        TokuchoHeijunkaRokuBatchTaishoshaIchiran taishosha = new TokuchoHeijunkaRokuBatchTaishoshaIchiran(
                taishoshaEntity, 今年度保険料率, new Decimal(調整金額));
        TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport report = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport(
                taishosha, null, parameter.get調定日時(),
                parameter.get賦課年度(), 導入団体クラス, outputOrder, 帳票制御共通);
        report.writeBy(reportSourceWriter);

        IKojin iKojin = ShikibetsuTaishoFactory.createKojin(taishoshaEntity.get宛名の情報());
        RString 編集後住所 = JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体クラス);
        List<RString> bodyList = new ArrayList<>();
        特徴平準化対象者CSV項目編集(bodyList, parameter.get調定日時(), parameter.get賦課年度(), taishoshaEntity,
                編集後住所, 今年度保険料率, 調整金額, taishoshaEntity.get備考コード());
        toBodyList(bodyList);
        csvWriter.writeLine(bodyList);

    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        count.setValue(new RString(batchReportWriter.getPageCount()));
    }

    private void 特徴平準化計算対象者entity作成(TokuchoHeijunkaRokuBatchTaishoshaEntity entity,
            TokuchoHeijyunkaTaishoshaEntity taishoshaEntity) {
        final DbT2015KeisangoJohoEntity 計算後情報 = entity.get計算後情報();
        変更後項目設定(taishoshaEntity, 計算後情報, entity.get宛名(), entity.get特別徴収義務者コード());
        taishoshaEntity.set平準化済フラグ(true);
        taishoshaEntity.set変更前特徴額_１期(entity.getTkKibetsuGaku01());
        taishoshaEntity.set変更前特徴額_２期(entity.getTkKibetsuGaku02());
        taishoshaEntity.set変更前特徴額_３期(entity.getTkKibetsuGaku03());
        taishoshaEntity.set変更前特徴額_４期(entity.getTkKibetsuGaku04());
        taishoshaEntity.set変更前特徴額_５期(entity.getTkKibetsuGaku05());
        taishoshaEntity.set変更前特徴額_６期(entity.getTkKibetsuGaku06());
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

    private void 変更後項目設定(TokuchoHeijyunkaTaishoshaEntity taishoshaEntity,
            DbT2015KeisangoJohoEntity 計算後情報, UaFt200FindShikibetsuTaishoEntity 宛名, RString 特別徴収義務者コード) {
        taishoshaEntity.set調定年度(計算後情報.getChoteiNendo());
        taishoshaEntity.set賦課年度(計算後情報.getFukaNendo());
        taishoshaEntity.set通知書番号(計算後情報.getTsuchishoNo());
        taishoshaEntity.set更正前後区分(計算後情報.getKoseiZengoKubun());
        taishoshaEntity.set作成処理名(計算後情報.getSakuseiShoriName());
        taishoshaEntity.set賦課履歴番号(計算後情報.getFukaRirekiNo());
        taishoshaEntity.set被保険者番号(計算後情報.getHihokenshaNo());
        taishoshaEntity.set識別コード(計算後情報.getShikibetsuCode());
        taishoshaEntity.set世帯コード(計算後情報.getSetaiCode());
        taishoshaEntity.set世帯員数(計算後情報.getSetaiInsu());
        taishoshaEntity.set資格取得日(計算後情報.getShikakuShutokuYMD());
        taishoshaEntity.set資格取得事由(計算後情報.getShikakuShutokuJiyu());
        taishoshaEntity.set資格喪失日(計算後情報.getShikakuSoshitsuYMD());
        taishoshaEntity.set資格喪失事由(計算後情報.getShikakuSoshitsuJiyu());
        taishoshaEntity.set生活保護扶助種類(計算後情報.getSeihofujoShurui());
        taishoshaEntity.set生保開始日(計算後情報.getSeihoKaishiYMD());
        taishoshaEntity.set生保廃止日(計算後情報.getSeihoHaishiYMD());
        taishoshaEntity.set老齢開始日(計算後情報.getRonenKaishiYMD());
        taishoshaEntity.set老齢廃止日(計算後情報.getRonenHaishiYMD());
        taishoshaEntity.set賦課期日(計算後情報.getFukaYMD());
        taishoshaEntity.set課税区分(計算後情報.getKazeiKubun());
        taishoshaEntity.set世帯課税区分(計算後情報.getSetaikazeiKubun());
        taishoshaEntity.set合計所得金額(計算後情報.getGokeiShotokuGaku());
        taishoshaEntity.set公的年金収入額(計算後情報.getNenkinShunyuGaku());
        taishoshaEntity.set保険料段階(計算後情報.getHokenryoDankai());
        taishoshaEntity.set保険料算定段階1(計算後情報.getHokenryoDankai1());
        taishoshaEntity.set算定年額保険料1(計算後情報.getNengakuHokenryo1());
        taishoshaEntity.set月割開始年月1(計算後情報.getTsukiwariStartYM1());
        taishoshaEntity.set月割終了年月1(計算後情報.getTsukiwariEndYM1());
        taishoshaEntity.set保険料算定段階2(計算後情報.getHokenryoDankai2());
        taishoshaEntity.set算定年額保険料2(計算後情報.getNengakuHokenryo2());
        taishoshaEntity.set月割開始年月2(計算後情報.getTsukiwariStartYM2());
        taishoshaEntity.set月割終了年月2(計算後情報.getTsukiwariEndYM2());
        taishoshaEntity.set調定日時(計算後情報.getChoteiNichiji());
        taishoshaEntity.set調定事由1(計算後情報.getChoteiJiyu1());
        taishoshaEntity.set調定事由2(計算後情報.getChoteiJiyu2());
        taishoshaEntity.set調定事由3(計算後情報.getChoteiJiyu3());
        taishoshaEntity.set調定事由4(計算後情報.getChoteiJiyu4());
        taishoshaEntity.set更正月(計算後情報.getKoseiM());
        taishoshaEntity.set減免前介護保険料年額(計算後情報.getGemmenMaeHokenryo());
        taishoshaEntity.set減免額(計算後情報.getGemmenGaku());
        taishoshaEntity.set確定介護保険料年額(計算後情報.getKakuteiHokenryo());
        taishoshaEntity.set保険料段階仮算定時(計算後情報.getHokenryoDankaiKarisanntei());
        taishoshaEntity.set徴収方法履歴番号(計算後情報.getChoshuHohoRirekiNo());
        taishoshaEntity.set異動基準日時(計算後情報.getIdoKijunNichiji());
        taishoshaEntity.set口座区分(計算後情報.getKozaKubun());
        taishoshaEntity.set境界層区分(計算後情報.getKyokaisoKubun());
        taishoshaEntity.set職権区分(計算後情報.getShokkenKubun());
        taishoshaEntity.set賦課市町村コード(計算後情報.getFukaShichosonCode());
        taishoshaEntity.set特徴歳出還付額(計算後情報.getTkSaishutsuKampuGaku());
        taishoshaEntity.set普徴歳出還付額(計算後情報.getFuSaishutsuKampuGaku());
        taishoshaEntity.set特徴期期別金額01(計算後情報.getTkKibetsuGaku01());
        taishoshaEntity.set特徴期期別金額02(計算後情報.getTkKibetsuGaku02());
        taishoshaEntity.set特徴期期別金額03(計算後情報.getTkKibetsuGaku03());
        taishoshaEntity.set特徴期期別金額04(計算後情報.getTkKibetsuGaku04());
        taishoshaEntity.set特徴期期別金額05(計算後情報.getTkKibetsuGaku05());
        taishoshaEntity.set特徴期期別金額06(計算後情報.getTkKibetsuGaku06());
        taishoshaEntity.set普徴期期別金額01(計算後情報.getFuKibetsuGaku01());
        taishoshaEntity.set普徴期期別金額02(計算後情報.getFuKibetsuGaku02());
        taishoshaEntity.set普徴期期別金額03(計算後情報.getFuKibetsuGaku03());
        taishoshaEntity.set普徴期期別金額04(計算後情報.getFuKibetsuGaku04());
        taishoshaEntity.set普徴期期別金額05(計算後情報.getFuKibetsuGaku05());
        taishoshaEntity.set普徴期期別金額06(計算後情報.getFuKibetsuGaku06());
        taishoshaEntity.set普徴期期別金額07(計算後情報.getFuKibetsuGaku07());
        taishoshaEntity.set普徴期期別金額08(計算後情報.getFuKibetsuGaku08());
        taishoshaEntity.set普徴期期別金額09(計算後情報.getFuKibetsuGaku09());
        taishoshaEntity.set普徴期期別金額10(計算後情報.getFuKibetsuGaku10());
        taishoshaEntity.set普徴期期別金額11(計算後情報.getFuKibetsuGaku11());
        taishoshaEntity.set普徴期期別金額12(計算後情報.getFuKibetsuGaku12());
        taishoshaEntity.set普徴期期別金額13(計算後情報.getFuKibetsuGaku13());
        taishoshaEntity.set普徴期期別金額14(計算後情報.getFuKibetsuGaku14());
        taishoshaEntity.set徴収方法4月(計算後情報.getChoshuHoho4gatsu());
        taishoshaEntity.set徴収方法5月(計算後情報.getChoshuHoho5gatsu());
        taishoshaEntity.set徴収方法6月(計算後情報.getChoshuHoho6gatsu());
        taishoshaEntity.set徴収方法7月(計算後情報.getChoshuHoho7gatsu());
        taishoshaEntity.set徴収方法8月(計算後情報.getChoshuHoho8gatsu());
        taishoshaEntity.set徴収方法9月(計算後情報.getChoshuHoho9gatsu());
        taishoshaEntity.set徴収方法10月(計算後情報.getChoshuHoho10gatsu());
        taishoshaEntity.set徴収方法11月(計算後情報.getChoshuHoho11gatsu());
        taishoshaEntity.set徴収方法12月(計算後情報.getChoshuHoho12gatsu());
        taishoshaEntity.set徴収方法1月(計算後情報.getChoshuHoho1gatsu());
        taishoshaEntity.set徴収方法2月(計算後情報.getChoshuHoho2gatsu());
        taishoshaEntity.set徴収方法3月(計算後情報.getChoshuHoho3gatsu());
        taishoshaEntity.set徴収方法翌4月(計算後情報.getChoshuHohoYoku4gatsu());
        taishoshaEntity.set徴収方法翌5月(計算後情報.getChoshuHohoYoku5gatsu());
        taishoshaEntity.set徴収方法翌6月(計算後情報.getChoshuHohoYoku6gatsu());
        taishoshaEntity.set徴収方法翌7月(計算後情報.getChoshuHohoYoku7gatsu());
        taishoshaEntity.set徴収方法翌8月(計算後情報.getChoshuHohoYoku8gatsu());
        taishoshaEntity.set徴収方法翌9月(計算後情報.getChoshuHohoYoku9gatsu());
        taishoshaEntity.set仮徴収基礎年金番号(計算後情報.getKariNenkinNo());
        taishoshaEntity.set仮徴収年金コード(計算後情報.getKariNenkinCode());
        taishoshaEntity.set仮徴収捕捉月(計算後情報.getKariHosokuM());
        taishoshaEntity.set本徴収基礎年金番号(計算後情報.getHonNenkinNo());
        taishoshaEntity.set本徴収年金コード(計算後情報.getHonNenkinCode());
        taishoshaEntity.set本徴収捕捉月(計算後情報.getHonHosokuM());
        taishoshaEntity.set翌年度仮徴収基礎年金番号(計算後情報.getYokunendoKariNenkinNo());
        taishoshaEntity.set翌年度仮徴収年金コード(計算後情報.getYokunendoKariNenkinCode());
        taishoshaEntity.set翌年度仮徴収捕捉月(計算後情報.getYokunendoKariHosokuM());
        taishoshaEntity.set依頼情報送付済みフラグ(計算後情報.getIraiSohuzumiFlag());
        taishoshaEntity.set追加依頼情報送付済みフラグ(計算後情報.getTsuikaIraiSohuzumiFlag());
        taishoshaEntity.set特別徴収停止日時(計算後情報.getTokuchoTeishiNichiji());
        taishoshaEntity.set特別徴収停止事由コード(計算後情報.getTokuchoTeishiJiyuCode());
        taishoshaEntity.set特徴収入額01(計算後情報.getTkShunyuGaku01());
        taishoshaEntity.set特徴収入額02(計算後情報.getTkShunyuGaku02());
        taishoshaEntity.set特徴収入額03(計算後情報.getTkShunyuGaku03());
        taishoshaEntity.set特徴収入額04(計算後情報.getTkShunyuGaku04());
        taishoshaEntity.set特徴収入額05(計算後情報.getTkShunyuGaku05());
        taishoshaEntity.set特徴収入額06(計算後情報.getTkShunyuGaku06());
        taishoshaEntity.set普徴収入額01(計算後情報.getFuShunyuGaku01());
        taishoshaEntity.set普徴収入額02(計算後情報.getFuShunyuGaku02());
        taishoshaEntity.set普徴収入額03(計算後情報.getFuShunyuGaku03());
        taishoshaEntity.set普徴収入額04(計算後情報.getFuShunyuGaku04());
        taishoshaEntity.set普徴収入額05(計算後情報.getFuShunyuGaku05());
        taishoshaEntity.set普徴収入額06(計算後情報.getFuShunyuGaku06());
        taishoshaEntity.set普徴収入額07(計算後情報.getFuShunyuGaku07());
        taishoshaEntity.set普徴収入額08(計算後情報.getFuShunyuGaku08());
        taishoshaEntity.set普徴収入額09(計算後情報.getFuShunyuGaku09());
        taishoshaEntity.set普徴収入額10(計算後情報.getFuShunyuGaku10());
        taishoshaEntity.set普徴収入額11(計算後情報.getFuShunyuGaku11());
        taishoshaEntity.set普徴収入額12(計算後情報.getFuShunyuGaku12());
        taishoshaEntity.set普徴収入額13(計算後情報.getFuShunyuGaku13());
        taishoshaEntity.set普徴収入額14(計算後情報.getFuShunyuGaku14());
        taishoshaEntity.set宛名の情報(宛名);
        taishoshaEntity.set特別徴収業務者コード(特別徴収義務者コード);
    }

    private RString 出力順設定(RString 出力順) {
        if (出力順.contains(被保険者番号)) {
            出力順 = 出力順.replace(被保険者番号, 計算後情報_テーブル.concat(被保険者番号));
        }
        return 出力順;
    }

    private void 特徴平準化対象者CSV項目編集(List<RString> bodyList, YMDHMS 調定日時, FlexibleYear 賦課年度,
            TokuchoHeijyunkaTaishoshaEntity 特徴平準化結果対象者, RString 編集後住所, Decimal 今年度保険料率,
            int 調整金額, RString 編集備考) {
        bodyList.add(調定日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
        bodyList.add(new RString(調定日時.toString()));
        bodyList.add(タイトル_対象者一覧表);
        bodyList.add(賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString());
        bodyList.add(特徴平準化結果対象者.get通知書番号().value());
        if (特徴平準化結果対象者.get識別コード() != null) {
            bodyList.add(特徴平準化結果対象者.get識別コード().value());
        } else {
            bodyList.add(RString.EMPTY);
        }
        final UaFt200FindShikibetsuTaishoEntity 宛名の情報 = 特徴平準化結果対象者.get宛名の情報();
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
        final RString 特別徴収業務者コード = 特徴平準化結果対象者.get特別徴収業務者コード();
        bodyList.add(特別徴収業務者コード);
        if (特別徴収業務者コード != null) {
            bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(特別徴収業務者コード), FlexibleDate.getNowDate()));
        } else {
            bodyList.add(RString.EMPTY);
        }
        変更前特徴額設定(特徴平準化結果対象者, bodyList);
        bodyList.add(特徴平準化結果対象者.get保険料段階仮算定時());
        bodyList.add(DecimalFormatter.toコンマ区切りRString(今年度保険料率, 0));
        bodyList.add(DecimalFormatter.toコンマ区切りRString(new Decimal(調整金額), 0));
        bodyList.add(編集備考);
        bodyList.add(特徴平準化結果対象者.get被保険者番号().value());
        if (特徴平準化結果対象者.get世帯コード() != null) {
            bodyList.add(特徴平準化結果対象者.get世帯コード().value());
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
        RString 仮徴収年金コード = 特徴平準化結果対象者.get仮徴収年金コード();
        bodyList.add(仮徴収年金コード);
        if (仮徴収年金コード != null && (NUM_3 <= 仮徴収年金コード.length())) {
            bodyList.add(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                    new Code(仮徴収年金コード.substring(NUM_0, NUM_3)), FlexibleDate.getNowDate()));
        }
        特徴期期別金額設定(特徴平準化結果対象者, bodyList);
    }

    private void 変更前特徴額設定(TokuchoHeijyunkaTaishoshaEntity 特徴平準化結果対象者, List<RString> bodyList) {
        if (特徴平準化結果対象者.get変更前特徴額_１期() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get変更前特徴額_１期(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get変更前特徴額_２期() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get変更前特徴額_２期(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get変更前特徴額_３期() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get変更前特徴額_３期(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get変更前特徴額_４期() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get変更前特徴額_４期(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get変更前特徴額_５期() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get変更前特徴額_５期(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get変更前特徴額_６期() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get変更前特徴額_６期(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
    }

    private void 特徴期期別金額設定(TokuchoHeijyunkaTaishoshaEntity 特徴平準化結果対象者, List<RString> bodyList) {
        if (特徴平準化結果対象者.get特徴期期別金額01() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get特徴期期別金額01(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get特徴期期別金額02() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get特徴期期別金額02(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get特徴期期別金額03() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get特徴期期別金額03(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get特徴期期別金額04() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get特徴期期別金額04(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get特徴期期別金額05() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get特徴期期別金額05(), 0));
        } else {
            bodyList.add(RString.EMPTY);
        }
        if (特徴平準化結果対象者.get特徴期期別金額06() != null) {
            bodyList.add(DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get特徴期期別金額06(), 0));
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

    @Override
    protected void keyBreakProcess(TokuchoHeijunkaRokuBatchTaishoshaEntity t) {
    }
}
