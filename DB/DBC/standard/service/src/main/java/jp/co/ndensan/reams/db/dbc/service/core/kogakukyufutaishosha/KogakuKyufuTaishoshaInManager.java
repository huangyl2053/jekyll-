/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakukyufutaishosha;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha.DbWT3054KogakuKyufuTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha.KogakuKyufuTaishoshaCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha.KogakuKyufuTaishoshaDataCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha.KogakuKyufuTaishoshaGokeiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha.KogakuKyufuTaishoshaGroupCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha.KogakuKyufuTaishoshaHeadCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha.KogakuKyufuTaishoshaMeisaiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha.KyuufuTaishoshaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha.RirikiNoKanrenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha.SaishoriFukaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3055KogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshainkouhifutann.IKagoKetteiHokenshaInKouhiFutannMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukyufutaishosha.IKogakuKyufuTaishoshaMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護サービス費給付対象者取込みのバッチのビジネス。
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
public class KogakuKyufuTaishoshaInManager {

    private final MapperProvider mapperProvider;
    private final IKogakuKyufuTaishoshaMapper mapper;
    private final IKokuhorenKyoutsuuMapper 処理結果mapper;
    private final DbT3054KogakuKyufuTaishoshaMeisaiDac dbT3054Dac;
    private final DbT3055KogakuKyufuTaishoshaGokeiDac dbT3055Dac;
    private KogakuKyufuTaishoshaCsvEntity entity;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private KogakuKyufuTaishoshaDataCsvEntity dataEntity;
    private KogakuKyufuTaishoshaHeadCsvEntity csvHeadEntity;
    private KogakuKyufuTaishoshaGroupCsvEntity csvGroupEntity;
    private KogakuKyufuTaishoshaMeisaiCsvEntity csvMeisaiEntity;
    private KogakuKyufuTaishoshaGokeiCsvEntity csvGokeiEntity;
    private List<KogakuKyufuTaishoshaDataCsvEntity> dataList;
    private List<KogakuKyufuTaishoshaGroupCsvEntity> groupList;
    private List<KogakuKyufuTaishoshaMeisaiCsvEntity> meisaiList;
    private final RString レコード種別 = new RString("1");
    private final RString 帳票レコード種別_H1 = new RString("H1");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private final RString 帳票レコード種別_T1 = new RString("T1");
    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_3 = 3;
    private static final RString エラー区分_登録対象なし = new RString("99");
    private static final RString エラー区分_再処理不可 = new RString("60");
    private static final RString エラー区分_再処理データなし = new RString("61");
    private static final RString 備考 = new RString("関連データ：高額介護サービス費支給申請データ");
    private static final RString パラメターキー = new RString("帳票レコード種別");
    private static final int 履歴番号デフォルト = 1;

    private int 連番 = 0;
    private int レコード番号 = 0;
    private int 集計件数合計 = 0;
    private int 明細件数合計 = 0;
    private int コントロールレコードのレコード件数の合計 = 0;
    private FlexibleYearMonth 処理対象年月;

