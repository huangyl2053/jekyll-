/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbz.business.HokenryoDankai;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.DankaiIndex;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.model.fuka.HokenryoDankaiModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.HokenryoDankaiDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 保険料段階を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class HokenryoDankaiManager {

    private final HokenryoDankaiDac dac;
    private final FukaKeisanConfig config;

    /**
     * コンストラクタです。
     */
    public HokenryoDankaiManager() {
        dac = InstanceProvider.create(HokenryoDankaiDac.class);
        config = new FukaKeisanConfig();
    }

    /**
     * 単体テスト用のコンストラクタです。
     */
    HokenryoDankaiManager(HokenryoDankaiDac dac, FukaKeisanConfig config) {
        this.dac = dac;
        this.config = config;
    }

    /**
     * 引数に合致する保険料段階を返します。
     *
     * @param 賦課年度 賦課年度
     * @param 段階インデックス 段階インデックス
     * @param ランク区分 ランク区分
     * @return IOptional<HokenryoDankaiModel>
     */
    @Transaction
    public IOptional<HokenryoDankaiModel> get保険料段階(FukaNendo 賦課年度, DankaiIndex 段階インデックス, RankKubun ランク区分) {
        return DbOptional.ofNullable(dac.select保険料段階ByKey(賦課年度, 段階インデックス, ランク区分));
    }

    /**
     * 引数に合致する保険料段階を返します。
     *
     * @param 賦課年度 賦課年度
     * @param 市町村コード 市町村コード
     * @param 段階区分 段階区分
     * @return IOptional<HokenryoDankai>
     */
    public IOptional<HokenryoDankai> get保険料段階(FukaNendo 賦課年度, LasdecCode 市町村コード, RString 段階区分) {
        List<HokenryoDankaiModel> modelList = isランク対象(賦課年度, 市町村コード)
                ? dac.select保険料段階一覧(賦課年度, 市町村コード, 段階区分)
                : dac.select保険料段階一覧(賦課年度, 段階区分);
        return DbOptional.ofNullable(!modelList.isEmpty() ? new HokenryoDankai(modelList.get(0), config) : null);
    }

    private boolean isランク対象(FukaNendo 賦課年度, LasdecCode 市町村コード) {
        return config.isランク有り() && new Range(config.getランク開始年度(), config.getランク終了年度()).between(賦課年度) && 市町村コード != null;
    }

    /**
     * 引数に合致する保険料段階の一覧を返します。
     *
     * @param 賦課年度 賦課年度
     * @return IItemList<HokenryoDankaiModel>
     */
    @Transaction
    public IItemList<HokenryoDankaiModel> get保険料段階一覧(FukaNendo 賦課年度) {
        return ItemList.of(dac.select保険料段階一覧(賦課年度));
    }

    /**
     * 保険料段階を登録します。
     *
     * @param 保険料段階モデル HokenryoDankaiModel
     * @return 登録件数
     */
    @Transaction
    public int save保険料段階(HokenryoDankaiModel 保険料段階モデル) {

        if (保険料段階モデル.getState() == EntityDataState.Added) {
            return dac.insert(保険料段階モデル);
        } else if (保険料段階モデル.getState() == EntityDataState.Modified) {
            return dac.update(保険料段階モデル);
        } else if (保険料段階モデル.getState() == EntityDataState.Deleted) {
            return dac.delete(保険料段階モデル);
        }

        throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
    }
}
