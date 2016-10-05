/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績集計Entityクラスです。
 *
 * @reamsid_L DBD-3880-060 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyuhuJissekiShukei {

    private static final int NOCOUNT_2 = 2;
    private static final int NOCOUNT_9 = 9;
    private static final int NOCOUNT_10 = 10;

    private ServiceShuruiCode サービス種類コード;
    private RString 保険請求額;
    private int 利用者負担額;

    /**
     * コンストラクタです。
     *
     * @return 助成後利用者負担額
     */
    public int get助成後利用者負担額() {
        return 利用者負担額 * NOCOUNT_9 / NOCOUNT_10;
    }

    /**
     * コンストラクタです。
     *
     * @return 助成額
     */
    public int get助成額() {
        return 利用者負担額 - get助成後利用者負担額();
    }

    /**
     * コンストラクタです。
     *
     * @return 保険者助成額
     */
    public int get保険者助成額() {
        return get助成額() / NOCOUNT_2;
    }

}
