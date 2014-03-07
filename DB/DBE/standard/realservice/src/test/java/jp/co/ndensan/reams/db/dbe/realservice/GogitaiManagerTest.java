/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Gogitai;
import jp.co.ndensan.reams.db.dbe.business.GogitaiList;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaichoKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsainKubun;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKaisaiBashoJokyo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IGogitaiDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IGogitaiAndGogitaiWariateIinDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IGogitaiWariateShinsakaiIinDac;
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
import static org.mockito.Mockito.any;

/**
 * 合議体マネージャのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiManagerTest {

    private static GogitaiManager sut;

    public static class get合議体履歴Listのテスト extends DbeTestBase {

        @Test
        public void Dacから3件の合議体エンティティを取得できたとき_3件の要素を持つ合議体Listが返る() {
            sut = new GogitaiManager(createGogitaiDacMock(3), createGogitaiWariateIinDacMock(), null, createKaisaiBashoManagerMock());
            GogitaiList result = sut.get合議体履歴List(new GogitaiNo(1));
            assertThat(result.size(), is(3));
        }

        private IGogitaiDac createGogitaiDacMock(int 件数) {
            IGogitaiDac dac = mock(IGogitaiDac.class);
            List<DbT5103GogitaiJohoEntity> list = create合議体EntityList(件数);
            when(dac.select(any(GogitaiNo.class))).thenReturn(list);
            return dac;
        }

        private IGogitaiWariateShinsakaiIinDac createGogitaiWariateIinDacMock() {
            IGogitaiWariateShinsakaiIinDac dac = mock(IGogitaiWariateShinsakaiIinDac.class);
            when(dac.select(any(GogitaiNo.class), any(FlexibleDate.class))).thenReturn(null);
            return dac;
        }

        private ShinsakaiKaisaiBashoManager createKaisaiBashoManagerMock() {
            ShinsakaiKaisaiBashoManager manager = mock(ShinsakaiKaisaiBashoManager.class);
            when(manager.get審査会開催場所(any(ShinsakaiKaisaiBashoCode.class))).thenReturn(create開催場所Mock("0001", "山田家", ShinsakaiKaisaiBashoJokyo.有効));
            return manager;
        }
    }

    public static class get有効合議体List extends DbeTestBase {

        @Test
        public void Dacから2件の有効な合議体エンティティを取得できたとき_2件の要素を持つ合議体Listが返る() {
            sut = new GogitaiManager(createGogitaiDacMock(2), createGogitaiWariateIinDacMock(), null, createKaisaiBashoManagerMock());
            GogitaiList result = sut.get有効合議体List(new GogitaiYukoKikanKaishiYMD("19991212"));
            assertThat(result.size(), is(2));
        }

        private IGogitaiDac createGogitaiDacMock(int 件数) {
            IGogitaiDac dac = mock(IGogitaiDac.class);
            List<DbT5103GogitaiJohoEntity> list = create合議体EntityList(件数);
            when(dac.select(any(FlexibleDate.class))).thenReturn(list);
            return dac;
        }

        private IGogitaiWariateShinsakaiIinDac createGogitaiWariateIinDacMock() {
            IGogitaiWariateShinsakaiIinDac dac = mock(IGogitaiWariateShinsakaiIinDac.class);
            when(dac.select(any(GogitaiNo.class), any(FlexibleDate.class))).thenReturn(null);
            return dac;
        }

        private ShinsakaiKaisaiBashoManager createKaisaiBashoManagerMock() {
            ShinsakaiKaisaiBashoManager manager = mock(ShinsakaiKaisaiBashoManager.class);
            when(manager.get審査会開催場所(any(ShinsakaiKaisaiBashoCode.class))).thenReturn(create開催場所Mock("0001", "山田家", ShinsakaiKaisaiBashoJokyo.有効));
            return manager;
        }
    }

    public static class saveのテスト extends DbeTestBase {

        @Test
        public void saveに成功したとき_trueが返る() {
            sut = new GogitaiManager(null, null, createGogitaiAndGogitaiWariateIinDacMock(4), null);
            assertThat(sut.save(create合議体Mock(1, "19991212", "0001")), is(true));
        }

        @Test
        public void saveに失敗したとき_falseが返る() {
            sut = new GogitaiManager(null, null, createGogitaiAndGogitaiWariateIinDacMock(0), null);
            assertThat(sut.save(create合議体Mock(1, "19991212", "0001")), is(false));
        }

        private IGogitaiAndGogitaiWariateIinDac createGogitaiAndGogitaiWariateIinDacMock(int 件数) {
            IGogitaiAndGogitaiWariateIinDac dac = mock(IGogitaiAndGogitaiWariateIinDac.class);
            when(dac.insertOrUpdate合議体割当審査会委員情報(any(DbT5103GogitaiJohoEntity.class), any(List.class))).thenReturn(件数);
            return dac;
        }
    }

    public static class removeのテスト extends DbeTestBase {

        @Test
        public void removeに成功したとき_trueが返る() {
            sut = new GogitaiManager(null, null, createGogitaiAndGogitaiWariateIinDacMock(4), null);
            assertThat(sut.remove(create合議体Mock(1, "19991212", "0001")), is(true));
        }

        @Test
        public void 合議体割当委員情報のremoveに失敗したとき_falseが返る() {
            sut = new GogitaiManager(null, null, createGogitaiAndGogitaiWariateIinDacMock(0), null);
            assertThat(sut.remove(create合議体Mock(1, "19991212", "0001")), is(false));
        }

        private IGogitaiAndGogitaiWariateIinDac createGogitaiAndGogitaiWariateIinDacMock(int 件数) {
            IGogitaiAndGogitaiWariateIinDac dac = mock(IGogitaiAndGogitaiWariateIinDac.class);
            when(dac.delete合議体割当審査会委員情報(any(DbT5103GogitaiJohoEntity.class), any(List.class))).thenReturn(件数);
            return dac;
        }
    }

    private static Gogitai create合議体Mock(int 合議体番号, String 有効期間開始年月日, String 開催場所コード) {
        Gogitai gogitai = mock(Gogitai.class);
        when(gogitai.get合議体番号()).thenReturn(new GogitaiNo(合議体番号));
        when(gogitai.get合議体名称()).thenReturn(RString.EMPTY);
        when(gogitai.get有効期間開始年月日()).thenReturn(new GogitaiYukoKikanKaishiYMD(有効期間開始年月日));
        when(gogitai.get有効期間終了年月日()).thenReturn(FlexibleDate.MAX);
        when(gogitai.get予定開催時間()).thenReturn(new Range(new TimeString("0830"), new TimeString("1720")));
        when(gogitai.get審査会開催場所()).thenReturn(create開催場所Mock(開催場所コード, "田島家", ShinsakaiKaisaiBashoJokyo.有効));
        GogitaiWariateIinList list = create合議体割当委員ListMock(3);
        when(gogitai.get合議体割当審査会委員List()).thenReturn(list);
        return gogitai;
    }

    private static GogitaiWariateIinList create合議体割当委員ListMock(int 件数) {
        List<GogitaiWariateIin> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(create合議体割当委員Mock());
        }
        return new GogitaiWariateIinList(list);
    }

    private static GogitaiWariateIin create合議体割当委員Mock() {
        return new GogitaiWariateIin(create審査会委員Mock(), new ShinsainKubun(new RString("0001"), new RString("審査員区分")),
                new GogitaichoKubun(new RString("0001"), new RString("合議体調区分")));
    }

    private static ShinsakaiIin create審査会委員Mock() {
        ShinsakaiIin iin = mock(ShinsakaiIin.class);
        when(iin.get委員コード()).thenReturn(new ShinsakaiIinCode(new RString("001")));
        return iin;
    }

    private static ShinsakaiKaisaiBasho create開催場所Mock(String 開催場所コード, String 開催場所名, ShinsakaiKaisaiBashoJokyo 開催場所有効) {
        return new ShinsakaiKaisaiBasho(new ShinsakaiKaisaiBashoCode(new RString(開催場所コード)),
                new RString(開催場所名), null, null, null, 開催場所有効);
    }

    private static List<DbT5103GogitaiJohoEntity> create合議体EntityList(int 件数) {
        List<DbT5103GogitaiJohoEntity> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(create合議体Entity(i, "1999121" + i));
        }
        return list;
    }

    private static DbT5103GogitaiJohoEntity create合議体Entity(int 合議体番号, String 有効期間開始年月日) {
        DbT5103GogitaiJohoEntity entity = mock(DbT5103GogitaiJohoEntity.class);
        when(entity.getGogitaiNo()).thenReturn(合議体番号);
        when(entity.getGogitaiMei()).thenReturn(RString.EMPTY);
        when(entity.getGogitaiYukoKikanKaishiYMD()).thenReturn(new FlexibleDate(有効期間開始年月日));
        when(entity.getGogitaiYukoKikanShuryoYMD()).thenReturn(FlexibleDate.MAX);
        when(entity.getGogitaiKaishiYoteiTime()).thenReturn(new RString("0830"));
        when(entity.getGogitaiShuryoYoteiTime()).thenReturn(new RString("1720"));
        when(entity.getShinsakaiKaisaiBashoCode()).thenReturn(RString.EMPTY);
        return entity;
    }
}