    /**
     * コンストラクタです。
     */
    public KogakuKyufuTaishoshaInManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(IKogakuKyufuTaishoshaMapper.class);
        this.処理結果mapper = mapperProvider.create(IKokuhorenKyoutsuuMapper.class);
        this.dbT3054Dac = InstanceProvider.create(DbT3054KogakuKyufuTaishoshaMeisaiDac.class);
        this.dbT3055Dac = InstanceProvider.create(DbT3055KogakuKyufuTaishoshaGokeiDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    KogakuKyufuTaishoshaInManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
        this.mapper = mapperProvider.create(IKogakuKyufuTaishoshaMapper.class);
        this.処理結果mapper = mapperProvider.create(IKokuhorenKyoutsuuMapper.class);
        this.dbT3054Dac = InstanceProvider.create(DbT3054KogakuKyufuTaishoshaMeisaiDac.class);
        this.dbT3055Dac = InstanceProvider.create(DbT3055KogakuKyufuTaishoshaGokeiDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KogakuKyufuTaishoshaInManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KogakuKyufuTaishoshaInManager}のインスタンス
     */
    public static KogakuKyufuTaishoshaInManager createInstance() {
        return InstanceProvider.create(KogakuKyufuTaishoshaInManager.class);
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
        IKagoKetteiHokenshaInKouhiFutannMapper 一時mapper = mapperProvider.create(IKagoKetteiHokenshaInKouhiFutannMapper.class);
        mapper.create高額介護サービス費給付対象者一時TBL();
        一時mapper.create被保険者一時TBL();
        一時mapper.create処理結果リスト一時TBL();
        return 取込件数確認(保存先フォルダ, エントリ情報List);
    }

    @Transaction
    private FlowEntity 取込件数確認(RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<KogakuKyufuTaishoshaCsvEntity> csvlist = csvファイル読込(保存先フォルダ, エントリ情報List);
        連番 = 0;
        レコード番号 = 0;
        集計件数合計 = 0;
        明細件数合計 = 0;
        処理対象年月 = FlexibleYearMonth.EMPTY;
        高額介護サービス費給付対象者一時TBLに登録(csvlist);
        if ((集計件数合計 + 明細件数合計) == INDEX_0) {
            登録対象なしエラー登録();
        }
        FlowEntity flowEntity = new FlowEntity();
        flowEntity.setCodeNum(コントロールレコードのレコード件数の合計);
        flowEntity.set明細データ登録件数(明細件数合計);
        flowEntity.set集計データ登録件数(集計件数合計);
        flowEntity.setShoriYM(処理対象年月);
        return flowEntity;

    }

    @Transaction
    private void 高額介護サービス費給付対象者一時TBLに登録(List<KogakuKyufuTaishoshaCsvEntity> csvlist) {
        for (KogakuKyufuTaishoshaCsvEntity csvEntity : csvlist) {
            KagoKetteiHokenshaInControlCsvEntity コントロールレコード = csvEntity.getControlCsvEntity();
            コントロールレコードのレコード件数の合計 = コントロールレコードのレコード件数の合計
                    + Integer.valueOf(コントロールレコード.getCodeNum().toString());
            if (FlexibleYearMonth.EMPTY.equals(処理対象年月)) {
                処理対象年月 = new FlexibleYearMonth(コントロールレコード.getShoriYM());
            }
            for (KogakuKyufuTaishoshaDataCsvEntity 保険者X : csvEntity.getListDataEntity()) {
                保険者X関連処理(保険者X, mapper);
            }
        }
    }

    private void 保険者X関連処理(KogakuKyufuTaishoshaDataCsvEntity 保険者X, IKogakuKyufuTaishoshaMapper mapper) {
        KogakuKyufuTaishoshaHeadCsvEntity ヘッダー = 保険者X.getHeadCsvEntity();
        for (KogakuKyufuTaishoshaGroupCsvEntity 被保険者XのY月分 : 保険者X.getListGroupCsvEntity()) {
            KogakuKyufuTaishoshaGokeiCsvEntity 集計 = 被保険者XのY月分.getGokeiCsvEntity();
            FlexibleYearMonth サービス提供年月 = FlexibleYearMonth.EMPTY;
            if (null != 被保険者XのY月分.getListMeisaiCsvEntity() && !被保険者XのY月分.getListMeisaiCsvEntity().isEmpty()) {
                サービス提供年月 = new FlexibleYearMonth(
                        被保険者XのY月分.getListMeisaiCsvEntity().get(0).getサービス提供年月());
            }
            連番 = 連番 + 1;
            レコード番号 = レコード番号 + 1;
            高額介護サービス費給付対象者一時TBLに集計保存(サービス提供年月, 集計, ヘッダー, mapper);
            for (KogakuKyufuTaishoshaMeisaiCsvEntity 明細 : 被保険者XのY月分.getListMeisaiCsvEntity()) {
                レコード番号 = レコード番号 + 1;
                高額介護サービス費給付対象者一時TBLに明細保存(サービス提供年月, 明細, ヘッダー, mapper);
                被保険者一時TBLに保存(サービス提供年月, 明細, ヘッダー, mapper);
            }
        }
    }

    private void 高額介護サービス費給付対象者一時TBLに集計保存(FlexibleYearMonth サービス提供年月,
            KogakuKyufuTaishoshaGokeiCsvEntity 集計, KogakuKyufuTaishoshaHeadCsvEntity ヘッダー,
            IKogakuKyufuTaishoshaMapper mapper) {
        DbWT3054KogakuKyufuTaishoshaTempEntity 集計Entity = new DbWT3054KogakuKyufuTaishoshaTempEntity();
        集計Entity.set連番(連番);
        集計Entity.setレコード番号(レコード番号);
        集計Entity.set帳票レコード種別(帳票レコード種別_T1);
        ShoKisaiHokenshaNo 証記載保険者番号 = ShoKisaiHokenshaNo.EMPTY;
        if (!RString.isNullOrEmpty(ヘッダー.get証記載保険者番号())) {
            証記載保険者番号 = new ShoKisaiHokenshaNo(ヘッダー.get証記載保険者番号());
        }
        集計Entity.set証記載保険者番号(証記載保険者番号);
        集計Entity.set証記載保険者名(ヘッダー.get保険者名());
        FlexibleDate 作成年月日 = FlexibleDate.EMPTY;
        if (!RString.isNullOrEmpty(ヘッダー.get作成年月日())) {
            作成年月日 = new FlexibleDate(ヘッダー.get作成年月日());
        }
        集計Entity.set作成年月日(作成年月日);
        集計Entity.set国保連合会名(ヘッダー.get国保連合会名());
        集計Entity.setサービス提供年月(サービス提供年月);
        集計Entity.setサービス費用合計額合計(toDecimal(集計.getサービス費用合計額合計()));
        集計Entity.set利用者負担額合計(toDecimal(集計.get利用者負担額合計()));
        集計Entity.set算定基準額(toDecimal(集計.get算定基準額()));
        集計Entity.set支払済金額合計(toDecimal(集計.get支払済金額合計()));
        集計Entity.set高額支給額(toDecimal(集計.get高額支給額()));
        集計Entity.set再処理不可フラグ(false);
        if (0 != mapper.高額介護サービス費給付対象者一時TBLに登録(集計Entity)) {
            集計件数合計 = 集計件数合計 + 1;
        }
    }

    private void 高額介護サービス費給付対象者一時TBLに明細保存(FlexibleYearMonth サービス提供年月,
            KogakuKyufuTaishoshaMeisaiCsvEntity 明細, KogakuKyufuTaishoshaHeadCsvEntity ヘッダー,
            IKogakuKyufuTaishoshaMapper mapper) {
        DbWT3054KogakuKyufuTaishoshaTempEntity 明細Entity = new DbWT3054KogakuKyufuTaishoshaTempEntity();
        明細Entity.set連番(連番);
        明細Entity.setレコード番号(レコード番号);
        明細Entity.set帳票レコード種別(帳票レコード種別_D1);
        ShoKisaiHokenshaNo 証記載保険者番号 = ShoKisaiHokenshaNo.EMPTY;
        if (!RString.isNullOrEmpty(ヘッダー.get証記載保険者番号())) {
            証記載保険者番号 = new ShoKisaiHokenshaNo(ヘッダー.get証記載保険者番号());
        }
        明細Entity.set証記載保険者番号(証記載保険者番号);
        明細Entity.set証記載保険者名(ヘッダー.get保険者名());
        FlexibleDate 作成年月日 = FlexibleDate.EMPTY;
        if (!RString.isNullOrEmpty(ヘッダー.get作成年月日())) {
            作成年月日 = new FlexibleDate(ヘッダー.get作成年月日());
        }
        明細Entity.set作成年月日(作成年月日);
        明細Entity.set国保連合会名(ヘッダー.get国保連合会名());
        明細Entity.setNo(明細.getNo());
        明細Entity.setサービス提供年月(サービス提供年月);
        JigyoshaNo 事業所番号 = JigyoshaNo.EMPTY;
        if (!RString.isNullOrEmpty(明細.get事業所番号())) {
            事業所番号 = new JigyoshaNo(明細.get事業所番号());
        }
        明細Entity.set事業所番号(事業所番号);
        明細Entity.set事業所名(明細.get事業所名_漢字());
        ServiceShuruiCode サービス種類コード = ServiceShuruiCode.EMPTY;
        if (!RString.isNullOrEmpty(明細.getサービス種類コード())) {
            サービス種類コード = new ServiceShuruiCode(明細.getサービス種類コード());
        }
        明細Entity.setサービス種類コード(サービス種類コード);
        明細Entity.setサービス種類名(明細.getサービス種類名());
        明細Entity.setサービス費用合計額(toDecimal(明細.getサービス費用合計額()));
        明細Entity.set利用者負担額(toDecimal(明細.get使用者負担額()));
        明細Entity.set備考(明細.get備考());
        明細Entity.set再処理不可フラグ(false);
        if (0 != mapper.高額介護サービス費給付対象者一時TBLに登録(明細Entity)) {
            明細件数合計 = 明細件数合計 + 1;
        }
    }

    private void 被保険者一時TBLに保存(FlexibleYearMonth サービス提供年月,
            KogakuKyufuTaishoshaMeisaiCsvEntity 明細, KogakuKyufuTaishoshaHeadCsvEntity ヘッダー,
            IKogakuKyufuTaishoshaMapper mapper) {
        DbWT0001HihokenshaTempEntity 被保険者 = new DbWT0001HihokenshaTempEntity();
        被保険者.set連番(連番);
        ShoKisaiHokenshaNo 証記載保険者番号 = ShoKisaiHokenshaNo.EMPTY;
        if (!RString.isNullOrEmpty(ヘッダー.get証記載保険者番号())) {
            証記載保険者番号 = new ShoKisaiHokenshaNo(ヘッダー.get証記載保険者番号());
        }
        被保険者.set証記載保険者番号(証記載保険者番号);
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        if (!RString.isNullOrEmpty(明細.get被保険者番号())) {
            被保険者番号 = new HihokenshaNo(明細.get被保険者番号());
        }
        被保険者.set被保険者番号(被保険者番号);
        int day = サービス提供年月.getLastDay();
        RString date = サービス提供年月.toDateString().concat(new RString(day));
        被保険者.setサービス提供年月末日(new FlexibleDate(date));
        被保険者.set被保険者カナ氏名(RString.EMPTY);
        被保険者.set被保険者氏名(明細.get被保険者氏名_漢字());
        被保険者.set旧市町村コード(LasdecCode.EMPTY);
        被保険者.set変換被保険者番号(null);
        被保険者.set登録被保険者番号(被保険者番号);
        被保険者.set市町村コード(LasdecCode.EMPTY);
        被保険者.set管内管外区分(RString.EMPTY);
        被保険者.set郵便番号(RString.EMPTY);
        被保険者.set町域コード(RString.EMPTY);
        被保険者.set行政区コード(RString.EMPTY);
        被保険者.set行政区名(RString.EMPTY);
        被保険者.set住所(RString.EMPTY);
        被保険者.set番地(RString.EMPTY);
        被保険者.set方書(RString.EMPTY);
        被保険者.set宛名カナ名称(RString.EMPTY);
        被保険者.set宛名名称(RString.EMPTY);
        被保険者.set氏名50音カナ(RString.EMPTY);
        被保険者.set識別コード(RString.EMPTY);
        被保険者.set資格取得日(FlexibleDate.EMPTY);
        被保険者.set資格取得事由コード(RString.EMPTY);
        被保険者.set資格喪失日(FlexibleDate.EMPTY);
        被保険者.set資格喪失事由コード(RString.EMPTY);
        被保険者.set世帯集約番号(RString.EMPTY);
        if (0 == mapper.select被保険者の件数(被保険者)) {
            mapper.被保険者一時TBLに登録(被保険者);
        }
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
     * @return List<KogakuKyufuTaishoshaCsvEntity>
     */
    private List<KogakuKyufuTaishoshaCsvEntity> csvファイル読込(RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<KogakuKyufuTaishoshaCsvEntity> list = new ArrayList<>();
        List<RString> csvFullPathList = new ArrayList<>();
        for (int i = INDEX_0; i < エントリ情報List.size(); i++) {
            File path = new File(保存先フォルダ + File.separator + エントリ情報List.get(i));
            RString csvFullPath = new RString(path.getPath());
            csvFullPathList.add(csvFullPath);
        }

        for (int j = INDEX_0; j < csvFullPathList.size(); j++) {
            entity = new KogakuKyufuTaishoshaCsvEntity();
            controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
            dataEntity = new KogakuKyufuTaishoshaDataCsvEntity();
            csvHeadEntity = new KogakuKyufuTaishoshaHeadCsvEntity();
            csvGroupEntity = new KogakuKyufuTaishoshaGroupCsvEntity();
            csvMeisaiEntity = new KogakuKyufuTaishoshaMeisaiCsvEntity();
            csvGokeiEntity = new KogakuKyufuTaishoshaGokeiCsvEntity();
            dataList = new ArrayList<>();
            groupList = new ArrayList<>();
            meisaiList = new ArrayList<>();
            try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(csvFullPathList.get(j)).setDelimiter(カンマ).setEncode(Encode.SJIS)
                    .hasHeader(false).setNewLine(NewLine.CRLF).build()) {
                while (true) {
                    List<RString> data = csvReader.readLine();
                    if (data != null && !data.isEmpty()) {
                        if (レコード種別.equals(data.get(INDEX_0))) {
                            controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
                        } else if (帳票レコード種別_H1.equals(data.get(INDEX_3))) {
                            addToGroup();
                            csvHeadEntity = ListToObjectMappingHelper.toObject(KogakuKyufuTaishoshaHeadCsvEntity.class, data);
                        } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                            csvMeisaiEntity = ListToObjectMappingHelper.toObject(KogakuKyufuTaishoshaMeisaiCsvEntity.class, data);
                            meisaiList.add(csvMeisaiEntity);
                        } else if (帳票レコード種別_T1.equals(data.get(INDEX_3))) {
                            csvGokeiEntity = ListToObjectMappingHelper.toObject(KogakuKyufuTaishoshaGokeiCsvEntity.class, data);
                            csvGroupEntity = new KogakuKyufuTaishoshaGroupCsvEntity();
                            csvGroupEntity.setGokeiCsvEntity(csvGokeiEntity);
                            csvGroupEntity.setListMeisaiCsvEntity(meisaiList);
                            meisaiList = new ArrayList<>();
                            groupList.add(csvGroupEntity);
                        }
                    } else {
                        break;
                    }
                }
                addToGroup();
                entity.setControlCsvEntity(controlCsvEntity);
                entity.setListDataEntity(dataList);
                list.add(entity);
            }
        }
        return list;
    }

