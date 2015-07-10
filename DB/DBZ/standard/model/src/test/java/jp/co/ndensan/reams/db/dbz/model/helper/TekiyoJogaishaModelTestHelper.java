/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.helper;

import java.util.Arrays;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1002TekiyoJogaishaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.TekiyoJogaishaModel;

/**
 * TekiyoJogaishaModelModelのテストデータ作成クラスです。
 *
 * @author n8178 城間篤人
 */
public final class TekiyoJogaishaModelTestHelper {

    private TekiyoJogaishaModelTestHelper() {
    }

    public static TekiyoJogaishaModel createModel() {

        return new TekiyoJogaishaModel(DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity());
    }
}
