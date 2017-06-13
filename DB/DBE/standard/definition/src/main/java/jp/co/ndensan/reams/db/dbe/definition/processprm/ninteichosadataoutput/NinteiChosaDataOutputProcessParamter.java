/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput.NinteiChosaDataOutputBatchMybitisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査データ出力（モバイル）ですためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-1860-011 duanzhanli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaDataOutputProcessParamter implements IBatchProcessParameter {

    private final RString ninteichosaItakusakiCode;
    private final RString ninteiChosainCode;
    private final List<RString> shinseishoKanriNoList;
    private final RString shichosonCode;
    private final RString csvTempTableName;
    private final RString addedFileName;
    private final RString tempFilePath;

    /**
     * コンストラクタです。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @param 市町村コード 市町村コード
     * @param csvTempTableName CSV一時テーブル名
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public NinteiChosaDataOutputProcessParamter(
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            List<RString> 申請書管理番号リスト,
            RString 市町村コード,
            RString csvTempTableName) {
        this.ninteichosaItakusakiCode = 認定調査委託先コード;
        this.ninteiChosainCode = 認定調査員コード;
        this.shinseishoKanriNoList = 申請書管理番号リスト;
        this.shichosonCode = 市町村コード;
        this.csvTempTableName = csvTempTableName;
        this.addedFileName = RString.EMPTY;
        this.tempFilePath = RString.EMPTY;
    }

    /**
     * コンストラクタです。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @param 市町村コード 市町村コード
     * @param csvTempTableName CSV一時テーブル名
     * @param addedFileName
     * @param tempFilePath
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public NinteiChosaDataOutputProcessParamter(
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            List<RString> 申請書管理番号リスト,
            RString 市町村コード,
            RString csvTempTableName,
            RString addedFileName,
            RString tempFilePath) {
        this.ninteichosaItakusakiCode = 認定調査委託先コード;
        this.ninteiChosainCode = 認定調査員コード;
        this.shinseishoKanriNoList = 申請書管理番号リスト;
        this.shichosonCode = 市町村コード;
        this.csvTempTableName = csvTempTableName;
        this.addedFileName = addedFileName;
        this.tempFilePath = tempFilePath;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return NinteiChosaDataOutputBatchMybitisParameter
     */
    public NinteiChosaDataOutputBatchMybitisParameter toNinteiChosaDataOutputBatchMybitisParameter() {
        return NinteiChosaDataOutputBatchMybitisParameter.createSelectByKeyParam(ninteichosaItakusakiCode,
                ninteiChosainCode,
                shinseishoKanriNoList,
                shichosonCode,
                csvTempTableName);
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return NinteiChosaDataOutputBatchMybitisParameter
     */
    public NinteiChosaDataOutputBatchMybitisParameter to認定調査員取得Parameter() {
        return NinteiChosaDataOutputBatchMybitisParameter.createSelectByKeyParam(ninteichosaItakusakiCode,
                null,
                null,
                shichosonCode,
                null);
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @param 広域保険者市町村コード
     * @return NinteiChosaDataOutputBatchMybitisParameter
     */
    public NinteiChosaDataOutputBatchMybitisParameter to認定調査員取得Parameter(RString 広域保険者市町村コード) {
        return NinteiChosaDataOutputBatchMybitisParameter.createSelectByKeyParam(ninteichosaItakusakiCode,
                null,
                null,
                shichosonCode,
                null,
                広域保険者市町村コード);
    }
}
