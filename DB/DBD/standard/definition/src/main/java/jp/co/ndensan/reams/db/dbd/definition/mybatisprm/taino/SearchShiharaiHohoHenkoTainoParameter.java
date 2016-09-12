/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.taino;

import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TainoHanteiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 滞納情報（画面）のパラメータです。
 *
 * @reamsid_L DBD-3620-050 liangbc
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SearchShiharaiHohoHenkoTainoParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString 管理区分;
    private final int 履歴番号;
    private final RString 滞納判定区分;

    private SearchShiharaiHohoHenkoTainoParameter(
            HihokenshaNo 被保険者番号, ShiharaiHenkoKanriKubun 管理区分, int 履歴番号, TainoHanteiKubun 滞納判定区分) {
        this.被保険者番号 = 被保険者番号;
        this.管理区分 = 管理区分.getコード();
        this.履歴番号 = 履歴番号;
        this.滞納判定区分 = 滞納判定区分.getコード();
    }

    /**
     * 滞納状況取得のパラメータを作成
     *
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     * @param 滞納判定区分 滞納判定区分
     * @return 滞納状況取得のパラメータ
     */
    public static SearchShiharaiHohoHenkoTainoParameter createParameter(
            HihokenshaNo 被保険者番号, ShiharaiHenkoKanriKubun 管理区分, int 履歴番号, TainoHanteiKubun 滞納判定区分) {
        return new SearchShiharaiHohoHenkoTainoParameter(被保険者番号, 管理区分, 履歴番号, 滞納判定区分);
    }
}
