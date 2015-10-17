/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.ICareManager;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;

/**
 * {@link CareManagerMapper}のテストクラスです。
 *
 * @author n9944 趙 春暉
 */
public class CareManagerMapperTest extends DbxTestBase {

    @Test
    public void 要素2件のCareManagerEntityのリストを_toCareManagerが_要素2件ICareManagerのリストに変換する() {
        DbT7064CareManegerEntity careManager1 = TestUtil.createCareManagerEntity(new RString("0000000001"));
        DbT7064CareManegerEntity careManager2 = TestUtil.createCareManagerEntity(new RString("0000000002"));
        List<DbT7064CareManegerEntity> input = Arrays.asList(careManager1, careManager2);

        IKaigoJigyosha 事業者 = mock(IKaigoJigyosha.class);

        List<ICareManager> result = CareManagerMapper.toCareManager(input, 事業者);
        assertThat(result.size(), is(2));
    }

    @Test
    public void CareManagerEntityの有効開年月日が20120101_20120103の場合_toCareManagerが_ICareManagerの有効開年月日は20120101_20120103を返す() {
        DbT7064CareManegerEntity careManager1 = TestUtil.createCareManagerEntity(new RString("0000000001"));
        DbT7064CareManegerEntity careManager2 = TestUtil.createCareManagerEntity(new RString("0000000002"));
        List<DbT7064CareManegerEntity> input = Arrays.asList(careManager1, careManager2);

        IKaigoJigyosha 事業者 = mock(IKaigoJigyosha.class);

        List<ICareManager> result = CareManagerMapper.toCareManager(input, 事業者);
        assertThat(result.get(0).get有効年月日(), is(new Range(new FlexibleDate("20120101"), new FlexibleDate("20120103"))));
    }
    
    @Test
    public void LDNS_メソッドCareManagerMapperが呼び出される場合_CareManagerMapperは_インスタンス化成功() throws Exception {
        Constructor<CareManagerMapper> constructor = CareManagerMapper.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    private static final class TestUtil {

        static DbT7064CareManegerEntity createCareManagerEntity(RString 介護支援専門員番号) {
            DbT7064CareManegerEntity result = new DbT7064CareManegerEntity();
            result.setKaigoShienSenmoninNo(介護支援専門員番号);
            result.setKaigoShienSenmoninMei(new AtenaMeisho("氏名"));
            result.setKaigoShienSenmoninMeiKana(new AtenaKanaMeisho("ｼﾒｲｶﾅ"));
            result.setShozokuJigyoshaNo(new KaigoJigyoshaNo("9999999999"));
            result.setYukoKaishiDate(new FlexibleDate("20120101"));
            result.setYukoShuryoDate(new FlexibleDate("20120103"));
            return result;
        }
    }
}
