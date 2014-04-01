/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.YokaigoninteiDateConstants;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.INinteichosaItakusakiDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiChosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinchokuJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.INinteiChosaIraiTaishoshaDac;
import jp.co.ndensan.reams.db.dbe.realservice.helper.KojinEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urf.persistence.basic.IChosainJohoDac;
import jp.co.ndensan.reams.ur.urf.persistence.basic.IKaigoJigyoshaDac;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.realservice.KojinService;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼対象者情報を管理するクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiTaishoshaFinderTest extends TestBase {

    private static final FlexibleDate 調査完了年月日 = new FlexibleDate(new RString("20140101"));
    private static final RString 試験用文字列 = new RString("0001");

    public static class get認定調査依頼対象者市町村指定 extends TestBase {

        private INinteiShinchokuJohoDac shinchokuJohoDac;
        private INinteiShinseiJohoDac shinseiJohoDac;
        private INinteichosaItakusakiDac itakusakiDac;
        private INinteiChosaIraiJohoDac iraiJohoDac;
        private INinteiChosaIraiTaishoshaDac iraiTaishoshaDac;
        private IKojin kojin;
        private IKaigoJigyoshaDac kaigoJigyoshaDac;
        private IChosainJohoDac chosainJohoDac;
        private NinteichosaIraiTaishoshaFinder sut;
        private ShoKisaiHokenshaNo 証記載保険者番号_登録なし = new ShoKisaiHokenshaNo(new RString("000000"));
        private ShoKisaiHokenshaNo 証記載保険者番号_登録あり = new ShoKisaiHokenshaNo(new RString("123456"));

        @Override
        public void setUp() {
            iraiTaishoshaDac = mock(INinteiChosaIraiTaishoshaDac.class);
            when(iraiTaishoshaDac.select(証記載保険者番号_登録なし)).thenReturn(Collections.EMPTY_LIST);
            when(iraiTaishoshaDac.select(証記載保険者番号_登録あり)).thenReturn(create認定進捗情報Result(証記載保険者番号_登録あり));
            shinchokuJohoDac = mock(INinteiShinchokuJohoDac.class);
            when(shinchokuJohoDac.select認定調査未完了()).thenReturn(create認定進捗情報市町村指定なしResult());
            shinseiJohoDac = mock(INinteiShinseiJohoDac.class);
            when(shinseiJohoDac.select(TestCases[0].get申請書管理番号())).thenReturn(Result認定申請情報[0]);
            when(shinseiJohoDac.select(TestCases[1].get申請書管理番号())).thenReturn(Result認定申請情報[1]);
            when(shinseiJohoDac.select(TestCases[2].get申請書管理番号())).thenReturn(Result認定申請情報[2]);
            when(shinseiJohoDac.select(TestCases[3].get申請書管理番号())).thenReturn(Result認定申請情報[3]);
            when(shinseiJohoDac.select(TestCases[4].get申請書管理番号())).thenReturn(Result認定申請情報[4]);
            when(shinseiJohoDac.select(TestCases[5].get申請書管理番号())).thenReturn(Result認定申請情報[5]);
            itakusakiDac = mock(INinteichosaItakusakiDac.class);
            iraiJohoDac = mock(INinteiChosaIraiJohoDac.class);
            when(iraiJohoDac.select(any(RString.class), any(NinteichosaIraiRirekiNo.class))).thenReturn(null);
            kojin = mock(IKojin.class);
            //when(kojinDac.select最新(any(RString.class))).thenReturn(KojinEntityMock.getSpiedInstance());
            kaigoJigyoshaDac = mock(IKaigoJigyoshaDac.class);
            chosainJohoDac = mock(IChosainJohoDac.class);
            sut = new NinteichosaIraiTaishoshaFinder(
                    shinchokuJohoDac,
                    shinseiJohoDac,
                    itakusakiDac,
                    iraiJohoDac,
                    iraiTaishoshaDac,
                    //                    kojinDac,
                    kaigoJigyoshaDac,
                    chosainJohoDac);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の証記載保険者番号がNULLの場合_get認定調査依頼対象者市町村指定_例外をthrowする() {
            List<NinteichosaIraiTaishosha> resultList = sut.get認定調査依頼対象者証記載保険者番号指定(null);
        }

        @Test
        public void 指定された証記載保険者番号で_未完了の要介護認定申請情報が_1件も登録されていない場合_EMPTY_LISTが返されること() {
            List<NinteichosaIraiTaishosha> resultList = sut.get認定調査依頼対象者証記載保険者番号指定(証記載保険者番号_登録なし);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }
//        @Test
//        public void 指定された証記載保険者番号で_未完了の要介護認定申請情報が_3件登録されている場合_指定された証記載保険者番号の情報が3件返されること() {
//            List<NinteichosaIraiTaishosha> resultList = sut.get認定調査依頼対象者証記載保険者番号指定(証記載保険者番号_登録あり);
//            assertThat(resultList.size(), is(3));
//        }
//
//        @Test
//        public void 全市町村を対象にした対象者の取得で_未完了の要介護認定申請情報が_4件登録されている場合_全市町村の情報が4件返されること() {
//            List<NinteichosaIraiTaishosha> resultList = sut.get認定調査依頼対象者全件();
//            assertThat(resultList.size(), is(4));
//        }
    }
    /**
     * テストケースのデータです。
     *
     * 証記載保険者番号=12345の場合、テストケース1,3,4が該当します。証記載保険者番号の指定が無い場合、テストケース1,3,4,5が該当します。
     */
    private static TestCase[] TestCases = {
        // TestNo, 申請書管理番号, 証記載保険者番号, 認定調査依頼履歴番号, 認定調査完了年月日, 認定調査委託先コード, 調査員番号コード;
        new TestCase(0, new ShinseishoKanriNo(new RString("0000")), new ShoKisaiHokenshaNo(new RString("000000")), new NinteichosaIraiRirekiNo(1), 調査完了年月日, new RString("01"), new RString("001")),
        new TestCase(1, new ShinseishoKanriNo(new RString("0001")), new ShoKisaiHokenshaNo(new RString("123456")), new NinteichosaIraiRirekiNo(2), YokaigoninteiDateConstants.認定調査未完了年月日, new RString("01"), new RString("001")),
        new TestCase(2, new ShinseishoKanriNo(new RString("0002")), new ShoKisaiHokenshaNo(new RString("123456")), new NinteichosaIraiRirekiNo(1), 調査完了年月日, new RString("01"), new RString("001")),
        new TestCase(3, new ShinseishoKanriNo(new RString("0003")), new ShoKisaiHokenshaNo(new RString("123456")), new NinteichosaIraiRirekiNo(1), YokaigoninteiDateConstants.認定調査未完了年月日, null, null),
        new TestCase(4, new ShinseishoKanriNo(new RString("0004")), new ShoKisaiHokenshaNo(new RString("123456")), new NinteichosaIraiRirekiNo(5), YokaigoninteiDateConstants.認定調査未完了年月日, new RString("02"), new RString("002")),
        new TestCase(5, new ShinseishoKanriNo(new RString("0005")), new ShoKisaiHokenshaNo(new RString("222222")), new NinteichosaIraiRirekiNo(1), YokaigoninteiDateConstants.認定調査未完了年月日, new RString("04"), new RString("004"))
    };
    private static DbT5001NinteiShinseiJohoEntity[] Result認定申請情報 = {
        create認定申請情報Entity(0),
        create認定申請情報Entity(1),
        create認定申請情報Entity(2),
        create認定申請情報Entity(3),
        create認定申請情報Entity(4),
        create認定申請情報Entity(5)
    };
    private static DbT5005NinteiShinchokuJohoEntity[] Result認定進捗情報 = {
        create認定進捗情報Entity(0),
        create認定進捗情報Entity(1),
        create認定進捗情報Entity(2),
        create認定進捗情報Entity(3),
        create認定進捗情報Entity(4),
        create認定進捗情報Entity(5)
    };

    private static List<DbT5005NinteiShinchokuJohoEntity> create認定進捗情報Result(ShoKisaiHokenshaNo 証記載保険者番号) {
        List<DbT5005NinteiShinchokuJohoEntity> resultList = new ArrayList<>();
        List<RString> list申請書管理番号 = new ArrayList<>();

        for (DbT5001NinteiShinseiJohoEntity entity : Result認定申請情報) {
            if (entity.getShoKisaiHokenshaNo().equals(証記載保険者番号)) {
                list申請書管理番号.add(entity.getShinseishoKanriNo().getColumnValue());
            }
        }

        for (RString 管理番号 : list申請書管理番号) {
            for (DbT5005NinteiShinchokuJohoEntity entity : Result認定進捗情報) {
                if (管理番号.equals(entity.getShinseishoKanriNo().getColumnValue())
                        && YokaigoninteiDateConstants.認定調査未完了年月日.equals(entity.getNinteichosaKanryoYMD())) {
                    resultList.add(entity);
                }
            }
        }
        return resultList;
    }

    private static List<DbT5005NinteiShinchokuJohoEntity> create認定進捗情報市町村指定なしResult() {
        List<DbT5005NinteiShinchokuJohoEntity> resultList = new ArrayList<>();

        for (DbT5005NinteiShinchokuJohoEntity entity : Result認定進捗情報) {
            if (YokaigoninteiDateConstants.認定調査未完了年月日.equals(entity.getNinteichosaKanryoYMD())) {
                resultList.add(entity);
            }
        }
        return resultList;
    }

    private static DbT5005NinteiShinchokuJohoEntity create認定進捗情報Entity(int テストパターン) {
        ShinseishoKanriNo shinseishoKanriNo = TestCases[テストパターン].get申請書管理番号();
        FlexibleDate ninteiShinseiJohoTorokuYMD = 調査完了年月日;
        boolean enkitsuchiDoiUmuKubun = true;
        FlexibleDate enkitsuchiHakkoYMD = 調査完了年月日;
        int enkitsuchiHakkoKaisu = 1;
        RString ninteiEnkiRuyu = 試験用文字列;
        FlexibleDate ichijihanteiChushutsuYMD = 調査完了年月日;
        FlexibleDate iraiJohoSoshinYMD = 調査完了年月日;
        FlexibleDate ninteichosaIraiKanryoYMD = 調査完了年月日;
        FlexibleDate ninteichosaKanryoYMD = TestCases[テストパターン].get認定調査完了年月日();
        FlexibleDate ikenshoSakuseiIraiKanryoYMD = 調査完了年月日;
        FlexibleDate ikenshoTorokuKanryoYMD = 調査完了年月日;
        FlexibleDate ichijiHanteiKanryoYMD = 調査完了年月日;
        FlexibleDate ichiGoHanteiKanryoYMD = 調査完了年月日;
        FlexibleDate ninteiShinsakaiWariateKanryoYMD = 調査完了年月日;
        FlexibleDate ninteiShinsakaiKanryoYMD = 調査完了年月日;
        FlexibleDate centerSoshinYMD = 調査完了年月日;

        DbT5005NinteiShinchokuJohoEntity entity = new DbT5005NinteiShinchokuJohoEntity(
                shinseishoKanriNo,
                ninteiShinseiJohoTorokuYMD,
                enkitsuchiDoiUmuKubun,
                enkitsuchiHakkoYMD,
                enkitsuchiHakkoKaisu,
                ninteiEnkiRuyu,
                ichijihanteiChushutsuYMD,
                iraiJohoSoshinYMD,
                ninteichosaIraiKanryoYMD,
                ninteichosaKanryoYMD,
                ikenshoSakuseiIraiKanryoYMD,
                ikenshoTorokuKanryoYMD,
                ichijiHanteiKanryoYMD,
                ichiGoHanteiKanryoYMD,
                ninteiShinsakaiWariateKanryoYMD,
                ninteiShinsakaiKanryoYMD,
                centerSoshinYMD);
        return entity;
    }

    private static DbT5001NinteiShinseiJohoEntity create認定申請情報Entity(int テストパターン) {
        DbT5001NinteiShinseiJohoEntity entity = new DbT5001NinteiShinseiJohoEntity();
        entity.setShinseishoKanriNo(TestCases[テストパターン].get申請書管理番号());
        entity.setShoKisaiHokenshaNo(TestCases[テストパターン].get証記載保険者番号());
        entity.setShishoCode(new RString("1"));
        entity.setHihokenshaNo(new KaigoHihokenshaNo(試験用文字列));
        entity.setShikibetsuCode(new ShikibetsuCode(試験用文字列));
        entity.setNinteiShinseiYMD(調査完了年月日);
        entity.setNinteiShinseiEdabanCode(new EdabanCode(new RString("01")));
        entity.setNinteiShinseiShinseijiKubunCode(NinteiShinseiKubunShinsei.新規申請);
        entity.setNinteiShinseiHoreiKubunCode(new Code(試験用文字列));
        entity.setNinteiShinseiYukoKubunCode(new Code(試験用文字列));
        entity.setShienShinseiKubun(試験用文字列);
        entity.setShinseiRiyu(試験用文字列);
        entity.setZenYokaigoKubunCode(new Code(試験用文字列));
        entity.setZenYukoKikan(1);
        entity.setJohoteikyoDouiUmuKubun(true);
        entity.setNinteichosaIraiRirekiNo(TestCases[テストパターン].get認定調査依頼履歴番号());
        entity.setIkenshoIraiRirekiNo(1);
        entity.setMinashiCode(試験用文字列);
        entity.setEnkitsuchiDoiUmuKubun(true);
        entity.setShisetsuNyushoUmuKubun(true);
        entity.setSichosonRenrakuJiko(試験用文字列);
        entity.setTorisageKubunCode(new Code(試験用文字列));
        entity.setTorisageRiyu(試験用文字列);
        entity.setTorisageYMD(調査完了年月日);
        entity.setShinsaKeizokuKubun(true);
        return entity;
    }

    /**
     * テストケースの番号と、設定する値を保持するクラスです。
     */
    private static class TestCase {

        private int TestNo;
        private ShinseishoKanriNo 申請書管理番号;
        private ShoKisaiHokenshaNo 証記載保険者番号;
        private NinteichosaIraiRirekiNo 認定調査依頼履歴番号;
        private FlexibleDate 認定調査完了年月日;
        private RString 認定調査委託先コード;
        private RString 調査員番号コード;

        public TestCase(int TestNo,
                ShinseishoKanriNo 申請書管理番号,
                ShoKisaiHokenshaNo 証記載保険者番号,
                NinteichosaIraiRirekiNo 認定調査依頼履歴番号,
                FlexibleDate 認定調査完了年月日,
                RString 認定調査委託先コード,
                RString 調査員番号コード) {
            this.TestNo = TestNo;
            this.申請書管理番号 = 申請書管理番号;
            this.証記載保険者番号 = 証記載保険者番号;
            this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
            this.認定調査完了年月日 = 認定調査完了年月日;
            this.認定調査委託先コード = 認定調査委託先コード;
            this.調査員番号コード = 調査員番号コード;
        }

        /**
         * @return TestNo
         */
        public int getTestNo() {
            return TestNo;
        }

        /**
         * @return 申請書管理番号
         */
        public ShinseishoKanriNo get申請書管理番号() {
            return 申請書管理番号;
        }

        /**
         * @return 証記載保険者番号
         */
        public ShoKisaiHokenshaNo get証記載保険者番号() {
            return 証記載保険者番号;
        }

        /**
         * @return 認定調査依頼履歴番号
         */
        public NinteichosaIraiRirekiNo get認定調査依頼履歴番号() {
            return 認定調査依頼履歴番号;
        }

        /**
         * @return 認定調査完了年月日
         */
        public FlexibleDate get認定調査完了年月日() {
            return 認定調査完了年月日;
        }

        /**
         * @return 認定調査委託先コード
         */
        public RString get認定調査委託先コード() {
            return 認定調査委託先コード;
        }

        /**
         * @return 調査員番号コード
         */
        public RString get調査員番号コード() {
            return 調査員番号コード;
        }
    }
}
