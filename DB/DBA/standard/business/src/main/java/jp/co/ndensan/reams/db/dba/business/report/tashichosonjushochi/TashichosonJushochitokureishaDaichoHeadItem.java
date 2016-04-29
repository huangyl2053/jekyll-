/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 他市町村住所地特例者台帳ヘッダのITEMです。
 *
 * @reamsid_L DBA-0402-030 xuyannan
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TashichosonJushochitokureishaDaichoHeadItem {

    private RString printTimeStamp;
    private RString shichosonCode;
    private RString shichosonName;
    private RString birthYMD;
    private RString seibetsu;
    private RString setaiCode;
    private RString shikibetsuCode;
    private RString shimeiKana;
    private RString chiku1CodeTitle;
    private RString chiku1Code;
    private RString shimei;
    private RString jotai;
    private RString telNoTitle;
    private RString chiku2CodeTitle;
    private RString chiku2Code;
    private RString jusho1;
    private RString telNo1;
    private RString jusho1Title;
    private RString telNo2;
    private RString chiku3CodeTitle;
    private RString chiku3Code;
    private RString gyoseikuTitle;
    private RString jusho1Code;
    private RString gyoseikuCode;
    private RString maeJushoCode;
    private RString jusho2;
    private RString tennyuYMD;
    private RString jusho2Title;
    private RString tenshutsuYMD;
}
