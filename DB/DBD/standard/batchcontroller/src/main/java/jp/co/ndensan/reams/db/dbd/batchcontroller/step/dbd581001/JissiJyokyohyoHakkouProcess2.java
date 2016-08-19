/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd581001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd300004.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd581001.YokaigoJissiJyokyohyoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd581001.JissiJyokyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd581001.JissiJyokyohyoHakkouEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijisshijokyohyo.YokaigoNinteiJisshiJokyohyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijisshijokyohyo.YokaigoNinteiJisshiJokyohyoReportEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300004.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定月別受給者数状況表（統計表）の発行_process処理クラスです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
public class JissiJyokyohyoHakkouProcess2 extends BatchProcessBase<JissiJyokyohyoHakkouEntity> {

    private static final ReportId REPORT_DBD300004 = ReportIdDBD.DBD300004.getReportId();
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigojissijyokyohyo."
                    + "IYokaigoJissiJyokyohyoHakkouMapper.get帳票DBD300004の場合のデータ");
    @BatchWriter
    private BatchReportWriter<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource> batchReportWriter;
    private ReportSourceWriter<YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource> reportSourceWriter;
    private YokaigoJissiJyokyohyoProcessParameter parameter;
    private JissiJyokyoEntity 実施状況Entity;
    private YokaigoNinteiJisshiJokyohyoEntity yokaigoNinteiJisshiJokyohyoEntity;
    private YokaigoNinteiJisshiJokyohyoReportEntity yokaigoNinteiJisshiJokyohyoReportEntity;
    private JissiJyokyohyoHakkouEntity beforeJissiJyokyohyoHakkouEntity = null;

    @Override
    protected void initialize() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD300004.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
        実施状況Entity = new JissiJyokyoEntity();
        実施状況Entity.set実施状況リスト1(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト2(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト3(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト4(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト5(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト6(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト7(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト8(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト9(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト10(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト11(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト12(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト13(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト14(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト15(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト16(new ArrayList<YokaigoNinteiJisshiJokyohyoEntity>());
        実施状況Entity.set実施状況リスト(new ArrayList<YokaigoNinteiJisshiJokyohyoReportEntity>());
        yokaigoNinteiJisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toYokaigoJissiJyokyohyoHakkouMybatisParameter());
    }

    @Override
    protected void process(JissiJyokyohyoHakkouEntity jissiJyokyohyoHakkouEntity) {
        if (beforeJissiJyokyohyoHakkouEntity != null
                && !jissiJyokyohyoHakkouEntity.get取得条件().equals(beforeJissiJyokyohyoHakkouEntity.get取得条件())) {
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("01"))) {
                実施状況Entity.get実施状況リスト2().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("02"))) {
                実施状況Entity.get実施状況リスト3().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("03"))) {
                実施状況Entity.get実施状況リスト4().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("04"))) {
                実施状況Entity.get実施状況リスト5().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("05"))) {
                実施状況Entity.get実施状況リスト6().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("06"))) {
                実施状況Entity.get実施状況リスト7().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("07"))) {
                実施状況Entity.get実施状況リスト8().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("08"))) {
                実施状況Entity.get実施状況リスト9().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("09"))) {
                実施状況Entity.get実施状況リスト10().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("10"))) {
                実施状況Entity.get実施状況リスト11().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("11"))) {
                実施状況Entity.get実施状況リスト12().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("12"))) {
                実施状況Entity.get実施状況リスト13().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("13"))) {
                実施状況Entity.get実施状況リスト14().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("14"))) {
                実施状況Entity.get実施状況リスト15().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            if (beforeJissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("15"))) {
                実施状況Entity.get実施状況リスト16().add(yokaigoNinteiJisshiJokyohyoEntity);
            }
            yokaigoNinteiJisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
        }
        実施状況リスト作成(jissiJyokyohyoHakkouEntity);
        beforeJissiJyokyohyoHakkouEntity = jissiJyokyohyoHakkouEntity;
    }

    private void 実施状況リスト作成(JissiJyokyohyoHakkouEntity jissiJyokyohyoHakkouEntity) {
        yokaigoNinteiJisshiJokyohyoEntity.set市町村番号(jissiJyokyohyoHakkouEntity.get市町村コード().code市町村RString());
        yokaigoNinteiJisshiJokyohyoEntity.set市町村名(jissiJyokyohyoHakkouEntity.get市町村名());
        if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("01"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("02"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("新規（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("03"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("新規（旧措置"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("04"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("要支援（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("05"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("要支援（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("06"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("更新（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("07"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("更新（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("08"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("区分変更（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("09"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("区分変更（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("10"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("転入（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("11"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("転入（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("12"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("職権他（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("13"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("職権他（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("14"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("資格喪失（旧措置）"));
        } else if (jissiJyokyohyoHakkouEntity.get取得条件().substring(2).equals(new RString("15"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("資格喪失（旧措置）"));
        }

        if (jissiJyokyohyoHakkouEntity.get年月().substring(4).equals(new RString("01"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set一月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(4).equals(new RString("02"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set二月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(4).equals(new RString("03"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set三月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(4).equals(new RString("04"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set四月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(4).equals(new RString("05"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set五月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(4).equals(new RString("06"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set六月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(4).equals(new RString("07"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set七月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(4).equals(new RString("08"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set八月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(4).equals(new RString("09"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set九月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(4).equals(new RString("10"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set十月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(4).equals(new RString("11"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set十一月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        if (jissiJyokyohyoHakkouEntity.get年月().substring(4).equals(new RString("12"))) {
            yokaigoNinteiJisshiJokyohyoEntity.set十二月の合計(jissiJyokyohyoHakkouEntity.get数量());
        }
        yokaigoNinteiJisshiJokyohyoEntity.set年度合計(yokaigoNinteiJisshiJokyohyoEntity.get年度合計() + jissiJyokyohyoHakkouEntity.get数量() - 1);
    }

    @Override
    protected void afterExecute() {
        実施状況Entity.get実施状況リスト16().add(yokaigoNinteiJisshiJokyohyoEntity);
        for (int index = 0; index < 10; index++) {
            yokaigoNinteiJisshiJokyohyoEntity = new YokaigoNinteiJisshiJokyohyoEntity();
            if (index == 0) {
                yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("認定件数（旧措置）"));
            } else if (index == 1) {
                yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("要介護度1（旧措置）"));
            } else if (index == 2) {
                yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("要介護度2（旧措置）"));
            } else if (index == 3) {
                yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("要介護度3（旧措置）"));
            } else if (index == 4) {
                yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("要介護度4（旧措置）"));
            } else if (index == 5) {
                yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("要介護度5（旧措置）"));
            } else if (index == 6) {
                yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("要支援1（旧措置）"));
            } else if (index == 7) {
                yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("要支援2（旧措置）"));
            } else if (index == 8) {
                yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("要支援（旧措置）"));
            } else if (index == 9) {
                yokaigoNinteiJisshiJokyohyoEntity.set集計項目(new RString("自立（旧措置）"));
            }
            yokaigoNinteiJisshiJokyohyoEntity.set一月の合計(
                    実施状況Entity.get実施状況リスト3().get(index).get一月の合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get一月の合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get一月の合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get一月の合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get一月の合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get一月の合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get一月の合計());
            yokaigoNinteiJisshiJokyohyoEntity.set二月の合計(
                    実施状況Entity.get実施状況リスト3().get(index).get二月の合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get二月の合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get二月の合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get二月の合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get二月の合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get二月の合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get二月の合計());
            yokaigoNinteiJisshiJokyohyoEntity.set三月の合計(
                    実施状況Entity.get実施状況リスト3().get(index).get三月の合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get三月の合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get三月の合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get三月の合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get三月の合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get三月の合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get三月の合計());
            yokaigoNinteiJisshiJokyohyoEntity.set四月の合計(
                    実施状況Entity.get実施状況リスト3().get(index).get四月の合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get四月の合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get四月の合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get四月の合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get四月の合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get四月の合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get四月の合計());
            yokaigoNinteiJisshiJokyohyoEntity.set五月の合計(
                    実施状況Entity.get実施状況リスト3().get(index).get五月の合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get五月の合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get五月の合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get五月の合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get五月の合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get五月の合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get五月の合計());
            yokaigoNinteiJisshiJokyohyoEntity.set六月の合計(
                    実施状況Entity.get実施状況リスト3().get(index).get六月の合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get六月の合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get六月の合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get六月の合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get六月の合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get六月の合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get六月の合計());
            yokaigoNinteiJisshiJokyohyoEntity.set七月の合計(
                    実施状況Entity.get実施状況リスト3().get(index).get七月の合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get七月の合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get七月の合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get七月の合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get七月の合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get七月の合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get七月の合計());
            yokaigoNinteiJisshiJokyohyoEntity.set八月の合計(
                    実施状況Entity.get実施状況リスト3().get(index).get八月の合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get八月の合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get八月の合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get八月の合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get八月の合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get八月の合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get八月の合計());
            yokaigoNinteiJisshiJokyohyoEntity.set九月の合計(
                    実施状況Entity.get実施状況リスト3().get(index).get九月の合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get九月の合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get九月の合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get九月の合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get九月の合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get九月の合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get九月の合計());
            yokaigoNinteiJisshiJokyohyoEntity.set十月の合計(
                    実施状況Entity.get実施状況リスト3().get(index).get十月の合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get十月の合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get十月の合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get十月の合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get十月の合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get十月の合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get十月の合計());
            yokaigoNinteiJisshiJokyohyoEntity.set十一月の合計(
                    実施状況Entity.get実施状況リスト3().get(index).get十一月の合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get十一月の合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get十一月の合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get十一月の合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get十一月の合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get十一月の合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get十一月の合計());
            yokaigoNinteiJisshiJokyohyoEntity.set十二月の合計(
                    実施状況Entity.get実施状況リスト3().get(index).get十二月の合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get十二月の合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get十二月の合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get十二月の合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get十二月の合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get十二月の合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get十二月の合計());
            yokaigoNinteiJisshiJokyohyoEntity.set年度合計(
                    実施状況Entity.get実施状況リスト3().get(index).get年度合計()
                    + 実施状況Entity.get実施状況リスト5().get(index).get年度合計()
                    + 実施状況Entity.get実施状況リスト7().get(index).get年度合計()
                    + 実施状況Entity.get実施状況リスト9().get(index).get年度合計()
                    + 実施状況Entity.get実施状況リスト11().get(index).get年度合計()
                    + 実施状況Entity.get実施状況リスト13().get(index).get年度合計()
                    + 実施状況Entity.get実施状況リスト15().get(index).get年度合計());
            実施状況Entity.get実施状況リスト1().add(yokaigoNinteiJisshiJokyohyoEntity);

        }
        for (int index = 0; index < 10; index++) {
            実施状況Entity.get実施状況リスト().add(JokyohyoEntityToJokyohyoReportEntity(実施状況Entity.get実施状況リスト1().get(index),
                    実施状況Entity.get実施状況リスト2().get(index)));
            実施状況Entity.get実施状況リスト().add(JokyohyoEntityToJokyohyoReportEntity(実施状況Entity.get実施状況リスト3().get(index),
                    実施状況Entity.get実施状況リスト4().get(index)));
            実施状況Entity.get実施状況リスト().add(JokyohyoEntityToJokyohyoReportEntity(実施状況Entity.get実施状況リスト5().get(index),
                    実施状況Entity.get実施状況リスト6().get(index)));
            実施状況Entity.get実施状況リスト().add(JokyohyoEntityToJokyohyoReportEntity(実施状況Entity.get実施状況リスト7().get(index),
                    実施状況Entity.get実施状況リスト8().get(index)));
            実施状況Entity.get実施状況リスト().add(JokyohyoEntityToJokyohyoReportEntity(実施状況Entity.get実施状況リスト9().get(index),
                    実施状況Entity.get実施状況リスト10().get(index)));
            実施状況Entity.get実施状況リスト().add(JokyohyoEntityToJokyohyoReportEntity(実施状況Entity.get実施状況リスト11().get(index),
                    実施状況Entity.get実施状況リスト12().get(index)));
            実施状況Entity.get実施状況リスト().add(JokyohyoEntityToJokyohyoReportEntity(実施状況Entity.get実施状況リスト13().get(index),
                    実施状況Entity.get実施状況リスト14().get(index)));
            実施状況Entity.get実施状況リスト().add(JokyohyoEntityToJokyohyoReportEntity(実施状況Entity.get実施状況リスト15().get(index),
                    実施状況Entity.get実施状況リスト16().get(index)));
        }
        FlexibleDate 基準日 = FlexibleDate.EMPTY;
        RString 年齢 = new RString(parameter.get年齢From())
                .concat(new RString("～"))
                .concat(new RString(parameter.get年齢To()));
        RString 地区 = RString.EMPTY;
        RString 集計単位 = RString.EMPTY;
        if (parameter.get地区区分().equals(new RString("ALL"))) {
            地区 = new RString("全て");

        } else {
            地区 = new RString(parameter.get開始地区コード().toString())
                    .concat(new RString("～"))
                    .concat(new RString(parameter.get終了地区コード().toString()));
        }
        if (parameter.get集計単位().equals(new RString("ZIYU"))) {
            集計単位 = new RString("受給申請事由");
        } else if (parameter.get集計単位().equals(new RString("SHINSEIZI"))) {
            集計単位 = new RString("申請区分(申請時)");

        } else if (parameter.get集計単位().equals(new RString("HOUREI"))) {
            集計単位 = new RString("申請区分(法令)");
        }

        YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport report = new YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReport(
                基準日,
                年齢,
                地区,
                集計単位,
                parameter.get対象年度().getYear(),
                実施状況Entity.get実施状況リスト());
        report.writeBy(reportSourceWriter);
        outputJokenhyoFactory();

    }

    private YokaigoNinteiJisshiJokyohyoReportEntity JokyohyoEntityToJokyohyoReportEntity(
            YokaigoNinteiJisshiJokyohyoEntity yokaigoNinteiJisshiJokyohyoEntity,
            YokaigoNinteiJisshiJokyohyoEntity yokaigoNinteiJisshiJokyohyoEntity2) {
        yokaigoNinteiJisshiJokyohyoReportEntity = new YokaigoNinteiJisshiJokyohyoReportEntity();
        yokaigoNinteiJisshiJokyohyoReportEntity.set市町村番号(yokaigoNinteiJisshiJokyohyoEntity.get市町村番号());
        yokaigoNinteiJisshiJokyohyoReportEntity.set市町村名(yokaigoNinteiJisshiJokyohyoEntity.get市町村名());
        yokaigoNinteiJisshiJokyohyoReportEntity.set集計項目(yokaigoNinteiJisshiJokyohyoEntity.get集計項目());
        yokaigoNinteiJisshiJokyohyoReportEntity.set一月の合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get一月の合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get一月の合計())).concat(")"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set二月の合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get二月の合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get二月の合計())).concat(")"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set三月の合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get三月の合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get三月の合計())).concat(")"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set四月の合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get四月の合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get四月の合計())).concat(")"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set五月の合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get五月の合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get五月の合計())).concat(")"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set六月の合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get六月の合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get六月の合計())).concat(")"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set七月の合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get七月の合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get七月の合計())).concat(")"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set八月の合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get八月の合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get八月の合計())).concat(")"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set九月の合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get九月の合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get九月の合計())).concat(")"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set十月の合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get十月の合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get十月の合計())).concat(")"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set十一月の合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get十一月の合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get十一月の合計())).concat(")"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set十二月の合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get十二月の合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get十二月の合計())).concat(")"));
        yokaigoNinteiJisshiJokyohyoReportEntity.set年度合計(new RString(yokaigoNinteiJisshiJokyohyoEntity.get年度合計())
                .concat("(").concat(new RString(yokaigoNinteiJisshiJokyohyoEntity2.get年度合計())).concat(")"));
        return yokaigoNinteiJisshiJokyohyoReportEntity;
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBD.DBD300004.getReportId().getColumnValue().substring(0, 9),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD300004.getReportName(),
                new RString("5ページ"),
                new RString("なし"),
                new RString("なし"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(new RString("【対象年月日】 " + parameter.get対象年度().wareki().toDateString()));
        出力条件.add(new RString("【地区区分】 " + parameter.get地区区分()));
        出力条件.add(new RString("【開始地区コード】 " + parameter.get開始地区コード()));
        出力条件.add(new RString("【終了地区コード】 " + parameter.get終了地区コード()));
        出力条件.add(new RString("【基準日】 " + parameter.get基準日()));
        出力条件.add(new RString("【集計単位】 " + parameter.get集計単位()));
        出力条件.add(new RString("【年齢From】 " + parameter.get年齢From()));
        出力条件.add(new RString("【年齢To】 " + parameter.get年齢To()));
        出力条件.add(new RString("【年齢基準日】 " + parameter.get年齢基準日().wareki().toDateString()));
        出力条件.add(new RString("【生年月日From】 " + parameter.get生年月日From()));
        出力条件.add(new RString("【生年月日To】 " + parameter.get生年月日To()));
        return 出力条件;
    }
}
