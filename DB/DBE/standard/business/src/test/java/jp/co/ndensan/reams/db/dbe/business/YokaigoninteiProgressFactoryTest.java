/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import com.google.common.base.Objects;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgressFactory.ParticularDates;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ConsentsToEnkitsuchiHakko;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * 要介護認定進捗情報の年月日を変更して生成するクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class YokaigoninteiProgressFactoryTest extends DbeTestBase {

    public static class コンストラクタ extends DbeTestBase {

        private static YokaigoNinteiProgressFactory sut;

        @Test(expected = NullPointerException.class)
        public void コンストラクタで_引数にNULLが渡されたとき_NullPointerExceptionが発生すること() {
            YokaigoNinteiProgress progress = null;
            sut = new YokaigoNinteiProgressFactory(progress);
        }
    }

    public static class createYokaigoninteiPorgressWith extends DbeTestBase {

        private static YokaigoNinteiProgressFactory sut;
        private static YokaigoNinteiProgress newProgress;
        private static FlexibleDate 変更年月日;

        @Before
        public void setUp() {
            変更年月日 = new FlexibleDate(new RString("20100101"));
            sut = new YokaigoNinteiProgressFactory(create認定進捗情報());
        }

        @Test
        public void createYokaigoninteiPorgressWithで_認定申請情報登録年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.認定申請情報登録年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.get認定申請情報登録年月日(), 変更年月日), is(true));
        }

        @Test
        public void createYokaigoninteiPorgressWithで_認定延期通知発行年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.認定延期通知発行年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.get認定延期通知発行年月日(), 変更年月日), is(true));
        }

        @Test
        public void createYokaigoninteiPorgressWithで_要介護認定一次判定情報抽出年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.要介護認定一次判定情報抽出年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.get要介護認定一次判定情報抽出年月日(), 変更年月日), is(true));
        }

        @Test
        public void createYokaigoninteiPorgressWithで_依頼情報データ送信年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.依頼情報データ送信年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.get依頼情報データ送信年月日(), 変更年月日), is(true));
        }

        @Test
        public void createYokaigoninteiPorgressWithで_認定調査依頼完了年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.認定調査依頼完了年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.get認定調査依頼完了年月日(), 変更年月日), is(true));
        }

        @Test
        public void createYokaigoninteiPorgressWithで_認定調査完了年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.認定調査完了年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.get認定調査完了年月日(), 変更年月日), is(true));
        }

        @Test
        public void createYokaigoninteiPorgressWithで_主治医意見書作成依頼完了年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.主治医意見書作成依頼完了年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.get主治医意見書作成依頼完了年月日(), 変更年月日), is(true));
        }

        @Test
        public void createYokaigoninteiPorgressWithで_主治医意見書登録完了年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.主治医意見書登録完了年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.get主治医意見書登録完了年月日(), 変更年月日), is(true));
        }

        @Test
        public void createYokaigoninteiPorgressWithで_要介護認定一次判定完了年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.要介護認定一次判定完了年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.get要介護認定一次判定完了年月日(), 変更年月日), is(true));
        }

        @Test
        public void createYokaigoninteiPorgressWithで_要介護認定1_5次判定完了年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.要介護認定1_5次判定完了年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.get要介護認定1_5次判定完了年月日(), 変更年月日), is(true));
        }

        @Test
        public void createYokaigoninteiPorgressWithで_認定審査会割当完了年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.認定審査会割当完了年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.get認定審査会割当完了年月日(), 変更年月日), is(true));
        }

        @Test
        public void createYokaigoninteiPorgressWithで_認定審査会完了年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.認定審査会完了年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.get認定審査会完了年月日(), 変更年月日), is(true));
        }

        @Test
        public void createYokaigoninteiPorgressWithで_センター送信年月日を変更した場合_生成された要介護認定進捗情報の年月日が変更されること() {
            newProgress = sut.createYokaigoninteiPorgressWith(ParticularDates.センター送信年月日, 変更年月日);
            assertThat(Objects.equal(newProgress.getセンター送信年月日(), 変更年月日), is(true));
        }
    }

    private static YokaigoNinteiProgress create認定進捗情報() {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("0001"));
        FlexibleDate 認定申請情報登録年月日 = new FlexibleDate(new RString("20140101"));
        boolean 認定延期通知発行に対する同意有無 = true;
        FlexibleDate 認定延期通知発行年月日 = new FlexibleDate(new RString("20140102"));
        int 認定延期通知発行回数 = 1;
        RString 要介護認定延期理由 = new RString("理由");
        FlexibleDate 要介護認定一次判定情報抽出年月日 = new FlexibleDate(new RString("20140103"));
        FlexibleDate 依頼情報データ送信年月日 = new FlexibleDate(new RString("20140104"));
        FlexibleDate 認定調査依頼完了年月日 = new FlexibleDate(new RString("20140105"));
        FlexibleDate 認定調査完了年月日 = new FlexibleDate(new RString("20140106"));
        FlexibleDate 主治医意見書作成依頼完了年月日 = new FlexibleDate(new RString("20140107"));
        FlexibleDate 主治医意見書登録完了年月日 = new FlexibleDate(new RString("20140108"));
        FlexibleDate 要介護認定一次判定完了年月日 = new FlexibleDate(new RString("20140109"));
        FlexibleDate 要介護認定1_5次判定完了年月日 = new FlexibleDate(new RString("20140110"));
        FlexibleDate 認定審査会割当完了年月日 = new FlexibleDate(new RString("20140111"));
        FlexibleDate 認定審査会完了年月日 = new FlexibleDate(new RString("20140112"));
        FlexibleDate センター送信年月日 = new FlexibleDate(new RString("20140113"));
        return new YokaigoNinteiProgress(
                申請書管理番号,
                認定申請情報登録年月日,
                ConsentsToEnkitsuchiHakko.toValue(認定延期通知発行に対する同意有無),
                認定延期通知発行年月日,
                認定延期通知発行回数,
                要介護認定延期理由,
                要介護認定一次判定情報抽出年月日,
                依頼情報データ送信年月日,
                認定調査依頼完了年月日,
                認定調査完了年月日,
                主治医意見書作成依頼完了年月日,
                主治医意見書登録完了年月日,
                要介護認定一次判定完了年月日,
                要介護認定1_5次判定完了年月日,
                認定審査会割当完了年月日,
                認定審査会完了年月日,
                センター送信年月日);
    }
}
