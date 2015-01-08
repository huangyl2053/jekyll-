/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.model.FukaModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.FukaDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class FukaManager {

    private final FukaDac dac;

    /**
     * コンストラクタです。
     */
    public FukaManager() {
        dac = InstanceProvider.create(FukaDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    FukaManager(FukaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護賦課を返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     * @return IOptional<FukaModel>
     */
    @Transaction
    public IOptional<FukaModel> get介護賦課(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, RDateTime 処理日時) {
        return dac.select介護賦課ByKey(調定年度, 賦課年度, 通知書番号, 処理日時);
    }

    /**
     * 条件に合致する介護賦課の一覧を返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return IItemList<FukaModel>
     */
    @Transaction
    public IItemList<FukaModel> get介護賦課一覧(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {
        return dac.select介護賦課一覧(調定年度, 賦課年度, 通知書番号);
    }

    /**
     * 条件に合致する最新介護賦課を返します。
     *
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return IOptional<FukaModel>
     */
    @Transaction
    public IOptional<FukaModel> get最新介護賦課(FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {
        return dac.select最新介護賦課(賦課年度, 通知書番号);
    }

    /**
     * 介護賦課を登録します。
     *
     * @param 介護賦課モデル FukaModel
     * @return 登録件数
     */
    @Transaction
    public int save介護賦課(FukaModel 介護賦課モデル) {

        if (介護賦課モデル.getState() == EntityDataState.Added) {
            return dac.insert(介護賦課モデル);
        } else if (介護賦課モデル.getState() == EntityDataState.Modified) {
            return dac.update(介護賦課モデル);
        } else if (介護賦課モデル.getState() == EntityDataState.Deleted) {
            return dac.delete(介護賦課モデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
