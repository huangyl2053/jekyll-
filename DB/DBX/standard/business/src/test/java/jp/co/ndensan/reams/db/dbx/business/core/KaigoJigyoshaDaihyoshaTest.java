/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.lang.reflect.Constructor;
import jp.co.ndensan.reams.db.dbx.business.core.KaigoJigyoshaDaihyosha.Builder;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization._Base64Serializer;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * KaigoJigyoshaDaihyoshaのテストクラスです。
 *
 * @author n2818 西澤 貴幸
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaDaihyoshaTest extends DbxTestBase {

    private static KaigoJigyoshaDaihyosha sut;

    public static class コンストラクタTest extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタに_Null_を指定した時_NullPointerExceptionが発生する() {
            KaigoJigyoshaDaihyosha sut = new KaigoJigyoshaDaihyosha(null);
        }
    }

    public static class toEntityTest extends DbxTestBase {

        @Before
        public void setup() {
            sut = new KaigoJigyoshaDaihyosha(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity());
        }

        @Test
        public void 同じ値のクローンを返す() {
            DbT7062KaigoJigyoshaDaihyoshaEntity clone = sut.toEntity();
            DbT7062KaigoJigyoshaDaihyoshaEntity result = sut.toEntity();
            assertThat(clone.getJigyoshaNo().equals(result.getJigyoshaNo()), is(true));
            assertThat(clone == result, is(false));
        }
    }

    public static class createBuilderForEditTest extends DbxTestBase {

        @Before
        public void setup() {
            sut = new KaigoJigyoshaDaihyosha(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity());
        }

        @Test
        public void メソッドが返すBuilderでオブジェクトを生成し_値を変更しても_元のオブジェクトには影響を与えない() {
            Builder builder = sut.createBuilderForEdit();
            builder.setDaihyoshaShimei(new AtenaMeisho("電算次郎"));
            KaigoJigyoshaDaihyosha result = builder.build();
            assertThat(sut.get代表者名().equals(result.get代表者名()), is(false));
        }
    }

    //TODO n3423 樋木隆真 stateの扱いについては現在検討中のため変更の可能性があります。