    private void addToGroup() {
        if (!groupList.isEmpty()) {
            dataEntity.setHeadCsvEntity(csvHeadEntity);
            dataEntity.setListGroupCsvEntity(groupList);
            dataList.add(dataEntity);
            csvHeadEntity = new KogakuKyufuTaishoshaHeadCsvEntity();
            csvGroupEntity = new KogakuKyufuTaishoshaGroupCsvEntity();
            csvMeisaiEntity = new KogakuKyufuTaishoshaMeisaiCsvEntity();
            csvGokeiEntity = new KogakuKyufuTaishoshaGokeiCsvEntity();
            groupList = new ArrayList<>();
            meisaiList = new ArrayList<>();
        }
    }

    /**
     * マスタ登録
     *
     * @param 再処理区分 SaiShoriKubun
     * @param 処理年月 FlexibleYearMonth
     */
    @Transaction
    public void doマスタ登録(SaiShoriKubun 再処理区分, FlexibleYearMonth 処理年月) {
        if (SaiShoriKubun.再処理.equals(再処理区分)) {
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("処理年月", 処理年月);
            List<DbT3055KogakuKyufuTaishoshaGokeiEntity> 合計List = mapper.合計再処理対象データの取得(parameter);
            List<DbT3054KogakuKyufuTaishoshaMeisaiEntity> 明細List = mapper.明細再処理対象データの取得(parameter);
            for (DbT3055KogakuKyufuTaishoshaGokeiEntity 合計 : 合計List) {
                合計.setState(EntityDataState.Deleted);
                dbT3055Dac.delete(合計);
            }
            for (DbT3054KogakuKyufuTaishoshaMeisaiEntity 明細 : 明細List) {
                明細.setState(EntityDataState.Deleted);
                dbT3054Dac.delete(明細);
            }
            List<SaishoriFukaEntity> 再処理不可データリスト = mapper.再処理不可データの取得(parameter);
            if (isNotEmptyList(再処理不可データリスト)) {
                for (SaishoriFukaEntity データ : 再処理不可データリスト) {
                    再処理不可データの登録とエラー登録(データ);
                }
            }
        }
        if (0 == マスタ登録(処理年月)) {
            登録対象なしエラー登録();
        }
    }

