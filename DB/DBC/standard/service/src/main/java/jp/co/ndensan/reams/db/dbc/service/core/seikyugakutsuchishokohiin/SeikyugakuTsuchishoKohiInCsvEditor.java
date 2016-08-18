/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.seikyugakutsuchishokohiin;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishokohiin.SeikyugakuTsuchishoKohiInCsvEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * バッチ設計_DBCMNF2002-631_介護給付費等請求額通知書情報（公費）取込のCsvEditorです。
 *
 * @reamsid_L DBC-2790-010 surun
 */
public class SeikyugakuTsuchishoKohiInCsvEditor {

    private static final int ZERO_INDEX = 0;
    private static final RString SAKUSEI = new RString("作成");
    private static final RString 定数_99 = new RString("99");
    private static final RString 総合計 = new RString("＊＊　総合計　＊＊");

    /**
     * editor
     *
     * @param index int
     * @param entity DbWT1511SeikyugakuTsuchishoTempEntity
     * @param システム日付 RDateTime
     * @return SeikyugakuTsuchishoKohiInCsvEntity
     */
    public SeikyugakuTsuchishoKohiInCsvEntity editor(int index, DbWT1511SeikyugakuTsuchishoTempEntity entity, RDateTime システム日付) {
        SeikyugakuTsuchishoKohiInCsvEntity csvEntity = new SeikyugakuTsuchishoKohiInCsvEntity();
        if (index == ZERO_INDEX) {
            if (entity != null && entity.get審査年月() != null) {
                csvEntity.set審査年月(entity.get審査年月().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            }
            RString 帳票作成年月日 = システム日付.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 帳票作成時 = システム日付.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            if (帳票作成年月日 != null && 帳票作成時 != null) {
                RString 帳票作成日時 = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成時)
                        .concat(RString.HALF_SPACE).concat(SAKUSEI);
                csvEntity.set作成日時(帳票作成日時);
            }
            if (entity != null) {
                csvEntity.set国保連合会名(entity.get国保連合会名());
            }
        }
        set明細項目(csvEntity, entity);
        set合計項目(csvEntity, entity);
        set累計項目(csvEntity, entity);
        set審査支払手数料項目(csvEntity, entity);
        return csvEntity;
    }

    private void set明細項目(SeikyugakuTsuchishoKohiInCsvEntity csvEntity, DbWT1511SeikyugakuTsuchishoTempEntity entity) {
        if (entity != null) {
            csvEntity.set公費負担者番号(entity.get公費負担者番号());
            csvEntity.set公費負担者名(entity.get公費負担者名());
            csvEntity.set款コード(entity.get款コード());
            if (定数_99.equals(entity.get款コード())) {
                csvEntity.set款名(総合計);
            } else {
                csvEntity.set款名(entity.get款名());
            }
            csvEntity.set項コード(entity.get項コード());
            if (!定数_99.equals(entity.get項コード())) {
                csvEntity.set項名(entity.get項名());
            }
            csvEntity.setサービス種類コード(entity.getサービス種類コード());
            csvEntity.setサービス種類名(entity.getサービス種類名());
            Decimal 通常分件数 = entity.get通常分_件数();
            if (通常分件数 != null) {
                csvEntity.set通常分件数(DecimalFormatter.toコンマ区切りRString(通常分件数, ZERO_INDEX));
            }
            Decimal 通常分実日数 = entity.get通常分_実日数();
            if (通常分実日数 != null) {
                csvEntity.set通常分実日数(DecimalFormatter.toコンマ区切りRString(通常分実日数, ZERO_INDEX));
            }
            Decimal 通常分公費対象単位数 = entity.get通常分_単位数();
            if (通常分公費対象単位数 != null) {
                csvEntity.set通常分公費対象単位数(DecimalFormatter.toコンマ区切りRString(通常分公費対象単位数, ZERO_INDEX));
            }
            Decimal 通常分公費対象金額 = entity.get通常分_金額();
            if (通常分公費対象金額 != null) {
                csvEntity.set通常分公費対象金額(DecimalFormatter.toコンマ区切りRString(通常分公費対象金額, ZERO_INDEX));
            }
            Decimal 再審査過誤件数 = entity.get再審査_過誤_件数();
            if (再審査過誤件数 != null) {
                csvEntity.set再審査過誤件数(DecimalFormatter.toコンマ区切りRString(再審査過誤件数, ZERO_INDEX));
            }
            Decimal 再審査過誤公費対象単位数 = entity.get再審査_過誤_単位数();
            if (再審査過誤公費対象単位数 != null) {
                csvEntity.set再審査過誤公費対象単位数(DecimalFormatter.toコンマ区切りRString(再審査過誤公費対象単位数, ZERO_INDEX));
            }
            Decimal 再審査過誤公費対象調整額 = entity.get再審査_過誤_調整額();
            if (再審査過誤公費対象調整額 != null) {
                csvEntity.set再審査過誤公費対象調整額(DecimalFormatter.toコンマ区切りRString(再審査過誤公費対象調整額, ZERO_INDEX));
            }
            Decimal 負担額 = entity.get公費負担額();
            if (負担額 != null) {
                csvEntity.set負担額(DecimalFormatter.toコンマ区切りRString(負担額, ZERO_INDEX));
            }
            Decimal 公費分本人負担額 = entity.get利用者負担額();
            if (公費分本人負担額 != null) {
                csvEntity.set公費分本人負担額(DecimalFormatter.toコンマ区切りRString(公費分本人負担額, ZERO_INDEX));
            }
        }
    }

