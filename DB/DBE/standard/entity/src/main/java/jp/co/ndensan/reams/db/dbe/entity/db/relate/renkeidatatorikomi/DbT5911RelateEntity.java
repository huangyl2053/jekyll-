package jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;

/**
 * 主治医医療機関情報テーブルのエンティティクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbT5911RelateEntity {

    private DbT5911TempEntity dbt5911TempEntity;
    private DbT5911ShujiiIryoKikanJohoEntity dbT5911Entity;
}
