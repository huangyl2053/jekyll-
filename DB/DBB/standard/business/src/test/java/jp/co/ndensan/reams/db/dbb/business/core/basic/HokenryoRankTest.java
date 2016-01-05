/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2012HokenryoRankEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {@link HokenryoRank}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HokenryoRankTest extends DbbTestBase {

    private static DbT2012HokenryoRankEntity HokenryoRankEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 賦課年度;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        賦課年度 = DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度;
        市町村コード = DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static HokenryoRank sut;

        @Before
        public void setUp() {
            HokenryoRankEntity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            HokenryoRankEntity.setFukaNendo(賦課年度);
            HokenryoRankEntity.setShichosonCode(市町村コード);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HokenryoRank(null, 市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HokenryoRank(賦課年度, null);
        }

        @Test
        public void 指定したキーが保持するDbT2012HokenryoRankEntityにセットされている() {
            sut = new HokenryoRank(賦課年度, 市町村コード);
            assertThat(sut.get賦課年度(), is(賦課年度));
            assertThat(sut.get市町村コード(), is(市町村コード));
        }

        @Test
        public void 指定したキーが保持するHokenryoRankIdentifierにセットされている() {
            sut = new HokenryoRank(賦課年度, 市町村コード);
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static HokenryoRank sut;

        @Before
        public void setUp() {
            HokenryoRankEntity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            HokenryoRankEntity.setFukaNendo(賦課年度);
            HokenryoRankEntity.setShichosonCode(市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new HokenryoRank(null);
        }

        @Test
        public void 指定したDbT2012HokenryoRankEntityのキー情報を識別子が持つ() {

            sut = new HokenryoRank(HokenryoRankEntity);

            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static HokenryoRank sut;

        @Before
        public void setUp() {
            HokenryoRankEntity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            HokenryoRankEntity.setFukaNendo(賦課年度);
            HokenryoRankEntity.setShichosonCode(市町村コード);

            sut = new HokenryoRank(HokenryoRankEntity);
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(HokenryoRankEntity.getFukaNendo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(HokenryoRankEntity.getShichosonCode()));
        }

        @Test
        public void getランク区分は_entityが持つランク区分を返す() {
            assertThat(sut.getランク区分(), is(HokenryoRankEntity.getRankKubun()));
        }

        @Test
        public void get遡及年度は_entityが持つ遡及年度を返す() {
            assertThat(sut.get遡及年度(), is(HokenryoRankEntity.getSokyuNendo()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static HokenryoRank sut;

        @Before
        public void setUp() {
            HokenryoRankEntity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            HokenryoRankEntity.setFukaNendo(賦課年度);
            HokenryoRankEntity.setShichosonCode(市町村コード);

            sut = new HokenryoRank(HokenryoRankEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(HokenryoRankEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static HokenryoRank sut;

        @Before
        public void setUp() {
            HokenryoRankEntity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            HokenryoRankEntity.setFukaNendo(賦課年度);
            HokenryoRankEntity.setShichosonCode(市町村コード);

            sut = new HokenryoRank(HokenryoRankEntity);
        }

        @Test
        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static HokenryoRank sut;
        private static HokenryoRank result;

        @Before
        public void setUp() {
            HokenryoRankEntity = DbT2012HokenryoRankEntityGenerator.createDbT2012HokenryoRankEntity();
            HokenryoRankEntity.setFukaNendo(賦課年度);
            HokenryoRankEntity.setShichosonCode(市町村コード);
        }

        @Test
        public void HokenryoRankが保持するDbT2012HokenryoRankEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりHokenryoRankが保持するDbT2012HokenryoRankEntityのEntityDataStateがDeletedに指定されたHokenryoRankが返る() {
            sut = TestSupport.setStateHokenryoRank(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void HokenryoRankが保持するDbT2012HokenryoRankEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりHokenryoRankが保持するDbT2012HokenryoRankEntityのEntityDataStateがDeletedに指定されたHokenryoRankが返る() {
            sut = TestSupport.setStateHokenryoRank(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void HokenryoRankが保持するDbT2012HokenryoRankEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりHokenryoRankが保持するDbT2012HokenryoRankEntityのEntityDataStateがDeletedに指定されたHokenryoRankが返る() {
            sut = TestSupport.setStateHokenryoRank(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void HokenryoRankが保持するDbT2012HokenryoRankEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateHokenryoRank(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static HokenryoRank setStateHokenryoRank(EntityDataState parentState) {
            HokenryoRankEntity.setState(parentState);
            return new HokenryoRank(HokenryoRankEntity);
        }
    }
}
