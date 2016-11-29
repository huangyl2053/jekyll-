/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120810;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenjukyushain.KokuhorenJukyushaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.KokuhorenJukyushaDataCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.KokuhorenJukyushaFlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenjukyushain.DbWT5331JukyushaJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvListReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 国保連保有受給者情報取込。
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
public class KokuhorenJukyushaInReadCsvFileProcess extends BatchProcessBase<List<RString>> {

    /**
     * CSVファイル取込後の返したエンティティ
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KokuhorenJukyushaReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("returnFlowEntity");
    }
    private OutputParameter<KokuhorenJukyushaFlowEntity> returnFlowEntity;
    private KokuhorenJukyushaFlowEntity flowEntity;

    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private KokuhorenJukyushaDataCsvEntity detialEntity;
    private final RString レコード種別 = new RString("1");
    private static final Integer INDEX_0 = 0;
    private static final RString エラー区分_取込対象データなし = new RString("99");

    @BatchWriter
    private IBatchTableWriter 被保険者一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 受給者情報明細一時tableWriter;
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 受給者情報明細一時_TABLE_NAME = new RString("DbWT5331JukyushaJoho");
    private final RString 区切り文字 = new RString(",");
    private final RString レコード種別_エンド = new RString("3");

    private RString 保険者番号;
    private int 連番;

    @Override
    protected void initialize() {
        controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
        returnFlowEntity = new OutputParameter<>();
        flowEntity = new KokuhorenJukyushaFlowEntity();
        連番 = parameter.get連番();

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchCsvListReader(new CsvListReader.InstanceBuilder(parameter.get保存先フォルダ())
                .setDelimiter(区切り文字).setEncode(Encode.SJIS).hasHeader(false).setNewLine(NewLine.CRLF).build());
    }

    @Override
    protected void createWriter() {
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaIchijiEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
        受給者情報明細一時tableWriter
                = new BatchEntityCreatedTempTableWriter(受給者情報明細一時_TABLE_NAME, DbWT5331JukyushaJohoTempEntity.class);
    }

    @Override
    protected void process(List<RString> data) {
        if (data != null && !data.isEmpty()) {
            if (レコード種別_エンド.equals(data.get(INDEX_0))) {
                return;
            }
            if (レコード種別.equals(data.get(INDEX_0))) {
                controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
                保険者番号 = controlCsvEntity.getHokenshaNo();
            } else {
                detialEntity = ListToObjectMappingHelper.toObject(KokuhorenJukyushaDataCsvEntity.class, data);
                連番 = 連番 + 1;
                受給者情報明細一時TBL登録(detialEntity, 連番);
                被保険者一時TBL登録(detialEntity, 連番);
            }
        }
    }

    @Override
    protected void afterExecute() {

        if (null == flowEntity.getShoriYM()) {
            FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(controlCsvEntity.getShoriYM());
            flowEntity.setShoriYM(処理対象年月);
        }

        if (parameter.isLast() && 連番 == INDEX_0) {
            登録対象なしエラー登録();
        }
        flowEntity.setCodeNum(Integer.parseInt(controlCsvEntity.getCodeNum().toString()));
        flowEntity.set連番(連番);
        returnFlowEntity.setValue(flowEntity);

    }

    private void 登録対象なしエラー登録() {
        DbWT0002KokuhorenTorikomiErrorEntity 処理結果 = new DbWT0002KokuhorenTorikomiErrorEntity();
        処理結果.setErrorKubun(エラー区分_取込対象データなし);
        処理結果.setState(EntityDataState.Added);
        処理結果リスト一時tableWriter.insert(処理結果);
    }

    private void 受給者情報明細一時TBL登録(KokuhorenJukyushaDataCsvEntity 保険者X, int 連番) {
        DbWT5331JukyushaJohoTempEntity 明細Entity = new DbWT5331JukyushaJohoTempEntity();
        明細Entity.setRenban(連番);
        明細Entity.setKokanJohoShikibetsuNo(保険者X.get交換情報識別番号());
        明細Entity.setIdoYmd(new FlexibleDate(保険者X.get異動年月日()));
        明細Entity.setIdoKubunCode(保険者X.get異動区分コード());
        明細Entity.setTeiseiYmd(保険者X.get訂正年月日());
        明細Entity.setTeiseiKubunCode(RString.EMPTY);
        明細Entity.setIdoJiyuKubun(保険者X.get異動事由());
        明細Entity.setSeinengappiYmd(保険者X.get生年月日());
        明細Entity.setSeibetsuCode(保険者X.get性別コード());
        明細Entity.setShikakuShutokuYmd(保険者X.get資格取得年月日());
        明細Entity.setShikakuSoshitsuYmd(保険者X.get資格喪失年月日());
        明細Entity.setRojinHokenShichosonNo(保険者X.get老人保健市町村番号());
        明細Entity.setRojinHokenJukyushaNo(保険者X.get老人保健受給者番号());
        明細Entity.setKoikiRengoHokenshaNo(保険者X.get広域連合政令市保険者番号());
        明細Entity.setShinseiShubetsuCode(保険者X.get申請種別コード());
        明細Entity.setHenkoShinseichuKubunCode(保険者X.get変更申請中区分コード());
        明細Entity.setShinseiYmd(保険者X.get申請年月日());
        明細Entity.setMinashiYokaigoKubunCode(保険者X.getみなし要介護区分コード());
        明細Entity.setYokaigoJotaiKubunCode(保険者X.get要介護状態区分コード());
        明細Entity.setNinteiYukokikanFromYmd(保険者X.get認定有効期間開始年月日());
        明細Entity.setNinteiYukokikanToYmd(保険者X.get認定有効期間終了年月日());
        明細Entity.setKyotakuServiceKubunCode(保険者X.get居宅サービス計画作成区分コード());
        明細Entity.setKyotakuKaigoShienJigyoshoNo(保険者X.get居宅介護支援事業所番号());
        明細Entity.setKyotakuServiceTekiyoFromYmd(保険者X.get居宅サービス計画適用開始年月日());
        明細Entity.setKyotakuServiceTekiyoToYmd(保険者X.get居宅サービス計画適用終了年月日());
        明細Entity.setHomonShikyugendoKijungaku(保険者X.get訪問通所サービス支給限度基準額());
        明細Entity.setHomonJogenKanriTekiyoKikanFromYmd(保険者X.get訪問通所サービス上限管理適用期間開始年月日());
        明細Entity.setHomonJogenKanriTekiyoKikanToYmd(保険者X.get訪問通所サービス上限管理適用期間終了年月日());
        明細Entity.setTankiShikyugendoKijungaku(保険者X.get短期入所サービス支給限度基準額());
        明細Entity.setTankiJogenKanriTekiyoKikanFromYmd(保険者X.get短期入所サービス上限管理適用期間開始年月日());
        明細Entity.setTankiJogenKanriTekiyoKikanToYmd(保険者X.get短期入所サービス上限管理適用期間終了年月日());
        明細Entity.setKohiFutanJogengakuGengakuUmu(保険者X.get公費負担上限額減額の有無());
        明細Entity.setShokanHaraikaFromYmd(保険者X.get償還払化開始年月日());
        明細Entity.setShokanHaraikaToYmd(保険者X.get償還払化終了年月日());
        明細Entity.setKyufuritsuHikisageFromYmd(保険者X.get給付率引下げ開始年月日());
        明細Entity.setKyufuritsuHikisageToYmd(保険者X.get給付率引下げ終了年月日());
        明細Entity.setGenmenShinseichuKubunCode(保険者X.get減免申請中区分コード());
        明細Entity.setRiyoshaFutanKubunCode(保険者X.get利用者負担減免旧措置入所者利用者負担区分コード());
        明細Entity.setKyufuRitsu(保険者X.get利用者負担減免旧措置入所者給付率());
        明細Entity.setRiyoshaFutanTekiyoFromYmd(保険者X.get利用者負担減免旧措置入所者適用開始年月日());
        明細Entity.setRiyoshaFutanTekiyoToYmd(保険者X.get利用者負担減免旧措置入所者適用終了年月日());
        明細Entity.setHyojunFutanKubunCode(保険者X.get標準負担特定標準負担標準負担区分コード());
        明細Entity.setFutanGaku(保険者X.get標準負担特定標準負担負担額());
        明細Entity.setFutanGakuTekiyoFromYmd(保険者X.get標準負担特定標準負担負担額適用開始年月日());
        明細Entity.setFutanGakuTekiyoToYmd(保険者X.get標準負担特定標準負担負担額適用終了年月日());
        明細Entity.setTokuteiNyushoshaNinteiShinseichuKubunCode(保険者X.get特定入所者介護サービス特定入所者認定申請中区分コード());
        明細Entity.setTokuteiNyushoshaKaigoServiceKubunCode(保険者X.get特定入所者介護サービス特定入所者介護サービス区分コード());
        明細Entity.setKazeisoNoTokureiGengakuSochiTaishoKubun(保険者X.get特定入所者介護サービス課税層の特例減額措置対象());
        明細Entity.setTokuteiNyushoshaShokuhiFutanGendoGaku(保険者X.get特定入所者介護サービス食費負担限度額());
        明細Entity.setKyojuhiUnitKoshitsuFutanGendoGaku(保険者X.get特定入所者介護サービス居住費ユニット型個室負担限度額());
        明細Entity.setKyojuhiUnitJunkoshitsuFutanGendoGaku(保険者X.get特定入所者介護サービス居住費ユニット型準個室負担限度額());
        明細Entity.setKyojuhiTokuyotoFutanGenndoGaku(保険者X.get特定入所者介護サービス居住費従来型個室特養等負担限度額());
        明細Entity.setKyojuhiRokenRyoyotoFutanGendoGaku(保険者X.get特定入所者介護サービス居住費従来型個室老健療養等負担限度額());
        明細Entity.setKyojuhiTashoShitsuFutanGendoGaku(保険者X.get特定入所者介護サービス居住費多床室負担限度額());
        明細Entity.setFutanGendoGakuTekiyoFromYmd(保険者X.get特定入所者介護サービス負担限度額適用開始年月日());
        明細Entity.setFutanGendoGakuTekiyoToYmd(保険者X.get特定入所者介護サービス負担限度額適用終了年月日());
        明細Entity.setKeigenRitsu(保険者X.get社会福祉法人軽減情報軽減率());
        明細Entity.setKeigenRitsuTekiyoFromYmd(保険者X.get社会福祉法人軽減情報軽減率適用開始年月日());
        明細Entity.setKeigenRitsuTekiyoToYmd(保険者X.get社会福祉法人軽減情報軽減率適用終了年月日());
        明細Entity.setShokiboKyotakuServiceRiyoUmu(保険者X.get小規模多機能型居宅介護の利用開始月における居宅サービス等の利用の有無());
        明細Entity.setKokiHokenshaNo(保険者X.get後期高齢者医療資格保険者番号後期());
        明細Entity.setKokiHihokenshaNo(保険者X.get後期高齢者医療資格被保険者番号後期());
        明細Entity.setKokuhoHokenshaNo(保険者X.get国民健康保険資格保険者番号国保());
        明細Entity.setKokuhoHihokenshashoNo(保険者X.get国民健康保険資格被保険者証番号国保());
        明細Entity.setAtenaNo(保険者X.get国民健康保険資格宛名番号());
        明細Entity.setNijiyoboJigyoKubunCode(保険者X.get二次予防事業区分コード());
        明細Entity.setNijiyoboJigyoYukokikanFromYmd(保険者X.get二次予防事業有効期間開始年月日());
        明細Entity.setNijiyoboJigyoYukokikanToYmd(保険者X.get二次予防事業有効期間終了年月日());
        明細Entity.setJushochiTokureiTaishoshaKubunCode(保険者X.get住所地特例住所地特例対象者区分コード());
        明細Entity.setShisetsuShozaiHokenshaNo(保険者X.get住所地特例施設所在保険者番号());
        明細Entity.setJushochiTokureiTekiyoFromYmd(保険者X.get住所地特例住所地特例適用開始年月日());
        明細Entity.setJushochiTokureiTekiyoToYmd(保険者X.get住所地特例住所地特例適用終了年月日());
        明細Entity.setKyojuhi1FutanGendogaku(保険者X.get特定入所者介護サービス居住費新１負担限度額());
        明細Entity.setKyojuhi2FutanGendogaku(保険者X.get特定入所者介護サービス居住費新２負担限度額());
        明細Entity.setKyojuhi3FutanGendogaku(保険者X.get特定入所者介護サービス居住費新３負担限度額());
        明細Entity.setNiwariFutanTekiyoFromYmd(保険者X.get二割負担適用開始年月日());
        明細Entity.setNiwariFutanTekiyoToYmd(保険者X.get二割負担終了開始年月日());
        明細Entity.setYuryoRojinHomeDoishoUmu(保険者X.get有料老人ホーム等同意書の有無());
        明細Entity.setTsugoKekkaKubun(RString.EMPTY);
        明細Entity.setTsugoJohoKubun(RString.EMPTY);
        明細Entity.setHokenshaNo(new HihokenshaNo(保険者番号));
        明細Entity.setHokenshaName(RString.EMPTY);

        HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
        Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(保険者番号));
        if (hokensha != null) {
            明細Entity.setHokenshaName(hokensha.get保険者名());
        }
        明細Entity.setTorikomiYM(parameter.get処理年月());
        明細Entity.setState(EntityDataState.Added);
        受給者情報明細一時tableWriter.insert(明細Entity);

    }

    private void 被保険者一時TBL登録(KokuhorenJukyushaDataCsvEntity 保険者X, int 連番) {

        DbWT0001HihokenshaIchijiEntity 明細Entity = new DbWT0001HihokenshaIchijiEntity();
        明細Entity.setMeisaiRenban(連番);
        明細Entity.setShoHokenshaNo(new ShoKisaiHokenshaNo(保険者X.get証記載保険者番号()));
        明細Entity.setOrgHihokenshaNo(new HihokenshaNo(保険者X.get被保険者番号()));
        明細Entity.setServiceTeikyoYmd(new FlexibleDate(保険者X.get異動年月日()));
        明細Entity.setOrgHihokenshaKanaShimei(保険者X.get被保険者氏名カナ());
        明細Entity.setHihokenshaNo(new HihokenshaNo(保険者X.get被保険者番号()));
        明細Entity.setChoikiCode(RString.EMPTY);
        明細Entity.setGyoseikuCode(RString.EMPTY);
        明細Entity.setState(EntityDataState.Added);
        被保険者一時tableWriter.insert(明細Entity);
    }


}
