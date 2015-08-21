/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import jp.co.ndensan.reams.db.dbx.business.IKobetsuJikoKaigoJukyu;
import jp.co.ndensan.reams.db.dbx.entity.basic.KaigohokenJukyushaEntity;
import jp.co.ndensan.reams.db.dbx.entity.relate.KaigohokenJukyushaAndKojinEntity;
import jp.co.ndensan.reams.db.dbx.persistence.relate.IKaigoHokenJukyushaDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link _JukyuDaichoFinder}のテストクラスです。
 *
 * @author N2218 村松 優
 */
public class _JukyuDaichoFinderTest extends DbxTestBase {

    private _JukyuDaichoFinder sut;
    private IKaigoHokenJukyushaDac KaigoJukyuDac;
    private ShikibetsuCode 識別コード;
    private RDate 基準日;

    @Before
    public void setUp() {
        KaigoJukyuDac = mock(IKaigoHokenJukyushaDac.class);
        識別コード = new ShikibetsuCode(new RString("00000000"));
        基準日 = new RDate("20130101");
    }

    @Test(expected = NullPointerException.class)
    public void 識別コードがnullの場合_get個別事項は_NullPointerExceptionを返す() {
        sut = new _JukyuDaichoFinder(KaigoJukyuDac);
        sut.get個別事項介護受給(null, 基準日);
    }

    @Test(expected = NullPointerException.class)
    public void 基準日がnullの場合_get個別事項は_NullPointerExceptionを返す() {
        sut = new _JukyuDaichoFinder(KaigoJukyuDac);
        sut.get個別事項介護受給(識別コード, null);
    }

    @Test
    public void LDNS_get個別事項介護受給呼び出し場合_get個別事項介護受給は＿基準日を戻す() {
        IKaigoHokenJukyushaDac KaigoJukyuDac1 = mock(IKaigoHokenJukyushaDac.class);
        KaigohokenJukyushaEntity kaigohokenJukyushaEntity = new KaigohokenJukyushaEntity();
        KaigohokenJukyushaAndKojinEntity entity = new KaigohokenJukyushaAndKojinEntity(kaigohokenJukyushaEntity, null);
        entity.getKaigohokenJukyushaEntity().set認定年月日(基準日);
        entity.getKaigohokenJukyushaEntity().set要介護状態区分(new RString("01"));
        entity.getKaigohokenJukyushaEntity().set有効開始年月日(new RDate("20130101"));
        entity.getKaigohokenJukyushaEntity().set有効終了年月日(new RDate("20130111"));
        entity.getKaigohokenJukyushaEntity().set審査会意見(new RString("ABCD"));
        entity.getKaigohokenJukyushaEntity().set異動年月日(new RDate("20130211"));
        entity.getKaigohokenJukyushaEntity().set特定疾病(new RString("ABCDE"));
        ShikibetsuCode 識別コード1 = new ShikibetsuCode(new RString("00000000"));
        RDate 基準日1 = new RDate("20130101");
        _JukyuDaichoFinder sut1 = new _JukyuDaichoFinder(KaigoJukyuDac1);
        when(KaigoJukyuDac1.select(new RString("00000000"), 基準日1)).thenReturn(entity);
        assertThat(sut1.get個別事項介護受給(識別コード1, 基準日1), instanceOf(IKobetsuJikoKaigoJukyu.class));
    }

    @Test
    public void LDNS_データがない場合_get個別事項介護受給は＿nullを戻す() {
        IKaigoHokenJukyushaDac KaigoJukyuDac1 = mock(IKaigoHokenJukyushaDac.class);
        ShikibetsuCode 識別コード1 = new ShikibetsuCode(new RString("00000000"));
        RDate 基準日1 = new RDate("20130101");
        _JukyuDaichoFinder sut1 = new _JukyuDaichoFinder(KaigoJukyuDac1);
        when(KaigoJukyuDac1.select(new RString("00000000"), 基準日1)).thenReturn(null);
        assertThat(sut1.get個別事項介護受給(識別コード1, 基準日1), is((IKobetsuJikoKaigoJukyu) null));
    }
}
