/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.INinteiChosain;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;

/**
 * {@link ChosainJohoMapper}のテストクラスです。
 *
 * @author N2204 三井 沙織
 */
public class NinteiChosainMapperTest extends DbxTestBase {

    @Test
    public void 要素2件のChosainJohoEntityを渡すと_toNinteiChosainは_要素2件のINinteiChosainのリストに変換する() {
        ChosainJohoEntity ｃhosain1 = new ChosainJohoEntity();
        ｃhosain1.set介護事業者番号(new KaigoJigyoshaNo("1000000001"));
        ｃhosain1.set介護調査員番号(new RString("00000001"));
        ｃhosain1.set調査員氏名(new RString("氏名１"));
        ｃhosain1.set調査員氏名カナ(new RString("ｼﾒｲｶﾅ1"));

        ChosainJohoEntity ｃhosain2 = new ChosainJohoEntity();
        ｃhosain2.set介護事業者番号(new KaigoJigyoshaNo("1000000002"));
        ｃhosain2.set介護調査員番号(new RString("00000002"));
        ｃhosain2.set調査員氏名(new RString("氏名２"));
        ｃhosain2.set調査員氏名カナ(new RString("ｼﾒｲｶﾅ2"));

        List<ChosainJohoEntity> chosains = Arrays.asList(ｃhosain1, ｃhosain2);

        IKaigoJigyosha 所属事業者 = mock(IKaigoJigyosha.class);

        List<INinteiChosain> result = NinteiChosainMapper.toNinteiChosain(chosains, 所属事業者);
        assertThat(result.size(), is(2));
    }
    
    @Test
    public void LDNS_メソッドNinteiChosainMapperが呼び出される場合_NinteiChosainMapperは_インスタンス化成功() throws Exception {
        Constructor<NinteiChosainMapper> constructor = NinteiChosainMapper.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();      
    }
}
