/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;

/**
 * HihokenshaDaichoModelのテストデータ作成クラスです。
 *
 * @author N8156 宮本 康
 */
public final class HihokenshaDaichoModelTestHelper {

    private HihokenshaDaichoModelTestHelper() {
    }

    /**
     * {@link HihokenshaDaichoModel}を生成して返します。
     *
     * @return {@link HihokenshaDaichoModel}
     */
    public static HihokenshaDaichoModel createModel() {
        return new HihokenshaDaichoModel(DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity());
    }
}
