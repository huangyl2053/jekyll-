/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.RenkeiyoDataSofuKiroku;
import jp.co.ndensan.reams.db.dbe.definition.HikiwatashiKubun;
import jp.co.ndensan.reams.db.dbe.definition.NinteiShinseijiKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiChousaSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiIkenshoSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiSoufuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.realservice.helper.RenkeiyoDataSofuKirokuDacMock;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.is;

/**
 * 連携用データ送付記録の情報を管理するクラスのテストクラスです。
 *
 * @author n8107 千秋雄
 */
@RunWith(Enclosed.class)
public class RenkeiyoDataSofuKirokuManagerTest extends TestBase {

    public static class get連携用データ送付記録 extends TestBase {

        private static RenkeiyoDataSofuKirokuManager sut;

        @Override
        protected void setUp() {
            sut = new RenkeiyoDataSofuKirokuManager(new RenkeiyoDataSofuKirokuDacMock());
        }

        @Test
        public void 申請書管理番号_1000000001_指定したとき_申請書管理番号に1000000001を持つ連携用データ送付記録情報が返る() {
            RString 申請書管理番号 = new RString("100000001");
            RenkeiyoDataSofuKiroku selected = sut.get連携用データ送付記録(申請書管理番号);
            assertThat(selected.get申請書管理番号().value(), is(申請書管理番号));
        }

        @Test
        public void 指定した申請書管理番号から_検索結果が得られないときは_nullを返す() {
            RString 申請書管理番号 = new RString("検索不可");
            RenkeiyoDataSofuKiroku selected = sut.get連携用データ送付記録(申請書管理番号);
            assertThat(selected, nullValue());
        }
    }

    public static class get連携用データ送付記録リスト_被保険者番号 extends TestBase {

        private static RenkeiyoDataSofuKirokuManager sut;

        @Override
        protected void setUp() {
            sut = new RenkeiyoDataSofuKirokuManager(new RenkeiyoDataSofuKirokuDacMock());
        }

        @Test
        public void 被保険者番号_H000000001_指定したとき_被保険者番号にH000000001を持つ連携用データ送付記録情報が返る() {
            RString 被保険者番号 = new RString("H00000001");
            List<RenkeiyoDataSofuKiroku> selectlist = sut.get連携用データ送付記録リスト(被保険者番号);
            assertThat(selectlist.get(0).get被保険者番号().getColumnValue(), is(被保険者番号));
        }

        @Test
        public void 指定した被保険者番号から_検索結果が得られないときは_返り値のsizeは0() {
            RString 被保険者番号 = new RString("検索不可");
            List<RenkeiyoDataSofuKiroku> selectlist = sut.get連携用データ送付記録リスト(被保険者番号);
            assertThat(selectlist.size(), is(0));
        }
    }

    public static class get連携用データ送付記録リスト_認定申請時区分 extends TestBase {

        private static RenkeiyoDataSofuKirokuManager sut;

        @Override
        protected void setUp() {
            sut = new RenkeiyoDataSofuKirokuManager(new RenkeiyoDataSofuKirokuDacMock());
        }

        @Test
        public void 認定申請時区分_1_指定したとき_認定申請時区分に1を持つ連携用データ送付記録情報が返る() {
            RString 認定申請時区分 = new RString("01");
            List<RenkeiyoDataSofuKiroku> selectlist = sut.get連携用データ送付記録リスト(認定申請時区分);
            assertThat(selectlist.get(0).get認定申請時区分().getCode(), is(認定申請時区分));
        }
    }

    public static class get連携用データ送付記録リスト_引渡し区分 extends TestBase {

        private static RenkeiyoDataSofuKirokuManager sut;

        @Override
        protected void setUp() {
            sut = new RenkeiyoDataSofuKirokuManager(new RenkeiyoDataSofuKirokuDacMock());
        }

        @Test
        public void 引渡し区分_0_指定したとき_引渡し区分に0を持つ連携用データ送付記録情報が返る() {
            RString 引渡し区分 = new RString("0");
            List<RenkeiyoDataSofuKiroku> selectlist = sut.get連携用データ送付記録リスト(引渡し区分);
            assertThat(selectlist.get(0).get引渡し区分().getCode(), is(引渡し区分));
        }
    }

    public static class get連携用データ送付記録リスト_引渡し日時 extends TestBase {

        private static RenkeiyoDataSofuKirokuManager sut;

        @Override
        protected void setUp() {
            sut = new RenkeiyoDataSofuKirokuManager(new RenkeiyoDataSofuKirokuDacMock());
        }

        @Test
        public void 引渡し日時_20140314184505_指定したとき_引渡し日時に20140314184505を持つ連携用データ送付記録情報が返る() {
            RDateTime 引渡し日時 = RDateTime.of(2014, 03, 14, 18, 45, 05);
            List<RenkeiyoDataSofuKiroku> selectlist = sut.get連携用データ送付記録リスト(引渡し日時);
            assertThat(selectlist.get(0).get引渡し日時(), is(引渡し日時));
        }
    }

