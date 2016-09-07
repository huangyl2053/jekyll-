/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoservicenaiyou;

import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
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
 * {link KaigoServiceNaiyouManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoServiceNaiyouManagerTest {

    private static DbT7131KaigoServiceNaiyouDac dac;
    private static KaigoServiceNaiyouManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7131KaigoServiceNaiyouDac.class);
        sut = new KaigoServiceNaiyouManager(dac, InstanceProvider.create(MapperProvider.class));
    }

    public static class save介護サービス内容 extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(1);

            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);

            assertThat(sut.save介護サービス内容(介護サービス内容), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(0);

            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);

            assertThat(sut.save介護サービス内容(介護サービス内容), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(1);

            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.initializeMd5();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);
            介護サービス内容 = 介護サービス内容.createBuilderForEdit().set単位数(1).build();

            assertThat(sut.save介護サービス内容(介護サービス内容), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(0);

            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.initializeMd5();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);
            介護サービス内容 = 介護サービス内容.createBuilderForEdit().set単位数(1).build();

            assertThat(sut.save介護サービス内容(介護サービス内容), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(1);

            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.initializeMd5();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);
            介護サービス内容 = 介護サービス内容.deleted();

            assertThat(sut.save介護サービス内容(介護サービス内容), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(0);

            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.initializeMd5();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);
            介護サービス内容 = 介護サービス内容.deleted();

            assertThat(sut.save介護サービス内容(介護サービス内容), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.initializeMd5();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);

            assertThat(sut.save介護サービス内容(介護サービス内容), is(false));
        }
    }
}
