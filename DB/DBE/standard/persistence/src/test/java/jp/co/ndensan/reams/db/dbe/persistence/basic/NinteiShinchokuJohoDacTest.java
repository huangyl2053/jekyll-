/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoMock;
import jp.co.ndensan.reams.db.dbe.persistence.basic.helper.NinteiShinchokuJohoDacMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
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

    private static NinteiShinchokuJohoDac sut;
    private static NinteiShinchokuJohoDacMock ninteiShinchokuJohoDacMock;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(NinteiShinchokuJohoDac.class);
        ninteiShinchokuJohoDacMock = InstanceProvider.create(NinteiShinchokuJohoDacMock.class);
    }

    public static class update_戻り値が1 extends DbeTestDacBase {

        @Test
        public void updateに成功し_1が返る() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0001"), new FlexibleDate("00000000"), new FlexibleDate("00000000")));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0002"), new FlexibleDate("20140101"), new FlexibleDate("20140102")));
            int result = sut.update(create認定進捗情報Entity(new RString("0001"), new FlexibleDate("20140101"), new FlexibleDate("00000000")));
            assertThat(result, is(1));
        }
    }

    public static class update_DB登録が更新される extends DbeTestDacBase {

        @Test
        public void updateに成功し_select認定調査未完了で取得した認定進捗情報の_認定調査依頼完了年月日が_20140101に変更される() {
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0001"), new FlexibleDate("00000000"), new FlexibleDate("00000000")));
            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(new RString("0002"), new FlexibleDate("20140101"), new FlexibleDate("20140102")));
            sut.update(create認定進捗情報Entity(new RString("0001"), new FlexibleDate("20140101"), new FlexibleDate("00000000")));
            assertThat(sut.select認定調査未完了().get(0).getNinteichosaIraiKanryoYMD().toString(), is("20140101"));
        }
    }

    private static DbT5005NinteiShinchokuJohoEntity create認定進捗情報Entity(RString 申請書管理番号, FlexibleDate 認定調査依頼完了年月日, FlexibleDate 認定調査完了年月日) {
        DbT5005NinteiShinchokuJohoEntity entity = NinteiShinchokuJohoMock.create認定進捗情報Entity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
        entity.setNinteichosaIraiKanryoYMD(認定調査依頼完了年月日);
        entity.setNinteichosaKanryoYMD(認定調査完了年月日);
        return entity;
    }
}
