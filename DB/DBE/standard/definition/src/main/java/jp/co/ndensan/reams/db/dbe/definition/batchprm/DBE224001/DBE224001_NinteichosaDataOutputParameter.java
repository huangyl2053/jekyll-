/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE224001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput.NinteiChosaDataCsvProcessParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput.NinteiChosaDataOutputProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 認定調査データ出力（モバイル）ですためのバッチ用パラメータクラスです。
 *
 * @reamsid_L DBE-1860-011 duanzhanli
 */
@Getter
@Setter
public class DBE224001_NinteichosaDataOutputParameter extends BatchParameterBase {

    private static final String NINTEICHOSAITAKUSAKICODE = "ninteichosaItakusakiCode";
    private static final String NINTEICHOSAINCODE = "ninteiChosainCode";
    private static final String SHINSEISHOKANRINOLIST = "shinseishoKanriNoList";
    private static final String SHICHOSONCODE = "shichosonCode";
    @BatchParameter(key = NINTEICHOSAITAKUSAKICODE, name = "認定調査委託先コード")
    private RString ninteichosaItakusakiCode;
    @BatchParameter(key = NINTEICHOSAINCODE, name = "認定調査員コード")
    private RString ninteiChosainCode;
    @BatchParameter(key = SHINSEISHOKANRINOLIST, name = "申請書管理番号リスト")
    private List<RString> shinseishoKanriNoList;
    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private RString shichosonCode;

    /**
     * コンストラクタです。
     */
    public DBE224001_NinteichosaDataOutputParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @param 市町村コード 市町村コード
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public DBE224001_NinteichosaDataOutputParameter(
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            List<RString> 申請書管理番号リスト,
            RString 市町村コード) {
        this.ninteichosaItakusakiCode = 認定調査委託先コード;
        this.ninteiChosainCode = 認定調査員コード;
        this.shinseishoKanriNoList = 申請書管理番号リスト;
        this.shichosonCode = 市町村コード;
    }

    /**
     * NinteiChosaDataOutputProcessParamterを作成します。
     *
     * @param csvTempTableName 一時テーブル名
     *
     * @return NinteiChosaDataOutputProcessParamter
     */
    public NinteiChosaDataOutputProcessParamter toNinteiChosaDataOutputProcessParamter(RString csvTempTableName) {
        return new NinteiChosaDataOutputProcessParamter(ninteichosaItakusakiCode,
                ninteiChosainCode,
                shinseishoKanriNoList,
                shichosonCode,
                csvTempTableName);
    }

    /**
     * NinteiChosaDataOutputProcessParamterを作成します。
     *
     * @param csvTempTableName 一時テーブル名
     * @param shinseishoKanriNoList List<RString>
     *
     * @return NinteiChosaDataOutputProcessParamter
     */
    public NinteiChosaDataOutputProcessParamter toNinteiChosaDataOutputProcessParamter(
            RString csvTempTableName, List<RString> shinseishoKanriNoList) {
        return new NinteiChosaDataOutputProcessParamter(ninteichosaItakusakiCode,
                ninteiChosainCode,
                shinseishoKanriNoList,
                shichosonCode,
                csvTempTableName);
    }

    /**
     * 認定調査データ出力（モバイル）のCSV出力のためのProcess用パラメータを取得します。
     *
     * @param csvTempTableName CSV一時テーブル名
     * @param csvTempTableNameZenkai CSV一時テーブル名（前回）
     * @return 認定調査データ出力（モバイル）のCSV出力のためのProcess用パラメータ取得
     */
    public NinteiChosaDataCsvProcessParamter toNinteiChosaDataCsvProcessParamter(
            RString csvTempTableName, RString csvTempTableNameZenkai) {
        return new NinteiChosaDataCsvProcessParamter(
                csvTempTableName, csvTempTableNameZenkai,
                this.ninteichosaItakusakiCode, this.ninteiChosainCode, this.shinseishoKanriNoList, this.shichosonCode);
    }

}
