/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuShikibetsu;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護サービスのコンバーターのテストクラスです。
 *
 * @author LDNS 郭旗
 */
@RunWith(Enclosed.class)
public class KaigoServiceMapperTest extends DbxTestBase {

    private static List<DbT7130KaigoServiceShuruiEntity> shuruiEntities;
    private static List<DbT7131KaigoServiceNaiyouEntity> kaigoServiceNaiyoList;

    public KaigoServiceMapperTest() {
    }

    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドKaigoServiceMapperが呼び出される場合_KaigoServiceMapperは_インスタンス化成功() throws Exception {
            Constructor<KaigoServiceMapper> constructor = KaigoServiceMapper.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }

    public static class to介護サービスのテスト extends DbxTestBase {

        @Before
        public void setUp() {
            shuruiEntities = new ArrayList<>();
            kaigoServiceNaiyoList = new ArrayList<>();
        }

        @Test
        public void LDNS_空のリストの場合_to介護サービスは_nullを返す() {
            KaigoServiceMapper.to介護サービス(shuruiEntities, kaigoServiceNaiyoList);
            assertThat(KaigoServiceMapper.to介護サービス(shuruiEntities, kaigoServiceNaiyoList), is(nullValue()));
        }

        @Test(expected = IllegalArgumentException.class)
        public void LDNS_空のshuruiEntitiesの場合_to介護サービスは_IllegalArgumentExceptionを返す() {
            kaigoServiceNaiyoList.add(createDbT7131Entity());
            KaigoServiceMapper.to介護サービス(shuruiEntities, kaigoServiceNaiyoList);
        }

        @Test
        public void LDNS_空のkaigoServiceNaiyoListの場合_to介護サービスは_サイズが0を返す() {
            shuruiEntities.add(createDbT7130Entity());
            KaigoServiceMapper.to介護サービス(shuruiEntities, kaigoServiceNaiyoList);
            assertThat(KaigoServiceMapper.to介護サービス(shuruiEntities, kaigoServiceNaiyoList).get介護サービス内容リスト().size(), is(0));
        }

        @Test
        public void LDNS_引数がリストの場合_to介護サービスは_サイズが1を返す() {
            shuruiEntities.add(createDbT7130Entity());
            kaigoServiceNaiyoList.add(createDbT7131Entity());
            KaigoServiceMapper.to介護サービス(shuruiEntities, kaigoServiceNaiyoList);
            assertThat(KaigoServiceMapper.to介護サービス(shuruiEntities, kaigoServiceNaiyoList).get介護サービス内容リスト().size(), is(1));
        }
    }

    private static DbT7130KaigoServiceShuruiEntity createDbT7130Entity() {
        DbT7130KaigoServiceShuruiEntity entity = new DbT7130KaigoServiceShuruiEntity();
        entity.setServiceShuruiCd(new KaigoServiceShuruiCode("01"));
        entity.setTeikyoKaishiYM(FlexibleYearMonth.MIN);
        entity.setTeikyoshuryoYM(FlexibleYearMonth.MAX);
        entity.setServiceShuruiMeisho(new RString("種類名称"));
        entity.setServiceShuruiRyakusho(new RString("種類名称略称"));
        entity.setServiceBunrruicode(new KaigoServiceBunruiCode(new RString("001")));
        return entity;
    }

    private static DbT7131KaigoServiceNaiyouEntity createDbT7131Entity() {
        DbT7131KaigoServiceNaiyouEntity entity = new DbT7131KaigoServiceNaiyouEntity();
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
