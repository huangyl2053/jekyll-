/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120820;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushatotsugokekkain.JukyushaTotsugoKekkaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.DbWT5331JukyushaJohoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushatotsugokekka.JukyushaKekkaJohoControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushatotsugokekka.JukyushaKekkaJohoCsvMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.KokuhorenJukyushaFlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakoshinkekka.IJukyushaKoshinKekkaMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuTempTableMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者情報突合結果情報取込・ファイル読込を実行する。
 *
 * @reamsid_L DBC-2760-010 jianglaisheng
 */
public class JukyushaTotsugoKekkaReadCsvFileProcess extends BatchProcessBase<RString> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;
    private JukyushaTotsugoKekkaReadCsvFileProcessParameter parameter;
    private IJukyushaKoshinKekkaMapper mapper;
    private IKokuhorenKyoutsuuTempTableMapper 一時mapper;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 受給者情報一時tableWriter;
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 受給者情報一時_TABLE_NAME = new RString("DbWT5331JukyushaJoho");
    private JukyushaKekkaJohoControlCsvEntity controlCsvEntity;
    private JukyushaKekkaJohoCsvMeisaiEntity dataEntity;
    private final RString レコード種別_コントロール = new RString("1");
    private final RString レコード種別_データ = new RString("2");
    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;

    private int 連番;
    private int コントロールレコードのレコード件数の合計 = 0;
    private int 明細件数合計 = 0;
    private FlexibleYearMonth 処理対象年月;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private OutputParameter<KokuhorenJukyushaFlowEntity> flowEntity;
    private KokuhorenJukyushaFlowEntity returnEntity;

    @Override
    protected void initialize() {
        連番 = parameter.get連番();
        controlCsvEntity = new JukyushaKekkaJohoControlCsvEntity();
        returnEntity = new KokuhorenJukyushaFlowEntity();
        flowEntity = new OutputParameter<>();
    }

    @Override
    protected void createWriter() {
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaIchijiEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
        受給者情報一時tableWriter
                = new BatchEntityCreatedTempTableWriter(受給者情報一時_TABLE_NAME, DbWT5331JukyushaJohoCsvEntity.class);
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IJukyushaKoshinKekkaMapper.class);
        this.一時mapper = getMapper(IKokuhorenKyoutsuuTempTableMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.getファイルパース());
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(カンマ.toString());
        if (data != null && !data.isEmpty()) {
            if (レコード種別_コントロール.equals(data.get(INDEX_0))) {
                controlCsvEntity = ListToObjectMappingHelper.toObject(JukyushaKekkaJohoControlCsvEntity.class, data);
                処理対象年月 = controlCsvEntity.get処理対象年月();
                コントロールレコードのレコード件数の合計++;
            } else if (レコード種別_データ.equals(data.get(INDEX_0))) {
                dataEntity = ListToObjectMappingHelper.toObject(JukyushaKekkaJohoCsvMeisaiEntity.class, data);
                受給者情報明細一時TBLに登録();
                明細件数合計++;
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (連番 == parameter.get連番()) {
            処理結果リスト一時に登録();
        }
        returnEntity.setCodeNum(コントロールレコードのレコード件数の合計);
        returnEntity.set明細データ登録件数(明細件数合計);
        returnEntity.setShoriYM(処理対象年月);
        returnEntity.set連番(連番);
        flowEntity.setValue(returnEntity);
    }

    private void 受給者情報明細一時TBLに登録() {
        HokenshaNyuryokuHojoFinder 保険者名取得 = HokenshaNyuryokuHojoFinder.createInstance();
        連番 = 連番 + 1;
        DbWT5331JukyushaJohoCsvEntity 受給者一時entity = new DbWT5331JukyushaJohoCsvEntity();
        受給者一時entity.set連番(連番);
        受給者一時entity.setみなし要介護区分コード(dataEntity.getMinashiYokaigoKubunCode());
        受給者一時entity.set交換情報識別番号(dataEntity.getKokanJohoShikibetsuNo());
        受給者一時entity.set異動年月日(dataEntity.getIdoYmd());
        受給者一時entity.set異動区分コード(dataEntity.getIdoKubunCode());
        受給者一時entity.set訂正年月日(FlexibleDate.EMPTY);
        受給者一時entity.set訂正区分コード(RString.EMPTY);
        受給者一時entity.set異動事由区分(dataEntity.getIdoJiyuKubun());
        受給者一時entity.set生年月日(dataEntity.getSeinengappiYmd());
        受給者一時entity.set性別コード(dataEntity.getSeibetsuCode());
        受給者一時entity.set資格取得年月日(dataEntity.getShikakuShutokuYmd());
        受給者一時entity.set資格喪失年月日(dataEntity.getShikakuSoshitsuYmd());
        受給者一時entity.set老人保健市町村番号(dataEntity.getRojinHokenShichosonNo());
        受給者一時entity.set老人保健受給者番号(dataEntity.getRojinHokenJukyushaNo());
        受給者一時entity.set広域連合_政令市_保険者番号(dataEntity.getKoikiRengoHokenshaNo());
        受給者一時entity.set申請種別コード(dataEntity.getShinseiShubetsuCode());
        受給者一時entity.set変更申請中区分コード(dataEntity.getHenkoShinseichuKubunCode());
        受給者一時entity.set申請年月日(dataEntity.getShinseiYmd());
        受給者一時entity.set要介護状態区分コード(dataEntity.getYokaigoJotaiKubunCode());
        受給者一時entity.set認定有効期間開始年月日(dataEntity.getNinteiYukokikanFromYmd());
        受給者一時entity.set認定有効期間終了年月日(dataEntity.getNinteiYukokikanToYmd());
        受給者一時entity.set居宅サービス計画作成区分コード(dataEntity.getKyotakuServiceKubunCode());
        受給者一時entity.set居宅介護支援事業所番号(dataEntity.getKyotakuKaigoShienJigyoshoNo());
        受給者一時entity.set居宅サービス計画適用開始年月日(dataEntity.getKyotakuServiceTekiyoFromYmd());
        受給者一時entity.set居宅サービス計画適用終了年月日(dataEntity.getKyotakuServiceTekiyoToYmd());
        受給者一時entity.set訪問通所_支給限度基準額(dataEntity.getHomonShikyugendoKijungaku());
        受給者一時entity.set訪問通所_上限管理適用期間開始年月日(dataEntity.getHomonJogenKanriTekiyoKikanFromYmd());
        受給者一時entity.set訪問通所_上限管理適用期間終了年月日(dataEntity.getHomonJogenKanriTekiyoKikanToYmd());
        受給者一時entity.set短期入所_支給限度基準額(dataEntity.getTankiShikyugendoKijungaku());
        受給者一時entity.set短期入所_上限管理適用期間開始年月日(dataEntity.getTankiJogenKanriTekiyoKikanFromYmd());
        受給者一時entity.set短期入所_上限管理適用期間終了年月日(dataEntity.getTankiJogenKanriTekiyoKikanToYmd());
        受給者一時entity.set公費負担上限額減額の有無(dataEntity.getKohiFutanJogengakuGengakuUmu());
        受給者一時entity.set償還払化開始年月日(dataEntity.getShokanHaraikaFromYmd());
        受給者一時entity.set償還払化終了年月日(dataEntity.getShokanHaraikaToYmd());
        受給者一時entity.set給付率引下げ開始年月日(dataEntity.getKyufuritsuHikisageFromYmd());
        受給者一時entity.set給付率引下げ終了年月日(dataEntity.getKyufuritsuHikisageToYmd());
        受給者一時entity.set減免申請中区分コード(dataEntity.getGenmenShinseichuKubunCode());
        受給者一時entity.set利用者負担区分コード(dataEntity.getRiyoshaFutanKubunCode());
        受給者一時entity.set給付率(dataEntity.getKyufuRitsu());
        受給者一時entity.set利用者負担適用開始年月日(dataEntity.getRiyoshaFutanTekiyoFromYmd());
        受給者一時entity.set利用者負担適用終了年月日(dataEntity.getRiyoshaFutanTekiyoToYmd());
        受給者一時entity.set標準負担区分コード(dataEntity.getHyojunFutanKubunCode());
        受給者一時entity.set負担額(dataEntity.getFutanGaku());
        受給者一時entity.set負担額適用開始年月日(dataEntity.getFutanGakuTekiyoFromYmd());
        受給者一時entity.set負担額適用終了年月日(dataEntity.getFutanGakuTekiyoToYmd());
        受給者一時entity.set特定入所者認定申請中区分コード(dataEntity.getTokuteiNyushoshaNinteiShinseichuKubunCode());
        受給者一時entity.set特定入所者介護サービス区分コード(dataEntity.getTokuteiNyushoshaKaigoServiceKubunCode());
        受給者一時entity.set課税層の特例減額措置対象区分(dataEntity.getKazeisoNoTokureiGengakuSochiTaishoKubun());
        受給者一時entity.set特定入所者食費負担限度額(dataEntity.getTokuteiNyushoshaShokuhiFutanGendoGaku());
        受給者一時entity.set居住費_ユニット型個室_負担限度額(dataEntity.getKyojuhiUnitKoshitsuFutanGendoGaku());
        受給者一時entity.set居住費_ユニット型準個室_負担限度額(dataEntity.getKyojuhiUnitJunkoshitsuFutanGendoGaku());
        受給者一時entity.set居住費_従来型個室_特養等_負担限度額(dataEntity.getKyojuhiTokuyotoFutanGenndoGaku());
        受給者一時entity.set居住費_従来型個室_老健_療養等_負担限度額(dataEntity.getKyojuhiRokenRyoyotoFutanGendoGaku());
        受給者一時entity.set居住費_多床室_負担限度額(dataEntity.getKyojuhiTashoShitsuFutanGendoGaku());
        受給者一時entity.set負担限度額適用開始年月日(dataEntity.getFutanGendoGakuTekiyoFromYmd());
        受給者一時entity.set負担限度額適用終了年月日(dataEntity.getFutanGendoGakuTekiyoToYmd());
        受給者一時entity.set軽減率(dataEntity.getKeigenRitsu());
        受給者一時entity.set軽減率適用開始年月日(dataEntity.getKeigenRitsuTekiyoFromYmd());
        受給者一時entity.set軽減率適用終了年月日(dataEntity.getKeigenRitsuTekiyoToYmd());
        受給者一時entity.set小規模居宅サービス利用有無(dataEntity.getShokiboKyotakuServiceRiyoUmu());
        受給者一時entity.set保険者番号_後期_(dataEntity.getKokiHokenshaNo());
        受給者一時entity.set被保険者番号_後期_(dataEntity.getKokiHihokenshaNo());
        受給者一時entity.set保険者番号_国保_(dataEntity.getKokuhoHokenshaNo());
        受給者一時entity.set被保険者証番号_国保_(dataEntity.getKokuhoHihokenshashoNo());
        受給者一時entity.set宛名番号(dataEntity.getAtenaNo());
        受給者一時entity.set二次予防事業区分コード(dataEntity.getNijiyoboJigyoKubunCode());
        受給者一時entity.set二次予防事業有効期間開始年月日(dataEntity.getNijiyoboJigyoYukokikanFromYmd());
        受給者一時entity.set二次予防事業有効期間終了年月日(dataEntity.getNijiyoboJigyoYukokikanToYmd());
        受給者一時entity.set住所地特例対象者区分コード(dataEntity.getJushochiTokureiTaishoshaKubunCode());
        受給者一時entity.set施設所在保険者番号(dataEntity.getShisetsuShozaiHokenshaNo());
        受給者一時entity.set住所地特例適用開始年月日(dataEntity.getJushochiTokureiTekiyoFromYmd());
        受給者一時entity.set住所地特例適用終了年月日(dataEntity.getJushochiTokureiTekiyoToYmd());
        受給者一時entity.set居住費_新１_負担限度額(dataEntity.getKyojuhi1FutanGendogaku());
        受給者一時entity.set居住費_新２_負担限度額(dataEntity.getKyojuhi2FutanGendogaku());
        受給者一時entity.set居住費_新３_負担限度額(dataEntity.getKyojuhi3FutanGendogaku());
        受給者一時entity.set二割負担適用開始年月日(dataEntity.getNiwariFutanTekiyoFromYmd());
        受給者一時entity.set二割負担適用終了年月日(dataEntity.getNiwariFutanTekiyoToYmd());
        受給者一時entity.set有料老人ホーム等同意書の有無(RString.EMPTY);
        受給者一時entity.set突合結果区分(dataEntity.getTsugoKekkaKubun());
        受給者一時entity.set突合情報区分(dataEntity.getTsugoJohoKubun());
        受給者一時entity.set保険者番号(controlCsvEntity.get保険者番号());
        Hokensha hokensha = 保険者名取得.getHokensha(new HokenjaNo(controlCsvEntity.get保険者番号()));
        if (hokensha != null) {
            受給者一時entity.set保険者名(hokensha.get保険者名());
        }
        受給者一時entity.set取込年月(処理対象年月);
        this.mapper.受給者情報明細一時TBLに登録(受給者一時entity);
        this.被保険者一時TBLに登録();
    }

    private void 被保険者一時TBLに登録() {
        DbWT0001HihokenshaTempEntity 被保険者一時entity = new DbWT0001HihokenshaTempEntity();
        被保険者一時entity.set連番(連番);
        被保険者一時entity.set証記載保険者番号(new ShoKisaiHokenshaNo(dataEntity.getShoukizaihokenshashoNo()));
        被保険者一時entity.set被保険者番号(new HihokenshaNo(dataEntity.getHihokenshashoNo()));
        被保険者一時entity.setサービス提供年月末日(dataEntity.getIdoYmd());
        被保険者一時entity.set被保険者カナ氏名(dataEntity.getHihokenshaShimeikana());
        被保険者一時entity.set被保険者氏名(RString.EMPTY);
        被保険者一時entity.set旧市町村コード(LasdecCode.EMPTY);
        被保険者一時entity.set変換被保険者番号(HihokenshaNo.EMPTY);
        被保険者一時entity.set登録被保険者番号(new HihokenshaNo(dataEntity.getHihokenshashoNo()));
        被保険者一時entity.set市町村コード(LasdecCode.EMPTY);
        被保険者一時entity.set管内管外区分(RString.EMPTY);
        被保険者一時entity.set郵便番号(RString.EMPTY);
        被保険者一時entity.set町域コード(RString.EMPTY);
        被保険者一時entity.set行政区コード(RString.EMPTY);
        被保険者一時entity.set行政区名(RString.EMPTY);
        被保険者一時entity.set住所(RString.EMPTY);
        被保険者一時entity.set番地(RString.EMPTY);
        被保険者一時entity.set方書(RString.EMPTY);
        被保険者一時entity.set宛名カナ名称(RString.EMPTY);
        被保険者一時entity.set宛名名称(RString.EMPTY);
        被保険者一時entity.set氏名50音カナ(RString.EMPTY);
        被保険者一時entity.set識別コード(RString.EMPTY);
        被保険者一時entity.set資格取得日(FlexibleDate.EMPTY);
        被保険者一時entity.set資格取得事由コード(RString.EMPTY);
        被保険者一時entity.set資格喪失日(FlexibleDate.EMPTY);
        被保険者一時entity.set資格喪失事由コード(RString.EMPTY);
        被保険者一時entity.set世帯集約番号(RString.EMPTY);
        this.一時mapper.被保険者一時TBLに登録(被保険者一時entity);
    }

    private void 処理結果リスト一時に登録() {
        DbWT0002KokuhorenTorikomiErrorTempEntity 処理結果リスト一時entity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        処理結果リスト一時entity.setエラー区分(KokuhorenJoho_TorikomiErrorKubun.取込対象データなし.getコード());
        処理結果リスト一時entity.set証記載保険者番号(ShoKisaiHokenshaNo.EMPTY);
        処理結果リスト一時entity.set被保険者番号(HihokenshaNo.EMPTY);
        処理結果リスト一時entity.setキー1(RString.EMPTY);
        処理結果リスト一時entity.setキー2(RString.EMPTY);
        処理結果リスト一時entity.setキー3(RString.EMPTY);
        処理結果リスト一時entity.setキー4(RString.EMPTY);
        処理結果リスト一時entity.setキー5(RString.EMPTY);
        処理結果リスト一時entity.set被保険者カナ氏名(RString.EMPTY);
        処理結果リスト一時entity.set被保険者氏名(RString.EMPTY);
        処理結果リスト一時entity.set備考(RString.EMPTY);
        this.一時mapper.処理結果リスト一時TBLに登録(処理結果リスト一時entity);
    }
}
