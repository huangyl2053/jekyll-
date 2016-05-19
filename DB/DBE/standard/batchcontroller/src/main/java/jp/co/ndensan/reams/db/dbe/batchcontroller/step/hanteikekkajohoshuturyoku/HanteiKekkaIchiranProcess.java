/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hanteikekkajohoshuturyoku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkaichiran.HanteiKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaNinchishoKasanCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定判定結果一覧表のデータを作成します。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
public class HanteiKekkaIchiranProcess extends BatchProcessBase<HanteiKekkaIchiranEntity> {

//    private static final ReportId ID = ReportIdDBE.DBE525001.getReportId();
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

    // TODO 帳票について、未作成
//    @BatchWriter
//    private BatchReportWriter<HanteiKekkaIchiranReportSource> batchReportWriter;
//    private ReportSourceWriter<HanteiKekkaIchiranReportSource> reportSourceWriter;
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
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        RString 導入形態コード = shichosonSecurityJoho.get導入形態コード().value();
        if (DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード)) {
            出力対象 = DbBusinessConifg.get(ConfigNameDBE.判定結果情報出力_広域連合名称, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
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
//        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
//        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(HanteiKekkaIchiranEntity entity) {
        entity.setTitle(REPORTNAME);
        entity.set出力対象(出力対象);
        entity.setPrintTimeStamp(システム時刻);
        entity.setNo(index);
        entity.set認定申請区分_申請時(NinteiShinseiShinseijiKubunCode.toValue(entity.get認定申請区分_申請時()).get名称());
        entity.set認定申請区分_法令(NinteiShinseiHoreiCode.toValue(entity.get認定申請区分_法令()).toRString());
        if (一次判定結果_認知症加算_1.equals(entity.getTb_一次判定結果_加算())) {
            entity.setTb_一次判定結果(IchijiHanteiKekkaCode09.toValue(entity.getTb_一次判定結果()).get名称());
        } else if (一次判定結果_認知症加算_2.equals(entity.getTb_一次判定結果_加算())
                || 一次判定結果_認知症加算_3.equals(entity.getTb_一次判定結果_加算())) {
            entity.setTb_一次判定結果(IchijiHanteiKekkaNinchishoKasanCode.toValue(entity.getTb_一次判定結果()).get名称());
        }
        entity.setTb_二次判定要介護状態区分(YokaigoJotaiKubun09.toValue(entity.getTb_二次判定要介護状態区分()).get略称());
        if (一次判定結果_認知症加算_1.equals(entity.get一次判定結果_加算())) {
            entity.set一次判定結果(IchijiHanteiKekkaCode09.toValue(entity.get一次判定結果()).get名称());
        } else if (一次判定結果_認知症加算_2.equals(entity.get一次判定結果_加算())
                || 一次判定結果_認知症加算_3.equals(entity.get一次判定結果_加算())) {
            entity.set一次判定結果(IchijiHanteiKekkaNinchishoKasanCode.toValue(entity.get一次判定結果()).get名称());
        }
        entity.set二次判定要介護状態区分(YokaigoJotaiKubun09.toValue(entity.get二次判定要介護状態区分()).get略称());
        entity.set二号特定疾病内容(TokuteiShippei.toValue(entity.get二号特定疾病コード()).toRString());
//        HanteiKekkaIchiranReport report = new HanteiKekkaIchiranReport(entity);
//        report.writeBy(reportSourceWriter);
        index = index + 1;
    }

}
