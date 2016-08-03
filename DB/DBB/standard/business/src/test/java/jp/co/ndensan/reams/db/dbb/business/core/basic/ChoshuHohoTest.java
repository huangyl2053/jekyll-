/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2001ChoshuHohoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {@link ChoshuHoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ChoshuHohoTest extends DbbTestBase {

    private static DbT2001ChoshuHohoEntity ChoshuHohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 賦課年度;
    private static HihokenshaNo 被保険者番号;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        賦課年度 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度;
        被保険者番号 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_被保険者番号;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static ChoshuHoho sut;

        @Before
        public void setUp() {
            ChoshuHohoEntity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            ChoshuHohoEntity.setFukaNendo(賦課年度);
            ChoshuHohoEntity.setHihokenshaNo(被保険者番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChoshuHoho(null, 被保険者番号, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChoshuHoho(賦課年度, null, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT2001ChoshuHohoEntityにセットされている() {
            sut = new ChoshuHoho(賦課年度, 被保険者番号, 履歴番号);
            assertThat(sut.get賦課年度(), is(賦課年度));
            assertThat(sut.get被保険者番号(), is(被保険者番号));
        }

        @Test
        public void 指定したキーが保持するChoshuHohoIdentifierにセットされている() {
            sut = new ChoshuHoho(賦課年度, 被保険者番号, 履歴番号);
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static ChoshuHoho sut;

        @Before
        public void setUp() {
            ChoshuHohoEntity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            ChoshuHohoEntity.setFukaNendo(賦課年度);
            ChoshuHohoEntity.setHihokenshaNo(被保険者番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChoshuHoho(null);
        }

        @Test
        public void 指定したDbT2001ChoshuHohoEntityのキー情報を識別子が持つ() {

            sut = new ChoshuHoho(ChoshuHohoEntity);

            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static ChoshuHoho sut;

        @Before
        public void setUp() {
            ChoshuHohoEntity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            ChoshuHohoEntity.setFukaNendo(賦課年度);
            ChoshuHohoEntity.setHihokenshaNo(被保険者番号);

            sut = new ChoshuHoho(ChoshuHohoEntity);
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(ChoshuHohoEntity.getFukaNendo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ChoshuHohoEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ChoshuHohoEntity.getRirekiNo()));
        }

        @Test
        public void get徴収方法4月は_entityが持つ徴収方法4月を返す() {
            assertThat(sut.get徴収方法4月(), is(ChoshuHohoEntity.getChoshuHoho4gatsu()));
        }

        @Test
        public void get徴収方法5月は_entityが持つ徴収方法5月を返す() {
            assertThat(sut.get徴収方法5月(), is(ChoshuHohoEntity.getChoshuHoho5gatsu()));
        }

        @Test
        public void get徴収方法6月は_entityが持つ徴収方法6月を返す() {
            assertThat(sut.get徴収方法6月(), is(ChoshuHohoEntity.getChoshuHoho6gatsu()));
        }

        @Test
        public void get徴収方法7月は_entityが持つ徴収方法7月を返す() {
            assertThat(sut.get徴収方法7月(), is(ChoshuHohoEntity.getChoshuHoho7gatsu()));
        }

        @Test
        public void get徴収方法8月は_entityが持つ徴収方法8月を返す() {
            assertThat(sut.get徴収方法8月(), is(ChoshuHohoEntity.getChoshuHoho8gatsu()));
        }

        @Test
        public void get徴収方法9月は_entityが持つ徴収方法9月を返す() {
            assertThat(sut.get徴収方法9月(), is(ChoshuHohoEntity.getChoshuHoho9gatsu()));
        }

        @Test
        public void get徴収方法10月は_entityが持つ徴収方法10月を返す() {
            assertThat(sut.get徴収方法10月(), is(ChoshuHohoEntity.getChoshuHoho10gatsu()));
        }

        @Test
        public void get徴収方法11月は_entityが持つ徴収方法11月を返す() {
            assertThat(sut.get徴収方法11月(), is(ChoshuHohoEntity.getChoshuHoho11gatsu()));
        }

        @Test
        public void get徴収方法12月は_entityが持つ徴収方法12月を返す() {
            assertThat(sut.get徴収方法12月(), is(ChoshuHohoEntity.getChoshuHoho12gatsu()));
        }

        @Test
        public void get徴収方法1月は_entityが持つ徴収方法1月を返す() {
            assertThat(sut.get徴収方法1月(), is(ChoshuHohoEntity.getChoshuHoho1gatsu()));
        }

        @Test
        public void get徴収方法2月は_entityが持つ徴収方法2月を返す() {
            assertThat(sut.get徴収方法2月(), is(ChoshuHohoEntity.getChoshuHoho2gatsu()));
        }

        @Test
        public void get徴収方法3月は_entityが持つ徴収方法3月を返す() {
            assertThat(sut.get徴収方法3月(), is(ChoshuHohoEntity.getChoshuHoho3gatsu()));
        }

        @Test
        public void get徴収方法翌4月は_entityが持つ徴収方法翌4月を返す() {
            assertThat(sut.get徴収方法翌4月(), is(ChoshuHohoEntity.getChoshuHohoYoku4gatsu()));
        }

        @Test
        public void get徴収方法翌5月は_entityが持つ徴収方法翌5月を返す() {
            assertThat(sut.get徴収方法翌5月(), is(ChoshuHohoEntity.getChoshuHohoYoku5gatsu()));
        }

        @Test
        public void get徴収方法翌6月は_entityが持つ徴収方法翌6月を返す() {
            assertThat(sut.get徴収方法翌6月(), is(ChoshuHohoEntity.getChoshuHohoYoku6gatsu()));
        }

        @Test
        public void get徴収方法翌7月は_entityが持つ徴収方法翌7月を返す() {
            assertThat(sut.get徴収方法翌7月(), is(ChoshuHohoEntity.getChoshuHohoYoku7gatsu()));
        }

        @Test
        public void get徴収方法翌8月は_entityが持つ徴収方法翌8月を返す() {
            assertThat(sut.get徴収方法翌8月(), is(ChoshuHohoEntity.getChoshuHohoYoku8gatsu()));
        }

        @Test
        public void get徴収方法翌9月は_entityが持つ徴収方法翌9月を返す() {
            assertThat(sut.get徴収方法翌9月(), is(ChoshuHohoEntity.getChoshuHohoYoku9gatsu()));
        }

        @Test
        public void get仮徴収_基礎年金番号は_entityが持つ仮徴収_基礎年金番号を返す() {
            assertThat(sut.get仮徴収_基礎年金番号(), is(ChoshuHohoEntity.getKariNenkinNo())
            );
        }

        @Test
        public void get仮徴収_年金コードは_entityが持つ仮徴収_年金コードを返す() {
            assertThat(sut.get仮徴収_年金コード(), is(ChoshuHohoEntity.getKariNenkinCode())
            );
        }

        @Test
        public void get仮徴収_捕捉月は_entityが持つ仮徴収_捕捉月を返す() {
            assertThat(sut.get仮徴収_捕捉月(), is(ChoshuHohoEntity.getKariHosokuM())
            );
        }

        @Test
        public void get本徴収_基礎年金番号は_entityが持つ本徴収_基礎年金番号を返す() {
            assertThat(sut.get本徴収_基礎年金番号(), is(ChoshuHohoEntity.getHonNenkinNo())
            );
        }

        @Test
        public void get本徴収_年金コードは_entityが持つ本徴収_年金コードを返す() {
            assertThat(sut.get本徴収_年金コード(), is(ChoshuHohoEntity.getHonNenkinCode())
            );
        }

        @Test
        public void get本徴収_捕捉月は_entityが持つ本徴収_捕捉月を返す() {
            assertThat(sut.get本徴収_捕捉月(), is(ChoshuHohoEntity.getHonHosokuM())
            );
        }

        @Test
        public void get翌年度仮徴収_基礎年金番号は_entityが持つ翌年度仮徴収_基礎年金番号を返す() {
            assertThat(sut.get翌年度仮徴収_基礎年金番号(), is(ChoshuHohoEntity.getYokunendoKariNenkinNo())
            );
        }

        @Test
        public void get翌年度仮徴収_年金コードは_entityが持つ翌年度仮徴収_年金コードを返す() {
            assertThat(sut.get翌年度仮徴収_年金コード(), is(ChoshuHohoEntity.getYokunendoKariNenkinCode())
            );
        }

        @Test
        public void get翌年度仮徴収_捕捉月は_entityが持つ翌年度仮徴収_捕捉月を返す() {
            assertThat(sut.get翌年度仮徴収_捕捉月(), is(ChoshuHohoEntity.getYokunendoKariHosokuM())
            );
        }

        @Test
        public void get依頼情報送付済みフラグは_entityが持つ依頼情報送付済みフラグを返す() {
            assertThat(sut.is依頼情報送付済みフラグ(), is(ChoshuHohoEntity.getIraiSohuzumiFlag()));
        }

        @Test
        public void get追加依頼情報送付済みフラグは_entityが持つ追加依頼情報送付済みフラグを返す() {
            assertThat(sut.is追加依頼情報送付済みフラグ(), is(ChoshuHohoEntity.getTsuikaIraiSohuzumiFlag()));
        }

        @Test
        public void get特別徴収停止日時は_entityが持つ特別徴収停止日時を返す() {
            assertThat(sut.get特別徴収停止日時(), is(ChoshuHohoEntity.getTokuchoTeishiNichiji()));
        }

        @Test
        public void get特別徴収停止事由コードは_entityが持つ特別徴収停止事由コードを返す() {
            assertThat(sut.get特別徴収停止事由コード(), is(ChoshuHohoEntity.getTokuchoTeishiJiyuCode()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static ChoshuHoho sut;

        @Before
        public void setUp() {
            ChoshuHohoEntity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            ChoshuHohoEntity.setFukaNendo(賦課年度);
            ChoshuHohoEntity.setHihokenshaNo(被保険者番号);

            sut = new ChoshuHoho(ChoshuHohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ChoshuHohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static ChoshuHoho sut;

        @Before
        public void setUp() {
            ChoshuHohoEntity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            ChoshuHohoEntity.setFukaNendo(賦課年度);
            ChoshuHohoEntity.setHihokenshaNo(被保険者番号);

            sut = new ChoshuHoho(ChoshuHohoEntity);
        }

        @Test
        public void シリアライズできる() {
//            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static ChoshuHoho sut;
        private static ChoshuHoho result;

        @Before
        public void setUp() {
            ChoshuHohoEntity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            ChoshuHohoEntity.setFukaNendo(賦課年度);
            ChoshuHohoEntity.setHihokenshaNo(被保険者番号);

        }

        @Test
        public void ChoshuHohoが保持するDbT2001ChoshuHohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChoshuHohoが保持するDbT2001ChoshuHohoEntityのEntityDataStateがDeletedに指定されたChoshuHohoが返る() {
            sut = TestSupport.setStateChoshuHoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChoshuHohoが保持するDbT2001ChoshuHohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChoshuHohoが保持するDbT2001ChoshuHohoEntityのEntityDataStateがDeletedに指定されたChoshuHohoが返る() {
            sut = TestSupport.setStateChoshuHoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChoshuHohoが保持するDbT2001ChoshuHohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChoshuHohoが保持するDbT2001ChoshuHohoEntityのEntityDataStateがDeletedに指定されたChoshuHohoが返る() {
            sut = TestSupport.setStateChoshuHoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChoshuHohoが保持するDbT2001ChoshuHohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChoshuHoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChoshuHoho setStateChoshuHoho(EntityDataState parentState) {
            ChoshuHohoEntity.setState(parentState);
            return new ChoshuHoho(ChoshuHohoEntity);
        }
    }
}
