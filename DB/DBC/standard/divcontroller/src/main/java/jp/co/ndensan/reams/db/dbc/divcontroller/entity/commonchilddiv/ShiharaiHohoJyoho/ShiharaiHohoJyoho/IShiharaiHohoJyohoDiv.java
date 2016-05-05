package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IShiharaiHohoJyohoDiv extends ICommonChildDivBaseProperties {

    void initialize(SikyuSinseiJyohoParameter 支給申請情報, KamokuCode 業務内区分コード, RString 状態);

    /**
     * 支払方法を返します。
     *
     * @return RString
     */
    RString getShiharaiHoho();

    /**
     * 支払方法を返します。
     *
     * @return RString
     */
    RString getShiharaiHohoRad();

    /**
     * 支払場所を返します。
     *
     * @return RString
     */
    RString getShiharaiBasho();

    /**
     * 開始日を返します。
     *
     * @return RDate
     */
    RDate getStartYMD();

    /**
     * 終了日を返します。
     *
     * @return RDate
     */
    RDate getEndYMD();

    /**
     * 開始時間を返します。
     *
     * @return RTime
     */
    RTime getStartHHMM();

    /**
     * 終了時間を返します。
     *
     * @return RTime
     */
    RTime getEndHHMM();

    /**
     * 口座番号を返します。
     *
     * @return RString
     */
    RString getKozaNo();

    /**
     * 契約番号を返します。
     *
     * @return RString
     */
    RString getKeiyakuNo();

    /**
     * 口座IDを返します。
     *
     * @return 口座ID
     */
    RString getKozaID();

}
