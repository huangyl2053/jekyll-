package jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;

/**
 * 認定調査委託先情報テーブルのエンティティクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbT5910RelateEntity {

    private DbT5910TempEntity dbt5910TempEntity;
    private DbT5910NinteichosaItakusakiJohoEntity dbT5910Entity;
}
