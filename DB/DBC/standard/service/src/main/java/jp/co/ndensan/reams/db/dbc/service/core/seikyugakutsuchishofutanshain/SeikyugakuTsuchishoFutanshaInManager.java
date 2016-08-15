/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.seikyugakutsuchishofutanshain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileToreraRecode3Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInCsvGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInCsvHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInCsvRuikeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInEntity;
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
 * 請求額通知書情報取込共通処理（CSVファイル取込・公費負担者分）Managerクラスです
 *
 * @reamsid_L DBC-2790-011 hemin
 */
public class SeikyugakuTsuchishoFutanshaInManager {

    private final MapperProvider mapperProvider;

    private SeikyugakuTsuchishoFutanshaInEntity entity;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private SeikyugakuTsuchishoFutanshaInDataEntity dataEntity;
    private SeikyugakuTsuchishoFutanshaInCsvHeadEntity headCsvEntity;
    private SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity meisaiCsvEntity;
    private SeikyugakuTsuchishoFutanshaInCsvGokeiEntity gokeiCsvEntity;
    private SeikyugakuTsuchishoFutanshaInCsvRuikeiEntity ruikeiCsvEntity;
    private SeikyugakuTsuchishoCsvFileToreraRecode3Entity tesuuyouCsvEntity;

    private FlowEntity flowEntity;
    private List<SeikyugakuTsuchishoFutanshaInDataEntity> dataList;
    private List<SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity> meisaiList;
    private static final RString エラー区分_登録対象なし = new RString("99");
    private final RString レコード種別 = new RString("1");
    private final RString 帳票レコード種別_H1 = new RString("H1");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private final RString 帳票レコード種別_T1 = new RString("T1");
    private final RString 帳票レコード種別_T2 = new RString("T2");
    private final RString 帳票レコード種別_T3 = new RString("T3");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_3 = 3;
    private static final RString カンマ = new RString(",");

