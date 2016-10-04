/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD301010;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.FileReaderProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.FuicchiCsvProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.GaitouIchirannCsvProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.HikazeiNennkinDeleteProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.NennkinnBanngouCsvProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.SeinenngappiCsvProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.SyoriHidukeKanriMasterUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.TorikomiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
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
public class DBD301010_HikazeiNenkinTaishoshaJohoTorikomiParameter extends BatchParameterBase {

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
     * ファイル取込のParameterです。
     *
     * @return FileReaderProcessParameter
     */
    public FileReaderProcessParameter toFileReaderProcessParameter() {
        return new FileReaderProcessParameter(処理年度, 処理区分, 対象月, 構成市町村コードリスト);
    }

    /**
     * 取込データ一時作成_共有ファイルに取得CSVデータパラメターを取得します．
     *
     * @param entry UzT0885SharedFileEntryEntity
     * @return 取込データ一時作成_共有ファイルに取得CSVデータパラメター
     */
    public TorikomiProcessParameter toTorikomiProcessParameter(UzT0885SharedFileEntryEntity entry) {
        return new TorikomiProcessParameter(処理年度, 処理区分, 対象月, 構成市町村コードリスト, entry);
    }

    /**
     * 結果一覧(該当一覧)CSV出力の引数を返します。。
     *
     * @return 結果一覧(該当一覧)CSV出力の引数
     */
    public GaitouIchirannCsvProcessParameter toGaitouIchirannCsvProcessParameter() {
        return new GaitouIchirannCsvProcessParameter(出力順ID1);
    }

    /**
     * 結果一覧(不一致)CSV出力の引数を返します。。
     *
     * @return 結果一覧(不一致)CSV出力の引数
     */
    public FuicchiCsvProcessParameter toFuicchiCsvProcessParameter() {
        return new FuicchiCsvProcessParameter(出力順ID2);
    }

    /**
     * 結果一覧(生年月日)CSV出力の引数を返します。。
     *
     * @return 結果一覧(生年月日)CSV出力の引数
     */
    public SeinenngappiCsvProcessParameter toSeinenngappiCsvProcessParameter() {
        return new SeinenngappiCsvProcessParameter(出力順ID3);
    }

    /**
     * 結果一覧(年金番号)CSV出力の引数を返します。。
     *
     * @return 結果一覧(年金番号)CSV出力の引数
     */
    public NennkinnBanngouCsvProcessParameter toNennkinnBanngouCsvProcessParameter() {
        return new NennkinnBanngouCsvProcessParameter(出力順ID4);
    }

    /**
     * 削除非課税年金対象者
     *
     * @return HikazeiNennkinDeleteProcessParameter
     */
    public HikazeiNennkinDeleteProcessParameter toHikazeiNennkinDeleteProcessParameter() {
        return new HikazeiNennkinDeleteProcessParameter(処理年度, 処理区分, 対象月);
    }

    /**
     * 処理日付管理マスタ更新
     *
     * @return SyoriHidukeKanriMasterUpdateProcessParameter
     */
    public SyoriHidukeKanriMasterUpdateProcessParameter toSyoriHidukeKanriMasterUpdateProcessParameter() {
        return new SyoriHidukeKanriMasterUpdateProcessParameter(処理年度, 処理区分, 対象月, 処理年月日, 処理日時);
    }
}
