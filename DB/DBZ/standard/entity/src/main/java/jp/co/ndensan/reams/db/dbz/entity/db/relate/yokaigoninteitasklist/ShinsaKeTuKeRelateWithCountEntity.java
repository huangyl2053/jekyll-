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
 * 審査受付入手処理の検索条件に該当する対象者と件数を保持するEntityクラスです。
 *
 * @author n8335
 */
@lombok.Getter
@lombok.Setter
public class ShinsaKeTuKeRelateWithCountEntity {

    private Decimal totalCount;
    private List<ShinSaKeTuKeRelateEntity> taishoshaList;

    /**
     * コンストラクタです。
     */
    public ShinsaKeTuKeRelateWithCountEntity() {
        this.totalCount = Decimal.ZERO;
        this.taishoshaList = new ArrayList<>();
    }
}
