/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IInsertable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IReplaceable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IUpdatable;

/**
 * 合議体割当委員情報テーブルのデータを扱うクラスのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IGogitaiWariateDac extends IReplaceable<DbT5107GogitaiWariateIinJohoEntity>, IDeletable<DbT5107GogitaiWariateIinJohoEntity>,
        IInsertable<DbT5107GogitaiWariateIinJohoEntity>, IUpdatable<DbT5107GogitaiWariateIinJohoEntity> {
}
