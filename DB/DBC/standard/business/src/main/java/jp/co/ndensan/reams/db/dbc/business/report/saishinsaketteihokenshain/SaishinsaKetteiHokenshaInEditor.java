/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsaketteihokenshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain.SaishinsaKetteiResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.saishinsaketteihokenshain.SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 再審査決定通知書情報取込一覧表（保険者分）のEditorです。
 *
 * @reamsid_L DBC-2520-040 chenaoqi
 */
public class SaishinsaKetteiHokenshaInEditor implements ISaishinsaKetteiHokenshaInEditor {

    private final SaishinsaKetteiResultEntity 帳票出力対象データ;
    private final FlexibleYearMonth 処理年月;
    private final List<RString> 出力項目リスト;
    private final RDateTime 作成日時;
    private final boolean 集計Flag;
    private final int 連番;

    private static final RString 申立タイトル = new RString("＜再審査申立＞");
    private static final RString 申立件数タイトル = new RString("件数");
    private static final RString 申立単位数タイトル = new RString("単位数");
    private static final RString 申立負担額タイトル = new RString("保険者負担額");
    private static final RString 決定タイトル = new RString("＜再審査決定＞");
    private static final RString 決定件数タイトル = new RString("件数");
    private static final RString 決定単位数タイトル = new RString("単位数");
    private static final RString 決定負担額タイトル = new RString("保険者負担額");
    private static final RString 調整タイトル = new RString("＜調整＞");
    private static final RString 調整件数タイトル = new RString("件数");
    private static final RString 調整単位数タイトル = new RString("単位数");
    private static final RString 調整負担額タイトル = new RString("保険者負担額");
    private static final RString 介護給付費タイトル = new RString("介護給付費");
    private static final RString 高額介護サービス費タイトル = new RString("高額介護サービス費");

