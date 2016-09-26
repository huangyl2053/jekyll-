/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD581001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd300003.YokaigoNinteiJisshiJokyohyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd581001.YokaigoJissiJyokyohyoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd581001.JissiJyokyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd581001.JissiJyokyoRisutoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd581001.JissiJyokyohyoHakkouEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijisshijokyohyo.YokaigoNinteiJisshiJokyohyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijisshijokyohyo.YokaigoNinteiJisshiJokyohyoReportEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300003.YokaigoNinteiJisshiJokyohyoReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定実施状況表（統計表）の発行_process処理クラスです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
public class JissiJyokyohyoHakkouProcess extends BatchKeyBreakBase<JissiJyokyohyoHakkouEntity> {

    private static final ReportId REPORT_DBD300003 = ReportIdDBD.DBD300003.getReportId();
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigojissijyokyohyo."
                    + "IYokaigoJissiJyokyohyoHakkouMapper.getDBT51001の場合のデータ");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(YokaigoNinteiJisshiJokyohyoReportSource.ReportSourceFields.hokenshaNo.name())));

    @BatchWriter
    private BatchReportWriter<YokaigoNinteiJisshiJokyohyoReportSource> batchReportWriter;
    private ReportSourceWriter<YokaigoNinteiJisshiJokyohyoReportSource> reportSourceWriter;
    private YokaigoJissiJyokyohyoProcessParameter parameter;
    private JissiJyokyoEntity 実施状況Entity;
    private JissiJyokyoRisutoEntity 実施状況リストEntity;
    private YokaigoNinteiJisshiJokyohyoEntity jisshiJokyohyoEntity;
    private YokaigoNinteiJisshiJokyohyoReportEntity jisshiJokyohyoReportEntity;
    private JissiJyokyohyoHakkouEntity beforeEntity = null;
    private LasdecCode beforeCode = LasdecCode.EMPTY;
    private static final RString 取得条件新規 = new RString("01");
    private static final RString 取得条件要支援 = new RString("02");
    private static final RString 取得条件更新 = new RString("03");
    private static final RString 取得条件区分変更 = new RString("04");
    private static final RString 集計項目新規 = new RString("新規（要支援）");
    private static final RString 集計項目更新 = new RString("更新");
    private static final RString 集計項目区分変更 = new RString("区分変更");
    private static final RString 集計項目申請受付件数 = new RString("申請受付件数");
    private static final RString 集計項目申請取下げ件数 = new RString("申請取下げ件数");
    private static final RString 集計項目申請却下件数 = new RString("申請却下件数");
    private static final RString 集計項目調査依頼件数 = new RString("調査依頼件数");
    private static final RString 集計項目調査予定件数 = new RString("調査予定件数");
    private static final RString 集計項目調査実施件数 = new RString("調査実施件数");
    private static final RString 集計項目意見書依頼件数 = new RString("意見書依頼件数");
    private static final RString 集計項目意見書取寄せ予定件数 = new RString("意見書取寄せ予定件数");
    private static final RString 集計項目意見書取寄せ件数 = new RString("意見書取寄せ件数");
    private static final RString 集計項目審査会依頼件数 = new RString("審査会依頼件数");
    private static final RString 集計項目審査会回答予定件数 = new RString("審査会回答予定件数");
    private static final RString 集計項目審査会回答件数 = new RString("審査会回答件数");
    private static final RString 一月 = new RString("01");
    private static final RString 二月 = new RString("02");
    private static final RString 三月 = new RString("03");
    private static final RString 四月 = new RString("04");
    private static final RString 五月 = new RString("05");
    private static final RString 六月 = new RString("06");
    private static final RString 七月 = new RString("07");
    private static final RString 八月 = new RString("08");
    private static final RString 九月 = new RString("09");
    private static final RString 十月 = new RString("10");
    private static final RString 十一月 = new RString("11");
    private static final RString 十二月 = new RString("12");
    private static final RString 地区区分全て = new RString("ALL");
    private static final RString 地区全て = new RString("全て");
    private static final RString 集計単位受給申請 = new RString("ZIYU");
    private static final RString 集計単位申請時 = new RString("SHINSEIZI");
    private static final RString 集計単位法令 = new RString("HOUREI");
    private static final RString 受給申請事由 = new RString("受給申請事由");
    private static final RString 申請区分申請時 = new RString("申請区分(申請時)");
    private static final RString 申請区分法令 = new RString("申請区分(法令)");
    private static final int SUBSTRING_5 = 5;
    private static final int SUBSTRING_9 = 9;
    private static final int INDEX_12 = 12;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;

    @Override
    protected void initialize() {
        実施状況Entity = new JissiJyokyoEntity();
        実施状況Entity.set実施状況リスト1(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト2(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト3(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト4(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト5(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        for (int index = 0; index < INDEX_12; index++) {
            jisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
            実施状況Entity.get実施状況リスト1().add(jisshiJokyohyoEntity);
            jisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
            実施状況Entity.get実施状況リスト2().add(jisshiJokyohyoEntity);
            jisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
            実施状況Entity.get実施状況リスト3().add(jisshiJokyohyoEntity);
            jisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
            実施状況Entity.get実施状況リスト4().add(jisshiJokyohyoEntity);
            jisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
            実施状況Entity.get実施状況リスト5().add(jisshiJokyohyoEntity);
        }
        実施状況リストEntity = new JissiJyokyoRisutoEntity();
        実施状況リストEntity.set実施状況Entityリスト1(new ArrayList<YokaigoNinteiJisshiJokyohyoReportEntity>());
        実施状況リストEntity.set実施状況Entityリスト2(new ArrayList<YokaigoNinteiJisshiJokyohyoReportEntity>());
        実施状況リストEntity.set実施状況Entityリスト3(new ArrayList<YokaigoNinteiJisshiJokyohyoReportEntity>());
        実施状況リストEntity.set実施状況Entityリスト4(new ArrayList<YokaigoNinteiJisshiJokyohyoReportEntity>());
        jisshiJokyohyoReportEntity = new YokaigoNinteiJisshiJokyohyoReportEntity();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toYokaigoJissiJyokyohyoHakkouMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD300003.value())
                .addBreak(new BreakerCatalog<YokaigoNinteiJisshiJokyohyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(JissiJyokyohyoHakkouEntity current) {

    }

    @Override
    protected void usualProcess(JissiJyokyohyoHakkouEntity jissiJyokyohyoHakkouEntity) {
        if (!beforeCode.isEmpty() && !jissiJyokyohyoHakkouEntity.get市町村コード().equals(beforeCode)) {
            実施状況リストEntity作成();
            実施状況Entity = new JissiJyokyoEntity();
            実施状況Entity.set実施状況リスト1(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
            実施状況Entity.set実施状況リスト2(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
            実施状況Entity.set実施状況リスト3(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
            実施状況Entity.set実施状況リスト4(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
            実施状況Entity.set実施状況リスト5(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
            for (int index = 0; index < INDEX_12; index++) {
                jisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
                実施状況Entity.get実施状況リスト1().add(jisshiJokyohyoEntity);
                jisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
                実施状況Entity.get実施状況リスト2().add(jisshiJokyohyoEntity);
                jisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
                実施状況Entity.get実施状況リスト3().add(jisshiJokyohyoEntity);
                jisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
                実施状況Entity.get実施状況リスト4().add(jisshiJokyohyoEntity);
                jisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
                実施状況Entity.get実施状況リスト5().add(jisshiJokyohyoEntity);
            }
        }
        if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(取得条件新規)) {
            setJisshiJokyohyoEntity(実施状況Entity.get実施状況リスト2(), jissiJyokyohyoHakkouEntity);
        }
        if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(取得条件要支援)) {
            setJisshiJokyohyoEntity(実施状況Entity.get実施状況リスト5(), jissiJyokyohyoHakkouEntity);
        }
        if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(取得条件更新)) {
            setJisshiJokyohyoEntity(実施状況Entity.get実施状況リスト3(), jissiJyokyohyoHakkouEntity);
        }
        if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(取得条件区分変更)) {
            setJisshiJokyohyoEntity(実施状況Entity.get実施状況リスト4(), jissiJyokyohyoHakkouEntity);
        }
        beforeEntity = jissiJyokyohyoHakkouEntity;
        beforeCode = jissiJyokyohyoHakkouEntity.get市町村コード();
    }

    private void setJisshiJokyohyoEntity(
            List<YokaigoNinteiJisshiJokyohyoEntity> list,
            JissiJyokyohyoHakkouEntity jissiJyokyohyoHakkouEntity) {
        if (jissiJyokyohyoHakkouEntity.get年月().substring(SUBSTRING_5).equals(一月)) {
            list.get(rstringToInt(jissiJyokyohyoHakkouEntity.get取得条件().substring(0, 2)))
                    .set一月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(SUBSTRING_5).equals(二月)) {
            list.get(rstringToInt(jissiJyokyohyoHakkouEntity.get取得条件().substring(0, 2)))
                    .set二月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(SUBSTRING_5).equals(三月)) {
            list.get(rstringToInt(jissiJyokyohyoHakkouEntity.get取得条件().substring(0, 2)))
                    .set三月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(SUBSTRING_5).equals(四月)) {
            list.get(rstringToInt(jissiJyokyohyoHakkouEntity.get取得条件().substring(0, 2)))
                    .set四月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(SUBSTRING_5).equals(五月)) {
            list.get(rstringToInt(jissiJyokyohyoHakkouEntity.get取得条件().substring(0, 2)))
                    .set五月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(SUBSTRING_5).equals(六月)) {
            list.get(rstringToInt(jissiJyokyohyoHakkouEntity.get取得条件().substring(0, 2)))
                    .set六月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(SUBSTRING_5).equals(七月)) {
            list.get(rstringToInt(jissiJyokyohyoHakkouEntity.get取得条件().substring(0, 2)))
                    .set七月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(SUBSTRING_5).equals(八月)) {
            list.get(rstringToInt(jissiJyokyohyoHakkouEntity.get取得条件().substring(0, 2)))
                    .set八月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(SUBSTRING_5).equals(九月)) {
            list.get(rstringToInt(jissiJyokyohyoHakkouEntity.get取得条件().substring(0, 2)))
                    .set九月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(SUBSTRING_5).equals(十月)) {
            list.get(rstringToInt(jissiJyokyohyoHakkouEntity.get取得条件().substring(0, 2)))
                    .set十月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(SUBSTRING_5).equals(十一月)) {
            list.get(rstringToInt(jissiJyokyohyoHakkouEntity.get取得条件().substring(0, 2)))
                    .set十一月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(SUBSTRING_5).equals(十二月)) {
            list.get(rstringToInt(jissiJyokyohyoHakkouEntity.get取得条件().substring(0, 2)))
                    .set十二月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
    }

    private int rstringToInt(RString rstring) {
        return Integer.parseInt(rstring.toString()) - 1;
    }

    private int 年度合計(YokaigoNinteiJisshiJokyohyoEntity target) {
        return target.get一月の合計()
                + target.get二月の合計()
                + target.get三月の合計()
                + target.get十月の合計()
                + target.get五月の合計()
                + target.get六月の合計()
                + target.get七月の合計()
                + target.get八月の合計()
                + target.get九月の合計()
                + target.get十月の合計()
                + target.get十一月の合計()
                + target.get十二月の合計();
    }

    private void 実施状況リストEntity作成() {
        for (int index = 0; index < INDEX_12; index++) {
            実施状況Entity.get実施状況リスト1().get(index).set市町村番号(beforeEntity.get市町村コード().value());
            実施状況Entity.get実施状況リスト1().get(index).set市町村名(beforeEntity.get市町村名());
            実施状況Entity.get実施状況リスト2().get(index).set市町村番号(beforeEntity.get市町村コード().value());
            実施状況Entity.get実施状況リスト2().get(index).set市町村名(beforeEntity.get市町村名());
            実施状況Entity.get実施状況リスト3().get(index).set市町村番号(beforeEntity.get市町村コード().value());
            実施状況Entity.get実施状況リスト3().get(index).set市町村名(beforeEntity.get市町村名());
            実施状況Entity.get実施状況リスト4().get(index).set市町村番号(beforeEntity.get市町村コード().value());
            実施状況Entity.get実施状況リスト4().get(index).set市町村名(beforeEntity.get市町村名());
            実施状況Entity.get実施状況リスト5().get(index).set市町村番号(beforeEntity.get市町村コード().value());
            実施状況Entity.get実施状況リスト5().get(index).set市町村名(beforeEntity.get市町村名());
        }
        for (int index = 0; index < INDEX_12; index++) {
            実施状況Entity.get実施状況リスト2().get(index).set年度合計(年度合計(実施状況Entity.get実施状況リスト2().get(index)));
            実施状況Entity.get実施状況リスト3().get(index).set年度合計(年度合計(実施状況Entity.get実施状況リスト3().get(index)));
            実施状況Entity.get実施状況リスト4().get(index).set年度合計(年度合計(実施状況Entity.get実施状況リスト4().get(index)));
        }
        for (int index = 0; index < INDEX_12; index++) {
            実施状況Entity.get実施状況リスト1().get(index).set一月の合計(
                    実施状況Entity.get実施状況リスト2().get(index).get一月の合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get一月の合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get一月の合計());
            実施状況Entity.get実施状況リスト1().get(index).set二月の合計(
                    実施状況Entity.get実施状況リスト2().get(index).get二月の合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get二月の合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get二月の合計());
            実施状況Entity.get実施状況リスト1().get(index).set三月の合計(
                    実施状況Entity.get実施状況リスト2().get(index).get三月の合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get三月の合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get三月の合計());
            実施状況Entity.get実施状況リスト1().get(index).set四月の合計(
                    実施状況Entity.get実施状況リスト2().get(index).get四月の合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get四月の合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get四月の合計());
            実施状況Entity.get実施状況リスト1().get(index).set五月の合計(
                    実施状況Entity.get実施状況リスト2().get(index).get五月の合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get五月の合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get五月の合計());
            実施状況Entity.get実施状況リスト1().get(index).set六月の合計(
                    実施状況Entity.get実施状況リスト2().get(index).get六月の合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get六月の合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get六月の合計());
            実施状況Entity.get実施状況リスト1().get(index).set七月の合計(
                    実施状況Entity.get実施状況リスト2().get(index).get七月の合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get七月の合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get七月の合計());
            実施状況Entity.get実施状況リスト1().get(index).set八月の合計(
                    実施状況Entity.get実施状況リスト2().get(index).get八月の合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get八月の合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get八月の合計());
            実施状況Entity.get実施状況リスト1().get(index).set九月の合計(
                    実施状況Entity.get実施状況リスト2().get(index).get九月の合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get九月の合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get九月の合計());
            実施状況Entity.get実施状況リスト1().get(index).set十月の合計(
                    実施状況Entity.get実施状況リスト2().get(index).get十月の合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get十月の合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get十月の合計());
            実施状況Entity.get実施状況リスト1().get(index).set十一月の合計(
                    実施状況Entity.get実施状況リスト2().get(index).get十一月の合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get十一月の合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get十一月の合計());
            実施状況Entity.get実施状況リスト1().get(index).set十二月の合計(
                    実施状況Entity.get実施状況リスト2().get(index).get十二月の合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get十二月の合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get十二月の合計());
            実施状況Entity.get実施状況リスト1().get(index).set年度合計(
                    実施状況Entity.get実施状況リスト2().get(index).get年度合計()
                    + 実施状況Entity.get実施状況リスト3().get(index).get年度合計()
                    + 実施状況Entity.get実施状況リスト4().get(index).get年度合計());
        }
        for (int index = 0; index < INDEX_12; index++) {
            jisshiJokyohyoReportEntity = new YokaigoNinteiJisshiJokyohyoReportEntity();
            jisshiJokyohyoReportEntity.set集計項目(集計項目(index));
            実施状況リストEntity.get実施状況Entityリスト1().add(jokyohyoEntityToJokyohyoReportEntity(実施状況Entity.get実施状況リスト1().get(index)));
            jisshiJokyohyoReportEntity = new YokaigoNinteiJisshiJokyohyoReportEntity();
            jisshiJokyohyoReportEntity.set市町村番号(実施状況Entity.get実施状況リスト2().get(index).get市町村番号());
            jisshiJokyohyoReportEntity.set市町村名(実施状況Entity.get実施状況リスト2().get(index).get市町村名());
            jisshiJokyohyoReportEntity.set集計項目(集計項目新規);
            jisshiJokyohyoReportEntity.set対象年度(parameter.get対象年度());
            jisshiJokyohyoReportEntity.set一月の合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get一月の合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get一月の合計())).concat(")"));
            jisshiJokyohyoReportEntity.set二月の合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get二月の合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get二月の合計())).concat(")"));
            jisshiJokyohyoReportEntity.set三月の合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get三月の合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get三月の合計())).concat(")"));
            jisshiJokyohyoReportEntity.set四月の合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get四月の合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get四月の合計())).concat(")"));
            jisshiJokyohyoReportEntity.set五月の合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get五月の合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get五月の合計())).concat(")"));
            jisshiJokyohyoReportEntity.set六月の合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get六月の合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get六月の合計())).concat(")"));
            jisshiJokyohyoReportEntity.set七月の合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get七月の合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get七月の合計())).concat(")"));
            jisshiJokyohyoReportEntity.set八月の合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get八月の合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get八月の合計())).concat(")"));
            jisshiJokyohyoReportEntity.set九月の合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get九月の合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get九月の合計())).concat(")"));
            jisshiJokyohyoReportEntity.set十月の合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get十月の合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get十月の合計())).concat(")"));
            jisshiJokyohyoReportEntity.set十一月の合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get十一月の合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get十一月の合計())).concat(")"));
            jisshiJokyohyoReportEntity.set十二月の合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get十二月の合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get十二月の合計())).concat(")"));
            jisshiJokyohyoReportEntity.set年度合計(new RString(実施状況Entity.get実施状況リスト2().get(index).get年度合計())
                    .concat("(").concat(new RString(実施状況Entity.get実施状況リスト5().get(index).get年度合計())).concat(")"));
            実施状況リストEntity.get実施状況Entityリスト2().add(jisshiJokyohyoReportEntity);
            jisshiJokyohyoReportEntity = new YokaigoNinteiJisshiJokyohyoReportEntity();
            jisshiJokyohyoReportEntity.set集計項目(集計項目更新);
            実施状況リストEntity.get実施状況Entityリスト3().add(jokyohyoEntityToJokyohyoReportEntity(実施状況Entity.get実施状況リスト3().get(index)));
            jisshiJokyohyoReportEntity = new YokaigoNinteiJisshiJokyohyoReportEntity();
            jisshiJokyohyoReportEntity.set集計項目(集計項目区分変更);
            実施状況リストEntity.get実施状況Entityリスト4().add(jokyohyoEntityToJokyohyoReportEntity(実施状況Entity.get実施状況リスト4().get(index)));

        }
    }

    private RString 集計項目(int index) {
        if (index == 0) {
            return 集計項目申請受付件数;
        } else if (index == 1) {
            return 集計項目申請取下げ件数;
        } else if (index == 2) {
            return 集計項目申請却下件数;
        } else if (index == INDEX_3) {
            return 集計項目調査依頼件数;
        } else if (index == INDEX_4) {
            return 集計項目調査予定件数;
        } else if (index == INDEX_5) {
            return 集計項目調査実施件数;
        } else if (index == INDEX_6) {
            return 集計項目意見書依頼件数;
        } else if (index == INDEX_7) {
            return 集計項目意見書取寄せ予定件数;
        } else if (index == INDEX_8) {
            return 集計項目意見書取寄せ件数;
        } else if (index == INDEX_9) {
            return 集計項目審査会依頼件数;
        } else if (index == INDEX_10) {
            return 集計項目審査会回答予定件数;
        } else if (index == INDEX_11) {
            return 集計項目審査会回答件数;
        }
        return RString.EMPTY;
    }

    @Override
    protected void afterExecute() {
        if (beforeEntity != null) {
            実施状況リストEntity作成();
        }
        FlexibleDate 基準日 = FlexibleDate.EMPTY;
        RString 地区 = RString.EMPTY;
        RString 集計単位 = RString.EMPTY;
        RString 年齢 = new RString(parameter.get年齢From())
                .concat("～").concat(new RString(parameter.get年齢To()));
        地区 = set地区(地区);
        集計単位 = set集計単位(集計単位);
        YokaigoNinteiJisshiJokyohyoReport report = YokaigoNinteiJisshiJokyohyoReport.createReport(
                基準日,
                年齢,
                地区,
                集計単位,
                実施状況リストEntity.get実施状況Entityリスト1(),
                実施状況リストEntity.get実施状況Entityリスト2(),
                実施状況リストEntity.get実施状況Entityリスト3(),
                実施状況リストEntity.get実施状況Entityリスト4());
        report.writeBy(reportSourceWriter);
        outputJokenhyoFactory();
    }

    private YokaigoNinteiJisshiJokyohyoReportEntity jokyohyoEntityToJokyohyoReportEntity(
            YokaigoNinteiJisshiJokyohyoEntity jisshiJokyohyoEntity) {
        jisshiJokyohyoReportEntity.set市町村番号(jisshiJokyohyoEntity.get市町村番号());
        jisshiJokyohyoReportEntity.set市町村名(jisshiJokyohyoEntity.get市町村名());
        jisshiJokyohyoReportEntity.set対象年度(parameter.get対象年度());
        jisshiJokyohyoReportEntity.set一月の合計(new RString(jisshiJokyohyoEntity.get一月の合計()));
        jisshiJokyohyoReportEntity.set二月の合計(new RString(jisshiJokyohyoEntity.get二月の合計()));
        jisshiJokyohyoReportEntity.set三月の合計(new RString(jisshiJokyohyoEntity.get三月の合計()));
        jisshiJokyohyoReportEntity.set四月の合計(new RString(jisshiJokyohyoEntity.get四月の合計()));
        jisshiJokyohyoReportEntity.set五月の合計(new RString(jisshiJokyohyoEntity.get五月の合計()));
        jisshiJokyohyoReportEntity.set六月の合計(new RString(jisshiJokyohyoEntity.get六月の合計()));
        jisshiJokyohyoReportEntity.set七月の合計(new RString(jisshiJokyohyoEntity.get七月の合計()));
        jisshiJokyohyoReportEntity.set八月の合計(new RString(jisshiJokyohyoEntity.get八月の合計()));
        jisshiJokyohyoReportEntity.set九月の合計(new RString(jisshiJokyohyoEntity.get九月の合計()));
        jisshiJokyohyoReportEntity.set十月の合計(new RString(jisshiJokyohyoEntity.get十月の合計()));
        jisshiJokyohyoReportEntity.set十一月の合計(new RString(jisshiJokyohyoEntity.get十一月の合計()));
        jisshiJokyohyoReportEntity.set十二月の合計(new RString(jisshiJokyohyoEntity.get十二月の合計()));
        jisshiJokyohyoReportEntity.set年度合計(new RString(jisshiJokyohyoEntity.get年度合計()));
        return jisshiJokyohyoReportEntity;
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBD.DBD300003.getReportId().getColumnValue().substring(0, SUBSTRING_9),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD300003.getReportName(),
                new RString("5"),
                new RString("なし"),
                new RString("なし"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private RString set地区(RString 地区) {
        if (parameter.get地区区分().equals(地区区分全て)) {
            地区 = 地区全て;

        } else {
            地区 = new RString(parameter.get開始地区コード().toString())
                    .concat("～")
                    .concat(new RString(parameter.get終了地区コード().toString()));
        }
        return 地区;
    }

    private RString set集計単位(RString 集計単位) {
        if (parameter.get集計単位().equals(集計単位受給申請)) {
            集計単位 = 受給申請事由;
        } else if (parameter.get集計単位().equals(集計単位申請時)) {
            集計単位 = 申請区分申請時;

        } else if (parameter.get集計単位().equals(集計単位法令)) {
            集計単位 = 申請区分法令;
        }
        return 集計単位;
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(new RString("【対象年月日】 " + parameter.get対象年度().wareki().toDateString()));
        出力条件.add(new RString("【地区区分】 " + parameter.get地区区分()));
        出力条件.add(new RString("【開始地区コード】 " + parameter.get開始地区コード()));
        出力条件.add(new RString("【終了地区コード】 " + parameter.get終了地区コード()));
        出力条件.add(new RString("【集計単位】 " + parameter.get集計単位()));
        出力条件.add(new RString("【年齢From】 " + parameter.get年齢From()));
        出力条件.add(new RString("【年齢To】 " + parameter.get年齢To()));
        if (parameter.get年齢基準日() == null || parameter.get年齢基準日().isEmpty()) {
            出力条件.add(new RString("【年齢基準日】 "));
        } else {
            出力条件.add(new RString("【年齢基準日】 " + parameter.get年齢基準日().wareki().toDateString()));
        }
        if (parameter.get生年月日From() == null || parameter.get生年月日To() == null) {
            出力条件.add(new RString("【生年月日From】 "));
            出力条件.add(new RString("【生年月日To】 "));
        } else {
            出力条件.add(new RString("【生年月日From】 " + parameter.get生年月日From()));
            出力条件.add(new RString("【生年月日To】 " + parameter.get生年月日To()));
        }
        return 出力条件;
    }
}
