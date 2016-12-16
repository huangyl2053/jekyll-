/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 月例処理の検索条件に該当する対象者と件数を保持するEntityクラスです。
 */
public class GetureiSyoriTantoshaWithCountEntity {

    private Decimal totalCount;
    private List<GeTuReiSyoRiRelateEntity> taishoshaList;

    /**
     * コンストラクタです。
     */
    public GetureiSyoriTantoshaWithCountEntity() {
        this.totalCount = Decimal.ZERO;
        this.taishoshaList = new ArrayList<>();
    }

    /**
     * totalCountを取得します。
     *
     * @return totalCount
     */
    public Decimal getTotalCount() {
        return totalCount;
    }

    /**
     * totalCountを設定します。
     *
     * @param totalCount totalCount
     */
    public void setTotalCount(Decimal totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 検索結果の対象者の一覧を取得します。
     *
     * @return 検索結果の対象者の一覧
     */
    public List<GeTuReiSyoRiRelateEntity> getTaishoshaList() {
        return taishoshaList;
    }

    /**
     * 検索結果の対象者の一覧を設定します。
     *
     * @param taishoshaList 検索結果の対象者の一覧
     */
    public void setTaishoshaList(List<GeTuReiSyoRiRelateEntity> taishoshaList) {
        this.taishoshaList = taishoshaList;
    }

}
