/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiSeikyugakuTsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.dbc120890.SogojigyohiSeikyugakuTsuchishoInSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費等請求額通知書帳票BodyEditor
 *
 * @reamsid_L DBC-2480-032 sunqingzhu
 */
public class SogojigyohiSeikyugakuTsuchishoInBodyEditor implements ISogojigyohiSeikyugakuTsuchishoInEditor {

    private final DbWT1511SeikyugakuTsuchishoTempEntity 帳票出力対象データ;
    private static final RString CODE_ST = new RString("ST");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ DbWT1511SeikyugakuTsuchishoTempEntity
     */
    public SogojigyohiSeikyugakuTsuchishoInBodyEditor(DbWT1511SeikyugakuTsuchishoTempEntity 帳票出力対象データ) {
        this.帳票出力対象データ = 帳票出力対象データ;
    }

    @Override
    public SogojigyohiSeikyugakuTsuchishoInSource edit(SogojigyohiSeikyugakuTsuchishoInSource source) {
        if (!CODE_ST.equals(帳票出力対象データ.getサービス種類コード())) {
            source.listMeisai_1 = 帳票出力対象データ.getサービス種類名();
            source.listMeisai_3 = doカンマ編集(帳票出力対象データ.get通常分_実日数());
        } else {
            source.listMeisai_1 = RString.HALF_SPACE.concat(帳票出力対象データ.getサービス種類名());
            source.listMeisai_3 = RString.EMPTY;
        }
        source.listMeisai_2 = doカンマ編集(帳票出力対象データ.get通常分_件数());
        source.listMeisai_4 = doカンマ編集(帳票出力対象データ.get通常分_単位数());
        source.listMeisai_5 = doカンマ編集(帳票出力対象データ.get通常分_金額());
        source.listMeisai_6 = doカンマ編集(帳票出力対象データ.get再審査_過誤_件数());
        source.listMeisai_7 = doカンマ編集(帳票出力対象データ.get再審査_過誤_単位数());
        source.listMeisai_8 = doカンマ編集(帳票出力対象データ.get再審査_過誤_調整額());
        source.listMeisai_9 = doカンマ編集(帳票出力対象データ.get介護給付_総合事業費());
        source.listMeisai_10 = doカンマ編集(帳票出力対象データ.get利用者負担額());
        source.listMeisai_11 = doカンマ編集(帳票出力対象データ.get公費負担額());
        if (!RString.isNullOrEmpty(帳票出力対象データ.get合計_帳票レコード種別())) {
            source.gokeiTsujoKensu = doカンマ編集(帳票出力対象データ.get合計_通常分_件数());
            source.gokeiTsujoTanisu = doカンマ編集(帳票出力対象データ.get合計_通常分_単位数());
            source.gokeiTsujoKingaku = doカンマ編集(帳票出力対象データ.get合計_通常分_金額());
            source.gokeiSaishinsaKagoKensu = doカンマ編集(帳票出力対象データ.get合計_再審査_過誤_件数());
            source.gokeiSaishinsaKagoTanisu = doカンマ編集(帳票出力対象データ.get合計_再審査_過誤_単位数());
            source.gokeiSaishinsaKagoChoseigaku = doカンマ編集(帳票出力対象データ.get合計_再審査_過誤_調整額());
            source.gokeiSogojigyohi = doカンマ編集(帳票出力対象データ.get合計_介護給付_総合事業費());
            source.gokeiRiyoshaFutangaku = doカンマ編集(帳票出力対象データ.get合計_利用者負担額());
            source.gokeiKohiFutangaku = doカンマ編集(帳票出力対象データ.get合計_公費負担額());
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get累計_帳票レコード種別())) {
            source.ruikeiTsujoKensu = doカンマ編集(帳票出力対象データ.get累計_通常分_件数());
            source.ruikeiTsujoTanisu = doカンマ編集(帳票出力対象データ.get累計_通常分_単位数());
            source.ruikeiTsujoKingaku = doカンマ編集(帳票出力対象データ.get累計_通常分_金額());
            source.ruikeiSaishinsaKagoKensu = doカンマ編集(帳票出力対象データ.get累計_再審査_過誤_件数());
            source.ruikeiSaishinsaKagoTanisu = doカンマ編集(帳票出力対象データ.get累計_再審査_過誤_単位数());
            source.ruikeiSaishinsaKagoChoseigaku = doカンマ編集(帳票出力対象データ.get累計_再審査_過誤_調整額());
            source.ruikeiSogojigyohi = doカンマ編集(帳票出力対象データ.get累計_介護給付_総合事業費());
            source.ruikeiRiyoshaFutangaku = doカンマ編集(帳票出力対象データ.get累計_利用者負担額());
            source.ruikeiKohiFutangaku = doカンマ編集(帳票出力対象データ.get累計_公費負担額());
        }
        if (!RString.isNullOrEmpty(帳票出力対象データ.get手数料_帳票レコード種別())) {
            source.tesuryoSeikyugaku = doカンマ編集(帳票出力対象データ.get手数料_請求額());
            source.tesuryoRuikeigaku = doカンマ編集(帳票出力対象データ.get手数料_累計請求額());
        }
        return source;
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }
}
