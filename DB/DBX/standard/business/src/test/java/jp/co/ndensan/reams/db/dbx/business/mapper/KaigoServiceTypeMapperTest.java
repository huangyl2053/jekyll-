/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.KaigoServiceTypeEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 介護サービス種類Entityを操作クラスに変換するクラスのテストクラスです。
 *
 * @author LDNS 馬広宇
 */
@RunWith(Enclosed.class)
public class KaigoServiceTypeMapperTest extends DbxTestBase {

    public KaigoServiceTypeMapperTest() {
    }

    public static class toKaigoServiceTypeのテスト extends DbxTestBase {

        @Test
        public void LDNS_引数を渡した場合_toKaigoServiceTypeは_介護サービス種類を取得する() {
            assertThat(KaigoServiceTypeMapper.toKaigoServiceType(createMockDac()).getサービス分類(), is(new RString("サービス分類")));
        }

        private static KaigoServiceTypeEntity createMockDac() {
            KaigoServiceTypeEntity mockDac = mock(KaigoServiceTypeEntity.class);
            when(mockDac.getサービス種類コード()).thenReturn(new RString("001"));
            when(mockDac.get提供開始年月()).thenReturn(new RDate("20120202"));
            when(mockDac.getサービス種類名称()).thenReturn(new RString("サービス種類名称"));
            when(mockDac.getサービス種類略称()).thenReturn(new RString("サービス種類略称"));
            when(mockDac.getサービス分類()).thenReturn(new RString("サービス分類"));
            return mockDac;
        }
    }
    
    public static class コンストラクタのテスト extends DbxTestBase {

        @Test(expected = InvocationTargetException.class)
        public void LDNS_メソッドKaigoServiceTypeMapperが呼び出される場合_KaigoServiceTypeMapperは_インスタンス化成功() throws Exception {
            Constructor<KaigoServiceTypeMapper> constructor = KaigoServiceTypeMapper.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }

}
