/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business._IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 主治医医療機関のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShujiiIryoKikanTest extends TestBase {

    public static class コンストラクタのテスト {

        private static final ShichosonCode 市町村コード = new ShichosonCode(RString.EMPTY);
        private static final KaigoIryoKikanCode 介護医療機関コード = new KaigoIryoKikanCode(RString.EMPTY);
        private static final IIryoKikanCode 医療機関コード = new _IryoKikanCode(new RString("000000009"));
        private static final IryoKikanJokyo 医療機関の状況 = IryoKikanJokyo.有効;
        private static final IryoKikanKubun 医療機関の区分 = new IryoKikanKubun();

        @Test
        public void 必須の項目がすべて渡されているとき_インスタンスが生成される() {
            ShujiiIryoKikan sut = new ShujiiIryoKikan(市町村コード, 介護医療機関コード, 医療機関コード, 医療機関の状況, null);
            assertThat(sut, instanceOf(ShujiiIryoKikan.class));
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            ShujiiIryoKikan sut = new ShujiiIryoKikan(null, 介護医療機関コード, 医療機関コード, 医療機関の状況, 医療機関の区分);
        }

        @Test(expected = NullPointerException.class)
        public void 介護医療機関コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            ShujiiIryoKikan sut = new ShujiiIryoKikan(市町村コード, null, 医療機関コード, 医療機関の状況, 医療機関の区分);
        }

        @Test(expected = NullPointerException.class)
        public void get医療機関コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            ShujiiIryoKikan sut = new ShujiiIryoKikan(市町村コード, 介護医療機関コード, null, 医療機関の状況, 医療機関の区分);
        }

        @Test(expected = NullPointerException.class)
        public void 医療機関の状況にnullが渡されたとき_NullPointerExceptionが発生する() {
            ShujiiIryoKikan sut = new ShujiiIryoKikan(市町村コード, 介護医療機関コード, 医療機関コード, null, 医療機関の区分);
        }
    }
}
