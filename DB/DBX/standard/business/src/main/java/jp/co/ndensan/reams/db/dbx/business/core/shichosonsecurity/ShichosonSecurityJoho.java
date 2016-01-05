/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村情報 の項目定義クラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShichosonSecurityJoho {

    private RString 介護導入区分;
    private RString 導入形態コード;
    private boolean 支所管理有無フラグ;
    private RString 広域タイプ;
    private RString 市町村ＩＤ有効桁数;
    private KoseiShichosonJohoEntity 市町村情報;
    private DonyukeitaiCode 導入形態;

    /**
     * 導入形態を返します。
     *
     * @return 導入形態
     */
    public DonyukeitaiCode get導入形態() {
        if (this.導入形態 == null) {
            this.導入形態 = DonyukeitaiCode.toValue(this.導入形態コード);
        }
        return this.導入形態;
    }
}
