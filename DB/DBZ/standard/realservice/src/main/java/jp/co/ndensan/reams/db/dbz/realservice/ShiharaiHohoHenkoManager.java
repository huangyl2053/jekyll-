/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.ShiharaiHohoHenkoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 支払方法変更を管理するクラスです。
 *
 * @author n8187 久保田 英男
 */
public class ShiharaiHohoHenkoManager {

    private final ShiharaiHohoHenkoDac dac;

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoManager() {
        dac = InstanceProvider.create(ShiharaiHohoHenkoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    ShiharaiHohoHenkoManager(ShiharaiHohoHenkoDac dac) {
        this.dac = dac;
    }

    /**
     * 検索条件に合致する支払方法変更を返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 処理日時 処理日時
     * @return ShiharaiHohoHenkoModel
     */
    @Transaction
    public ShiharaiHohoHenkoModel get支払方法変更(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            YMDHMS 処理日時) {

        return dac.selectByKey(証記載保険者番号, 被保険者番号, 管理区分, 処理日時);
    }

    /**
     * 支払方法変更の一覧を返します。
     *
     * @return IItemList<ShiharaiHohoHenkoModel>
     */
    @Transaction
    public IItemList<ShiharaiHohoHenkoModel> get支払方法変更一覧() {
        return dac.selectAll();
    }

    /**
     * 2号差止に合致する支払方法変更の一覧を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return IItemList<ShiharaiHohoHenkoModel>
     */
    @Transaction
    public IItemList<ShiharaiHohoHenkoModel> get2号差止履歴(HihokenshaNo 被保険者番号) {
        return dac.select2号差止履歴(被保険者番号);
    }

    /**
     * 1号償還払化に合致する支払方法変更の一覧を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<ShiharaiHohoHenkoModel>
     */
    @Transaction
    public IItemList<ShiharaiHohoHenkoModel> get1号償還払化履歴(HihokenshaNo 被保険者番号) {
        return dac.select1号償還払化履歴(被保険者番号);
    }

    /**
     * 1号減額に合致する支払方法変更の一覧を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<ShiharaiHohoHenkoModel>
     */
    @Transaction
    public IItemList<ShiharaiHohoHenkoModel> get1号減額履歴(HihokenshaNo 被保険者番号) {
        return dac.select1号減額履歴(被保険者番号);
    }

    /**
     * 支払方法変更を登録します。
     *
     * @param 支払方法変更モデル ShiharaiHohoHenkoModel
     * @return 登録件数
     */
    @Transaction
    public int save支払方法変更(ShiharaiHohoHenkoModel 支払方法変更モデル) {

        if (支払方法変更モデル.getState() == EntityDataState.Added) {
            return dac.insert(支払方法変更モデル);
        } else if (支払方法変更モデル.getState() == EntityDataState.Modified) {
            return dac.update(支払方法変更モデル);
        } else if (支払方法変更モデル.getState() == EntityDataState.Deleted) {
            return dac.delete(支払方法変更モデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
