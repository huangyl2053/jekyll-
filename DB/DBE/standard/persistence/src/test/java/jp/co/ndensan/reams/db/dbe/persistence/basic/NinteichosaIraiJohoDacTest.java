/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ChosainBangoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItakusakiCode;
import static jp.co.ndensan.reams.db.dbe.persistence.basic.helper.NinteichosaIraiJohoTestHelper.*;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定調査依頼情報DACのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiJohoDacTest extends TestDacBase {
    //TODO n8178 城間篤人 ドメイン化対応後に修正 2014年2月末
//
//    private static INinteichosaIraiJohoDac sut;
//
//    @BeforeClass
//    public static void setUpClass() {
//        sut = InstanceCreator.create(INinteichosaIraiJohoDac.class);
//    }
//
//    public static class insertのテスト extends TestDacBase {
//
//        ShinseishoKanriNo 申請書管理番号;
//        int 認定調査依頼履歴番号;
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            申請書管理番号 = new ShinseishoKanriNo((new RString("01")));
//            認定調査依頼履歴番号 = 4;
//        }
//
//        @Test
//        public void insertに成功したとき_1が返る() {
//            assertThat(sut.insert(create認定調査依頼情報Entity(申請書管理番号, 認定調査依頼履歴番号)), is(1));
//        }
//
//        @Test
//        public void すでに同じ主キーの項目が存在して_insertに失敗したとき_0が返る() {
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号, 認定調査依頼履歴番号));
//            assertThat(sut.insert(create認定調査依頼情報Entity(申請書管理番号, 認定調査依頼履歴番号)), is(0));
//        }
//    }
//
//    public static class updateのテスト extends TestDacBase {
//
//        ShinseishoKanriNo 申請書管理番号;
//        int 認定調査依頼履歴番号;
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            申請書管理番号 = new ShinseishoKanriNo((new RString("01")));
//            認定調査依頼履歴番号 = 4;
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号, 認定調査依頼履歴番号, new RDate("19991212")));
//        }
//
//        @Test
//        public void updateに成功したとき_1が返る() {
//            assertThat(sut.insert(create認定調査依頼情報Entity(申請書管理番号, 認定調査依頼履歴番号, new RDate("20001212"))), is(1));
//        }
//
//        @Test
//        public void 存在しない主キーの項目に対して_updateを行ったとき_updateに失敗し0が返る() {
//            申請書管理番号 = new ShinseishoKanriNo(new RString("9999"));
//            assertThat(sut.insert(create認定調査依頼情報Entity(申請書管理番号, 認定調査依頼履歴番号, new RDate("20001212"))), is(1));
//        }
//    }
//
//    public static class select_引数に申請書管理番号と認定調査依頼履歴番号を渡した場合のテスト extends TestDacBase {
//
//        ShinseishoKanriNo 申請書管理番号;
//        int 認定調査依頼履歴番号;
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            申請書管理番号 = new ShinseishoKanriNo((new RString("01")));
//            認定調査依頼履歴番号 = 4;
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号, 認定調査依頼履歴番号));
//        }
//
//        @Test
//        public void 申請書管理番号_1のデータを取得できる() {
//            assertThat(sut.select(申請書管理番号, 認定調査依頼履歴番号).getShinseishoKanriNo(), is(申請書管理番号));
//        }
//
//        public void 認定調査依頼履歴番号_4のデータを取得できる() {
//            assertThat(sut.select(申請書管理番号, 認定調査依頼履歴番号).getNinteichosaIraiRirekiNo(), is(認定調査依頼履歴番号));
//        }
//
//        @Test
//        public void 存在しないデータを取得しようとしたとき_nullが返る() {
//            assertThat(sut.select(new ShinseishoKanriNo(RString.EMPTY), 45).getNinteichosaIraiRirekiNo(), is(nullValue()));
//        }
//    }
//
//    public static class select_引数に申請書管理番号を渡した場合のテスト extends TestDacBase {
//
//        ShinseishoKanriNo 申請書管理番号1;
//        ShinseishoKanriNo 申請書管理番号2;
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            申請書管理番号1 = new ShinseishoKanriNo((new RString("01")));
//            申請書管理番号2 = new ShinseishoKanriNo((new RString("02")));
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号1, 1));
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号1, 2));
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号2, 1));
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号1, 3));
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号2, 2));
//        }
//
//        @Test
//        public void 申請書管理番号_1のデータを検索すると_3件のリストが取得できる() {
//            assertThat(sut.select(申請書管理番号1).size(), is(3));
//        }
//
//        public void 申請書管理番号_2のデータを検索すると_2件のリストが取得できる() {
//            assertThat(sut.select(申請書管理番号2).size(), is(2));
//        }
//
//        @Test
//        public void 存在しないデータを取得しようとしたとき_空のリストが返る() {
//            assertThat(sut.select(new ShinseishoKanriNo(RString.EMPTY)), is(Collections.EMPTY_LIST));
//        }
//    }
//
//    public static class select_引数に認定調査委託先コードと調査員番号コードを渡した場合のテスト extends TestDacBase {
//
//        ShinseishoKanriNo 申請書管理番号;
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            申請書管理番号 = new ShinseishoKanriNo((new RString("01")));
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号, 1, create認定調査委託先コード("01"), create調査員番号コード("001")));
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号, 2, create認定調査委託先コード("01"), create調査員番号コード("001")));
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号, 3, create認定調査委託先コード("01"), create調査員番号コード("001")));
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号, 4, create認定調査委託先コード("02"), create調査員番号コード("001")));
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号, 5, create認定調査委託先コード("02"), create調査員番号コード("001")));
//            sut.insert(create認定調査依頼情報Entity(申請書管理番号, 6, create認定調査委託先コード("02"), create調査員番号コード("002")));
//        }
//
//        @Test
//        public void 認定調査委託先コード_01_調査員番号コード_001_のデータを検索すると_3件のリストが取得できる() {
//            assertThat(sut.select(create認定調査委託先コード("01"), create調査員番号コード("001")).size(), is(3));
//        }
//
//        public void 認定調査委託先コード_02_調査員番号コード_001_のデータを検索すると_2件のリストが取得できる() {
//            assertThat(sut.select(create認定調査委託先コード("02"), create調査員番号コード("001")).size(), is(2));
//        }
//
//        public void 認定調査委託先コード_02_調査員番号コード_002_のデータを検索すると_1件のリストが取得できる() {
//            assertThat(sut.select(create認定調査委託先コード("02"), create調査員番号コード("002")).size(), is(1));
//        }
//
//        @Test
//        public void 存在しないデータを取得しようとしたとき_空のリストが返る() {
//            assertThat(sut.select(create認定調査委託先コード("99"), create調査員番号コード("999")), is(Collections.EMPTY_LIST));
//        }
//
//        private NinteichosaItakusakiCode create認定調査委託先コード(String str) {
//            return new NinteichosaItakusakiCode(new RString(str));
//        }
//
//        private ChosainBangoCode create調査員番号コード(String str) {
//            return new ChosainBangoCode(new RString(str));
//        }
//    }
//
//    public static class select_認定調査督促年月日を渡した場合のテスト extends TestDacBase {
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            sut.insert(create認定調査依頼情報Entity(create申請書管理番号("1"), 1, new RDate("19991212")));
//            sut.insert(create認定調査依頼情報Entity(create申請書管理番号("2"), 1, new RDate("19991212")));
//            sut.insert(create認定調査依頼情報Entity(create申請書管理番号("3"), 1, new RDate("20011212")));
//        }
//
//        public void 督促年月日_1999年12月12日_のデータを検索すると_2件のリストが取得できる() {
//            assertThat(sut.select(new RDate("19991212")).size(), is(2));
//        }
//
//        public void 督促年月日_2001年12月12日_のデータを検索すると_1件のリストが取得できる() {
//            assertThat(sut.select(new RDate("20011212")).size(), is(1));
//        }
//
//        @Test
//        public void 存在しないデータを取得しようとしたとき_空のリストが返る() {
//            assertThat(sut.select(new RDate("10240101")), is(Collections.EMPTY_LIST));
//        }
//
//        private ShinseishoKanriNo create申請書管理番号(String str) {
//            return new ShinseishoKanriNo(new RString(str));
//        }
//    }
}
