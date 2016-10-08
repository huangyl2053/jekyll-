/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.iryohokenkanyujokyo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1008IryohokenKanyuJokyoDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 医療保険履歴のクラスです。
 *
 * @reamsid_L DBA-0230-020 hezhenzhen
 *
 */
public class IryohokenKanyuJokyoManager {

    private final DbT1008IryohokenKanyuJokyoDac dac;

    /**
     * コンストラクタです。
     */
    public IryohokenKanyuJokyoManager() {

        dac = InstanceProvider.create(DbT1008IryohokenKanyuJokyoDac.class);
    }

    /**
     * コンストラクタ。
     *
     */
    IryohokenKanyuJokyoManager(DbT1008IryohokenKanyuJokyoDac dac) {

        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IryohokenKanyuJokyoManager}のインスタンスを返します。
     *
     * @return IryohokenKanyuJokyoManager
     */
    public static IryohokenKanyuJokyoManager createInstance() {
        return InstanceProvider.create(IryohokenKanyuJokyoManager.class);
    }

    /**
     * 医療保険情報リストを取得します。
     *
     * @param 識別コード 識別コード
     * @return SearchResult<IryohokenKanyuJokyo>
     */
    @Transaction
    public SearchResult<IryohokenKanyuJokyo> getIryoHokenJohoList(ShikibetsuCode 識別コード) {
        List<DbT1008IryohokenKanyuJokyoEntity> ｓhikibetsuCodeList = dac.selectByCode(識別コード);

        if (ｓhikibetsuCodeList == null || ｓhikibetsuCodeList.isEmpty()) {
            return SearchResult.of(Collections.<IryohokenKanyuJokyo>emptyList(), 0, false);
        }
        List<IryohokenKanyuJokyo> kanyuJokyosList = new ArrayList<>();
        for (DbT1008IryohokenKanyuJokyoEntity entity : ｓhikibetsuCodeList) {
            kanyuJokyosList.add(new IryohokenKanyuJokyo(entity));
        }
        return SearchResult.of(kanyuJokyosList, 0, false);

    }

    /**
     * 医療保険情報の保存処理を保存します。
     *
     * @param 医療保険情報List 医療保険情報
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public int saveAllIryoHokenJoho(List<IryohokenKanyuJokyo> 医療保険情報List) {
        int count = 0;
        for (IryohokenKanyuJokyo 医療保険情報 : 医療保険情報List) {
            if (!EntityDataState.Unchanged.equals(医療保険情報.toEntity().getState())) {
                count = count + dac.saveOrDeletePhysicalBy(医療保険情報.toEntity());
            }
        }
        return count;
    }
}
