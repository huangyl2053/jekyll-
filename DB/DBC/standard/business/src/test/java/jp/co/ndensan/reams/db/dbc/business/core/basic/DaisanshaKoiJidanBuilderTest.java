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
 * {@link DaisanshaKoiJidanBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiJidanBuilderTest extends DbcTestBase {

    private static DbT3080DaisanshaKoiJidanEntity DaisanshaKoiJidanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static DaisanshaKoiJidanBuilder sut;
        private static DaisanshaKoiJidan business;

        @Before
        public void setUp() {
            DaisanshaKoiJidanEntity = new DbT3080DaisanshaKoiJidanEntity();
            DaisanshaKoiJidanEntity.setXXX(主キー名1);
            DaisanshaKoiJidanEntity.setXXX(主キー名2);

            business = new DaisanshaKoiJidan(DaisanshaKoiJidanEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の第三者行為届出管理番号は_設定した値と同じ第三者行為届出管理番号を返す() {
            business = sut.set第三者行為届出管理番号(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_第三者行為届出管理番号).build();
            assertThat(business.get第三者行為届出管理番号(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_第三者行為届出管理番号));
        }

        @Test
        public void 戻り値の示談報告書受付年月日は_設定した値と同じ示談報告書受付年月日を返す() {
            business = sut.set示談報告書受付年月日(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談報告書受付年月日).build();
            assertThat(business.get示談報告書受付年月日(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談報告書受付年月日));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の第三者行為求償協議区分は_設定した値と同じ第三者行為求償協議区分を返す() {
            business = sut.set第三者行為求償協議区分(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_第三者行為求償協議区分).build();
            assertThat(business.get第三者行為求償協議区分(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_第三者行為求償協議区分));
        }

        @Test
        public void 戻り値の示談報告書提出年月日は_設定した値と同じ示談報告書提出年月日を返す() {
            business = sut.set示談報告書提出年月日(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談報告書提出年月日).build();
            assertThat(business.get示談報告書提出年月日(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談報告書提出年月日));
        }

        @Test
        public void 戻り値の示談成立年月日は_設定した値と同じ示談成立年月日を返す() {
            business = sut.set示談成立年月日(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談成立年月日).build();
            assertThat(business.get示談成立年月日(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談成立年月日));
        }

        @Test
        public void 戻り値の給付期間開始年月は_設定した値と同じ給付期間開始年月を返す() {
            business = sut.set給付期間開始年月(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_給付期間開始年月).build();
            assertThat(business.get給付期間開始年月(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_給付期間開始年月));
        }

        @Test
        public void 戻り値の給付期間終了年月は_設定した値と同じ給付期間終了年月を返す() {
            business = sut.set給付期間終了年月(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_給付期間終了年月).build();
            assertThat(business.get給付期間終了年月(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_給付期間終了年月));
        }

        @Test
        public void 戻り値の過失割合・加害者は_設定した値と同じ過失割合・加害者を返す() {
            business = sut.set過失割合・加害者(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_過失割合・加害者).build();
            assertThat(business.get過失割合・加害者(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_過失割合・加害者));
        }

        @Test
        public void 戻り値の過失割合・被害者は_設定した値と同じ過失割合・被害者を返す() {
            business = sut.set過失割合・被害者(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_過失割合・被害者).build();
            assertThat(business.get過失割合・被害者(), is(DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_過失割合・被害者));
        }

    }
}
