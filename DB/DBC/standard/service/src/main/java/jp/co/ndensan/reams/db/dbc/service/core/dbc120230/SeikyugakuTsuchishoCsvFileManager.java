/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.dbc120230;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileHeadRecordEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileToreraRecode1Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileToreraRecode2Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileToreraRecode3Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc120230.ISeikyugakuTsuchishoCsvFileMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 請求額通知書情報取込共通処理（CSVファイル取込）のCSVファイル読取 。
 *
 * @reamsid_L DBC-2480-013 sunqingzhu
 */
public class SeikyugakuTsuchishoCsvFileManager {

    private final MapperProvider mapperProvider;
    private SeikyugakuTsuchishoCsvFileEntity entity;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private SeikyugakuTsuchishoCsvFileDataEntity csvFileDataEntity;
    private SeikyugakuTsuchishoCsvFileHeadRecordEntity headRecordEntity;
    private SeikyugakuTsuchishoCsvFileToreraRecode1Entity toreraRecord1Entity;
    private SeikyugakuTsuchishoCsvFileToreraRecode2Entity toreraRecord2Entity;
    private SeikyugakuTsuchishoCsvFileToreraRecode3Entity toreraRecord3Entity;
    private SeikyugakuTsuchishoCsvFileMeisaiEntity meisaiEntity;
    private List<SeikyugakuTsuchishoCsvFileDataEntity> listCsvFileDataEntity;
    private List<SeikyugakuTsuchishoCsvFileMeisaiEntity> listMeisaiEntity;
    private final RString レコード種別 = new RString("1");
    private final RString 帳票レコード種別_H1 = new RString("H1");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private final RString 帳票レコード種別_T1 = new RString("T1");
    private final RString 帳票レコード種別_T2 = new RString("T2");
    private final RString 帳票レコード種別_T3 = new RString("T3");
    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_3 = 3;
    private static final RString NUM = new RString("99");

