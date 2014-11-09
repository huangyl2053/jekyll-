/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ConsentsToEnkitsuchiHakko;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定進捗情報を表すクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class YokaigoninteiProgressTest extends DbeTestBase {

    public static class コンストラクタ extends DbeTestBase {

        private static YokaigoNinteiProgress sut;
        private ShinseishoKanriNo 申請書管理番号;
        private FlexibleDate 認定申請情報登録年月日;
        private ConsentsToEnkitsuchiHakko 認定延期通知発行に対する同意有無;
        private FlexibleDate 認定延期通知発行年月日;
        private int 認定延期通知発行回数;
        private RString 要介護認定延期理由;
        private FlexibleDate 要介護認定一次判定情報抽出年月日;
        private FlexibleDate 依頼情報データ送信年月日;
        private FlexibleDate 認定調査依頼完了年月日;
        private FlexibleDate 認定調査完了年月日;
        private FlexibleDate 主治医意見書作成依頼完了年月日;
        private FlexibleDate 主治医意見書登録完了年月日;
        private FlexibleDate 要介護認定一次判定完了年月日;
        private FlexibleDate 要介護認定1_5次判定完了年月日;
        private FlexibleDate 認定審査会割当完了年月日;
        private FlexibleDate 認定審査会完了年月日;
        private FlexibleDate センター送信年月日;

        @Before
        public void setUp() {
            申請書管理番号 = new ShinseishoKanriNo(new RString("0001"));
            認定申請情報登録年月日 = new FlexibleDate(new RString("20140303"));
            認定延期通知発行に対する同意有無 = ConsentsToEnkitsuchiHakko.同意;
            認定延期通知発行年月日 = new FlexibleDate(new RString("20140303"));
            認定延期通知発行回数 = 1;
            要介護認定延期理由 = new RString("延期");
            要介護認定一次判定情報抽出年月日 = new FlexibleDate(new RString("20140303"));
            依頼情報データ送信年月日 = new FlexibleDate(new RString("20140303"));
            認定調査依頼完了年月日 = new FlexibleDate(new RString("20140303"));
            認定調査完了年月日 = new FlexibleDate(new RString("20140303"));
            主治医意見書作成依頼完了年月日 = new FlexibleDate(new RString("20140303"));
            主治医意見書登録完了年月日 = new FlexibleDate(new RString("20140303"));
            要介護認定一次判定完了年月日 = new FlexibleDate(new RString("20140303"));
            要介護認定1_5次判定完了年月日 = new FlexibleDate(new RString("20140303"));
            認定審査会割当完了年月日 = new FlexibleDate(new RString("20140303"));
            認定審査会完了年月日 = new FlexibleDate(new RString("20140303"));
            センター送信年月日 = new FlexibleDate(new RString("20140303"));
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号にnullが渡されたとき_NullPointerException発生() {
            申請書管理番号 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 認定申請情報登録年月日にnullが渡されたとき_NullPointerException発生() {
            認定申請情報登録年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 認定延期通知発行年月日にnullが渡されたとき_NullPointerException発生() {
            認定延期通知発行年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護認定延期理由にnullが渡されたとき_NullPointerException発生() {
            要介護認定延期理由 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護認定一次判定情報抽出年月日にnullが渡されたとき_NullPointerException発生() {
            要介護認定一次判定情報抽出年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 依頼情報データ送信年月日にnullが渡されたとき_NullPointerException発生() {
            依頼情報データ送信年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査依頼完了年月日にnullが渡されたとき_NullPointerException発生() {
            認定調査依頼完了年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査完了年月日にnullが渡されたとき_NullPointerException発生() {
            認定調査完了年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医意見書作成依頼完了年月日にnullが渡されたとき_NullPointerException発生() {
            主治医意見書作成依頼完了年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医意見書登録完了年月日にnullが渡されたとき_NullPointerException発生() {
            主治医意見書登録完了年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護認定一次判定完了年月日にnullが渡されたとき_NullPointerException発生() {
            要介護認定一次判定完了年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護認定1_5次判定完了年月日にnullが渡されたとき_NullPointerException発生() {
            要介護認定1_5次判定完了年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 認定審査会割当完了年月日にnullが渡されたとき_NullPointerException発生() {
            認定審査会割当完了年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 認定審査会完了年月日にnullが渡されたとき_NullPointerException発生() {
            認定審査会完了年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }

        @Test(expected = NullPointerException.class)
        public void センター送信年月日にnullが渡されたとき_NullPointerException発生() {
            センター送信年月日 = null;
            sut = new YokaigoNinteiProgress(申請書管理番号, 認定申請情報登録年月日, 認定延期通知発行に対する同意有無, 認定延期通知発行年月日,
                    認定延期通知発行回数, 要介護認定延期理由, 要介護認定一次判定情報抽出年月日, 依頼情報データ送信年月日, 認定調査依頼完了年月日,
                    認定調査完了年月日, 主治医意見書作成依頼完了年月日, 主治医意見書登録完了年月日, 要介護認定一次判定完了年月日, 要介護認定1_5次判定完了年月日,
                    認定審査会割当完了年月日, 認定審査会完了年月日, センター送信年月日);
        }
    }
}
