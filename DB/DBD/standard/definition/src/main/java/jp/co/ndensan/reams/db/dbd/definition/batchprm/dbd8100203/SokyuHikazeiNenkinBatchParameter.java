/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100203;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100203.SokyuuFuicchiCsvProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100203.SokyuuGaitouIchirannCsvProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100203.SokyuuSeinenngappiCsvProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 遡及非課税年金対象者同定のバッチパラメタークラスです．
 *
 * @reamsid_L DBD-4910-050 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokyuHikazeiNenkinBatchParameter extends BatchParameterBase {

    private static final String TAISHOUNENDO = "taishouNendo";
    private static final String SHORIKUBUNN = "shoriKubunn";
    private static final String TAISHOUMONTH = "taishouMonth";
    private static final String TESTSHORI = "testShori";
    private static final String OUTPUTJUNN1 = "outputJunn1";
    private static final String OUTPUTJUNN2 = "outputJunn2";
    private static final String OUTPUTJUNN3 = "outputJunn3";
    private static final String OUTPUTJUNN4 = "outputJunn4";

    @BatchParameter(key = TAISHOUNENDO, name = "処理年度")
    private FlexibleYear 処理年度;
    @BatchParameter(key = SHORIKUBUNN, name = "処理区分")
    private RString 処理区分;
    @BatchParameter(key = TAISHOUMONTH, name = "処理月")
    private RString 処理月;
    @BatchParameter(key = TESTSHORI, name = "テスト処理")
    private RString テスト処理;
    @BatchParameter(key = OUTPUTJUNN1, name = "出力順ID1")
    private Long 出力順ID1;
    @BatchParameter(key = OUTPUTJUNN2, name = "出力順ID2")
    private Long 出力順ID2;
    @BatchParameter(key = OUTPUTJUNN3, name = "出力順ID3")
    private Long 出力順ID3;
    @BatchParameter(key = OUTPUTJUNN4, name = "出力順ID4")
    private Long 出力順ID4;

    /**
     * 結果一覧(遡及該当)CSV出力の引数を返します。。
     *
     * @return 結果一覧(遡及該当)CSV出力
     */
    public SokyuuGaitouIchirannCsvProcessParameter toSokyuuGaitouIchirannCsvProcessParameter() {
        return new SokyuuGaitouIchirannCsvProcessParameter(出力順ID1);
    }

    /**
     * 結果一覧(遡及不一致)CSV出力の引数を返します。。
     *
     * @return 結果一覧(遡及不一致)CSV出力
     */
    public SokyuuFuicchiCsvProcessParameter toSokyuuFuicchiCsvProcessParameter() {
        return new SokyuuFuicchiCsvProcessParameter(出力順ID2);
    }

    /**
     * 結果一覧(生年月日)CSV出力の引数を返します。。
     *
     * @return 結果一覧(生年月日)CSV出力
     */
    public SokyuuSeinenngappiCsvProcessParameter toSokyuuSeinenngappiCsvProcessParameter() {
        return new SokyuuSeinenngappiCsvProcessParameter(出力順ID3);
    }
}
