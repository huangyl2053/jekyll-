/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.kanri;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3423
 */
public enum ImageFileName {

    /**
     * 名称:調査実施場所 ファイル名:C0001 略称:定義なし
     */
    調査実施場所("C0001"),
    /**
     * 名称:市町村特別給付 ファイル名:C0002 略称:定義なし
     */
    市町村特別給付("C0002"),
    /**
     * 名称:介護保険給付外のサービス ファイル名:C0003 略称:定義なし
     */
    介護保険給付外のサービス("C0003"),
    /**
     * 名称:施設名 ファイル名:C0004 略称:定義なし
     */
    施設名("C0004"),
    /**
     * 名称:施設住所 ファイル名:C0005 略称:定義なし
     */
    施設住所("C0005"),
    /**
     * 名称:施設電話番号 ファイル名:C0006 略称:定義なし
     */
    施設電話番号("C0006"),
    /**
     * 名称:概況調査特記 ファイル名:C0007 略称:定義なし
     */
    概況調査特記("C0007"),
    /**
     * 名称:特記資料1 ファイル名:C4101 略称:定義なし
     */
    特記資料1("C4101"),
    /**
     * 名称:特記資料2 ファイル名:C4102 略称:定義なし
     */
    特記資料2("C4102"),
    /**
     * 名称:特記資料3 ファイル名:C4103 略称:定義なし
     */
    特記資料3("C4103"),
    /**
     * 名称:特記資料4 ファイル名:C4104 略称:定義なし
     */
    特記資料4("C4104"),
    /**
     * 名称:特記資料5 ファイル名:C4105 略称:定義なし
     */
    特記資料5("C4105"),
    /**
     * 名称:特記資料6 ファイル名:C4106 略称:定義なし
     */
    特記資料6("C4106"),
    /**
     * 名称:特記資料7 ファイル名:C4107 略称:定義なし
     */
    特記資料7("C4107"),
    /**
     * 名称:特記資料8 ファイル名:C4108 略称:定義なし
     */
    特記資料8("C4108"),
    /**
     * 名称:概況特記 ファイル名:G0001 略称:定義なし
     */
    概況特記("G0001"),
    /**
     * 名称:主治医意見書表 ファイル名:E0001 略称:定義なし
     */
    主治医意見書表("E0001"),
    /**
     * 名称:主治医意見書裏 ファイル名:E0002 略称:定義なし
     */
    主治医意見書裏("E0002");

    private final RString imageFileName;

    private ImageFileName(String imageFileName) {
        this.imageFileName = new RString(imageFileName);
    }

    /**
     * ファイル名を返します。
     *
     * @return ファイル名
     */
    public RString getImageFileName() {
        return imageFileName;
    }
}