    public static class get連携用データ送付記録リスト_再送付区分 extends TestBase {

        private static RenkeiyoDataSofuKirokuManager sut;

        @Override
        protected void setUp() {
            sut = new RenkeiyoDataSofuKirokuManager(new RenkeiyoDataSofuKirokuDacMock());
        }

        @Test
        public void 再送付区分_01_指定したとき_再送付区分に01を持つ連携用データ送付記録情報が返る() {
            RString 再送付区分 = new RString("01");
            List<RenkeiyoDataSofuKiroku> selectlist = sut.get連携用データ送付記録リスト(再送付区分);
            assertThat(selectlist.get(0).get再送付区分().getCode(), is(再送付区分));

        }
    }

    public static class get連携用データ送付記録リスト_再調査送付区分 extends TestBase {

        private static RenkeiyoDataSofuKirokuManager sut;

        @Override
        protected void setUp() {
            sut = new RenkeiyoDataSofuKirokuManager(new RenkeiyoDataSofuKirokuDacMock());
        }

        @Test
        public void 再調査送付区分_0_指定したとき_再調査送付区分に0を持つ連携用データ送付記録情報が返る() {
            RString 再調査送付区分 = new RString("0");
            List<RenkeiyoDataSofuKiroku> selectlist = sut.get連携用データ送付記録リスト(再調査送付区分);
            assertThat(selectlist.get(0).get再調査送付区分().getCode(), is(再調査送付区分));

        }
    }

    public static class get連携用データ送付記録リスト_再意見書送付区分 extends TestBase {

        private static RenkeiyoDataSofuKirokuManager sut;

        @Override
        protected void setUp() {
            sut = new RenkeiyoDataSofuKirokuManager(new RenkeiyoDataSofuKirokuDacMock());
        }

        @Test
        public void 再意見書送付区分_0_指定したとき_再意見書送付区分に0を持つ連携用データ送付記録情報が返る() {
            RString 再意見書送付区分 = new RString("0");
            List<RenkeiyoDataSofuKiroku> selectlist = sut.get連携用データ送付記録リスト(再意見書送付区分);
            assertThat(selectlist.get(0).get再意見書送付区分().getCode(), is(再意見書送付区分));
        }
    }

    public static class Save extends TestBase {

        private static RenkeiyoDataSofuKirokuManager sut;

        @Override
        protected void setUp() {
            sut = new RenkeiyoDataSofuKirokuManager(new RenkeiyoDataSofuKirokuDacMock());
        }

        @Test
        public void saveに成功しないときは_falseを返す() {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("100000001"));
            RenkeiyoDataSofuKiroku 連携用データ送付記録 = RenkeiData(申請書管理番号);
            boolean result = sut.save(連携用データ送付記録);
            assertThat(result, is(false));
        }

        @Test
        public void saveに成功したとき_trueを返す() {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("更新可能"));
            RenkeiyoDataSofuKiroku 連携用データ送付記録 = RenkeiData(申請書管理番号);
            boolean result = sut.save(連携用データ送付記録);
            assertThat(result, is(true));
        }
    }

    public static class Delete extends TestBase {

        private static RenkeiyoDataSofuKirokuManager sut;

        @Override
        protected void setUp() {
            sut = new RenkeiyoDataSofuKirokuManager(new RenkeiyoDataSofuKirokuDacMock());
        }

        @Test
        public void deleteできないときは_falseを返す() {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("100000001"));
            RenkeiyoDataSofuKiroku 連携用データ送付記録 = RenkeiData(申請書管理番号);
            boolean result = sut.remove(連携用データ送付記録);
            assertThat(result, is(false));
        }

        @Test
        public void deleteに成功したとき_trueを返す() {
            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("削除可能"));
            RenkeiyoDataSofuKiroku 連携用データ送付記録 = RenkeiData(申請書管理番号);
            boolean result = sut.remove(連携用データ送付記録);
            assertThat(result, is(true));
        }
    }

    private static RenkeiyoDataSofuKiroku RenkeiData(ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        KaigoHihokenshaNo 被保険者番号 = new KaigoHihokenshaNo(new RString("H00000001"));
        NinteiShinseijiKubun 認定申請時区分 = NinteiShinseijiKubun.新規申請;
        HikiwatashiKubun 引渡し区分 = HikiwatashiKubun.引き渡し未済;
        SaiSoufuKubun 再送付区分 = SaiSoufuKubun.再送信;
        SaiChousaSoufuKubun 再調査送付区分 = SaiChousaSoufuKubun.未使用;
        SaiIkenshoSoufuKubun 再意見書送付区分 = SaiIkenshoSoufuKubun.未使用;
        RenkeiyoDataSofuKiroku 連携用データ送付記録 = new RenkeiyoDataSofuKiroku(
                申請書管理番号, 被保険者番号, 認定申請時区分, 引渡し区分,
                RDateTime.of(2014, 03, 14, 18, 45, 05),
                再送付区分, 再調査送付区分, 再意見書送付区分);
        return 連携用データ送付記録;
    }
}
