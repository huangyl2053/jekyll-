/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushakyufujissekidaicho.JukyushaKyufuDaichoData;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoReportSource;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaTmpMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者給付実績台帳のListケアマネジメント費のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 *
 */
public class JukyushaKyufuJissekidaichoProcess extends BatchProcessBase<JukyushaKyufuJissekidaichoData> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaTmpMapper."
            + "get帳票データ");
    private static final ReportId ID = ReportIdDBC.DBC100055.getReportId();
    private static final RString MESSAGE = new RString("**　対象データは存在しません　**");
    @BatchWriter
    private BatchReportWriter<JukyushaKyufuJissekidaichoReportSource> batchReportWriter;
    private ReportSourceWriter<JukyushaKyufuJissekidaichoReportSource> reportSourceWriter;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;
    private ShutsuryokujunRelateEntity 出力順entity;
    private IJukyushaTmpMapper mapper;
    private boolean flag = false;
    private int index = 0;
    private int pageCnt = 0;

    @Override
    protected void initialize() {
        出力順entity = ReportUtil.get出力順情報(JukyushaKyufuDaichoData.ShutsuryokujunEnum.class, SubGyomuCode.DBC介護給付, ID, parameter.get出力順ID());
        mapper = getMapper(IJukyushaTmpMapper.class);
        pageCnt = mapper.get帳票データCount(parameter.toJukyushaKyufujissekiDaichoMybatisParameter(出力順entity.get出力順OrderBy()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter(出力順entity.get出力順OrderBy()));
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value())
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(JukyushaKyufuJissekidaichoData entity) {
        flag = true;
        index++;
        entity.set被保険者毎ページ数(new RString(index));
        entity.set被保険者毎総ページ数(new RString(pageCnt));
        entity.setページ数(new RString(pageCnt));
        JukyushaKyufuJissekidaichoReport report = new JukyushaKyufuJissekidaichoReport(entity);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        if (!flag) {
            JukyushaKyufuJissekidaichoData jukyushaKyufuDaicho = new JukyushaKyufuJissekidaichoData();
            jukyushaKyufuDaicho.set被保険者氏名(MESSAGE);
            JukyushaKyufuJissekidaichoReport report = new JukyushaKyufuJissekidaichoReport(jukyushaKyufuDaicho);
            report.writeBy(reportSourceWriter);
        }
    }

}
