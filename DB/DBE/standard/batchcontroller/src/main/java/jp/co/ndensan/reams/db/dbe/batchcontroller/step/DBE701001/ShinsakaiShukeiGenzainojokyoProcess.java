package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE701001;

import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.ShinsakaiShukeihyoGenzaiEditor;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsakaiShukeiGenzainojokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsakaiShukeihyoGenzaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会集計表（現在の状況別）の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class ShinsakaiShukeiGenzainojokyoProcess extends BatchProcessBase<ShinsakaiShukeihyoGenzaiEntity> {

    private static final RString SELECT_GENZAINOJOKYO = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getShinsakaiShukeiGenzainojokyo");
    private static final RString タイトル = new RString("介護認定審査会集計表（現在の状況別）");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");

    private ShinsakaiShukeiGenzainojokyoProcessParameter parameter;
    private ShinsakaiShukeiGenzainojokyoEntity genzainojokyo;
    private boolean isデータあり;
    @BatchWriter
    private BatchReportWriter<ShinsakaiShukeiGenzainojokyoReportSource> batchWriter;
    private ReportSourceWriter<ShinsakaiShukeiGenzainojokyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        isデータあり = false;
        genzainojokyo = new ShinsakaiShukeiGenzainojokyoEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_GENZAINOJOKYO, parameter.toShinsakaiShukeiGenzainojokyoMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE701009.getReportId().value())
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(ShinsakaiShukeihyoGenzaiEntity current) {
        isデータあり = true;
        new ShinsakaiShukeihyoGenzaiEditor(parameter, current, genzainojokyo).set介護認定審査会集計表現在の状況別();
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            setヘッダー項目();
            ShinsakaiShukeiGenzainojokyoReport report = new ShinsakaiShukeiGenzainojokyoReport(genzainojokyo);
            report.writeBy(reportSourceWriter);
        }
    }

    private void setヘッダー項目() {
        genzainojokyo.setタイトル(タイトル);
        set有効基準年月日();
        genzainojokyo.set発行日時(get発行日時());
    }

    private void set有効基準年月日() {
        if (parameter.isEmptyKijyunYMD()) {
            genzainojokyo.set有効基準年月日(RString.EMPTY);
        } else {
            genzainojokyo.set有効基準年月日(parameter.getKijyunYMD().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
    }

    private RString get発行日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        return printTimeStampSb.toRString();
    }

}
