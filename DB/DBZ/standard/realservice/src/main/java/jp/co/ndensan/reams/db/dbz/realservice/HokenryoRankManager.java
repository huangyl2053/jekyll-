/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.model.HokenryoRankModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.model.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.HokenryoRankDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 保険料ランクを管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class HokenryoRankManager {

    private final HokenryoRankDac dac;

    /**
     * コンストラクタです。
     */
    public HokenryoRankManager() {
        dac = InstanceProvider.create(HokenryoRankDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    HokenryoRankManager(HokenryoRankDac dac) {
        this.dac = dac;
    }

    /**
     * 引数に合致する保険料ランクを返します。
     *
     * @param 賦課年度 賦課年度
     * @param 市町村コード 市町村コード
     * @return HokenryoRankModel
     */
    @Transaction
    public IOptional<HokenryoRankModel> get保険料ランク(FlexibleYear 賦課年度, LasdecCode 市町村コード) {

        return DbOptional.ofNullable(dac.select保険料ランクByKey(賦課年度, 市町村コード));
    }

    /**
     * 引数に合致する保険料ランクの一覧を返します。
     *
     * @param 賦課年度 賦課年度
     * @return List<HokenryoRankModel>
     */
    @Transaction
    public IItemList<HokenryoRankModel> get保険料ランク一覧(FlexibleYear 賦課年度) {
        return ItemList.of(dac.select保険料ランク一覧(賦課年度));
    }

    /**
     * 保険料ランクを登録します。
     *
     * @param 保険料ランクモデル HokenryoRankModel
     * @return 登録件数
     */
    @Transaction
    public int save保険料ランク(HokenryoRankModel 保険料ランクモデル) {

        if (保険料ランクモデル.getState() == EntityDataState.Added) {
            return dac.insert(保険料ランクモデル);
        } else if (保険料ランクモデル.getState() == EntityDataState.Modified) {
            return dac.update(保険料ランクモデル);
        } else if (保険料ランクモデル.getState() == EntityDataState.Deleted) {
            return dac.delete(保険料ランクモデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
