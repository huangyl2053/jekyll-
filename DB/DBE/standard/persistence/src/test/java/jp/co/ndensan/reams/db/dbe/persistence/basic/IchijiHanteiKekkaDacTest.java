/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiResultSofuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 一次判定結果Dacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiKekkaDacTest {

    private static IchijiHanteiKekkaDac sut;

    @BeforeClass
    public static void setUpBeforeClass() {
        sut = InstanceProvider.create(IchijiHanteiKekkaDac.class);
    }

    public static class selectのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut.insert(create一次判定結果Entity("A000000001"));
        }

        @Test
        public void DB上のデータを取得できる() {
            DbT5016IchijiHanteiKekkaJohoEntity result = sut.select(new ShinseishoKanriNo(new RString("A000000001")));
            assertThat(result.getShinseishoKanriNo(), is(new ShinseishoKanriNo(new RString("A000000001"))));
        }

        @Test
        public void 存在しないデータを取得しようとした場合_nullが返る() {
            DbT5016IchijiHanteiKekkaJohoEntity result = sut.select(new ShinseishoKanriNo(new RString("B000000001")));
            assertThat(result, is(nullValue()));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void insertできる() {
            sut.insert(create一次判定結果Entity("A000000001"));
            DbT5016IchijiHanteiKekkaJohoEntity result = sut.select(new ShinseishoKanriNo(new RString("A000000001")));
            assertThat(result.getShinseishoKanriNo(), is(new ShinseishoKanriNo(new RString("A000000001"))));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Test
        public void updateできる() {
            sut.insert(create一次判定結果Entity("A000000001", KariIchijiHanteiKubun.本判定.is仮判定()));
            sut.update(create一次判定結果Entity("A000000001", KariIchijiHanteiKubun.仮判定.is仮判定()));
            DbT5016IchijiHanteiKekkaJohoEntity result = sut.select(new ShinseishoKanriNo(new RString("A000000001")));
            assertThat(result.getKariIchijiHanteiKubun(), is(false));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Test
        public void deleteできる() {
            sut.insert(create一次判定結果Entity("A000000001"));
            sut.delete(create一次判定結果Entity("A000000001"));
            DbT5016IchijiHanteiKekkaJohoEntity result = sut.select(new ShinseishoKanriNo(new RString("A000000001")));
            assertThat(result, is(nullValue()));
        }
    }

    //TODO n8178 城間篤人 insertとupdateの判別方法が決定した後にテスト作成予定 2014年3月
//    public static class insertOrUpdateのテスト extends DbeTestDacBase{
//
//    }
    private static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果Entity(String 申請書管理番号) {
        return create一次判定結果Entity(申請書管理番号, KariIchijiHanteiKubun.仮判定.is仮判定());
    }

    private static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果Entity(String 申請書管理番号, boolean 仮一次判定flag) {
        DbT5016IchijiHanteiKekkaJohoEntity entity = new DbT5016IchijiHanteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString(申請書管理番号)));
        entity.setKoroshoIfShikibetsuCode(KoroshoIFKubun.V02A.getCode());
        entity.setKariIchijiHanteiKubun(仮一次判定flag);
        entity.setIchijiHanteiYMD(FlexibleDate.MIN);
        entity.setIchijiHanteiKekkaCode(Code.EMPTY);
        entity.setIchijiHanteiKekkaNinchishoKasanCode(Code.EMPTY);
        entity.setKijunJikan(11);
        entity.setKijunJikanShokuji(12);
        entity.setKijunJikanHaisetsu(13);
        entity.setKijunJikanIdo(14);
        entity.setKijunJikanSeiketsuHoji(15);
        entity.setKijunJikanKansetsuCare(16);
        entity.setKijunJikanBPSDKanren(17);
        entity.setKijunJikanKinoKunren(18);
        entity.setKijunJikanIryoKanren(19);
        entity.setKijunJikanNinchishoKasan(20);
        entity.setChukanHyokaKomoku1gun(1);
        entity.setChukanHyokaKomoku2gun(2);
        entity.setChukanHyokaKomoku3gun(3);
        entity.setChukanHyokaKomoku4gun(4);
        entity.setChukanHyokaKomoku5gun(5);
        entity.setChukanHyokaKomoku6gun(6);
        entity.setChukanHyokaKomoku7gun(7);
        entity.setIchijiHanteiKeikokuCode(RString.EMPTY);
        entity.setJotaiAnteiseiCode(Code.EMPTY);
        entity.setNinchishoJiritsudoIIijoNoGaizensei(Decimal.ONE);
        entity.setSuiteiKyufuKubunCode(Code.EMPTY);
        entity.setNinchishoKoreishaShihyoCode(Code.EMPTY);
        entity.setJiritsudoKumiawase1(21);
        entity.setJiritsudoKumiawase2(22);
        entity.setJiritsudoKumiawase3(23);
        entity.setJiritsudoKumiawase4(24);
        entity.setJiritsudoKumiawase5(25);
        entity.setJiritsudoKumiawase6(26);
        entity.setJiritsudoKumiawase7(27);
        entity.setGaizenseiHyokaCode(Code.EMPTY);
        entity.setGaizenseiHyokaPercent(1);
        entity.setIchijiHanteiSofuKubun(IchijiHanteiResultSofuKubun.未送付.get送付区分コード());
        entity.setIchijiHanteiKekkaSofuYMD(FlexibleDate.MIN);
        return entity;
    }
}
