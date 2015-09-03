/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
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

/**
 * {@link KyodoShoriyoJukyushaIdoKogakuSofu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyodoShoriyoJukyushaIdoKogakuSofuTest extends DbcTestBase {

    private static DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity KyodoShoriyoJukyushaIdoKogakuSofuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        主キー名1 = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.DEFAULT_異動年月日;
        主キー名2 = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.DEFAULT_異動区分コード;
        主キー名3 = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.DEFAULT_受給者異動事由;
        主キー名4 = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKogakuSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKogakuSofuEntity = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.createDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity();
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setIdoKubunCode(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyodoShoriyoJukyushaIdoKogakuSofu(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyodoShoriyoJukyushaIdoKogakuSofu(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityにセットされている() {
            sut = new KyodoShoriyoJukyushaIdoKogakuSofu(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get異動年月日(), is(主キー名1));
            assertThat(sut.get異動区分コード(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyodoShoriyoJukyushaIdoKogakuSofuIdentifierにセットされている() {
            sut = new KyodoShoriyoJukyushaIdoKogakuSofu(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get異動年月日(), is(主キー名1));
            assertThat(sut.identifier().get異動区分コード(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKogakuSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKogakuSofuEntity = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.createDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity();
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setIdoKubunCode(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyodoShoriyoJukyushaIdoKogakuSofu(null);
        }

        @Test
        public void 指定したDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityのキー情報を識別子が持つ() {

            sut = new KyodoShoriyoJukyushaIdoKogakuSofu(KyodoShoriyoJukyushaIdoKogakuSofuEntity);

            assertThat(sut.identifier().get異動年月日(), is(主キー名1));
            assertThat(sut.identifier().get異動区分コード(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKogakuSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKogakuSofuEntity = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.createDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity();
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setIdoKubunCode(主キー名2);

            sut = new KyodoShoriyoJukyushaIdoKogakuSofu(KyodoShoriyoJukyushaIdoKogakuSofuEntity);
        }

        @Test
        public void get異動年月日は_entityが持つ異動年月日を返す() {
            assertThat(sut.get異動年月日(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getIdoYMD()));
        }

        @Test
        public void get異動区分コードは_entityが持つ異動区分コードを返す() {
            assertThat(sut.get異動区分コード(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getIdoKubunCode()));
        }

        @Test
        public void get受給者異動事由は_entityが持つ受給者異動事由を返す() {
            assertThat(sut.get受給者異動事由(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getJukyushaIdoJiyu()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getHiHokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getRirekiNo()));
        }

        @Test
        public void get世帯集約番号は_entityが持つ世帯集約番号を返す() {
            assertThat(sut.get世帯集約番号(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getSetaiShuyakuNo()));
        }

        @Test
        public void get世帯所得区分コードは_entityが持つ世帯所得区分コードを返す() {
            assertThat(sut.get世帯所得区分コード(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getSetaiShotokuKubunCode()));
        }

        @Test
        public void get所得区分コードは_entityが持つ所得区分コードを返す() {
            assertThat(sut.get所得区分コード(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getShotokuKubunCode()));
        }

        @Test
        public void get老齢福祉年金受給有フラグは_entityが持つ老齢福祉年金受給有フラグを返す() {
            assertThat(sut.get老齢福祉年金受給有フラグ(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getRoureiFukushiNenkinJukyuAriFlag()));
        }

        @Test
        public void get利用者負担第２段階有フラグは_entityが持つ利用者負担第２段階有フラグを返す() {
            assertThat(sut.get利用者負担第２段階有フラグ(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getRiyoshaFutan2DankaiAriFlag()));
        }

        @Test
        public void get支給申請書出力有フラグは_entityが持つ支給申請書出力有フラグを返す() {
            assertThat(sut.get支給申請書出力有フラグ(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getShikyuShinseishoOutputAriFlag()));
        }

        @Test
        public void get訂正連絡票フラグは_entityが持つ訂正連絡票フラグを返す() {
            assertThat(sut.get訂正連絡票フラグ(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getTeiseiRenrakuhyoFlag()));
        }

        @Test
        public void get送付年月は_entityが持つ送付年月を返す() {
            assertThat(sut.get送付年月(), is(KyodoShoriyoJukyushaIdoKogakuSofuEntity.getSofuYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKogakuSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKogakuSofuEntity = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.createDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity();
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setIdoKubunCode(主キー名2);

            sut = new KyodoShoriyoJukyushaIdoKogakuSofu(KyodoShoriyoJukyushaIdoKogakuSofuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyodoShoriyoJukyushaIdoKogakuSofuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKogakuSofu sut;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKogakuSofuEntity = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.createDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity();
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setIdoKubunCode(主キー名2);

            sut = new KyodoShoriyoJukyushaIdoKogakuSofu(KyodoShoriyoJukyushaIdoKogakuSofuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyodoShoriyoJukyushaIdoKogakuSofu sut;
        private static KyodoShoriyoJukyushaIdoKogakuSofu result;

        @Before
        public void setUp() {
            KyodoShoriyoJukyushaIdoKogakuSofuEntity = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.createDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity();
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setIdoYMD(主キー名1);
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setIdoKubunCode(主キー名2);

        }

        @Test
        public void KyodoShoriyoJukyushaIdoKogakuSofuが保持するDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyodoShoriyoJukyushaIdoKogakuSofuが保持するDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityのEntityDataStateがDeletedに指定されたKyodoShoriyoJukyushaIdoKogakuSofuが返る() {
            sut = TestSupport.setStateKyodoShoriyoJukyushaIdoKogakuSofu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyodoShoriyoJukyushaIdoKogakuSofuが保持するDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyodoShoriyoJukyushaIdoKogakuSofuが保持するDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityのEntityDataStateがDeletedに指定されたKyodoShoriyoJukyushaIdoKogakuSofuが返る() {
            sut = TestSupport.setStateKyodoShoriyoJukyushaIdoKogakuSofu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyodoShoriyoJukyushaIdoKogakuSofuが保持するDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyodoShoriyoJukyushaIdoKogakuSofuが保持するDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityのEntityDataStateがDeletedに指定されたKyodoShoriyoJukyushaIdoKogakuSofuが返る() {
            sut = TestSupport.setStateKyodoShoriyoJukyushaIdoKogakuSofu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyodoShoriyoJukyushaIdoKogakuSofuが保持するDbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyodoShoriyoJukyushaIdoKogakuSofu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyodoShoriyoJukyushaIdoKogakuSofu setStateKyodoShoriyoJukyushaIdoKogakuSofu(EntityDataState parentState) {
            KyodoShoriyoJukyushaIdoKogakuSofuEntity.setState(parentState);
            return new KyodoShoriyoJukyushaIdoKogakuSofu(KyodoShoriyoJukyushaIdoKogakuSofuEntity);
        }
    }
}
