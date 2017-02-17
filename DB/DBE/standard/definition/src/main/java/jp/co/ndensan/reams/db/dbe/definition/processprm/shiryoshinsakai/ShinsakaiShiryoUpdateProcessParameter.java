/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.ShinsakaiShiryoUpdateMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用一次判定結果情報のProcessParameterです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiShiryoUpdateProcessParameter implements IBatchProcessParameter {

    private RString shinsakaiKaisaiNo;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     */
    public ShinsakaiShiryoUpdateProcessParameter(
            RString shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * 審査会資料作成の更新に関する基本情報のMyBatisParameterに転換します。
     *
     * @return ShinsakaiShiryoUpadateMyBatisParameter
     */
    public ShinsakaiShiryoUpdateMyBatisParameter toShinsakaiShiryoUpdateMyBatisParameter() {
        return new ShinsakaiShiryoUpdateMyBatisParameter(shinsakaiKaisaiNo);
    }
}
