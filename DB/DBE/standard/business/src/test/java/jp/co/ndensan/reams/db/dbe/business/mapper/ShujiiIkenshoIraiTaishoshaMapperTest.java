/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.mapper.ShujiiIkenshoIraiTaishoshaMapper;
import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiProgress;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.YokaigoNinteiShinseiTestHelper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;

/**
 * 主治医意見書作成依頼対象者のビジネスクラスとエンティティの変換を行うMapperのテストクラスです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoIraiTaishoshaMapperTest extends DbeTestBase {

    private static ShujiiIkenshoIraiTaishosha sut;
    private static YokaigoNinteiProgress 認定進捗情報;
    private static YokaigoNinteiShinsei 認定申請情報;
    private static IKojin 個人;
    private static RString 氏名;
    private static RString 住所;
    private static KaigoIryoKikan 主治医医療機関;
    private static KaigoDoctor 主治医;

    public static class ConstructorTest extends DbeTestBase {

        @Before
        public void setUp() {
            認定進捗情報 = mock(YokaigoNinteiProgress.class);
            認定申請情報 = mock(YokaigoNinteiShinsei.class);
            個人 = mock(IKojin.class);
            氏名 = new RString("あああ");
            住所 = new RString("長野市");
            主治医医療機関 = mock(KaigoIryoKikan.class);
            主治医 = mock(KaigoDoctor.class);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの認定進捗情報に_Nullを指定した場合_NullPointerExceptionが発生する() {
            認定進捗情報 = null;
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定進捗情報, 認定申請情報, 個人, 氏名, 住所, 主治医医療機関, 主治医);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの認定申請情報に_Nullを指定した場合_NullPointerExceptionが発生する() {
            認定申請情報 = null;
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定進捗情報, 認定申請情報, 個人, 氏名, 住所, 主治医医療機関, 主治医);
        }
    }

    public static class toShujiiIkenshoIraiTaishoshaTest extends DbeTestBase {

        @Before
        public void setUp() {
            認定進捗情報 = NinteiShinchokuJohoMock.create認定進捗情報();
            認定申請情報 = YokaigoNinteiShinseiTestHelper.create認定申請情報();
            個人 = mock(IKojin.class);
            氏名 = new RString("あああ");
            住所 = new RString("長野市");
            主治医医療機関 = mock(KaigoIryoKikan.class);
            主治医 = mock(KaigoDoctor.class);
        }

        @Test
        public void 引き渡した_認定申請情報の申請書管理番号_とtoShujiiIkenshoIraiTaishoshaの結果は一致する() {
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定進捗情報, 認定申請情報, 個人, 氏名, 住所, 主治医医療機関, 主治医);
            assertThat(sut.get申請書管理番号(), is(認定申請情報.get申請書管理番号()));
        }

        @Test
        public void 引き渡した_認定申請情報の証記載保険者番号_とtoShujiiIkenshoIraiTaishoshaの結果は一致する() {
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定進捗情報, 認定申請情報, 個人, 氏名, 住所, 主治医医療機関, 主治医);
            assertThat(sut.get証記載保険者番号(), is(認定申請情報.get証記載保険者番号()));
        }

        @Test
        public void 引き渡した_認定申請情報の被保険者番号_とtoShujiiIkenshoIraiTaishoshaの結果は一致する() {
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定進捗情報, 認定申請情報, 個人, 氏名, 住所, 主治医医療機関, 主治医);
            assertThat(sut.get被保険者番号(), is(認定申請情報.get被保番号()));
        }

        @Test
        public void 引き渡した_認定申請情報の認定申請年月日_とtoShujiiIkenshoIraiTaishoshaの結果は一致する() {
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定進捗情報, 認定申請情報, 個人, 氏名, 住所, 主治医医療機関, 主治医);
            assertThat(sut.get認定申請年月日(), is(認定申請情報.get認定申請年月日()));
        }

        @Test
        public void 引き渡した_認定申請情報の認定申請区分_とtoShujiiIkenshoIraiTaishoshaの結果は一致する() {
            sut = ShujiiIkenshoIraiTaishoshaMapper.toShujiiIkenshoIraiTaishosha(
                    認定進捗情報, 認定申請情報, 個人, 氏名, 住所, 主治医医療機関, 主治医);
            assertThat(sut.get認定申請区分(), is(認定申請情報.get認定申請区分_申請時()));
        }
    }
}
