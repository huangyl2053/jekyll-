/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoServiceIdoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TanisuSanteiTani;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.TanisuShikibetsu;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7131KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.contains;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護サービス内容テーブルにアクセスするクラスのテストクラスです
 *
 * @author LDNS 梁百川
 */
@RunWith(Enclosed.class)
public class DbT7131KaigoServiceNaiyouDacTest extends DbxTestDacBase {

    private static DbT7131KaigoServiceNaiyouDac sut;
    private final static KaigoServiceShuruiCode 介護サービス種類コード = new KaigoServiceShuruiCode("01");
    private final static RString 介護サービス項目コード = new RString("2345");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7131KaigoServiceNaiyouDac.class);
    }

    public static class selectListのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert();
        }

        @Test
        public void LDNS_引数を設定した場合_selectListは_サイズが１のリストを返す() {
            ITrueFalseCriteria criteria = contains(DbT7131KaigoServiceNaiyou.serviceShuruiCode, 介護サービス種類コード.toString());
            assertThat(sut.selectList(criteria).size(), is(1));
        }
    }

    public static class insertOrUpdateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert();
        }

        @Test
        public void LDNS_updateの場合_insertOrUpdateは_１を返す() {
            DbT7131KaigoServiceNaiyouEntity entity = TestSupport.createDbT7131KaigoServiceNaiyouEntity();
            entity.setTanisuShikibetsuCode(new TanisuShikibetsu(new RString("002")));
            assertThat(sut.insertOrUpdate(entity), is(1));
        }

        @Test
        public void LDNS_insertの場合_insertOrUpdateは_１を返す() {
            DbT7131KaigoServiceNaiyouEntity entity = TestSupport.createDbT7131KaigoServiceNaiyouEntity();
            entity.setServiceShuruiCode(new KaigoServiceShuruiCode("02"));
            assertThat(sut.insertOrUpdate(entity), is(1));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert();
        }

        @Test
        public void LDNS_引数を設定した場合_deleteは_１を返す() {
            DbT7131KaigoServiceNaiyouEntity entity = TestSupport.createDbT7131KaigoServiceNaiyouEntity();
            assertThat(sut.delete(entity), is(1));
        }

    }

    private static class TestSupport {

        public static DbT7131KaigoServiceNaiyouEntity createDbT7131KaigoServiceNaiyouEntity() {
            DbT7131KaigoServiceNaiyouEntity entity = new DbT7131KaigoServiceNaiyouEntity();
            entity.setServiceShuruiCode(介護サービス種類コード);
            entity.setServiceKoumokuCode(介護サービス項目コード);
            entity.setTeikyoKaishiYM(new FlexibleYearMonth("201304"));
            entity.setTeikyoShuryoYM(new FlexibleYearMonth("201305"));
            entity.setRirekiNo(Decimal.ZERO);
            entity.setServiceName(new RString("内容名称１"));
            entity.setServiceNameRyaku(new RString("内容名称略称１"));
            entity.setTaniSu(3);
            entity.setTanisuShikibetsuCode(new TanisuShikibetsu(new RString("001")));
            entity.setTanisuSanteiTani(new TanisuSanteiTani(new RString("3000")));
            entity.setIdouJiyuCode(new KaigoServiceIdoJiyu(new RString("123")));
            return entity;
        }

        public static void insert() {
            DbT7131KaigoServiceNaiyouEntity entity = createDbT7131KaigoServiceNaiyouEntity();
            sut.insert(entity);
        }

        public static void deleteData() {
            CSVDataUtilForUseSession utilForUseSession = new CSVDataUtilForUseSession();
            utilForUseSession.clearTable(sqlSession, DbT7131KaigoServiceNaiyouEntity.TABLE_NAME.toString());
        }
    }

}
