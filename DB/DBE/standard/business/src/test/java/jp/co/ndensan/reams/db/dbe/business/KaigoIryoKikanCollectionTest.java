/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikan;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 介護医療機関コレクションクラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KaigoIryoKikanCollectionTest extends TestBase {

    private static KaigoIryoKikanCollection sut;
    private static List<KaigoIryoKikan> kaigoIryoKikanList;

    public static class コンストラクタのテスト extends TestBase {

        @Test
        public void 必須項目がそろっているとき_インスタンスが生成される() {
            kaigoIryoKikanList = mock(List.class);
            sut = new KaigoIryoKikanCollection(kaigoIryoKikanList);
            assertThat(sut, instanceOf(KaigoIryoKikanCollection.class));
        }

        @Test(expected = NullPointerException.class)
        public void 引数からnullが渡されたとき_NullPointerExceptionを返す() {
            sut = new KaigoIryoKikanCollection(null);
        }
    }

    public static class get介護医療機関のテスト extends TestBase {

        private ShichosonCode 市町村コード;
        private KaigoIryoKikanCode 介護医療機関コード;

        @Override
        public void setUp() {
            kaigoIryoKikanList = new ArrayList<>();
            kaigoIryoKikanList.add(create介護医療機関("0001", "1234", "5678"));
            kaigoIryoKikanList.add(create介護医療機関("0002", "2345", "6789"));
            kaigoIryoKikanList.add(create介護医療機関("0003", "3456", "7890"));
            sut = new KaigoIryoKikanCollection(kaigoIryoKikanList);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 市町村コード_介護医療機関コードともに対応していない場合_例外が発生する() {
            市町村コード = new ShichosonCode(new RString("0987"));
            介護医療機関コード = new KaigoIryoKikanCode(new RString("0987"));
            assertThat(sut.get介護医療機関(市町村コード, 介護医療機関コード), nullValue());
        }

        @Test(expected = IllegalArgumentException.class)
        public void 市町村コードに対応するものがあっても_介護医療機関コードについて対応していない場合_例外が発生する() {
            市町村コード = new ShichosonCode(new RString("1234"));
            介護医療機関コード = new KaigoIryoKikanCode(new RString("0987"));
            sut.get介護医療機関(市町村コード, 介護医療機関コード);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 介護医療機関コードに対応するものがあっても_市町村コードについて対応していない場合_例外が発生する() {
            市町村コード = new ShichosonCode(new RString("0987"));
            介護医療機関コード = new KaigoIryoKikanCode(new RString("5678"));
            sut.get介護医療機関(市町村コード, 介護医療機関コード);
        }

        @Test
        public void 両方に対応しているものが存在するとき_対応した介護医療機関が返る() {
            市町村コード = new ShichosonCode(new RString("1234"));
            介護医療機関コード = new KaigoIryoKikanCode(new RString("5678"));
            assertThat(sut.get介護医療機関(市町村コード, 介護医療機関コード).get識別コード().getValue(), is(new RString("0001")));
        }

        private KaigoIryoKikan create介護医療機関(String 識別コード, String 市町村コード, String 介護医療機関コード) {
            IShujiiIryoKikan 主治医医療機関 = mock(KaigoIryoKikan.class);
            when(主治医医療機関.get市町村コード()).thenReturn(new ShichosonCode(new RString(市町村コード)));
            when(主治医医療機関.get介護医療機関コード()).thenReturn(new KaigoIryoKikanCode(new RString(介護医療機関コード)));

            IIryoKikan 医療機関 = mock(KaigoIryoKikan.class);
            when(医療機関.get識別コード()).thenReturn(new _ShikibetsuCode(new RString(識別コード)));

            return new KaigoIryoKikan(医療機関, 主治医医療機関);
        }
    }

    public static class sub介護医療機関Collection_医療機関区分を引数に渡した場合のテスト extends TestBase {

        private KaigoIryoKikan iryoKikan_A001 = create介護医療機関("0001", "A001");
        private KaigoIryoKikan iryoKikan_B001 = create介護医療機関("0002", "B001");
        private KaigoIryoKikan iryoKikan_C001 = create介護医療機関("0003", "C001");

        @Override
        public void setUp() {
            sut = new KaigoIryoKikanCollection(create介護医療機関List());
        }

        @Test
        public void 医療機関コードにA001を指定したとき_sub介護医療機関Collectionは3件の要素を持つコレクションを返す() {
            KaigoIryoKikanCollection results = sut.sub介護医療機関Collection(create医療機関区分("A001"));
            assertThat(results.size(), is(3));
        }

        @Test
        public void 医療機関コードにB001を指定したとき_sub介護医療機関Collectionは2件の要素を持つコレクションを返す() {
            KaigoIryoKikanCollection results = sut.sub介護医療機関Collection(create医療機関区分("B001"));
            assertThat(results.size(), is(2));
        }

        @Test
        public void 医療機関コードにC001を指定したとき_sub介護医療機関Collectionは1件の要素を持つコレクションを返す() {
            KaigoIryoKikanCollection results = sut.sub介護医療機関Collection(create医療機関区分("C001"));
            assertThat(results.size(), is(1));
        }

        private List<KaigoIryoKikan> create介護医療機関List() {
            List<KaigoIryoKikan> kaigoIryoKikanList = new ArrayList<>();
            kaigoIryoKikanList.add(iryoKikan_A001);
            kaigoIryoKikanList.add(iryoKikan_B001);
            kaigoIryoKikanList.add(iryoKikan_C001);
            kaigoIryoKikanList.add(iryoKikan_A001);
            kaigoIryoKikanList.add(iryoKikan_A001);
            kaigoIryoKikanList.add(iryoKikan_B001);
            return kaigoIryoKikanList;
        }

        private KaigoIryoKikan create介護医療機関(String 識別コード, String 医療機関区分コード) {
            IryoKikanKubun 医療機関区分 = create医療機関区分(医療機関区分コード);

            IShujiiIryoKikan 主治医医療機関 = mock(KaigoIryoKikan.class);
            when(主治医医療機関.get医療機関区分()).thenReturn(医療機関区分);

            IIryoKikan 医療機関 = mock(KaigoIryoKikan.class);
            when(医療機関.get識別コード()).thenReturn(new _ShikibetsuCode(new RString(識別コード)));

            return new KaigoIryoKikan(医療機関, 主治医医療機関);
        }

        private IryoKikanKubun create医療機関区分(String 医療機関区分コード) {
            return new IryoKikanKubun(new RString(医療機関区分コード), RString.EMPTY, RString.EMPTY);
        }
    }

    public static class sub介護医療機関Collection_医療機関状況を引数に渡した場合のテスト extends TestBase {

        private KaigoIryoKikan iryoKikan_有効 = create介護医療機関("0001", IryoKikanJokyo.有効);
        private KaigoIryoKikan iryoKikan_無効 = create介護医療機関("0002", IryoKikanJokyo.無効);

        @Override
        public void setUp() {
            sut = new KaigoIryoKikanCollection(create介護医療機関List());
        }

        @Test
        public void 医療機関状況に有効を指定したとき_sub介護医療機関Collectionは4件の要素を持つコレクションを返す() {
            KaigoIryoKikanCollection results = sut.sub介護医療機関Collection(IryoKikanJokyo.有効);
            assertThat(results.size(), is(4));
        }

        @Test
        public void 医療機関状況に有効を指定したとき_sub介護医療機関Collectionは2件の要素を持つコレクションを返す() {
            KaigoIryoKikanCollection results = sut.sub介護医療機関Collection(IryoKikanJokyo.無効);
            assertThat(results.size(), is(2));
        }

        private List<KaigoIryoKikan> create介護医療機関List() {
            List<KaigoIryoKikan> kaigoIryoKikanList = new ArrayList<>();
            kaigoIryoKikanList.add(iryoKikan_有効);
            kaigoIryoKikanList.add(iryoKikan_有効);
            kaigoIryoKikanList.add(iryoKikan_無効);
            kaigoIryoKikanList.add(iryoKikan_有効);
            kaigoIryoKikanList.add(iryoKikan_無効);
            kaigoIryoKikanList.add(iryoKikan_有効);
            return kaigoIryoKikanList;
        }

        private KaigoIryoKikan create介護医療機関(String 識別コード, IryoKikanJokyo 医療機関状況) {
            IShujiiIryoKikan 主治医医療機関 = mock(KaigoIryoKikan.class);
            when(主治医医療機関.get医療機関状況()).thenReturn(医療機関状況);

            IIryoKikan 医療機関 = mock(KaigoIryoKikan.class);
            when(医療機関.get識別コード()).thenReturn(new _ShikibetsuCode(new RString(識別コード)));

            return new KaigoIryoKikan(医療機関, 主治医医療機関);
        }
    }

    public static class isEmptyのテスト {

        @Test
        public void コレクションが空の場合_trueが返る() {
            sut = new KaigoIryoKikanCollection(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void コレクションに一つ以上の要素がある場合_falseが返る() {
            kaigoIryoKikanList = new ArrayList<>();
            kaigoIryoKikanList.add(mock(KaigoIryoKikan.class));
            sut = new KaigoIryoKikanCollection(kaigoIryoKikanList);
            assertThat(sut.isEmpty(), is(false));
        }
    }
}
