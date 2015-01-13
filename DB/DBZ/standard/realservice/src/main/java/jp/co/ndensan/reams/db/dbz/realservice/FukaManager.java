/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.fuka.FukaModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.persistence.relate.FukaDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 賦課を管理するクラスです。
 *
 * @author n3317 塚田 萌
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
     *
     * @param dac 賦課dac
     */
    FukaManager(FukaDac dac) {
        this.dac = dac;
    }

    /**
     * 条件に該当する全賦課履歴を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 全賦課履歴
     */
    public IItemList<FukaModel> load全賦課履歴(HihokenshaNo 被保険者番号) {
        return dac.select介護賦課一覧(被保険者番号);
    }

    /**
     * 条件に該当する全賦課履歴を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 賦課年度 賦課年度
     * @return 全賦課履歴
     */
    public IItemList<FukaModel> load全賦課履歴(HihokenshaNo 被保険者番号, FukaNendo 賦課年度) {
        return dac.select介護賦課一覧(被保険者番号, 賦課年度);
    }

    /**
     * 引数の主キーに該当する１件の賦課モデルを取得します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     * @return 賦課モデル
     */
    public IOptional<FukaModel> find賦課(ChoteiNendo 調定年度, FukaNendo 賦課年度,
            TsuchishoNo 通知書番号, RDateTime 処理日時) {

        return dac.select賦課ByKey(調定年度, 賦課年度, 通知書番号, 処理日時);
    }

    /**
     * 引数に該当するデータから直近の１件を取得します。<br/>
     * 直近とは以下の条件でソートした１件目です。<br/>
     * 通知書番号（降順）＞調定年度（降順）＞処理日時（降順）かつ　引数の処理日時　＞　対象データの処理日時
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @param 処理日時 処理日時
     * @return 直近賦課モデル
     */
    public IOptional<FukaModel> find賦課直近(FukaNendo 賦課年度, HihokenshaNo 被保険者番号, RDateTime 処理日時) {

        return dac.select賦課Recently(賦課年度, 被保険者番号, 処理日時);
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
    public IItemList<FukaModel> get介護賦課一覧(ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号) {
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
    public IOptional<FukaModel> get最新介護賦課(FukaNendo 賦課年度, TsuchishoNo 通知書番号) {
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
