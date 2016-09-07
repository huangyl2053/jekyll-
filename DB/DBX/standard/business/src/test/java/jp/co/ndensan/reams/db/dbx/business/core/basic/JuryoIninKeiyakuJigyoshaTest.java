/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7061JuryoIninJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.ServiceShubetsuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link JuryoIninKeiyakuJigyosha}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class JuryoIninKeiyakuJigyoshaTest extends DbxTestBase {

    private static DbT7061JuryoIninJigyoshaEntity JuryoIninKeiyakuJigyoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static JigyoshaNo 主キー名1;
    private static FlexibleDate 主キー名2;
    private static ServiceShubetsuCode 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約事業者番号;
        主キー名2 = DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約開始日;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static JuryoIninKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoIninKeiyakuJigyoshaEntity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            JuryoIninKeiyakuJigyoshaEntity.setJigyoshaNo(主キー名1);
            JuryoIninKeiyakuJigyoshaEntity.setKeiyakuKaishiYMD(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JuryoIninKeiyakuJigyosha(null, 主キー名2, RString.EMPTY);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JuryoIninKeiyakuJigyosha(主キー名1, null, RString.EMPTY);
        }

        @Test
        public void 指定したキーが保持するDbT7061JuryoIninJigyoshaEntityにセットされている() {
            sut = new JuryoIninKeiyakuJigyosha(主キー名1, 主キー名2, RString.EMPTY);
            assertThat(sut.get受領委任契約事業者番号(), is(主キー名1));
            assertThat(sut.get受領委任契約開始日(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJuryoIninKeiyakuJigyoshaIdentifierにセットされている() {
            sut = new JuryoIninKeiyakuJigyosha(主キー名1, 主キー名2, RString.EMPTY);
            assertThat(sut.identifier().get受領委任契約事業者番号(), is(主キー名1));
            assertThat(sut.identifier().get受領委任契約開始日(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static JuryoIninKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoIninKeiyakuJigyoshaEntity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            JuryoIninKeiyakuJigyoshaEntity.setJigyoshaNo(主キー名1);
            JuryoIninKeiyakuJigyoshaEntity.setKeiyakuKaishiYMD(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JuryoIninKeiyakuJigyosha(null);
        }

        @Test
        public void 指定したDbT7061JuryoIninJigyoshaEntityのキー情報を識別子が持つ() {

            sut = new JuryoIninKeiyakuJigyosha(JuryoIninKeiyakuJigyoshaEntity);
            JuryoIninKeiyakuJigyoshaEntity.setJigyoshaNo(主キー名1);
            JuryoIninKeiyakuJigyoshaEntity.setKeiyakuKaishiYMD(主キー名2);
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static JuryoIninKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoIninKeiyakuJigyoshaEntity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            JuryoIninKeiyakuJigyoshaEntity.setJigyoshaNo(主キー名1);
            JuryoIninKeiyakuJigyoshaEntity.setKeiyakuKaishiYMD(主キー名2);

            sut = new JuryoIninKeiyakuJigyosha(JuryoIninKeiyakuJigyoshaEntity);
        }

        @Test
        public void get受領委任契約事業者番号は_entityが持つ受領委任契約事業者番号を返す() {
            assertThat(sut.get受領委任契約事業者番号(), is(JuryoIninKeiyakuJigyoshaEntity.getJigyoshaNo()));
        }

        @Test
        public void get受領委任契約開始日は_entityが持つ受領委任契約開始日を返す() {
            assertThat(sut.get受領委任契約開始日(), is(JuryoIninKeiyakuJigyoshaEntity.getKeiyakuKaishiYMD()));
        }

        @Test
        public void get受領委任契約終了日は_entityが持つ受領委任契約終了日を返す() {
            assertThat(sut.get受領委任契約終了日(), is(JuryoIninKeiyakuJigyoshaEntity.getKeiyakuShuryoYMD()));
        }

        @Test
        public void get契約サービス種別は_entityが持つ契約サービス種別を返す() {
            assertThat(sut.get契約サービス種別(), is(JuryoIninKeiyakuJigyoshaEntity.getServiceShubetsuCode()));
        }

        @Test
        public void get契約事業者郵便番号は_entityが持つ契約事業者郵便番号を返す() {
            assertThat(sut.get契約事業者郵便番号(), is(JuryoIninKeiyakuJigyoshaEntity.getJigyoshaYubinNo()));
        }

        @Test
        public void get契約事業者住所は_entityが持つ契約事業者住所を返す() {
            assertThat(sut.get契約事業者住所(), is(JuryoIninKeiyakuJigyoshaEntity.getJigyoshaJusho()));
        }

        @Test
        public void get契約事業者電話番号は_entityが持つ契約事業者電話番号を返す() {
            assertThat(sut.get契約事業者電話番号(), is(JuryoIninKeiyakuJigyoshaEntity.getJigyoshaTelNo()));
        }

        @Test
        public void get契約事業者FAX番号は_entityが持つ契約事業者FAX番号を返す() {
            assertThat(sut.get契約事業者FAX番号(), is(JuryoIninKeiyakuJigyoshaEntity.getJigyoshaFaxNo()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static JuryoIninKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoIninKeiyakuJigyoshaEntity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            JuryoIninKeiyakuJigyoshaEntity.setJigyoshaNo(主キー名1);
            JuryoIninKeiyakuJigyoshaEntity.setKeiyakuKaishiYMD(主キー名2);

            sut = new JuryoIninKeiyakuJigyosha(JuryoIninKeiyakuJigyoshaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JuryoIninKeiyakuJigyoshaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static JuryoIninKeiyakuJigyosha sut;

        @Before
        public void setUp() {
            JuryoIninKeiyakuJigyoshaEntity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            JuryoIninKeiyakuJigyoshaEntity.setJigyoshaNo(主キー名1);
            JuryoIninKeiyakuJigyoshaEntity.setKeiyakuKaishiYMD(主キー名2);

            sut = new JuryoIninKeiyakuJigyosha(JuryoIninKeiyakuJigyoshaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static JuryoIninKeiyakuJigyosha sut;
        private static JuryoIninKeiyakuJigyosha result;

        @Before
        public void setUp() {
            JuryoIninKeiyakuJigyoshaEntity = DbT7061JuryoIninJigyoshaEntityGenerator.createDbT7061JuryoIninJigyoshaEntity();
            JuryoIninKeiyakuJigyoshaEntity.setJigyoshaNo(主キー名1);
            JuryoIninKeiyakuJigyoshaEntity.setKeiyakuKaishiYMD(主キー名2);

        }

        @Test
        public void JuryoIninKeiyakuJigyoshaが保持するDbT7061JuryoIninJigyoshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJuryoIninKeiyakuJigyoshaが保持するDbT7061JuryoIninJigyoshaEntityのEntityDataStateがDeletedに指定されたJuryoIninKeiyakuJigyoshaが返る() {
            sut = TestSupport.setStateJuryoIninKeiyakuJigyosha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JuryoIninKeiyakuJigyoshaが保持するDbT7061JuryoIninJigyoshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJuryoIninKeiyakuJigyoshaが保持するDbT7061JuryoIninJigyoshaEntityのEntityDataStateがDeletedに指定されたJuryoIninKeiyakuJigyoshaが返る() {
            sut = TestSupport.setStateJuryoIninKeiyakuJigyosha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JuryoIninKeiyakuJigyoshaが保持するDbT7061JuryoIninJigyoshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJuryoIninKeiyakuJigyoshaが保持するDbT7061JuryoIninJigyoshaEntityのEntityDataStateがDeletedに指定されたJuryoIninKeiyakuJigyoshaが返る() {
            sut = TestSupport.setStateJuryoIninKeiyakuJigyosha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JuryoIninKeiyakuJigyoshaが保持するDbT7061JuryoIninJigyoshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJuryoIninKeiyakuJigyosha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JuryoIninKeiyakuJigyosha setStateJuryoIninKeiyakuJigyosha(EntityDataState parentState) {
            JuryoIninKeiyakuJigyoshaEntity.setState(parentState);
            return new JuryoIninKeiyakuJigyosha(JuryoIninKeiyakuJigyoshaEntity);
        }
    }
}
