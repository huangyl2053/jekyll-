/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Gogitai;
import jp.co.ndensan.reams.db.dbe.business.GogitaiList;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyFlag;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiFlag;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiMeisho;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
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
 * 合議体Mapperのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiMapperTest {

    private static GogitaiNo 合議体番号_1 = new GogitaiNo(1);
    private static GogitaiMeisho 合議体名称_合議体1 = new GogitaiMeisho(new RString("合議体1"));
    private static Range<FlexibleDate> 有効期間_19991212_20101212 = new Range(new FlexibleDate("19991212"), new FlexibleDate("20101212"));
    private static Range<RString> 開始終了予定時刻_0830_1720 = new Range(new RString("0830"), new RString("1720"));
    private static ShinsakaiKaisaiBasho 審査会開催場所_山田家001 = create審査会開催場所Mock("山田家001");
    private static int 審査会予定定員_5 = 5;
    private static int 審査会自動割当定員_6 = 6;
    private static int 審査会委員定員_7 = 7;
    private static GogitaiWariateIinList 合議体割当審査会委員List_3件 = create合議体割当委員ListMock(3);
    private static GogitaiSeishinkaIshiSonzaiFlag 精神科医師存在_存在 = GogitaiSeishinkaIshiSonzaiFlag.存在;
    private static GogitaiDummyFlag 合議体ダミー_notダミー = GogitaiDummyFlag.NO;

    public static class to合議体のテスト extends DbeTestBase {

        @Test
        public void 引数の合議体Entityにnullが渡されたとき_戻り値はnullになる() {
            Gogitai sut = GogitaiMapper.to合議体(null, 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 引数の審査会開催場所にnullが渡されたとき_戻り値はnullになる() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), null, 合議体割当審査会委員List_3件);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 引数の合議体割当審査会委員Listにnullが渡されたとき_戻り値はnullになる() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 合議体番号に1を持つEntityを引数に指定した場合_合議体番号に1を持つ合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get合議体番号(), is(合議体番号_1));
        }

        @Test
        public void 合議体名称として合議体1を持つEntityを引数に指定した場合_合議体名称に合議体1を持つ合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get合議体名称(), is(合議体名称_合議体1));
        }

        @Test
        public void 有効期間開始年月日として19991212を持つEntityを引数に指定した場合_有効期間開始年月日に19991212を持つ合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get有効期間().getFrom(), is(有効期間_19991212_20101212.getFrom()));
        }

        @Test
        public void 有効期間終了年月日として20101212を持つEntityを引数に指定した場合_有効期間終了年月日に20101212を持つ合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get有効期間().getTo(), is(有効期間_19991212_20101212.getTo()));
        }

        @Test
        public void 開始予定時刻として0830を持つEntityを引数に指定した場合_開始予定時刻に0830を持つ合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get開始終了予定時刻().getFrom(), is(開始終了予定時刻_0830_1720.getFrom()));
        }

        @Test
        public void 終了予定時刻として1720を持つEntityを引数に指定した場合_終了予定時刻に1720を持つ合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get開始終了予定時刻().getTo(), is(開始終了予定時刻_0830_1720.getTo()));
        }

        @Test
        public void 審査会開催場所コードに山田家001を持つ審査会開催場所クラスを引数に指定した場合_審査会開催場所コードに山田家001を持つ合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get審査会開催場所().get開催場所コード(), is(審査会開催場所_山田家001.get開催場所コード()));
        }

        @Test
        public void 審査会予定定員に5を持つEntityを引数に指定した場合_審査会予定定員に5を持つ合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get審査会予定定員(), is(審査会予定定員_5));
        }

        @Test
        public void 審査会自動割当定員に6を持つEntityを引数に指定した場合_審査会自動割当定員に6を持つ合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get審査会自動割当定員(), is(審査会自動割当定員_6));
        }

        @Test
        public void 審査会委員定員に7を持つEntityを引数に指定した場合_審査会委員定員に7を持つ合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get審査会委員定員(), is(審査会委員定員_7));
        }

        @Test
        public void 引数に指定した合議体割当審査会委員Listと_同一のリストを持つ合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get合議体割当審査会委員List(), is(合議体割当審査会委員List_3件));
        }

        @Test
        public void 精神科医師が存在するEntityを引数に指定した場合_精神科医師が存在する合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get精神科医師存在(), is(精神科医師存在_存在));
        }

        @Test
        public void 合議体がダミーで無いことを示すEntityを引数に指定した場合_ダミーではない合議体が返る() {
            Gogitai sut = GogitaiMapper.to合議体(createEntity(), 審査会開催場所_山田家001, 合議体割当審査会委員List_3件);
            assertThat(sut.get合議体ダミー(), is(合議体ダミー_notダミー));
        }
    }

    public static class to合議体Listのテスト extends DbeTestBase {

        private GogitaiList sut;

        @Test
        public void 引数の合議体Entitiesにnullが渡されたとき_戻り値はnullになる() {
            sut = GogitaiMapper.to合議体List(null, create審査会開催場所ListMock(3), create合議体割当委員ListsMock(3));
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 引数の審査会開催場所Listにnullが渡されたとき_戻り値はnullになる() {
            sut = GogitaiMapper.to合議体List(createEntities(3), null, create合議体割当委員ListsMock(3));
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 引数の合議体割当委員Listsにnullが渡されたとき_戻り値はnullになる() {
            sut = GogitaiMapper.to合議体List(createEntities(3), create審査会開催場所ListMock(3), null);
            assertThat(sut, is(nullValue()));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に渡されたリストのサイズが違う場合_例外が発生する() {
            sut = GogitaiMapper.to合議体List(createEntities(4), create審査会開催場所ListMock(2), create合議体割当委員ListsMock(3));
        }

        @Test
        public void 引数の合議体Entitiesに3件のEntityを持つリストが渡されたとき_3件の合議体を持つリストが返る() {
            sut = GogitaiMapper.to合議体List(createEntities(3), create審査会開催場所ListMock(3), create合議体割当委員ListsMock(3));
            assertThat(sut.size(), is(3));

        }
    }

    public static class to合議体Entityのテスト extends DbeTestBase {

        private DbT5103GogitaiJohoEntity sut;

        @Test
        public void 引数にnullを渡したとき_nullが返る() {
            sut = GogitaiMapper.to合議体Entity(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void 合議体番号に1を持つ合議体を引数に指定した場合_合議体番号に1を持つ合議体Entityが返る() {
            sut = GogitaiMapper.to合議体Entity(createGogitai());
            assertThat(sut.getGogitaiNo(), is(合議体番号_1.value()));
        }

        @Test
        public void 合議体名称に合議体1を持つ合議体を引数に指定した場合_合議体名称に合議体1を持つ合議体Entityが返る() {
            sut = GogitaiMapper.to合議体Entity(createGogitai());
            assertThat(sut.getGogitaiMei(), is(合議体名称_合議体1.value()));
        }

        @Test
        public void 有効期間開始年月日に19991212を持つ合議体を引数に指定した場合_有効期間開始年月日に19991212を持つ合議体Entityが返る() {
            sut = GogitaiMapper.to合議体Entity(createGogitai());
            assertThat(sut.getGogitaiYukoKikanKaishiYMD(), is(有効期間_19991212_20101212.getFrom()));
        }

        @Test
        public void 有効期間終了年月日に20101212を持つ合議体を引数に指定した場合_有効期間終了年月日に20101212を持つ合議体Entityが返る() {
            sut = GogitaiMapper.to合議体Entity(createGogitai());
            assertThat(sut.getGogitaiYukoKikanShuryoYMD(), is(有効期間_19991212_20101212.getTo()));
        }

        @Test
        public void 開始予定時刻に0830を持つ合議体を引数に指定した場合_開始予定時刻に0830を持つ合議体Entityが返る() {
            sut = GogitaiMapper.to合議体Entity(createGogitai());
            assertThat(sut.getGogitaiKaishiYoteiTime(), is(開始終了予定時刻_0830_1720.getFrom()));
        }

        @Test
        public void 終了予定時刻に1720を持つ合議体を引数に指定した場合_終了予定時刻に1720を持つ合議体Entityが返る() {
            sut = GogitaiMapper.to合議体Entity(createGogitai());
            assertThat(sut.getGogitaiShuryoYoteiTime(), is(開始終了予定時刻_0830_1720.getTo()));
        }

        @Test
        public void 審査会開催場所コードに山田家001を持つ合議体を引数に指定した場合_審査会開催場所コードに山田家001を持つ合議体Entityが返る() {
            sut = GogitaiMapper.to合議体Entity(createGogitai());
            assertThat(sut.getShinsakaiKaisaiBashoCode(), is(審査会開催場所_山田家001.get開催場所コード().value()));
        }

        @Test
        public void 審査会予定定員に5を持つ合議体を引数に指定した場合_審査会予定定員に5を持つ合議体Entityが返る() {
            sut = GogitaiMapper.to合議体Entity(createGogitai());
            assertThat(sut.getShinsakaiYoteiTeiin(), is(審査会予定定員_5));
        }

        @Test
        public void 審査会自動割当定員に6を持つ合議体を引数に指定した場合_審査会自動割当定員に6を持つ合議体Entityが返る() {
            sut = GogitaiMapper.to合議体Entity(createGogitai());
            assertThat(sut.getShinsakaiJidoWariateTeiin(), is(審査会自動割当定員_6));
        }

        @Test
        public void 審査会委員定員に7を持つ合議体を引数に指定した場合_審査会委員定員に7を持つ合議体Entityが返る() {
            sut = GogitaiMapper.to合議体Entity(createGogitai());
            assertThat(sut.getShinsakaiIinTeiin(), is(審査会委員定員_7));
        }

        @Test
        public void 精神科医師が存在する合議体を引数に指定した場合_精神科医師が存在することを示す合議体Entityが返る() {
            sut = GogitaiMapper.to合議体Entity(createGogitai());
            assertThat(sut.getGogitaiSeishinkaSonzaiFlag(), is(精神科医師存在_存在.is存在()));
        }

        @Test
        public void ダミーではない合議体を引数に指定した場合_合議体がダミーではないことを示す合議体Entityが返る() {
            sut = GogitaiMapper.to合議体Entity(createGogitai());
            assertThat(sut.getGogitaiDummyFlag(), is(合議体ダミー_notダミー.isDummy()));
        }
    }

    private static DbT5103GogitaiJohoEntity createEntity() {
        DbT5103GogitaiJohoEntity entity = new DbT5103GogitaiJohoEntity();
        entity.setGogitaiNo(合議体番号_1.value());
        entity.setGogitaiMei(合議体名称_合議体1.value());
        entity.setGogitaiYukoKikanKaishiYMD(有効期間_19991212_20101212.getFrom());
        entity.setGogitaiYukoKikanShuryoYMD(有効期間_19991212_20101212.getTo());
        entity.setGogitaiKaishiYoteiTime(開始終了予定時刻_0830_1720.getFrom());
        entity.setGogitaiShuryoYoteiTime(開始終了予定時刻_0830_1720.getTo());
        entity.setShinsakaiKaisaiBashoCode(審査会開催場所_山田家001.get開催場所コード().value());
        entity.setShinsakaiYoteiTeiin(審査会予定定員_5);
        entity.setShinsakaiJidoWariateTeiin(審査会自動割当定員_6);
        entity.setShinsakaiIinTeiin(審査会委員定員_7);
        entity.setGogitaiSeishinkaSonzaiFlag(精神科医師存在_存在.is存在());
        entity.setGogitaiDummyFlag(合議体ダミー_notダミー.isDummy());
        return entity;
    }

    private static Gogitai createGogitai() {
        return new Gogitai(合議体番号_1, 合議体名称_合議体1, 有効期間_19991212_20101212, 開始終了予定時刻_0830_1720,
                審査会開催場所_山田家001, 審査会予定定員_5, 審査会自動割当定員_6, 審査会委員定員_7,
                合議体割当審査会委員List_3件, 精神科医師存在_存在, 合議体ダミー_notダミー);
    }

    private static List<DbT5103GogitaiJohoEntity> createEntities(int 件数) {
        List<DbT5103GogitaiJohoEntity> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(createEntity());
        }
        return list;
    }

    private static ShinsakaiKaisaiBasho create審査会開催場所Mock(String str) {
        ShinsakaiKaisaiBasho 審査会開催場所mock = mock(ShinsakaiKaisaiBasho.class);
        when(審査会開催場所mock.get開催場所コード()).thenReturn(new ShinsakaiKaisaiBashoCode(new RString(str)));
        return 審査会開催場所mock;
    }

    private static List<ShinsakaiKaisaiBasho> create審査会開催場所ListMock(int 件数) {
        List<ShinsakaiKaisaiBasho> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(create審査会開催場所Mock("test" + i));
        }
        return list;
    }

    private static GogitaiWariateIinList create合議体割当委員ListMock(int 件数) {
        List<GogitaiWariateIin> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(mock(GogitaiWariateIin.class));
        }
        return new GogitaiWariateIinList(list);
    }

    private static List<GogitaiWariateIinList> create合議体割当委員ListsMock(int 件数) {
        List<GogitaiWariateIinList> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(create合議体割当委員ListMock(i));
        }
        return list;
    }
}
