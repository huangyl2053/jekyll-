/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoChosainNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護認定調査員の情報を扱うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KaigoNinteiChosainTest extends TestBase {

    public static class ConstructorTest extends TestBase {

        private KaigoNinteiChosain sut;
        private ShichosonCode 市町村コード;
        private KaigoJigyoshaNo 介護事業者番号;
        private KaigoChosainNo 介護調査員番号;
        private JigyoshaNo 事業者番号;
        private boolean 調査員状況;
        private AtenaMeisho 調査員氏名;
        private AtenaKanaMeisho 調査員氏名カナ;
        private Gender 性別;
        private Code 調査員資格コード;
        private ChikuCode 地区コード;
        private YubinNo 郵便番号;
        private AtenaJusho 住所;
        private TelNo 電話番号;

        @Override
        protected void setUp() {

            市町村コード = new ShichosonCode(new RString("0001"));
            介護事業者番号 = new KaigoJigyoshaNo(new RString("0001"));
            介護調査員番号 = new KaigoChosainNo(new RString("0001"));
            事業者番号 = new JigyoshaNo(new RString("0001"));
            調査員状況 = true;
            調査員氏名 = new AtenaMeisho(new RString("山田"));
            調査員氏名カナ = new AtenaKanaMeisho(new RString("あああ"));
            性別 = Gender.MALE;
            調査員資格コード = new Code(new RString("0001"));
            地区コード = new ChikuCode(new RString("0001"));
            郵便番号 = new YubinNo(new RString("001"));
            住所 = new AtenaJusho(new RString("長野市"));
            電話番号 = new TelNo(new RString("0001"));
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            市町村コード = null;
            sut = new KaigoNinteiChosain(市町村コード, 介護事業者番号, 介護調査員番号, 事業者番号, 調査員状況,
                    調査員氏名, 調査員氏名カナ, 性別, 調査員資格コード, 地区コード, 郵便番号, 住所, 電話番号);
        }

        @Test(expected = NullPointerException.class)
        public void 介護事業者番号がNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            介護事業者番号 = null;
            sut = new KaigoNinteiChosain(市町村コード, 介護事業者番号, 介護調査員番号, 事業者番号, 調査員状況,
                    調査員氏名, 調査員氏名カナ, 性別, 調査員資格コード, 地区コード, 郵便番号, 住所, 電話番号);
        }

        @Test(expected = NullPointerException.class)
        public void 介護調査員番号がNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            介護調査員番号 = null;
            sut = new KaigoNinteiChosain(市町村コード, 介護事業者番号, 介護調査員番号, 事業者番号, 調査員状況,
                    調査員氏名, 調査員氏名カナ, 性別, 調査員資格コード, 地区コード, 郵便番号, 住所, 電話番号);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者番号がNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            事業者番号 = null;
            sut = new KaigoNinteiChosain(市町村コード, 介護事業者番号, 介護調査員番号, 事業者番号, 調査員状況,
                    調査員氏名, 調査員氏名カナ, 性別, 調査員資格コード, 地区コード, 郵便番号, 住所, 電話番号);
        }

        @Test(expected = NullPointerException.class)
        public void 調査員氏名がNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            調査員氏名 = null;
            sut = new KaigoNinteiChosain(市町村コード, 介護事業者番号, 介護調査員番号, 事業者番号, 調査員状況,
                    調査員氏名, 調査員氏名カナ, 性別, 調査員資格コード, 地区コード, 郵便番号, 住所, 電話番号);
        }

        @Test(expected = NullPointerException.class)
        public void 調査員氏名カナがNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            調査員氏名カナ = null;
            sut = new KaigoNinteiChosain(市町村コード, 介護事業者番号, 介護調査員番号, 事業者番号, 調査員状況,
                    調査員氏名, 調査員氏名カナ, 性別, 調査員資格コード, 地区コード, 郵便番号, 住所, 電話番号);
        }

        @Test(expected = NullPointerException.class)
        public void 調査員資格コードがNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            調査員資格コード = null;
            sut = new KaigoNinteiChosain(市町村コード, 介護事業者番号, 介護調査員番号, 事業者番号, 調査員状況,
                    調査員氏名, 調査員氏名カナ, 性別, 調査員資格コード, 地区コード, 郵便番号, 住所, 電話番号);
        }

        @Test(expected = NullPointerException.class)
        public void 地区コードがNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            地区コード = null;
            sut = new KaigoNinteiChosain(市町村コード, 介護事業者番号, 介護調査員番号, 事業者番号, 調査員状況,
                    調査員氏名, 調査員氏名カナ, 性別, 調査員資格コード, 地区コード, 郵便番号, 住所, 電話番号);
        }

        @Test(expected = NullPointerException.class)
        public void 郵便番号がNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            郵便番号 = null;
            sut = new KaigoNinteiChosain(市町村コード, 介護事業者番号, 介護調査員番号, 事業者番号, 調査員状況,
                    調査員氏名, 調査員氏名カナ, 性別, 調査員資格コード, 地区コード, 郵便番号, 住所, 電話番号);
        }

        @Test(expected = NullPointerException.class)
        public void 住所がNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            住所 = null;
            sut = new KaigoNinteiChosain(市町村コード, 介護事業者番号, 介護調査員番号, 事業者番号, 調査員状況,
                    調査員氏名, 調査員氏名カナ, 性別, 調査員資格コード, 地区コード, 郵便番号, 住所, 電話番号);
        }

        @Test(expected = NullPointerException.class)
        public void 電話番号がNullの場合_コンストラクタは_NullPointerExceptionを投げる() {
            電話番号 = null;
            sut = new KaigoNinteiChosain(市町村コード, 介護事業者番号, 介護調査員番号, 事業者番号, 調査員状況,
                    調査員氏名, 調査員氏名カナ, 性別, 調査員資格コード, 地区コード, 郵便番号, 住所, 電話番号);
        }
    }
}
