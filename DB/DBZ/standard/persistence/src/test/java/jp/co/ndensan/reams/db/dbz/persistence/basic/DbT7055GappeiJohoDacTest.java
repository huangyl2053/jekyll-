/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Restrictions;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 合併情報のデータアクセスクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class DbT7055GappeiJohoDacTest extends DbzTestDacBase {

    private static DbT7055GappeiJohoDac sut;

    private static final ITrueFalseCriteria 検索条件_該当0件 = Restrictions.eq(new RString("99"), DbT7055GappeiJoho.chiikiNo);
    private static final ITrueFalseCriteria 検索条件_該当1件 = Restrictions.eq(new RString("01"), DbT7055GappeiJoho.chiikiNo);
    private static final ITrueFalseCriteria 検索条件_該当2件 = Restrictions.eq(new RString("000001"), DbT7055GappeiJoho.shichosonCode);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7055GappeiJohoDac.class);
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void 合併情報が0件の時_selectAllは_0件の情報を返す() {
            initializeEntityData(0);
            assertThat(sut.selectAll().size(), is(0));
        }

        @Test
        public void 合併情報が1件の時_selectAllは_1件の情報を返す() {
            initializeEntityData(1);
            assertThat(sut.selectAll().size(), is(1));
        }

        @Test
        public void 合併情報が2件の時_selectAllは_2件の情報を返す() {
            initializeEntityData(2);
            assertThat(sut.selectAll().size(), is(2));
        }
    }

    public static class select extends DbzTestDacBase {

        @Before
        public void setup() {
            initializeEntityData(2);
        }

        @Test
        public void 該当の合併情報が0件の時_selectは_0件の情報を返す() {
            assertThat(sut.select(検索条件_該当0件).size(), is(0));
        }

        @Test
        public void 該当の合併情報が1件の時_selectは_1件の情報を返す() {
            assertThat(sut.select(検索条件_該当1件).size(), is(1));
        }

        @Test
        public void 該当の合併情報が2件の時_selectは_2件の情報を返す() {
            assertThat(sut.select(検索条件_該当2件).size(), is(2));
        }
    }

    private static void initializeEntityData(int count) {
        for (int i = 1; i <= count; i++) {
            sut.insert(createEntity(i));
        }
    }

    private static DbT7055GappeiJohoEntity createEntity(int no) {
        DbT7055GappeiJohoEntity entity = new DbT7055GappeiJohoEntity();
        entity.setGappeiYMD(new FlexibleDate(String.format("201401%1$02d", no)));
        entity.setChiikiNo(new RString(String.format("%1$02d", no)));
        entity.setShichosonCode(new LasdecCode("000001"));
        entity.setGappeiShurui(new RString("1"));
        entity.setHokenshaNo(new ShoKisaiHokenshaNo(new RString("000001")));
        entity.setKyuJohoFuyoToYMD(new FlexibleDate("20140201"));
        entity.setKokuhorenDataFromYMD(new FlexibleDate("20140301"));
        return entity;
    }
}
