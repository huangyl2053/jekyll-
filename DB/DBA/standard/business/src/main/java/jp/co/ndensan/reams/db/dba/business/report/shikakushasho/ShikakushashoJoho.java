/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.shikakushasho;

import java.util.List;
import lombok.Getter;

/**
 *
 * 介護保険資格者証作成_帳票クラスパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakushashoJoho {
    
    private final List<ShikakushashoBodyItem> bodyItem;
    
    /**
     * コンストラクタを作成します。
     * @param bodyItem 介護保険資格者証情報
     */
    public ShikakushashoJoho(List<ShikakushashoBodyItem> bodyItem) {
        this.bodyItem = bodyItem;
    }
}
