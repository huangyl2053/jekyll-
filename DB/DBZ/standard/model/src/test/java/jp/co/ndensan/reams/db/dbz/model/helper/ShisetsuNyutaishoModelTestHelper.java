/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.helper;

import java.util.Arrays;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.model.shisetsunyutaisho.ShisetsuNyutaishoModel;

/**
 * ShisetsuNyutaishoModelのテストデータ作成クラスです。
 *
 * @author n8223 朴義一
 */
public final class ShisetsuNyutaishoModelTestHelper {

    private ShisetsuNyutaishoModelTestHelper() {
    }

    public static ShisetsuNyutaishoRelateModel createModel() {

        return new ShisetsuNyutaishoRelateModel(
                new ShisetsuNyutaishoModel(DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity()));
    }
}
