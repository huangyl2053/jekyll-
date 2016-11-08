/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050022;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaidata.JigyoKogakuOutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiranjigyokogaku.FurikomiMeisaiIchiranJigyoKogakuParameter;
import jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiranjigyokogaku.FurikomiMeisaiIchiranJigyoKogakuReport;
import jp.co.ndensan.reams.db.dbc.definition.core.chohyoseigyohanyo.ChohyoSeigyoHanyoKomokuMei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiDataSakusei_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050021.FurikomimeisaiFurikomiDataMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050021.FurikomimeisaiFurikomiDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.FurikomimeisaiDataShikyugakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.FurikomiMeisaiIchiranJigyoKogakuSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 振込明細一覧表作成事業高額です。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class JigyoKogakuReportProcess extends BatchProcessBase<FurikomimeisaiDataShikyugakuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021."
            + "IFurikomimeisaiFurikomiDataMapper.select出力対象データ");
    private static final RString コンマ = new RString(",");
    private static final RString ORDER = new RString("order by");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_15 = 15;
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final ReportId 帳票ID = ReportIdDBC.DBC200102.getReportId();
    private static final RString 処理結果確認リスト一時TBL = new RString("DbWT0512ShoriKekkaKakuninList");
    /**
     * 出力ページ数です。
     */
    public static final RString PAGECOUNT;

    static {
        PAGECOUNT = new RString("pageCount");
    }
    private OutputParameter<Integer> pageCount;

    private FurikomimeisaiFurikomiDataProcessParameter processParameter;
    private FurikomimeisaiFurikomiDataMybatisParameter mybatisParameter;
    private IOutputOrder 出力順情報;
    private List<RString> 出力順リスト;
    private int index;
    private RString 設定値;
    private RString 項目名;
    private Decimal 振込金額合算;
    private int 頁計人数;
    private int 総合計要支援人数;
    private Decimal 総合計要支援金額;
    private int 総合計事業対象人数;
    private Decimal 総合計事業対象金額;
    private int 総合計不明人数;
    private Decimal 総合計不明金額;
    private int 総合計人数;
    private int ページ件数;
    private Decimal 総合計金額;
    private FurikomimeisaiDataShikyugakuEntity 振込明細一時;
    private boolean is頁計;
    private boolean is総合計;

    private BatchReportWriter<FurikomiMeisaiIchiranJigyoKogakuSource> batchReportWriter;
    private ReportSourceWriter<FurikomiMeisaiIchiranJigyoKogakuSource> reportSourceWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter shoriKekkaKakuninListTempTable;

    @Override
    protected void initialize() {
        pageCount = new OutputParameter<>();
        get出力順情報();
        ページ件数 = INT_15;
        出力順リスト = new ArrayList<>();
        if (Furikomi_ShihraiHohoShitei.口座.getコード().equals(processParameter.get支払方法())) {
            項目名 = ChohyoSeigyoHanyoKomokuMei.帳票タイトル_口座.get名称();
        } else {
            項目名 = ChohyoSeigyoHanyoKomokuMei.帳票タイトル_窓口.get名称();
        }
        mybatisParameter = processParameter.toMybatisParameter();
        if (出力順情報 != null) {
            for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
                出力順リスト.add(item.get項目名());
            }
            RString 出力順 = MyBatisOrderByClauseCreator.create(JigyoKogakuOutOrder.class, 出力順情報);
            出力順 = 出力順.replace(ORDER, RString.EMPTY).concat(コンマ);
            mybatisParameter.set出力順(出力順);
        }
        index = INT_0;
        振込金額合算 = Decimal.ZERO;
        頁計人数 = INT_0;
        総合計要支援人数 = INT_0;
        総合計要支援金額 = Decimal.ZERO;
        総合計事業対象人数 = INT_0;
        総合計事業対象金額 = Decimal.ZERO;
        総合計不明人数 = INT_0;
        総合計不明金額 = Decimal.ZERO;
        総合計人数 = INT_0;
        総合計金額 = Decimal.ZERO;
        is頁計 = false;
        is総合計 = false;
        get設定値();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        shoriKekkaKakuninListTempTable
                = new BatchEntityCreatedTempTableWriter(処理結果確認リスト一時TBL, ShoriKekkaKakuninListTempTableEntity.class);
    }

    @Override
    protected void process(FurikomimeisaiDataShikyugakuEntity entity) {
        if (index == INT_0) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.getColumnValue(), SubGyomuCode.DBC介護給付).create();
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        }
        if (振込明細一時 != null) {
            FurikomiMeisaiIchiranJigyoKogakuParameter target = getTarget(振込明細一時);
            FurikomiMeisaiIchiranJigyoKogakuReport report = new FurikomiMeisaiIchiranJigyoKogakuReport(target, is頁計, is総合計);
            report.writeBy(reportSourceWriter);
        }
        index = index + 1;
        prepare(entity);
        振込明細一時 = entity;
    }

    @Override
    protected void afterExecute() {
        is頁計 = true;
        is総合計 = true;
        if (振込明細一時 != null) {
            FurikomiMeisaiIchiranJigyoKogakuParameter target = getTarget(振込明細一時);
            FurikomiMeisaiIchiranJigyoKogakuReport report = new FurikomiMeisaiIchiranJigyoKogakuReport(target, is頁計, is総合計);
            report.writeBy(reportSourceWriter);
            batchReportWriter.close();
        }
        if (index == INT_0 && Furikomi_ShoriKubun.明細一覧表作成.getコード().equals(processParameter.get処理区分())) {
            ShoriKekkaKakuninListTempTableEntity shoriKekkaKakuninList = get処理結果確認リスト一時();
            shoriKekkaKakuninListTempTable.insert(shoriKekkaKakuninList);
        }
        pageCount.setValue(reportSourceWriter.pageCount().value());
    }

    private ShoriKekkaKakuninListTempTableEntity get処理結果確認リスト一時() {
        ShoriKekkaKakuninListTempTableEntity shoriKekkaKakuninList = new ShoriKekkaKakuninListTempTableEntity();
        shoriKekkaKakuninList.setErrorKubun(FurikomiDataSakusei_ErrorKubun.一覧表データなし.getコード());
        shoriKekkaKakuninList.setBiko(RString.EMPTY);
        shoriKekkaKakuninList.setHiHokenshaNo(HihokenshaNo.EMPTY);
        shoriKekkaKakuninList.setHihokenshaShimei(RString.EMPTY);
        shoriKekkaKakuninList.setKey1(RString.EMPTY);
        shoriKekkaKakuninList.setKey2(RString.EMPTY);
        shoriKekkaKakuninList.setKey3(RString.EMPTY);
        shoriKekkaKakuninList.setKey4(RString.EMPTY);
        shoriKekkaKakuninList.setKey5(RString.EMPTY);
        shoriKekkaKakuninList.setShoKisaiHokenshaNo(ShoKisaiHokenshaNo.EMPTY);
        return shoriKekkaKakuninList;
    }

    private FurikomiMeisaiIchiranJigyoKogakuParameter getTarget(FurikomimeisaiDataShikyugakuEntity entity) {
        FurikomiMeisaiIchiranJigyoKogakuParameter target = new FurikomiMeisaiIchiranJigyoKogakuParameter();
        target.set振込明細一時(entity.get振込明細一時Entity());
        target.setシステム日付(processParameter.getシステム日時());
        target.set連番(index);
        target.set帳票タイトル(項目名);
        RString 並び順１ = RString.EMPTY;
        RString 並び順２ = RString.EMPTY;
        RString 並び順３ = RString.EMPTY;
        RString 並び順４ = RString.EMPTY;
        RString 並び順５ = RString.EMPTY;
        if (INT_0 < 出力順リスト.size()) {
            並び順１ = 出力順リスト.get(INT_0);
        }
        if (INT_1 < 出力順リスト.size()) {
            並び順２ = 出力順リスト.get(INT_1);
        }
        if (INT_2 < 出力順リスト.size()) {
            並び順３ = 出力順リスト.get(INT_2);
        }
        if (INT_3 < 出力順リスト.size()) {
            並び順４ = 出力順リスト.get(INT_3);
        }
        if (INT_4 < 出力順リスト.size()) {
            並び順５ = 出力順リスト.get(INT_4);
        }
        target.set並び順１(並び順１);
        target.set並び順２(並び順２);
        target.set並び順３(並び順３);
        target.set並び順４(並び順４);
        target.set並び順４(並び順５);
        target.set帳票タイトル(設定値);
        target.setNinzu_shokei(new Decimal(頁計人数));
        target.setShikyu_shokei(振込金額合算);
        target.setYoshien_ninzu_gokei(new Decimal(総合計要支援人数));
        target.setYoshien_kingaku_gokei(総合計要支援金額);
        target.setJigyotaisho_ninzu_gokei(new Decimal(総合計事業対象人数));
        target.setJigyotaisho_kingaku_gokei(総合計事業対象金額);
        target.setFumei_ninzu_gokei(new Decimal(総合計不明人数));
        target.setFumei_kingaku_gokei(総合計不明金額);
        target.setNinzu_gokei(new Decimal(総合計人数));
        target.setShikyu_gokei(総合計金額);
        return target;
    }

    private void prepare(FurikomimeisaiDataShikyugakuEntity entity) {
        DbWT0510FurikomiMeisaiTempEntity 一時Entity = entity.get振込明細一時Entity();
        int flag = index % ページ件数;
        頁計人数 = flag == INT_0 ? ページ件数 : flag;
        is頁計 = flag == INT_0;
        if (flag == INT_1) {
            振込金額合算 = 一時Entity.getFurikomiKingaku() == null ? Decimal.ZERO : 一時Entity.getFurikomiKingaku();
        } else {
            振込金額合算 = 振込金額合算.add(一時Entity.getFurikomiKingaku() == null ? Decimal.ZERO : 一時Entity.getFurikomiKingaku());
        }
        if (一時Entity.getYokaigoJotaiKubunCode() != null && !一時Entity.getYokaigoJotaiKubunCode().isEmpty()) {
            総合計要支援人数 = 総合計要支援人数 + INT_1;
            総合計要支援金額 = 総合計要支援金額.add(一時Entity.getFurikomiKingaku() == null ? Decimal.ZERO : 一時Entity.getFurikomiKingaku());
        } else if (一時Entity.isSogoJigyoFlag()) {
            総合計事業対象人数 = 総合計事業対象人数 + INT_1;
            総合計事業対象金額 = 総合計事業対象金額.add(一時Entity.getFurikomiKingaku() == null ? Decimal.ZERO : 一時Entity.getFurikomiKingaku());
        } else {
            総合計不明人数 = 総合計不明人数 + INT_1;
            総合計不明金額 = 総合計不明金額.add(一時Entity.getFurikomiKingaku() == null ? Decimal.ZERO : 一時Entity.getFurikomiKingaku());
        }
        総合計金額 = 総合計金額.add(一時Entity.getFurikomiKingaku() == null ? Decimal.ZERO : 一時Entity.getFurikomiKingaku());
        総合計人数 = index;
    }

    private void get設定値() {
        ChohyoSeigyoHanyo hanyoResult = ChohyoSeigyoHanyoManager.createInstance()
                .get帳票制御汎用(SubGyomuCode.DBC介護給付, 帳票ID, 管理年度, 項目名);
        if (hanyoResult != null) {
            設定値 = hanyoResult.get設定値();
        } else {
            設定値 = RString.EMPTY;
        }
    }

    private void get出力順情報() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (RString.isNullOrEmpty(processParameter.get出力順ID())) {
            出力順情報 = null;
        } else {
            出力順情報 = finder.get出力順(
                    SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200102.getReportId(), Long.parseLong(processParameter.get出力順ID().toString()));
        }
    }

}
