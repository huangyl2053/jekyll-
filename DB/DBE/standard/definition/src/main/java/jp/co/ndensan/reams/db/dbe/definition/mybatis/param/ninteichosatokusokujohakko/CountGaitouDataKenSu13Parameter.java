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
public class CountGaitouDataKenSu13Parameter {

    private final FlexibleDate temp_ninteichosaKigenYMD;
    private final boolean temp_insatusumiTaishoumono_Equal_1;
    private final boolean temp_hokennshaCode_isNotEmpty;
    private final RString temp_hokennshaCode;
    private final boolean temp_ninteiChosaItakusakiCode_isNotEmpty;
    private final RString temp_ninteiChosaItakusakiCode;
    private final boolean temp_ninteiChosainCode_isNotEmpty;
    private final RString temp_ninteiChosainCode;

    private CountGaitouDataKenSu13Parameter(NinteiChosaTokusokujoHakkoTempData tempData) {
        this.temp_ninteichosaKigenYMD = tempData.getTemp_基準日().minusDay(tempData.getTemp_認定調査督促期限日数().intValue());
        this.temp_insatusumiTaishoumono_Equal_1 = tempData.getTemp_印刷済対象者().equals(new RString("1"));
        this.temp_hokennshaCode_isNotEmpty = !tempData.getTemp_保険者コード().isEmpty();
        this.temp_hokennshaCode = tempData.getTemp_保険者コード();
        this.temp_ninteiChosaItakusakiCode_isNotEmpty = !tempData.getTemp_認定調査委託先コード().isEmpty();
        this.temp_ninteiChosaItakusakiCode = tempData.getTemp_認定調査委託先コード();
        this.temp_ninteiChosainCode_isNotEmpty = !tempData.getTemp_認定調査員コード().isEmpty();
        this.temp_ninteiChosainCode = tempData.getTemp_認定調査員コード();
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param tempData NinteiChosaTokusokujoHakkoDivのTempData
     * @return 認定調査督促状発行パラメータ
     */
    public static CountGaitouDataKenSu13Parameter createParam(NinteiChosaTokusokujoHakkoTempData tempData) {
        return new CountGaitouDataKenSu13Parameter(tempData);
    }
}
