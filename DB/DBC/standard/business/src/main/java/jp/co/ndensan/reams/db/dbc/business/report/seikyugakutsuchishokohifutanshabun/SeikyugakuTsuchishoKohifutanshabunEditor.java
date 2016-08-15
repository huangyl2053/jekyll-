/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishokohifutanshabun;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.seikyugakutsuchishokohifutanshabun.SeikyugakuTsuchishoKohifutanshabunSource;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 帳票設計_DBC200067_介護給付費等請求額通知書（公費負担者分）Editorするクラスです。
 *
 * @reamsid_L DBC-2790-030 lijian
 */
public class SeikyugakuTsuchishoKohifutanshabunEditor implements
        ISeikyugakuTsuchishoKohifutanshabunEditor {

    private final DbWT1511SeikyugakuTsuchishoTempEntity 請求額通知書帳票用データ;
    private final RDateTime 作成日時;
    private static final RString NINETY_NINE = new RString("99");
    private static final RString 総合計 = new RString("＊＊　総合計　＊＊");
    private static final RString ST = new RString("ST");
    private static final RString FULLMONTH = new RString("00");
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString 秒 = new RString("秒");

    /**
     * コンストラクタです。
     *
     * @param 請求額通知書帳票用データ SeikyugakuTsuchishoKohifutanshabunEntity
     * @param 作成日時 RDateTime
     */
    public SeikyugakuTsuchishoKohifutanshabunEditor(
            DbWT1511SeikyugakuTsuchishoTempEntity 請求額通知書帳票用データ,
            RDateTime 作成日時) {
        this.請求額通知書帳票用データ = 請求額通知書帳票用データ;
        this.作成日時 = 作成日時;
    }

    @Override
    public SeikyugakuTsuchishoKohifutanshabunSource edit(SeikyugakuTsuchishoKohifutanshabunSource source) {

        source.printTimeStamp = getSakuseiYmhm(作成日時);
        source.shinsaYM = DateConverter.toWarekiHalf_Zero(new RDate(請求額通知書帳票用データ.get審査年月().toString()));
        source.kohiFutanshaNo = 請求額通知書帳票用データ.get公費負担者番号();
        source.kohiFutanshaName = 請求額通知書帳票用データ.get公費負担者名();

        if (!NINETY_NINE.equals(請求額通知書帳票用データ.get款コード())) {
            source.kanName = 請求額通知書帳票用データ.get款名();
            source.kouName = 請求額通知書帳票用データ.get項名();
        } else {
            source.kanName = 総合計;
            source.kouName = RString.EMPTY;
        }

        source.kokuhorenName = 請求額通知書帳票用データ.get国保連合会名();

        set明細(source);
        setフッター合計(source);
        setフッター累計(source);
        setフッター審査支払手数料(source);

        return source;
    }

    private void set明細(SeikyugakuTsuchishoKohifutanshabunSource source) {

        if (!ST.equals(請求額通知書帳票用データ.getサービス種類コード())) {
            source.listMeisai_1 = 請求額通知書帳票用データ.getサービス種類名();
        } else {
            source.listMeisai_1 = new RString(new StringBuilder(RString.FULL_SPACE).append(請求額通知書帳票用データ
                    .getサービス種類名()).toString());
        }

        source.listMeisai_2 = doカンマ編集(請求額通知書帳票用データ.get通常分_件数());

        if (!ST.equals(請求額通知書帳票用データ.getサービス種類コード())) {
            source.listMeisai_3 = doカンマ編集(請求額通知書帳票用データ.get通常分_実日数());
        } else {
            source.listMeisai_3 = RString.EMPTY;
        }

        source.listMeisai_4 = doカンマ編集(請求額通知書帳票用データ.get通常分_単位数());
        source.listMeisai_5 = doカンマ編集(請求額通知書帳票用データ.get通常分_金額());
        source.listMeisai_6 = doカンマ編集(請求額通知書帳票用データ.get累計_再審査_過誤_件数());
        source.listMeisai_7 = doカンマ編集(請求額通知書帳票用データ.get累計_再審査_過誤_単位数());
        source.listMeisai_8 = doカンマ編集(請求額通知書帳票用データ.get累計_再審査_過誤_調整額());
        source.listMeisai_9 = doカンマ編集(請求額通知書帳票用データ.get累計_公費負担額());
        source.listMeisai_10 = doカンマ編集(請求額通知書帳票用データ.get累計_利用者負担額());
    }

    private void setフッター合計(SeikyugakuTsuchishoKohifutanshabunSource source) {
        if (!請求額通知書帳票用データ.get合計_帳票レコード種別().isEmpty()) {
            source.gokeiTsujoKensu = doカンマ編集(請求額通知書帳票用データ.get合計_通常分_件数());
            source.gokeiTsujoTanisu = doカンマ編集(請求額通知書帳票用データ.get合計_通常分_単位数());
            source.gokeiTsujoKingaku = doカンマ編集(請求額通知書帳票用データ.get合計_通常分_金額());
            source.gokeiSaishinsaKagoKensu = doカンマ編集(請求額通知書帳票用データ.get累計_再審査_過誤_件数());
            source.gokeiSaishinsaKagoTanisu = doカンマ編集(請求額通知書帳票用データ.get累計_再審査_過誤_単位数());
            source.gokeiSaishinsaKagoChoseigaku = doカンマ編集(請求額通知書帳票用データ.get累計_再審査_過誤_調整額());
            source.gokeiKohiFutangaku = doカンマ編集(請求額通知書帳票用データ.get合計_公費負担額());
            source.gokeiRiyoshaFutangaku = doカンマ編集(請求額通知書帳票用データ.get合計_利用者負担額());
        }
    }

    private void setフッター累計(SeikyugakuTsuchishoKohifutanshabunSource source) {
        if (!請求額通知書帳票用データ.get累計_帳票レコード種別().isEmpty()) {
            source.ruikeiTsujoKensu = doカンマ編集(請求額通知書帳票用データ.get累計_通常分_件数());
            source.ruikeiTsujoTanisu = doカンマ編集(請求額通知書帳票用データ.get累計_通常分_単位数());
            source.ruikeiTsujoKingaku = doカンマ編集(請求額通知書帳票用データ.get累計_通常分_金額());
            source.ruikeiSaishinsaKagoKensu = doカンマ編集(請求額通知書帳票用データ.get累計_再審査_過誤_件数());
            source.ruikeiSaishinsaKagoTanisu = doカンマ編集(請求額通知書帳票用データ.get再審査_過誤_単位数());
            source.ruikeiSaishinsaKagoChoseigaku = doカンマ編集(請求額通知書帳票用データ.get再審査_過誤_調整額());
            source.ruikeiKohiFutangaku = doカンマ編集(請求額通知書帳票用データ.get累計_公費負担額());
            source.ruikeiRiyoshaFutangaku = doカンマ編集(請求額通知書帳票用データ.get累計_利用者負担額());
        }
    }

    private void setフッター審査支払手数料(SeikyugakuTsuchishoKohifutanshabunSource source) {
        if (!請求額通知書帳票用データ.get手数料_帳票レコード種別().isEmpty()) {
            source.tesuryoSeikyugaku = doカンマ編集(請求額通知書帳票用データ.get手数料_請求額());
            source.tesuryoRuikeigaku = doカンマ編集(請求額通知書帳票用データ.get手数料_累計請求額());
        }
    }

    private RString getSakuseiYmhm(RDateTime datetime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.FULL_SPACE);
        sakuseiYMD.append(new RString(new Decimal(datetime.getHour()).toString(FULLMONTH.toString())));
        sakuseiYMD.append(時);
        sakuseiYMD.append(new RString(new Decimal(datetime.getMinute()).toString(FULLMONTH.toString())));
        sakuseiYMD.append(分);
        sakuseiYMD.append(new RString(new Decimal(datetime.getSecond()).toString(FULLMONTH.toString())));
        sakuseiYMD.append(秒);
        return sakuseiYMD.toRString();
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

}
