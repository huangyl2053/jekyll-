/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB233001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb233001.TokuchouSeidoKanIFRenkeiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBB233001_特徴制度間Ｉ／Ｆ連携　のBatchParameter作成です。
 *
 * @reamsid_L DBB-1810-040 dengjiajia
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB233001_TokuchoSeidokanIFRenkeiParameter extends BatchParameterBase {

    private RString dumy;

    /**
     * コンストラクタです。
     *
     * @param dumy dumy
     */
    public DBB233001_TokuchoSeidokanIFRenkeiParameter(RString dumy) {
        this.dumy = dumy;
    }

    /**
     * コンストラクタです。
     *
     */
    public DBB233001_TokuchoSeidokanIFRenkeiParameter() {
    }

    /**
     * 連携用出力ファイル作成ファイル出力（連携用出力ファイル） のparameter作成する。
     *
     * @param 処理年度 FlexibleYear
     * @param 市町村コードリスト List<RString>
     * @return TokuchouSeidoKanIFRenkeiProcessParameter
     */
    public TokuchouSeidoKanIFRenkeiProcessParameter toTokuchouSeidoKanIFRenkeiProcessParameter(
            FlexibleYear 処理年度,
            List<RString> 市町村コードリスト) {
        return new TokuchouSeidoKanIFRenkeiProcessParameter(処理年度, 市町村コードリスト);
    }
}
