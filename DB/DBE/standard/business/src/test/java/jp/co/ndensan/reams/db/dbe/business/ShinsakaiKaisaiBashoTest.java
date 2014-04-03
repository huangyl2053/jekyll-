/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiChiku;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * ShinsakaiKaisaiBashoのテストクラスです。
 *
 * @author N1013 松本直樹
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiBashoTest extends DbeTestBase {

    private static ShinsakaiKaisaiBasho sut;

    public static class ConstructorTest extends DbeTestBase {

        private ShinsakaiKaisaiBashoCode 開催場所コード;
        private ShinsakaiKaisaiChiku 開催地区;
        private RString 開催場所名称;
        private AtenaJusho 開催場所住所;
        private TelNo 開催場所電話番号;
        private ShinsakaiKaisaiBashoJokyo 開催場所状況;

        @Before
        public void setUp() {
            開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("000001"));
            開催場所名称 = new RString("市役所会議室");
            開催地区 = new ShinsakaiKaisaiChiku(new RString("0001"), new RString("山田市"));
            開催場所住所 = new AtenaJusho(new RString("長野市鶴賀"));
            開催場所電話番号 = new TelNo(new RString("026-233-9999"));
            開催場所状況 = 開催場所状況.有効;
        }

        @Test
        public void 必須項目が渡されたとき_インスタンスが生成される() {
            開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("000001"));
            開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("000001"));
            開催場所名称 = new RString("市役所会議室");
            開催地区 = new ShinsakaiKaisaiChiku(new RString("0001"), new RString("山田市"));
            開催場所住所 = new AtenaJusho(new RString("長野市鶴賀"));
            開催場所電話番号 = new TelNo(new RString("026-233-9999"));
            開催場所状況 = 開催場所状況.有効;
            sut = new ShinsakaiKaisaiBasho(開催場所コード, 開催場所名称,
                    開催地区, 開催場所住所, 開催場所電話番号, 開催場所状況);
            assertThat(sut, instanceOf(ShinsakaiKaisaiBasho.class));
        }

        @Test(expected = NullPointerException.class)
        public void 開催場所コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiKaisaiBasho(null, 開催場所名称,
                    開催地区, 開催場所住所, 開催場所電話番号, 開催場所状況);

        }

        @Test(expected = NullPointerException.class)
        public void 開催場所名称にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiKaisaiBasho(開催場所コード, null,
                    開催地区, 開催場所住所, 開催場所電話番号, 開催場所状況);
        }

        @Test(expected = NullPointerException.class)
        public void 開催場所状況にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiKaisaiBasho(開催場所コード, 開催場所名称,
                    開催地区, 開催場所住所, 開催場所電話番号, null);
        }
    }

    public static class equalsのテスト extends DbeTestBase {

        private ShinsakaiKaisaiBasho sut2;
        private ShinsakaiKaisaiBashoCode 開催場所コード;
        private ShinsakaiKaisaiChiku 開催地区;
        private RString 開催場所名称;
        private AtenaJusho 開催場所住所;
        private TelNo 開催場所電話番号;
        private ShinsakaiKaisaiBashoJokyo 開催場所状況;

        @Before
        public void setUp() {
            開催場所コード = new ShinsakaiKaisaiBashoCode(new RString("000001"));
            開催場所名称 = new RString("市役所会議室");
            開催地区 = new ShinsakaiKaisaiChiku(new RString("0001"), new RString("山田市"));
            開催場所住所 = new AtenaJusho(new RString("長野市鶴賀"));
            開催場所電話番号 = new TelNo(new RString("026-233-9999"));
            開催場所状況 = 開催場所状況.有効;
            sut = new ShinsakaiKaisaiBasho(開催場所コード, 開催場所名称, 開催地区, 開催場所住所, 開催場所電話番号, 開催場所状況);
        }

        @Test
        public void 引数にnullが渡されたとき_falseが返る() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 引数に型の違うインスタンスが渡されたとき_falseが返る() {
            assertThat(sut.equals(new RString("000001")), is(false));
        }

        @Test
        public void 開催場所コードが違う値の場合_falseが返る() {
            sut2 = new ShinsakaiKaisaiBasho(new ShinsakaiKaisaiBashoCode(new RString("123456")),
                    開催場所名称, 開催地区, 開催場所住所, 開催場所電話番号, 開催場所状況);
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 開催場所名称が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiKaisaiBasho(開催場所コード, new RString("沖縄県"),
                    開催地区, 開催場所住所, 開催場所電話番号, 開催場所状況);
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 開催地区が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiKaisaiBasho(開催場所コード, 開催場所名称, new ShinsakaiKaisaiChiku(new Code("9999"), new RString("中城")),
                    開催場所住所, 開催場所電話番号, 開催場所状況);
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 開催場所住所が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiKaisaiBasho(開催場所コード, 開催場所名称, 開催地区, new AtenaJusho("1111町4771町"),
                    開催場所電話番号, 開催場所状況);
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 開催場所電話番号が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiKaisaiBasho(開催場所コード, 開催場所名称, 開催地区, 開催場所住所, new TelNo("098-000-0000"), 開催場所状況);
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 開催場所状況が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiKaisaiBasho(開催場所コード, 開催場所名称, 開催地区, 開催場所住所, 開催場所電話番号, ShinsakaiKaisaiBashoJokyo.無効);
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void すべての要素が同値の場合_trueが返る() {
            sut2 = new ShinsakaiKaisaiBasho(開催場所コード, 開催場所名称, 開催地区, 開催場所住所, 開催場所電話番号, 開催場所状況);
            assertThat(sut.equals(sut2), is(true));
        }
    }
}
