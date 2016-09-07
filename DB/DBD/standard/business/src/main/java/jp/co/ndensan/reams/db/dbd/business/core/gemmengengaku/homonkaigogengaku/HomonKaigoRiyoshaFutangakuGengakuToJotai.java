/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 訪問介護利用者負担額減額申請の情報と状態を管理するクラスです。
 *
 * @reamsid_L DBD-3730-010 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HomonKaigoRiyoshaFutangakuGengakuToJotai implements Serializable {

    private HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額情報;
    private RString 状態;
    private int 新履歴番号;

    /**
     * コンストラクタです。<br/>
     * 訪問介護利用者負担額減額情報の新規作成時に使用します。
     *
     * @param 訪問介護利用者負担額減額情報 訪問介護利用者負担額減額情報
     * @param 状態 状態
     * @param 新履歴番号 新履歴番号
     */
    public HomonKaigoRiyoshaFutangakuGengakuToJotai(
            HomonKaigoRiyoshaFutangakuGengaku 訪問介護利用者負担額減額情報, RString 状態, int 新履歴番号) {
        this.訪問介護利用者負担額減額情報 = 訪問介護利用者負担額減額情報;
        this.状態 = 状態;
        this.新履歴番号 = 新履歴番号;
    }

}
