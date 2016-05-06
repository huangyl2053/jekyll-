/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.createtsukibetsusuiihyo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.createtsukibetsusuiihyo.ReportDateHensyu;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoBodyItem;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoBodyTitleItem;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoHeaderItem;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo.GemmenJyoho;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo.GennendoDate;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo.GokeiChi;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo.HihokenshaDaichoPsm;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo.KoumokuGoukey;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo.KoumokuSyoukeyi;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo.NinsuKinkaku;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.createtsukibetsusuiihyo.ReportDate;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 月別推移表作成帳票用Processクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
public class CreateTsukibetsuSuiihyoProcess extends BatchProcessBase<KoumokuGoukey> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper.get特別徴収帳票データの取得");
    private static final ReportId 帳票ID = ReportIdDBB.DBB300002.getReportId();
    private static final RString 普通徴収 = new RString("2");
    private static final RString 特別徴収 = new RString("1");
    private static final RString 四月 = new RString("04");
    private static final RString 五月 = new RString("05");
    private static final RString 六月 = new RString("06");
    private static final RString 七月 = new RString("07");
    private static final RString 八月 = new RString("08");
    private static final RString 九月 = new RString("09");
    private static final RString 十月 = new RString("10");
    private static final RString 十一月 = new RString("11");
    private static final RString 十二月 = new RString("12");
    private static final RString 一月 = new RString("01");
    private static final RString 二月 = new RString("02");
    private static final RString 三月 = new RString("03");
    private static final RString 処理年度 = new RString("処理年度");
    private static final RString 調定基準日 = new RString("調定基準日");
    private static final RString 各月資格基準日 = new RString("各月資格基準日");
    private static final RString 年齢開始 = new RString("年齢開始");
    private static final RString 年齢終了 = new RString("年齢終了");
    private static final RString 年齢基準日 = new RString("年齢基準日");
    private static final RString 生年月日開始 = new RString("生年月日開始");
    private static final RString 生年月日終了 = new RString("生年月日終了");
    private static final RString 選択対象 = new RString("選択対象");
    private static final RString 市町村 = new RString("市町村");
    private CreateTsukibetsuSuiihyoProcessParameter processPrm;
    private CreateTsukibetsuSuiihyoMyBatisParameter mybatisPrm;
    private ICreateTsukibetsuSuiihyoMapper iCreateTsukibetsuSuiihyoMapper;
    @BatchWriter
    private BatchReportWriter<TsukibetsuSuiihyoReportSource> batchReportWriter;
    private ReportSourceWriter<TsukibetsuSuiihyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mybatisPrm = processPrm.toCreateTsukibetsuSuiihyoMyBatisParameter();
        iCreateTsukibetsuSuiihyoMapper = getMapper(ICreateTsukibetsuSuiihyoMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        get合計部分の項目();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        CreateTsukibetsuSuiihyoMyBatisParameter myBatisParameter
                = CreateTsukibetsuSuiihyoMyBatisParameter.create_被保険者台帳管理と宛名のデータ(
                        mybatisPrm.getChoteiNendo(), mybatisPrm.isAgeFlg(), mybatisPrm.getAgeStart(), mybatisPrm.getAgeEnd(),
                        mybatisPrm.getAgeKijunNi(), mybatisPrm.isSeinengappiYMDFlg(), mybatisPrm.getSeinengappiYMDStart(),
                        mybatisPrm.getSeinengappiYMDEnd(), mybatisPrm.getSentakuTaisho(), mybatisPrm.getSentakuKekkaList(),
                        mybatisPrm.getShichosonCode(), mybatisPrm.getKyuShichosonCode(),
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        return new BatchDbReader(MYBATIS_SELECT_ID, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB300002.getReportId().getColumnValue()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(KoumokuGoukey koumokuGoukey) {
    }

    @Override
    protected void afterExecute() {
        List<KoumokuGoukey> 特別徴収帳票データList = iCreateTsukibetsuSuiihyoMapper.get特別徴収帳票データの取得();
        List<KoumokuGoukey> 普通徴収帳票データList = iCreateTsukibetsuSuiihyoMapper.get普通徴収帳票データの取得();
        List<KoumokuGoukey> 合計帳票データList = iCreateTsukibetsuSuiihyoMapper.get合計帳票データの取得();
        List<GemmenJyoho> 減免帳票データList = iCreateTsukibetsuSuiihyoMapper.get減免帳票データの取得();
        List<ReportDate> reportDateList1 = getReportDate(特別徴収帳票データList);
        for (ReportDate reportDate : reportDateList1) {
            reportDate.setChoshuHouhouTitle(new RString("特別徴収"));
            reportDate.setGengo(mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString());
            reportDate.setNendo(mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString());
            reportDate.setHokenshaName(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
            reportDate.setHokenshaNo(AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().getColumnValue());
        }
        List<ReportDate> reportDateList2 = getReportDate(普通徴収帳票データList);
        for (ReportDate reportDate : reportDateList2) {
            reportDate.setChoshuHouhouTitle(new RString("普通徴収"));
            reportDate.setGengo(mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString());
            reportDate.setNendo(mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString());
            reportDate.setHokenshaName(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
            reportDate.setHokenshaNo(AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().getColumnValue());
        }
        TsukibetsuSuiihyoReport report2 = TsukibetsuSuiihyoReport.createFrom(setHeadItem(new RString("普通徴収")),
                setBodyTitleItem(reportDateList2), setbodyItemList(reportDateList2));
        report2.writeBy(reportSourceWriter);
        List<ReportDate> reportDateList3 = getReportDate(合計帳票データList);
        for (ReportDate reportDate : reportDateList3) {
            reportDate.setChoshuHouhouTitle(new RString("合計"));
            reportDate.setGengo(mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString());
            reportDate.setNendo(mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString());
            reportDate.setHokenshaName(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
            reportDate.setHokenshaNo(AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().getColumnValue());
        }
        List<ReportDate> reportDateList4 = getReportGemmenDate(減免帳票データList);
        for (ReportDate reportDate : reportDateList4) {
            reportDate.setChoshuHouhouTitle(new RString("減免"));
            reportDate.setGengo(mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString());
            reportDate.setNendo(mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString());
            reportDate.setHokenshaName(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
            reportDate.setHokenshaNo(AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().getColumnValue());
        }
        outputJokenhyoFactory(1);
    }

    private List<ReportDate> getReportDate(List<KoumokuGoukey> list) {
        ReportDateHensyu reportDateHensyu = new ReportDateHensyu();
        return reportDateHensyu.getReportDateList(list);
    }

    private List<ReportDate> getReportGemmenDate(List<GemmenJyoho> list) {
        ReportDateHensyu reportDateHensyu = new ReportDateHensyu();
        return reportDateHensyu.getReportGemmenDateList(list);
    }

    private TsukibetsuSuiihyoHeaderItem setHeadItem(RString choshuHouhouTitle) {
        return new TsukibetsuSuiihyoHeaderItem(
                mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString(),
                mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString(),
                AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().getColumnValue(),
                AssociationFinderFactory.createInstance().getAssociation().get市町村名(),
                choshuHouhouTitle);
    }

    private List<TsukibetsuSuiihyoBodyTitleItem> setBodyTitleItem(List<ReportDate> reportDateList) {
        List<TsukibetsuSuiihyoBodyTitleItem> list = new ArrayList<>();
        for (ReportDate reportDate : reportDateList) {
            TsukibetsuSuiihyoBodyTitleItem bodyTitleItem = new TsukibetsuSuiihyoBodyTitleItem(reportDate.getListTitle_1());
            list.add(bodyTitleItem);
        }
        return list;
    }

    private List<TsukibetsuSuiihyoBodyItem> setbodyItemList(List<ReportDate> reportDateList) {
        List<TsukibetsuSuiihyoBodyItem> list = new ArrayList<>();
        for (ReportDate reportDate : reportDateList) {
            TsukibetsuSuiihyoBodyItem bodyItem = new TsukibetsuSuiihyoBodyItem(reportDate.getList_1(),
                    reportDate.getList_2(), reportDate.getList_3(), reportDate.getList_4(), reportDate.getList_5(), reportDate.getList_6(),
                    reportDate.getList_7(), reportDate.getList_8(), reportDate.getList_9(), reportDate.getList_10(), reportDate.getList_11(),
                    reportDate.getList_12(), reportDate.getList_13(), reportDate.getList_14(), reportDate.getList_15(), reportDate.getList_16());
            list.add(bodyItem);
        }
        return list;
    }

    private void outputJokenhyoFactory(int pageCnt) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString("56"),
                ReportIdDBB.DBB300002.getReportName(),
                new RString(String.valueOf(pageCnt)),
                new RString("なし"),
                new RString("ー"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        FlexibleYear 調定年度 = mybatisPrm.getChoteiNendo();
        出力条件.add(get条件(処理年度, 調定年度.wareki().toDateString()));
        RDate 基準日 = new YMDHMS(mybatisPrm.getChoteiKijunNichiji().toString()).getDate();
        出力条件.add(get条件(調定基準日, 基準日.wareki().toDateString()));
        出力条件.add(get条件(各月資格基準日, mybatisPrm.getKakutukiShikakuKijunNichi()));
        出力条件.add(get条件(年齢開始, mybatisPrm.getAgeStart()));
        出力条件.add(get条件(年齢終了, mybatisPrm.getAgeEnd()));
        出力条件.add(get条件(年齢基準日, mybatisPrm.getAgeKijunNi().wareki().toDateString()));
        FlexibleDate 開始生年月日 = new FlexibleDate(mybatisPrm.getSeinengappiYMDStart());
        FlexibleDate 終了生年月日 = new FlexibleDate(mybatisPrm.getSeinengappiYMDEnd());
        出力条件.add(get条件(生年月日開始, 開始生年月日.wareki().toDateString()));
        出力条件.add(get条件(生年月日終了, 終了生年月日.wareki().toDateString()));
        出力条件.add(get条件(選択対象, mybatisPrm.getSentakuTaisho()));
        RStringBuilder 市町村コード_名 = new RStringBuilder();
        市町村コード_名.append(mybatisPrm.getShichosonCode());
        市町村コード_名.append(" ");
        市町村コード_名.append(mybatisPrm.getShichosonMeisho());
        出力条件.add(get条件(市町村, 市町村コード_名.toRString()));
        return 出力条件;
    }

    private RString get条件(RString バッチパラメータ名, RString 値) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append("【");
        条件.append(バッチパラメータ名);
        条件.append("】");
        条件.append(値);
        return 条件.toRString();
    }

    private List<HihokenshaDaichoPsm> get資格状況のデータ() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        CreateTsukibetsuSuiihyoMyBatisParameter parameter
                = CreateTsukibetsuSuiihyoMyBatisParameter.create_被保険者台帳管理と宛名のデータ(
                        mybatisPrm.getChoteiNendo(), mybatisPrm.isAgeFlg(), mybatisPrm.getAgeStart(), mybatisPrm.getAgeEnd(),
                        mybatisPrm.getAgeKijunNi(), mybatisPrm.isSeinengappiYMDFlg(), mybatisPrm.getSeinengappiYMDStart(),
                        mybatisPrm.getSeinengappiYMDEnd(), mybatisPrm.getSentakuTaisho(), mybatisPrm.getSentakuKekkaList(),
                        mybatisPrm.getShichosonCode(), mybatisPrm.getKyuShichosonCode(),
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        return iCreateTsukibetsuSuiihyoMapper.get被保険者台帳管理と宛名のデータ(parameter);
    }

    private void 資格状況一時テーブル() {
        iCreateTsukibetsuSuiihyoMapper.createTmpSikakuJyoukyou_Ichi();
        List<HihokenshaDaichoPsm> list = get資格状況のデータ();
        for (HihokenshaDaichoPsm psm : list) {
            iCreateTsukibetsuSuiihyoMapper.insertTmpSikakuJyoukyou_Ichi(psm);
        }
    }

    private void set各月資格有無の判断() {
        資格状況一時テーブル();
        List<HihokenshaDaichoPsm> list = iCreateTsukibetsuSuiihyoMapper.get各月資格の取得();
        iCreateTsukibetsuSuiihyoMapper.dellertTmpSikakuJyoukyou_Ichi();
        for (HihokenshaDaichoPsm psm : list) {
            psm.setYoGetuSikakuumuFlg(get各月資格有無の判断(四月, psm));
            psm.setGoGetuSikakuumuFlg(get各月資格有無の判断(五月, psm));
            psm.setRokuGetuSikakuumuFlg(get各月資格有無の判断(六月, psm));
            psm.setNanaGetuSikakuumuFlg(get各月資格有無の判断(七月, psm));
            psm.setHatiGetuSikakuumuFlg(get各月資格有無の判断(八月, psm));
            psm.setKyuGetuSikakuumuFlg(get各月資格有無の判断(九月, psm));
            psm.setJyuGetuSikakuumuFlg(get各月資格有無の判断(十月, psm));
            psm.setJyuitiGetuSikakuumuFlg(get各月資格有無の判断(十一月, psm));
            psm.setJyuniGetuSikakuumuFlg(get各月資格有無の判断(十二月, psm));
            psm.setItiGetuSikakuumuFlg(get各月資格有無の判断(一月, psm));
            psm.setNiGetuSikakuumuFlg(get各月資格有無の判断(二月, psm));
            psm.setSanGetuSikakuumuFlg(get各月資格有無の判断(三月, psm));
            iCreateTsukibetsuSuiihyoMapper.insertTmpSikakuJyoukyou_Ichi(psm);
        }
    }

    private boolean get各月資格有無の判断(RString getu, HihokenshaDaichoPsm psm) {
        FlexibleDate 資格判断基準日;
        StringBuilder builder = new StringBuilder();
        builder.append(mybatisPrm.getChoteiNendo());
        builder.append(getu);
        builder.append(mybatisPrm.getKakutukiShikakuKijunNichi());
        資格判断基準日 = new FlexibleDate(builder.toString());
        return psm.getIchigoShikakuShutokuYMD().isBeforeOrEquals(資格判断基準日)
                && (psm.getShikakuSoshitsuYMD() == null || psm.getShikakuSoshitsuYMD().isEmpty()
                || 資格判断基準日.isBefore(psm.getShikakuSoshitsuYMD()));
    }

    private List<GennendoDate> get現年度データ() {
        List<GennendoDate> gennendoList = new ArrayList<>();
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_現年度データの取得(mybatisPrm.getChoteiNendo(), mybatisPrm.getChoteiKijunNichiji());
        List<GennendoDate> list = iCreateTsukibetsuSuiihyoMapper.get現年度データの取得(parameter);
        iCreateTsukibetsuSuiihyoMapper.createTmpKayigoJyoho_Ichi();
        for (GennendoDate gennendoDate : list) {
            gennendoDate.setGetu(get期に対する月の設定(gennendoDate));
            if (普通徴収.equals(gennendoDate.getChoshuHouhou())) {
                FuchoKiUtil fuchoKiUtil = new FuchoKiUtil();
                Kitsuki kitsuki = fuchoKiUtil.get期月リスト().get最終法定納期();
                if (get期に対する月の設定(gennendoDate).equals(kitsuki.get期())) {
                    gennendoDate.setGetu(new RString("随"));
                }
            }
            iCreateTsukibetsuSuiihyoMapper.insertTmpKayigoJyoho_Ichi(gennendoDate);
            gennendoList.add(gennendoDate);
        }
        return gennendoList;
    }

    private RString get期に対する月の設定(GennendoDate gennendoDate) {
        List<Kitsuki> itsukiList = new ArrayList<>();
        if (普通徴収.equals(gennendoDate.getChoshuHouhou())) {
            FuchoKiUtil fuchoKiUtil = new FuchoKiUtil();
            itsukiList = fuchoKiUtil.get期月リスト().get期の月(gennendoDate.getKi());
        }
        if (特別徴収.equals(gennendoDate.getChoshuHouhou())) {
            TokuchoKiUtil tokuchoKiUtil = new TokuchoKiUtil();
            itsukiList = tokuchoKiUtil.get期月リスト().get期の月(gennendoDate.getKi());
        }
        return itsukiList.get(0).get月().getコード();
    }

    private void 過年度のデータの取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_過年度のデータの取得(mybatisPrm.getChoteiNendo(), mybatisPrm.getChoteiKijunNichiji());
        List<GennendoDate> list = iCreateTsukibetsuSuiihyoMapper.get過年度のデータの取得(parameter);
        for (GennendoDate gennendoDate : list) {
            gennendoDate.setGetu(RString.EMPTY);
            iCreateTsukibetsuSuiihyoMapper.insertTmpKayigoJyoho_Ichi(gennendoDate);
        }
    }

    private void 不明のデータの取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_不明のデータの取得(mybatisPrm.getChoteiNendo(), mybatisPrm.getChoteiKijunNichiji());
        List<GennendoDate> list = iCreateTsukibetsuSuiihyoMapper.get不明のデータの取得(parameter);
        for (GennendoDate gennendoDate : list) {
            gennendoDate.setGetu(get期に対する月の設定(gennendoDate));
            gennendoDate.setDankaiFumeyiFlg(true);
            iCreateTsukibetsuSuiihyoMapper.insertTmpKayigoJyoho_Ichi(gennendoDate);
        }
    }

    private void 減免部分のデータの取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_過年度のデータの取得(mybatisPrm.getChoteiNendo(), mybatisPrm.getChoteiKijunNichiji());
        List<GennendoDate> list = iCreateTsukibetsuSuiihyoMapper.get減免部分のデータの取得(parameter);
        for (GennendoDate gennendoDate : list) {
            iCreateTsukibetsuSuiihyoMapper.insertTmpKayigoJyoho_Ichi(gennendoDate);
        }
    }

    private List<NinsuKinkaku> get4月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get4月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get5月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get5月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get6月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get6月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get7月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get7月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get8月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get8月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get9月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get9月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get10月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get10月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get11月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get11月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get12月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get12月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get1月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get1月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get2月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get2月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get3月の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get3月の人数金額(parameter);
    }

    private List<NinsuKinkaku> get現年随時の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get現年随時の人数金額(parameter);
    }

    private List<NinsuKinkaku> get過年度の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_過年度人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get過年度の人数金額(parameter);
    }

    private List<NinsuKinkaku> get特別徴収歳出還付の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get特別徴収歳出還付の人数金額(parameter);
    }

    private List<NinsuKinkaku> get普通徴収歳出還付の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get普通徴収歳出還付の人数金額(parameter);
    }

    private List<NinsuKinkaku> get不明の人数金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_4月人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get不明の人数と金額(parameter);
    }

    private List<NinsuKinkaku> get減免部分の人数と金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_過年度人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get減免部分の人数と金額(parameter);
    }

    private List<NinsuKinkaku> get減免部分合計の人数と金額の取得() {
        CreateTsukibetsuSuiihyoMyBatisParameter parameter = CreateTsukibetsuSuiihyoMyBatisParameter
                .create_過年度人数と金額の取得(mybatisPrm.getChoteiNendo());
        return iCreateTsukibetsuSuiihyoMapper.get減免部分合計の人数と金額(parameter);
    }

    private void 減免部分の人数と金額の計算() {
        Map map1 = new HashMap();
        List<NinsuKinkaku> ninsuKinkakuList = get減免部分の人数と金額の取得();
        for (NinsuKinkaku ninsuKinkak : ninsuKinkakuList) {
            GemmenJyoho gemmenJyoho = new GemmenJyoho();
            gemmenJyoho.setChoteiNendo(ninsuKinkak.getChoteiNendo());
            gemmenJyoho.setFukaNendo(ninsuKinkak.getFukaNendo());
            gemmenJyoho.setHokenryoDankai(ninsuKinkak.getHokenryoDankai());
            gemmenJyoho.setHokenryoDankaiKanendoNinsu(getNinsuOrKinkakul(ninsuKinkak.getKanendoNinsu()));
            gemmenJyoho.setHoDankaiKanendoGemmenGaku(getNinsuOrKinkakul(ninsuKinkak.getKanendoGemmenGaku()));
            map1.put(getMapKey(ninsuKinkak), gemmenJyoho);
        }
        iCreateTsukibetsuSuiihyoMapper.createTmpGemmenJyoho_Ichi();
        List<NinsuKinkaku> ninsuKinkakulist = get減免部分合計の人数と金額の取得();
        for (NinsuKinkaku ninsuKinkak : ninsuKinkakulist) {
            RString key = getMapKey(ninsuKinkak);
            if (map1.containsKey(key)) {
                GemmenJyoho gemmenJyoho = (GemmenJyoho) map1.get(key);
                gemmenJyoho.setHoDankaiKanendoNinsuGoukeyi(getNinsuOrKinkakul(ninsuKinkak.getKanendoNinsu()));
                gemmenJyoho.setHoDankaiKanendoGemenGakuGoukei(getNinsuOrKinkakul(ninsuKinkak.getKanendoGemmenGaku()));
                map1.put(key, gemmenJyoho);
            } else {
                GemmenJyoho gemmenJyoho = new GemmenJyoho();
                gemmenJyoho.setChoteiNendo(ninsuKinkak.getChoteiNendo());
                gemmenJyoho.setFukaNendo(ninsuKinkak.getFukaNendo());
                gemmenJyoho.setHokenryoDankai(ninsuKinkak.getHokenryoDankai());
                gemmenJyoho.setHoDankaiKanendoNinsuGoukeyi(getNinsuOrKinkakul(ninsuKinkak.getKanendoNinsu()));
                gemmenJyoho.setHoDankaiKanendoGemenGakuGoukei(getNinsuOrKinkakul(ninsuKinkak.getKanendoGemmenGaku()));
                map1.put(key, gemmenJyoho);
            }
        }
        for (Object value : map1.values()) {
            GemmenJyoho gemmenJyoho = (GemmenJyoho) value;
            iCreateTsukibetsuSuiihyoMapper.insertTmpGemmenJyoho_Ichi(gemmenJyoho);
        }
        List<GemmenJyoho> gemmenJyoholist = iCreateTsukibetsuSuiihyoMapper.get該当段階の過年度の人数と金額合計();
        for (GemmenJyoho gemmenJyoho : gemmenJyoholist) {
            iCreateTsukibetsuSuiihyoMapper.insertTmpGemmenJyoho_Ichi(gemmenJyoho);
        }
        GemmenJyoho gemmenJyoho = iCreateTsukibetsuSuiihyoMapper.get減免部分過年度の人数合計と金額合計();
        gemmenJyoho.setHokenryoDankai(new RString("合計"));
        iCreateTsukibetsuSuiihyoMapper.insertTmpGemmenJyoho_Ichi(gemmenJyoho);
    }

    private void set項目小計() {
        set各月資格有無の判断();
        get現年度データ();
        過年度のデータの取得();
        不明のデータの取得();
        減免部分のデータの取得();
        KoumokuSyoukeyi koumokuSyoukeyi = new KoumokuSyoukeyi();
        iCreateTsukibetsuSuiihyoMapper.createTmpKoumokuSyoukeyi_Ichi();
        Map map = new HashMap();
        map = setすべて月の人数金額(map);
        for (Object value : map.values()) {
            NinsuKinkaku kinkaku = (NinsuKinkaku) value;
            koumokuSyoukeyi.setChoteiNendo(kinkaku.getChoteiNendo());
            koumokuSyoukeyi.setFukaNendo(kinkaku.getFukaNendo());
            koumokuSyoukeyi.setChoshuHouhou(kinkaku.getChoshuHouhou());
            koumokuSyoukeyi.setHokenryoDankai(kinkaku.getHokenryoDankai());
            koumokuSyoukeyi.setYoGetuKinkaku(kinkaku.getYoGetuNinsu());
            koumokuSyoukeyi.setYoGetuKinkaku(kinkaku.getYoGetuKinkaku());
            koumokuSyoukeyi.setGoGetuNinsu(getNinsuOrKinkakul(kinkaku.getGoGetuNinsu()));
            koumokuSyoukeyi.setGoGetuKinkaku(getNinsuOrKinkakul(kinkaku.getGoGetuKinkaku()));
            koumokuSyoukeyi.setRokuGetuNinsu(getNinsuOrKinkakul(kinkaku.getRokuGetuNinsu()));
            koumokuSyoukeyi.setRokuGetuKinkaku(getNinsuOrKinkakul(kinkaku.getRokuGetuKinkaku()));
            koumokuSyoukeyi.setNanaGetuNinsu(getNinsuOrKinkakul(kinkaku.getNanaGetuNinsu()));
            koumokuSyoukeyi.setNanaGetuKinkaku(getNinsuOrKinkakul(kinkaku.getNanaGetuKinkaku()));
            koumokuSyoukeyi.setHatiGetuKinkaku(getNinsuOrKinkakul(kinkaku.getHatiGetuNinsu()));
            koumokuSyoukeyi.setHatiGetuKinkaku(getNinsuOrKinkakul(kinkaku.getHatiGetuKinkaku()));
            koumokuSyoukeyi.setKyuGetuNinsu(getNinsuOrKinkakul(kinkaku.getKyuGetuNinsu()));
            koumokuSyoukeyi.setKyuGetuKinkaku(getNinsuOrKinkakul(kinkaku.getKyuGetuKinkaku()));
            koumokuSyoukeyi.setJyuGetuNinsu(getNinsuOrKinkakul(kinkaku.getJyuGetuNinsu()));
            koumokuSyoukeyi.setJyuGetuKinkaku(getNinsuOrKinkakul(kinkaku.getJyuGetuKinkaku()));
            koumokuSyoukeyi.setJyuitiGetuNinsu(getNinsuOrKinkakul(kinkaku.getJyuitiGetuNinsu()));
            koumokuSyoukeyi.setJyuitiGetuKinkaku(getNinsuOrKinkakul(kinkaku.getJyuitiGetuKinkaku()));
            koumokuSyoukeyi.setJyuniGetuNinsu(getNinsuOrKinkakul(kinkaku.getJyuniGetuNinsu()));
            koumokuSyoukeyi.setJyuniGetuKinkaku(getNinsuOrKinkakul(kinkaku.getJyuniGetuKinkaku()));
            koumokuSyoukeyi.setItiGetuNinsu(getNinsuOrKinkakul(kinkaku.getItiGetuNinsu()));
            koumokuSyoukeyi.setItiGetuKinkaku(getNinsuOrKinkakul(kinkaku.getItiGetuKinkaku()));
            koumokuSyoukeyi.setNiGetuNinsu(getNinsuOrKinkakul(kinkaku.getNiGetuNinsu()));
            koumokuSyoukeyi.setNiGetuKinkaku(getNinsuOrKinkakul(kinkaku.getNiGetuKinkaku()));
            koumokuSyoukeyi.setSanGetuNinsu(getNinsuOrKinkakul(kinkaku.getSanGetuNinsu()));
            koumokuSyoukeyi.setSanGetuKinkaku(getNinsuOrKinkakul(kinkaku.getSanGetuKinkaku()));
            koumokuSyoukeyi.setGennenSuyijiNinsu(getNinsuOrKinkakul(kinkaku.getGennenSuyijiNinsu()));
            koumokuSyoukeyi.setGennenSuyijiKinkaku(getNinsuOrKinkakul(kinkaku.getGennenSuyijiKinkaku()));
            koumokuSyoukeyi.setKanendoNinsu(getNinsuOrKinkakul(kinkaku.getKanendoNinsu()));
            koumokuSyoukeyi.setKanendoKinkaku(getNinsuOrKinkakul(kinkaku.getKanendoKinkaku()));
            koumokuSyoukeyi.setSayisyutuKanpuNinsu(getNinsuOrKinkakul(kinkaku.getSayisyutuKanpuNinsu()));
            koumokuSyoukeyi.setSayisyutuKanpuKinkaku(getNinsuOrKinkakul(kinkaku.getSayisyutuKanpuKinkaku()));
            iCreateTsukibetsuSuiihyoMapper.insertTmpKoumokuSyoukeyi_Ichi(koumokuSyoukeyi);
        }
    }

    private Map setすべて月の人数金額(Map map) {
        for (int i = 0; i < get4月の人数金額の取得().size(); i++) {
            map.put(getMapKey(get4月の人数金額の取得().get(i)), get4月の人数金額の取得().get(i));
        }
        for (int i = 0; i < get5月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get5月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setGoGetuNinsu(getNinsuOrKinkakul(get5月の人数金額の取得().get(i).getGoGetuNinsu()));
                ninsuKinkaku.setGoGetuKinkaku(getNinsuOrKinkakul(get5月の人数金額の取得().get(i).getGoGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get5月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get6月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get6月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setRokuGetuNinsu(getNinsuOrKinkakul(get6月の人数金額の取得().get(i).getRokuGetuNinsu()));
                ninsuKinkaku.setRokuGetuKinkaku(getNinsuOrKinkakul(get6月の人数金額の取得().get(i).getRokuGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get6月の人数金額の取得().get(i));
            }
        }
        map = set7_3月の人数金額(map);
        for (int i = 0; i < get現年随時の人数金額の取得().size(); i++) {
            RString key = getMapKey(get現年随時の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setGennenSuyijiNinsu(getNinsuOrKinkakul(get現年随時の人数金額の取得().get(i).getGennenSuyijiNinsu()));
                ninsuKinkaku.setGennenSuyijiKinkaku(getNinsuOrKinkakul(get現年随時の人数金額の取得().get(i).getGennenSuyijiKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get現年随時の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get過年度の人数金額の取得().size(); i++) {
            RString key = getMapKey(get過年度の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setKanendoNinsu(getNinsuOrKinkakul(get過年度の人数金額の取得().get(i).getKanendoNinsu()));
                ninsuKinkaku.setKanendoKinkaku(getNinsuOrKinkakul(get過年度の人数金額の取得().get(i).getKanendoKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get過年度の人数金額の取得().get(i));
            }
        }
        map = set歳出還付と不明の人数金額(map);
        return map;
    }

    private Map set7_3月の人数金額(Map map) {
        for (int i = 0; i < get7月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get7月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setNanaGetuNinsu(getNinsuOrKinkakul(get7月の人数金額の取得().get(i).getNanaGetuNinsu()));
                ninsuKinkaku.setNanaGetuKinkaku(getNinsuOrKinkakul(get7月の人数金額の取得().get(i).getNanaGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get7月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get8月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get8月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setHatiGetuNinsu(getNinsuOrKinkakul(get8月の人数金額の取得().get(i).getHatiGetuNinsu()));
                ninsuKinkaku.setHatiGetuKinkaku(getNinsuOrKinkakul(get8月の人数金額の取得().get(i).getHatiGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get8月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get9月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get9月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setKyuGetuNinsu(getNinsuOrKinkakul(get9月の人数金額の取得().get(i).getKyuGetuNinsu()));
                ninsuKinkaku.setKyuGetuKinkaku(getNinsuOrKinkakul(get9月の人数金額の取得().get(i).getKyuGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get9月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get10月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get10月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setJyuGetuNinsu(getNinsuOrKinkakul(get10月の人数金額の取得().get(i).getJyuGetuNinsu()));
                ninsuKinkaku.setJyuGetuKinkaku(getNinsuOrKinkakul(get10月の人数金額の取得().get(i).getJyuGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get10月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get11月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get11月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setJyuitiGetuNinsu(getNinsuOrKinkakul(get11月の人数金額の取得().get(i).getJyuitiGetuNinsu()));
                ninsuKinkaku.setJyuitiGetuKinkaku(getNinsuOrKinkakul(get11月の人数金額の取得().get(i).getJyuitiGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get11月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get12月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get12月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setJyuniGetuNinsu(getNinsuOrKinkakul(get12月の人数金額の取得().get(i).getJyuniGetuNinsu()));
                ninsuKinkaku.setJyuniGetuKinkaku(getNinsuOrKinkakul(get12月の人数金額の取得().get(i).getJyuniGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get12月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get1月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get1月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setItiGetuNinsu(getNinsuOrKinkakul(get1月の人数金額の取得().get(i).getItiGetuNinsu()));
                ninsuKinkaku.setItiGetuKinkaku(getNinsuOrKinkakul(get1月の人数金額の取得().get(i).getItiGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get1月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get2月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get2月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setNiGetuNinsu(getNinsuOrKinkakul(get2月の人数金額の取得().get(i).getNiGetuNinsu()));
                ninsuKinkaku.setNiGetuKinkaku(getNinsuOrKinkakul(get2月の人数金額の取得().get(i).getNiGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get2月の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get3月の人数金額の取得().size(); i++) {
            RString key = getMapKey(get3月の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setSanGetuNinsu(getNinsuOrKinkakul(get3月の人数金額の取得().get(i).getSanGetuNinsu()));
                ninsuKinkaku.setSanGetuKinkaku(getNinsuOrKinkakul(get3月の人数金額の取得().get(i).getSanGetuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get3月の人数金額の取得().get(i));
            }
        }
        return map;
    }

    private Map set歳出還付と不明の人数金額(Map map) {
        for (int i = 0; i < get特別徴収歳出還付の人数金額の取得().size(); i++) {
            RString key = getMapKey(get特別徴収歳出還付の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setSayisyutuKanpuNinsu(getNinsuOrKinkakul(get特別徴収歳出還付の人数金額の取得().get(i).getSayisyutuKanpuNinsu()));
                ninsuKinkaku.setSayisyutuKanpuKinkaku(getNinsuOrKinkakul(get特別徴収歳出還付の人数金額の取得().get(i).getSayisyutuKanpuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get特別徴収歳出還付の人数金額の取得().get(i));
            }
        }
        for (int i = 0; i < get普通徴収歳出還付の人数金額の取得().size(); i++) {
            RString key = getMapKey(get普通徴収歳出還付の人数金額の取得().get(i));
            if (map.containsKey(key)) {
                NinsuKinkaku ninsuKinkaku = (NinsuKinkaku) map.get(key);
                ninsuKinkaku.setSayisyutuKanpuNinsu(getNinsuOrKinkakul(get普通徴収歳出還付の人数金額の取得().get(i).getSayisyutuKanpuNinsu()));
                ninsuKinkaku.setSayisyutuKanpuKinkaku(getNinsuOrKinkakul(get普通徴収歳出還付の人数金額の取得().get(i).getSayisyutuKanpuKinkaku()));
                map.put(key, ninsuKinkaku);
            } else {
                map.put(key, get普通徴収歳出還付の人数金額の取得().get(i));
            }
        }
        NinsuKinkaku ninsuKinkaku = new NinsuKinkaku();
        for (int i = 0; i < get不明の人数金額の取得().size(); i++) {
            ninsuKinkaku.setChoteiNendo(get不明の人数金額の取得().get(i).getChoteiNendo());
            ninsuKinkaku.setFukaNendo(get不明の人数金額の取得().get(i).getFukaNendo());
            ninsuKinkaku.setChoshuHouhou(get不明の人数金額の取得().get(i).getChoshuHouhou());
            ninsuKinkaku.setHokenryoDankai(new RString("不明"));
            if (四月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setYoGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setYoGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (五月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setGoGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setGoGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (六月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setRokuGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setRokuGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (七月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setNanaGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setNanaGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (八月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setHatiGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setHatiGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (九月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setKyuGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setKyuGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (十月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setJyuGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setJyuGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (十一月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setJyuitiGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setJyuitiGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (十二月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setJyuniGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setJyuniGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (一月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setItiGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setItiGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (二月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setNiGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setNiGetuNinsu(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            } else if (三月.equals(get不明の人数金額の取得().get(i).getGetu())) {
                ninsuKinkaku.setSanGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeNinsu()));
                ninsuKinkaku.setSanGetuKinkaku(getNinsuOrKinkakul(get不明の人数金額の取得().get(i).getFumeKinkaku()));
            }
        }
        map.put(getMapKey(ninsuKinkaku), ninsuKinkaku);
        return map;
    }

    private Decimal getNinsuOrKinkakul(Decimal ninsuOrKinkaku) {
        return ninsuOrKinkaku == null ? new Decimal(0) : ninsuOrKinkaku;
    }

    private RString getMapKey(NinsuKinkaku ninsuKinkaku) {
        StringBuilder key = new StringBuilder();
        key.append(ninsuKinkaku.getChoteiNendo());
        key.append(ninsuKinkaku.getFukaNendo());
        key.append(ninsuKinkaku.getChoshuHouhou());
        key.append(ninsuKinkaku.getHokenryoDankai());
        return new RString(key.toString());
    }

    private void データ合計() {
        set項目小計();
        減免部分の人数と金額の計算();
        List<KoumokuSyoukeyi> list = iCreateTsukibetsuSuiihyoMapper.get項目小計一時テーブルデータの取得();
        iCreateTsukibetsuSuiihyoMapper.createTmpKoumokuGoukey_Ichi();
        for (KoumokuSyoukeyi koumokuSyoukeyi : list) {
            if (koumokuSyoukeyi != null) {
                GokeiChi gokeiChi = new GokeiChi();
                gokeiChi.setChoshuHouhou(koumokuSyoukeyi.getChoshuHouhou());
                gokeiChi.setHokenryoDankai(koumokuSyoukeyi.getHokenryoDankai());
                gokeiChi.setYoGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getYoGetuNinsu()));
                gokeiChi.setYoGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getYoGetuKinkaku()));
                gokeiChi.setGoGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getGoGetuNinsu()));
                gokeiChi.setGoGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getGoGetuKinkaku()));
                gokeiChi.setRokuGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getRokuGetuNinsu()));
                gokeiChi.setRokuGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getRokuGetuKinkaku()));
                gokeiChi.setNanaGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getNanaGetuNinsu()));
                gokeiChi.setNanaGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getNanaGetuKinkaku()));
                gokeiChi.setHatiGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getHatiGetuNinsu()));
                gokeiChi.setHatiGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getHatiGetuKinkaku()));
                gokeiChi.setKyuGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getKyuGetuNinsu()));
                gokeiChi.setKyuGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getKyuGetuKinkaku()));
                gokeiChi.setJyuGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuGetuNinsu()));
                gokeiChi.setJyuGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuGetuKinkaku()));
                gokeiChi.setJyuitiGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuitiGetuNinsu()));
                gokeiChi.setJyuitiGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuitiGetuKinkaku()));
                gokeiChi.setJyuniGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuniGetuNinsu()));
                gokeiChi.setJyuniGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuniGetuKinkaku()));
                gokeiChi.setItiGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getItiGetuNinsu()));
                gokeiChi.setItiGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getItiGetuKinkaku()));
                gokeiChi.setNiGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getNiGetuNinsu()));
                gokeiChi.setNiGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getNiGetuKinkaku()));
                gokeiChi.setSanGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getSanGetuNinsu()));
                gokeiChi.setSanGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getSanGetuKinkaku()));
                gokeiChi.set現年随時の人数合計(getNinsuOrKinkakul(koumokuSyoukeyi.getGennenSuyijiNinsu()));
                gokeiChi.set現年随時の金額合計(getNinsuOrKinkakul(koumokuSyoukeyi.getGennenSuyijiKinkaku()));
                gokeiChi.set過年度の人数合計(getNinsuOrKinkakul(koumokuSyoukeyi.getKanendoNinsu()));
                gokeiChi.set過年度の金額合計(getNinsuOrKinkakul(koumokuSyoukeyi.getKanendoKinkaku()));
                gokeiChi.set歳出還付の人数合計(getNinsuOrKinkakul(koumokuSyoukeyi.getSayisyutuKanpuNinsu()));
                gokeiChi.set歳出還付の金額合計(getNinsuOrKinkakul(koumokuSyoukeyi.getSayisyutuKanpuKinkaku()));
                gokeiChi.set該当段階の人数合計(get該当段階の人数合計(koumokuSyoukeyi));
                gokeiChi.set該当段階の金額合計(get該当段階の金額合計(koumokuSyoukeyi));
                iCreateTsukibetsuSuiihyoMapper.insertTmpKoumokuGoukey_Ichi(gokeiChi);
            }
        }
        List<KoumokuSyoukeyi> koumokuSyoukeyiList = iCreateTsukibetsuSuiihyoMapper.get項目小計一時テーブル合計データの取得();
        for (KoumokuSyoukeyi koumokuSyoukeyi : koumokuSyoukeyiList) {
            if (koumokuSyoukeyi != null) {
                GokeiChi gokeiChi = new GokeiChi();
                gokeiChi.setChoshuHouhou(koumokuSyoukeyi.getChoshuHouhou());
                gokeiChi.setHokenryoDankai(new RString("合計"));
                gokeiChi.setYoGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getYoGetuNinsu()));
                gokeiChi.setYoGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getYoGetuKinkaku()));
                gokeiChi.setGoGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getGoGetuNinsu()));
                gokeiChi.setGoGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getGoGetuKinkaku()));
                gokeiChi.setRokuGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getRokuGetuNinsu()));
                gokeiChi.setRokuGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getRokuGetuKinkaku()));
                gokeiChi.setNanaGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getNanaGetuNinsu()));
                gokeiChi.setNanaGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getNanaGetuKinkaku()));
                gokeiChi.setHatiGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getHatiGetuNinsu()));
                gokeiChi.setHatiGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getHatiGetuKinkaku()));
                gokeiChi.setKyuGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getKyuGetuNinsu()));
                gokeiChi.setKyuGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getKyuGetuKinkaku()));
                gokeiChi.setJyuGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuGetuNinsu()));
                gokeiChi.setJyuGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuGetuKinkaku()));
                gokeiChi.setJyuitiGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuitiGetuNinsu()));
                gokeiChi.setJyuitiGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuitiGetuKinkaku()));
                gokeiChi.setJyuniGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuniGetuNinsu()));
                gokeiChi.setJyuniGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getJyuniGetuKinkaku()));
                gokeiChi.setItiGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getItiGetuNinsu()));
                gokeiChi.setItiGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getItiGetuKinkaku()));
                gokeiChi.setNiGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getNiGetuNinsu()));
                gokeiChi.setNiGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getNiGetuKinkaku()));
                gokeiChi.setSanGetuNinsuuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getSanGetuNinsu()));
                gokeiChi.setSanGetuKinkakuGoukeyi(getNinsuOrKinkakul(koumokuSyoukeyi.getSanGetuKinkaku()));
                gokeiChi.set現年随時の人数合計(getNinsuOrKinkakul(koumokuSyoukeyi.getGennenSuyijiNinsu()));
                gokeiChi.set現年随時の金額合計(getNinsuOrKinkakul(koumokuSyoukeyi.getGennenSuyijiKinkaku()));
                gokeiChi.set過年度の人数合計(getNinsuOrKinkakul(koumokuSyoukeyi.getKanendoNinsu()));
                gokeiChi.set過年度の金額合計(getNinsuOrKinkakul(koumokuSyoukeyi.getKanendoKinkaku()));
                gokeiChi.set歳出還付の人数合計(getNinsuOrKinkakul(koumokuSyoukeyi.getSayisyutuKanpuNinsu()));
                gokeiChi.set歳出還付の金額合計(getNinsuOrKinkakul(koumokuSyoukeyi.getSayisyutuKanpuKinkaku()));
                gokeiChi.set該当段階の人数合計(get該当段階の人数合計(koumokuSyoukeyi));
                gokeiChi.set該当段階の金額合計(get該当段階の金額合計(koumokuSyoukeyi));
                iCreateTsukibetsuSuiihyoMapper.insertTmpKoumokuGoukey_Ichi(gokeiChi);
            }
        }
    }

    private int chickNull(Decimal ninsuOrKinkaku) {
        return ninsuOrKinkaku == null ? 0 : ninsuOrKinkaku.intValue();
    }

    private Decimal get該当段階の人数合計(KoumokuSyoukeyi koumokuSyoukeyi) {
        return new Decimal(chickNull(koumokuSyoukeyi.getYoGetuNinsu()) + chickNull(koumokuSyoukeyi.getGoGetuNinsu())
                + chickNull(koumokuSyoukeyi.getRokuGetuNinsu()) + chickNull(koumokuSyoukeyi.getNanaGetuNinsu())
                + chickNull(koumokuSyoukeyi.getHatiGetuNinsu()) + chickNull(koumokuSyoukeyi.getKyuGetuNinsu())
                + chickNull(koumokuSyoukeyi.getJyuGetuNinsu()) + chickNull(koumokuSyoukeyi.getJyuitiGetuNinsu())
                + chickNull(koumokuSyoukeyi.getJyuniGetuNinsu()) + chickNull(koumokuSyoukeyi.getItiGetuNinsu())
                + chickNull(koumokuSyoukeyi.getNiGetuNinsu()) + chickNull(koumokuSyoukeyi.getSanGetuNinsu())
                + chickNull(koumokuSyoukeyi.getGennenSuyijiNinsu()) + chickNull(koumokuSyoukeyi.getKanendoNinsu()));
    }

    private Decimal get該当段階の金額合計(KoumokuSyoukeyi koumokuSyoukeyi) {
        return new Decimal(chickNull(koumokuSyoukeyi.getYoGetuNinsu()) + chickNull(koumokuSyoukeyi.getGoGetuNinsu())
                + chickNull(koumokuSyoukeyi.getRokuGetuNinsu()) + chickNull(koumokuSyoukeyi.getNanaGetuNinsu())
                + chickNull(koumokuSyoukeyi.getHatiGetuNinsu()) + chickNull(koumokuSyoukeyi.getKyuGetuNinsu())
                + chickNull(koumokuSyoukeyi.getJyuGetuNinsu()) + chickNull(koumokuSyoukeyi.getJyuitiGetuNinsu())
                + chickNull(koumokuSyoukeyi.getJyuniGetuNinsu()) + chickNull(koumokuSyoukeyi.getItiGetuNinsu())
                + chickNull(koumokuSyoukeyi.getNiGetuNinsu()) + chickNull(koumokuSyoukeyi.getSanGetuNinsu())
                + chickNull(koumokuSyoukeyi.getGennenSuyijiNinsu()) + chickNull(koumokuSyoukeyi.getKanendoNinsu()));
    }

    private void get合計部分の項目() {
        データ合計();
        List<KoumokuGoukey> list = iCreateTsukibetsuSuiihyoMapper.get項目合計一時テーブルデータの取得();
        iCreateTsukibetsuSuiihyoMapper.createTmpGokeyBubunKoumoku_Ichi();
        for (KoumokuGoukey koumokuGoukey : list) {
            iCreateTsukibetsuSuiihyoMapper.insertTmpGokeyBubunKoumoku_Ichi(koumokuGoukey);
        }
        KoumokuGoukey koumokuGoukey = iCreateTsukibetsuSuiihyoMapper.get項目合計一時テーブル合計データの取得();
        koumokuGoukey.setHokenryoDankai(new RString("合計"));
        iCreateTsukibetsuSuiihyoMapper.insertTmpGokeyBubunKoumoku_Ichi(koumokuGoukey);
    }
}
