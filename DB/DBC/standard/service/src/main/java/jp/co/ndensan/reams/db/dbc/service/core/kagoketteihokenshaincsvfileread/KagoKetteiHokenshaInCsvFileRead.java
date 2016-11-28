package jp.co.ndensan.reams.db.dbc.service.core.kagoketteihokenshaincsvfileread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3060KagoKetteiShukeiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3061KagoKetteiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInGokeiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInHeadCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInMeisaiCsvEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshaincsvfileread.IKagoKetteiHokenshaInCsvFileReadMapper;
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
 * 過誤決定通知書情報取込共通処理（保険者分・ファイル読込）のCSVファイル読取 。
 *
 * @reamsid_L DBC-0980-302 surun
 */
public class KagoKetteiHokenshaInCsvFileRead {

    private final MapperProvider mapperProvider;
    private KagoKetteiHokenshaInCsvEntity entity;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private KagoKetteiHokenshaInDataEntity dataEntity;
    private KagoKetteiHokenshaInHeadCsvEntity headCsvEntity;
    private KagoKetteiHokenshaInMeisaiCsvEntity meisaiCsvEntity;
    private KagoKetteiHokenshaInGokeiCsvEntity gokeiCsvEntity;
    private FlowEntity flowEntity;
    private List<KagoKetteiHokenshaInDataEntity> dataList;
    private List<KagoKetteiHokenshaInMeisaiCsvEntity> meisaiList;
    private final RString レコード種別 = new RString("1");
    private final RString エンドレコード種別 = new RString("3");
    private final RString 帳票レコード種別_H1 = new RString("H1");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private final RString 帳票レコード種別_T1 = new RString("T1");
    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_3 = 3;

