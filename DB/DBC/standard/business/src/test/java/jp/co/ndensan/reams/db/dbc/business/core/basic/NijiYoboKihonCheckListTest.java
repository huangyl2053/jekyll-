/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3101NijiYoboKihonCheckListEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3101NijiYoboKihonCheckListEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link NijiYoboKihonCheckList}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NijiYoboKihonCheckListTest extends DbcTestBase {

    private static DbT3101NijiYoboKihonCheckListEntity NijiYoboKihonCheckListEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleDate 受付年月日;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_識別コード;
        被保険者番号 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_被保険者番号;
        受付年月日 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_受付年月日;
        履歴番号 = DbT3101NijiYoboKihonCheckListEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static NijiYoboKihonCheckList sut;

        @Before
        public void setUp() {
            NijiYoboKihonCheckListEntity = DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity();
            NijiYoboKihonCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboKihonCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboKihonCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboKihonCheckListEntity.setRirekiNo(履歴番号);

        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 識別コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboKihonCheckList(null, 被保険者番号, 受付年月日, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboKihonCheckList(識別コード, null, 受付年月日, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT3101NijiYoboKihonCheckListEntityにセットされている() {
            sut = new NijiYoboKihonCheckList(識別コード, 被保険者番号, 受付年月日, 履歴番号);
            assertThat(sut.get識別コード(), is(識別コード));
            assertThat(sut.get被保険者番号(), is(被保険者番号));
        }

        @Test
        public void 指定したキーが保持するNijiYoboKihonCheckListIdentifierにセットされている() {
            sut = new NijiYoboKihonCheckList(識別コード, 被保険者番号, 受付年月日, 履歴番号);
            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get受付年月日(), is(受付年月日));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static NijiYoboKihonCheckList sut;

        @Before
        public void setUp() {
            NijiYoboKihonCheckListEntity = DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity();
            NijiYoboKihonCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboKihonCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboKihonCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboKihonCheckListEntity.setRirekiNo(履歴番号);

        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NijiYoboKihonCheckList(null);
        }

        @Test
        public void 指定したDbT3101NijiYoboKihonCheckListEntityのキー情報を識別子が持つ() {

            sut = new NijiYoboKihonCheckList(NijiYoboKihonCheckListEntity);

            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get受付年月日(), is(受付年月日));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static NijiYoboKihonCheckList sut;

        @Before
        public void setUp() {
            NijiYoboKihonCheckListEntity = DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity();
            NijiYoboKihonCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboKihonCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboKihonCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboKihonCheckListEntity.setRirekiNo(履歴番号);

            sut = new NijiYoboKihonCheckList(NijiYoboKihonCheckListEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(NijiYoboKihonCheckListEntity.getShikibetsuCode()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(NijiYoboKihonCheckListEntity.getHihokenshaNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(NijiYoboKihonCheckListEntity.getUketsukeYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(NijiYoboKihonCheckListEntity.getRirekiNo()));
        }

        @Test
        public void get記入年月日は_entityが持つ記入年月日を返す() {
            assertThat(sut.get記入年月日(), is(NijiYoboKihonCheckListEntity.getKinyuYMD()));
        }

        @Test
        public void get質問事項１は_entityが持つ質問事項１を返す() {
            assertThat(sut.get質問事項１(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko01()));
        }

        @Test
        public void get質問事項２は_entityが持つ質問事項２を返す() {
            assertThat(sut.get質問事項２(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko02()));
        }

        @Test
        public void get質問事項３は_entityが持つ質問事項３を返す() {
            assertThat(sut.get質問事項３(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko03()));
        }

        @Test
        public void get質問事項４は_entityが持つ質問事項４を返す() {
            assertThat(sut.get質問事項４(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko04()));
        }

        @Test
        public void get質問事項５は_entityが持つ質問事項５を返す() {
            assertThat(sut.get質問事項５(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko05()));
        }

        @Test
        public void get質問事項６は_entityが持つ質問事項６を返す() {
            assertThat(sut.get質問事項６(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko06()));
        }

        @Test
        public void get質問事項７は_entityが持つ質問事項７を返す() {
            assertThat(sut.get質問事項７(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko07()));
        }

        @Test
        public void get質問事項８は_entityが持つ質問事項８を返す() {
            assertThat(sut.get質問事項８(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko08()));
        }

        @Test
        public void get質問事項９は_entityが持つ質問事項９を返す() {
            assertThat(sut.get質問事項９(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko09()));
        }

        @Test
        public void get質問事項１０は_entityが持つ質問事項１０を返す() {
            assertThat(sut.get質問事項１０(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko10()));
        }

        @Test
        public void get質問事項１１は_entityが持つ質問事項１１を返す() {
            assertThat(sut.get質問事項１１(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko11()));
        }

        @Test
        public void get質問事項１２身長は_entityが持つ質問事項１２身長を返す() {
            assertThat(sut.get質問事項１２身長(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko12Shincho()));
        }

        @Test
        public void get質問事項１２体重は_entityが持つ質問事項１２体重を返す() {
            assertThat(sut.get質問事項１２体重(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko12Taiju()));
        }

        @Test
        public void get質問事項１３は_entityが持つ質問事項１３を返す() {
            assertThat(sut.get質問事項１３(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko13()));
        }

        @Test
        public void get質問事項１４は_entityが持つ質問事項１４を返す() {
            assertThat(sut.get質問事項１４(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko14()));
        }

        @Test
        public void get質問事項１５は_entityが持つ質問事項１５を返す() {
            assertThat(sut.get質問事項１５(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko15()));
        }

        @Test
        public void get質問事項１６は_entityが持つ質問事項１６を返す() {
            assertThat(sut.get質問事項１６(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko16()));
        }

        @Test
        public void get質問事項１７は_entityが持つ質問事項１７を返す() {
            assertThat(sut.get質問事項１７(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko17()));
        }

        @Test
        public void get質問事項１８は_entityが持つ質問事項１８を返す() {
            assertThat(sut.get質問事項１８(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko18()));
        }

        @Test
        public void get質問事項１９は_entityが持つ質問事項１９を返す() {
            assertThat(sut.get質問事項１９(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko19()));
        }

        @Test
        public void get質問事項２０は_entityが持つ質問事項２０を返す() {
            assertThat(sut.get質問事項２０(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko20()));
        }

        @Test
        public void get質問事項２１は_entityが持つ質問事項２１を返す() {
            assertThat(sut.get質問事項２１(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko21()));
        }

        @Test
        public void get質問事項２２は_entityが持つ質問事項２２を返す() {
            assertThat(sut.get質問事項２２(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko22()));
        }

        @Test
        public void get質問事項２３は_entityが持つ質問事項２３を返す() {
            assertThat(sut.get質問事項２３(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko23()));
        }

        @Test
        public void get質問事項２４は_entityが持つ質問事項２４を返す() {
            assertThat(sut.get質問事項２４(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko24()));
        }

        @Test
        public void get質問事項２５は_entityが持つ質問事項２５を返す() {
            assertThat(sut.get質問事項２５(), is(NijiYoboKihonCheckListEntity.getShitsumonJiko25()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static NijiYoboKihonCheckList sut;

        @Before
        public void setUp() {
            NijiYoboKihonCheckListEntity = DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity();
            NijiYoboKihonCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboKihonCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboKihonCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboKihonCheckListEntity.setRirekiNo(履歴番号);

            sut = new NijiYoboKihonCheckList(NijiYoboKihonCheckListEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NijiYoboKihonCheckListEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static NijiYoboKihonCheckList sut;

        @Before
        public void setUp() {
            NijiYoboKihonCheckListEntity = DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity();
            NijiYoboKihonCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboKihonCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboKihonCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboKihonCheckListEntity.setRirekiNo(履歴番号);

            sut = new NijiYoboKihonCheckList(NijiYoboKihonCheckListEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static NijiYoboKihonCheckList sut;
        private static NijiYoboKihonCheckList result;

        @Before
        public void setUp() {
            NijiYoboKihonCheckListEntity = DbT3101NijiYoboKihonCheckListEntityGenerator.createDbT3101NijiYoboKihonCheckListEntity();
            NijiYoboKihonCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboKihonCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboKihonCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboKihonCheckListEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void NijiYoboKihonCheckListが保持するDbT3101NijiYoboKihonCheckListEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNijiYoboKihonCheckListが保持するDbT3101NijiYoboKihonCheckListEntityのEntityDataStateがDeletedに指定されたNijiYoboKihonCheckListが返る() {
            sut = TestSupport.setStateNijiYoboKihonCheckList(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NijiYoboKihonCheckListが保持するDbT3101NijiYoboKihonCheckListEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNijiYoboKihonCheckListが保持するDbT3101NijiYoboKihonCheckListEntityのEntityDataStateがDeletedに指定されたNijiYoboKihonCheckListが返る() {
            sut = TestSupport.setStateNijiYoboKihonCheckList(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NijiYoboKihonCheckListが保持するDbT3101NijiYoboKihonCheckListEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNijiYoboKihonCheckListが保持するDbT3101NijiYoboKihonCheckListEntityのEntityDataStateがDeletedに指定されたNijiYoboKihonCheckListが返る() {
            sut = TestSupport.setStateNijiYoboKihonCheckList(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NijiYoboKihonCheckListが保持するDbT3101NijiYoboKihonCheckListEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNijiYoboKihonCheckList(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NijiYoboKihonCheckList setStateNijiYoboKihonCheckList(EntityDataState parentState) {
            NijiYoboKihonCheckListEntity.setState(parentState);
            return new NijiYoboKihonCheckList(NijiYoboKihonCheckListEntity);
        }
    }
}
