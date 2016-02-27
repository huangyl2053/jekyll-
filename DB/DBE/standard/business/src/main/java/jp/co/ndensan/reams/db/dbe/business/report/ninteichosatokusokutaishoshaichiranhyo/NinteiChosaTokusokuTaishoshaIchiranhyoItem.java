/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書督促対象者一覧表のITEMです。
 *
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaTokusokuTaishoshaIchiranhyoItem {

    private final RString cityCode;
    private final RString cityName;
    private final RString listUpper1_1;
    private final RString listLower1_1;
    private final RString listUpper1_2;
    private final RString listLower1_2;
    private final RDate listShinseiYMD_1;
    private final RDate listTokusokujoHakkoYMD_1;
    private final RString listLower2_1;
    private final RString listUpper2_1;
    private final RString listUpper2_2;
    private final RString listLower2_2;

    /**
     *
     * @param cityCode 市町村コード
     * @param cityName 市町村名称
     * @param listUpper1_1 保険者名
     * @param listLower1_1 被保険者番号
     * @param listUpper1_2 被保険者氏名カナ
     * @param listLower1_2 被保険者氏名
     * @param listShinseiYMD_1 申請日
     * @param listTokusokujoHakkoYMD_1 督促状発行日
     * @param listLower2_1 氏名
     * @param listUpper2_1 事業者名称
     * @param listUpper2_2 事業者住所
     * @param listLower2_2 事業者電話番号
     *
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoItem(RString cityCode, RString cityName, RString listUpper1_1,
            RString listLower1_1, RString listUpper1_2,
            RString listLower1_2, RDate listShinseiYMD_1,
            RDate listTokusokujoHakkoYMD_1, RString listLower2_1,
            RString listUpper2_1, RString listUpper2_2, RString listLower2_2) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.listUpper1_1 = listUpper1_1;
        this.listLower1_1 = listLower1_1;
        this.listUpper1_2 = listUpper1_2;
        this.listLower1_2 = listLower1_2;
        this.listShinseiYMD_1 = listShinseiYMD_1;
        this.listTokusokujoHakkoYMD_1 = listTokusokujoHakkoYMD_1;
        this.listLower2_1 = listLower2_1;
        this.listUpper2_1 = listUpper2_1;
        this.listUpper2_2 = listUpper2_2;
        this.listLower2_2 = listLower2_2;
    }

}
