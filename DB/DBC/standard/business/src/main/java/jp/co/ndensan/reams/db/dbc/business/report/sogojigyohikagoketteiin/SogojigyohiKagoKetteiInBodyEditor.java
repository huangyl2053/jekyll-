/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteiin;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInSource;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費（経過措置）過誤決定通知書情報取込一覧表帳票BodyEditor。
 *
 * @reamsid_L DBC-2550-030 jianglaisheng
 */
public class SogojigyohiKagoKetteiInBodyEditor implements ISogojigyohiKagoKetteiInEditor {

    private final SogojigyohiKagoKetteiInEntity 帳票出力対象データ;
    private final boolean 集計Flag;
    private final int no;
    private static final RString 件数タイトル = new RString("件数");
    private static final RString 単位数タイトル = new RString("単位数");
    private static final RString 負担額タイトル = new RString("保険者負担額");
    private static final RString 総合事業費タイトル = new RString("総合事業費");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SogojigyohiKagoKetteiInEntity
     * @param 集計Flag boolean
     * @param no int
     */
    public SogojigyohiKagoKetteiInBodyEditor(SogojigyohiKagoKetteiInEntity 帳票出力対象データ,
            boolean 集計Flag, int no) {
        this.集計Flag = 集計Flag;
        this.帳票出力対象データ = 帳票出力対象データ;
        this.no = no;
    }

    @Override
    public SogojigyohiKagoKetteiInSource edit(SogojigyohiKagoKetteiInSource source) {
        if (集計Flag) {
            edit集計(source);
        } else {
            edit明細(source);
        }
        return source;
    }

    private void edit明細(SogojigyohiKagoKetteiInSource source) {
        source.listUpper_1 = new RString(no);
        source.listUpper_2 = doパターン54(帳票出力対象データ.get取扱年月());
        source.listUpper_3 = getColumnValue(帳票出力対象データ.get事業者番号());
        source.listUpper_4 = getColumnValue(帳票出力対象データ.get被保険者番号());
        source.listUpper_5 = 帳票出力対象データ.get被保険者名();
        source.listUpper_6 = doパターン54(帳票出力対象データ.getサービ提供年月());
        source.listUpper_7 = getColumnValue(帳票出力対象データ.getサービス種類コード());
        source.listUpper_8 = 帳票出力対象データ.getサービス種類名();
        source.listUpper_9 = decimalFormatter(帳票出力対象データ.get単位数(), 0);
        source.listLower_1 = 帳票出力対象データ.get事業者名();
        source.listLower_2 = getColumnValue(帳票出力対象データ.get過誤申立事由コード());
        source.listLower_3 = 帳票出力対象データ.get過誤申立事由();
        source.listLower_4 = decimalFormatter(帳票出力対象データ.get保険者負担額(), 0);
    }

    private void edit集計(SogojigyohiKagoKetteiInSource source) {
        source.kensuTitle = 件数タイトル;
        source.tanisuTitle = 単位数タイトル;
        source.futangakuTitle = 負担額タイトル;
        source.sogojigyohiTitle = 総合事業費タイトル;
        source.sogojigyohiKensu = decimalFormatter(new Decimal(帳票出力対象データ.get介護給付費件数()), 0);
        source.sogojigyohiTanisu = decimalFormatter(帳票出力対象データ.get介護給付費単位数(), 0);
        source.sogojigyohiFutangaku = decimalFormatter(帳票出力対象データ.get介護給付費保険者負担額(), 0);
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString decimalFormatter(Decimal 額, int count) {
        if (null == 額) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(額, count);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
