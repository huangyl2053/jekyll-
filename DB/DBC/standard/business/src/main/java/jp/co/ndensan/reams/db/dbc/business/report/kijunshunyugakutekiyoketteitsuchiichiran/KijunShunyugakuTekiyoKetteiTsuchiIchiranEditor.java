/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoketteitsuchiichiran.KijunShunyugakuTekiyoKetteiTsuchiIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票Editorクラスです。
 *
 * @reamsid_L DBC-4610-050 xuhao
 */
public class KijunShunyugakuTekiyoKetteiTsuchiIchiranEditor implements IKijunShunyugakuTekiyoKetteiTsuchiIchiranEditor {

    private final KijunShunyugakuTekiyoKetteiTsuchiIchiran 基準収入額決定通知一覧表パラメータ;
    private static final int INT_0 = 0;

    /**
     * コンストラクタです
     *
     * @param 基準収入額決定通知一覧表パラメータ KijunShunyugakuTekiyoKetteiTsuchiIchiran
     */
    protected KijunShunyugakuTekiyoKetteiTsuchiIchiranEditor(KijunShunyugakuTekiyoKetteiTsuchiIchiran 基準収入額決定通知一覧表パラメータ) {
        this.基準収入額決定通知一覧表パラメータ = 基準収入額決定通知一覧表パラメータ;
    }

    @Override
    public KijunShunyugakuTekiyoKetteiTsuchiIchiranSource edit(KijunShunyugakuTekiyoKetteiTsuchiIchiranSource source) {
        source.printTimeStamp = YMDHMS.now().toDateString();
        if (基準収入額決定通知一覧表パラメータ.get市町村番号() != null) {
            source.shichosonNo = 基準収入額決定通知一覧表パラメータ.get市町村番号().value();
        }
        source.shichosonName = 基準収入額決定通知一覧表パラメータ.get市町村名();
        source.shutsuryokujun1 = 基準収入額決定通知一覧表パラメータ.get出力順１();
        source.shutsuryokujun2 = 基準収入額決定通知一覧表パラメータ.get出力順２();
        source.shutsuryokujun3 = 基準収入額決定通知一覧表パラメータ.get出力順３();
        source.shutsuryokujun4 = 基準収入額決定通知一覧表パラメータ.get出力順４();
        source.shutsuryokujun5 = 基準収入額決定通知一覧表パラメータ.get出力順５();
        source.kaipage1 = 基準収入額決定通知一覧表パラメータ.get改頁１();
        source.kaipage2 = 基準収入額決定通知一覧表パラメータ.get改頁２();
        source.kaipage3 = 基準収入額決定通知一覧表パラメータ.get改頁３();
        source.kaipage4 = 基準収入額決定通知一覧表パラメータ.get改頁４();
        source.kaipage5 = 基準収入額決定通知一覧表パラメータ.get改頁５();
        source.listHakkoTaishosha_1 = new RString(String.valueOf(基準収入額決定通知一覧表パラメータ.get通番()));
        if (基準収入額決定通知一覧表パラメータ.get世帯コード() != null) {
            source.listHakkoTaishosha_2 = 基準収入額決定通知一覧表パラメータ.get世帯コード().value();
        }
        source.listHakkoTaishosha_3 = 基準収入額決定通知一覧表パラメータ.get年度().wareki().toDateString();
        if (基準収入額決定通知一覧表パラメータ.get被保険者番号() != null) {
            source.listHakkoTaishosha_4 = 基準収入額決定通知一覧表パラメータ.get被保険者番号().value();
        }
        if (基準収入額決定通知一覧表パラメータ.get氏名() != null) {
            source.listHakkoTaishosha_5 = 基準収入額決定通知一覧表パラメータ.get氏名().value();
        }
        if (基準収入額決定通知一覧表パラメータ.get申請年月日() != null) {
            source.listHakkoTaishosha_6 = 基準収入額決定通知一覧表パラメータ.get申請年月日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
        }
        if (基準収入額決定通知一覧表パラメータ.get決定年月日() != null) {
            source.listHakkoTaishosha_7 = 基準収入額決定通知一覧表パラメータ.get決定年月日().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
        }
        if (基準収入額決定通知一覧表パラメータ.get適用開始年月() != null) {
            source.listHakkoTaishosha_8 = 基準収入額決定通知一覧表パラメータ.get適用開始年月().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
        }
        if (基準収入額決定通知一覧表パラメータ.get算定基準額() != null) {
            source.listHakkoTaishosha_9 = DecimalFormatter.toコンマ区切りRString(基準収入額決定通知一覧表パラメータ.get算定基準額(), INT_0);
        }
        source.listHakkoTaishosha_10 = 基準収入額決定通知一覧表パラメータ.get備考();
        if (基準収入額決定通知一覧表パラメータ.get識別コード() != null) {
            source.listHakkoTaishosha_11 = 基準収入額決定通知一覧表パラメータ.get識別コード().value();
        }
        return source;
    }

}
