/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.GogitaiDetail;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.GogitaichoKubun;
import jp.co.ndensan.reams.db.dbe.business.ShinsainKubun;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiDate;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.GogitaiWariateShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.GogitaiWariateDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.GogitaiWariateShinsakaiIinDac;
import jp.co.ndensan.reams.db.dbe.entity.helper.GogitaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
import static org.mockito.Mockito.any;

/**
 * 合議体割当委員管理クラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiWariateIinManagerTest {

    private static GogitaiWariateIinManager sut;

    public static class get合議体割当委員ListAllのテスト extends DbeTestBase {

        @Test
        public void Dacから5件のリストを取得できるとき_size5の合議体割当委員リストが取得できる() {
            sut = new GogitaiWariateIinManager(create合議体割当委員DacMock(5), null);
            assertThat(sut.get合議体割当委員ListAll().size(), is(5));
        }

        private GogitaiWariateShinsakaiIinDac create合議体割当委員DacMock(int 件数) {
            GogitaiWariateShinsakaiIinDac dac = mock(GogitaiWariateShinsakaiIinDac.class);
            List<GogitaiWariateShinsakaiIinEntity> 合議体割当委員EntityList = create合議体割当委員EntityList(件数);
            when(dac.select()).thenReturn(合議体割当委員EntityList);
            return dac;
        }
    }

    public static class get有効割当委員Listのテスト extends DbeTestBase {

        @Test
        public void Dacから3件のリストを取得できるとき_size3の合議体割当委員リストが取得できる() {
            sut = new GogitaiWariateIinManager(create合議体割当委員DacMock(3), null);
            assertThat(sut.get有効割当委員List(new GogitaiYukoKikanKaishiDate("19990101")).size(), is(3));
        }

        private GogitaiWariateShinsakaiIinDac create合議体割当委員DacMock(int 件数) {
            GogitaiWariateShinsakaiIinDac dac = mock(GogitaiWariateShinsakaiIinDac.class);
            List<GogitaiWariateShinsakaiIinEntity> 合議体割当委員EntityList = create合議体割当委員EntityList(件数);
            when(dac.select(any(GogitaiYukoKikanKaishiDate.class))).thenReturn(合議体割当委員EntityList);
            return dac;
        }
    }

    public static class get合議体割当委員Listのテスト extends DbeTestBase {

        @Test
        public void Dacから3件のリストを取得できるとき_size3の合議体割当委員リストが取得できる() {
            sut = new GogitaiWariateIinManager(create合議体割当委員DacMock(2), null);
            assertThat(sut.get合議体割当委員List(new GogitaiNo(1), new GogitaiYukoKikanKaishiDate("19990101")).size(), is(2));
        }

        private GogitaiWariateShinsakaiIinDac create合議体割当委員DacMock(int 件数) {
            GogitaiWariateShinsakaiIinDac dac = mock(GogitaiWariateShinsakaiIinDac.class);
            List<GogitaiWariateShinsakaiIinEntity> 合議体割当委員EntityList = create合議体割当委員EntityList(件数);
            when(dac.select(any(GogitaiNo.class), any(GogitaiYukoKikanKaishiDate.class))).thenReturn(合議体割当委員EntityList);
            return dac;
        }
    }

    public static class saveのテスト extends DbeTestBase {

        @Test
        public void 削除結果が1件だった場合_trueが返る() {
            sut = new GogitaiWariateIinManager(null, create割当DacMock(1));
            assertThat(sut.save(create合議体割当委員(1, "19990101", "iin01")), is(true));
        }

        @Test
        public void 削除結果が0件だった場合_falseが返る() {
            sut = new GogitaiWariateIinManager(null, create割当DacMock(0));
            assertThat(sut.save(create合議体割当委員(1, "19990101", "iin01")), is(false));
        }

        private GogitaiWariateDac create割当DacMock(int 更新件数) {
            GogitaiWariateDac dac = mock(GogitaiWariateDac.class);
            when(dac.insertOrUpdate(any(DbT5107GogitaiWariateIinJohoEntity.class))).thenReturn(更新件数);
            return dac;
        }
    }

    public static class removeのテスト extends DbeTestBase {

        @Test
        public void 削除結果が1件だった場合_trueが返る() {
            sut = new GogitaiWariateIinManager(null, create割当DacMock(1));
            assertThat(sut.remove(create合議体割当委員(1, "19990101", "iin01")), is(true));
        }

        @Test
        public void 削除結果が0件だった場合_falseが返る() {
            sut = new GogitaiWariateIinManager(null, create割当DacMock(0));
            assertThat(sut.remove(create合議体割当委員(1, "19990101", "iin01")), is(false));
        }

        private GogitaiWariateDac create割当DacMock(int 削除件数) {
            GogitaiWariateDac dac = mock(GogitaiWariateDac.class);
            when(dac.delete(any(DbT5107GogitaiWariateIinJohoEntity.class))).thenReturn(削除件数);
            return dac;
        }
    }

    private static GogitaiWariateIin create合議体割当委員(int 合議体番号, String 合議体有効期間開始年月日, String 委員コード) {
        return new GogitaiWariateIin(create審査会委員(委員コード),
                new ShinsainKubun(new Code("001"), new RString("審査員"), new RString("審査員")),
                new GogitaichoKubun(new Code("001"), new RString("体長"), new RString("体長")),
                create合議体情報(1, 合議体有効期間開始年月日));
    }

    private static GogitaiDetail create合議体情報(int 合議体番号, String 開始年月日) {
        return new GogitaiDetail(new GogitaiNo(合議体番号), RString.EMPTY, new GogitaiYukoKikanKaishiDate(開始年月日),
                new FlexibleDate("20011231"), mock(Range.class), mock(ShinsakaiKaisaiBasho.class), 3, 4, 5,
                GogitaiSeishinkaIshiSonzaiKubun.存在, GogitaiDummyKubun.ダミー);
    }

    private static ShinsakaiIin create審査会委員(String 委員コード) {
        ShinsakaiIin iin = mock(ShinsakaiIin.class);
        ShinsakaiIinCode shinsakaiIinCode = new ShinsakaiIinCode(new RString(委員コード));
        when(iin.get委員コード()).thenReturn(shinsakaiIinCode);
        return iin;
    }

    private static List<GogitaiWariateShinsakaiIinEntity> create合議体割当委員EntityList(int 件数) {
        List<GogitaiWariateShinsakaiIinEntity> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(create合議体割当委員Entity());
        }
        return list;
    }

    private static GogitaiWariateShinsakaiIinEntity create合議体割当委員Entity() {
        GogitaiWariateShinsakaiIinEntity entity = new GogitaiWariateShinsakaiIinEntity();
        entity.set割当Entity(GogitaiMockEntityCreator.create合議体割当EntitySpy(1, "iin01", "19990101", "19991231"));
        entity.set合議体情報Entity(GogitaiMockEntityCreator.create合議体情報EntitySpy(1, "19990101", "19991231", "basho1"));
        entity.set委員Entity(GogitaiMockEntityCreator.create審査会委員EntitySpy("iin01", "19800101"));
        entity.set開催場所Entity(GogitaiMockEntityCreator.create開催場所EntitySpy("basho1"));
        return entity;
    }
}
