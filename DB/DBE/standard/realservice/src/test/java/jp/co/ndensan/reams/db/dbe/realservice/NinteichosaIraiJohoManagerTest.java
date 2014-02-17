/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteichosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5006NinteichosaIraiJohoEntity;
import static jp.co.ndensan.reams.db.dbe.realservice.helper.NinteichosaIraiJohoTestHelper.*;
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
 * 認定調査依頼情報Managerのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiJohoManagerTest extends TestBase {

    private static NinteichosaIraiJohoManager sut;

    public static class get認定調査依頼情報のテスト extends TestBase {

        private ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("004"));
        private int 認定調査依頼履歴番号 = 8;

        @Override
        public void setUp() {
            sut = new NinteichosaIraiJohoManager(createDac(申請書管理番号, 認定調査依頼履歴番号));
        }

        @Test
        public void 申請書管理番号_004_認定調査依頼履歴番号_8を指定したとき_申請書管理番号に004を持つ認定調査依頼情報が返る() {
            assertThat(sut.get認定調査依頼情報(申請書管理番号, 認定調査依頼履歴番号).get申請書管理番号(), is(申請書管理番号));
        }

        @Test
        public void 申請書管理番号_004_認定調査依頼履歴番号_8を指定したとき_認定調査依頼履歴番号に8を持つ認定調査依頼情報が返る() {
            assertThat(sut.get認定調査依頼情報(申請書管理番号, 認定調査依頼履歴番号).get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }

        @Test
        public void 検索した結果_該当する項目が存在しなかった場合_nullが返る() {
            INinteichosaIraiJohoDac dac = mock(INinteichosaIraiJohoDac.class);
            when(dac.select(申請書管理番号, 認定調査依頼履歴番号)).thenReturn(null);
            sut = new NinteichosaIraiJohoManager(dac);
            assertThat(sut.get認定調査依頼情報(申請書管理番号, 認定調査依頼履歴番号), is(nullValue()));
        }

        private INinteichosaIraiJohoDac createDac(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号) {
            INinteichosaIraiJohoDac dac = mock(INinteichosaIraiJohoDac.class);
            when(dac.select(申請書管理番号, 認定調査依頼履歴番号)).thenReturn(create認定調査依頼情報Entity(申請書管理番号, 認定調査依頼履歴番号));
            return dac;
        }
    }

    public static class get認定調査依頼情報履歴のテスト extends TestBase {

        private ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(new RString("004"));

        @Override
        public void setUp() {
            sut = new NinteichosaIraiJohoManager(createDac(4, 申請書管理番号));
        }

        @Test
        public void Entityを4件持つリストを渡したとき_4件の要素を持つコレクションが返る() {
            assertThat(sut.get認定調査依頼情報履歴(申請書管理番号).size(), is(4));
        }

        @Test
        public void Dacからnullが返ってきたとき_空のコレクションが返る() {
            INinteichosaIraiJohoDac dac = mock(INinteichosaIraiJohoDac.class);
            when(dac.select(申請書管理番号)).thenReturn(null);
            sut = new NinteichosaIraiJohoManager(dac);
            assertThat(sut.get認定調査依頼情報履歴(申請書管理番号).isEmpty(), is(true));
        }

        @Test
        public void Dacから空のリストが返ってきたとき_空のコレクションが返る() {
            INinteichosaIraiJohoDac dac = mock(INinteichosaIraiJohoDac.class);
            when(dac.select(申請書管理番号)).thenReturn(Collections.EMPTY_LIST);
            sut = new NinteichosaIraiJohoManager(dac);
            assertThat(sut.get認定調査依頼情報履歴(申請書管理番号).isEmpty(), is(true));
        }

        private INinteichosaIraiJohoDac createDac(int 要素数, ShinseishoKanriNo 申請書管理番号) {
            INinteichosaIraiJohoDac dac = mock(INinteichosaIraiJohoDac.class);
            when(dac.select(申請書管理番号)).thenReturn(createList(要素数, 申請書管理番号));
            return dac;
        }

        private List<DbT5006NinteichosaIraiJohoEntity> createList(int 要素数, ShinseishoKanriNo 申請書管理番号) {
            List<DbT5006NinteichosaIraiJohoEntity> list = new ArrayList<>();
            for (int i = 0; i < 要素数; i++) {
                list.add(create認定調査依頼情報Entity(申請書管理番号, i));
            }
            return list;
        }
    }

    public static class saveのテスト extends TestBase {

        @Override
        public void setUp() {
            sut = new NinteichosaIraiJohoManager(createDac(1));
        }

        @Test
        public void saveに成功したとき_trueが返る() {
            sut = new NinteichosaIraiJohoManager(createDac(1));
            assertThat(sut.save(create認定調査依頼情報()), is(true));
        }

        @Test
        public void saveに失敗したとき_trueが返る() {
            sut = new NinteichosaIraiJohoManager(createDac(0));
            assertThat(sut.save(create認定調査依頼情報()), is(false));
        }

        private INinteichosaIraiJohoDac createDac(int 件数) {
            INinteichosaIraiJohoDac dac = mock(INinteichosaIraiJohoDac.class);
            when(dac.insertOrUpdate(any(DbT5006NinteichosaIraiJohoEntity.class))).thenReturn(件数);
            return dac;
        }
    }
}
