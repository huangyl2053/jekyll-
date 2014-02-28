/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 合議体ダミーのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiDummyTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void 引数にtrueを渡したとき_ダミーが返る() {
            assertThat(GogitaiDummy.toValue(true), is(GogitaiDummy.ダミー));
        }

        @Test
        public void 引数にfalseを渡したとき_notダミーが返る() {
            assertThat(GogitaiDummy.toValue(false), is(GogitaiDummy.notダミー));
        }
    }
}
