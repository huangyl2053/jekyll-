/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021;

import jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaidata.FurikomimeisaiDataOutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiran.FurikomiMeisaiIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.chohyoseigyohanyo.ChohyoSeigyoHanyoKomokuMei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiDataSakusei_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050021.FurikomimeisaiFurikomiDataMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050021.FurikomimeisaiFurikomiDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShoriKekkaKakuninListTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.FurikomimeisaiDataShikyugakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego.FurikaeGoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiran.FurikomiMeisaiIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 振込明細一覧表作成_高額合算と事業高額合算です。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class FurikomimeisaiDataReportProcess extends BatchProcessBase<FurikomimeisaiDataShikyugakuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021."
            + "IFurikomimeisaiFurikomiDataMapper.select出力対象データ");
    private static final RString コンマ = new RString(",");
    private static final RString ORDER = new RString("order by");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_15 = 15;
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString 処理結果確認リスト一時TBL = new RString("DbWT0512ShoriKekkaKakuninList");
    private static final RString 高額合算KUNBUN = new RString("高額合算");
    private static final RString 事業高額合算KUNBUN = new RString("事業高額合算");
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
    private ReportId 帳票ID;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter shoriKekkaKakuninListTempTable;
    @BatchWriter
    private BatchReportWriter<FurikomiMeisaiIchiranSource> batchReportWriter;
    private ReportSourceWriter<FurikomiMeisaiIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        pageCount = new OutputParameter<>();
        get出力順情報();
        ページ件数 = INT_15;
        if (高額合算KUNBUN.equals(processParameter.getBatchKunbun())) {
            帳票ID = ReportIdDBC.DBC200003.getReportId();
        } else if (事業高額合算KUNBUN.equals(processParameter.getBatchKunbun())) {
            帳票ID = ReportIdDBC.DBC200103.getReportId();
        }
        if (Furikomi_ShihraiHohoShitei.口座.getコード().equals(processParameter.get支払方法())) {
            項目名 = ChohyoSeigyoHanyoKomokuMei.帳票タイトル_口座.get名称();
        } else {
            項目名 = ChohyoSeigyoHanyoKomokuMei.帳票タイトル_窓口.get名称();
        }
        mybatisParameter = processParameter.toMybatisParameter();
        if (出力順情報 != null) {
            RString 出力順 = MyBatisOrderByClauseCreator.create(FurikomimeisaiDataOutOrder.class, 出力順情報);
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
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.getColumnValue(), SubGyomuCode.DBC介護給付).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(FurikomimeisaiDataShikyugakuEntity entity) {
        if (振込明細一時 != null) {
            FurikomiMeisaiIchiranReport report = new FurikomiMeisaiIchiranReport(getFurikaeGoMeisaiEntity(振込明細一時), 出力順情報, index);
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
            FurikomiMeisaiIchiranReport report = new FurikomiMeisaiIchiranReport(getFurikaeGoMeisaiEntity(振込明細一時), 出力順情報, index);
            report.writeBy(reportSourceWriter);
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

    private FurikaeGoMeisaiEntity getFurikaeGoMeisaiEntity(FurikomimeisaiDataShikyugakuEntity entity1) {
        DbWT0510FurikomiMeisaiTempEntity 一時Entity = entity1.get振込明細一時Entity();
        FurikaeGoMeisaiEntity entity = new FurikaeGoMeisaiEntity();
        entity.set支払方法区分(一時Entity.getShiharaiHohoKubunCode());
        entity.set総合事業フラグ(一時Entity.isSogoJigyoFlag());
        entity.set帳票タイトル(設定値);
        entity.set金融機関名称(一時Entity.getKinyuKikanName());
        entity.set支店名称(一時Entity.getKinyuKikanShitenName());
        entity.set預金種別名称(一時Entity.getYokinShubetsuName());
        entity.set口座番号(一時Entity.getKozaNo());
        entity.set口座名義人(一時Entity.getKozaMeiginin() == null ? RString.EMPTY : 一時Entity.getKozaMeiginin().getColumnValue());
        entity.set被保険者番号(一時Entity.getHihokenshaNo());
        entity.set氏名漢字(一時Entity.getShimei() == null ? RString.EMPTY : 一時Entity.getShimei().getColumnValue());
        entity.set支給申請書整理番号(一時Entity.getShikyuShinseishoSeiriNo());
        entity.set申請年月日(一時Entity.getShinseiYMD());
        entity.set申請区分コード(一時Entity.getShinseiKubunCode() == null ? RString.EMPTY : 一時Entity.getShinseiKubunCode().getColumnValue());
        entity.set要介護認定状態区分コード(一時Entity
                .getYokaigoJotaiKubunCode() == null ? RString.EMPTY : 一時Entity.getYokaigoJotaiKubunCode().getColumnValue());
        entity.set支払区分方法コード(一時Entity.getShiharaiHohoKubunCode());
        entity.set認定有効期間開始年月日(一時Entity.getNinteiYukoKikanKaishiYMD());
        entity.set総合事業適用開始年月日(一時Entity.getSogoJigyoTekiyoKaishiYMD());
        entity.set認定有効期間終了年月日(一時Entity.getNinteiYukoKikanShuryoYMD());
        entity.set総合事業適用終了年月日(一時Entity.getSogoJigyoTekiyoShuryoYMD());
        entity.set対象計算期間開始年月(一時Entity.getKeisanKaishiYMD() == null || 一時Entity.getKeisanKaishiYMD().isEmpty()
                ? FlexibleYearMonth.EMPTY : 一時Entity.getKeisanKaishiYMD().getYearMonth());
        entity.set対象計算期間終了年月(一時Entity.getKeisanShuryoYMD() == null || 一時Entity.getKeisanShuryoYMD().isEmpty()
                ? FlexibleYearMonth.EMPTY : 一時Entity.getKeisanShuryoYMD().getYearMonth());
        entity.set支払期間開始年月日(一時Entity.getShiharaiKaishiYMD());
        entity.set支払期間終了年月日(一時Entity.getShiharaiShuryoYMD());
        entity.set支払窓口開始時間(一時Entity.getShiharaiKaishiTime());
        entity.set支払窓口終了時間(一時Entity.getShiharaiShuryoTime());
        entity.set自己負担総額円(一時Entity.getJikoFutanSogaku());
        entity.set対象年度(一時Entity.getTaishoNendo());
        entity.set住所(一時Entity.getJusho() == null ? RString.EMPTY : 一時Entity.getJusho().getColumnValue());
        entity.set支払場所(一時Entity.getShiharaiBasho());
        entity.set決定年月日(一時Entity.getKetteiYMD());
        entity.set振込金額(一時Entity.getFurikomiKingaku());
        entity.set名寄せ件数(entity1.get名寄せ件数());
        entity.set頁計金額(振込金額合算);
        entity.set頁計人数(new Decimal(頁計人数));
        entity.set総合計要支援人数(new Decimal(総合計要支援人数));
        entity.set総合計要支援金額(総合計要支援金額);
        entity.set総合計事業対象人数(new Decimal(総合計事業対象人数));
        entity.set総合計事業対象金額(総合計事業対象金額);
        entity.set総合計不明人数(new Decimal(総合計不明人数));
        entity.set総合計不明金額(総合計不明金額);
        entity.set総合計人数(new Decimal(総合計人数));
        entity.set総合計金額(総合計金額);
        entity.set頁計フラグ(is頁計);
        entity.set総合計フラグ(is総合計);
        entity.set識別コード(一時Entity.getShikibetsuCode());
        return entity;
    }

    private void get出力順情報() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (RString.isNullOrEmpty(processParameter.get出力順ID())) {
            出力順情報 = null;
        } else {
            出力順情報 = finder.get出力順(
                    SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200003.getReportId(), Long.parseLong(processParameter.get出力順ID().toString()));
        }
    }
}
