/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiKaisaiBashoTest extends TestBase {

    public static class コンストラクタのテスト extends TestBase {

        private ShinsakaiKaisaiBashoCode 開催場所コード;
        private RString 開催場所名;
        private ShinsakaiKaisaiChiku 開催地区;
        private AtenaJusho 開催場所住所;
        private TelNo 電話番号;
        private ShinsakaiKaisaiBashoJokyo 開催場所状況;
        private ShinsakaiKaisaiBasho sut;

        @Override
        public void setUp() {
            開催場所コード = new ShinsakaiKaisaiBashoCode(RString.EMPTY);
            開催場所名 = RString.EMPTY;
            開催地区 = new ShinsakaiKaisaiChiku();
            開催場所住所 = new AtenaJusho(RString.EMPTY);
            電話番号 = new TelNo(RString.EMPTY);
            開催場所状況 = ShinsakaiKaisaiBashoJokyo.有効;
        }

        @Test
        public void 必須項目がそろっているとき_インスタンスが生成される() {
            sut = new ShinsakaiKaisaiBasho(開催場所コード, 開催場所名, null, null, null, 開催場所状況);
            assertThat(sut, is(instanceOf(ShinsakaiKaisaiBasho.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 開催場所コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiKaisaiBasho(null, 開催場所名, 開催地区, 開催場所住所, 電話番号, 開催場所状況);
        }

        @Test(expected = NullPointerException.class)
        public void 開催場所名にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiKaisaiBasho(開催場所コード, null, 開催地区, 開催場所住所, 電話番号, 開催場所状況);
        }

        @Test(expected = NullPointerException.class)
        public void 開催場所状況にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiKaisaiBasho(開催場所コード, 開催場所名, 開催地区, 開催場所住所, 電話番号, null);
        }
    }
}
