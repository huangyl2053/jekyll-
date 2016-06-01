package jp.co.ndensan.reams.db.dbc.service.core.kagoketteihokenshaincsvfileread;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3060KagoKetteiShukeiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3061KagoKetteiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInGokeiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInHeadCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInMeisaiCsvEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kagoketteihokenshaincsvfileread.IKagoKetteiHokenshaInMapperCsvFileRead;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokensha.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
    private KagoKetteiHokenshaInHeadCsvEntity headCsvEntity;
    private KagoKetteiHokenshaInMeisaiCsvEntity meisaiCsvEntity;
    private KagoKetteiHokenshaInGokeiCsvEntity gokeiCsvEntity;
    private FlowEntity flowEntity;
    private List<KagoKetteiHokenshaInMeisaiCsvEntity> meisaiList;
    private List<KagoKetteiHokenshaInGokeiCsvEntity> gokeiList;
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
     * @return {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInCsvFileRead}のインスタンス
     */
    public static KagoKetteiHokenshaInCsvFileRead createInstance() {
        return InstanceProvider.create(KagoKetteiHokenshaInCsvFileRead.class);
    }

    /**
     * 一時TBL作成
     */
    @Transaction
    public void 一時TBL作成() {
        IKagoKetteiHokenshaInMapperCsvFileRead mapper = this.mapperProvider.create(IKagoKetteiHokenshaInMapperCsvFileRead.class);
        mapper.create過誤決定集計一時TBL();
        mapper.create過誤決定明細一時TBL();
        mapper.create被保険者一時TBL();
        mapper.create処理結果リスト一時TBL();

    }

    /**
     * 一時TBLに読込と登録
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 保存先フォルダ RString
     * @param エントリ情報List List<RString>
     */
    @Transaction
    public void 一時TBLに読込と登録(FlexibleYearMonth 処理年月, RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<KagoKetteiHokenshaInCsvEntity> csvlist = csvファイル読込(保存先フォルダ, エントリ情報List);
        過誤決定集計一時TBLに登録(処理年月, csvlist);
        過誤決定明細一時TBLに登録(処理年月, csvlist);
        取込件数確認(csvlist);
    }

    @Transaction
    private void 取込件数確認(List<KagoKetteiHokenshaInCsvEntity> csvlist) {
        IKagoKetteiHokenshaInMapperCsvFileRead mapper = this.mapperProvider.create(IKagoKetteiHokenshaInMapperCsvFileRead.class);
        DbWT0002KokuhorenTorikomiErrorTempEntity entity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
        FlowEntity flowEntity = バッチフロ(csvlist);
        int レコード件数合算 = flowEntity.getCodeNum();
        entity.setエラー区分(NUM);
        if (レコード件数合算 == INDEX_0) {
            mapper.処理結果リスト一時TBLに登録(entity);
        }

    }

    private FlowEntity バッチフロ(List<KagoKetteiHokenshaInCsvEntity> csvlist) {
        flowEntity = new FlowEntity();
        FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(csvlist.get(0).getControlCsvEntity().getShoriYM());
        int レコード件数合算 = 0;
        for (int i = INDEX_0; i < csvlist.size(); i++) {
            int レコード件数 = Integer.parseInt(csvlist.get(i).getControlCsvEntity().getCodeNum().toString());
            レコード件数合算 = レコード件数合算 + レコード件数;
        }
        flowEntity.setShoriYM(処理対象年月);
        flowEntity.setCodeNum(レコード件数合算);
        return flowEntity;
    }

    @Transaction
    private void 過誤決定集計一時TBLに登録(FlexibleYearMonth 処理年月, List<KagoKetteiHokenshaInCsvEntity> csvlist) {
        IKagoKetteiHokenshaInMapperCsvFileRead mapper = this.mapperProvider.create(IKagoKetteiHokenshaInMapperCsvFileRead.class);
        int 連番 = INDEX_0;
        for (int i = INDEX_0; i < csvlist.size(); i++) {
            KagoKetteiHokenshaInCsvEntity csvEntity = csvlist.get(i);
            List<KagoKetteiHokenshaInGokeiCsvEntity> listGokeiCsvEntity = csvEntity.getListGokeiCsvEntity();
            for (int j = INDEX_0; j < listGokeiCsvEntity.size(); j++) {
                DbWT3060KagoKetteiShukeiTempEntity entity = new DbWT3060KagoKetteiShukeiTempEntity();
                RString 保険者番号 = csvEntity.getControlCsvEntity().getHokenshaNo();
                entity.set取扱年月(new FlexibleYearMonth(csvEntity.getHeadCscEntity().getHdrToriatsukaiYm()));
                entity.set履歴番号(++連番);
                entity.set証記載保険者番号(new ShoKisaiHokenshaNo(csvEntity.getHeadCscEntity().getShoKisaiHokenshaNo().substring(2)));
                entity.set証記載保険者名(csvEntity.getHeadCscEntity().getHihokenshaName());
                entity.set作成年月日(new FlexibleDate(csvEntity.getHeadCscEntity().getSakuseiYMD()));
                entity.set介護給付費件数(Integer.parseInt(listGokeiCsvEntity.get(j).getKaigoKyufuhiKensu().toString()));
                entity.set介護給付費単位数(new Decimal(listGokeiCsvEntity.get(j).getKaigoKyufuhiTanisu().toString()));
                entity.set介護給付費保険者負担額(new Decimal(listGokeiCsvEntity.get(j).getKaigoKyufuhiFutangaku().toString()));
                entity.set高額介護サービス費件数(INDEX_0);
                entity.set高額介護サービス費単位数(Decimal.ZERO);
                entity.set高額介護サービス費保険者負担額(Decimal.ZERO);
                if (listGokeiCsvEntity.get(j).getTokuteiNyushoshaServicehiKensu() != null
                        && !listGokeiCsvEntity.get(j).getTokuteiNyushoshaServicehiKensu().isEmpty()) {
                    entity.set特定入所者介護サービス費等件数(Integer.parseInt(listGokeiCsvEntity.get(j)
                            .getTokuteiNyushoshaServicehiKensu().toString()));
                } else {
                    entity.set特定入所者介護サービス費等件数(INDEX_0);
                }
                if (listGokeiCsvEntity.get(j).getTokuteiNyushoshaServicehiTanisu() != null
                        && !listGokeiCsvEntity.get(j).getTokuteiNyushoshaServicehiTanisu().isEmpty()) {
                    entity.set特定入所者介護サービス費等費用額(new Decimal(listGokeiCsvEntity.get(j)
                            .getTokuteiNyushoshaServicehiTanisu().toString()));
                } else {
                    entity.set特定入所者介護サービス費等費用額(Decimal.ZERO);
                }
                if (listGokeiCsvEntity.get(j).getTokuteiNyushoshaServicehiFutangaku() != null
                        && !listGokeiCsvEntity.get(j).getTokuteiNyushoshaServicehiFutangaku().isEmpty()) {
                    entity.set特定入所者介護サービス費等保険者負担額(new Decimal(listGokeiCsvEntity.get(j)
                            .getTokuteiNyushoshaServicehiFutangaku().toString()));
                } else {
                    entity.set特定入所者介護サービス費等保険者負担額(Decimal.ZERO);
                }
                entity.set取込年月(処理年月);
                entity.set保険者番号(new ShoKisaiHokenshaNo(保険者番号));
                HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
                Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(保険者番号));
                if (hokensha != null) {
                    entity.set保険者名(hokensha.get保険者名());
                }
                mapper.過誤決定集計一時TBLに登録(entity);
            }

        }
    }

    @Transaction
    private void 過誤決定明細一時TBLに登録(FlexibleYearMonth 処理年月, List<KagoKetteiHokenshaInCsvEntity> csvlist) {
        IKagoKetteiHokenshaInMapperCsvFileRead mapper = this.mapperProvider.create(IKagoKetteiHokenshaInMapperCsvFileRead.class);
        int 連番 = INDEX_0;
        for (int i = INDEX_0; i < csvlist.size(); i++) {
            KagoKetteiHokenshaInCsvEntity csvEntity = csvlist.get(i);
            List<KagoKetteiHokenshaInMeisaiCsvEntity> listMeisaiCsvEntity = csvEntity.getListMeisaiCsvEntity();
            for (int j = INDEX_0; j < listMeisaiCsvEntity.size(); j++) {
                連番 = 連番 + 1;
                DbWT3061KagoKetteiMeisaiTempEntity entity = new DbWT3061KagoKetteiMeisaiTempEntity();
                entity.set取扱年月(new FlexibleYearMonth(csvEntity.getHeadCscEntity().getHdrToriatsukaiYm()));
                entity.set履歴番号(連番);
                entity.set連番(連番);
                if (listMeisaiCsvEntity.get(j).getJigyoshoNo() != null
                        && !listMeisaiCsvEntity.get(j).getJigyoshoNo().isEmpty()) {
                    entity.set事業所番号(new JigyoshaNo(listMeisaiCsvEntity.get(j).getJigyoshoNo()));
                }
                if (listMeisaiCsvEntity.get(j).getJigyoshaName() != null
                        && !listMeisaiCsvEntity.get(j).getJigyoshaName().isEmpty()) {
                    entity.set事業所名(listMeisaiCsvEntity.get(j).getJigyoshaName());
                }
                entity.set公費負担者番号(RString.EMPTY);
                entity.set公費受給者番号(RString.EMPTY);
                entity.set公費証記載保険者番号(null);
                entity.setサービス提供年月(new FlexibleYearMonth(listMeisaiCsvEntity.get(j).getServiceTeikyoYM()));
                if (listMeisaiCsvEntity.get(j).getServiceShuruiCode() != null
                        && !listMeisaiCsvEntity.get(j).getServiceShuruiCode().isEmpty()) {
                    entity.setサービス種類コード(new ServiceShuruiCode(listMeisaiCsvEntity.get(j).getServiceShuruiCode()));
                }
                if (listMeisaiCsvEntity.get(j).getServiceShuruiName() != null
                        && !listMeisaiCsvEntity.get(j).getServiceShuruiName().isEmpty()) {
                    entity.setサービス種類名(listMeisaiCsvEntity.get(j).getServiceShuruiName());
                }
                if (listMeisaiCsvEntity.get(j).getKagomoushitateJiyuCode() != null
                        && !listMeisaiCsvEntity.get(j).getKagomoushitateJiyuCode().isEmpty()) {
                    entity.set過誤申立事由コード(new Code(listMeisaiCsvEntity.get(j).getKagomoushitateJiyuCode()));
                }
                if (listMeisaiCsvEntity.get(j).getKagomoushitateJiyu() != null
                        && !listMeisaiCsvEntity.get(j).getKagomoushitateJiyu().isEmpty()) {
                    entity.set過誤申立事由(listMeisaiCsvEntity.get(j).getKagomoushitateJiyu());
                }
                entity.set単位数(new Decimal(listMeisaiCsvEntity.get(j).getTanisu().toString()));
                entity.set保険者負担額(new Decimal(listMeisaiCsvEntity.get(j).getHokenshaFutangaku().toString()));
                entity.set取込年月(処理年月);
                mapper.過誤決定明細一時TBLに登録(entity);
                被保険者一時TBLに登録(連番, csvEntity, listMeisaiCsvEntity.get(j));

            }

        }
    }

    @Transaction
    private void 被保険者一時TBLに登録(int 連番, KagoKetteiHokenshaInCsvEntity csvEntity,
            KagoKetteiHokenshaInMeisaiCsvEntity meisaiCsvEntity) {
        IKagoKetteiHokenshaInMapperCsvFileRead mapper = this.mapperProvider.create(IKagoKetteiHokenshaInMapperCsvFileRead.class);
        DbWT0001HihokenshaTempEntity entity = new DbWT0001HihokenshaTempEntity();
        entity.set連番(連番);
        entity.set証記載保険者番号(new ShoKisaiHokenshaNo(csvEntity.getHeadCscEntity().getShoKisaiHokenshaNo().substring(2)));
        entity.set被保険者番号(new HihokenshaNo(meisaiCsvEntity.getOrgHihokenshaNo()));
        FlexibleYearMonth flexibleYearMonth = new FlexibleYearMonth(meisaiCsvEntity.getServiceTeikyoYM());
        int day = flexibleYearMonth.getLastDay();
        RString date = flexibleYearMonth.toDateString().concat(new RString(day));
        entity.setサービス提供年月末日(new FlexibleDate(date));
        entity.set被保険者カナ氏名(meisaiCsvEntity.getOrgHihokenshaShimei());
        entity.set被保険者氏名(RString.EMPTY);
        entity.set旧市町村コード(null);
        entity.set変換被保険者番号(null);
        entity.set登録被保険者番号(new HihokenshaNo(meisaiCsvEntity.getOrgHihokenshaNo()));
        entity.set市町村コード(null);
        entity.set管内管外区分(RString.EMPTY);
        entity.set郵便番号(RString.EMPTY);
        entity.set町域コード(RString.EMPTY);
        entity.set行政区コード(RString.EMPTY);
        entity.set行政区名(RString.EMPTY);
        entity.set住所(RString.EMPTY);
        entity.set番地(RString.EMPTY);
        entity.set方書(RString.EMPTY);
        entity.set宛名カナ名称(RString.EMPTY);
        entity.set宛名名称(RString.EMPTY);
        entity.set氏名50音カナ(RString.EMPTY);
        entity.set識別コード(RString.EMPTY);
        entity.set資格取得日(new FlexibleDate("20160531"));
        entity.set資格取得事由コード(RString.EMPTY);
        entity.set資格喪失日(new FlexibleDate("20160531"));
        entity.set資格喪失事由コード(RString.EMPTY);
        entity.set世帯集約番号(RString.EMPTY);
        mapper.被保険者一時TBLに登録(entity);

    }

    /**
     * csvファイル読込
     *
     * @param 保存先フォルダ RString
     * @param エントリ情報List List<RString>
     * @return List<KagoKetteiHokenshaInCsvEntity>
     */
    public List<KagoKetteiHokenshaInCsvEntity> csvファイル読込(RString 保存先フォルダ, List<RString> エントリ情報List) {
        List<KagoKetteiHokenshaInCsvEntity> list = new ArrayList<>();
        List<RString> csvFullPathList = new ArrayList<>();
        for (int i = INDEX_0; i < エントリ情報List.size(); i++) {
            RString csvFullPath = 保存先フォルダ.concat("\\").concat(エントリ情報List.get(i));
            csvFullPathList.add(csvFullPath);
        }

        for (int j = INDEX_0; j < csvFullPathList.size(); j++) {
            entity = new KagoKetteiHokenshaInCsvEntity();
            controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
            headCsvEntity = new KagoKetteiHokenshaInHeadCsvEntity();
            meisaiCsvEntity = new KagoKetteiHokenshaInMeisaiCsvEntity();
            gokeiCsvEntity = new KagoKetteiHokenshaInGokeiCsvEntity();
            meisaiList = new ArrayList<>();
            gokeiList = new ArrayList<>();
            CsvListReader csvReader = new CsvListReader.InstanceBuilder(csvFullPathList.get(j)).setDelimiter(カンマ).setEncode(Encode.SJIS)
                    .hasHeader(false).setNewLine(NewLine.CRLF).build();
            while (true) {
                List<RString> data = csvReader.readLine();
                if (data != null && !data.isEmpty()) {
                    if (帳票レコード種別_H1.equals(data.get(INDEX_3))) {
                        headCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInHeadCsvEntity.class, data);
                    } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                        meisaiCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInMeisaiCsvEntity.class, data);
                        meisaiList.add(meisaiCsvEntity);
                    } else if (帳票レコード種別_T1.equals(data.get(INDEX_3))) {
                        gokeiCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInGokeiCsvEntity.class, data);
                        gokeiList.add(gokeiCsvEntity);
                    } else if (レコード種別.equals(data.get(INDEX_0))) {
                        controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
                    }

                } else {
                    break;
                }

            }
            entity.setHeadCscEntity(headCsvEntity);
            entity.setControlCsvEntity(controlCsvEntity);
            entity.setListMeisaiCsvEntity(meisaiList);
            entity.setListGokeiCsvEntity(gokeiList);
            list.add(entity);
            csvReader.close();
        }
        return list;
    }

}
