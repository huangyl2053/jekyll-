/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.helper;

import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * NinteiShinseiJohoを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class NinteiShinseiJohoMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteiShinseiJohoMock() {
    }

    /**
     * NinteiShinseiJohoを生成して返します。
     *
     * @return NinteiShinseiJoho
     */
    public static NinteiShinseiJoho getSpiedInstance() {
        return spy(new NinteiShinseiJoho(
                new ShinseishoKanriNo(new RString("申請書管理番号")),
                new ShichosonCode(new RString("市町村コード")),
                new RString("支所コード"),
                new KaigoHihokenshaNo(new RString("介護被保険者番号")),
                new ShikibetsuCode(new RString("123456")),
                RDate.MIN,
                new EdabanCode(new RString("001")),
                NinteiShinseiKubunShinsei.新規申請,
                new Code(new RString("認定申請区分_法令")),
                new Code(new RString("認定申請有効区分")),
                new Code(new RString("要支援申請区分")),
                new RString("認定申請理由"),
                new Code(new RString("前回要介護状態区分コード")),
                0,
                true,
                1,
                2,
                new Code(new RString("みなし要介護区分コード")),
                false,
                true,
                new RString("市町村連絡事項"),
                new NinteiShinseiTorisage(TorisageKubun.取下げ, new RString("取下げ理由"), FlexibleDate.MAX, ShinsaKeizokuKubun.継続する)));
    }
}
