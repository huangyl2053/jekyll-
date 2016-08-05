package jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;

/**
 * 認定調査委託先情報テーブルのエンティティクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbT5913RelateEntity {

    private DbT5913TempEntity dbt5913TempEntity;
    private DbT5913ChosainJohoEntity dbT5913Entity;
}
