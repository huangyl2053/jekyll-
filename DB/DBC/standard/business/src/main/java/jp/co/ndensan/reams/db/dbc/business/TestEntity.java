/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author XuPeng
 */
public class TestEntity {

    private final ShikibetsuCode 識別コード;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス年月;
    private final RDate 申請日;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 明細番号;
    private final RString 証明書;
    private final RString 様式番号;

    public TestEntity() {
        this.識別コード = new ShikibetsuCode("123456");
        this.被保険者番号 = new HihokenshaNo("1");
        this.サービス年月 = new FlexibleYearMonth("201601");
        this.申請日 = new RDate(2016, 01, 16);
        this.整理番号 = new RString("123456");
        this.事業者番号 = new JigyoshaNo("2");
        this.明細番号 = new RString("3456");
        this.証明書 = new RString("証明書");
        this.様式番号 = new RString("123");
    }

    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    public HihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    public FlexibleYearMonth getサービス年月() {
        return サービス年月;
    }

    public RDate get申請日() {
        return 申請日;
    }

    public RString get整理番号() {
        return 整理番号;
    }

    public JigyoshaNo get事業者番号() {
        return 事業者番号;
    }

    public RString get明細番号() {
        return 明細番号;
    }

    public RString get証明書() {
        return 証明書;
    }

    public RString get様式番号() {
        return 様式番号;
    }

}
