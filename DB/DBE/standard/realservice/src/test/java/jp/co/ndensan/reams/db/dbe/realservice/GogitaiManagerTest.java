/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Gogitai;
import jp.co.ndensan.reams.db.dbe.business.GogitaiJoho;
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
import jp.co.ndensan.reams.db.dbe.entity.relate.GogitaiWariateShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IGogitaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IGogitaiAndGogitaiWariateIinDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IGogitaiWariateShinsakaiIinDac;
import jp.co.ndensan.reams.db.dbe.realservice.helper.GogitaiMockEntityCreator;
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
            sut = new GogitaiManager(createGogitaiWariateIinDacMock(3), null);
            GogitaiList result = sut.get合議体履歴List(new GogitaiNo(1));
            assertThat(result.size(), is(3));
        }

        private IGogitaiWariateShinsakaiIinDac createGogitaiWariateIinDacMock(int 件数) {
            IGogitaiWariateShinsakaiIinDac dac = mock(IGogitaiWariateShinsakaiIinDac.class);
            when(dac.select(any(GogitaiNo.class))).thenReturn(create合議体割当委員EntityList(件数));
            return dac;
        }
    }

    public static class get有効合議体List extends DbeTestBase {

        @Test
        public void Dacから2件の有効な合議体エンティティを取得できたとき_2件の要素を持つ合議体Listが返る() {
            sut = new GogitaiManager(createGogitaiWariateIinDacMock(2), null);
            GogitaiList result = sut.get有効合議体List(new GogitaiYukoKikanKaishiYMD("19991212"));
            assertThat(result.size(), is(2));
        }

        private IGogitaiWariateShinsakaiIinDac createGogitaiWariateIinDacMock(int 件数) {
            IGogitaiWariateShinsakaiIinDac dac = mock(IGogitaiWariateShinsakaiIinDac.class);
            when(dac.select(any(GogitaiYukoKikanKaishiYMD.class))).thenReturn(create合議体割当委員EntityList(件数));
            return dac;
        }
    }

    public static class saveのテスト extends DbeTestBase {

        @Test
        public void saveに成功したとき_trueが返る() {
            sut = new GogitaiManager(null, createGogitaiAndGogitaiWariateIinDacMock(4));
            assertThat(sut.save(create合議体Mock()), is(true));
        }

        @Test
        public void saveに失敗したとき_falseが返る() {
            sut = new GogitaiManager(null, createGogitaiAndGogitaiWariateIinDacMock(0));
            assertThat(sut.save(create合議体Mock()), is(false));
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
            sut = new GogitaiManager(null, createGogitaiAndGogitaiWariateIinDacMock(4));
            assertThat(sut.remove(create合議体Mock()), is(true));
        }

        @Test
        public void 合議体割当委員情報のremoveに失敗したとき_falseが返る() {
            sut = new GogitaiManager(null, createGogitaiAndGogitaiWariateIinDacMock(0));
            assertThat(sut.remove(create合議体Mock()), is(false));
        }

        private IGogitaiAndGogitaiWariateIinDac createGogitaiAndGogitaiWariateIinDacMock(int 件数) {
            IGogitaiAndGogitaiWariateIinDac dac = mock(IGogitaiAndGogitaiWariateIinDac.class);
            when(dac.delete合議体割当審査会委員情報(any(DbT5103GogitaiJohoEntity.class), any(List.class))).thenReturn(件数);
            return dac;
        }
    }

    private static Gogitai create合議体Mock() {
        return mock(Gogitai.class);
    }

    private static List<GogitaiWariateShinsakaiIinEntity> create合議体割当委員EntityList(int 件数) {
        List<GogitaiWariateShinsakaiIinEntity> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(create合議体割当委員Entity(i));
        }
        return list;
    }

    private static GogitaiWariateShinsakaiIinEntity create合議体割当委員Entity(int 合議体番号) {
        GogitaiWariateShinsakaiIinEntity entity = new GogitaiWariateShinsakaiIinEntity();
        entity.set割当Entity(GogitaiMockEntityCreator.create合議体割当Entity(合議体番号, "iin01", "19991212", "19991231"));
        entity.set合議体情報Entity(GogitaiMockEntityCreator.create合議体情報Entity(合議体番号, "19991212", "19991231", "basho1"));
        entity.set委員Entity(GogitaiMockEntityCreator.create審査会委員Entity("iin01", "19800101"));
        entity.set開催場所Entity(GogitaiMockEntityCreator.create開催場所Entity("basho1"));
        return entity;
    }
}
