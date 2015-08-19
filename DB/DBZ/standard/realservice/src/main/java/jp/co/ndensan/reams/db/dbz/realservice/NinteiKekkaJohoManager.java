/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.relate.NinteiKekkaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定結果情報を管理するクラスです。
 *
 * @author n8187 久保田 英男
 */
public class NinteiKekkaJohoManager {

    private final NinteiKekkaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiKekkaJohoManager() {
        dac = InstanceProvider.create(NinteiKekkaJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    NinteiKekkaJohoManager(NinteiKekkaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 検索条件に合致する要介護認定結果情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT4102NinteiKekkaJohoEntity
     */
    @Transaction
    public Optional<DbT4102NinteiKekkaJohoEntity> get要介護認定結果情報(ShinseishoKanriNo 申請書管理番号) {

        return dac.selectByKey(申請書管理番号);
    }

    /**
     * 要介護認定結果情報の一覧を返します。
     *
     * @return IItemList<DbT4102NinteiKekkaJohoEntity>
     */
    @Transaction
    public IItemList<DbT4102NinteiKekkaJohoEntity> get要介護認定結果情報一覧() {
        return dac.selectAll();
    }

    /**
     * 申請書管理番号に合致する要介護認定結果情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT4102NinteiKekkaJohoEntity
     */
    @Transaction
    public Optional<DbT4102NinteiKekkaJohoEntity> get要介護認定結果情報_直近(ShinseishoKanriNo 申請書管理番号) {
        return dac.select直近要介護認定結果情報By申請書管理番号(申請書管理番号);
    }

    /**
     * 要介護認定結果情報を登録します。
     *
     * @param 要介護認定結果情報モデル DbT4102NinteiKekkaJohoEntity
     * @return 登録件数
     */
    @Transaction
    public int save要介護認定結果情報(DbT4102NinteiKekkaJohoEntity 要介護認定結果情報モデル) {

        if (要介護認定結果情報モデル.getState() == EntityDataState.Added) {
            return dac.insert(要介護認定結果情報モデル);
        } else if (要介護認定結果情報モデル.getState() == EntityDataState.Modified) {
            return dac.update(要介護認定結果情報モデル);
        } else if (要介護認定結果情報モデル.getState() == EntityDataState.Deleted) {
            return dac.delete(要介護認定結果情報モデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
