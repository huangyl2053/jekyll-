/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.model.helper;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.UrT0705ChoteiKyotsuEntityGenerator;
import jp.co.ndensan.reams.db.dbb.model.KibetsuModel;
import jp.co.ndensan.reams.db.dbb.model.ChoteiKyotsuModel;
import jp.co.ndensan.reams.db.dbb.model.relate.KibetsuChoteiKyotsuModel;

/**
 * KibetsuChoteiKyotsuModelのテストデータ作成クラスです。
 *
 * @author N8156 宮本 康
 */
public final class KibetsuChoteiKyotsuModelTestHelper {

    private KibetsuChoteiKyotsuModelTestHelper() {
    }

    public static KibetsuChoteiKyotsuModel createModel() {

        return new KibetsuChoteiKyotsuModel(
                new KibetsuModel(DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity()),
                new ChoteiKyotsuModel(UrT0705ChoteiKyotsuEntityGenerator.createUrT0705ChoteiKyotsuEntity()));
    }
}
