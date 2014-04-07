/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinchokuJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShujiiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IShujiiIkenshoIraiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 主治医意見書依頼対象者の情報を扱うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoIraiTaishoshaFinderTest extends TestBase {

    private static ShujiiIkenshoIraiTaishoshaFinder sut;

    public static class get主治医意見書作成依頼対象者_引数なし extends TestBase {

        private INinteiShinchokuJohoDac ninteiShinchokuJohoDac;
        private IShujiiIkenshoIraiTaishoshaDac shujiiIkenshoIraiTaishoshaDac;
        private INinteiShinseiJohoDac ninteiShinseiJohoDac;
        private IShujiiJohoDac shujiiJohoDac;
        private IShujiiIkenshoIraiJohoDac shujiiIkenshoIraiJohoDac;

        @Test
        public void 主治医意見書作成依頼が未完了の対象者が_存在しない場合_EMPTY_LISTが返されること() {
            ninteiShinchokuJohoDac = mock(INinteiShinchokuJohoDac.class);
            when(ninteiShinchokuJohoDac.select主治医意見書作成依頼未完了()).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaFinder(
                    ninteiShinchokuJohoDac,
                    shujiiIkenshoIraiTaishoshaDac,
                    ninteiShinseiJohoDac,
                    shujiiJohoDac,
                    shujiiIkenshoIraiJohoDac);
            List<ShujiiIkenshoIraiTaishosha> resultList = sut.get主治医意見書作成依頼対象者();
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }
    }

    public static class get主治医意見書作成依頼対象者_証記載保険者番号 extends TestBase {

        private INinteiShinchokuJohoDac ninteiShinchokuJohoDac;
        private IShujiiIkenshoIraiTaishoshaDac shujiiIkenshoIraiTaishoshaDac;
        private INinteiShinseiJohoDac ninteiShinseiJohoDac;
        private IShujiiJohoDac shujiiJohoDac;
        private IShujiiIkenshoIraiJohoDac shujiiIkenshoIraiJohoDac;

        @Test
        public void 主治医意見書作成依頼が未完了の対象者が_存在しない場合_EMPTY_LISTが返されること() {
            ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("000001"));

            shujiiIkenshoIraiTaishoshaDac = mock(IShujiiIkenshoIraiTaishoshaDac.class);
            when(shujiiIkenshoIraiTaishoshaDac.select主治医意見書作成依頼対象者(any(ShoKisaiHokenshaNo.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaFinder(
                    ninteiShinchokuJohoDac,
                    shujiiIkenshoIraiTaishoshaDac,
                    ninteiShinseiJohoDac,
                    shujiiJohoDac,
                    shujiiIkenshoIraiJohoDac);
            List<ShujiiIkenshoIraiTaishosha> resultList = sut.get主治医意見書作成依頼対象者(証記載保険者番号);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }
    }

    public static class get主治医意見書作成依頼対象者_証記載保険者番号_支所コード extends TestBase {

        private INinteiShinchokuJohoDac ninteiShinchokuJohoDac;
        private IShujiiIkenshoIraiTaishoshaDac shujiiIkenshoIraiTaishoshaDac;
        private INinteiShinseiJohoDac ninteiShinseiJohoDac;
        private IShujiiJohoDac shujiiJohoDac;
        private IShujiiIkenshoIraiJohoDac shujiiIkenshoIraiJohoDac;

        @Test
        public void 主治医意見書作成依頼が未完了の対象者が_存在しない場合_EMPTY_LISTが返されること() {
            ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("000001"));
            RString 支所コード = new RString("0002");

            shujiiIkenshoIraiTaishoshaDac = mock(IShujiiIkenshoIraiTaishoshaDac.class);
            when(shujiiIkenshoIraiTaishoshaDac.select主治医意見書作成依頼対象者(any(ShoKisaiHokenshaNo.class), any(RString.class))).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoIraiTaishoshaFinder(
                    ninteiShinchokuJohoDac,
                    shujiiIkenshoIraiTaishoshaDac,
                    ninteiShinseiJohoDac,
                    shujiiJohoDac,
                    shujiiIkenshoIraiJohoDac);
            List<ShujiiIkenshoIraiTaishosha> resultList = sut.get主治医意見書作成依頼対象者(証記載保険者番号, 支所コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }
    }
}