    private boolean isNotEmptyList(List list) {
        return null != list && !list.isEmpty();
    }

    private void 再処理不可データの登録とエラー登録(SaishoriFukaEntity データ) {
        if (isNotEmptyList(データ.get一時リスト())) {
            for (KyuufuTaishoshaHihokenshaEntity 一時 : データ.get一時リスト()) {
                mapper.高額介護サービス費給付対象者一時TBLに再処理不可登録(一時.get対象者());
                再処理不可エラー登録(一時.get被保険者一時());
            }
        } else {
            再処理データなしエラー登録(データ.get合計(), データ.get宛名());
        }
    }

    private void 再処理不可エラー登録(DbWT0001HihokenshaTempEntity 被保険者一時) {
        DbWT0002KokuhorenTorikomiErrorTempEntity 処理結果 = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        処理結果.setエラー区分(エラー区分_再処理不可);
        処理結果.set証記載保険者番号(被保険者一時.get証記載保険者番号());
        処理結果.set被保険者番号(被保険者一時.get登録被保険者番号());
        if (null != 被保険者一時.getサービス提供年月末日()) {
            RString サービス提供年月末日の年月 = 被保険者一時.getサービス提供年月末日().getYearMonth().wareki().
                    firstYear(FirstYear.ICHI_NEN).toDateString();
            処理結果.setキー1(サービス提供年月末日の年月);
        }
        処理結果.set被保険者カナ氏名(被保険者一時.get被保険者カナ氏名());
        処理結果.set被保険者氏名(被保険者一時.get被保険者氏名());
        処理結果.set備考(備考);
        do一意排他登録処理結果(処理結果);
    }