//    public static class getStateTest extends DbxTestBase {
//
//        @Test
//        public void 状態Addedの取得確認() {
//            KaigoJigyoshaDaihyosha sut = new KaigoJigyoshaDaihyosha(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity());
//            assertThat(sut.getState(), is(EntityDataState.Added));
//        }
//
//        @Test
//        public void 状態Modifinedの取得確認() {
//            KaigoJigyoshaDaihyosha sut = new KaigoJigyoshaDaihyosha(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity());
//            sut.toEntity().initializeMd5();
//            sut.toEntity().setDaihyoshaYakushokuMei(new RString("係長"));
//            assertThat(sut.getState(), is(EntityDataState.Modified));
//        }
//
//        @Test
//        public void 状態Unchangedの取得確認() {
//            KaigoJigyoshaDaihyosha sut = new KaigoJigyoshaDaihyosha(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity());
//            sut.toEntity().initializeMd5();
//            assertThat(sut.getState(), is(EntityDataState.Unchanged));
//        }
//
//        @Test
//        public void 状態Deletedの取得確認() {
//            KaigoJigyoshaDaihyosha sut = new KaigoJigyoshaDaihyosha(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity());
//            sut.toEntity().initializeMd5();
//            sut.createBuilderForEdit().setDeletedState(true);
//
//            assertThat(sut.getState(), is(EntityDataState.Deleted));
//        }
//    }
    public static class BuilderTest extends DbxTestBase {

        @Test
        public void setJigyoshaNoで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setJigyoshaNo(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(result.get事業者番号(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void setYukoKaishiYMDで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setYukoKaishiYMD(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_有効開始日).build();
            assertThat(result.get有効開始日(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_有効開始日));
        }

        @Test
        public void setDaihyoshaShimeiで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setDaihyoshaShimei(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者名).build();
            assertThat(result.get代表者名(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者名));
        }

        @Test
        public void setDaihyoshaKanaShimeiで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setDaihyoshaKanaShimei(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者名カナ).build();
            assertThat(result.get代表者名カナ(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者名カナ));
        }

        @Test
        public void setDaihyoshaYubinNoで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setDaihyoshaYubinNo(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者郵便番号).build();
            assertThat(result.get代表者郵便番号(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者郵便番号));
        }

        @Test
        public void setDaihyoshaJushoで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setDaihyoshaJusho(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者住所).build();
            assertThat(result.get代表者住所(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者住所));
        }

        @Test
        public void setDaihyoshaKanaJushoで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setDaihyoshaKanaJusho(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者住所カナ).build();
            assertThat(result.get代表者住所カナ(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者住所カナ));
        }

        @Test
        public void setDaihyoshaYakushokuMeiで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setDaihyoshaYakushokuMei(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者役職名).build();
            assertThat(result.get代表者役職名(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者役職名));
        }

        @Test
        public void setKaisetsushaShimeiで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setKaisetsushaShimei(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者名称).build();
            assertThat(result.get開設者名(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者名称));
        }

        @Test
        public void setKaisetsushaKanaShimeiで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setKaisetsushaKanaShimei(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者名称カナ).build();
            assertThat(result.get開設者名カナ(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者名称カナ));
        }

        @Test
        public void setKaisetsushaYubinNoで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setKaisetsushaYubinNo(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者郵便番号).build();
            assertThat(result.get開設者郵便番号(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者郵便番号));
        }

        @Test
        public void setKaisetsushaJushoで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setKaisetsushaJusho(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者住所).build();
            assertThat(result.get開設者住所(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者住所));
        }

        @Test
        public void setKaisetsushaKanaJushoで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setKaisetsushaKanaJusho(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者住所カナ).build();
            assertThat(result.get開設者住所カナ(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者住所カナ));
        }

        @Test
        public void setKaisetsushaTelNoで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setKaisetsushaTelNo(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者電話番号).build();
            assertThat(result.get開設者電話番号(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者電話番号));
        }

        @Test
        public void setKaisetsushaFaxNoで設定した値を_生成されたKaigoJigyoshaDaihyoshaも保持する() {
            KaigoJigyoshaDaihyosha result = KaigoJigyoshaDaihyosha.newBuilder().setKaisetsushaFaxNo(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者ＦＡＸ番号).build();
            assertThat(result.get開設者FAX番号(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者ＦＡＸ番号));
        }
    }

    public static class SerializationProxyTest extends DbxTestBase {

        private KaigoJigyoshaDaihyosha sut;

        @Before
        public void setUp() {
            sut = KaigoJigyoshaDaihyosha.newBuilder().build();
        }

        @Test
        public void serializeの戻り値の代表者名は_デシリアライズすると_同じ代表者名を持ったインスタンスを生成する() {
            sut.createBuilderForEdit().setDaihyoshaShimei(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者名);
            String b64 = _Base64Serializer.serialize(sut.serialize());
            KaigoJigyoshaDaihyosha desirialized = _Base64Serializer.deSerialize(b64, KaigoJigyoshaDaihyosha.class);
            assertThat(desirialized.get代表者名(), is(sut.get代表者名()));
        }
    }

    public static class getStateTest extends DbxTestBase {

        private static KaigoJigyoshaDaihyosha sut;

        @Before
        public void setUp() {
            sut = KaigoJigyoshaDaihyosha.newBuilder().build();
        }

        @Test
        public void LDNS_メソッドgetStateが呼び出される場合_getStateは_Addedを返す() {
            assertThat(sut.getState(), is(EntityDataState.Added));
        }

    }

    public static class LDNS_コンストラクタTEST extends DbxTestBase {

        @Test
        public void LDNS_privateConstructor() throws Exception {
            Constructor<KaigoJigyoshaDaihyosha> constructor = KaigoJigyoshaDaihyosha.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }

    }
}
