/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 介護サービス種類のコンバーターのテストクラスです。
 *
 * @author LDNS 郭旗
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiMapperTest extends DbxTestBase {

    private static DbT7130KaigoServiceShuruiEntity entity;

    public KaigoServiceShuruiMapperTest() {
    }

    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドKaigoServiceShuruiMapperが呼び出される場合_KaigoServiceShuruiMapperは_インスタンス化成功() throws Exception {
            Constructor<KaigoServiceShuruiMapper> constructor = KaigoServiceShuruiMapper.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }

    public static class to介護サービス種類のテスト extends DbxTestBase {

        @Test
        public void LDNS_引数がentityの場合_to介護サービス種類は_IKaigoServiceShuruiのインスタンス() {
            assertThat(KaigoServiceShuruiMapper.to介護サービス種類(createEntity()), instanceOf(IKaigoServiceShurui.class));
        }

        @Test(expected = NullPointerException.class)
        public void LDNS_引数がnullの場合_to介護サービス種類は_NullPointerExceptionを返す() {
            KaigoServiceShuruiMapper.to介護サービス種類(null);
        }
    }

    public static class to介護サービス種類Entityのテスト extends DbxTestBase {

        @Test
        public void LDNS_引数がkaigoServiceShuruiの場合_to介護サービス種類Entityは_種類名称を返す() {
            IKaigoServiceShurui kaigoServiceShurui = mock(IKaigoServiceShurui.class);
            when(kaigoServiceShurui.getサービス種類コード()).thenReturn(new KaigoServiceShuruiCode(new RString("11")));
            when(kaigoServiceShurui.get提供年月()).thenReturn(new Range(FlexibleYearMonth.MIN, FlexibleYearMonth.MAX));
            when(kaigoServiceShurui.getサービス種類名称()).thenReturn(new RString("種類名称"));
            when(kaigoServiceShurui.getサービス種類名称略称()).thenReturn(new RString("種類名称略称"));
            when(kaigoServiceShurui.getサービス分類()).thenReturn(new KaigoServiceBunruiCode(new RString("001")));
            assertThat(KaigoServiceShuruiMapper.to介護サービス種類Entity(kaigoServiceShurui).getServiceShuruiMeisho(), is(new RString("種類名称")));
        }

        @Test(expected = NullPointerException.class)
        public void LDNS_引数がnullの場合_to介護サービス種類Entityは_NullPointerExceptionを返す() {
            KaigoServiceShuruiMapper.to介護サービス種類Entity(null);
        }
    }

    public static class to介護サービス種類リストのテスト extends DbxTestBase {

        @Test
        public void LDNS_引数がentitiesの場合_to介護サービス種類リストは_サイズが1を返す() {
            List<DbT7130KaigoServiceShuruiEntity> entities = new ArrayList<>();
            entities.add(createEntity());
            assertThat(KaigoServiceShuruiMapper.to介護サービス種類リスト(entities).size(), is(1));
        }

        @Test
        public void LDNS_引数がnullの場合_to介護サービス種類リストは_空のリストを返す() {
            List<DbT7130KaigoServiceShuruiEntity> entities = new ArrayList<>();
            assertThat(KaigoServiceShuruiMapper.to介護サービス種類リスト(entities), is(Collections.EMPTY_LIST));
        }
    }

    private static DbT7130KaigoServiceShuruiEntity createEntity() {
        entity = new DbT7130KaigoServiceShuruiEntity();
        entity.setServiceShuruiCd(new KaigoServiceShuruiCode("01"));
        entity.setTeikyoKaishiYM(FlexibleYearMonth.MIN);
        entity.setTeikyoshuryoYM(FlexibleYearMonth.MAX);
        entity.setServiceShuruiMeisho(new RString("種類名称"));
        entity.setServiceShuruiRyakusho(new RString("種類名称略称"));
        entity.setServiceBunrruicode(new KaigoServiceBunruiCode(new RString("001")));
        return entity;
    }
}
