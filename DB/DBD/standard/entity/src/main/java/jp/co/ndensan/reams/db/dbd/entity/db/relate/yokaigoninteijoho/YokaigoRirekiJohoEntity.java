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
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4913ChosainJohoEntity;

/**
 * 介護認定処理履歴情報Entityのクラスです。
 *
 * @reamsid_L DBD-1530-010 lit
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoRirekiJohoEntity implements Cloneable, Serializable {

    private DbT4101NinteiShinseiJohoEntity 要介護認定申請情報受給Entity;
    private DbT4001JukyushaDaichoEntity 受給者台帳Entity;
    private DbT4910NinteichosaItakusakiJohoEntity 認定調査委託先情報Entity;
    private DbT4911ShujiiIryoKikanJohoEntity 主治医医療機関情報受給Entity;
    private DbT4912ShujiiJohoEntity 主治医情報受給Entity;
    private DbT4913ChosainJohoEntity 調査員情報Entity;
    private DbT4102NinteiKekkaJohoEntity 要介護認定結果情報Entity;
    private DbT4201NinteichosaIraiJohoEntity 認定調査依頼情報Entity;
    private DbT4301ShujiiIkenshoIraiJohoEntity 主治医意見書作成依頼情報Entity;
    private DbT4123NinteiKeikakuJohoEntity 要介護認定計画情報Entity;
    private DbT4116IchijiHanteiKekkaJohoEntity 要介護認定一次判定結果情報Entity;

    /**
     * コンストラクタです。
     */
    public YokaigoRirekiJohoEntity() {
        要介護認定申請情報受給Entity = new DbT4101NinteiShinseiJohoEntity();
        受給者台帳Entity = new DbT4001JukyushaDaichoEntity();
        認定調査委託先情報Entity = new DbT4910NinteichosaItakusakiJohoEntity();
        主治医医療機関情報受給Entity = new DbT4911ShujiiIryoKikanJohoEntity();
        主治医情報受給Entity = new DbT4912ShujiiJohoEntity();
        調査員情報Entity = new DbT4913ChosainJohoEntity();
        要介護認定結果情報Entity = new DbT4102NinteiKekkaJohoEntity();
        認定調査依頼情報Entity = new DbT4201NinteichosaIraiJohoEntity();
        主治医意見書作成依頼情報Entity = new DbT4301ShujiiIkenshoIraiJohoEntity();
        要介護認定計画情報Entity = new DbT4123NinteiKeikakuJohoEntity();
        要介護認定一次判定結果情報Entity = new DbT4116IchijiHanteiKekkaJohoEntity();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.要介護認定申請情報受給Entity.initializeMd5();
        this.受給者台帳Entity.initializeMd5();
        this.認定調査委託先情報Entity.initializeMd5();
        this.主治医医療機関情報受給Entity.initializeMd5();
        this.主治医情報受給Entity.initializeMd5();
        this.調査員情報Entity.initializeMd5();
        this.要介護認定結果情報Entity.initializeMd5();
        this.認定調査依頼情報Entity.initializeMd5();
        this.主治医意見書作成依頼情報Entity.initializeMd5();
        this.要介護認定計画情報Entity.initializeMd5();
        this.要介護認定一次判定結果情報Entity.initializeMd5();
    }
}
