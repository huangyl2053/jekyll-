/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohisaishinsaketteitsuchisho.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohisaishin.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200081_総合事業費再審査決定通知書情報取込一覧表（公費）Reportのインターフェースクラスです。
 *
 * @reamsid_L DBC-4730-040 liuxiaoyu
 */
public class SogojigyohiSaishinsaKetteitsuchishoBodyEditor
        implements ISogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEditor {

    private final SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity 帳票出力対象データ;
    private final boolean 集計Flag;
    private final int 連番;
    private final boolean データFlag;
    private static final RString 決定タイトル = new RString("＜再審査決定＞");
    private static final RString 決定件数タイトル = new RString("件数");
    private static final RString 決定単位数タイトル = new RString("単位数");
    private static final RString 決定負担額タイトル = new RString("公費負担額");
    private static final RString 調整タイトル = new RString("＜調整＞");
    private static final RString 調整件数タイトル = new RString("件数");
    private static final RString 調整単位数タイトル = new RString("単位数");
    private static final RString 調整負担額タイトル = new RString("公費負担額");
    private static final RString 総合事業費タイトル = new RString("総合事業費");
    private static final Code CODE = new Code("0003");
    private static final RString NAME = new RString("被保険者番号");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SaishinsaKetteiTsuchishoChohyoEntity
     * @param 集計Flag boolean
     * @param 連番 int
     * @param データFlag boolean
     *
     */
    public SogojigyohiSaishinsaKetteitsuchishoBodyEditor(
            SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity 帳票出力対象データ, boolean 集計Flag, int 連番, boolean データFlag) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.集計Flag = 集計Flag;
        this.連番 = 連番;
        this.データFlag = データFlag;
    }

    @Override
    public SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource edit(
            SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource source) {

        if (集計Flag) {
            edit集計(source);
        } else {
            if (!データFlag) {
                edit明細(source);
            } else {
                edit集計(source);
                edit明細(source);
            }
        }
        source.拡張情報 = new ExpandedInformation(CODE, NAME,
                ReportKomokuEditorUtil.get非空文字列(source.listLower_1));
        return source;
    }

    private void edit明細(SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource source) {
        source.listUpper_1 = new RString(連番);
        source.listUpper_2 = doパターン54(帳票出力対象データ.get取扱年月());
        source.listUpper_3 = 帳票出力対象データ.get事業者番号().getColumnValue();
        source.listUpper_4 = 帳票出力対象データ.get事業者名();
        source.listUpper_5 = doパターン54(帳票出力対象データ.getサービス提供年月());
        source.listUpper_6 = 帳票出力対象データ.getサービス種類コード().getColumnValue();
        source.listUpper_7 = 帳票出力対象データ.getサービス種類名();
        source.listUpper_8 = doカンマ編集(帳票出力対象データ.get当初請求単位数());
        source.listUpper_9 = doカンマ編集(帳票出力対象データ.get決定単位数());
        source.listUpper_10 = doカンマ編集(帳票出力対象データ.get公費負担額());
        if (null != 帳票出力対象データ.get被保険者番号()) {
            source.listLower_1 = 帳票出力対象データ.get被保険者番号().getColumnValue();
        }
        source.listLower_2 = 帳票出力対象データ.get被保険者氏名();
        if (null != 帳票出力対象データ.get申立事由コード()) {
            source.listLower_3 = 帳票出力対象データ.get申立事由コード().getColumnValue();
        }
        source.listLower_4 = 帳票出力対象データ.get申立事由();
        source.listLower_5 = doカンマ編集(帳票出力対象データ.get原審単位数());
        source.listLower_6 = doカンマ編集(帳票出力対象データ.get調整単位数());
        source.shikibetuCode = 帳票出力対象データ.get識別コード();
    }

    private void edit集計(SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource source) {
        source.ketteiTitle = 決定タイトル;
        source.ketteiKensuTitle = 決定件数タイトル;
        source.ketteiTanisuTitle = 決定単位数タイトル;
        source.ketteiFutangakuTitle = 決定負担額タイトル;
        source.choseiTitle = 調整タイトル;
        source.choseiKensuTitle = 調整件数タイトル;
        source.choseiTanisuTitle = 調整単位数タイトル;
        source.choseiFutangakuTitle = 調整負担額タイトル;
        source.sogojigyohiTitle = 総合事業費タイトル;
        source.sogojigyohiKetteiKensu = doカンマ編集(帳票出力対象データ.get総合事業費_決定_件数());
        source.sogojigyohiKetteiTanisu = doカンマ編集(帳票出力対象データ.get総合事業費_決定_単位数());
        source.sogojigyohiKetteiFutangaku = doカンマ編集(帳票出力対象データ.get総合事業費_決定_負担額());
        source.sogojigyohiChoseiKensu = doカンマ編集(帳票出力対象データ.get総合事業費_調整_件数());
        source.sogojigyohiChoseiTanisu = doカンマ編集(帳票出力対象データ.get総合事業費_調整_単位数());
        source.sogojigyohiChoseiFutangaku = doカンマ編集(帳票出力対象データ.get総合事業費_調整_負担額());

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
