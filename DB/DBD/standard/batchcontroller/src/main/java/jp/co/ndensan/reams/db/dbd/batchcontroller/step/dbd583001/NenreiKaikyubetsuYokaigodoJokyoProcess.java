/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd583001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd300005.NenreiKaikyubetsuYokaigodoJokyoReport;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd583001.NenreiKaikyubetsuYokaigodoJokyoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd583001.NenreiKaikyubetsuYokaigodoJokyoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd583001.ToukeiNinzuEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300005.NenreiKaikyubetsuYokaigodoJokyoReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 年齢階級別要介護度状況（統計表）のprocess処理クラスです。
 *
 * @reamsid_L DBD-1790-020 donghj
 */
public class NenreiKaikyubetsuYokaigodoJokyoProcess extends BatchProcessBase<ToukeiNinzuEntity> {

    private static final ReportId REPORT_DBD300005 = ReportIdDBD.DBD300005.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.nenreikaidanbetsuyokaigodujyokyo.INenreiKaikyubetsuYokaigodoJokyoMapper.get人数");
    private NenreiKaikyubetsuYokaigodoJokyoProcessParameter parameter;
    private static final int SUBSTRING_9 = 9;
    private static final int FLAG10 = 10;
    private static final int FLAG16 = 16;
    private static final int FLAG18 = 18;
    private static final int FLAG28 = 28;
    private static final int FLAG42 = 42;
    private static final int FLAG60 = 60;
    private static final int INDEX4 = 4;
    private static final int INDEX16 = 16;
    private static final int INDEX31 = 31;
    private List<ToukeiNinzuEntity> 統計人数Entityリスト;
    private int flag = 0;

