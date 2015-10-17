/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3099TandokuJoseiShuruiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3099TandokuJoseiShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link TandokuJoseiShurui}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TandokuJoseiShuruiTest extends DbcTestBase {

    private static DbT3099TandokuJoseiShuruiEntity TandokuJoseiShuruiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;
    private static ServiceShuruiCode 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_市町村単独助成種類;
        主キー名2 = DbT3099TandokuJoseiShuruiEntityGenerator.DEFAULT_助成サービス種類コード;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static TandokuJoseiShurui sut;

        @Before
        public void setUp() {
            TandokuJoseiShuruiEntity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            TandokuJoseiShuruiEntity.setTandokuJoseiShuruiCode(主キー名1);
            TandokuJoseiShuruiEntity.setJoseiServiceShuruiCode(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TandokuJoseiShurui(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TandokuJoseiShurui(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT3099TandokuJoseiShuruiEntityにセットされている() {
            sut = new TandokuJoseiShurui(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get市町村単独助成種類(), is(主キー名1));
            assertThat(sut.get助成サービス種類コード(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するTandokuJoseiShuruiIdentifierにセットされている() {
            sut = new TandokuJoseiShurui(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().get市町村単独助成種類(), is(主キー名1));
            assertThat(sut.identifier().get助成サービス種類コード(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static TandokuJoseiShurui sut;

        @Before
        public void setUp() {
            TandokuJoseiShuruiEntity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            TandokuJoseiShuruiEntity.setTandokuJoseiShuruiCode(主キー名1);
            TandokuJoseiShuruiEntity.setJoseiServiceShuruiCode(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new TandokuJoseiShurui(null);
        }

        @Test
        public void 指定したDbT3099TandokuJoseiShuruiEntityのキー情報を識別子が持つ() {

            sut = new TandokuJoseiShurui(TandokuJoseiShuruiEntity);

            assertThat(sut.identifier().get市町村単独助成種類(), is(主キー名1));
            assertThat(sut.identifier().get助成サービス種類コード(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static TandokuJoseiShurui sut;

        @Before
        public void setUp() {
            TandokuJoseiShuruiEntity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            TandokuJoseiShuruiEntity.setTandokuJoseiShuruiCode(主キー名1);
            TandokuJoseiShuruiEntity.setJoseiServiceShuruiCode(主キー名2);

            sut = new TandokuJoseiShurui(TandokuJoseiShuruiEntity);
        }

        @Test
        public void get市町村単独助成種類は_entityが持つ市町村単独助成種類を返す() {
            assertThat(sut.get市町村単独助成種類(), is(TandokuJoseiShuruiEntity.getTandokuJoseiShuruiCode()));
        }

        @Test
        public void get助成サービス種類コードは_entityが持つ助成サービス種類コードを返す() {
            assertThat(sut.get助成サービス種類コード(), is(TandokuJoseiShuruiEntity.getJoseiServiceShuruiCode()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(TandokuJoseiShuruiEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(TandokuJoseiShuruiEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(TandokuJoseiShuruiEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void get助成サービス種類名称は_entityが持つ助成サービス種類名称を返す() {
            assertThat(sut.get助成サービス種類名称(), is(TandokuJoseiShuruiEntity.getJoseiServiceShuriMeisho()));
        }

        @Test
        public void get市町村単独助成単位は_entityが持つ市町村単独助成単位を返す() {
            assertThat(sut.get市町村単独助成単位(), is(TandokuJoseiShuruiEntity.getJoseiTani()));
        }

        @Test
        public void get市町村単独助成内容は_entityが持つ市町村単独助成内容を返す() {
            assertThat(sut.get市町村単独助成内容(), is(TandokuJoseiShuruiEntity.getJoseiNaiyo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static TandokuJoseiShurui sut;

        @Before
        public void setUp() {
            TandokuJoseiShuruiEntity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            TandokuJoseiShuruiEntity.setTandokuJoseiShuruiCode(主キー名1);
            TandokuJoseiShuruiEntity.setJoseiServiceShuruiCode(主キー名2);

            sut = new TandokuJoseiShurui(TandokuJoseiShuruiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(TandokuJoseiShuruiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static TandokuJoseiShurui sut;

        @Before
        public void setUp() {
            TandokuJoseiShuruiEntity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            TandokuJoseiShuruiEntity.setTandokuJoseiShuruiCode(主キー名1);
            TandokuJoseiShuruiEntity.setJoseiServiceShuruiCode(主キー名2);

            sut = new TandokuJoseiShurui(TandokuJoseiShuruiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static TandokuJoseiShurui sut;
        private static TandokuJoseiShurui result;

        @Before
        public void setUp() {
            TandokuJoseiShuruiEntity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            TandokuJoseiShuruiEntity.setTandokuJoseiShuruiCode(主キー名1);
            TandokuJoseiShuruiEntity.setJoseiServiceShuruiCode(主キー名2);

        }

        @Test
        public void TandokuJoseiShuruiが保持するDbT3099TandokuJoseiShuruiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりTandokuJoseiShuruiが保持するDbT3099TandokuJoseiShuruiEntityのEntityDataStateがDeletedに指定されたTandokuJoseiShuruiが返る() {
            sut = TestSupport.setStateTandokuJoseiShurui(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TandokuJoseiShuruiが保持するDbT3099TandokuJoseiShuruiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりTandokuJoseiShuruiが保持するDbT3099TandokuJoseiShuruiEntityのEntityDataStateがDeletedに指定されたTandokuJoseiShuruiが返る() {
            sut = TestSupport.setStateTandokuJoseiShurui(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TandokuJoseiShuruiが保持するDbT3099TandokuJoseiShuruiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりTandokuJoseiShuruiが保持するDbT3099TandokuJoseiShuruiEntityのEntityDataStateがDeletedに指定されたTandokuJoseiShuruiが返る() {
            sut = TestSupport.setStateTandokuJoseiShurui(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void TandokuJoseiShuruiが保持するDbT3099TandokuJoseiShuruiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateTandokuJoseiShurui(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static TandokuJoseiShurui setStateTandokuJoseiShurui(EntityDataState parentState) {
            TandokuJoseiShuruiEntity.setState(parentState);
            return new TandokuJoseiShurui(TandokuJoseiShuruiEntity);
        }
    }
}
