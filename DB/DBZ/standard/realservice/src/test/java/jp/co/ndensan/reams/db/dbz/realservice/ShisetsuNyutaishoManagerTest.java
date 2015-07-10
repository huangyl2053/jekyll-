/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.NyushoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.ShisetsuNyutaishoList;
import jp.co.ndensan.reams.db.dbz.business.helper.ShisetsuNyutaishoMock;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 施設入退所を管理するクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoManagerTest extends DbzTestBase {

    private static ShisetsuNyutaishoManager sut;

    private static final int AS_情報なし = 0;
    private static final int AS_情報あり = 1;
    private static final int AS_情報あり_2件 = 2;
    private static final int AS_失敗 = 0;
    private static final int AS_成功 = 1;

    public static class save {

        @Test
        public void saveに失敗した場合_falseを返す() {
//            sut = createManager(AS_失敗);
//            assertThat(sut.save(ShisetsuNyutaishoMock.create施設入退所()), is(false));
        }

        @Test
        public void saveに成功した場合_trueを返す() {
//            sut = createManager(AS_成功);
//            assertThat(sut.save(ShisetsuNyutaishoMock.create施設入退所()), is(true));
        }
    }

    private static DbT1004ShisetsuNyutaishoEntity create施設入退所() {
        return DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
    }

    public static class remove {

        @Test
        public void removeに失敗した場合_falseを返す() {
//            sut = createManager(AS_失敗);
//            assertThat(sut.remove(ShisetsuNyutaishoMock.create施設入退所()), is(false));
        }

        @Test
        public void removeに成功した場合_trueを返す() {
            //           sut = createManager(AS_成功);
            //           assertThat(sut.remove(ShisetsuNyutaishoMock.create施設入退所()), is(true));
        }
    }

    public static class get施設入退所 {

        private static final ShikibetsuCode 個人識別コード = new ShikibetsuCode(new RString("1111111111"));
        private static final FlexibleDate 入所日 = new FlexibleDate("20110703");

        @Test
        public void 該当の施設入退所情報がない時_get施設入退所は_NULLを返す() {
 //           sut = createManager(AS_情報なし);
            //           ShisetsuNyutaisho result = sut.get施設入退所(個人識別コード, 入所日);
            //           assertThat(result, nullValue());
        }

        @Test
        public void 該当の施設入退所情報がある時_get施設入退所は_施設入退所情報を返す() {
            //           sut = createManager(AS_情報あり);
//            ShisetsuNyutaisho result = sut.get施設入退所(個人識別コード, 入所日);
//            assertThat(result, instanceOf(ShisetsuNyutaisho.class));
        }
    }

    public static class get個人施設入退所履歴 {

        private static final ShikibetsuCode 個人識別コード = new ShikibetsuCode(new RString("1111111111"));

        @Test
        public void 該当の施設入退所情報がない時_get個人施設入退所履歴は_空のリストを返す() {
            //           sut = createManager(AS_情報なし);
//            ShisetsuNyutaishoList result = sut.get個人施設入退所履歴(個人識別コード);
//           assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 該当の施設入退所情報が2件ある時_get個人施設入退所履歴は_2件の個人施設入退所履歴を返す() {
//            sut = createManager(AS_情報あり_2件);
//            ShisetsuNyutaishoList result = sut.get個人施設入退所履歴(個人識別コード);
//            assertThat(result.size(), is(2));
        }
    }

    public static class get個人台帳別施設入退所履歴 {

        private static final ShikibetsuCode 個人識別コード = new ShikibetsuCode(new RString("1111111111"));
        private static final DaichoType 台帳種別 = DaichoType.被保険者;

        @Test
        public void 該当の施設入退所情報がない時_get個人台帳別施設入退所履歴は_空のリストを返す() {
//            sut = createManager(AS_情報なし);
//            ShisetsuNyutaishoList result = sut.get個人台帳別施設入退所履歴(個人識別コード, 台帳種別);
//            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 該当の施設入退所情報が2件ある時_get個人台帳別施設入退所履歴は_2件の個人施設入退所履歴を返す() {
 //           sut = createManager(AS_情報あり_2件);
            //           ShisetsuNyutaishoList result = sut.get個人台帳別施設入退所履歴(個人識別コード, 台帳種別);
            //           assertThat(result.size(), is(2));
        }
    }

    //  private static ShisetsuNyutaishoManager createManager(int flg) {
    //      return new ShisetsuNyutaishoManager(createDac(flg), createBuilder());
    //  }
    private static ShisetsuNyutaishoDac createDac(int flg) {
        DbT1004ShisetsuNyutaishoEntity entity = createEntity(flg);
        List<DbT1004ShisetsuNyutaishoEntity> entities = createEntities(flg);

        ShisetsuNyutaishoDac dac = mock(ShisetsuNyutaishoDac.class);
        when(dac.select(any(ShikibetsuCode.class), any(FlexibleDate.class))).thenReturn(entity);
        when(dac.select(any(ShikibetsuCode.class))).thenReturn(entities);
        when(dac.select(any(ShikibetsuCode.class), any(DaichoType.class))).thenReturn(entities);
        when(dac.insert(any(DbT1004ShisetsuNyutaishoEntity.class))).thenReturn(flg);
        when(dac.delete(any(DbT1004ShisetsuNyutaishoEntity.class))).thenReturn(flg);
        return dac;
    }

    private static NyushoShisetsuBuilder createBuilder() {
        NyushoShisetsuBuilder builder = mock(NyushoShisetsuBuilder.class);
        when(builder.build入所施設(
                any(ShisetsuType.class), any(ShisetsuCode.class), any(FlexibleDate.class))).
                thenReturn(mock(NyushoShisetsu.class));
        return builder;
    }

    private static DbT1004ShisetsuNyutaishoEntity createEntity(int flg) {
        return flg == 0 ? null : DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
    }

    private static List<DbT1004ShisetsuNyutaishoEntity> createEntities(int entitiesSize) {
        if (entitiesSize == 0) {
            return Collections.EMPTY_LIST;
        }
        List<DbT1004ShisetsuNyutaishoEntity> entities = new ArrayList<>();
        for (int i = 0; i < entitiesSize; i++) {
            entities.add(DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity());
        }
        return entities;
    }
}
