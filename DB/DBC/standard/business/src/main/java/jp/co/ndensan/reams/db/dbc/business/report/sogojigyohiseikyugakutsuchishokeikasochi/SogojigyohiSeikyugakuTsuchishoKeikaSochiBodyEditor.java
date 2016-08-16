/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokeikasochi;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.SogojigyohiSeiDoIchiranhyoSakusei.SogojigyohiSeikyugakuTsuchishoKeikaSochiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費（経過措置）請求額通知書一覧表帳票BodyIEditorクラスです。
 *
 * @reamsid_L DBC-2480-031 jiangxiaolong
 */
public class SogojigyohiSeikyugakuTsuchishoKeikaSochiBodyEditor implements ISogojigyohiSeikyugakuTsuchishoKeikaSochiEditor {

    private final DbWT1511SeikyugakuTsuchishoTempEntity 帳票出力対象データ;

    private final RString サービス種類コード_ST = new RString("ST");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ DbWT1511SeikyugakuTsuchishoTempEntity
     */
    public SogojigyohiSeikyugakuTsuchishoKeikaSochiBodyEditor(DbWT1511SeikyugakuTsuchishoTempEntity 帳票出力対象データ) {
        this.帳票出力対象データ = 帳票出力対象データ;
    }

    @Override
    public SogojigyohiSeikyugakuTsuchishoKeikaSochiSource edit(SogojigyohiSeikyugakuTsuchishoKeikaSochiSource source) {
        if (サービス種類コード_ST.equals(帳票出力対象データ.getサービス種類コード())) {
            source.listMeisai_1 = 帳票出力対象データ.getサービス種類名();
            source.listMeisai_3 = doカンマ編集(帳票出力対象データ.get通常分_実日数());
        } else {
            source.listMeisai_1 = RString.FULL_SPACE.concat(帳票出力対象データ
                    .getサービス種類名());
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
        if (!帳票出力対象データ.get合計_帳票レコード種別().isEmpty()) {
            source.gokeiTsujoKensu = doカンマ編集(帳票出力対象データ.get合計_通常分_件数());
            source.gokeiTsujoTanisu = doカンマ編集(帳票出力対象データ.get合計_通常分_単位数());
            source.gokeiTsujoKingaku = doカンマ編集(帳票出力対象データ.get合計_通常分_金額());
            source.gokeiKagoKensu = doカンマ編集(帳票出力対象データ.get合計_再審査_過誤_件数());
            source.gokeiKagoTanisu = doカンマ編集(帳票出力対象データ.get合計_再審査_過誤_単位数());
            source.gokeiKagoChoseigaku = doカンマ編集(帳票出力対象データ.get合計_再審査_過誤_調整額());
            source.gokeiSogojigyohi = doカンマ編集(帳票出力対象データ.get合計_介護給付_総合事業費());
            source.gokeiRiyoshaFutangaku = doカンマ編集(帳票出力対象データ.get合計_利用者負担額());
        }
        if (!帳票出力対象データ.get累計_帳票レコード種別().isEmpty()) {
            source.ruikeiTsujoKensu = doカンマ編集(帳票出力対象データ.get累計_通常分_件数());
            source.ruikeiTsujoTanisu = doカンマ編集(帳票出力対象データ.get累計_通常分_単位数());
            source.ruikeiTsujoKingaku = doカンマ編集(帳票出力対象データ.get累計_通常分_金額());
            source.ruikeiKagoKensu = doカンマ編集(帳票出力対象データ.get累計_再審査_過誤_件数());
            source.ruikeiKagoTanisu = doカンマ編集(帳票出力対象データ.get累計_再審査_過誤_単位数());
            source.ruikeiKagoChoseigaku = doカンマ編集(帳票出力対象データ.get累計_再審査_過誤_調整額());
            source.ruikeiSogojigyohi = doカンマ編集(帳票出力対象データ.get累計_介護給付_総合事業費());
            source.ruikeiRiyoshaFutangaku = doカンマ編集(帳票出力対象データ.get累計_利用者負担額());
        }
        if (!帳票出力対象データ.get手数料_帳票レコード種別().isEmpty()) {
            source.tesuryoSeikyugaku = doカンマ編集(帳票出力対象データ.get手数料_請求額());
            source.tesuryoRuikeigaku = doカンマ編集(帳票出力対象データ.get手数料_累計請求額());
        }

        return source;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }
}
