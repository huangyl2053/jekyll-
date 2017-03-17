/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshuturyoku;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.hanteikekkakagami.HanteikekkaKagamiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkakagami.HanteikekkaKagamiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kekkatsuchiichiranhyo.KekkatsuchiIchiranhyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkakagami.HanteikekkaKagamiReportSource;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.kaigiatesakijushosettei.KaigoAtesakiJushoSetteiFinder;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査判定結果（鑑）のデータを作成します。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
public class HanteikekkaKagamiProcess extends BatchKeyBreakBase<KekkatsuchiIchiranhyoEntity> {

    private static final ReportId ID = ReportIdDBE.DBE525006.getReportId();
    private static final int パターン番号 = 1;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshuturyoku."
            + "IHanteiKekkaJohoShuturyokuMapper.getKekkatsuchiIchiranList");
    private HanteiKekkaJohoShuturyokuProcessParameter processParameter;
    private RDateTime システム時刻;
    private Map<Integer, RString> 通知文;
    private boolean 初回判定フラグ;
    private boolean is認定広域 = false;
    NinshoshaSource ninshoshaSource;

    @BatchWriter
    private BatchReportWriter<HanteikekkaKagamiReportSource> batchReportWriter;
    private ReportSourceWriter<HanteikekkaKagamiReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        初回判定フラグ = true;
        システム時刻 = RDateTime.now();
        通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ID, KamokuCode.EMPTY, パターン番号);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toHanteiKekkaJohoShuturyokuMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(KekkatsuchiIchiranhyoEntity entity) {
        if (初回判定フラグ) {
            writeReport(entity);
            初回判定フラグ = false;
        }
    }

    @Override
    protected void keyBreakProcess(KekkatsuchiIchiranhyoEntity current) {
        if (!getBefore().getShoKisaiHokenshaNo().equals(current.getShoKisaiHokenshaNo())) {
            writeReport(current);
        }
    }

    @Override
    protected void beforeExecute() {
        KaigoAtesakiJushoSetteiFinder finader = KaigoAtesakiJushoSetteiFinder.createInstance();
        List<KaigoDonyuKeitai> 介護導入形態 = finader.select介護導入形態().records();
        for (KaigoDonyuKeitai item : 介護導入形態) {
            if (GyomuBunrui.介護認定.equals(item.get業務分類()) && DonyuKeitaiCode.認定広域.equals(item.get導入形態コード())) {
                is認定広域 = true;
            }
        }
    }

    private void writeReport(KekkatsuchiIchiranhyoEntity entity) {
        HanteikekkaKagamiEntity hanteikekkaKagamiEntity = new HanteikekkaKagamiEntity();
        hanteikekkaKagamiEntity.setPrintTimeStamp(システム時刻);
        hanteikekkaKagamiEntity.setShinsakaiKaisaiYMD(entity.getShinsakaiKaisaiYMD());
        hanteikekkaKagamiEntity.setShinsakaiKaisaiNo(processParameter.getKaisaiBangou());
        if (is認定広域) {
            ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                    ID,
                    new FlexibleDate(システム時刻.getDate().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし,
                    reportSourceWriter, entity.getShoKisaiHokenshaNo());
        } else {
            ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                    ID,
                    new FlexibleDate(システム時刻.getDate().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし,
                    reportSourceWriter);
        }
        hanteikekkaKagamiEntity.setNinshoshaSource(ninshoshaSource);
        hanteikekkaKagamiEntity.setTsuchibun1(通知文.get(INDEX_1));
        hanteikekkaKagamiEntity.setTsuchibun2(通知文.get(INDEX_2));
        hanteikekkaKagamiEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        HanteikekkaKagamiReport report = new HanteikekkaKagamiReport(hanteikekkaKagamiEntity);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
    }
}