    private void set合計項目(SeikyugakuTsuchishoKohiInCsvEntity csvEntity, DbWT1511SeikyugakuTsuchishoTempEntity entity) {
        if (entity != null && !RString.isNullOrEmpty(entity.get合計_帳票レコード種別())) {
            Decimal 合計通常分件数 = entity.get合計_通常分_件数();
            if (合計通常分件数 != null) {
                csvEntity.set合計通常分件数(DecimalFormatter.toコンマ区切りRString(合計通常分件数, ZERO_INDEX));
            }
            Decimal 合計通常分公費対象単位数 = entity.get合計_通常分_単位数();
            if (合計通常分公費対象単位数 != null) {
                csvEntity.set合計通常分公費対象単位数(DecimalFormatter.toコンマ区切りRString(合計通常分公費対象単位数, ZERO_INDEX));
            }
            Decimal 合計通常分公費対象金額 = entity.get合計_通常分_金額();
            if (合計通常分公費対象金額 != null) {
                csvEntity.set合計通常分公費対象金額(DecimalFormatter.toコンマ区切りRString(合計通常分公費対象金額, ZERO_INDEX));
            }
            Decimal 合計再審査過誤件数 = entity.get合計_再審査_過誤_件数();
            if (合計再審査過誤件数 != null) {
                csvEntity.set合計再審査過誤件数(DecimalFormatter.toコンマ区切りRString(合計再審査過誤件数, ZERO_INDEX));
            }
            Decimal 合計再審査過誤公費対象単位数 = entity.get合計_再審査_過誤_単位数();
            if (合計再審査過誤公費対象単位数 != null) {
                csvEntity.set合計再審査過誤公費対象単位数(DecimalFormatter.toコンマ区切りRString(合計再審査過誤公費対象単位数, ZERO_INDEX));
            }
            Decimal 合計再審査過誤公費対象調整額 = entity.get合計_再審査_過誤_調整額();
            if (合計再審査過誤公費対象調整額 != null) {
                csvEntity.set合計再審査過誤公費対象調整額(DecimalFormatter.toコンマ区切りRString(合計再審査過誤公費対象調整額, ZERO_INDEX));
            }
            Decimal 合計負担額 = entity.get合計_公費負担額();
            if (合計負担額 != null) {
                csvEntity.set合計負担額(DecimalFormatter.toコンマ区切りRString(合計負担額, ZERO_INDEX));
            }
            Decimal 合計公費分本人負担額 = entity.get合計_利用者負担額();
            if (合計公費分本人負担額 != null) {
                csvEntity.set合計公費分本人負担額(DecimalFormatter.toコンマ区切りRString(合計公費分本人負担額, ZERO_INDEX));
            }
        }
    }

