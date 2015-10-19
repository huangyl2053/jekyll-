/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link KaigoServiceShurui}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiTest extends DbxTestBase {

    private static DbT7130KaigoServiceShuruiEntity KaigoServiceShuruiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KaigoServiceShuruiCode 主キー名1;
    private static FlexibleYearMonth 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;

        @Before
        public void setUp() {
            KaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            KaigoServiceShuruiEntity.setServiceShuruiCd(主キー名1);
            KaigoServiceShuruiEntity.setTeikyoKaishiYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoServiceShurui(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoServiceShurui(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7130KaigoServiceShuruiEntityにセットされている() {
            sut = new KaigoServiceShurui(主キー名1, 主キー名2);
            assertThat(sut.getサービス種類コード(), is(主キー名1));
            assertThat(sut.get提供開始年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKaigoServiceShuruiIdentifierにセットされている() {
            sut = new KaigoServiceShurui(主キー名1, 主キー名2);
            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().get提供開始年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;

        @Before
        public void setUp() {
            KaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            KaigoServiceShuruiEntity.setServiceShuruiCd(主キー名1);
            KaigoServiceShuruiEntity.setTeikyoKaishiYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoServiceShurui(null);
        }

        @Test
        public void 指定したDbT7130KaigoServiceShuruiEntityのキー情報を識別子が持つ() {

            sut = new KaigoServiceShurui(KaigoServiceShuruiEntity);
            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().get提供開始年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;

        @Before
        public void setUp() {
            KaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            KaigoServiceShuruiEntity.setServiceShuruiCd(主キー名1);
            KaigoServiceShuruiEntity.setTeikyoKaishiYM(主キー名2);

            sut = new KaigoServiceShurui(KaigoServiceShuruiEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KaigoServiceShuruiEntity.getServiceShuruiCd()));
        }

        @Test
        public void get提供開始年月は_entityが持つ提供開始年月を返す() {
            assertThat(sut.get提供開始年月(), is(KaigoServiceShuruiEntity.getTeikyoKaishiYM()));
        }

        @Test
        public void get提供終了年月は_entityが持つ提供終了年月を返す() {
            assertThat(sut.get提供終了年月(), is(KaigoServiceShuruiEntity.getTeikyoshuryoYM()));
        }

        @Test
        public void getサービス種類名称は_entityが持つサービス種類名称を返す() {
            assertThat(sut.getサービス種類名称(), is(KaigoServiceShuruiEntity.getServiceShuruiMeisho()));
        }

        @Test
        public void getサービス種類略称は_entityが持つサービス種類略称を返す() {
            assertThat(sut.getサービス種類略称(), is(KaigoServiceShuruiEntity.getServiceShuruiRyakusho()));
        }

        @Test
        public void getサービス分類コードは_entityが持つサービス分類コードを返す() {
            assertThat(sut.getサービス分類コード(), is(KaigoServiceShuruiEntity.getServiceBunrruicode().value()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;

        @Before
        public void setUp() {
            KaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            KaigoServiceShuruiEntity.setServiceShuruiCd(主キー名1);
            KaigoServiceShuruiEntity.setTeikyoKaishiYM(主キー名2);

            sut = new KaigoServiceShurui(KaigoServiceShuruiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KaigoServiceShuruiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;

        @Before
        public void setUp() {
            KaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            KaigoServiceShuruiEntity.setServiceShuruiCd(主キー名1);
            KaigoServiceShuruiEntity.setTeikyoKaishiYM(主キー名2);

            sut = new KaigoServiceShurui(KaigoServiceShuruiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static KaigoServiceShurui sut;
        private static KaigoServiceShurui result;

        @Before
        public void setUp() {
            KaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            KaigoServiceShuruiEntity.setServiceShuruiCd(主キー名1);
            KaigoServiceShuruiEntity.setTeikyoKaishiYM(主キー名2);

        }

        @Test
        public void KaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがDeletedに指定されたKaigoServiceShuruiが返る() {
            sut = TestSupport.setStateKaigoServiceShurui(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがDeletedに指定されたKaigoServiceShuruiが返る() {
            sut = TestSupport.setStateKaigoServiceShurui(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがDeletedに指定されたKaigoServiceShuruiが返る() {
            sut = TestSupport.setStateKaigoServiceShurui(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoServiceShuruiが保持するDbT7130KaigoServiceShuruiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoServiceShurui(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoServiceShurui setStateKaigoServiceShurui(EntityDataState parentState) {
            KaigoServiceShuruiEntity.setState(parentState);
            return new KaigoServiceShurui(KaigoServiceShuruiEntity);
        }
    }
}
