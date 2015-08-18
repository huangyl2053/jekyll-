/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険施設入退所を管理するクラスです。
 *
 * @author n8223 朴義一
 */
public class ShisetsuNyutaishoManager {

    private final ShisetsuNyutaishoDac dac;

    /**
     * コンストラクタです。
     */
    public ShisetsuNyutaishoManager() {
        dac = InstanceProvider.create(ShisetsuNyutaishoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    ShisetsuNyutaishoManager(ShisetsuNyutaishoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護保険施設入退所を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 Decimal
     * @return ShisetsuNyutaishoModel
     */
    @Transaction
    public Optional<DbT1004ShisetsuNyutaishoEntity> get介護保険施設入退所(ShikibetsuCode 識別コード, Decimal 履歴番号) {

        return dac.select介護保険施設入退所ByKey(識別コード, 履歴番号);
    }

    /**
     * 識別コードに合致する介護保険施設入退所の一覧を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @return List<ShisetsuNyutaishoModel>
     */
    @Transaction
    public IItemList<DbT1004ShisetsuNyutaishoEntity> get介護保険施設入退所一覧By主キー1(ShikibetsuCode 識別コード) {
        return dac.select介護保険施設入退所一覧By識別コード(識別コード);
    }

    /**
     * 介護保険施設入退所を登録します。
     *
     * @param 介護保険施設入退所モデル ShisetsuNyutaishoModel
     * @return 登録件数
     */
    @Transaction
    public int save介護保険施設入退所(DbT1004ShisetsuNyutaishoEntity 介護保険施設入退所モデル) {

        if (介護保険施設入退所モデル.getState() == EntityDataState.Added) {
            return dac.insert(介護保険施設入退所モデル);
        } else if (介護保険施設入退所モデル.getState() == EntityDataState.Modified) {
            return dac.update(介護保険施設入退所モデル);
        } else if (介護保険施設入退所モデル.getState() == EntityDataState.Deleted) {
            return dac.delete(介護保険施設入退所モデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