    private void set累計項目(SeikyugakuTsuchishoKohiInCsvEntity csvEntity, DbWT1511SeikyugakuTsuchishoTempEntity entity) {
        if (entity != null && !RString.isNullOrEmpty(entity.get累計_帳票レコード種別())) {
            Decimal 累計通常分件数 = entity.get累計_通常分_件数();
            if (累計通常分件数 != null) {
                csvEntity.set累計通常分件数(DecimalFormatter.toコンマ区切りRString(累計通常分件数, ZERO_INDEX));
            }
            Decimal 累計通常分公費対象単位数 = entity.get累計_通常分_単位数();
            if (累計通常分公費対象単位数 != null) {
                csvEntity.set累計通常分公費対象単位数(DecimalFormatter.toコンマ区切りRString(累計通常分公費対象単位数, ZERO_INDEX));
            }
            Decimal 累計通常分公費対象金額 = entity.get累計_通常分_金額();
            if (累計通常分公費対象金額 != null) {
                csvEntity.set累計通常分公費対象金額(DecimalFormatter.toコンマ区切りRString(累計通常分公費対象金額, ZERO_INDEX));
            }
            Decimal 累計再審査過誤件数 = entity.get累計_再審査_過誤_件数();
            if (累計再審査過誤件数 != null) {
                csvEntity.set累計再審査過誤件数(DecimalFormatter.toコンマ区切りRString(累計再審査過誤件数, ZERO_INDEX));
            }
            Decimal 累計再審査過誤公費対象単位数 = entity.get累計_再審査_過誤_単位数();
            if (累計再審査過誤公費対象単位数 != null) {
                csvEntity.set累計再審査過誤公費対象単位数(DecimalFormatter.toコンマ区切りRString(累計再審査過誤公費対象単位数, ZERO_INDEX));
            }
            Decimal 累計再審査過誤公費対象調整額 = entity.get累計_再審査_過誤_調整額();
            if (累計再審査過誤公費対象調整額 != null) {
                csvEntity.set累計再審査過誤公費対象調整額(DecimalFormatter.toコンマ区切りRString(累計再審査過誤公費対象調整額, ZERO_INDEX));
            }
            Decimal 累計負担額 = entity.get累計_公費負担額();
            if (累計負担額 != null) {
                csvEntity.set累計負担額(DecimalFormatter.toコンマ区切りRString(累計負担額, ZERO_INDEX));
            }
            Decimal 累計公費分本人負担額 = entity.get累計_利用者負担額();
            if (累計公費分本人負担額 != null) {
                csvEntity.set累計公費分本人負担額(DecimalFormatter.toコンマ区切りRString(累計公費分本人負担額, ZERO_INDEX));
            }

        }

    }

    private void set審査支払手数料項目(SeikyugakuTsuchishoKohiInCsvEntity csvEntity, DbWT1511SeikyugakuTsuchishoTempEntity entity) {
        if (entity != null && !RString.isNullOrEmpty(entity.get手数料_帳票レコード種別())) {
            Decimal 手数料請求額 = entity.get手数料_請求額();
            if (手数料請求額 != null) {
                csvEntity.set手数料請求額(DecimalFormatter.toコンマ区切りRString(手数料請求額, ZERO_INDEX));
            }
            Decimal 手数料累計請求額 = entity.get手数料_累計請求額();
            if (手数料累計請求額 != null) {
                csvEntity.set手数料累計請求額(DecimalFormatter.toコンマ区切りRString(手数料累計請求額, ZERO_INDEX));
            }
        }
    }
}
