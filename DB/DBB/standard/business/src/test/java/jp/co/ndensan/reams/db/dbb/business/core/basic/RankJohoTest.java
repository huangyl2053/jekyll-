/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2011RankJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
//import static jp.co.ndensan.reams.db.dbb.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RankJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RankJohoTest extends DbbTestBase {

    private static DbT2011RankJohoEntity RankJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 賦課年度;
    private static RankKubun ランク区分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        賦課年度 = DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度;
        ランク区分 = DbT2011RankJohoEntityGenerator.DEFAULT_ランク区分;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static RankJoho sut;

        @Before
        public void setUp() {
            RankJohoEntity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            RankJohoEntity.setFukaNendo(賦課年度);
            RankJohoEntity.setRankKubun(ランク区分);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RankJoho(null, ランク区分);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RankJoho(賦課年度, null);
        }

        @Test
        public void 指定したキーが保持するDbT2011RankJohoEntityにセットされている() {
            sut = new RankJoho(賦課年度, ランク区分);
            assertThat(sut.get賦課年度(), is(賦課年度));
            assertThat(sut.getランク区分(), is(ランク区分));
        }

        @Test
        public void 指定したキーが保持するRankJohoIdentifierにセットされている() {
            sut = new RankJoho(賦課年度, ランク区分);
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
            assertThat(sut.identifier().getランク区分(), is(ランク区分));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static RankJoho sut;

        @Before
        public void setUp() {
            RankJohoEntity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            RankJohoEntity.setFukaNendo(賦課年度);
            RankJohoEntity.setRankKubun(ランク区分);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new RankJoho(null);
        }

        @Test
        public void 指定したDbT2011RankJohoEntityのキー情報を識別子が持つ() {

            sut = new RankJoho(RankJohoEntity);

            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
            assertThat(sut.identifier().getランク区分(), is(ランク区分));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static RankJoho sut;

        @Before
        public void setUp() {
            RankJohoEntity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            RankJohoEntity.setFukaNendo(賦課年度);
            RankJohoEntity.setRankKubun(ランク区分);

            sut = new RankJoho(RankJohoEntity);
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(RankJohoEntity.getFukaNendo()));
        }

        @Test
        public void getランク区分は_entityが持つランク区分を返す() {
            assertThat(sut.getランク区分(), is(RankJohoEntity.getRankKubun()));
        }

        @Test
        public void getランク名称は_entityが持つランク名称を返す() {
            assertThat(sut.getランク名称(), is(RankJohoEntity.getRankName()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static RankJoho sut;

        @Before
        public void setUp() {
            RankJohoEntity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            RankJohoEntity.setFukaNendo(賦課年度);
            RankJohoEntity.setRankKubun(ランク区分);

            sut = new RankJoho(RankJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(RankJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static RankJoho sut;

        @Before
        public void setUp() {
            RankJohoEntity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            RankJohoEntity.setFukaNendo(賦課年度);
            RankJohoEntity.setRankKubun(ランク区分);

            sut = new RankJoho(RankJohoEntity);
        }

        @Test
        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static RankJoho sut;
        private static RankJoho result;

        @Before
        public void setUp() {
            RankJohoEntity = DbT2011RankJohoEntityGenerator.createDbT2011RankJohoEntity();
            RankJohoEntity.setFukaNendo(賦課年度);
            RankJohoEntity.setRankKubun(ランク区分);

        }

        @Test
        public void RankJohoが保持するDbT2011RankJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりRankJohoが保持するDbT2011RankJohoEntityのEntityDataStateがDeletedに指定されたRankJohoが返る() {
            sut = TestSupport.setStateRankJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RankJohoが保持するDbT2011RankJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりRankJohoが保持するDbT2011RankJohoEntityのEntityDataStateがDeletedに指定されたRankJohoが返る() {
            sut = TestSupport.setStateRankJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RankJohoが保持するDbT2011RankJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりRankJohoが保持するDbT2011RankJohoEntityのEntityDataStateがDeletedに指定されたRankJohoが返る() {
            sut = TestSupport.setStateRankJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void RankJohoが保持するDbT2011RankJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateRankJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static RankJoho setStateRankJoho(EntityDataState parentState) {
            RankJohoEntity.setState(parentState);
            return new RankJoho(RankJohoEntity);
        }
    }
}
