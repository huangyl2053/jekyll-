/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5102NinteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization._Base64Serializer;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinsakaiNinteiKekkaJoho}のテストクラスです。
 *
 * @author n8223　朴義一
 */
@RunWith(Enclosed.class)
public class ShinsakaiNinteiKekkaJohoTest extends DbdTestBase {

    private static ShinsakaiNinteiKekkaJoho sut;

    public static class getterSetterTest extends DbdTestBase {

        @BeforeClass
        public static void test() {
            sut = new ShinsakaiNinteiKekkaJoho(DbT5102NinteiKekkaJohoEntityGenerator.createDbT5102NinteiKekkaJohoEntity());
        }

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の二次判定年月日は_設定した値と同じ二次判定年月日を返す() {
            assertThat(sut.get二次判定年月日(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定年月日));
        }

        @Test
        public void 戻り値の二次判定要介護状態区分コードは_設定した値と同じ二次判定要介護状態区分コードを返す() {
            assertThat(sut.get二次判定要介護状態区分コード(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定要介護状態区分コード));
        }

        @Test
        public void 戻り値の二次判定認定有効期間は_設定した値と同じ二次判定認定有効期間を返す() {
            assertThat(sut.get二次判定認定有効期間(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定認定有効期間));
        }

        @Test
        public void 戻り値の二次判定認定有効開始年月日は_設定した値と同じ二次判定認定有効開始年月日を返す() {
            assertThat(sut.get二次判定認定有効開始年月日(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定認定有効開始年月日));
        }

        @Test
        public void 戻り値の二次判定認定有効終了年月日は_設定した値と同じ二次判定認定有効終了年月日を返す() {
            assertThat(sut.get二次判定認定有効終了年月日(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定認定有効終了年月日));
        }

        @Test
        public void 戻り値の介護認定審査会開催番号は_設定した値と同じ介護認定審査会開催番号を返す() {
            assertThat(sut.get介護認定審査会開催番号(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号));
        }

        @Test
        public void 戻り値の介護認定審査会意見は_設定した値と同じ介護認定審査会意見を返す() {
            assertThat(sut.get介護認定審査会意見(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_介護認定審査会意見));
        }

        @Test
        public void 戻り値の一次判定結果変更理由は_設定した値と同じ一次判定結果変更理由を返す() {
            assertThat(sut.get一次判定結果変更理由(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_一次判定結果変更理由));
        }

        @Test
        public void 戻り値の要介護状態像例コードは_設定した値と同じ要介護状態像例コードを返す() {
            assertThat(sut.get要介護状態像例コード(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_要介護状態像例コード));
        }

        @Test
        public void 戻り値の認定審査会意見種類は_設定した値と同じ認定審査会意見種類を返す() {
            assertThat(sut.get認定審査会意見種類(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_認定審査会意見種類));
        }

        @Test
        public void 戻り値の審査会メモは_設定した値と同じ審査会メモを返す() {
            assertThat(sut.get審査会メモ(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_審査会メモ));
        }

        @Test
        public void 戻り値の二次判定結果入力方法は_設定した値と同じ二次判定結果入力方法を返す() {
            assertThat(sut.get二次判定結果入力方法(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定結果入力方法));
        }

        @Test
        public void 戻り値の二次判定結果入力年月日は_設定した値と同じ二次判定結果入力年月日を返す() {
            assertThat(sut.get二次判定結果入力年月日(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定結果入力年月日));
        }

    }

    public static class BuilderTest extends DbdTestBase {

        @Test
        public void setShinseishoKanriNoで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setShinseishoKanriNo(new ShinseishoKanriNo("00000000000000002")).build();
            assertThat(result.get申請書管理番号().value(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号.value()));
        }

