/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5001NinteiShinseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5002NinteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.JukyushaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.NinteiShinseiJohoModel;
import jp.co.ndensan.reams.db.dbz.model.NinteiKekkaJohoModel;
import jp.co.ndensan.reams.db.dbz.model.relate.NinteiShinseiKekkaModel;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;

/**
 * NinteiShinseiKekkaModelのテストデータ作成クラスです。
 *
 * @author n8187 久保田 英男
 */
public final class NinteiShinseiKekkaModelTestHelper {

    private NinteiShinseiKekkaModelTestHelper() {
    }

    public static NinteiShinseiKekkaModel createModel() {

        return new NinteiShinseiKekkaModel(
                new JukyushaDaichoModel(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity()),
                DbOptional.of(new NinteiShinseiJohoModel(DbT5001NinteiShinseiJohoEntityGenerator.createDbT5001NinteiShinseiJohoEntity())),
                DbOptional.of(new NinteiKekkaJohoModel(DbT5002NinteiKekkaJohoEntityGenerator.createDbT5002NinteiKekkaJohoEntity())));
    }
}
