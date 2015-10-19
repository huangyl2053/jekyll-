/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import jp.co.ndensan.reams.db.dbe.persistence.db.basic.GogitaiWariateDac;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * 合議体割当Dacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiWariateDacTest {

    private static GogitaiWariateDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(GogitaiWariateDac.class);
    }

    //TODO n8178 城間篤人 insertOrUpdate実装が完了後に改めてテスト 2014年3月末
//    public static class insertOrUpdateのテスト {
//    }
    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void insertに成功し_1が返る() {
            int result = sut.insert(create合議体割当Entity(1, "A0001", "19990101", "20010101"));
            assertThat(result, is(1));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Test
        public void updateに成功し_1が返る() {
            sut.insert(create合議体割当Entity(1, "A0001", "19990101", "99999999"));
            int result = sut.update(create合議体割当Entity(1, "A0001", "19990101", "20010101"));
            assertThat(result, is(1));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Test
        public void deleteに成功した場合_1が返る() {
            sut.insert(create合議体割当Entity(1, "A0001", "19990101", "99999999"));
            int result = sut.delete(create合議体割当Entity(1, "A0001", "19990101", "99999999"));
            assertThat(result, is(1));
        }
    }

    private static DbT5107GogitaiWariateIinJohoEntity create合議体割当Entity(int 合議体番号, String 割当委員コード, String 開始年月日, String 終了年月日) {
        DbT5107GogitaiWariateIinJohoEntity entity = new DbT5107GogitaiWariateIinJohoEntity();
        entity.setGogitaiNo(合議体番号);
        entity.setShinsakaiIinCode(new RString(割当委員コード));
        entity.setGogitaiYukoKikanKaishiYMD(new FlexibleDate(開始年月日));
        entity.setGogitaiYukoKikanShuryoYMD(new FlexibleDate(終了年月日));
        entity.setGogitaichoKubunCode(new Code(new RString("1")));
        entity.setShinsainKubunCode(new Code(new RString("1")));
        return entity;
    }
}