    @BatchWriter
    private BatchReportWriter<NenreiKaikyubetsuYokaigodoJokyoReportSource> batchReportWriter;
    private ReportSourceWriter<NenreiKaikyubetsuYokaigodoJokyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        統計人数Entityリスト = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, toNenreiKaikyubetsuYokaigodoJokyoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD300005.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
    }

    @Override
    protected void process(ToukeiNinzuEntity toukeiNinzuEntity) {
        setToukeiNinzuEntityZero(toukeiNinzuEntity);
        統計人数Entityリスト.add(toukeiNinzuEntity);
        ToukeiNinzuEntity toukeiNinzuEntity1 = new ToukeiNinzuEntity();
        ToukeiNinzuEntity toukeiNinzuEntity2 = new ToukeiNinzuEntity();
        initializeToukeiNinzuEntity(toukeiNinzuEntity1);
        initializeToukeiNinzuEntity(toukeiNinzuEntity2);
        flag = flag + 1;
        if (flag == FLAG10 || flag == FLAG42) {
            for (int index = flag - FLAG10; index < flag; index = index + 2) {
                setToukeiNinzuEntity(index, toukeiNinzuEntity1, toukeiNinzuEntity2);
            }
            統計人数Entityリスト.add(toukeiNinzuEntity1);
            統計人数Entityリスト.add(toukeiNinzuEntity2);
            flag = flag + 2;
        }
        if (flag == FLAG28 || flag == FLAG60) {
            for (int index = flag - FLAG16; index < flag; index = index + 2) {
                setToukeiNinzuEntity(index, toukeiNinzuEntity1, toukeiNinzuEntity2);
            }
            統計人数Entityリスト.add(toukeiNinzuEntity1);
            統計人数Entityリスト.add(toukeiNinzuEntity2);
            ToukeiNinzuEntity toukeiNinzuEntity3 = new ToukeiNinzuEntity();
            ToukeiNinzuEntity toukeiNinzuEntity4 = new ToukeiNinzuEntity();
            initializeToukeiNinzuEntity(toukeiNinzuEntity3);
            initializeToukeiNinzuEntity(toukeiNinzuEntity4);
            for (int index = flag - FLAG18; index < flag + 1; index = index + FLAG18) {
                setToukeiNinzuEntity(index, toukeiNinzuEntity3, toukeiNinzuEntity4);
            }
            統計人数Entityリスト.add(toukeiNinzuEntity3);
            統計人数Entityリスト.add(toukeiNinzuEntity4);
            flag = flag + INDEX4;
        }
    }

    @Override
    protected void afterExecute() {
        List<RString> 区分リスト1 = new ArrayList<>();
        List<RString> 区分リスト2 = new ArrayList<>();
        set区分リスト(区分リスト1, 区分リスト2);
        RString 市町村番号 = parameter.get旧市町村コード();
        RString 市町村名 = parameter.get旧市町村名称();
        RDate 基準日 = RDate.getNowDate();
        set基準日(基準日);
        RString 地区 = parameter.get開始地区コード().getColumnValue().concat("～").concat(parameter.get終了地区コード().getColumnValue());
        NenreiKaikyubetsuYokaigodoJokyoReport report = NenreiKaikyubetsuYokaigodoJokyoReport.createReport(
                市町村番号, 市町村名, 基準日, 地区, 区分リスト1, 区分リスト2, 統計人数Entityリスト);
        report.writeBy(reportSourceWriter);
        outputJokenhyoFactory();

    }

    private RDate set基準日(RDate 基準日) {
        if (parameter.get基準日() != null && !parameter.get基準日().toDateString().isEmpty()) {
            基準日 = parameter.get基準日();
        } else {
            基準日 = parameter.get基準年月();
        }
        return 基準日;
    }

    private void set区分リスト(List<RString> 区分リスト1, List<RString> 区分リスト2) {
        for (int index = 0; index <= INDEX31; index++) {
            if (index < INDEX16) {
                区分リスト1.add(new RString("人数"));
                区分リスト2.add(new RString("旧措置"));
            } else {
                区分リスト1.add(new RString("男"));
                区分リスト2.add(new RString("女"));
            }
        }
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                REPORT_DBD300005.getColumnValue().substring(0, SUBSTRING_9),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD300005.getReportName(),
                new RString("2ページ"),
                new RString("なし"),
                new RString("なし"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        if (parameter.get基準日() != null) {
            出力条件.add(new RString("【基準日】　").concat(parameter.get基準日().wareki().toDateString()));
        }
        if (parameter.get基準年月() != null) {
            出力条件.add(new RString("【基準年月】　").concat(parameter.get基準年月().wareki().firstYear(FirstYear.ICHI_NEN).getYearMonth()));
        }
        if (parameter.get地区区分() != null) {
            出力条件.add(new RString("【地区区分】　").concat(parameter.get地区区分()));
        }
        if (parameter.get開始地区コード() != null) {
            出力条件.add(new RString("【開始地区コード】　").concat(parameter.get開始地区コード().value()));
        }
        if (parameter.get終了地区コード() != null) {
            出力条件.add(new RString("【終了地区コード】　").concat(parameter.get終了地区コード().value()));
        }
        if (parameter.get旧市町村コード() != null) {
            出力条件.add(new RString("【旧市町村コード】　").concat(parameter.get旧市町村コード()));
        }
        return 出力条件;
    }

    private NenreiKaikyubetsuYokaigodoJokyoMybatisParameter toNenreiKaikyubetsuYokaigodoJokyoMybatisParameter() {
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        return new NenreiKaikyubetsuYokaigodoJokyoMybatisParameter(parameter.get基準日(), parameter.get基準年月(),
                parameter.get地区区分(), parameter.get開始地区コード(), parameter.get終了地区コード(),
                parameter.get旧市町村コード(), shikibetsuTaishoPSMSearchKey);
    }

    private void setToukeiNinzuEntityZero(ToukeiNinzuEntity toukeiNinzuEntity) {
        if (toukeiNinzuEntity.get自立人数() == null) {
            toukeiNinzuEntity.set自立人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get経過介護人数() == null) {
            toukeiNinzuEntity.set経過介護人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要支援1人数() == null) {
            toukeiNinzuEntity.set要支援1人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要支援2人数() == null) {
            toukeiNinzuEntity.set要支援2人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要介護1人数() == null) {
            toukeiNinzuEntity.set要介護1人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要介護2人数() == null) {
            toukeiNinzuEntity.set要介護2人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要介護3人数() == null) {
            toukeiNinzuEntity.set要介護3人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要介護4人数() == null) {
            toukeiNinzuEntity.set要介護4人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get要介護5人数() == null) {
            toukeiNinzuEntity.set要介護5人数(Decimal.ZERO);
        }
        if (toukeiNinzuEntity.get合計() == null) {
            toukeiNinzuEntity.set合計(Decimal.ZERO);
        }

    }

    private void initializeToukeiNinzuEntity(ToukeiNinzuEntity toukeiNinzuEntity) {
        toukeiNinzuEntity.set自立人数(Decimal.ZERO);
        toukeiNinzuEntity.set経過介護人数(Decimal.ZERO);
        toukeiNinzuEntity.set要支援1人数(Decimal.ZERO);
        toukeiNinzuEntity.set要支援2人数(Decimal.ZERO);
        toukeiNinzuEntity.set要介護1人数(Decimal.ZERO);
        toukeiNinzuEntity.set要介護2人数(Decimal.ZERO);
        toukeiNinzuEntity.set要介護3人数(Decimal.ZERO);
        toukeiNinzuEntity.set要介護4人数(Decimal.ZERO);
        toukeiNinzuEntity.set要介護5人数(Decimal.ZERO);
        toukeiNinzuEntity.set合計(Decimal.ZERO);
    }

    private void setToukeiNinzuEntity(int index, ToukeiNinzuEntity toukeiNinzuEntity1, ToukeiNinzuEntity toukeiNinzuEntity2) {
        toukeiNinzuEntity1.set自立人数(統計人数Entityリスト.get(index).get自立人数().add(toukeiNinzuEntity1.get自立人数()));
        toukeiNinzuEntity2.set自立人数(統計人数Entityリスト.get(index + 1).get自立人数().add(toukeiNinzuEntity2.get自立人数()));
        toukeiNinzuEntity1.set経過介護人数(統計人数Entityリスト.get(index).get経過介護人数().add(toukeiNinzuEntity1.get経過介護人数()));
        toukeiNinzuEntity2.set経過介護人数(統計人数Entityリスト.get(index + 1).get経過介護人数().add(toukeiNinzuEntity2.get経過介護人数()));
        toukeiNinzuEntity1.set要支援1人数(統計人数Entityリスト.get(index).get要支援1人数().add(toukeiNinzuEntity1.get要支援1人数()));
        toukeiNinzuEntity2.set要支援1人数(統計人数Entityリスト.get(index + 1).get要支援1人数().add(toukeiNinzuEntity2.get要支援1人数()));
        toukeiNinzuEntity1.set要支援2人数(統計人数Entityリスト.get(index).get要支援2人数().add(toukeiNinzuEntity1.get要支援2人数()));
        toukeiNinzuEntity2.set要支援2人数(統計人数Entityリスト.get(index + 1).get要支援2人数().add(toukeiNinzuEntity2.get要支援2人数()));
        toukeiNinzuEntity1.set要介護1人数(統計人数Entityリスト.get(index).get要介護1人数().add(toukeiNinzuEntity1.get要介護1人数()));
        toukeiNinzuEntity2.set要介護1人数(統計人数Entityリスト.get(index + 1).get要介護1人数().add(toukeiNinzuEntity2.get要介護1人数()));
        toukeiNinzuEntity1.set要介護2人数(統計人数Entityリスト.get(index).get要介護2人数().add(toukeiNinzuEntity1.get要介護2人数()));
        toukeiNinzuEntity2.set要介護2人数(統計人数Entityリスト.get(index + 1).get要介護2人数().add(toukeiNinzuEntity2.get要介護2人数()));
        toukeiNinzuEntity1.set要介護3人数(統計人数Entityリスト.get(index).get要介護3人数().add(toukeiNinzuEntity1.get要介護3人数()));
        toukeiNinzuEntity2.set要介護3人数(統計人数Entityリスト.get(index + 1).get要介護3人数().add(toukeiNinzuEntity2.get要介護3人数()));
        toukeiNinzuEntity1.set要介護4人数(統計人数Entityリスト.get(index).get要介護4人数().add(toukeiNinzuEntity1.get要介護4人数()));
        toukeiNinzuEntity2.set要介護4人数(統計人数Entityリスト.get(index + 1).get要介護4人数().add(toukeiNinzuEntity2.get要介護4人数()));
        toukeiNinzuEntity1.set要介護5人数(統計人数Entityリスト.get(index).get要介護5人数().add(toukeiNinzuEntity1.get要介護5人数()));
        toukeiNinzuEntity2.set要介護5人数(統計人数Entityリスト.get(index + 1).get要介護5人数().add(toukeiNinzuEntity2.get要介護5人数()));
        toukeiNinzuEntity1.set合計(統計人数Entityリスト.get(index).get合計().add(toukeiNinzuEntity1.get合計()));
        toukeiNinzuEntity2.set合計(統計人数Entityリスト.get(index + 1).get合計().add(toukeiNinzuEntity2.get合計()));
    }

}