    private void 再処理データなしエラー登録(DbT3055KogakuKyufuTaishoshaGokeiEntity 合計,
            UaFt200FindShikibetsuTaishoEntity 宛名) {
        IShikibetsuTaisho 識別対象 = ShikibetsuTaishoFactory.createKojin(宛名);
        DbWT0002KokuhorenTorikomiErrorTempEntity 処理結果 = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        処理結果.setエラー区分(エラー区分_再処理データなし);
        //TODO 高額介護サービス費給付対象者合計TBL．証記載保険者番号
//        処理結果.set証記載保険者番号(合計);
        処理結果.set被保険者番号(合計.getHihokenshaNo());
        if (null != 合計.getServiceTeikyoYM()) {
            RString サービス提供年月 = 合計.getServiceTeikyoYM().wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
            処理結果.setキー1(サービス提供年月);
        }
        if (null != 識別対象.get名称()) {
            処理結果.set被保険者カナ氏名(識別対象.get名称().getKana().getColumnValue());
            処理結果.set被保険者氏名(識別対象.get名称().getName().getColumnValue());
        }
        処理結果.set備考(備考);
        do一意排他登録処理結果(処理結果);
    }

    private void 登録対象なしエラー登録() {
        DbWT0002KokuhorenTorikomiErrorTempEntity 処理結果 = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        処理結果.setエラー区分(エラー区分_登録対象なし);
        do一意排他登録処理結果(処理結果);
    }

