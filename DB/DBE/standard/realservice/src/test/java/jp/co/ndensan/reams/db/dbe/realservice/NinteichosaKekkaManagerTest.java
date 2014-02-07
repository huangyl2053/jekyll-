/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekka;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5008NinteichosaKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteiChosaTokkijikoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosaKekkaJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosaTokkijikoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosahyoJohoDac;
import jp.co.ndensan.reams.db.dbe.realservice.helper.NinteichosaKekkaEntityMock;
import jp.co.ndensan.reams.db.dbe.realservice.helper.NinteichosaKekkaMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 要介護認定調査結果の情報を管理するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaKekkaManagerTest {

    public static class get認定調査結果 {

        @Test
        public void 認定調査結果情報が存在する時_get認定調査結果は_該当の認定調査結果情報を返す() {
            NinteichosaKekkaManager sut = createNinteichosaKekkaManager(1, 1, 1);
            assertThat(sut.get認定調査結果(new ShinseishoKanriNo(new RString("1234567890")), 0).get申請書管理番号().getValue(), is(new RString("1234567890")));
        }

        @Test
        public void 認定調査結果情報が存在しない時_get認定調査結果は_NULLを返す() {
            NinteichosaKekkaManager sut = createNinteichosaKekkaManager(0, 1, 1);
            assertThat(sut.get認定調査結果(new ShinseishoKanriNo(new RString("1234567890")), 0), nullValue());
        }

        @Test
        public void 認定調査票情報が存在しない時_get認定調査結果は_NULLを返す() {
            NinteichosaKekkaManager sut = createNinteichosaKekkaManager(1, 0, 1);
            assertThat(sut.get認定調査結果(new ShinseishoKanriNo(new RString("1234567890")), 0), nullValue());
        }

        @Test
        public void 認定調査特記情報が存在しない時_get認定調査結果は_NULLを返す() {
            NinteichosaKekkaManager sut = createNinteichosaKekkaManager(1, 1, 0);
            assertThat(sut.get認定調査結果(new ShinseishoKanriNo(new RString("1234567890")), 0), nullValue());
        }
    }

    public static class save認定調査結果 {

        @Test
        public void 認定調査結果情報の保存が成功した時_save認定調査結果は_TRUEを返す() {
            NinteichosaKekkaManager sut = createNinteichosaKekkaManager(1, 1, 1);
            assertThat(sut.save認定調査結果(createNinteichosaKekka()), is(true));
        }

        @Test
        public void 認定調査結果情報の保存が失敗した時_save認定調査結果は_FALSEを返す() {
            NinteichosaKekkaManager sut = createNinteichosaKekkaManager(0, 1, 1);
            assertThat(sut.save認定調査結果(createNinteichosaKekka()), is(false));
        }

        @Test
        public void 認定調査票情報の保存が失敗した時_save認定調査結果は_FALSEを返す() {
            NinteichosaKekkaManager sut = createNinteichosaKekkaManager(1, 0, 1);
            assertThat(sut.save認定調査結果(createNinteichosaKekka()), is(false));
        }

        @Test
        public void 認定調査特記情報の保存が失敗した時_save認定調査結果は_FALSEを返す() {
            NinteichosaKekkaManager sut = createNinteichosaKekkaManager(1, 1, 0);
            assertThat(sut.save認定調査結果(createNinteichosaKekka()), is(false));
        }
    }

    public static class remove認定調査結果 {

        @Test
        public void 認定調査結果情報の削除が成功した時_remove認定調査結果は_TRUEを返す() {
            NinteichosaKekkaManager sut = createNinteichosaKekkaManager(1, 1, 1);
            assertThat(sut.remove認定調査結果(createNinteichosaKekka()), is(true));
        }

        @Test
        public void 認定調査結果情報の削除が失敗した時_remove認定調査結果は_FALSEを返す() {
            NinteichosaKekkaManager sut = createNinteichosaKekkaManager(0, 1, 1);
            assertThat(sut.remove認定調査結果(createNinteichosaKekka()), is(false));
        }

        @Test
        public void 認定調査票情報の削除が失敗した時_remove認定調査結果は_FALSEを返す() {
            NinteichosaKekkaManager sut = createNinteichosaKekkaManager(1, 0, 1);
            assertThat(sut.remove認定調査結果(createNinteichosaKekka()), is(false));
        }

        @Test
        public void 認定調査特記情報の保存が失敗した時_save認定調査結果は_FALSEを返す() {
            NinteichosaKekkaManager sut = createNinteichosaKekkaManager(1, 1, 0);
            assertThat(sut.save認定調査結果(createNinteichosaKekka()), is(false));
        }
    }

    private static NinteichosaKekkaManager createNinteichosaKekkaManager(int chosakekkaFlg, int chosahyoFlag, int tokkijikoFlag) {
        return new NinteichosaKekkaManager(
                createNinteichosaKekkaJohoDac(chosakekkaFlg),
                createNinteichosahyoJohoDac(chosahyoFlag),
                createNinteichosaTokkijikoDac(tokkijikoFlag));
    }

    private static INinteichosaKekkaJohoDac createNinteichosaKekkaJohoDac(int flag) {
        INinteichosaKekkaJohoDac dac = mock(INinteichosaKekkaJohoDac.class);
        when(dac.select(any(RString.class), any(int.class))).thenReturn(createDbT5008NinteichosaKekkaJohoEntity(flag));
        when(dac.insertOrUpdate(any(DbT5008NinteichosaKekkaJohoEntity.class))).thenReturn(flag);
        when(dac.insert(any(DbT5008NinteichosaKekkaJohoEntity.class))).thenReturn(flag);
        when(dac.update(any(DbT5008NinteichosaKekkaJohoEntity.class))).thenReturn(flag);
        when(dac.delete(any(DbT5008NinteichosaKekkaJohoEntity.class))).thenReturn(flag);
        return dac;
    }

    private static INinteichosahyoJohoDac createNinteichosahyoJohoDac(int flag) {
        INinteichosahyoJohoDac dac = mock(INinteichosahyoJohoDac.class);
        when(dac.select(any(RString.class), any(int.class))).thenReturn(createDbT5009NinteichosahyoJohoEntity(flag));
        when(dac.insertOrUpdate(any(DbT5009NinteichosahyoJohoEntity.class))).thenReturn(flag);
        when(dac.insert(any(DbT5009NinteichosahyoJohoEntity.class))).thenReturn(flag);
        when(dac.update(any(DbT5009NinteichosahyoJohoEntity.class))).thenReturn(flag);
        when(dac.delete(any(DbT5009NinteichosahyoJohoEntity.class))).thenReturn(flag);
        return dac;
    }

    private static INinteichosaTokkijikoDac createNinteichosaTokkijikoDac(int flag) {
        INinteichosaTokkijikoDac dac = mock(INinteichosaTokkijikoDac.class);
        when(dac.select(any(RString.class), any(int.class))).thenReturn(createDbT5010NinteiChosaTokkijikoEntity(flag));
        when(dac.insertOrUpdate(any(DbT5010NinteiChosaTokkijikoEntity.class))).thenReturn(flag);
        when(dac.insert(any(DbT5010NinteiChosaTokkijikoEntity.class))).thenReturn(flag);
        when(dac.update(any(DbT5010NinteiChosaTokkijikoEntity.class))).thenReturn(flag);
        when(dac.delete(any(DbT5010NinteiChosaTokkijikoEntity.class))).thenReturn(flag);
        return dac;
    }

    private static NinteichosaKekka createNinteichosaKekka() {
        return NinteichosaKekkaMock.getSpiedNinteichosaKekkaInstance();
    }

    private static DbT5008NinteichosaKekkaJohoEntity createDbT5008NinteichosaKekkaJohoEntity(int flag) {
        return 0 < flag ? NinteichosaKekkaEntityMock.getSpiedDbT5008NinteichosaKekkaJohoEntityInstance() : null;
    }

    private static DbT5009NinteichosahyoJohoEntity createDbT5009NinteichosahyoJohoEntity(int flag) {
        return 0 < flag ? NinteichosaKekkaEntityMock.getSpiedDbT5009NinteichosahyoJohoEntityInstance() : null;
    }

    private static DbT5010NinteiChosaTokkijikoEntity createDbT5010NinteiChosaTokkijikoEntity(int flag) {
        return 0 < flag ? NinteichosaKekkaEntityMock.getSpiedDbT5010NinteiChosaTokkijikoEntityInstance() : null;
    }
}
