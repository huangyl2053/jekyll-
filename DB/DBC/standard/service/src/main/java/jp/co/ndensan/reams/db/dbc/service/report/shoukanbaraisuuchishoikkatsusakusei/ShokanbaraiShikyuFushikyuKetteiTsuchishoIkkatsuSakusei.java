/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.shoukanbaraisuuchishoikkatsusakusei;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC030010.DBC030010_ShokanShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shoukanbaraisuuchishoikkatsusakusei.ShoukanBaraiSuuchiShoIkatsuParamter;

/**
 *
 * 償還払い支給不支給決定通知書作成画面入力するデータより、バッチ用パラメータクラスを作成する。
 *
 * @reamsid_L DBC-1000-070 lizhuoxuan
 */
public class ShokanbaraiShikyuFushikyuKetteiTsuchishoIkkatsuSakusei {

    /**
     * 償還払い支給不支給決定通知書作成画面入力を印刷します。
     *
     * @param paramter ShoukanBaraiSuuchiShoIkatsuParamter
     * @return {@link DBC030010_ShokanShikyuKetteiTsuchishoParameter}
     */
    public DBC030010_ShokanShikyuKetteiTsuchishoParameter
            getShokanbaraiShikyuFushikyuKetteiTsuchishoBatchParameter(ShoukanBaraiSuuchiShoIkatsuParamter paramter) {
        DBC030010_ShokanShikyuKetteiTsuchishoParameter shoukanParamter = new DBC030010_ShokanShikyuKetteiTsuchishoParameter();
        shoukanParamter.set抽出モード(paramter.get抽出モード());
        shoukanParamter.set決定日付From(paramter.get決定日付From());
        shoukanParamter.set決定日付To(paramter.get決定日付To());
        shoukanParamter.set受付日付From(paramter.get受付日付From());
        shoukanParamter.set受付日付To(paramter.get受付日付To());
        shoukanParamter.set決定者受付年月(paramter.get決定者受付年月());
        shoukanParamter.set印書(paramter.get印書());
        shoukanParamter.set発行日(paramter.get発行日());
        shoukanParamter.set文書番号(paramter.get文書番号());
        shoukanParamter.setテスト出力フラグ(paramter.getテスト出力フラグ());
        shoukanParamter.set決定日一括更新区分(paramter.get決定日一括更新区分());
        shoukanParamter.set決定日(paramter.get決定日());
        shoukanParamter.set利用者向け決定通知書フラグ(paramter.get利用者向け決定通知書フラグ());
        shoukanParamter.set受領委任者向け決定通知書フラグ(paramter.get受領委任者向け決定通知書フラグ());
        shoukanParamter.set振込予定日(paramter.get振込予定日());
        shoukanParamter.set支払場所(paramter.get支払場所());
        shoukanParamter.set支払期間From(paramter.get支払期間From());
        shoukanParamter.set支払期間To(paramter.get支払期間To());
        shoukanParamter.set開始時間(paramter.get開始時間());
        shoukanParamter.set終了時間(paramter.get終了時間());
        shoukanParamter.set出力順ID(paramter.get出力順ID());
        shoukanParamter.set窓口払い一括更新区分(paramter.get窓口払い一括更新区分());
        return shoukanParamter;
    }

}
