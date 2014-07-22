/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import jp.co.ndensan.reams.db.dbe.business.NinteiResultSimple;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiRiyu;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbe.business.TorisageRiyu;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiYusenWaritsukeKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * YokaigoNinteiShinseiのMockです。
 *
 * @author N3327 三浦 凌
 */
public class YokaigoNinteiShinseiMock {

    /**
     * YokaigoNinteiShinseiのspyインスタンスを返します。
     *
     * @return YokaigoNinteiShinseiのspy
     */
    public static YokaigoNinteiShinsei getSpiedInstance() {
        return spy(createYokaogoNinteiShinsei());
    }

    private static YokaigoNinteiShinsei createYokaogoNinteiShinsei() {
        return new YokaigoNinteiShinsei(
                new ShinseishoKanriNo(RString.EMPTY),
                new ShoKisaiHokenshaNo(new RString("000000")),
                ShishoCode.NULL_VALUE,
                KaigoHihokenshaNo.NULL_VALUE,
                new ShikibetsuCode("0"),
                FlexibleDate.EMPTY,
                new EdabanCode("000"),
                new Code(RString.EMPTY),
                new Code(RString.EMPTY),
                new Code(RString.EMPTY),
                new Code(RString.EMPTY),
                NinteiShinseiRiyu.EMPTY,
                NinteiResultSimple.EMPTY,
                true,
                new NinteichosaIraiRirekiNo(0),
                0,
                new Code(RString.EMPTY),
                true,
                true,
                RString.EMPTY,
                new NinteiShinseiTorisage(TorisageKubun.認定申請有効, TorisageRiyu.EMPTY, FlexibleDate.MAX, ShinsaKeizokuKubun.継続する),
                ShinsakaiYusenWaritsukeKubun.優先しない
        );
    }

}
