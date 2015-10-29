/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJigyoshaBuilder}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoJigyoshaBuilderTest extends DbxTestBase {

    private static DbT7060KaigoJigyoshaEntity KaigoJigyoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KaigoJigyoshaNo 主キー名1;
    private static FlexibleDate 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
        主キー名2 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
    }

    public static class getterSetterTest extends DbxTestBase {

        private static KaigoJigyoshaBuilder sut;
        private static KaigoJigyosha business;

        @Before
        public void setUp() {
            KaigoJigyoshaEntity = new DbT7060KaigoJigyoshaEntity();
            KaigoJigyoshaEntity.setJigyoshaNo(主キー名1);
            KaigoJigyoshaEntity.setYukoKaishiYMD(主キー名2);

            business = new KaigoJigyosha(KaigoJigyoshaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の有効開始日は_設定した値と同じ有効開始日を返す() {
            business = sut.set有効開始日(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日).build();
            assertThat(business.get有効開始日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日));
        }

        @Test
        public void 戻り値の有効終了日は_設定した値と同じ有効終了日を返す() {
            business = sut.set有効終了日(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効終了日).build();
            assertThat(business.get有効終了日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効終了日));
        }

        @Test
        public void 戻り値の異動日は_設定した値と同じ異動日を返す() {
            business = sut.set異動日(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_異動日).build();
            assertThat(business.get異動日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_異動日));
        }

        @Test
        public void 戻り値の異動事由は_設定した値と同じ異動事由を返す() {
            business = sut.set異動事由(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_異動事由).build();
            assertThat(business.get異動事由(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_異動事由));
        }

        @Test
        public void 戻り値の事業開始日は_設定した値と同じ事業開始日を返す() {
            business = sut.set事業開始日(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業開始日).build();
            assertThat(business.get事業開始日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業開始日));
        }

        @Test
        public void 戻り値の事業休止日は_設定した値と同じ事業休止日を返す() {
            business = sut.set事業休止日(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業休止日).build();
            assertThat(business.get事業休止日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業休止日));
        }

        @Test
        public void 戻り値の事業再開日は_設定した値と同じ事業再開日を返す() {
            business = sut.set事業再開日(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業再開日).build();
            assertThat(business.get事業再開日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業再開日));
        }

        @Test
        public void 戻り値の事業廃止日は_設定した値と同じ事業廃止日を返す() {
            business = sut.set事業廃止日(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業廃止日).build();
            assertThat(business.get事業廃止日(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業廃止日));
        }

        @Test
        public void 戻り値の事業者名称は_設定した値と同じ事業者名称を返す() {
            business = sut.set事業者名称(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者名称).build();
            assertThat(business.get事業者名称(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者名称));
        }

        @Test
        public void 戻り値の事業者名称カナは_設定した値と同じ事業者名称カナを返す() {
            business = sut.set事業者名称カナ(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者名称カナ).build();
            assertThat(business.get事業者名称カナ(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者名称カナ));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            business = sut.set郵便番号(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_郵便番号).build();
            assertThat(business.get郵便番号(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の事業者住所は_設定した値と同じ事業者住所を返す() {
            business = sut.set事業者住所(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者住所).build();
            assertThat(business.get事業者住所(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者住所));
        }

        @Test
        public void 戻り値の事業者住所カナは_設定した値と同じ事業者住所カナを返す() {
            business = sut.set事業者住所カナ(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者住所カナ).build();
            assertThat(business.get事業者住所カナ(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者住所カナ));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            business = sut.set電話番号(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_電話番号).build();
            assertThat(business.get電話番号(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値のFAX番号は_設定した値と同じFAX番号を返す() {
            business = sut.setFax番号(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_FAX番号).build();
            assertThat(business.getFAX番号(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_FAX番号));
        }

        @Test
        public void 戻り値の宛先部署は_設定した値と同じ宛先部署を返す() {
            business = sut.set宛先部署(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_宛先部署).build();
            assertThat(business.get宛先部署(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_宛先部署));
        }

        @Test
        public void 戻り値の宛先人名は_設定した値と同じ宛先人名を返す() {
            business = sut.set宛先人名(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_宛先人名).build();
            assertThat(business.get宛先人名(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_宛先人名));
        }

        @Test
        public void 戻り値の宛先人名カナは_設定した値と同じ宛先人名カナを返す() {
            business = sut.set宛先人名カナ(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_宛先人名カナ).build();
            assertThat(business.get宛先人名カナ(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_宛先人名カナ));
        }

        @Test
        public void 戻り値の指定_基準該当等事業所区分は_設定した値と同じ指定_基準該当等事業所区分を返す() {
            business = sut.set指定_基準該当等事業所区分(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_指定_基準該当等事業所区分).build();
            assertThat(business.get指定_基準該当等事業所区分(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_指定_基準該当等事業所区分));
        }

        @Test
        public void 戻り値の所在市町村は_設定した値と同じ所在市町村を返す() {
            business = sut.set所在市町村(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_所在市町村).build();
            assertThat(business.get所在市町村(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_所在市町村));
        }

        @Test
        public void 戻り値のサービス実施地域は_設定した値と同じサービス実施地域を返す() {
            business = sut.setサービス実施地域(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_サービス実施地域).build();
            assertThat(business.getサービス実施地域(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_サービス実施地域));
        }

        @Test
        public void 戻り値の法人等種別は_設定した値と同じ法人等種別を返す() {
            business = sut.set法人等種別(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_法人等種別).build();
            assertThat(business.get法人等種別(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_法人等種別));
        }

        @Test
        public void 戻り値のベッド数は_設定した値と同じベッド数を返す() {
            business = sut.setベッド数(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_ベッド数).build();
            assertThat(business.getベッド数(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_ベッド数));
        }

        @Test
        public void 戻り値の所属人数は_設定した値と同じ所属人数を返す() {
            business = sut.set所属人数(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_所属人数).build();
            assertThat(business.get所属人数(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_所属人数));
        }

        @Test
        public void 戻り値の利用者数は_設定した値と同じ利用者数を返す() {
            business = sut.set利用者数(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_利用者数).build();
            assertThat(business.get利用者数(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_利用者数));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            business = sut.set備考(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_備考).build();
            assertThat(business.get備考(), is(DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_備考));
        }

    }
}
