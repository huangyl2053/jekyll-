/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.sogojigyokubun;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoKubunShikyuGendoGaku;

/**
 * 総合事業区分支給限度額登録合併Entityクラスです。
 *
 * @reamsid_L DBC-3363-010 xuxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogoJigyoKubunEntity implements Serializable {

    private SogoJigyoKubunShikyuGendoGaku 要支援1;
    private SogoJigyoKubunShikyuGendoGaku 要支援2;
    private SogoJigyoKubunShikyuGendoGaku 二次予防;

    /**
     * コンストラクタです。
     *
     * @param 要支援1 SogoJigyoKubunShikyuGendoGaku
     * @param 要支援2 SogoJigyoKubunShikyuGendoGaku
     * @param 二次予防 SogoJigyoKubunShikyuGendoGaku
     */
    public SogoJigyoKubunEntity(SogoJigyoKubunShikyuGendoGaku 要支援1,
            SogoJigyoKubunShikyuGendoGaku 要支援2,
            SogoJigyoKubunShikyuGendoGaku 二次予防) {
        this.要支援1 = 要支援1;
        this.要支援2 = 要支援2;
        this.二次予防 = 二次予防;
    }
}
