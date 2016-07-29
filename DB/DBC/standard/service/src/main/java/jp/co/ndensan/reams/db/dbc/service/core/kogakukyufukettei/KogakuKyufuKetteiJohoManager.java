/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakukyufukettei;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3058KogakuShikyuShinsaKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufukettei.KogakuKyufuKetteiJohoControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufukettei.KogakuKyufuKetteiJohoCsvHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufukettei.KogakuKyufuKetteiJohoCsvMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufukettei.KogakuKyufuKetteiJohoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufukettei.KogakuKyufuKetteiJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufukettei.KogakuKyufuKetteiChohyoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufukettei.KogakuKyufuKetteiHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufukettei.KogakuKyufuKetteiTorokuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3057KogakuShikyuHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3058KogakuShikyuShinsaKetteiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshainkouhifutann.IKagoKetteiHokenshaInKouhiFutannMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukyufukettei.IKogakuKyufuKetteiJohoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshaatenafinder.HihokenshaAtenaResult;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshaatena.HihokenshaAtenaFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額サービス費決定情報取込みのビジネス
 *
 * @reamsid_L DBC-0980-390 zhangrui
 */
public class KogakuKyufuKetteiJohoManager {

    private final MapperProvider mapperProvider;
    private final RString レコード種別 = new RString("1");
    private final RString 帳票レコード種別_H1 = new RString("H1");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_3 = 3;

    private static final RString エラー区分_再処理データなし = new RString("61");
    private static final RString エラー区分_判定結果データなし = new RString("62");
    private static final RString エラー区分_登録対象なし = new RString("99");
    private static final RString 審査結果反映区分_未反映 = new RString("0");
    private static final RString 審査結果反映区分_反映済 = new RString("1");
    private static final RString 漢字_連番 = new RString("連番");
    private static final RString 備考_再処理データなし
            = new RString("高額介護サービス費支給判定結果データを審査結果未反映の状態に更新しました。");
    private static final RString 備考_判定結果データなし
            = new RString("関連データ：高額介護サービス費支給判定結果データ。");

    private KogakuKyufuKetteiJohoEntity entity;
    private KogakuKyufuKetteiJohoControlCsvEntity controlCsvEntity;
    private KogakuKyufuKetteiJohoDataEntity dataEntity;
    private KogakuKyufuKetteiJohoCsvHeadEntity headCsvEntity;
    private KogakuKyufuKetteiJohoCsvMeisaiEntity meisaiCsvEntity;
    private List<KogakuKyufuKetteiJohoDataEntity> dataList;
    private List<KogakuKyufuKetteiJohoCsvMeisaiEntity> meisaiList;

    private DbT3057KogakuShikyuHanteiKekkaDac dbT3057Dac;
    private DbT3058KogakuShikyuShinsaKetteiDac dbT3058Dac;

    /**
     * コンストラクタです。
     */
    public KogakuKyufuKetteiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT3057Dac = InstanceProvider.create(DbT3057KogakuShikyuHanteiKekkaDac.class);
        this.dbT3058Dac = InstanceProvider.create(DbT3058KogakuShikyuShinsaKetteiDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    KogakuKyufuKetteiJohoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KogakuKyufuKetteiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KogakuKyufuKetteiJohoManager}のインスタンス
     */
    public static KogakuKyufuKetteiJohoManager createInstance() {
        return InstanceProvider.create(KogakuKyufuKetteiJohoManager.class);
    }

    /**
     * 一時TBL作成と読込と登録
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 保存先フォルダ RString
     * @param エントリ情報List List<RString>
     * @return FlowEntity
     */
    @Transaction
    public FlowEntity 一時TBL作成と読込と登録(FlexibleYearMonth 処理年月, RString 保存先フォルダ, List<RString> エントリ情報List) {
        IKogakuKyufuKetteiJohoMapper mapper = mapperProvider.create(IKogakuKyufuKetteiJohoMapper.class);
        IKagoKetteiHokenshaInKouhiFutannMapper futannMapper
                = mapperProvider.create(IKagoKetteiHokenshaInKouhiFutannMapper.class);
        mapper.create高額介護サービス費支給審査決定一時TBL();
        futannMapper.create被保険者一時TBL();
        futannMapper.create処理結果リスト一時TBL();
        return 取込件数確認(保存先フォルダ, エントリ情報List, mapper, futannMapper);
    }

