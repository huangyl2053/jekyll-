/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.KaigoNinteichosain;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;
import static jp.co.ndensan.reams.db.dbe.entity.helper.KaigoNinteichosainTestHelper.*;
import jp.co.ndensan.reams.db.dbe.entity.helper.MockNinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * 介護認定調査員のMapperクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KaigoNinteichosainMapperTest extends TestBase {

    public static class toKaigoNinteichosain extends TestBase {

        KaigoNinteichosain sut;

        @Override
        public void setUp() {
            sut = KaigoNinteichosainMapper.toKaigoNinteichosain(create認定調査員Entity(), MockNinteichosaItakusakiJohoEntity.getSpiedInstance());
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査員entityにnullがわたったとき_NullpointerExceptionが発生する() {
            sut = KaigoNinteichosainMapper.toKaigoNinteichosain(null, MockNinteichosaItakusakiJohoEntity.getSpiedInstance());
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査委託先entityにnullがわたったとき_NullpointerExceptionが発生する() {
            sut = KaigoNinteichosainMapper.toKaigoNinteichosain(create認定調査員Entity(), null);
        }

        @Test
        public void 認定調査員entityから渡された市町村コードと_Mapping後の認定調査員が返す市町村コードが_同一になる() {
            assertThat(sut.get市町村コード(), is(市町村コード));
        }

        @Test
        public void 認定調査員entityから渡された介護事業者番号と_Mapping後の認定調査員が返す介護事業者番号が_同一になる() {
            assertThat(sut.get介護事業者番号(), is(介護事業者番号));
        }

        @Test
        public void 認定調査員entityから渡された介護調査員番号と_Mapping後の認定調査員が返す介護調査員番号が_同一になる() {
            assertThat(sut.get介護調査員番号().value(), is(介護調査員番号));
        }

        @Test
        public void 認定調査員entityから渡された事業者番号と_Mapping後の認定調査員が返す事業者番号が_同一になる() {
            assertThat(sut.get事業者番号(), is(事業者番号));
        }

        @Test
        public void 認定調査員entityから渡された調査員状況と_Mapping後の認定調査員が返す調査員状況が_同一になる() {
            assertThat(sut.is調査員状況(), is(調査員状況));
        }

        @Test
        public void 認定調査員entityから渡された調査員氏名と_Mapping後の認定調査員が返す調査員氏名が_同一になる() {
            assertThat(sut.get調査員氏名(), is(調査員氏名));
        }

        @Test
        public void 認定調査員entityから渡された調査員氏名カナと_Mapping後の認定調査員が返す調査員氏名カナが_同一になる() {
            assertThat(sut.get調査員氏名カナ(), is(調査員氏名カナ));
        }

        @Test
        public void 認定調査員entityから渡された性別と_Mapping後の認定調査員が返す性別が_同一になる() {
            assertThat(sut.get性別(), is(性別));
        }

        @Test
        public void 認定調査員entityから渡された調査員資格コードと_Mapping後の認定調査員が返す調査員資格コードが_同一になる() {
            assertThat(sut.get調査員資格コード(), is(調査員資格コード));
        }

        @Test
        public void 認定調査員entityから渡された地区コードと_Mapping後の認定調査員が返す地区コードが_同一になる() {
            assertThat(sut.get地区コード(), is(地区コード));
        }

        @Test
        public void 認定調査員entityから渡された郵便番号と_Mapping後の認定調査員が返す郵便番号が_同一になる() {
            assertThat(sut.get郵便番号(), is(郵便番号));
        }

        @Test
        public void 認定調査員entityから渡された住所と_Mapping後の認定調査員が返す住所が_同一になる() {
            assertThat(sut.get住所(), is(住所));
        }

        @Test
        public void 認定調査員entityから渡された電話番号と_Mapping後の認定調査員が返す電話番号が_同一になる() {
            assertThat(sut.get電話番号(), is(電話番号));
        }

        @Test
        public void 認定調査委託先entityから渡された介護事業者番号と_Mapping後の認定調査員が返す_認定調査委託先の介護事業者番号が_同一になる() {
            assertThat(sut.get認定調査委託先().getKaigoJigyoshaNo().value(), is(new RString("0000000001")));
        }
    }

    public static class toKaigoNinteichosainEntity extends TestBase {

        DbT7013ChosainJohoEntity sut;

        @Override
        public void setUp() {
            sut = KaigoNinteichosainMapper.toKaigoNinteichosainEntity(create認定調査員());
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査員クラスにnullがわたったとき_NullpointerExceptionが発生する() {
            sut = KaigoNinteichosainMapper.toKaigoNinteichosainEntity(null);
        }

        @Test
        public void 渡された認定調査員クラスの市町村コードと_認定調査員エンティティの市町村コードが_同一になる() {
            assertThat(sut.getShichosonCode(), is(市町村コード));
        }

        @Test
        public void 渡された認定調査員クラスの介護事業者番号と_認定調査員エンティティの介護事業者番号が_同一になる() {
            assertThat(sut.getKaigoJigyoshaNo(), is(介護事業者番号));
        }

        @Test
        public void 渡された認定調査員クラスの介護調査員番号と_認定調査員エンティティの介護調査員番号が_同一になる() {
            assertThat(sut.getKaigoChosainNo(), is(介護調査員番号));
        }

        @Test
        public void 渡された認定調査員クラスの事業者番号と_認定調査員エンティティの事業者番号が_同一になる() {
            assertThat(sut.getJigyoshaNo(), is(事業者番号));
        }

        @Test
        public void 渡された認定調査員クラスの調査員状況と_認定調査員エンティティの調査員状況が_同一になる() {
            assertThat(sut.getKaigoChosainJokyo(), is(調査員状況));
        }

        @Test
        public void 渡された認定調査員クラスの調査員氏名と_認定調査員エンティティの調査員氏名が_同一になる() {
            assertThat(sut.getChosainShimei(), is(調査員氏名));
        }

        @Test
        public void 渡された認定調査員クラスの調査員氏名カナと_認定調査員エンティティの調査員氏名カナが_同一になる() {
            assertThat(sut.getChosainKanaShimei(), is(調査員氏名カナ));
        }

        @Test
        public void 渡された認定調査員クラスの性別と_認定調査員エンティティの性別が_同一になる() {
            assertThat(sut.getSeibetsu(), is(性別));
        }

        @Test
        public void 渡された認定調査員クラスの調査員資格コードと_認定調査員エンティティの調査員資格コードが_同一になる() {
            assertThat(sut.getChosainShikakuCode(), is(調査員資格コード));
        }

        @Test
        public void 渡された認定調査員クラスの地区コードと_認定調査員エンティティの地区コードが_同一になる() {
            assertThat(sut.getChikuCode(), is(地区コード));
        }

        @Test
        public void 渡された認定調査員クラスの郵便番号と_認定調査員エンティティの郵便番号が_同一になる() {
            assertThat(sut.getYubinNo(), is(郵便番号));
        }

        @Test
        public void 渡された認定調査員クラスの住所と_認定調査員エンティティの住所が_同一になる() {
            assertThat(sut.getJusho(), is(住所));
        }

        @Test
        public void 渡された認定調査員クラスの電話番号と_認定調査員エンティティの電話番号が_同一になる() {
            assertThat(sut.getTelNo(), is(電話番号));
        }
    }
}
