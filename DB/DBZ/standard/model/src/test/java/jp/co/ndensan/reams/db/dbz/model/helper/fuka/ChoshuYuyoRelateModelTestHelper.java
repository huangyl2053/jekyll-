/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.helper.fuka;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.fuka.ChoshuYuyoModel;
import jp.co.ndensan.reams.db.dbz.model.fuka.KibetsuChoshuYuyoModel;
import jp.co.ndensan.reams.db.dbz.model.relate.fuka.ChoshuYuyoRelateModel;

/**
 * ChoshuYuyoRelateModelのテストデータ作成クラスです。
 *
 * @author n3317 塚田 萌
 */
public final class ChoshuYuyoRelateModelTestHelper {

    private ChoshuYuyoRelateModelTestHelper() {
    }

    public static ChoshuYuyoRelateModel createModel() {
        List<KibetsuChoshuYuyoModel> list = new ArrayList<>();
        list.add(new KibetsuChoshuYuyoModel(DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity()));

        return new ChoshuYuyoRelateModel(
                new ChoshuYuyoModel(DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity()),
                list);
    }
}
