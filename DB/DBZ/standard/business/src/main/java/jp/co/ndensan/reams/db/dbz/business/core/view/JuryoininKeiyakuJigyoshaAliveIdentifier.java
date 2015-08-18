/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任事業者Aliveの識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
//@lombok.Value TODO
public class JuryoininKeiyakuJigyoshaAliveIdentifier implements Serializable {

    private final RString 事業者契約番号;
    private final FlexibleDate 開始年月日;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 事業者契約番号 事業者契約番号
     * @param 開始年月日 開始年月日
     * @param 履歴番号 履歴番号
     */
    public JuryoininKeiyakuJigyoshaAliveIdentifier(RString 事業者契約番号,
            FlexibleDate 開始年月日,
            int 履歴番号) {
        this.事業者契約番号 = 事業者契約番号;
        this.開始年月日 = 開始年月日;
        this.履歴番号 = 履歴番号;
    }
}
