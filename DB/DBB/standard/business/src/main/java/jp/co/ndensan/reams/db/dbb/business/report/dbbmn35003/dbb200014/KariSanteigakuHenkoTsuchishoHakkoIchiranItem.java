/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200014;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 仮算定額変更通知書発行一覧表の情報です。
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KariSanteigakuHenkoTsuchishoHakkoIchiranItem {

    private final RString printTimeStamp;
    private final RString nendo;
    private final RString hokenshaNo;
    private final RString hokenshaName;
    private final RString shutsuryokujun1;
    private final RString shutsuryokujun2;
    private final RString shutsuryokujun3;
    private final RString shutsuryokujun4;
    private final RString shutsuryokujun5;
    private final RString hyojicodeName1;
    private final RString hyojicodeName2;
    private final RString hyojicodeName3;
    private final RString listUpper_1;
    private final RString listUpper_2;
    private final RString listUpper_3;
    private final RString listUpper_4;
    private final RString listUpper_5;
    private final RString listUpper_6;
    private final RString listUpper_7;
    private final RString listUpper_8;
    private final RString listUpper_9;
    private final RString listUpper_10;
    private final RString listUpper_11;
    private final RString listLower_1;
    private final RString listLower_2;
    private final RString listLower_3;
    private final RString listLower_4;
    private final RString listLower_5;
    private final RString listLower_6;

    /**
     * コンストラクタです
     *
     * @param printTimeStamp 作成日時
     * @param nendo 年度
     * @param hokenshaNo 市町村コード
     * @param hokenshaName 市町村名称
     * @param shutsuryokujun1 出力順１
     * @param shutsuryokujun2 出力順２
     * @param shutsuryokujun3 出力順３
     * @param shutsuryokujun4 出力順４
     * @param shutsuryokujun5 出力順５
     * @param hyojicodeName1 表示コード名１
     * @param hyojicodeName2 表示コード名２
     * @param hyojicodeName3 表示コード名３
     * @param listUpper_1 連番
     * @param listUpper_2 通知書番号
     * @param listUpper_3 被保険者氏番号
     * @param listUpper_4 世帯コード
     * @param listUpper_5 表示コード１
     * @param listUpper_6 表示コード２
     * @param listUpper_7 表示コード３
     * @param listUpper_8 保険料額 （更正前 ）
     * @param listUpper_9 徴収方法 （更正後 ）
     * @param listUpper_10 生保開始日
     * @param listUpper_11 生保種別
     * @param listLower_1 氏名
     * @param listLower_2 郵便番号
     * @param listLower_3 住所
     * @param listLower_4 保険料額 （更正後 ）
     * @param listLower_5 徴収方法 （更正後 ）
     * @param listLower_6 口座情報
     */
    public KariSanteigakuHenkoTsuchishoHakkoIchiranItem(
            RString printTimeStamp,
            RString nendo,
            RString hokenshaNo,
            RString hokenshaName,
            RString shutsuryokujun1,
            RString shutsuryokujun2,
            RString shutsuryokujun3,
            RString shutsuryokujun4,
            RString shutsuryokujun5,
            RString hyojicodeName1,
            RString hyojicodeName2,
            RString hyojicodeName3,
            RString listUpper_1,
            RString listUpper_2,
            RString listUpper_3,
            RString listUpper_4,
            RString listUpper_5,
            RString listUpper_6,
            RString listUpper_7,
            RString listUpper_8,
            RString listUpper_9,
            RString listUpper_10,
            RString listUpper_11,
            RString listLower_1,
            RString listLower_2,
            RString listLower_3,
            RString listLower_4,
            RString listLower_5,
            RString listLower_6
    ) {
        this.printTimeStamp = printTimeStamp;
        this.nendo = nendo;
        this.hokenshaNo = hokenshaNo;
        this.hokenshaName = hokenshaName;
        this.shutsuryokujun1 = shutsuryokujun1;
        this.shutsuryokujun2 = shutsuryokujun2;
        this.shutsuryokujun3 = shutsuryokujun3;
        this.shutsuryokujun4 = shutsuryokujun4;
        this.shutsuryokujun5 = shutsuryokujun5;
        this.hyojicodeName1 = hyojicodeName1;
        this.hyojicodeName2 = hyojicodeName2;
        this.hyojicodeName3 = hyojicodeName3;
        this.listUpper_1 = listUpper_1;
        this.listUpper_2 = listUpper_2;
        this.listUpper_3 = listUpper_3;
        this.listUpper_4 = listUpper_4;
        this.listUpper_5 = listUpper_5;
        this.listUpper_6 = listUpper_6;
        this.listUpper_7 = listUpper_7;
        this.listUpper_8 = listUpper_8;
        this.listUpper_9 = listUpper_9;
        this.listUpper_10 = listUpper_10;
        this.listUpper_11 = listUpper_11;
        this.listLower_1 = listLower_1;
        this.listLower_2 = listLower_2;
        this.listLower_3 = listLower_3;
        this.listLower_4 = listLower_4;
        this.listLower_5 = listLower_5;
        this.listLower_6 = listLower_6;
        

    }

}
