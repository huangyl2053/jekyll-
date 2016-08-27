/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 被保険者台帳関連情報のエンティティクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDaichoShinseiRelateEntity {

    private DbT1001HihokenshaDaichoEntity 被保険者台帳;
    private ShinseiJohoTempEntity 申請情報;
    private ShinseiJohoShokanTempEntity 申請情報償還;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoShinseiRelateEntity() {
        this.被保険者台帳 = new DbT1001HihokenshaDaichoEntity();
        this.申請情報 = new ShinseiJohoTempEntity();
        this.申請情報償還 = new ShinseiJohoShokanTempEntity();
    }

}
