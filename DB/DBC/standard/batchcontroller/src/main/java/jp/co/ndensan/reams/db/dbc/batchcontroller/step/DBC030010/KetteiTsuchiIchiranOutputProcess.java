/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
import jp.co.ndensan.reams.db.dbz.business.core.mybatisorderbycreator.BreakPageCreator;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
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
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票DBC200023_償還払い支給（不支給）決定通知一覧表を出力します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class KetteiTsuchiIchiranOutputProcess extends BatchKeyBreakBase<ShokanKetteiTsuchiShoShiharaiRelateEntity> {

    private static final RString 帳票取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get決定通知一覧表帳票データ");
    private static final RString ORDER_BY = new RString("order by");
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int ZERO = 0;
    private static final int TEN = 10;
    private static final RString カンマ = new RString(",");
    List<ShokanKetteiTsuchiShoShiharai> 帳票データリスト = new ArrayList<>();
    Map<RString, RString> 種類Map = new HashMap<RString, RString>();
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
    IOutputOrder outputOrder;

    @BatchWriter
    private BatchReportWriter<ShokanbaraiShikyuFushikyuReportSource> batchWrite;
    private ReportSourceWriter<ShokanbaraiShikyuFushikyuReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        並び順List = new ArrayList();
        改頁List = new ArrayList();
    }

    @Override
    protected IBatchReader createReader() {
        RString 出力順 = get出力順(ReportIdDBC.DBC100002_2.getReportId(), batchPram.getSyutujunId());
        if (!RString.isNullOrEmpty(出力順)) {
            出力順 = 出力順.replace(ORDER_BY, RString.EMPTY);
        }
        get出力順項目();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter parameter
                = ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter.toMybatisParameter(出力順,
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        return new BatchDbReader(帳票取得SQL, parameter);
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
        RString key = getJufukuKey(データ);
        if (種類Map.containsKey(key)) {
            種類Map.put(key, set種類(種類Map.get(key), データ.get種類()));
        } else {
            帳票データリスト.add(データ);
            種類Map.put(key, データ.get種類());
                    
        }
    }
    
    private RString set種類(RString kyufuShu, RString 種類) {
        if (RString.isNullOrEmpty(kyufuShu)) {
            return 種類;
        }
        RStringBuilder builder = new RStringBuilder(kyufuShu);
        if (!RString.isNullOrEmpty(種類)) {
            builder.append(カンマ);
            builder.append(種類);
        }
        return builder.toRString();
    }
    
    private RString getJufukuKey(ShokanKetteiTsuchiShoShiharai shiharai) {
        RStringBuilder key = new RStringBuilder();
        key.append(shiharai.get被保険者番号().value());
        key.append(shiharai.get提供年月().wareki().toDateString());
        key.append(shiharai.get整理番号().padLeft(new RString(ZERO), TEN));
        return key.toRString();
    }

    @Override
    protected void afterExecute() {
        if (帳票データリスト.isEmpty()) {
            return;
        }
        ShokanharaiShikyuFushikyuKeteiTsuchiIchiranhyo ichiranhyo = new ShokanharaiShikyuFushikyuKeteiTsuchiIchiranhyo();
        List<ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranItem> itemList
                = ichiranhyo.getShokanharaiShikyuFushikyuKeteiTsuchiIchiranhyoData(帳票データリスト, batchPram, 並び順List, 改頁List, 種類Map);
        ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport report = ShokanbaraiShikyuFushikyuKetteiTsuchiIchiranReport.createFrom(itemList);
        report.writeBy(reportSourceWriter);
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
