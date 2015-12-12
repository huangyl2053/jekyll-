/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KibetsuChoshuYuyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KibetsuChoshuYuyoBuilderTest extends DbbTestBase {

    private static DbT2007KibetsuChoshuYuyoEntity kibetsuChoshuYuyoEntity;

    public static class getterSetterTest extends DbbTestBase {

        private static KibetsuChoshuYuyoBuilder sut;
        private static KibetsuChoshuYuyo business;

        @Before
        public void setUp() {
            kibetsuChoshuYuyoEntity = new DbT2007KibetsuChoshuYuyoEntity();

            business = new KibetsuChoshuYuyo(kibetsuChoshuYuyoEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の徴収猶予開始日は_設定した値と同じ徴収猶予開始日を返す() {
            business = sut.set徴収猶予開始日(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収猶予開始日).build();
            assertThat(business.get徴収猶予開始日(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収猶予開始日));
        }

        @Test
        public void 戻り値の徴収猶予終了日は_設定した値と同じ徴収猶予終了日を返す() {
            business = sut.set徴収猶予終了日(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収猶予終了日).build();
            assertThat(business.get徴収猶予終了日(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収猶予終了日));
        }

    }
}
