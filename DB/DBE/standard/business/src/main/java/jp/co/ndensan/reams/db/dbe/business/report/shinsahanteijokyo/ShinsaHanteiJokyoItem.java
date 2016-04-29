/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 帳票設計_DBE701001_介護認定審査会判定状況表クラスです。
 *
 * @reamsid_L DBE-1450-030 wanghui
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaHanteiJokyoItem {

    private final RString title;
    private final RString gogitaiName;
    private final RString kaisaiKaishiYMD;
    private final RString kaisaiShuryoYMD;
    private final RString kaisaiCount;
    private final RString hokenshaNo;
    private final RString printTimeStamp;
    private final RString hokenshaName;
    private final RString listHanteiHeader_1;
    private final RString listHanteiHeader_2;
    private final RString listHanteiHeader_3;
    private final RString listHanteiHeader_4;
    private final RString listHanteiHeader_5;
    private final RString listHanteiHeader_6;
    private final RString listHanteiHeader_7;
    private final RString listHanteiHeader_8;
    private final RString listHanteiHeader_9;
    private final RString listHantei_1;
    private final RString listHantei_2;
    private final RString listHantei_3;
    private final RString listHantei_4;
    private final RString listHantei_5;
    private final RString listHantei_6;
    private final RString listHantei_7;
    private final RString listHantei_8;
    private final RString listHantei_9;
    private final RString listHantei_10;
    private final RString listHantei_11;
    private final RString listHantei_12;
    private final RString listHantei_13;
    private final RString listHantei_14;
    private final RString listHantei_15;
    private final RString listHanteiKensu_1;
    private final RString listHanteiKensu_2;
    private final RString listHanteiKensu_3;

    /**
     * インスタンスを生成します。
     *
     * @param title タイトル
     * @param gogitaiName 合議体名称
     * @param kaisaiKaishiYMD 開催開始年月日
     * @param kaisaiShuryoYMD 開催終了年月日
     * @param kaisaiCount 開催回数
     * @param hokenshaNo 保険者番号
     * @param printTimeStamp 発行日時
     * @param hokenshaName 保険者名
     * @param listHanteiHeader_1 二次判定要支援1タイトル
     * @param listHanteiHeader_2 二次判定要支援2タイトル
     * @param listHanteiHeader_3 二次判定要支援3タイトル
     * @param listHanteiHeader_4 二次判定要支援4タイトル
     * @param listHanteiHeader_5 二次判定要支援5タイトル
     * @param listHanteiHeader_6 二次判定要支援6タイトル
     * @param listHanteiHeader_7 二次判定要支援7タイトル
     * @param listHanteiHeader_8 二次判定要支援8タイトル
     * @param listHanteiHeader_9 二次判定要支援9タイトル
     * @param listHantei_1 一次判定非該当・二次判定要支援1
     * @param listHantei_2 一次判定非該当・二次判定要支援2
     * @param listHantei_3 一次判定非該当・二次判定要支援3
     * @param listHantei_4 一次判定非該当・二次判定要支援4
     * @param listHantei_5 一次判定非該当・二次判定要支援5
     * @param listHantei_6 一次判定非該当・二次判定要支援6
     * @param listHantei_7 一次判定非該当・二次判定要支援7
     * @param listHantei_8 一次判定非該当・二次判定要支援8
     * @param listHantei_9 一次判定非該当・二次判定要支援9
     * @param listHantei_10 一次判定非該当・二次判定要支援10
     * @param listHantei_11 一次判定非該当・二次判定要支援11
     * @param listHantei_12 一次判定非該当・二次判定要支援12
     * @param listHantei_13 一次判定非該当・二次判定要支援13
     * @param listHantei_14 一次判定非該当・二次判定要支援14
     * @param listHantei_15 一次判定非該当・二次判定要支援15
     * @param listHanteiKensu_1 変更者
     * @param listHanteiKensu_2 軽度
     * @param listHanteiKensu_3 重度
     */
    public ShinsaHanteiJokyoItem(
            RString title,
            RString gogitaiName,
            RString kaisaiKaishiYMD,
            RString kaisaiShuryoYMD,
            RString kaisaiCount,
            RString hokenshaNo,
            RString printTimeStamp,
            RString hokenshaName,
            RString listHanteiHeader_1,
            RString listHanteiHeader_2,
            RString listHanteiHeader_3,
            RString listHanteiHeader_4,
            RString listHanteiHeader_5,
            RString listHanteiHeader_6,
            RString listHanteiHeader_7,
            RString listHanteiHeader_8,
            RString listHanteiHeader_9,
            RString listHantei_1,
            RString listHantei_2,
            RString listHantei_3,
            RString listHantei_4,
            RString listHantei_5,
            RString listHantei_6,
            RString listHantei_7,
            RString listHantei_8,
            RString listHantei_9,
            RString listHantei_10,
            RString listHantei_11,
            RString listHantei_12,
            RString listHantei_13,
            RString listHantei_14,
            RString listHantei_15,
            RString listHanteiKensu_1,
            RString listHanteiKensu_2,
            RString listHanteiKensu_3
    ) {
        this.title = title;
        this.gogitaiName = gogitaiName;
        this.kaisaiKaishiYMD = kaisaiKaishiYMD;
        this.kaisaiShuryoYMD = kaisaiShuryoYMD;
        this.kaisaiCount = kaisaiCount;
        this.hokenshaNo = hokenshaNo;
        this.printTimeStamp = printTimeStamp;
        this.hokenshaName = hokenshaName;
        this.listHanteiHeader_1 = listHanteiHeader_1;
        this.listHanteiHeader_2 = listHanteiHeader_2;
        this.listHanteiHeader_3 = listHanteiHeader_3;
        this.listHanteiHeader_4 = listHanteiHeader_4;
        this.listHanteiHeader_5 = listHanteiHeader_5;
        this.listHanteiHeader_6 = listHanteiHeader_6;
        this.listHanteiHeader_7 = listHanteiHeader_7;
        this.listHanteiHeader_8 = listHanteiHeader_8;
        this.listHanteiHeader_9 = listHanteiHeader_9;
        this.listHantei_1 = listHantei_1;
        this.listHantei_2 = listHantei_2;
        this.listHantei_3 = listHantei_3;
        this.listHantei_4 = listHantei_4;
        this.listHantei_5 = listHantei_5;
        this.listHantei_6 = listHantei_6;
        this.listHantei_7 = listHantei_7;
        this.listHantei_8 = listHantei_8;
        this.listHantei_9 = listHantei_9;
        this.listHantei_10 = listHantei_10;
        this.listHantei_11 = listHantei_11;
        this.listHantei_12 = listHantei_12;
        this.listHantei_13 = listHantei_13;
        this.listHantei_14 = listHantei_14;
        this.listHantei_15 = listHantei_15;
        this.listHanteiKensu_1 = listHanteiKensu_1;
        this.listHanteiKensu_2 = listHanteiKensu_2;
        this.listHanteiKensu_3 = listHanteiKensu_3;
    }
}
