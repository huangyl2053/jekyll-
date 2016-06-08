/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7004KaigoShiharaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7004KaigoShiharaiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link KaigoShiharaiJoho}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoShiharaiJohoTest extends DbzTestBase {

    private static DbT7004KaigoShiharaiJohoEntity KaigoShiharaiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static KamokuCode 科目コード;
    private static FlexibleDate 決定年月日;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_識別コード;
        科目コード = DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_科目コード;
        決定年月日 = DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_決定年月日;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KaigoShiharaiJoho sut;

        @Before
        public void setUp() {
            KaigoShiharaiJohoEntity = DbT7004KaigoShiharaiJohoEntityGenerator.createDbT7004KaigoShiharaiJohoEntity();
            KaigoShiharaiJohoEntity.setShikibetsuCode(識別コード);
            KaigoShiharaiJohoEntity.setKamokuCode(科目コード);
            KaigoShiharaiJohoEntity.setKetteiYMD(決定年月日);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 識別コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoShiharaiJoho(null, 科目コード, 決定年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 科目コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoShiharaiJoho(識別コード, null, 決定年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 決定年月日がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoShiharaiJoho(識別コード, 科目コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT7004KaigoShiharaiJohoEntityにセットされている() {
            sut = new KaigoShiharaiJoho(識別コード, 科目コード, 決定年月日);
            assertThat(sut.get識別コード(), is(識別コード));
            assertThat(sut.get科目コード(), is(科目コード));
        }

        @Test
        public void 指定したキーが保持するKaigoShiharaiJohoIdentifierにセットされている() {
            sut = new KaigoShiharaiJoho(識別コード, 科目コード, 決定年月日);
            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get科目コード(), is(科目コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KaigoShiharaiJoho sut;

        @Before
        public void setUp() {
            KaigoShiharaiJohoEntity = DbT7004KaigoShiharaiJohoEntityGenerator.createDbT7004KaigoShiharaiJohoEntity();
            KaigoShiharaiJohoEntity.setShikibetsuCode(識別コード);
            KaigoShiharaiJohoEntity.setKamokuCode(科目コード);
            KaigoShiharaiJohoEntity.setKetteiYMD(決定年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoShiharaiJoho(null);
        }

        @Test
        public void 指定したDbT7004KaigoShiharaiJohoEntityのキー情報を識別子が持つ() {

            sut = new KaigoShiharaiJoho(KaigoShiharaiJohoEntity);

            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get科目コード(), is(科目コード));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KaigoShiharaiJoho sut;

        @Before
        public void setUp() {
            KaigoShiharaiJohoEntity = DbT7004KaigoShiharaiJohoEntityGenerator.createDbT7004KaigoShiharaiJohoEntity();
            KaigoShiharaiJohoEntity.setShikibetsuCode(識別コード);
            KaigoShiharaiJohoEntity.setKamokuCode(科目コード);
            KaigoShiharaiJohoEntity.setKetteiYMD(決定年月日);

            sut = new KaigoShiharaiJoho(KaigoShiharaiJohoEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(KaigoShiharaiJohoEntity.getShikibetsuCode()));
        }

        @Test
        public void get科目コードは_entityが持つ科目コードを返す() {
            assertThat(sut.get科目コード(), is(KaigoShiharaiJohoEntity.getKamokuCode()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(KaigoShiharaiJohoEntity.getKetteiYMD()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KaigoShiharaiJohoEntity.getHihokenshaNo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(KaigoShiharaiJohoEntity.getShichosonCode()));
        }

        @Test
        public void get支払方法区分は_entityが持つ支払方法区分を返す() {
            assertThat(sut.get支払方法区分(), is(KaigoShiharaiJohoEntity.getShiharaiHohoKubun()));
        }

        @Test
        public void get窓口支払場所コードは_entityが持つ窓口支払場所コードを返す() {
            assertThat(sut.get窓口支払場所コード(), is(KaigoShiharaiJohoEntity.getMadoguchiShiharaiBashoCode()));
        }

        @Test
        public void get窓口支払開始年月日時分は_entityが持つ窓口支払開始年月日時分を返す() {
            assertThat(sut.get窓口支払開始年月日時分(), is(KaigoShiharaiJohoEntity.getMadoguchiShiharaiKaishiYMDHM()));
        }

        @Test
        public void get窓口支払終了年月日時分は_entityが持つ窓口支払終了年月日時分を返す() {
            assertThat(sut.get窓口支払終了年月日時分(), is(KaigoShiharaiJohoEntity.getMadoguchiShiharaiShuryoYMDHM()));
        }

        @Test
        public void get振込予定年月日は_entityが持つ振込予定年月日を返す() {
            assertThat(sut.get振込予定年月日(), is(KaigoShiharaiJohoEntity.getFurikomiYoteiYMD()));
        }

        @Test
        public void get支払金額は_entityが持つ支払金額を返す() {
            assertThat(sut.get支払金額(), is(KaigoShiharaiJohoEntity.getShiharaiKingaku()));
        }

        @Test
        public void get種別コードは_entityが持つ種別コードを返す() {
            assertThat(sut.get種別コード(), is(KaigoShiharaiJohoEntity.getSyubetsuCode()));
        }

        @Test
        public void get用途区分コードは_entityが持つ用途区分コードを返す() {
            assertThat(sut.get用途区分コード(), is(KaigoShiharaiJohoEntity.getYotoKubunCode()));
        }

        @Test
        public void get認証日１は_entityが持つ認証日１を返す() {
            assertThat(sut.get認証日１(), is(KaigoShiharaiJohoEntity.getNinshoYMD1()));
        }

        @Test
        public void get認証者コード１は_entityが持つ認証者コード１を返す() {
            assertThat(sut.get認証者コード１(), is(KaigoShiharaiJohoEntity.getNinshoshaCode1()));
        }

        @Test
        public void get認証日２は_entityが持つ認証日２を返す() {
            assertThat(sut.get認証日２(), is(KaigoShiharaiJohoEntity.getNinshoYMD2()));
        }

        @Test
        public void get認証者コード２は_entityが持つ認証者コード２を返す() {
            assertThat(sut.get認証者コード２(), is(KaigoShiharaiJohoEntity.getNinshoshaCode2()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KaigoShiharaiJoho sut;

        @Before
        public void setUp() {
            KaigoShiharaiJohoEntity = DbT7004KaigoShiharaiJohoEntityGenerator.createDbT7004KaigoShiharaiJohoEntity();
            KaigoShiharaiJohoEntity.setShikibetsuCode(識別コード);
            KaigoShiharaiJohoEntity.setKamokuCode(科目コード);
            KaigoShiharaiJohoEntity.setKetteiYMD(決定年月日);

            sut = new KaigoShiharaiJoho(KaigoShiharaiJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KaigoShiharaiJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KaigoShiharaiJoho sut;

        @Before
        public void setUp() {
            KaigoShiharaiJohoEntity = DbT7004KaigoShiharaiJohoEntityGenerator.createDbT7004KaigoShiharaiJohoEntity();
            KaigoShiharaiJohoEntity.setShikibetsuCode(識別コード);
            KaigoShiharaiJohoEntity.setKamokuCode(科目コード);
            KaigoShiharaiJohoEntity.setKetteiYMD(決定年月日);

            sut = new KaigoShiharaiJoho(KaigoShiharaiJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KaigoShiharaiJoho sut;
        private static KaigoShiharaiJoho result;

        @Before
        public void setUp() {
            KaigoShiharaiJohoEntity = DbT7004KaigoShiharaiJohoEntityGenerator.createDbT7004KaigoShiharaiJohoEntity();
            KaigoShiharaiJohoEntity.setShikibetsuCode(識別コード);
            KaigoShiharaiJohoEntity.setKamokuCode(科目コード);
            KaigoShiharaiJohoEntity.setKetteiYMD(決定年月日);

        }

        @Test
        public void KaigoShiharaiJohoが保持するDbT7004KaigoShiharaiJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoShiharaiJohoが保持するDbT7004KaigoShiharaiJohoEntityのEntityDataStateがDeletedに指定されたKaigoShiharaiJohoが返る() {
            sut = TestSupport.setStateKaigoShiharaiJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoShiharaiJohoが保持するDbT7004KaigoShiharaiJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoShiharaiJohoが保持するDbT7004KaigoShiharaiJohoEntityのEntityDataStateがDeletedに指定されたKaigoShiharaiJohoが返る() {
            sut = TestSupport.setStateKaigoShiharaiJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoShiharaiJohoが保持するDbT7004KaigoShiharaiJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoShiharaiJohoが保持するDbT7004KaigoShiharaiJohoEntityのEntityDataStateがDeletedに指定されたKaigoShiharaiJohoが返る() {
            sut = TestSupport.setStateKaigoShiharaiJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoShiharaiJohoが保持するDbT7004KaigoShiharaiJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoShiharaiJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoShiharaiJoho setStateKaigoShiharaiJoho(EntityDataState parentState) {
            KaigoShiharaiJohoEntity.setState(parentState);
            return new KaigoShiharaiJoho(KaigoShiharaiJohoEntity);
        }
    }
}
