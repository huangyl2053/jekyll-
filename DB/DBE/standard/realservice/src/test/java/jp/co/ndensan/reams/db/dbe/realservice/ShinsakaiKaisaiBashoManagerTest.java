/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiChiku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiChikuCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.realservice.helper.ShinsakaiKaisaiBashoDacMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会開催場所Managerのテストクラスです。
 *
 * @author N1013 松本直樹
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiBashoManagerTest extends DbeTestBase {

    public static class get審査会開催場所 extends DbeTestBase {

        private static ShinsakaiKaisaiBashoManager sut;

        @Before
        public void setUp() {
            sut = new ShinsakaiKaisaiBashoManager(new ShinsakaiKaisaiBashoDacMock());
        }

        @Test
        public void 引数の指定した開催場所コードを持つ開催場所が取得できる() {
            ShinsakaiKaisaiBashoCode 開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00001"));
            ShinsakaiKaisaiBasho result = sut.get審査会開催場所(開催場所コード);
            assertThat(result.get開催場所コード(), is(開催場所コード));
        }

        @Test
        public void 引数の指定した開催場所コードから開催場所がみつから無い場合にはnullを返す() {
            ShinsakaiKaisaiBashoCode 開催場所コード = new ShinsakaiKaisaiBashoCode(ShinsakaiKaisaiBashoDacMock.検索不可な開催場所コード);
            ShinsakaiKaisaiBasho result = sut.get審査会開催場所(開催場所コード);
            assertThat(result, nullValue());
        }

        @Test
        public void 引数の指定した開催場所コードと開催場所状況を持つ開催場所を取得できる() {
            ShinsakaiKaisaiBashoCode 開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00001"));
            ShinsakaiKaisaiBasho result = sut.get審査会開催場所(開催場所コード, ShinsakaiKaisaiBashoJokyo.有効);
            assertThat(result.get開催場所コード(), is(開催場所コード));
        }

        @Test
        public void 引数の指定した開催場所コードと開催場所状況から開催場所がみつから無い場合にはnullを返す() {
            ShinsakaiKaisaiBashoCode 開催場所コード = new ShinsakaiKaisaiBashoCode(ShinsakaiKaisaiBashoDacMock.検索不可な開催場所コード);
            ShinsakaiKaisaiBasho result = sut.get審査会開催場所(開催場所コード, ShinsakaiKaisaiBashoJokyo.有効);
            assertThat(result, nullValue());
        }
    }

    public static class get審査会開催場所List extends DbeTestBase {

        private static ShinsakaiKaisaiBashoManager sut;

        @Before
        public void setUp() {
            sut = new ShinsakaiKaisaiBashoManager(new ShinsakaiKaisaiBashoDacMock());
        }

        @Test
        public void 開催場所情報に保持している全件データを取得する() {
            List<ShinsakaiKaisaiBasho> result = sut.get審査会開催場所List();
            assertThat(result.size(), is(2));
        }

        @Test
        public void 引数の指定した開催場所状況を持つ開催場所を全件取得する() {
            List<ShinsakaiKaisaiBasho> result = sut.get審査会開催場所List(ShinsakaiKaisaiBashoJokyo.有効);
            assertThat(result.size(), is(1));
        }
    }

    public static class saveのテスト extends DbeTestBase {

        private static ShinsakaiKaisaiBashoManager sut;

        @Before
        public void setUp() {
            sut = new ShinsakaiKaisaiBashoManager(new ShinsakaiKaisaiBashoDacMock());
        }

        @Test
        public void 引数で渡した情報を更新する() {
            ShinsakaiKaisaiBashoCode 開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00001"));
            ShinsakaiKaisaiChikuCode 開催場所地区コード = new ShinsakaiKaisaiChikuCode(new RString("00001"));
            ShinsakaiKaisaiBashoJokyo 審査会開催場所状況 = ShinsakaiKaisaiBashoJokyo.有効;
            ShinsakaiKaisaiBasho 審査会開催場所 = create審査会開催場所(開催場所コード,
                    開催場所地区コード, 審査会開催場所状況);
            boolean result = sut.save(審査会開催場所);
            assertThat(result, is(true));
        }
    }

    public static class deleteのテスト extends DbeTestBase {

        private static ShinsakaiKaisaiBashoManager sut;

        @Before
        public void setUp() {
            sut = new ShinsakaiKaisaiBashoManager(new ShinsakaiKaisaiBashoDacMock());
        }

        @Test
        public void 引数で渡した情報を削除する() {
            ShinsakaiKaisaiBashoCode 開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("00001"));
            ShinsakaiKaisaiChikuCode 開催場所地区コード = new ShinsakaiKaisaiChikuCode(new RString("00001"));
            ShinsakaiKaisaiBashoJokyo 審査会開催場所状況 = ShinsakaiKaisaiBashoJokyo.有効;
            ShinsakaiKaisaiBasho 審査会開催場所 = create審査会開催場所(開催場所コード,
                    開催場所地区コード, 審査会開催場所状況);
            boolean result = sut.remove(審査会開催場所);
            assertThat(result, is(true));
        }

        @Test
        public void 引数で渡した情報を削除しようとした際に対象が無いとfalseが返る() {
            ShinsakaiKaisaiBashoCode 開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("検索不可"));
            ShinsakaiKaisaiChikuCode 開催場所地区コード = new ShinsakaiKaisaiChikuCode(new RString("00001"));
            ShinsakaiKaisaiBashoJokyo 審査会開催場所状況 = ShinsakaiKaisaiBashoJokyo.有効;
            ShinsakaiKaisaiBasho 審査会開催場所 = create審査会開催場所(開催場所コード,
                    開催場所地区コード, 審査会開催場所状況);
            boolean result = sut.remove(審査会開催場所);
            assertThat(result, is(false));
        }
    }

    private static ShinsakaiKaisaiBasho create審査会開催場所(ShinsakaiKaisaiBashoCode 開催場所コード, ShinsakaiKaisaiChikuCode 開催場所地区コード,
            ShinsakaiKaisaiBashoJokyo 審査会開催場所状況) {
        return new ShinsakaiKaisaiBasho(開催場所コード,
                new RString("開催場所名"),
                new ShinsakaiKaisaiChiku(開催場所地区コード, new RString("地区")),
                new AtenaJusho(new RString("開催場所住所")),
                new TelNo(new RString("012-3456-1234")), 審査会開催場所状況);
    }
}
