/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaTokkijiko;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteichosaTokkijikoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosaTokkijikoDac;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * 認定調査特記事項Managerのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaTokkijikoManagerTest extends TestBase {

    private static NinteichosaTokkijikoManager sut;

    public static class get認定調査特記事項のテスト extends TestBase {

        @Test
        public void 申請書管理番号_A001_認定調査依頼履歴番号_1を指定したとき_4件の要素を持つ認定調査特記事項Listが返る() {

            sut = new NinteichosaTokkijikoManager(createMockDac(create件数分のList(4)));

            ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("A001"));
            NinteichosaIraiRirekiNo 認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(1);
            assertThat(sut.get認定調査特記事項(申請書管理番号, 認定調査依頼履歴番号).size(), is(4));
        }

        private INinteichosaTokkijikoDac createMockDac(List<DbT5010NinteichosaTokkijikoEntity> list) {
            INinteichosaTokkijikoDac dac = mock(INinteichosaTokkijikoDac.class);
            when(dac.select(any(ShinseishoKanriNo.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(list);
            return dac;
        }

        private List<DbT5010NinteichosaTokkijikoEntity> create件数分のList(int 件数) {
            List<DbT5010NinteichosaTokkijikoEntity> list = new ArrayList<>();
            for (int i = 0; i < 件数; i++) {
                list.add(create認定調査特記事項Entity("A001", 1, "特記事項" + i));
            }
            return list;
        }
    }

    public static class get認定調査特記事項履歴のテスト extends TestBase {

        private ShinseishoKanriNo 申請書管理番号;

        @Override
        public void setUp() {
            申請書管理番号 = new ShinseishoKanriNo(new RString("A001"));
        }

        @Test
        public void DBからデータを3件取得した場合_3件の要素を持つ認定調査特記事項Collectionを返す() {
            sut = new NinteichosaTokkijikoManager(createMockDac(create件数分のList(3)));
            assertThat(sut.get認定調査特記事項履歴(申請書管理番号).size(), is(3));
        }

        @Test
        public void DBからデータを取得できなかった場合_空の認定調査特記事項Collectionを返す() {
            sut = new NinteichosaTokkijikoManager(createMockDac(Collections.EMPTY_LIST));
            assertThat(sut.get認定調査特記事項履歴(申請書管理番号).isEmpty(), is(true));
        }

        private INinteichosaTokkijikoDac createMockDac(List<DbT5010NinteichosaTokkijikoEntity> entities) {
            INinteichosaTokkijikoDac dac = mock(INinteichosaTokkijikoDac.class);
            when(dac.select(any(ShinseishoKanriNo.class))).thenReturn(entities);
            return dac;
        }

        private List<DbT5010NinteichosaTokkijikoEntity> create件数分のList(int 件数) {
            List<DbT5010NinteichosaTokkijikoEntity> list = new ArrayList<>();
            for (int i = 0; i < 件数; i++) {
                list.add(create認定調査特記事項Entity("A001", i, "特記事項"));
            }
            return list;
        }
    }

    public static class saveのテスト {

        @Test
        public void saveに成功した場合_trueを返す() {
            sut = new NinteichosaTokkijikoManager(createMockDac(1));
            assertThat(sut.save(create認定調査特記事項()), is(true));
        }

        @Test
        public void saveに失敗した場合_falseを返す() {
            sut = new NinteichosaTokkijikoManager(createMockDac(0));
            assertThat(sut.save(create認定調査特記事項()), is(false));
        }

        private INinteichosaTokkijikoDac createMockDac(int 更新件数) {
            INinteichosaTokkijikoDac dac = mock(INinteichosaTokkijikoDac.class);
            when(dac.insertOrUpdate(any(DbT5010NinteichosaTokkijikoEntity.class))).thenReturn(更新件数);
            return dac;
        }
    }

    public static class removeのテスト {

        @Test
        public void removeに成功した場合_trueを返す() {
            sut = new NinteichosaTokkijikoManager(createMockDac(1));
            assertThat(sut.remove(create認定調査特記事項()), is(true));
        }

        @Test
        public void removeに失敗した場合_falseを返す() {
            sut = new NinteichosaTokkijikoManager(createMockDac(0));
            assertThat(sut.remove(create認定調査特記事項()), is(false));
        }

        private INinteichosaTokkijikoDac createMockDac(int 削除件数) {
            INinteichosaTokkijikoDac dac = mock(INinteichosaTokkijikoDac.class);
            when(dac.delete(any(DbT5010NinteichosaTokkijikoEntity.class))).thenReturn(削除件数);
            return dac;
        }
    }

    private static NinteichosaTokkijiko create認定調査特記事項(String 申請書管理番号, int 認定調査依頼履歴番号,
            Code 原本マスク区分, String 特記事項) {
        return new NinteichosaTokkijiko(new ShinseishoKanriNo(new RString(申請書管理番号)),
                new NinteichosaIraiRirekiNo(認定調査依頼履歴番号), new RString("B001"), 原本マスク区分, new RString(特記事項));
    }

    private static NinteichosaTokkijiko create認定調査特記事項() {
        return create認定調査特記事項("A001", 1, new Code(new RString("1")), "特記事項を記入しましょう");
    }

    private static DbT5010NinteichosaTokkijikoEntity create認定調査特記事項Entity(String 申請書管理番号, int 認定調査依頼履歴番号, String 特記事項) {
        DbT5010NinteichosaTokkijikoEntity entity = new DbT5010NinteichosaTokkijikoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString(申請書管理番号)));
        entity.setNinteichosaRirekiNo(new NinteichosaIraiRirekiNo(認定調査依頼履歴番号));
        entity.setNinteichosaTokkijikoNo(new RString("B001"));
        entity.setGenponMaskKubun(new Code(new RString("1")));
        entity.setNinteichosaTokkijiko(new RString(特記事項));
        return entity;
    }
}
