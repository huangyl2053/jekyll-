/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 障がい者控除申請登録の情報と状態を管理するクラスです。
 *
 * @reamsid_L DBD-3840-010 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishaKoujoToJotai implements Serializable {

    private ShogaishaKoujo 障がい書控除申請登録情報;
    private RString 状態;
    private int 新履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 障がい書控除申請登録情報 障がい書控除申請登録情報
     * @param 状態 状態
     * @param 新履歴番号 新履歴番号
     */
    public ShogaishaKoujoToJotai(ShogaishaKoujo 障がい書控除申請登録情報, RString 状態, int 新履歴番号) {
        this.障がい書控除申請登録情報 = 障がい書控除申請登録情報;
        this.状態 = 状態;
        this.新履歴番号 = 新履歴番号;
    }

}
