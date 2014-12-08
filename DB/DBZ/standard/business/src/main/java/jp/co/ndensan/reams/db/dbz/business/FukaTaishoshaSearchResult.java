/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.FukaTaishoshaModel;
import jp.co.ndensan.reams.ur.urz.business.ISearchResult;

/**
 * 対象者検索の結果を格納するクラスです。（賦課系）
 *
 * @author N8156 宮本 康
 */
public class FukaTaishoshaSearchResult implements ISearchResult<FukaTaishoshaModel> {

    private final int count;
    private final List<FukaTaishoshaModel> result;

    /**
     * コンストラクタです
     *
     * @param count 検索結果件数
     * @param result 検索結果
     */
    public FukaTaishoshaSearchResult(int count, List<FukaTaishoshaModel> result) {
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
    public List<FukaTaishoshaModel> getList() {
        return result;
    }
}
