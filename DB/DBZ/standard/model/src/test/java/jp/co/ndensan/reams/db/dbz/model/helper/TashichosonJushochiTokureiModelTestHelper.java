/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1003TashichosonJushochiTokureiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.TashichosonJushochiTokureiModel;

/**
 * TashichosonJushochiTokureiModelModelのテストデータ作成クラスです。
 *
 * @author n8178 城間篤人
 */
public final class TashichosonJushochiTokureiModelTestHelper {

    private TashichosonJushochiTokureiModelTestHelper() {
    }

    public static TashichosonJushochiTokureiModel createModel() {

        return new TashichosonJushochiTokureiModel(
                DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity());
    }
}
