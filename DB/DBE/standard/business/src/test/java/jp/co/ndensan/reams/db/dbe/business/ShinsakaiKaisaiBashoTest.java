/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiChikuCode;
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

    public static class ConstructorTest extends DbeTestBase {

        private ShinsakaiKaisaiBasho sut;
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
            開催地区 = new ShinsakaiKaisaiChiku(new ShinsakaiKaisaiChikuCode(new RString("0001")), new RString("山田家"));
            開催場所住所 = new AtenaJusho(new RString("長野市鶴賀"));
            開催場所電話番号 = new TelNo(new RString("026-233-9999"));
            開催場所状況 = 開催場所状況.有効;
        }

        @Test
        public void 必須項目が渡されたとき_インスタンスが生成される() {
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
}
