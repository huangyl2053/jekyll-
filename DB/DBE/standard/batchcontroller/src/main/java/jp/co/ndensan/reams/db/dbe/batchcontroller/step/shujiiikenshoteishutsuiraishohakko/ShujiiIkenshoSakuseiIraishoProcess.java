/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.IraishoIkkatsuHakkoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho.ShujiiIkenshoSakuseiIraishoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
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

/**
 *
 * 帳票「主治医意見書作成依頼書」の出力処理クラスです。
 *
 * @reamsid_L DBE-0080-130 duanzhanli
 */
public class ShujiiIkenshoSakuseiIraishoProcess extends BatchProcessBase<ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoTeishutsuIraishoHakkoMapper."
            + "get主治医意見書提出依頼書発行");
    private static final ReportId 帳票ID = ReportIdDBE.DBE230001.getReportId();
    private List<ShujiiIkenshoSakuseiIraishoItem> itemList;
    private ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter processParamter;

    @BatchWriter
    private BatchReportWriter<ShujiiIkenshoSakuseiIraishoReportSource> batchWriter;
    private ReportSourceWriter<ShujiiIkenshoSakuseiIraishoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        itemList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                帳票ID,
                new FlexibleDate(processParamter.getHakkobi()),
                NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし,
                reportSourceWriter);
        Map<Integer, RString> 通知文Map = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, 帳票ID, KamokuCode.EMPTY, 1);
        RString 文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, 帳票ID, FlexibleDate.getNowDate());
        itemList.add(new IraishoIkkatsuHakkoBusiness(entity, processParamter).setDBE230001Item(ninshoshaSource, 文書番号, 通知文Map));
    }

    @Override
    protected void afterExecute() {
        if (!itemList.isEmpty()) {
            ShujiiIkenshoSakuseiIraishoReport report = ShujiiIkenshoSakuseiIraishoReport.createFrom(itemList);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        OutputJokenhyoFactory.createInstance(new IraishoIkkatsuHakkoBusiness(null, processParamter)
                .バッチ出力条件リストの出力(市町村名,
                        出力ページ数,
                        導入団体コード,
                        ReportIdDBE.DBE230001)).print();
    }
}
