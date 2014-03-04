/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Gogitai;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.business.GogitaichoKubun;
import jp.co.ndensan.reams.db.dbe.business.ShinsainKubun;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsainYusoKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.GogitaiWariateShinsakaiIinEntity;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiWariateIinMapperTest {

    private static GogitaiNo 合議体番号_1 = new GogitaiNo(1);
    private static ShinsakaiIinCode 委員コード_iin01 = new ShinsakaiIinCode(new RString("iin01"));
    private static ShinsakaiIin 委員情報_iin01 = create審査会委員Mock();
    private static Range<FlexibleDate> 有効期間_19991212_20101212 = new Range(new FlexibleDate("19991212"), new FlexibleDate("20101212"));
    private static ShinsainKubun 認定調査員区分_iinCode_iinName = new ShinsainKubun(new RString("iinCode"), new RString("iinName"));
    private static GogitaichoKubun 合議体長区分_taichoCode_taichoName = new GogitaichoKubun(new RString("taichoCode"), new RString("taichoName"));

    public static class to合議体割当委員Listのテスト extends DbeTestBase {

        private GogitaiWariateIinList sut;

        @Test
        public void 引数にnullを渡したとき_nullが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員List(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 要素数が3の合議体割当委員EntityListを渡したとき_要素数が3の合議体割当委員Listが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員List(create合議体割当委員EntityList(3));
            assertThat(sut.size(), is(3));
        }

        private List<GogitaiWariateShinsakaiIinEntity> create合議体割当委員EntityList(int 件数) {
            List<GogitaiWariateShinsakaiIinEntity> 合議体割当委員EntityList = new ArrayList<>();
            for (int i = 0; i < 件数; i++) {
                合議体割当委員EntityList.add(create合議体割当審査会委員Entity());
            }
            return 合議体割当委員EntityList;
        }
    }

    public static class to合議体割当委員のテスト extends DbeTestBase {

        private GogitaiWariateIin sut;

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 認定審査員コードにiin01を持つ合議体割当審査会委員Entityが渡されたとき_認定審査員コードにiin01を持つ合議体割当委員が返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員(create合議体割当審査会委員Entity());
            assertThat(sut.get委員情報().get委員コード(), is(委員コード_iin01));
        }

        @Test
        public void 認定調査員区分コードにiinCodeを持つ合議体割当審査会委員Entityが渡されたとき_認定調査員区分コードにiinCodeを持つ合議体割当委員が返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員(create合議体割当審査会委員Entity());
            assertThat(sut.get認定調査員区分().getCode(), is(認定調査員区分_iinCode_iinName.getCode()));
        }

        @Test
        public void 合議体長区分にtaichoCodeを持つ合議体割当審査会委員Entityが渡されたとき_合議体長区分にtaichoCodeを持つ合議体割当委員が返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員(create合議体割当審査会委員Entity());
            assertThat(sut.get合議体長区分().getCode(), is(合議体長区分_taichoCode_taichoName.getCode()));
        }
    }

    public static class to合議体割当EntityListのテスト extends DbeTestBase {

        private List<DbT5107GogitaiWariateIinJohoEntity> sut;

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当EntityList(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 要素数3の割当審査会委員Listを持つ_合議体が引数として渡されたとき_要素数3の合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当EntityList(create合議体Mock());
            assertThat(sut.size(), is(3));
        }
    }

    public static class to合議体割当Entityのテスト extends DbeTestBase {

        private DbT5107GogitaiWariateIinJohoEntity sut;

        @Test
        public void 引数の合議体にnullを渡したとき_nullが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当Entity(null, createGogitaiWariateIin());
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 引数の合議体割当委員にnullを渡したとき_nullが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当Entity(create合議体Mock(), null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 合議体番号に1を持つ合議体を渡したとき_合議体番号に1を持つ合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当Entity(create合議体Mock(), createGogitaiWariateIin());
            assertThat(sut.getGogitaiNo(), is(合議体番号_1.value()));
        }

        @Test
        public void 合議体有効開始年月日に19991212を持つ合議体を渡したとき_合議体有効開始年月日に19991212を持つ合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当Entity(create合議体Mock(), createGogitaiWariateIin());
            assertThat(sut.getGogitaiYukoKikanKaishiYMD(), is(有効期間_19991212_20101212.getFrom()));
        }

        @Test
        public void 合議体有効終了年月日に20101212を持つ合議体を渡したとき_合議体有効終了年月日に20101212を持つ合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当Entity(create合議体Mock(), createGogitaiWariateIin());
            assertThat(sut.getGogitaiYukoKikanShuryoYMD(), is(有効期間_19991212_20101212.getTo()));
        }

        @Test
        public void 委員コードにiin01を持つ合議体割当委員を渡したとき_委員コードにiin01を持つ合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当Entity(create合議体Mock(), createGogitaiWariateIin());
            assertThat(sut.getShinsakaiIinCode(), is(委員情報_iin01.get委員コード().value()));
        }

        @Test
        public void 認定調査員区分コードにiinCodeを持つ合議体割当委員を渡したとき_認定調査員区分コードにiinCodeを持つ合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当Entity(create合議体Mock(), createGogitaiWariateIin());
            assertThat(sut.getShinsainKubunCode(), is(new Code(認定調査員区分_iinCode_iinName.getCode())));
        }

        @Test
        public void 合議体長区分コードにtaichoCodeを持つ合議体割当委員を渡したとき_合議体長区分コードにtaichoCodeを持つ合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当Entity(create合議体Mock(), createGogitaiWariateIin());
            assertThat(sut.getGogitaichoKubunCode(), is(new Code(合議体長区分_taichoCode_taichoName.getCode())));
        }
    }

    private static GogitaiWariateIin createGogitaiWariateIin() {
        return new GogitaiWariateIin(委員情報_iin01, 認定調査員区分_iinCode_iinName, 合議体長区分_taichoCode_taichoName);
    }

    private static DbT5107GogitaiWariateIinJohoEntity create合議体割当Entity() {
        DbT5107GogitaiWariateIinJohoEntity entity = new DbT5107GogitaiWariateIinJohoEntity();
        entity.setGogitaiNo(合議体番号_1.value());
        entity.setShinsakaiIinCode(委員情報_iin01.get委員コード().value());
        entity.setGogitaiYukoKikanKaishiYMD(有効期間_19991212_20101212.getFrom());
        entity.setGogitaiYukoKikanShuryoYMD(有効期間_19991212_20101212.getTo());
        entity.setGogitaichoKubunCode(new Code(合議体長区分_taichoCode_taichoName.getCode()));
        entity.setShinsainKubunCode(new Code(認定調査員区分_iinCode_iinName.getCode()));
        return entity;
    }

    private static GogitaiWariateShinsakaiIinEntity create合議体割当審査会委員Entity() {
        GogitaiWariateShinsakaiIinEntity entity = new GogitaiWariateShinsakaiIinEntity();
        entity.set割当Entity(create合議体割当Entity());
        entity.set委員Entity(create審査会委員Entity());
        return entity;
    }

    private static ShinsakaiIin create審査会委員Mock() {
        ShinsakaiIin 委員 = mock(ShinsakaiIin.class);
        when(委員.get委員コード()).thenReturn(委員コード_iin01);
        return 委員;
    }

    private static DbT5102ShinsakaiIinJohoEntity create審査会委員Entity() {
        DbT5102ShinsakaiIinJohoEntity 委員Entity = new DbT5102ShinsakaiIinJohoEntity();
        委員Entity.setShinsakaiIinCode(委員コード_iin01.value());
        委員Entity.setShinsakaiIinKaishiYMD(FlexibleDate.MIN);
        委員Entity.setShinsakaiIinShuryoYMD(FlexibleDate.MAX);
        委員Entity.setShinsakaiIinJokyo(Boolean.TRUE);
        委員Entity.setJigyoushaNo(new JigyoshaNo(RString.EMPTY));
        委員Entity.setShinsakaiIinShimei(new AtenaMeisho(RString.EMPTY));
        委員Entity.setShinsakaiIinKanaShimei(new AtenaKanaMeisho(RString.EMPTY));
        委員Entity.setSeibetsu(Gender.FEMALE.getCode());
        委員Entity.setShinsakaiIinShikakuCode(new Code(RString.EMPTY));
        委員Entity.setShinsainYusoKubun(ShinsainYusoKubun.自宅.get郵送区分());
        委員Entity.setYubinNo(new YubinNo(new RString("123-1234")));
        委員Entity.setJusho(new AtenaJusho(RString.EMPTY));
        委員Entity.setTelNo(new TelNo(RString.EMPTY));
        委員Entity.setKinyuKikanCode(new KinyuKikanCode(RString.HALF_SPACE));
        委員Entity.setKinyuKikanShitenCode(new KinyuKikanShitenCode(RString.HALF_SPACE));
        委員Entity.setKozaShubetsu(RString.EMPTY);
        委員Entity.setKozaMeigi(RString.EMPTY);
        委員Entity.setKozaMeigiKana(RString.EMPTY);
        委員Entity.setKozaNo(RString.EMPTY);
        return 委員Entity;
    }

    private static Gogitai create合議体Mock() {
        Gogitai 合議体 = mock(Gogitai.class);
        when(合議体.get合議体番号()).thenReturn(合議体番号_1);
        when(合議体.get有効期間()).thenReturn(有効期間_19991212_20101212);
        when(合議体.get合議体割当審査会委員List()).thenReturn(create合議体割当委員List(3));
        return 合議体;
    }

    private static GogitaiWariateIinList create合議体割当委員List(int 件数) {
        List<GogitaiWariateIin> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(createGogitaiWariateIin());
        }
        return new GogitaiWariateIinList(list);
    }
}
