/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.NinchishoKoreishaNichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.ShogaiKoreiNichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 * 意見書のテストクラスです。
 *
 * @author n3310 酒井 裕亮
 */
public class _IkenshoTest extends DbxTestBase {

    private static RDate 依頼年月日;
    private static RDate 受領年月日;
    private static ShogaiKoreiNichijoSeikatsuJiritsudo 障害高齢者の日常生活自立度;
    private static NinchishoKoreishaNichijoSeikatsuJiritsudo 認知症高齢者の日常生活自立度;

    @BeforeClass
    public static void setUpClass() {
        依頼年月日 = mock(RDate.class);
        受領年月日 = mock(RDate.class);
        障害高齢者の日常生活自立度 = ShogaiKoreiNichijoSeikatsuJiritsudo.A1;
        認知症高齢者の日常生活自立度 = NinchishoKoreishaNichijoSeikatsuJiritsudo.Ⅰ;
    }

    @Test(expected = NullPointerException.class)
    public void 依頼年月日がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
        new _Ikensho(null, 受領年月日, 障害高齢者の日常生活自立度, 認知症高齢者の日常生活自立度);
    }

    @Test(expected = NullPointerException.class)
    public void 受領年月日がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
        new _Ikensho(依頼年月日, null, 障害高齢者の日常生活自立度, 認知症高齢者の日常生活自立度);
    }

    @Test(expected = NullPointerException.class)
    public void 障害高齢者の日常生活自立度がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
        new _Ikensho(依頼年月日, 受領年月日, null, 認知症高齢者の日常生活自立度);
    }

    @Test(expected = NullPointerException.class)
    public void 認知症高齢者の日常生活自立度がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
        new _Ikensho(依頼年月日, 受領年月日, 障害高齢者の日常生活自立度, null);
    }

    @Test
    public void LDNS_クラスが実例化した場合_get依頼年月日は_設定された依頼年月日を返す() {
        IIkensho ikensho = new _Ikensho(依頼年月日, 受領年月日, 障害高齢者の日常生活自立度, 認知症高齢者の日常生活自立度);
        assertThat(ikensho.get依頼年月日(), is(依頼年月日));
    }

    @Test
    public void LDNS_クラスが実例化した場合_get受領年月日は_設定された受領年月日を返す() {
        IIkensho ikensho = new _Ikensho(依頼年月日, 受領年月日, 障害高齢者の日常生活自立度, 認知症高齢者の日常生活自立度);
        assertThat(ikensho.get受領年月日(), is(受領年月日));
    }

    @Test
    public void LDNS_クラスが実例化した場合_get障害高齢者日常生活自立度は_設定された障害高齢者日常生活自立度を返す() {
        IIkensho ikensho = new _Ikensho(依頼年月日, 受領年月日, 障害高齢者の日常生活自立度, 認知症高齢者の日常生活自立度);
        assertThat(ikensho.get障害高齢者日常生活自立度(), is(障害高齢者の日常生活自立度));
    }

    @Test
    public void LDNS_クラスが実例化した場合_get認知症高齢者日常生活自立度は_設定された認知症高齢者日常生活自立度を返す() {
        IIkensho ikensho = new _Ikensho(依頼年月日, 受領年月日, 障害高齢者の日常生活自立度, 認知症高齢者の日常生活自立度);
        assertThat(ikensho.get認知症高齢者日常生活自立度(), is(認知症高齢者の日常生活自立度));
    }
}
