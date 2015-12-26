/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho;

import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaName;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TopPriorityArea;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link HokenshaJohoConfig}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class HokenshaJohoConfigTest extends DbxTestBase {

    public static class get {

        static HokenshaJohoConfig sut;

        @Before
        public void setUp() {
            createBusinessConfigMock();
            sut = new HokenshaJohoConfig();
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

    private static BusinessConfig createBusinessConfigMock() {
        BusinessConfig mock = mock(BusinessConfig.class);
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
