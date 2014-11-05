/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.JogaiShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.JogaiShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiMockBusinessCreator;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5014ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbe.entity.relate.JogaiShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiIinJogaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.JogaiShinsakaiIinDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * 除外審査会委員Managerのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JogaiShinsakaiIinManagerTest {

    private static JogaiShinsakaiIinManager sut;

    public static class get除外審査会委員List extends DbeTestBase {

        @Test
        public void Dacから3件の除外審査会委員Entityが返却される時_get除外審査会委員Listの戻り値は_3件の要素を持つ除外審査会Listを返す() {
            sut = new JogaiShinsakaiIinManager(createMockDac(), null);

            ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("012345"));
            KaigoHihokenshaNo 介護被保険者番号 = new KaigoHihokenshaNo(new RString("0123456789"));
            JogaiShinsakaiIinList result = sut.get除外審査会委員List(証記載保険者番号, 介護被保険者番号);
            assertThat(result.size(), is(3));
        }

        private JogaiShinsakaiIinDac createMockDac() {
            JogaiShinsakaiIinDac mockDac = mock(JogaiShinsakaiIinDac.class);
            List<JogaiShinsakaiIinEntity> list = ShinsakaiMockEntityCreator.create除外対象審査会委員EntityListSpy(3);
            when(mockDac.select(any(ShoKisaiHokenshaNo.class), any(KaigoHihokenshaNo.class))).thenReturn(list);
            return mockDac;
        }
    }

    public static class save extends DbeTestBase {

        @Test
        public void 保存に成功したときtrueが返る() {
            JogaiShinsakaiIin jogaiIin = ShinsakaiMockBusinessCreator.create除外対象審査会委員();
            sut = new JogaiShinsakaiIinManager(null, createMockDac(1));
            assertThat(sut.save(jogaiIin), is(true));
        }

        @Test
        public void 保存に失敗したときfalseが返る() {
            JogaiShinsakaiIin jogaiIin = ShinsakaiMockBusinessCreator.create除外対象審査会委員();
            sut = new JogaiShinsakaiIinManager(null, createMockDac(0));
            assertThat(sut.save(jogaiIin), is(false));
        }

        private ShinsakaiIinJogaiJohoDac createMockDac(int 件数) {
            ShinsakaiIinJogaiJohoDac dacMock = mock(ShinsakaiIinJogaiJohoDac.class);
            when(dacMock.insertOrUpdate(any(DbT5014ShinsakaiIinJogaiJohoEntity.class))).thenReturn(件数);
            return dacMock;
        }

    }

    public static class remove extends DbeTestBase {

        @Test
        public void 削除に成功したときtrueが返る() {
            JogaiShinsakaiIin jogaiIin = ShinsakaiMockBusinessCreator.create除外対象審査会委員();
            sut = new JogaiShinsakaiIinManager(null, createMockDac(1));
            assertThat(sut.remove(jogaiIin), is(true));
        }

        @Test
        public void 削除に失敗したときfalseが返る() {
            JogaiShinsakaiIin jogaiIin = ShinsakaiMockBusinessCreator.create除外対象審査会委員();
            sut = new JogaiShinsakaiIinManager(null, createMockDac(0));
            assertThat(sut.remove(jogaiIin), is(false));
        }

        private ShinsakaiIinJogaiJohoDac createMockDac(int 件数) {
            ShinsakaiIinJogaiJohoDac dacMock = mock(ShinsakaiIinJogaiJohoDac.class);
            when(dacMock.delete(any(DbT5014ShinsakaiIinJogaiJohoEntity.class))).thenReturn(件数);
            return dacMock;
        }

    }

}
