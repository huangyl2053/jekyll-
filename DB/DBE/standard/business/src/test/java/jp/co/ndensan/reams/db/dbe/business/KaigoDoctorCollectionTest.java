/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.business.IDoctor;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 介護医師情報のコレクションを扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KaigoDoctorCollectionTest extends DbeTestBase {

    public static class コンストラクタ extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 介護医師リストがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new KaigoDoctorCollection(null);
        }
    }

    public static class get介護医師 extends DbeTestBase {

        @Test
        public void 介護医師情報が存在する時_get介護医師は_該当の介護医師情報を返す() {
            KaigoDoctorCollection sut = createKaigoDoctorList();
            assertThat(sut.get介護医師(createShichosonCode("000002"), createKaigoIryoKikanCode("K00A"), createKaigoDoctorCode("I0A2")).get介護医師コード().value(), is(new RString("I0A2")));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 証記載保険者番号が該当しない時_get介護医師は_IllegalArgumentExceptionを投げる() {
            KaigoDoctorCollection sut = createKaigoDoctorList();
            sut.get介護医師(createShichosonCode("000999"), createKaigoIryoKikanCode("K00A"), createKaigoDoctorCode("I0A2"));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 介護医療機関コードが該当しない時_get介護医師は_IllegalArgumentExceptionを投げる() {
            KaigoDoctorCollection sut = createKaigoDoctorList();
            sut.get介護医師(createShichosonCode("000002"), createKaigoIryoKikanCode("K999"), createKaigoDoctorCode("I0A2"));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 介護医師コードが該当しない時_get介護医師は_IllegalArgumentExceptionを投げる() {
            KaigoDoctorCollection sut = createKaigoDoctorList();
            sut.get介護医師(createShichosonCode("000002"), createKaigoIryoKikanCode("K00A"), createKaigoDoctorCode("I999"));
        }
    }

    public static class sub介護医師List extends DbeTestBase {

        @Test
        public void 介護医師情報が存在する時_sub介護医師Listは_該当の介護医師情報を返す() {
            KaigoDoctorCollection sut = createKaigoDoctorList();
            assertThat(sut.sub介護医師List(createKaigoIryoKikanCode("K00A")).size(), is(2));
        }

        @Test
        public void 介護医師情報が存在しない時_sub介護医師Listは_空のListを返す() {
            KaigoDoctorCollection sut = createKaigoDoctorList();
            assertThat(sut.sub介護医師List(createKaigoIryoKikanCode("K999")).size(), is(0));
        }
    }

    public static class isEmpty extends DbeTestBase {

        @Test
        public void 介護医師情報が存在する時_isEmptyは_FALSEを返す() {
            KaigoDoctorCollection sut = createKaigoDoctorList();
            assertThat(sut.isEmpty(), is(false));
        }

        @Test
        public void 介護医師情報が存在しない時_isEmptyは_TRUEを返す() {
            KaigoDoctorCollection sut = new KaigoDoctorCollection(new ArrayList<KaigoDoctor>());
            assertThat(sut.isEmpty(), is(true));
        }
    }

    private static KaigoDoctorCollection createKaigoDoctorList() {
        List<KaigoDoctor> list = new ArrayList<>();
        list.add(createKaigoDoctor("000001", "K00A", "I0A1"));
        list.add(createKaigoDoctor("000002", "K00A", "I0A2"));
        list.add(createKaigoDoctor("000003", "K00B", "I0B1"));
        return new KaigoDoctorCollection(list);
    }

    private static KaigoDoctor createKaigoDoctor(String 市町村コード, String 介護医療機関コード, String 介護医師コード) {
        return new KaigoDoctor(
                mock(IDoctor.class),
                new Shujii(
                        createShichosonCode(市町村コード),
                        createKaigoIryoKikanCode(介護医療機関コード),
                        createKaigoDoctorCode(介護医師コード),
                        mock(IIryoKikanCode.class), new RString("1234"), IshiJokyo.有効,
                        mock(YubinNo.class), mock(AtenaJusho.class), mock(TelNo.class), new RString("0123456789")),
                mock(KaigoIryoKikan.class));
    }

    private static LasdecCode createShichosonCode(String code) {
        return new LasdecCode(new RString(code));
    }

    private static KaigoIryoKikanCode createKaigoIryoKikanCode(String code) {
        return new KaigoIryoKikanCode(new RString(code));
    }

    private static KaigoDoctorCode createKaigoDoctorCode(String code) {
        return new KaigoDoctorCode(new RString(code));
    }
}