    @Transaction
    private FlowEntity 取込件数確認(RString 保存先フォルダ, List<RString> エントリ情報List,
            IKogakuKyufuKetteiJohoMapper mapper, IKagoKetteiHokenshaInKouhiFutannMapper futannMapper) {
        FlowEntity flowEntity = new FlowEntity();
        List<KogakuKyufuKetteiJohoEntity> list = csvファイル読込(保存先フォルダ, エントリ情報List);
        int 連番 = 0;
        int レコード件数合算 = 0;
        for (KogakuKyufuKetteiJohoEntity johoEntity : list) {
            KogakuKyufuKetteiJohoControlCsvEntity controlEntity = johoEntity.getControlCsvEntity();
            if (controlEntity != null && controlEntity.getレコード件数() != null) {
                if (FlexibleYearMonth.canConvert(controlEntity.get処理対象年月())) {
                    flowEntity.setShoriYM(new FlexibleYearMonth(controlEntity.get処理対象年月()));
                }
                int レコード件数 = Integer.parseInt(controlEntity.getレコード件数().toString());
                レコード件数合算 = レコード件数合算 + レコード件数;
            }
            for (KogakuKyufuKetteiJohoDataEntity johoDataEntity : johoEntity.getListDataEntity()) {
                KogakuKyufuKetteiJohoCsvHeadEntity headerEntity = johoDataEntity.getCsvHeadEntity();
                for (KogakuKyufuKetteiJohoCsvMeisaiEntity meisaiEntity : johoDataEntity.getListCsvMeisaiEntity()) {
                    連番 = 連番 + 1;
                    insert高額介護サービス費支給審査決定一時TBL(連番, headerEntity, meisaiEntity, mapper);
                    insert被保険者一時TBL(連番, headerEntity, meisaiEntity, futannMapper);
                }
            }
        }
        IKagoKetteiHokenshaInKouhiFutannMapper hokenshaMapper
                = this.mapperProvider.create(IKagoKetteiHokenshaInKouhiFutannMapper.class);
        if ((連番 == INDEX_0)) {
            DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
            errorTempentity.setエラー区分(エラー区分_登録対象なし);
            hokenshaMapper.処理結果リスト一時TBLに登録(errorTempentity);
        }
        flowEntity.setCodeNum(レコード件数合算);
        flowEntity.set明細データ登録件数(連番);
        return flowEntity;
    }

    private void insert高額介護サービス費支給審査決定一時TBL(int 連番, KogakuKyufuKetteiJohoCsvHeadEntity headerEntity,
            KogakuKyufuKetteiJohoCsvMeisaiEntity meisaiEntity, IKogakuKyufuKetteiJohoMapper mapper) {
        DbWT3058KogakuShikyuShinsaKetteiTempEntity temp = new DbWT3058KogakuShikyuShinsaKetteiTempEntity();
        temp.set連番(連番);
        if (!RString.isNullOrEmpty(headerEntity.get証記載保険者番号())) {
            temp.set証記載保険者番号(new ShoKisaiHokenshaNo(headerEntity.get証記載保険者番号()));
        }
        temp.set証記載保険者名(headerEntity.get保険者名());
        temp.set作成年月日(headerEntity.get作成年月日());
        temp.set国保連合会名(headerEntity.get国保連合会名());
        temp.setNo(meisaiEntity.getNo());
        temp.setサービス提供年月(meisaiEntity.getサービス提供年月());
        temp.set利用者負担額(meisaiEntity.get利用者負担額());
        temp.set支給区分コード(meisaiEntity.get支給区分コード());
        temp.set決定年月(meisaiEntity.get決定年月());
        temp.set高額支給額(meisaiEntity.get高額支給額());
        temp.set支払方法区分コード(meisaiEntity.get支払方法区分コード());
        temp.set更新済フラグ(false);
        mapper.do高額介護サービス費支給審査決定一時TBLに登録(temp);
    }

