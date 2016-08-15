/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120250;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.sogojigyohiseikyugakutsuchishokeikasochiin.SogojigyohiSeiDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufukettei.sogojigyohisei.SogojigyohiSeiCsvEntity;
import jp.co.ndensan.reams.db.dbc.service.core.sogojigyohiseiichiran.SogojigyohiSeikyugakuTsuchishoKeikaSochiManager;
import jp.co.ndensan.reams.db.dbc.service.report.sogojigyohisei.SogojigyohiSeikyugakuTsuchishoKeikaSochiPrintService;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費（経過措置）請求額通知書の一覧表作成を実行する
 *
 * @reamsid_L DBC-2480-011 jiangxiaolong
 */
public class SogojigyohiSeiDoIchiranhyoSakuseiProcess extends SimpleBatchProcessBase {

    private SogojigyohiSeiDoIchiranhyoSakuseiProcessParameter parameter;

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200068");
    private FileSpoolManager manager;
    private RString filePath;
    @BatchWriter
    private CsvWriter csvWriter;
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 出力ファイル名
            = new RString("DBC200068_SogojigyohiSeikyugakuTsuchishoKeikaSochi.csv");
    private final RString 総合計 = new RString("＊＊　総合計　＊＊");
    private final RString コード_99 = new RString("99");
    private static final RString 漢字_分 = new RString("分");

    @Override
    protected void process() {
        SogojigyohiSeikyugakuTsuchishoKeikaSochiManager chohyoManager = SogojigyohiSeikyugakuTsuchishoKeikaSochiManager.createInstance();
        List<DbWT1511SeikyugakuTsuchishoTempEntity> list = chohyoManager.get帳票出力対象データ();
        if (null == list || list.isEmpty()) {
            return;
        }
        SogojigyohiSeikyugakuTsuchishoKeikaSochiPrintService printService
                = new SogojigyohiSeikyugakuTsuchishoKeikaSochiPrintService();
        printService.printTaitsu(list, parameter.getシステム日付());
        do帳票のCSVファイル作成(list, parameter.getシステム日付());
    }

    private void do帳票のCSVファイル作成(List<DbWT1511SeikyugakuTsuchishoTempEntity> list,
            RDateTime 作成日時) {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        filePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(filePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();

        for (int index = 0; index < list.size(); index++) {
            SogojigyohiSeiCsvEntity output = new SogojigyohiSeiCsvEntity();
            DbWT1511SeikyugakuTsuchishoTempEntity 出力対象 = list.get(index);
            output.set審査年月(出力対象.get審査年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(漢字_分));
            if (index == 0) {
                RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString();
                RString 作成時 = 作成日時.getTime()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
                output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
            } else {
                output.set作成日時(RString.EMPTY);
            }
            output.set国保連合会名(出力対象.get国保連合会名());
            output.set保険者番号(出力対象.get保険者番号().getColumnValue());
            output.set保険者名(出力対象.get保険者名());
            output.set証記載保険者番号(出力対象.get証記載保険者番号().getColumnValue());
            output.set款コード(出力対象.get款コード());
            if (コード_99.equals(出力対象.get款コード())) {
                output.set款名(総合計);
            } else {
                output.set款名(出力対象.get款名());
            }
            output.set項コード(出力対象.get項コード());
            if (コード_99.equals(出力対象.get項コード())) {
                output.set項名(RString.EMPTY);
            } else {
                output.set項名(出力対象.get項名());
            }
            output.setサービス種類コード(出力対象.getサービス種類コード());
            output.setサービス種類名(出力対象.getサービス種類名());
            output.set通常分_件数(doカンマ編集(出力対象.get通常分_件数()));
            output.set通常分_実日数(doカンマ編集(出力対象.get通常分_実日数()));
            output.set通常分_単位数(doカンマ編集(出力対象.get通常分_単位数()));
            output.set通常分_金額(doカンマ編集(出力対象.get通常分_金額()));
            output.set過誤_件数(doカンマ編集(出力対象.get再審査_過誤_件数()));
            output.set過誤_単位数(doカンマ編集(出力対象.get再審査_過誤_単位数()));
            output.set過誤_調整額(doカンマ編集(出力対象.get再審査_過誤_調整額()));
            output.set総合事業費(doカンマ編集(出力対象.get介護給付_総合事業費()));
            output.set利用者負担額(doカンマ編集(出力対象.get利用者負担額()));
            if (!出力対象.get合計_帳票レコード種別().isEmpty()) {
                output.set合計_通常分_件数(doカンマ編集(出力対象.get合計_通常分_件数()));
                output.set合計_通常分_単位数(doカンマ編集(出力対象.get合計_通常分_単位数()));
                output.set合計_通常分_金額(doカンマ編集(出力対象.get合計_通常分_金額()));
                output.set合計_過誤_件数(doカンマ編集(出力対象.get合計_再審査_過誤_件数()));
                output.set合計_過誤_単位数(doカンマ編集(出力対象.get合計_再審査_過誤_単位数()));
                output.set合計_過誤_調整額(doカンマ編集(出力対象.get合計_再審査_過誤_調整額()));
                output.set合計_総合事業費(doカンマ編集(出力対象.get合計_介護給付_総合事業費()));
                output.set合計_利用者負担額(doカンマ編集(出力対象.get合計_利用者負担額()));
            }
            if (!出力対象.get累計_帳票レコード種別().isEmpty()) {
                output.set累計_通常分_件数(doカンマ編集(出力対象.get累計_通常分_件数()));
                output.set累計_通常分_単位数(doカンマ編集(出力対象.get累計_通常分_単位数()));
                output.set累計_通常分_金額(doカンマ編集(出力対象.get累計_通常分_金額()));
                output.set累計_過誤_件数(doカンマ編集(出力対象.get累計_再審査_過誤_件数()));
                output.set累計_過誤_単位数(doカンマ編集(出力対象.get累計_再審査_過誤_単位数()));
                output.set累計_過誤_調整額(doカンマ編集(出力対象.get累計_再審査_過誤_調整額()));
                output.set累計_総合事業費(doカンマ編集(出力対象.get累計_介護給付_総合事業費()));
                output.set累計_利用者負担額(doカンマ編集(出力対象.get累計_利用者負担額()));
            }
            if (!出力対象.get手数料_帳票レコード種別().isEmpty()) {
                output.set手数料_請求額(doカンマ編集(出力対象.get手数料_請求額()));
                output.set手数料_累計請求額(doカンマ編集(出力対象.get手数料_累計請求額()));
            }
            csvWriter.writeLine(output);
        }
        csvWriter.close();
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }
}
