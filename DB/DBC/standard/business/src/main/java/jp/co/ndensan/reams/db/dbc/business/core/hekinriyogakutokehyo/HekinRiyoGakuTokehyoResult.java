/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hekinriyogakutokehyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.KyufujissekiTempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.ShikakutempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.SyorikekkaCyouHyouEucCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.SyorikekkatempTblEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 平均利用額統計表作成のビジネスです。
 *
 * @reamsid_L DBC-3490-050 yaoyahui
 */
public class HekinRiyoGakuTokehyoResult {

    private static final RString 訪問介護 = new RString("1．(介護予防)訪問介護");
    private static final RString 訪問入浴介護 = new RString("2．(介護予防)訪問入浴介護");
    private static final RString 訪問看護 = new RString("3．(介護予防)訪問看護");
    private static final RString 訪問リハビリ = new RString("4．(介護予防) 訪問リハビリ");
    private static final RString 通所介護 = new RString("5．(介護予防) 通所介護");
    private static final RString 通所リハビ = new RString("6．(介護予防) 通所リハビ");
    private static final RString 福祉用具貸与 = new RString("7．(介護予防)福祉用具貸与");
    private static final RString 短期入所生活介護 = new RString("8．(介護予防)短期入所生活介護");
    private static final RString 短期入所老健施設 = new RString("9．(介護予防)短期入所老健施設");
    private static final RString 短期入所医療施設 = new RString("10．(介護予防)短期入所医療施設");
    private static final RString 管理指導 = new RString("11．(介護予防)居宅療養 管理指導");
    private static final RString 特定施設生活介護短期以外 = new RString("12．介護予防）特定施設生活介護（短期以外）");
    private static final RString 特定施設生活介護短期 = new RString("13．介護予防）特定施設生活介護（短期）");
    private static final RString 介護福祉施設 = new RString("14．介護福祉施設");
    private static final RString 介護老健施設 = new RString("15．介護老健施設");
    private static final RString 介護医療施設 = new RString("16．介護医療施設");
    private static final RString 夜間対応型訪問介護 = new RString("17．夜間対応型訪問介護");
    private static final RString 認知症対応型通所介護 = new RString("18．(介護予防)認知症対応型通所介護");
    private static final RString 小規模多機能型居宅介護 = new RString("19．(介護予防)小規模多機能型居宅介護");
    private static final RString 小規模多機能型居宅介護短期 = new RString("20．(介護予防)小規模多機能型居宅介護（短期）");
    private static final RString 認知症対応型共同生活 = new RString("21．(介護予防)認知症対応型共同生活");
    private static final RString 地域密着型特定施設入居者生活 = new RString("22．地域密着型特定施設入居者生活(短期以外)");
    private static final RString 地域密着型特定施設入居者生活短期 = new RString("23．地域密着型特定施設入居者生活（短期）");
    private static final RString 認知症対応型共同生活短期 = new RString("24．(介護予防)認知症対応型共同生活(短期)");
    private static final RString 地域密着型介護老人福祉施設 = new RString("25．地域密着型介護老人福祉施設");
    private static final RString 随時対応型訪問介護看護 = new RString("26．定期巡回・随時対応型訪問介護看護");
    private static final RString 看護小規模多機能型居宅介護 = new RString("27. 複合型サービス（看護小規模多機能型居宅介護 短期以外）");
    private static final RString 看護小規模多機能型居宅介護短期 = new RString("28. 複合型サービス（看護小規模多機能型居宅介護 短期）");
    private static final RString 地域密着型通所介護 = new RString("29．地域密着型通所介護");
    private static final RString 特定福祉用具販売費 = new RString("30．(介護予防)特定福祉用具販売費");
    private static final RString 住宅改修費 = new RString("31．(介護予防)住宅改修費");
    private static final RString 介護予防支援 = new RString("32．居宅介護支援・介護予防支援");
    private static final RString 特定入所者介護サービス費食費 = new RString("33．(介護予防)特定入所者介護サービス費(食費)");
    private static final RString 特定入所者介護サービス費居住費 = new RString("34．(介護予防)特定入所者介護サービス費(居住費)");
    private static final RString 市町村特別給付 = new RString("35．市町村特別給付");
    private static final RString 総合計 = new RString("36．総合計");
    private static final RString 人数 = new RString("人数");
    private static final RString 費用総額 = new RString("費用総額");
    private static final RString 平均額 = new RString("平均額");
    private static final RString 值1 = new RString("1");
    private static final RString 值2 = new RString("2");
    private static final RString 值3 = new RString("3");
    private static final RString 值4 = new RString("4");
    private static final RString 值5 = new RString("5");
    private static final RString 值6 = new RString("6");
    private static final RString 值7 = new RString("7");
    private static final RString 值8 = new RString("8");
    private static final RString 值9 = new RString("9");
    private static final RString 值10 = new RString("10");
    private static final RString 值11 = new RString("11");
    private static final RString 值12 = new RString("12");
    private static final RString 值13 = new RString("13");
    private static final RString 值14 = new RString("14");
    private static final RString 值15 = new RString("15");
    private static final RString 值16 = new RString("16");
    private static final RString 值17 = new RString("17");
    private static final RString 值18 = new RString("18");
    private static final RString 值19 = new RString("19");
    private static final RString 值20 = new RString("20");
    private static final RString 值21 = new RString("21");
    private static final RString 值22 = new RString("22");
    private static final RString 值23 = new RString("23");
    private static final RString 值24 = new RString("24");
    private static final RString 值25 = new RString("25");
    private static final RString 值26 = new RString("26");
    private static final RString 值27 = new RString("27");
    private static final RString 值28 = new RString("28");
    private static final RString 值29 = new RString("29");
    private static final RString 值30 = new RString("30");
    private static final RString 值31 = new RString("31");
    private static final RString 值32 = new RString("32");
    private static final RString 值33 = new RString("33");
    private static final RString 值34 = new RString("34");
    private static final RString 值35 = new RString("35");
    private static final RString 以上 = new RString("10以上");
    private static final RString その他 = new RString("その他");
    private static final RString 号 = new RString("２号");
    private static final RString 合計 = new RString("合計");
    private static final int 值二 = 2;
    private static final int 值三 = 3;
    private static int count = 0;
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");

