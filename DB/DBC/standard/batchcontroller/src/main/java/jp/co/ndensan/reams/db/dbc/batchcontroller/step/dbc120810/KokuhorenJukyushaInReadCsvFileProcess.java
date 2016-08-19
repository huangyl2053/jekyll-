/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120810;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenjukyushain.KokuhorenJukyushaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.DbWT5331JukyushaJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.KokuhorenJukyushaCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.KokuhorenJukyushaDataCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.KokuhorenJukyushaFlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenjukyushain.DbWT5331JukyushaJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenjukyushain.IKokuhorenJukyushaMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuTempTableMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ux.uxx.persistence.db.mapper.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 国保連保有受給者情報取込。
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
public class KokuhorenJukyushaInReadCsvFileProcess extends BatchProcessBase<RString> {

    /**
     * CSVファイル取込後の返したエンティティ
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KokuhorenJukyushaReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("returnFlowEntity");
    }
    OutputParameter<KokuhorenJukyushaFlowEntity> returnFlowEntity;
    KokuhorenJukyushaFlowEntity flowEntity;

    private MapperProvider mapperProvider;
    private IKokuhorenJukyushaMapper mapper;
    private IKokuhorenKyoutsuuTempTableMapper mapper1;
    private IKokuhorenKyoutsuuMapper 処理結果mapper;
    private KokuhorenJukyushaCsvEntity entity;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private List<KokuhorenJukyushaDataCsvEntity> detialList;
    private KokuhorenJukyushaDataCsvEntity detialEntity;
    private final RString レコード種別 = new RString("1");
    private static final Integer INDEX_0 = 0;
    private static final RString エラー区分_取込対象データなし = new RString("99");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 受給者情報明細一時tableWriter;
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 受給者情報明細一時_TABLE_NAME = new RString("DbWT5331JukyushaJoho");
    private final RString 区切り文字 = new RString(",");
    private final RString レコード種別_エンド = new RString("3");

    private FlexibleYearMonth 処理対象年月;
    private RString 保険者番号;

    @Override
    protected void initialize() {
        entity = new KokuhorenJukyushaCsvEntity();
        controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
        returnFlowEntity = new OutputParameter<>();
        detialList = new ArrayList();
        flowEntity = new KokuhorenJukyushaFlowEntity();

    }

    @Override
    protected void beforeExecute() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        mapper = mapperProvider.create(IKokuhorenJukyushaMapper.class);
        mapper1 = mapperProvider.create(IKokuhorenKyoutsuuTempTableMapper.class);
        処理結果mapper = mapperProvider.create(IKokuhorenKyoutsuuMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.get保存先フォルダ());
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
    protected void process(RString line) {
        List<RString> data = line.split(区切り文字.toString());
        if (data != null && !data.isEmpty()) {
            if (レコード種別_エンド.equals(data.get(INDEX_0))) {
                return;
            }
            if (レコード種別.equals(data.get(INDEX_0))) {
                controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
            } else {
                detialEntity = ListToObjectMappingHelper.toObject(KokuhorenJukyushaDataCsvEntity.class, data);
                detialList.add(detialEntity);
            }
        }
    }

    @Override
    protected void afterExecute() {
        entity.setControlCsvEntity(controlCsvEntity);
        entity.setListDataEntity(detialList);

        if (null == parameter.get処理年月()) {
            FlexibleYearMonth 処理対象年月temp = new FlexibleYearMonth(controlCsvEntity.getShoriYM());
            parameter.set処理年月(処理対象年月temp);
        }

        int 連番 = parameter.get連番();
        保険者番号 = controlCsvEntity.getHokenshaNo();
        for (KokuhorenJukyushaDataCsvEntity 保険者X : entity.getListDataEntity()) {
            連番 = 連番 + 1;
            受給者情報明細一時TBL登録(保険者X, 連番);
            被保険者一時TBL登録(保険者X, 連番);
        }

        if (連番 == parameter.get連番()) {
            登録対象なしエラー登録();
        }
        flowEntity.setShoriYM(parameter.get処理年月());
        flowEntity.setCodeNum(Integer.parseInt(controlCsvEntity.getCodeNum().toString()));
        flowEntity.set連番(連番);
        returnFlowEntity.setValue(flowEntity);

    }

    private void 登録対象なしエラー登録() {
        DbWT0002KokuhorenTorikomiErrorTempEntity 処理結果 = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        処理結果.setエラー区分(エラー区分_取込対象データなし);
        do一意排他登録処理結果(処理結果);
    }

    private boolean do一意排他登録処理結果(DbWT0002KokuhorenTorikomiErrorTempEntity kekka) {
        if (処理結果mapper.count処理結果ByPK(kekka) == 0) {
            処理結果mapper.insert処理結果リスト一時TBL(kekka);
        } else {
            return false;
        }
        return true;
    }

    private void 受給者情報明細一時TBL登録(KokuhorenJukyushaDataCsvEntity 保険者X, int 連番) {

        DbWT5331JukyushaJohoEntity 明細Entity = new DbWT5331JukyushaJohoEntity();
        明細Entity.set連番(連番);
        明細Entity.set交換情報識別番号(保険者X.get交換情報識別番号());
        明細Entity.set異動年月日(new FlexibleDate(保険者X.get異動年月日()));
        明細Entity.set異動区分コード(保険者X.get異動区分コード());
        明細Entity.set訂正年月日(new FlexibleDate(保険者X.get訂正年月日()));
        明細Entity.set訂正区分コード(RString.EMPTY);
        明細Entity.set異動事由区分(保険者X.get異動事由());
        明細Entity.set生年月日(new FlexibleDate(保険者X.get生年月日()));
        明細Entity.set性別コード(保険者X.get性別コード());
        明細Entity.set資格取得年月日(new FlexibleDate(保険者X.get資格取得年月日()));
        明細Entity.set資格喪失年月日(new FlexibleDate(保険者X.get資格喪失年月日()));
        明細Entity.set老人保健市町村番号(保険者X.get老人保健市町村番号());
        明細Entity.set老人保健受給者番号(保険者X.get老人保健受給者番号());
        明細Entity.set広域連合政令市保険者番号(保険者X.get広域連合政令市保険者番号());
        明細Entity.set申請種別コード(保険者X.get申請種別コード());
        明細Entity.set変更申請中区分コード(保険者X.get変更申請中区分コード());
        明細Entity.set申請年月日(new FlexibleDate(保険者X.get申請年月日()));
        明細Entity.setみなし要介護区分コード(保険者X.getみなし要介護区分コード());
        明細Entity.set要介護状態区分コード(保険者X.get要介護状態区分コード());
        明細Entity.set認定有効期間開始年月日(new FlexibleDate(保険者X.get認定有効期間開始年月日()));
        明細Entity.set認定有効期間終了年月日(new FlexibleDate(保険者X.get認定有効期間終了年月日()));
        明細Entity.set居宅サービス計画作成区分コード(保険者X.get居宅サービス計画作成区分コード());
        明細Entity.set居宅介護支援事業所番号(保険者X.get居宅介護支援事業所番号());
        明細Entity.set居宅サービス計画適用開始年月日(new FlexibleDate(保険者X.get居宅サービス計画適用開始年月日()));
        明細Entity.set居宅サービス計画適用終了年月日(new FlexibleDate(保険者X.get居宅サービス計画適用終了年月日()));
        明細Entity.set訪問通所支給限度基準額(toDecimal(保険者X.get訪問通所サービス支給限度基準額()));
        明細Entity.set訪問通所上限管理適用期間開始年月日(new FlexibleDate(保険者X.get訪問通所サービス上限管理適用期間開始年月日()));
        明細Entity.set訪問通所上限管理適用期間終了年月日(new FlexibleDate(保険者X.get訪問通所サービス上限管理適用期間終了年月日()));
        明細Entity.set短期入所支給限度基準額(toDecimal(保険者X.get短期入所サービス支給限度基準額()));
        明細Entity.set短期入所上限管理適用期間開始年月日(new FlexibleDate(保険者X.get短期入所サービス上限管理適用期間開始年月日()));
        明細Entity.set短期入所上限管理適用期間終了年月日(new FlexibleDate(保険者X.get短期入所サービス上限管理適用期間終了年月日()));
        明細Entity.set公費負担上限額減額の有無(保険者X.get公費負担上限額減額の有無());
        明細Entity.set償還払化開始年月日(new FlexibleDate(保険者X.get償還払化開始年月日()));
        明細Entity.set償還払化終了年月日(new FlexibleDate(保険者X.get償還払化終了年月日()));
        明細Entity.set給付率引下げ開始年月日(new FlexibleDate(保険者X.get給付率引下げ開始年月日()));
        明細Entity.set給付率引下げ終了年月日(new FlexibleDate(保険者X.get給付率引下げ終了年月日()));
        明細Entity.set減免申請中区分コード(保険者X.get減免申請中区分コード());
        明細Entity.set利用者負担区分コード(保険者X.get利用者負担減免旧措置入所者利用者負担区分コード());
        明細Entity.set給付率(toDecimal(保険者X.get利用者負担減免旧措置入所者給付率()));
        明細Entity.set利用者負担適用開始年月日(new FlexibleDate(保険者X.get利用者負担減免旧措置入所者適用開始年月日()));
        明細Entity.set利用者負担適用終了年月日(new FlexibleDate(保険者X.get利用者負担減免旧措置入所者適用終了年月日()));
        明細Entity.set標準負担区分コード(保険者X.get標準負担特定標準負担標準負担区分コード());
        明細Entity.set負担額(toDecimal(保険者X.get標準負担特定標準負担負担額()));
        明細Entity.set負担額適用開始年月日(new FlexibleDate(保険者X.get標準負担特定標準負担負担額適用開始年月日()));
        明細Entity.set負担額適用終了年月日(new FlexibleDate(保険者X.get標準負担特定標準負担負担額適用終了年月日()));
        明細Entity.set特定入所者認定申請中区分コード(保険者X.get特定入所者介護サービス特定入所者認定申請中区分コード());
        明細Entity.set特定入所者介護サービス区分コード(保険者X.get特定入所者介護サービス特定入所者介護サービス区分コード());
        明細Entity.set課税層の特例減額措置対象区分(保険者X.get特定入所者介護サービス課税層の特例減額措置対象());
        明細Entity.set特定入所者食費負担限度額(toDecimal(保険者X.get特定入所者介護サービス食費負担限度額()));
        明細Entity.set居住費ユニット型個室負担限度額(toDecimal(保険者X.get特定入所者介護サービス居住費ユニット型個室負担限度額()));
        明細Entity.set居住費ユニット型準個室負担限度額(toDecimal(保険者X.get特定入所者介護サービス居住費ユニット型準個室負担限度額()));
        明細Entity.set居住費従来型個室特養等負担限度額(toDecimal(保険者X.get特定入所者介護サービス居住費従来型個室特養等負担限度額()));
        明細Entity.set居住費従来型個室老健療養等負担限度額(toDecimal(保険者X.get特定入所者介護サービス居住費従来型個室老健療養等負担限度額()));
        明細Entity.set居住費多床室負担限度額(toDecimal(保険者X.get特定入所者介護サービス居住費多床室負担限度額()));
        明細Entity.set負担限度額適用開始年月日(new FlexibleDate(保険者X.get特定入所者介護サービス負担限度額適用開始年月日()));
        明細Entity.set負担限度額適用終了年月日(new FlexibleDate(保険者X.get特定入所者介護サービス負担限度額適用終了年月日()));
        明細Entity.set軽減率(toDecimal(保険者X.get社会福祉法人軽減情報軽減率()));
        明細Entity.set軽減率適用開始年月日(new FlexibleDate(保険者X.get社会福祉法人軽減情報軽減率適用開始年月日()));
        明細Entity.set軽減率適用終了年月日(new FlexibleDate(保険者X.get社会福祉法人軽減情報軽減率適用終了年月日()));
        明細Entity.set小規模居宅サービス利用有無(保険者X.get小規模多機能型居宅介護の利用開始月における居宅サービス等の利用の有無());
        明細Entity.set保険者番号後期(保険者X.get後期高齢者医療資格保険者番号後期());
        明細Entity.set被保険者番号後期(保険者X.get後期高齢者医療資格被保険者番号後期());
        明細Entity.set保険者番号国保(保険者X.get国民健康保険資格保険者番号国保());
        明細Entity.set被保険者証番号国保(保険者X.get国民健康保険資格被保険者証番号国保());
        明細Entity.set宛名番号(保険者X.get国民健康保険資格宛名番号());
        明細Entity.set二次予防事業区分コード(保険者X.get二次予防事業区分コード());
        明細Entity.set二次予防事業有効期間開始年月日(new FlexibleDate(保険者X.get二次予防事業有効期間開始年月日()));
        明細Entity.set二次予防事業有効期間終了年月日(new FlexibleDate(保険者X.get二次予防事業有効期間終了年月日()));
        明細Entity.set住所地特例対象者区分コード(保険者X.get住所地特例住所地特例対象者区分コード());
        明細Entity.set施設所在保険者番号(保険者X.get住所地特例施設所在保険者番号());
        明細Entity.set住所地特例適用開始年月日(new FlexibleDate(保険者X.get住所地特例住所地特例適用開始年月日()));
        明細Entity.set住所地特例適用終了年月日(new FlexibleDate(保険者X.get住所地特例住所地特例適用終了年月日()));
        明細Entity.set居住費新１負担限度額(toDecimal(保険者X.get特定入所者介護サービス居住費新１負担限度額()));
        明細Entity.set居住費新２負担限度額(toDecimal(保険者X.get特定入所者介護サービス居住費新２負担限度額()));
        明細Entity.set居住費新３負担限度額(toDecimal(保険者X.get特定入所者介護サービス居住費新３負担限度額()));
        明細Entity.set二割負担適用開始年月日(new FlexibleDate(保険者X.get二割負担適用開始年月日()));
        明細Entity.set二割負担終了開始年月日(new FlexibleDate(保険者X.get二割負担終了開始年月日()));
        明細Entity.set有料老人ホーム等同意書の有無(保険者X.get有料老人ホーム等同意書の有無());
        明細Entity.set突合結果区分(RString.EMPTY);
        明細Entity.set突合情報区分(RString.EMPTY);
        明細Entity.set保険者番号(保険者番号);
        明細Entity.set保険者名(RString.EMPTY);
        HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
        Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(保険者番号));
        if (hokensha != null) {
            明細Entity.set保険者名(hokensha.get保険者名());
        }
        明細Entity.set取込年月(処理対象年月);
        mapper.insert受給者情報明細一時TBLに登録(明細Entity);

    }

    private void 被保険者一時TBL登録(KokuhorenJukyushaDataCsvEntity 保険者X, int 連番) {

        DbWT0001HihokenshaTempEntity 明細Entity = new DbWT0001HihokenshaTempEntity();
        明細Entity.set連番(連番);
        明細Entity.set証記載保険者番号(new ShoKisaiHokenshaNo(保険者X.get証記載保険者番号()));
        明細Entity.set被保険者番号(new HihokenshaNo(保険者X.get被保険者番号()));
        明細Entity.setサービス提供年月末日(new FlexibleDate(保険者X.get異動年月日()));
        明細Entity.set被保険者カナ氏名(保険者X.get被保険者氏名カナ());
        明細Entity.set登録被保険者番号(new HihokenshaNo(保険者X.get被保険者番号()));
        mapper1.被保険者一時TBLに登録(明細Entity);
    }

    private Decimal toDecimal(RString 金額) {
        if (RString.isNullOrEmpty(金額)) {
            return Decimal.ZERO;
        }
        return new Decimal(金額.toString());
    }
}
