/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiTest {

    private static Shinsakai sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 審査会情報にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Shinsakai(null, createList(3));
        }

        @Test(expected = NullPointerException.class)
        public void 割当委員Listにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Shinsakai(ShinsakaiTestBusinessCreator.create審査会情報(1, "19990101"), null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 審査会情報と_割当委員がそれぞれ持つ審査会情報が一致しないとき_IllegalArgumentExceptionが発生する() {
            sut = new Shinsakai(ShinsakaiTestBusinessCreator.create審査会情報(2, "19990101"), createList(3));
        }

        @Test
        public void 必要な条件を満たしたとき_インスタンスが生成される() {
            sut = new Shinsakai(ShinsakaiTestBusinessCreator.create審査会情報(1, "19990101"), createList(3));
            assertThat(sut, is(instanceOf(Shinsakai.class)));
        }
    }

    private static ShinsakaiWariateIinList createList(int 件数) {
        List<ShinsakaiWariateIin> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(ShinsakaiTestBusinessCreator.create審査会割当委員(1, "19990101", "A001"));
        }
        return new ShinsakaiWariateIinList(list);
    }
}
