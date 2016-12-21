/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshuturyoku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.hanteikekkajohoichiran.HanteiKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkaichiran.HanteiKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkajohoichiran.HanteiKekkaIchiranA4ReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaNinchishoKasanCode;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定判定結果一覧表のデータを作成します。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
public class HanteiKekkaIchiranProcess extends BatchProcessBase<HanteiKekkaIchiranEntity> {

    private static final ReportId ID = ReportIdDBE.DBE525001.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshuturyoku."
            + "IHanteiKekkaJohoShuturyokuMapper.getHanteiKekkaIchiranList");
    private static final RString REPORTNAME = new RString("審査判定結果一覧");
    private static final RString 一次判定結果_認知症加算_1 = new RString("1");
    private static final RString 一次判定結果_認知症加算_2 = new RString("2");
    private static final RString 一次判定結果_認知症加算_3 = new RString("3");
    private HanteiKekkaJohoShuturyokuProcessParameter processParameter;
    private RDateTime システム時刻;
    private RString 出力対象;
    private int index;

    @BatchWriter
    private BatchReportWriter<HanteiKekkaIchiranA4ReportSource> batchReportWriter;
    private ReportSourceWriter<HanteiKekkaIchiranA4ReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        システム時刻 = RDateTime.now();
        index = 1;
    }

    @Override
    protected IBatchReader createReader() {
        List<RString> 処理状態区分 = new ArrayList<>();
        処理状態区分.add(ShoriJotaiKubun.通常.getコード());
        処理状態区分.add(ShoriJotaiKubun.延期.getコード());
        ShichosonSecurityJoho shichosonSecurityJoho
                = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定, processParameter.getUserId());
        RString 導入形態コード = shichosonSecurityJoho.get導入形態コード().value();
        if (DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード)) {
            出力対象 = DbBusinessConfig.get(ConfigNameDBE.広域連合名称, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        }
        if (DonyuKeitaiCode.認定単一.getCode().equals(導入形態コード)) {
            processParameter.setShoKisaiHokenshaNo(shichosonSecurityJoho.get市町村情報().get証記載保険者番号().value());
            出力対象 = shichosonSecurityJoho.get市町村情報().get市町村名称();
        }
        processParameter.setShoriJotaiKubun(処理状態区分);
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toHanteiKekkaJohoShuturyokuMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(HanteiKekkaIchiranEntity entity) {
        entity.setTitle(REPORTNAME);
        entity.set出力対象(出力対象);
        entity.setPrintTimeStamp(システム時刻);
        entity.setNo(index);
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
            if (!entity.getTb_一次判定結果().isEmpty()) {
                entity.setTb_一次判定結果(IchijiHanteiKekkaCode09.toValue(entity.getTb_一次判定結果()).get名称());
            } else {
                entity.setTb_一次判定結果(RString.EMPTY);
            }
        } else if (一次判定結果_認知症加算_2.equals(entity.getTb_一次判定結果_加算())
                || 一次判定結果_認知症加算_3.equals(entity.getTb_一次判定結果_加算())) {
            if (!entity.getTb_一次判定結果().isEmpty()) {
                entity.setTb_一次判定結果(IchijiHanteiKekkaNinchishoKasanCode.toValue(entity.getTb_一次判定結果()).get名称());
            } else {
                entity.setTb_一次判定結果(RString.EMPTY);
            }
        }
        if (entity.getTb_二次判定要介護状態区分() != null && !entity.getTb_二次判定要介護状態区分().isEmpty()) {
            entity.setTb_二次判定要介護状態区分(YokaigoJotaiKubun09.toValue(entity.getTb_二次判定要介護状態区分()).get名称());
        } else {
            entity.setTb_二次判定要介護状態区分(RString.EMPTY);
        }
        if (一次判定結果_認知症加算_1.equals(entity.get一次判定結果_加算())) {
            entity.set一次判定結果(IchijiHanteiKekkaCode09.toValue(entity.get一次判定結果()).get名称());
        } else if (一次判定結果_認知症加算_2.equals(entity.get一次判定結果_加算())
                || 一次判定結果_認知症加算_3.equals(entity.get一次判定結果_加算())) {
            entity.set一次判定結果(IchijiHanteiKekkaNinchishoKasanCode.toValue(entity.get一次判定結果()).get名称());
        }
        if (entity.get二次判定要介護状態区分() != null && !entity.get二次判定要介護状態区分().isEmpty()) {
            entity.set二次判定要介護状態区分(YokaigoJotaiKubun09.toValue(entity.get二次判定要介護状態区分()).get名称());
        } else {
            entity.set二次判定要介護状態区分(RString.EMPTY);
        }
        if (entity.get二号特定疾病コード() != null && !entity.get二号特定疾病コード().isEmpty()) {
            entity.set二号特定疾病内容(TokuteiShippei.toValue(entity.get二号特定疾病コード()).get名称());
        } else {
            entity.set二号特定疾病内容(RString.EMPTY);
        }
        HanteiKekkaIchiranReport report = new HanteiKekkaIchiranReport(entity);
        report.writeBy(reportSourceWriter);
        index = index + 1;
    }

}
