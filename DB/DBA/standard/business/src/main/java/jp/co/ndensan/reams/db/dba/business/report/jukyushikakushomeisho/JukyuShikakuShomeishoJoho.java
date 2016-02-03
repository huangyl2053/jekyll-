/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho;

import lombok.Getter;

/**
 *
 * 受給資格証明書クラスパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyuShikakuShomeishoJoho {
    
    private final JukyuShikakuShomeishoBodyItem bodyItem;
    
    /**
     * コンストラクタを作成します。
     * @param bodyItem 受給資格証明書情報
     */
    public JukyuShikakuShomeishoJoho(JukyuShikakuShomeishoBodyItem bodyItem) {
        this.bodyItem = bodyItem;
    }
}
