/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.helper;

import jp.co.ndensan.reams.db.dbe.business.NinteiResultSimple;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiShinsei;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbe.business.TorisageRiyu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShishoCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * NinteiShinseiJohoを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class YokaigoNinteiShinseiMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private YokaigoNinteiShinseiMock() {
    }

    /**
     * NinteiShinseiJohoを生成して返します。
     *
     * @return NinteiShinseiJoho
     */
    public static YokaigoNinteiShinsei getSpiedInstance() {
        return spy(new YokaigoNinteiShinsei(
                new ShinseishoKanriNo(new RString("申請書管理番号")),
                new ShoKisaiHokenshaNo(new RString("証記載保険者番号")),
                new ShishoCode(new RString("支所コード")),
                new KaigoHihokenshaNo(new RString("1234567890")),
                new ShikibetsuCode(new RString("123456")),
                FlexibleDate.MIN,
                new EdabanCode(new RString("001")),
                new Code(String.valueOf(NinteiShinseiKubunShinsei.新規申請.コード())),
                new Code(new RString("認定申請区分_法令")),
                new Code(new RString("認定申請有効区分")),
                new Code(new RString("要支援申請区分")),
                new RString("認定申請理由"),
                NinteiResultSimple.EMPTY,
                true,
                new NinteichosaIraiRirekiNo(1),
                2,
                new Code(new RString("みなし要介護区分コード")),
                false,
                true,
                new RString("市町村連絡事項"),
                new NinteiShinseiTorisage(
                        TorisageKubun.取下げ,
                        TorisageRiyu.EMPTY,
                        FlexibleDate.MAX, ShinsaKeizokuKubun.継続する)));
    }
}
