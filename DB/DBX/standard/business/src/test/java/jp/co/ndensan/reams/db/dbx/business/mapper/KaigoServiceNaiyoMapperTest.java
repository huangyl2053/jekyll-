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
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoServiceCode;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoServiceNaiyo;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoServiceTani;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuSanteiTani;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuShikibetsu;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 介護サービス内容のコンバーターのテストクラスです。
 *
 * @author LDNS 郭旗
 */
@RunWith(Enclosed.class)
public class KaigoServiceNaiyoMapperTest extends DbxTestBase {

    private static DbT7131KaigoServiceNaiyouEntity entity;

    public KaigoServiceNaiyoMapperTest() {
    }

    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドKaigoServiceNaiyoMapperが呼び出される場合_KaigoServiceNaiyoMapperは_インスタンス化成功() throws Exception {
            Constructor<KaigoServiceNaiyoMapper> constructor = KaigoServiceNaiyoMapper.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }

    public static class to介護サービス内容のテスト extends DbxTestBase {

        @Test
        public void LDNS_引数がentityの場合_to介護サービス内容は_IKaigoServiceShuruiのインスタンス() {
            assertThat(KaigoServiceNaiyoMapper.to介護サービス内容(createEntity()), instanceOf(IKaigoServiceNaiyo.class));
        }

        @Test(expected = NullPointerException.class)
        public void LDNS_引数がnullの場合_to介護サービス内容は_NullPointerExceptionを返す() {
            KaigoServiceNaiyoMapper.to介護サービス内容(null);
        }
    }

    public static class to介護サービス内容Entityのテスト extends DbxTestBase {

        @Test
        public void LDNS_引数がkaigoServiceNaiyoの場合_to介護サービス内容Entityは_1を返す() {
            IKaigoServiceNaiyo kaigoServiceNaiyo = mock(IKaigoServiceNaiyo.class);
            IKaigoServiceCode iKaigoServiceCode = mock(IKaigoServiceCode.class);
            when(kaigoServiceNaiyo.getサービスコード()).thenReturn(iKaigoServiceCode);
            when(iKaigoServiceCode.getサービス種類コード()).thenReturn(new KaigoServiceShuruiCode(new RString("21")));
            when(iKaigoServiceCode.getサービス項目コード()).thenReturn((new RString("21")));
            when(kaigoServiceNaiyo.get適用年月()).thenReturn(new Range(FlexibleYearMonth.MIN, FlexibleYearMonth.MAX));
            when(kaigoServiceNaiyo.get履歴番号()).thenReturn(1);
            when(kaigoServiceNaiyo.getサービス名称()).thenReturn(new RString("service"));
            when(kaigoServiceNaiyo.getサービス略称()).thenReturn(new RString("serviceRyaku"));
            IKaigoServiceTani iKaigoServiceTani = mock(IKaigoServiceTani.class);
            when(kaigoServiceNaiyo.get介護サービス単位()).thenReturn(iKaigoServiceTani);
            when(iKaigoServiceTani.get単位数()).thenReturn(1);
            when(iKaigoServiceTani.get単位数算定単位()).thenReturn(new TanisuSanteiTani(new Code(new RString("23"))));
            when(iKaigoServiceTani.get単位数識別()).thenReturn(new TanisuShikibetsu(new Code(new RString("23"))));
            assertThat(KaigoServiceNaiyoMapper.to介護サービス内容Entity(kaigoServiceNaiyo).getTaniSu(), is(1));
        }

        @Test(expected = NullPointerException.class)
        public void LDNS_引数がnullの場合_to介護サービス内容Entityは_NullPointerExceptionを返す() {
            KaigoServiceNaiyoMapper.to介護サービス内容Entity(null);
        }
    }

    public static class to介護サービス内容リストのテスト extends DbxTestBase {

        @Test
        public void LDNS_引数がentitiesの場合_to介護サービス内容リストは_サイズが1を返す() {
            List<DbT7131KaigoServiceNaiyouEntity> entities = new ArrayList<>();
            entities.add(createEntity());
            assertThat(KaigoServiceNaiyoMapper.to介護サービス内容リスト(entities).size(), is(1));
        }

        @Test
        public void LDNS_引数がnullの場合_to介護サービス内容リストは_空のリストを返す() {
            List<DbT7131KaigoServiceNaiyouEntity> entities = new ArrayList<>();
            assertThat(KaigoServiceNaiyoMapper.to介護サービス内容リスト(entities), is(Collections.EMPTY_LIST));
        }
    }

    private static DbT7131KaigoServiceNaiyouEntity createEntity() {
        entity = new DbT7131KaigoServiceNaiyouEntity();
        entity.setServiceShuruiCode(new KaigoServiceShuruiCode(new RString("21")));
        entity.setServiceKoumokuCode(new RString("serviceCode"));
        entity.setTaniSu(1);
        entity.setTanisuShikibetsuCode(new TanisuShikibetsu(new RString("202")));
        entity.setTeikyoKaishiYM(FlexibleYearMonth.MIN);
        entity.setTeikyoShuryoYM(FlexibleYearMonth.MAX);
        entity.setRirekiNo(Decimal.ONE);
        entity.setServiceName(new RString("service"));
        entity.setServiceNameRyaku(new RString("serviceRyaku"));
        return entity;
    }
}
