/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran.KetteiTsuchiIchiranBreakPageItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran.KetteiTsuchiIchiranOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyufushikyuketteitsuchiichiran.ShokanbaraiShikyuFushikyuReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.shokanharaishikyufushikyuketeitsuchiichiranhyo.ShokanharaiShikyuFushikyuKeteiTsuchiIchiranhyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.mybatisorderbycreator.BreakPageCreator;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票DBC200023_償還払い支給（不支給）決定通知一覧表を出力します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class KetteiTsuchiIchiranOutputProcess extends BatchKeyBreakBase<ShokanKetteiTsuchiShoShiharaiRelateEntity> {

    private static final RString 帳票取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get決定通知書明細一覧情報Data");
    private static final RString ORDER_BY = new RString("order by");
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    List<ShokanKetteiTsuchiShoShiharai> 帳票データリスト = new ArrayList<>();
    ShokanKetteiTsuchiShoSealerBatchParameter batchPram;
    List<RString> 並び順List;
    List<RString> 改頁List;
    List<RString> pageBreakKeys;
    private RString 出力順1 = RString.EMPTY;
    private RString 出力順2 = RString.EMPTY;
    private RString 出力順3 = RString.EMPTY;
    private RString 出力順4 = RString.EMPTY;
    private RString 出力順5 = RString.EMPTY;
    private RString 改頁1 = RString.EMPTY;
    private RString 改頁2 = RString.EMPTY;
    private RString 改頁3 = RString.EMPTY;
    private RString 改頁4 = RString.EMPTY;
    private RString 改頁5 = RString.EMPTY;
    private static final RString 帳票制御汎用キー_償還払い支給不支給決定通知書 = new RString("２号発行有無");
    private static final RString 発行有無_発行しない = new RString("0");
    IOutputOrder outputOrder;
    private ChohyoSeigyoKyotsu 帳票制御共通情報;
    private List<PersonalData> personalDataList;

    @BatchWriter
    private BatchReportWriter<ShokanbaraiShikyuFushikyuReportSource> batchWrite;
    private ReportSourceWriter<ShokanbaraiShikyuFushikyuReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        並び順List = new ArrayList();
        改頁List = new ArrayList();
        personalDataList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        RString 出力順 = get出力順(ReportIdDBC.DBC100002_2.getReportId(), batchPram.getSyutujunId());
        if (!RString.isNullOrEmpty(出力順)) {
            出力順 = 出力順.replace(ORDER_BY, RString.EMPTY);
        }
        get出力順項目();
        
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        RString 資格区分 = null;

        ChohyoSeigyoHanyo 帳票制御汎発行有無 = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                FlexibleYear.MIN, 帳票制御汎用キー_償還払い支給不支給決定通知書);
        if (帳票制御汎発行有無 != null && 発行有無_発行しない.equals(帳票制御汎発行有無.get設定値())) {
            資格区分 = ShikakuKubun._２号.getコード();
        }
        帳票制御共通情報 = get帳票制御共通情報();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);

        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder 宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set基準日(batchPram.getHakkoYMD());
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        
        ShikibetsuTaishoPSMSearchKeyBuilder key2 = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoPSMSearchKey psmShikibetsuTaisho = key2.build();

        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 介護給付_償還 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護給付_償還);
        KamokuCode 科目コード;
        if (介護給付_償還 != null) {
            科目コード = 介護給付_償還.getコード();
        } else {
            科目コード = KamokuCode.EMPTY;
        }
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder()
                .set業務コード(GyomuCode.DB介護保険)
                .setサブ業務コード(SubGyomuCode.DBC介護給付)
                .set科目コード(科目コード)
                .set基準日(FlexibleDate.getNowDate()).build();
        List<KamokuCode> kamokuList = new ShunoKamokuAuthority().
                get参照権限科目コード(UrControlDataFactory.createInstance().getLoginInfo().getUserId());
        
        ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter parameter
                = ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter.toMybatisParameter(出力順, 資格区分, psmShikibetsuTaisho,
                        key.getPSM検索キー(), 宛先builder.build(), searchKey, kamokuList);
        return new BatchDbReader(帳票取得SQL, parameter);
    }
    private ChohyoSeigyoKyotsu get帳票制御共通情報() {
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        return chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付,
                new ReportId(ReportIdDBC.DBC100002_2.getReportId().value()));
    }
    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200023.getReportId().value())
                .addBreak(new BreakerCatalog<ShokanbaraiShikyuFushikyuReportSource>().simplePageBreaker(pageBreakKeys)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void usualProcess(ShokanKetteiTsuchiShoShiharaiRelateEntity entity) {
        
        ShokanKetteiTsuchiShoShiharai データ = new ShokanKetteiTsuchiShoShiharai(entity);
        帳票データリスト.add(データ);
        personalDataList.add(toPersonalData(entity));         
    }


    @Override
    protected void afterExecute() {
        if (帳票データリスト.isEmpty()) {
            return;
        }
        ShokanharaiShikyuFushikyuKeteiTsuchiIchiranhyo ichiranhyo = new ShokanharaiShikyuFushikyuKeteiTsuchiIchiranhyo();
        List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem> itemList
                = ichiranhyo.getShokanharaiShikyuFushikyuKeteiTsuchiIchiranhyoData(帳票データリスト, batchPram, 並び順List, 改頁List, 帳票制御共通情報);
        ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport report = ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport.createFrom(itemList);
        report.writeBy(reportSourceWriter);
        AccessLogger.log(AccessLogType.照会, personalDataList);
    }

    private PersonalData toPersonalData(ShokanKetteiTsuchiShoShiharaiRelateEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), 
                new RString("被保険者番号"), new RString(entity.getHiHokenshaNo().toString()));
        return PersonalData.of(entity.getShikibetsuCode(), expandedInfo);
    }
    private RString get出力順(ReportId 帳票分類ID, RString 出力順ID) {

        if (RString.isNullOrEmpty(出力順ID)) {
            return RString.EMPTY;
        }
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, Long.parseLong(出力順ID.toString()));
        if (outputOrder == null) {
            return RString.EMPTY;
        }
        return MyBatisOrderByClauseCreator.create(KetteiTsuchiIchiranOutPutOrder.class, outputOrder);
    }

    private void get出力順項目() {
        Map<Integer, ISetSortItem> 改頁Map = ChohyoUtil.get改頁項目Map(outputOrder);
        Map<Integer, ISetSortItem> 出力順Map = ChohyoUtil.get出力順項目Map(outputOrder);
        if (出力順Map.get(1) != null) {
            出力順1 = 出力順Map.get(1).get項目名();
        }
        if (出力順Map.get(2) != null) {
            出力順2 = 出力順Map.get(2).get項目名();
        }
        if (出力順Map.get(INT3) != null) {
            出力順3 = 出力順Map.get(INT3).get項目名();
        }
        if (出力順Map.get(INT4) != null) {
            出力順4 = 出力順Map.get(INT4).get項目名();
        }
        if (出力順Map.get(INT5) != null) {
            出力順5 = 出力順Map.get(INT5).get項目名();
        }
        if (改頁Map.get(1) != null) {
            改頁1 = 改頁Map.get(1).get項目名();
        }
        if (改頁Map.get(2) != null) {
            改頁2 = 改頁Map.get(2).get項目名();
        }
        if (改頁Map.get(INT3) != null) {
            改頁3 = 改頁Map.get(INT3).get項目名();
        }
        if (改頁Map.get(INT4) != null) {
            改頁4 = 改頁Map.get(INT4).get項目名();
        }
        if (改頁Map.get(INT5) != null) {
            改頁5 = 改頁Map.get(INT5).get項目名();
        }
        並び順List.add(出力順1);
        並び順List.add(出力順2);
        並び順List.add(出力順3);
        並び順List.add(出力順4);
        並び順List.add(出力順5);
        改頁List.add(改頁1);
        改頁List.add(改頁2);
        改頁List.add(改頁3);
        改頁List.add(改頁4);
        改頁List.add(改頁5);
        getPageBreakKeys();
    }

    private void getPageBreakKeys() {
        List<RString> pageBreakKeyList = new ArrayList<>();
        if (!RString.isNullOrEmpty(改頁1)) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(KetteiTsuchiIchiranBreakPageItem.class, 改頁1));
        }
        if (!RString.isNullOrEmpty(改頁2)) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(KetteiTsuchiIchiranBreakPageItem.class, 改頁2));
        }
        if (!RString.isNullOrEmpty(改頁3)) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(KetteiTsuchiIchiranBreakPageItem.class, 改頁3));
        }
        if (!RString.isNullOrEmpty(改頁4)) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(KetteiTsuchiIchiranBreakPageItem.class, 改頁4));
        }
        if (!RString.isNullOrEmpty(改頁5)) {
            pageBreakKeyList.add(BreakPageCreator.getBreakPageName(KetteiTsuchiIchiranBreakPageItem.class, 改頁5));
        }
        pageBreakKeys = Collections.unmodifiableList(pageBreakKeyList);
    }

    @Override
    protected void keyBreakProcess(ShokanKetteiTsuchiShoShiharaiRelateEntity t) {
    }
}
