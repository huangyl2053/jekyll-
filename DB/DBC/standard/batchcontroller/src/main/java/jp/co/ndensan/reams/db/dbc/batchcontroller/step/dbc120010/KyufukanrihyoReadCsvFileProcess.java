/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoin.KyufukanrihyoInCsvReadReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuCsvFileReadProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenkyotsu.KokuhorenkyoutsuControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufukanrihyoin.KyufukanrihyoInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufukanrihyoin.KyufukanrihyoInMeisaiGoEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufukanrihyoin.KyufukanrihyoInMeisaiZenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT1121KyufuKanrihyoTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuTempTableMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufukanrihyoin.IKyufukanrihyoInMapper;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
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
    private IKyufukanrihyoInMapper mapper;
    private IKokuhorenKyoutsuuTempTableMapper 一時表Mapper;

    private final RString レコード種別 = new RString("1");
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
    private KyufukanrihyoInCsvEntity entity;
    private KokuhorenkyoutsuControlCsvEntity controlCsvEntity;
    private KyufukanrihyoInMeisaiZenEntity meisaiZenEntity;
    private KyufukanrihyoInMeisaiGoEntity meisaiGoEntity;
    private List<KyufukanrihyoInMeisaiZenEntity> meisaiZenList;
    private List<KyufukanrihyoInMeisaiGoEntity> meisaiGoList;

    @Override
    protected void initialize() {
        entity = new KyufukanrihyoInCsvEntity();
        controlCsvEntity = new KokuhorenkyoutsuControlCsvEntity();
        meisaiZenEntity = new KyufukanrihyoInMeisaiZenEntity();
        meisaiGoEntity = new KyufukanrihyoInMeisaiGoEntity();
        meisaiZenList = new ArrayList<>();
        meisaiGoList = new ArrayList<>();
        returnEntity = new KyufukanrihyoInCsvReadReturnEntity();
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKyufukanrihyoInMapper.class);
        一時表Mapper = getMapper(IKokuhorenKyoutsuuTempTableMapper.class);
        if (parameter.isFirst()) {
            一時TBL作成();
        }
        証記載保険者番号取得の判断基準の取得();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.get保存先パース());
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(区切り文字.toString());
        if (data != null && !data.isEmpty()) {
            if (レコード種別.equals(data.get(INDEX_0))) {
                controlCsvEntity = ListToObjectMappingHelper.
                        toObject(KokuhorenkyoutsuControlCsvEntity.class, data);
            } else if (帳票レコード種別_D1.equals(data.get(INDEX_3)) && 交換情報識別番号_前.equals(data.get(INDEX_2))) {
                meisaiZenEntity = ListToObjectMappingHelper.
                        toObject(KyufukanrihyoInMeisaiZenEntity.class, data);
                meisaiZenList.add(meisaiZenEntity);
            } else if (帳票レコード種別_D1.equals(data.get(INDEX_3)) && 交換情報識別番号_後.equals(data.get(INDEX_2))) {
                meisaiGoEntity = ListToObjectMappingHelper.
                        toObject(KyufukanrihyoInMeisaiGoEntity.class, data);
                meisaiGoList.add(meisaiGoEntity);
            }
        }
    }

    @Override
    protected void afterExecute() {
        entity.setControlCsvEntity(controlCsvEntity);
        entity.setListMeisaiZenEntity(meisaiZenList);
        entity.setListMeisaiGoEntity(meisaiGoList);

        int 連番 = 0;
        KokuhorenkyoutsuControlCsvEntity controlEntity = entity.getControlCsvEntity();
        if (null == returnEntity.get処理対象年月()) {
            FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(controlEntity.getShoriYM());
            returnEntity.set処理対象年月(処理対象年月);
        }
        RString 保険者番号 = controlEntity.getHokenshaNo();
        HokenshaNyuryokuHojoFinder 保険者Finder = HokenshaNyuryokuHojoFinder.createInstance();
        Hokensha 保険者 = 保険者Finder.getHokensha(new HokenjaNo(保険者番号));
        RString 保険者名 = null == 保険者 ? RString.EMPTY : 保険者.get保険者名();
        List<KyufukanrihyoInMeisaiZenEntity> zenList = entity.getListMeisaiZenEntity();
        List<KyufukanrihyoInMeisaiGoEntity> goList = entity.getListMeisaiGoEntity();
        if (null != zenList && !zenList.isEmpty()) {
            for (KyufukanrihyoInMeisaiZenEntity zenEntity : zenList) {
                連番 = 連番 + 1;
                前データを一時TBLに登録する(zenEntity, 連番, parameter.get処理年月(), 保険者番号, 保険者名);
            }
        }
        if (null != goList && !goList.isEmpty()) {
            for (KyufukanrihyoInMeisaiGoEntity goEntity : goList) {
                連番 = 連番 + 1;
                後データを一時TBLに登録する(goEntity, 連番, parameter.get処理年月(), 保険者番号, 保険者名);
            }
        }

        if (連番 == INDEX_0) {
            DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
            errorTempentity.setエラー区分(NUM);
            一時表Mapper.処理結果リスト一時TBLに登録(errorTempentity);
        }
        int レコード件数合算 = 連番 + Integer.valueOf(controlEntity.getCodeNum().toString());
        returnEntity.setレコード件数合算(レコード件数合算);

    }

    private void 一時TBL作成() {
        mapper.create給付管理票一時TBL();
        一時表Mapper.create被保険者一時TBL();
        一時表Mapper.create処理結果リスト一時TBL();
    }

    private void 証記載保険者番号取得の判断基準の取得() {
        ShichosonSecurityJohoFinder 市町村finder = ShichosonSecurityJohoFinder.createInstance();
        ShichosonSecurityJoho joho = 市町村finder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (null == joho) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(市町村セキュリティ情報の取得実行不可.toString()).toString());
        }
        returnEntity.set市町村セキュリティ情報(joho);
        GappeiCityJohoBFinder 変換基準日finder = GappeiCityJohoBFinder.createInstance();
        FlexibleDate 変換基準日 = 変換基準日finder.getHihokenshaBangoHenkanKijunbi(GyomuBunrui.介護事務,
                joho.get導入形態コード());
        if (null == 変換基準日) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(被保険者番号変換基準日の取得実行不可.toString()).toString());
        }
        returnEntity.set変換基準日(変換基準日);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);
    }

    private void 前データを一時TBLに登録する(KyufukanrihyoInMeisaiZenEntity zenEntity, int 連番,
            FlexibleYearMonth 処理年月, RString 保険者番号, RString 保険者名) {
        DbWT1121KyufuKanrihyoTempEntity 登録Entity = new DbWT1121KyufuKanrihyoTempEntity();
        登録Entity.set連番(連番);
        登録Entity.set交換情報識別番号(zenEntity.get交換情報識別番号());
        登録Entity.set審査年月(get年月(zenEntity.get審査年月()));
        登録Entity.setサービス提供年月(get年月(zenEntity.get対象年月()));
        登録Entity.set給付管理票種別区分コード(zenEntity.get給付管理票種別区分コード());
        登録Entity.set給付管理票明細行番号(zenEntity.get給付管理票明細行番号());
        登録Entity.set居宅支援事業所番号(zenEntity.get事業所番号_居宅介護支援事業所());
        登録Entity.set給付管理票情報作成区分コード(zenEntity.get給付管理票情報作成区分コード());
        登録Entity.set給付管理票作成年月日(get年月日(zenEntity.get給付管理票作成年月日()));
        登録Entity.set保険者番号(zenEntity.get保険者番号());
        登録Entity.set被保険者生年月日(get年月日(zenEntity.get被保険者生年月日()));
        登録Entity.set性別コード(zenEntity.get被保険者性別コード());
        登録Entity.set要介護状態区分コード(zenEntity.get要介護状態区分コード());
        登録Entity.set限度額適用開始年月(get年月(zenEntity.get限度額適用期間_開始()));
        登録Entity.set限度額適用終了年月(get年月(zenEntity.get限度額適用期間_終了()));
        登録Entity.set居宅_介護予防支給限度額(getDecimal(zenEntity.get訪問通所_短期入所支給限度額()));
        登録Entity.set居宅サービス計画作成区分コード(zenEntity.get居宅サービス計画作成区分コード());
        登録Entity.setサービス事業所番号(getNotNullRString(zenEntity.get事業所番号_サービス事業所()));
        登録Entity.set指定_基準該当_地域密着型サービス識別コード(getNotNullRString(zenEntity.get指定等事業所区分コード()));
        登録Entity.setサービス種類コード(getNotNullRString(zenEntity.getサービス種別コード()));
        登録Entity.set給付計画単位数_日数(getDecimal(zenEntity.get給付計画単位数_日数()));
        登録Entity.set限度額管理期間における前月までの給付計画日数(getDecimal(zenEntity.get限度額管理期間における前月までの給付計画日数()));
        登録Entity.set指定サービス分小計(getDecimal(zenEntity.get指定サービス分小計()));
        登録Entity.set基準該当サービス分小計(getDecimal(zenEntity.get基準該当サービス分小計()));
        登録Entity.set給付計画合計単位数_日数(getDecimal(zenEntity.get給付計画合計単位数_日数()));
        登録Entity.set担当介護支援専門員番号(RString.EMPTY);
        登録Entity.set委託先の居宅介護支援事業所番号(RString.EMPTY);
        登録Entity.set委託先の担当介護支援専門員番号(RString.EMPTY);
        登録Entity.set当初登録年月日(null);
        登録Entity.set取込年月(処理年月);
        登録Entity.setコントロールレコード保険者番号(保険者番号);
        登録Entity.setコントロールレコード保険者名(保険者名);
        登録Entity.set事業者名称(RString.EMPTY);
        mapper.給付管理票一時TBLに登録(登録Entity);

        DbWT0001HihokenshaTempEntity 被保険者 = new DbWT0001HihokenshaTempEntity();
        被保険者.set連番(連番);
        HihokenshaNo 被保険者番号 = new HihokenshaNo(zenEntity.get被保険者番号());
        被保険者.set被保険者番号(被保険者番号);
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(zenEntity.get対象年月());
        int day = サービス提供年月.getLastDay();
        RString date = サービス提供年月.toDateString().concat(new RString(day));
        被保険者.setサービス提供年月末日(new FlexibleDate(date));
        被保険者.set登録被保険者番号(被保険者番号);
        一時表Mapper.被保険者一時TBLに登録(被保険者);
    }

    private void 後データを一時TBLに登録する(KyufukanrihyoInMeisaiGoEntity goEntity, int 連番,
            FlexibleYearMonth 処理年月, RString 保険者番号, RString 保険者名) {
        DbWT1121KyufuKanrihyoTempEntity 登録Entity = new DbWT1121KyufuKanrihyoTempEntity();
        登録Entity.set連番(連番);
        登録Entity.set交換情報識別番号(goEntity.get交換情報識別番号());
        登録Entity.set審査年月(get年月(goEntity.get審査年月()));
        登録Entity.setサービス提供年月(get年月(goEntity.get対象年月()));
        登録Entity.set給付管理票種別区分コード(goEntity.get給付管理票種別区分コード());
        登録Entity.set給付管理票明細行番号(goEntity.get給付管理票明細行番号());
        登録Entity.set居宅支援事業所番号(goEntity.get事業所番号());
        登録Entity.set給付管理票情報作成区分コード(goEntity.get給付管理票情報作成区分コード());
        登録Entity.set給付管理票作成年月日(get年月日(goEntity.get給付管理票作成年月日()));
        登録Entity.set保険者番号(goEntity.get保険者番号());
        登録Entity.set被保険者生年月日(get年月日(goEntity.get被保険者生年月日()));
        登録Entity.set性別コード(goEntity.get被保険者性別コード());
        登録Entity.set要介護状態区分コード(goEntity.get要介護状態区分コード());
        登録Entity.set限度額適用開始年月(get年月(goEntity.get限度額適用期間_開始()));
        登録Entity.set限度額適用終了年月(get年月(goEntity.get限度額適用期間_終了()));
        登録Entity.set居宅_介護予防支給限度額(getDecimal(goEntity.get居宅_介護予防_総合事業支給限度額()));
        登録Entity.set居宅サービス計画作成区分コード(goEntity.get居宅サービス計画作成区分コード());
        登録Entity.setサービス事業所番号(getNotNullRString(goEntity.get事業所番号_サービス事業所()));
        登録Entity.set指定_基準該当_地域密着型サービス識別コード(getNotNullRString(goEntity.get指定等事業識別コード()));
        登録Entity.setサービス種類コード(getNotNullRString(goEntity.getサービス種別コード()));
        登録Entity.set給付計画単位数_日数(getDecimal(goEntity.get給付計画単位数_日数()));
        登録Entity.set限度額管理期間における前月までの給付計画日数(getDecimal(goEntity.get限度額管理期間における前月までの給付計画日数()));
        登録Entity.set指定サービス分小計(getDecimal(goEntity.get指定サービス分小計()));
        登録Entity.set基準該当サービス分小計(getDecimal(goEntity.get基準該当サービス分小計()));
        登録Entity.set給付計画合計単位数_日数(getDecimal(goEntity.get給付計画合計単位数_日数()));
        登録Entity.set担当介護支援専門員番号(getNotNullRString(goEntity.get担当介護支援専門員番号()));
        登録Entity.set委託先の居宅介護支援事業所番号(getNotNullRString(goEntity.get委託先の居宅介護支援事業所番号()));
        登録Entity.set委託先の担当介護支援専門員番号(getNotNullRString(goEntity.get委託先の担当介護支援専門員番号()));
        登録Entity.set当初登録年月日(null);
        登録Entity.set取込年月(処理年月);
        登録Entity.setコントロールレコード保険者番号(保険者番号);
        登録Entity.setコントロールレコード保険者名(保険者名);
        登録Entity.set事業者名称(RString.EMPTY);
        mapper.給付管理票一時TBLに登録(登録Entity);

        DbWT0001HihokenshaTempEntity 被保険者 = new DbWT0001HihokenshaTempEntity();
        被保険者.set連番(連番);
        HihokenshaNo 被保険者番号 = new HihokenshaNo(goEntity.get被保険者番号());
        被保険者.set被保険者番号(被保険者番号);
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(goEntity.get対象年月());
        int day = サービス提供年月.getLastDay();
        RString date = サービス提供年月.toDateString().concat(new RString(day));
        被保険者.setサービス提供年月末日(new FlexibleDate(date));
        被保険者.set登録被保険者番号(被保険者番号);
        一時表Mapper.被保険者一時TBLに登録(被保険者);
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
