/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.model.NinteiShinseiJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.relate.NinteiShinseiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請情報を管理するクラスです。
 *
 * @author n8187 久保田 英男
 */
public class NinteiShinseiJohoManager {

    private final NinteiShinseiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiShinseiJohoManager() {
        dac = InstanceProvider.create(NinteiShinseiJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    NinteiShinseiJohoManager(NinteiShinseiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する要介護認定申請情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 処理日時 処理日時
     * @return NinteiShinseiJohoModel
     */
    @Transaction
    public Optional<NinteiShinseiJohoModel> get要介護認定申請情報(ShinseishoKanriNo 申請書管理番号, YMDHMS 処理日時) {

        return dac.selectByKey(申請書管理番号, 処理日時);
    }

    /**
     * 要介護認定申請情報の一覧を返します。
     *
     * @return List<NinteiShinseiJohoModel>
     */
    @Transaction
    public IItemList<NinteiShinseiJohoModel> get要介護認定申請情報一覧() {
        return dac.selectAll();
    }

    /**
     * 申請書管理番号に合致する要介護認定申請情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return NinteiShinseiJohoModel
     */
    @Transaction
    public Optional<NinteiShinseiJohoModel> get要介護認定申請情報(ShinseishoKanriNo 申請書管理番号) {

        return dac.select要介護認定申請情報By申請書管理番号(申請書管理番号);
    }

    /**
     * 要介護認定申請情報を登録します。
     *
     * @param 要介護認定申請情報モデル NinteiShinseiJohoModel
     * @return 登録件数
     */
    @Transaction
    public int save要介護認定申請情報(NinteiShinseiJohoModel 要介護認定申請情報モデル) {

        if (要介護認定申請情報モデル.getState() == EntityDataState.Added) {
            return dac.insert(要介護認定申請情報モデル);
        } else if (要介護認定申請情報モデル.getState() == EntityDataState.Modified) {
            return dac.update(要介護認定申請情報モデル);
        } else if (要介護認定申請情報モデル.getState() == EntityDataState.Deleted) {
            return dac.delete(要介護認定申請情報モデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
