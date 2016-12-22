/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査データ出力（モバイル）CSV出力のためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class NinteiChosaDataOutputCsvMybitisParameter implements IMyBatisParameter {

    private final RString csvTempTableName;
    private final RString csvTempTableNameZenkai;

    private NinteiChosaDataOutputCsvMybitisParameter(
            RString csvTempTableName, RString csvTempTableNameZenkai) {
        this.csvTempTableName = csvTempTableName;
        this.csvTempTableNameZenkai = csvTempTableNameZenkai;
    }

    /**
     * パラメータを取得します。
     *
     * @param csvTempTableName CSV一時テーブル名
     * @param csvTempTableNameZenkai CSV一時テーブル名（前回）
     * @return バッチパラメータ
     */
    public static NinteiChosaDataOutputCsvMybitisParameter createSelectByKeyParam(RString csvTempTableName, RString csvTempTableNameZenkai) {
        return new NinteiChosaDataOutputCsvMybitisParameter(csvTempTableName, csvTempTableNameZenkai);
    }

}
