/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.NyushoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.ShisetsuNyutaishoList;
import jp.co.ndensan.reams.db.dbz.business.helper.ShisetsuNyutaishoMock;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.ShisetsuNyutaishoEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 施設入退所のマッパークラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoMapperTest extends DbzTestBase {

    public static class to施設入退所 extends DbzTestBase {

        private final DbT1004ShisetsuNyutaishoEntity entity
                = ShisetsuNyutaishoEntityMock.create施設入退所Entity();
        private ShisetsuNyutaisho sut;

        @Before
        public void setUp() {
            sut = ShisetsuNyutaishoMapper.to施設入退所(
                    entity, ShisetsuNyutaishoMock.create入所施設());
        }

        @Test
        public void 施設入退所entityに_nullを設定した時_nullを返す() {
            sut = ShisetsuNyutaishoMapper.to施設入退所(null, ShisetsuNyutaishoMock.create入所施設());
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void get市町村コードが_Entityの市町村コードと同一になる() {
            assertThat(sut.get市町村コード(), is(entity.getShichosonCode()));
        }

        @Test
        public void get個人識別コードが_Entityの識別コードと同一になる() {
            assertThat(sut.get個人識別コード(), is(entity.getShikibetsuCode()));
        }

        @Test
        public void get処理日時が_Entityの処理日時と同一になる() {
            assertThat(sut.get処理日時(), is(entity.getShoriTimestamp()));
        }

        @Test
        public void get台帳種別のコードが_Entityの台帳種別と同一になる() {
            assertThat(sut.get台帳種別().getCode(), is(entity.getDaichoShubetsu()));
        }

        @Test
        public void get入所期間の開始日が_Entityの入所日と同一になる() {
            assertThat(sut.get入所期間().getFrom(), is(entity.getNyushoYMD()));
        }

        @Test
        public void get入所期間の終了日が_Entityの退所日と同一になる() {
            assertThat(sut.get入所期間().getTo(), is(entity.getTaishoYMD()));
        }

        @Test
        public void get入所処理年月日が_Entityの入所処理年月日と同一になる() {
            assertThat(sut.get入所処理年月日(), is(entity.getNyushoShoriYMD()));
        }

        @Test
        public void get退所処理年月日が_Entityの退所処理年月日と同一になる() {
            assertThat(sut.get退所処理年月日(), is(entity.getTaishoShoriYMD()));
        }

        @Test
        public void get入所施設のget施設種類が_Entityの入所施設種類と同一になる() {
            assertThat(sut.get入所施設().get施設種類().getCode(), is(entity.getNyushoShisetsuShurui()));
        }

        @Test
        public void get入所施設のget施設コードが_Entityの入所施設コードと同一になる() {
            assertThat(sut.get入所施設().get施設コード().value(), is(entity.getNyushoShisetsuCode()));
        }
    }

    public static class to施設入退所List {

        private ShisetsuNyutaishoList sut;

        @Test
        public void 引数のentityがnullの時_空のコレクションが返る() {
            sut = ShisetsuNyutaishoMapper.to施設入退所List(null, create入所施設List(3));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 引数の入所施設がnullの時_空のコレクションが返る() {
            sut = ShisetsuNyutaishoMapper.to施設入退所List(create施設入退所EntityList(3), null);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 空のentityリストが渡された時_空のコレクションが返る() {
            sut = ShisetsuNyutaishoMapper.to施設入退所List(Collections.EMPTY_LIST, create入所施設List(3));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 空の入所施設リストが渡された時_空のコレクションが返る() {
            sut = ShisetsuNyutaishoMapper.to施設入退所List(create施設入退所EntityList(3), Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void entityを3件持つListが渡された場合_3件の要素を持つコレクションが返る() {
            final int LIST_SIZE = 3;
            sut = ShisetsuNyutaishoMapper.to施設入退所List(
                    create施設入退所EntityList(LIST_SIZE), create入所施設List(LIST_SIZE));
            assertThat(sut.size(), is(3));
        }

        private List<DbT1004ShisetsuNyutaishoEntity> create施設入退所EntityList(int listSize) {
            List<DbT1004ShisetsuNyutaishoEntity> list = new ArrayList<>();
            for (int i = 0; i < listSize; i++) {
                list.add(ShisetsuNyutaishoEntityMock.create施設入退所Entity());
            }
            return list;
        }

        private List<NyushoShisetsu> create入所施設List(int listSize) {
            List<NyushoShisetsu> list = new ArrayList<>();
            for (int i = 0; i < listSize; i++) {
                list.add(ShisetsuNyutaishoMock.create入所施設());
            }
            return list;
        }
    }

    public static class to施設入退所Entity extends DbzTestBase {

        private DbT1004ShisetsuNyutaishoEntity sut;
        private final ShisetsuNyutaisho 施設入退所 = ShisetsuNyutaishoMock.create施設入退所();

        @Before
        public void setUp() {
            sut = ShisetsuNyutaishoMapper.to施設入退所Entity(施設入退所);
        }

        @Test
        public void 引数にnullが渡された時_nullを返す() {
            sut = ShisetsuNyutaishoMapper.to施設入退所Entity(null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void Entityの市町村コードと_施設入退所の市町村コードが同一になる() {
            assertThat(sut.getShichosonCode(), is(施設入退所.get市町村コード()));
        }

        @Test
        public void Entityの識別コードと_施設入退所の個人識別コードが同一になる() {
            assertThat(sut.getShikibetsuCode(), is(施設入退所.get個人識別コード()));
        }

        @Test
        public void Entityの処理日時と_施設入退所の処理日時が同一になる() {
            assertThat(sut.getShoriTimestamp(), is(施設入退所.get処理日時()));
        }

        @Test
        public void Entityの台帳種別と_施設入退所の台帳種別のコードが同一になる() {
            assertThat(sut.getDaichoShubetsu(), is(施設入退所.get台帳種別().getCode()));
        }

        @Test
        public void Entityの入所施設種類と_入所施設の施設種類が同一になる() {
            assertThat(sut.getNyushoShisetsuShurui(), is(施設入退所.get入所施設().get施設種類().getCode()));
        }

        @Test
        public void Entityの入所施設コードと_入所施設の施設コードが同一になる() {
            assertThat(sut.getNyushoShisetsuCode(), is(施設入退所.get入所施設().get施設コード().value()));
        }

        @Test
        public void Entityの入所処理年月日と_施設入退所の入所処理年月日が同一になる() {
            assertThat(sut.getNyushoShoriYMD(), is(施設入退所.get入所処理年月日()));
        }

        @Test
        public void Entityの退所処理年月日と_施設入退所の退所処理年月日が同一になる() {
            assertThat(sut.getTaishoShoriYMD(), is(施設入退所.get退所処理年月日()));
        }

        @Test
        public void Entityの入所年月日と_施設入退所の入所年月日が同一になる() {
            assertThat(sut.getNyushoYMD(), is(施設入退所.get入所期間().getFrom()));
        }

        @Test
        public void Entityの退所年月日と_施設入退所の退所年月日が同一になる() {
            assertThat(sut.getTaishoYMD(), is(施設入退所.get入所期間().getTo()));
        }
    }
}
