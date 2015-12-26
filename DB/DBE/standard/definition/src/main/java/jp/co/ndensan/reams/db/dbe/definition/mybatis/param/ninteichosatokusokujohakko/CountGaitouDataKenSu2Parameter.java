/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosatokusokujohakko;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoTempData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査督促状発行のMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class CountGaitouDataKenSu2Parameter {

    private final boolean temp_kaishibiAndShuryoubi_isNotNull;
    private final RDate temp_insatuKikanKaishibi;
    private final RDate temp_insatuKikanShuryoubi;
    private final boolean temp_kaishibi_isNotNull_huryoubi_isNull;
    private final boolean temp_kaishibi_isNull_huryoubi_isNotNull;
    private final boolean temp_hokennshaCode_isNotEmpty;
    private final RString temp_hokennshaCode;
    private final boolean temp_ninteiChosaItakusakiCode_isNotEmpty;
    private final RString temp_ninteiChosaItakusakiCode;
    private final boolean temp_ninteiChosainCode_isNotEmpty;
    private final RString temp_ninteiChosainCode;

    private CountGaitouDataKenSu2Parameter(NinteiChosaTokusokujoHakkoTempData tempData) {
        this.temp_kaishibiAndShuryoubi_isNotNull = (null != tempData.getTemp_印刷期間開始日() && null != tempData.getTemp_印刷期間終了日());
        this.temp_insatuKikanKaishibi = tempData.getTemp_印刷期間開始日();
        this.temp_insatuKikanShuryoubi = tempData.getTemp_印刷期間終了日();
        this.temp_kaishibi_isNotNull_huryoubi_isNull = (null != tempData.getTemp_印刷期間開始日() && null == tempData.getTemp_印刷期間終了日());
        this.temp_kaishibi_isNull_huryoubi_isNotNull = (null == tempData.getTemp_印刷期間開始日() && null != tempData.getTemp_印刷期間終了日());
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
    public static CountGaitouDataKenSu2Parameter createParam(NinteiChosaTokusokujoHakkoTempData tempData) {
        return new CountGaitouDataKenSu2Parameter(tempData);
    }
}
