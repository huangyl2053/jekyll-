/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.Gogitai.GogitaiDetail;
import jp.co.ndensan.reams.db.dbe.business.core.Gogitai.GogitaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.core.Gogitai.GogitaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.business.core.Gogitai.GogitaichoKubun;
import jp.co.ndensan.reams.db.dbe.business.core.ShinsainKubun;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.gogitaiyukokikankaishidate.GogitaiYukoKikanKaishiDate;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaiiincode.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.GogitaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.GogitaiWariateShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 合議体割当委員Mapperのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
@Ignore
public class GogitaiWariateIinMapperTest {

    private static GogitaiNo 合議体番号_1 = new GogitaiNo(1);
    private static ShinsakaiIinCode 委員コード_00000001 = new ShinsakaiIinCode(new RString("00000001"));
    private static ShinsakaiIin 委員情報_00000001 = create審査会委員Mock();
    private static GogitaiYukoKikanKaishiDate 開始年月日_19991212 = new GogitaiYukoKikanKaishiDate("19991212");
    private static FlexibleDate 終了年月日_20101212 = new FlexibleDate("20101212");
    private static ShinsainKubun 認定調査員区分_iinCode_iinName
            = new ShinsainKubun(new Code("iinCode"), new RString("iinName"), new RString("ryakusho"));
    private static GogitaichoKubun 合議体長区分_taichoCode_taichoName
            = new GogitaichoKubun(new Code("taichoCode"), new RString("taichoName"), new RString("ryakusho"));

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
            assertThat(sut.get委員情報().get審査会委員コード(), is(委員コード_00000001));
        }

        @Test
        public void 認定調査員区分コードにiinCodeを持つ合議体割当審査会委員Entityが渡されたとき_認定調査員区分コードにiinCodeを持つ合議体割当委員が返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員(create合議体割当審査会委員Entity());
            assertThat(sut.get認定調査員区分().getShinsainKubunCode(), is(認定調査員区分_iinCode_iinName.getShinsainKubunCode()));
        }

        @Test
        public void 合議体長区分にtaichoCodeを持つ合議体割当審査会委員Entityが渡されたとき_合議体長区分にtaichoCodeを持つ合議体割当委員が返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員(create合議体割当審査会委員Entity());
            assertThat(sut.get合議体長区分().getGogitaichoKubunCode(), is(合議体長区分_taichoCode_taichoName.getGogitaichoKubunCode()));
        }

        @Test
        public void 合議体番号に1を持つ合議体割当審査会委員Entityが渡されたとき_合議体番号1を持つ合議体割当委員が返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員(create合議体割当審査会委員Entity());
            assertThat(sut.get合議体情報().get合議体番号(), is(合議体番号_1));
        }

        @Test
        public void 合議体有効期間開始年月日に19991212を持つ合議体割当審査会委員Entityが渡されたとき_合議体有効期間開始年月日に19991212を持つ合議体割当委員が返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員(create合議体割当審査会委員Entity());
            assertThat(sut.get合議体情報().get有効期間開始年月日().value(), is(開始年月日_19991212.value()));
        }
    }

    public static class to合議体割当EntityListのテスト extends DbeTestBase {

        private List<DbT5107GogitaiWariateIinJohoEntity> sut;

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員EntityList(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 要素数3の割当審査会委員Listを持つ_合議体が引数として渡されたとき_要素数3の合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員EntityList(create合議体割当委員List(3));
            assertThat(sut.size(), is(3));
        }
    }

    public static class to合議体割当Entityのテスト extends DbeTestBase {

        private DbT5107GogitaiWariateIinJohoEntity sut;

        @Test
        public void 引数の合議体割当委員にnullを渡したとき_nullが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員Entity(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 合議体番号に1を持つ合議体を渡したとき_合議体番号に1を持つ合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員Entity(createGogitaiWariateIin());
            assertThat(sut.getGogitaiNo(), is(合議体番号_1.value()));
        }

        @Test
        public void 合議体有効開始年月日に19991212を持つ合議体を渡したとき_合議体有効開始年月日に19991212を持つ合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員Entity(createGogitaiWariateIin());
            assertThat(sut.getGogitaiYukoKikanKaishiYMD(), is(開始年月日_19991212.value()));
        }

        @Test
        public void 合議体有効終了年月日に20101212を持つ合議体を渡したとき_合議体有効終了年月日に20101212を持つ合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員Entity(createGogitaiWariateIin());
            assertThat(sut.getGogitaiYukoKikanShuryoYMD(), is(終了年月日_20101212));
        }

        @Test
        public void 委員コードにiin01を持つ合議体割当委員を渡したとき_委員コードにiin01を持つ合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員Entity(createGogitaiWariateIin());
            assertThat(sut.getShinsakaiIinCode(), is(委員情報_00000001.get審査会委員コード().value()));
        }

        @Test
        public void 認定調査員区分コードにiinCodeを持つ合議体割当委員を渡したとき_認定調査員区分コードにiinCodeを持つ合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員Entity(createGogitaiWariateIin());
            assertThat(sut.getShinsainKubunCode(), is(認定調査員区分_iinCode_iinName.getShinsainKubunCode().asCode()));
        }

        @Test
        public void 合議体長区分コードにtaichoCodeを持つ合議体割当委員を渡したとき_合議体長区分コードにtaichoCodeを持つ合議体割当Entityが返る() {
            sut = GogitaiWariateIinMapper.to合議体割当委員Entity(createGogitaiWariateIin());
            assertThat(sut.getGogitaichoKubunCode(), is(合議体長区分_taichoCode_taichoName.getGogitaichoKubunCode().asCode()));
        }
    }

    private static GogitaiWariateIin createGogitaiWariateIin() {
        return new GogitaiWariateIin(委員情報_00000001, 認定調査員区分_iinCode_iinName,
                合議体長区分_taichoCode_taichoName, create合議体());
    }

    private static GogitaiWariateShinsakaiIinEntity create合議体割当審査会委員Entity() {
        GogitaiWariateShinsakaiIinEntity entity = new GogitaiWariateShinsakaiIinEntity();

        DbT5107GogitaiWariateIinJohoEntity 割当Entity = GogitaiMockEntityCreator.create合議体割当EntitySpy(1, "00000001", "19991212", "20101212");
        Code shinsakaiKubunCode = 認定調査員区分_iinCode_iinName.getShinsainKubunCode().asCode();
        when(割当Entity.getShinsainKubunCode()).thenReturn(shinsakaiKubunCode);
        Code gogitaichoKubunCode = 合議体長区分_taichoCode_taichoName.getGogitaichoKubunCode().asCode();
        when(割当Entity.getGogitaichoKubunCode()).thenReturn(gogitaichoKubunCode);
        entity.set割当Entity(割当Entity);

        entity.set委員Entity(ShinsakaiMockEntityCreator.create審査会委員EntitySpy("00000001"));
        entity.set合議体情報Entity(GogitaiMockEntityCreator.create合議体情報Entity(1, "19991212", "20101212", "basho01"));
        entity.set開催場所Entity(GogitaiMockEntityCreator.create開催場所EntitySpy("A001"));
        return entity;
    }

    private static ShinsakaiIin create審査会委員Mock() {
        ShinsakaiIin 委員 = mock(ShinsakaiIin.class);
        when(委員.get審査会委員コード()).thenReturn(委員コード_00000001);
        return 委員;
    }

    private static GogitaiDetail create合議体() {
        return new GogitaiDetail(合議体番号_1, RString.EMPTY, 開始年月日_19991212,
                終了年月日_20101212, mock(Range.class), mock(ShinsakaiKaisaiBasho.class), 3, 4, 5,
                GogitaiSeishinkaIshiSonzaiKubun.存在, GogitaiDummyKubun.ダミー);
    }

    private static GogitaiWariateIinList create合議体割当委員List(int 件数) {
        List<GogitaiWariateIin> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(createGogitaiWariateIin());
        }
        return new GogitaiWariateIinList(list);
    }
}
