/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表の情報です。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuChoHeijunkaKariSanteigakuHakkoIchiranItem {

    private final RString nendo;
    private final RString hokenshaNo;
    private final RString hokenshaName;
    private final RString shutsuryokujun1;
    private final RString shutsuryokujun2;
    private final RString shutsuryokujun3;
    private final RString shutsuryokujun4;
    private final RString shutsuryokujun5;
    private final RString kaipage1;
    private final RString kaipage2;
    private final RString kaipage3;
    private final RString kaipage4;
    private final RString kaipage5;
    private final RString listUpper_1;
    private final RString listUpper_2;
    private final RString listUpper_3;
    private final RString listUpper_4;
    private final RString listUpper_5;
    private final RString listUpper_6;
    private final RString listUpper_7;
    private final RString listUpper_8;
    private final RString listUpper_9;
    private final RString listLower_1;
    private final RString listLower_2;
    private final RString listLower_3;
    private final RString listLower_4;
    private final RString listLower_5;
    private final RString listLower_6;
    private final RString listLower_7;
    private final RString listLower_8;

    /**
     * コンストラクタです。
     *
     * @param nendo 年度
     * @param hokenshaNo 市町村コード
     * @param hokenshaName 市町村名称
     * @param shutsuryokujun1 並び順１
     * @param shutsuryokujun2 並び順２
     * @param shutsuryokujun3 並び順３
     * @param shutsuryokujun4 並び順４
     * @param shutsuryokujun5 並び順５
     * @param kaipage1 改頁１
     * @param kaipage2 改頁２
     * @param kaipage3 改頁３
     * @param kaipage4 改頁４
     * @param kaipage5 改頁５
     * @param listUpper_1 連番
     * @param listUpper_2 郵便番号
     * @param listUpper_3 住所
     * @param listUpper_4 行政区
     * @param listUpper_5 性別
     * @param listUpper_6 生年月日
     * @param listUpper_7 変更前特徴額（１期）
     * @param listUpper_8 変更前特徴額（２期）
     * @param listUpper_9 変更前特徴額（３期）
     * @param listLower_1 通知書番号
     * @param listLower_2 世帯コード
     * @param listLower_3 被保険者氏名
     * @param listLower_4 特別徴収義務者
     * @param listLower_5 特別徴対象年金
     * @param listLower_6 変更後特徴額（１期）
     * @param listLower_7 変更後特徴額（２期）
     * @param listLower_8 変更後特徴額（３期）
     */
    public TokuChoHeijunkaKariSanteigakuHakkoIchiranItem(
            RString nendo,
            RString hokenshaNo,
            RString hokenshaName,
            RString shutsuryokujun1,
            RString shutsuryokujun2,
            RString shutsuryokujun3,
            RString shutsuryokujun4,
            RString shutsuryokujun5,
            RString kaipage1,
            RString kaipage2,
            RString kaipage3,
            RString kaipage4,
            RString kaipage5,
            RString listUpper_1,
            RString listUpper_2,
            RString listUpper_3,
            RString listUpper_4,
            RString listUpper_5,
            RString listUpper_6,
            RString listUpper_7,
            RString listUpper_8,
            RString listUpper_9,
            RString listLower_1,
            RString listLower_2,
            RString listLower_3,
            RString listLower_4,
            RString listLower_5,
            RString listLower_6,
            RString listLower_7,
            RString listLower_8
    ) {
        this.nendo = nendo;
        this.hokenshaNo = hokenshaNo;
        this.hokenshaName = hokenshaName;
        this.shutsuryokujun1 = shutsuryokujun1;
        this.shutsuryokujun2 = shutsuryokujun2;
        this.shutsuryokujun3 = shutsuryokujun3;
        this.shutsuryokujun4 = shutsuryokujun4;
        this.shutsuryokujun5 = shutsuryokujun5;
        this.kaipage1 = kaipage1;
        this.kaipage2 = kaipage2;
        this.kaipage3 = kaipage3;
        this.kaipage4 = kaipage4;
        this.kaipage5 = kaipage5;
        this.listUpper_1 = listUpper_1;
        this.listUpper_2 = listUpper_2;
        this.listUpper_3 = listUpper_3;
        this.listUpper_4 = listUpper_4;
        this.listUpper_5 = listUpper_5;
        this.listUpper_6 = listUpper_6;
        this.listUpper_7 = listUpper_7;
        this.listUpper_8 = listUpper_8;
        this.listUpper_9 = listUpper_9;
        this.listLower_1 = listLower_1;
        this.listLower_2 = listLower_2;
        this.listLower_3 = listLower_3;
        this.listLower_4 = listLower_4;
        this.listLower_5 = listLower_5;
        this.listLower_6 = listLower_6;
        this.listLower_7 = listLower_7;
        this.listLower_8 = listLower_8;

    }

}
