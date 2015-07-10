/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7004KaigoShiharaiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoShiharaiJohoModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class KaigoShiharaiJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KaigoShiharaiJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new KaigoShiharaiJohoModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の科目コードは_設定した値と同じ科目コードを返す() {
            sut.set科目コード(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_科目コード);
            assertThat(sut.get科目コード(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_科目コード));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            sut.set決定年月日(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_決定年月日);
            assertThat(sut.get決定年月日(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の支払方法区分は_設定した値と同じ支払方法区分を返す() {
            sut.set支払方法区分(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_支払方法区分);
            assertThat(sut.get支払方法区分(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_支払方法区分));
        }

        @Test
        public void 戻り値の窓口支払場所コードは_設定した値と同じ窓口支払場所コードを返す() {
            sut.set窓口支払場所コード(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_窓口支払場所コード);
            assertThat(sut.get窓口支払場所コード(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_窓口支払場所コード));
        }

        @Test
        public void 戻り値の窓口支払開始年月日時分は_設定した値と同じ窓口支払開始年月日時分を返す() {
            sut.set窓口支払開始年月日時分(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_窓口支払開始年月日時分);
            assertThat(sut.get窓口支払開始年月日時分(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_窓口支払開始年月日時分));
        }

        @Test
        public void 戻り値の窓口支払終了年月日時分は_設定した値と同じ窓口支払終了年月日時分を返す() {
            sut.set窓口支払終了年月日時分(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_窓口支払終了年月日時分);
            assertThat(sut.get窓口支払終了年月日時分(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_窓口支払終了年月日時分));
        }

        @Test
        public void 戻り値の振込予定年月日は_設定した値と同じ振込予定年月日を返す() {
            sut.set振込予定年月日(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_振込予定年月日);
            assertThat(sut.get振込予定年月日(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_振込予定年月日));
        }

        @Test
        public void 戻り値の支払金額は_設定した値と同じ支払金額を返す() {
            sut.set支払金額(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_支払金額);
            assertThat(sut.get支払金額(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_支払金額));
        }

        @Test
        public void 戻り値の種別コードは_設定した値と同じ種別コードを返す() {
            sut.set種別コード(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_種別コード);
            assertThat(sut.get種別コード(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_種別コード));
        }

        @Test
        public void 戻り値の用途区分コードは_設定した値と同じ用途区分コードを返す() {
            sut.set用途区分コード(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_用途区分コード);
            assertThat(sut.get用途区分コード(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_用途区分コード));
        }

        @Test
        public void 戻り値の認証日１は_設定した値と同じ認証日１を返す() {
            sut.set認証日１(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証日１);
            assertThat(sut.get認証日１(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証日１));
        }

        @Test
        public void 戻り値の認証者コード１は_設定した値と同じ認証者コード１を返す() {
            sut.set認証者コード１(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証者コード１);
            assertThat(sut.get認証者コード１(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証者コード１));
        }

        @Test
        public void 戻り値の認証日２は_設定した値と同じ認証日２を返す() {
            sut.set認証日２(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証日２);
            assertThat(sut.get認証日２(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証日２));
        }

        @Test
        public void 戻り値の認証者コード２は_設定した値と同じ認証者コード２を返す() {
            sut.set認証者コード２(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証者コード２);
            assertThat(sut.get認証者コード２(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証者コード２));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KaigoShiharaiJohoModel sut = new KaigoShiharaiJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KaigoShiharaiJohoModel sut = new KaigoShiharaiJohoModel();
            sut.setEntity(DbT7004KaigoShiharaiJohoEntityGenerator.createDbT7004KaigoShiharaiJohoEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KaigoShiharaiJohoModel sut = new KaigoShiharaiJohoModel();
            sut.setEntity(DbT7004KaigoShiharaiJohoEntityGenerator.createDbT7004KaigoShiharaiJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KaigoShiharaiJohoModel sut = new KaigoShiharaiJohoModel();
            sut.setEntity(DbT7004KaigoShiharaiJohoEntityGenerator.createDbT7004KaigoShiharaiJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
