/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5001NinteiShinseiJohoEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class YokaigoNinteiShinseiDacTest extends DbeTestDacBase {

    private static YokaigoNinteiShinseiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(YokaigoNinteiShinseiDac.class);
    }

    public static class insert extends DbeTestDacBase {

        @Before
        public void setUp() {
        }

        @Test
        public void insertは_成功した時_1を返す() {
            DbT5001NinteiShinseiJohoEntity data = createEntity(new ShinseishoKanriNo(new RString("0")));
            assertThat(sut.insert(data), is(1));
        }
    }

    public static class select extends DbeTestDacBase {

        private ShinseishoKanriNo shinseishoKanriNo;

        @Before
        public void setUp() {
            shinseishoKanriNo = new ShinseishoKanriNo(new RString("0"));
            sut.insert(createEntity(shinseishoKanriNo));
        }

        @Test
        public void selectFromKeyは_引数にレコードの存在するShinseishoKanriNoを渡した時_同じ値を持ったDbT5001NinteiShinseiJohoEntityを返す() {
            DbT5001NinteiShinseiJohoEntity selected = sut.selectFromKey(shinseishoKanriNo);
            assertThat(selected.getShinseishoKanriNo(), is(shinseishoKanriNo));
        }

        @Test
        public void selectFromKeyは_引数にレコードの存在しないShinseishoKanriNoを渡した時_nullを返す() {
            DbT5001NinteiShinseiJohoEntity selected = sut.selectFromKey(new ShinseishoKanriNo(new RString("1")));
            assertThat(selected, is(nullValue()));
        }
    }

    private static DbT5001NinteiShinseiJohoEntity createEntity(ShinseishoKanriNo shinseishoKanriNo) {
        DbT5001NinteiShinseiJohoEntity entity = DbT5001NinteiShinseiJohoEntityMock.getEntity();
        entity.setShinseishoKanriNo(shinseishoKanriNo);
        return entity;
    }

    public static class insertOrUpdate extends DbeTestDacBase {

        private ShinseishoKanriNo shinseishoKanriNo;

        @Before
        public void setUp() {
            shinseishoKanriNo = new ShinseishoKanriNo(new RString("0"));
            sut.insert(createEntity(shinseishoKanriNo));
        }

        @Test
        public void insertOrUpdateは_あるkeyでselectしたentityのNinteiShinseiYMDを変更して渡した時_変更した内容でレコードを更新する() {
            DbT5001NinteiShinseiJohoEntity recode = sut.selectFromKey(shinseishoKanriNo);
            FlexibleDate shinseiDate = recode.getNinteiShinseiYMD().plusYear(1);
            recode.setNinteiShinseiYMD(shinseiDate);
            sut.insertOrUpdate(recode);
            DbT5001NinteiShinseiJohoEntity updated = sut.selectFromKey(shinseishoKanriNo);
            assertThat(updated.getNinteiShinseiYMD(), is(shinseiDate));
        }

        @Test
        public void insertOrUpdateは_ある存在しないkeyを持ったentityを渡した時_insertする() {
            ShinseishoKanriNo key = new ShinseishoKanriNo(new RString("1"));
            DbT5001NinteiShinseiJohoEntity recode = createEntity(key);
            sut.insertOrUpdate(recode);
            DbT5001NinteiShinseiJohoEntity selected = sut.selectFromKey(key);
            assertThat(selected.getShinseishoKanriNo(), is(key));
        }
    }

}
