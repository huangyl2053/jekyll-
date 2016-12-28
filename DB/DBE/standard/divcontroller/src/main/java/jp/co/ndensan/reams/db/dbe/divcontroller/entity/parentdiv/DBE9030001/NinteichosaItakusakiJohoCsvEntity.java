/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査委託先情報CSVのクラスです
 *
 * @reamsid_L DBE-0270-010 liangbc
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaItakusakiJohoCsvEntity {

    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 1, name = "市町村コード")
    private RString 市町村コード;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 2, name = "市町村")
    private RString 市町村;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 3, name = "調査委託先コード")
    private RString 調査委託先コード;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 4, name = "事業者番号")
    private RString 事業者番号;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 5, name = "調査委託先名称")
    private RString 調査委託先名称;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 6, name = "調査委託先カナ名称")
    private RString 調査委託先カナ名称;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 7, name = "郵便番号")
    private RString 郵便番号;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 8, name = "住所")
    private RString 住所;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 9, name = "電話番号")
    private RString 電話番号;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 10, name = "ＦＡＸ番号")
    private RString ＦＡＸ番号;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 11, name = "機関代表者氏名")
    private RString 機関代表者氏名;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 12, name = "機関代表者カナ氏名")
    private RString 機関代表者カナ氏名;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 13, name = "調査委託区分")
    private RString 調査委託区分;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 14, name = "特定調査員表示の表示")
    private RString 特定調査員表示フラグ;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 15, name = "割付定員")
    private RString 割付定員;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 16, name = "割付地区コード")
    private RString 割付地区コード;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 17, name = "割付地区名称")
    private RString 割付地区名称;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 18, name = "自動割付可否")
    private RString 自動割付フラグ;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 19, name = "機関の区分")
    private RString 機関の区分;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 20, name = "調査委託先の状況")
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    private RString 状況フラグ;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 21, name = "金融機関コード")
    private RString 金融機関コード;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 22, name = "支店コード")
    private RString 支店コード;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 23, name = "預金種別")
    private RString 預金種別;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 24, name = "口座番号")
    private RString 口座番号;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 25, name = "口座名義人")
    private RString 口座名義人;
    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 1 LINES
    @CsvField(order = 26, name = "漢字名義人")
    private RString 漢字名義人;
}
