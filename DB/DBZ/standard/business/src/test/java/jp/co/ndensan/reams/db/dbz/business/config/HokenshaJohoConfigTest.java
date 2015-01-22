/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TopPriorityArea;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.HokenshaName;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link HokenshaJohoConfig}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class HokenshaJohoConfigTest extends DbzTestBase {

    public static class get {

        private HokenshaJohoConfig sut;

        @Before
        public void setUp() {
            sut = new HokenshaJohoConfig(createBusinessConfigMock());
        }

        @Test
        public void 保険者情報_保険者構成を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get保険者情報_保険者構成();
            assertThat(result, is(new RString("1")));
        }

        @Test
        public void 保険者構成を指定したとき_業務コンフィグ設定値が返る() {
            HokenshaKosei result = sut.get保険者構成();
            assertThat(result, is(HokenshaKosei.toValue(new RString("1"))));
        }

        @Test
        public void 保険者情報_保険者番号を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get保険者情報_保険者番号();
            assertThat(result, is(new RString("202184")));
        }

        @Test
        public void 保険者番号を指定したとき_業務コンフィグ設定値が返る() {
            HokenshaNo result = sut.get保険者番号();
            assertThat(result, is(new HokenshaNo(new RString("202184"))));
        }

        @Test
        public void 保険者情報_保険者名称を指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get保険者情報_保険者名称();
            assertThat(result, is(new RString("合算市")));
        }

        @Test
        public void 保険者名称を指定したとき_業務コンフィグ設定値が返る() {
            HokenshaName result = sut.get保険者名();
            assertThat(result, is(new HokenshaName(new RString("合算市"))));
        }

        @Test
        public void 保険者情報_最優先地区コードを指定したとき_業務コンフィグ設定値が返る() {
            RString result = sut.get保険者情報_最優先地区コード();
            assertThat(result, is(new RString("4")));
        }

        @Test
        public void 最優先地区を指定したとき_業務コンフィグ設定値が返る() {
            TopPriorityArea result = sut.get最優先地区();
            assertThat(result, is(TopPriorityArea.toValue(new RString("4"))));
        }

    }

    private static IUrBusinessConfig createBusinessConfigMock() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        RDate nowDate = RDate.getNowDate();

        when(mock.get(
                ConfigKeysHokenshaJoho.保険者情報_保険者構成,
                nowDate,
                SubGyomuCode.DBU介護統計報告
        )).thenReturn(new RString("1"));
        when(mock.get(
                ConfigKeysHokenshaJoho.保険者情報_保険者番号,
                nowDate,
                SubGyomuCode.DBU介護統計報告
        )).thenReturn(new RString("202184"));
        when(mock.get(
                ConfigKeysHokenshaJoho.保険者情報_保険者名称,
                nowDate,
                SubGyomuCode.DBU介護統計報告
        )).thenReturn(new RString("合算市"));
        when(mock.get(
                ConfigKeysHokenshaJoho.保険者情報_最優先地区コード,
                nowDate,
                SubGyomuCode.DBU介護統計報告
        )).thenReturn(new RString("4"));
        return mock;
    }
}
