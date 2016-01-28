/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.gemmen.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2004GemmenEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
//import static jp.co.ndensan.reams.db.dbb.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link Gemmen}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class GemmenTest extends DbbTestBase {

    private static DbT2004GemmenEntity GemmenEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 調停年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        調停年度 = DbT2004GemmenEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2004GemmenEntityGenerator.DEFAULT_賦課年度;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static Gemmen sut;

        @Before
        public void setUp() {
            GemmenEntity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            GemmenEntity.setChoteiNendo(調停年度);
            GemmenEntity.setFukaNendo(賦課年度);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Gemmen(null, 賦課年度, 通知書番号, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Gemmen(調停年度, null, 通知書番号, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT2004GemmenEntityにセットされている() {
            sut = new Gemmen(調停年度, 賦課年度, 通知書番号, 履歴番号);
            assertThat(sut.get調定年度(), is(調停年度));
            assertThat(sut.get賦課年度(), is(賦課年度));
        }

        @Test
        public void 指定したキーが保持するGemmenIdentifierにセットされている() {
            sut = new Gemmen(調停年度, 賦課年度, 通知書番号, 履歴番号);
            assertThat(sut.identifier().get調定年度(), is(調停年度));
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static Gemmen sut;

        @Before
        public void setUp() {
            GemmenEntity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            GemmenEntity.setChoteiNendo(調停年度);
            GemmenEntity.setFukaNendo(賦課年度);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new Gemmen(null);
        }

        @Test
        public void 指定したDbT2004GemmenEntityのキー情報を識別子が持つ() {

            sut = new Gemmen(GemmenEntity);

            assertThat(sut.identifier().get調定年度(), is(調停年度));
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static Gemmen sut;

        @Before
        public void setUp() {
            GemmenEntity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            GemmenEntity.setChoteiNendo(調停年度);
            GemmenEntity.setFukaNendo(賦課年度);

            sut = new Gemmen(GemmenEntity);
        }

        @Test
        public void get調定年度は_entityが持つ調定年度を返す() {
            assertThat(sut.get調定年度(), is(GemmenEntity.getChoteiNendo()));
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(GemmenEntity.getFukaNendo()));
        }

        @Test
        public void get通知書番号は_entityが持つ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(GemmenEntity.getTsuchishoNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(GemmenEntity.getRirekiNo()));
        }

        @Test
        public void get減免申請日は_entityが持つ減免申請日を返す() {
            assertThat(sut.get減免申請日(), is(GemmenEntity.getShinseiYMD()));
        }

        @Test
        public void get減免決定日は_entityが持つ減免決定日を返す() {
            assertThat(sut.get減免決定日(), is(GemmenEntity.getKetteiYMD()));
        }

        @Test
        public void get減免取消日は_entityが持つ減免取消日を返す() {
            assertThat(sut.get減免取消日(), is(GemmenEntity.getTorikeshiYMD()));
        }

        @Test
        public void get減免状態区分は_entityが持つ減免状態区分を返す() {
            assertThat(sut.get減免状態区分(), is(GemmenEntity.getJotaiKubun()));
        }

        @Test
        public void get減免作成区分は_entityが持つ減免作成区分を返す() {
            assertThat(sut.get減免作成区分(), is(GemmenEntity.getSakuseiKubun()));
        }

        @Test
        public void get申請事由は_entityが持つ申請事由を返す() {
            assertThat(sut.get申請事由(), is(GemmenEntity.getShinseiJiyu()));
        }

        @Test
        public void get減免種類コードは_entityが持つ減免種類コードを返す() {
            assertThat(sut.get減免種類コード(), is(GemmenEntity.getGemmenJiyuCode()));
        }

        @Test
        public void get減免事由は_entityが持つ減免事由を返す() {
            assertThat(sut.get減免事由(), is(GemmenEntity.getGemmenJiyu()));
        }

        @Test
        public void get減免取消種類コードは_entityが持つ減免取消種類コードを返す() {
            assertThat(sut.get減免取消種類コード(), is(GemmenEntity.getGemmenTorikeshiJiyuCode()));
        }

        @Test
        public void get減免取消事由は_entityが持つ減免取消事由を返す() {
            assertThat(sut.get減免取消事由(), is(GemmenEntity.getGemmenTorikeshiJiyu()));
        }

        @Test
        public void get申請減免額は_entityが持つ申請減免額を返す() {
            assertThat(sut.get申請減免額(), is(GemmenEntity.getShinseiGemmenGaku()));
        }

        @Test
        public void get決定減免額は_entityが持つ決定減免額を返す() {
            assertThat(sut.get決定減免額(), is(GemmenEntity.getKetteiGemmenGaku()));
        }

        @Test
        public void get取消減免額は_entityが持つ取消減免額を返す() {
            assertThat(sut.get取消減免額(), is(GemmenEntity.getTorikeshiGemmenGaku()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static Gemmen sut;

        @Before
        public void setUp() {
            GemmenEntity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            GemmenEntity.setChoteiNendo(調停年度);
            GemmenEntity.setFukaNendo(賦課年度);

            sut = new Gemmen(GemmenEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(GemmenEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static Gemmen sut;

        @Before
        public void setUp() {
            GemmenEntity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            GemmenEntity.setChoteiNendo(調停年度);
            GemmenEntity.setFukaNendo(賦課年度);

            sut = new Gemmen(GemmenEntity);
        }

        @Test
        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static Gemmen sut;
        private static Gemmen result;

        @Before
        public void setUp() {
            GemmenEntity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            GemmenEntity.setChoteiNendo(調停年度);
            GemmenEntity.setFukaNendo(賦課年度);

        }

        @Test
        public void Gemmenが保持するDbT2004GemmenEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりGemmenが保持するDbT2004GemmenEntityのEntityDataStateがDeletedに指定されたGemmenが返る() {
            sut = TestSupport.setStateGemmen(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Gemmenが保持するDbT2004GemmenEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりGemmenが保持するDbT2004GemmenEntityのEntityDataStateがDeletedに指定されたGemmenが返る() {
            sut = TestSupport.setStateGemmen(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Gemmenが保持するDbT2004GemmenEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりGemmenが保持するDbT2004GemmenEntityのEntityDataStateがDeletedに指定されたGemmenが返る() {
            sut = TestSupport.setStateGemmen(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void Gemmenが保持するDbT2004GemmenEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateGemmen(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static Gemmen setStateGemmen(EntityDataState parentState) {
            GemmenEntity.setState(parentState);
            return new Gemmen(GemmenEntity);
        }
    }
}
