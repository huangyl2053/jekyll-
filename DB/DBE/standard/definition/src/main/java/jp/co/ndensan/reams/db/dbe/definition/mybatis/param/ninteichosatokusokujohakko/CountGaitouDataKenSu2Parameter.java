/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosatokusokujohakko;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoTempData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査督促状発行のMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class CountGaitouDataKenSu2Parameter {

    private final boolean temp_kaishishuryoubi_NotNull;
    private final FlexibleDate temp_insatuKikanKaishibi;
    private final FlexibleDate temp_insatuKikanShuryoubi;
    private final boolean temp_kaishiNotNull_huryouNull;
    private final boolean temp_kaishiNull_huryouNotNull;
    private final boolean temp_hokennshaCode_isNotEmpty;
    private final RString temp_hokennshaCode;
    private final boolean temp_itakusakiCode_isNotEmpty;
    private final RString temp_ninteiChosaItakusakiCode;
    private final boolean temp_chosainCode_isNotEmpty;
    private final RString temp_ninteiChosainCode;

    private CountGaitouDataKenSu2Parameter(NinteiChosaTokusokujoHakkoTempData tempData) {
        this.temp_kaishishuryoubi_NotNull = (null != tempData.getTemp_印刷期間開始日() && null != tempData.getTemp_印刷期間終了日());
        this.temp_insatuKikanKaishibi = tempData.getTemp_印刷期間開始日() == null
                ? FlexibleDate.EMPTY : new FlexibleDate(tempData.getTemp_印刷期間開始日().toString());
        this.temp_insatuKikanShuryoubi = tempData.getTemp_印刷期間終了日() == null
                ? FlexibleDate.EMPTY : new FlexibleDate(tempData.getTemp_印刷期間終了日().toString());
        this.temp_kaishiNotNull_huryouNull = (null != tempData.getTemp_印刷期間開始日() && null == tempData.getTemp_印刷期間終了日());
        this.temp_kaishiNull_huryouNotNull = (null == tempData.getTemp_印刷期間開始日() && null != tempData.getTemp_印刷期間終了日());
        this.temp_hokennshaCode_isNotEmpty = !tempData.getTemp_保険者コード().isEmpty();
        if (temp_hokennshaCode_isNotEmpty) {
            this.temp_hokennshaCode = tempData.getTemp_保険者コード();
        } else {
            this.temp_hokennshaCode = null;
        }
        this.temp_itakusakiCode_isNotEmpty = !tempData.getTemp_認定調査委託先コード().isEmpty();
        this.temp_ninteiChosaItakusakiCode = tempData.getTemp_認定調査委託先コード();
        this.temp_chosainCode_isNotEmpty = !tempData.getTemp_認定調査員コード().isEmpty();
        this.temp_ninteiChosainCode = tempData.getTemp_認定調査員コード();
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param tempData NinteiChosaTokusokujoHakkoDivのTempData
     * @return 認定調査督促状発行パラメータ
     */
    public static CountGaitouDataKenSu2Parameter createParam(NinteiChosaTokusokujoHakkoTempData tempData) {
        return new CountGaitouDataKenSu2Parameter(tempData);
    }
}