    private void insert被保険者一時TBL(int 連番, KogakuKyufuKetteiJohoCsvHeadEntity headerEntity,
            KogakuKyufuKetteiJohoCsvMeisaiEntity meisaiEntity, IKagoKetteiHokenshaInKouhiFutannMapper mapper) {
        DbWT0001HihokenshaTempEntity hihokensha = new DbWT0001HihokenshaTempEntity();
        hihokensha.set連番(連番);
        if (!RString.isNullOrEmpty(headerEntity.get証記載保険者番号())) {
            hihokensha.set証記載保険者番号(new ShoKisaiHokenshaNo(headerEntity.get証記載保険者番号()));
        }
        if (!RString.isNullOrEmpty(meisaiEntity.get被保険者番号())) {
            hihokensha.set被保険者番号(new HihokenshaNo(meisaiEntity.get被保険者番号()));
        }
        if (null != meisaiEntity.getサービス提供年月()) {
            int lastDay = meisaiEntity.getサービス提供年月().getLastDay();
            hihokensha.setサービス提供年月末日(new FlexibleDate(meisaiEntity.getサービス提供年月().toDateString()
                    .concat(new RString(lastDay))));
        }
        hihokensha.set被保険者カナ氏名(RString.EMPTY);
        hihokensha.set被保険者氏名(meisaiEntity.get被保険者氏名_漢字());
        hihokensha.set旧市町村コード(LasdecCode.EMPTY);
        hihokensha.set変換被保険者番号(null);
        if (!RString.isNullOrEmpty(meisaiEntity.get被保険者番号())) {
            hihokensha.set登録被保険者番号(new HihokenshaNo(meisaiEntity.get被保険者番号()));
        }
        hihokensha.set市町村コード(LasdecCode.EMPTY);
        hihokensha.set管内管外区分(RString.EMPTY);
        hihokensha.set郵便番号(RString.EMPTY);
        hihokensha.set町域コード(RString.EMPTY);
        hihokensha.set行政区コード(RString.EMPTY);
        hihokensha.set行政区名(RString.EMPTY);
        hihokensha.set住所(RString.EMPTY);
        hihokensha.set番地(RString.EMPTY);
        hihokensha.set方書(RString.EMPTY);
        hihokensha.set宛名カナ名称(RString.EMPTY);
        hihokensha.set宛名名称(RString.EMPTY);
        hihokensha.set氏名50音カナ(RString.EMPTY);
        hihokensha.set識別コード(RString.EMPTY);
        hihokensha.set資格取得日(FlexibleDate.EMPTY);
        hihokensha.set資格取得事由コード(RString.EMPTY);
        hihokensha.set資格喪失日(FlexibleDate.EMPTY);
        hihokensha.set資格喪失事由コード(RString.EMPTY);
        hihokensha.set世帯集約番号(RString.EMPTY);
        mapper.被保険者一時TBLに登録(hihokensha);
    }

