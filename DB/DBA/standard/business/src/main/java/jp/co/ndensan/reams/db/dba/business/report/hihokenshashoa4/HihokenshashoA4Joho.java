/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4;

import java.util.List;
import lombok.Getter;

/**
 *
 * 介護保険被保険者証作成_帳票クラスパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshashoA4Joho {
    
    private final List<HihokenshashoA4BodyItem> bodyItem;
    
    /**
     * コンストラクタを作成します。
     * @param bodyItem 介護保険被保険者証情報
     */
    public HihokenshashoA4Joho(List<HihokenshashoA4BodyItem> bodyItem) {
        this.bodyItem = bodyItem;
    }
}
