/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.TaishoshaModel;
import jp.co.ndensan.reams.ur.urz.business.ISearchResult;

/**
 * 対象者検索の結果を格納するクラスです。（資格系）
 *
 * @author N8156 宮本 康
 */
public class TaishoshaSearchResult implements ISearchResult<TaishoshaModel> {

    private final int count;
    private final List<TaishoshaModel> result;

    /**
     * コンストラクタです
     *
     * @param count 検索結果件数
     * @param result 検索結果
     */
    public TaishoshaSearchResult(int count, List<TaishoshaModel> result) {
        this.count = count;
        this.result = result;
    }

    /**
     * 検索結果件数を返します。
     *
     * @return 検索結果件数
     */
    @Override
    public int getTotalCount() {
        return count;
    }

    /**
     * 検索結果を返します。
     *
     * @return 検索結果
     */
    @Override
    public List<TaishoshaModel> getList() {
        return result;
    }
}