    /**
     * csvファイル読込
     *
     * @param 保存先フォルダ RString
     * @param エントリ情報List List<RString>
     * @return List<KagoKetteiHokenshaInCsvEntity>
     */
    private List<KogakuKyufuKetteiJohoEntity> csvファイル読込(RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<KogakuKyufuKetteiJohoEntity> list = new ArrayList<>();
        List<RString> csvFullPathList = new ArrayList<>();
        for (int i = INDEX_0; i < エントリ情報List.size(); i++) {
            File path = new File(保存先フォルダ + File.separator + エントリ情報List.get(i));
            RString csvFullPath = new RString(path.getPath());
            csvFullPathList.add(csvFullPath);
        }

        for (int fileIndex = INDEX_0; fileIndex < csvFullPathList.size(); fileIndex++) {
            entity = new KogakuKyufuKetteiJohoEntity();
            controlCsvEntity = new KogakuKyufuKetteiJohoControlCsvEntity();
            dataEntity = new KogakuKyufuKetteiJohoDataEntity();
            headCsvEntity = new KogakuKyufuKetteiJohoCsvHeadEntity();
            meisaiCsvEntity = new KogakuKyufuKetteiJohoCsvMeisaiEntity();
            dataList = new ArrayList<>();
            meisaiList = new ArrayList<>();
            try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(csvFullPathList.get(fileIndex))
                    .setDelimiter(カンマ).setEncode(Encode.SJIS).hasHeader(false).setNewLine(NewLine.CRLF).build()) {
                while (true) {
                    List<RString> data = csvReader.readLine();
                    if (data != null && !data.isEmpty()) {
                        if (レコード種別.equals(data.get(INDEX_0))) {
                            controlCsvEntity = ListToObjectMappingHelper.
                                    toObject(KogakuKyufuKetteiJohoControlCsvEntity.class, data);
                        } else if (帳票レコード種別_H1.equals(data.get(INDEX_3))) {
                            addHeaderAndMeisai();
                            headCsvEntity = ListToObjectMappingHelper.
                                    toObject(KogakuKyufuKetteiJohoCsvHeadEntity.class, data);
                        } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                            meisaiCsvEntity = ListToObjectMappingHelper.
                                    toObject(KogakuKyufuKetteiJohoCsvMeisaiEntity.class, data);
                            meisaiList.add(meisaiCsvEntity);
                        }
                    } else {
                        break;
                    }
                }
                addHeaderAndMeisai();
                entity.setControlCsvEntity(controlCsvEntity);
                entity.setListDataEntity(dataList);
                list.add(entity);
            }
        }
        return list;
    }

    private void addHeaderAndMeisai() {
        if (null != meisaiList && !meisaiList.isEmpty()) {
            dataEntity.setCsvHeadEntity(headCsvEntity);
            dataEntity.setListCsvMeisaiEntity(meisaiList);
            dataList.add(dataEntity);
        }
    }

    /**
     * DB登録
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 再処理区分 RString
     */
    public void doDB登録(FlexibleYearMonth 処理年月, SaiShoriKubun 再処理区分) {
        IKogakuKyufuKetteiJohoMapper mapper = mapperProvider.create(IKogakuKyufuKetteiJohoMapper.class);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("処理年月", 処理年月);
        if (SaiShoriKubun.再処理.equals(再処理区分)) {
            List<KogakuKyufuKetteiTorokuEntity> list = mapper.get前回登録データ(parameter);
            if (null != list && !list.isEmpty()) {
                for (KogakuKyufuKetteiTorokuEntity torokuEntity : list) {
                    do審査決定情報の更新(torokuEntity, mapper);
                }
            }
        }
        List<KogakuKyufuKetteiHanteiEntity> hanteiList = mapper.get登録対象データ();
        if (null != hanteiList && !hanteiList.isEmpty()) {
            for (KogakuKyufuKetteiHanteiEntity hanteiEntity : hanteiList) {
                do審査決定情報の登録(hanteiEntity, 処理年月);
            }
        }
    }

    private void do審査決定情報の更新(KogakuKyufuKetteiTorokuEntity entity,
            IKogakuKyufuKetteiJohoMapper mapper) {
        if (null == entity) {
            return;
        }
        DbWT3058KogakuShikyuShinsaKetteiTempEntity ketteiTemp = entity.getKetteiTemp();
        DbT3058KogakuShikyuShinsaKetteiEntity shinsaKettei = entity.getShinsaKettei();
        DbT3057KogakuShikyuHanteiKekkaEntity hanteiKekka = entity.getHanteiKekka();
        Map<String, Object> parameter = new HashMap<>();
        if (null != ketteiTemp) {
            shinsaKettei.setTsuchishoNo(ketteiTemp.getNo());
            shinsaKettei.setRiyoshaFutanGaku(ketteiTemp.get利用者負担額());
            shinsaKettei.setShikyuKubunCode(ketteiTemp.get支給区分コード());
            shinsaKettei.setKetteiYM(ketteiTemp.get決定年月());
            shinsaKettei.setKogakuShikyuGaku(ketteiTemp.get高額支給額());
            shinsaKettei.setState(EntityDataState.Modified);
            dbT3058Dac.update(shinsaKettei);
            parameter.put(漢字_連番.toString(), ketteiTemp.get連番());
            mapper.do審査決定一時データを更新済にする(parameter);
        } else {
            shinsaKettei.setState(EntityDataState.Deleted);
            dbT3058Dac.deletePhysical(shinsaKettei);
            if (null != hanteiKekka) {
                hanteiKekka.setShinsaKekkaHaneiKubun(審査結果反映区分_未反映);
                hanteiKekka.setState(EntityDataState.Modified);
                dbT3057Dac.save(hanteiKekka);
            }
            処理結果一時TBLに再処理データなしエラー登録する(shinsaKettei, hanteiKekka);
        }
    }

    private void 処理結果一時TBLに再処理データなしエラー登録する(
            DbT3058KogakuShikyuShinsaKetteiEntity shinsaKettei, DbT3057KogakuShikyuHanteiKekkaEntity hanteiKekka) {
        IKagoKetteiHokenshaInKouhiFutannMapper hokenshaMapper
                = this.mapperProvider.create(IKagoKetteiHokenshaInKouhiFutannMapper.class);
        DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        errorTempentity.setエラー区分(エラー区分_再処理データなし);
        if (null != shinsaKettei.getShoKisaiHokenshaNo()) {
            ShoKisaiHokenshaNo 証記載保険者番号
                    = new ShoKisaiHokenshaNo(shinsaKettei.getShoKisaiHokenshaNo().getColumnValue());
            errorTempentity.set証記載保険者番号(証記載保険者番号);
        }
        errorTempentity.set被保険者番号(shinsaKettei.getHihokenshaNo());
        if (null != shinsaKettei.getServiceTeikyoYM()) {
            RString キー1 = shinsaKettei.getServiceTeikyoYM().wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
            errorTempentity.setキー1(キー1);
        }
        RString 被保険者カナ氏名 = RString.EMPTY;
        RString 被保険者氏名 = RString.EMPTY;
        if (null != shinsaKettei.getHihokenshaNo() && !HihokenshaNo.EMPTY.equals(shinsaKettei.getHihokenshaNo())) {
            HihokenshaAtenaFinder finder = new HihokenshaAtenaFinder();
            HihokenshaAtenaResult atena = finder.getHihokenshaAtena(shinsaKettei.getHihokenshaNo());
            IShikibetsuTaisho 被保険者 = atena.get識別対象();
            if (null != 被保険者 && null != 被保険者.get名称()) {
                被保険者カナ氏名 = 被保険者.get名称().getKana().getColumnValue();
                被保険者氏名 = 被保険者.get名称().getName().getColumnValue();
            }
        }
        errorTempentity.set被保険者カナ氏名(被保険者カナ氏名);
        errorTempentity.set被保険者氏名(被保険者氏名);
        if (null != hanteiKekka) {
            errorTempentity.set備考(備考_再処理データなし);
        }
        hokenshaMapper.処理結果リスト一時TBLに登録(errorTempentity);
    }

    private void do審査決定情報の登録(KogakuKyufuKetteiHanteiEntity hanteiEntity, FlexibleYearMonth 処理年月) {
        DbWT0001HihokenshaTempEntity hihokenshaTemp = hanteiEntity.getHihokenshaTemp();
        DbWT3058KogakuShikyuShinsaKetteiTempEntity ketteiTemp = hanteiEntity.getKetteiTemp();
        List<DbT3057KogakuShikyuHanteiKekkaEntity> kekkaList = hanteiEntity.getKekkaList();
        DbT3058KogakuShikyuShinsaKetteiEntity newKetteiEntity = new DbT3058KogakuShikyuShinsaKetteiEntity();
        newKetteiEntity.setHihokenshaNo(hihokenshaTemp.get被保険者番号());
        newKetteiEntity.setServiceTeikyoYM(ketteiTemp.getサービス提供年月());
        if (null != ketteiTemp.get証記載保険者番号()) {
            HokenshaNo 証記載保険者番号 = new HokenshaNo(ketteiTemp.get証記載保険者番号().getColumnValue());
            newKetteiEntity.setShoKisaiHokenshaNo(証記載保険者番号);
        }
        if (null != kekkaList && !kekkaList.isEmpty()) {
            newKetteiEntity.setRirekiNo(kekkaList.get(0).getRirekiNo());
            do判定結果データの審査結果反映区分を反映済にする(kekkaList.get(0));
        } else {
            newKetteiEntity.setRirekiNo(0);
            do判定結果データが存在しないエラー登録する(hihokenshaTemp);
        }
        newKetteiEntity.setKetteishaUketoriYM(処理年月);
        newKetteiEntity.setTsuchishoNo(ketteiTemp.getNo());
        newKetteiEntity.setRiyoshaFutanGaku(ketteiTemp.get利用者負担額());
        newKetteiEntity.setShikyuKubunCode(ketteiTemp.get支給区分コード());
        newKetteiEntity.setKetteiYM(ketteiTemp.get決定年月());
        newKetteiEntity.setKogakuShikyuGaku(ketteiTemp.get高額支給額());
        newKetteiEntity.setState(EntityDataState.Added);
        dbT3058Dac.insert(newKetteiEntity);
    }

    private void do判定結果データの審査結果反映区分を反映済にする(DbT3057KogakuShikyuHanteiKekkaEntity kekkaEntity) {
        kekkaEntity.setShinsaKekkaHaneiKubun(審査結果反映区分_反映済);
        kekkaEntity.setState(EntityDataState.Modified);
        dbT3057Dac.save(kekkaEntity);
    }

    private void do判定結果データが存在しないエラー登録する(DbWT0001HihokenshaTempEntity hihokenshaTemp) {
        IKagoKetteiHokenshaInKouhiFutannMapper hokenshaMapper
                = this.mapperProvider.create(IKagoKetteiHokenshaInKouhiFutannMapper.class);
        DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        errorTempentity.setエラー区分(エラー区分_判定結果データなし);
        errorTempentity.set証記載保険者番号(hihokenshaTemp.get証記載保険者番号());
        errorTempentity.set被保険者番号(hihokenshaTemp.get登録被保険者番号());
        if (null != hihokenshaTemp.getサービス提供年月末日()) {
            FlexibleYearMonth サービス提供年月 = hihokenshaTemp.getサービス提供年月末日().getYearMonth();
            errorTempentity.setキー1(サービス提供年月.wareki().firstYear(FirstYear.ICHI_NEN).toDateString());
        }
        errorTempentity.set被保険者カナ氏名(hihokenshaTemp.get被保険者カナ氏名());
        errorTempentity.set被保険者氏名(hihokenshaTemp.get被保険者氏名());
        errorTempentity.set備考(備考_判定結果データなし);
        hokenshaMapper.処理結果リスト一時TBLに登録(errorTempentity);
    }

    /**
     * 帳票出力対象データを取得する
     *
     * @param parameter Map<String, Object>
     * @return List<KogakuKyufuKetteiChohyoDataEntity>
     */
    public List<KogakuKyufuKetteiChohyoDataEntity> get帳票出力対象データ(Map<String, Object> parameter) {
        IKogakuKyufuKetteiJohoMapper mapper = mapperProvider.create(IKogakuKyufuKetteiJohoMapper.class);
        List<KogakuKyufuKetteiChohyoDataEntity> list = mapper.get帳票出力対象データ(parameter);
        if (null == list) {
            return Collections.EMPTY_LIST;
        }
        return list;
    }

}
