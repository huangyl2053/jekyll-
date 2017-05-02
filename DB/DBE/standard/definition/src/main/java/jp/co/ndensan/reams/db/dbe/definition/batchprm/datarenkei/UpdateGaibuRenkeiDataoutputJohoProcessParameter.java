/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.datarenkei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionUpdateMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
public class UpdateGaibuRenkeiDataoutputJohoProcessParameter implements IBatchProcessParameter {

    private final List<RString> shinseishoKanriNos;
    private final RenkeiDataType renkeiDataType;
    private final FlexibleDate operationDate;

    public UpdateGaibuRenkeiDataoutputJohoProcessParameter(List<RString> shinseishoKanriNos, RenkeiDataType renkeiDataType, FlexibleDate operationDate) {
        this.shinseishoKanriNos = java.util.Collections.unmodifiableList(shinseishoKanriNos);
        this.renkeiDataType = renkeiDataType;
        this.operationDate = operationDate;
    }

    /**
     * @return 出力する連携データの種類
     */
    public RenkeiDataType getRenkeiDataType() {
        return this.renkeiDataType;
    }

    /**
     * @return データ出力の処理日
     */
    public FlexibleDate getOperationDate() {
        return this.operationDate;
    }

    /**
     * @return 保持する申請書管理番号のビュー(編集可能)
     */
    public List<RString> getShinseishoKanriNos() {
        return new ArrayList<>(this.shinseishoKanriNos);
    }

    /**
     * 出力する連携データの種類です。
     */
    public enum RenkeiDataType {

        /**
         * 審査会結果情報
         */
        審査会結果,
        /**
         * センター送信
         */
        センター送信;

    }

    /**
     * CenterTransmissionUpdateMybitisParamterに転換します。
     *
     * @return CenterTransmissionUpdateMybitisParamter
     */
    public CenterTransmissionUpdateMybitisParamter toCenterTransmissionUpdateMybitisParamter() {
        CenterTransmissionUpdateMybitisParamter paramter = new CenterTransmissionUpdateMybitisParamter();
        paramter.setShinseishoKanriNoList(shinseishoKanriNos);
        return paramter;
    }
}
