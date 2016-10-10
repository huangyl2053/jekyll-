/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KyufuJissekiRecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekiyoshikikubun.KyufuJissekiYoshikiKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukyufuketteiin.KogakuKyufuKetteiReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenkyotsu.KokuhorenkyoutsuControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvRecordKensuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.ShinseiJouhouCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.ShinseiSentouCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050.ShinseiSentouDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT1111KyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
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
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績情報取込
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public class KyufuJissekiInReadCsvProcess extends BatchProcessBase<List<RString>> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KogakuKyufuKetteiReadCsvFileProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private OutputParameter<FlowEntity> flowEntity;
    FlowEntity returnEntity;

    private final RString レコード種別 = new RString("1");
    private final RString エンドレコード種別 = new RString("3");
    private final RString 交換情報識別番号_1111 = new RString("1111");

    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_2 = 2;
    private static final Integer INDEX_4 = 4;
    private static final RString エラー区分_登録対象なし = new RString("99");
    int 連番;

    private KokuhorenkyoutsuControlCsvEntity controlCsvEntity;
    private ShinseiSentouDataEntity dataEntity;
    private ShinseiSentouCsvEntity sentouCsvEntity;
    private ShinseiJouhouCsvEntity jouhouCsvEntity;
    private List<ShinseiJouhouCsvEntity> listCsvShinseiJouhouCsvEntity;
    private KyufuJissekiKoshinJohoCsvRecordKensuEntity recordKensu;

    @BatchWriter
    private IBatchTableWriter 被保険者一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    private IBatchTableWriter 給付実績一時tableWriter;

    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 給付実績一時_TABLE_NAME = new RString("DbWT1111KyufuJisseki");

    private int 件数_H1;
    private int 件数_D1;
    private int 件数_DD;
    private int 件数_D2;
    private int 件数_DC;
    private int 件数_D3;
    private int 件数_D4;
    private int 件数_D5;
    private int 件数_D6;
    private int 件数_D7;
    private int 件数_D8;
    private int 件数_DE;
    private int 件数_T1;
    private int 件数_D9;
    private int 件数_DA;
    private int 件数_DB;
    private static final RString 読点 = new RString("、");
    private boolean 組み合わせ不正フラグ = false;
    private RString 組み合わせ不正の備考 = RString.EMPTY;
    private boolean 必須レコードなしフラグ = false;
    private RString 必須レコードなしの備考 = RString.EMPTY;
    private boolean 複数レコード不可フラグ = false;
    private RString 複数レコード不可の備考 = RString.EMPTY;
    private static final RString エラー区分_キー項目不一致 = new RString("01");
    private static final RString エラー区分_レコード構成不正 = new RString("02");
    private static final RString エラー区分_必須レコードなし = new RString("03");
    private static final RString エラー区分_複数レコード不可 = new RString("04");

    @Override
    protected void initialize() {
        controlCsvEntity = new KokuhorenkyoutsuControlCsvEntity();
        listCsvShinseiJouhouCsvEntity = new ArrayList<>();
        returnEntity = new FlowEntity();
        flowEntity = new OutputParameter<>();
        連番 = INDEX_0;
        件数_H1 = INDEX_0;
        件数_D1 = INDEX_0;
        件数_DD = INDEX_0;
        件数_D2 = INDEX_0;
        件数_DC = INDEX_0;
        件数_D3 = INDEX_0;
        件数_D4 = INDEX_0;
        件数_D5 = INDEX_0;
        件数_D6 = INDEX_0;
        件数_D7 = INDEX_0;
        件数_D8 = INDEX_0;
        件数_DE = INDEX_0;
        件数_T1 = INDEX_0;
        件数_D9 = INDEX_0;
        件数_DA = INDEX_0;
        件数_DB = INDEX_0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchCsvListReader(new CsvListReader.InstanceBuilder(parameter.get保存先フォルダ())
                .setDelimiter(カンマ).setEncode(Encode.SJIS).hasHeader(false).setNewLine(NewLine.CRLF).build());
    }

    @Override
    protected void createWriter() {
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaIchijiEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
        給付実績一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績一時_TABLE_NAME, DbWT1111KyufuJissekiEntity.class);
    }

    @Override
    protected void process(List<RString> data) {
        if (エンドレコード種別.equals(data.get(INDEX_0))) {
            return;
        }
        if (レコード種別.equals(data.get(INDEX_0))) {
            controlCsvEntity = ListToObjectMappingHelper.
                    toObject(KokuhorenkyoutsuControlCsvEntity.class, data);
            returnEntity.setShoriYM(new FlexibleYearMonth(controlCsvEntity.getShoriYM()));
        } else {
            if ((KyufuJissekiRecordShubetsu.基本情報レコード.getコード().equals(data.get(INDEX_4))
                    && 交換情報識別番号_1111.compareTo(data.get(INDEX_2)) <= INDEX_0)
                    || KyufuJissekiRecordShubetsu.介護給付費_高額介護サービス費情報レコード.getコード().equals(data.get(INDEX_4))
                    || KyufuJissekiRecordShubetsu.総合事業費_高額介護サービス費情報レコード.getコード().equals(data.get(INDEX_4))) {
                settei();
                sentouCsvEntity = ListToObjectMappingHelper.
                        toObject(ShinseiSentouCsvEntity.class, data);
            } else {
                jouhouCsvEntity = ListToObjectMappingHelper.
                        toObject(ShinseiJouhouCsvEntity.class, data);
                listCsvShinseiJouhouCsvEntity.add(jouhouCsvEntity);
            }
        }
    }

    @Override
    protected void afterExecute() {
        settei();
        if (連番 == INDEX_0) {
            DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
            errorTempentity.setエラー区分(エラー区分_登録対象なし);
            処理結果リスト一時tableWriter.insert(errorTempentity.toEntity());
        }
        returnEntity.set明細データ登録件数(連番);
        returnEntity.setCodeNum(Integer.valueOf(controlCsvEntity.getCodeNum().toString()));
        flowEntity.setValue(returnEntity);
    }

    private void insert給付実績一時TBL(int 連番,
            KyufuJissekiKoshinJohoCsvRecordKensuEntity recordKensu,
            KokuhorenkyoutsuControlCsvEntity controlCsvEntity,
            ShinseiSentouCsvEntity sentouCsvEntity,
            IBatchTableWriter 給付実績一時tableWriter) {
        DbWT1111KyufuJissekiEntity temp = new DbWT1111KyufuJissekiEntity();
        temp.setRenban(連番);
        temp.setKokanJohoShikibetsuNo(sentouCsvEntity.get交換情報識別番号());
        temp.setNyuryokuShikibetsuNo(new NyuryokuShikibetsuNo(sentouCsvEntity.get入力識別番号()));
        temp.setRecordShubetsuCode(sentouCsvEntity.getレコード種別コード());
        temp.setKyufuJissekiSakuseiKubunCode(sentouCsvEntity.get給付実績情報作成区分コード());
        temp.setServiceTeikyoYM(new FlexibleYearMonth(sentouCsvEntity.getサービス提供年月()));
        temp.setKyufuJissekiKubun(sentouCsvEntity.get給付実績区分コード());
        temp.setJigyoshoNo(new JigyoshaNo(sentouCsvEntity.get事業所番号()));
        temp.setSeiriNo(sentouCsvEntity.get整理番号());
        temp.setRecordKensuH1(recordKensu.get件数_H1());
        temp.setRecordKensuD1(recordKensu.get件数_D1());
        temp.setRecordKensuDD(recordKensu.get件数_DD());
        temp.setRecordKensuD2(recordKensu.get件数_D2());
        temp.setRecordKensuDC(recordKensu.get件数_DC());
        temp.setRecordKensuD3(recordKensu.get件数_D3());
        temp.setRecordKensuD4(recordKensu.get件数_D4());
        temp.setRecordKensuD5(recordKensu.get件数_D5());
        temp.setRecordKensuD6(recordKensu.get件数_D6());
        temp.setRecordKensuD7(recordKensu.get件数_D7());
        temp.setRecordKensuD8(recordKensu.get件数_D8());
        temp.setRecordKensuDE(recordKensu.get件数_DE());
        temp.setRecordKensuT1(recordKensu.get件数_T1());
        temp.setRecordKensuD9(recordKensu.get件数_D9());
        temp.setRecordKensuDA(recordKensu.get件数_DA());
        temp.setRecordKensuDB(recordKensu.get件数_DB());
        temp.setKeikokuKubunCode(sentouCsvEntity.get警告区分コード());
        temp.setHokenshaNo(new HokenshaNo(controlCsvEntity.getHokenshaNo()));
        HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
        Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(controlCsvEntity.getHokenshaNo()));
        if (hokensha != null) {
            temp.setHokenshaName(hokensha.get保険者名());
        } else {
            temp.setHokenshaName(RString.EMPTY);
        }
        temp.setJigyoshaName(RString.EMPTY);
        temp.setNyuryokuShikibetsuMeisho(RString.EMPTY);
        temp.setState(EntityDataState.Added);
        給付実績一時tableWriter.insert(temp);
    }

    private void insert被保険者一時TBL(int 連番, ShinseiSentouCsvEntity sentouCsvEntity, IBatchTableWriter 被保険者一時tableWriter) {
        DbWT0001HihokenshaIchijiEntity hihokensha = new DbWT0001HihokenshaIchijiEntity();
        if (null != sentouCsvEntity) {
            hihokensha.setMeisaiRenban(連番);
            if (!RString.isNullOrEmpty(sentouCsvEntity.get証記載保険者番号())) {
                hihokensha.setShoHokenshaNo(new ShoKisaiHokenshaNo(sentouCsvEntity.get証記載保険者番号()));
            }
            if (!RString.isNullOrEmpty(sentouCsvEntity.get被保険者番号())) {
                hihokensha.setOrgHihokenshaNo(new HihokenshaNo(sentouCsvEntity.get被保険者番号()));
            }
            if (null != sentouCsvEntity.getサービス提供年月()) {
                int lastDay = new FlexibleYearMonth(sentouCsvEntity.getサービス提供年月()).getLastDay();
                hihokensha.setServiceTeikyoYmd(new FlexibleDate(new FlexibleYearMonth(sentouCsvEntity.getサービス提供年月()).toDateString()
                        .concat(new RString(lastDay))));
            }
            hihokensha.setOrgHihokenshaKanaShimei(RString.EMPTY);
            hihokensha.setOrgHihokenshaShimei(RString.EMPTY);
            hihokensha.setOldShichosonCode(LasdecCode.EMPTY);
            hihokensha.setHenkanHihokenshaNo(null);
            if (!RString.isNullOrEmpty(sentouCsvEntity.get被保険者番号())) {
                hihokensha.setHihokenshaNo(new HihokenshaNo(sentouCsvEntity.get被保険者番号()));
            }
            hihokensha.setShichosonCode(LasdecCode.EMPTY);
            hihokensha.setKannaiKangaiKubun(RString.EMPTY);
            hihokensha.setYubinNo(RString.EMPTY);
            hihokensha.setChoikiCode(RString.EMPTY);
            hihokensha.setGyoseikuCode(RString.EMPTY);
            hihokensha.setGyoseikuMei(RString.EMPTY);
            hihokensha.setJusho(RString.EMPTY);
            hihokensha.setBanchi(RString.EMPTY);
            hihokensha.setKatagaki(RString.EMPTY);
            hihokensha.setKanaMeisho(RString.EMPTY);
            hihokensha.setMeisho(RString.EMPTY);
            hihokensha.setShimei50onKana(RString.EMPTY);
            hihokensha.setShikibetsuCode(ShikibetsuCode.EMPTY);
            hihokensha.setShikakuShutokuYmd(FlexibleDate.EMPTY);
            hihokensha.setShikakuShutokuJiyuCode(RString.EMPTY);
            hihokensha.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
            hihokensha.setShikakuSoshitsuJiyuCode(RString.EMPTY);
            hihokensha.setSetaiShuyakuNo(HihokenshaNo.EMPTY);
            hihokensha.setState(EntityDataState.Added);
            被保険者一時tableWriter.insert(hihokensha);
        }
    }

    private void settei() {
        if (null != sentouCsvEntity) {
            dataEntity = addMeisai(sentouCsvEntity, listCsvShinseiJouhouCsvEntity, 処理結果リスト一時tableWriter);
            if (null != dataEntity) {
                recordKensu = dataEntity.getRecordNumber();
                連番 = 連番 + 1;
                insert給付実績一時TBL(連番, recordKensu, controlCsvEntity, sentouCsvEntity, 給付実績一時tableWriter);
                insert被保険者一時TBL(連番, sentouCsvEntity, 被保険者一時tableWriter);
            }
            sentouCsvEntity = null;
            listCsvShinseiJouhouCsvEntity = new ArrayList<>();
        }
    }

    /**
     * 明細設定する
     *
     * @param sentouCsvEntity ShinseiSentouCsvEntity
     * @param listCsvShinseiJouhouCsvEntity List<ShinseiJouhouCsvEntity>
     * @param tableWriter IBatchTableWriter
     * @return dataEntity ShinseiSentouDataEntity
     *
     */
    private ShinseiSentouDataEntity addMeisai(
            ShinseiSentouCsvEntity sentouCsvEntity,
            List<ShinseiJouhouCsvEntity> listCsvShinseiJouhouCsvEntity,
            IBatchTableWriter tableWriter) {
        dataEntity = new ShinseiSentouDataEntity();
        recordKensu = new KyufuJissekiKoshinJohoCsvRecordKensuEntity();
        組み合わせ不正フラグ = false;
        必須レコードなしフラグ = false;
        複数レコード不可フラグ = false;
        組み合わせ不正の備考 = RString.EMPTY;
        必須レコードなしの備考 = RString.EMPTY;
        複数レコード不可の備考 = RString.EMPTY;
        RString 申請先頭レコードのキー項目値;
        RString 入力識別番号;
        DbWT0002KokuhorenTorikomiErrorEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorEntity();
        if (KyufuJissekiRecordShubetsu.基本情報レコード.getコード().equals(sentouCsvEntity.getレコード種別コード())) {
            件数_H1 = 件数_H1 + 1;
        } else if (KyufuJissekiRecordShubetsu.介護給付費_高額介護サービス費情報レコード.getコード().equals(sentouCsvEntity.getレコード種別コード())) {
            件数_D8 = 件数_D8 + 1;
        } else if (KyufuJissekiRecordShubetsu.総合事業費_高額介護サービス費情報レコード.getコード().equals(sentouCsvEntity.getレコード種別コード())) {
            件数_DE = 件数_DE + 1;
        }
        入力識別番号 = sentouCsvEntity.get入力識別番号();
        申請先頭レコードのキー項目値 = sentouCsvEntity.get交換情報識別番号().concat(入力識別番号)
                .concat(sentouCsvEntity.get被保険者番号()).concat(new FlexibleYearMonth(sentouCsvEntity.getサービス提供年月()).toDateString())
                .concat(sentouCsvEntity.get事業所番号()).concat(sentouCsvEntity.get整理番号());
        doキー項目値チェック(申請先頭レコードのキー項目値, listCsvShinseiJouhouCsvEntity, tableWriter);
        if (do件数チェック(入力識別番号)) {
            setレコード件数();
            dataEntity.setRecordNumber(recordKensu);
            dataEntity.setSentouCsvEntity(sentouCsvEntity);
            return dataEntity;
        } else {
            errorTempentity.setShoHokanehshaNo(new ShoKisaiHokenshaNo(sentouCsvEntity.get証記載保険者番号()));
            errorTempentity.setHihokenshaNo(new HihokenshaNo(sentouCsvEntity.get被保険者番号()));
            errorTempentity.setKey1(sentouCsvEntity.get交換情報識別番号());
            errorTempentity.setKey2(sentouCsvEntity.get入力識別番号());
            errorTempentity.setKey3(new FlexibleYearMonth(sentouCsvEntity.getサービス提供年月()).toDateString());
            errorTempentity.setKey4(sentouCsvEntity.get事業所番号());
            errorTempentity.setKey5(sentouCsvEntity.get整理番号());
            組み合わせ不正登録(errorTempentity, tableWriter);
            必須レコードなし登録(errorTempentity, tableWriter);
            複数レコード不可登録(errorTempentity, tableWriter);
        }
        return null;
    }

    private void 組み合わせ不正登録(DbWT0002KokuhorenTorikomiErrorEntity errorTempentity, IBatchTableWriter tableWriter) {
        if (組み合わせ不正フラグ) {
            errorTempentity.setErrorKubun(エラー区分_レコード構成不正);
            errorTempentity.setBiko(組み合わせ不正の備考.substring(1));
            errorTempentity.setState(EntityDataState.Added);
            tableWriter.insert(errorTempentity);
        }
    }

    private void 必須レコードなし登録(DbWT0002KokuhorenTorikomiErrorEntity errorTempentity, IBatchTableWriter tableWriter) {
        if (必須レコードなしフラグ) {
            errorTempentity.setErrorKubun(エラー区分_必須レコードなし);
            errorTempentity.setBiko(必須レコードなしの備考.substring(1));
            errorTempentity.setState(EntityDataState.Added);
            tableWriter.insert(errorTempentity);
        }
    }

    private void 複数レコード不可登録(DbWT0002KokuhorenTorikomiErrorEntity errorTempentity, IBatchTableWriter tableWriter) {
        if (複数レコード不可フラグ) {
            errorTempentity.setErrorKubun(エラー区分_複数レコード不可);
            errorTempentity.setBiko(複数レコード不可の備考.substring(1));
            errorTempentity.setState(EntityDataState.Added);
            tableWriter.insert(errorTempentity);
        }
    }

    private void doキー項目値チェック(RString 申請先頭レコードのキー項目値,
            List<ShinseiJouhouCsvEntity> listCsvShinseiJouhouCsvEntity,
            IBatchTableWriter tableWriter) {
        if (null != listCsvShinseiJouhouCsvEntity && !listCsvShinseiJouhouCsvEntity.isEmpty()) {
            for (int index = 0; index < listCsvShinseiJouhouCsvEntity.size(); index++) {
                jouhouCsvEntity = listCsvShinseiJouhouCsvEntity.get(index);
                RString 申請先頭以外レコードのキー項目値 = jouhouCsvEntity.get交換情報識別番号().concat(jouhouCsvEntity.get入力識別番号())
                        .concat(jouhouCsvEntity.get被保険者番号()).concat(jouhouCsvEntity.getサービス提供年月())
                        .concat(jouhouCsvEntity.get事業所番号()).concat(jouhouCsvEntity.get整理番号());
                if (!申請先頭以外レコードのキー項目値.equals(申請先頭レコードのキー項目値)) {
                    DbWT0002KokuhorenTorikomiErrorEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorEntity();
                    errorTempentity.setShoHokanehshaNo(new ShoKisaiHokenshaNo(jouhouCsvEntity.get証記載保険者番号()));
                    errorTempentity.setHihokenshaNo(new HihokenshaNo(jouhouCsvEntity.get被保険者番号()));
                    errorTempentity.setKey1(jouhouCsvEntity.get交換情報識別番号());
                    errorTempentity.setKey2(jouhouCsvEntity.get入力識別番号());
                    errorTempentity.setKey3(jouhouCsvEntity.getサービス提供年月());
                    errorTempentity.setKey4(jouhouCsvEntity.get事業所番号());
                    errorTempentity.setKey5(jouhouCsvEntity.get整理番号());
                    errorTempentity.setErrorKubun(エラー区分_キー項目不一致);
                    errorTempentity.setState(EntityDataState.Added);
                    tableWriter.insert(errorTempentity);
                    listCsvShinseiJouhouCsvEntity.remove(index);
                    index--;
                } else {
                    calcRecordNumber(jouhouCsvEntity);
                }
            }
        }
    }

    private void calcRecordNumber(ShinseiJouhouCsvEntity jouhouCsvEntity) {

        if (KyufuJissekiRecordShubetsu.明細情報レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_D1 = 件数_D1 + 1;
        } else if (KyufuJissekiRecordShubetsu.明細情報_住所地特例レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_DD = 件数_DD + 1;
        } else if (KyufuJissekiRecordShubetsu.緊急時施設療養情報レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_D2 = 件数_D2 + 1;
        } else if (KyufuJissekiRecordShubetsu.所定疾患施設療養費等情報レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_DC = 件数_DC + 1;
        } else if (KyufuJissekiRecordShubetsu.特定診療費_特別療養費情報レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_D3 = 件数_D3 + 1;
        } else if (KyufuJissekiRecordShubetsu.食事費用情報レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_D4 = 件数_D4 + 1;
        } else if (KyufuJissekiRecordShubetsu.居宅サービス計画費情報レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_D5 = 件数_D5 + 1;
        } else if (KyufuJissekiRecordShubetsu.福祉用具販売費情報レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_D6 = 件数_D6 + 1;
        } else if (KyufuJissekiRecordShubetsu.住宅改修費情報レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_D7 = 件数_D7 + 1;
        } else if (KyufuJissekiRecordShubetsu.集計情報レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_T1 = 件数_T1 + 1;
        } else if (KyufuJissekiRecordShubetsu.特定入所者介護サービス費用情報レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_D9 = 件数_D9 + 1;
        } else if (KyufuJissekiRecordShubetsu.社会福祉法人軽減額情報レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_DA = 件数_DA + 1;
        } else if (KyufuJissekiRecordShubetsu.ケアマネジメント費情報レコード.getコード().equals(jouhouCsvEntity.getレコード種別コード())) {
            件数_DB = 件数_DB + 1;
        }
    }

    private boolean do件数チェック(RString 入力識別番号) {
        do件数チェック1(入力識別番号);
        do件数チェック2(入力識別番号);
        do件数チェック3(入力識別番号);
        do件数チェック4(入力識別番号);
        do件数チェック5(入力識別番号);
        do件数チェック6(入力識別番号);
        do件数チェック7(入力識別番号);
        do件数チェック8(入力識別番号);
        do件数チェック9(入力識別番号);
        do件数チェック10(入力識別番号);
        do件数チェック11(入力識別番号);
        do件数チェック12(入力識別番号);
        do件数チェック13(入力識別番号);
        do件数チェック14(入力識別番号);
        do件数チェック15(入力識別番号);
        do件数チェック16(入力識別番号);
        do件数チェック17(入力識別番号);
        do件数チェック18(入力識別番号);
        do件数チェック19(入力識別番号);
        do件数チェック20(入力識別番号);
        do件数チェック21(入力識別番号);
        return !組み合わせ不正フラグ && !必須レコードなしフラグ && !複数レコード不可フラグ;
    }

    private void do件数チェック1(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2131_様式第二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7131_様式第二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2132_様式第二の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7132_様式第二の二.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1とDD件数チェック(入力識別番号);
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック2(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2141_様式第三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7141_様式第三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2142_様式第三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7142_様式第三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2171_様式第六.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7171_様式第六.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2172_様式第六の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7172_様式第六の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2173_様式第六の三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7173_様式第六の三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2174_様式第六の四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7174_様式第六の四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2175_様式第六の五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7175_様式第六の五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2176_様式第六の六.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7176_様式第六の六.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2177_様式第六の七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7177_様式第六の七.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック3(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2143_様式第三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7143_様式第三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2144_様式第三の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7144_様式第三の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2183_様式第八.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7183_様式第八.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック4(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2151_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7151_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2152_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7152_様式第四.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック5(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2153_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7153_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2154_様式第四の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7154_様式第四の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2193_様式第九.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7193_様式第九.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック6(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2155_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7155_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2156_様式第四の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7156_様式第四の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2194_様式第九.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7194_様式第九.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック7(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2161_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7161_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2162_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7162_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2163_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7163_様式第五.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック8(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2164_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7164_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2165_様式第五の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7165_様式第五の二.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック9(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2181_様式第八.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7181_様式第八.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2182_様式第八.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7182_様式第八.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が2件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック10(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2191_様式第九.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7191_様式第九.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2192_様式第九.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7192_様式第九.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が2件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック11(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2195_様式第九.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7195_様式第九.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック12(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._21A1_様式第十.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._71A1_様式第十.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._21A2_様式第十.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._71A2_様式第十.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD4件数が2件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック13(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._21A3_様式第十.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._71A3_様式第十.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック14(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._21B1_様式第七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8121_様式第七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._21B2_様式第七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8122_様式第七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._21B3_様式第七の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8123_様式第七の二.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が1件以上チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が0件チェック();
            doD5件数が2件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が1件以上チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック15(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._21B4_様式第七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8124_様式第七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._21B5_様式第七の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8125_様式第七の二.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が1件以上チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が0件チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が1件以上チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック16(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._21C1_福祉用具販売費.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._21C2_予防用具販売費.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が1件以上チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が0件チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック17(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._21D1_住宅改修費.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._21D2_予防住宅改修費.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が1件以上チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が0件チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック18(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._3411_高額介護給付費.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._3421_高額介護総合事業.getコード().equals(入力識別番号)) {
            doH1件数が1件以上チェック();
            doD1件数が1件以上チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が1件以上チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック19(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._8161_ケアマネジメント.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が1件以上チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が1件以上チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が0件チェック();
        }
    }

    private void do件数チェック20(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._71R1_様式第二の三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8171_様式第七の三.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1とDD件数チェック(入力識別番号);
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック21(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._71P1_予防サービス_生活支援サービス.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void doH1件数が1件以上チェック() {
        if (件数_H1 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.基本情報レコード.getコード());
        }
    }

    private void doH1件数が0件チェック() {
        if (件数_H1 == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.基本情報レコード.getコード());
        }
    }

    private void doD1とDD件数チェック(RString 入力識別番号) {
        if ((KyufuJissekiYoshikiKubun._71R1_様式第二の三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8171_様式第七の三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2131_様式第二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7131_様式第二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2132_様式第二の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7132_様式第二の二.getコード().equals(入力識別番号)) && (件数_D1 == 0 && 件数_DD == 0)) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.明細情報レコード.getコード())
                    .concat(読点).concat(KyufuJissekiRecordShubetsu.明細情報_住所地特例レコード.getコード());
        }
    }

    private void doD1件数が1件以上チェック() {
        if (件数_D1 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.明細情報レコード.getコード());
        }
    }

    private void doD1件数が0件チェック() {
        if (件数_D1 == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.明細情報レコード.getコード());
        }
    }

    private void doDD件数が1件以上チェック() {
        if (件数_DD >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.明細情報_住所地特例レコード.getコード());
        }
    }

    private void doD2件数が1件以上チェック() {
        if (件数_D2 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.緊急時施設療養情報レコード.getコード());
        }
    }

    private void doDC件数が1件以上チェック() {
        if (件数_DC >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.所定疾患施設療養費等情報レコード.getコード());
        }
    }

    private void doD3件数が1件以上チェック() {
        if (件数_D3 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.特定診療費_特別療養費情報レコード.getコード());
        }
    }

    private void doD4件数が1件以上チェック() {
        if (件数_D4 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.食事費用情報レコード.getコード());
        }
    }

    private void doD4件数が2件以上チェック() {
        if (件数_D4 >= 2) {
            複数レコード不可フラグ = true;
            複数レコード不可の備考 = 複数レコード不可の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.食事費用情報レコード.getコード());
        }

    }

    private void doD5件数が1件以上チェック() {
        if (件数_D5 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.居宅サービス計画費情報レコード.getコード());
        }
    }

    private void doD5件数が0件チェック() {
        if (件数_D5 == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.居宅サービス計画費情報レコード.getコード());
        }
    }

    private void doD5件数が2件以上チェック() {
        if (件数_D5 >= 2) {
            複数レコード不可フラグ = true;
            複数レコード不可の備考 = 複数レコード不可の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.居宅サービス計画費情報レコード.getコード());
        }
    }

    private void doD6件数が1件以上チェック() {
        if (件数_D6 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.福祉用具販売費情報レコード.getコード());
        }

    }

    private void doD6件数が0件チェック() {
        if (件数_D6 == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.福祉用具販売費情報レコード.getコード());
        }
    }

    private void doD7件数が1件以上チェック() {
        if (件数_D7 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.住宅改修費情報レコード.getコード());
        }

    }

    private void doD7件数が0件チェック() {
        if (件数_D7 == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.住宅改修費情報レコード.getコード());
        }
    }

    private void doD8とDE件数チェック(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._3411_高額介護給付費.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._3421_高額介護総合事業.getコード().equals(入力識別番号)) {
            if (件数_D8 == 0 && 件数_DE == 0) {
                必須レコードなしフラグ = true;
                必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                        .concat(KyufuJissekiRecordShubetsu.介護給付費_高額介護サービス費情報レコード.getコード()).concat(読点)
                        .concat(KyufuJissekiRecordShubetsu.総合事業費_高額介護サービス費情報レコード.getコード());
            }
        } else {
            if (件数_D8 >= 1) {
                組み合わせ不正フラグ = true;
                組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                        .concat(KyufuJissekiRecordShubetsu.介護給付費_高額介護サービス費情報レコード.getコード());
            }
            if (件数_DE >= 1) {
                組み合わせ不正フラグ = true;
                組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                        .concat(KyufuJissekiRecordShubetsu.総合事業費_高額介護サービス費情報レコード.getコード());
            }
        }

    }

    private void doT1件数が1件以上チェック() {
        if (件数_T1 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.集計情報レコード.getコード());
        }
    }

    private void doT1件数が0件チェック() {
        if (件数_T1 == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.集計情報レコード.getコード());
        }
    }

    private void doD9件数が1件以上チェック() {
        if (件数_D9 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.特定入所者介護サービス費用情報レコード.getコード());
        }
    }

    private void doDA件数が1件以上チェック() {
        if (件数_DA >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.社会福祉法人軽減額情報レコード.getコード());
        }

    }

    private void doDB件数が1件以上チェック() {
        if (件数_DB >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.ケアマネジメント費情報レコード.getコード());
        }
    }

    private void doDB件数が0件チェック() {
        if (件数_DB == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.ケアマネジメント費情報レコード.getコード());
        }
    }

    private void setレコード件数() {
        recordKensu.set件数_D1(件数_D1);
        recordKensu.set件数_D2(件数_D2);
        recordKensu.set件数_D3(件数_D3);
        recordKensu.set件数_D4(件数_D4);
        recordKensu.set件数_D5(件数_D5);
        recordKensu.set件数_D6(件数_D6);
        recordKensu.set件数_D7(件数_D7);
        recordKensu.set件数_D8(件数_D8);
        recordKensu.set件数_D9(件数_D9);
        recordKensu.set件数_DA(件数_DA);
        recordKensu.set件数_DB(件数_DB);
        recordKensu.set件数_DC(件数_DC);
        recordKensu.set件数_DD(件数_DD);
        recordKensu.set件数_DE(件数_DE);
        recordKensu.set件数_H1(件数_H1);
        recordKensu.set件数_T1(件数_T1);

    }

}
