/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7069KaigoToiawasesakiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * {@link KaigoToiawasesaki}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoToiawasesakiTest extends DbzTestBase {

    private static DbT7069KaigoToiawasesakiEntity KaigoToiawasesakiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static SubGyomuCode サブ業務コード;
    private static ReportId 帳票分類ID;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        サブ業務コード = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード;
        帳票分類ID = DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KaigoToiawasesaki sut;

        @Before
        public void setUp() {
            KaigoToiawasesakiEntity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            KaigoToiawasesakiEntity.setSubGyomuCode(サブ業務コード);
            KaigoToiawasesakiEntity.setChohyoBunruiID(帳票分類ID);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void サブ業務コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoToiawasesaki(null, 帳票分類ID);
        }

        @Test(expected = NullPointerException.class)
        public void 帳票分類IDがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoToiawasesaki(サブ業務コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT7069KaigoToiawasesakiEntityにセットされている() {
            sut = new KaigoToiawasesaki(サブ業務コード, 帳票分類ID);
            assertThat(sut.getサブ業務コード(), is(サブ業務コード));
            assertThat(sut.get帳票分類ID(), is(帳票分類ID));
        }

        @Test
        public void 指定したキーが保持するKaigoToiawasesakiIdentifierにセットされている() {
            sut = new KaigoToiawasesaki(サブ業務コード, 帳票分類ID);
            assertThat(sut.identifier().getサブ業務コード(), is(サブ業務コード));
            assertThat(sut.identifier().get帳票分類ID(), is(帳票分類ID));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KaigoToiawasesaki sut;

        @Before
        public void setUp() {
            KaigoToiawasesakiEntity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            KaigoToiawasesakiEntity.setSubGyomuCode(サブ業務コード);
            KaigoToiawasesakiEntity.setChohyoBunruiID(帳票分類ID);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoToiawasesaki(null);
        }

        @Test
        public void 指定したDbT7069KaigoToiawasesakiEntityのキー情報を識別子が持つ() {

            sut = new KaigoToiawasesaki(KaigoToiawasesakiEntity);

            assertThat(sut.identifier().getサブ業務コード(), is(サブ業務コード));
            assertThat(sut.identifier().get帳票分類ID(), is(帳票分類ID));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KaigoToiawasesaki sut;

        @Before
        public void setUp() {
            KaigoToiawasesakiEntity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            KaigoToiawasesakiEntity.setSubGyomuCode(サブ業務コード);
            KaigoToiawasesakiEntity.setChohyoBunruiID(帳票分類ID);

            sut = new KaigoToiawasesaki(KaigoToiawasesakiEntity);
        }

        @Test
        public void getサブ業務コードは_entityが持つサブ業務コードを返す() {
            assertThat(sut.getサブ業務コード(), is(KaigoToiawasesakiEntity.getSubGyomuCode()));
        }

        @Test
        public void get帳票分類IDは_entityが持つ帳票分類IDを返す() {
            assertThat(sut.get帳票分類ID(), is(KaigoToiawasesakiEntity.getChohyoBunruiID()));
        }

        @Test
        public void get郵便番号は_entityが持つ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(KaigoToiawasesakiEntity.getYubinNo()));
        }

        @Test
        public void get所在地は_entityが持つ所在地を返す() {
            assertThat(sut.get所在地(), is(KaigoToiawasesakiEntity.getShozaichi()));
        }

        @Test
        public void get庁舎名は_entityが持つ庁舎名を返す() {
            assertThat(sut.get庁舎名(), is(KaigoToiawasesakiEntity.getChoshaName()));
        }

        @Test
        public void get電話番号は_entityが持つ電話番号を返す() {
            assertThat(sut.get電話番号(), is(KaigoToiawasesakiEntity.getTelNo()));
        }

        @Test
        public void get内線番号は_entityが持つ内線番号を返す() {
            assertThat(sut.get内線番号(), is(KaigoToiawasesakiEntity.getNaisenNo()));
        }

        @Test
        public void get部署名は_entityが持つ部署名を返す() {
            assertThat(sut.get部署名(), is(KaigoToiawasesakiEntity.getBushoName()));
        }

        @Test
        public void get担当者名は_entityが持つ担当者名を返す() {
            assertThat(sut.get担当者名(), is(KaigoToiawasesakiEntity.getTantoshaName()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KaigoToiawasesaki sut;

        @Before
        public void setUp() {
            KaigoToiawasesakiEntity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            KaigoToiawasesakiEntity.setSubGyomuCode(サブ業務コード);
            KaigoToiawasesakiEntity.setChohyoBunruiID(帳票分類ID);

            sut = new KaigoToiawasesaki(KaigoToiawasesakiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KaigoToiawasesakiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KaigoToiawasesaki sut;

        @Before
        public void setUp() {
            KaigoToiawasesakiEntity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            KaigoToiawasesakiEntity.setSubGyomuCode(サブ業務コード);
            KaigoToiawasesakiEntity.setChohyoBunruiID(帳票分類ID);

            sut = new KaigoToiawasesaki(KaigoToiawasesakiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KaigoToiawasesaki sut;
        private static KaigoToiawasesaki result;

        @Before
        public void setUp() {
            KaigoToiawasesakiEntity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            KaigoToiawasesakiEntity.setSubGyomuCode(サブ業務コード);
            KaigoToiawasesakiEntity.setChohyoBunruiID(帳票分類ID);

        }

        @Test
        public void KaigoToiawasesakiが保持するDbT7069KaigoToiawasesakiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoToiawasesakiが保持するDbT7069KaigoToiawasesakiEntityのEntityDataStateがDeletedに指定されたKaigoToiawasesakiが返る() {
            sut = TestSupport.setStateKaigoToiawasesaki(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoToiawasesakiが保持するDbT7069KaigoToiawasesakiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoToiawasesakiが保持するDbT7069KaigoToiawasesakiEntityのEntityDataStateがDeletedに指定されたKaigoToiawasesakiが返る() {
            sut = TestSupport.setStateKaigoToiawasesaki(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoToiawasesakiが保持するDbT7069KaigoToiawasesakiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoToiawasesakiが保持するDbT7069KaigoToiawasesakiEntityのEntityDataStateがDeletedに指定されたKaigoToiawasesakiが返る() {
            sut = TestSupport.setStateKaigoToiawasesaki(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoToiawasesakiが保持するDbT7069KaigoToiawasesakiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoToiawasesaki(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoToiawasesaki setStateKaigoToiawasesaki(EntityDataState parentState) {
            KaigoToiawasesakiEntity.setState(parentState);
            return new KaigoToiawasesaki(KaigoToiawasesakiEntity);
        }
    }
}
