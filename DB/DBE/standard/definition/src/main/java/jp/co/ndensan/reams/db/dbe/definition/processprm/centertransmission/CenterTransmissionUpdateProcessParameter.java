/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionUpdateMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * センター送信データ作成のProcessParameterクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CenterTransmissionUpdateProcessParameter implements IBatchProcessParameter {

    private final List<RString> 申請書管理番号リスト;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト 申請書管理番号リスト
     */
    public CenterTransmissionUpdateProcessParameter(List<RString> 申請書管理番号リスト) {
        this.申請書管理番号リスト = 申請書管理番号リスト;
    }

    /**
     * CenterTransmissionUpdateMybitisParamterに転換します。
     *
     * @return CenterTransmissionUpdateMybitisParamter
     */
    public CenterTransmissionUpdateMybitisParamter toCenterTransmissionUpdateMybitisParamter() {
        CenterTransmissionUpdateMybitisParamter paramter = new CenterTransmissionUpdateMybitisParamter();
        paramter.setShinseishoKanriNoList(申請書管理番号リスト);
        return paramter;
    }
}
