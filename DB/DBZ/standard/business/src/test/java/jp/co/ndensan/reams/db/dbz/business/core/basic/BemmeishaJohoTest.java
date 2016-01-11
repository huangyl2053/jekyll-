/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7003BemmeishaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
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
 * {@link BemmeishaJoho}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class BemmeishaJohoTest extends DbzTestBase {

    private static DbT7003BemmeishaJohoEntity BemmeishaJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShoKisaiHokenshaNo 主キー名1;
    private static ShikibetsuCode 主キー名2;
    private static HihokenshaNo 主キー名3;
    private static FlexibleDate 主キー名4;
    private static FlexibleDate 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7003BemmeishaJohoEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名2 = DbT7003BemmeishaJohoEntityGenerator.DEFAULT_識別コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static BemmeishaJoho sut;

        @Before
        public void setUp() {
            BemmeishaJohoEntity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            BemmeishaJohoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeishaJohoEntity.setShikibetsuCode(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new BemmeishaJoho(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new BemmeishaJoho(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT7003BemmeishaJohoEntityにセットされている() {
            sut = new BemmeishaJoho(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get証記載保険者番号(), is(主キー名1));
            assertThat(sut.get識別コード(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するBemmeishaJohoIdentifierにセットされている() {
            sut = new BemmeishaJoho(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get証記載保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get識別コード(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static BemmeishaJoho sut;

        @Before
        public void setUp() {
            BemmeishaJohoEntity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            BemmeishaJohoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeishaJohoEntity.setShikibetsuCode(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new BemmeishaJoho(null);
        }

        @Test
        public void 指定したDbT7003BemmeishaJohoEntityのキー情報を識別子が持つ() {

            sut = new BemmeishaJoho(BemmeishaJohoEntity);

            assertThat(sut.identifier().get証記載保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get識別コード(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static BemmeishaJoho sut;

        @Before
        public void setUp() {
            BemmeishaJohoEntity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            BemmeishaJohoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeishaJohoEntity.setShikibetsuCode(主キー名2);

            sut = new BemmeishaJoho(BemmeishaJohoEntity);
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(BemmeishaJohoEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(BemmeishaJohoEntity.getShikibetsuCode()));
        }

        @Test
        public void get原処分被保険者番号は_entityが持つ原処分被保険者番号を返す() {
            assertThat(sut.get原処分被保険者番号(), is(BemmeishaJohoEntity.getGenshobunHihokenshaNo()));
        }

        @Test
        public void get審査請求届出日は_entityが持つ審査請求届出日を返す() {
            assertThat(sut.get審査請求届出日(), is(BemmeishaJohoEntity.getShinsaseikyuTodokedeYMD()));
        }

        @Test
        public void get弁明書作成日は_entityが持つ弁明書作成日を返す() {
            assertThat(sut.get弁明書作成日(), is(BemmeishaJohoEntity.getBemmeishoSakuseiYMD()));
        }

        @Test
        public void get弁明者枝番は_entityが持つ弁明者枝番を返す() {
            assertThat(sut.get弁明者枝番(), is(new Decimal(BemmeishaJohoEntity.getBemmeishaEdaban())));
        }

        @Test
        public void get職員コードは_entityが持つ職員コードを返す() {
            assertThat(sut.get職員コード(), is(BemmeishaJohoEntity.getShokuinCode()));
        }

        @Test
        public void get部署コードは_entityが持つ部署コードを返す() {
            assertThat(sut.get部署コード(), is(BemmeishaJohoEntity.getBushoCode()));
        }

        @Test
        public void get役職名は_entityが持つ役職名を返す() {
            assertThat(sut.get役職名(), is(BemmeishaJohoEntity.getYakushoskuName()));
        }

        @Test
        public void get弁明者氏名は_entityが持つ弁明者氏名を返す() {
            assertThat(sut.get弁明者氏名(), is(BemmeishaJohoEntity.getBemmeishaShimei()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static BemmeishaJoho sut;

        @Before
        public void setUp() {
            BemmeishaJohoEntity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            BemmeishaJohoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeishaJohoEntity.setShikibetsuCode(主キー名2);

            sut = new BemmeishaJoho(BemmeishaJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(BemmeishaJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static BemmeishaJoho sut;

        @Before
        public void setUp() {
            BemmeishaJohoEntity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            BemmeishaJohoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeishaJohoEntity.setShikibetsuCode(主キー名2);

            sut = new BemmeishaJoho(BemmeishaJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static BemmeishaJoho sut;
        private static BemmeishaJoho result;

        @Before
        public void setUp() {
            BemmeishaJohoEntity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            BemmeishaJohoEntity.setShoKisaiHokenshaNo(主キー名1);
            BemmeishaJohoEntity.setShikibetsuCode(主キー名2);

        }

        @Test
        public void BemmeishaJohoが保持するDbT7003BemmeishaJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりBemmeishaJohoが保持するDbT7003BemmeishaJohoEntityのEntityDataStateがDeletedに指定されたBemmeishaJohoが返る() {
            sut = TestSupport.setStateBemmeishaJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void BemmeishaJohoが保持するDbT7003BemmeishaJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりBemmeishaJohoが保持するDbT7003BemmeishaJohoEntityのEntityDataStateがDeletedに指定されたBemmeishaJohoが返る() {
            sut = TestSupport.setStateBemmeishaJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void BemmeishaJohoが保持するDbT7003BemmeishaJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりBemmeishaJohoが保持するDbT7003BemmeishaJohoEntityのEntityDataStateがDeletedに指定されたBemmeishaJohoが返る() {
            sut = TestSupport.setStateBemmeishaJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void BemmeishaJohoが保持するDbT7003BemmeishaJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateBemmeishaJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static BemmeishaJoho setStateBemmeishaJoho(EntityDataState parentState) {
            BemmeishaJohoEntity.setState(parentState);
            return new BemmeishaJoho(BemmeishaJohoEntity);
        }
    }
}
