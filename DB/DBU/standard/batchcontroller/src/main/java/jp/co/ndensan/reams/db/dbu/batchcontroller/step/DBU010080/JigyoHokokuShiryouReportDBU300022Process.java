/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201Business;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki2220161.JigyohokokuGeppoYoshiki2220161Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNoyoshiki2;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hokenkyufushokankettei.JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.JigyoHokokuShiryouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki2220161.JigyohokokuGeppoYoshiki2220161ReportSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業報告月報様式_04帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
public class JigyoHokokuShiryouReportDBU300022Process extends BatchProcessBase<JigyoHokokuShiryouRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hokenkyufushokankettei."
            + "IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper.getJigyouHokoku_Hokensha");
    private static final RString 構成市町村 = new RString("1");
    private static final RString 旧市町村 = new RString("2");
    private JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter processParameter;
    @BatchWriter
    private BatchReportWriter<JigyohokokuGeppoYoshiki2220161ReportSource> 様式_04batchWrite;
    private ReportSourceWriter<JigyohokokuGeppoYoshiki2220161ReportSource> 様式_04reportSourceWriter;
    private List<RString> 市町村コードList;
    private List<RString> 表番号List;
    private RString 引数Flag;
    private JigyohokokuCompYoshiki201Business business;
    private List<JigyoHokokuShiryouRelateEntity> list;
    private List<RString> page_break_keys;

    @Override
    protected void initialize() {
        市町村コードList = new ArrayList<>();
        表番号List = new ArrayList<>();
        list = new ArrayList<>();
        business = new JigyohokokuCompYoshiki201Business();
        引数Flag = RString.EMPTY;
        if (RString.isNullOrEmpty(processParameter.get過去集計分旧市町村区分())) {
            市町村コードList.add(processParameter.get市町村コード());
            表番号List.add(new RString("06"));
            引数Flag = new RString("1");
        } else if (構成市町村.equals(processParameter.get過去集計分旧市町村区分())) {
            市町村コードList.addAll(processParameter.get過去集計分市町村コードリスト());
            表番号List.add(new RString("06"));
            引数Flag = new RString("2");
        } else if (旧市町村.equals(processParameter.get過去集計分旧市町村区分())) {
            市町村コードList.addAll(processParameter.get過去集計分市町村コードリスト());
            表番号List.add(new RString("16"));
            引数Flag = new RString("3");
        }
        business.set年報月報区分(new RString("1"));
        business.set処理日時(processParameter.get処理日時().getRDateTime());
        if (new RString("1").equals(引数Flag)) {
            business.set旧市町村区分(new RString("0"));
            business.set保険者コード(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value());
        } else if (new RString("2").equals(引数Flag)) {
            business.set旧市町村区分(new RString("0"));
        } else if (new RString("3").equals(引数Flag)) {
            business.set旧市町村区分(new RString("1"));
        }
        business.set保険者名(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
        business.set集計年月(processParameter.get集計年月());
        business.set給付実績区分コード(new RString("2"));
        page_break_keys = Collections.unmodifiableList(
                Arrays.asList(new RString(ReportSourceFields.hokenjano.name()), new RString(ReportSourceFields.title1.name()),
                        new RString(ReportSourceFields.title2.name())));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.create事業状況報告取得MybitisParamter(市町村コードList, 表番号List));
    }

    @Override
    protected void createWriter() {
        様式_04batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBU300022.getReportId().value())
                .addBreak(new BreakerCatalog<JigyohokokuGeppoYoshiki2220161ReportSource>().simplePageBreaker(page_break_keys)).create();
        様式_04reportSourceWriter = new ReportSourceWriter(様式_04batchWrite);
    }

    @Override
    protected void process(JigyoHokokuShiryouRelateEntity entity) {
        list.add(entity);
    }

    @Override
    protected void afterExecute() {
        business.set事業報告資料(list);
        if (RString.isNullOrEmpty(processParameter.get過去集計分旧市町村区分())) {
            print帳票(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value());
        } else {
            for (RString 市町村コード : processParameter.get過去集計分市町村コードリスト()) {
                print帳票(市町村コード);
            }
        }
    }

    private void print帳票(RString 市町村コード) {
        for (JigyoHokokuShiryouRelateEntity entity : list) {
            if (市町村コード.equals(entity.getShichosonCode())
                    && (ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_単位数.getコード().equals(entity.getSyukeiNo()))) {
                business.set保険者コード(市町村コード);
                JigyohokokuGeppoYoshiki2220161Report 様式_04report = new JigyohokokuGeppoYoshiki2220161Report(business);
                様式_04report.writeBy(様式_04reportSourceWriter);
            }
        }
    }
}
