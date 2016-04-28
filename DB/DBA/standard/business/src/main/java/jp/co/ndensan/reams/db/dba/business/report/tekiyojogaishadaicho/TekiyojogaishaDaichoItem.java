/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 適用除外者台帳のITEMクラスです。
 *
 * @reamsid_L DBA-0412-040 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TekiyojogaishaDaichoItem {

    private final RString printTimeStamp;
    private final RString title;
    private final RString shichosonCode;
    private final RString shichosonName;
    private final RString birthYMD;
    private final RString seibetsu;
    private final RString setaiCode;
    private final RString shikibetsuCode;
    private final RString shimeiKana;
    private final RString chiku1CodeTitle;
    private final RString chiku1Code;
    private final RString shimei;
    private final RString jotai;
    private final RString telNoTitle;
    private final RString chiku2CodeTitle;
    private final RString chiku2Code;
    private final RString jusho1;
    private final RString jusho1Title;
    private final RString telNo1;
    private final RString telNo2;
    private final RString chiku3CodeTitle;
    private final RString chiku3Code;
    private final RString jusho1Code;
    private final RString gyoseikuTitle;
    private final RString gyoseikuCode;
    private final RString jusho2;
    private final RString jusho2Title;
    private final RString jusho2Code;
    private final RString listNo_1;
    private final RString listUpper_1;
    private final RString listUpper_2;
    private final RString listUpper_3;
    private final RString listUpper_4;
    private final RString listUpper_5;
    private final RString listUpper_6;
    private final RString listUpper_7;
    private final RString listLower_1;
    private final RString listLower_2;
    private final RString listLower_3;
    private final RString listLower_4;
    private final RString listLower_5;
    private final RString listLower_6;
    private final RString listLower_7;

    /**
     * コンストラクタです。
     *
     * @param printTimeStamp 印刷日時
     * @param title タイトル
     * @param shichosonCode 市町村コード
     * @param shichosonName 市町村名称
     * @param birthYMD 生年月日
     * @param seibetsu 性別
     * @param setaiCode 世帯コード
     * @param shikibetsuCode 識別コード
     * @param shimeiKana 氏名カナ
     * @param chiku1CodeTitle 地区タイトル1
     * @param chiku1Code 地区コード1
     * @param shimei 氏名
     * @param jotai 状態
     * @param telNoTitle 電話番号タイトル
     * @param chiku2CodeTitle 地区タイトル2
     * @param chiku2Code 地区コード2
     * @param jusho1 住所1
     * @param jusho1Title 住所タイトル1
     * @param telNo1 電話番号１
     * @param telNo2 電話番号２
     * @param chiku3CodeTitle 地区タイトル3
     * @param chiku3Code 地区コード3
     * @param jusho1Code 住所コード
     * @param gyoseikuTitle 行政区タイトル
     * @param gyoseikuCode 行政区コード
     * @param jusho2 住所2
     * @param jusho2Title 住所タイトル2
     * @param jusho2Code 住所コード2
     * @param listNo_1 NO
     * @param listUpper_1 適用年月日
     * @param listUpper_2 適用届出年月日
     * @param listUpper_3 適用除外適用事由コード
     * @param listUpper_4 適用除外適用事由名称
     * @param listUpper_5 入所年月日
     * @param listUpper_6 事業者名称
     * @param listUpper_7 電話番号
     * @param listLower_1 解除年月日
     * @param listLower_2 解除届出年月日
     * @param listLower_3 適用除外解除事由コード
     * @param listLower_4 適用除外解除事由名称
     * @param listLower_5 退所年月日
     * @param listLower_6 事業者住所
     * @param listLower_7 郵便番号
     */
    public TekiyojogaishaDaichoItem(
            RString printTimeStamp,
            RString title,
            RString shichosonCode,
            RString shichosonName,
            RString birthYMD,
            RString seibetsu,
            RString setaiCode,
            RString shikibetsuCode,
            RString shimeiKana,
            RString chiku1CodeTitle,
            RString chiku1Code,
            RString shimei,
            RString jotai,
            RString telNoTitle,
            RString chiku2CodeTitle,
            RString chiku2Code,
            RString jusho1,
            RString jusho1Title,
            RString telNo1,
            RString telNo2,
            RString chiku3CodeTitle,
            RString chiku3Code,
            RString jusho1Code,
            RString gyoseikuTitle,
            RString gyoseikuCode,
            RString jusho2,
            RString jusho2Title,
            RString jusho2Code,
            RString listNo_1,
            RString listUpper_1,
            RString listUpper_2,
            RString listUpper_3,
            RString listUpper_4,
            RString listUpper_5,
            RString listUpper_6,
            RString listUpper_7,
            RString listLower_1,
            RString listLower_2,
            RString listLower_3,
            RString listLower_4,
            RString listLower_5,
            RString listLower_6,
            RString listLower_7) {
        this.printTimeStamp = printTimeStamp;
        this.title = title;
        this.shichosonCode = shichosonCode;
        this.shichosonName = shichosonName;
        this.birthYMD = birthYMD;
        this.seibetsu = seibetsu;
        this.setaiCode = setaiCode;
        this.shikibetsuCode = shikibetsuCode;
        this.shimeiKana = shimeiKana;
        this.chiku1CodeTitle = chiku1CodeTitle;
        this.chiku1Code = chiku1Code;
        this.shimei = shimei;
        this.jotai = jotai;
        this.telNoTitle = telNoTitle;
        this.chiku2CodeTitle = chiku2CodeTitle;
        this.chiku2Code = chiku2Code;
        this.jusho1 = jusho1;
        this.jusho1Title = jusho1Title;
        this.telNo1 = telNo1;
        this.telNo2 = telNo2;
        this.chiku3CodeTitle = chiku3CodeTitle;
        this.chiku3Code = chiku3Code;
        this.jusho1Code = jusho1Code;
        this.gyoseikuTitle = gyoseikuTitle;
        this.gyoseikuCode = gyoseikuCode;
        this.jusho2 = jusho2;
        this.jusho2Title = jusho2Title;
        this.jusho2Code = jusho2Code;
        this.listNo_1 = listNo_1;
        this.listUpper_1 = listUpper_1;
        this.listUpper_2 = listUpper_2;
        this.listUpper_3 = listUpper_3;
        this.listUpper_4 = listUpper_4;
        this.listUpper_5 = listUpper_5;
        this.listUpper_6 = listUpper_6;
        this.listUpper_7 = listUpper_7;
        this.listLower_1 = listLower_1;
        this.listLower_2 = listLower_2;
        this.listLower_3 = listLower_3;
        this.listLower_4 = listLower_4;
        this.listLower_5 = listLower_5;
        this.listLower_6 = listLower_6;
        this.listLower_7 = listLower_7;
    }
}
