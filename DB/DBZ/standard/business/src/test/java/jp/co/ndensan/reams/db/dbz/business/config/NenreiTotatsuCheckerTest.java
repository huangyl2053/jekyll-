/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysNenreiTotatsuKijunJoho;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.model.IDateOfBirth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link NenreiTotatsuChecker}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NenreiTotatsuCheckerTest {

    private static NenreiTotatsuChecker sut;
    private static ConfigKeysNenreiTotatsuKijunJoho nenreiTotatsuKijun;
    private static RDate kijunDate;
    private static NenreiTotatsuKijunConfig config;

    public static class isValid_第1号年齢到達の判定 extends DbzTestBase {

        private RDate dateOfBirth;

        @Before
        public void setUp() {
            nenreiTotatsuKijun = ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第１号被保険者到達基準年齢;
            kijunDate = new RDate("20141201");
            config = createMockConfig();
            sut = new NenreiTotatsuChecker(nenreiTotatsuKijun, kijunDate, config);
        }

        @Test
        public void 基準日時点で65歳以上になる場合_trueが返る() {
            dateOfBirth = new RDate("19491202");
            assertThat(sut.personBornOn(dateOfBirth).has年齢到達(), is(true));
        }

        @Test
        public void 基準日時点で_年齢到達基準を満たさない場合_falseが返る() {
            dateOfBirth = new RDate("19491203");
            assertThat(sut.personBornOn(dateOfBirth).has年齢到達(), is(false));
        }
    }

    public static class isValid_第2号年齢到達の判定 extends DbzTestBase {

        private RDate dateOfBirth;

        @Before
        public void setUp() {
            nenreiTotatsuKijun = ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第２号被保険者到達基準年齢;
            kijunDate = new RDate("20141201");
            config = createMockConfig();
            sut = new NenreiTotatsuChecker(nenreiTotatsuKijun, kijunDate, config);
        }

        @Test
        public void 基準日時点で40歳以上になる場合_trueが返る() {
            dateOfBirth = new RDate("19741202");
            assertThat(sut.personBornOn(dateOfBirth).has年齢到達(), is(true));
        }

        @Test
        public void 基準日時点で_年齢到達基準を満たさない場合_falseが返る() {
            dateOfBirth = new RDate("19741203");
            assertThat(sut.personBornOn(dateOfBirth).has年齢到達(), is(false));
        }
    }

    public static class personBornOn extends DbzTestBase {

        private RDate dateOfBirth_RDate;
        private FlexibleDate dateOfBirth_FlexibleDate;
        private IDateOfBirth dateOfBirth_IDateOfBirth;

        @Before
        public void setUp() {
            nenreiTotatsuKijun = ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第２号被保険者到達基準年齢;
            kijunDate = new RDate("20141201");
            config = createMockConfig();
            sut = new NenreiTotatsuChecker(nenreiTotatsuKijun, kijunDate, config);
        }

        @Test(expected = NullPointerException.class)
        public void 暦上日としてnullが渡された場合_NullPointerExceptionが発生する() {
            dateOfBirth_IDateOfBirth = null;
            sut.personBornOn(dateOfBirth_RDate).has年齢到達();
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 非暦上日としてnullが渡された場合_NullPointerExceptionが発生する() {
            dateOfBirth_FlexibleDate = null;
            sut.personBornOn(dateOfBirth_FlexibleDate).has年齢到達();
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 生年月日としてnullが渡された場合_NullPointerExceptionが発生する() {
            dateOfBirth_IDateOfBirth = null;
            sut.personBornOn(dateOfBirth_IDateOfBirth).has年齢到達();
            fail();
        }

    }

    private static NenreiTotatsuKijunConfig createMockConfig() {
        NenreiTotatsuKijunConfig mock = mock(NenreiTotatsuKijunConfig.class);
        when(mock.get(ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第１号被保険者到達基準年齢))
                .thenReturn(65);
        when(mock.get(ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第２号被保険者到達基準年齢))
                .thenReturn(40);
        return mock;

    }

}
