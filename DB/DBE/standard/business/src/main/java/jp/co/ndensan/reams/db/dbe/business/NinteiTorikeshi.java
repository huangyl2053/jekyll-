/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定取消情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteiTorikeshi {

    private final RString 認定取消理由;
    private final FlexibleDate 認定取消年月日;

    /**
     * インスタンスを生成します。
     *
     * @param 認定取消理由 認定取消理由
     * @param 認定取消年月日 認定取消年月日
     */
    public NinteiTorikeshi(RString 認定取消理由, FlexibleDate 認定取消年月日) {
        this.認定取消理由 = 認定取消理由;
        this.認定取消年月日 = 認定取消年月日;
    }

    /**
     * 認定取消理由を返します。
     *
     * @return 認定取消理由
     */
    public RString get認定取消理由() {
        return 認定取消理由;
    }

    /**
     * 認定取消年月日を返します。
     *
     * @return 認定取消年月日
     */
    public FlexibleDate get認定取消年月日() {
        return 認定取消年月日;
    }
}
