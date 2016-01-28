/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link KaigoJigyoshaDaihyosha}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaDaihyoshaTest extends DbxTestBase {

    private static DbT7062KaigoJigyoshaDaihyoshaEntity KaigoJigyoshaDaihyoshaEntity;
    private static KaigoJigyoshaNo 事業者番号;
    private static FlexibleDate 有効開始日;

    @BeforeClass
    public static void setUpClass() {

        事業者番号 = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_事業者番号;
        有効開始日 = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_有効開始日;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static KaigoJigyoshaDaihyosha sut;

        @Before
        public void setUp() {
            KaigoJigyoshaDaihyoshaEntity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaDaihyoshaEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaDaihyoshaEntity.setYukoKaishiYMD(有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJigyoshaDaihyosha(null, 有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJigyoshaDaihyosha(事業者番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT7062KaigoJigyoshaDaihyoshaEntityにセットされている() {
            sut = new KaigoJigyoshaDaihyosha(事業者番号, 有効開始日);
            assertThat(sut.get事業者番号(), is(事業者番号));
            assertThat(sut.get有効開始日(), is(有効開始日));
        }

        @Test
        public void 指定したキーが保持するKaigoJigyoshaDaihyoshaIdentifierにセットされている() {
            sut = new KaigoJigyoshaDaihyosha(事業者番号, 有効開始日);
            assertThat(sut.identifier().get事業者番号(), is(事業者番号));
            assertThat(sut.identifier().get有効開始日(), is(有効開始日));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static KaigoJigyoshaDaihyosha sut;

        @Before
        public void setUp() {
            KaigoJigyoshaDaihyoshaEntity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaDaihyoshaEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaDaihyoshaEntity.setYukoKaishiYMD(有効開始日);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoJigyoshaDaihyosha(null);
        }

        @Test
        public void 指定したDbT7062KaigoJigyoshaDaihyoshaEntityのキー情報を識別子が持つ() {

            sut = new KaigoJigyoshaDaihyosha(KaigoJigyoshaDaihyoshaEntity);

            assertThat(sut.identifier().get事業者番号(), is(事業者番号));
            assertThat(sut.identifier().get有効開始日(), is(有効開始日));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static KaigoJigyoshaDaihyosha sut;

        @Before
        public void setUp() {
            KaigoJigyoshaDaihyoshaEntity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaDaihyoshaEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaDaihyoshaEntity.setYukoKaishiYMD(有効開始日);

            sut = new KaigoJigyoshaDaihyosha(KaigoJigyoshaDaihyoshaEntity);
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(KaigoJigyoshaDaihyoshaEntity.getJigyoshaNo()));
        }

        @Test
        public void get有効開始日は_entityが持つ有効開始日を返す() {
            assertThat(sut.get有効開始日(), is(KaigoJigyoshaDaihyoshaEntity.getYukoKaishiYMD()));
        }

        @Test
        public void get代表者名は_entityが持つ代表者名を返す() {
            assertThat(sut.get代表者名(), is(KaigoJigyoshaDaihyoshaEntity.getDaihyoshaShimei()));
        }

        @Test
        public void get代表者名カナは_entityが持つ代表者名カナを返す() {
            assertThat(sut.get代表者名カナ(), is(KaigoJigyoshaDaihyoshaEntity.getDaihyoshaKanaShimei()));
        }

        @Test
        public void get代表者郵便番号は_entityが持つ代表者郵便番号を返す() {
            assertThat(sut.get代表者郵便番号(), is(KaigoJigyoshaDaihyoshaEntity.getDaihyoshaYubinNo()));
        }

        @Test
        public void get代表者住所は_entityが持つ代表者住所を返す() {
            assertThat(sut.get代表者住所(), is(KaigoJigyoshaDaihyoshaEntity.getDaihyoshaJusho()));
        }

        @Test
        public void get代表者住所カナは_entityが持つ代表者住所カナを返す() {
            assertThat(sut.get代表者住所カナ(), is(KaigoJigyoshaDaihyoshaEntity.getDaihyoshaKanaJusho()));
        }

        @Test
        public void get代表者役職名は_entityが持つ代表者役職名を返す() {
            assertThat(sut.get代表者役職名(), is(KaigoJigyoshaDaihyoshaEntity.getDaihyoshaYakushokuMei()));
        }

        @Test
        public void get開設者名称は_entityが持つ開設者名称を返す() {
            assertThat(sut.get開設者名称(), is(KaigoJigyoshaDaihyoshaEntity.getKaisetsushaShimei()));
        }

        @Test
        public void get開設者名称カナは_entityが持つ開設者名称カナを返す() {
            assertThat(sut.get開設者名称カナ(), is(KaigoJigyoshaDaihyoshaEntity.getKaisetsushaKanaShimei()));
        }

        @Test
        public void get開設者郵便番号は_entityが持つ開設者郵便番号を返す() {
            assertThat(sut.get開設者郵便番号(), is(KaigoJigyoshaDaihyoshaEntity.getKaisetsushaYubinNo()));
        }

        @Test
        public void get開設者住所は_entityが持つ開設者住所を返す() {
            assertThat(sut.get開設者住所(), is(KaigoJigyoshaDaihyoshaEntity.getKaisetsushaJusho()));
        }

        @Test
        public void get開設者住所カナは_entityが持つ開設者住所カナを返す() {
            assertThat(sut.get開設者住所カナ(), is(KaigoJigyoshaDaihyoshaEntity.getKaisetsushaKanaJusho()));
        }

        @Test
        public void get開設者電話番号は_entityが持つ開設者電話番号を返す() {
            assertThat(sut.get開設者電話番号(), is(KaigoJigyoshaDaihyoshaEntity.getKaisetsushaTelNo()));
        }

        @Test
        public void get開設者ＦＡＸ番号は_entityが持つ開設者ＦＡＸ番号を返す() {
            assertThat(sut.get開設者ＦＡＸ番号(), is(KaigoJigyoshaDaihyoshaEntity.getKaisetsushaFaxNo()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static KaigoJigyoshaDaihyosha sut;

        @Before
        public void setUp() {
            KaigoJigyoshaDaihyoshaEntity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaDaihyoshaEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaDaihyoshaEntity.setYukoKaishiYMD(有効開始日);

            sut = new KaigoJigyoshaDaihyosha(KaigoJigyoshaDaihyoshaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KaigoJigyoshaDaihyoshaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static KaigoJigyoshaDaihyosha sut;

        @Before
        public void setUp() {
            KaigoJigyoshaDaihyoshaEntity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaDaihyoshaEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaDaihyoshaEntity.setYukoKaishiYMD(有効開始日);

            sut = new KaigoJigyoshaDaihyosha(KaigoJigyoshaDaihyoshaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static KaigoJigyoshaDaihyosha sut;
        private static KaigoJigyoshaDaihyosha result;

        @Before
        public void setUp() {
            KaigoJigyoshaDaihyoshaEntity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaDaihyoshaEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaDaihyoshaEntity.setYukoKaishiYMD(有効開始日);
        }

        @Test
        public void KaigoJigyoshaDaihyoshaが保持するDbT7062KaigoJigyoshaDaihyoshaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoJigyoshaDaihyoshaが保持するDbT7062KaigoJigyoshaDaihyoshaEntityのEntityDataStateがDeletedに指定されたKaigoJigyoshaDaihyoshaが返る() {
            sut = TestSupport.setStateKaigoJigyoshaDaihyosha(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoJigyoshaDaihyoshaが保持するDbT7062KaigoJigyoshaDaihyoshaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoJigyoshaDaihyoshaが保持するDbT7062KaigoJigyoshaDaihyoshaEntityのEntityDataStateがDeletedに指定されたKaigoJigyoshaDaihyoshaが返る() {
            sut = TestSupport.setStateKaigoJigyoshaDaihyosha(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoJigyoshaDaihyoshaが保持するDbT7062KaigoJigyoshaDaihyoshaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoJigyoshaDaihyoshaが保持するDbT7062KaigoJigyoshaDaihyoshaEntityのEntityDataStateがDeletedに指定されたKaigoJigyoshaDaihyoshaが返る() {
            sut = TestSupport.setStateKaigoJigyoshaDaihyosha(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoJigyoshaDaihyoshaが保持するDbT7062KaigoJigyoshaDaihyoshaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoJigyoshaDaihyosha(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoJigyoshaDaihyosha setStateKaigoJigyoshaDaihyosha(EntityDataState parentState) {
            KaigoJigyoshaDaihyoshaEntity.setState(parentState);
            return new KaigoJigyoshaDaihyosha(KaigoJigyoshaDaihyoshaEntity);
        }
    }
}
