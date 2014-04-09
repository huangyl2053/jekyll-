/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.business.NinteiResult;
import jp.co.ndensan.reams.db.dbe.business.NinteiRiyu;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinsakaiIken;
import jp.co.ndensan.reams.db.dbe.business.NinteiYukoKikan;
import jp.co.ndensan.reams.db.dbe.business.TokuteiShippeiKubun;
import jp.co.ndensan.reams.db.dbe.business.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbe.business.YokaigoJotaizoRei;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiKekkaIdoJiyu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIkenShurui;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiYukoKikanTsukisu;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * NinteiResultを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class NinteiResultMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteiResultMock() {
    }

    /**
     * NinteiResultを生成して返します。
     *
     * @return NinteiResult
     */
    public static NinteiResult getSpiedInstance() {
        return spy(createNinteiResult());
    }

    private static NinteiResult createNinteiResult() {
        return new NinteiResult(
                createShinseishoKanriNo(),
                FlexibleDate.MIN,
                createYokaigoJotaiKubun(),
                createYokaigoJotaizoRei(),
                createNinteiYukoKikan(),
                KaigoServiceShurui.訪問介護,
                true,
                createTokuteiShippeiKubun(),
                createNinteiShinsakaiIken(),
                createNinteiRiyu());
    }

    private static ShinseishoKanriNo createShinseishoKanriNo() {
        return new ShinseishoKanriNo(new RString("1234567890"));
    }

    private static YokaigoJotaiKubun createYokaigoJotaiKubun() {
        return new YokaigoJotaiKubun(new Code(new RString("コード")), new RString("名称"), new RString("略称"));
    }

    private static YokaigoJotaizoRei createYokaigoJotaizoRei() {
        return new YokaigoJotaizoRei(new Code(new RString("コード")), new RString("名称"), new RString("略称"));
    }

    private static NinteiYukoKikan createNinteiYukoKikan() {
        return new NinteiYukoKikan(FlexibleDate.MIN, new NinteiYukoKikanTsukisu(1), FlexibleDate.MAX);
    }

    private static TokuteiShippeiKubun createTokuteiShippeiKubun() {
        return new TokuteiShippeiKubun(new Code(new RString("コード")), new RString("名称"), new RString("略称"));
    }

    private static NinteiShinsakaiIken createNinteiShinsakaiIken() {
        return new NinteiShinsakaiIken(
                new ShinsakaiKaisaiNo(new Integer("123")),
                ShinsakaiIkenShurui.サービス利用への意見,
                new RString("審査会意見"),
                new RString("審査会メモ"));
    }

    private static NinteiRiyu createNinteiRiyu() {
        return new NinteiRiyu(
                new RString("一次判定結果変更理由"),
                NinteiKekkaIdoJiyu.職権追加,
                FlexibleDate.MIN,
                new RString("認定取消理由"),
                FlexibleDate.MAX,
                new RString("認定理由"));
    }
}
