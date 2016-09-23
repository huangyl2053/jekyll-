/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.rirekishusei;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4913ChosainJohoEntity;

/**
 * 特殊修正のEntityクラス
 *
 * @reamsid_L DBD-1330-010 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RirekiShuseiRelateEntity {

    private DbT4001JukyushaDaichoEntity dbt4001Entity;
    private DbT4101NinteiShinseiJohoEntity dbt4101Entity;
    private DbT4121ShinseiRirekiJohoEntity dbt4121Entity;
    private DbT4102NinteiKekkaJohoEntity dbt4102Entity;
    private DbT4120ShinseitodokedeJohoEntity dbt4120Entity;
    private DbT4116IchijiHanteiKekkaJohoEntity dbt4116Entity;
    private DbT4123NinteiKeikakuJohoEntity dbt4123Entity;
    private DbT4301ShujiiIkenshoIraiJohoEntity dbt4301Entity;
    private DbT4302ShujiiIkenshoJohoEntity dbt4302Entity;
    private DbT4201NinteichosaIraiJohoEntity dbt4201Entity;
    private DbT4202NinteichosahyoGaikyoChosaEntity dbt4202Entity;
    private DbT4910NinteichosaItakusakiJohoEntity dbt4910Entity;
    private DbT4911ShujiiIryoKikanJohoEntity dbt4911Entity;
    private DbT4912ShujiiJohoEntity dbt4912Entity;
    private DbT4913ChosainJohoEntity dbt4913Entity;
}
