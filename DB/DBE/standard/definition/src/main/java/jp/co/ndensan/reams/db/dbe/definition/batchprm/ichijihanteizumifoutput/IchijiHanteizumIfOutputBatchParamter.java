/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.ichijihanteizumifoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ichijihanteizumifoutput.IchijiHanteizumIfOutputProcessParamter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBE309001_一次判定IF作成のバッチフロークラスです。
 *
 * @reamsid_L DBE-1470-021 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class IchijiHanteizumIfOutputBatchParamter extends BatchParameterBase {

    private static final String SHINSEISHOLANRINOLIST = "shinseishoKanriNoList";
    @BatchParameter(key = SHINSEISHOLANRINOLIST, name = "申請書管理番号リスト")
    private List<ShinseishoKanriNo> shinseishoKanriNoList;

    /**
     * コンストラクタです。
     */
    public IchijiHanteizumIfOutputBatchParamter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト List<ShinseishoKanriNo>
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public IchijiHanteizumIfOutputBatchParamter(
            List<ShinseishoKanriNo> 申請書管理番号リスト) {
        this.shinseishoKanriNoList = 申請書管理番号リスト;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return IchijiHanteizumIfOutputProcessParamter
     */
    public IchijiHanteizumIfOutputProcessParamter toIchijiHanteizumIfOutputProcessParamter() {
        return new IchijiHanteizumIfOutputProcessParamter(shinseishoKanriNoList);
    }
}
