/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoin.KyufukanrihyoInCsvReadReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuCsvFileReadProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenkyotsu.KokuhorenkyoutsuControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufukanrihyoin.KyufukanrihyoInMeisaiGoEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufukanrihyoin.KyufukanrihyoInMeisaiZenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT1121KyufuKanrihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuTempTableMapper;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
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

/**
 * 公費負担者分・ファイル読込を実行する。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
public class KyufukanrihyoReadCsvFileProcess extends BatchProcessBase<RString> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KokuhorenkyotsuCsvFileReadProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private OutputParameter<KyufukanrihyoInCsvReadReturnEntity> flowEntity;

    private final RString 区切り文字 = new RString(",");
    private IKokuhorenKyoutsuuTempTableMapper 一時表Mapper;

    private final RString レコード種別 = new RString("1");
    private final RString レコード種別_エンド = new RString("3");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_2 = 2;
    private static final Integer INDEX_3 = 3;
    private static final RString NUM = new RString("99");
    private static final RString 交換情報識別番号_前 = new RString("1121");
    private static final RString 交換情報識別番号_後 = new RString("1122");

    private static final RString 市町村セキュリティ情報の取得実行不可 = new RString("市町村セキュリティ情報の取得");
    private static final RString 被保険者番号変換基準日の取得実行不可 = new RString("被保険者番号変換基準日の取得");

    private KyufukanrihyoInCsvReadReturnEntity returnEntity;
    private KokuhorenkyoutsuControlCsvEntity controlCsvEntity;
    private KyufukanrihyoInMeisaiZenEntity meisaiZenEntity;
    private KyufukanrihyoInMeisaiGoEntity meisaiGoEntity;
    private int 連番;
    private FlexibleYearMonth 処理対象年月;
    private RString 保険者番号;
    private RString 保険者名;
    private FlexibleDate 被保険者番号変換基準日;
    private DonyuKeitaiCode 導入形態コード;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付管理票一時tableWriter;
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 給付管理票一時_TABLE_NAME = new RString("DbWT1121KyufuKanrihyo");

    @Override
    protected void initialize() {
        controlCsvEntity = new KokuhorenkyoutsuControlCsvEntity();
        meisaiZenEntity = new KyufukanrihyoInMeisaiZenEntity();
        meisaiGoEntity = new KyufukanrihyoInMeisaiGoEntity();
        returnEntity = new KyufukanrihyoInCsvReadReturnEntity();
        連番 = parameter.get明細件数合算();
    }

    @Override
    protected void beforeExecute() {
        一時表Mapper = getMapper(IKokuhorenKyoutsuuTempTableMapper.class);
        証記載保険者番号取得の判断基準の取得();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.get保存先パース());
    }

    @Override
    protected void createWriter() {
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaIchijiEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
        給付管理票一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付管理票一時_TABLE_NAME, DbWT1121KyufuKanrihyoEntity.class);
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(区切り文字.toString());
        if (data != null && !data.isEmpty()) {
            if (レコード種別_エンド.equals(data.get(INDEX_0))) {
                return;
            }
            if (レコード種別.equals(data.get(INDEX_0))) {
                controlCsvEntity = ListToObjectMappingHelper.
                        toObject(KokuhorenkyoutsuControlCsvEntity.class, data);
                set処理対象年月();
                保険者番号 = controlCsvEntity.getHokenshaNo();
                HokenshaNyuryokuHojoFinder 保険者Finder = HokenshaNyuryokuHojoFinder.createInstance();
                Hokensha 保険者 = 保険者Finder.getHokensha(new HokenjaNo(保険者番号));
                保険者名 = null == 保険者 ? RString.EMPTY : 保険者.get保険者名();
            } else if (帳票レコード種別_D1.equals(data.get(INDEX_3)) && 交換情報識別番号_前.equals(data.get(INDEX_2))) {
                meisaiZenEntity = ListToObjectMappingHelper.
                        toObject(KyufukanrihyoInMeisaiZenEntity.class, data);
                連番 = 連番 + 1;
                前データを一時TBLに登録する(meisaiZenEntity, 連番, parameter.get処理年月(), 保険者番号, 保険者名);
            } else if (帳票レコード種別_D1.equals(data.get(INDEX_3)) && 交換情報識別番号_後.equals(data.get(INDEX_2))) {
                meisaiGoEntity = ListToObjectMappingHelper.
                        toObject(KyufukanrihyoInMeisaiGoEntity.class, data);
                連番 = 連番 + 1;
                後データを一時TBLに登録する(meisaiGoEntity, 連番, parameter.get処理年月(), 保険者番号, 保険者名);
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (parameter.isLast() && 連番 == INDEX_0) {
            DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
            errorTempentity.setエラー区分(NUM);
            一時表Mapper.処理結果リスト一時TBLに登録(errorTempentity);
        }
        returnEntity.set明細件数合算(連番);
        returnEntity.setレコード件数合算(parameter.getレコード件数合算()
                + Integer.valueOf(controlCsvEntity.getCodeNum().toString()));
    }

    private void set処理対象年月() {
        if (null == returnEntity.get処理対象年月()) {
            処理対象年月 = new FlexibleYearMonth(controlCsvEntity.getShoriYM());
            returnEntity.set処理対象年月(処理対象年月);
        }
    }

    private void 証記載保険者番号取得の判断基準の取得() {
        ShichosonSecurityJohoFinder 市町村finder = ShichosonSecurityJohoFinder.createInstance();
        ShichosonSecurityJoho joho = 市町村finder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (null == joho) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(市町村セキュリティ情報の取得実行不可.toString()).toString());
        }
        導入形態コード = joho.get導入形態コード();
        returnEntity.set市町村セキュリティ情報(joho);
        GappeiCityJohoBFinder 変換基準日finder = GappeiCityJohoBFinder.createInstance();
        被保険者番号変換基準日 = 変換基準日finder.getHihokenshaBangoHenkanKijunbi(GyomuBunrui.介護事務,
                導入形態コード);
        if (null == 被保険者番号変換基準日) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(被保険者番号変換基準日の取得実行不可.toString()).toString());
        }
        returnEntity.set変換基準日(被保険者番号変換基準日);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);
    }

    private void 前データを一時TBLに登録する(KyufukanrihyoInMeisaiZenEntity zenEntity, int 連番,
            FlexibleYearMonth 処理年月, RString 保険者番号, RString 保険者名) {
        FlexibleYearMonth 対象年月 = get年月(zenEntity.get対象年月());
        DbWT1121KyufuKanrihyoEntity 登録Entity = new DbWT1121KyufuKanrihyoEntity();
        登録Entity.setRenban(連番);
        登録Entity.setKokanJohoShikibetsuNo(zenEntity.get交換情報識別番号());
        登録Entity.setShinsaYM(get年月(zenEntity.get審査年月()));
        登録Entity.setServiceTeikyoYM(対象年月);
        登録Entity.setKyufuShubetsuKubunCode(zenEntity.get給付管理票種別区分コード());
        登録Entity.setKyufuMeisaiLineNo(zenEntity.get給付管理票明細行番号());
        登録Entity.setKyotakushienJigyoshoNo(zenEntity.get事業所番号_居宅介護支援事業所());
        登録Entity.setKyufuSakuseiKubunCode(zenEntity.get給付管理票情報作成区分コード());
        登録Entity.setKyufuSakuseiYMD(get年月日(zenEntity.get給付管理票作成年月日()));
        登録Entity.setMeisaiHokenshaNo(zenEntity.get保険者番号());
        登録Entity.setHiHokenshaUmareYMD(get年月日(zenEntity.get被保険者生年月日()));
        登録Entity.setSeibetsuCode(zenEntity.get被保険者性別コード());
        登録Entity.setYoKaigoJotaiKubunCode(zenEntity.get要介護状態区分コード());
        登録Entity.setGendogakuTekiyoKaishiYM(get年月(zenEntity.get限度額適用期間_開始()));
        登録Entity.setGendogakuTekiyoShuryoYM(get年月(zenEntity.get限度額適用期間_終了()));
        登録Entity.setKyotakuKaigoYoboShikyuGendogaku(getDecimal(zenEntity.get訪問通所_短期入所支給限度額()));
        登録Entity.setKyotakuServicePlanSakuseiKubunCode(zenEntity.get居宅サービス計画作成区分コード());
        登録Entity.setServiceJigyoshoNo(getNotNullRString(zenEntity.get事業所番号_サービス事業所()));
        登録Entity.setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(getNotNullRString(zenEntity.get指定等事業所区分コード()));
        登録Entity.setServiceShuruiCode(getNotNullRString(zenEntity.getサービス種別コード()));
        登録Entity.setKyufuKeikakuTanisuNissu(getDecimal(zenEntity.get給付計画単位数_日数()));
        登録Entity.setKyufuKeikakuNissu(getDecimal(zenEntity.get限度額管理期間における前月までの給付計画日数()));
        登録Entity.setShiteiServiceSubTotal(getDecimal(zenEntity.get指定サービス分小計()));
        登録Entity.setKijyunGaitoServiceSubTotal(getDecimal(zenEntity.get基準該当サービス分小計()));
        登録Entity.setKyufuKeikakuTotalTanisuNissu(getDecimal(zenEntity.get給付計画合計単位数_日数()));
        登録Entity.setTantoKaigoShienSemmoninNo(RString.EMPTY);
        登録Entity.setKaigoShienJigyoshaNo(RString.EMPTY);
        登録Entity.setItakusakiTantoKaigoShienSemmoninNo(RString.EMPTY);
        登録Entity.setToshoTorokuYMD(null);
        登録Entity.setTorikomiYM(処理年月);
        登録Entity.setHokenshaNo(保険者番号);
        登録Entity.setHokenshaName(保険者名);
        登録Entity.setJigyoshaName(RString.EMPTY);
        給付管理票一時tableWriter.insert(登録Entity);

        DbWT0001HihokenshaIchijiEntity 被保険者 = new DbWT0001HihokenshaIchijiEntity();
        被保険者.setMeisaiRenban(連番);
        FlexibleDate 対象年月末日 = new FlexibleDate(対象年月.toDateString().concat(new RString(対象年月.getLastDay())));
        if (FlexibleDate.EMPTY.equals(被保険者番号変換基準日) || 被保険者番号変換基準日.isBeforeOrEquals(対象年月末日)) {
            if (導入形態コード.is単一()) {
                被保険者.setShoHokenshaNo(new ShoKisaiHokenshaNo(zenEntity.get保険者番号()));
            } else {
                被保険者.setShoHokenshaNo(null);
            }
        } else if (対象年月末日.isBefore(被保険者番号変換基準日)) {
            被保険者.setShoHokenshaNo(new ShoKisaiHokenshaNo(zenEntity.get保険者番号()));
        }
        HihokenshaNo 被保険者番号 = new HihokenshaNo(zenEntity.get被保険者番号());
        被保険者.setOrgHihokenshaNo(被保険者番号);
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(zenEntity.get対象年月());
        int day = サービス提供年月.getLastDay();
        RString date = サービス提供年月.toDateString().concat(new RString(day));
        被保険者.setServiceTeikyoYmd(new FlexibleDate(date));
        被保険者.setHihokenshaNo(被保険者番号);
        被保険者一時tableWriter.insert(被保険者);
    }

    private void 後データを一時TBLに登録する(KyufukanrihyoInMeisaiGoEntity goEntity, int 連番,
            FlexibleYearMonth 処理年月, RString 保険者番号, RString 保険者名) {
        FlexibleYearMonth 対象年月 = get年月(goEntity.get対象年月());
        DbWT1121KyufuKanrihyoEntity 登録Entity = new DbWT1121KyufuKanrihyoEntity();
        登録Entity.setRenban(連番);
        登録Entity.setKokanJohoShikibetsuNo(goEntity.get交換情報識別番号());
        登録Entity.setShinsaYM(get年月(goEntity.get審査年月()));
        登録Entity.setServiceTeikyoYM(get年月(goEntity.get対象年月()));
        登録Entity.setKyufuShubetsuKubunCode(goEntity.get給付管理票種別区分コード());
        登録Entity.setKyufuMeisaiLineNo(goEntity.get給付管理票明細行番号());
        登録Entity.setKyotakushienJigyoshoNo(goEntity.get事業所番号());
        登録Entity.setKyufuSakuseiKubunCode(goEntity.get給付管理票情報作成区分コード());
        登録Entity.setKyufuSakuseiYMD(get年月日(goEntity.get給付管理票作成年月日()));
        登録Entity.setMeisaiHokenshaNo(goEntity.get保険者番号());
        登録Entity.setHiHokenshaUmareYMD(get年月日(goEntity.get被保険者生年月日()));
        登録Entity.setSeibetsuCode(goEntity.get被保険者性別コード());
        登録Entity.setYoKaigoJotaiKubunCode(goEntity.get要介護状態区分コード());
        登録Entity.setGendogakuTekiyoKaishiYM(get年月(goEntity.get限度額適用期間_開始()));
        登録Entity.setGendogakuTekiyoShuryoYM(get年月(goEntity.get限度額適用期間_終了()));
        登録Entity.setKyotakuKaigoYoboShikyuGendogaku(getDecimal(goEntity.get居宅_介護予防_総合事業支給限度額()));
        登録Entity.setKyotakuServicePlanSakuseiKubunCode(goEntity.get居宅サービス計画作成区分コード());
        登録Entity.setServiceJigyoshoNo(getNotNullRString(goEntity.get事業所番号_サービス事業所()));
        登録Entity.setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(getNotNullRString(goEntity.get指定等事業識別コード()));
        登録Entity.setServiceShuruiCode(getNotNullRString(goEntity.getサービス種別コード()));
        登録Entity.setKyufuKeikakuTanisuNissu(getDecimal(goEntity.get給付計画単位数_日数()));
        登録Entity.setKyufuKeikakuNissu(getDecimal(goEntity.get限度額管理期間における前月までの給付計画日数()));
        登録Entity.setShiteiServiceSubTotal(getDecimal(goEntity.get指定サービス分小計()));
        登録Entity.setKijyunGaitoServiceSubTotal(getDecimal(goEntity.get基準該当サービス分小計()));
        登録Entity.setKyufuKeikakuTotalTanisuNissu(getDecimal(goEntity.get給付計画合計単位数_日数()));
        登録Entity.setTantoKaigoShienSemmoninNo((getNotNullRString(goEntity.get担当介護支援専門員番号())));
        登録Entity.setKaigoShienJigyoshaNo(getNotNullRString(goEntity.get委託先の居宅介護支援事業所番号()));
        登録Entity.setItakusakiTantoKaigoShienSemmoninNo(getNotNullRString(goEntity.get委託先の担当介護支援専門員番号()));
        登録Entity.setToshoTorokuYMD(null);
        登録Entity.setTorikomiYM(処理年月);
        登録Entity.setHokenshaNo(保険者番号);
        登録Entity.setHokenshaName(保険者名);
        登録Entity.setJigyoshaName(RString.EMPTY);
        給付管理票一時tableWriter.insert(登録Entity);

        DbWT0001HihokenshaIchijiEntity 被保険者 = new DbWT0001HihokenshaIchijiEntity();
        被保険者.setMeisaiRenban(連番);
        FlexibleDate 対象年月末日 = new FlexibleDate(対象年月.toDateString().concat(new RString(対象年月.getLastDay())));
        if (FlexibleDate.EMPTY.equals(被保険者番号変換基準日) || 被保険者番号変換基準日.isBeforeOrEquals(対象年月末日)) {
            if (導入形態コード.is単一()) {
                被保険者.setShoHokenshaNo(new ShoKisaiHokenshaNo(goEntity.get保険者番号()));
            } else {
                被保険者.setShoHokenshaNo(null);
            }
        } else if (対象年月末日.isBefore(被保険者番号変換基準日)) {
            被保険者.setShoHokenshaNo(new ShoKisaiHokenshaNo(goEntity.get保険者番号()));
        }
        HihokenshaNo 被保険者番号 = new HihokenshaNo(goEntity.get被保険者番号());
        被保険者.setOrgHihokenshaNo(被保険者番号);
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(goEntity.get対象年月());
        int day = サービス提供年月.getLastDay();
        RString date = サービス提供年月.toDateString().concat(new RString(day));
        被保険者.setServiceTeikyoYmd(new FlexibleDate(date));
        被保険者.setHihokenshaNo(被保険者番号);
        被保険者一時tableWriter.insert(被保険者);
    }

    private FlexibleYearMonth get年月(RString 年月str) {
        if (RString.isNullOrEmpty(年月str)) {
            return null;
        }
        return new FlexibleYearMonth(年月str);
    }

    private FlexibleDate get年月日(RString 年月日str) {
        if (RString.isNullOrEmpty(年月日str)) {
            return null;
        }
        return new FlexibleDate(年月日str);
    }

    private Decimal getDecimal(RString decimalStr) {
        if (RString.isNullOrEmpty(decimalStr) || !Decimal.canConvert(decimalStr)) {
            return Decimal.ZERO;
        }
        return new Decimal(decimalStr.toString());
    }

    private RString getNotNullRString(RString str) {
        if (RString.isNullOrEmpty(str)) {
            return RString.EMPTY;
        }
        return str;
    }

}
