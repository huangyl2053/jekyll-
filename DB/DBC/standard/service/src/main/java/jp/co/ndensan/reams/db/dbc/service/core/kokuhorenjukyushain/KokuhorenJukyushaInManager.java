/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kokuhorenjukyushain;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.DbWT0001DbWT5331Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.DbWT5331JukyushaJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.KokuhorenJukyushaCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.KokuhorenJukyushaDataCsvEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenjukyushain.IKokuhorenJukyushaMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuTempTableMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 国保連保有受給者情報取込。
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
public class KokuhorenJukyushaInManager {

    private final MapperProvider mapperProvider;
    private final IKokuhorenJukyushaMapper mapper;
    private final IKokuhorenKyoutsuuTempTableMapper mapper1;
    private final IKokuhorenKyoutsuuMapper 処理結果mapper;
    private KokuhorenJukyushaCsvEntity entity;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private List<KokuhorenJukyushaDataCsvEntity> detialList;
    private KokuhorenJukyushaDataCsvEntity detialEntity;
    private final RString レコード種別 = new RString("1");
    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;
    private static final RString エラー区分_取込対象データなし = new RString("99");

    private int 連番 = 0;

    private int 明細件数合計 = 0;
    private int コントロールレコードのレコード件数の合計 = 0;
    private FlexibleYearMonth 処理対象年月;
    private RString 保険者番号;
    private RString 保険者名;

    /**
     * コンストラクタです。
     */
    public KokuhorenJukyushaInManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(IKokuhorenJukyushaMapper.class);
        this.mapper1 = mapperProvider.create(IKokuhorenKyoutsuuTempTableMapper.class);
        this.処理結果mapper = mapperProvider.create(IKokuhorenKyoutsuuMapper.class);

    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    KokuhorenJukyushaInManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
        this.mapper = mapperProvider.create(IKokuhorenJukyushaMapper.class);
        this.mapper1 = mapperProvider.create(IKokuhorenKyoutsuuTempTableMapper.class);
        this.処理結果mapper = mapperProvider.create(IKokuhorenKyoutsuuMapper.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KokuhorenJukyushaInManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KokuhorenJukyushaInManager}のインスタンス
     */
    public static KokuhorenJukyushaInManager createInstance() {
        return InstanceProvider.create(KokuhorenJukyushaInManager.class);
    }

    /**
     * 一時TBL作成と読込と登録
     *
     * @param 保存先フォルダ RString
     * @param エントリ情報List List<RString>
     * @return FlowEntity
     */
    @Transaction
    public FlowEntity 一時TBL作成と読込と登録(RString 保存先フォルダ, List<RString> エントリ情報List) {
        mapper.create受給者情報明細一時TBL();
        mapper1.create被保険者一時TBL();
        mapper1.create処理結果リスト一時TBL();
        return 取込件数確認(保存先フォルダ, エントリ情報List);
    }

    @Transaction
    private FlowEntity 取込件数確認(RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<KokuhorenJukyushaCsvEntity> csvlist = csvファイル読込(保存先フォルダ, エントリ情報List);
        連番 = 0;
        明細件数合計 = 0;
        処理対象年月 = FlexibleYearMonth.EMPTY;
        国保連保有受給者情報取込一時TBLに登録(csvlist);
        if ((明細件数合計) == INDEX_0) {
            登録対象なしエラー登録();
        }
        FlowEntity flowEntity = new FlowEntity();
        flowEntity.setCodeNum(コントロールレコードのレコード件数の合計);
        flowEntity.set明細データ登録件数(明細件数合計);
        flowEntity.setShoriYM(処理対象年月);
        return flowEntity;

    }

    @Transaction
    private void 国保連保有受給者情報取込一時TBLに登録(List<KokuhorenJukyushaCsvEntity> csvlist) {
        for (KokuhorenJukyushaCsvEntity csvEntity : csvlist) {
            KagoKetteiHokenshaInControlCsvEntity コントロールレコード = csvEntity.getControlCsvEntity();
            コントロールレコードのレコード件数の合計 = コントロールレコードのレコード件数の合計
                    + Integer.valueOf(コントロールレコード.getCodeNum().toString());
            if (FlexibleYearMonth.EMPTY.equals(処理対象年月)) {
                処理対象年月 = new FlexibleYearMonth(コントロールレコード.getShoriYM());
            }
            保険者番号 = コントロールレコード.getHokenshaNo();
            保険者名 = RString.EMPTY;
            for (KokuhorenJukyushaDataCsvEntity 保険者X : csvEntity.getListDataEntity()) {
                連番 = 連番 + 1;
                受給者情報明細一時TBL登録(保険者X);
                被保険者一時TBL登録(保険者X);
            }
        }
    }

    private void 受給者情報明細一時TBL登録(KokuhorenJukyushaDataCsvEntity 保険者X) {

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
        if (0 != mapper.insert受給者情報明細一時TBLに登録(明細Entity)) {
            明細件数合計 = 明細件数合計 + 1;
        }
    }

    private void 被保険者一時TBL登録(KokuhorenJukyushaDataCsvEntity 保険者X) {

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

    /**
     * csvファイル読込
     *
     * @param 保存先フォルダ RString
     * @param エントリ情報List List<RString>
     * @return List<KokuhorenJukyushaCsvEntity>
     */
    private List<KokuhorenJukyushaCsvEntity> csvファイル読込(RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<KokuhorenJukyushaCsvEntity> list = new ArrayList<>();
        List<RString> csvFullPathList = new ArrayList<>();
        for (int i = INDEX_0; i < エントリ情報List.size(); i++) {
            File path = new File(保存先フォルダ + File.separator + エントリ情報List.get(i));
            RString csvFullPath = new RString(path.getPath());
            csvFullPathList.add(csvFullPath);
        }

        for (int j = INDEX_0; j < csvFullPathList.size(); j++) {
            entity = new KokuhorenJukyushaCsvEntity();
            controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
            detialList = new ArrayList<>();
            detialEntity = new KokuhorenJukyushaDataCsvEntity();
            try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(csvFullPathList.get(j)).setDelimiter(カンマ).setEncode(Encode.SJIS)
                    .hasHeader(false).setNewLine(NewLine.CRLF).build()) {
                while (true) {
                    List<RString> data = csvReader.readLine();

                    if (data != null && !data.isEmpty()) {
                        if (レコード種別.equals(data.get(INDEX_0))) {
                            controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
                        } else {
                            detialEntity = ListToObjectMappingHelper.toObject(KokuhorenJukyushaDataCsvEntity.class, data);
                            detialList.add(detialEntity);
                        }
                    } else {
                        break;
                    }
                }
                entity.setControlCsvEntity(controlCsvEntity);
                entity.setListDataEntity(detialList);
                list.add(entity);
            }
        }
        return list;
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

    /**
     * get帳票出力対象データ
     *
     * @param mybatisParameter Map<String, Object>
     * @return List<DbWT0001DbWT5331Entity>
     */
    public List<DbWT0001DbWT5331Entity> get帳票出力対象データ(Map<String, Object> mybatisParameter) {
        List<DbWT0001DbWT5331Entity> 帳票出力対象データリスト = mapper.get帳票出力対象データ(mybatisParameter);
        if (null == 帳票出力対象データリスト) {
            return Collections.EMPTY_LIST;
        }
        return 帳票出力対象データリスト;
    }
}
