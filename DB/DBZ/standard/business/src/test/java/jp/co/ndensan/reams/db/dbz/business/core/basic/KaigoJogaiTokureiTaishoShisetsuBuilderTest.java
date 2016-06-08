/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsuBuilder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJogaiTokureiTaishoShisetsuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJogaiTokureiTaishoShisetsuBuilderTest extends DbzTestBase {

    private static DbT1005KaigoJogaiTokureiTaishoShisetsuEntity KaigoJogaiTokureiTaishoShisetsuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 事業者種別;
    private static RString 事業者番号;
    private static FlexibleDate 有効開始日時;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        事業者種別 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別;
        事業者番号 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号;
        有効開始日時 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効開始年月日;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KaigoJogaiTokureiTaishoShisetsuBuilder sut;
        private static KaigoJogaiTokureiTaishoShisetsu business;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuEntity = new DbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaShubetsu(事業者種別);
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaNo(事業者番号);
            KaigoJogaiTokureiTaishoShisetsuEntity.setYukoKaishiYMD(有効開始日時);

            business = new KaigoJogaiTokureiTaishoShisetsu(KaigoJogaiTokureiTaishoShisetsuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の事業者種別は_設定した値と同じ事業者種別を返す() {
            business = sut.set事業者種別(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別).build();
            assertThat(business.get事業者種別(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の有効開始年月日は_設定した値と同じ有効開始年月日を返す() {
            business = sut.set有効開始年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効開始年月日).build();
            assertThat(business.get有効開始年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効開始年月日));
        }

        @Test
        public void 戻り値の有効終了年月日は_設定した値と同じ有効終了年月日を返す() {
            business = sut.set有効終了年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効終了年月日).build();
            assertThat(business.get有効終了年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効終了年月日));
        }

        @Test
        public void 戻り値の管内_管外区分は_設定した値と同じ管内_管外区分を返す() {
            business = sut.set管内_管外区分(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_管内管外区分).build();
            assertThat(business.get管内_管外区分(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_管内管外区分));
        }

        @Test
        public void 戻り値の事業者名称は_設定した値と同じ事業者名称を返す() {
            business = sut.set事業者名称(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者名称).build();
            assertThat(business.get事業者名称(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者名称));
        }

        @Test
        public void 戻り値の事業者名称カナは_設定した値と同じ事業者名称カナを返す() {
            business = sut.set事業者名称カナ(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者名称カナ).build();
            assertThat(business.get事業者名称カナ(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者名称カナ));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            business = sut.set郵便番号(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_郵便番号).build();
            assertThat(business.get郵便番号(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の事業者住所は_設定した値と同じ事業者住所を返す() {
            business = sut.set事業者住所(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者住所).build();
            assertThat(business.get事業者住所(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者住所));
        }

        @Test
        public void 戻り値の事業者住所カナは_設定した値と同じ事業者住所カナを返す() {
            business = sut.set事業者住所カナ(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者住所カナ).build();
            assertThat(business.get事業者住所カナ(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者住所カナ));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            business = sut.set電話番号(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_電話番号).build();
            assertThat(business.get電話番号(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値のFAX番号は_設定した値と同じFAX番号を返す() {
            business = sut.setFax番号(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_FAX番号).build();
            assertThat(business.getFAX番号(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_FAX番号));
        }

        @Test
        public void 戻り値の異動事由は_設定した値と同じ異動事由を返す() {
            business = sut.set異動事由(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_異動事由).build();
            assertThat(business.get異動事由(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_異動事由));
        }

        @Test
        public void 戻り値の異動年月日は_設定した値と同じ異動年月日を返す() {
            business = sut.set異動年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_異動年月日).build();
            assertThat(business.get異動年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_異動年月日));
        }

        @Test
        public void 戻り値の代表者名称は_設定した値と同じ代表者名称を返す() {
            business = sut.set代表者名称(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_代表者名称).build();
            assertThat(business.get代表者名称(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_代表者名称));
        }

        @Test
        public void 戻り値の代表者名称カナは_設定した値と同じ代表者名称カナを返す() {
            business = sut.set代表者名称カナ(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_代表者名称カナ).build();
            assertThat(business.get代表者名称カナ(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_代表者名称カナ));
        }

        @Test
        public void 戻り値の役職は_設定した値と同じ役職を返す() {
            business = sut.set役職(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_役職).build();
            assertThat(business.get役職(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_役職));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            business = sut.set備考(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_備考).build();
            assertThat(business.get備考(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_備考));
        }

        @Test
        public void 戻り値の事業開始年月日は_設定した値と同じ事業開始年月日を返す() {
            business = sut.set事業開始年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業開始年月日).build();
            assertThat(business.get事業開始年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業開始年月日));
        }

        @Test
        public void 戻り値の事業休止年月日は_設定した値と同じ事業休止年月日を返す() {
            business = sut.set事業休止年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業休止年月日).build();
            assertThat(business.get事業休止年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業休止年月日));
        }

        @Test
        public void 戻り値の事業廃止年月日は_設定した値と同じ事業廃止年月日を返す() {
            business = sut.set事業廃止年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業廃止年月日).build();
            assertThat(business.get事業廃止年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業廃止年月日));
        }

        @Test
        public void 戻り値の事業再開年月日は_設定した値と同じ事業再開年月日を返す() {
            business = sut.set事業再開年月日(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業再開年月日).build();
            assertThat(business.get事業再開年月日(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業再開年月日));
        }

    }
}
