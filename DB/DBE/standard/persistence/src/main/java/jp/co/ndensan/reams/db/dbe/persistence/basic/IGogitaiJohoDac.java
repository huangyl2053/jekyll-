/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体情報テーブルのデータを扱うクラスのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IGogitaiJohoDac extends IReplaceable<DbT5103GogitaiJohoEntity>, IDeletable<DbT5103GogitaiJohoEntity> {

    /**
     * 指定した合議体番号に該当する合議体Entityのリストを取得します。
     *
     * @param 合議体番号 合議体番号
     * @return 合議体EntityのList
     */
    @Transaction
    List<DbT5103GogitaiJohoEntity> select(GogitaiNo 合議体番号);

    /**
     * 指定した日付時点で有効な合議体の情報を取得します。
     *
     * @param 年月日 年月日
     * @return 合議体EntityのList
     */
    @Transaction
    List<DbT5103GogitaiJohoEntity> select(FlexibleDate 年月日);
}