    private int マスタ登録(FlexibleYearMonth 処理年月) {
        List<RirikiNoKanrenEntity> 履歴番号確認データリスト = mapper.select履歴番号確認データ();
        Map<RString, Integer> 履歴番号Map = new HashMap<>();
        if (isNotEmptyList(履歴番号確認データリスト)) {
            for (RirikiNoKanrenEntity 履歴番号確認データ : 履歴番号確認データリスト) {
                RString キー = 履歴番号確認データ.get被保険者番号().getColumnValue()
                        .concat(履歴番号確認データ.getサービス提供年月().toDateString());
                履歴番号Map.put(キー, 履歴番号確認データ.get履歴番号());
            }
        }
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(パラメターキー.toString(), 帳票レコード種別_D1);
        List<KyuufuTaishoshaHihokenshaEntity> マスタ登録用明細リスト = mapper.selectマスタ登録用データ(parameter);
        for (KyuufuTaishoshaHihokenshaEntity マスタ登録用明細 : マスタ登録用明細リスト) {
            DbWT3054KogakuKyufuTaishoshaTempEntity 対象者 = マスタ登録用明細.get対象者();
            int 履歴番号 = get履歴番号(マスタ登録用明細, 履歴番号Map);
            DbT3054KogakuKyufuTaishoshaMeisaiEntity 明細 = new DbT3054KogakuKyufuTaishoshaMeisaiEntity();
            明細.setHihokenshaNo(マスタ登録用明細.get被保険者一時().get登録被保険者番号());
            明細.setServiceTeikyoYM(対象者.getサービス提供年月());
            明細.setJigyoshaNo(対象者.get事業所番号());
            明細.setServiceShuruiCode(対象者.getサービス種類コード());
            明細.setRirekiNo(履歴番号);
            明細.setServiceHiyoGokeiGaku(対象者.getサービス費用合計額());
            明細.setRiyoshaFutanGaku(対象者.get利用者負担額());
            明細.setKogakuKyufuKonkyo(対象者.get備考());
            明細.setTaishoshaUketoriYM(処理年月);
            明細.setState(EntityDataState.Added);
            dbT3054Dac.save(明細);
        }
        parameter.clear();
        parameter.put(パラメターキー.toString(), 帳票レコード種別_T1);
        List<KyuufuTaishoshaHihokenshaEntity> マスタ登録用合計リスト = mapper.selectマスタ登録用データ(parameter);
        for (KyuufuTaishoshaHihokenshaEntity マスタ登録用合計 : マスタ登録用合計リスト) {
            DbWT3054KogakuKyufuTaishoshaTempEntity 対象者 = マスタ登録用合計.get対象者();
            DbT3055KogakuKyufuTaishoshaGokeiEntity 合計 = new DbT3055KogakuKyufuTaishoshaGokeiEntity();
            int 履歴番号 = get履歴番号(マスタ登録用合計, 履歴番号Map);
            合計.setHihokenshaNo(マスタ登録用合計.get被保険者一時().get登録被保険者番号());
            合計.setServiceTeikyoYM(対象者.getサービス提供年月());
            合計.setRirekiNo(new Decimal(履歴番号));
            合計.setServiceHiyoGokeiGakuGokei(対象者.getサービス費用合計額合計());
            合計.setRiyoshaFutanGakuGokei(対象者.get利用者負担額合計());
            合計.setSanteiKijunGaku(対象者.get算定基準額());
            合計.setShiharaiSumiKingakuGokei(対象者.get支払済金額合計());
            合計.setKogakuShikyuGaku(対象者.get高額支給額());
            合計.setTashoshaUketoriYM(処理年月);
            合計.setTaishoshaHanteiShinsaYM(対象者.get作成年月日().getYearMonth());
            合計.setSetaiShuyakuNo(マスタ登録用合計.get被保険者一時().get世帯集約番号());
            合計.setKyokaisoTaishoshaFlag(false);
            合計.setHojinKeigenTaishoFlag(false);
            合計.setKogakuTaishoGaiFlag(false);
            合計.setJidoShokanTaishoFlag(false);
            合計.setState(EntityDataState.Added);
            dbT3055Dac.save(合計);
        }
        return マスタ登録用明細リスト.size() + マスタ登録用合計リスト.size();
    }

