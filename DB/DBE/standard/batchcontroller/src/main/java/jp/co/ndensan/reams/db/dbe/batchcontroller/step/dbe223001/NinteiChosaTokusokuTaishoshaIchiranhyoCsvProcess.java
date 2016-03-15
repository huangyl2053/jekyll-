/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoCsvProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 認定調査督促対象者一覧表csvの作成クラスです。
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoCsvProcess extends SimpleBatchProcessBase {

    private NinteiChosaTokusokuTaishoshaIchiranhyoCsvProcessParameter processParameter;
    @BatchWriter
    private CsvWriter<NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity> csvWriter;
    private static final RString ファイル名 = new RString("認定調査督促対象者一覧表.csv");
    private static final RString タイトル = new RString("督促状発行対象者一覧");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;

    @Override
    protected void process() {

        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), ファイル名);
        RString 印刷年月日 = new RString(RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString().toString());

        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString 時分秒 = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");

        csvWriter = new CsvWriter.InstanceBuilder(filePath).canAppend(false)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).setNewLine(NewLine.CRLF).build();
        csvWriter.writeLine(new NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity(
                タイトル, null, null, null, null,
                null, null, null, null,
                null, null, null, null, null));
        csvWriter.writeLine(new NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity(
                印刷年月日.concat(RString.HALF_SPACE).concat(時分秒),
                null, null, null, null,
                null, null, null, null,
                null, null, null, null, null));

        List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> dataList
                = (List<NinteiChosaTokusokuTaishoshaIchiranhyoItem>) processParameter.getNinteiChosaTokusokuTaishoshaIchiranhyoItemList();
        for (NinteiChosaTokusokuTaishoshaIchiranhyoItem item : dataList) {
            csvWriter.writeLine(createCsvEntity(item));
        }
    }

    private NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity createCsvEntity(NinteiChosaTokusokuTaishoshaIchiranhyoItem item) {
        return new NinteiChosaTokusokuTaishoshaIchiranhyoCsvEntity(
                item.getCityCode(),
                item.getCityName(),
                item.getListNo_1(),
                item.getListUpper1_1(),
                item.getListLower1_1(),
                item.getListUpper1_2(),
                item.getListLower1_2(),
                item.getListShinseiYMD_1(),
                item.getListTokusokujoHakkoYMD_1(),
                item.getJigyoshaCode(),
                item.getListUpper2_1(),
                item.getListLower2_1(),
                item.getListUpper2_2(),
                item.getListLower2_2());
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
    }

}
