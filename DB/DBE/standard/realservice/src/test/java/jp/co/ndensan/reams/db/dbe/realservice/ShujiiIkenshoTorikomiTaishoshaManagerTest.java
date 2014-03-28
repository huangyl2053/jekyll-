/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoTorikomiTaishosha;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IShujiiIkenshoTorikomiTaishoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * 主治医意見書取込対象者を扱うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoTorikomiTaishoshaManagerTest extends DbeTestBase {

    private static ShujiiIkenshoTorikomiTaishoshaManager sut;
    private static IShujiiIkenshoTorikomiTaishoshaDac torikomiTaishoshaDac;
    private static ShichosonCode 市町村コード = new ShichosonCode(new RString("123456"));
    private static RString 支所コード = new RString("0001");
    private static List<ShujiiIkenshoTorikomiTaishosha> resultList;

    @BeforeClass
    public static void setUpClass() {
        torikomiTaishoshaDac = mock(IShujiiIkenshoTorikomiTaishoshaDac.class);
    }

    public static class get主治医意見書取込対象者全件 extends DbeTestBase {

        @Test
        public void 主治医意見書取込対象者の取得条件に一致するデータが登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.selectAll()).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoTorikomiTaishoshaManager(torikomiTaishoshaDac);
            resultList = sut.get主治医意見書取込対象者全件();
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }
    }

    public static class get主治医意見書取込対象者全件_市町村コード extends DbeTestBase {

        @Test
        public void 主治医意見書取込対象者の取得条件に一致するデータが登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.select市町村コード(市町村コード)).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoTorikomiTaishoshaManager(torikomiTaishoshaDac);
            resultList = sut.get主治医意見書取込対象者全件(市町村コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }
    }

    public static class get主治医意見書取込対象者全件_市町村コード_支所コード extends DbeTestBase {

        @Test
        public void 主治医意見書取込対象者の取得条件に一致するデータが登録されていないとき_COLLECTIONS_EMPTYを返す() {
            when(torikomiTaishoshaDac.select市町村コード及び支所コード(市町村コード, 支所コード)).thenReturn(Collections.EMPTY_LIST);
            sut = new ShujiiIkenshoTorikomiTaishoshaManager(torikomiTaishoshaDac);
            resultList = sut.get主治医意見書取込対象者全件(市町村コード, 支所コード);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }
    }
}
