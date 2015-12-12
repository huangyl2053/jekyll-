/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2009RentaiGimushaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link RentaiGimusha}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RentaiGimushaTest extends DbbTestBase {

    private static DbT2009RentaiGimushaEntity RentaiGimushaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT2009RentaiGimushaEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbT2009RentaiGimushaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static RentaiGimusha sut;

        @Before
        public void setUp() {
            RentaiGimushaEntity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            RentaiGimushaEntity.setHihokenshaNo(被保険者番号);
            RentaiGimushaEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RentaiGimusha(null, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RentaiGimusha(被保険者番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT2009RentaiGimushaEntityにセットされている() {
            sut = new RentaiGimusha(被保険者番号, 履歴番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するRentaiGimushaIdentifierにセットされている() {
            sut = new RentaiGimusha(被保険者番号, 履歴番号);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static RentaiGimusha sut;

        @Before
        public void setUp() {
            RentaiGimushaEntity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            RentaiGimushaEntity.setHihokenshaNo(被保険者番号);
            RentaiGimushaEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new RentaiGimusha(null);
        }

        @Test
        public void 指定したDbT2009RentaiGimushaEntityのキー情報を識別子が持つ() {

            sut = new RentaiGimusha(RentaiGimushaEntity);

            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static RentaiGimusha sut;

        @Before
        public void setUp() {
            RentaiGimushaEntity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            RentaiGimushaEntity.setHihokenshaNo(被保険者番号);
            RentaiGimushaEntity.setRirekiNo(履歴番号);

            sut = new RentaiGimusha(RentaiGimushaEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(RentaiGimushaEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(RentaiGimushaEntity.getRirekiNo()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(RentaiGimushaEntity.getShikibetuCode()));
        }

        @Test
        public void get開始年月日は_entityが持つ開始年月日を返す() {
            assertThat(sut.get開始年月日(), is(RentaiGimushaEntity.getStartYMD()));
        }

        @Test
        public void get終了年月日は_entityが持つ終了年月日を返す() {
            assertThat(sut.get終了年月日(), is(RentaiGimushaEntity.getEndYMD()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static RentaiGimusha sut;

        @Before
        public void setUp() {
            RentaiGimushaEntity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            RentaiGimushaEntity.setHihokenshaNo(被保険者番号);
            RentaiGimushaEntity.setRirekiNo(履歴番号);

            sut = new RentaiGimusha(RentaiGimushaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(RentaiGimushaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static RentaiGimusha sut;

        @Before
        public void setUp() {
            RentaiGimushaEntity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            RentaiGimushaEntity.setHihokenshaNo(被保険者番号);
            RentaiGimushaEntity.setRirekiNo(履歴番号);

            sut = new RentaiGimusha(RentaiGimushaEntity);
        }

        @Test
        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static RentaiGimusha sut;
        private static RentaiGimusha result;

        @Before
        public void setUp() {
            RentaiGimushaEntity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            RentaiGimushaEntity.setHihokenshaNo(被保険者番号);
            RentaiGimushaEntity.setRirekiNo(履歴番号);
        }

        @Test
        public void RentaiGimushaが保持するDbT2009RentaiGimushaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりRentaiGimushaが保持するDbT2009RentaiGimushaEntityのEntityDataStateがDeletedに指定されたRentaiGimushaが返る() {
            sut = TestSupport.setStateRentaiGimusha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RentaiGimushaが保持するDbT2009RentaiGimushaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりRentaiGimushaが保持するDbT2009RentaiGimushaEntityのEntityDataStateがDeletedに指定されたRentaiGimushaが返る() {
            sut = TestSupport.setStateRentaiGimusha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RentaiGimushaが保持するDbT2009RentaiGimushaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりRentaiGimushaが保持するDbT2009RentaiGimushaEntityのEntityDataStateがDeletedに指定されたRentaiGimushaが返る() {
            sut = TestSupport.setStateRentaiGimusha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void RentaiGimushaが保持するDbT2009RentaiGimushaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateRentaiGimusha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static RentaiGimusha setStateRentaiGimusha(EntityDataState parentState) {
            RentaiGimushaEntity.setState(parentState);
            return new RentaiGimusha(RentaiGimushaEntity);
        }
    }
}
