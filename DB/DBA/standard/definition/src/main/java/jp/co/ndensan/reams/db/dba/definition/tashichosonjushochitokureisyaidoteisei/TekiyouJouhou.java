/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.definition.tashichosonjushochitokureisyaidoteisei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 適用情報グリッドクラスです。
 */
public class TekiyouJouhou {
    
    private RString 適用日;
    
    private RString 解除日;

    /**
     * 適用日を取得します。
     * @return 適用日
     */
    public RString get適用日() {
        return 適用日;
    }

    /**
     * 適用日を設定します。
     * @param 適用日 
     */
    public void set適用日(RString 適用日) {
        this.適用日 = 適用日;
    }

    /**
     * 解除日を取得します。
     * @return 解除日
     */
    public RString get解除日() {
        return 解除日;
    }

    /**
     * 解除日を設定します。
     * @param 解除日 
     */
    public void set解除日(RString 解除日) {
        this.解除日 = 解除日;
    }
}
