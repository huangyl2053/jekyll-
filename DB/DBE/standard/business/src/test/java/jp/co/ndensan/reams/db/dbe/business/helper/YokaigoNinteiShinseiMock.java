/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import jp.co.ndensan.reams.db.dbe.business.core.NinteiResult.NinteiResultSimple;
import jp.co.ndensan.reams.db.dbe.business.core.NinteiShinsei.NinteiShinseiRiyu;
import jp.co.ndensan.reams.db.dbe.business.core.NinteiShinseiTorisage.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbe.business.core.TorisageRiyu;
import jp.co.ndensan.reams.db.dbe.business.core.YokaigoNintei.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.ShinsakaiYusenWaritsukeKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
                new YMDHMS(new RString("20140808102030")),
                new ShoKisaiHokenshaNo(new RString("000000")),
                new ShishoCode(new RString("0")),
                HihokenshaNo.EMPTY,
                new ShikibetsuCode("0"),
                FlexibleDate.EMPTY,
                new EdabanCode("000"),
                new Code(RString.EMPTY),
                new Code(RString.EMPTY),
                new Code(RString.EMPTY),
                new Code(RString.EMPTY),
                NinteiShinseiRiyu.EMPTY,
                NinteiResultSimple.NONE,
                true,
                new NinteichosaIraiRirekiNo(0),
                0,
                new Code(RString.EMPTY),
                true,
                true,
                RString.EMPTY,
                new NinteiShinseiTorisage(TorisageKubun.認定申請有効, TorisageRiyu.EMPTY, FlexibleDate.MAX, ShinsaKeizokuKubun.継続する),
                ShinsakaiYusenWaritsukeKubun.優先しない,
                FlexibleDate.EMPTY
        );
    }

}
