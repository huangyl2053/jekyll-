/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2010FukaErrorListEntityGenerator;
//import static jp.co.ndensan.reams.db.dbb.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link FukaErrorList}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class FukaErrorListTest extends DbbTestBase {

    private static DbT2010FukaErrorListEntity FukaErrorListEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static SubGyomuCode サブ業務コード;
    private static RString 内部帳票ID;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        サブ業務コード = DbT2010FukaErrorListEntityGenerator.DEFAULT_サブ業務コード;
        内部帳票ID = DbT2010FukaErrorListEntityGenerator.DEFAULT_内部帳票ID;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static FukaErrorList sut;

        @Before
        public void setUp() {
            FukaErrorListEntity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            FukaErrorListEntity.setSubGyomuCode(サブ業務コード);
            FukaErrorListEntity.setInternalReportId(内部帳票ID);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new FukaErrorList(null, 内部帳票ID, 賦課年度, 通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new FukaErrorList(サブ業務コード, null, 賦課年度, 通知書番号);
        }

        @Test
        public void 指定したキーが保持するDbT2010FukaErrorListEntityにセットされている() {
            sut = new FukaErrorList(サブ業務コード, 内部帳票ID, 賦課年度, 通知書番号);
            assertThat(sut.getサブ業務コード(), is(サブ業務コード));
            assertThat(sut.get内部帳票ID(), is(内部帳票ID));
        }

        @Test
        public void 指定したキーが保持するFukaErrorListIdentifierにセットされている() {
            sut = new FukaErrorList(サブ業務コード, 内部帳票ID, 賦課年度, 通知書番号);
            assertThat(sut.identifier().getサブ業務コード(), is(サブ業務コード));
            assertThat(sut.identifier().get内部帳票ID(), is(内部帳票ID));

        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static FukaErrorList sut;

        @Before
        public void setUp() {
            FukaErrorListEntity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            FukaErrorListEntity.setSubGyomuCode(サブ業務コード);
            FukaErrorListEntity.setInternalReportId(内部帳票ID);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new FukaErrorList(null);
        }

        @Test
        public void 指定したDbT2010FukaErrorListEntityのキー情報を識別子が持つ() {

            sut = new FukaErrorList(FukaErrorListEntity);
            assertThat(sut.identifier().getサブ業務コード(), is(サブ業務コード));
            assertThat(sut.identifier().get内部帳票ID(), is(内部帳票ID));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static FukaErrorList sut;

        @Before
        public void setUp() {
            FukaErrorListEntity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            FukaErrorListEntity.setSubGyomuCode(サブ業務コード);
            FukaErrorListEntity.setInternalReportId(内部帳票ID);

            sut = new FukaErrorList(FukaErrorListEntity);
        }

        @Test
        public void getサブ業務コードは_entityが持つサブ業務コードを返す() {
            assertThat(sut.getサブ業務コード(), is(FukaErrorListEntity.getSubGyomuCode()));
        }

        @Test
        public void get内部帳票IDは_entityが持つ内部帳票IDを返す() {
            assertThat(sut.get内部帳票ID(), is(FukaErrorListEntity.getInternalReportId()));
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(FukaErrorListEntity.getFukaNendo()));
        }

        @Test
        public void get通知書番号は_entityが持つ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(FukaErrorListEntity.getTsuchishoNo()));
        }

        @Test
        public void get内部帳票作成日時は_entityが持つ内部帳票作成日時を返す() {
            assertThat(sut.get内部帳票作成日時(), is(FukaErrorListEntity.getInternalReportCreationDateTime()));
        }

        @Test
        public void getバッチIDは_entityが持つバッチIDを返す() {
            assertThat(sut.getバッチID(), is(FukaErrorListEntity.getBatchId()));
        }

        @Test
        public void getバッチ起動日時は_entityが持つバッチ起動日時を返す() {
            assertThat(sut.getバッチ起動日時(), is(FukaErrorListEntity.getBatchStartingDateTime()));
        }

        @Test
        public void getエラーコードは_entityが持つエラーコードを返す() {
            assertThat(sut.getエラーコード(), is(FukaErrorListEntity.getErrorCode()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(FukaErrorListEntity.getHihokenshaNo()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(FukaErrorListEntity.getShikibetsuCode()));
        }

        @Test
        public void get処理区分コードは_entityが持つ処理区分コードを返す() {
            assertThat(sut.get処理区分コード(), is(FukaErrorListEntity.getShoriKubunCode()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static FukaErrorList sut;

        @Before
        public void setUp() {
            FukaErrorListEntity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            FukaErrorListEntity.setSubGyomuCode(サブ業務コード);
            FukaErrorListEntity.setInternalReportId(内部帳票ID);

            sut = new FukaErrorList(FukaErrorListEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(FukaErrorListEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static FukaErrorList sut;

        @Before
        public void setUp() {
            FukaErrorListEntity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            FukaErrorListEntity.setSubGyomuCode(サブ業務コード);
            FukaErrorListEntity.setInternalReportId(内部帳票ID);

            sut = new FukaErrorList(FukaErrorListEntity);
        }

        @Test
        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static FukaErrorList sut;
        private static FukaErrorList result;

        @Before
        public void setUp() {
            FukaErrorListEntity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            FukaErrorListEntity.setSubGyomuCode(サブ業務コード);
            FukaErrorListEntity.setInternalReportId(内部帳票ID);

        }

        @Test
        public void FukaErrorListが保持するDbT2010FukaErrorListEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりFukaErrorListが保持するDbT2010FukaErrorListEntityのEntityDataStateがDeletedに指定されたFukaErrorListが返る() {
            sut = TestSupport.setStateFukaErrorList(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void FukaErrorListが保持するDbT2010FukaErrorListEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりFukaErrorListが保持するDbT2010FukaErrorListEntityのEntityDataStateがDeletedに指定されたFukaErrorListが返る() {
            sut = TestSupport.setStateFukaErrorList(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void FukaErrorListが保持するDbT2010FukaErrorListEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりFukaErrorListが保持するDbT2010FukaErrorListEntityのEntityDataStateがDeletedに指定されたFukaErrorListが返る() {
            sut = TestSupport.setStateFukaErrorList(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void FukaErrorListが保持するDbT2010FukaErrorListEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateFukaErrorList(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static FukaErrorList setStateFukaErrorList(EntityDataState parentState) {
            FukaErrorListEntity.setState(parentState);
            return new FukaErrorList(FukaErrorListEntity);
        }
    }
}
