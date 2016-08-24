/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.jizenshinsakaishiryopublication;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員事前審査 のコントローラです。
 *
 * @reamsid_L DBE-1630-010 dangjingjing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class JizenShinsakaiShiryoPublicationMybitisParamter implements IMyBatisParameter {

    private final RString shinsakaiKaisaiNo;

    public JizenShinsakaiShiryoPublicationMybitisParamter(RString shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * Mybatisパラメータクラスです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     * @return IJizenShinsakaiShiryoPublicationMybitisParamter 介護認定審査会委員事前審査のMybatisパラメータクラス
     */
    public static JizenShinsakaiShiryoPublicationMybitisParamter createParamter(RString shinsakaiKaisaiNo) {
        boolean shinsakaiKaisaiNoFlag = false;
        if (!shinsakaiKaisaiNo.isEmpty()) {
            shinsakaiKaisaiNoFlag = true;
        }
        return new JizenShinsakaiShiryoPublicationMybitisParamter(shinsakaiKaisaiNo);
    }
}
