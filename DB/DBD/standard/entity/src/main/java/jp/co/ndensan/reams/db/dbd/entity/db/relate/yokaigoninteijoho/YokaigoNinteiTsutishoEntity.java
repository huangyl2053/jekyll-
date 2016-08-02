/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;

/**
 * 要介護認定通知書発行Entityのクラスです。
 *
 * @reamsid_L DBE-1430-010 lit
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiTsutishoEntity implements Cloneable, Serializable {

    private DbT4101NinteiShinseiJohoEntity 要介護認定申請情報受給Entity;
    private DbT4001JukyushaDaichoEntity 受給者台帳Entity;
    private DbT4102NinteiKekkaJohoEntity 要介護認定結果情報Entity;

    /**
     * コンストラクタです。
     */
    public YokaigoNinteiTsutishoEntity() {
        要介護認定申請情報受給Entity = new DbT4101NinteiShinseiJohoEntity();
        受給者台帳Entity = new DbT4001JukyushaDaichoEntity();
        要介護認定結果情報Entity = new DbT4102NinteiKekkaJohoEntity();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.要介護認定申請情報受給Entity.initializeMd5();
        this.受給者台帳Entity.initializeMd5();
        this.要介護認定結果情報Entity.initializeMd5();
    }
}
