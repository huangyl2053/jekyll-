/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TandokuJoseikinKyufuShinseiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TandokuJoseikinKyufuShinseiBuilderTest extends DbcTestBase {

    private static DbT3098TandokuJoseikinKyufuShinseiEntity TandokuJoseikinKyufuShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static TandokuJoseikinKyufuShinseiBuilder sut;
        private static TandokuJoseikinKyufuShinsei business;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuShinseiEntity = new DbT3098TandokuJoseikinKyufuShinseiEntity();
            TandokuJoseikinKyufuShinseiEntity.setXXX(主キー名1);
            TandokuJoseikinKyufuShinseiEntity.setXXX(主キー名2);

            business = new TandokuJoseikinKyufuShinsei(TandokuJoseikinKyufuShinseiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            business = sut.set受付年月日(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日).build();
            assertThat(business.get受付年月日(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            business = sut.set申請年月日(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請年月日).build();
            assertThat(business.get申請年月日(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の申請者区分は_設定した値と同じ申請者区分を返す() {
            business = sut.set申請者区分(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者区分).build();
            assertThat(business.get申請者区分(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者区分));
        }

        @Test
        public void 戻り値の申請代行事業者番号は_設定した値と同じ申請代行事業者番号を返す() {
            business = sut.set申請代行事業者番号(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請代行事業者番号).build();
            assertThat(business.get申請代行事業者番号(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請代行事業者番号));
        }

        @Test
        public void 戻り値の事業者区分は_設定した値と同じ事業者区分を返す() {
            business = sut.set事業者区分(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_事業者区分).build();
            assertThat(business.get事業者区分(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_事業者区分));
        }

        @Test
        public void 戻り値の申請者郵便番号は_設定した値と同じ申請者郵便番号を返す() {
            business = sut.set申請者郵便番号(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者郵便番号).build();
            assertThat(business.get申請者郵便番号(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者郵便番号));
        }

        @Test
        public void 戻り値の申請者住所は_設定した値と同じ申請者住所を返す() {
            business = sut.set申請者住所(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者住所).build();
            assertThat(business.get申請者住所(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者住所));
        }

        @Test
        public void 戻り値の申請者電話番号は_設定した値と同じ申請者電話番号を返す() {
            business = sut.set申請者電話番号(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者電話番号).build();
            assertThat(business.get申請者電話番号(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請者電話番号));
        }

        @Test
        public void 戻り値の申請理由は_設定した値と同じ申請理由を返す() {
            business = sut.set申請理由(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請理由).build();
            assertThat(business.get申請理由(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_申請理由));
        }

        @Test
        public void 戻り値の市町村単独助成種類は_設定した値と同じ市町村単独助成種類を返す() {
            business = sut.set市町村単独助成種類(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_市町村単独助成種類).build();
            assertThat(business.get市町村単独助成種類(), is(DbT3098TandokuJoseikinKyufuShinseiEntityGenerator.DEFAULT_市町村単独助成種類));
        }

    }
}
