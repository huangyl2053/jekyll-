/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB022001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolist.fukadaicho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolist.fukadaicho.JukyushaHantei;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolist.fukadaicho.KijunbiKubun;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolist.fukadaicho.ShikakuKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.processprm.hanyolistfukadaicho.HanyoListFukaDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistfukadaicho.HanyoListFukaDaichoCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistfukadaicho.HanyoListFukaDaichoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistfukadaicho.HanyoListFukaDaichoTmpEntity;
import jp.co.ndensan.reams.db.dbb.service.core.hanyolistfukadaicho.HanyoListFukaDaichoCsvEditor;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * バッチ設計_DBBBT22002_汎用リスト 賦課台帳Processのクラスです。
 *
 * @reamsid_L DBB-1900-030 zhaowei
 */
public class HanyoListFukaDaichoProcess extends BatchKeyBreakBase<HanyoListFukaDaichoTmpEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "hanyolistfukadaicho.IHanyoListFukaDaichoMapper.getHanyoListFukaDaicho");

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200033"));
    private static final RString 日本語ファイル名 = new RString("汎用リスト 賦課台帳CSV");
    private static final RString ファイル名 = new RString("HanyoList_FukaDaicho.csv");
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 抽出条件 = new RString("【抽出条件】");
    private static final RString 賦課年度 = new RString("　　　賦課年度：");
    private static final RString 調定年度 = new RString("　　　調定年度：");
    private static final RString 資格区分 = new RString("　　　資格区分：");
    private static final RString 受給者判定 = new RString("　　　受給者判定：");
    private static final RString 徴収方法 = new RString("　　　徴収方法：");
    private static final RString 保険料段階 = new RString("　　　保険料段階：");
    private static final RString SPACE = new RString("　　　　　　　　　");
    private static final RString 時点 = new RString("　　　時点：");
    private static final RString 最新状態で抽出する = new RString("最新状態で抽出する");
    private static final RString 指定された賦課基準日で抽出する = new RString("指定された賦課基準日で抽出する");
    private static final RString 基準日 = new RString("基準日：");
    private static final RString 指定された調定日処理日で抽出する = new RString("指定された調定日（処理日）で抽出する");
    private static final ReportId EUC_ID = new ReportId("DBB200033");
    private static final RString CSV出力有無 = new RString("");
    private static final RString CODE = new RString("0003");
    private static final RString 定数_年度 = new RString("年度");
    private static final RString 段階１FALSE = new RString("□１段階　　");
    private static final RString 段階２FALSE = new RString("□２段階　　");
    private static final RString 段階３FALSE = new RString("□３段階　　");
    private static final RString 段階４FALSE = new RString("□４段階　　");
    private static final RString 段階５FALSE = new RString("□５段階　　");
    private static final RString 段階６FALSE = new RString("□６段階　　");
    private static final RString 段階７FALSE = new RString("□７段階　　");
    private static final RString 段階８FALSE = new RString("□８段階　　");
    private static final RString 段階９FALSE = new RString("□９段階　　");
    private static final RString 段階１０FALSE = new RString("□１０段階　　");
    private static final RString 段階１１FALSE = new RString("□１１段階　　");
    private static final RString 段階１２FALSE = new RString("□１２段階　　");
    private static final RString 段階１３FALSE = new RString("□１３段階　　");
    private static final RString 段階１４FALSE = new RString("□１４段階　　");
    private static final RString 段階１５FALSE = new RString("□１５段階　　");
    private static final RString 段階１６FALSE = new RString("□１６段階　　");
    private static final RString 段階１７FALSE = new RString("□１７段階　　");
    private static final RString 段階１８FALSE = new RString("□１８段階　　");
    private static final RString 段階１９FALSE = new RString("□１９段階　　");
    private static final RString 段階２０FALSE = new RString("□２０段階　　");
    private static final RString 段階１TRUE = new RString("■１段階　　");
    private static final RString 段階２TRUE = new RString("■２段階　　");
    private static final RString 段階３TRUE = new RString("■３段階　　");
    private static final RString 段階４TRUE = new RString("■４段階　　");
    private static final RString 段階５TRUE = new RString("■５段階　　");
    private static final RString 段階６TRUE = new RString("■６段階　　");
    private static final RString 段階７TRUE = new RString("■７段階　　");
    private static final RString 段階８TRUE = new RString("■８段階　　");
    private static final RString 段階９TRUE = new RString("■９段階　　");
    private static final RString 段階１０TRUE = new RString("■１０段階　　");
    private static final RString 段階１１TRUE = new RString("■１１段階　　");
    private static final RString 段階１２TRUE = new RString("■１２段階　　");
    private static final RString 段階１３TRUE = new RString("■１３段階　　");
    private static final RString 段階１４TRUE = new RString("■１４段階　　");
    private static final RString 段階１５TRUE = new RString("■１５段階　　");
    private static final RString 段階１６TRUE = new RString("■１６段階　　");
    private static final RString 段階１７TRUE = new RString("■１７段階　　");
    private static final RString 段階１８TRUE = new RString("■１８段階　　");
    private static final RString 段階１９TRUE = new RString("■１９段階　　");
    private static final RString 段階２０TRUE = new RString("■２０段階　　");
    private static final RString 定数_ONE = new RString("01");
    private static final RString 定数_TWO = new RString("02");
    private static final RString 定数_THREE = new RString("03");
    private static final RString 定数_FOUR = new RString("04");
    private static final RString 定数_FIVE = new RString("05");
    private static final RString 定数_６ = new RString("06");
    private static final RString 定数_７ = new RString("07");
    private static final RString 定数_８ = new RString("08");
    private static final RString 定数_９ = new RString("09");
    private static final RString 定数_１０ = new RString("10");
    private static final RString 定数_１１ = new RString("11");
    private static final RString 定数_１２ = new RString("12");
    private static final RString 定数_１３ = new RString("13");
    private static final RString 定数_１４ = new RString("14");
    private static final RString 定数_１５ = new RString("15");
    private static final RString 定数_１６ = new RString("16");
    private static final RString 定数_１７ = new RString("17");
    private static final RString 定数_１８ = new RString("18");
    private static final RString 定数_１９ = new RString("19");
    private static final RString 定数_２０ = new RString("20");
    private static final RString 年齢SHOW = new RString("　　　年齢：");
    private static final RString 年齢PARAMETER = new RString("年齢");
    private static final RString 年齢基準日SHOW = new RString("年齢基準日：");
    private static final RString 生年月日PARAMETER = new RString("生年月日");
    private static final RString 生年月日SHOW = new RString("　　　生年月日：");
    private static final RString 左記号 = new RString("(");
    private static final RString 右記号 = new RString(")");
    private static final RString LINE = new RString("　～　");
    private static final RString 定数_歳 = new RString("歳");
    private static final RString 住所SHOW = new RString("　　　住所：");
    private static final RString 行政区SHOW = new RString("　　　行政区：");
    private static final RString 地区1SHOW = new RString("　　　地区1：");
    private static final RString 地区2SHOW = new RString("　　　地区2：");
    private static final RString 地区3SHOW = new RString("　　　地区3：");
    private static final RString 保険者SHOW = new RString("　　　保険者：");
    private static final int INDEX_ZERO = 0;
    private HanyoListFukaDaichoCsvEditor csvEditor;
    private HanyoListFukaDaichoProcessParameter processParameter;
    private List<PersonalData> personalDataList;
    private HokenryoDankaiList 保険料段階リスト;
    private List<KoseiShichosonMaster> 構成市町村マスタlist;
    private Association 地方公共団体;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private FileSpoolManager manager;
    private YMDHMS システム日時;
    private RString eucFilePath;
    private Decimal 連番;

    private int flag;
    private HokenryoDankaiSettings hokenryoDankaiSettings;
    private IShikibetsuTaishoPSMSearchKey searchKey;
    private RString 出力順;
    private HanyoListFukaDaichoEntity 賦課台帳;
    private HanyoListFukaDaichoProcessCore breakProcessCore;
    @BatchWriter
    private CsvWriter<HanyoListFukaDaichoCsvEntity> csvWriter;

    @Override
    protected void initialize() {
        flag = 0;
        連番 = Decimal.ONE;
        出力順 = RString.EMPTY;
        システム日時 = YMDHMS.now();
        csvEditor = new HanyoListFukaDaichoCsvEditor();
        personalDataList = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        hokenryoDankaiSettings = HokenryoDankaiSettings.createInstance();
        保険料段階リスト = hokenryoDankaiSettings.get保険料段階ListIn(processParameter.get賦課年度());
        構成市町村マスタlist = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        賦課台帳 = new HanyoListFukaDaichoEntity();
        breakProcessCore = new HanyoListFukaDaichoProcessCore();
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBB介護賦課, processParameter.get帳票ID());
    }

    @Override
    protected IBatchReader createReader() {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課,
                processParameter.get帳票ID(), processParameter.get出力順ID());
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(
                    HanyoListFukaDaichoProcessCore.DBB200033HanyoListFukaDaichoEnum.class, outputOrder);
        }
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.setデータ取得区分(DataShutokuKubun.直近レコード);
        searchKey = builder.build();
        processParameter.set宛名検索条件(searchKey);
        processParameter.setシステム日付(システム日時.getDate());
        processParameter.set賦課基準日で抽出(KijunbiKubun.賦課基準日で抽出.getコード());
        processParameter.set調定日で抽出(KijunbiKubun.調定日で抽出.getコード());
        processParameter.set資格取得者のみ(ShikakuKubun.資格取得者のみ.getコード());
        processParameter.set資格喪失者のみ(ShikakuKubun.資格喪失者のみ.getコード());
        processParameter.set受給者のみ(JukyushaHantei.受給者のみ.getコード());
        processParameter.set有効無効区分(YukoMukoKubun.有効.getコード());
        RString 保険者コード = processParameter.get宛名抽出条件().getShichoson_Code().getColumnValue();
        processParameter.set保険者コード(保険者コード);
        processParameter.set出力順(出力順);
        return new BatchDbReader(ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(processParameter.is項目名付加()).build();
    }

    @Override
    protected void usualProcess(HanyoListFukaDaichoTmpEntity entity) {
        if (flag == 0) {
            flag = 1;
        }
    }

    @Override
    protected void keyBreakProcess(HanyoListFukaDaichoTmpEntity entity) {
        flag = 2;
        賦課台帳 = breakProcessCore.keyBreakProcess(getBefore(), entity);
        csvファイル出力();
    }

    @Override
    protected void afterExecute() {
        if (flag == 1) {
            賦課台帳 = new HanyoListFukaDaichoEntity();
            賦課台帳.set介護賦課(getBefore().get介護賦課());
            賦課台帳.get調定共通リスト().add(getBefore().get調定共通());
            賦課台帳.get介護期別リスト().add(getBefore().get介護期別());
            賦課台帳.set介護徴収方法(getBefore().get介護徴収方法());
            賦課台帳.set受給者台帳Newest(getBefore().get受給者台帳Newest());
            賦課台帳.set被保険者台帳管理Newest(getBefore().get被保険者台帳管理Newest());
            賦課台帳.set宛名(getBefore().get宛名());
            賦課台帳.set宛先(getBefore().get宛先());
            賦課台帳.set特別徴収義務者コード(getBefore().get特別徴収義務者コード());
            賦課台帳.set本算定後(getBefore().is本算定後());
            csvファイル出力();
        }
        if (flag == 2) {
            賦課台帳 = breakProcessCore.getFinal賦課台帳();
            csvファイル出力();
        }

        if ((personalDataList == null || personalDataList.isEmpty()) && processParameter.is項目名付加()) {
            csvWriter.writeLine(new HanyoListFukaDaichoCsvEntity());
        }
        csvWriter.close();
        if (personalDataList == null || personalDataList.isEmpty()) {
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);
        } else {
            AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath, accessLog);
        }
        バッチ出力条件リストの出力();
    }

    private void csvファイル出力() {
        if (賦課台帳 != null && is出力データ(賦課台帳)) {
            csvWriter.writeLine(csvEditor.editor(賦課台帳, processParameter, 連番, 保険料段階リスト, 構成市町村マスタlist,
                    new FlexibleDate(システム日時.getDate().toDateString()), 帳票制御共通));
            連番 = 連番.add(Decimal.ONE);
            personalDataList.add(toPersonalData(賦課台帳));
        }
    }

    private boolean is出力データ(HanyoListFukaDaichoEntity entity) {
        if (ChoshuHoho.全て.getコード().equals(processParameter.get徴収方法())
                || ChoshuHoho.前半普後半特.getコード().equals(processParameter.get徴収方法())) {
            return true;
        }
        Decimal 特徴納付額 = Decimal.ZERO;
        Decimal 普徴納付額 = Decimal.ZERO;
        for (DbT2003KibetsuEntity 介護期別 : entity.get介護期別リスト()) {
            for (UrT0705ChoteiKyotsuEntity 調定共通 : entity.get調定共通リスト()) {
                if (介護期別.getChoteiId().compareTo(new Decimal(調定共通.getChoteiId())) == 0) {
                    if (ChoshuHohoKibetsu.特別徴収.getコード().equals(介護期別.getChoshuHouhou())) {
                        特徴納付額 = 特徴納付額.add(調定共通.getChoteigaku());
                    }
                    if (ChoshuHohoKibetsu.普通徴収.getコード().equals(介護期別.getChoshuHouhou())) {
                        普徴納付額 = 普徴納付額.add(調定共通.getChoteigaku());
                    }
                    break;
                }
            }
        }
        if (ChoshuHoho.特徴のみ.getコード().equals(processParameter.get徴収方法())
                && 特徴納付額.compareTo(Decimal.ZERO) > 0 && 普徴納付額.compareTo(Decimal.ZERO) == 0) {
            return true;
        }
        if (ChoshuHoho.普徴のみ.getコード().equals(processParameter.get徴収方法())
                && 特徴納付額.compareTo(Decimal.ZERO) == 0 && 普徴納付額.compareTo(Decimal.ZERO) > 0) {
            return true;
        }
        return ChoshuHoho.併徴者のみ.getコード().equals(processParameter.get徴収方法())
                && 特徴納付額.compareTo(Decimal.ZERO) > 0 && 普徴納付額.compareTo(Decimal.ZERO) > 0;
    }

    private PersonalData toPersonalData(HanyoListFukaDaichoEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE), 定数_被保険者番号,
                entity.get被保険者台帳管理Newest().getHihokenshaNo().value());
        return PersonalData.of(entity.get宛名().getShikibetsuCode(), expandedInfo);
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString 出力件数 = new RString(String.valueOf(csvWriter.getCount()));
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder1 = new RStringBuilder();
        builder1.append(抽出条件);
        出力条件.add(builder1.toRString());
        RStringBuilder builder2 = new RStringBuilder();
        FlexibleYear 調定年度2 = processParameter.get調定年度();
        builder2.append(調定年度);
        if (調定年度2 != null && !調定年度2.isEmpty()) {
            builder2.append(調定年度2.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK)
                    .toDateString()).append(定数_年度);
        } else {
            builder2.append(RString.EMPTY);
        }
        出力条件.add(builder2.toRString());
        RStringBuilder builder3 = new RStringBuilder();
        builder3.append(賦課年度);
        FlexibleYear 賦課年度2 = processParameter.get賦課年度();
        if (賦課年度2 != null && !賦課年度2.isEmpty()) {
            builder3.append(賦課年度2.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK)
                    .toDateString()).append(定数_年度);
        } else {
            builder3.append(RString.EMPTY);
        }
        出力条件.add(builder3.toRString());
        RStringBuilder builder4 = new RStringBuilder();
        builder4.append(時点);
        if (processParameter.is最新状態で抽出()) {
            builder4.append(最新状態で抽出する);
        } else {
            if (KijunbiKubun.賦課基準日で抽出.getコード().equals(processParameter.get基準日区分())) {
                builder4.append(指定された賦課基準日で抽出する);
            }
            if (KijunbiKubun.調定日で抽出.getコード().equals(processParameter.get基準日区分())) {
                builder4.append(指定された調定日処理日で抽出する);
            }
        }
        出力条件.add(builder4.toRString());
        if (!processParameter.is最新状態で抽出()) {
            RStringBuilder builder5 = new RStringBuilder();
            builder5.append(左記号).append(基準日)
                    .append(processParameter.get基準日().wareki().eraType(EraType.KANJI)
                            .firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE)
                            .fillType(FillType.ZERO).toDateString()).append(右記号);
            出力条件.add(builder5.toRString());
        }
        出力条件.add(RString.EMPTY);
        RStringBuilder builder7 = new RStringBuilder();
        builder7.append(資格区分);
        builder7.append(ShikakuKubun.toValue(processParameter.get資格区分()).get名称());
        出力条件.add(builder7.toRString());
        RStringBuilder builder11 = new RStringBuilder();
        builder11.append(受給者判定);
        builder11.append(JukyushaHantei.toValue(processParameter.get受給者判定()).get名称());
        出力条件.add(builder11.toRString());
        RStringBuilder builder12 = new RStringBuilder();
        builder12.append(徴収方法);
        builder12.append(ChoshuHoho.toValue(processParameter.get徴収方法()).get名称());
        出力条件.add(builder12.toRString());
        RStringBuilder builder6 = new RStringBuilder();
        set保険料段階１(builder6, 出力条件);
        RStringBuilder builder13 = new RStringBuilder();
        set保険料段階２(builder13, 出力条件);
        RStringBuilder builder14 = new RStringBuilder();
        set保険料段階３(builder14, 出力条件);
        RStringBuilder builder15 = new RStringBuilder();
        set保険料段階４(builder15, 出力条件);
        出力条件.add(RString.EMPTY);
        RStringBuilder builder8 = new RStringBuilder();
        set年齢層抽出方法(builder8, 出力条件);
        RStringBuilder builder9 = new RStringBuilder();
        set地区区分(builder9, 出力条件);
        RStringBuilder builder10 = new RStringBuilder();
        KaigoDonyuKeitaiManager 介護導入形態manager = KaigoDonyuKeitaiManager.createInstance();
        List<KaigoDonyuKeitai> list = 介護導入形態manager.get介護導入形態By業務分類(GyomuBunrui.介護事務);
        if (list.get(INDEX_ZERO).get導入形態コード().is広域()) {
            builder10.append(保険者SHOW);
            builder10.append(processParameter.get宛名抽出条件().getShichoson_Code().getColumnValue());
            builder10.append(processParameter.get宛名抽出条件().getShichoson_Mesho());
            出力条件.add(builder10.toRString());
        }
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ID.value(),
                導入団体コード,
                市町村名,
                new RString(String.valueOf(JobContextHolder.getJobId())),
                日本語ファイル名,
                出力件数,
                CSV出力有無,
                ファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private void set保険料段階１(RStringBuilder builder, List<RString> 出力条件) {
        builder.append(保険料段階);
        if (processParameter.get保険料段階s().contains(定数_ONE)) {
            builder.append(段階１TRUE);
        } else {
            builder.append(段階１FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_TWO)) {
            builder.append(段階２TRUE);
        } else {
            builder.append(段階２FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_THREE)) {
            builder.append(段階３TRUE);
        } else {
            builder.append(段階３FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_FOUR)) {
            builder.append(段階４TRUE);
        } else {
            builder.append(段階４FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_FIVE)) {
            builder.append(段階５TRUE);
        } else {
            builder.append(段階５FALSE);
        }
        出力条件.add(builder.toRString());
    }

    private void set保険料段階２(RStringBuilder builder, List<RString> 出力条件) {
        builder.append(SPACE);
        if (processParameter.get保険料段階s().contains(定数_６)) {
            builder.append(段階６TRUE);
        } else {
            builder.append(段階６FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_７)) {
            builder.append(段階７TRUE);
        } else {
            builder.append(段階７FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_８)) {
            builder.append(段階８TRUE);
        } else {
            builder.append(段階８FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_９)) {
            builder.append(段階９TRUE);
        } else {
            builder.append(段階９FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_１０)) {
            builder.append(段階１０TRUE);
        } else {
            builder.append(段階１０FALSE);
        }
        出力条件.add(builder.toRString());
    }

    private void set保険料段階３(RStringBuilder builder, List<RString> 出力条件) {
        builder.append(SPACE);
        if (processParameter.get保険料段階s().contains(定数_１１)) {
            builder.append(段階１１TRUE);
        } else {
            builder.append(段階１１FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_１２)) {
            builder.append(段階１２TRUE);
        } else {
            builder.append(段階１２FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_１３)) {
            builder.append(段階１３TRUE);
        } else {
            builder.append(段階１３FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_１４)) {
            builder.append(段階１４TRUE);
        } else {
            builder.append(段階１４FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_１５)) {
            builder.append(段階１５TRUE);
        } else {
            builder.append(段階１５FALSE);
        }
        出力条件.add(builder.toRString());
    }

    private void set保険料段階４(RStringBuilder builder, List<RString> 出力条件) {
        builder.append(SPACE);
        if (processParameter.get保険料段階s().contains(定数_１６)) {
            builder.append(段階１６TRUE);
        } else {
            builder.append(段階１６FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_１７)) {
            builder.append(段階１７TRUE);
        } else {
            builder.append(段階１７FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_１８)) {
            builder.append(段階１８TRUE);
        } else {
            builder.append(段階１８FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_１９)) {
            builder.append(段階１９TRUE);
        } else {
            builder.append(段階１９FALSE);
        }
        if (processParameter.get保険料段階s().contains(定数_２０)) {
            builder.append(段階２０TRUE);
        } else {
            builder.append(段階２０FALSE);
        }
        出力条件.add(builder.toRString());
    }

    private void set地区区分(RStringBuilder builder, List<RString> 出力条件) {
        RString 地区区分コード = processParameter.get宛名抽出条件().getChiku_Kubun().getコード();
        if (processParameter.get宛名抽出条件() != null
                && processParameter.get宛名抽出条件().getChiku_Kubun() != null
                && !Chiku.全て.getコード().equals(地区区分コード)) {
            if (Chiku.住所.getコード().equals(地区区分コード)) {
                builder.append(住所SHOW);
                RString 町域CodeFrom = processParameter.get宛名抽出条件().getJusho_From();
                RString 町域名称From = processParameter.get宛名抽出条件().getJusho_FromMesho();
                RString 町域CodeTo = processParameter.get宛名抽出条件().getJusho_To();
                RString 町域名称To = processParameter.get宛名抽出条件().getJusho_ToMesho();
                builder.append(町域CodeFrom).append(町域名称From).append(LINE).append(町域CodeTo).append(町域名称To);
                出力条件.add(builder.toRString());
            } else if (Chiku.行政区.getコード().equals(地区区分コード)) {
                builder.append(行政区SHOW);
                RString 行政区CodeFrom = processParameter.get宛名抽出条件().getGyoseiku_From();
                RString 行政区名称From = processParameter.get宛名抽出条件().getGyoseiku_FromMesho();
                RString 行政区CodeTo = processParameter.get宛名抽出条件().getGyoseiku_To();
                RString 行政区名称To = processParameter.get宛名抽出条件().getGyoseiku_ToMesho();
                builder.append(行政区CodeFrom).append(行政区名称From).append(LINE).append(行政区CodeTo).append(行政区名称To);
                出力条件.add(builder.toRString());
            } else if (Chiku.地区.getコード().equals(地区区分コード)) {
                RStringBuilder builder1 = new RStringBuilder();
                builder1.append(地区1SHOW);
                RString 地区１CodeFrom = processParameter.get宛名抽出条件().getChiku1_From();
                RString 地区１名称From = processParameter.get宛名抽出条件().getChiku1_FromMesho();
                RString 地区１CodeTo = processParameter.get宛名抽出条件().getChiku1_To();
                RString 地区１名称To = processParameter.get宛名抽出条件().getChiku1_ToMesho();
                builder1.append(地区１CodeFrom).append(地区１名称From).append(LINE).append(地区１CodeTo).append(地区１名称To);
                出力条件.add(builder1.toRString());
                RStringBuilder builder2 = new RStringBuilder();
                builder2.append(地区2SHOW);
                RString 地区2CodeFrom = processParameter.get宛名抽出条件().getChiku2_From();
                RString 地区2名称From = processParameter.get宛名抽出条件().getChiku2_From();
                RString 地区2CodeTo = processParameter.get宛名抽出条件().getChiku2_To();
                RString 地区2名称To = processParameter.get宛名抽出条件().getChiku2_To();
                builder2.append(地区2CodeFrom).append(地区2名称From).append(LINE).append(地区2CodeTo).append(地区2名称To);
                出力条件.add(builder2.toRString());
                RStringBuilder builder3 = new RStringBuilder();
                builder3.append(地区3SHOW);
                RString 地区3CodeFrom = processParameter.get宛名抽出条件().getChiku3_From();
                RString 地区3名称From = processParameter.get宛名抽出条件().getChiku3_FromMesho();
                RString 地区3CodeTo = processParameter.get宛名抽出条件().getChiku3_To();
                RString 地区3名称To = processParameter.get宛名抽出条件().getChiku3_ToMesho();
                builder3.append(地区3CodeFrom).append(地区3名称From).append(LINE).append(地区3CodeTo).append(地区3名称To);
                出力条件.add(builder3.toRString());
            }
        }
    }

    private void set年齢層抽出方法(RStringBuilder builder, List<RString> 出力条件) {
        if (年齢PARAMETER.equals(processParameter.get宛名抽出条件().getAgeSelectKijun().get名称())) {
            builder.append(年齢SHOW);
            if (processParameter.get宛名抽出条件().getNenreiRange() != null) {
                set年齢(builder);
            } else {
                builder.append(RString.FULL_SPACE);
            }
            builder.append(左記号).append(年齢基準日SHOW);
            RDate 年齢基準日 = processParameter.get宛名抽出条件().getNenreiKijunbi();
            if (年齢基準日 != null) {
                RString 変数_年齢基準日 = 年齢基準日.wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString();
                builder.append(変数_年齢基準日).append(右記号);
            } else {
                builder.append(RString.FULL_SPACE).append(右記号);
            }
            出力条件.add(builder.toRString());
        } else if (生年月日PARAMETER.equals(processParameter.get宛名抽出条件().getAgeSelectKijun().get名称())) {
            builder.append(生年月日SHOW);
            if (processParameter.get宛名抽出条件().getSeinengappiRange() != null) {
                set生年月日(builder);
            } else {
                builder.append(RString.EMPTY);
            }
            出力条件.add(builder.toRString());
        }
    }

    private void set年齢(RStringBuilder builder) {
        Decimal 年齢From = processParameter.get宛名抽出条件().getNenreiRange().getFrom();
        Decimal 年齢To = processParameter.get宛名抽出条件().getNenreiRange().getTo();
        RString 変数_年齢From = null;
        RString 変数_年齢To = null;
        if (年齢From != null) {
            変数_年齢From = new RString(年齢From.toString());
        }
        if (年齢To != null) {
            変数_年齢To = new RString(年齢To.toString());
        }
        builder.append(変数_年齢From).append(定数_歳).append(LINE).
                append(変数_年齢To).append(定数_歳).append(RString.FULL_SPACE);
    }

    private void set生年月日(RStringBuilder builder) {
        RDate 生年月日From = processParameter.get宛名抽出条件().getSeinengappiRange().getFrom();
        RDate 生年月日To = processParameter.get宛名抽出条件().getSeinengappiRange().getTo();
        RString 変数_生年月日From = null;
        RString 変数_生年月日To = null;
        if (生年月日From != null) {
            変数_生年月日From = 生年月日From.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
        if (生年月日To != null) {
            変数_生年月日To = 生年月日To.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
        builder.append(変数_生年月日From).append(LINE).append(変数_生年月日To);
    }
}
