/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.iknijuntsukishichosonjoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 調査委託先＆調査員ガイドのRelateEntityクラスです。
 *
 * @reamsid_L DBZ-1300-020 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IKijuntsukiShichosonjohoRelateEntity {

    private RString ninteichosaItakusakiCode;
    private RString jigyoshaMeisho;
    private RString jigyoshaMeishoKana;
    private RString chosaItakuKubun;
    private boolean jokyoFlag;
    private RString ninteiChosainCode;
    private RString chosainShimei;
    private RString chosainKanaShimei;
    private boolean jokyoFlag2;
    private RString shichosonCode;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;
}
