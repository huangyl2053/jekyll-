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
    private final RString listUpper1_2;
    private final RString listUpper2_1;
    private final RString listUpper2_2;
    private final RDate listShinseiYMD_1;
    private final RDate listTokusokujoHakkoYMD_1;
    private final RString listNo_1;
    private final RString kikanName;
    private final RString kikanJusho;
    private final RString name;
    private final RString kikanTel;
    private final RString 出力順;
    private final RString 改頁;

    /**
     *
     * @param cityCode 市町村コード
     * @param cityName 市町村名称
     * @param listUpper1_1 保険者名
     * @param listUpper1_2 被保険者番号
     * @param listUpper2_1 被保険者氏名カナ
     * @param listUpper2_2 被保険者氏名
     * @param listShinseiYMD_1 申請日
     * @param listTokusokujoHakkoYMD_1 督促状発行日
     * @param listNo_1 No
     * @param kikanName 事業者名称
     * @param kikanJusho 事業者住所
     * @param name 氏名
     * @param kikanTel 事業者電話番号
     * @param 出力順 出力順
     * @param 改頁 改頁
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoItem(RString cityCode, RString cityName, RString listNo_1, RString listUpper1_1,
            RString listUpper1_2, RString listUpper2_1, RString listUpper2_2, RDate listShinseiYMD_1,
            RDate listTokusokujoHakkoYMD_1, RString kikanName, RString kikanJusho, RString name,
            RString kikanTel, RString 出力順, RString 改頁) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.listNo_1 = listNo_1;
        this.listUpper1_1 = listUpper1_1;
        this.listUpper1_2 = listUpper1_2;
        this.listUpper2_1 = listUpper2_1;
        this.listUpper2_2 = listUpper2_2;
        this.listShinseiYMD_1 = listShinseiYMD_1;
        this.listTokusokujoHakkoYMD_1 = listTokusokujoHakkoYMD_1;

        //TODO:QA:NO.638.
        this.kikanName = kikanName;
        //TODO:QA:NO.638.
        this.kikanJusho = kikanJusho;
        //TODO:QA:NO.638.
        this.name = name;
        //TODO:QA:NO.638.
        this.kikanTel = kikanTel;
        this.出力順 = 出力順;
        this.改頁 = 改頁;
        //TODO
    }

}
