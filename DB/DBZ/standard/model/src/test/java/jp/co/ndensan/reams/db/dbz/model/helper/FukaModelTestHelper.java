/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.FukaModel;

/**
 * FukaModelのテストデータ作成クラスです。
 *
 * @author N8156 宮本 康
 */
public final class FukaModelTestHelper {

    private FukaModelTestHelper() {
    }

    public static FukaModel createModel() {
        return new FukaModel(DbT2002FukaEntityGenerator.createDbT2002FukaEntity());
    }
}
