/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.helper.NinteiShinchokuJohoDacMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定進捗情報Dacのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteiShinchokuJohoDacTest extends DbeTestDacBase {

    private static INinteiShinchokuJohoDac sut;
    private static NinteiShinchokuJohoDacMock ninteiShinchokuJohoDacMock;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceCreator.create(INinteiShinchokuJohoDac.class);
        ninteiShinchokuJohoDacMock = InstanceCreator.injectAspect(NinteiShinchokuJohoDacMock.class);
    }

    public static class select依頼済認定調査未完了_0件 extends DbeTestDacBase {

        @Before
        public void setUp() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0001"), new FlexibleDate("00000000"), new FlexibleDate("00000000")));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0002"), new FlexibleDate("20140101"), new FlexibleDate("20140102")));
        }

        @Test
        public void 認定調査依頼済みで未完了が0件のとき_0件のリストが返る() {
            assertThat(sut.select依頼済認定調査未完了().isEmpty(), is(true));
        }
    }

    public static class select依頼済認定調査未完了_1件 extends DbeTestDacBase {

        @Before
        public void setUp() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0001"), new FlexibleDate("00000000"), new FlexibleDate("00000000")));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0002"), new FlexibleDate("20140101"), new FlexibleDate("20140102")));
        }

        @Test
        public void 認定調査依頼済みで未完了が1件のとき_1件のリストが返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0003"), new FlexibleDate("20140101"), new FlexibleDate("00000000")));
            assertThat(sut.select依頼済認定調査未完了().size(), is(1));
        }
    }

    public static class select依頼済認定調査未完了_2件 extends DbeTestDacBase {

        @Before
        public void setUp() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0001"), new FlexibleDate("00000000"), new FlexibleDate("00000000")));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0002"), new FlexibleDate("20140101"), new FlexibleDate("20140102")));
        }

        @Test
        public void 認定調査依頼済みで未完了が2件のとき_2件のリストが返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0003"), new FlexibleDate("20140101"), new FlexibleDate("00000000")));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0004"), new FlexibleDate("20140101"), new FlexibleDate("00000000")));
            assertThat(sut.select依頼済認定調査未完了().size(), is(2));
        }
    }

    private static DbT5005NinteiShinchokuJohoEntity create認定進捗情報Entity(RString 申請書管理番号, FlexibleDate 認定調査依頼完了年月日, FlexibleDate 認定調査完了年月日) {
        FlexibleDate testDate = new FlexibleDate("20140101");

        DbT5005NinteiShinchokuJohoEntity entity = new DbT5005NinteiShinchokuJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
        entity.setNinteiShinseiJohoTorokuYMD(testDate);
        entity.setEnkitsuchiDoiUmuKubun(true);
        entity.setEnkitsuchiHakkoYMD(testDate);
        entity.setEnkitsuchiHakkoKaisu(1);
        entity.setNinteiEnkiRuyu(new RString("延期理由"));
        entity.setIchijihanteiChushutsuYMD(testDate);
        entity.setIraiJohoSoshinYMD(testDate);
        entity.setIchijihanteiChushutsuYMD(testDate);
        entity.setIraiJohoSoshinYMD(testDate);
        entity.setNinteichosaIraiKanryoYMD(認定調査依頼完了年月日);
        entity.setNinteichosaKanryoYMD(認定調査完了年月日);
        entity.setIkenshoSakuseiIraiKanryoYMD(testDate);
        entity.setIkenshoTorokuKanryoYMD(testDate);
        entity.setIchijiHanteiKanryoYMD(testDate);
        entity.setIchiGoHanteiKanryoYMD(testDate);
        entity.setNinteiShinsakaiWariateKanryoYMD(testDate);
        entity.setNinteiShinsakaiKanryoYMD(testDate);
        entity.setCenterSoshinYMD(testDate);
        return entity;
    }
}
