/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokohi;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohiseikyugakutsuchishokohi.SogojigyohiSeikyugakuTsuchishoKohiSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費等請求額通知書（公費負担者分）帳票Editor
 *
 * @reamsid_L DBC-4700-040 zhangyaru
 */
public class SogojigyohiSeikyugakuTsuchishoKohiEditor implements ISogojigyohiSeikyugakuTsuchishoKohiEditor {

    private final DbWT1511SeikyugakuTsuchishoTempEntity 請求額通知書情報;
    private final YMDHMS 帳票作成日時;
    private static final RString SAKUSEI = new RString("作成");
    private static final RString NUM = new RString("99");
    private static final RString ST = new RString("ST");
    private static final RString 総合計 = new RString("「＊＊　総合計　＊＊」");

    /**
     * インスタンスを生成します。
     *
     * @param 請求額通知書情報 DbWT1511SeikyugakuTsuchishoTempEntity
     * @param 帳票作成日時 YMDHMS
     */
    public SogojigyohiSeikyugakuTsuchishoKohiEditor(DbWT1511SeikyugakuTsuchishoTempEntity 請求額通知書情報,
            YMDHMS 帳票作成日時) {
        this.請求額通知書情報 = 請求額通知書情報;
        this.帳票作成日時 = 帳票作成日時;
    }

    @Override
    public SogojigyohiSeikyugakuTsuchishoKohiSource edit(SogojigyohiSeikyugakuTsuchishoKohiSource source) {
        if (帳票作成日時 != null && !帳票作成日時.isEmpty()) {
            RString 帳票作成日 = 帳票作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 帳票作成時 = 帳票作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.printTimeStamp = 帳票作成日.concat(RString.HALF_SPACE).concat(帳票作成時).concat(RString.HALF_SPACE).concat(SAKUSEI);
        }
        if (請求額通知書情報.get審査年月() != null && !請求額通知書情報.get審査年月().isEmpty()) {
            source.shinsaYM = 請求額通知書情報.get審査年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        source.kohiFutanshaNo = 請求額通知書情報.get公費負担者番号();
        source.kohiFutanshaName = 請求額通知書情報.get公費負担者名();
        if (!NUM.equals(請求額通知書情報.get款コード())) {
            source.kanName = 請求額通知書情報.get款名();
        } else {
            source.kanName = 総合計;
        }

        if (!NUM.equals(請求額通知書情報.get項コード())) {
            source.kouName = 請求額通知書情報.get項名();
        } else {
            source.kouName = RString.EMPTY;
        }
        source.kokuhorenName = 請求額通知書情報.get国保連合会名();
        if (!ST.equals(請求額通知書情報.getサービス種類コード())) {
            source.listMeisai_1 = 請求額通知書情報.getサービス種類名();
            source.listMeisai_3 = this.decimal_to_string(請求額通知書情報.get通常分_実日数());
        } else {
            source.listMeisai_1 = RString.FULL_SPACE.concat(請求額通知書情報.getサービス種類名());
            source.listMeisai_3 = RString.EMPTY;
        }
        source.listMeisai_2 = this.decimal_to_string(請求額通知書情報.get通常分_件数());
        source.listMeisai_4 = this.decimal_to_string(請求額通知書情報.get通常分_単位数());
        source.listMeisai_5 = this.decimal_to_string(請求額通知書情報.get通常分_金額());
        source.listMeisai_6 = this.decimal_to_string(請求額通知書情報.get再審査_過誤_件数());
        source.listMeisai_7 = this.decimal_to_string(請求額通知書情報.get再審査_過誤_単位数());
        source.listMeisai_8 = this.decimal_to_string(請求額通知書情報.get再審査_過誤_調整額());
        source.listMeisai_9 = this.decimal_to_string(請求額通知書情報.get公費負担額());
        source.listMeisai_10 = this.decimal_to_string(請求額通知書情報.get利用者負担額());
        if (請求額通知書情報.get合計_帳票レコード種別() != null && !請求額通知書情報.get合計_帳票レコード種別().isEmpty()) {
            source.gokeiTsujoKensu = this.decimal_to_string(請求額通知書情報.get合計_通常分_件数());
            source.gokeiTsujoTanisu = this.decimal_to_string(請求額通知書情報.get合計_通常分_単位数());
            source.gokeiTsujoKingaku = this.decimal_to_string(請求額通知書情報.get合計_通常分_金額());
            source.gokeiSaishinsaKagoKensu = this.decimal_to_string(請求額通知書情報.get合計_再審査_過誤_件数());
            source.gokeiSaishinsaKagoTanisu = this.decimal_to_string(請求額通知書情報.get合計_再審査_過誤_単位数());
            source.gokeiSaishinsaKagoChoseigaku = this.decimal_to_string(請求額通知書情報.get合計_再審査_過誤_調整額());
            source.gokeiKohiFutangaku = this.decimal_to_string(請求額通知書情報.get合計_公費負担額());
            source.gokeiRiyoshaFutangaku = this.decimal_to_string(請求額通知書情報.get合計_利用者負担額());
        }
        if (請求額通知書情報.get累計_帳票レコード種別() != null && 請求額通知書情報.get累計_帳票レコード種別().isEmpty()) {
            source.ruikeiTsujoKensu = this.decimal_to_string(請求額通知書情報.get累計_通常分_件数());
            source.ruikeiTsujoTanisu = this.decimal_to_string(請求額通知書情報.get累計_通常分_単位数());
            source.ruikeiTsujoKingaku = this.decimal_to_string(請求額通知書情報.get累計_通常分_金額());
            source.ruikeiSaishinsaKagoKensu = this.decimal_to_string(請求額通知書情報.get累計_再審査_過誤_件数());
            source.ruikeiSaishinsaKagoTanisu = this.decimal_to_string(請求額通知書情報.get累計_再審査_過誤_単位数());
            source.ruikeiSaishinsaKagoChoseigaku = this.decimal_to_string(請求額通知書情報.get累計_再審査_過誤_調整額());
            source.ruikeiKohiFutangaku = this.decimal_to_string(請求額通知書情報.get累計_公費負担額());
            source.ruikeiRiyoshaFutangaku = this.decimal_to_string(請求額通知書情報.get累計_利用者負担額());
        }
        if (請求額通知書情報.get手数料_帳票レコード種別() != null && !請求額通知書情報.get手数料_帳票レコード種別().isEmpty()) {
            source.tesuryoSeikyugaku = this.decimal_to_string(請求額通知書情報.get手数料_請求額());
            source.tesuryoRuikeigaku = this.decimal_to_string(請求額通知書情報.get手数料_累計請求額());
        }
        return source;
    }

    /**
     * 数値からstringに転換する。
     *
     * @param number 数値
     * @return カンマで編集した値
     */
    public RString decimal_to_string(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }
}
