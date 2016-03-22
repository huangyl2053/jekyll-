/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.kaigoninteishinsakaischedulekagami;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiItem;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.definition.processprm.kaigoninteishinsakaischedulekagami.KaigoNinteiShinsakaiScheduleKagamiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedulekagami.KaigoNinteiShinsakaiScheduleKagamiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kaigoninteishinsakaischedulekagami.IKaigoNinteiShinsakaiScheduleKagamiMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 介護認定審査会スケジュール表_バッチフ処理クラスです
 */
public class KaigoNinteiShinsakaiScheduleKagamiProcess extends BatchProcessBase<KaigoNinteiShinsakaiScheduleKagamiRelateEntity> {

    private static final RString 宛名連番 = new RString("1");
    private static final int KEY = 2;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kaigoninteishinsakaischedulekagami."
            + "IKaigoNinteiShinsakaiScheduleKagamiMapper.get出力明細一覧");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE514002.getReportId();
    private IKaigoNinteiShinsakaiScheduleKagamiMapper kagamiMapper;
    private List<ShinsaschedulekagamiItem> itemList;
    private KaigoNinteiShinsakaiScheduleKagamiProcessParamter processParamter;
    @BatchWriter
    private BatchReportWriter<ShinsaschedulekagamiReportSource> batchWriter;
    private ReportSourceWriter<ShinsaschedulekagamiReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        itemList = new ArrayList<>();
        kagamiMapper = getMapper(IKaigoNinteiShinsakaiScheduleKagamiMapper.class);

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toKaigoNinteiShinsakaiScheduleMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(KaigoNinteiShinsakaiScheduleKagamiRelateEntity entity) {
        itemList.add(setItem(entity));
    }

    @Override
    protected void afterExecute() {
        if (itemList != null && !itemList.isEmpty()) {
            ShinsaschedulekagamiReport report = ShinsaschedulekagamiReport.createFrom(itemList);
            report.writeBy(reportSourceWriter);
        }
    }

    private ShinsaschedulekagamiItem setItem(KaigoNinteiShinsakaiScheduleKagamiRelateEntity entity) {
        RString 宛名機関名 = RString.EMPTY;
        if (!RString.isNullOrEmpty(entity.getShujiiIryokikanCode())) {
            宛名機関名 = kagamiMapper.get医療機関名称(entity.getShujiiIryokikanCode());
        } else if (!RString.isNullOrEmpty(entity.getNinteichosaItakusakiCode())) {
            宛名機関名 = kagamiMapper.get事業者名称(entity.getNinteichosaItakusakiCode());
        } else if (!RString.isNullOrEmpty(entity.getSonotaKikanCode())) {
            宛名機関名 = kagamiMapper.get機関名称(entity.getSonotaKikanCode());
        }
        CustomerBarCode barcode = new CustomerBarCode();
        RString customerBarCode = barcode.convertCustomerBarCode(entity.getYubinNo(), entity.getJushoText()).getCustomerBarCode();
        NinshoshaSource compNinshosha = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, REPORT_ID, FlexibleDate.getNowDate(), reportSourceWriter);
        Map<Integer, RString> 通知文Map = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, REPORT_ID, KamokuCode.EMPTY, 1);
        return new ShinsaschedulekagamiItem(BusinessConfig.get(ConfigNameDBE.介護認定審査会スケジュール表鑑, SubGyomuCode.DBE認定支援),
                processParamter.getShinsakaiKaisaiKikanFrom(), processParamter.getShinsakaiKaisaiKikanTo(), compNinshosha.denshiKoin,
                compNinshosha.hakkoYMD, compNinshosha.koinMojiretsu, compNinshosha.koinShoryaku, compNinshosha.ninshoshaShimeiKakeru,
                compNinshosha.ninshoshaShimeiKakenai, compNinshosha.ninshoshaYakushokuMei, compNinshosha.ninshoshaYakushokuMei1,
                compNinshosha.ninshoshaYakushokuMei2, 宛名連番, customerBarCode, entity.getYubinNo(), entity.getJushoText(), 宛名機関名,
                entity.getShimeiText(), ChohyoAtesakiKeisho.toValue(BusinessConfig.get(
                                ConfigNameDBE.介護認定審査会スケジュール表鏡_宛先敬称, SubGyomuCode.DBE認定支援)).get名称(),
                通知文Map.get(1), 通知文Map.get(KEY));
    }
}
