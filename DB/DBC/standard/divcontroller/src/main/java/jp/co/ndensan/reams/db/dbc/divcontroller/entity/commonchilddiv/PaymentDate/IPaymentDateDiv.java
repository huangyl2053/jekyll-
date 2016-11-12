package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBC-4470-010 wangkanglei
 */
public interface IPaymentDateDiv extends ICommonChildDivBaseProperties {

    /**
     * onLoad
     *
     * @param 支払方法機能区分 RString
     */
    public void initialize(RString 支払方法機能区分);

    /**
     * get振込予定日
     *
     * @return RDate
     */
    public RDate get振込予定日();

    /**
     * get支払場所
     *
     * @return RString
     */
    public RString get支払場所();

    /**
     * get支払期間FROM
     *
     * @return RDate
     */
    public RDate get支払期間FROM();

    /**
     * get支払期間TO
     *
     * @return RDate
     */
    public RDate get支払期間TO();

    /**
     * get開始時間
     *
     * @return RTime
     */
    public RTime get開始時間();

    /**
     * get終了時間
     *
     * @return RTime
     */
    public RTime get終了時間();

    /**
     * get窓口払い一括更新区分
     *
     * @return RString
     */
    public RString get窓口払い一括更新区分();

    /**
     * getCheckMessage
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs getCheckMessage();
}
