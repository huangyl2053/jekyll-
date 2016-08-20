/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.seikyugakutsuchishofutanshain;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileToreraRecode3Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInCsvGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInCsvHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInCsvRuikeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyugakutsuchishofutanshain.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
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

    private SeikyugakuTsuchishoFutanshaInEntity entity;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private SeikyugakuTsuchishoFutanshaInDataEntity dataEntity;
    private SeikyugakuTsuchishoFutanshaInCsvHeadEntity headCsvEntity;
    private SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity meisaiCsvEntity;
    private SeikyugakuTsuchishoFutanshaInCsvGokeiEntity gokeiCsvEntity;
    private SeikyugakuTsuchishoFutanshaInCsvRuikeiEntity ruikeiCsvEntity;
    private SeikyugakuTsuchishoCsvFileToreraRecode3Entity tesuuyouCsvEntity;
    private DbWT1511SeikyugakuTsuchishoTempEntity suchishoTempentity;
    private List<SeikyugakuTsuchishoFutanshaInDataEntity> dataList;
    private List<SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity> meisaiList;
    private final MapperProvider mapperProvider;

    private final RString レコード種別 = new RString("1");
    private final RString 帳票レコード種別_H1 = new RString("H1");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private final RString 帳票レコード種別_T1 = new RString("T1");
    private final RString 帳票レコード種別_T2 = new RString("T2");
    private final RString 帳票レコード種別_T3 = new RString("T3");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_3 = 3;

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
     * csvファイル読込
     *
     * @param data List<RString>
     * @return List<SeikyugakuTsuchishoFutanshaInEntity>
     */
    @Transaction
    public DbWT1511SeikyugakuTsuchishoTempEntity csvファイル読込データ処理(List<RString> data) {

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
            entity.setControlCsvEntity(controlCsvEntity);
            entity.setListDataEntity(dataList);
            entity.setCsvRuikeiEntity(ruikeiCsvEntity);
            entity.setCsvTesuuryouEntity(tesuuyouCsvEntity);
        }
        return setレコード(entity);
    }

    @Transaction
    private DbWT1511SeikyugakuTsuchishoTempEntity setレコード(SeikyugakuTsuchishoFutanshaInEntity csvData) {
        suchishoTempentity = new DbWT1511SeikyugakuTsuchishoTempEntity();
        int renban = INDEX_0;
        boolean 合計;
        boolean 累計;
        List<SeikyugakuTsuchishoFutanshaInDataEntity> listDataEntity = csvData.getListDataEntity();
        for (int j = INDEX_0; j < listDataEntity.size(); j++) {
            List<SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity> listMeisaiEntity = listDataEntity.get(j).getListCsvMeisaiEntity();
            for (int k = INDEX_0; k < listMeisaiEntity.size(); k++) {
                renban = renban + 1;
                合計 = false;
                累計 = false;
                suchishoTempentity.setRenban(renban);
                RString 保険者番号 = csvData.getControlCsvEntity().getHokenshaNo();
                if (保険者番号 != null && !保険者番号.isEmpty()) {
                    suchishoTempentity.setHokenshaNo(new ShoKisaiHokenshaNo(保険者番号));
                }
                HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
                Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(保険者番号));
                if (hokensha != null) {
                    suchishoTempentity.setHokenshaName(hokensha.get保険者名());
                }
                suchishoTempentity.setShoKisaiHokenshaNo(null);
                suchishoTempentity.setShoKisaiHokenshaName(RString.EMPTY);
                suchishoTempentity.setKohiFutanshaNo(listDataEntity.get(j).getCsvHeadEntity().get公費負担者番号());
                suchishoTempentity.setKohiFutanshaName(listDataEntity.get(j).getCsvHeadEntity().get公費負担者名());
                suchishoTempentity.setKanCode(listDataEntity.get(j).getCsvHeadEntity().get款コード());
                suchishoTempentity.setKanName(listDataEntity.get(j).getCsvHeadEntity().get款名());
                suchishoTempentity.setKouCode(listDataEntity.get(j).getCsvHeadEntity().get項コード());
                suchishoTempentity.setKouName(listDataEntity.get(j).getCsvHeadEntity().get項名());
                suchishoTempentity.setShinsaYM(new FlexibleYearMonth(listDataEntity.get(j).getCsvHeadEntity().get審査年月()));
                suchishoTempentity.setKokuhorenName(listDataEntity.get(j).getCsvHeadEntity().get国保連合会名());

                set明細レコード(suchishoTempentity, listMeisaiEntity.get(k));
                if (k == listMeisaiEntity.size() - 1) {
                    合計 = true;
                    if (j == listDataEntity.size() - 1) {
                        累計 = true;
                    }
                }
                set合計レコード(suchishoTempentity, listDataEntity.get(j).getCsvGokeiEntity(), 合計);
                set累計レコード(suchishoTempentity, csvData.getCsvRuikeiEntity(), 累計);
                set審査支払手数料レコード(suchishoTempentity, csvData.getCsvTesuuryouEntity(), 累計);
            }

        }
        return suchishoTempentity;
    }

    @Transaction
    private void set明細レコード(DbWT1511SeikyugakuTsuchishoTempEntity suchishoTempentity,
            SeikyugakuTsuchishoFutanshaInCsvMeisaiEntity meisaiEntity) {
        suchishoTempentity.setMokuCode(meisaiEntity.get目コード());
        suchishoTempentity.setMokuName(meisaiEntity.get目名());
        suchishoTempentity.setServiceShuruiCode(meisaiEntity.getサービス種類コード());
        suchishoTempentity.setServiceShuruiMei(meisaiEntity.getサービス種類名());
        suchishoTempentity.setT_Kensu(getDecimal(meisaiEntity.get通常分_件数()));
        suchishoTempentity.setT_JitsuNissu(getDecimal(meisaiEntity.get通常分_実日数()));
        suchishoTempentity.setT_Tanisu(getDecimal(meisaiEntity.get通常分_公費対象単位数()));
        suchishoTempentity.setT_Kingaku(getDecimal(meisaiEntity.get通常分_公費対象金額()));
        suchishoTempentity.setS_Kensu(getDecimal(meisaiEntity.get再審査_過誤_件数()));
        suchishoTempentity.setS_Tanisu(getDecimal(meisaiEntity.get再審査_過誤_公費対象単位数()));
        suchishoTempentity.setS_Choseigaku(getDecimal(meisaiEntity.get再審査_過誤_公費対象調整額()));
        suchishoTempentity.setKaigokyufuSogojigyohi(Decimal.ZERO);
        suchishoTempentity.setRiyoshaFutangaku(getDecimal(meisaiEntity.get負担額()));
        suchishoTempentity.setKohiFutangaku(getDecimal(meisaiEntity.get公費分本人負担額()));
    }

    @Transaction
    private void set合計レコード(DbWT1511SeikyugakuTsuchishoTempEntity suchishoTempentity,
            SeikyugakuTsuchishoFutanshaInCsvGokeiEntity gokeiCsvEntity, boolean flag) {

        if (flag) {
            suchishoTempentity.setGokeiChohyoRecordShubetsu(gokeiCsvEntity.get帳票レコード種別());
            suchishoTempentity.setT_GokeiKensu(getDecimal(gokeiCsvEntity.get通常分_件数()));
            suchishoTempentity.setT_GokeiTanisu(getDecimal(gokeiCsvEntity.get通常分_公費対象単位数()));
            suchishoTempentity.setT_GokeiKingaku(getDecimal(gokeiCsvEntity.get通常分_公費対象金額()));
            suchishoTempentity.setS_GokeiKensu(getDecimal(gokeiCsvEntity.get再審査_過誤_件数()));
            suchishoTempentity.setS_GokeiTanisu(getDecimal(gokeiCsvEntity.get再審査_過誤_公費対象単位数()));
            suchishoTempentity.setS_GokeiChoseigaku(getDecimal(gokeiCsvEntity.get再審査_過誤_公費対象調整額()));
            suchishoTempentity.setGokeiKaigokyufuSogojigyohi(Decimal.ZERO);
            suchishoTempentity.setGokeiRiyoshaFutangaku(getDecimal(gokeiCsvEntity.get負担額()));
            suchishoTempentity.setGokeiKohiFutangaku(getDecimal(gokeiCsvEntity.get公費分本人負担額()));
        } else {
            suchishoTempentity.setGokeiChohyoRecordShubetsu(RString.EMPTY);
            suchishoTempentity.setT_GokeiKensu(Decimal.ZERO);
            suchishoTempentity.setT_GokeiTanisu(Decimal.ZERO);
            suchishoTempentity.setT_GokeiKingaku(Decimal.ZERO);
            suchishoTempentity.setS_GokeiKensu(Decimal.ZERO);
            suchishoTempentity.setS_GokeiTanisu(Decimal.ZERO);
            suchishoTempentity.setS_GokeiChoseigaku(Decimal.ZERO);
            suchishoTempentity.setGokeiKaigokyufuSogojigyohi(Decimal.ZERO);
            suchishoTempentity.setGokeiRiyoshaFutangaku(Decimal.ZERO);
            suchishoTempentity.setGokeiKohiFutangaku(Decimal.ZERO);
        }

    }

    @Transaction
    private void set累計レコード(DbWT1511SeikyugakuTsuchishoTempEntity suchishoTempentity,
            SeikyugakuTsuchishoFutanshaInCsvRuikeiEntity ruikeiCsvEntity, boolean flag) {
        if (flag) {
            suchishoTempentity.setRuisekiChohyoRecordShubetsu(ruikeiCsvEntity.get帳票レコード種別());
            suchishoTempentity.setT_RuisekiKensu(getDecimal(ruikeiCsvEntity.get通常分_件数()));
            suchishoTempentity.setT_RuisekiTanisu(getDecimal(ruikeiCsvEntity.get通常分_公費対象単位数()));
            suchishoTempentity.setT_RuisekiKingaku(getDecimal(ruikeiCsvEntity.get通常分_公費対象金額()));
            suchishoTempentity.setS_RuisekiKensu(getDecimal(ruikeiCsvEntity.get再審査_過誤_件数()));
            suchishoTempentity.setS_RuisekiTanisu(getDecimal(ruikeiCsvEntity.get再審査_過誤_公費対象単位数()));
            suchishoTempentity.setS_RuisekiChoseigaku(getDecimal(ruikeiCsvEntity.get再審査_過誤_公費対象調整額()));
            suchishoTempentity.setRuisekiKaigokyufuSogojigyohi(Decimal.ZERO);
            suchishoTempentity.setRuisekiRiyoshaFutangaku(getDecimal(ruikeiCsvEntity.get負担額()));
            suchishoTempentity.setRuisekiKohiFutangaku(getDecimal(ruikeiCsvEntity.get公費分本人負担額()));
        } else {
            suchishoTempentity.setRuisekiChohyoRecordShubetsu(RString.EMPTY);
            suchishoTempentity.setT_RuisekiKensu(Decimal.ZERO);
            suchishoTempentity.setT_RuisekiTanisu(Decimal.ZERO);
            suchishoTempentity.setT_RuisekiKingaku(Decimal.ZERO);
            suchishoTempentity.setS_RuisekiKensu(Decimal.ZERO);
            suchishoTempentity.setS_RuisekiTanisu(Decimal.ZERO);
            suchishoTempentity.setS_RuisekiChoseigaku(Decimal.ZERO);
            suchishoTempentity.setRuisekiKaigokyufuSogojigyohi(Decimal.ZERO);
            suchishoTempentity.setRuisekiRiyoshaFutangaku(Decimal.ZERO);
            suchishoTempentity.setRuisekiKohiFutangaku(Decimal.ZERO);
        }
    }

    @Transaction
    private void set審査支払手数料レコード(DbWT1511SeikyugakuTsuchishoTempEntity suchishoTempentity,
            SeikyugakuTsuchishoCsvFileToreraRecode3Entity tesuuyouCsvEntity, boolean flag) {
        if (flag) {
            suchishoTempentity.setTesuryoChohyoRecordShubetsu(tesuuyouCsvEntity.get帳票レコード種別());
            suchishoTempentity.setTesuryoSeikyugaku(getDecimal(tesuuyouCsvEntity.get請求額()));
            suchishoTempentity.setTesuiryoRuisekiSeikyugaku(getDecimal(tesuuyouCsvEntity.get累計請求額()));
        } else {
            suchishoTempentity.setTesuryoChohyoRecordShubetsu(RString.EMPTY);
            suchishoTempentity.setTesuryoSeikyugaku(Decimal.ZERO);
            suchishoTempentity.setTesuiryoRuisekiSeikyugaku(Decimal.ZERO);
        }
    }

    private Decimal getDecimal(RString decimal) {
        if (RString.isNullOrEmpty(decimal)) {
            return Decimal.ZERO;
        }
        return new Decimal(decimal.toString());
    }

}
