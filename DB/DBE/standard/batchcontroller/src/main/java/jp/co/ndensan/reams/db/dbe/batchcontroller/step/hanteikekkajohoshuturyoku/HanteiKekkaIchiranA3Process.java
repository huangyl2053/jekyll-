/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshuturyoku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.hanteikekkaichirana3.HanteiKekkaIchiranA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkaichirana3.HanteiKekkaIchiranA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.hanteikekkaichirana3.HanteiKekkaIchiranA3ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaNinchishoKasanCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定判定結果一覧表Ａ３版のデータを作成します。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
public class HanteiKekkaIchiranA3Process extends BatchProcessBase<HanteiKekkaIchiranA3Entity> {

    private static final ReportId ID = ReportIdDBE.DBE525002.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshuturyoku."
            + "IHanteiKekkaJohoShuturyokuMapper.getHanteiKekkaIchiranA3List");
    private static final RString REPORTNAME = new RString("認定審査会　判定結果一覧");
    private static final RString 一次判定結果_認知症加算_1 = new RString("1");
    private static final RString 一次判定結果_認知症加算_2 = new RString("2");
    private static final RString 一次判定結果_認知症加算_3 = new RString("3");
    private HanteiKekkaJohoShuturyokuProcessParameter processParameter;
    private RDateTime システム時刻;
    private int index;

    @BatchWriter
    private BatchReportWriter<HanteiKekkaIchiranA3ReportSource> batchReportWriter;
    private ReportSourceWriter<HanteiKekkaIchiranA3ReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        システム時刻 = RDateTime.now();
        index = 0;
    }

    @Override
    protected IBatchReader createReader() {
        List<RString> shoriJotaiKubunList = new ArrayList<>();
        shoriJotaiKubunList.add(ShoriJotaiKubun.通常.getコード());
        shoriJotaiKubunList.add(ShoriJotaiKubun.延期.getコード());
        processParameter.setShoriJotaiKubun(shoriJotaiKubunList);
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toHanteiKekkaJohoShuturyokuMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(HanteiKekkaIchiranA3Entity entity) {
        entity.setTitle(REPORTNAME);
        entity.setPrintTimeStamp(システム時刻);
        index = index + 1;
        if (entity.get被保険者区分() != null && !entity.get被保険者区分().isEmpty()) {
            entity.set被保険者区分(HihokenshaKubunCode.toValue(entity.get被保険者区分()).get略称());
        } else {
            entity.set被保険者区分(RString.EMPTY);
        }
        if (entity.get認定申請区分_申請時() != null && !entity.get認定申請区分_申請時().isEmpty()) {
            entity.set認定申請区分_申請時(NinteiShinseiShinseijiKubunCode.toValue(entity.get認定申請区分_申請時()).get略称());
        } else {
            entity.set認定申請区分_申請時(RString.EMPTY);
        }
        if (entity.get認定申請区分_法令() != null && !entity.get認定申請区分_法令().isEmpty()) {
            entity.set認定申請区分_法令(NinteiShinseiHoreiCode.toValue(entity.get認定申請区分_法令()).get略称());
        } else {
            entity.set認定申請区分_法令(RString.EMPTY);
        }
        if (一次判定結果_認知症加算_1.equals(entity.getTb_一次判定結果_加算())) {
            entity.setTb_一次判定結果(IchijiHanteiKekkaCode09.toValue(entity.getTb_一次判定結果()).get名称());
        } else if (一次判定結果_認知症加算_2.equals(entity.getTb_一次判定結果_加算())) {
            entity.setTb_一次判定結果(IchijiHanteiKekkaNinchishoKasanCode.一段階の重度変更.get名称());
        } else if (一次判定結果_認知症加算_3.equals(entity.getTb_一次判定結果_加算())) {
            entity.setTb_一次判定結果(IchijiHanteiKekkaNinchishoKasanCode.二段階の重度変更.get名称());
        } else {
            entity.setTb_一次判定結果(RString.EMPTY);
        }
        if (entity.getTb_二次判定要介護状態区分() != null && !entity.getTb_二次判定要介護状態区分().isEmpty()) {
            entity.setTb_二次判定要介護状態区分(YokaigoJotaiKubun09.toValue(entity.getTb_二次判定要介護状態区分()).get名称());
        } else {
            entity.setTb_二次判定要介護状態区分(RString.EMPTY);
        }
        if (一次判定結果_認知症加算_1.equals(entity.get一次判定結果_加算())) {
            entity.set一次判定結果(IchijiHanteiKekkaCode09.toValue(entity.get一次判定結果()).get名称());
        } else if (一次判定結果_認知症加算_2.equals(entity.get一次判定結果_加算())) {
            entity.set一次判定結果(IchijiHanteiKekkaNinchishoKasanCode.一段階の重度変更.get名称());
        } else if (一次判定結果_認知症加算_3.equals(entity.get一次判定結果_加算())) {
            entity.set一次判定結果(IchijiHanteiKekkaNinchishoKasanCode.二段階の重度変更.get名称());
        } else {
            entity.set一次判定結果(RString.EMPTY);
        }
        if (entity.get二次判定要介護状態区分() != null && !entity.get二次判定要介護状態区分().isEmpty()) {
            entity.set二次判定要介護状態区分(YokaigoJotaiKubun09.toValue(entity.get二次判定要介護状態区分()).get名称());
        } else {
            entity.set二次判定要介護状態区分(RString.EMPTY);
        }
        if (entity.get要介護状態像例コード() != null && !entity.get要介護状態像例コード().isEmpty()) {
            entity.set状態像内容(YokaigoJotaizoReiCode.toValue(entity.get要介護状態像例コード()).get名称());
        } else {
            entity.set状態像内容(RString.EMPTY);
        }
        if (entity.get二号特定疾病コード() != null && !entity.get二号特定疾病コード().isEmpty()) {
            entity.set二号特定疾病内容(new RString(TokuteiShippei.toValue(entity.get二号特定疾病コード()).toString()));
        } else {
            entity.set二号特定疾病内容(RString.EMPTY);
        }
        HanteiKekkaIchiranA3Report report = new HanteiKekkaIchiranA3Report(entity);
        report.writeBy(reportSourceWriter);
    }

}
