/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.KaigoTeikeibun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.TeikeibunJohoEntityMock;
import jp.co.ndensan.reams.db.dbz.persistence.basic.KaigoTeikeibunDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * KaigoTeikeibunFinderのテストです。
 *
 * @author N9606 漢那 憲作
 */
@RunWith(Enclosed.class)
public class KaigoTeikeibunFinderTest extends DbzTestBase {

    private static KaigoTeikeibunFinder sut;
    private static final int 情報なし_0件 = 0;
    private static final int 情報あり_1件 = 1;
    private static final int 情報あり_2件 = 2;
    private static final RString 区分 = new RString("1");
    private static final RString 種別 = new RString("001");
    private static final RString コード = new RString("0001");
    private static final RString notFount区分 = new RString("2");

    public static class get定型文情報リスト_区分 {

        @Test
        public void 該当の定型文情報がない時_get定型文情報リストは_空のリストを返す() {

            sut = new KaigoTeikeibunFinder(createDacMock(情報なし_0件));
            List<KaigoTeikeibun> result = sut.getTeikeibunList(notFount区分);
            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 該当の定型文情報が１件存在する時_get定型文情報リストは_１件のデータを返す() {

            sut = new KaigoTeikeibunFinder(createDacMock(情報あり_1件));
            List<KaigoTeikeibun> result = sut.getTeikeibunList(区分);
            assertThat(result.size(), is(1));
        }

        @Test
        public void 該当の定型文情報が２件存在する時_get定型文情報リストは_２件のデータを返す() {

            sut = new KaigoTeikeibunFinder(createDacMock(情報あり_2件));
            List<KaigoTeikeibun> result = sut.getTeikeibunList(区分);
            assertThat(result.size(), is(2));
        }
    }

    public static class get定型文情報リスト_区分_種別 {

        @Test
        public void 該当の定型文情報がない時_get定型文情報リストは_空のリストを返す() {

            sut = new KaigoTeikeibunFinder(createDacMock(情報なし_0件));
            List<KaigoTeikeibun> result = sut.getTeikeibunList(notFount区分, 種別);
            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 該当の定型文情報が１件存在する時_get定型文情報リストは_１件のデータを返す() {

            sut = new KaigoTeikeibunFinder(createDacMock(情報あり_1件));
            List<KaigoTeikeibun> result = sut.getTeikeibunList(区分, 種別);
            assertThat(result.size(), is(1));
        }

        @Test
        public void 該当の定型文情報が２件存在する時_get定型文情報リストは_２件のデータを返す() {

            sut = new KaigoTeikeibunFinder(createDacMock(情報あり_2件));
            List<KaigoTeikeibun> result = sut.getTeikeibunList(区分, 種別);
            assertThat(result.size(), is(2));
        }
    }

    public static class get定型文情報 {

        @Test
        public void 該当の定型文情報がない時_get定型文情報は_nullを返す() {

            sut = new KaigoTeikeibunFinder(createDacMock(情報なし_0件));
            KaigoTeikeibun result = sut.getTeikeibun(notFount区分, 種別, コード);
            assertThat(result, nullValue());
        }

        @Test
        public void 該当の定型文情報が存在する時_get定型文情報は_介護定型文データを返す() {

            sut = new KaigoTeikeibunFinder(createDacMock(情報あり_1件));
            KaigoTeikeibun result = sut.getTeikeibun(区分, 種別, コード);
            assertThat(result, instanceOf(KaigoTeikeibun.class));
        }
    }

    private static KaigoTeikeibunDac createDacMock(int kensu) {
        KaigoTeikeibunDac 定型文情報dac = mock(KaigoTeikeibunDac.class);
        List<DbT7103TeikeibunJohoEntity> entityList = new ArrayList<>();
        DbT7103TeikeibunJohoEntity entity = TeikeibunJohoEntityMock.create定型文情報Entity();
        entityList.add(entity);
        if (kensu == 情報あり_2件) {
            entity.setTeikeibunCd(new RString("0002"));
            entityList.add(entity);
        }

        when(定型文情報dac.select(区分)).thenReturn(entityList);
        when(定型文情報dac.select(区分, 種別)).thenReturn(entityList);
        when(定型文情報dac.select(区分, 種別, コード)).thenReturn(entity);

        return 定型文情報dac;

    }
}
