/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosainJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteichosainNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.basic.IReplaceable;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定調査員情報Dacのインターフェースです。
 *
 * @author N8187 久保田 英男
 */
public interface IKaigoNinteichosainDac extends IReplaceable<DbT7013ChosainJohoEntity>, IDeletable<DbT7013ChosainJohoEntity> {

    /**
     * 引数の条件に該当する調査員情報エンティティを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護調査員番号 介護調査員番号
     * @return 調査員情報エンティティ
     */
    @Transaction
    DbT7013ChosainJohoEntity select(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoNinteichosainNo 介護調査員番号);

    /**
     * 引数の条件に該当する調査員情報エンティティを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 介護調査員番号 介護調査員番号
     * @param 調査員の状況 調査員の状況
     * @return 調査員情報エンティティ
     */
    @Transaction
    DbT7013ChosainJohoEntity select(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, KaigoNinteichosainNo 介護調査員番号, ChosainJokyo 調査員の状況);

    /**
     * 引数の条件に該当する調査員情報エンティティをリストで取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @return 調査員情報エンティティのリスト
     */
    @Transaction
    List<DbT7013ChosainJohoEntity> selectAll(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号);

    /**
     * 引数の条件に該当する調査員情報エンティティをリストで取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 介護事業者番号 介護事業者番号
     * @param 調査員の状況 調査員の状況
     * @return 調査員情報エンティティのリスト
     */
    @Transaction
    List<DbT7013ChosainJohoEntity> selectAll(ShichosonCode 市町村コード, KaigoJigyoshaNo 介護事業者番号, ChosainJokyo 調査員の状況);

    /**
     * 引数の条件に該当する調査員情報エンティティをリストで取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 調査員の状況 調査員の状況
     * @return 調査員情報エンティティのリスト
     */
    @Transaction
    List<DbT7013ChosainJohoEntity> selectAll(ShichosonCode 市町村コード, ChosainJokyo 調査員の状況);

    /**
     * 引数の条件に該当する調査員情報エンティティをリストで取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 調査員情報エンティティのリスト
     */
    @Transaction
    List<DbT7013ChosainJohoEntity> selectAll(ShichosonCode 市町村コード);

    @Override
    int insertOrUpdate(DbT7013ChosainJohoEntity entity);

    @Override
    int insert(DbT7013ChosainJohoEntity entity);

    @Override
    int update(DbT7013ChosainJohoEntity entity);

    @Override
    int delete(DbT7013ChosainJohoEntity entity);
}