    /**
     * コンストラクタです。
     */
    public SeikyugakuTsuchishoCsvFileManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    SeikyugakuTsuchishoCsvFileManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SeikyugakuTsuchishoCsvFileManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SeikyugakuTsuchishoCsvFileManager}のインスタンス
     */
    public static SeikyugakuTsuchishoCsvFileManager createInstance() {
        return InstanceProvider.create(SeikyugakuTsuchishoCsvFileManager.class);
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
        ISeikyugakuTsuchishoCsvFileMapper mapper = this.mapperProvider.create(ISeikyugakuTsuchishoCsvFileMapper.class);
//        mapper.create請求額通知書一時TBL();
//        mapper.create処理結果リスト一時TBL();
        return 取込件数確認(保存先フォルダ, エントリ情報List);
    }

    @Transaction
    private FlowEntity 取込件数確認(RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<SeikyugakuTsuchishoCsvFileEntity> csvlist = csvファイル読込(保存先フォルダ, エントリ情報List);
        ISeikyugakuTsuchishoCsvFileMapper mapper = this.mapperProvider.create(ISeikyugakuTsuchishoCsvFileMapper.class);
        DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        errorTempentity.setエラー区分(NUM);
        int 登録件数 = INDEX_0;
        FlowEntity getEntity = バッチフロ(csvlist);
        int レコード件数合算 = getEntity.getCodeNum();
        if (レコード件数合算 != INDEX_0) {
            登録件数 = 請求額通知書一時TBLに登録(csvlist);
        }
        if ((レコード件数合算 == INDEX_0) || 登録件数 == INDEX_0) {
//            mapper.処理結果リスト一時TBLに登録(errorTempentity);
        }
        getEntity.set明細データ登録件数(登録件数);
        return getEntity;

    }

    private FlowEntity バッチフロ(List<SeikyugakuTsuchishoCsvFileEntity> csvlist) {
        FlowEntity flowEntity = new FlowEntity();
        if (!csvlist.isEmpty() && csvlist.get(0).getControlCsvEntity() != null
                && csvlist.get(0).getControlCsvEntity().getShoriYM() != null) {
            FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(csvlist.get(0).getControlCsvEntity().getShoriYM());
            flowEntity.setShoriYM(処理対象年月);
        }
        int レコード件数合算 = 0;
        for (SeikyugakuTsuchishoCsvFileEntity csvEntity : csvlist) {
            if (csvEntity.getControlCsvEntity() != null && csvEntity.getControlCsvEntity().getCodeNum() != null) {
                int レコード件数 = Integer.parseInt(csvEntity.getControlCsvEntity().getCodeNum().toString());
                レコード件数合算 = レコード件数合算 + レコード件数;
            }
        }
        flowEntity.setCodeNum(レコード件数合算);
        return flowEntity;
    }

    @Transaction
    private int 請求額通知書一時TBLに登録(List<SeikyugakuTsuchishoCsvFileEntity> csvlist) {
        boolean 合計;
        boolean 累計;
        ISeikyugakuTsuchishoCsvFileMapper mapper = this.mapperProvider.create(ISeikyugakuTsuchishoCsvFileMapper.class);
        int 連番 = INDEX_0;
        for (int i = INDEX_0; i < csvlist.size(); i++) {
            SeikyugakuTsuchishoCsvFileEntity csvEntity = csvlist.get(i);
            List<SeikyugakuTsuchishoCsvFileDataEntity> listDataEntity = csvEntity.getListCsvFileDataEntity();
            for (int k = INDEX_0; k < listDataEntity.size(); k++) {
                List<SeikyugakuTsuchishoCsvFileMeisaiEntity> listMeisaiCsvEntity = listDataEntity.get(k).getListMeisaiEntity();
                for (int j = INDEX_0; j < listMeisaiCsvEntity.size(); j++) {
                    合計 = false;
                    累計 = false;
                    連番 = 連番 + 1;
                    DbWT1511SeikyugakuTsuchishoTempEntity shoTempentity = new DbWT1511SeikyugakuTsuchishoTempEntity();
                    shoTempentity.set連番(連番);

                    RString 保険者番号 = csvEntity.getControlCsvEntity().getHokenshaNo();
                    if (保険者番号 != null && !保険者番号.isEmpty()) {
                        shoTempentity.set保険者番号(new ShoKisaiHokenshaNo(保険者番号));
                    }

                    HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
                    Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(保険者番号));
                    if (hokensha != null) {
                        shoTempentity.set保険者名(hokensha.get保険者名());
                    }
                    if (listDataEntity.get(k).getHeadRecordEntity().get証記載保険者番号() != null
                            && !listDataEntity.get(k).getHeadRecordEntity().get証記載保険者番号().isEmpty()) {
                        shoTempentity.set証記載保険者番号(new ShoKisaiHokenshaNo(
                                listDataEntity.get(k).getHeadRecordEntity().get証記載保険者番号().substring(INDEX_3)));
                    }

                    shoTempentity.set証記載保険者名(listDataEntity.get(k).getHeadRecordEntity().get保険者名());
                    shoTempentity.set公費負担者番号(RString.EMPTY);
                    shoTempentity.set公費負担者名(RString.EMPTY);
                    shoTempentity.set款コード(listDataEntity.get(k).getHeadRecordEntity().get款コード());
                    shoTempentity.set款名(listDataEntity.get(k).getHeadRecordEntity().get款名());
                    shoTempentity.set項コード(listDataEntity.get(k).getHeadRecordEntity().get項コード());
                    shoTempentity.set項名(listDataEntity.get(k).getHeadRecordEntity().get項名());
                    shoTempentity.set審査年月(new FlexibleYearMonth(listDataEntity.get(k).getHeadRecordEntity().get審査年月()));
                    shoTempentity.set国保連合会名(listDataEntity.get(k).getHeadRecordEntity().get国保連合会名());

                    shoTempentity.set目コード(listMeisaiCsvEntity.get(j).get目コード());
                    shoTempentity.set目名(listMeisaiCsvEntity.get(j).get目名());
                    shoTempentity.setサービス種類コード(listMeisaiCsvEntity.get(j).getサービス種類コード());
                    shoTempentity.setサービス種類名(listMeisaiCsvEntity.get(j).getサービス種類名());
                    shoTempentity.set通常分_件数(getDecimal(listMeisaiCsvEntity.get(j).get通常分_件数()));
                    shoTempentity.set通常分_実日数(getDecimal(listMeisaiCsvEntity.get(j).get通常分_実日数()));
                    shoTempentity.set通常分_単位数(getDecimal(listMeisaiCsvEntity.get(j).get通常分_単位数()));
                    shoTempentity.set通常分_金額(getDecimal(listMeisaiCsvEntity.get(j).get通常分_金額()));
                    shoTempentity.set再審査_過誤_件数(getDecimal(listMeisaiCsvEntity.get(j).get再審査_過誤_件数()));
                    shoTempentity.set再審査_過誤_単位数(getDecimal(listMeisaiCsvEntity.get(j).get再審査_過誤_単位数()));
                    shoTempentity.set再審査_過誤_調整額(getDecimal(listMeisaiCsvEntity.get(j).get再審査_過誤_調整額()));
                    shoTempentity.set介護給付_総合事業費(getDecimal(listMeisaiCsvEntity.get(j).get介護給付費_総合事業費()));
                    shoTempentity.set利用者負担額(getDecimal(listMeisaiCsvEntity.get(j).get利用者負担額()));
                    shoTempentity.set公費負担額(getDecimal(listMeisaiCsvEntity.get(j).get公費負担額()));

                    if (j == listMeisaiCsvEntity.size() - 1) {
                        合計 = true;
                        if (k == listDataEntity.size() - 1) {
                            累計 = true;
                        }
                    }
                    setトレーラレコード1_合計(shoTempentity, listDataEntity.get(k).getToreraRecord1Entity(), 合計);
                    setトレーラレコード2_累計(shoTempentity, csvlist.get(i).getToreraRecord2Entity(), 累計);
                    setトレーラレコード3_審査支払手数料(shoTempentity, csvlist.get(i).getToreraRecord3Entity(), 累計);

//                    mapper.請求額通知書一時TBLに登録(shoTempentity);
                }
            }
        }
        return 連番;
    }

    private void setトレーラレコード1_合計(DbWT1511SeikyugakuTsuchishoTempEntity shoTempentity,
            SeikyugakuTsuchishoCsvFileToreraRecode1Entity toreraRecord1Entity, boolean flag) {
        if (flag) {
            shoTempentity.set合計_帳票レコード種別(toreraRecord1Entity.get帳票レコード種別());
            shoTempentity.set合計_通常分_件数(getDecimal(toreraRecord1Entity.get通常分_件数()));
            shoTempentity.set合計_通常分_単位数(getDecimal(toreraRecord1Entity.get通常分_単位数()));
            shoTempentity.set合計_通常分_金額(getDecimal(toreraRecord1Entity.get通常分_金額()));
            shoTempentity.set合計_再審査_過誤_件数(getDecimal(toreraRecord1Entity.get再審査_過誤_件数()));
            shoTempentity.set合計_再審査_過誤_単位数(getDecimal(toreraRecord1Entity.get再審査_過誤_単位数()));
            shoTempentity.set合計_再審査_過誤_調整額(getDecimal(toreraRecord1Entity.get再審査_過誤_調整額()));
            shoTempentity.set合計_介護給付_総合事業費(getDecimal(toreraRecord1Entity.get介護給付費_総合事業費()));
            shoTempentity.set合計_利用者負担額(getDecimal(toreraRecord1Entity.get利用者負担額()));
            shoTempentity.set合計_公費負担額(getDecimal(toreraRecord1Entity.get公費負担額()));
        } else {
            shoTempentity.set合計_帳票レコード種別(RString.EMPTY);
            shoTempentity.set合計_通常分_件数(Decimal.ZERO);
            shoTempentity.set合計_通常分_単位数(Decimal.ZERO);
            shoTempentity.set合計_通常分_金額(Decimal.ZERO);
            shoTempentity.set合計_再審査_過誤_件数(Decimal.ZERO);
            shoTempentity.set合計_再審査_過誤_単位数(Decimal.ZERO);
            shoTempentity.set合計_再審査_過誤_調整額(Decimal.ZERO);
            shoTempentity.set合計_介護給付_総合事業費(Decimal.ZERO);
            shoTempentity.set合計_利用者負担額(Decimal.ZERO);
            shoTempentity.set合計_公費負担額(Decimal.ZERO);
        }
    }

    private Decimal getDecimal(RString decimal) {
        if (RString.isNullOrEmpty(decimal)) {
            return Decimal.ZERO;
        }
        return new Decimal(decimal.toString());
    }

    private void setトレーラレコード2_累計(DbWT1511SeikyugakuTsuchishoTempEntity shoTempentity,
            SeikyugakuTsuchishoCsvFileToreraRecode2Entity toreraRecord2Entity, boolean flag) {
        if (flag) {
            shoTempentity.set累計_帳票レコード種別(toreraRecord2Entity.get帳票レコード種別());
            shoTempentity.set累計_通常分_件数(getDecimal(toreraRecord2Entity.get通常分_件数()));
            shoTempentity.set累計_通常分_単位数(getDecimal(toreraRecord2Entity.get通常分_単位数()));
            shoTempentity.set累計_通常分_金額(getDecimal(toreraRecord2Entity.get通常分_金額()));
            shoTempentity.set累計_再審査_過誤_件数(getDecimal(toreraRecord2Entity.get再審査_過誤_件数()));
            shoTempentity.set累計_再審査_過誤_単位数(getDecimal(toreraRecord2Entity.get再審査_過誤_単位数()));
            shoTempentity.set累計_再審査_過誤_調整額(getDecimal(toreraRecord2Entity.get再審査_過誤_調整額()));
            shoTempentity.set累計_介護給付_総合事業費(getDecimal(toreraRecord2Entity.get介護給付費_総合事業費()));
            shoTempentity.set累計_利用者負担額(getDecimal(toreraRecord2Entity.get利用者負担額()));
            shoTempentity.set累計_公費負担額(getDecimal(toreraRecord2Entity.get公費負担額()));
        } else {
            shoTempentity.set累計_帳票レコード種別(RString.EMPTY);
            shoTempentity.set累計_通常分_件数(Decimal.ZERO);
            shoTempentity.set累計_通常分_単位数(Decimal.ZERO);
            shoTempentity.set累計_通常分_金額(Decimal.ZERO);
            shoTempentity.set累計_再審査_過誤_件数(Decimal.ZERO);
            shoTempentity.set累計_再審査_過誤_単位数(Decimal.ZERO);
            shoTempentity.set累計_再審査_過誤_調整額(Decimal.ZERO);
            shoTempentity.set累計_介護給付_総合事業費(Decimal.ZERO);
            shoTempentity.set累計_利用者負担額(Decimal.ZERO);
            shoTempentity.set累計_公費負担額(Decimal.ZERO);
        }
    }

    private void setトレーラレコード3_審査支払手数料(DbWT1511SeikyugakuTsuchishoTempEntity shoTempentity,
            SeikyugakuTsuchishoCsvFileToreraRecode3Entity toreraRecord3Entity, boolean flag) {
        if (flag) {
            shoTempentity.set手数料_帳票レコード種別(toreraRecord3Entity.get帳票レコード種別());
            shoTempentity.set累計_利用者負担額(getDecimal(toreraRecord3Entity.get請求額()));
            shoTempentity.set累計_公費負担額(getDecimal(toreraRecord3Entity.get累計請求額()));
        } else {
            shoTempentity.set手数料_帳票レコード種別(RString.EMPTY);
            shoTempentity.set累計_利用者負担額(Decimal.ZERO);
            shoTempentity.set累計_公費負担額(Decimal.ZERO);
        }
    }

    private List<SeikyugakuTsuchishoCsvFileEntity> csvファイル読込(RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<SeikyugakuTsuchishoCsvFileEntity> list = new ArrayList<>();
        List<RString> csvFullPathList = new ArrayList<>();
        for (int i = INDEX_0; i < エントリ情報List.size(); i++) {
            File path = new File(保存先フォルダ + File.separator + エントリ情報List.get(i));
            RString csvFullPath = new RString(path.getPath());
            csvFullPathList.add(csvFullPath);
        }

        for (int j = INDEX_0; j < csvFullPathList.size(); j++) {
            entity = new SeikyugakuTsuchishoCsvFileEntity();
            csvFileDataEntity = new SeikyugakuTsuchishoCsvFileDataEntity();
            controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
            headRecordEntity = new SeikyugakuTsuchishoCsvFileHeadRecordEntity();
            meisaiEntity = new SeikyugakuTsuchishoCsvFileMeisaiEntity();
            toreraRecord1Entity = new SeikyugakuTsuchishoCsvFileToreraRecode1Entity();
            toreraRecord2Entity = new SeikyugakuTsuchishoCsvFileToreraRecode2Entity();
            toreraRecord3Entity = new SeikyugakuTsuchishoCsvFileToreraRecode3Entity();
            listCsvFileDataEntity = new ArrayList<>();
            listMeisaiEntity = new ArrayList<>();
            try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(csvFullPathList.get(j)).setDelimiter(カンマ).setEncode(Encode.SJIS)
                    .hasHeader(false).setNewLine(NewLine.CRLF).build()) {
                while (true) {
                    List<RString> data = csvReader.readLine();
                    if (data != null && !data.isEmpty()) {
                        if (レコード種別.equals(data.get(INDEX_0))) {
                            controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
                        } else if (帳票レコード種別_H1.equals(data.get(INDEX_3))) {
                            headRecordEntity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoCsvFileHeadRecordEntity.class, data);
                        } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                            meisaiEntity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoCsvFileMeisaiEntity.class, data);
                            listMeisaiEntity.add(meisaiEntity);
                        } else if (帳票レコード種別_T1.equals(data.get(INDEX_3))) {
                            toreraRecord1Entity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoCsvFileToreraRecode1Entity.class, data);
                            csvFileDataEntity.setHeadRecordEntity(headRecordEntity);
                            csvFileDataEntity.setListMeisaiEntity(listMeisaiEntity);
                            csvFileDataEntity.setToreraRecord1Entity(toreraRecord1Entity);
                            listCsvFileDataEntity.add(csvFileDataEntity);

                            headRecordEntity = new SeikyugakuTsuchishoCsvFileHeadRecordEntity();
                            meisaiEntity = new SeikyugakuTsuchishoCsvFileMeisaiEntity();
                            listMeisaiEntity = new ArrayList<>();
                            toreraRecord1Entity = new SeikyugakuTsuchishoCsvFileToreraRecode1Entity();

                        } else if (帳票レコード種別_T2.equals(data.get(INDEX_3))) {
                            toreraRecord2Entity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoCsvFileToreraRecode2Entity.class, data);
                        } else if (帳票レコード種別_T3.equals(data.get(INDEX_3))) {
                            toreraRecord3Entity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoCsvFileToreraRecode3Entity.class, data);
                        }
                    } else {
                        break;
                    }

                }
                entity.setControlCsvEntity(controlCsvEntity);
                entity.setListCsvFileDataEntity(listCsvFileDataEntity);
                entity.setToreraRecord2Entity(toreraRecord2Entity);
                entity.setToreraRecord3Entity(toreraRecord3Entity);
                list.add(entity);
            }
        }
        return list;
    }
}
