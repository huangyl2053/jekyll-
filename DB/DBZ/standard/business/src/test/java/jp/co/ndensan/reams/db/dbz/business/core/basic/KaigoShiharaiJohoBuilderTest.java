/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7004KaigoShiharaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7004KaigoShiharaiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoShiharaiJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoShiharaiJohoBuilderTest extends DbzTestBase {

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

    public static class getterSetterTest extends DbzTestBase {

        private static KaigoShiharaiJohoBuilder sut;
        private static KaigoShiharaiJoho business;

        @Before
        public void setUp() {
            KaigoShiharaiJohoEntity = new DbT7004KaigoShiharaiJohoEntity();
            KaigoShiharaiJohoEntity.setShikibetsuCode(識別コード);
            KaigoShiharaiJohoEntity.setKamokuCode(科目コード);
            KaigoShiharaiJohoEntity.setKetteiYMD(決定年月日);

            business = new KaigoShiharaiJoho(KaigoShiharaiJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の科目コードは_設定した値と同じ科目コードを返す() {
            business = sut.set科目コード(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_科目コード).build();
            assertThat(business.get科目コード(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_科目コード));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            business = sut.set決定年月日(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_決定年月日).build();
            assertThat(business.get決定年月日(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の支払方法区分は_設定した値と同じ支払方法区分を返す() {
            business = sut.set支払方法区分(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_支払方法区分).build();
            assertThat(business.get支払方法区分(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_支払方法区分));
        }

        @Test
        public void 戻り値の窓口支払場所コードは_設定した値と同じ窓口支払場所コードを返す() {
            business = sut.set窓口支払場所コード(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_窓口支払場所コード).build();
            assertThat(business.get窓口支払場所コード(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_窓口支払場所コード));
        }

        @Test
        public void 戻り値の窓口支払開始年月日時分は_設定した値と同じ窓口支払開始年月日時分を返す() {
            business = sut.set窓口支払開始年月日時分(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_窓口支払開始年月日時分).build();
            assertThat(business.get窓口支払開始年月日時分(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_窓口支払開始年月日時分));
        }

        @Test
        public void 戻り値の窓口支払終了年月日時分は_設定した値と同じ窓口支払終了年月日時分を返す() {
            business = sut.set窓口支払終了年月日時分(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_窓口支払終了年月日時分).build();
            assertThat(business.get窓口支払終了年月日時分(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_窓口支払終了年月日時分));
        }

        @Test
        public void 戻り値の振込予定年月日は_設定した値と同じ振込予定年月日を返す() {
            business = sut.set振込予定年月日(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_振込予定年月日).build();
            assertThat(business.get振込予定年月日(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_振込予定年月日));
        }

        @Test
        public void 戻り値の支払金額は_設定した値と同じ支払金額を返す() {
            business = sut.set支払金額(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_支払金額).build();
            assertThat(business.get支払金額(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_支払金額));
        }

        @Test
        public void 戻り値の種別コードは_設定した値と同じ種別コードを返す() {
            business = sut.set種別コード(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_種別コード).build();
            assertThat(business.get種別コード(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_種別コード));
        }

        @Test
        public void 戻り値の用途区分コードは_設定した値と同じ用途区分コードを返す() {
            business = sut.set用途区分コード(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_用途区分コード).build();
            assertThat(business.get用途区分コード(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_用途区分コード));
        }

        @Test
        public void 戻り値の認証日１は_設定した値と同じ認証日１を返す() {
            business = sut.set認証日１(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証日１).build();
            assertThat(business.get認証日１(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証日１));
        }

        @Test
        public void 戻り値の認証者コード１は_設定した値と同じ認証者コード１を返す() {
            business = sut.set認証者コード１(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証者コード１).build();
            assertThat(business.get認証者コード１(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証者コード１));
        }

        @Test
        public void 戻り値の認証日２は_設定した値と同じ認証日２を返す() {
            business = sut.set認証日２(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証日２).build();
            assertThat(business.get認証日２(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証日２));
        }

        @Test
        public void 戻り値の認証者コード２は_設定した値と同じ認証者コード２を返す() {
            business = sut.set認証者コード２(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証者コード２).build();
            assertThat(business.get認証者コード２(), is(DbT7004KaigoShiharaiJohoEntityGenerator.DEFAULT_認証者コード２));
        }

    }
}
