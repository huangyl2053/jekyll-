/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigoserviceshurui;

import java.util.Arrays;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * KaigoServiceShuruiEntityのテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiEntityTest extends DbxTestBase {

    private static KaigoServiceShuruiEntity sut;

    public static class 新規作成時 extends DbxTestBase {

        @Before
        public void setUp() {
            createEntity();
        }

        @Test
        public void DbT7130KaigoServiceShuruiEntityの_EntityStateは_Added() {
            assertThat(sut.get介護サービス種類Entity().getState(), is(EntityDataState.Added));
        }

        @Test
        public void DbT7131KaigoServiceNaiyouEntityの_EntityStateは_Added() {
            assertThat(sut.get介護サービス内容Entity().get(0).getState(), is(EntityDataState.Added));
        }

    }

    public static class initializeMd5ToEntities後 extends DbxTestBase {

        @Before
        public void setUp() {
            createEntity();
            sut.initializeMd5ToEntities();
        }

        @Test
        public void DbT7130KaigoServiceShuruiEntityの_EntityStateは_Unchanged() {
            sut.initializeMd5ToEntities();
            assertThat(sut.get介護サービス種類Entity().getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void DbT7131KaigoServiceNaiyouEntityの_EntityStateは_Unchanged() {
            assertThat(sut.get介護サービス内容Entity().get(0).getState(), is(EntityDataState.Unchanged));
        }
    }

    private static void createEntity() {
        sut = new KaigoServiceShuruiEntity();
        sut.set介護サービス種類Entity(new DbT7130KaigoServiceShuruiEntity());
        sut.set介護サービス内容Entity(Arrays.asList(new DbT7131KaigoServiceNaiyouEntity()));
    }
}
