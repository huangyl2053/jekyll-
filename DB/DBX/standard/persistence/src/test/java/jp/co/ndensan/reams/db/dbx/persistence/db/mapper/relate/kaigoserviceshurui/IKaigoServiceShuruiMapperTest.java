/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.kaigoserviceshurui;

import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigoserviceshurui.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7130KaigoServiceShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigoserviceshurui.KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IKaigoServiceShuruiMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IKaigoServiceShuruiMapperTest {

    private static IKaigoServiceShuruiMapper sut;
    private static KaigoServiceShuruiEntity result;

    private static DbT7130KaigoServiceShuruiDac 介護サービス種類Dac;
    private static DbT7131KaigoServiceNaiyouDac 介護サービス内容Dac;

    private static KaigoServiceShuruiMapperParameter param;
    private static DbTestHelper dbTestHelper;

    private static ServiceShuruiCode serviceShuruiCd;
    private static FlexibleYearMonth teikyoKaishiYM;
    private static RString serviceKoumokuCode;
    private static Decimal rirekiNo;

//    @BeforeClass
//    public static void setUpClass() {
//        dbTestHelper = new DbTestHelper();
//        serviceShuruiCd = new KaigoServiceShuruiCode(new RString("12"));
//        teikyoKaishiYM = new FlexibleYearMonth(new RString("201510"));
//        DbxTestDacBase.setUpClassInternal();
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//        DbxTestDacBase.afterTearDownClass();
//    }
    @Ignore
    public static class get介護サービス_DbT7130KaigoServiceShurui介護サービス種類情報取得Test extends DbxTestDacBase {

        @Before
        public void setUp() {

            dbTestHelper.truncateTable(sqlSession, DbT7130KaigoServiceShuruiEntity.TABLE_NAME);
            sut = sqlSession.getMapper(IKaigoServiceShuruiMapper.class);

        }

        @Test
        public void 指定のパラメータと同様ない主キーを持つDbT7130介護サービス種類が存在しない場合_getKaigoServiceEntityメソッドにより_nullが返却される() {
            TestSupport.insertDbT7130(serviceShuruiCd, teikyoKaishiYM);
            param = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(new ServiceShuruiCode(new RString("1234")), new FlexibleYearMonth(new RString("201510")));

            result = sut.getKaigoServiceEntity(param);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 指定のパラメータと同様の主キーを持つDbT7130介護サービス種類が存在する場合_getKaigoServiceEntityメソッドにより_指定のパラメータと同様の主キーを持つ介護サービス種類DbT7130を保持するKaigoServiceEntityを取得する() {
            TestSupport.insertDbT7130(serviceShuruiCd, teikyoKaishiYM);
            param = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(serviceShuruiCd, teikyoKaishiYM);
            result = sut.getKaigoServiceEntity(param);
            assertThat(result.get介護サービス種類Entity().getServiceShuruiCd().toString(), is(serviceShuruiCd.toString()));
            assertThat(result.get介護サービス種類Entity().getTeikyoKaishiYM().toString(), is(teikyoKaishiYM.toString()));
        }
    }

    @Ignore
    public static class get介護サービス_DbT7131KaigoServiceNaiyou介護サービス内容情報取得Test extends DbxTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper = new DbTestHelper();
            serviceShuruiCd = new ServiceShuruiCode(new RString("23"));
            serviceKoumokuCode = new RString("789");
            teikyoKaishiYM = new FlexibleYearMonth(new RString("201510"));
            rirekiNo = new Decimal(1265);
            DbxTestDacBase.setUpClassInternal();
        }

        @Test
        public void 指定のパラメータと同様ない主キーを持つDbT7131介護サービス内容が存在しない場合_getKaigoServiceEntityメソッドにより_nullが返却される() {
            TestSupport.insertDBT7131(serviceShuruiCd, serviceKoumokuCode, teikyoKaishiYM, rirekiNo);
            param = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(new ServiceShuruiCode(new RString("1234")), new FlexibleYearMonth(new RString("201510")));
            result = sut.getKaigoServiceEntity(param);
            assertThat(result.get介護サービス内容Entity().size(), is(0));
        }

        @Test
        public void 指定のパラメータと同様の主キーを持つDbT7131介護サービス内容が存在する場合_getKaigoServiceEntityメソッドにより_指定のパラメータと同様の主キーを持つDbT7131介護サービス内容1件保持するを保持するKaigoServiceEntityを取得する() {
            TestSupport.insertDBT7131(serviceShuruiCd, serviceKoumokuCode, teikyoKaishiYM, rirekiNo);
            param = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(serviceShuruiCd, teikyoKaishiYM);
            result = sut.getKaigoServiceEntity(param);
            assertThat(result.get介護サービス内容Entity().get(0).getServiceShuruiCd(), is(serviceShuruiCd));
            assertThat(result.get介護サービス内容Entity().get(0).getServiceKoumokuCd(), is(serviceKoumokuCode));
            assertThat(result.get介護サービス内容Entity().get(0).getTeikyoKaishiYM(), is(teikyoKaishiYM));
            assertThat(result.get介護サービス内容Entity().get(0).getRirekiNo(), is(rirekiNo));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT7130(
                ServiceShuruiCode 主キー1,
                FlexibleYearMonth 主キー2) {
            DbT7130KaigoServiceShuruiEntity entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            entity.setServiceShuruiCd(主キー1);
            entity.setTeikyoKaishiYM(主キー2);
            entity.setState(EntityDataState.Added);
            介護サービス種類Dac.save(entity);
        }

        public static void insertDBT7131(ServiceShuruiCode serviceShuruiCode, RString serviceKoumokuCode, FlexibleYearMonth teikyoKaishiYM, Decimal rirekiNo) {
            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.setServiceShuruiCd(serviceShuruiCode);
            entity.setServiceKoumokuCd(serviceKoumokuCode);
            entity.setTeikyoKaishiYM(teikyoKaishiYM);
            entity.setRirekiNo(rirekiNo);
            介護サービス内容Dac.save(entity);
        }
    }

}
