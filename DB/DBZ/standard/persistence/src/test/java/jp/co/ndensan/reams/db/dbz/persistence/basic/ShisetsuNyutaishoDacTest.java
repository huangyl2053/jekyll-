/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.ShisetsuNyutaishoEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 施設入退所データアクセスクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoDacTest extends DbzTestDacBase {

    private static ShisetsuNyutaishoDac sut;
    private static final int 成功 = 1;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(ShisetsuNyutaishoDac.class);
    }

    public static class insert extends DbzTestDacBase {

        @Test
        public void 一件もデータを持っていないテーブルに対して_1件のデータを挿入したとき_1を返す() {
            int result = sut.insert(ShisetsuNyutaishoEntityMock.create施設入退所Entity());
            assertThat(result, is(成功));
        }

        @Test
        public void 既にデータを持っているテーブルに対して_新たに同じキー項目を持つデータを挿入したとき_1を返す() {
            sut.insert(ShisetsuNyutaishoEntityMock.create施設入退所Entity());
            int result = sut.insert(ShisetsuNyutaishoEntityMock.create施設入退所Entity());
            assertThat(result, is(成功));
        }
    }

    public static class delete extends DbzTestDacBase {

        private static final ShikibetsuCode 個人識別コード = new ShikibetsuCode(new RString("1111111111"));
        private static final FlexibleDate 入所日 = new FlexibleDate("20110703");

        @Before
        public void setUp() {
            createEntityForDelete();
        }

        @Test
        public void 削除対象のデータが存在しているとき_一件のデータを削除すると_1が返る() {
            int result = sut.delete(ShisetsuNyutaishoEntityMock.create施設入退所Entity());
            assertThat(result, is(成功));
        }

        @Test
        public void 既に論理削除したデータを取得しようとしたとき_nullが返る() {
            sut.delete(ShisetsuNyutaishoEntityMock.create施設入退所Entity());
            DbT1004ShisetsuNyutaishoEntity result = sut.select(個人識別コード, 入所日);
            assertThat(result, nullValue());
        }

        private static void createEntityForDelete() {
            DbT1004ShisetsuNyutaishoEntity entity
                    = ShisetsuNyutaishoEntityMock.create施設入退所Entity();

            entity.setShikibetsuCode(個人識別コード);
            sut.insert(entity);
        }
    }

    public static class select_個人識別コード_基準日 extends DbzTestDacBase {

        private static final ShikibetsuCode 個人識別コード = new ShikibetsuCode(new RString("1111111111"));
        private static final FlexibleDate 入所日 = new FlexibleDate("20110703");

        @Before
        public void setUp() {
            createEntityForInsert個人識別コード_基準日();
        }

        @Test
        public void 指定する個人識別コードに対応するデータがない時_select個人識別コード_基準日は_NULLを返す() {
            ShikibetsuCode notFound個人識別コード = new ShikibetsuCode(new RString("9999999999"));
            DbT1004ShisetsuNyutaishoEntity result = sut.select(notFound個人識別コード, 入所日);
            assertThat(result, nullValue());
        }

        @Test
        public void 指定する基準日に対応するデータがない時_select個人識別コード_基準日は_NULLを返す() {
            FlexibleDate notFound入所日 = new FlexibleDate("20120909");
            DbT1004ShisetsuNyutaishoEntity result = sut.select(個人識別コード, notFound入所日);
            assertThat(result, nullValue());
        }

        @Test
        public void 指定するデータがあり履歴もある時_select個人識別コード_基準日は_履歴最新の一件を返す() {
            DbT1004ShisetsuNyutaishoEntity result = sut.select(個人識別コード, 入所日);
            DaichoType newest台帳種別 = DaichoType.適用除外者台帳;
            assertThat(result.getDaichoShubetsu(), is(newest台帳種別.getCode()));
        }

        static void createEntityForInsert個人識別コード_基準日() {
            DbT1004ShisetsuNyutaishoEntity entity
                    = ShisetsuNyutaishoEntityMock.create施設入退所Entity();

            entity.setShikibetsuCode(個人識別コード);
            entity.setDaichoShubetsu(DaichoType.被保険者台帳.getCode());
            sut.insert(entity);

            entity.setShikibetsuCode(個人識別コード);
            entity.setDaichoShubetsu(DaichoType.適用除外者台帳.getCode());
            sut.insert(entity);
        }
    }

    public static class select_個人識別コード extends DbzTestDacBase {

        private static final ShikibetsuCode 個人識別コード1 = new ShikibetsuCode(new RString("1111111111"));
        private static final ShikibetsuCode 個人識別コード2 = new ShikibetsuCode(new RString("2222222222"));

        @Before
        public void setUp() {
            createEntityForInsert個人識別コード();
        }

        @Test
        public void 指定するデータがない時_select個人識別コードは_空のリストを返す() {
            ShikibetsuCode notFound識別コード = new ShikibetsuCode(new RString("9999999999"));
            List<DbT1004ShisetsuNyutaishoEntity> result = sut.select(notFound識別コード);
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 個人識別コード1を指定する時_select個人識別コードは_2件のリストを返す() {
            List<DbT1004ShisetsuNyutaishoEntity> result = sut.select(個人識別コード1);
            assertThat(result.size(), is(2));
        }

        @Test
        public void 個人識別コード2を指定する時_select個人識別コードは_3件のリストを返す() {
            List<DbT1004ShisetsuNyutaishoEntity> result = sut.select(個人識別コード2);
            assertThat(result.size(), is(3));
        }

        static void createEntityForInsert個人識別コード() {
            DbT1004ShisetsuNyutaishoEntity entity
                    = ShisetsuNyutaishoEntityMock.create施設入退所Entity();

            entity.setShikibetsuCode(個人識別コード1);
            entity.setShoriTimestamp(RDateTime.of(2010, 1, 10, 11, 12));
            sut.insert(entity);

            entity.setShikibetsuCode(個人識別コード2);
            entity.setShoriTimestamp(RDateTime.of(2011, 1, 10, 11, 12));
            sut.insert(entity);

            entity.setShikibetsuCode(個人識別コード2);
            entity.setShoriTimestamp(RDateTime.of(2012, 1, 10, 11, 12));
            sut.insert(entity);

            entity.setShikibetsuCode(個人識別コード1);
            entity.setShoriTimestamp(RDateTime.of(2013, 1, 10, 11, 12));
            sut.insert(entity);

            entity.setShikibetsuCode(個人識別コード2);
            entity.setShoriTimestamp(RDateTime.of(2014, 1, 10, 11, 12));
            sut.insert(entity);
        }
    }

    public static class select_個人識別コード_台帳種別 extends DbzTestDacBase {

        private static final ShikibetsuCode 個人識別コード1 = new ShikibetsuCode(new RString("1111111111"));
        private static final ShikibetsuCode 個人識別コード2 = new ShikibetsuCode(new RString("2222222222"));
        private static final DaichoType 台帳種別1 = DaichoType.他市町村住所地特例者台帳;
        private static final DaichoType 台帳種別2 = DaichoType.被保険者台帳;

        @Before
        public void setUp() {
            createEntityForInsert個人識別コード_台帳種別();
        }

        @Test
        public void 指定する識別コードに対応するデータがない時_select個人識別コード_台帳種別は_空のリストを返す() {
            ShikibetsuCode notFound識別コード = new ShikibetsuCode(new RString("9999999999"));
            List<DbT1004ShisetsuNyutaishoEntity> result = sut.select(notFound識別コード, DaichoType.被保険者台帳);
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 指定する台帳種別に対応するデータがない時_select個人識別コード_台帳種別は_空のリストを返す() {
            DaichoType notFound台帳種別 = DaichoType.適用除外者台帳;
            List<DbT1004ShisetsuNyutaishoEntity> result = sut.select(個人識別コード1, notFound台帳種別);
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 個人識別コード1_台帳種別1を指定する時_select個人識別コード_台帳種別は_1件のリストを返す() {
            List<DbT1004ShisetsuNyutaishoEntity> result = sut.select(個人識別コード1, 台帳種別1);
            assertThat(result.size(), is(1));
        }

        @Test
        public void 個人識別コード2_台帳種別2を指定する時_select個人識別コード_台帳種別は_2件のリストを返す() {
            List<DbT1004ShisetsuNyutaishoEntity> result = sut.select(個人識別コード2, 台帳種別2);
            assertThat(result.size(), is(2));
        }

        static void createEntityForInsert個人識別コード_台帳種別() {
            DbT1004ShisetsuNyutaishoEntity entity
                    = ShisetsuNyutaishoEntityMock.create施設入退所Entity();

            entity.setShikibetsuCode(個人識別コード1);
            entity.setShoriTimestamp(RDateTime.of(2010, 1, 10, 11, 12));
            entity.setDaichoShubetsu(DaichoType.他市町村住所地特例者台帳.getCode());
            sut.insert(entity);

            entity.setShikibetsuCode(個人識別コード2);
            entity.setShoriTimestamp(RDateTime.of(2011, 1, 10, 11, 12));
            entity.setDaichoShubetsu(DaichoType.被保険者台帳.getCode());
            sut.insert(entity);

            entity.setShikibetsuCode(個人識別コード2);
            entity.setShoriTimestamp(RDateTime.of(2012, 1, 10, 11, 12));
            entity.setDaichoShubetsu(DaichoType.被保険者台帳.getCode());
            sut.insert(entity);

            entity.setShikibetsuCode(個人識別コード1);
            entity.setShoriTimestamp(RDateTime.of(2013, 1, 10, 11, 12));
            entity.setDaichoShubetsu(DaichoType.被保険者台帳.getCode());
            sut.insert(entity);

            entity.setShikibetsuCode(個人識別コード2);
            entity.setShoriTimestamp(RDateTime.of(2014, 1, 10, 11, 12));
            entity.setDaichoShubetsu(DaichoType.適用除外者台帳.getCode());
            sut.insert(entity);
        }
    }
}
