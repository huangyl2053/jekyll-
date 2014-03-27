/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;

/**
 * KaigoCodeAssinedItemのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class KaigoCodeAssignedItemTest extends DbzTestBase {

    /**
     * 審査会委員の資格をあらわすコードです。(sample)
     */
    private static class ShinsakaiIinShikakuCode extends Code {

        public ShinsakaiIinShikakuCode(RString code) throws NullPointerException, IllegalArgumentException {
            super(code);
        }
    }

    /**
     * 審査会委員の資格です。(sample)
     */
    private static class ShisakaiIinShikaku extends KaigoCodeAssignedItem<ShinsakaiIinShikakuCode> {

        /**
         * 何も考えなかったときの実装です。とはいえ、スーパークラスのKaigoCodeAssingeItemのコンストラクタが必要としているので、
         * 最低限、こういったコンストラクタは必要になります。
         * CodeAssinedItemのコンストラクタ引数に、ShinsakaiIinShikakuCodeを追加した形になります。
         */
        private ShisakaiIinShikaku(ShinsakaiIinShikakuCode extendedCode, Code code, RString codeMeisho, RString codeRyakusho, RString option1, RString option2, RString option3) {
            super(extendedCode, code, codeMeisho, codeRyakusho, option1, option2, option3);
        }

        /**
         * ↑の形だと、引数の項目が多くて大変です。 作成するクラスによっては、コンストラクタの引数を
         * 必要なものだけに、絞り込むことを考慮しましょう。
         *
         * Codeを継承したValueObjectが初期化に必要ですが、
         * それは『Code#value()を使ってコンストラクタ内でインスタンスを作ってしまう』と、スマートだと思います。
         */
        public ShisakaiIinShikaku(Code code, RString codeMeisho, RString codeRyakusho) {
            this(new ShinsakaiIinShikakuCode(code.value()), code, codeMeisho, codeRyakusho, null, null, null);
        }

        /**
         * 審査会委員資格コードを返します。
         *
         * @return 審査会委員資格コード
         */
        public ShinsakaiIinShikakuCode get審査会委員資格コード() {
            return getExtendedCode();
        }
    }

    public static class get審査会委員資格コード extends DbzTestBase {

        private ShisakaiIinShikaku sut;
        private Code code = new Code("コード");
        private RString codeMeisho = new RString("コード名称");
        private RString codeRyakusho = new RString("コード略称");

        @Before
        public void setUp() {
            sut = new ShisakaiIinShikaku(code, codeMeisho, codeRyakusho);
        }

        @Test
        public void get審査会委員資格コードは_コンストラクタに引き渡したCodeと_値が一致する() {
            assertThat(sut.get審査会委員資格コード().value(), is(code.value()));
        }
    }
}
