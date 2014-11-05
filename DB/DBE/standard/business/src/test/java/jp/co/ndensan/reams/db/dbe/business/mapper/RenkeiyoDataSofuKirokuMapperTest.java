/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.mapper.RenkeiyoDataSofuKirokuMapper;
import jp.co.ndensan.reams.db.dbe.business.RenkeiyoDataSofuKiroku;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5022RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;

/**
 * RenkeiyoDataSofuKirokuMapperのテストクラスです。
 *
 * @author n8107
 */
@RunWith(Enclosed.class)
public class RenkeiyoDataSofuKirokuMapperTest extends TestBase {

    public static class toRenkeiyoDataSofuKirokui extends TestBase {

        private ShinseishoKanriNo 申請書管理番号;
        private YMDHMS 処理日時;
        private KaigoHihokenshaNo 被保険者番号;
        private RString 認定申請時区分;
        private RString 引渡し区分;
        private RDateTime 引渡し日時;
        private RString 再送付区分;
        private RString 再調査送付区分;
        private RString 再意見書送付区分;
        private RenkeiyoDataSofuKiroku sut;

        @Override
        public void setUp() {
            申請書管理番号 = new ShinseishoKanriNo(new RString("100000001"));
            処理日時 = new YMDHMS(new RString("20140808102030"));
            被保険者番号 = new KaigoHihokenshaNo(new RString("1234567890"));
            認定申請時区分 = new RString("01");
            引渡し区分 = new RString("1");
            引渡し日時 = RDateTime.of(2014, 03, 14, 18, 45, 59);
            再送付区分 = new RString("01");
            再調査送付区分 = new RString("0");
            再意見書送付区分 = new RString("0");
            sut = RenkeiyoDataSofuKirokuMapper.toRenkeiyoDataSofuKiroku(create連携用送付記録Entity());
        }

        @Test
        public void 引き渡した申請書管理番号と_toRenkeiyoDataSofuKirokui_の結果は一致する() {
            assertThat(sut.get申請書管理番号().value(), is(申請書管理番号.value()));
        }

        @Test
        public void 引き渡した処理日時と_toRenkeiyoDataSofuKirokui_の結果は一致する() {
            assertThat(sut.get処理日時(), is(処理日時));
        }

        @Test
        public void 引き渡した被保険者番号と_toRenkeiyoDataSofuKirokui_の結果は一致する() {
            assertThat(sut.get被保険者番号().getColumnValue(), is(被保険者番号.getColumnValue()));
        }

        @Test
        public void 引き渡した認定申請時区分とtoRenkeiyoDataSofuKirokuiの結果は一致する() {
            assertThat(sut.get認定申請時区分().getCode(), is(認定申請時区分));
        }

        @Test
        public void 引き渡した引渡し区分とtoRenkeiyoDataSofuKirokuiの結果は一致する() {
            assertThat(sut.get引渡し区分().getCode(), is(引渡し区分));
        }

        @Test
        public void 引き渡した引渡し日時とtoRenkeiyoDataSofuKirokuiの結果は一致する() {
            assertThat(sut.get引渡し日時(), is(RDateTime.of(2014, 03, 14, 18, 45, 59)));
        }

        @Test
        public void 引き渡した再送付区分とtoRenkeiyoDataSofuKirokuiの結果は一致する() {
            assertThat(sut.get再送付区分().getCode(), is(再送付区分));
        }

        @Test
        public void 引き渡した再調査送付区分とtoRenkeiyoDataSofuKirokuiの結果は一致する() {
            assertThat(sut.get再調査送付区分().getCode(), is(再調査送付区分));
        }

        @Test
        public void 引き渡した再意見書送付区分とtoRenkeiyoDataSofuKirokuiの結果は一致する() {
            assertThat(sut.get再意見書送付区分().getCode(), is(再意見書送付区分));
        }

        private DbT5022RenkeiyoDataSofuKirokuEntity create連携用送付記録Entity() {
            DbT5022RenkeiyoDataSofuKirokuEntity entity = new DbT5022RenkeiyoDataSofuKirokuEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setShoriTimestamp(処理日時);
            entity.setHihokenshaNo(被保険者番号);
            entity.setNinteiShinseiShinseijiKubun(認定申請時区分);
            entity.setHikiwatashiKubun(引渡し区分);
            entity.setHikiwatashiNichiji(引渡し日時);
            entity.setSaiSoufuKubun(再送付区分);
            entity.setSaiChousaSoufuKubun(再調査送付区分);
            entity.setSaiIkenshoSoufuKubun(再意見書送付区分);
            return entity;
        }
    }
}