    /**
     * set給付実績データ一時TBL
     *
     * @param entity KyufujisDataTempTblEntity
     * @return KyufujissekiTempTblEntity 一時Entity
     */
    public KyufujissekiTempTblEntity set給付実績データ一時TBL(KyufujissekiTempTblEntity entity) {
        KyufujissekiTempTblEntity 一時Entity = new KyufujissekiTempTblEntity();
        一時Entity.setHiHokenshaNo(entity.getHiHokenshaNo());
        一時Entity.setHiyosogaku(entity.getHiyosogaku());
        一時Entity.setHokenDekidakaTanisu(entity.getHokenDekidakaTanisu());
        一時Entity.setHokenRiyoshaFutangaku(entity.getHokenRiyoshaFutangaku());
        一時Entity.setHokenSeikyuKingaku(entity.getHokenSeikyuKingaku());
        一時Entity.setHokenTanisu(entity.getHokenTanisu());
        一時Entity.setHokenTanisuTani(entity.getHokenTanisuTani());
        一時Entity.setServiceKomokuCode(entity.getServiceKomokuCode());
        一時Entity.setServiceSyuruiCode(entity.getServiceSyuruiCode());
        一時Entity.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        一時Entity.setShotoku(entity.getShotoku());
        一時Entity.setUmareYMD(entity.getUmareYMD());
        一時Entity.setYoKaigoJotaiKubunCode(entity.getYoKaigoJotaiKubunCode());
        if (!RString.isNullOrEmpty(entity.getServiceSyuruiCode())) {
            set給付実績データ一時Entity(entity, 一時Entity);
        } else {
            if (ServiceCategoryShurui.特定入所.getコード().equals(entity.getServiceSyuruiCode())) {
                set一時EntityのServiceBunrui(entity, 一時Entity);
            }
            set給付実績データ一時Entity(entity, 一時Entity);
        }
        return 一時Entity;
    }

    private void set一時EntityのServiceBunrui(KyufujissekiTempTblEntity entity, KyufujissekiTempTblEntity 一時Entity) {
        if (值1.equals(entity.getServiceKomokuCode().substring(值二, 值三))) {
            一時Entity.setServiceBunrui(值33);
        } else if (值2.equals(entity.getServiceKomokuCode())) {
            一時Entity.setServiceBunrui(值34);
        }
    }

