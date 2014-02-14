/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.INinteiShinchokuJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.INinteichosaItakusakiDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiChosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.realservice.helper.KojinEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.persistence.basic.IChosainJohoDac;
import jp.co.ndensan.reams.ur.urf.persistence.basic.IKaigoJigyoshaDac;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.persistence.basic.IKojinDac;
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
 * 認定調査依頼対象者情報を管理するクラスのテストです
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiTaishoshaFinderTest extends TestBase {

    private static final FlexibleDate 調査未完了年月日 = new FlexibleDate(new RString("00000000"));
    private static final FlexibleDate 調査完了年月日 = new FlexibleDate(new RString("20140101"));
    private static final RString 試験用文字列 = new RString("0001");

    public static class get認定調査依頼対象者市町村指定 extends TestBase {

        private INinteiShinchokuJohoDac shinchokuJohoDac;
        private INinteiShinseiJohoDac shinseiJohoDac;
        private INinteichosaItakusakiDac itakusakiDac;
        private INinteiChosaIraiJohoDac iraiJohoDac;
        private IKojinDac kojinDac;
        private IKaigoJigyoshaDac kaigoJigyoshaDac;
        private IChosainJohoDac chosainJohoDac;
        private NinteichosaIraiTaishoshaFinder sut;
        private ShichosonCode 市町村コード_登録なし = new ShichosonCode(new RString("00000"));
        private ShichosonCode 市町村コード_登録あり = new ShichosonCode(new RString("12345"));

        @Override
        public void setUp() {
            shinchokuJohoDac = mock(INinteiShinchokuJohoDac.class);
            when(shinchokuJohoDac.selectChosaIraiTaisho(市町村コード_登録なし)).thenReturn(Collections.EMPTY_LIST);
            when(shinchokuJohoDac.selectChosaIraiTaisho(市町村コード_登録あり)).thenReturn(create認定進捗情報Result(市町村コード_登録あり.getValue()));
            when(shinchokuJohoDac.selectChosaIraiTaisho()).thenReturn(create認定進捗情報市町村指定なしResult());
            shinseiJohoDac = mock(INinteiShinseiJohoDac.class);
            when(shinseiJohoDac.select(TestScenarios[0].get市町村コード(), TestScenarios[0].get認定調査依頼履歴番号())).thenReturn(Result認定申請情報[0]);
            when(shinseiJohoDac.select(TestScenarios[1].get市町村コード(), TestScenarios[1].get認定調査依頼履歴番号())).thenReturn(Result認定申請情報[1]);
            when(shinseiJohoDac.select(TestScenarios[2].get市町村コード(), TestScenarios[2].get認定調査依頼履歴番号())).thenReturn(Result認定申請情報[2]);
            when(shinseiJohoDac.select(TestScenarios[3].get市町村コード(), TestScenarios[3].get認定調査依頼履歴番号())).thenReturn(Result認定申請情報[3]);
            when(shinseiJohoDac.select(TestScenarios[4].get市町村コード(), TestScenarios[4].get認定調査依頼履歴番号())).thenReturn(Result認定申請情報[4]);
            when(shinseiJohoDac.select(TestScenarios[5].get市町村コード(), TestScenarios[5].get認定調査依頼履歴番号())).thenReturn(Result認定申請情報[5]);
            when(shinseiJohoDac.select(any(ShichosonCode.class), any(RString.class))).thenReturn(Result認定申請情報[1]);
            when(shinseiJohoDac.select申請書管理番号(TestScenarios[0].get申請書管理番号().get申請書管理番号())).thenReturn(Result認定申請情報[0]);
            when(shinseiJohoDac.select申請書管理番号(TestScenarios[1].get申請書管理番号().get申請書管理番号())).thenReturn(Result認定申請情報[1]);
            when(shinseiJohoDac.select申請書管理番号(TestScenarios[2].get申請書管理番号().get申請書管理番号())).thenReturn(Result認定申請情報[2]);
            when(shinseiJohoDac.select申請書管理番号(TestScenarios[3].get申請書管理番号().get申請書管理番号())).thenReturn(Result認定申請情報[3]);
            when(shinseiJohoDac.select申請書管理番号(TestScenarios[4].get申請書管理番号().get申請書管理番号())).thenReturn(Result認定申請情報[4]);
            when(shinseiJohoDac.select申請書管理番号(TestScenarios[5].get申請書管理番号().get申請書管理番号())).thenReturn(Result認定申請情報[5]);
            itakusakiDac = mock(INinteichosaItakusakiDac.class);
            iraiJohoDac = mock(INinteiChosaIraiJohoDac.class);
            when(iraiJohoDac.select(any(RString.class), any(RString.class))).thenReturn(null);
            kojinDac = mock(IKojinDac.class);
            when(kojinDac.select最新(any(RString.class))).thenReturn(KojinEntityMock.getSpiedInstance());
            kaigoJigyoshaDac = mock(IKaigoJigyoshaDac.class);
            chosainJohoDac = mock(IChosainJohoDac.class);
            sut = new NinteichosaIraiTaishoshaFinder(
                    shinchokuJohoDac,
                    shinseiJohoDac,
                    itakusakiDac,
                    iraiJohoDac,
                    kojinDac,
                    kaigoJigyoshaDac,
                    chosainJohoDac);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードがNULLの場合_get認定調査依頼対象者市町村指定_例外をthrowする() {
            List<NinteichosaIraiTaishosha> resultList = sut.get認定調査依頼対象者市町村指定(null);
        }

        @Test
        public void 指定された市町村コードで_未完了の要介護認定申請情報が_1件も登録されていない場合_EMPTY_LISTが返されること() {
            List<NinteichosaIraiTaishosha> resultList = sut.get認定調査依頼対象者市町村指定(市町村コード_登録なし);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 指定された市町村コードで_未完了の要介護認定申請情報が_3件登録されている場合_指定された市町村コードの情報が3件返されること() {
            List<NinteichosaIraiTaishosha> resultList = sut.get認定調査依頼対象者市町村指定(市町村コード_登録あり);
            assertThat(resultList.size(), is(3));
        }

        @Test
        public void 全市町村を対象にした対象者の取得で_未完了の要介護認定申請情報が_4件登録されている場合_全市町村の情報が4件返されること() {
            List<NinteichosaIraiTaishosha> resultList = sut.get認定調査依頼対象者全件();
            assertThat(resultList.size(), is(4));
        }
    }
    private static TestScenario[] TestScenarios = {
        // TestNo, 申請書管理番号, 市町村コード, 認定調査依頼履歴番号, 認定調査完了年月日, 認定調査委託先コード, 調査員番号コード;
        // 市町村コード=12345の場合、シナリオ1,3,4が該当する
        // 市町村コードの指定が無い場合、シナリオ1,3,4,5が該当する
        new TestScenario(0, new ShinseishoKanriNo(new RString("0000")), new ShichosonCode(new RString("00000")), new RString("1"), new FlexibleDate(new RString("20140101")), new RString("01"), new RString("001")),
        new TestScenario(1, new ShinseishoKanriNo(new RString("0001")), new ShichosonCode(new RString("12345")), new RString("2"), new FlexibleDate(new RString("00000000")), new RString("01"), new RString("001")),
        new TestScenario(2, new ShinseishoKanriNo(new RString("0002")), new ShichosonCode(new RString("12345")), new RString("1"), new FlexibleDate(new RString("20140101")), new RString("01"), new RString("001")),
        new TestScenario(3, new ShinseishoKanriNo(new RString("0003")), new ShichosonCode(new RString("12345")), new RString("1"), new FlexibleDate(new RString("00000000")), null, null),
        new TestScenario(4, new ShinseishoKanriNo(new RString("0004")), new ShichosonCode(new RString("12345")), new RString("5"), new FlexibleDate(new RString("00000000")), new RString("02"), new RString("002")),
        new TestScenario(5, new ShinseishoKanriNo(new RString("0005")), new ShichosonCode(new RString("22222")), new RString("1"), new FlexibleDate(new RString("00000000")), new RString("04"), new RString("004"))
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

    private static List<DbT5005NinteiShinchokuJohoEntity> create認定進捗情報Result(RString 市町村コード) {
        List<DbT5005NinteiShinchokuJohoEntity> resultList = new ArrayList<>();
        List<RString> list申請書管理番号 = new ArrayList<>();

        for (DbT5001NinteiShinseiJohoEntity entity : Result認定申請情報) {
            if (entity.getShichosonCode().getValue().equals(市町村コード)) {
                list申請書管理番号.add(entity.getShinseishoKanriNo().get申請書管理番号());
            }
        }

        for (RString 管理番号 : list申請書管理番号) {
            for (DbT5005NinteiShinchokuJohoEntity entity : Result認定進捗情報) {
                if (管理番号.equals(entity.getShinseishoKanriNo().get申請書管理番号())
                        && 調査未完了年月日.equals(entity.getNinteichosaKanryoYMD())) {
                    resultList.add(entity);
                }
            }
        }
        return resultList;
    }

    private static List<DbT5005NinteiShinchokuJohoEntity> create認定進捗情報市町村指定なしResult() {
        List<DbT5005NinteiShinchokuJohoEntity> resultList = new ArrayList<>();
        List<RString> list申請書管理番号 = new ArrayList<>();

        for (DbT5001NinteiShinseiJohoEntity entity : Result認定申請情報) {
            list申請書管理番号.add(entity.getShinseishoKanriNo().get申請書管理番号());
        }

        for (RString 管理番号 : list申請書管理番号) {
            for (DbT5005NinteiShinchokuJohoEntity entity : Result認定進捗情報) {
                if (管理番号.equals(entity.getShinseishoKanriNo().get申請書管理番号())
                        && 調査未完了年月日.equals(entity.getNinteichosaKanryoYMD())) {
                    resultList.add(entity);
                }
            }
        }
        return resultList;
    }

    private static DbT5005NinteiShinchokuJohoEntity create認定進捗情報Entity(int テストパターン) {
        ShinseishoKanriNo shinseishoKanriNo = TestScenarios[テストパターン].get申請書管理番号();
        FlexibleDate ninteiShinseiJohoTorokuYMD = 調査完了年月日;
        boolean enkitsuchiDoiUmuKubun = true;
        FlexibleDate enkitsuchiHakkoYMD = 調査完了年月日;
        int enkitsuchiHakkoKaisu = 1;
        RString ninteiEnkiRuyu = 試験用文字列;
        FlexibleDate ichijihanteiChushutsuYMD = 調査完了年月日;
        FlexibleDate iraiJohoSoshinYMD = 調査完了年月日;
        FlexibleDate ninteichosaIraiKanryoYMD = 調査完了年月日;
        FlexibleDate ninteichosaKanryoYMD = TestScenarios[テストパターン].get認定調査完了年月日();
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
        ShinseishoKanriNo shinseishoKanriNo = TestScenarios[テストパターン].get申請書管理番号();
        ShichosonCode shichosonCode = TestScenarios[テストパターン].get市町村コード();
        RString shishoCode = new RString("1");
        KaigoHihokenshaNumber hihokenshaNo = new KaigoHihokenshaNumber(試験用文字列);
        IShikibetsuCode shikibetsuCode = new _ShikibetsuCode(試験用文字列);
        FlexibleDate ninteiShinseiYMD = 調査完了年月日;
        RString ninteiShinseiEdabanCode = 試験用文字列;
        RString ninteiShinseiShinseijiKubunCode = 試験用文字列;
        RString ninteiShinseiHoreiKubunCode = 試験用文字列;
        RString ninteiShinseiYukoKubunCode = 試験用文字列;
        RString shienShinseiKubun = 試験用文字列;
        RString shinseiRiyu = 試験用文字列;
        RString zenYokaigoKubunCode = 試験用文字列;
        int zenYukoKikan = 1;
        boolean johoteikyoDouiUmuKubun = true;
        RString ninteichosaIraiRirekiNo = TestScenarios[テストパターン].get認定調査依頼履歴番号();
        RString ikenshoIraiRirekiNo = 試験用文字列;
        RString minashiCode = 試験用文字列;
        boolean enkitsuchiDoiUmuKubun = true;
        boolean shisetsuNyushoUmuKubun = true;
        RString sichosonRenrakuJiko = 試験用文字列;
        RString torisageKubunCode = 試験用文字列;
        RString torisageRiyu = 試験用文字列;
        FlexibleDate torisageYMD = 調査完了年月日;
        boolean shinsaKeizokuKubun = true;
        DbT5001NinteiShinseiJohoEntity entity = new DbT5001NinteiShinseiJohoEntity(shinseishoKanriNo,
                shichosonCode,
                shishoCode,
                hihokenshaNo,
                shikibetsuCode,
                ninteiShinseiYMD,
                ninteiShinseiEdabanCode,
                ninteiShinseiShinseijiKubunCode,
                ninteiShinseiHoreiKubunCode,
                ninteiShinseiYukoKubunCode,
                shienShinseiKubun,
                shinseiRiyu,
                zenYokaigoKubunCode,
                zenYukoKikan,
                johoteikyoDouiUmuKubun,
                ninteichosaIraiRirekiNo,
                ikenshoIraiRirekiNo,
                minashiCode,
                enkitsuchiDoiUmuKubun,
                shisetsuNyushoUmuKubun,
                sichosonRenrakuJiko,
                torisageKubunCode,
                torisageRiyu,
                torisageYMD,
                shinsaKeizokuKubun);
        return entity;
    }

    private static class TestScenario {
        // テストケースの番号と、設定する値を保持するクラス。

        private int TestNo;
        private ShinseishoKanriNo 申請書管理番号;
        private ShichosonCode 市町村コード;
        private RString 認定調査依頼履歴番号;
        private FlexibleDate 認定調査完了年月日;
        private RString 認定調査委託先コード;
        private RString 調査員番号コード;

        public TestScenario(int TestNo,
                ShinseishoKanriNo 申請書管理番号,
                ShichosonCode 市町村コード,
                RString 認定調査依頼履歴番号,
                FlexibleDate 認定調査完了年月日,
                RString 認定調査委託先コード,
                RString 調査員番号コード) {
            this.TestNo = TestNo;
            this.申請書管理番号 = 申請書管理番号;
            this.市町村コード = 市町村コード;
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
         * @return 市町村コード
         */
        public ShichosonCode get市町村コード() {
            return 市町村コード;
        }

        /**
         * @return 認定調査依頼履歴番号
         */
        public RString get認定調査依頼履歴番号() {
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
