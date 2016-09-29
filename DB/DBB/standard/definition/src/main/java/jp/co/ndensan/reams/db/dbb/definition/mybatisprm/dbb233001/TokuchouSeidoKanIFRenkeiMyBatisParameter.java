/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb233001;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB233001_特徴制度間Ｉ／Ｆ連携 のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBB-1810-040 dengjiajia
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuchouSeidoKanIFRenkeiMyBatisParameter implements IMyBatisParameter {

    private final FlexibleYear 処理年度;
    private final List<RString> 市町村コードリスト;

    /**
     * コンストラクタの取得メソッドです。
     *
     * @param 処理年度 FlexibleYear
     * @param 市町村コードリスト List<RString>
     */
    public TokuchouSeidoKanIFRenkeiMyBatisParameter(
            FlexibleYear 処理年度,
            List<RString> 市町村コードリスト) {

        this.処理年度 = 処理年度;
        this.市町村コードリスト = 市町村コードリスト;
    }
}
