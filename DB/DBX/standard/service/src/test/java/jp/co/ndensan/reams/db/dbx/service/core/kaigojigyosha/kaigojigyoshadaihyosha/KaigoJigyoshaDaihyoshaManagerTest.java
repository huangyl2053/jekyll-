/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyoshadaihyosha;

import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KaigoJigyoshaDaihyoshaManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoJigyoshaDaihyoshaManagerTest {

    private static DbT7062KaigoJigyoshaDaihyoshaDac dac;
    private static KaigoJigyoshaDaihyoshaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7062KaigoJigyoshaDaihyoshaDac.class);
        sut = new KaigoJigyoshaDaihyoshaManager(dac);
    }

    public static class save介護事業者代表者 extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7062KaigoJigyoshaDaihyoshaEntity.class))).thenReturn(1);

            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);

            assertThat(sut.save介護事業者代表者(介護事業者代表者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7062KaigoJigyoshaDaihyoshaEntity.class))).thenReturn(0);

            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);

            assertThat(sut.save介護事業者代表者(介護事業者代表者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7062KaigoJigyoshaDaihyoshaEntity.class))).thenReturn(1);

            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            entity.initializeMd5();
            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);
            介護事業者代表者 = 介護事業者代表者.createBuilderForEdit().set代表者住所カナ(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護事業者代表者(介護事業者代表者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7062KaigoJigyoshaDaihyoshaEntity.class))).thenReturn(0);

            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            entity.initializeMd5();
            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);
            介護事業者代表者 = 介護事業者代表者.createBuilderForEdit().set代表者住所カナ(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護事業者代表者(介護事業者代表者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7062KaigoJigyoshaDaihyoshaEntity.class))).thenReturn(1);

            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            entity.initializeMd5();
            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);
            介護事業者代表者 = 介護事業者代表者.deleted();

            assertThat(sut.save介護事業者代表者(介護事業者代表者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7062KaigoJigyoshaDaihyoshaEntity.class))).thenReturn(0);

            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            entity.initializeMd5();
            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);
            介護事業者代表者 = 介護事業者代表者.deleted();

            assertThat(sut.save介護事業者代表者(介護事業者代表者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            entity.initializeMd5();
            KaigoJigyoshaDaihyosha 介護事業者代表者 = new KaigoJigyoshaDaihyosha(entity);

            assertThat(sut.save介護事業者代表者(介護事業者代表者), is(false));
        }
    }
}
