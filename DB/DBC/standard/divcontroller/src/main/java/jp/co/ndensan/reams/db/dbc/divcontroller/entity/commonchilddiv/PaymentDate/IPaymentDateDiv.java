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

    void onLoad(RString 支払方法機能区分, RString 支払予定日印字有無);

    RDate get振込予定日();

    RString get支払場所();

    RDate get支払期間FROM();

    RDate get支払期間TO();

    RTime get開始時間();

    RTime get終了時間();

    ValidationMessageControlPairs getCheckMessage();
}
