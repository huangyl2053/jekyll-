/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7102ZeiritsuJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 税率情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7102ZeiritsuJohoEntityGenerator {

    public static final int DEFAULT_税率 = 1;
    public static final FlexibleDate DEFAULT_開始年月 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_終了年月 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7102ZeiritsuJohoEntityGenerator() {
    }

    public static DbT7102ZeiritsuJohoEntity createDbT7102ZeiritsuJohoEntity() {
        DbT7102ZeiritsuJohoEntity entity = new DbT7102ZeiritsuJohoEntity();
        entity.setZeiritsu(DEFAULT_税率);
        entity.setZeiritsuKaishiYMD(DEFAULT_開始年月);
        entity.setZeiritsuShuryoYMD(DEFAULT_終了年月);
        return entity;
    }
}
