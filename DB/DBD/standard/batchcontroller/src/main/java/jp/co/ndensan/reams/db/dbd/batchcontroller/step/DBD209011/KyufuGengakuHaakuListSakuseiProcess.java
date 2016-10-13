/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200008.KyufuGengakuHaakuIchiranProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200008.KyufuGengakuHaakuIchiranReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd209011.KyufuGengakuHaakuListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran.KyufuGengakuHaakuIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.KyufuGengakuHaakuListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200008.KyufuGengakuHaakuIchiranReportSource;
import jp.co.ndensan.reams.db.dbd.service.core.dbd209011.KyufuGengakuHaakuListSakuseiService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
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
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 給付額減額滞納者把握情報の取得_Process処理クラスです．
 *
 * @reamsid_L DBD-3610-030 x_miaocl
 */
public class KyufuGengakuHaakuListSakuseiProcess extends BatchProcessBase<KyufuGengakuHaakuListSakuseiEntity> {

    private KyufuGengakuHaakuListSakuseiProcessParameter parameter;
    private static final ReportId REPORT_DBD200008 = ReportIdDBD.DBD200008.getReportId();
    private IOutputOrder outputOrder;
    @BatchWriter
    private BatchReportWriter<KyufuGengakuHaakuIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<KyufuGengakuHaakuIchiranReportSource> reportSourceWriter;

    private KyufuGengakuHaakuListSakuseiService service;
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugengakulist."
            + "IKyufuGengakuHaakuListSakuseiMapper.get給付額減額滞納者把握情報");
    HokenshaNo 保険者番号;
    RString 保険者名称;

    private static final int NUM5 = 5;
    private HihokenshaNo 当該被保険者番号;
    private Map<FlexibleYear, Decimal> 調定額Map;
    private Map<FlexibleYear, Decimal> 収入額Map;
    private Map<FlexibleYear, Decimal> 未納額Map;
    private Map<FlexibleYear, Decimal> 徴収権消滅期間Map;
    private Map<FlexibleYear, Decimal> 納付済み期間Map;

    private List<DbT4025ShiharaiHohoHenkoGengakuEntity> 支払方法変更減額List;
    private List<KyufuGengakuHaakuListSakuseiEntity> 把握情報List;
    private Map<FlexibleYear, List<KyufuGengakuHaakuListSakuseiEntity>> 把握情報Map;

    @Override
    protected void initialize() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        if (association != null) {
            if (association.get地方公共団体コード() != null) {
                保険者番号 = new HokenshaNo(association.get地方公共団体コード().getColumnValue());
            }
            保険者名称 = association.get市町村名();
        }
        service = KyufuGengakuHaakuListSakuseiService.createInstance();
        調定額Map = new HashMap<>();
        収入額Map = new HashMap<>();
        未納額Map = new HashMap<>();
        徴収権消滅期間Map = new HashMap<>();
        納付済み期間Map = new HashMap<>();

        支払方法変更減額List = new ArrayList<>();
        把握情報List = new ArrayList<>();
        把握情報Map = new HashMap<>();
    }

    @Override
    protected IBatchReader createReader() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (parameter.get改頁出力順ID() != null) {
            outputOrder = finder.get出力順(SubGyomuCode.DBD介護受給, REPORT_DBD200008, Long.parseLong(parameter.get改頁出力順ID().toString()));
        }
        RString 出力順 = RString.EMPTY;
        if (outputOrder != null) {
            出力順 = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.
                    create(KyufuGengakuHaakuIchiranProerty.DBD200008ShutsuryokujunEnum.class, outputOrder), NUM5);
        }
        if (出力順 != null && !出力順.isEmpty()) {
            出力順 = (new RString("order by \"tmp_hihokenshaNo\",")).concat(出力順.replace("order by", ""));
        } else {
            出力順 = new RString("tmp_hihokenshaNo");
        }

        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        key.set基準日(parameter.get基準日());
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toKyufuGengakuHaakuListSakuseiMybatisParameter(出力順, uaFt200Psm));
    }

    @Override
    protected void createWriter() {
        List pageBreakKeys = new ArrayList<>();
        service.set改頁Key(outputOrder, pageBreakKeys);

        if (!pageBreakKeys.isEmpty()) {
            batchReportWrite = BatchReportFactory.
                    createBatchReportWriter(REPORT_DBD200008.getColumnValue(), SubGyomuCode.DBD介護受給)
                    .addBreak(new BreakerCatalog<KyufuGengakuHaakuIchiranReportSource>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWrite = BatchReportFactory.
                    createBatchReportWriter(REPORT_DBD200008.getColumnValue(), SubGyomuCode.DBD介護受給).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(KyufuGengakuHaakuListSakuseiEntity haakuEntity) {
        edit給付額減額滞納者把握情報(haakuEntity);
    }

    @Override
    protected void afterExecute() {
        if (当該被保険者番号 != null) {
            KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity = service.edit給付額減額把握リストEntity(
                    把握情報Map, 調定額Map, 収入額Map, 未納額Map, 徴収権消滅期間Map, 納付済み期間Map, 把握情報List, 支払方法変更減額List);
            KyufuGengakuHaakuIchiranReport report = new KyufuGengakuHaakuIchiranReport(RDateTime.now(),
                    保険者番号, 保険者名称, 給付額減額把握リストEntity, outputOrder);
            report.writeBy(reportSourceWriter);
        }

        RString 出力ページ数 = new RString(String.valueOf(batchReportWrite.getPageCount()));
        service.バッチ出力条件リストの出力(出力ページ数, parameter, outputOrder);
    }

    private void edit給付額減額滞納者把握情報(KyufuGengakuHaakuListSakuseiEntity entity) {

        if (!entity.get対象者TmpTblEntity().getHihokenshaNo2().equals(当該被保険者番号)) {

            if (当該被保険者番号 != null) {
                KyufuGengakuHaakuIchiranEntity 給付額減額把握リストEntity = service.edit給付額減額把握リストEntity(
                        把握情報Map, 調定額Map, 収入額Map, 未納額Map, 徴収権消滅期間Map, 納付済み期間Map, 把握情報List, 支払方法変更減額List);
                KyufuGengakuHaakuIchiranReport report = new KyufuGengakuHaakuIchiranReport(RDateTime.now(),
                        保険者番号, 保険者名称, 給付額減額把握リストEntity, outputOrder);
                report.writeBy(reportSourceWriter);
            }
            当該被保険者番号 = entity.get対象者TmpTblEntity().getHihokenshaNo2();
            支払方法変更減額List = new ArrayList<>();
            把握情報List = new ArrayList<>();
            把握情報Map = new HashMap<>();

            調定額Map = new HashMap<>();
            収入額Map = new HashMap<>();
            未納額Map = new HashMap<>();
            徴収権消滅期間Map = new HashMap<>();
            納付済み期間Map = new HashMap<>();
        }

        if (entity.get支払方法変更減額Entity() != null) {
            支払方法変更減額List.add(entity.get支払方法変更減額Entity());
        }

        service.減額対象最新情報の設定(entity, 調定額Map, 収入額Map, 未納額Map);

        FlexibleYear 賦課年度 = entity.get収納滞納状況TmpTblEntity().getTmp_fukaNendo();
        把握情報List = 把握情報Map.get(賦課年度);
        if (把握情報List == null) {
            把握情報List = new ArrayList<>();
        }
        把握情報List.add(entity);
        把握情報Map.put(賦課年度, 把握情報List);
    }

}
