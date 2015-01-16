/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.helper;

import java.util.Arrays;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.KaigoJogaiTokureiTaishoShisetsu.KaigoJogaiTokureiTaishoShisetsuModel;
import jp.co.ndensan.reams.db.dbz.model.relate.KaigoJogaiTokureiTaishoShisetsuRelateModel;

/**
 * KaigoJogaiTokureiTaishoShisetsuRelateModelのテストデータ作成クラスです。
 *
 * @author n8223 朴義一
 */
public final class KaigoJogaiTokureiTaishoShisetsuRelateModelTestHelper {

    private KaigoJogaiTokureiTaishoShisetsuRelateModelTestHelper() {
    }

    public static KaigoJogaiTokureiTaishoShisetsuRelateModel createModel() {
        return new KaigoJogaiTokureiTaishoShisetsuRelateModel(
                new KaigoJogaiTokureiTaishoShisetsuModel(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity()));
    }
}
