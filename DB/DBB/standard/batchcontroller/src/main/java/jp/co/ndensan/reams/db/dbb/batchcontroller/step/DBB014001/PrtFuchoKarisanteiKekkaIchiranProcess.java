/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranOutputOrder;
import jp.co.ndensan.reams.db.dbb.business.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranPageBreak;
import jp.co.ndensan.reams.db.dbb.business.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb014001.FuchoKarisanteiFukaMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014001.FuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.csv.FutyoKarisanteiKekkaIcihiranDataCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.FuchoKarisanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FuchoKariKeisanGoFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.definition.core.NenkinCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 普徴仮算定結果のクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
public class PrtFuchoKarisanteiKekkaIchiranProcess extends BatchProcessBase<FuchoKarisanteiKekkaEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokarisanteifuka."
                    + "IFuchoKarisanteiFukaMapper.get普徴仮算定結果");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200006");
    private static final RString CSVFILENAME = new RString("FutsuChoshuKarisanteiKekkaIchiranData.csv");
    private final ReportId 帳票分類ID = new ReportId(new RString("DBB200009_HonsanteiKekkaIcihiran"));
    private static final RString TITLE_調定年度 = new RString("【調定年度】　");
    private static final RString TITLE_賦課年度 = new RString("【賦課年度】　");
    private static final RString 徴収方法_普通徴収 = new RString("普通徴収");
    private static final RString 徴収方法_併用徴収 = new RString("併用徴収");
    private static final RString 定数_年度 = new RString("年度");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final RString DOT = new RString("*");
    private static final Decimal 月処理区分_5 = new Decimal("5");
    private static final int NUM_1 = 1;
    private static final int NUM_4 = 4;
    private RString eucFilePath;
    FileSpoolManager spoolManager;
    private DbT2015KeisangoJohoEntity 計算後情報;
    private FuchoKarisanteiFukaProcessParameter parameter;
    private FuchoKarisanteiFukaMybatisParameter mybatisParameter;
    private Association 地方公共団体情報;
    private int 連番;
    private IOutputOrder 出力順;
    private List<RString> pageBreakKeys;
    private List<RString> 出力項目リスト;
    private List<RString> 改頁項目リスト;
    private RDate 調定年度開始日;

    @BatchWriter
    private BatchReportWriter<FutsuChoshuKarisanteiKekkaIchiranSource> batchReportWriter;
    private ReportSourceWriter<FutsuChoshuKarisanteiKekkaIchiranSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<FutyoKarisanteiKekkaIcihiranDataCSVEntity> csvWriter;

    @Override
    protected void initialize() {
        出力項目リスト = new ArrayList<>();
        改頁項目リスト = new ArrayList<>();
        pageBreakKeys = new ArrayList<>();
        mybatisParameter = parameter.toMybatisParameter();
        mybatisParameter.set特別徴収対象者情報(TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード());
        mybatisParameter.set特別徴収追加候補者情報(TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード());
        調定年度開始日 = new RDate(parameter.get調定年度().getYearValue() - NUM_1, NUM_4, NUM_1);
        地方公共団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        連番 = 0;
        if (parameter.get出力順ID() != null) {
            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBB介護賦課,
                    ReportIdDBB.DBB200006.getReportId(), Long.parseLong(parameter.get出力順ID().toString()));
            if (出力順 != null) {
                mybatisParameter.set出力順(MyBatisOrderByClauseCreator.create(
                        FutsuChoshuKarisanteiKekkaIchiranOutputOrder.class, 出力順));
                setPageBreakKeys();
            }
        } else {
            mybatisParameter.set出力順(null);
        }
    }

    private void setPageBreakKeys() {
        for (ISetSortItem item : 出力順.get設定項目リスト()) {
            出力項目リスト.add(item.get項目名());
            if (item.is改頁項目()) {
                pageBreakKeys.add(item.get項目ID());
                改頁項目リスト.add(item.get項目名());
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<FutsuChoshuKarisanteiKekkaIchiranSource> breaker = new FutsuChoshuKarisanteiKekkaIchiranPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200006.getReportId().value()).
                addBreak(breaker).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(spoolManager.getEucOutputDirectry(),
                CSVFILENAME);
        csvWriter = BatchWriters.csvWriter(FutyoKarisanteiKekkaIcihiranDataCSVEntity.class).
                filePath(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected void process(FuchoKarisanteiKekkaEntity entity) {
        連番++;
        計算後情報 = entity.get計算後情報();
        FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課Entity = new FuchoKariKeisanGoFukaEntity();
        普徴仮算定計算後賦課Entity.set調定年度(計算後情報.getChoteiNendo());
        普徴仮算定計算後賦課Entity.set賦課年度(計算後情報.getFukaNendo());
        普徴仮算定計算後賦課Entity.set通知書番号(計算後情報.getTsuchishoNo());
        普徴仮算定計算後賦課Entity.set更正前後区分(計算後情報.getKoseiZengoKubun());
        普徴仮算定計算後賦課Entity.set作成処理名(計算後情報.getSakuseiShoriName());
        普徴仮算定計算後賦課Entity.set賦課履歴番号(計算後情報.getFukaRirekiNo());
        普徴仮算定計算後賦課Entity.set被保険者番号(計算後情報.getHihokenshaNo());
        普徴仮算定計算後賦課Entity.set識別コード(計算後情報.getShikibetsuCode());
        普徴仮算定計算後賦課Entity.set世帯コード(計算後情報.getSetaiCode());
        普徴仮算定計算後賦課Entity.set世帯員数(計算後情報.getSetaiInsu());
        普徴仮算定計算後賦課Entity.set資格取得日(計算後情報.getShikakuShutokuYMD());
        普徴仮算定計算後賦課Entity.set資格取得事由(計算後情報.getShikakuShutokuJiyu());
        普徴仮算定計算後賦課Entity.set資格喪失日(計算後情報.getShikakuSoshitsuYMD());
        普徴仮算定計算後賦課Entity.set資格喪失事由(計算後情報.getShikakuSoshitsuJiyu());
        普徴仮算定計算後賦課Entity.set生活保護扶助種類(計算後情報.getSeihofujoShurui());
        普徴仮算定計算後賦課Entity.set生保開始日(計算後情報.getSeihoKaishiYMD());
        普徴仮算定計算後賦課Entity.set生保廃止日(計算後情報.getSeihoHaishiYMD());
        普徴仮算定計算後賦課Entity.set老齢開始日(計算後情報.getRonenKaishiYMD());
        普徴仮算定計算後賦課Entity.set老齢廃止日(計算後情報.getRonenHaishiYMD());
        普徴仮算定計算後賦課Entity.set賦課期日(計算後情報.getFukaYMD());
        普徴仮算定計算後賦課Entity.set課税区分(計算後情報.getKazeiKubun());
        普徴仮算定計算後賦課Entity.set世帯課税区分(計算後情報.getSetaikazeiKubun());
        普徴仮算定計算後賦課Entity.set合計所得金額(計算後情報.getGokeiShotokuGaku());
        普徴仮算定計算後賦課Entity.set公的年金収入額(計算後情報.getNenkinShunyuGaku());
        普徴仮算定計算後賦課Entity.set保険料段階(計算後情報.getHokenryoDankai());
        普徴仮算定計算後賦課Entity.set保険料算定段階1(計算後情報.getHokenryoDankai1());
        普徴仮算定計算後賦課Entity.set算定年額保険料1(計算後情報.getNengakuHokenryo1());
        普徴仮算定計算後賦課Entity.set月割開始年月1(計算後情報.getTsukiwariStartYM1());
        普徴仮算定計算後賦課Entity.set月割終了年月1(計算後情報.getTsukiwariEndYM1());
        普徴仮算定計算後賦課Entity.set保険料算定段階2(計算後情報.getHokenryoDankai2());
        普徴仮算定計算後賦課Entity.set算定年額保険料2(計算後情報.getNengakuHokenryo2());
        普徴仮算定計算後賦課Entity.set月割開始年月2(計算後情報.getTsukiwariStartYM2());
        普徴仮算定計算後賦課Entity.set月割終了年月2(計算後情報.getTsukiwariEndYM2());
        普徴仮算定計算後賦課Entity.set調定日時(計算後情報.getChoteiNichiji());
        普徴仮算定計算後賦課Entity.set調定事由1(計算後情報.getChoteiJiyu1());
        普徴仮算定計算後賦課Entity.set調定事由2(計算後情報.getChoteiJiyu2());
        普徴仮算定計算後賦課Entity.set調定事由3(計算後情報.getChoteiJiyu3());
        普徴仮算定計算後賦課Entity.set調定事由4(計算後情報.getChoteiJiyu4());
        普徴仮算定計算後賦課Entity.set更正月(計算後情報.getKoseiM());
        普徴仮算定計算後賦課Entity.set減免前介護保険料年額(計算後情報.getGemmenMaeHokenryo());
        普徴仮算定計算後賦課Entity.set減免額(計算後情報.getGemmenGaku());
        普徴仮算定計算後賦課Entity.set確定介護保険料年額(計算後情報.getKakuteiHokenryo());
        普徴仮算定計算後賦課Entity.set保険料段階仮算定時(計算後情報.getHokenryoDankaiKarisanntei());
        普徴仮算定計算後賦課Entity.set徴収方法履歴番号(計算後情報.getChoshuHohoRirekiNo());
        普徴仮算定計算後賦課Entity.set異動基準日時(計算後情報.getIdoKijunNichiji());
        普徴仮算定計算後賦課Entity.set口座区分(計算後情報.getKozaKubun());
        普徴仮算定計算後賦課Entity.set境界層区分(計算後情報.getKyokaisoKubun());
        普徴仮算定計算後賦課Entity.set職権区分(計算後情報.getShokkenKubun());
        普徴仮算定計算後賦課Entity.set賦課市町村コード(計算後情報.getFukaShichosonCode());
        普徴仮算定計算後賦課Entity.set特徴歳出還付額(計算後情報.getTkSaishutsuKampuGaku());
        普徴仮算定計算後賦課Entity.set普徴歳出還付額(計算後情報.getFuSaishutsuKampuGaku());
        普徴仮算定計算後賦課Entity.set特徴期別金額01(計算後情報.getTkKibetsuGaku01());
        普徴仮算定計算後賦課Entity.set特徴期別金額02(計算後情報.getTkKibetsuGaku02());
        普徴仮算定計算後賦課Entity.set特徴期別金額03(計算後情報.getTkKibetsuGaku03());
        普徴仮算定計算後賦課Entity.set特徴期別金額04(計算後情報.getTkKibetsuGaku04());
        普徴仮算定計算後賦課Entity.set特徴期別金額05(計算後情報.getTkKibetsuGaku05());
        普徴仮算定計算後賦課Entity.set特徴期別金額06(計算後情報.getTkKibetsuGaku06());
        普徴仮算定計算後賦課Entity.set普徴期別金額01(計算後情報.getFuKibetsuGaku01());
        普徴仮算定計算後賦課Entity.set普徴期別金額02(計算後情報.getFuKibetsuGaku02());
        普徴仮算定計算後賦課Entity.set普徴期別金額03(計算後情報.getFuKibetsuGaku03());
        普徴仮算定計算後賦課Entity.set普徴期別金額04(計算後情報.getFuKibetsuGaku04());
        普徴仮算定計算後賦課Entity.set普徴期別金額05(計算後情報.getFuKibetsuGaku05());
        普徴仮算定計算後賦課Entity.set普徴期別金額06(計算後情報.getFuKibetsuGaku06());
        普徴仮算定計算後賦課Entity.set普徴期別金額07(計算後情報.getFuKibetsuGaku07());
        普徴仮算定計算後賦課Entity.set普徴期別金額08(計算後情報.getFuKibetsuGaku08());
        普徴仮算定計算後賦課Entity.set普徴期別金額09(計算後情報.getFuKibetsuGaku09());
        普徴仮算定計算後賦課Entity.set普徴期別金額10(計算後情報.getFuKibetsuGaku10());
        普徴仮算定計算後賦課Entity.set普徴期別金額11(計算後情報.getFuKibetsuGaku11());
        普徴仮算定計算後賦課Entity.set普徴期別金額12(計算後情報.getFuKibetsuGaku12());
        普徴仮算定計算後賦課Entity.set普徴期別金額13(計算後情報.getFuKibetsuGaku13());
        普徴仮算定計算後賦課Entity.set普徴期別金額14(計算後情報.getFuKibetsuGaku14());
        普徴仮算定計算後賦課Entity.set徴収方法4月(計算後情報.getChoshuHoho4gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法5月(計算後情報.getChoshuHoho5gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法6月(計算後情報.getChoshuHoho6gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法7月(計算後情報.getChoshuHoho7gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法8月(計算後情報.getChoshuHoho8gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法9月(計算後情報.getChoshuHoho9gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法10月(計算後情報.getChoshuHoho10gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法11月(計算後情報.getChoshuHoho11gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法12月(計算後情報.getChoshuHoho12gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法1月(計算後情報.getChoshuHoho1gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法2月(計算後情報.getChoshuHoho2gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法3月(計算後情報.getChoshuHoho3gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法翌4月(計算後情報.getChoshuHohoYoku4gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法翌5月(計算後情報.getChoshuHohoYoku5gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法翌6月(計算後情報.getChoshuHohoYoku6gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法翌7月(計算後情報.getChoshuHohoYoku7gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法翌8月(計算後情報.getChoshuHohoYoku8gatsu());
        普徴仮算定計算後賦課Entity.set徴収方法翌9月(計算後情報.getChoshuHohoYoku9gatsu());
        普徴仮算定計算後賦課Entity.set仮徴収基礎年金番号(計算後情報.getKariNenkinNo());
        普徴仮算定計算後賦課Entity.set仮徴収年金コード(計算後情報.getKariNenkinCode());
        普徴仮算定計算後賦課Entity.set仮徴収捕捉月(計算後情報.getKariHosokuM());
        普徴仮算定計算後賦課Entity.set本徴収基礎年金番号(計算後情報.getHonNenkinNo());
        普徴仮算定計算後賦課Entity.set本徴収年金コード(計算後情報.getHonNenkinCode());
        普徴仮算定計算後賦課Entity.set本徴収捕捉月(計算後情報.getHonHosokuM());
        普徴仮算定計算後賦課Entity.set翌年度仮徴収基礎年金番号(計算後情報.getYokunendoKariNenkinNo());
        普徴仮算定計算後賦課Entity.set翌年度仮徴収年金コード(計算後情報.getYokunendoKariNenkinCode());
        普徴仮算定計算後賦課Entity.set翌年度仮徴収捕捉月(計算後情報.getYokunendoKariHosokuM());
        普徴仮算定計算後賦課Entity.set依頼情報送付済みフラグ(計算後情報.getIraiSohuzumiFlag());
        普徴仮算定計算後賦課Entity.set追加依頼情報送付済みフラグ(計算後情報.getTsuikaIraiSohuzumiFlag());
        普徴仮算定計算後賦課Entity.set特別徴収停止日時(計算後情報.getTokuchoTeishiNichiji());
        普徴仮算定計算後賦課Entity.set特別徴収停止事由コード(計算後情報.getTokuchoTeishiJiyuCode());
        普徴仮算定計算後賦課Entity.set特徴収入額01(計算後情報.getTkShunyuGaku01());
        普徴仮算定計算後賦課Entity.set特徴収入額02(計算後情報.getTkShunyuGaku02());
        普徴仮算定計算後賦課Entity.set特徴収入額03(計算後情報.getTkShunyuGaku03());
        普徴仮算定計算後賦課Entity.set特徴収入額04(計算後情報.getTkShunyuGaku04());
        普徴仮算定計算後賦課Entity.set特徴収入額05(計算後情報.getTkShunyuGaku05());
        普徴仮算定計算後賦課Entity.set特徴収入額06(計算後情報.getTkShunyuGaku06());
        普徴仮算定計算後賦課Entity.set普徴収入額01(計算後情報.getFuShunyuGaku01());
        普徴仮算定計算後賦課Entity.set普徴収入額02(計算後情報.getFuShunyuGaku02());
        普徴仮算定計算後賦課Entity.set普徴収入額03(計算後情報.getFuShunyuGaku03());
        普徴仮算定計算後賦課Entity.set普徴収入額04(計算後情報.getFuShunyuGaku04());
        普徴仮算定計算後賦課Entity.set普徴収入額05(計算後情報.getFuShunyuGaku05());
        普徴仮算定計算後賦課Entity.set普徴収入額06(計算後情報.getFuShunyuGaku06());
        普徴仮算定計算後賦課Entity.set普徴収入額07(計算後情報.getFuShunyuGaku07());
        普徴仮算定計算後賦課Entity.set普徴収入額08(計算後情報.getFuShunyuGaku08());
        普徴仮算定計算後賦課Entity.set普徴収入額09(計算後情報.getFuShunyuGaku09());
        普徴仮算定計算後賦課Entity.set普徴収入額10(計算後情報.getFuShunyuGaku10());
        普徴仮算定計算後賦課Entity.set普徴収入額11(計算後情報.getFuShunyuGaku11());
        普徴仮算定計算後賦課Entity.set普徴収入額12(計算後情報.getFuShunyuGaku12());
        普徴仮算定計算後賦課Entity.set普徴収入額13(計算後情報.getFuShunyuGaku13());
        普徴仮算定計算後賦課Entity.set普徴収入額14(計算後情報.getFuShunyuGaku14());
        普徴仮算定計算後賦課Entity.set宛名の情報(entity.get宛名());
        TokubetsuChoshuGimushaCode 特別徴収業務者コード = entity.get介護継承().getDtTokubetsuChoshuGimushaCode();
        普徴仮算定計算後賦課Entity.set特別徴収業務者コード(特別徴収業務者コード != null
                ? 特別徴収業務者コード.getColumnValue().getColumnValue() : RString.EMPTY);
        普徴仮算定計算後賦課Entity.set資格適用対象の通知書番号(計算後情報.getTsuchishoNo());
        普徴仮算定計算後賦課Entity.set前年度賦課の情報(entity.get介護賦課前年度());
        普徴仮算定計算後賦課Entity.set資格適用対象の通知書番号(entity.getTsuchishoNo());
        普徴仮算定計算後賦課Entity.set徴収方法(entity.getChoshuHoho());
        普徴仮算定計算後賦課Entity.set特徴開始月(entity.getTkKaishiM());
        FutsuChoshuKarisanteiKekkaIchiranReport report = new FutsuChoshuKarisanteiKekkaIchiranReport(普徴仮算定計算後賦課Entity,
                parameter.get調定年度(), parameter.get賦課年度(), new YMDHMS(parameter.getバッチ起動日時()),
                地方公共団体情報, 出力項目リスト, 改頁項目リスト, 連番);
        report.writeBy(reportSourceWriter);
        FutyoKarisanteiKekkaIcihiranDataCSVEntity csvEntity = getCsvEntity(普徴仮算定計算後賦課Entity, 連番);
        csvWriter.writeLine(csvEntity);
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        spoolManager.spool(eucFilePath);

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBB.DBB200006.getReportId().getColumnValue(),
                地方公共団体情報.getLasdecCode_().value(),
                地方公共団体情報.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBB.DBB200006.getReportName(),
                new RString(reportSourceWriter.pageCount().value()),
                CSV出力有無_有り,
                CSVFILENAME,
                get出力条件()
        );
        OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem)
                .print();
    }

    private List<RString> get出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(TITLE_調定年度.concat(dateFormat308(parameter.get調定年度())).concat(定数_年度));
        出力条件.add(TITLE_賦課年度.concat(dateFormat308(parameter.get賦課年度())).concat(定数_年度));
        if (出力順 != null) {
            出力条件.add(出力順.getFormated出力順名());
        }
        return 出力条件;
    }

    private FutyoKarisanteiKekkaIcihiranDataCSVEntity getCsvEntity(FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課Entity, int 連番) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(普徴仮算定計算後賦課Entity.get宛名の情報());
        ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(SubGyomuCode.DBB介護賦課, 帳票分類ID);
        EditedKojin 編集後個人 = new EditedKojin(kojin, 帳票制御共通, null);
        FutyoKarisanteiKekkaIcihiranDataCSVEntity csvEntity = new FutyoKarisanteiKekkaIcihiranDataCSVEntity();
        csvEntity.set作成年月日(dateFormat32(parameter.getバッチ起動日時().getDate()));
        csvEntity.set作成時刻(共通ポリシーパターン141(parameter.getバッチ起動日時().getTime()));
        csvEntity.set賦課年度(dateFormat308(parameter.get賦課年度()));
        csvEntity.set連番(new RString(連番));
        YubinNo yubinNo = 普徴仮算定計算後賦課Entity.get宛名の情報().getYubinNo();
        csvEntity.set郵便番号(yubinNo == null ? RString.EMPTY : yubinNo.getYubinNo());
        csvEntity.set住所(編集後個人.get編集後住所());
        csvEntity.set町域管内管外住所(kojin.get住所().get住所());
        AtenaBanchi banchi = 普徴仮算定計算後賦課Entity.get宛名の情報().getBanchi();
        csvEntity.set番地(banchi == null ? RString.EMPTY : banchi.getColumnValue());
        GyoseikuCode gyoseikuCode = 普徴仮算定計算後賦課Entity.get宛名の情報().getGyoseikuCode();
        csvEntity.set行政区コード(gyoseikuCode == null ? RString.EMPTY : gyoseikuCode.getColumnValue());
        csvEntity.set行政区(普徴仮算定計算後賦課Entity.get宛名の情報().getGyoseikuName());
        csvEntity.set生年月日(dateFormat32(普徴仮算定計算後賦課Entity.get宛名の情報().getSeinengappiYMD()));
        csvEntity.set性別(kojin.get性別().getName().getShortJapanese());
        AtenaMeisho setainushiMei = 普徴仮算定計算後賦課Entity.get宛名の情報().getSetainushiMei();
        csvEntity.set世帯主名(setainushiMei == null ? RString.EMPTY : setainushiMei.getColumnValue());
        csvEntity.set通知書番号(普徴仮算定計算後賦課Entity.get通知書番号().getColumnValue());
        SetaiCode setaiCode = 普徴仮算定計算後賦課Entity.get宛名の情報().getSetaiCode();
        csvEntity.set世帯コード(setaiCode == null ? RString.EMPTY : setaiCode.getColumnValue());
        AtenaKanaMeisho kanaMeisho = 普徴仮算定計算後賦課Entity.get宛名の情報().getKanaMeisho();
        csvEntity.set被保険者氏名(kanaMeisho == null ? RString.EMPTY : kanaMeisho.getColumnValue());
        csvEntity.set特別徴収業務者コード(普徴仮算定計算後賦課Entity.get特別徴収業務者コード());
        csvEntity.set特別徴収義務者(new TokubetsuChoshuGimushaCode(普徴仮算定計算後賦課Entity.get特別徴収業務者コード()).getMeisho());
        csvEntity.set特別徴収対象年金コード(普徴仮算定計算後賦課Entity.get仮徴収年金コード());
        csvEntity.set特別徴収対象年金(new NenkinCode(普徴仮算定計算後賦課Entity.get仮徴収年金コード()).getMeisho());
        csvEntity.set特別徴収仮徴収額_4月(getDecimal(普徴仮算定計算後賦課Entity.get特徴期別金額01()));
        csvEntity.set特別徴収仮徴収額_6月(getDecimal(普徴仮算定計算後賦課Entity.get特徴期別金額02()));
        csvEntity.set特別徴収仮徴収額_8月(getDecimal(普徴仮算定計算後賦課Entity.get特徴期別金額03()));
        HokenryoDankaiList 保険料段階List = HokenryoDankaiSettings.createInstance().
                get保険料段階ListIn(普徴仮算定計算後賦課Entity.get賦課年度());
        if (普徴仮算定計算後賦課Entity.get前年度賦課の情報() != null && RString.isNullOrEmpty(
                普徴仮算定計算後賦課Entity.get前年度賦課の情報().getHokenryoDankai2())) {
            csvEntity.set前年度情報の最終所得段階(保険料段階List.getBy段階区分(普徴仮算定計算後賦課Entity.get前年度賦課の情報().
                    getHokenryoDankai2()).get表記());
        } else if (普徴仮算定計算後賦課Entity.get前年度賦課の情報() != null) {
            csvEntity.set前年度情報の最終所得段階(保険料段階List.getBy段階区分(普徴仮算定計算後賦課Entity.get前年度賦課の情報().
                    getHokenryoDankai1()).get表記());
        }
        if (普徴仮算定計算後賦課Entity.get前年度賦課の情報() != null
                && 普徴仮算定計算後賦課Entity.get前年度賦課の情報().getNengakuHokenryo2() != null) {
            csvEntity.set前年度情報の最終月別年額(new RString(普徴仮算定計算後賦課Entity.get前年度賦課の情報().getNengakuHokenryo2().toString()));
        } else if (普徴仮算定計算後賦課Entity.get前年度賦課の情報() != null) {
            csvEntity.set前年度情報の最終月別年額(new RString(普徴仮算定計算後賦課Entity.get前年度賦課の情報().getNengakuHokenryo1().toString()));
        }
        csvEntity.set前年度情報の最終普徴額(get前年度情報の最終普徴額(普徴仮算定計算後賦課Entity));
        if (普徴仮算定計算後賦課Entity.get前年度賦課の情報() != null) {
            csvEntity.set前年度情報の確定保険料額(new RString(普徴仮算定計算後賦課Entity.get前年度賦課の情報().getKakuteiHokenryo().toString()));
            FuchoKiUtil fuchoKiUtil = new FuchoKiUtil(普徴仮算定計算後賦課Entity.get前年度賦課の情報().getFukaNendo());
            KitsukiList 普徴期月リスト = fuchoKiUtil.get期月リスト();
            Kitsuki 最終法定納期 = 普徴期月リスト.get最終法定納期();
            int 期 = 最終法定納期.get期AsInt();
            csvEntity.set前年度情報の計算納期数(new RString(期));
            csvEntity.set前年度情報の賦課納期数(get賦課納期数(調定年度開始日, 普徴仮算定計算後賦課Entity.get前年度賦課の情報(), 期, 普徴期月リスト));
        }
        csvEntity.set仮算定時保険料段階(保険料段階List.getBy段階区分(普徴仮算定計算後賦課Entity.get保険料段階仮算定時()).get表記());
        csvEntity.set新規資格適用段階対象者(普徴仮算定計算後賦課Entity.get資格適用対象の通知書番号() == null
                ? DOT : 普徴仮算定計算後賦課Entity.get資格適用対象の通知書番号().getColumnValue());
        csvEntity.set徴収方法(get徴収方法(普徴仮算定計算後賦課Entity));
        csvEntity.set普通徴収仮徴収額_4月(getDecimal(普徴仮算定計算後賦課Entity.get普徴期別金額01()));
        csvEntity.set普通徴収仮徴収額_5月(getDecimal(普徴仮算定計算後賦課Entity.get普徴期別金額02()));
        csvEntity.set普通徴収仮徴収額_6月(getDecimal(普徴仮算定計算後賦課Entity.get普徴期別金額03()));
        csvEntity.set普通徴収仮徴収額_7月(getDecimal(普徴仮算定計算後賦課Entity.get普徴期別金額04()));
        csvEntity.set普通徴収仮徴収額_8月(getDecimal(普徴仮算定計算後賦課Entity.get普徴期別金額05()));
        csvEntity.set普通徴収仮徴収額_9月(getDecimal(普徴仮算定計算後賦課Entity.get普徴期別金額06()));
        return csvEntity;
    }

    private RString get賦課納期数(RDate 調定年度開始日, FukaJohoTempEntity 前年度賦課情報, int 期, KitsukiList 期月リスト) {
        int 納期数 = 0;
        List<RString> 月処理区分list = new ArrayList<>();
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分1, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分2, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分3, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分4, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分5, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分6, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分7, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分8, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分9, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分10, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分11, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分12, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分13, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        月処理区分list.add(DbBusinessConfig.get(ConfigNameDBB.普徴期情報_月処理区分14, 調定年度開始日, SubGyomuCode.DBB介護賦課));
        List<Decimal> 普徴期別金額list = new ArrayList<>();
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku01());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku02());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku03());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku04());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku05());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku06());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku07());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku08());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku09());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku10());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku11());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku12());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku13());
        普徴期別金額list.add(前年度賦課情報.getFuKibetsuGaku14());
        for (int i = 1; i <= 期; i++) {
            boolean flag = false;
            for (Kitsuki kitsuki : 期月リスト.get期の月(i)) {
                int 月 = kitsuki.get月AsInt();
                Decimal 月処理区分 = new Decimal(月処理区分list.get(月 - 1).toString());
                Decimal 普徴期別金額 = 普徴期別金額list.get(i - 1) == null ? Decimal.ZERO : 普徴期別金額list.get(i - 1);
                if (月処理区分.compareTo(月処理区分_5) <= 0
                        && 普徴期別金額.compareTo(Decimal.ZERO) > 0) {
                    flag = true;
                }
            }
            if (flag) {
                納期数++;
            }
        }
        return new RString(納期数);
    }

    private RString get徴収方法(FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課Entity) {
        Decimal 特徴期別金額01 = 普徴仮算定計算後賦課Entity.get特徴期別金額01() == null
                ? Decimal.ZERO : 普徴仮算定計算後賦課Entity.get特徴期別金額01();
        Decimal 特徴期別金額02 = 普徴仮算定計算後賦課Entity.get特徴期別金額02() == null
                ? Decimal.ZERO : 普徴仮算定計算後賦課Entity.get特徴期別金額02();
        Decimal 特徴期別金額03 = 普徴仮算定計算後賦課Entity.get特徴期別金額03() == null
                ? Decimal.ZERO : 普徴仮算定計算後賦課Entity.get特徴期別金額03();
        Decimal 合計値 = 特徴期別金額01.add(特徴期別金額02).
                add(特徴期別金額03);
        if (NUM_1 <= 合計値.intValue()) {
            return 徴収方法_併用徴収;
        }
        return 徴収方法_普通徴収;
    }

    private RString getDecimal(Decimal dec) {
        if (dec == null) {
            return new RString(Decimal.ZERO.toString());
        }
        return new RString(dec.toString());
    }

    private RString get前年度情報の最終普徴額(FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課Entity) {
        Decimal 前年度情報の最終普徴額 = Decimal.ZERO;
        if (普徴仮算定計算後賦課Entity.get普徴収入額01() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額01().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額01();
        } else if (普徴仮算定計算後賦課Entity.get普徴収入額02() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額02().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額02();
        } else if (普徴仮算定計算後賦課Entity.get普徴収入額03() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額03().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額03();
        } else if (普徴仮算定計算後賦課Entity.get普徴収入額04() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額04().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額04();
        } else if (普徴仮算定計算後賦課Entity.get普徴収入額05() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額05().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額05();
        } else if (普徴仮算定計算後賦課Entity.get普徴収入額06() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額06().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額06();
        } else if (普徴仮算定計算後賦課Entity.get普徴収入額07() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額07().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額07();
        } else {
            前年度情報の最終普徴額 = get前年度情報の最終普徴額Part2(普徴仮算定計算後賦課Entity, 前年度情報の最終普徴額);
        }
        return new RString(前年度情報の最終普徴額.toString());
    }

    private Decimal get前年度情報の最終普徴額Part2(FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課Entity, Decimal 前年度情報の最終普徴額) {
        if (普徴仮算定計算後賦課Entity.get普徴収入額08() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額08().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額08();
        } else if (普徴仮算定計算後賦課Entity.get普徴収入額09() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額09().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額09();
        } else if (普徴仮算定計算後賦課Entity.get普徴収入額10() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額10().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額10();
        } else if (普徴仮算定計算後賦課Entity.get普徴収入額11() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額11().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額11();
        } else if (普徴仮算定計算後賦課Entity.get普徴収入額12() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額12().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額12();
        } else if (普徴仮算定計算後賦課Entity.get普徴収入額13() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額13().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額13();
        } else if (普徴仮算定計算後賦課Entity.get普徴収入額14() != null && 0 < 普徴仮算定計算後賦課Entity.get普徴収入額14().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額14();
        }
        return 前年度情報の最終普徴額;
    }

    private RString dateFormat32(RDate date) {
        return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }

    private RString dateFormat32(FlexibleDate date) {
        return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }

    private RString dateFormat308(FlexibleYear year) {
        return year.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString();
    }

    private RString 共通ポリシーパターン141(RTime time) {
        return time.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
    }

}
