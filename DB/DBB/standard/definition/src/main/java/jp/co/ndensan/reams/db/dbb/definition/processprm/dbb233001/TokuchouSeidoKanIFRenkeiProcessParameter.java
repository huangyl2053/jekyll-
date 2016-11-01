/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb233001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb233001.TokuchouSeidoKanIFRenkeiMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB233001_特徴制度間Ｉ／Ｆ連携　のProcessParameter作成です。
 *
 * @reamsid_L DBB-1810-040 dengjiajia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchouSeidoKanIFRenkeiProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 処理年度;
    private List<RString> 市町村コードリスト;

    /**
     * コンストラクタの取得メソッドです。
     *
     * @param 処理年度 FlexibleYear
     * @param 市町村コードリスト List<RString>
     */
    public TokuchouSeidoKanIFRenkeiProcessParameter(FlexibleYear 処理年度,
            List<RString> 市町村コードリスト) {
        this.処理年度 = 処理年度;
        this.市町村コードリスト = 市町村コードリスト;
    }

    /**
     * TokuchouSeidoKanIFRenkeiMyBatisParameterの取得メソッドです。
     *
     * @return ZennenTaihiHyoMyBatisParameter
     */
    public TokuchouSeidoKanIFRenkeiMyBatisParameter toTokuchouSeidoKanIFRenkeiMyBatisParameter() {
        return new TokuchouSeidoKanIFRenkeiMyBatisParameter(処理年度, 市町村コードリスト);
    }

}
