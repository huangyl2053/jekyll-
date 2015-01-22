/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichoson;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
 * 合併市町村のデータアクセスクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class DbT7056GappeiShichosonDacTest extends DbzTestDacBase {

    private static DbT7056GappeiShichosonDac sut;

    private static final ITrueFalseCriteria 検索条件_該当0件 = Restrictions.eq(new RString("99"), DbT7056GappeiShichoson.chiikiNo);
    private static final ITrueFalseCriteria 検索条件_該当1件 = Restrictions.eq(new RString("01"), DbT7056GappeiShichoson.chiikiNo);
    private static final ITrueFalseCriteria 検索条件_該当2件 = Restrictions.eq(new RString("00000001"), DbT7056GappeiShichoson.kyuHokenshaNo);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7056GappeiShichosonDac.class);
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void 合併市町村が0件の時_selectAllは_0件の情報を返す() {
            initializeEntityData(0);
            assertThat(sut.selectAll().size(), is(0));
        }

        @Test
        public void 合併市町村が1件の時_selectAllは_1件の情報を返す() {
            initializeEntityData(1);
            assertThat(sut.selectAll().size(), is(1));
        }

        @Test
        public void 合併市町村が2件の時_selectAllは_2件の情報を返す() {
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
        public void 該当の合併市町村が0件の時_selectは_0件の情報を返す() {
            assertThat(sut.select(検索条件_該当0件).size(), is(0));
        }

        @Test
        public void 該当の合併市町村が1件の時_selectは_1件の情報を返す() {
            assertThat(sut.select(検索条件_該当1件).size(), is(1));
        }

        @Test
        public void 該当の合併市町村が2件の時_selectは_2件の情報を返す() {
            assertThat(sut.select(検索条件_該当2件).size(), is(2));
        }
    }

    private static void initializeEntityData(int count) {
        for (int i = 1; i <= count; i++) {
            sut.insert(createEntity(i));
        }
    }

    private static DbT7056GappeiShichosonEntity createEntity(int no) {
        DbT7056GappeiShichosonEntity entity = new DbT7056GappeiShichosonEntity();
        entity.setGappeiYMD(new FlexibleDate(String.format("201401%1$02d", no)));
        entity.setChiikiNo(new RString(String.format("%1$02d", no)));
        entity.setKyuShichosonCode(new LasdecCode(String.format("%1$06d", no)));
        entity.setUnyoKaishiYMD(new FlexibleDate("20140201"));
        entity.setUnyoShuryoYMD(new FlexibleDate("20140301"));
        entity.setKyuHokenshaNo(new ShoKisaiHokenshaNo(new RString("00000001")));
        entity.setKyuShichosonMeisho(new RString("電算市"));
        entity.setTodofukenMeisho(new RString("電算県"));
        entity.setGunMeisho(new RString("電算郡"));
        entity.setYubinNo(new YubinNo("0010001"));
        entity.setTelNo(new TelNo("0010010001"));
        entity.setRojinhokenShichosonNo(new RString("00000001"));
        entity.setRokenJukyushaNoTaikei(new RString("1"));
        entity.setHyojiUmu(new RString("1"));
        return entity;
    }
}
