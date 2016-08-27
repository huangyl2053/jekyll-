/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shokkentorikeshiichibusoshitu;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 「職権修正/職権取消(一部)/認定結果入力(サ変・区変)」画面の今回情報Entityクラスです。
 *
 * @reamsid_L DBD-1320-010 zuotao
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokkenTorikeshiNinteiJohoKonkaiEntity implements Serializable {

    private LasdecCode shichosonCode;
    private DbT4101NinteiShinseiJohoEntity t4101Entity;
    private DbT4001JukyushaDaichoEntity t4001Entity;
    private DbT5911ShujiiIryoKikanJohoEntity t5911Entity;
    private DbT5912ShujiiJohoEntity t5912Entity;
    private DbT5910NinteichosaItakusakiJohoEntity t5910Entity;
    private DbT5913ChosainJohoEntity t5913Entity;
    private DbT4102NinteiKekkaJohoEntity t4102Entity;
    private DbT4120ShinseitodokedeJohoEntity t4120Entity;
}
