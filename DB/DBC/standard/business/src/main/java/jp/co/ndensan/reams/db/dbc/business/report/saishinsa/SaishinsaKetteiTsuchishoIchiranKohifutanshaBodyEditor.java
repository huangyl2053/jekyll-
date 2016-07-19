/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsa;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsa.SaishinsaKetteiTsuchishoChohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.saishinsa.SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 再審査決定通知書情報取込一覧表（公費負担者分）帳票BodyEditor
 *
 * @reamsid_L DBC-2820-050 sunhui
 */
public class SaishinsaKetteiTsuchishoIchiranKohifutanshaBodyEditor
        implements ISaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor {

    private final SaishinsaKetteiTsuchishoChohyoEntity 帳票出力対象データ;
    private final boolean 集計Flag;

    private static final RString 申立タイトル = new RString("＜再審査申立＞");
    private static final RString 申立件数タイトル = new RString("件数");
    private static final RString 申立単位数タイトル = new RString("単位数");
    private static final RString 申立負担額タイトル = new RString("公費負担額");
    private static final RString 決定タイトル = new RString("＜再審査決定＞");
    private static final RString 決定件数タイトル = new RString("件数");
    private static final RString 決定単位数タイトル = new RString("単位数");
    private static final RString 決定負担額タイトル = new RString("公費負担額");
    private static final RString 調整タイトル = new RString("＜調整＞");
    private static final RString 調整件数タイトル = new RString("件数");
    private static final RString 調整単位数タイトル = new RString("単位数");
    private static final RString 調整負担額タイトル = new RString("公費負担額");
    private static final RString 介護給付費タイトル = new RString("介護給付費");
    private static final RString 高額介護サービス費タイトル = new RString("高額介護サービス費");

    private static final CodeShubetsu 再審査結果コード = new CodeShubetsu("0020");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SaishinsaKetteiTsuchishoChohyoEntity
     * @param 集計Flag boolean
     */
    public SaishinsaKetteiTsuchishoIchiranKohifutanshaBodyEditor(
            SaishinsaKetteiTsuchishoChohyoEntity 帳票出力対象データ, boolean 集計Flag) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.集計Flag = 集計Flag;
    }

    @Override
    public SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource edit(
            SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource source) {
        edit明細(source);
        if (集計Flag) {
            edit集計(source);
        }
        return source;
    }

    private void edit明細(SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource source) {
        source.listUpper_1 = new RString(帳票出力対象データ.get連番());
        source.listUpper_2 = doパターン54(帳票出力対象データ.get取扱年月());
        source.listUpper_3 = 帳票出力対象データ.get事業者番号().getColumnValue();
        source.listUpper_4 = 帳票出力対象データ.get事業者名();
        source.listUpper_5 = doパターン54(帳票出力対象データ.getサービス提供年月());
        source.listUpper_6 = 帳票出力対象データ.getサービス種類コード().getColumnValue();
        source.listUpper_7 = 帳票出力対象データ.getサービス種類名();
        if (null != 帳票出力対象データ.get再審査結果コード()) {
            source.listUpper_8 = 帳票出力対象データ.get再審査結果コード().getColumnValue();
        }
        source.listUpper_9 = doカンマ編集(帳票出力対象データ.get当初請求単位数());
        source.listUpper_10 = doカンマ編集(帳票出力対象データ.get申立単位数());
        source.listUpper_11 = doカンマ編集(帳票出力対象データ.get調整単位数());
        if (null != 帳票出力対象データ.get被保険者番号()) {
            source.listLower_1 = 帳票出力対象データ.get被保険者番号().getColumnValue();
        }
        source.listLower_2 = 帳票出力対象データ.get公費受給者名();
        if (null != 帳票出力対象データ.get申立事由コード()) {
            source.listLower_3 = 帳票出力対象データ.get申立事由コード().getColumnValue();
        }
        source.listLower_4 = 帳票出力対象データ.get申立事由();
        if (null != 帳票出力対象データ.get再審査結果コード()) {
            RString 再審査結果 = CodeMaster.getCodeMeisho(再審査結果コード, 帳票出力対象データ.get再審査結果コード());
            source.listLower_5 = 再審査結果;
        }
        source.listLower_6 = doカンマ編集(帳票出力対象データ.get原審単位数());
        source.listLower_7 = doカンマ編集(帳票出力対象データ.get決定単位数());
        source.listLower_8 = doカンマ編集(帳票出力対象データ.get公費負担額());
    }

    private void edit集計(SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource source) {
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
