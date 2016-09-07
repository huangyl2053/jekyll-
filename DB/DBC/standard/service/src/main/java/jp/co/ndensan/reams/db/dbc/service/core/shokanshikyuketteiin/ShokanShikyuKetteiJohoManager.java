/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanshikyuketteiin;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.shokanshikyukettei.ShokanShikyuKetteiJohoControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.shokanshikyukettei.ShokanShikyuKetteiJohoCsvHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.shokanshikyukettei.ShokanShikyuKetteiJohoCsvMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.shokanshikyukettei.ShokanShikyuKetteiJohoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.shokanshikyukettei.ShokanShikyuKetteiJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT3036ShokanHanteiKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.ShokanShikyuKetteiChohyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshainkouhifutann.IKagoKetteiHokenshaInKouhiFutannMapper;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanshikyuketteiin.IShokanShikyuKetteiJohoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払支給決定情報取込のビジネスです。
 *
 * @reamsid_L DBC-0980-330 gongliang
 */
public class ShokanShikyuKetteiJohoManager {

    private final MapperProvider mapperProvider;
    private final RString レコード種別 = new RString("1");
    private final RString 帳票レコード種別_H1 = new RString("H1");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_3 = 3;

    private static final RString エラー区分_登録対象なし = new RString("99");

    private ShokanShikyuKetteiJohoEntity entity;
    private ShokanShikyuKetteiJohoControlCsvEntity controlCsvEntity;
    private ShokanShikyuKetteiJohoDataEntity dataEntity;
    private ShokanShikyuKetteiJohoCsvHeadEntity headCsvEntity;
    private ShokanShikyuKetteiJohoCsvMeisaiEntity meisaiCsvEntity;
    private List<ShokanShikyuKetteiJohoDataEntity> dataList;
    private List<ShokanShikyuKetteiJohoCsvMeisaiEntity> meisaiList;

