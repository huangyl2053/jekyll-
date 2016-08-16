/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.houshold;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.houshold.HousholdBusiness;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;

/**
 *
 * @author wangjie2
 */
public class HousholdFinderTest extends DbdTestDacBase {

    /**
     * Test of getLastInputHousehold method, of class HousholdFinder.
     */
    @Test
    public void testGetLastInputHousehold() {
        System.out.println("getLastInputHousehold");
        FlexibleYear 年度 = null;
        HihokenshaNo 被保険者番号 = new HihokenshaNo("0000000273");
        RString 対象年 = null;
        RString 年金保険者コード = null;
        RString 基礎年金番号 = null;
        RString 年金コード = null;
        HousholdFinder instance = new HousholdFinder();
        List<HousholdBusiness> result = instance.getLastInputHousehold(年度, 被保険者番号, 対象年, 年金保険者コード, 基礎年金番号, 年金コード);
        System.out.println("re:" + result.get(0).getカナ氏名());
    }

}
