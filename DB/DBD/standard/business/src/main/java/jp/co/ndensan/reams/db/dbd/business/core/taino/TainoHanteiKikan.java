/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.taino;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 滞納判定期間のクラスです。
 *
 * @reamsid_L DBD-3620-060 liangbc
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TainoHanteiKikan implements Serializable {

    private final int 合計月数;
    private final int 年数;
    private final int 月数Without年数;
    private final RString 表記;

    /**
     * コンストラクタです。
     *
     * @param 合計月数 合計月数
     * @param 年数 年数
     * @param 月数Without年数 月数Without年数
     * @param 表記 表記
     */
    public TainoHanteiKikan(int 合計月数,
            int 年数,
            int 月数Without年数,
            RString 表記) {
        this.合計月数 = 合計月数;
        this.年数 = 年数;
        this.月数Without年数 = 月数Without年数;
        this.表記 = 表記;
    }

}
