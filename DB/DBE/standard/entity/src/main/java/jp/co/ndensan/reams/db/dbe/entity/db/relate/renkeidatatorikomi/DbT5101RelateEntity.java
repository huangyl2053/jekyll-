package jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;

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
    private DbT5123NinteiKeikakuJohoEntity dbt5123Entity;

}