        @Test
        public void setNijiHanteiYMDで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setNijiHanteiYMD(new FlexibleDate("20150604")).build();
            assertThat(result.get二次判定年月日(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定年月日));
        }

        @Test
        public void setNijiHanteiYokaigoJotaiKubunCodeで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setNijiHanteiYokaigoJotaiKubunCode(new Code("21")).build();
            assertThat(result.get二次判定要介護状態区分コード().value(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定要介護状態区分コード.value()));
        }

        @Test
        public void setNijiHanteiNinteiYukoKikanで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setNijiHanteiNinteiYukoKikan(1).build();
            assertThat(result.get二次判定認定有効期間(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定認定有効期間));
        }

        @Test
        public void setNijiHanteiNinteiYukoKaishiYMDで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setNijiHanteiNinteiYukoKaishiYMD(new FlexibleDate("20150604")).build();
            assertThat(result.get二次判定認定有効開始年月日(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定認定有効開始年月日));
        }

        @Test
        public void setNijiHanteiNinteiYukoShuryoYMDで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setNijiHanteiNinteiYukoShuryoYMD(new FlexibleDate("20150605")).build();
            assertThat(result.get二次判定認定有効終了年月日(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定認定有効終了年月日));
        }

        @Test
        public void setShinsakaiKaisaiNoで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setShinsakaiKaisaiNo(1).build();
            assertThat(result.get介護認定審査会開催番号(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号));
        }

        @Test
        public void setShinsakaiIkenで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setShinsakaiIken(new RString("介護認定審査会意見")).build();
            assertThat(result.get介護認定審査会意見(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_介護認定審査会意見));
        }

        @Test
        public void setIchijiHnateiKekkaHenkoRiyuで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setIchijiHnateiKekkaHenkoRiyu(new RString("一次判定結果変更理由")).build();
            assertThat(result.get一次判定結果変更理由(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_一次判定結果変更理由));
        }

        @Test
        public void setYokaigoJotaizoReiCodeで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setYokaigoJotaizoReiCode(new Code("99")).build();
            assertThat(result.get要介護状態像例コード(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_要介護状態像例コード));
        }

        @Test
        public void setNinteishinsakaiIkenShuruiで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setNinteishinsakaiIkenShurui(new RString("認定審査会意見種類")).build();
            assertThat(result.get認定審査会意見種類(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_認定審査会意見種類));
        }

        @Test
        public void setShinsakaiMemoで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setShinsakaiMemo(new RString("審査会メモ")).build();
            assertThat(result.get審査会メモ(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_審査会メモ));
        }

        @Test
        public void setNijiHanteiKekkaInputHohoで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setNijiHanteiKekkaInputHoho(new Code("1")).build();
            assertThat(result.get二次判定結果入力方法(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定結果入力方法));
        }

        @Test
        public void setNiniHanteiKekkaInputYMDで設定した値を＿生成されたHokenshaShinseitodokedeJohoも保持する() {
            ShinsakaiNinteiKekkaJoho result = ShinsakaiNinteiKekkaJoho.newBuilder().setNiniHanteiKekkaInputYMD(new FlexibleDate("20150604")).build();
            assertThat(result.get二次判定結果入力年月日(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_二次判定結果入力年月日));
        }

    }

    public static class SerializationProxyTest {

        private ShinsakaiNinteiKekkaJoho sut;

        @Before
        public void setUp() {
            sut = ShinsakaiNinteiKekkaJoho.newBuilder().build();
        }

        @Test
        public void serializeの戻り値の都道府県名は_デシリアライズすると_同じ都道府県名を持ったインスタンスを生成する() {
            sut.createBuilderForEdit().setShinseishoKanriNo(new ShinseishoKanriNo("00000000000000002"));
            String b64 = _Base64Serializer.serialize(sut.serialize());
            ShinsakaiNinteiKekkaJoho desirialized = _Base64Serializer.deSerialize(b64, ShinsakaiNinteiKekkaJoho.class);
            assertThat(desirialized.get申請書管理番号(), is(sut.get申請書管理番号()));
        }

    }

}
