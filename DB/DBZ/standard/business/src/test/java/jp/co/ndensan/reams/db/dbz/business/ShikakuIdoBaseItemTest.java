/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;

/**
 * ShikakuIdoItemのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShikakuIdoBaseItemTest extends DbzTestBase {

    /**
     * ShikakuIdoItemのサンプル実装です。
     */
    private static class ShikakuIdoBaseItemSample extends ShikakuIdoBaseItem<ShikakuShutokuJiyu> {

        public static final ShikakuIdoBaseItemSample NOTHING;

        static {
            NOTHING = new ShikakuIdoBaseItemSample(ShikakuShutokuJiyu.なし, FlexibleDate.MAX, FlexibleDate.MAX);
        }

        private ShikakuIdoBaseItemSample(ShikakuShutokuJiyu reason, FlexibleDate noticeDate, FlexibleDate actionDate) {
            super(reason, noticeDate, actionDate);
        }

        @Override
        public boolean isNothing() {
            return this == NOTHING;
        }
    }

    public static class Constructor extends DbzTestBase {

        private final int ReasonIsNull = 1;
        private final int NoticeDateIsNull = 2;
        private final int ActionDateIsNull = 3;

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_第1引数の資格異動事由がnullのとき_NullPointerExceptionをスローする() {
            callConstructorAs(ReasonIsNull);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_第2引数の届出年月日がnullのとき_NullPointerExceptionをスローする() {
            callConstructorAs(NoticeDateIsNull);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_第3引数の処理年月日がnullのとき_NullPointerExceptionをスローする() {
            callConstructorAs(ActionDateIsNull);
        }

        private void callConstructorAs(int flag) {
            ShikakuIdoBaseItemSample sut = new ShikakuIdoBaseItemSample(
                    flag == ReasonIsNull ? null : ShikakuShutokuJiyu.年齢到達,
                    flag == NoticeDateIsNull ? null : new FlexibleDate("20130617"),
                    flag == ActionDateIsNull ? null : new FlexibleDate("20130617"));
        }
    }

    public static class NOTHING extends DbzTestBase {

        @Test
        public void NOTHINGは_isNothingで_trueを返す() {
            assertThat(ShikakuIdoBaseItemSample.NOTHING.isNothing(), is(true));
        }

        @Test
        public void NOTHING以外は_isNothingで_falseを返す() {
            ShikakuIdoBaseItemSample sut = new ShikakuIdoBaseItemSample(ShikakuShutokuJiyu.なし, FlexibleDate.MAX, FlexibleDate.MAX);
            assertThat(sut.isNothing(), is(false));
        }
    }

    public static class Getter extends DbzTestBase {

        private ShikakuIdoBaseItemSample sut;
        private final ShikakuShutokuJiyu reason = ShikakuShutokuJiyu.年齢到達;
        private final FlexibleDate noticeDate = new FlexibleDate("20130617");
        private final FlexibleDate actionDate = new FlexibleDate("20130617");

        @Before
        public void setUp() {
            sut = new ShikakuIdoBaseItemSample(reason, noticeDate, actionDate);
        }

        @Test
        public void getReasonは_コンストラクタの第1引数に渡したものと_同じ値を返す() {
            assertThat(sut.getReason(), is(reason));
        }

        @Test
        public void getNoticeDateは_コンストラクタの第2引数に渡したものと_同じ値を返す() {
            assertThat(sut.getNoticeDate(), is(noticeDate));
        }

        @Test
        public void getActionDateは_コンストラクタの第3引数に渡したものと_同じ値を返す() {
            assertThat(sut.getActionDate(), is(actionDate));
        }
    }
}
