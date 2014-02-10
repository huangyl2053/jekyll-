/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaisaiBashoChikuCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.realservice.helper.ShinsakaiKaisaiBashoDacMock;
import jp.co.ndensan.reams.db.dbztesthelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会開催場所Managerのテストクラスです
 *
 * @author N1013 松本直樹
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiBashoManagerTest extends DbeTestBase {

    public static class get審査会開催場所 extends DbeTestBase {

        private static ShinsakaiKaisaiBashoManager sut;

        @Override
        public void setUp() {
            sut = new ShinsakaiKaisaiBashoManager(new ShinsakaiKaisaiBashoDacMock());
        }

        @Test
        public void 引数の指定した開催場所コードを持つ開催場所が取得できる() {
            KaisaiBashoCode 開催場所コード = new KaisaiBashoCode(new RString("00001"));
            ShinsakaiKaisaiBasho result = sut.get審査会開催場所(開催場所コード);
            assertThat(result.get開催場所コード().getColumnValue(), is(開催場所コード.getColumnValue()));
        }

        @Test
        public void 引数の指定した開催場所コードから開催場所がみつから無い場合にはnullを返す() {
            KaisaiBashoCode 開催場所コード = new KaisaiBashoCode(ShinsakaiKaisaiBashoDacMock.検索不可な開催場所コード);
            ShinsakaiKaisaiBasho result = sut.get審査会開催場所(開催場所コード);
            assertThat(result, nullValue());
        }

        @Test
        public void 引数の指定した開催場所コードと開催場所状況を持つ開催場所を取得できる() {
            KaisaiBashoCode 開催場所コード = new KaisaiBashoCode(new RString("00001"));
            ShinsakaiKaisaiBasho result = sut.get審査会開催場所(開催場所コード, true);
            assertThat(result.get開催場所コード().getColumnValue(), is(開催場所コード.getColumnValue()));
        }

        @Test
        public void 引数の指定した開催場所コードと開催場所状況から開催場所がみつから無い場合にはnullを返す() {
            KaisaiBashoCode 開催場所コード = new KaisaiBashoCode(ShinsakaiKaisaiBashoDacMock.検索不可な開催場所コード);
            ShinsakaiKaisaiBasho result = sut.get審査会開催場所(開催場所コード, true);
            assertThat(result, nullValue());
        }
    }

    public static class get審査会開催場所List extends DbeTestBase {

        private static ShinsakaiKaisaiBashoManager sut;

        @Override
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
            List<ShinsakaiKaisaiBasho> result = sut.get審査会開催場所List(true);
            assertThat(result.size(), is(1));
        }
    }

    public static class saveのテスト extends DbeTestBase {

        private static ShinsakaiKaisaiBashoManager sut;

        @Override
        public void setUp() {
            sut = new ShinsakaiKaisaiBashoManager(new ShinsakaiKaisaiBashoDacMock());
        }

        @Test
        public void 引数で渡した情報を更新する() {
            KaisaiBashoCode 開催場所コード = new KaisaiBashoCode(new RString("00001"));
            KaisaiBashoChikuCode 開催場所地区コード = new KaisaiBashoChikuCode(new RString("00001"));
            ShinsakaiKaisaiBashoJokyo 審査会開催場所状況 = ShinsakaiKaisaiBashoJokyo.有効;
            ShinsakaiKaisaiBasho 審査会開催場所 = new ShinsakaiKaisaiBasho(開催場所コード,
                    new RString("開催場所名"),
                    開催場所地区コード,
                    new RString("開催場所住所"),
                    new RString("開催場所電話番号"), 審査会開催場所状況);
            boolean result = sut.save(審査会開催場所);
            assertThat(result, is(true));
        }
    }

    public static class deleteのテスト extends DbeTestBase {

        private static ShinsakaiKaisaiBashoManager sut;

        @Override
        public void setUp() {
            sut = new ShinsakaiKaisaiBashoManager(new ShinsakaiKaisaiBashoDacMock());
        }

        @Test
        public void 引数で渡した情報を削除する() {
            KaisaiBashoCode 開催場所コード = new KaisaiBashoCode(new RString("00001"));
            KaisaiBashoChikuCode 開催場所地区コード = new KaisaiBashoChikuCode(new RString("00001"));
            ShinsakaiKaisaiBashoJokyo 審査会開催場所状況 = ShinsakaiKaisaiBashoJokyo.有効;
            ShinsakaiKaisaiBasho 審査会開催場所 = new ShinsakaiKaisaiBasho(開催場所コード,
                    new RString("開催場所名"),
                    開催場所地区コード,
                    new RString("開催場所住所"),
                    new RString("開催場所電話番号"), 審査会開催場所状況);
            boolean result = sut.remove(審査会開催場所);
            assertThat(result, is(true));
        }
    }
}
