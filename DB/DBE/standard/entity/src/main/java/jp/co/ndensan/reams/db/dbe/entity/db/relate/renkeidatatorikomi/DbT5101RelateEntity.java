package jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;

/**
 * 要介護認定申請情報テーブルのエンティティクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbT5101RelateEntity {

    private DbT5101TempEntity dbt5101TempEntity;
    private DbT5101NinteiShinseiJohoEntity dbT5101Entity;
    private DbT5123NinteiKeikakuJohoEntity dbT5123Entity;
    private DbT5102NinteiKekkaJohoEntity dbT5102Entity;
    private DbT7051KoseiShichosonMasterEntity dbT7051Entity;
    private DbT5910NinteichosaItakusakiJohoEntity dbT5910Entity;
    private DbT5911ShujiiIryoKikanJohoEntity dbT5911Entity;
    private DbT5912ShujiiJohoEntity dbT5912Entity;

}