    private static final RString SAKUSEI = new RString("作成");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SaishinsaKetteiResultEntity
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 出力項目リスト List<RString>
     * @param 集計Flag boolean
     * @param 連番 int
     */
    public SaishinsaKetteiHokenshaInEditor(
            SaishinsaKetteiResultEntity 帳票出力対象データ,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            List<RString> 出力項目リスト, boolean 集計Flag, int 連番) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.処理年月 = 処理年月;
        this.出力項目リスト = 出力項目リスト;
        this.作成日時 = 作成日時;
        this.集計Flag = 集計Flag;
        this.連番 = 連番;
    }

    @Override
    public SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource edit(SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource source) {
        return editSource(source);
    }

    private SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource editSource(SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource source) {
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);

        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.torikomiYM = 処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.kokuhorenName = 帳票出力対象データ.get国保連合会名();
        source.shinsakaiName = 帳票出力対象データ.get審査委員会名();
        source.hokenshaNo = getColumnValue(帳票出力対象データ.get保険者番号());
        source.hokenshaName = 帳票出力対象データ.get保険者名();
        source.shoKisaiHokenshaNo = getColumnValue(帳票出力対象データ.get証記載保険者番号());
        source.shoKisaiHokenshaName = 帳票出力対象データ.get証記載保険者名();
        if (出力項目リスト != null && !出力項目リスト.isEmpty()) {
            source.shutsuryokujun1 = get出力項目(INT_0);
            source.shutsuryokujun2 = get出力項目(INT_1);
            source.shutsuryokujun3 = get出力項目(INT_2);
            source.shutsuryokujun4 = get出力項目(INT_3);
            source.shutsuryokujun5 = get出力項目(INT_4);
        }
        source.kaipage1 = RString.EMPTY;
        source.kaipage2 = RString.EMPTY;
        source.kaipage3 = RString.EMPTY;
        source.kaipage4 = RString.EMPTY;
        source.kaipage5 = RString.EMPTY;
        source.listUpper_1 = new RString(連番);
        source.listUpper_2 = doパターン54(帳票出力対象データ.get取扱年月());
        source.listUpper_3 = getColumnValue(帳票出力対象データ.get事業者番号());
        source.listUpper_4 = 帳票出力対象データ.get事業者名();
        source.listUpper_5 = doパターン54(帳票出力対象データ.getサービス提供年月());
        source.listUpper_6 = getColumnValue(帳票出力対象データ.getサービス種類コード());
        source.listUpper_7 = 帳票出力対象データ.getサービス種類名();
        source.listUpper_8 = getColumnValue(帳票出力対象データ.get再審査結果コード());
        source.listUpper_9 = doカンマ編集(帳票出力対象データ.get当初請求単位数());
        source.listUpper_10 = doカンマ編集(帳票出力対象データ.get申立単位数());
        source.listUpper_11 = doカンマ編集(帳票出力対象データ.get調整単位数());
        source.listLower_1 = getColumnValue(帳票出力対象データ.get被保険者番号());
        source.listLower_2 = 帳票出力対象データ.get被保険者氏名();
        source.listLower_3 = getColumnValue(帳票出力対象データ.get申立事由コード());
        source.listLower_4 = 帳票出力対象データ.get申立事由();
        RString 再審査結果 = CodeMaster.getCodeMeisho(DBCCodeShubetsu.再審査結果コード.getコード(),
                帳票出力対象データ.get再審査結果コード());
        source.listLower_5 = 再審査結果;
        source.listLower_6 = doカンマ編集(帳票出力対象データ.get原審単位数());
        source.listLower_7 = doカンマ編集(帳票出力対象データ.get決定単位数());
        source.listLower_8 = doカンマ編集(帳票出力対象データ.get保険者負担額());
        if (集計Flag) {
            source.seikyuTitle = 申立タイトル;
            source.seikyuKensuTitle = 申立件数タイトル;
            source.seikyuTanisuTitle = 申立単位数タイトル;
            source.seikyuFutangakuTitle = 申立負担額タイトル;
            source.ketteiTitle = 決定タイトル;
            source.ketteiKensuTitle = 決定件数タイトル;
            source.ketteiTanisuTitle = 決定単位数タイトル;
            source.ketteiFutangakuTitle = 決定負担額タイトル;
            source.choseiTitle = 調整タイトル;
            source.choseiKensuTitle = 調整件数タイトル;
            source.choseiTanisuTitle = 調整単位数タイトル;
            source.choseiFutangakuTitle = 調整負担額タイトル;
            source.kaigoKyufuhiTitle = 介護給付費タイトル;
            source.kogakuServicehiTitle = 高額介護サービス費タイトル;
            source.kaigoKyufuhiSeikyuKensu = doカンマ編集(帳票出力対象データ.get介護給付費_申立_件数());
            source.kaigoKyufuhiSeikyuTanisu = doカンマ編集(帳票出力対象データ.get介護給付費_申立_単位数());
            source.kaigoKyufuhiSeikyuFutangaku = doカンマ編集(帳票出力対象データ.get介護給付費_申立_負担額());
            source.kaigoKyufuhiKetteiKensu = doカンマ編集(帳票出力対象データ.get介護給付費_決定_件数());
            source.kaigoKyufuhiKetteiTanisu = doカンマ編集(帳票出力対象データ.get介護給付費_決定_単位数());
            source.kaigoKyufuhiKetteiFutangaku = doカンマ編集(帳票出力対象データ.get介護給付費_決定_負担額());
            source.kaigoKyufuhiChoseiKensu = doカンマ編集(帳票出力対象データ.get介護給付費_調整_件数());
            source.kaigoKyufuhiChoseiTanisu = doカンマ編集(帳票出力対象データ.get介護給付費_調整_単位数());
            source.kaigoKyufuhiChoseiFutangaku = doカンマ編集(帳票出力対象データ.get介護給付費_調整_負担額());
            source.kogakuServicehiSeikyuKensu = doカンマ編集(帳票出力対象データ.get高額介護サービス費_申立_件数());
            source.kogakuServicehiSeikyuTanisu = doカンマ編集(帳票出力対象データ.get高額介護サービス費_申立_単位数());
            source.kogakuServicehiSeikyuFutangaku = doカンマ編集(帳票出力対象データ.get高額介護サービス費_申立_負担額());
            source.kogakuServicehiKetteiKensu = doカンマ編集(帳票出力対象データ.get高額介護サービス費_決定_件数());
            source.kogakuServicehiKetteiTanisu = doカンマ編集(帳票出力対象データ.get高額介護サービス費_決定_単位数());
            source.kogakuServicehiKetteiFutangaku = doカンマ編集(帳票出力対象データ.get高額介護サービス費_決定_負担額());
            source.kogakuServicehiChoseiKensu = doカンマ編集(帳票出力対象データ.get高額介護サービス費_調整_件数());
            source.kogakuServicehiChoseiTanisu = doカンマ編集(帳票出力対象データ.get高額介護サービス費_調整_単位数());
            source.kogakuServicehiChoseiFutangaku = doカンマ編集(帳票出力対象データ.get高額介護サービス費_調整_負担額());
        }

        return source;
    }

    private RString get出力項目(int index) {
        return index < 出力項目リスト.size() ? 出力項目リスト.get(index) : RString.EMPTY;
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

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
