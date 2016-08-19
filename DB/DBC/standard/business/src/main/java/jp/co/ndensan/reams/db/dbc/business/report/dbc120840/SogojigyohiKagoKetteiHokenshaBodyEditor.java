/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120840;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120840.SogojigyohiKagoKetteiHokenshaChohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc120840.SogojigyohiKagoKetteiTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200085_総合事業費過誤決定通知書情報取込一覧表帳票BodyEditor
 *
 * @reamsid_LDBC-2550-031 jiangxiaolong
 */
public class SogojigyohiKagoKetteiHokenshaBodyEditor
        implements ISogojigyohiKagoKetteiHokenshaBunEditor {

    private final SogojigyohiKagoKetteiHokenshaChohyoEntity 帳票出力対象データ;
    private final boolean 集計Flag;
    private final int no;

    private static final RString 件数タイトル = new RString("件数");
    private static final RString 単位数タイトル = new RString("単位数");
    private static final RString 負担額タイトル = new RString("保険者負担額");
    private static final RString 総合事業費_負担額タイトル = new RString("総合事業費");

    /**
     *  コンストラクタです
     * @param 帳票出力対象データ SogojigyohiKagoKetteiHokenshaChohyoEntity
     * @param 集計Flag boolean
     * @param no int
     */
    public SogojigyohiKagoKetteiHokenshaBodyEditor(
            SogojigyohiKagoKetteiHokenshaChohyoEntity 帳票出力対象データ, boolean 集計Flag, int no) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.集計Flag = 集計Flag;
        this.no = no;
    }

    @Override
    public SogojigyohiKagoKetteiTorikomiIchiranSource edit(
            SogojigyohiKagoKetteiTorikomiIchiranSource source) {
        edit明細(source);
        if (集計Flag) {
            edit集計(source);
        }
        return source;
    }

    private void edit明細(SogojigyohiKagoKetteiTorikomiIchiranSource source) {
        source.listUpper_1 = new RString(this.no);
        source.listUpper_2 = doパターン54(帳票出力対象データ.get取扱年月());
        source.listUpper_3 = 帳票出力対象データ.get事業者番号().getColumnValue();
        if (null != 帳票出力対象データ.get被保険者番号()) {
            source.listUpper_4 = 帳票出力対象データ.get被保険者番号().getColumnValue();
        }
        
        source.listUpper_6 = doパターン54(帳票出力対象データ.getサービス提供年月());
        source.listUpper_7 = 帳票出力対象データ.getサービス種類コード().getColumnValue();
        source.listUpper_8 = 帳票出力対象データ.getサービス種類名();
        source.listUpper_9 = doカンマ編集(帳票出力対象データ.get単位数());
        source.listLower_1 = 帳票出力対象データ.get事業者名();
        if (null != 帳票出力対象データ.get過誤申立事由コード()) {
            source.listLower_2 = 帳票出力対象データ.get過誤申立事由コード().getColumnValue();
        }
        source.listLower_3 = 帳票出力対象データ.get過誤申立事由();
        source.listLower_4 = doカンマ編集(帳票出力対象データ.get負担額());
    }

    private void edit集計(SogojigyohiKagoKetteiTorikomiIchiranSource source) {
        source.kensuTitle = 件数タイトル;
        source.tanisuTitle = 単位数タイトル;
        source.futangakuTitle = 負担額タイトル;
        source.sogojigyohiTitle = 総合事業費_負担額タイトル;
        
        source.sogojigyohiKensu = doカンマ編集(帳票出力対象データ.get総合事業費_件数());
        source.sogojigyohiTanisu = doカンマ編集(帳票出力対象データ.get総合事業費_単位数());
        source.sogojigyohiFutangaku = doカンマ編集(帳票出力対象データ.get総合事業費_負担額());
       

    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

}
