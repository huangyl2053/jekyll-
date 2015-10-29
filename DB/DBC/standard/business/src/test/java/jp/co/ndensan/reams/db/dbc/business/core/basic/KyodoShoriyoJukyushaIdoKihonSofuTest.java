/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
import org.junit.Ignore;

/**
 * {@link KyodoShoriyoJukyushaIdoKihonSofu}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyodoShoriyoJukyushaIdoKihonSofuTest extends DbcTestBase {

    private static DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity KyodoShoriyoJukyushaIdoKihonSofuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleDate 主キー名1;
    private static RString 主キー名2;
    private static RString 主キー名3;
    private static HokenshaNo 主キー名4;
    private static HihokenshaNo 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_異動年月日;
        主キー名2 = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_異動区分コード;
        主キー名3 = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_受給者異動事由;
        主キー名4 = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKihonSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKihonSofuEntity = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.createDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoKubunCode(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyodoShoriyoJukyushaIdoKihonSofu(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyodoShoriyoJukyushaIdoKihonSofu(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityにセットされている() {
            sut = new KyodoShoriyoJukyushaIdoKihonSofu(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get異動年月日(), is(主キー名1));
            assertThat(sut.get異動区分コード(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyodoShoriyoJukyushaIdoKihonSofuIdentifierにセットされている() {
            sut = new KyodoShoriyoJukyushaIdoKihonSofu(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get異動年月日(), is(主キー名1));
            assertThat(sut.identifier().get異動区分コード(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKihonSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKihonSofuEntity = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.createDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoKubunCode(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyodoShoriyoJukyushaIdoKihonSofu(null);
        }

        @Test
        public void 指定したDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityのキー情報を識別子が持つ() {

            sut = new KyodoShoriyoJukyushaIdoKihonSofu(KyodoShoriyoJukyushaIdoKihonSofuEntity);

            assertThat(sut.identifier().get異動年月日(), is(主キー名1));
            assertThat(sut.identifier().get異動区分コード(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKihonSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKihonSofuEntity = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.createDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoKubunCode(主キー名2);

            sut = new KyodoShoriyoJukyushaIdoKihonSofu(KyodoShoriyoJukyushaIdoKihonSofuEntity);
        }

        @Test
        public void get異動年月日は_entityが持つ異動年月日を返す() {
            assertThat(sut.get異動年月日(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getIdoYMD()));
        }

        @Test
        public void get異動区分コードは_entityが持つ異動区分コードを返す() {
            assertThat(sut.get異動区分コード(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getIdoKubunCode()));
        }

        @Test
        public void get受給者異動事由は_entityが持つ受給者異動事由を返す() {
            assertThat(sut.get受給者異動事由(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getJukyushaIdoJiyu()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getHiHokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getRirekiNo()));
        }

        @Test
        public void get被保険者氏名は_entityが持つ被保険者氏名を返す() {
            assertThat(sut.get被保険者氏名(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getHiHokenshaName()));
        }

        @Test
        public void get郵便番号は_entityが持つ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getYubinNo()));
        }

        @Test
        public void get住所カナは_entityが持つ住所カナを返す() {
            assertThat(sut.get住所カナ(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getDdressKana()));
        }

        @Test
        public void get住所は_entityが持つ住所を返す() {
            assertThat(sut.get住所(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getAddress()));
        }

        @Test
        public void get電話番号は_entityが持つ電話番号を返す() {
            assertThat(sut.get電話番号(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getTelNo()));
        }

        @Test
        public void get帳票出力順序コードは_entityが持つ帳票出力順序コードを返す() {
            assertThat(sut.get帳票出力順序コード(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getChohyoOutputJunjyoCode()));
        }

        @Test
        public void get訂正連絡票フラグは_entityが持つ訂正連絡票フラグを返す() {
            assertThat(sut.get訂正連絡票フラグ(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getTeiseiRenrakuhyoFlag()));
        }

        @Test
        public void get送付年月は_entityが持つ送付年月を返す() {
            assertThat(sut.get送付年月(), is(KyodoShoriyoJukyushaIdoKihonSofuEntity.getSofuYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKihonSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKihonSofuEntity = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.createDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoKubunCode(主キー名2);

            sut = new KyodoShoriyoJukyushaIdoKihonSofu(KyodoShoriyoJukyushaIdoKihonSofuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyodoShoriyoJukyushaIdoKihonSofuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKihonSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKihonSofuEntity = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.createDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoKubunCode(主キー名2);

            sut = new KyodoShoriyoJukyushaIdoKihonSofu(KyodoShoriyoJukyushaIdoKihonSofuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKihonSofu sut;
        private static KyodoShoriyoJukyushaIdoKihonSofu result;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKihonSofuEntity = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.createDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setIdoKubunCode(主キー名2);

        }

        @Test
        public void KyodoShoriyoJukyushaIdoKihonSofuが保持するDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyodoShoriyoJukyushaIdoKihonSofuが保持するDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityのEntityDataStateがDeletedに指定されたKyodoShoriyoJukyushaIdoKihonSofuが返る() {
            sut = TestSupport.setStateKyodoShoriyoJukyushaIdoKihonSofu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyodoShoriyoJukyushaIdoKihonSofuが保持するDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyodoShoriyoJukyushaIdoKihonSofuが保持するDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityのEntityDataStateがDeletedに指定されたKyodoShoriyoJukyushaIdoKihonSofuが返る() {
            sut = TestSupport.setStateKyodoShoriyoJukyushaIdoKihonSofu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyodoShoriyoJukyushaIdoKihonSofuが保持するDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyodoShoriyoJukyushaIdoKihonSofuが保持するDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityのEntityDataStateがDeletedに指定されたKyodoShoriyoJukyushaIdoKihonSofuが返る() {
            sut = TestSupport.setStateKyodoShoriyoJukyushaIdoKihonSofu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyodoShoriyoJukyushaIdoKihonSofuが保持するDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyodoShoriyoJukyushaIdoKihonSofu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyodoShoriyoJukyushaIdoKihonSofu setStateKyodoShoriyoJukyushaIdoKihonSofu(EntityDataState parentState) {
            KyodoShoriyoJukyushaIdoKihonSofuEntity.setState(parentState);
            return new KyodoShoriyoJukyushaIdoKihonSofu(KyodoShoriyoJukyushaIdoKihonSofuEntity);
        }
    }
}
