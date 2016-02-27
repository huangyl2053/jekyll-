/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.shoukanbaraisuuchishoikkatsusakusei;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.shoukanbaraisuuchishoikkatsusakusei.ShoukanBaraiSuuchiShoIkatsuBatchParamter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shoukanbaraisuuchishoikkatsusakusei.ShoukanBaraiSuuchiShoIkatsuParamter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 償還払い支給不支給決定通知書作成画面入力するデータより、バッチ用パラメータクラスを作成する。
 */
public class ShokanbaraiShikyuFushikyuKetteiTsuchishoIkkatsuSakusei {

    /**
     * 償還払い支給不支給決定通知書作成画面入力を印刷します。
     *
     * @param paramter ShoukanBaraiSuuchiShoIkatsuParamter
     * @return {@link ShoukanBaraiSuuchiShoIkatsuBatchParamter}
     */
    public ShoukanBaraiSuuchiShoIkatsuBatchParamter
            getShokanbaraiShikyuFushikyuKetteiTsuchishoBatchParameter(ShoukanBaraiSuuchiShoIkatsuParamter paramter) {
        ShoukanBaraiSuuchiShoIkatsuBatchParamter shoukanParamter = new ShoukanBaraiSuuchiShoIkatsuBatchParamter();
        shoukanParamter.set抽出モード(paramter.get抽出モード());
        if (paramter.get抽出モード().equals(new RString("1"))) {
            shoukanParamter.set抽出条件日付From(paramter.get抽出条件日付From());
        }
        if (paramter.get抽出モード().equals(new RString("2"))) {
            shoukanParamter.set抽出条件日付From(paramter.get抽出条件日付To());
        }
        if (paramter.get抽出モード().equals(new RString("1"))) {
            shoukanParamter.set抽出条件日付To(paramter.get抽出条件日付From());
        }
        if (paramter.get抽出モード().equals(new RString("2"))) {
            shoukanParamter.set抽出条件日付To(paramter.get抽出条件日付To());
        }
        shoukanParamter.set決定者受付年月(paramter.get決定者受付年月());
        shoukanParamter.set印書(paramter.get印書());
        shoukanParamter.set発行日(paramter.get発行日());
        shoukanParamter.set文書番号(paramter.get文書番号());
        if (paramter.getテスト出力フラグ().equals(new RString("0"))) {
            shoukanParamter.setテスト出力フラグ(new RString("false"));
        }
        if (paramter.getテスト出力フラグ().equals(new RString("1"))) {
            shoukanParamter.setテスト出力フラグ(new RString("true"));
        }
        shoukanParamter.set決定日一括更新区分(paramter.get決定日一括更新区分());
        shoukanParamter.set決定日(paramter.get決定日());
        if (paramter.get利用者向け決定通知書フラグ().equals(new RString("0"))) {
            shoukanParamter.set利用者向け決定通知書フラグ(new RString("false"));
        }
        if (paramter.get利用者向け決定通知書フラグ().equals(new RString("1"))) {
            shoukanParamter.set利用者向け決定通知書フラグ(new RString("true"));
        }
        if (paramter.get受領委任者向け決定通知書フラグ().equals(new RString("0"))) {
            shoukanParamter.set受領委任者向け決定通知書フラグ(new RString("false"));
        }
        if (paramter.get受領委任者向け決定通知書フラグ().equals(new RString("1"))) {
            shoukanParamter.set受領委任者向け決定通知書フラグ(new RString("true"));
        }
        shoukanParamter.set振込予定日(paramter.get振込予定日());
        shoukanParamter.set支払場所(paramter.get支払場所());
        shoukanParamter.set支払期間From(paramter.get支払期間From());
        shoukanParamter.set支払期間To(paramter.get支払期間To());
        shoukanParamter.set開始時間(paramter.get開始時間());
        shoukanParamter.set開始時間(paramter.get終了時間());
        shoukanParamter.set出力順ID(paramter.get出力順ID());
        return shoukanParamter;
    }

}
