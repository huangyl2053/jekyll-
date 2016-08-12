/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120230;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishoin.SeikyugakuTsuchishoInCsvEntity;
import jp.co.ndensan.reams.db.dbc.service.core.seikyugakutsuchishoin.SeikyugakuTsuchishoInIchiranPrintService;
import jp.co.ndensan.reams.db.dbc.service.core.seikyugakutsuchishoin.SeikyugakuTsuchishoInManager;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護給付費等請求額通知書情報取込のCSVファイル読取
 *
 * @reamsid_L DBC-2480-010 jiangwenkai
 */
public class SeikyugakuTsuchishoInDoIchiranhyoSakuseiProcess extends SimpleBatchProcessBase {

    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200066");
    private FileSpoolManager manager;
    private RString eucFilePath;
    @BatchWriter
    private CsvWriter csvWriter;

    private static final RString 出力ファイル名
            = new RString("DBC200066_SeikyugakuTsuchisho.csv");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private final RString 款コード_99 = new RString("99");
    private final RString 項コード_99 = new RString("99");
    private final RString 総合計 = new RString("＊＊　総合計　＊＊");

    @Override
    protected void process() {
        SeikyugakuTsuchishoInManager seikyugakuManager = SeikyugakuTsuchishoInManager.createInstance();
        List<DbWT1511SeikyugakuTsuchishoTempEntity> list = seikyugakuManager.get帳票出力対象データ();
        if (null == list || list.isEmpty()) {
            return;
        }
        SeikyugakuTsuchishoInIchiranPrintService printService
                = new SeikyugakuTsuchishoInIchiranPrintService();
        printService.printTaitsu(list, parameter.getシステム日付());
        do帳票のCSVファイル作成(list, parameter.getシステム日付());

    }

    private void do帳票のCSVファイル作成(List<DbWT1511SeikyugakuTsuchishoTempEntity> list,
            RDateTime 作成日時) {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
        for (int index = 0; index < list.size(); index++) {
            SeikyugakuTsuchishoInCsvEntity output = new SeikyugakuTsuchishoInCsvEntity();
            DbWT1511SeikyugakuTsuchishoTempEntity 請求額通知書 = list.get(index);
            if (index == 0) {
                output.set審査年月(doパターン54(請求額通知書.get審査年月()));
                RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString();
                RString 作成時 = 作成日時.getTime()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
                output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
            } else {
                output.set審査年月(RString.EMPTY);
                output.set作成日時(RString.EMPTY);
            }
            output.set国保連合会名(請求額通知書.get国保連合会名());
            output.set保険者番号(getColumnValue(請求額通知書.get保険者番号()));
            output.set保険者名(請求額通知書.get保険者名());
            output.set証記載保険者番号(getColumnValue(請求額通知書.get証記載保険者番号()));
            output.set款コード(請求額通知書.get款コード());
            if (款コード_99.equals(請求額通知書.get款コード())) {
                output.set款名(総合計);
            } else {
                output.set款名(請求額通知書.get款名());
            }
            output.set項コード(請求額通知書.get項コード());
            if (項コード_99.equals(請求額通知書.get項コード())) {
                output.set項名(RString.EMPTY);
            } else {
                output.set項名(請求額通知書.get項名());
            }
            output.setサービス種類コード(請求額通知書.getサービス種類コード());
            output.setサービス種類名(請求額通知書.getサービス種類名());
            output.set通常_分件数(doカンマ編集(請求額通知書.get通常分_件数()));
            output.set通常分_実日数(doカンマ編集(請求額通知書.get通常分_実日数()));
            output.set通常分_単位数(doカンマ編集(請求額通知書.get通常分_単位数()));
            output.set通常分_金額(doカンマ編集(請求額通知書.get通常分_金額()));
            output.set再審査_過誤_件数(doカンマ編集(請求額通知書.get再審査_過誤_件数()));
            output.set再審査_過誤_単位数(doカンマ編集(請求額通知書.get再審査_過誤_単位数()));
            output.set再審査_過誤_調整額(doカンマ編集(請求額通知書.get再審査_過誤_調整額()));
            output.set介護給付費(doカンマ編集(請求額通知書.get介護給付_総合事業費()));
            output.set利用者負担額(doカンマ編集(請求額通知書.get利用者負担額()));
            output.set公費負担額(doカンマ編集(請求額通知書.get公費負担額()));
            if (!請求額通知書.get合計_帳票レコード種別().isEmpty()) {
                output.set合計_通常分_件数(doカンマ編集(請求額通知書.get合計_通常分_件数()));
                output.set合計_通常分_単位数(doカンマ編集(請求額通知書.get合計_通常分_単位数()));
                output.set合計_通常分_金額(doカンマ編集(請求額通知書.get合計_通常分_金額()));
                output.set合計_再審査_過誤_件数(doカンマ編集(請求額通知書.get合計_再審査_過誤_件数()));
                output.set合計_再審査_過誤_単位数(doカンマ編集(請求額通知書.get合計_再審査_過誤_単位数()));
                output.set合計_再審査_過誤_調整額(doカンマ編集(請求額通知書.get合計_再審査_過誤_調整額()));
                output.set合計_介護給付費(doカンマ編集(請求額通知書.get合計_介護給付_総合事業費()));
                output.set合計_利用者負担額(doカンマ編集(請求額通知書.get合計_利用者負担額()));
                output.set合計_公費負担額(doカンマ編集(請求額通知書.get合計_公費負担額()));
            }
            if (!請求額通知書.get累計_帳票レコード種別().isEmpty()) {
                output.set累計_通常分_件数(doカンマ編集(請求額通知書.get累計_通常分_件数()));
                output.set累計_通常分_単位数(doカンマ編集(請求額通知書.get累計_通常分_単位数()));
                output.set累計_通常分_金額(doカンマ編集(請求額通知書.get累計_通常分_金額()));
                output.set累計_再審査_過誤_件数(doカンマ編集(請求額通知書.get累計_再審査_過誤_件数()));
                output.set累計_再審査_過誤_単位数(doカンマ編集(請求額通知書.get累計_再審査_過誤_単位数()));
                output.set累計_再審査_過誤_調整額(doカンマ編集(請求額通知書.get累計_再審査_過誤_調整額()));
                output.set累計_介護給付費(doカンマ編集(請求額通知書.get累計_介護給付_総合事業費()));
                output.set累計_利用者負担額(doカンマ編集(請求額通知書.get累計_利用者負担額()));
                output.set累計_公費負担額(doカンマ編集(請求額通知書.get累計_公費負担額()));
            }
            if (!請求額通知書.get手数料_帳票レコード種別().isEmpty()) {
                output.set手数料_請求額(doカンマ編集(請求額通知書.get手数料_請求額()));
                output.set手数料_累計請求額(doカンマ編集(請求額通知書.get手数料_累計請求額()));
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

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
