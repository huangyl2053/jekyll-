/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080;

import jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist.ShoriKekkaKakuninListReport;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hokenkyufushokankettei.JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.TempDwbTKyufujissekiShukeiKonkyo1Entity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.shorikekkakakuninlist.ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 処理結果確認リスト前後給付率エラーフラグ分のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
public class ShoriKekkaKakuninListZengoKyufurituProcess extends BatchProcessBase<TempDwbTKyufujissekiShukeiKonkyo1Entity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hokenkyufushokankettei."
            + "IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper.getShoriKekkaKakuninListByZengoKyufuritu");
    private static final RString 項目コード1 = new RString("入力識別番号");
    private static final RString 項目コード2 = new RString("被保険者番号");
    private static final RString 項目コード3 = new RString("サービス提供年月");
    private static final RString 項目コード4 = new RString("事業者番号");
    private static final RString プログラムID = new RString("DBU010060");
    private static final RString 内容1 = new RString("前後履歴の保険給付率が異なっています。");
    private static final RString 処理名称 = new RString("保険給付決定状況償還分決定年月");
    private static final RString 内容２_１ = new RString("修正前の保険給付率を");
    private static final RString 内容２_２ = new RString("で計算しています。");
    private JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter processParameter;
    @BatchWriter
    private BatchReportWriter<ShoriKekkaKakuninListReportSource> batchWrite;
    private ReportSourceWriter<ShoriKekkaKakuninListReportSource> reportSourceWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBU200002.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(TempDwbTKyufujissekiShukeiKonkyo1Entity entity) {
        ShoriKekkaKakuninListEntity listEntity = new ShoriKekkaKakuninListEntity();
        listEntity.set作成日時(new RString(processParameter.get処理日時().toString()));
        listEntity.set保険者番号(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value());
        listEntity.set保険者名(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
        listEntity.set項目コード1(項目コード1);
        listEntity.set項目コード2(項目コード2);
        listEntity.set項目コード3(項目コード3);
        listEntity.set項目コード4(項目コード4);
        listEntity.setプログラムID(プログラムID);
        listEntity.set項目値1(entity.getInputShikibetsuNo());
        listEntity.set項目値2(entity.getHihokenshaNo().value());
        listEntity.set項目値3(entity.getServiceTeikyoYM());
        listEntity.set項目値4(entity.getJigyoshaNo().value());
        listEntity.set内容1(内容1);
        listEntity.set処理名称(処理名称);
        RStringBuilder builder = new RStringBuilder();
        builder.append(内容２_１);
        builder.append(entity.getHokenKyufuritsu());
        builder.append(内容２_２);
        listEntity.set内容2(builder.toRString());
        ShoriKekkaKakuninListReport report = new ShoriKekkaKakuninListReport(listEntity);
        report.writeBy(reportSourceWriter);
    }
}
