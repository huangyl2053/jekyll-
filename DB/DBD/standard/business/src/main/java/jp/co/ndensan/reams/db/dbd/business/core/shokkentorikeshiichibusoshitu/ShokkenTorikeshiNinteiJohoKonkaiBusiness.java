/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shokkentorikeshiichibusoshitu;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shokkentorikeshiichibusoshitu.ShokkenTorikeshiNinteiJohoKonkaiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4102NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4120ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiJoho;
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
 * 「職権修正/職権取消(一部)/認定結果入力(サ変・区変)」画面の今回情報ビジネスクラスです。
 *
 * @reamsid_L DBD-1320-010 zuotao
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokkenTorikeshiNinteiJohoKonkaiBusiness implements Serializable {

    private final DbT4101NinteiShinseiJoho 要介護認定申請情報;
    private final JukyushaDaicho 受給者台帳;
    private final ShujiiIryoKikanJoho 主治医医療機関情報;
    private final ShujiiJoho 主治医情報;
    private final NinteichosaItakusakiJoho 認定調査委託先情報;
    private final ChosainJoho 調査員情報;
    private final DbT4102NinteiKekkaJoho 要介護認定結果情報;
    private final DbT4120ShinseitodokedeJoho 申請届出者情報;
    private final LasdecCode 市町村コード;

    private ShokkenTorikeshiNinteiJohoKonkaiBusiness(DbT4101NinteiShinseiJoho 要介護認定申請情報, JukyushaDaicho 受給者台帳,
            ShujiiIryoKikanJoho 主治医医療機関情報, ShujiiJoho 主治医情報, NinteichosaItakusakiJoho 認定調査委託先情報,
            ChosainJoho 調査員情報, DbT4102NinteiKekkaJoho 要介護認定結果情報, DbT4120ShinseitodokedeJoho 申請届出者情報, LasdecCode 市町村コード) {

        this.要介護認定申請情報 = 要介護認定申請情報;
        this.受給者台帳 = 受給者台帳;
        this.主治医医療機関情報 = 主治医医療機関情報;
        this.主治医情報 = 主治医情報;
        this.認定調査委託先情報 = 認定調査委託先情報;
        this.調査員情報 = 調査員情報;
        this.要介護認定結果情報 = 要介護認定結果情報;
        this.申請届出者情報 = 申請届出者情報;
        this.市町村コード = 市町村コード;
    }

    /**
     * 今回情報ビジネスを作成します。
     *
     * @param entity 今回情報Entityクラス
     * @return 今回情報ビジネス
     */
    public static ShokkenTorikeshiNinteiJohoKonkaiBusiness createBusiness(ShokkenTorikeshiNinteiJohoKonkaiEntity entity) {
        DbT4102NinteiKekkaJohoEntity t4102Entity = entity.getT4102Entity();
        DbT4001JukyushaDaichoEntity t4001Entity = entity.getT4001Entity();
        DbT4101NinteiShinseiJohoEntity t4101Entity = entity.getT4101Entity();
        DbT5910NinteichosaItakusakiJohoEntity t5910Entity = entity.getT5910Entity();
        DbT5911ShujiiIryoKikanJohoEntity t5911Entity = entity.getT5911Entity();
        DbT5912ShujiiJohoEntity t5912Entity = entity.getT5912Entity();
        DbT5913ChosainJohoEntity t5913Entity = entity.getT5913Entity();
        DbT4120ShinseitodokedeJohoEntity t4120Entity = entity.getT4120Entity();
        DbT4101NinteiShinseiJoho t4101;
        JukyushaDaicho t4001;
        ShujiiIryoKikanJoho t591l;
        ShujiiJoho t5912;
        NinteichosaItakusakiJoho t5910;
        ChosainJoho t5913;
        DbT4102NinteiKekkaJoho t4102;
        DbT4120ShinseitodokedeJoho t4120;
        if (t4001Entity != null) {
            t4001Entity.initializeMd5();
            t4001 = new JukyushaDaicho(t4001Entity);
        } else {
            t4001 = new JukyushaDaicho(new DbT4001JukyushaDaichoEntity());
        }
        if (t4102Entity != null) {
            t4102Entity.initializeMd5();
            t4102 = new DbT4102NinteiKekkaJoho(t4102Entity);
        } else {
            t4102 = new DbT4102NinteiKekkaJoho(new DbT4102NinteiKekkaJohoEntity());
        }
        if (t4101Entity != null) {
            t4101Entity.initializeMd5();
            t4101 = new DbT4101NinteiShinseiJoho(t4101Entity);
        } else {
            t4101 = new DbT4101NinteiShinseiJoho(new DbT4101NinteiShinseiJohoEntity());
        }
        if (t5910Entity != null) {
            t5910Entity.initializeMd5();
            t5910 = new NinteichosaItakusakiJoho(t5910Entity);
        } else {
            t5910 = new NinteichosaItakusakiJoho(new DbT5910NinteichosaItakusakiJohoEntity());
        }
        if (t5911Entity != null) {
            t5911Entity.initializeMd5();
            t591l = new ShujiiIryoKikanJoho(t5911Entity);
        } else {
            t591l = new ShujiiIryoKikanJoho(new DbT5911ShujiiIryoKikanJohoEntity());
        }
        if (t5912Entity != null) {
            t5912Entity.initializeMd5();
            t5912 = new ShujiiJoho(t5912Entity);
        } else {
            t5912 = new ShujiiJoho(new DbT5912ShujiiJohoEntity());
        }
        if (t5913Entity != null) {
            t5913Entity.initializeMd5();
            t5913 = new ChosainJoho(t5913Entity);
        } else {
            t5913 = new ChosainJoho(new DbT5913ChosainJohoEntity());
        }
        if (t4120Entity != null) {
            t4120Entity.initializeMd5();
            t4120 = new DbT4120ShinseitodokedeJoho(t4120Entity);
        } else {
            t4120 = new DbT4120ShinseitodokedeJoho(new DbT4120ShinseitodokedeJohoEntity());
        }
        return new ShokkenTorikeshiNinteiJohoKonkaiBusiness(t4101, t4001, t591l, t5912, t5910, t5913,
                t4102, t4120, entity.getShichosonCode());
    }
}
