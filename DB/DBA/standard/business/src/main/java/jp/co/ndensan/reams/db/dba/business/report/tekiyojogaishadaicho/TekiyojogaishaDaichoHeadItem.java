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
 *
 * 適用除外者台帳ヘッダのITEMクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TekiyojogaishaDaichoHeadItem {

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
     */
    public TekiyojogaishaDaichoHeadItem(
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
            RString jusho2Code) {
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
    }
}
