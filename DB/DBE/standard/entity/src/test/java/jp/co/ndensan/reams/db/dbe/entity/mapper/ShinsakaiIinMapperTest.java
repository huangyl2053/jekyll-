/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinKoza;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinShikaku;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinShikakuCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsainYusoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIinJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.GogitaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会委員Mapperのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiIinMapperTest {

    private static ShinsakaiIinCode 委員コード_iin01 = new ShinsakaiIinCode(new RString("iin01"));
    private static Range<FlexibleDate> 委員着任期間_19991212_20101212 = new Range(new FlexibleDate("19991212"), new FlexibleDate("20101212"));
    private static ShinsakaiIinJokyo 審査会委員状況_有効 = ShinsakaiIinJokyo.有効;
    private static JigyoshaNo 事業者番号_jigyo01 = new JigyoshaNo(new RString("jogyo01"));
    private static AtenaMeisho 氏名_太郎 = new AtenaMeisho(new RString("太郎"));
    private static AtenaKanaMeisho カナ氏名_タロウ = new AtenaKanaMeisho(new RString("タロウ"));
    private static Gender 性別_MALE = Gender.MALE;
    private static ShinsakaiIinShikaku 審査会委員資格_code_name =
            new ShinsakaiIinShikaku(new Code("code"), new RString("name"), new RString("ryakusho"));
    private static ShinsainYusoKubun 審査委員郵送区分_自宅 = ShinsainYusoKubun.自宅;
    private static YubinNo 郵便番号_1231234 = new YubinNo("1231234");
    private static AtenaJusho 住所_山田市 = new AtenaJusho(new RString("山田市"));
    private static TelNo 電話番号_0981234567 = new TelNo("0981234567");
    private static KinyuKikanCode 金融機関コード_0001 = new KinyuKikanCode(new RString("0001"));
    private static KinyuKikanShitenCode 金融機関支店コード_011 = new KinyuKikanShitenCode(new RString("011"));
    private static RString 口座種別_普通 = new RString("普通");
    private static RString 口座名義人_次郎 = new RString("次郎");
    private static RString 口座名義人カナ_ジロウ = new RString("ジロウ");
    private static RString 口座番号_1237890 = new RString("1237890");

    public static class to審査会委員のテスト extends DbeTestBase {

        private ShinsakaiIin sut;

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            sut = ShinsakaiIinMapper.to審査会委員(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 委員コードにiin01を持つEntityが渡されたとき_委員コードにiin01を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get委員コード(), is(委員コード_iin01));
        }

        @Test
        public void 委員開始年月日に19991212を持つEntityが渡されたとき_委員開始年月日に19991212を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get委員着任期間().getFrom(), is(委員着任期間_19991212_20101212.getFrom()));
        }

        @Test
        public void 委員終了年月日に20101212を持つEntityが渡されたとき_委員終了年月日に20101212を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get委員着任期間().getTo(), is(委員着任期間_19991212_20101212.getTo()));
        }

        @Test
        public void 審査会委員状況に有効を持つEntityが渡されたとき_審査会委員状況に有効を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get審査会委員状況(), is(審査会委員状況_有効));
        }

        @Test
        public void 事業者番号にjigyo01を持つEntityが渡されたとき_事業者番号にjigyo01を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get事業者番号(), is(事業者番号_jigyo01));
        }

        @Test
        public void 氏名に太郎を持つEntityが渡されたとき_氏名に太郎を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get氏名(), is(氏名_太郎));
        }

        @Test
        public void カナ氏名にタロウを持つEntityが渡されたとき_カナ氏名にタロウを持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.getカナ氏名(), is(カナ氏名_タロウ));
        }

        @Test
        public void 性別にMALEを持つEntityが渡されたとき_性別にMALEを持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get性別(), is(性別_MALE));
        }

        @Test
        public void 審査会委員資格にcodeを持つEntityが渡されたとき_審査会委員資格にcodeを持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get審査会委員資格().get区分コード(), is(審査会委員資格_code_name.get区分コード()));
        }

        @Test
        public void 審査委員郵送区分に自宅を持つEntityが渡されたとき_審査委員郵送区分に自宅を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get審査委員郵送区分(), is(審査委員郵送区分_自宅));
        }

        @Test
        public void 郵便番号に1231234を持つEntityが渡されたとき_郵便番号に1231234を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get郵便番号(), is(郵便番号_1231234));
        }

        @Test
        public void 住所に山田市を持つEntityが渡されたとき_住所に山田市を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get住所(), is(住所_山田市));
        }

        @Test
        public void 電話番号に0981234567を持つEntityが渡されたとき_電話番号に0981234567を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get電話番号(), is(電話番号_0981234567));
        }

        @Test
        public void 金融機関コードに01を持つEntityが渡されたとき_金融機関コードに0001を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get口座情報().get金融機関コード(), is(金融機関コード_0001));
        }

        @Test
        public void 金融機関支店コードに011を持つEntityが渡されたとき_金融機関支店コードに011を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get口座情報().get金融機関支店コード(), is(金融機関支店コード_011));
        }

        @Test
        public void 口座種別に普通を持つEntityが渡されたとき_口座種別に普通を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get口座情報().get口座種別(), is(口座種別_普通));
        }

        @Test
        public void 口座名義人に次郎を持つEntityが渡されたとき_口座名義人に次郎を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get口座情報().get口座名義人(), is(口座名義人_次郎));
        }

        @Test
        public void 口座名義人カナにジロウを持つEntityが渡されたとき_口座名義人カナにジロウを持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get口座情報().get口座名義人カナ(), is(口座名義人カナ_ジロウ));
        }

        @Test
        public void 口座番号に1237890を持つEntityが渡されたとき_口座番号に1237890を持つ審査会委員が返る() {
            sut = ShinsakaiIinMapper.to審査会委員(createEntity());
            assertThat(sut.get口座情報().get口座番号(), is(口座番号_1237890));
        }
    }

    public static class to審査会委員Entityのテスト extends DbeTestBase {

        private DbT5102ShinsakaiIinJohoEntity sut;

        @Test
        public void 引数にnullが渡されたとき_nullを返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 委員コードにiin01を持つ審査会委員が渡されたとき_委員コードにiin01を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getShinsakaiIinCode(), is(委員コード_iin01.value()));
        }

        @Test
        public void 委員開始年月日に19991212を持つ審査会委員が渡されたとき_委員開始年月日に19991212を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getShinsakaiIinKaishiYMD(), is(委員着任期間_19991212_20101212.getFrom()));
        }

        @Test
        public void 委員終了年月日に20101212を持つ審査会委員が渡されたとき_委員終了年月日に20101212を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getShinsakaiIinShuryoYMD(), is(委員着任期間_19991212_20101212.getTo()));
        }

        @Test
        public void 審査会委員状況に有効を持つ審査会委員が渡されたとき_審査会委員状況に有効を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getShinsakaiIinJokyo(), is(審査会委員状況_有効.is有効()));
        }

        @Test
        public void 事業者番号にjigyo01を持つ審査会委員が渡されたとき_事業者番号にjigyo01を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getJigyoshaNo(), is(事業者番号_jigyo01));
        }

        @Test
        public void 氏名に太郎を持つ審査会委員が渡されたとき_氏名に太郎を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getShinsakaiIinShimei(), is(氏名_太郎));
        }

        @Test
        public void カナ氏名にタロウを持つ審査会委員が渡されたとき_カナ氏名にタロウを持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getShinsakaiIinKanaShimei(), is(カナ氏名_タロウ));
        }

        @Test
        public void 性別にMALEを持つ審査会委員が渡されたとき_性別にMALEを持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getSeibetsu(), is(性別_MALE.getCommonName()));
        }

        @Test
        public void 審査会委員資格コードにcodeを持つ審査会委員が渡されたとき_審査会委員資格コードにcodeを持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getShinsakaiIinShikakuCode(), is(審査会委員資格_code_name.getCode()));
        }

        @Test
        public void 審査委員郵送区分に自宅を持つ審査会委員が渡されたとき_審査委員郵送区分に自宅を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getShinsainYusoKubun(), is(審査委員郵送区分_自宅.get郵送区分()));
        }

        @Test
        public void 郵便番号に1231234を持つ審査会委員が渡されたとき_郵便番号に1231234を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getYubinNo(), is(郵便番号_1231234));
        }

        @Test
        public void 住所に山田市を持つ審査会委員が渡されたとき_住所に山田市を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getJusho(), is(住所_山田市));
        }

        @Test
        public void 電話番号に0981234567を持つ審査会委員が渡されたとき_電話番号に0981234567を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getTelNo(), is(電話番号_0981234567));
        }

        @Test
        public void 金融機関コードに01を持つ審査会委員が渡されたとき_金融機関コードに0001を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getKinyuKikanCode(), is(金融機関コード_0001));
        }

        @Test
        public void 金融機関支店コードに011を持つ審査会委員が渡されたとき_金融機関支店コードに011を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getKinyuKikanShitenCode(), is(金融機関支店コード_011));
        }

        @Test
        public void 口座種別に普通を持つ審査会委員が渡されたとき_口座種別に普通を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getKozaShubetsu(), is(口座種別_普通));
        }

        @Test
        public void 口座名義人に次郎を持つ審査会委員が渡されたとき_口座名義人に次郎を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getKozaMeigi(), is(口座名義人_次郎));
        }

        @Test
        public void 口座名義人カナにジロウを持つ審査会委員が渡されたとき_口座名義人カナにジロウを持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getKozaMeigiKana(), is(口座名義人カナ_ジロウ));
        }

        @Test
        public void 口座番号に1237890を持つ審査会委員が渡されたとき_口座番号に1237890を持つEntityが返す() {
            sut = ShinsakaiIinMapper.to審査会委員Entity(createShinsakaiIin());
            assertThat(sut.getKozaNo(), is(口座番号_1237890));
        }
    }

    private static ShinsakaiIin createShinsakaiIin() {
        ShinsakaiIinKoza kozaJoho = new ShinsakaiIinKoza(金融機関コード_0001,
                金融機関支店コード_011, 口座種別_普通, 口座名義人_次郎, 口座名義人カナ_ジロウ, 口座番号_1237890);

        return new ShinsakaiIin(委員コード_iin01, 委員着任期間_19991212_20101212, 審査会委員状況_有効,
                事業者番号_jigyo01, 氏名_太郎, カナ氏名_タロウ, 性別_MALE, 審査会委員資格_code_name,
                審査委員郵送区分_自宅, 郵便番号_1231234, 住所_山田市, 電話番号_0981234567, kozaJoho);
    }

    private static DbT5102ShinsakaiIinJohoEntity createEntity() {
        DbT5102ShinsakaiIinJohoEntity 委員Entity = GogitaiMockEntityCreator.create審査会委員EntitySpy(委員コード_iin01.value().toString(),
                委員着任期間_19991212_20101212.getFrom().toString());
        委員Entity.setShinsakaiIinCode(委員コード_iin01.value());
        委員Entity.setShinsakaiIinKaishiYMD(委員着任期間_19991212_20101212.getFrom());
        委員Entity.setShinsakaiIinShuryoYMD(委員着任期間_19991212_20101212.getTo());
        委員Entity.setShinsakaiIinJokyo(審査会委員状況_有効.is有効());
        委員Entity.setJigyoshaNo(事業者番号_jigyo01);
        委員Entity.setShinsakaiIinShimei(氏名_太郎);
        委員Entity.setShinsakaiIinKanaShimei(カナ氏名_タロウ);
        委員Entity.setSeibetsu(性別_MALE.getCode());
        委員Entity.setShinsakaiIinShikakuCode(審査会委員資格_code_name.getCode());
        委員Entity.setShinsainYusoKubun(審査委員郵送区分_自宅.get郵送区分());
        委員Entity.setYubinNo(郵便番号_1231234);
        委員Entity.setJusho(住所_山田市);
        委員Entity.setTelNo(電話番号_0981234567);
        委員Entity.setKinyuKikanCode(金融機関コード_0001);
        委員Entity.setKinyuKikanShitenCode(金融機関支店コード_011);
        委員Entity.setKozaShubetsu(口座種別_普通);
        委員Entity.setKozaMeigi(口座名義人_次郎);
        委員Entity.setKozaMeigiKana(口座名義人カナ_ジロウ);
        委員Entity.setKozaNo(口座番号_1237890);
        return 委員Entity;
    }
}
