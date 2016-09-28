/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuCsvFileReadProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費通知書作成(一括)のProcessクラスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public class KyufuhiTsuchishoReadCsvFileProcess extends BatchProcessBase<RString> {

    /**
     * CSVファイル取込後の返したエンティティ
     */
    private static final RString 介護給付費福祉用具貸与品目一時_TABLE_NAME = new RString("KaigoKyufuHiFukushiYouguTemp");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;
    private static final RString 種別 = new RString("F1");
    private KokuhorenkyotsuCsvFileReadProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }
    OutputParameter<FlowEntity> flowEntity;
    Boolean flag;
    private final RString 区切り文字 = new RString(",");
    private KyufuhiTuchiHakkoCsvEntity hakkoCsvEntity;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 介護給付費福祉用具貸与品目一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;

    @Override
    protected void initialize() {
        flag = false;
        hakkoCsvEntity = new KyufuhiTuchiHakkoCsvEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.get保存先パース());
    }

    @Override
    protected void createWriter() {
        介護給付費福祉用具貸与品目一時tableWriter
                = new BatchEntityCreatedTempTableWriter(介護給付費福祉用具貸与品目一時_TABLE_NAME,
                        KyufuhiTuchiHakkoIchiranRelateEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void process(RString line) {
        flag = true;
        List<RString> data = line.split(区切り文字.toString());
        hakkoCsvEntity = ListToObjectMappingHelper.
                toObject(KyufuhiTuchiHakkoCsvEntity.class, data);
        if (new RString("2").equals(hakkoCsvEntity.getレコード種別()) && (種別).equals(hakkoCsvEntity.get帳票レコード種別())) {
            前データを一時TBLに登録する(hakkoCsvEntity);
        }
    }

    @Override
    protected void afterExecute() {
        if (!flag) {
            DbWT0002KokuhorenTorikomiErrorEntity errorEntity = new DbWT0002KokuhorenTorikomiErrorEntity();
            errorEntity.setエラー区分(new RString("99"));
            errorEntity.set証記載保険者番号(RString.EMPTY);
            errorEntity.set被保険者番号(RString.EMPTY);
            errorEntity.setキー1(RString.EMPTY);
            errorEntity.setキー2(RString.EMPTY);
            errorEntity.setキー3(RString.EMPTY);
            errorEntity.setキー4(RString.EMPTY);
            errorEntity.setキー5(RString.EMPTY);
            errorEntity.set被保険者カナ氏名(RString.EMPTY);
            errorEntity.set被保険者氏名(RString.EMPTY);
            errorEntity.set備考(RString.EMPTY);
            処理結果リスト一時tableWriter.insert(errorEntity);
        }
    }

    private void 前データを一時TBLに登録する(KyufuhiTuchiHakkoCsvEntity chiranCsvEntity) {
        KyufuhiTuchiHakkoIchiranRelateEntity 登録Entity = new KyufuhiTuchiHakkoIchiranRelateEntity();
        登録Entity.setRekodoShubetsu(chiranCsvEntity.getレコード種別());
        登録Entity.setRekodoNo(chiranCsvEntity.getレコード番号());
        登録Entity.setKoukanJouhouSikibetuNo(chiranCsvEntity.get交換情報識別番号());
        登録Entity.setTyouhyouRekodoShubetsu(chiranCsvEntity.get帳票レコード種別());
        登録Entity.setHokenShaNo(chiranCsvEntity.get保険者番号());
        登録Entity.setShokisaiHokenshaNo(chiranCsvEntity.get証記載保険者番号());
        登録Entity.setHiHokenshaNo(chiranCsvEntity.get被保険者番号());
        登録Entity.setServiceTeikyoYM(get年月日(chiranCsvEntity.getサービス提供年月()));
        登録Entity.setJigyoshoNo(chiranCsvEntity.get事業所番号());
        登録Entity.setJigyoshoKanji(chiranCsvEntity.get事業所名_漢字());
        登録Entity.setServiceShuruiCode(chiranCsvEntity.getサービス種類コード());
        登録Entity.setServiceKomokuCode(chiranCsvEntity.getサービス項目コード());
        登録Entity.setServiceRyakushou(chiranCsvEntity.getサービス略称());
        登録Entity.setCctaCode(chiranCsvEntity.getＣＣＴＡコード());
        登録Entity.setFukushiYouguKaHinmokuCode(chiranCsvEntity.get福祉用具貸与品目コード());
        登録Entity.setFukushiYouguShouhin(chiranCsvEntity.get福祉用具商品名());
        登録Entity.setHiyouGaku(getDecimal(chiranCsvEntity.get費用額()));
        登録Entity.setKibouKouriKakaku(chiranCsvEntity.get希望小売価格());
        登録Entity.setZenkokuSeikyuKensu(chiranCsvEntity.get全国請求件数());
        登録Entity.setZenkokuSaiteiHiyouGaku(getDecimal(chiranCsvEntity.get全国最低費用額()));
        登録Entity.setZenkokuShikiHiyouGaku(getDecimal(chiranCsvEntity.get全国最頻費用額()));
        登録Entity.setZenkokuSaikouHiyouGaku(getDecimal(chiranCsvEntity.get全国最高費用額()));
        登録Entity.setZenkokuHeikinHiyouGaku(getDecimal(chiranCsvEntity.get全国平均費用額()));
        登録Entity.setTodoufukenSeikyuKensu(chiranCsvEntity.get都道府県請求件数());
        登録Entity.setTodoufukenSaiteiHiyouGaku(getDecimal(chiranCsvEntity.get都道府県最低費用額()));
        登録Entity.setTodoufukenShikiHiyouGaku(getDecimal(chiranCsvEntity.get都道府県最頻費用額()));
        登録Entity.setTodoufukenSaikouHiyouGaku(getDecimal(chiranCsvEntity.get都道府県最高費用額()));
        登録Entity.setTodoufukenHeikinHiyouGaku(getDecimal(chiranCsvEntity.get都道府県平均費用額()));
        登録Entity.setHokenShaSeikyuKensu(chiranCsvEntity.get保険者請求件数());
        登録Entity.setHokenShaSaiteiHiyouGaku(getDecimal(chiranCsvEntity.get保険者最低費用額()));
        登録Entity.setHokenShaShikiHiyouGaku(getDecimal(chiranCsvEntity.get保険者最頻費用額()));
        登録Entity.setHokenShaSaikouHiyouGaku(getDecimal(chiranCsvEntity.get保険者最高費用額()));
        登録Entity.setHokenShaHeikinHiyouGaku(getDecimal(chiranCsvEntity.get保険者平均費用額()));
        登録Entity.setZenkokuTanisuHani1(getDecimal(chiranCsvEntity.get全国単位数範囲１()));
        登録Entity.setZenkokuTanisuHani2(getDecimal(chiranCsvEntity.get全国単位数範囲２()));
        登録Entity.setZenkokuTanisuHani3(getDecimal(chiranCsvEntity.get全国単位数範囲３()));
        登録Entity.setZenkokuTanisuHani4(getDecimal(chiranCsvEntity.get全国単位数範囲４()));
        登録Entity.setZenkokuTanisuHani5(getDecimal(chiranCsvEntity.get全国単位数範囲５()));
        登録Entity.setZenkokuTanisuHani6(getDecimal(chiranCsvEntity.get全国単位数範囲６()));
        登録Entity.setZenkokuTanisuHani7(getDecimal(chiranCsvEntity.get全国単位数範囲７()));
        登録Entity.setZenkokuTanisuHani8(getDecimal(chiranCsvEntity.get全国単位数範囲８()));
        登録Entity.setZenkokuTanisuHani9(getDecimal(chiranCsvEntity.get全国単位数範囲９()));
        登録Entity.setZenkokuTanisuHani10(getDecimal(chiranCsvEntity.get全国単位数範囲１０()));
        登録Entity.setZenkokuTanisuHani1Dosu(getDecimal(chiranCsvEntity.get全国単位数範囲１の度数()));
        登録Entity.setZenkokuTanisuHani2Dosu(getDecimal(chiranCsvEntity.get全国単位数範囲２の度数()));
        登録Entity.setZenkokuTanisuHani3Dosu(getDecimal(chiranCsvEntity.get全国単位数範囲３の度数()));
        登録Entity.setZenkokuTanisuHani4Dosu(getDecimal(chiranCsvEntity.get全国単位数範囲４の度数()));
        登録Entity.setZenkokuTanisuHani5Dosu(getDecimal(chiranCsvEntity.get全国単位数範囲５の度数()));
        登録Entity.setZenkokuTanisuHani6Dosu(getDecimal(chiranCsvEntity.get全国単位数範囲６の度数()));
        登録Entity.setZenkokuTanisuHani7Dosu(getDecimal(chiranCsvEntity.get全国単位数範囲７の度数()));
        登録Entity.setZenkokuTanisuHani8Dosu(getDecimal(chiranCsvEntity.get全国単位数範囲８の度数()));
        登録Entity.setZenkokuTanisuHani9Dosu(getDecimal(chiranCsvEntity.get全国単位数範囲９の度数()));
        登録Entity.setZenkokuTanisuHani10Dosu(getDecimal(chiranCsvEntity.get全国単位数範囲１０の度数()));
        登録Entity.setTodoufukenTanisuHani1(getDecimal(chiranCsvEntity.get都道府県単位数範囲１()));
        登録Entity.setTodoufukenTanisuHani2(getDecimal(chiranCsvEntity.get都道府県単位数範囲２()));
        登録Entity.setTodoufukenTanisuHani3(getDecimal(chiranCsvEntity.get都道府県単位数範囲３()));
        登録Entity.setTodoufukenTanisuHani4(getDecimal(chiranCsvEntity.get都道府県単位数範囲４()));
        登録Entity.setTodoufukenTanisuHani5(getDecimal(chiranCsvEntity.get都道府県単位数範囲５()));
        登録Entity.setTodoufukenTanisuHani6(getDecimal(chiranCsvEntity.get都道府県単位数範囲６()));
        登録Entity.setTodoufukenTanisuHani7(getDecimal(chiranCsvEntity.get都道府県単位数範囲７()));
        登録Entity.setTodoufukenTanisuHani8(getDecimal(chiranCsvEntity.get都道府県単位数範囲８()));
        登録Entity.setTodoufukenTanisuHani9(getDecimal(chiranCsvEntity.get都道府県単位数範囲９()));
        登録Entity.setTodoufukenTanisuHani10(getDecimal(chiranCsvEntity.get都道府県単位数範囲１０()));
        登録Entity.setTodoufukenTanisuHani1Dosu(getDecimal(chiranCsvEntity.get都道府県単位数範囲１の度数()));
        登録Entity.setTodoufukenTanisuHani2Dosu(getDecimal(chiranCsvEntity.get都道府県単位数範囲２の度数()));
        登録Entity.setTodoufukenTanisuHani3Dosu(getDecimal(chiranCsvEntity.get都道府県単位数範囲３の度数()));
        登録Entity.setTodoufukenTanisuHani4Dosu(getDecimal(chiranCsvEntity.get都道府県単位数範囲４の度数()));
        登録Entity.setTodoufukenTanisuHani5Dosu(getDecimal(chiranCsvEntity.get都道府県単位数範囲５の度数()));
        登録Entity.setTodoufukenTanisuHani6Dosu(getDecimal(chiranCsvEntity.get都道府県単位数範囲６の度数()));
        登録Entity.setTodoufukenTanisuHani7Dosu(getDecimal(chiranCsvEntity.get都道府県単位数範囲７の度数()));
        登録Entity.setTodoufukenTanisuHani8Dosu(getDecimal(chiranCsvEntity.get都道府県単位数範囲８の度数()));
        登録Entity.setTodoufukenTanisuHani9Dosu(getDecimal(chiranCsvEntity.get都道府県単位数範囲９の度数()));
        登録Entity.setTodoufukenTanisuHani10Dosu(getDecimal(chiranCsvEntity.get都道府県単位数範囲１０の度数()));
        介護給付費福祉用具貸与品目一時tableWriter.insert(登録Entity);
    }

    private FlexibleYearMonth get年月日(RString 年月日str) {
        if (RString.isNullOrEmpty(年月日str)) {
            return null;
        }
        return new FlexibleYearMonth(年月日str);
    }

    private Decimal getDecimal(RString decimalStr) {
        if (RString.isNullOrEmpty(decimalStr) || !Decimal.canConvert(decimalStr)) {
            return Decimal.ZERO;
        }
        return new Decimal(decimalStr.toString());
    }
}
