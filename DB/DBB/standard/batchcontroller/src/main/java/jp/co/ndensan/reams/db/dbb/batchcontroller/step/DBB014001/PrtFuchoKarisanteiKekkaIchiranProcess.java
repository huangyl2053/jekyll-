/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranOutputOrder;
import jp.co.ndensan.reams.db.dbb.business.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb014001.FuchoKarisanteiFukaMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014001.FuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.csv.FutyoKarisanteiKekkaIcihiranDataCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.FuchoKarisanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FuchoKariKeisanGoFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.definition.core.NenkinCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

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
    private static final RString TITLE_調定年度 = new RString("【調定年度】　");
    private static final RString TITLE_賦課年度 = new RString("【賦課年度】　");
    private static final RString 定数_年度 = new RString("年度");
    private RString eucFilePath;
    FileSpoolManager spoolManager;
    private FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課Entity;
    private DbT2015KeisangoJohoEntity 計算後情報;
    private FuchoKarisanteiFukaProcessParameter parameter;
    private FuchoKarisanteiFukaMybatisParameter mybatisParameter;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private Association 地方公共団体情報;
    private int 連番;
    private IOutputOrder 出力順;

    @BatchWriter
    private BatchReportWriter<FutsuChoshuKarisanteiKekkaIchiranSource> batchReportWriter;
    private ReportSourceWriter<FutsuChoshuKarisanteiKekkaIchiranSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<FutyoKarisanteiKekkaIcihiranDataCSVEntity> csvWriter;

    @Override
    protected void initialize() {
        mybatisParameter = parameter.toMybatisParameter();
        mybatisParameter.set特別徴収対象者情報(TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード());
        mybatisParameter.set特別徴収追加候補者情報(TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード());
        普徴仮算定計算後賦課Entity = new FuchoKariKeisanGoFukaEntity();
        地方公共団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        連番 = 0;
        if (parameter.get出力順ID() != null) {
            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBB介護賦課,
                    ReportIdDBB.DBB200006.getReportId(), Long.parseLong(parameter.get出力順ID().toString()));
            if (出力順 != null) {
                mybatisParameter.set出力順(MyBatisOrderByClauseCreator.create(
                        FutsuChoshuKarisanteiKekkaIchiranOutputOrder.class, 出力順));
            }
        } else {
            mybatisParameter.set出力順(null);
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200006.getReportId().value()).create();
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
        Code 特別徴収業務者コード = entity.get介護継承().getDtTokubetsuChoshuGimushaCode();
        普徴仮算定計算後賦課Entity.set特別徴収業務者コード(特別徴収業務者コード != null ? 特別徴収業務者コード.getColumnValue() : RString.EMPTY);
        普徴仮算定計算後賦課Entity.set資格適用対象の通知書番号(計算後情報.getTsuchishoNo());
        普徴仮算定計算後賦課Entity.set前年度賦課の情報(entity.get介護賦課前年度());
        FutsuChoshuKarisanteiKekkaIchiranReport report = new FutsuChoshuKarisanteiKekkaIchiranReport(普徴仮算定計算後賦課Entity,
                parameter.get調定年度(), parameter.get賦課年度(), null, 地方公共団体情報, null, null, 連番);
        report.writeBy(reportSourceWriter);
        FutyoKarisanteiKekkaIcihiranDataCSVEntity csvEntity = getCsvEntity(普徴仮算定計算後賦課Entity);
        csvWriter.writeLine(csvEntity);
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        spoolManager.spool(eucFilePath);
    }

    private List<RString> get出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(TITLE_調定年度.concat(dateFormat308(parameter.get調定年度())).concat(定数_年度));
        出力条件.add(TITLE_賦課年度.concat(dateFormat308(parameter.get賦課年度())).concat(定数_年度));
        return 出力条件;
    }

    private FutyoKarisanteiKekkaIcihiranDataCSVEntity getCsvEntity(FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課Entity) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(普徴仮算定計算後賦課Entity.get宛名の情報());
        FutyoKarisanteiKekkaIcihiranDataCSVEntity csvEntity = new FutyoKarisanteiKekkaIcihiranDataCSVEntity();

        csvEntity.set作成年月日(dateFormat32(parameter.getバッチ起動日時().getDate()));
        csvEntity.set作成時刻(dateFormat32(parameter.getバッチ起動日時().getDate()));
        csvEntity.set賦課年度(dateFormat308(parameter.get賦課年度()));

        csvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
        csvEntity.set住所(kojin.get住所().get住所());
        csvEntity.set町域管内管外住所(kojin.get住所().get住所());
        csvEntity.set番地(kojin.get住所().get番地().getBanchi().getColumnValue());
        csvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
        csvEntity.set行政区(kojin.get行政区画().getGyoseiku().get名称());
        csvEntity.set生年月日(dateFormat32(kojin.get生年月日().toFlexibleDate()));
        csvEntity.set性別(kojin.get性別().getName().getShortJapanese());
        csvEntity.set世帯主名(kojin.get世帯主名().getColumnValue());
        csvEntity.set通知書番号(普徴仮算定計算後賦課Entity.get通知書番号().getColumnValue());
        csvEntity.set世帯コード(kojin.get世帯コード().getColumnValue());
        csvEntity.set被保険者氏名(kojin.get日本人氏名().getName().getColumnValue());
        csvEntity.set特別徴収業務者コード(普徴仮算定計算後賦課Entity.get特別徴収業務者コード());
        csvEntity.set特別徴収義務者(new TokubetsuChoshuGimushaCode(普徴仮算定計算後賦課Entity.get特別徴収業務者コード()).getMeisho());
        csvEntity.set特別徴収対象年金コード(普徴仮算定計算後賦課Entity.get仮徴収年金コード());
        csvEntity.set特別徴収対象年金(new NenkinCode(普徴仮算定計算後賦課Entity.get仮徴収年金コード()).getMeisho());
        csvEntity.set特別徴収仮徴収額_4月(new RString(普徴仮算定計算後賦課Entity.get特徴期別金額01().toString()));
        csvEntity.set特別徴収仮徴収額_6月(new RString(普徴仮算定計算後賦課Entity.get特徴期別金額02().toString()));
        csvEntity.set特別徴収仮徴収額_8月(new RString(普徴仮算定計算後賦課Entity.get特徴期別金額03().toString()));
        //csvEntity.set前年度情報の最終所得段階(普徴仮算定計算後賦課Entity.get特別徴収業務者コード());
        if (普徴仮算定計算後賦課Entity.get前年度賦課の情報().getNengakuHokenryo2() != null) {
            csvEntity.set前年度情報の最終月別年額(new RString(普徴仮算定計算後賦課Entity.get前年度賦課の情報().getNengakuHokenryo2().toString()));
        } else {
            csvEntity.set前年度情報の最終月別年額(new RString(普徴仮算定計算後賦課Entity.get前年度賦課の情報().getNengakuHokenryo1().toString()));
        }
        csvEntity.set前年度情報の最終普徴額(get前年度情報の最終普徴額(普徴仮算定計算後賦課Entity));
        csvEntity.set前年度情報の確定保険料額(new RString(普徴仮算定計算後賦課Entity.get前年度賦課の情報().getKakuteiHokenryo().toString()));
        csvEntity.set前年度情報の計算納期数(普徴仮算定計算後賦課Entity.get特別徴収業務者コード());
        csvEntity.set前年度情報の賦課納期数(普徴仮算定計算後賦課Entity.get特別徴収業務者コード());
        csvEntity.set特別徴収業務者コード(普徴仮算定計算後賦課Entity.get特別徴収業務者コード());
        csvEntity.set特別徴収業務者コード(普徴仮算定計算後賦課Entity.get特別徴収業務者コード());

        return csvEntity;
    }

    private RString get前年度情報の最終普徴額(FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課Entity) {
        Decimal 前年度情報の最終普徴額 = Decimal.ZERO;
        if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額01().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額01();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額02().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額02();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額03().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額03();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額04().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額04();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額05().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額05();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額06().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額06();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額07().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額07();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額08().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額08();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額09().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額09();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額10().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額10();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額11().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額11();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額12().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額12();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額13().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額13();
        } else if (0 < 普徴仮算定計算後賦課Entity.get普徴収入額14().compareTo(Decimal.ZERO)) {
            前年度情報の最終普徴額 = 普徴仮算定計算後賦課Entity.get普徴収入額14();
        }
        return new RString(前年度情報の最終普徴額.toString());
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
}
