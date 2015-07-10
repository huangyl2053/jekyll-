/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.helper;

import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3005KyotakuKeikakuTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuTodokedeModel;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuJigyoshaSakuseiModel;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuJikoSakuseiModel;
import jp.co.ndensan.reams.db.dbz.model.relate.KyotakuKeikakuRelateModel;

/**
 * KyotakuKeikakuRelateModelのテストデータ作成クラスです。
 *
 * @author n8187 久保田 英男
 */
public final class KyotakuKeikakuRelateModelTestHelper {

    private KyotakuKeikakuRelateModelTestHelper() {
    }

    public static KyotakuKeikakuRelateModel createModel() {

        return new KyotakuKeikakuRelateModel(
                new KyotakuKeikakuTodokedeModel(DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity()),
                Optional.ofNullable(new KyotakuKeikakuJigyoshaSakuseiModel(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity())),
                Optional.ofNullable(new KyotakuKeikakuJikoSakuseiModel(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity())));
    }
}
