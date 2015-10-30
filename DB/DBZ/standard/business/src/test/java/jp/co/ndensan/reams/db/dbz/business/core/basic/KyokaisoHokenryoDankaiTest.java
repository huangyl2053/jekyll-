/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoHokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1007KyokaisoHokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link KyokaisoHokenryoDankai}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KyokaisoHokenryoDankaiTest extends DbzTestBase {

    private static DbT1007KyokaisoHokenryoDankaiEntity KyokaisoHokenryoDankaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static Decimal 履歴番号;
    private static FlexibleYearMonth 適用開始年月日;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_履歴番号;
        適用開始年月日 = DbT1007KyokaisoHokenryoDankaiEntityGenerator.DEFAULT_適用開始年月;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyokaisoHokenryoDankai sut;

        @Before
        public void setUp() {
            KyokaisoHokenryoDankaiEntity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            KyokaisoHokenryoDankaiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoHokenryoDankaiEntity.setRirekiNo(履歴番号);
            KyokaisoHokenryoDankaiEntity.setTekiyoKaishiYM(適用開始年月日);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyokaisoHokenryoDankai(null, 履歴番号, 適用開始年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyokaisoHokenryoDankai(被保険者番号, null, 適用開始年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 適用開始年月日がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyokaisoHokenryoDankai(被保険者番号, 履歴番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT1007KyokaisoHokenryoDankaiEntityにセットされている() {
            sut = new KyokaisoHokenryoDankai(被保険者番号, 履歴番号, 適用開始年月日);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get履歴番号(), is(履歴番号));
            assertThat(sut.get適用開始年月(), is(適用開始年月日));
        }

        @Test
        public void 指定したキーが保持するKyokaisoHokenryoDankaiIdentifierにセットされている() {
            sut = new KyokaisoHokenryoDankai(被保険者番号, 履歴番号, 適用開始年月日);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
            assertThat(sut.identifier().get適用開始年月(), is(適用開始年月日));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyokaisoHokenryoDankai sut;

        @Before
        public void setUp() {
            KyokaisoHokenryoDankaiEntity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            KyokaisoHokenryoDankaiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoHokenryoDankaiEntity.setRirekiNo(履歴番号);
            KyokaisoHokenryoDankaiEntity.setTekiyoKaishiYM(適用開始年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyokaisoHokenryoDankai(null);
        }

        @Test
        public void 指定したDbT1007KyokaisoHokenryoDankaiEntityのキー情報を識別子が持つ() {

            sut = new KyokaisoHokenryoDankai(KyokaisoHokenryoDankaiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
            assertThat(sut.identifier().get適用開始年月(), is(適用開始年月日));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyokaisoHokenryoDankai sut;

        @Before
        public void setUp() {
            KyokaisoHokenryoDankaiEntity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            KyokaisoHokenryoDankaiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoHokenryoDankaiEntity.setRirekiNo(履歴番号);
            KyokaisoHokenryoDankaiEntity.setTekiyoKaishiYM(適用開始年月日);

            sut = new KyokaisoHokenryoDankai(KyokaisoHokenryoDankaiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyokaisoHokenryoDankaiEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyokaisoHokenryoDankaiEntity.getRirekiNo()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(KyokaisoHokenryoDankaiEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(KyokaisoHokenryoDankaiEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void get保険料納付減額後保険料段階は_entityが持つ保険料納付減額後保険料段階を返す() {
            assertThat(sut.get保険料納付減額後保険料段階(), is(KyokaisoHokenryoDankaiEntity.getGengakuGoHokenryoDankai()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyokaisoHokenryoDankai sut;

        @Before
        public void setUp() {
            KyokaisoHokenryoDankaiEntity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            KyokaisoHokenryoDankaiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoHokenryoDankaiEntity.setRirekiNo(履歴番号);
            KyokaisoHokenryoDankaiEntity.setTekiyoKaishiYM(適用開始年月日);

            sut = new KyokaisoHokenryoDankai(KyokaisoHokenryoDankaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyokaisoHokenryoDankaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyokaisoHokenryoDankai sut;

        @Before
        public void setUp() {
            KyokaisoHokenryoDankaiEntity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            KyokaisoHokenryoDankaiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoHokenryoDankaiEntity.setRirekiNo(履歴番号);
            KyokaisoHokenryoDankaiEntity.setTekiyoKaishiYM(適用開始年月日);

            sut = new KyokaisoHokenryoDankai(KyokaisoHokenryoDankaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyokaisoHokenryoDankai sut;
        private static KyokaisoHokenryoDankai result;

        @Before
        public void setUp() {
            KyokaisoHokenryoDankaiEntity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            KyokaisoHokenryoDankaiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoHokenryoDankaiEntity.setRirekiNo(履歴番号);
            KyokaisoHokenryoDankaiEntity.setTekiyoKaishiYM(適用開始年月日);

        }

        @Test
        public void KyokaisoHokenryoDankaiが保持するDbT1007KyokaisoHokenryoDankaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyokaisoHokenryoDankaiが保持するDbT1007KyokaisoHokenryoDankaiEntityのEntityDataStateがDeletedに指定されたKyokaisoHokenryoDankaiが返る() {
            sut = TestSupport.setStateKyokaisoHokenryoDankai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyokaisoHokenryoDankaiが保持するDbT1007KyokaisoHokenryoDankaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyokaisoHokenryoDankaiが保持するDbT1007KyokaisoHokenryoDankaiEntityのEntityDataStateがDeletedに指定されたKyokaisoHokenryoDankaiが返る() {
            sut = TestSupport.setStateKyokaisoHokenryoDankai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyokaisoHokenryoDankaiが保持するDbT1007KyokaisoHokenryoDankaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyokaisoHokenryoDankaiが保持するDbT1007KyokaisoHokenryoDankaiEntityのEntityDataStateがDeletedに指定されたKyokaisoHokenryoDankaiが返る() {
            sut = TestSupport.setStateKyokaisoHokenryoDankai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyokaisoHokenryoDankaiが保持するDbT1007KyokaisoHokenryoDankaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyokaisoHokenryoDankai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyokaisoHokenryoDankai setStateKyokaisoHokenryoDankai(EntityDataState parentState) {
            KyokaisoHokenryoDankaiEntity.setState(parentState);
            return new KyokaisoHokenryoDankai(KyokaisoHokenryoDankaiEntity);
        }
    }
}