    /**
     * コンストラクタです。
     */
    public ShokanShikyuKetteiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    ShokanShikyuKetteiJohoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShokanShikyuKetteiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShokanShikyuKetteiJohoManager}のインスタンス
     */
    public static ShokanShikyuKetteiJohoManager createInstance() {
        return InstanceProvider.create(ShokanShikyuKetteiJohoManager.class);
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
        IShokanShikyuKetteiJohoMapper mapper = mapperProvider.create(IShokanShikyuKetteiJohoMapper.class);
        IKagoKetteiHokenshaInKouhiFutannMapper futannMapper
                = mapperProvider.create(IKagoKetteiHokenshaInKouhiFutannMapper.class);
        mapper.create償還払支給判定結果一時TBL();
        futannMapper.create被保険者一時TBL();
        futannMapper.create処理結果リスト一時TBL();
        return 取込件数確認(保存先フォルダ, エントリ情報List, mapper, futannMapper);
    }

    @Transaction
    private FlowEntity 取込件数確認(RString 保存先フォルダ, List<RString> エントリ情報List,
            IShokanShikyuKetteiJohoMapper mapper, IKagoKetteiHokenshaInKouhiFutannMapper futannMapper) {
        FlowEntity flowEntity = new FlowEntity();
        List<ShokanShikyuKetteiJohoEntity> list = csvファイル読込(保存先フォルダ, エントリ情報List);
        int 連番 = 0;
        int レコード件数合算 = 0;
        for (ShokanShikyuKetteiJohoEntity johoEntity : list) {
            ShokanShikyuKetteiJohoControlCsvEntity controlEntity = johoEntity.getControlCsvEntity();
            if (controlEntity != null && controlEntity.getレコード件数() != null) {
                if (FlexibleYearMonth.canConvert(controlEntity.get処理対象年月())) {
                    flowEntity.setShoriYM(new FlexibleYearMonth(controlEntity.get処理対象年月()));
                }
                int レコード件数 = Integer.parseInt(controlCsvEntity.getレコード件数().toString());
                レコード件数合算 = レコード件数合算 + レコード件数;
            }
            for (ShokanShikyuKetteiJohoDataEntity johoDataEntity : johoEntity.getListDataEntity()) {
                ShokanShikyuKetteiJohoCsvHeadEntity headerEntity = johoDataEntity.getCsvHeadEntity();
                for (ShokanShikyuKetteiJohoCsvMeisaiEntity meisaiEntity : johoDataEntity.getListCsvMeisaiEntity()) {
                    連番 = 連番 + 1;
                    insert償還払支給判定結果一時TBL(連番, headerEntity, meisaiEntity, mapper);
                    insert被保険者一時TBL(連番, headerEntity, meisaiEntity, futannMapper);
                }
            }
        }
        IKagoKetteiHokenshaInKouhiFutannMapper hokenshaMapper
                = this.mapperProvider.create(IKagoKetteiHokenshaInKouhiFutannMapper.class);
        if ((連番 == INDEX_0)) {
            DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
            errorTempentity.set証記載保険者番号(null);
            errorTempentity.set被保険者番号(null);
            errorTempentity.setエラー区分(エラー区分_登録対象なし);
            hokenshaMapper.処理結果リスト一時TBLに登録(errorTempentity);
        }
        flowEntity.setCodeNum(連番);
        return flowEntity;
    }

    private void insert償還払支給判定結果一時TBL(int 連番, ShokanShikyuKetteiJohoCsvHeadEntity headerEntity,
            ShokanShikyuKetteiJohoCsvMeisaiEntity meisaiEntity, IShokanShikyuKetteiJohoMapper mapper) {
        DbWT3036ShokanHanteiKekkaTempEntity temp = new DbWT3036ShokanHanteiKekkaTempEntity();
        temp.set連番(連番);
        if (!RString.isNullOrEmpty(headerEntity.get証記載保険者番号())) {
            temp.set証記載保険者番号(new ShoKisaiHokenshaNo(headerEntity.get証記載保険者番号()));
        }
        temp.set証記載保険者名(headerEntity.get保険者名());
        temp.set作成年月日(headerEntity.get作成年月日());
        temp.set国保連合会名(headerEntity.get国保連合会名());
        temp.setNo(meisaiEntity.getNo());
        temp.set整理番号(meisaiEntity.get整理番号());
        temp.setサービス提供年月(meisaiEntity.getサービス提供年月());
        if (null != meisaiEntity.get事業所番号()) {
            temp.set事業所番号(new JigyoshaNo(meisaiEntity.get事業所番号()));
        } else {
            temp.set事業所番号(JigyoshaNo.EMPTY);
        }
        if (null != meisaiEntity.get事業所名()) {
            temp.set事業所名(meisaiEntity.get事業所名());
        } else {
            temp.set事業所名(RString.EMPTY);
        }
        if (null != meisaiEntity.getサービス種類コード()) {
            temp.setサービス種類コード(new ServiceShuruiCode(meisaiEntity.getサービス種類コード()));
        }
        if (null != meisaiEntity.getサービス種類名()) {
            temp.setサービス種類名(meisaiEntity.getサービス種類名());
        } else {
            temp.setサービス種類名(RString.EMPTY);
        }
        temp.set単位数_金額(meisaiEntity.get単位数_金額());
        temp.set支払金額(meisaiEntity.get支払金額());
        temp.set増減単位数(meisaiEntity.get増減単位数());
        temp.set支払方法区分コード(meisaiEntity.get支払方法区分コード());
        temp.set備考1(meisaiEntity.get備考());
        temp.set備考2(RString.EMPTY);
        temp.set更新DB有無(RString.EMPTY);
        mapper.do償還払支給判定結果一時TBLに登録(temp);
    }

    private void insert被保険者一時TBL(int 連番, ShokanShikyuKetteiJohoCsvHeadEntity headerEntity,
            ShokanShikyuKetteiJohoCsvMeisaiEntity meisaiEntity, IKagoKetteiHokenshaInKouhiFutannMapper mapper) {
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
    private List<ShokanShikyuKetteiJohoEntity> csvファイル読込(RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<ShokanShikyuKetteiJohoEntity> list = new ArrayList<>();
        List<RString> csvFullPathList = new ArrayList<>();
        for (int i = INDEX_0; i < エントリ情報List.size(); i++) {
            File path = new File(保存先フォルダ + File.separator + エントリ情報List.get(i));
            RString csvFullPath = new RString(path.getPath());
            csvFullPathList.add(csvFullPath);
        }

        for (int fileIndex = INDEX_0; fileIndex < csvFullPathList.size(); fileIndex++) {
            entity = new ShokanShikyuKetteiJohoEntity();
            controlCsvEntity = new ShokanShikyuKetteiJohoControlCsvEntity();
            dataEntity = new ShokanShikyuKetteiJohoDataEntity();
            headCsvEntity = new ShokanShikyuKetteiJohoCsvHeadEntity();
            meisaiCsvEntity = new ShokanShikyuKetteiJohoCsvMeisaiEntity();
            dataList = new ArrayList<>();
            meisaiList = new ArrayList<>();
            try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(csvFullPathList.get(fileIndex))
                    .setDelimiter(カンマ).setEncode(Encode.SJIS).hasHeader(false).setNewLine(NewLine.CRLF).build()) {
                while (true) {
                    List<RString> data = csvReader.readLine();
                    if (data != null && !data.isEmpty()) {
                        if (レコード種別.equals(data.get(INDEX_0))) {
                            controlCsvEntity = ListToObjectMappingHelper.
                                    toObject(ShokanShikyuKetteiJohoControlCsvEntity.class, data);
                        } else if (帳票レコード種別_H1.equals(data.get(INDEX_3))) {
                            addHeaderAndMeisai();
                            headCsvEntity = ListToObjectMappingHelper.
                                    toObject(ShokanShikyuKetteiJohoCsvHeadEntity.class, data);
                        } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                            meisaiCsvEntity = ListToObjectMappingHelper.
                                    toObject(ShokanShikyuKetteiJohoCsvMeisaiEntity.class, data);
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
     * 償還払支給決定者一覧表の帳票出力対象データ取得
     *
     * @param parameter Map<String,Object>
     * @return List<ShokanShikyuKetteiChohyoEntity>
     */
    @Transaction
    public List<ShokanShikyuKetteiChohyoEntity> get帳票出力対象データ(Map<String, Object> parameter) {
        IShokanShikyuKetteiJohoMapper mapper = mapperProvider.create(IShokanShikyuKetteiJohoMapper.class);
        List<ShokanShikyuKetteiChohyoEntity> list = mapper.get帳票出力対象データ(parameter);
        if (null == list) {
            return Collections.EMPTY_LIST;
        }
        return list;
    }

}