    private boolean do一意排他登録処理結果(DbWT0002KokuhorenTorikomiErrorTempEntity kekka) {
        if (処理結果mapper.count処理結果ByPK(kekka) == 0) {
            処理結果mapper.insert処理結果リスト一時TBL(kekka);
        } else {
            return false;
        }
        return true;
    }

    private int get履歴番号(KyuufuTaishoshaHihokenshaEntity マスタ登録用データ, Map<RString, Integer> 履歴番号Map) {
        RString キー = マスタ登録用データ.get被保険者一時().get登録被保険者番号().getColumnValue()
                .concat(マスタ登録用データ.get対象者().getサービス提供年月().toDateString());
        int 履歴番号 = 履歴番号デフォルト;
        if (!履歴番号Map.isEmpty() && 履歴番号Map.containsKey(キー)) {
            履歴番号 = 履歴番号Map.get(キー) + 1;
            履歴番号Map.put(キー, 履歴番号);
            return 履歴番号;
        }
        履歴番号Map.put(キー, 履歴番号);
        return 履歴番号デフォルト;
    }

    /**
     * get帳票出力対象データ
     *
     * @param mybatisParameter Map<String, Object>
     * @return List<KyuufuTaishoshaHihokenshaEntity>
     */
    public List<KyuufuTaishoshaHihokenshaEntity> get帳票出力対象データ(Map<String, Object> mybatisParameter) {
        List<KyuufuTaishoshaHihokenshaEntity> 帳票出力対象データリスト = mapper.select帳票出力対象データ(mybatisParameter);
        if (null == 帳票出力対象データリスト) {
            return Collections.EMPTY_LIST;
        }
        return 帳票出力対象データリスト;
    }

}
