/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import jp.co.ndensan.reams.db.dbe.business.core.ninteiresult.NinteiResult;
import jp.co.ndensan.reams.db.dbe.business.core.ninteiresult.NinteiResultIdo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteiresult.NinteiShinsakaiIken;
import jp.co.ndensan.reams.db.dbe.business.core.ninteiresult.NinteiTorikeshi;
import jp.co.ndensan.reams.db.dbe.business.core.ninteiresult.NinteiYukoKikan;
import jp.co.ndensan.reams.db.dbe.business.core.TokuteiShippei;
import jp.co.ndensan.reams.db.dbe.business.core.YokaigoJotai.YokaigoJotai;
import jp.co.ndensan.reams.db.dbe.business.core.YokaigoJotai.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbe.business.core.YokaigoJotai.YokaigoJotaizoRei;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.NinteiResultIdoJiyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.ShinsakaiIkenType;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.ShisetsuNyushoKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.TsuchiKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.NinteiYukoKikanTsukisu;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaikaisaino.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.business.core._KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
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
                new ShinseishoKanriNo(new RString("1234567890")),
                new YMDHMS(new RString("20140808102030")),
                new ShoKisaiHokenshaNo(new RString("1234567890")),
                new HihokenshaNo(new RString("4567890123")),
                new FlexibleDate("20140101"),
                createYokaigoJotai(),
                createYokaigoJotaizoRei(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                createKaigoServiceShurui(),
                ShisetsuNyushoKubun.入所している,
                createTokuteiShippeiKubun(),
                createNinteiShinsakaiIken(),
                createNinteiResultIdo(),
                createNinteiTorikeshi(),
                TsuchiKubun.認定,
                new RString("認定理由"),
                FlexibleDate.EMPTY);
    }

    private static YokaigoJotai createYokaigoJotai() {
        return new YokaigoJotai(createYokaigoJotaiKubun(), createNinteiYukoKikan());
    }

    private static YokaigoJotaiKubun createYokaigoJotaiKubun() {
        return spy(new YokaigoJotaiKubun(new Code(new RString("1111111111")), new RString("名称"), new RString("略称")));
    }

    private static YokaigoJotaizoRei createYokaigoJotaizoRei() {
        return spy(new YokaigoJotaizoRei(new Code(new RString("2222222222")), new RString("名称"), new RString("略称")));
    }

    private static IKaigoServiceShurui createKaigoServiceShurui() {
        return spy(new _KaigoServiceShurui(
                new ServiceShuruiCode("01"), new Range<>(FlexibleYearMonth.MIN, FlexibleYearMonth.MAX), new RString("サービス種類名称"),
                new RString("サービス種類名称略称"), new Code("サービス分類")));
    }

    private static NinteiYukoKikan createNinteiYukoKikan() {
        return spy(new NinteiYukoKikan(new FlexibleDate("20140202"), new NinteiYukoKikanTsukisu(1), new FlexibleDate("20140303")));
    }

    private static TokuteiShippei createTokuteiShippeiKubun() {
        return spy(new TokuteiShippei(new Code(new RString("3333333333")), new RString("名称"), new RString("略称")));
    }

    private static NinteiShinsakaiIken createNinteiShinsakaiIken() {
        return spy(new NinteiShinsakaiIken(
                new ShinsakaiKaisaiNo(new Integer("123")),
                ShinsakaiIkenType.サービス利用への意見,
                new RString("審査会意見"),
                new RString("審査会メモ"),
                new RString("一次判定結果変更理由")));
    }

    private static NinteiResultIdo createNinteiResultIdo() {
        return spy(new NinteiResultIdo(NinteiResultIdoJiyuKubun.職権追加, new FlexibleDate("20140404")));
    }

    private static NinteiTorikeshi createNinteiTorikeshi() {
        return spy(new NinteiTorikeshi(new RString("認定取消理由"), new FlexibleDate("20140505")));
    }
}
