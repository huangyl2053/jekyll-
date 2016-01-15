/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3102NijiYoboNiniCheckListEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3102NijiYoboNiniCheckListEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
import org.junit.Ignore;

/**
 * {@link NijiYoboNiniCheckList}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class NijiYoboNiniCheckListTest extends DbcTestBase {

    private static DbT3102NijiYoboNiniCheckListEntity NijiYoboNiniCheckListEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
//    private static ShikibetsuCode 識別コード;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleDate 受付年月日;
    private static int 任意質問番号;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
//        識別コード = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード;
        被保険者番号 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_被保険者番号;
        受付年月日 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_受付年月日;
        任意質問番号 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問番号;
        履歴番号 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static NijiYoboNiniCheckList sut;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
//            NijiYoboNiniCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboNiniCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboNiniCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboNiniCheckListEntity.setNiniShitsumonNo(任意質問番号);
            NijiYoboNiniCheckListEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
//        @Test(expected = NullPointerException.class)
//        public void 識別コードがnullである場合に_NullPointerExceptionが発生する() {
//            sut = new NijiYoboNiniCheckList(null, 被保険者番号, 受付年月日, 任意質問番号, 履歴番号);
//        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboNiniCheckList(null, 受付年月日, 任意質問番号, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT3102NijiYoboNiniCheckListEntityにセットされている() {
            sut = new NijiYoboNiniCheckList(被保険者番号, 受付年月日, 任意質問番号, 履歴番号);
//            assertThat(sut.get識別コード(), is(識別コード));
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get受付年月日(), is(受付年月日));
            assertThat(sut.get任意質問番号(), is(任意質問番号));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するNijiYoboNiniCheckListIdentifierにセットされている() {
            sut = new NijiYoboNiniCheckList(被保険者番号, 受付年月日, 任意質問番号, 履歴番号);
//            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get受付年月日(), is(受付年月日));
            assertThat(sut.identifier().get任意質問番号(), is(任意質問番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static NijiYoboNiniCheckList sut;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
//            NijiYoboNiniCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboNiniCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboNiniCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboNiniCheckListEntity.setNiniShitsumonNo(任意質問番号);
            NijiYoboNiniCheckListEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NijiYoboNiniCheckList(null);
        }

        @Test
        public void 指定したDbT3102NijiYoboNiniCheckListEntityのキー情報を識別子が持つ() {

            sut = new NijiYoboNiniCheckList(NijiYoboNiniCheckListEntity);

//            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get受付年月日(), is(受付年月日));
            assertThat(sut.identifier().get任意質問番号(), is(任意質問番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static NijiYoboNiniCheckList sut;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
//            NijiYoboNiniCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboNiniCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboNiniCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboNiniCheckListEntity.setNiniShitsumonNo(任意質問番号);
            NijiYoboNiniCheckListEntity.setRirekiNo(履歴番号);

            sut = new NijiYoboNiniCheckList(NijiYoboNiniCheckListEntity);
        }

//        @Test
//        public void get識別コードは_entityが持つ識別コードを返す() {
//            assertThat(sut.get識別コード(), is(NijiYoboNiniCheckListEntity.getShikibetsuCode()));
//        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(NijiYoboNiniCheckListEntity.getHihokenshaNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(NijiYoboNiniCheckListEntity.getUketsukeYMD()));
        }

        @Test
        public void get任意質問番号は_entityが持つ任意質問番号を返す() {
            assertThat(sut.get任意質問番号(), is(NijiYoboNiniCheckListEntity.getNiniShitsumonNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(NijiYoboNiniCheckListEntity.getRirekiNo()));
        }

        @Test
        public void get任意質問事項は_entityが持つ任意質問事項を返す() {
            assertThat(sut.get任意質問事項(), is(NijiYoboNiniCheckListEntity.getNiniShitsumonJiko()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static NijiYoboNiniCheckList sut;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
//            NijiYoboNiniCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboNiniCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboNiniCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboNiniCheckListEntity.setNiniShitsumonNo(任意質問番号);
            NijiYoboNiniCheckListEntity.setRirekiNo(履歴番号);

            sut = new NijiYoboNiniCheckList(NijiYoboNiniCheckListEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NijiYoboNiniCheckListEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static NijiYoboNiniCheckList sut;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
//            NijiYoboNiniCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboNiniCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboNiniCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboNiniCheckListEntity.setNiniShitsumonNo(任意質問番号);
            NijiYoboNiniCheckListEntity.setRirekiNo(履歴番号);

            sut = new NijiYoboNiniCheckList(NijiYoboNiniCheckListEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static NijiYoboNiniCheckList sut;
        private static NijiYoboNiniCheckList result;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
//            NijiYoboNiniCheckListEntity.setShikibetsuCode(識別コード);
            NijiYoboNiniCheckListEntity.setHihokenshaNo(被保険者番号);
            NijiYoboNiniCheckListEntity.setUketsukeYMD(受付年月日);
            NijiYoboNiniCheckListEntity.setNiniShitsumonNo(任意質問番号);
            NijiYoboNiniCheckListEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void NijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがDeletedに指定されたNijiYoboNiniCheckListが返る() {
            sut = TestSupport.setStateNijiYoboNiniCheckList(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがDeletedに指定されたNijiYoboNiniCheckListが返る() {
            sut = TestSupport.setStateNijiYoboNiniCheckList(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがDeletedに指定されたNijiYoboNiniCheckListが返る() {
            sut = TestSupport.setStateNijiYoboNiniCheckList(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NijiYoboNiniCheckListが保持するDbT3102NijiYoboNiniCheckListEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNijiYoboNiniCheckList(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NijiYoboNiniCheckList setStateNijiYoboNiniCheckList(EntityDataState parentState) {
            NijiYoboNiniCheckListEntity.setState(parentState);
            return new NijiYoboNiniCheckList(NijiYoboNiniCheckListEntity);
        }
    }
}
