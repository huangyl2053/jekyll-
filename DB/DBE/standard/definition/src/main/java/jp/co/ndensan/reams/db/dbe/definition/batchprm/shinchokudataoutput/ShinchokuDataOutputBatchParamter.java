/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.shinchokudataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinchokudataoutput.ShinchokuDataOutputProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBE491001_日次進捗データ作成ですためのBatch用パラメータクラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShinchokuDataOutputBatchParamter extends BatchParameterBase {

    private static final String SHINSEISHOLANRINOLIST = "shinseishoKanriNoList";
    private static final String FAYIRUKUBEN = "fayirukuben";
    @BatchParameter(key = SHINSEISHOLANRINOLIST, name = "申請書管理番号リスト")
    private List<RString> shinseishoKanriNoList;
    @BatchParameter(key = FAYIRUKUBEN, name = "ファイル区分")
    private RString fayirukuben;

    /**
     * コンストラクタです。
     */
    public ShinchokuDataOutputBatchParamter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号リスト List<RString>
     * @param ファイル区分 RString
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public ShinchokuDataOutputBatchParamter(
            List<RString> 申請書管理番号リスト,
            RString ファイル区分) {
        this.shinseishoKanriNoList = 申請書管理番号リスト;
        this.fayirukuben = ファイル区分;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return KaigoNinteiShinsakaiScheduleProcessParamter
     */
    public ShinchokuDataOutputProcessParamter toShinchokuDataOutputProcessParamter() {
        return new ShinchokuDataOutputProcessParamter(shinseishoKanriNoList, fayirukuben);
    }
}