    /**
     * コンストラクタです。
     */
    public SeikyugakuTsuchishoFutanshaInManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    SeikyugakuTsuchishoFutanshaInManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SeikyugakuTsuchishoFutanshaInManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SeikyugakuTsuchishoFutanshaInManager}のインスタンス
     */
    public static SeikyugakuTsuchishoFutanshaInManager createInstance() {
        return InstanceProvider.create(SeikyugakuTsuchishoFutanshaInManager.class);
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
        mapper.create請求額通知書一時TBL();
        mapper.create処理結果リスト一時TBL();
        return 取込件数確認(保存先フォルダ, エントリ情報List);
    }

    @Transaction
    private FlowEntity 取込件数確認(RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<SeikyugakuTsuchishoFutanshaInEntity> csvlist = csvファイル読込(保存先フォルダ, エントリ情報List);
        ISeikyugakuTsuchishoCsvFileMapper mapper = this.mapperProvider.create(ISeikyugakuTsuchishoCsvFileMapper.class);
        DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        errorTempentity.setエラー区分(エラー区分_登録対象なし);
        int 登録件数 = INDEX_0;
        FlowEntity getEntity = バッチフロ(csvlist);
        int レコード件数合算 = getEntity.getCodeNum();
        if (レコード件数合算 != INDEX_0) {
            登録件数 = 請求額通知書一時TBL登録(csvlist);
        }
        if ((レコード件数合算 == INDEX_0) || 登録件数 == INDEX_0) {
            mapper.処理結果リスト一時TBLに登録(errorTempentity);
        }
        getEntity.set明細データ登録件数(登録件数);
        return getEntity;
    }

    private FlowEntity バッチフロ(List<SeikyugakuTsuchishoFutanshaInEntity> csvlist) {
        flowEntity = new FlowEntity();
        if (csvlist.size() > INDEX_0 && csvlist.get(0).getControlCsvEntity() != null
                && csvlist.get(0).getControlCsvEntity().getShoriYM() != null) {
            FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(csvlist.get(0).getControlCsvEntity().getShoriYM());
            flowEntity.setShoriYM(処理対象年月);
        }
        int レコード件数合算 = 0;
        if (csvlist.size() > INDEX_0) {
            for (int i = INDEX_0; i < csvlist.size(); i++) {
                if (csvlist.get(i).getControlCsvEntity() != null && csvlist.get(i).getControlCsvEntity().getCodeNum() != null) {
                    int レコード件数 = Integer.parseInt(csvlist.get(i).getControlCsvEntity().getCodeNum().toString());
                    レコード件数合算 = レコード件数合算 + レコード件数;
                }
            }
        }
        flowEntity.setCodeNum(レコード件数合算);
        return flowEntity;
    }

    /**
     * csvファイル読込
     *
     * @param 保存先フォルダ RString
     * @param エントリ情報List List<RString>
     * @return List<SeikyugakuTsuchishoFutanshaInEntity>
     */
    private List<SeikyugakuTsuchishoFutanshaInEntity> csvファイル読込(RString 保存先フォルダ, List<RString> エントリ情報List) {

        List<SeikyugakuTsuchishoFutanshaInEntity> list = new ArrayList<>();
        List<RString> csvFullPathList = new ArrayList<>();
        for (int i = INDEX_0; i < エントリ情報List.size(); i++) {
            File path = new File(保存先フォルダ + File.separator + エントリ情報List.get(i));
            RString csvFullPath = new RString(path.getPath());
            csvFullPathList.add(csvFullPath);
        }
        for (int j = INDEX_0; j < csvFullPathList.size(); j++) {
            entity = new SeikyugakuTsuchishoFutanshaInEntity();
            controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
            dataEntity = new SeikyugakuTsuchishoFutanshaInDataEntity();
            headCsvEntity = new SeikyugakuTsuchishoFutanshaInCsvHeadEntity();
            meisaiCsvEntity = new SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity();
            gokeiCsvEntity = new SeikyugakuTsuchishoFutanshaInCsvGokeiEntity();
            ruikeiCsvEntity = new SeikyugakuTsuchishoFutanshaInCsvRuikeiEntity();
            tesuuyouCsvEntity = new SeikyugakuTsuchishoCsvFileToreraRecode3Entity();
            dataList = new ArrayList<>();
            meisaiList = new ArrayList<>();
            try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(csvFullPathList.get(j)).setDelimiter(カンマ).setEncode(Encode.SJIS)
                    .hasHeader(false).setNewLine(NewLine.CRLF).build()) {
                while (true) {
                    List<RString> data = csvReader.readLine();
                    if (data != null && !data.isEmpty()) {
                        if (レコード種別.equals(data.get(INDEX_0))) {
                            controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
                        } else if (帳票レコード種別_H1.equals(data.get(INDEX_3))) {
                            headCsvEntity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoFutanshaInCsvHeadEntity.class, data);
                        } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                            meisaiCsvEntity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity.class, data);
                            meisaiList.add(meisaiCsvEntity);
                        } else if (帳票レコード種別_T1.equals(data.get(INDEX_3))) {
                            gokeiCsvEntity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoFutanshaInCsvGokeiEntity.class, data);
                            dataEntity.setCsvHeadEntity(headCsvEntity);
                            dataEntity.setListCsvMeisaiEntity(meisaiList);
                            dataEntity.setCsvGokeiEntity(gokeiCsvEntity);
                            dataList.add(dataEntity);

                            headCsvEntity = new SeikyugakuTsuchishoFutanshaInCsvHeadEntity();
                            meisaiCsvEntity = new SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity();
                            gokeiCsvEntity = new SeikyugakuTsuchishoFutanshaInCsvGokeiEntity();
                            meisaiList = new ArrayList<>();
                        } else if (帳票レコード種別_T2.equals(data.get(INDEX_3))) {
                            ruikeiCsvEntity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoFutanshaInCsvRuikeiEntity.class, data);
                        } else if (帳票レコード種別_T3.equals(data.get(INDEX_3))) {
                            tesuuyouCsvEntity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoCsvFileToreraRecode3Entity.class, data);
                        }
                    } else {
                        break;
                    }
                }
                entity.setControlCsvEntity(controlCsvEntity);
                entity.setListDataEntity(dataList);
                entity.setCsvRuikeiEntity(ruikeiCsvEntity);
                entity.setCsvTesuuryouEntity(tesuuyouCsvEntity);
                list.add(entity);
            }
        }
        return list;
    }

    @Transaction
    private int 請求額通知書一時TBL登録(List<SeikyugakuTsuchishoFutanshaInEntity> csvlist) {
        ISeikyugakuTsuchishoCsvFileMapper mapper = this.mapperProvider.create(ISeikyugakuTsuchishoCsvFileMapper.class);
        int 連番 = INDEX_0;
        boolean 合計;
        boolean 累計;
        for (int i = INDEX_0;
                i < csvlist.size();
                i++) {
            SeikyugakuTsuchishoFutanshaInEntity csvEntity = csvlist.get(i);
            List<SeikyugakuTsuchishoFutanshaInDataEntity> listDataEntity = csvEntity.getListDataEntity();
            for (int j = INDEX_0; j < listDataEntity.size(); j++) {
                List<SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity> listMeisaiEntity = listDataEntity.get(j).getListCsvMeisaiEntity();
                for (int k = INDEX_0; k < listMeisaiEntity.size(); k++) {
                    連番 = 連番 + 1;
                    合計 = false;
                    累計 = false;
                    DbWT1511SeikyugakuTsuchishoTempEntity suchishoTempentity = new DbWT1511SeikyugakuTsuchishoTempEntity();
                    suchishoTempentity.set連番(連番);
                    RString 保険者番号 = csvEntity.getControlCsvEntity().getHokenshaNo();
                    if (保険者番号 != null && !保険者番号.isEmpty()) {
                        suchishoTempentity.set保険者番号(new ShoKisaiHokenshaNo(保険者番号));
                    }
                    HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
                    Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(保険者番号));
                    if (hokensha != null) {
                        suchishoTempentity.set保険者名(hokensha.get保険者名());
                    }
                    suchishoTempentity.set証記載保険者番号(null);
                    suchishoTempentity.set証記載保険者名(RString.EMPTY);
                    suchishoTempentity.set公費負担者番号(listDataEntity.get(j).getCsvHeadEntity().get公費負担者番号());
                    suchishoTempentity.set公費負担者名(listDataEntity.get(j).getCsvHeadEntity().get公費負担者名());
                    suchishoTempentity.set款コード(listDataEntity.get(j).getCsvHeadEntity().get款コード());
                    suchishoTempentity.set款名(listDataEntity.get(j).getCsvHeadEntity().get款名());
                    suchishoTempentity.set項コード(listDataEntity.get(j).getCsvHeadEntity().get項コード());
                    suchishoTempentity.set項名(listDataEntity.get(j).getCsvHeadEntity().get項名());
                    suchishoTempentity.set審査年月(new FlexibleYearMonth(listDataEntity.get(j).getCsvHeadEntity().get審査年月()));
                    suchishoTempentity.set国保連合会名(listDataEntity.get(j).getCsvHeadEntity().get国保連合会名());

                    set明細レコード(suchishoTempentity, listMeisaiEntity.get(k));
                    if (k == listMeisaiEntity.size() - 1) {
                        合計 = true;
                        if (j == listDataEntity.size() - 1) {
                            累計 = true;
                        }
                    }
                    set合計レコード(suchishoTempentity, listDataEntity.get(j).getCsvGokeiEntity(), 合計);
                    set累計レコード(suchishoTempentity, csvlist.get(i).getCsvRuikeiEntity(), 累計);
                    set審査支払手数料レコード(suchishoTempentity, csvlist.get(i).getCsvTesuuryouEntity(), 累計);
                    mapper.請求額通知書一時TBLに登録(suchishoTempentity);
                }
            }
        }
        return 連番;
    }

    private void set明細レコード(DbWT1511SeikyugakuTsuchishoTempEntity suchishoTempentity,
            SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity meisaiEntity) {
        suchishoTempentity.set目コード(meisaiEntity.get目コード());
        suchishoTempentity.set目名(meisaiEntity.get目名());
        suchishoTempentity.setサービス種類コード(meisaiEntity.getサービス種類コード());
        suchishoTempentity.setサービス種類名(meisaiEntity.getサービス種類名());
        suchishoTempentity.set通常分_件数(getDecimal(meisaiEntity.get通常分_件数()));
        suchishoTempentity.set通常分_実日数(getDecimal(meisaiEntity.get通常分_実日数()));
        suchishoTempentity.set通常分_単位数(getDecimal(meisaiEntity.get通常分_公費対象単位数()));
        suchishoTempentity.set通常分_金額(getDecimal(meisaiEntity.get通常分_公費対象金額()));
        suchishoTempentity.set再審査_過誤_件数(getDecimal(meisaiEntity.get再審査_過誤_件数()));
        suchishoTempentity.set再審査_過誤_単位数(getDecimal(meisaiEntity.get再審査_過誤_公費対象単位数()));
        suchishoTempentity.set再審査_過誤_調整額(getDecimal(meisaiEntity.get再審査_過誤_公費対象調整額()));
        suchishoTempentity.set介護給付_総合事業費(Decimal.ZERO);
        suchishoTempentity.set利用者負担額(getDecimal(meisaiEntity.get負担額()));
        suchishoTempentity.set公費負担額(getDecimal(meisaiEntity.get公費分本人負担額()));
    }

    private void set合計レコード(DbWT1511SeikyugakuTsuchishoTempEntity suchishoTempentity,
            SeikyugakuTsuchishoFutanshaInCsvGokeiEntity gokeiCsvEntity, boolean flag) {

        if (flag) {
            suchishoTempentity.set合計_帳票レコード種別(gokeiCsvEntity.get帳票レコード種別());
            suchishoTempentity.set合計_通常分_件数(getDecimal(gokeiCsvEntity.get通常分_件数()));
            suchishoTempentity.set合計_通常分_単位数(getDecimal(gokeiCsvEntity.get通常分_公費対象単位数()));
            suchishoTempentity.set合計_通常分_金額(getDecimal(gokeiCsvEntity.get通常分_公費対象金額()));
            suchishoTempentity.set合計_再審査_過誤_件数(getDecimal(gokeiCsvEntity.get再審査_過誤_件数()));
            suchishoTempentity.set合計_再審査_過誤_単位数(getDecimal(gokeiCsvEntity.get再審査_過誤_公費対象単位数()));
            suchishoTempentity.set合計_再審査_過誤_調整額(getDecimal(gokeiCsvEntity.get再審査_過誤_公費対象調整額()));
            suchishoTempentity.set合計_介護給付_総合事業費(Decimal.ZERO);
            suchishoTempentity.set合計_利用者負担額(getDecimal(gokeiCsvEntity.get負担額()));
            suchishoTempentity.set合計_公費負担額(getDecimal(gokeiCsvEntity.get公費分本人負担額()));
        } else {
            suchishoTempentity.set合計_帳票レコード種別(RString.EMPTY);
            suchishoTempentity.set合計_通常分_件数(Decimal.ZERO);
            suchishoTempentity.set合計_通常分_単位数(Decimal.ZERO);
            suchishoTempentity.set合計_通常分_金額(Decimal.ZERO);
            suchishoTempentity.set合計_再審査_過誤_件数(Decimal.ZERO);
            suchishoTempentity.set合計_再審査_過誤_単位数(Decimal.ZERO);
            suchishoTempentity.set合計_再審査_過誤_調整額(Decimal.ZERO);
            suchishoTempentity.set合計_介護給付_総合事業費(Decimal.ZERO);
            suchishoTempentity.set合計_利用者負担額(Decimal.ZERO);
            suchishoTempentity.set合計_公費負担額(Decimal.ZERO);
        }

    }

    private void set累計レコード(DbWT1511SeikyugakuTsuchishoTempEntity suchishoTempentity,
            SeikyugakuTsuchishoFutanshaInCsvRuikeiEntity ruikeiCsvEntity, boolean flag) {
        if (flag) {
            suchishoTempentity.set累計_帳票レコード種別(ruikeiCsvEntity.get帳票レコード種別());
            suchishoTempentity.set累計_通常分_件数(getDecimal(ruikeiCsvEntity.get通常分_件数()));
            suchishoTempentity.set累計_通常分_単位数(getDecimal(ruikeiCsvEntity.get通常分_公費対象単位数()));
            suchishoTempentity.set累計_通常分_金額(getDecimal(ruikeiCsvEntity.get通常分_公費対象金額()));
            suchishoTempentity.set累計_再審査_過誤_件数(getDecimal(ruikeiCsvEntity.get再審査_過誤_件数()));
            suchishoTempentity.set累計_再審査_過誤_単位数(getDecimal(ruikeiCsvEntity.get再審査_過誤_公費対象単位数()));
            suchishoTempentity.set累計_再審査_過誤_調整額(getDecimal(ruikeiCsvEntity.get再審査_過誤_公費対象調整額()));
            suchishoTempentity.set累計_介護給付_総合事業費(Decimal.ZERO);
            suchishoTempentity.set累計_利用者負担額(getDecimal(ruikeiCsvEntity.get負担額()));
            suchishoTempentity.set累計_公費負担額(getDecimal(ruikeiCsvEntity.get公費分本人負担額()));
        } else {
            suchishoTempentity.set累計_帳票レコード種別(RString.EMPTY);
            suchishoTempentity.set累計_通常分_件数(Decimal.ZERO);
            suchishoTempentity.set累計_通常分_単位数(Decimal.ZERO);
            suchishoTempentity.set累計_通常分_金額(Decimal.ZERO);
            suchishoTempentity.set累計_再審査_過誤_件数(Decimal.ZERO);
            suchishoTempentity.set累計_再審査_過誤_単位数(Decimal.ZERO);
            suchishoTempentity.set累計_再審査_過誤_調整額(Decimal.ZERO);
            suchishoTempentity.set累計_介護給付_総合事業費(Decimal.ZERO);
            suchishoTempentity.set累計_利用者負担額(Decimal.ZERO);
            suchishoTempentity.set累計_公費負担額(Decimal.ZERO);
        }
    }

    private void set審査支払手数料レコード(DbWT1511SeikyugakuTsuchishoTempEntity suchishoTempentity,
            SeikyugakuTsuchishoCsvFileToreraRecode3Entity tesuuyouCsvEntity, boolean flag) {
        if (flag) {
            suchishoTempentity.set手数料_帳票レコード種別(tesuuyouCsvEntity.get帳票レコード種別());
            suchishoTempentity.set累計_利用者負担額(getDecimal(tesuuyouCsvEntity.get請求額()));
            suchishoTempentity.set累計_公費負担額(getDecimal(tesuuyouCsvEntity.get累計請求額()));
        } else {
            suchishoTempentity.set手数料_帳票レコード種別(RString.EMPTY);
            suchishoTempentity.set累計_利用者負担額(Decimal.ZERO);
            suchishoTempentity.set累計_公費負担額(Decimal.ZERO);
        }
    }

    private Decimal getDecimal(RString decimal) {
        if (RString.isNullOrEmpty(decimal)) {
            return Decimal.ZERO;
        }
        return new Decimal(decimal.toString());
    }
}
