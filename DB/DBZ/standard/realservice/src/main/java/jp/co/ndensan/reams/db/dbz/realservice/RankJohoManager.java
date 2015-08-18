/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

//import jp.co.ndensan.reams.db.dbz.model.fuka.RankJohoModel;
//import jp.co.ndensan.reams.db.dbz.persistence.relate.RankJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ランク情報を管理するクラスです。
 *
 * @author N8156 宮本 康
 * @deprecated dbb.realserviceを使用する。
 */
// TODO n8300姜 dbb.realserviceパッケージに移動予定。
public class RankJohoManager {

//    private final RankJohoDac dac;
    /**
     * コンストラクタです。
     */
//    public RankJohoManager() {
//        dac = InstanceProvider.create(RankJohoDac.class);
//    }
    /**
     * 単体テスト用のコンストラクタです。
     */
//    RankJohoManager(RankJohoDac dac) {
//        this.dac = dac;
//    }
    /**
     * 引数に合致するランク情報を返します。
     *
     * @param 賦課年度 賦課年度
     * @param ランク区分 ランク区分
     * @return RankJohoModel
     */
    @Transaction
    public Optional<Object> getランク情報(FukaNendo 賦課年度, RankKubun ランク区分) {

        return Optional.ofNullable(null);
    }
//    public Optional<RankJohoModel> getランク情報(FukaNendo 賦課年度, RankKubun ランク区分) {
//
//        return Optional.ofNullable(dac.selectランク情報ByKey(賦課年度, ランク区分));
//    }

    /**
     * 引数に合致するランク情報の一覧を返します。
     *
     * @param 賦課年度 賦課年度
     * @return List<RankJohoModel>
     */
    @Transaction
    public IItemList<Object> getランク情報一覧(FukaNendo 賦課年度) {
        return null;
    }
//    public IItemList<RankJohoModel> getランク情報一覧(FukaNendo 賦課年度) {
//        return ItemList.of(dac.selectランク情報一覧(賦課年度));
//    }

    /**
     * ランク情報を登録します。
     *
     * @param ランク情報モデル RankJohoModel
     * @return 登録件数
     */
    @Transaction
    public int saveランク情報(Object ランク情報モデル) {
//        public int saveランク情報(RankJohoModel ランク情報モデル) {

//        if (ランク情報モデル.getState() == EntityDataState.Added) {
//            return dac.insert(ランク情報モデル);
//        } else if (ランク情報モデル.getState() == EntityDataState.Modified) {
//            return dac.update(ランク情報モデル);
//        } else if (ランク情報モデル.getState() == EntityDataState.Deleted) {
//            return dac.delete(ランク情報モデル);
//        }
        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