    /**
     * コンストラクタです。
     */
    public KagoKetteiHokenshaInCsvFileRead() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    KagoKetteiHokenshaInCsvFileRead(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInCsvFileRead}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInCsvFileRead}のインスタンス
     */
    public static KagoKetteiHokenshaInCsvFileRead createInstance() {
        return InstanceProvider.create(KagoKetteiHokenshaInCsvFileRead.class);
    }

    /**
     * 一時TBL作成と読込と登録メソッド
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 保存先フォルダ RString
     * @param エントリ情報List List<RString>
     * @return FlowEntity
     */
    @Transaction
    public FlowEntity 一時TBL作成と読込と登録(FlexibleYearMonth 処理年月, RString 保存先フォルダ, List<RString> エントリ情報List) {
        IKagoKetteiHokenshaInCsvFileReadMapper mapper = this.mapperProvider.create(IKagoKetteiHokenshaInCsvFileReadMapper.class);
        mapper.create過誤決定集計一時TBL();
        mapper.create過誤決定明細一時TBL();
        mapper.create被保険者一時TBL();
        mapper.create処理結果リスト一時TBL();
        return 取込件数確認(処理年月, 保存先フォルダ, エントリ情報List);
    }

    @Transaction
    private FlowEntity 取込件数確認(FlexibleYearMonth 処理年月, RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<KagoKetteiHokenshaInCsvEntity> csvlist = csvファイル読込(保存先フォルダ, エントリ情報List);
        IKagoKetteiHokenshaInCsvFileReadMapper mapper = this.mapperProvider.create(IKagoKetteiHokenshaInCsvFileReadMapper.class);
        DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        errorTempentity.setエラー区分(KokuhorenJoho_TorikomiErrorKubun.取込対象データなし.getコード());
        int 集計データ登録件数 = INDEX_0;
        int 明細データ登録件数 = INDEX_0;
        FlowEntity getEntity = バッチフロ(csvlist);
        int レコード件数合算 = getEntity.getCodeNum();
        if (レコード件数合算 != INDEX_0) {
            集計データ登録件数 = 過誤決定集計一時TBLに登録(処理年月, csvlist);
            明細データ登録件数 = 過誤決定明細一時TBLに登録(処理年月, csvlist);
        }
        if ((レコード件数合算 == INDEX_0) || (集計データ登録件数 + 明細データ登録件数) == INDEX_0) {
            mapper.処理結果リスト一時TBLに登録(errorTempentity);
        }
        getEntity.set集計データ登録件数(集計データ登録件数);
        getEntity.set明細データ登録件数(明細データ登録件数);
        return getEntity;
    }

    private FlowEntity バッチフロ(List<KagoKetteiHokenshaInCsvEntity> csvlist) {
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
    private int 過誤決定集計一時TBLに登録(FlexibleYearMonth 処理年月, List<KagoKetteiHokenshaInCsvEntity> csvlist) {
        IKagoKetteiHokenshaInCsvFileReadMapper mapper = this.mapperProvider.create(IKagoKetteiHokenshaInCsvFileReadMapper.class);
        int 連番 = INDEX_0;
        for (int i = INDEX_0; i < csvlist.size(); i++) {
            KagoKetteiHokenshaInCsvEntity csvEntity = csvlist.get(i);
            List<KagoKetteiHokenshaInDataEntity> listDataEntity = csvEntity.getListDataEntity();
            for (int j = INDEX_0; j < listDataEntity.size(); j++) {
                DbWT3060KagoKetteiShukeiTempEntity shukeiTempentity = new DbWT3060KagoKetteiShukeiTempEntity();
                RString 保険者番号 = csvEntity.getControlCsvEntity().getHokenshaNo();
                if (listDataEntity.get(j).getHeadCsvEntity().getHdrToriatsukaiYm() != null
                        && !listDataEntity.get(j).getHeadCsvEntity().getHdrToriatsukaiYm().isEmpty()) {
                    shukeiTempentity.set取扱年月(new FlexibleYearMonth(listDataEntity.get(j).getHeadCsvEntity().getHdrToriatsukaiYm()));
                }
                shukeiTempentity.set履歴番号(++連番);
                if (listDataEntity.get(j).getHeadCsvEntity().getShoKisaiHokenshaNo() != null
                        && !listDataEntity.get(j).getHeadCsvEntity().getShoKisaiHokenshaNo().isEmpty()
                        && listDataEntity.get(j).getHeadCsvEntity().getShoKisaiHokenshaNo().length() >= INDEX_3) {
                    shukeiTempentity.set証記載保険者番号(new ShoKisaiHokenshaNo(listDataEntity.get(j).getHeadCsvEntity()
                            .getShoKisaiHokenshaNo()));
                }
                shukeiTempentity.set証記載保険者名(listDataEntity.get(j).getHeadCsvEntity().getHihokenshaName());
                if (listDataEntity.get(j).getHeadCsvEntity().getSakuseiYMD() != null
                        && !listDataEntity.get(j).getHeadCsvEntity().getSakuseiYMD().isEmpty()) {
                    shukeiTempentity.set作成年月日(new FlexibleDate(listDataEntity.get(j).getHeadCsvEntity().getSakuseiYMD()));
                }
                shukeiTempentity.set高額介護サービス費件数(INDEX_0);
                shukeiTempentity.set高額介護サービス費単位数(Decimal.ZERO);
                shukeiTempentity.set高額介護サービス費保険者負担額(Decimal.ZERO);
                set件数と単位数と費用額(shukeiTempentity, listDataEntity.get(j));
                shukeiTempentity.set取込年月(処理年月);
                if (保険者番号 != null && !保険者番号.isEmpty()) {
                    shukeiTempentity.set保険者番号(new ShoKisaiHokenshaNo(保険者番号));
                }
                HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
                Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(保険者番号));
                if (hokensha != null) {
                    shukeiTempentity.set保険者名(hokensha.get保険者名());
                }
                mapper.過誤決定集計一時TBLに登録(shukeiTempentity);
            }

        }
        return 連番;
    }

    private void set件数と単位数と費用額(DbWT3060KagoKetteiShukeiTempEntity shukeiTempentity, KagoKetteiHokenshaInDataEntity dataEntity) {
        if (dataEntity.getGokeiCsvEntity().getKaigoKyufuhiKensu() != null
                && !dataEntity.getGokeiCsvEntity().getKaigoKyufuhiKensu().isEmpty()) {
            shukeiTempentity.set介護給付費件数(Integer.parseInt(dataEntity.getGokeiCsvEntity().getKaigoKyufuhiKensu().toString()));
        }
        if (dataEntity.getGokeiCsvEntity().getKaigoKyufuhiTanisu() != null
                && !dataEntity.getGokeiCsvEntity().getKaigoKyufuhiTanisu().isEmpty()) {
            shukeiTempentity.set介護給付費単位数(new Decimal(dataEntity.getGokeiCsvEntity().getKaigoKyufuhiTanisu().toString()));
        }
        if (dataEntity.getGokeiCsvEntity().getKaigoKyufuhiFutangaku() != null
                && !dataEntity.getGokeiCsvEntity().getKaigoKyufuhiFutangaku().isEmpty()) {
            shukeiTempentity.set介護給付費保険者負担額(new Decimal(dataEntity.getGokeiCsvEntity().getKaigoKyufuhiFutangaku().toString()));
        }
        if (dataEntity.getGokeiCsvEntity().getTokuteiNyushoshaServicehiKensu() != null
                && !dataEntity.getGokeiCsvEntity().getTokuteiNyushoshaServicehiKensu().isEmpty()) {
            shukeiTempentity.set特定入所者介護サービス費等件数(Integer.parseInt(dataEntity.getGokeiCsvEntity()
                    .getTokuteiNyushoshaServicehiKensu().toString()));
        } else {
            shukeiTempentity.set特定入所者介護サービス費等件数(INDEX_0);
        }
        if (dataEntity.getGokeiCsvEntity().getTokuteiNyushoshaServicehiTanisu() != null
                && !dataEntity.getGokeiCsvEntity().getTokuteiNyushoshaServicehiTanisu().isEmpty()) {
            shukeiTempentity.set特定入所者介護サービス費等費用額(new Decimal(dataEntity.getGokeiCsvEntity()
                    .getTokuteiNyushoshaServicehiTanisu().toString()));
        } else {
            shukeiTempentity.set特定入所者介護サービス費等費用額(Decimal.ZERO);
        }
        if (dataEntity.getGokeiCsvEntity().getTokuteiNyushoshaServicehiFutangaku() != null
                && !dataEntity.getGokeiCsvEntity().getTokuteiNyushoshaServicehiFutangaku().isEmpty()) {
            shukeiTempentity.set特定入所者介護サービス費等保険者負担額(new Decimal(dataEntity.getGokeiCsvEntity()
                    .getTokuteiNyushoshaServicehiFutangaku().toString()));
        } else {
            shukeiTempentity.set特定入所者介護サービス費等保険者負担額(Decimal.ZERO);
        }

    }

    @Transaction
    private int 過誤決定明細一時TBLに登録(FlexibleYearMonth 処理年月, List<KagoKetteiHokenshaInCsvEntity> csvlist) {
        IKagoKetteiHokenshaInCsvFileReadMapper mapper = this.mapperProvider.create(IKagoKetteiHokenshaInCsvFileReadMapper.class);
        int 連番 = INDEX_0;
        int 履歴番号 = INDEX_0;
        for (int i = INDEX_0; i < csvlist.size(); i++) {
            KagoKetteiHokenshaInCsvEntity csvEntity = csvlist.get(i);
            List<KagoKetteiHokenshaInDataEntity> listDataEntity = csvEntity.getListDataEntity();
            for (int k = INDEX_0; k < listDataEntity.size(); k++) {
                履歴番号 = 履歴番号 + 1;
                List<KagoKetteiHokenshaInMeisaiCsvEntity> listMeisaiCsvEntity = listDataEntity.get(k).getListMeisaiCsvEntity();
                for (int j = INDEX_0; j < listMeisaiCsvEntity.size(); j++) {
                    連番 = 連番 + 1;
                    DbWT3061KagoKetteiMeisaiTempEntity meisaiTempentity = new DbWT3061KagoKetteiMeisaiTempEntity();
                    if (listDataEntity.get(k).getHeadCsvEntity().getHdrToriatsukaiYm() != null
                            && !listDataEntity.get(k).getHeadCsvEntity().getHdrToriatsukaiYm().isEmpty()) {
                        meisaiTempentity.set取扱年月(new FlexibleYearMonth(listDataEntity.get(k).getHeadCsvEntity().getHdrToriatsukaiYm()));
                    }
                    meisaiTempentity.set履歴番号(履歴番号);
                    meisaiTempentity.set連番(連番);
                    if (listMeisaiCsvEntity.get(j).getJigyoshoNo() != null
                            && !listMeisaiCsvEntity.get(j).getJigyoshoNo().isEmpty()) {
                        meisaiTempentity.set事業所番号(new JigyoshaNo(listMeisaiCsvEntity.get(j).getJigyoshoNo()));
                    }
                    meisaiTempentity.set事業所名(listMeisaiCsvEntity.get(j).getJigyoshaName());
                    meisaiTempentity.set公費負担者番号(RString.EMPTY);
                    meisaiTempentity.set公費受給者番号(RString.EMPTY);
                    meisaiTempentity.set公費証記載保険者番号(null);
                    meisaiTempentity.setサービス提供年月(new FlexibleYearMonth(listMeisaiCsvEntity.get(j).getServiceTeikyoYM()));
                    if (listMeisaiCsvEntity.get(j).getServiceShuruiCode() != null
                            && !listMeisaiCsvEntity.get(j).getServiceShuruiCode().isEmpty()) {
                        meisaiTempentity.setサービス種類コード(new ServiceShuruiCode(listMeisaiCsvEntity.get(j).getServiceShuruiCode()));
                    }
                    meisaiTempentity.setサービス種類名(listMeisaiCsvEntity.get(j).getServiceShuruiName());
                    if (listMeisaiCsvEntity.get(j).getKagomoushitateJiyuCode() != null
                            && !listMeisaiCsvEntity.get(j).getKagomoushitateJiyuCode().isEmpty()) {
                        meisaiTempentity.set過誤申立事由コード(new Code(listMeisaiCsvEntity.get(j).getKagomoushitateJiyuCode()));
                    }
                    meisaiTempentity.set過誤申立事由(listMeisaiCsvEntity.get(j).getKagomoushitateJiyu());
                    if (listMeisaiCsvEntity.get(j).getTanisu() != null
                            && !listMeisaiCsvEntity.get(j).getTanisu().isEmpty()) {
                        meisaiTempentity.set単位数(new Decimal(listMeisaiCsvEntity.get(j).getTanisu().toString()));
                    }
                    if (listMeisaiCsvEntity.get(j).getHokenshaFutangaku() != null
                            && !listMeisaiCsvEntity.get(j).getHokenshaFutangaku().isEmpty()) {
                        meisaiTempentity.set保険者負担額(new Decimal(listMeisaiCsvEntity.get(j).getHokenshaFutangaku().toString()));
                    }
                    meisaiTempentity.set取込年月(処理年月);
                    mapper.過誤決定明細一時TBLに登録(meisaiTempentity);
                    被保険者一時TBLに登録(連番, listDataEntity.get(k), listMeisaiCsvEntity.get(j));

                }

            }

        }
        return 連番;
    }

    @Transaction
    private void 被保険者一時TBLに登録(int 連番, KagoKetteiHokenshaInDataEntity dataEntity,
            KagoKetteiHokenshaInMeisaiCsvEntity meisaiCsvEntity) {
        IKagoKetteiHokenshaInCsvFileReadMapper mapper = this.mapperProvider.create(IKagoKetteiHokenshaInCsvFileReadMapper.class);
        DbWT0001HihokenshaTempEntity hihokenshaTempentity = new DbWT0001HihokenshaTempEntity();
        hihokenshaTempentity.set連番(連番);
        if (dataEntity.getHeadCsvEntity().getShoKisaiHokenshaNo() != null
                && !dataEntity.getHeadCsvEntity().getShoKisaiHokenshaNo().isEmpty()
                && dataEntity.getHeadCsvEntity().getShoKisaiHokenshaNo().length() >= INDEX_3) {
            hihokenshaTempentity.set証記載保険者番号(new ShoKisaiHokenshaNo(dataEntity.getHeadCsvEntity().getShoKisaiHokenshaNo()));
        }
        if (meisaiCsvEntity.getOrgHihokenshaNo() != null && !meisaiCsvEntity.getOrgHihokenshaNo().isEmpty()) {
            hihokenshaTempentity.set被保険者番号(new HihokenshaNo(meisaiCsvEntity.getOrgHihokenshaNo()));
        }
        if (meisaiCsvEntity.getServiceTeikyoYM() != null && !meisaiCsvEntity.getServiceTeikyoYM().isEmpty()) {
            FlexibleYearMonth flexibleYearMonth = new FlexibleYearMonth(meisaiCsvEntity.getServiceTeikyoYM());
            int day = flexibleYearMonth.getLastDay();
            RString date = flexibleYearMonth.toDateString().concat(new RString(day));
            hihokenshaTempentity.setサービス提供年月末日(new FlexibleDate(date));
        }
        hihokenshaTempentity.set被保険者カナ氏名(meisaiCsvEntity.getOrgHihokenshaShimei());
        hihokenshaTempentity.set被保険者氏名(RString.EMPTY);
        hihokenshaTempentity.set旧市町村コード(LasdecCode.EMPTY);
        hihokenshaTempentity.set変換被保険者番号(null);
        if (meisaiCsvEntity.getOrgHihokenshaNo() != null && !meisaiCsvEntity.getOrgHihokenshaNo().isEmpty()) {
            hihokenshaTempentity.set登録被保険者番号(new HihokenshaNo(meisaiCsvEntity.getOrgHihokenshaNo()));
        }
        hihokenshaTempentity.set市町村コード(LasdecCode.EMPTY);
        hihokenshaTempentity.set管内管外区分(RString.EMPTY);
        hihokenshaTempentity.set郵便番号(RString.EMPTY);
        hihokenshaTempentity.set町域コード(RString.EMPTY);
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
    private List<KagoKetteiHokenshaInCsvEntity> csvファイル読込(RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<KagoKetteiHokenshaInCsvEntity> list = new ArrayList<>();
        List<RString> csvFullPathList = new ArrayList<>();
        for (int i = INDEX_0; i < エントリ情報List.size(); i++) {
            File path = new File(保存先フォルダ + File.separator + エントリ情報List.get(i));
            RString csvFullPath = new RString(path.getPath());
            csvFullPathList.add(csvFullPath);
        }

        for (int j = INDEX_0; j < csvFullPathList.size(); j++) {
            entity = new KagoKetteiHokenshaInCsvEntity();
            controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
            dataEntity = new KagoKetteiHokenshaInDataEntity();
            headCsvEntity = new KagoKetteiHokenshaInHeadCsvEntity();
            meisaiCsvEntity = new KagoKetteiHokenshaInMeisaiCsvEntity();
            gokeiCsvEntity = new KagoKetteiHokenshaInGokeiCsvEntity();
            dataList = new ArrayList<>();
            meisaiList = new ArrayList<>();
            try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(csvFullPathList.get(j)).setDelimiter(カンマ).setEncode(Encode.SJIS)
                    .hasHeader(false).setNewLine(NewLine.CRLF).build()) {
                while (true) {
                    List<RString> data = csvReader.readLine();
                    if (data != null && !data.isEmpty()) {
                        if (エンドレコード種別.equals(data.get(INDEX_0))) {
                            break;
                        }
                        if (レコード種別.equals(data.get(INDEX_0))) {
                            controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
                        } else if (帳票レコード種別_H1.equals(data.get(INDEX_3))) {
                            headCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInHeadCsvEntity.class, data);
                        } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                            meisaiCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInMeisaiCsvEntity.class, data);
                            meisaiList.add(meisaiCsvEntity);
                        } else if (帳票レコード種別_T1.equals(data.get(INDEX_3))) {
                            gokeiCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInGokeiCsvEntity.class, data);
                            dataEntity.setHeadCsvEntity(headCsvEntity);
                            dataEntity.setListMeisaiCsvEntity(meisaiList);
                            dataEntity.setGokeiCsvEntity(gokeiCsvEntity);
                            dataList.add(dataEntity);
                            dataEntity = new KagoKetteiHokenshaInDataEntity();
                            headCsvEntity = new KagoKetteiHokenshaInHeadCsvEntity();
                            meisaiCsvEntity = new KagoKetteiHokenshaInMeisaiCsvEntity();
                            gokeiCsvEntity = new KagoKetteiHokenshaInGokeiCsvEntity();
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
