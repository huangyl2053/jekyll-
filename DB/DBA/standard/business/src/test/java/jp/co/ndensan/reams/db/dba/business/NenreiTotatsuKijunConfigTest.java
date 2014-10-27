/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ConfigKeysNenreiTotatsuKijun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NenreiTotatsuKijunConfigTest}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NenreiTotatsuKijunConfigTest {

    public static class get extends DbaTestBase {

        private NenreiTotatsuKijunConfig sut;

        @Before
        public void setUp() {
            sut = new NenreiTotatsuKijunConfig(createMap());
        }

        @Test
        public void 年齢到達基準_65歳を指定したとき_65が返る() {
            int result = sut.get(ConfigKeysNenreiTotatsuKijun.年齢到達基準_65歳);
            assertThat(result, is(65));
        }

        public void 年齢到達基準_40歳を指定したとき_40が返る() {
            int result = sut.get(ConfigKeysNenreiTotatsuKijun.年齢到達基準_40歳);
            assertThat(result, is(40));
        }
    }

    private static Map<ConfigKeysNenreiTotatsuKijun, RString> createMap() {
        Map<ConfigKeysNenreiTotatsuKijun, RString> map = new HashMap<>();
        map.put(ConfigKeysNenreiTotatsuKijun.年齢到達基準_65歳, new RString("65"));
        map.put(ConfigKeysNenreiTotatsuKijun.年齢到達基準_40歳, new RString("40"));
        return map;
    }

}
