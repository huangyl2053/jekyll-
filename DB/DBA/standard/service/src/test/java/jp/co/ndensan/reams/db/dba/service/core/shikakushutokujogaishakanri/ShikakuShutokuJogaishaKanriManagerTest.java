/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.shikakushutokujogaishakanri;

import jp.co.ndensan.reams.db.dba.entity.db.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1009ShikakuShutokuJogaishaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * 資格取得除外者管理の取得します
 */
@RunWith(Enclosed.class)
public class ShikakuShutokuJogaishaKanriManagerTest extends DbaTestDacBase {

    public static final ShikibetsuCode shikibetsuCode = new ShikibetsuCode("012345012345012");
    public static final LasdecCode shichosonCode = new LasdecCode("410222");
    public static final RString shikakuShutokuJogaiRiyu = new RString("1");
    public static final FlexibleDate shikakuShutokuJogaiYMD = new FlexibleDate("20150412");
    public static final FlexibleDate shikakuShutokuJogaiKaijoYMD = new FlexibleDate("20150112");
    public static final int rirekiNo = 1;
    private static ShikakuShutokuJogaishaKanriManager sut;
    private static DbT1009ShikakuShutokuJogaishaDac dac;

    @BeforeClass
    public static void setUpClass() {
        sut = ShikakuShutokuJogaishaKanriManager.createInstance();
        dac = InstanceProvider.create(DbT1009ShikakuShutokuJogaishaDac.class);

    }

    public static class KijuntsukiShichosonjohoFinderテスト extends DbaTestDacBase {

//
//        @Test
//        public void getTennyuHoryuTokuteiJushoIchiran() {
//            SearchResult<ShikakuShutokuJogaishaKanri> result = sut.getTennyuHoryuTokuteiJushoIchiran();
//            assertThat(result.records().size(), is(1));
//        }
//        @Test
//        public void updateShikakuShutokuJogaisha() {
//            insert_DbT1009ShikakuShutokuJogaisha();
//            ShikakuShutokuJogaishaKanriEntity shikakushutokujogaishakanrientity = new ShikakuShutokuJogaishaKanriEntity();
//            shikakushutokujogaishakanrientity.setShikibetsuCode(shikibetsuCode);
//            shikakushutokujogaishakanrientity.setShichosonCode(shichosonCode);
//            shikakushutokujogaishakanrientity.setRirekiNo(rirekiNo);
//            shikakushutokujogaishakanrientity.setShikakuShutokuJogaiRiyu(shikakuShutokuJogaiRiyu);
//            shikakushutokujogaishakanrientity.setShikakuShutokuJogaiYMD(shikakuShutokuJogaiYMD);
//            shikakushutokujogaishakanrientity.setShikakuShutokuJogaiKaijoYMD(shikakuShutokuJogaiKaijoYMD);
//            int count = sut.updateShikakuShutokuJogaisha(shikakushutokujogaishakanrientity);
//            assertThat(count, is(1));
//        }
//
        @Test
        public void 資格取得除外者登録のテスト() {
            ShikakuShutokuJogaishaKanriEntity shakanrientity = new ShikakuShutokuJogaishaKanriEntity();
            shakanrientity.setShikibetsuCode(new ShikibetsuCode("012345012345012"));
            shakanrientity.setShichosonCode(new LasdecCode("012345"));
            shakanrientity.setJuminJotaiCode(new RString("資格取得除外理由5"));
            shakanrientity.setShikakuShutokuJogaiKaijoYMD(new FlexibleDate("20160202"));
            shakanrientity.setShikakuShutokuJogaiYMD(new FlexibleDate("20160202"));
            int result = sut.insertShikakuShutokuJogaisha(shakanrientity);
            assertThat(result, is(1));

        }
//        @Test
//        public void delShikakuShutokuJogaisha() {
//            insert_DbT1009ShikakuShutokuJogaisha();
//            ShikakuShutokuJogaishaKanriEntity shikakushutokujogaishakanrientity = new ShikakuShutokuJogaishaKanriEntity();
//            shikakushutokujogaishakanrientity.setShikibetsuCode(shikibetsuCode);
//            shikakushutokujogaishakanrientity.setRirekiNo(rirekiNo);
//            int count = sut.delShikakuShutokuJogaisha(shikakushutokujogaishakanrientity);
//            assertThat(count, is(1));
//        }
//        @Test
//        public void jogaiKikanJufukuCheck() {
//            insert_DbT1009ShikakuShutokuJogaisha();
//            ShikakuShutokuJogaishaKanriEntity shikakushutokujogaishakanrientity = new ShikakuShutokuJogaishaKanriEntity();
//            shikakushutokujogaishakanrientity.setShikibetsuCode(shikibetsuCode);
//            shikakushutokujogaishakanrientity.setShichosonCode(shichosonCode);
//            shikakushutokujogaishakanrientity.setShikakuShutokuJogaiRiyu(shikakuShutokuJogaiRiyu);
//            shikakushutokujogaishakanrientity.setShikakuShutokuJogaiYMD(shikakuShutokuJogaiYMD);
//            shikakushutokujogaishakanrientity.setShikakuShutokuJogaiKaijoYMD(shikakuShutokuJogaiKaijoYMD);
//            boolean count = sut.jogaiKikanJufukuCheck(shikakushutokujogaishakanrientity);
//            assertThat(count, is(true));
//        }
    }
}
