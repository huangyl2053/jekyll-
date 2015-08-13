/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinsei;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1013KyokaisoSochiShinseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1013KyokaisoSochiShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link KyokaisoSochiShinsei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyokaisoSochiShinseiTest extends DbzTestBase {

    private static DbT1013KyokaisoSochiShinseiEntity KyokaisoSochiShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyokaisoSochiShinsei sut;

        @Before
        public void setUp() {
            KyokaisoSochiShinseiEntity = DbT1013KyokaisoSochiShinseiEntityGenerator.createDbT1013KyokaisoSochiShinseiEntity();
            KyokaisoSochiShinseiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoSochiShinseiEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyokaisoSochiShinsei(null, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyokaisoSochiShinsei(被保険者番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT1013KyokaisoSochiShinseiEntityにセットされている() {
            sut = new KyokaisoSochiShinsei(被保険者番号, 履歴番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するKyokaisoSochiShinseiIdentifierにセットされている() {
            sut = new KyokaisoSochiShinsei(被保険者番号, 履歴番号);
//            assertThat(sut.identifier().getXXX(), is(被保険者番号));
//            assertThat(sut.identifier().getXXX(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyokaisoSochiShinsei sut;

        @Before
        public void setUp() {
            KyokaisoSochiShinseiEntity = DbT1013KyokaisoSochiShinseiEntityGenerator.createDbT1013KyokaisoSochiShinseiEntity();
            KyokaisoSochiShinseiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoSochiShinseiEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyokaisoSochiShinsei(null);
        }

        @Test
        public void 指定したDbT1013KyokaisoSochiShinseiEntityのキー情報を識別子が持つ() {

            sut = new KyokaisoSochiShinsei(KyokaisoSochiShinseiEntity);
//            assertThat(sut.identifier().getXXX(), is(被保険者番号));
//            assertThat(sut.identifier().getXXX(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyokaisoSochiShinsei sut;

        @Before
        public void setUp() {
            KyokaisoSochiShinseiEntity = DbT1013KyokaisoSochiShinseiEntityGenerator.createDbT1013KyokaisoSochiShinseiEntity();
            KyokaisoSochiShinseiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoSochiShinseiEntity.setRirekiNo(履歴番号);

            sut = new KyokaisoSochiShinsei(KyokaisoSochiShinseiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyokaisoSochiShinseiEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyokaisoSochiShinseiEntity.getRirekiNo()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(KyokaisoSochiShinseiEntity.getShinseiYMD()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(KyokaisoSochiShinseiEntity.getUketsukeYMD()));
        }

        @Test
        public void get申請_廃止区分は_entityが持つ申請_廃止区分を返す() {
            assertThat(sut.get申請_廃止区分(), is(KyokaisoSochiShinseiEntity.getShinsei_HaishiKubun()));
        }

        @Test
        public void get申請_廃止年月日は_entityが持つ申請_廃止年月日を返す() {
            assertThat(sut.get申請_廃止年月日(), is(KyokaisoSochiShinseiEntity.getShinsei_HaishiYMD()));
        }

        @Test
        public void get保護不要根拠減額金額は_entityが持つ保護不要根拠減額金額を返す() {
            assertThat(sut.get保護不要根拠減額金額(), is(KyokaisoSochiShinseiEntity.getHogoHuyoKonkyoGengakuKingaku()));
        }

        @Test
        public void get境界層証明書交付年月日は_entityが持つ境界層証明書交付年月日を返す() {
            assertThat(sut.get境界層証明書交付年月日(), is(KyokaisoSochiShinseiEntity.getKyokaisoShomeishoKofuYMD()));
        }

        @Test
        public void get給付額減額取消_減額自己負担月額は_entityが持つ給付額減額取消_減額自己負担月額を返す() {
            assertThat(sut.get給付額減額取消_減額自己負担月額(), is(KyokaisoSochiShinseiEntity.getKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku())
            );
        }

        @Test
        public void get居住費軽減_減額自己負担月額は_entityが持つ居住費軽減_減額自己負担月額を返す() {
            assertThat(sut.get居住費軽減_減額自己負担月額(), is(KyokaisoSochiShinseiEntity.getKyojuhiKeigen_GengakuJikofutanGetsugaku()));
        }

        @Test
        public void get居住費軽減_負担限度額段階コードは_entityが持つ居住費軽減_負担限度額段階コードを返す() {
            assertThat(sut.get居住費軽減_負担限度額段階コード(), is(KyokaisoSochiShinseiEntity.getKyojuhiKeigen_FutangendogakuDankaiCode()));
        }

        @Test
        public void get食費軽減_減額自己負担月額は_entityが持つ食費軽減_減額自己負担月額を返す() {
            assertThat(sut.get食費軽減_減額自己負担月額(), is(KyokaisoSochiShinseiEntity.getShokuhiKeigen_GengakuJikofutanGetsugaku()));
        }

        @Test
        public void get食費軽減_負担限度額段階コードは_entityが持つ食費軽減_負担限度額段階コードを返す() {
            assertThat(sut.get食費軽減_負担限度額段階コード(), is(KyokaisoSochiShinseiEntity.getShokuhiKeigen_FutangendogakuDankaiCode()));
        }

        @Test
        public void get利用者負担世帯合算額_減額自己負担月額は_entityが持つ利用者負担世帯合算額_減額自己負担月額を返す() {
            assertThat(sut.get利用者負担世帯合算額_減額自己負担月額(), is(KyokaisoSochiShinseiEntity.getRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku()));
        }

        @Test
        public void get保険料減額_減額自己負担月額は_entityが持つ保険料減額_減額自己負担月額を返す() {
            assertThat(sut.get保険料減額_減額自己負担月額(), is(KyokaisoSochiShinseiEntity.getHokenryoGengaku_GengakuJikofutanGetsugaku()));
        }

        @Test
        public void get減額自己負担月額合計額は_entityが持つ減額自己負担月額合計額を返す() {
            assertThat(sut.get減額自己負担月額合計額(), is(KyokaisoSochiShinseiEntity.getGengakuJikofutanGetsugakuGokeigaku()));
        }

        @Test
        public void get境界層措置決定年月日は_entityが持つ境界層措置決定年月日を返す() {
            assertThat(sut.get境界層措置決定年月日(), is(KyokaisoSochiShinseiEntity.getKyukaisoSochiKetteiYMD()));
        }

        @Test
        public void get措置該当_非該当区分は_entityが持つ措置該当_非該当区分を返す() {
            assertThat(sut.get措置該当_非該当区分(), is(KyokaisoSochiShinseiEntity.getSochiGaito_HigaitoKubun()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyokaisoSochiShinsei sut;

        @Before
        public void setUp() {
            KyokaisoSochiShinseiEntity = DbT1013KyokaisoSochiShinseiEntityGenerator.createDbT1013KyokaisoSochiShinseiEntity();
            KyokaisoSochiShinseiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoSochiShinseiEntity.setRirekiNo(履歴番号);

            sut = new KyokaisoSochiShinsei(KyokaisoSochiShinseiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyokaisoSochiShinseiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyokaisoSochiShinsei sut;

        @Before
        public void setUp() {
            KyokaisoSochiShinseiEntity = DbT1013KyokaisoSochiShinseiEntityGenerator.createDbT1013KyokaisoSochiShinseiEntity();
            KyokaisoSochiShinseiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoSochiShinseiEntity.setRirekiNo(履歴番号);

            sut = new KyokaisoSochiShinsei(KyokaisoSochiShinseiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyokaisoSochiShinsei sut;
        private static KyokaisoSochiShinsei result;

        @Before
        public void setUp() {
            KyokaisoSochiShinseiEntity = DbT1013KyokaisoSochiShinseiEntityGenerator.createDbT1013KyokaisoSochiShinseiEntity();
            KyokaisoSochiShinseiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoSochiShinseiEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void KyokaisoSochiShinseiが保持するDbT1013KyokaisoSochiShinseiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyokaisoSochiShinseiが保持するDbT1013KyokaisoSochiShinseiEntityのEntityDataStateがDeletedに指定されたKyokaisoSochiShinseiが返る() {
            sut = TestSupport.setStateKyokaisoSochiShinsei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyokaisoSochiShinseiが保持するDbT1013KyokaisoSochiShinseiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyokaisoSochiShinseiが保持するDbT1013KyokaisoSochiShinseiEntityのEntityDataStateがDeletedに指定されたKyokaisoSochiShinseiが返る() {
            sut = TestSupport.setStateKyokaisoSochiShinsei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyokaisoSochiShinseiが保持するDbT1013KyokaisoSochiShinseiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyokaisoSochiShinseiが保持するDbT1013KyokaisoSochiShinseiEntityのEntityDataStateがDeletedに指定されたKyokaisoSochiShinseiが返る() {
            sut = TestSupport.setStateKyokaisoSochiShinsei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyokaisoSochiShinseiが保持するDbT1013KyokaisoSochiShinseiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyokaisoSochiShinsei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyokaisoSochiShinsei setStateKyokaisoSochiShinsei(EntityDataState parentState) {
            KyokaisoSochiShinseiEntity.setState(parentState);
            return new KyokaisoSochiShinsei(KyokaisoSochiShinseiEntity);
        }
    }
}
