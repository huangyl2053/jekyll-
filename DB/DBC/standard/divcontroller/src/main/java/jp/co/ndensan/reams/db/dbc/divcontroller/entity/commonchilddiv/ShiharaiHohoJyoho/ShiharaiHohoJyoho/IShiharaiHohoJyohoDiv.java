package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBC-0300-010 houtianpeng
 */
public interface IShiharaiHohoJyohoDiv extends ICommonChildDivBaseProperties {

    public abstract void initialize(SikyuSinseiJyohoParameter 支給申請情報, RString 状態);

    /**
     * 支払方法を取得します。
     *
     * @return RString
     */
    public RString getShiharaiHohoRad();

    /**
     * 支払場所を取得します。
     *
     * @return RString
     */
    public RString getShiharaiBasho();

    /**
     * 開始日を取得します。
     *
     * @return RDate
     */
    public RDate getStartYMD();

    /**
     * 終了日を取得します。
     *
     * @return RDate
     */
    public RDate getEndYMD();

    /**
     * 開始時間を取得します。
     *
     * @return RTime
     */
    public RTime getStartHHMM();

    /**
     * 終了時間を取得します。
     *
     * @return RTime
     */
    public RTime getEndHHMM();

    /**
     * 口座IDを取得します。
     *
     * @return RString
     */
    public RString getKozaNo();

    /**
     * 契約番号を取得します。
     *
     * @return RString
     */
    public RString getKeiyakuNo();

    /**
     * 口座IDを取得します。
     *
     * @return RString
     */
    public RString getKozaID();

    /**
     * 支払方法情報、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck();
}
