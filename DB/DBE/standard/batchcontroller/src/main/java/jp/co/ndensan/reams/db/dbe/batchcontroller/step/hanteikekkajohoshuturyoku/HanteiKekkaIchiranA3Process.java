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
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkaichirana3.HanteiKekkaIchiranA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.hanteikekkaichirana3.HanteiKekkaIchiranA3ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshuturyoku.IHanteiKekkaJohoShuturyokuMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    private static final RString REPORTNAME = new RString("認定審査会　判定結果一覧表");
    private static final int ページあたりレコード数 = 15;
    private int 総ページ数;

    private HanteiKekkaJohoShuturyokuProcessParameter processParameter;
    private RDateTime システム時刻;
    private int index;
    private RString 出力対象;
    private HanteiKekkaJohoShuturyokuMybatisParameter mybatisParameter;
    private static final RString 広域保険者ID = new RString("00");
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
        ShichosonSecurityJoho shichosonSecurityJoho
                = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定, processParameter.getUserId());
        RString 導入形態コード = shichosonSecurityJoho.get導入形態コード().value();
        if (DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード)) {
            RString 市町村識別ID = shichosonSecurityJoho.get市町村情報().get市町村識別ID();
            if (広域保険者ID.equals(市町村識別ID)) {
                processParameter.setShoKisaiHokenshaNo(shichosonSecurityJoho.get市町村情報().get証記載保険者番号().value());
            }
            出力対象 = DbBusinessConfig.get(ConfigNameDBE.広域連合名称, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        }
        if (DonyuKeitaiCode.認定単一.getCode().equals(導入形態コード)) {
            processParameter.setShoKisaiHokenshaNo(shichosonSecurityJoho.get市町村情報().get証記載保険者番号().value());
            出力対象 = shichosonSecurityJoho.get市町村情報().get市町村名称();
        }
        processParameter.setShoriJotaiKubun(shoriJotaiKubunList);
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toHanteiKekkaJohoShuturyokuMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void beforeExecute() {
        mybatisParameter = processParameter.toHanteiKekkaJohoShuturyokuMybatisParameter();
        int 総レコード数 = getMapper(IHanteiKekkaJohoShuturyokuMapper.class).countHanteiKekkaIchiranA3List(mybatisParameter);
        int レコード余り = 総レコード数 % ページあたりレコード数;
        int ページ算出値 = 総レコード数 / ページあたりレコード数;
        if (レコード余り > 0) {
            総ページ数 = ページ算出値 + 1;
        } else {
            総ページ数 = ページ算出値;
        }
    }

    @Override
    protected void process(HanteiKekkaIchiranA3Entity entity) {
        entity.setTitle(REPORTNAME);
        entity.setPrintTimeStamp(システム時刻);
        entity.set出力対象(出力対象);
        entity.set審査会開催番号(processParameter.getKaisaiBangou());
        index = index + 1;
        if (index % ページあたりレコード数 > 0) {
            entity.set当前頁((index - (index % ページあたりレコード数)) / ページあたりレコード数 + 1);
        } else {
            entity.set当前頁(index / ページあたりレコード数);
        }
        entity.set総頁(総ページ数);
        entity.set項番(index);
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
        if (entity.getTb_二次判定要介護状態区分() != null && !entity.getTb_二次判定要介護状態区分().isEmpty()) {
            entity.setTb_二次判定要介護状態区分(YokaigoJotaiKubun09.toValue(entity.getTb_二次判定要介護状態区分()).get名称());
        } else {
            entity.setTb_二次判定要介護状態区分(RString.EMPTY);
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
