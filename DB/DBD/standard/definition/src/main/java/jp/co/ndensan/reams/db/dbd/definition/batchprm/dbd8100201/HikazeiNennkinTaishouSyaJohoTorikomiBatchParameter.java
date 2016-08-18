/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100201;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.FuicchiCsvProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.GaitouIchirannCsvProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.NennkinnBanngouCsvProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.SeinenngappiCsvProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.TorikomiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者情報取込バッチパラメタークラスです．
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter extends BatchParameterBase {

    private static final String TAISHOUNENDO = "taishouNendo";
    private static final String SHORIKUBUNN = "shoriKubunn";
    private static final String TAISHOUMONTH = "taishouMonth";
    private static final String TESTSHORI = "testShori";
    private static final String OUTPUTKUBUNN = "outputKubunn";
    private static final String SHORISTATUS = "shoriStatus";
    private static final String KOUSEISHICHOUSONNCODELIST = "kouseiShichousonnCodeList";
    private static final String SHORIYMD = "shoriYmd";
    private static final String SHORIDATETIME = "shoriDateTime";
    private static final String OUTPUTJUNN1 = "outputJunn1";
    private static final String OUTPUTJUNN2 = "outputJunn2";
    private static final String OUTPUTJUNN3 = "outputJunn3";
    private static final String OUTPUTJUNN4 = "outputJunn4";

    @BatchParameter(key = TAISHOUNENDO, name = "処理年度")
    private FlexibleYear 処理年度;
    @BatchParameter(key = SHORIKUBUNN, name = "処理区分")
    private RString 処理区分;
    @BatchParameter(key = TAISHOUMONTH, name = "対象月")
    private RString 対象月;
    @BatchParameter(key = TESTSHORI, name = "テスト処理")
    private RString テスト処理;
    @BatchParameter(key = OUTPUTKUBUNN, name = "出力区分")
    private RString 出力区分;
    @BatchParameter(key = SHORISTATUS, name = "処理状態")
    private RString 処理状態;
    @BatchParameter(key = KOUSEISHICHOUSONNCODELIST, name = "構成市町村コードリスト")
    private List<RString> 構成市町村コードリスト;
    @BatchParameter(key = SHORIYMD, name = "処理年月日")
    private FlexibleDate 処理年月日;
    @BatchParameter(key = SHORIDATETIME, name = "処理日時")
    private YMDHMS 処理日時;
    @BatchParameter(key = OUTPUTJUNN1, name = "出力順ID1")
    private Long 出力順ID1;
    @BatchParameter(key = OUTPUTJUNN2, name = "出力順ID2")
    private Long 出力順ID2;
    @BatchParameter(key = OUTPUTJUNN3, name = "出力順ID3")
    private Long 出力順ID3;
    @BatchParameter(key = OUTPUTJUNN4, name = "出力順ID4")
    private Long 出力順ID4;

    /**
     * 取込データ一時作成_共有ファイルに取得CSVデータパラメターを取得します．
     *
     * @return 取込データ一時作成_共有ファイルに取得CSVデータパラメター
     */
    public TorikomiProcessParameter toTorikomiProcessParameter() {
        return new TorikomiProcessParameter(処理年度, 処理区分, 対象月, 構成市町村コードリスト);
    }

    /**
     * 結果一覧(該当一覧)CSV出力の引数を返します。。
     *
     * @param 出力順ID1 出力順ID1
     * @return 結果一覧(該当一覧)CSV出力の引数
     */
    public GaitouIchirannCsvProcessParameter toGaitouIchirannCsvProcessParameter(Long 出力順ID1) {
        return new GaitouIchirannCsvProcessParameter(出力順ID1);
    }

    /**
     * 結果一覧(不一致)CSV出力の引数を返します。。
     *
     * @param 出力順ID2 出力順ID2
     * @return 結果一覧(不一致)CSV出力の引数
     */
    public FuicchiCsvProcessParameter toFuicchiCsvProcessParameter(Long 出力順ID2) {
        return new FuicchiCsvProcessParameter(出力順ID2);
    }

    /**
     * 結果一覧(生年月日)CSV出力の引数を返します。。
     *
     * @param 出力順ID3 出力順ID3
     * @return 結果一覧(生年月日)CSV出力の引数
     */
    public SeinenngappiCsvProcessParameter toSeinenngappiCsvProcessParameter(Long 出力順ID3) {
        return new SeinenngappiCsvProcessParameter(出力順ID3);
    }

    /**
     * 結果一覧(年金番号)CSV出力の引数を返します。。
     *
     * @param 出力順ID4 出力順ID4
     * @return 結果一覧(年金番号)CSV出力の引数
     */
    public NennkinnBanngouCsvProcessParameter toNennkinnBanngouCsvProcessParameter(Long 出力順ID4) {
        return new NennkinnBanngouCsvProcessParameter(出力順ID4);
    }

}
