/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
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
 * 構成市町村マスタのデータアクセスクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterDacTest extends DbzTestDacBase {

    private static KoseiShichosonMasterDac sut;

    private static final ITrueFalseCriteria 検索条件_該当0件 = Restrictions.eq(new RString("99"), DbT7051KoseiShichosonMaster.shichosonShokibetsuID);
    private static final ITrueFalseCriteria 検索条件_該当1件 = Restrictions.eq(new RString("01"), DbT7051KoseiShichosonMaster.shichosonShokibetsuID);
    private static final ITrueFalseCriteria 検索条件_該当2件 = Restrictions.eq(new RString("01"), DbT7051KoseiShichosonMaster.gappeiLinkNo);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KoseiShichosonMasterDac.class);
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

    private static DbT7051KoseiShichosonMasterEntity createEntity(int no) {
        DbT7051KoseiShichosonMasterEntity entity = new DbT7051KoseiShichosonMasterEntity();
        entity.setShichosonShokibetsuID(new RString(String.format("%1$02d", no)));
        entity.setShichosonCode(new RString(String.format("%1$05d", no)));
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString(String.format("%1$06d", no))));
        entity.setKokuhorenKoikiShichosonNo(new RString("001"));
        entity.setShichosonMeisho(new RString("電算市"));
        entity.setTodofukenMeisho(new RString("電算県"));
        entity.setGunMeisho(new RString("電算郡"));
        entity.setYubinNo(new YubinNo("0010001"));
        entity.setJusho(new AtenaJusho("電算住所"));
        entity.setTelNo(new TelNo("0010010001"));
        entity.setYusenChikuCode(new RString("1"));
        entity.setTyohyoTodoufukenHyojiUmu(new RString("1"));
        entity.setTyohyoGunHyojiUmu(new RString("1"));
        entity.setTyohyoShichosonHyojiUmu(new RString("1"));
        entity.setTyohyoJushoHenshuHouhou(new RString("1"));
        entity.setTyohyoKatagakiHyojiUmu(new RString("1"));
        entity.setGaikokujinHyojiHouhou(new RString("1"));
        entity.setRojinhokenShichosonNo(new RString("00000001"));
        entity.setRokenJukyushaNoTaikei(new RString("1"));
        entity.setIkoYMD(new FlexibleDate("20140201"));
        entity.setKanyuYMD(new FlexibleDate("20140301"));
        entity.setRidatsuYMD(new FlexibleDate("20140401"));
        entity.setGappeiKyuShichosonKubun(new RString("1"));
        entity.setGappeiKyuShichosonHyojiUmu(new RString("1"));
        entity.setGappeiLinkNo(new RString("01"));
        entity.setUnyoHokenshaNo(new ShoKisaiHokenshaNo(new RString("000001")));
        entity.setUnyoKaishiYMD(new FlexibleDate("20140501"));
        entity.setUnyoShuryoYMD(new FlexibleDate("20140601"));
        entity.setUnyoKeitaiKubun(new RString("1"));
        return entity;
    }
}
