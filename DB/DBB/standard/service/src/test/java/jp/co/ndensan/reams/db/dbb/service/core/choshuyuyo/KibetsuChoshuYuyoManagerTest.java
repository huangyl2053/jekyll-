/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo;

import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.KibetsuChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2007KibetsuChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KibetsuChoshuYuyoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KibetsuChoshuYuyoManagerTest {

    private static DbT2007KibetsuChoshuYuyoDac dac;
    private static KibetsuChoshuYuyoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT2007KibetsuChoshuYuyoDac.class);
        sut = new KibetsuChoshuYuyoManager(dac);
    }

    public static class save介護期別徴収猶予 extends DbbTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT2007KibetsuChoshuYuyoEntity.class))).thenReturn(1);

            DbT2007KibetsuChoshuYuyoEntity entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            KibetsuChoshuYuyo 介護期別徴収猶予 = new KibetsuChoshuYuyo(entity);

            assertThat(sut.save介護期別徴収猶予(介護期別徴収猶予), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT2007KibetsuChoshuYuyoEntity.class))).thenReturn(0);

            DbT2007KibetsuChoshuYuyoEntity entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            KibetsuChoshuYuyo 介護期別徴収猶予 = new KibetsuChoshuYuyo(entity);

            assertThat(sut.save介護期別徴収猶予(介護期別徴収猶予), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT2007KibetsuChoshuYuyoEntity.class))).thenReturn(1);

            DbT2007KibetsuChoshuYuyoEntity entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            entity.initializeMd5();
            KibetsuChoshuYuyo 介護期別徴収猶予 = new KibetsuChoshuYuyo(entity);
            介護期別徴収猶予 = 介護期別徴収猶予.createBuilderForEdit().set徴収猶予開始日(new FlexibleDate("20151111")).build();

            assertThat(sut.save介護期別徴収猶予(介護期別徴収猶予), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT2007KibetsuChoshuYuyoEntity.class))).thenReturn(0);

            DbT2007KibetsuChoshuYuyoEntity entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            entity.initializeMd5();
            KibetsuChoshuYuyo 介護期別徴収猶予 = new KibetsuChoshuYuyo(entity);
            介護期別徴収猶予 = 介護期別徴収猶予.createBuilderForEdit().set徴収猶予開始日(new FlexibleDate("20151111")).build();

            assertThat(sut.save介護期別徴収猶予(介護期別徴収猶予), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT2007KibetsuChoshuYuyoEntity.class))).thenReturn(1);

            DbT2007KibetsuChoshuYuyoEntity entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            entity.initializeMd5();
            KibetsuChoshuYuyo 介護期別徴収猶予 = new KibetsuChoshuYuyo(entity);
            介護期別徴収猶予 = 介護期別徴収猶予.deleted();

            assertThat(sut.save介護期別徴収猶予(介護期別徴収猶予), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT2007KibetsuChoshuYuyoEntity.class))).thenReturn(0);

            DbT2007KibetsuChoshuYuyoEntity entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            entity.initializeMd5();
            KibetsuChoshuYuyo 介護期別徴収猶予 = new KibetsuChoshuYuyo(entity);
            介護期別徴収猶予 = 介護期別徴収猶予.deleted();

            assertThat(sut.save介護期別徴収猶予(介護期別徴収猶予), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT2007KibetsuChoshuYuyoEntity entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            entity.initializeMd5();
            KibetsuChoshuYuyo 介護期別徴収猶予 = new KibetsuChoshuYuyo(entity);

            assertThat(sut.save介護期別徴収猶予(介護期別徴収猶予), is(false));
        }
    }
}
