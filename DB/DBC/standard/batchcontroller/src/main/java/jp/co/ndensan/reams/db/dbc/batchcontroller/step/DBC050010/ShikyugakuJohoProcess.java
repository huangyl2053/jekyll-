/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.furikomimeisaifurikomidata.FurikomiMeisaiYoshikiBetsuKingakuShukei;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200101detail.FurikomiMeisaiIchiranDetailReport;
import jp.co.ndensan.reams.db.dbc.definition.core.chohyoseigyohanyo.ChohyoSeigyoHanyoKomokuMei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekiyoshikikubun.KyufuJissekiYoshikiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno.NyuryokuShikibetsuNoShokan3Keta;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.ShikyugakuJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.ShikyugakuJohoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.InjiYoushikiBangouBetuKingaku;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShikyugakuJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.YoshikiNoJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.gokeidata.GokeiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.meisaidata.MeisaiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.meisaidata.PrintNoKingakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200101detail.FurikomiMeisaiIchiranDetailReportSource;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010.IShikyugakuJohoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.shikyugakujohomanager.ShikyugakuJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 振込明細一覧表作成_Processクラスです．
 *
 * @reamsid_L DBC-2180-030 tianyh
 */
public class ShikyugakuJohoProcess extends BatchProcessBase<ShikyugakuJohoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010."
                    + "IShikyugakuJohoMapper.select様式番号別支給金額情報");
    private static final RString 処理結果確認リスト一時TBL = new RString("DbWT0512ShoriKekkaKakuninList");
    private ShikyugakuJohoMybatisParameter データの取得Parameter;
    private ShikyugakuJohoProcessParameter parameter;
    private List<YoshikiNoJohoEntity> 様式番号名称;
    private List<GokeiDataEntity> 振込明細一覧表合計;
    private Map<RString, RString> 様式名称MAP;
    private IOutputOrder outputOrder;
    private RString orderBy = RString.EMPTY;
    private RString 設定値;
    private RString 項目名;
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final ReportId 帳票分類ID = new ReportId("DBC200100_FurikomiMeisaiIchiran");
    private final RString 処理区分3 = new RString("3");
    private final RString 処理区分2 = new RString("2");
    private final RString 処理区分1 = new RString("1");
    private final RString 識別番号2131 = new RString("2131");
    private final RString 識別番号2141 = new RString("2141");
    private final RString 識別番号2151 = new RString("2151");
    private final RString 識別番号2161 = new RString("2161");
    private final RString 識別番号2171 = new RString("2171");
    private final RString 識別番号21B1 = new RString("21B1");
    private final RString 識別番号2181 = new RString("2181");
    private final RString 識別番号2191 = new RString("2191");
    private final RString 識別番号21A1 = new RString("21A1");
    private final RString 識別番号21C1 = new RString("21C1");
    private final RString 識別番号21D1 = new RString("21D1");
    private final RString 償還計 = new RString("償還計");
    private final RString 要介護1 = new RString("21");
    private final RString 要介護2 = new RString("22");
    private final RString 要介護3 = new RString("23");
    private final RString 要介護4 = new RString("24");
    private final RString 要介護5 = new RString("25");
    private final RString 要支援 = new RString("11");
    private final RString 経過的要介護 = new RString("11");
    private final RString 要支援1 = new RString("12");
    private final RString 要支援2 = new RString("13");
    private static final int 区分 = 6;
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int NUM5 = 5;
    private static final int NUM6 = 6;
    private static final int NUM7 = 7;
    private static final int NUM8 = 8;
    private static final int NUM9 = 9;
    private static final int NUM10 = 10;
    private static final int NUM11 = 11;
    private static final int NUM12 = 12;
    private static final int NUM13 = 13;
    private int 様式連番 = 0;

    private OutputParameter<RString> outputPageCount;
    /**
     * 検索件数を返却
     */
    public static final RString PARAMETER_OUT_PAGE_COUNT;

    static {
        PARAMETER_OUT_PAGE_COUNT = new RString("outputPageCount");
    }

    @BatchWriter
    private BatchEntityCreatedTempTableWriter shoriKekkaKakuninListTempTable;
    @BatchWriter
    private BatchReportWriter<FurikomiMeisaiIchiranDetailReportSource> batchReportWriter_明細一覧表;
    private ReportSourceWriter<FurikomiMeisaiIchiranDetailReportSource> reportSourceWriter_明細一覧表;

    @Override
    protected void initialize() {
        outputPageCount = new OutputParameter<>();
        if (parameter.get支払方法().getコード().equals(Furikomi_ShihraiHohoShitei.口座.getコード())) {
            項目名 = ChohyoSeigyoHanyoKomokuMei.帳票タイトル_口座.get名称();
        } else {
            項目名 = ChohyoSeigyoHanyoKomokuMei.帳票タイトル_窓口.get名称();
        }
        設定値 = ShikyugakuJohoManager.createInstance().fetch設定値(帳票分類ID, 管理年度, 項目名);
        if (parameter.get出力順ID() != 0) {
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            long 帳票出力順ID = parameter.get出力順ID();
            outputOrder = finder.get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200101.getReportId(), 帳票出力順ID);
            if (outputOrder != null) {
                orderBy = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.
                        create(ShikyugakuJohoOrderKey.class, outputOrder).replace("order by", ","), NUM5);
            }
        }
        データの取得Parameter = new ShikyugakuJohoMybatisParameter(orderBy);
        IShikyugakuJohoMapper mapper = getMapper(IShikyugakuJohoMapper.class);
        様式番号名称 = mapper.select様式番号名称();
        様式名称MAP = new HashMap<>();
        for (YoshikiNoJohoEntity entiry : 様式番号名称) {
            様式名称MAP.put(entiry.get識別番号(), entiry.get名称２());
        }
        振込明細一覧表合計 = new ArrayList();
        for (int i = 0; i <= NUM13; i++) {
            GokeiDataEntity entity = new GokeiDataEntity();
            entity.setその他件数(Decimal.ZERO);
            entity.setその他金額(Decimal.ZERO);
            entity.set要介護件数(Decimal.ZERO);
            entity.set要介護金額(Decimal.ZERO);
            entity.set要支援件数(Decimal.ZERO);
            entity.set要支援金額(Decimal.ZERO);
            set振込明細様式名称(i, entity);
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, データの取得Parameter);
    }

    @Override
    protected void createWriter() {
        shoriKekkaKakuninListTempTable
                = new BatchEntityCreatedTempTableWriter(処理結果確認リスト一時TBL, ShoriKekkaKakuninListTempTableEntity.class);
        batchReportWriter_明細一覧表 = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200101.getReportId().value(), SubGyomuCode.DBC介護給付)
                .addBreak(new BreakerCatalog<FurikomiMeisaiIchiranDetailReportSource>().new SimpleLayoutBreaker(









                    FurikomiMeisaiIchiranDetailReportSource.LAYOUT_BREAK_KEYS) {
            @Override
                    public ReportLineRecord<FurikomiMeisaiIchiranDetailReportSource> occuredBreak(
                            ReportLineRecord<FurikomiMeisaiIchiranDetailReportSource> currentRecord,
                            ReportLineRecord<FurikomiMeisaiIchiranDetailReportSource> nextRecord,
                            ReportDynamicChart dynamicChart) {
                        int layout = currentRecord.getSource().layout.index();
                        currentRecord.setFormGroupIndex(layout);
                        if (nextRecord != null && nextRecord.getSource() != null) {
                            layout = nextRecord.getSource().layout.index();
                            nextRecord.setFormGroupIndex(layout);
                        }
                        return currentRecord;
                    }
                }).create();
        reportSourceWriter_明細一覧表 = new ReportSourceWriter<>(batchReportWriter_明細一覧表);
    }

    @Override
    protected void process(ShikyugakuJohoEntity t) {
        様式連番 = 0;
        RString 制度改正施行年月日
                = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_平成１８年０４月改正, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        FlexibleYearMonth 制度改正施行日 = new FlexibleYearMonth(制度改正施行年月日.substring(0, 区分));

        if (t.get様式番号別金額EntityList().isEmpty()) {
            t.set様式番号別金額EntityList(Collections.EMPTY_LIST);
        }
        if (t.get振込明細一時Entity().getDataKubun().equals(処理区分1)) {
            edit処理区分が1の場合_帳票データ作成(t, 制度改正施行日);
        } else if (t.get振込明細一時Entity().getDataKubun().equals(処理区分2)) {
            MeisaiDataEntity 振込明細一覧表明細 = new MeisaiDataEntity();
            振込明細一覧表明細.set振込明細一時TBL(t.get振込明細一時Entity());
            List<PrintNoKingakuEntity> 印字様式番号別金額List = new ArrayList<>();
            PrintNoKingakuEntity printNoKingakuEntity = new PrintNoKingakuEntity();
            printNoKingakuEntity.set様式連番(NUM1);
            printNoKingakuEntity.set印字様式名称(様式名称MAP.get(KyufuJissekiYoshikiKubun._3411_高額介護給付費.getコード()));
            printNoKingakuEntity.set集計様式番号(NyuryokuShikibetsuNoShokan3Keta.高額介護サービス.getコード());
            printNoKingakuEntity.set様式別集計金額(t.get振込明細一時Entity().getFurikomiKingaku());
            printNoKingakuEntity.set印字様式番号(KyufuJissekiYoshikiKubun._3411_高額介護給付費.getコード());
            printNoKingakuEntity.set名寄せ件数(t.get名寄せ件数());
            印字様式番号別金額List.add(printNoKingakuEntity);
            振込明細一覧表明細.set印字様式番号別金額List(印字様式番号別金額List);
            FurikomiMeisaiIchiranDetailReport report = new FurikomiMeisaiIchiranDetailReport(振込明細一覧表明細, null, outputOrder, parameter.get支払方法(),
                    RDateTime.now(), 設定値);
            report.writeBy(reportSourceWriter_明細一覧表);
            if (t.get振込明細一時Entity().getServiceTeikyoYM().isBefore(制度改正施行日)) {

                set認定状態区分before施行日高額(t.get振込明細一時Entity().getYokaigoJotaiKubunCode(),
                        振込明細一覧表合計.get(NUM12), t.get振込明細一時Entity().getFurikomiKingaku());
            } else {
                set認定状態区分after施行日高額(t.get振込明細一時Entity().getYokaigoJotaiKubunCode(),
                        振込明細一覧表合計.get(NUM12), t.get振込明細一時Entity().getFurikomiKingaku());
            }
        }
    }

    private void edit処理区分が1の場合_帳票データ作成(ShikyugakuJohoEntity t, FlexibleYearMonth 制度改正施行日) {
        boolean flag = false;
        FurikomiMeisaiYoshikiBetsuKingakuShukei bisness = new FurikomiMeisaiYoshikiBetsuKingakuShukei();
        List<InjiYoushikiBangouBetuKingaku> 印字様式番号別金額List = bisness.sumKingakuBy印字様式番号(t.get様式番号別金額EntityList());
        MeisaiDataEntity 振込明細一覧表明細 = new MeisaiDataEntity();
        List<PrintNoKingakuEntity> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < 印字様式番号別金額List.size(); i++) {
            InjiYoushikiBangouBetuKingaku 印字様式番号別金額 = 印字様式番号別金額List.get(i);
            様式連番++;

            if (1 == 様式連番) {
                振込明細一覧表明細.set振込明細一時TBL(t.get振込明細一時Entity());

                list.add(create印字様式番号別金額(t, 様式名称MAP, 印字様式番号別金額));
                振込明細一覧表明細.set印字様式番号別金額List(list);
                FurikomiMeisaiIchiranDetailReport report = new FurikomiMeisaiIchiranDetailReport(振込明細一覧表明細, null, outputOrder, parameter.get支払方法(),
                        RDateTime.now(), 設定値);
                report.writeBy(reportSourceWriter_明細一覧表);
                list.clear();
            } else {
                count++;
                list.add(create印字様式番号別金額(t, 様式名称MAP, 印字様式番号別金額));
                if (印字様式番号別金額List.size() % 2 == 0 && i == 印字様式番号別金額List.size() - 1) {
                    list.add(new PrintNoKingakuEntity());
                    count++;
                }

                振込明細一覧表明細.set印字様式番号別金額List(list);
                振込明細一覧表明細.set振込明細一時TBL(t.get振込明細一時Entity());
                if (2 == count) {
                    FurikomiMeisaiIchiranDetailReport report = new FurikomiMeisaiIchiranDetailReport(振込明細一覧表明細, null, outputOrder, parameter.get支払方法(),
                            RDateTime.now(), 設定値);
                    report.writeBy(reportSourceWriter_明細一覧表);
                    list.clear();
                    count = 0;
                }
            }

            flag = is支給金額計(t);

            if (t.get振込明細一時Entity().getServiceTeikyoYM().isBefore(制度改正施行日)) {
                set件数加算before制度改正施行日(t.get振込明細一時Entity().getYokaigoJotaiKubunCode(), flag, 印字様式番号別金額);
            } else {
                set件数加算after制度改正施行日(t.get振込明細一時Entity().getYokaigoJotaiKubunCode(), flag, 印字様式番号別金額);
            }
        }
    }

    private PrintNoKingakuEntity create印字様式番号別金額(ShikyugakuJohoEntity t, Map<RString, RString> 様式名称MAP,
            InjiYoushikiBangouBetuKingaku 印字様式番号別金額) {
        PrintNoKingakuEntity data = new PrintNoKingakuEntity();

        data.set様式連番(様式連番);
        data.set名寄せ件数(t.get名寄せ件数());
        data.set印字様式名称(様式名称MAP.get(印字様式番号別金額.get印字様式番号()));
        data.set集計様式番号(印字様式番号別金額.get集計様式番号());

        data.set印字様式番号(印字様式番号別金額.get印字様式番号());
        if (t.get振込明細一時Entity().getSagakuKingakuGokei().intValue() == 0) {
            data.set様式別集計金額(印字様式番号別金額.get支給金額計());
        } else {
            data.set様式別集計金額(印字様式番号別金額.get差額金額計());
        }
        return data;
    }

    private boolean is支給金額計(ShikyugakuJohoEntity t) {
        return 0 == t.get振込明細一時Entity().getSagakuKingakuGokei().intValue();
    }

    @Override
    protected void afterExecute() {
        outputPageCount.setValue(new RString(batchReportWriter_明細一覧表.getCount()));

        if (parameter.get処理区分().getコード().equals(処理区分3)) {
            ShoriKekkaKakuninListTempTableEntity shoriKekkaKakuninList = new ShoriKekkaKakuninListTempTableEntity();
            shoriKekkaKakuninList.setErrorKubun(new RString("03"));
            shoriKekkaKakuninListTempTable.insert(shoriKekkaKakuninList);
        }
        for (int i = 0; i < NUM11; i++) {
            振込明細一覧表合計.get(NUM11).setその他件数(振込明細一覧表合計.get(i).getその他件数().add(振込明細一覧表合計.get(NUM11).getその他件数()));
            振込明細一覧表合計.get(NUM11).setその他金額(振込明細一覧表合計.get(i).getその他金額().add(振込明細一覧表合計.get(NUM11).getその他金額()));
            振込明細一覧表合計.get(NUM11).set要介護件数(振込明細一覧表合計.get(i).get要介護件数().add(振込明細一覧表合計.get(NUM11).get要介護件数()));
            振込明細一覧表合計.get(NUM11).set要介護金額(振込明細一覧表合計.get(i).get要介護金額().add(振込明細一覧表合計.get(NUM11).get要介護金額()));
            振込明細一覧表合計.get(NUM11).set要支援件数(振込明細一覧表合計.get(i).get要支援件数().add(振込明細一覧表合計.get(NUM11).get要支援件数()));
            振込明細一覧表合計.get(NUM11).set要支援金額(振込明細一覧表合計.get(i).get要支援金額().add(振込明細一覧表合計.get(NUM11).get要支援金額()));
        }
        振込明細一覧表合計.get(NUM13).setその他件数(振込明細一覧表合計.get(NUM11).getその他件数().add(振込明細一覧表合計.get(NUM12).getその他件数()));
        振込明細一覧表合計.get(NUM13).setその他金額(振込明細一覧表合計.get(NUM11).getその他金額().add(振込明細一覧表合計.get(NUM12).getその他金額()));
        振込明細一覧表合計.get(NUM13).set要介護件数(振込明細一覧表合計.get(NUM11).get要介護件数().add(振込明細一覧表合計.get(NUM12).get要介護件数()));
        振込明細一覧表合計.get(NUM13).set要介護金額(振込明細一覧表合計.get(NUM11).get要介護金額().add(振込明細一覧表合計.get(NUM12).get要介護金額()));
        振込明細一覧表合計.get(NUM13).set要支援件数(振込明細一覧表合計.get(NUM11).get要支援件数().add(振込明細一覧表合計.get(NUM12).get要支援件数()));
        振込明細一覧表合計.get(NUM13).set要支援金額(振込明細一覧表合計.get(NUM11).get要支援金額().add(振込明細一覧表合計.get(NUM12).get要支援金額()));
        for (GokeiDataEntity entity : 振込明細一覧表合計) {
            FurikomiMeisaiIchiranDetailReport report = new FurikomiMeisaiIchiranDetailReport(null, entity, outputOrder, parameter.get支払方法(),
                    RDateTime.now(), 設定値);
            report.writeBy(reportSourceWriter_明細一覧表);
        }
    }

    private void set件数加算before制度改正施行日(Code code, boolean flag, InjiYoushikiBangouBetuKingaku 印字様式番号別金額) {
        RString 印字様式番号 = 印字様式番号別金額.get印字様式番号();
        if (印字様式番号.equals(識別番号2131)) {
            set認定状態区分before施行日(code, 振込明細一覧表合計.get(NUM0), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号2141)) {
            set認定状態区分before施行日(code, 振込明細一覧表合計.get(NUM1), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号2151)) {
            set認定状態区分before施行日(code, 振込明細一覧表合計.get(NUM2), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号2161)) {
            set認定状態区分before施行日(code, 振込明細一覧表合計.get(NUM3), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号2171)) {
            set認定状態区分before施行日(code, 振込明細一覧表合計.get(NUM4), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号21B1)) {
            set認定状態区分before施行日(code, 振込明細一覧表合計.get(NUM5), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号2181)) {
            set認定状態区分before施行日(code, 振込明細一覧表合計.get(NUM6), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号2191)) {
            set認定状態区分before施行日(code, 振込明細一覧表合計.get(NUM7), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号21A1)) {
            set認定状態区分before施行日(code, 振込明細一覧表合計.get(NUM8), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号21C1)) {
            set認定状態区分before施行日(code, 振込明細一覧表合計.get(NUM9), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号21D1)) {
            set認定状態区分before施行日(code, 振込明細一覧表合計.get(NUM10), flag, 印字様式番号別金額);
        }
    }

    private void set件数加算after制度改正施行日(Code code, boolean flag, InjiYoushikiBangouBetuKingaku 印字様式番号別金額) {
        RString 印字様式番号 = 印字様式番号別金額.get印字様式番号();
        if (印字様式番号.equals(識別番号2131)) {
            set認定状態区分after施行日(code, 振込明細一覧表合計.get(NUM0), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号2141)) {
            set認定状態区分after施行日(code, 振込明細一覧表合計.get(NUM1), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号2151)) {
            set認定状態区分after施行日(code, 振込明細一覧表合計.get(NUM2), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号2161)) {
            set認定状態区分after施行日(code, 振込明細一覧表合計.get(NUM3), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号2171)) {
            set認定状態区分after施行日(code, 振込明細一覧表合計.get(NUM4), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号21B1)) {
            set認定状態区分after施行日(code, 振込明細一覧表合計.get(NUM5), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号2181)) {
            set認定状態区分after施行日(code, 振込明細一覧表合計.get(NUM6), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号2191)) {
            set認定状態区分after施行日(code, 振込明細一覧表合計.get(NUM7), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号21A1)) {
            set認定状態区分after施行日(code, 振込明細一覧表合計.get(NUM8), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号21C1)) {
            set認定状態区分after施行日(code, 振込明細一覧表合計.get(NUM9), flag, 印字様式番号別金額);
        }
        if (印字様式番号.equals(識別番号21D1)) {
            set認定状態区分after施行日(code, 振込明細一覧表合計.get(NUM10), flag, 印字様式番号別金額);
        }
    }

    private void set認定状態区分before施行日(Code jotaiKubunCode, GokeiDataEntity entity, boolean flag, InjiYoushikiBangouBetuKingaku 印字様式番号別金額) {
        RString code = RString.EMPTY;
        if (jotaiKubunCode != null) {
            code = jotaiKubunCode.value();
        }
        if (code.equals(要介護1) || code.equals(要介護2) || code.equals(要介護3)
                || code.equals(要介護4) || code.equals(要介護5)) {
            entity.set要介護件数(entity.get要介護件数().add(NUM1));
            if (flag) {
                entity.set要介護金額(entity.get要介護金額().add(印字様式番号別金額.get支給金額計()));
            } else {
                entity.set要介護金額(entity.get要介護金額().add(印字様式番号別金額.get差額金額計()));
            }
        } else if (code.equals(要支援)) {
            entity.set要支援件数(entity.get要支援件数().add(NUM1));
            if (flag) {
                entity.set要支援金額(entity.get要支援金額().add(印字様式番号別金額.get支給金額計()));
            } else {
                entity.set要支援金額(entity.get要支援金額().add(印字様式番号別金額.get差額金額計()));
            }
        } else {
            entity.setその他件数(entity.getその他件数().add(NUM1));
            if (flag) {
                entity.setその他金額(entity.getその他金額().add(印字様式番号別金額.get支給金額計()));
            } else {
                entity.setその他金額(entity.getその他金額().add(印字様式番号別金額.get差額金額計()));
            }
        }
    }

    private void set認定状態区分after施行日(Code jotaiKubunCode, GokeiDataEntity entity, boolean flag, InjiYoushikiBangouBetuKingaku 印字様式番号別金額) {
        RString code = RString.EMPTY;
        if (jotaiKubunCode != null) {
            code = jotaiKubunCode.value();
        }
        if (code.equals(要介護1) || code.equals(要介護2) || code.equals(要介護3)
                || code.equals(要介護4) || code.equals(要介護5) || code.equals(経過的要介護)) {
            entity.set要介護件数(entity.get要介護件数().add(NUM1));
            if (flag) {
                entity.set要介護金額(entity.get要介護金額().add(印字様式番号別金額.get支給金額計()));
            } else {
                entity.set要介護金額(entity.get要介護金額().add(印字様式番号別金額.get差額金額計()));
            }
        } else if (code.equals(要支援1) || code.equals(要支援2)) {
            entity.set要支援件数(entity.get要支援件数().add(NUM1));
            if (flag) {
                entity.set要支援金額(entity.get要支援金額().add(印字様式番号別金額.get支給金額計()));
            } else {
                entity.set要支援金額(entity.get要支援金額().add(印字様式番号別金額.get差額金額計()));
            }
        } else {
            entity.setその他件数(entity.getその他件数().add(NUM1));
            if (flag) {
                entity.setその他金額(entity.getその他金額().add(印字様式番号別金額.get支給金額計()));
            } else {
                entity.setその他金額(entity.getその他金額().add(印字様式番号別金額.get差額金額計()));
            }
        }
    }

    private void set認定状態区分before施行日高額(Code code, GokeiDataEntity entity, Decimal 金額) {
        RString 認定状態区分 = RString.EMPTY;
        if (code != null && !code.isEmpty()) {
            認定状態区分 = code.value();
        }
        if (認定状態区分.equals(要介護1) || 認定状態区分.equals(要介護2) || 認定状態区分.equals(要介護3)
                || 認定状態区分.equals(要介護4) || 認定状態区分.equals(要介護5)) {
            entity.set要介護件数(entity.get要介護件数().add(NUM1));
            entity.set要介護金額(entity.get要介護金額().add(金額));
        } else if (認定状態区分.equals(要支援)) {
            entity.set要支援件数(entity.get要支援件数().add(NUM1));
            entity.set要支援金額(entity.get要支援金額().add(金額));
        } else {
            entity.setその他件数(entity.getその他件数().add(NUM1));
            entity.setその他金額(entity.getその他金額().add(金額));
        }
    }

    private void set認定状態区分after施行日高額(Code code, GokeiDataEntity entity, Decimal 金額) {
        RString 認定状態区分 = RString.EMPTY;
        if (code != null && !code.isEmpty()) {
            認定状態区分 = code.value();
        }
        if (認定状態区分.equals(要介護1) || 認定状態区分.equals(要介護2) || 認定状態区分.equals(要介護3)
                || 認定状態区分.equals(要介護4) || 認定状態区分.equals(要介護5) || 認定状態区分.equals(経過的要介護)) {
            entity.set要介護件数(entity.get要介護件数().add(NUM1));
            if (entity.get要介護金額() != null && 金額 != null) {
                entity.set要介護金額(entity.get要介護金額().add(金額));
            } else if (entity.get要介護金額() != null) {
                entity.set要介護金額(entity.get要介護金額());
            } else if (金額 != null) {
                entity.set要介護金額(金額);
            }
        } else if (認定状態区分.equals(要支援1) || 認定状態区分.equals(要支援2)) {
            entity.set要支援件数(entity.get要支援件数().add(NUM1));
            if (entity.get要支援金額() != null && 金額 != null) {
                entity.set要支援金額(entity.get要支援金額().add(金額));
            } else if (entity.get要支援金額() != null) {
                entity.set要支援金額(entity.get要支援金額());
            } else if (金額 != null) {
                entity.set要支援金額(金額);
            }
        } else {
            entity.setその他件数(entity.getその他件数().add(NUM1));
            if (entity.getその他金額() != null && 金額 != null) {
                entity.setその他金額(entity.getその他金額().add(金額));
            } else if (entity.getその他金額() != null) {
                entity.setその他金額(entity.getその他金額());
            } else if (金額 != null) {
                entity.setその他金額(金額);
            }
        }
    }

    private void set振込明細様式名称(int i, GokeiDataEntity entity) {
        if (i == NUM0) {
            entity.set様式名称(様式名称MAP.get(識別番号2131));
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM1) {
            entity.set様式名称(様式名称MAP.get(識別番号2141));
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM2) {
            entity.set様式名称(様式名称MAP.get(識別番号2151));
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM3) {
            entity.set様式名称(様式名称MAP.get(識別番号2161));
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM4) {
            entity.set様式名称(様式名称MAP.get(識別番号2171));
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM5) {
            entity.set様式名称(様式名称MAP.get(識別番号21B1));
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM6) {
            entity.set様式名称(様式名称MAP.get(識別番号2181));
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM7) {
            entity.set様式名称(様式名称MAP.get(識別番号2191));
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM8) {
            entity.set様式名称(様式名称MAP.get(識別番号21A1));
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM9) {
            entity.set様式名称(様式名称MAP.get(識別番号21C1));
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM10) {
            entity.set様式名称(様式名称MAP.get(識別番号21D1));
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM11) {
            entity.set様式名称(償還計);
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM12) {
            entity.set様式名称(RString.EMPTY);
            振込明細一覧表合計.add(entity);
        }
        if (i == NUM13) {
            entity.set様式名称(RString.EMPTY);
            振込明細一覧表合計.add(entity);
        }
    }
}
