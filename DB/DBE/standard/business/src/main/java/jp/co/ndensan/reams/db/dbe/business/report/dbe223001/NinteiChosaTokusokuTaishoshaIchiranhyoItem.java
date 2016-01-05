/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.report.dbe223001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 認定調査督促対象者一覧表情報です。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaTokusokuTaishoshaIchiranhyoItem {
    private final RString cityCode;
    private final RString cityName;
    private final RString kikanNameTitle;
    private final RString kikanJushoTitle;
    private final RString nameTitle;
    private final RString kikanTelTitle;
    private final RString listNo_1;
    private final RString listUpper1_1;
    private final RString listUpper1_2;
    private final RString listShinseiYMD_1;
    private final RString listTokusokujoHakkoYMD_1;
    private final RString listUpper2_1;
    private final RString listUpper2_2;
    private final RString listLower1_1;
    private final RString listLower1_2;
    private final RString listLower2_1;
    private final RString listLower2_2;

    /**
     * コンストラクタです。
     * @param cityCode cityCode
     * @param cityName cityName
     * @param kikanNameTitle kikanNameTitle
     * @param kikanJushoTitle kikanJushoTitle
     * @param nameTitle nameTitle
     * @param kikanTelTitle kikanTelTitle
     * @param listNo_1 listNo_1
     * @param listUpper1_1 listUpper1_1
     * @param listUpper1_2 listUpper1_2
     * @param listShinseiYMD_1 listShinseiYMD_1
     * @param listTokusokujoHakkoYMD_1 listTokusokujoHakkoYMD_1
     * @param listUpper2_1 listUpper2_1
     * @param listUpper2_2 listUpper2_2
     * @param listLower1_1 listLower1_1
     * @param listLower1_2 listLower1_2
     * @param listLower2_1 listLower2_1
     * @param listLower2_2 listLower2_2
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoItem(
            RString cityCode,
            RString cityName,
            RString kikanNameTitle,
            RString kikanJushoTitle,
            RString nameTitle,
            RString kikanTelTitle,
            RString listNo_1,
            RString listUpper1_1,
            RString listUpper1_2,
            RString listShinseiYMD_1,
            RString listTokusokujoHakkoYMD_1,
            RString listUpper2_1,
            RString listUpper2_2,
            RString listLower1_1,
            RString listLower1_2,
            RString listLower2_1,
            RString listLower2_2
    ) {
            this.cityCode = cityCode;
            this.cityName = cityName;
            this.kikanNameTitle = kikanNameTitle;
            this.kikanJushoTitle = kikanJushoTitle;
            this.nameTitle = nameTitle;
            this.kikanTelTitle = kikanTelTitle;
            this.listNo_1 = listNo_1;
            this.listUpper1_1 = listUpper1_1;
            this.listUpper1_2 = listUpper1_2;
            this.listShinseiYMD_1 = listShinseiYMD_1;
            this.listTokusokujoHakkoYMD_1 = listTokusokujoHakkoYMD_1;
            this.listUpper2_1 = listUpper2_1;
            this.listUpper2_2 = listUpper2_2;
            this.listLower1_1 = listLower1_1;
            this.listLower1_2 = listLower1_2;
            this.listLower2_1 = listLower2_1;
            this.listLower2_2 = listLower2_2;
    }
    
}
