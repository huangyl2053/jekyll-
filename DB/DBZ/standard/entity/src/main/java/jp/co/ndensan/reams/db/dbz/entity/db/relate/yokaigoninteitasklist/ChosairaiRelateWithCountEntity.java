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
 *
 * @author
 */
@lombok.Getter
@lombok.Setter
public class ChosairaiRelateWithCountEntity {

    private Decimal totalCount;
    private List<CyoSaiRaiRelateEntity> taishoshaList;

    /**
     * コンストラクタです。
     */
    public ChosairaiRelateWithCountEntity() {
        this.totalCount = Decimal.ZERO;
        this.taishoshaList = new ArrayList<>();
    }
}
