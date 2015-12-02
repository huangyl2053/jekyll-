/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hokensha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.Hokensha;
import jp.co.ndensan.reams.db.dba.business.core.hokensha.KenCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hokensha.HokenjaMapperParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.zenkokujusho.ZenkokuJushoAzaSento;
import jp.co.ndensan.reams.ur.urz.definition.core.zenkokujusho.ZenkokuJushoDataKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.zenkokujusho.ZenkokuJushoOoazaSento;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.hokenja.UrT0507HokenjaEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.zenkokujusho.UrT0101ZenkokuJushoEntity;
import jp.co.ndensan.reams.ur.urz.persistence.db.basic.hokenja.UrT0507HokenjaDac;
import jp.co.ndensan.reams.ur.urz.persistence.db.basic.zenkokujusho.UrT0101ZenkokuJushoDac;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * {@link HokenshaNyuryokuHojoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HokenshaNyuryokuHojoFinderTest extends DbaTestDacBase {

    private static HokenshaNyuryokuHojoFinder sut;
    private static UrT0507HokenjaDac urT0507Dac;
    private static UrT0101ZenkokuJushoDac urT0101Dac;

    public static final HokenjaShubetsu 保険者種別1 = new HokenjaShubetsu(new RString("08"));
    public static final HokenjaNo 保険者番号1 = new HokenjaNo(new RString("101101"));
    public static final HokenjaShubetsu 保険者種別2 = new HokenjaShubetsu(new RString("08"));
    public static final HokenjaNo 保険者番号2 = new HokenjaNo(new RString("102102"));
    public static final ZenkokuJushoDataKubun データ区分1 = new ZenkokuJushoDataKubun(1);
    public static final ZenkokuJushoDataKubun データ区分2 = new ZenkokuJushoDataKubun(2);
    public static final RString 都道府県住所コード1 = new RString("01");
    public static final RString 都道府県住所コード2 = new RString("02");
    public static final RString 市町村住所コード1 = new RString("01");
    public static final RString 市町村住所コード2 = new RString("02");
    public static final RString 大字住所コード1 = new RString("01");
    public static final RString 大字住所コード2 = new RString("02");
    public static final RString 字丁住所コード1 = new RString("01");
    public static final RString 字丁住所コード2 = new RString("02");
    public static final RString 都道府県コード1 = new RString("01");
    public static final RString 都道府県コード2 = new RString("02");
    public static final RString 郡市区コード1 = new RString("01");
    public static final RString 郡市区コード2 = new RString("02");

    @BeforeClass
    public static void setUpClass() {
        sut = new HokenshaNyuryokuHojoFinder();
        urT0507Dac = new UrT0507HokenjaDac();
        urT0101Dac = new UrT0101ZenkokuJushoDac();
    }

    public static class getHokenshaのテスト extends DbaTestDacBase {

        @Before
        public void setUp() {
            urT0507Dac = InstanceProvider.create(UrT0507HokenjaDac.class);
        }

        @Test
        public void 該当する保険者情報が存在しない場合_getHokenshaは_NULLを返すさせる() {
            insert_UrT0507Hokenja(保険者種別2, 保険者番号2);
            HokenjaMapperParameter parameter = HokenjaMapperParameter.createHokenjaNoParam(保険者番号2);
            Hokensha result = sut.getHokensha(parameter);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 該当する保険者情報が存在した場合_getHokenshaは_保険者名を返すさせる() {
            insert_UrT0507Hokenja(保険者種別1, 保険者番号1);
            HokenjaMapperParameter parameter = HokenjaMapperParameter.createHokenjaNoParam(保険者番号1);
            Hokensha result = sut.getHokensha(parameter);
            assertThat(result.get保険者名(), is(new RString("保険者名")));
        }
    }

    public static class getKenCodeJigyoshaInputGuideのテスト extends DbaTestDacBase {

        @Before
        public void setUp() {
            urT0101Dac = InstanceProvider.create(UrT0101ZenkokuJushoDac.class);
        }

        @Test
        public void テーブルにレコードが存在しない場合_県コード取得処理は_NULLを返すこと() {
            insert_UrT0101ZenkokuJusho(データ区分2, 都道府県住所コード1, 市町村住所コード1, 大字住所コード1, 字丁住所コード1);
            List<KenCodeJigyoshaInputGuide> kenCodeList = sut.getKenCodeJigyoshaInputGuide();
            assertThat(kenCodeList.size(), is(0));
        }

        @Test
        public void テーブルにレコードが存在する場合_県コード取得処理は_1件を返すこと() {
            insert_UrT0101ZenkokuJusho(データ区分1, 都道府県住所コード1, 市町村住所コード1, 大字住所コード1, 字丁住所コード1);
            List<KenCodeJigyoshaInputGuide> kenCodeList = sut.getKenCodeJigyoshaInputGuide();
            assertThat(kenCodeList.size(), is(1));
        }

        @Test
        public void テーブルにレコードが存在する場合_県コード取得処理は_2件を返すこと() {
            insert_UrT0101ZenkokuJusho(データ区分1, 都道府県住所コード1, 市町村住所コード1, 大字住所コード1, 字丁住所コード1);
            insert_UrT0101ZenkokuJusho(データ区分1, 都道府県住所コード2, 市町村住所コード2, 大字住所コード2, 字丁住所コード2);
            List<KenCodeJigyoshaInputGuide> kenCodeList = sut.getKenCodeJigyoshaInputGuide();
            assertThat(kenCodeList.size(), is(2));
        }
    }

    public static class getHokenshaListのテスト extends DbaTestDacBase {

        @Before
        public void setUp() {
            urT0507Dac = InstanceProvider.create(UrT0507HokenjaDac.class);
        }

        @Test
        public void テーブルにレコードが存在しない場合_県コード取得処理は_NULLを返すこと() {
            HokenjaMapperParameter parameter = HokenjaMapperParameter.createKenCodeParam(new RString("101"));
            List<Hokensha> hokenjaNoList = sut.getHokenshaList(parameter);
            assertThat(hokenjaNoList.size(), is(0));
        }

        @Test
        public void テーブルにレコードが存在する場合_県コード取得処理は_1件を返すこと() {
            insert_UrT0507Hokenja(保険者種別1, 保険者番号1);
            HokenjaMapperParameter parameter = HokenjaMapperParameter.createKenCodeParam(new RString("101"));
            List<Hokensha> hokenjaNoList = sut.getHokenshaList(parameter);
            assertThat(hokenjaNoList.size(), is(1));
        }

        @Test
        public void テーブルにレコードが存在する場合_県コード取得処理は_2件を返すこと() {
            insert_UrT0507Hokenja(保険者種別2, 保険者番号1);
            insert_UrT0507Hokenja(保険者種別2, 保険者番号2);
            HokenjaMapperParameter parameter = HokenjaMapperParameter.createKenCodeParam(new RString("10"));
            List<Hokensha> hokenjaNoList = sut.getHokenshaList(parameter);
            assertThat(hokenjaNoList.size(), is(2));
        }
    }

    public static void insert_UrT0507Hokenja(HokenjaShubetsu 保険者種別, HokenjaNo 保険者番号) {
        UrT0507HokenjaEntity entity = new UrT0507HokenjaEntity();
        entity.setInsertDantaiCd(new RString("209007"));
        entity.setIsDeleted(false);
        entity.setLastUpdateReamsLoginId(new RString("1"));
        entity.setHokenjaShubetsu(保険者種別);
        entity.setHokenjaNo(保険者番号);
        entity.setHokenjaName(new RString("保険者名"));
        entity.setJusho(new RString("111"));
        entity.setTelNo(new TelNo(new RString("111")));
        urT0507Dac.save(entity);
    }

    public static void insert_UrT0101ZenkokuJusho(ZenkokuJushoDataKubun データ区分,
            RString 都道府県住所コード,
            RString 市町村住所コード,
            RString 大字住所コード,
            RString 字丁住所コード) {
        UrT0101ZenkokuJushoEntity entity = new UrT0101ZenkokuJushoEntity();
        entity.setDataKubun(データ区分);
        entity.setTodofukenJushoCode(都道府県住所コード);
        entity.setShichosonJushoCode(市町村住所コード);
        entity.setOoazaJushoCode(大字住所コード);
        entity.setAzaChoJushoCode(字丁住所コード);
        entity.setIsDeleted(false);
        entity.setLastUpdateReamsLoginId(new RString("1"));
        entity.setSeireiShiteiToshiKubun(new RString("1"));
        entity.setTodofukenKanaKey(new RString("1"));
        entity.setShichosonKanaKey(new RString("1"));
        entity.setShiteiToshiKuKanaKey(new RString("1"));
        entity.setOoazaKanaKey(new RString("1"));
        entity.setAzaChoKanaKey(new RString("1"));
        entity.setTodofukenKanjiKey(new RString("1"));
        entity.setShichosonKanjiKey(new RString("1"));
        entity.setShiteiToshiKuKanjiKey(new RString("1"));
        entity.setOoazaKanjiKey(new RString("1"));
        entity.setAzaChoKanjiKey(new RString("1"));
        entity.setYubinNo(new YubinNo("123"));
        entity.setTodofukenName(new RString("1"));
        entity.setShichosonName(new RString("1"));
        entity.setOoazaName(new RString("1"));
        entity.setAzaChoName(new RString("1"));
        entity.setTodofukenKanaName(new RString("1"));
        entity.setShichosonKanaName(new RString("1"));
        entity.setOoazaKanaName(new RString("1"));
        entity.setAzaChoKanaName(new RString("1"));
        entity.setOoazaSento(new ZenkokuJushoOoazaSento(new RString("1")));
        entity.setAzaSentoKubun(new ZenkokuJushoAzaSento(new RString("2")));
        entity.setShikoYM(new FlexibleYearMonth("201509"));
        entity.setHaishiYM(new FlexibleYearMonth("201509"));
        urT0101Dac.save(entity);
    }

}
