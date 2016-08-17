/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.saishinsaketteihokenshaincsvfileread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain.DbWT3063SaishinsaKetteiShukeiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain.DbWT3064SaishinsaKetteiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInCsvGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInCsvHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInCsvMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInDataEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsaketteihokenshaincsvfileread.ISaishinsaKetteiHokenshaInCsvFileReadMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * 再審査決定通知書情報取込共通処理（保険者分・ファイル読込）のCSVファイル読取 。
 *
 * @reamsid_L DBC-2520-012 surun
 */
public class SaishinsaKetteiHokenshaInCsvFileRead {

    private final MapperProvider mapperProvider;
    private SaishinsaKetteiHokenshaInCsvEntity entity;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private SaishinsaKetteiHokenshaInDataEntity dataEntity;
    private SaishinsaKetteiHokenshaInCsvHeadEntity csvHeadEntity;
    private SaishinsaKetteiHokenshaInCsvMeisaiEntity csvMeisaiEntity;
    private SaishinsaKetteiHokenshaInCsvGokeiEntity csvGokeiEntity;
    private FlowEntity flowEntity;
    private List<SaishinsaKetteiHokenshaInDataEntity> dataList;
    private List<SaishinsaKetteiHokenshaInCsvMeisaiEntity> meisaiList;
    private final RString レコード種別 = new RString("1");
    private final RString 帳票レコード種別_H1 = new RString("H1");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private final RString 帳票レコード種別_T1 = new RString("T1");
    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_3 = 3;
    private static final RString NUM = new RString("99");

