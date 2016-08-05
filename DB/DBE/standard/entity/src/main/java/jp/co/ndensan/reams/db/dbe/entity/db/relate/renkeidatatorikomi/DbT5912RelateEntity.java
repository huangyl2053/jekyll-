package jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;

/**
 * 主治医情報テーブルのエンティティクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbT5912RelateEntity {

    private DbT5912TempEntity dbt5912TempEntity;
    private DbT5912ShujiiJohoEntity dbT5912Entity;
}
