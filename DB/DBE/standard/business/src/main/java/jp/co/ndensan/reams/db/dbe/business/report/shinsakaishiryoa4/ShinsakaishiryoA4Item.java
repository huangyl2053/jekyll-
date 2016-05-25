/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事務局用介護認定審査対象者一覧表のITEMです。
 *
 * @reamsid_L DBE-0150-020 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaishiryoA4Item {

    private RString shinsakaiNo;
    private RString year;
    private RString listshinsainName_1;
    private RString gogitaiNo;
    private RString shinsaTaishoshaCount;
    private RString list1_1;
    private RString list1_2;
    private RString list1_3;
    private RString list1_4;
    private RString list1_5;
    private RString list1_6;
    private RString list1_7;
    private RString list1_8;
    private RString list1_9;
    private RString list1_10;
    private RString list1_11;
    private RString list1_12;
    private RString list1_13;

    /**
     * インスタンスを生成します。
     *
     * @param shinsakaiNo 審査会番号
     * @param year 審査会開催年月日
     * @param listshinsainName_1 審査員一覧
     * @param gogitaiNo 合議体番号
     * @param shinsaTaishoshaCount 審査対象者数
     * @param list1_1 NO
     * @param list1_2 保険者
     * @param list1_3 被保険者
     * @param list1_4 氏名
     * @param list1_5 性別
     * @param list1_6 年齢
     * @param list1_7 前回二次
     * @param list1_8 前回期間
     * @param list1_9 一次判定
     * @param list1_10 警告
     * @param list1_11 基準時間
     * @param list1_12 審査結果
     * @param list1_13 期間
     */
    public ShinsakaishiryoA4Item(
            RString shinsakaiNo,
            RString year,
            RString listshinsainName_1,
            RString gogitaiNo,
            RString shinsaTaishoshaCount,
            RString list1_1,
            RString list1_2,
            RString list1_3,
            RString list1_4,
            RString list1_5,
            RString list1_6,
            RString list1_7,
            RString list1_8,
            RString list1_9,
            RString list1_10,
            RString list1_11,
            RString list1_12,
            RString list1_13) {
        this.shinsakaiNo = shinsakaiNo;
        this.year = year;
        this.listshinsainName_1 = listshinsainName_1;
        this.gogitaiNo = gogitaiNo;
        this.shinsaTaishoshaCount = shinsaTaishoshaCount;
        this.list1_1 = list1_1;
        this.list1_2 = list1_2;
        this.list1_3 = list1_3;
        this.list1_4 = list1_4;
        this.list1_5 = list1_5;
        this.list1_6 = list1_6;
        this.list1_7 = list1_7;
        this.list1_8 = list1_8;
        this.list1_9 = list1_9;
        this.list1_10 = list1_10;
        this.list1_11 = list1_11;
        this.list1_12 = list1_12;
        this.list1_13 = list1_13;
    }

}
