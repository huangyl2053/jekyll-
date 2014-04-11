/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ICodeWrapValueObject;
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
    private static class ShinsakaiIinShikakuCode implements ICodeWrapValueObject {

        private final Code code;

        public ShinsakaiIinShikakuCode(Code code) {
            this.code = code;
        }

        @Override
        public Code asCode() {
            return code;
        }

        @Override
        public RString value() {
            return code.value();
        }
    }

    /**
     * 審査会委員の資格です。(sample)
     */
    private static class ShisakaiIinShikaku extends KaigoCodeAssignedItem<ShinsakaiIinShikakuCode> {

        public ShisakaiIinShikaku(Code code, RString codeMeisho, RString codeRyakusho) {
            super(new ShinsakaiIinShikakuCode(code), code, codeMeisho, codeRyakusho);
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
            assertThat(sut.get審査会委員資格コード().asCode(), is(code));
        }
    }
}
