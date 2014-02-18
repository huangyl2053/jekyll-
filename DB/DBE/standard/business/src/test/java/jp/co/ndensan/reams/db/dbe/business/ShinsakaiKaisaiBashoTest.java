/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoChikuCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbztesthelper.DbeTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * ShinsakaiKaisaiBashoのテストクラスです
 *
 * @author N1013 松本直樹
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiBashoTest extends DbeTestBase {

    public static class ConstructorTest extends DbeTestBase {

        private ShinsakaiKaisaiBasho sut;
//        private ShinsakaiKaisaiBashoCode 開催場所コード;
//        private ShinsakaiKaisaiBashoChikuCode 開催場所地区コード;
        private RString 開催場所コード;
        private RString 開催場所名称;
        private RString 開催場所地区コード;
        private RString 開催場所住所;
        private RString 開催場所電話番号;
        private ShinsakaiKaisaiBashoJokyo 開催場所状況;

        @Override
        public void setUp() {
            開催場所コード = new RString("000001");
            開催場所名称 = new RString("市役所会議室");
            開催場所地区コード = new RString("0001");
            開催場所住所 = new RString("長野市鶴賀");
            開催場所電話番号 = new RString("026-233-9999");
            開催場所状況 = 開催場所状況.有効;
        }

        @Test
        public void 必須項目が渡されたとき_インスタンスが生成される() {
            sut = new ShinsakaiKaisaiBasho(開催場所コード, 開催場所名称,
                    開催場所地区コード, 開催場所住所, 開催場所電話番号, 開催場所状況);
            assertThat(sut, instanceOf(ShinsakaiKaisaiBasho.class));
        }

        @Test(expected = NullPointerException.class)
        public void 開催場所コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiKaisaiBasho(null, 開催場所名称,
                    開催場所地区コード, 開催場所住所, 開催場所電話番号, 開催場所状況);

        }

        @Test(expected = NullPointerException.class)
        public void 開催場所名称にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiKaisaiBasho(開催場所コード, null,
                    開催場所地区コード, 開催場所住所, 開催場所電話番号, 開催場所状況);

        }

        @Test(expected = NullPointerException.class)
        public void 開催場所状況にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiKaisaiBasho(開催場所コード, 開催場所名称,
                    開催場所地区コード, 開催場所住所, 開催場所電話番号, null);

        }
    }
}
