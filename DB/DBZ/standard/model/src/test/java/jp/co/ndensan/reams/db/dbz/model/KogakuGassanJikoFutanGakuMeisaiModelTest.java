/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuGassanJikoFutanGakuMeisaiModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuGassanJikoFutanGakuMeisaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuGassanJikoFutanGakuMeisaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuGassanJikoFutanGakuMeisaiModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            sut.set対象年度(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_対象年度);
            assertThat(sut.get対象年度(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            sut.set保険者番号(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_保険者番号);
            assertThat(sut.get保険者番号(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の支給申請書整理番号は_設定した値と同じ支給申請書整理番号を返す() {
            sut.set支給申請書整理番号(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_支給申請書整理番号);
            assertThat(sut.get支給申請書整理番号(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_支給申請書整理番号));
        }

        @Test
        public void 戻り値の対象月は_設定した値と同じ対象月を返す() {
            sut.set対象月(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_対象月);
            assertThat(sut.get対象月(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_対象月));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の自己負担額は_設定した値と同じ自己負担額を返す() {
            sut.set自己負担額(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_自己負担額);
            assertThat(sut.get自己負担額(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_自己負担額));
        }

        @Test
        public void 戻り値の70_74自己負担額_内数は_設定した値と同じ70_74自己負担額_内数を返す() {
            sut.set70_74自己負担額_内数(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_70_74自己負担額_内数);
            assertThat(sut.get70_74自己負担額_内数(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_70_74自己負担額_内数));
        }

        @Test
        public void 戻り値の70未満高額支給額は_設定した値と同じ70未満高額支給額を返す() {
            sut.set70未満高額支給額(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_70未満高額支給額);
            assertThat(sut.get70未満高額支給額(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_70未満高額支給額));
        }

        @Test
        public void 戻り値の70_74高額支給額は_設定した値と同じ70_74高額支給額を返す() {
            sut.set70_74高額支給額(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_70_74高額支給額);
            assertThat(sut.get70_74高額支給額(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_70_74高額支給額));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            sut.set摘要(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_摘要);
            assertThat(sut.get摘要(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_摘要));
        }

        @Test
        public void 戻り値の補正済_自己負担額は_設定した値と同じ補正済_自己負担額を返す() {
            sut.set補正済_自己負担額(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済_自己負担額);
            assertThat(sut.get補正済_自己負担額(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済_自己負担額));
        }

        @Test
        public void 戻り値の補正済_70_74自己負担額_内数は_設定した値と同じ補正済_70_74自己負担額_内数を返す() {
            sut.set補正済_70_74自己負担額_内数(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済_70_74自己負担額_内数);
            assertThat(sut.get補正済_70_74自己負担額_内数(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済_70_74自己負担額_内数));
        }

        @Test
        public void 戻り値の補正済_70未満高額支給額は_設定した値と同じ補正済_70未満高額支給額を返す() {
            sut.set補正済_70未満高額支給額(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済_70未満高額支給額);
            assertThat(sut.get補正済_70未満高額支給額(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済_70未満高額支給額));
        }

        @Test
        public void 戻り値の補正済_70_74高額支給額は_設定した値と同じ補正済_70_74高額支給額を返す() {
            sut.set補正済_70_74高額支給額(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済_70_74高額支給額);
            assertThat(sut.get補正済_70_74高額支給額(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済_70_74高額支給額));
        }

        @Test
        public void 戻り値の補正済_摘要は_設定した値と同じ補正済_摘要を返す() {
            sut.set補正済_摘要(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済_摘要);
            assertThat(sut.get補正済_摘要(), is(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_補正済_摘要));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuGassanJikoFutanGakuMeisaiModel sut = new KogakuGassanJikoFutanGakuMeisaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuGassanJikoFutanGakuMeisaiModel sut = new KogakuGassanJikoFutanGakuMeisaiModel();
        //sut.setEntity(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.createDbT3071KogakuGassanJikoFutanGakuMeisaiEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuGassanJikoFutanGakuMeisaiModel sut = new KogakuGassanJikoFutanGakuMeisaiModel();
            sut.setEntity(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.createDbT3071KogakuGassanJikoFutanGakuMeisaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuGassanJikoFutanGakuMeisaiModel sut = new KogakuGassanJikoFutanGakuMeisaiModel();
            sut.setEntity(DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.createDbT3071KogakuGassanJikoFutanGakuMeisaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
