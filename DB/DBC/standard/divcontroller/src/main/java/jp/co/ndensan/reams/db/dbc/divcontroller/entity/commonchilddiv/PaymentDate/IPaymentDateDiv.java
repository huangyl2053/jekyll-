package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 */
public interface IPaymentDateDiv extends ICommonChildDivBaseProperties {

    public void onLoad(RString 支払方法機能区分, RString 支払予定日印字有無);

    public RDate get振込予定日();

    public RString get支払場所();

    public RDate get支払期間FROM();

    public RDate get支払期間TO();

    public RTime get開始時間();

    public RTime get終了時間();

    public ValidationMessageControlPairs getCheckMessage();
}
