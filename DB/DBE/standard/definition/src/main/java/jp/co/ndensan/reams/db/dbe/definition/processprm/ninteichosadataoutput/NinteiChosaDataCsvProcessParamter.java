/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput.NinteiChosaDataOutputCsvMybitisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査データ出力（モバイル）のCSV出力のためのProcess用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaDataCsvProcessParamter implements IBatchProcessParameter {

    private final RString csvTempTableName;
    private final RString csvTempTableNameZenkai;
    private final RString ninteichosaItakusakiCode;
    private final RString ninteiChosainCode;
    private final List<RString> shinseishoKanriNoList;
    private final RString shichosonCode;
    private final List<RString> hihokenshaNoList;

    /**
     * コンストラクタです。
     *
     * @param csvTempTableName CSV一時テーブル名
     * @param csvTempTableNameZenkai CSV一時テーブル名（前回）
     * @param ninteichosaItakusakiCode 認定調査委託先コード
     * @param ninteiChosainCode 認定調査員コード
     * @param shinseishoKanriNoList 申請書管理番号リスト
     * @param shichosonCode 市町村コード
     * @param hihokenshaNoList 被保険者番号リスト
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public NinteiChosaDataCsvProcessParamter(
            RString csvTempTableName,
            RString csvTempTableNameZenkai,
            RString ninteichosaItakusakiCode,
            RString ninteiChosainCode,
            List<RString> shinseishoKanriNoList,
            RString shichosonCode,
            List<RString> hihokenshaNoList) {
        this.csvTempTableName = csvTempTableName;
        this.csvTempTableNameZenkai = csvTempTableNameZenkai;
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
        this.ninteiChosainCode = ninteiChosainCode;
        this.shinseishoKanriNoList = shinseishoKanriNoList;
        this.shichosonCode = shichosonCode;
        this.hihokenshaNoList = hihokenshaNoList;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return NinteiChosaDataOutputBatchMybitisParameter
     */
    public NinteiChosaDataOutputCsvMybitisParameter toNinteiChosaDataOutputCsvMybitisParameter() {
        return NinteiChosaDataOutputCsvMybitisParameter.createSelectByKeyParam(csvTempTableName, csvTempTableNameZenkai);
    }

}