    private void set給付実績データ一時Entity(KyufujissekiTempTblEntity entity, KyufujissekiTempTblEntity 一時Entity) {
        set給付実績データ一時Entity1(entity, 一時Entity);
        set給付実績データ一時Entity2(entity, 一時Entity);
        set給付実績データ一時Entity3(entity, 一時Entity);
        if (ServiceCategoryShurui.定期随時.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值26);
        } else if (ServiceCategoryShurui.看小短外.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值27);
        } else if (ServiceCategoryShurui.看小規短.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值28);
        } else if (ServiceCategoryShurui.地域通所.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值29);
        } else if (ServiceCategoryShurui.用具販売.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予用販売.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值30);
        } else if (ServiceCategoryShurui.住宅改修.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予住改修.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值31);
        } else if (ServiceCategoryShurui.居宅支援.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予防支援.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值32);
        } else {
            一時Entity.setServiceBunrui(值35);
        }
    }

    private void set給付実績データ一時Entity1(KyufujissekiTempTblEntity entity, KyufujissekiTempTblEntity 一時Entity) {
        if (ServiceCategoryShurui.訪問介護.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予訪介護.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值1);
        } else if (ServiceCategoryShurui.訪問入浴.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予訪入浴.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值2);
        } else if (ServiceCategoryShurui.訪問看護.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予訪看護.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值3);
        } else if (ServiceCategoryShurui.訪問リハ.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予訪リハ.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值4);
        } else if (ServiceCategoryShurui.通所介護.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予通介護.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值5);
        } else if (ServiceCategoryShurui.通所リハ.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予通リハ.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值6);
        } else if (ServiceCategoryShurui.用具貸与.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予用貸与.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值7);
        }
    }

    private void set給付実績データ一時Entity2(KyufujissekiTempTblEntity entity, KyufujissekiTempTblEntity 一時Entity) {
        if (ServiceCategoryShurui.短期生活.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予短介護.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值8);
        } else if (ServiceCategoryShurui.短期老健.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予短老健.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值9);
        } else if (ServiceCategoryShurui.短期医療.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予訪看護.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值10);
        } else if (ServiceCategoryShurui.療養指導.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予療養指.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值11);
        } else if (ServiceCategoryShurui.特施短外.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予特施設.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值12);
        } else if (ServiceCategoryShurui.特施短期.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值13);
        } else if (ServiceCategoryShurui.福祉施設.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值14);
        } else if (ServiceCategoryShurui.老健施設.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值15);
        } else if (ServiceCategoryShurui.医療施設.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值16);
        } else if (ServiceCategoryShurui.地夜間訪.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值17);
        }
    }

    private void set給付実績データ一時Entity3(KyufujissekiTempTblEntity entity, KyufujissekiTempTblEntity 一時Entity) {
        if (ServiceCategoryShurui.地通所介.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.地予通所.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值18);
        } else if (ServiceCategoryShurui.地小短外.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.地予小外.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值19);
        } else if (ServiceCategoryShurui.地予小短.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值20);
        } else if (ServiceCategoryShurui.地共同介.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.地予共同.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值21);
        } else if (ServiceCategoryShurui.地施短外.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值22);
        } else if (ServiceCategoryShurui.地施短期.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值23);
        } else if (ServiceCategoryShurui.地共同短.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.地予共短.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值24);
        } else if (ServiceCategoryShurui.地福祉生.getコード().equals(entity.getServiceSyuruiCode())) {
            一時Entity.setServiceBunrui(值25);
        }
    }

    /**
     * set出力用一時TBL
     *
     * @return ShikakutempTblEntity
     */
    public List<ShikakutempTblEntity> set出力用一時TBL() {
        List<ShikakutempTblEntity> 一時EntityList = new ArrayList<>();
        List<RString> shotokuList = new ArrayList<>();
        shotokuList.add(值1);
        shotokuList.add(值2);
        shotokuList.add(值3);
        shotokuList.add(值4);
        shotokuList.add(值5);
        shotokuList.add(值6);
        shotokuList.add(值7);
        shotokuList.add(值8);
        shotokuList.add(值9);
        shotokuList.add(以上);
        shotokuList.add(その他);
        shotokuList.add(号);
        shotokuList.add(合計);
        List<RString> shukeinaiyouList = new ArrayList<>();
        shukeinaiyouList.add(人数);
        shukeinaiyouList.add(費用総額);
        shukeinaiyouList.add(平均額);
        List<RString> serviceshuruiList = new ArrayList<>();
        serviceshuruiList.add(訪問介護);
        serviceshuruiList.add(訪問入浴介護);
        serviceshuruiList.add(訪問看護);
        serviceshuruiList.add(訪問リハビリ);
        serviceshuruiList.add(通所介護);
        serviceshuruiList.add(通所リハビ);
        serviceshuruiList.add(福祉用具貸与);
        serviceshuruiList.add(短期入所生活介護);
        serviceshuruiList.add(短期入所老健施設);
        serviceshuruiList.add(短期入所医療施設);
        serviceshuruiList.add(管理指導);
        serviceshuruiList.add(特定施設生活介護短期以外);
        serviceshuruiList.add(特定施設生活介護短期);
        serviceshuruiList.add(介護福祉施設);
        serviceshuruiList.add(介護老健施設);
        serviceshuruiList.add(介護医療施設);
        serviceshuruiList.add(夜間対応型訪問介護);
        serviceshuruiList.add(認知症対応型通所介護);
        serviceshuruiList.add(小規模多機能型居宅介護);
        serviceshuruiList.add(小規模多機能型居宅介護短期);
        serviceshuruiList.add(認知症対応型共同生活);
        serviceshuruiList.add(地域密着型特定施設入居者生活);
        serviceshuruiList.add(地域密着型特定施設入居者生活短期);
        serviceshuruiList.add(認知症対応型共同生活短期);
        serviceshuruiList.add(地域密着型介護老人福祉施設);
        serviceshuruiList.add(随時対応型訪問介護看護);
        serviceshuruiList.add(看護小規模多機能型居宅介護);
        serviceshuruiList.add(看護小規模多機能型居宅介護短期);
        serviceshuruiList.add(地域密着型通所介護);
        serviceshuruiList.add(特定福祉用具販売費);
        serviceshuruiList.add(住宅改修費);
        serviceshuruiList.add(介護予防支援);
        serviceshuruiList.add(特定入所者介護サービス費食費);
        serviceshuruiList.add(特定入所者介護サービス費居住費);
        serviceshuruiList.add(市町村特別給付);
        serviceshuruiList.add(総合計);
        for (int i = 0; i < serviceshuruiList.size(); i++) {
            set一時Entity(i, serviceshuruiList, shotokuList, shukeinaiyouList,
                    一時EntityList);
        }
        return 一時EntityList;
    }

    private void set一時Entity(int i, List<RString> serviceshuruiList,
            List<RString> shotokuList, List<RString> shukeinaiyouList,
            List<ShikakutempTblEntity> 一時EntityList) {
        for (int n = 0; n < shotokuList.size(); n++) {
            for (int j = 0; j < shukeinaiyouList.size(); j++) {
                ShikakutempTblEntity 一時Entity = new ShikakutempTblEntity();
                一時Entity.setPageNO(new RString(String.valueOf(i + 1)));
                一時Entity.setServiceshurui(serviceshuruiList.get(i));
                一時Entity.setShukeinaiyou(shukeinaiyouList.get(j));
                一時Entity.setShotoku(shotokuList.get(n));
                一時Entity.setHokenseiteitoku(RString.EMPTY);
                一時Entity.setYoshien1(Decimal.ZERO);
                一時Entity.setYoshien2(Decimal.ZERO);
                一時Entity.setKeikanoyokaigo(Decimal.ZERO);
                一時Entity.setYokaigo1(Decimal.ZERO);
                一時Entity.setYokaigo2(Decimal.ZERO);
                一時Entity.setYokaigo3(Decimal.ZERO);
                一時Entity.setYokaigo4(Decimal.ZERO);
                一時Entity.setYokaigo5(Decimal.ZERO);
                一時Entity.setGokeichi(Decimal.ZERO);
                一時EntityList.add(一時Entity);
            }
        }
    }

    /**
     * setSyorikekkaCyouHyouEucCsvEntity
     *
     * @param entity entity
     * @return SyorikekkaCyouHyouEucCsvEntity SyorikekkaCyouHyouEucCsvEntity
     */
    public SyorikekkaCyouHyouEucCsvEntity setSyorikekkaCyouHyouEucCsvEntity(SyorikekkatempTblEntity entity) {
        SyorikekkaCyouHyouEucCsvEntity csvEntity = new SyorikekkaCyouHyouEucCsvEntity();
        if (count == 0) {
            count++;
            csvEntity.set作成日時(setDateFormat());
        }
        csvEntity.set処理名(entity.getErrorkubun());
        csvEntity.set被保険者番号(entity.getHiHokenshaNo());
        csvEntity.setキー１(new RString(entity.getKi1().toString()));
        csvEntity.setキー２(new RString(entity.getKi2().toString()));
        csvEntity.setエラー内容(entity.getErrornaiyo());
        csvEntity.set備考(entity.getBiko());
        return csvEntity;
    }

    private RString setDateFormat() {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        RDateTime printdate = RDateTime.now();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        return printTimeStampSb.toRString();
    }
}
