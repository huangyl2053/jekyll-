/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoServiceNaiyou}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceNaiyouTest extends DbxTestBase {

    private static DbT7131KaigoServiceNaiyouEntity KaigoServiceNaiyouEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KaigoServiceShuruiCode 主キー名1;
    private static RString 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス項目コード;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static KaigoServiceNaiyou sut;

        @Before
        public void setUp() {
            KaigoServiceNaiyouEntity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            KaigoServiceNaiyouEntity.setServiceShuruiCode(主キー名1);
            KaigoServiceNaiyouEntity.setServiceKoumokuCode(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoServiceNaiyou(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoServiceNaiyou(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT7131KaigoServiceNaiyouEntityにセットされている() {
            sut = new KaigoServiceNaiyou(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.getサービス種類コード(), is(主キー名1));
            assertThat(sut.getサービス項目コード(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKaigoServiceNaiyouIdentifierにセットされている() {
            sut = new KaigoServiceNaiyou(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().getサービス項目コード(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static KaigoServiceNaiyou sut;

        @Before
        public void setUp() {
            KaigoServiceNaiyouEntity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            KaigoServiceNaiyouEntity.setServiceShuruiCode(主キー名1);
            KaigoServiceNaiyouEntity.setServiceKoumokuCode(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoServiceNaiyou(null);
        }

        @Test
        public void 指定したDbT7131KaigoServiceNaiyouEntityのキー情報を識別子が持つ() {

            sut = new KaigoServiceNaiyou(KaigoServiceNaiyouEntity);
            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().getサービス項目コード(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static KaigoServiceNaiyou sut;

        @Before
        public void setUp() {
            KaigoServiceNaiyouEntity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            KaigoServiceNaiyouEntity.setServiceShuruiCode(主キー名1);
            KaigoServiceNaiyouEntity.setServiceKoumokuCode(主キー名2);

            sut = new KaigoServiceNaiyou(KaigoServiceNaiyouEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KaigoServiceNaiyouEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(KaigoServiceNaiyouEntity.getServiceKoumokuCode()));
        }

        @Test
        public void get提供開始年月は_entityが持つ提供開始年月を返す() {
            assertThat(sut.get提供開始年月(), is(KaigoServiceNaiyouEntity.getTeikyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KaigoServiceNaiyouEntity.getRirekiNo()));
        }

        @Test
        public void get提供終了年月は_entityが持つ提供終了年月を返す() {
            assertThat(sut.get提供終了年月(), is(KaigoServiceNaiyouEntity.getTeikyoShuryoYM()));
        }

        @Test
        public void getサービス名称は_entityが持つサービス名称を返す() {
            assertThat(sut.getサービス名称(), is(KaigoServiceNaiyouEntity.getServiceName()));
        }

        @Test
        public void getサービス略称は_entityが持つサービス略称を返す() {
            assertThat(sut.getサービス略称(), is(KaigoServiceNaiyouEntity.getServiceNameRyaku()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(KaigoServiceNaiyouEntity.getTaniSu()));
        }

        @Test
        public void get単位数識別は_entityが持つ単位数識別を返す() {
            assertThat(sut.get単位数識別(), is(KaigoServiceNaiyouEntity.getTanisuShikibetsuCode().value()));
        }

        @Test
        public void get単位数算定単位は_entityが持つ単位数算定単位を返す() {
            assertThat(sut.get単位数算定単位(), is(KaigoServiceNaiyouEntity.getTanisuSanteiTani().value()));
        }

        @Test
        public void get異動事由は_entityが持つ異動事由を返す() {
            assertThat(sut.get異動事由(), is(KaigoServiceNaiyouEntity.getIdouJiyuCode().value()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static KaigoServiceNaiyou sut;

        @Before
        public void setUp() {
            KaigoServiceNaiyouEntity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            KaigoServiceNaiyouEntity.setServiceShuruiCode(主キー名1);
            KaigoServiceNaiyouEntity.setServiceKoumokuCode(主キー名2);

            sut = new KaigoServiceNaiyou(KaigoServiceNaiyouEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KaigoServiceNaiyouEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static KaigoServiceNaiyou sut;

        @Before
        public void setUp() {
            KaigoServiceNaiyouEntity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            KaigoServiceNaiyouEntity.setServiceShuruiCode(主キー名1);
            KaigoServiceNaiyouEntity.setServiceKoumokuCode(主キー名2);

            sut = new KaigoServiceNaiyou(KaigoServiceNaiyouEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static KaigoServiceNaiyou sut;
        private static KaigoServiceNaiyou result;

        @Before
        public void setUp() {
            KaigoServiceNaiyouEntity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            KaigoServiceNaiyouEntity.setServiceShuruiCode(主キー名1);
            KaigoServiceNaiyouEntity.setServiceKoumokuCode(主キー名2);

        }

        @Test
        public void KaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがDeletedに指定されたKaigoServiceNaiyouが返る() {
            sut = TestSupport.setStateKaigoServiceNaiyou(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがDeletedに指定されたKaigoServiceNaiyouが返る() {
            sut = TestSupport.setStateKaigoServiceNaiyou(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがDeletedに指定されたKaigoServiceNaiyouが返る() {
            sut = TestSupport.setStateKaigoServiceNaiyou(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoServiceNaiyouが保持するDbT7131KaigoServiceNaiyouEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoServiceNaiyou(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoServiceNaiyou setStateKaigoServiceNaiyou(EntityDataState parentState) {
            KaigoServiceNaiyouEntity.setState(parentState);
            return new KaigoServiceNaiyou(KaigoServiceNaiyouEntity);
        }
    }
}
