/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.chosatokkishokai;

import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査特記事項照会情報
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaTokkiShokaiJoho {

    private NinteichosahyoTokkijiko 特記情報;
    private RString 原本特記事項;
    private RString マスク特記事項;

    public boolean isEmpty() {
        return this.特記情報 == null;
    }
}