    /**
     * コンストラクタです。
     */
    public SaishinsaKetteiHokenshaInCsvFileRead() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    SaishinsaKetteiHokenshaInCsvFileRead(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SaishinsaKetteiHokenshaInCsvFileRead}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SaishinsaKetteiHokenshaInCsvFileRead}のインスタンス
     */
    public static SaishinsaKetteiHokenshaInCsvFileRead createInstance() {
        return InstanceProvider.create(SaishinsaKetteiHokenshaInCsvFileRead.class);
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

        ISaishinsaKetteiHokenshaInCsvFileReadMapper mapper = this.mapperProvider.create(ISaishinsaKetteiHokenshaInCsvFileReadMapper.class);
        mapper.create再審査決定集計一時TBL();
        mapper.create再審査決定明細一時TBL();
        mapper.create被保険者一時TBL();
        mapper.create処理結果リスト一時TBL();
        return 取込件数確認(処理年月, 保存先フォルダ, エントリ情報List);
    }

    @Transaction
    private FlowEntity 取込件数確認(FlexibleYearMonth 処理年月, RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<SaishinsaKetteiHokenshaInCsvEntity> csvlist = csvファイル読込(保存先フォルダ, エントリ情報List);
        ISaishinsaKetteiHokenshaInCsvFileReadMapper mapper = this.mapperProvider.create(ISaishinsaKetteiHokenshaInCsvFileReadMapper.class);
        DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        FlowEntity getEntity = バッチフロ(csvlist);
        int レコード件数合算 = getEntity.getCodeNum();
        int 集計データ登録件数 = INDEX_0;
        int 明細データ登録件数 = INDEX_0;
        errorTempentity.setエラー区分(NUM);
        if (レコード件数合算 != INDEX_0) {
            集計データ登録件数 = 再審査決定集計一時TBLに登録(処理年月, csvlist);
            明細データ登録件数 = 再審査決定明細一時TBLに登録(処理年月, csvlist);
        }
        if ((レコード件数合算 == INDEX_0) || (集計データ登録件数 + 明細データ登録件数) == INDEX_0) {
            mapper.処理結果リスト一時TBLに登録(errorTempentity);
        }
        getEntity.set集計データ登録件数(集計データ登録件数);
        getEntity.set明細データ登録件数(明細データ登録件数);
        return getEntity;

    }

    private FlowEntity バッチフロ(List<SaishinsaKetteiHokenshaInCsvEntity> csvlist) {
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

    @Transaction
    private int 再審査決定集計一時TBLに登録(FlexibleYearMonth 処理年月, List<SaishinsaKetteiHokenshaInCsvEntity> csvlist) {
        ISaishinsaKetteiHokenshaInCsvFileReadMapper mapper = this.mapperProvider.create(ISaishinsaKetteiHokenshaInCsvFileReadMapper.class);
        int 連番 = INDEX_0;
        for (int i = INDEX_0; i < csvlist.size(); i++) {
            SaishinsaKetteiHokenshaInCsvEntity csvEntity = csvlist.get(i);
            List<SaishinsaKetteiHokenshaInDataEntity> listDataEntity = csvEntity.getListDataEntity();
            for (int j = INDEX_0; j < listDataEntity.size(); j++) {
                DbWT3063SaishinsaKetteiShukeiTempEntity shukeiTempentity = new DbWT3063SaishinsaKetteiShukeiTempEntity();
                RString 保険者番号 = csvEntity.getControlCsvEntity().getHokenshaNo();
                if (listDataEntity.get(j).getCsvHeadEntity().get取扱年月() != null
                        && !listDataEntity.get(j).getCsvHeadEntity().get取扱年月().isEmpty()) {
                    shukeiTempentity.set取扱年月(new FlexibleYearMonth(listDataEntity.get(j).getCsvHeadEntity().get取扱年月()));
                }
                shukeiTempentity.set履歴番号(++連番);
                if (listDataEntity.get(j).getCsvHeadEntity().get証記載保険者番号() != null
                        && !listDataEntity.get(j).getCsvHeadEntity().get証記載保険者番号().isEmpty()
                        && listDataEntity.get(j).getCsvHeadEntity().get証記載保険者番号().length() >= INDEX_3) {
                    shukeiTempentity.set証記載保険者番号(new ShoKisaiHokenshaNo(listDataEntity.get(j).getCsvHeadEntity()
                            .get証記載保険者番号().substring(2)));
                }
                shukeiTempentity.set証記載保険者名(listDataEntity.get(j).getCsvHeadEntity().get証記載保険者名());
                if (listDataEntity.get(j).getCsvHeadEntity().get作成年月日() != null
                        && !listDataEntity.get(j).getCsvHeadEntity().get作成年月日().isEmpty()) {
                    shukeiTempentity.set作成年月日(new FlexibleDate(listDataEntity.get(j).getCsvHeadEntity().get作成年月日()));
                }
                shukeiTempentity.set国保連合会名(listDataEntity.get(j).getCsvHeadEntity().get国保連合会名());
                shukeiTempentity.set審査委員会名(listDataEntity.get(j).getCsvHeadEntity().get審査委員会名());
                set件数と単位数と費用額(shukeiTempentity, listDataEntity.get(j));
                shukeiTempentity.set高額介護サービス費請求件数(INDEX_0);
                shukeiTempentity.set高額介護サービス費請求単位数(Decimal.ZERO);
                shukeiTempentity.set高額介護サービス費請求保険者負担額(Decimal.ZERO);
                shukeiTempentity.set高額介護サービス費決定件数(INDEX_0);
                shukeiTempentity.set高額介護サービス費決定単位数(Decimal.ZERO);
                shukeiTempentity.set高額介護サービス費決定保険者負担額(Decimal.ZERO);
                shukeiTempentity.set高額介護サービス費調整件数(INDEX_0);
                shukeiTempentity.set高額介護サービス費調整単位数(Decimal.ZERO);
                shukeiTempentity.set高額介護サービス費調整保険者負担額(Decimal.ZERO);
                shukeiTempentity.set取込年月(処理年月);
                if (保険者番号 != null && !保険者番号.isEmpty()) {
                    shukeiTempentity.set保険者番号(new ShoKisaiHokenshaNo(保険者番号));
                }
                HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
                Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(保険者番号));
                if (hokensha != null) {
                    shukeiTempentity.set保険者名(hokensha.get保険者名());
                }
                mapper.再審査決定集計一時TBLに登録(shukeiTempentity);
            }

        }
        return 連番;
    }

    private void set件数と単位数と費用額(DbWT3063SaishinsaKetteiShukeiTempEntity shukeiTempentity, SaishinsaKetteiHokenshaInDataEntity dataEntity) {
        if (dataEntity.getCsvGokeiEntity().get介護給付費請求件数() != null
                && !dataEntity.getCsvGokeiEntity().get介護給付費請求件数().isEmpty()) {
            shukeiTempentity.set介護給付費請求件数(Integer.parseInt(dataEntity.getCsvGokeiEntity()
                    .get介護給付費請求件数().toString()));
        } else {
            shukeiTempentity.set介護給付費請求件数(INDEX_0);
        }
        if (dataEntity.getCsvGokeiEntity().get介護給付費請求単位数() != null
                && !dataEntity.getCsvGokeiEntity().get介護給付費請求単位数().isEmpty()) {
            shukeiTempentity.set介護給付費請求単位数(new Decimal(dataEntity.getCsvGokeiEntity().
                    get介護給付費請求単位数().toString()));
        } else {
            shukeiTempentity.set介護給付費請求単位数(Decimal.ZERO);
        }
        if (dataEntity.getCsvGokeiEntity().get介護給付費請求保険者負担額() != null
                && !dataEntity.getCsvGokeiEntity().get介護給付費請求保険者負担額().isEmpty()) {
            shukeiTempentity.set介護給付費請求保険者負担額(new Decimal(dataEntity.getCsvGokeiEntity()
                    .get介護給付費請求保険者負担額().toString()));
        } else {
            shukeiTempentity.set介護給付費請求保険者負担額(Decimal.ZERO);
        }
        if (dataEntity.getCsvGokeiEntity().get介護給付費総合事業費決定件数() != null
                && !dataEntity.getCsvGokeiEntity().get介護給付費総合事業費決定件数().isEmpty()) {
            shukeiTempentity.set介護給付費決定件数(Integer.parseInt(dataEntity.getCsvGokeiEntity()
                    .get介護給付費総合事業費決定件数().toString()));
        }
        if (dataEntity.getCsvGokeiEntity().get介護給付費総合事業費決定単位数() != null
                && !dataEntity.getCsvGokeiEntity().get介護給付費総合事業費決定単位数().isEmpty()) {
            shukeiTempentity.set介護給付費決定単位数(new Decimal(dataEntity.getCsvGokeiEntity()
                    .get介護給付費総合事業費決定単位数().toString()));
        }
        if (dataEntity.getCsvGokeiEntity().get介護給付費総合事業費決定保険者負担額() != null
                && !dataEntity.getCsvGokeiEntity().get介護給付費総合事業費決定保険者負担額().isEmpty()) {
            shukeiTempentity.set介護給付費決定保険者負担額(new Decimal(dataEntity.getCsvGokeiEntity()
                    .get介護給付費総合事業費決定保険者負担額().toString()));
        }
        if (dataEntity.getCsvGokeiEntity().get介護給付費総合事業費調整件数() != null
                && !dataEntity.getCsvGokeiEntity().get介護給付費総合事業費調整件数().isEmpty()) {
            shukeiTempentity.set介護給付費調整件数(Integer.parseInt(dataEntity.getCsvGokeiEntity()
                    .get介護給付費総合事業費調整件数().toString()));
        }
        if (dataEntity.getCsvGokeiEntity().get介護給付費総合事業費調整単位数() != null
                && !dataEntity.getCsvGokeiEntity().get介護給付費総合事業費調整単位数().isEmpty()) {
            shukeiTempentity.set介護給付費調整単位数(new Decimal(dataEntity.getCsvGokeiEntity()
                    .get介護給付費総合事業費調整単位数().toString()));
        }
        if (dataEntity.getCsvGokeiEntity().get介護給付費総合事業費調整保険者負担額() != null
                && !dataEntity.getCsvGokeiEntity().get介護給付費総合事業費調整保険者負担額().isEmpty()) {
            shukeiTempentity.set介護給付費調整保険者負担額(new Decimal(dataEntity.getCsvGokeiEntity()
                    .get介護給付費総合事業費調整保険者負担額().toString()));
        }
    }

    @Transaction
    private int 再審査決定明細一時TBLに登録(FlexibleYearMonth 処理年月, List<SaishinsaKetteiHokenshaInCsvEntity> csvlist) {
        ISaishinsaKetteiHokenshaInCsvFileReadMapper mapper = this.mapperProvider.create(ISaishinsaKetteiHokenshaInCsvFileReadMapper.class);
        int 連番 = INDEX_0;
        int 履歴番号 = INDEX_0;
        for (int i = INDEX_0; i < csvlist.size(); i++) {
            SaishinsaKetteiHokenshaInCsvEntity csvEntity = csvlist.get(i);
            List<SaishinsaKetteiHokenshaInDataEntity> listDataEntity = csvEntity.getListDataEntity();
            for (int k = INDEX_0; k < listDataEntity.size(); k++) {
                履歴番号 = 履歴番号 + 1;
                List<SaishinsaKetteiHokenshaInCsvMeisaiEntity> listMeisaiCsvEntity = listDataEntity.get(k).getListCsvMeisaiEntity();
                for (int j = INDEX_0; j < listMeisaiCsvEntity.size(); j++) {
                    連番 = 連番 + 1;
                    DbWT3064SaishinsaKetteiMeisaiTempEntity meisaiTempentity = new DbWT3064SaishinsaKetteiMeisaiTempEntity();
                    if (listDataEntity.get(k).getCsvHeadEntity().get取扱年月() != null
                            && !listDataEntity.get(k).getCsvHeadEntity().get取扱年月().isEmpty()) {
                        meisaiTempentity.set取扱年月(new FlexibleYearMonth(listDataEntity.get(k).getCsvHeadEntity().get取扱年月()));
                    }
                    meisaiTempentity.set履歴番号(履歴番号);
                    meisaiTempentity.set連番(連番);
                    if (listMeisaiCsvEntity.get(j).get事業所番号() != null
                            && !listMeisaiCsvEntity.get(j).get事業所番号().isEmpty()) {
                        meisaiTempentity.set事業所番号(new JigyoshaNo(listMeisaiCsvEntity.get(j).get事業所番号()));
                    }
                    if (listMeisaiCsvEntity.get(j).get事業所名() != null
                            && !listMeisaiCsvEntity.get(j).get事業所名().isEmpty()) {
                        meisaiTempentity.set事業所名(listMeisaiCsvEntity.get(j).get事業所名());
                    }
                    meisaiTempentity.set公費負担者番号(RString.EMPTY);
                    meisaiTempentity.set公費受給者番号(RString.EMPTY);
                    meisaiTempentity.set公費証記載保険者番号(null);
                    setサービスと申立(meisaiTempentity, listMeisaiCsvEntity.get(j));
                    if (listMeisaiCsvEntity.get(j).get決定単位数() != null
                            && !listMeisaiCsvEntity.get(j).get決定単位数().isEmpty()) {
                        meisaiTempentity.set決定単位数(new Decimal(listMeisaiCsvEntity.get(j).get決定単位数().toString()));
                    }
                    if (listMeisaiCsvEntity.get(j).get調整単位数() != null
                            && !listMeisaiCsvEntity.get(j).get調整単位数().isEmpty()) {
                        meisaiTempentity.set調整単位数(new Decimal(listMeisaiCsvEntity.get(j).get調整単位数().toString()));
                    }
                    if (listMeisaiCsvEntity.get(j).get保険者負担額() != null
                            && !listMeisaiCsvEntity.get(j).get保険者負担額().isEmpty()) {
                        meisaiTempentity.set保険者負担額(new Decimal(listMeisaiCsvEntity.get(j).get保険者負担額().toString()));
                    }
                    meisaiTempentity.set取込年月(処理年月);
                    mapper.再審査決定明細一時TBLに登録(meisaiTempentity);
                    被保険者一時TBLに登録(連番, listDataEntity.get(k), listMeisaiCsvEntity.get(j));

                }

            }

        }
        return 連番;
    }

    private void setサービスと申立(DbWT3064SaishinsaKetteiMeisaiTempEntity meisaiTempentity, SaishinsaKetteiHokenshaInCsvMeisaiEntity meisaiEntity) {
        if (meisaiEntity.getサービス提供年月() != null
                && !meisaiEntity.getサービス提供年月().isEmpty()) {
            meisaiTempentity.setサービス提供年月(new FlexibleYearMonth(meisaiEntity.getサービス提供年月()));
        }
        if (meisaiEntity.getサービス種類コード() != null
                && !meisaiEntity.getサービス種類コード().isEmpty()) {
            meisaiTempentity.setサービス種類コード(new ServiceShuruiCode(meisaiEntity.getサービス種類コード()));
        }
        if (meisaiEntity.getサービス種類名() != null
                && !meisaiEntity.getサービス種類名().isEmpty()) {
            meisaiTempentity.setサービス種類名(meisaiEntity.getサービス種類名());
        }
        if (meisaiEntity.get申立事由コード() != null
                && !meisaiEntity.get申立事由コード().isEmpty()) {
            meisaiTempentity.set申立事由コード(new Code(meisaiEntity.get申立事由コード()));
        }
        if (meisaiEntity.get申立事由() != null
                && !meisaiEntity.get申立事由().isEmpty()) {
            meisaiTempentity.set申立事由(meisaiEntity.get申立事由());
        }
        if (meisaiEntity.get再審査結果コード() != null
                && !meisaiEntity.get再審査結果コード().isEmpty()) {
            meisaiTempentity.set再審査結果コード(new Code(meisaiEntity.get再審査結果コード()));
        }
        if (meisaiEntity.get当初請求単位数() != null
                && !meisaiEntity.get当初請求単位数().isEmpty()) {
            meisaiTempentity.set当初請求単位数(new Decimal(meisaiEntity.get当初請求単位数().toString()));
        }
        if (meisaiEntity.get原審単位数() != null
                && !meisaiEntity.get原審単位数().isEmpty()) {
            meisaiTempentity.set原審単位数(new Decimal(meisaiEntity.get原審単位数().toString()));
        }
        if (meisaiEntity.get申立単位数() != null
                && !meisaiEntity.get申立単位数().isEmpty()) {
            meisaiTempentity.set申立単位数(new Decimal(meisaiEntity.get申立単位数().toString()));
        } else {
            meisaiTempentity.set申立単位数(Decimal.ZERO);
        }

    }

    @Transaction
    private void 被保険者一時TBLに登録(int 連番, SaishinsaKetteiHokenshaInDataEntity dataEntity,
            SaishinsaKetteiHokenshaInCsvMeisaiEntity meisaiCsvEntity) {
        ISaishinsaKetteiHokenshaInCsvFileReadMapper mapper = this.mapperProvider.create(ISaishinsaKetteiHokenshaInCsvFileReadMapper.class);
        DbWT0001HihokenshaTempEntity hihokenshaTempentity = new DbWT0001HihokenshaTempEntity();
        hihokenshaTempentity.set連番(連番);
        if (dataEntity.getCsvHeadEntity().get証記載保険者番号() != null && !dataEntity.getCsvHeadEntity().get証記載保険者番号().isEmpty()
                && dataEntity.getCsvHeadEntity().get証記載保険者番号().length() >= INDEX_3) {
            hihokenshaTempentity.set証記載保険者番号(new ShoKisaiHokenshaNo(dataEntity.getCsvHeadEntity().get証記載保険者番号().substring(2)));
        }
        if (meisaiCsvEntity.get被保険者番号() != null && !meisaiCsvEntity.get被保険者番号().isEmpty()) {
            hihokenshaTempentity.set被保険者番号(new HihokenshaNo(meisaiCsvEntity.get被保険者番号()));
        }
        if (meisaiCsvEntity.getサービス提供年月() != null && !meisaiCsvEntity.getサービス提供年月().isEmpty()) {
            FlexibleYearMonth flexibleYearMonth = new FlexibleYearMonth(meisaiCsvEntity.getサービス提供年月());
            int day = flexibleYearMonth.getLastDay();
            RString date = flexibleYearMonth.toDateString().concat(new RString(day));
            hihokenshaTempentity.setサービス提供年月末日(new FlexibleDate(date));
        }
        hihokenshaTempentity.set被保険者カナ氏名(meisaiCsvEntity.get被保険者氏名());
        hihokenshaTempentity.set被保険者氏名(RString.EMPTY);
        hihokenshaTempentity.set旧市町村コード(LasdecCode.EMPTY);
        hihokenshaTempentity.set変換被保険者番号(null);
        if (meisaiCsvEntity.get被保険者番号() != null && !meisaiCsvEntity.get被保険者番号().isEmpty()) {
            hihokenshaTempentity.set登録被保険者番号(new HihokenshaNo(meisaiCsvEntity.get被保険者番号()));
        }
        hihokenshaTempentity.set市町村コード(LasdecCode.EMPTY);
        hihokenshaTempentity.set管内管外区分(RString.EMPTY);
        hihokenshaTempentity.set郵便番号(null);
        hihokenshaTempentity.set町域コード(null);
        hihokenshaTempentity.set行政区コード(RString.EMPTY);
        hihokenshaTempentity.set行政区名(RString.EMPTY);
        hihokenshaTempentity.set住所(RString.EMPTY);
        hihokenshaTempentity.set番地(RString.EMPTY);
        hihokenshaTempentity.set方書(RString.EMPTY);
        hihokenshaTempentity.set宛名カナ名称(RString.EMPTY);
        hihokenshaTempentity.set宛名名称(RString.EMPTY);
        hihokenshaTempentity.set氏名50音カナ(RString.EMPTY);
        hihokenshaTempentity.set識別コード(RString.EMPTY);
        hihokenshaTempentity.set資格取得日(FlexibleDate.EMPTY);
        hihokenshaTempentity.set資格取得事由コード(RString.EMPTY);
        hihokenshaTempentity.set資格喪失日(FlexibleDate.EMPTY);
        hihokenshaTempentity.set資格喪失事由コード(RString.EMPTY);
        hihokenshaTempentity.set世帯集約番号(RString.EMPTY);
        mapper.被保険者一時TBLに登録(hihokenshaTempentity);

    }

    /**
     * csvファイル読込
     *
     * @param 保存先フォルダ RString
     * @param エントリ情報List List<RString>
     * @return List<KagoKetteiHokenshaInCsvEntity>
     */
    private List<SaishinsaKetteiHokenshaInCsvEntity> csvファイル読込(RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<SaishinsaKetteiHokenshaInCsvEntity> list = new ArrayList<>();
        List<RString> csvFullPathList = new ArrayList<>();
        for (int i = INDEX_0; i < エントリ情報List.size(); i++) {
            File path = new File(保存先フォルダ + File.separator + エントリ情報List.get(i));
            RString csvFullPath = new RString(path.getPath());
            csvFullPathList.add(csvFullPath);
        }

        for (int j = INDEX_0; j < csvFullPathList.size(); j++) {
            entity = new SaishinsaKetteiHokenshaInCsvEntity();
            controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
            dataEntity = new SaishinsaKetteiHokenshaInDataEntity();
            csvHeadEntity = new SaishinsaKetteiHokenshaInCsvHeadEntity();
            csvMeisaiEntity = new SaishinsaKetteiHokenshaInCsvMeisaiEntity();
            csvGokeiEntity = new SaishinsaKetteiHokenshaInCsvGokeiEntity();
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
                            csvHeadEntity = ListToObjectMappingHelper.toObject(SaishinsaKetteiHokenshaInCsvHeadEntity.class, data);
                        } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                            csvMeisaiEntity = ListToObjectMappingHelper.toObject(SaishinsaKetteiHokenshaInCsvMeisaiEntity.class, data);
                            meisaiList.add(csvMeisaiEntity);
                        } else if (帳票レコード種別_T1.equals(data.get(INDEX_3))) {
                            csvGokeiEntity = ListToObjectMappingHelper.toObject(SaishinsaKetteiHokenshaInCsvGokeiEntity.class, data);
                            dataEntity.setCsvHeadEntity(csvHeadEntity);
                            dataEntity.setListCsvMeisaiEntity(meisaiList);
                            dataEntity.setCsvGokeiEntity(csvGokeiEntity);
                            dataList.add(dataEntity);
                            dataEntity = new SaishinsaKetteiHokenshaInDataEntity();
                            csvHeadEntity = new SaishinsaKetteiHokenshaInCsvHeadEntity();
                            csvMeisaiEntity = new SaishinsaKetteiHokenshaInCsvMeisaiEntity();
                            csvGokeiEntity = new SaishinsaKetteiHokenshaInCsvGokeiEntity();
                            meisaiList = new ArrayList<>();
                        }
                    } else {
                        break;
                    }

                }
                entity.setControlCsvEntity(controlCsvEntity);
                entity.setListDataEntity(dataList);
                list.add(entity);
            }
        }
        return list;
    }

}
