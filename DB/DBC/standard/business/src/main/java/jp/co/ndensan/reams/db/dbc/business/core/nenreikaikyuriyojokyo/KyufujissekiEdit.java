/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.nenreikaikyuriyojokyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.nenreikaikyuriyojokyo.SyorikekkaCyouHyouEucCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.SyorikekkatempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.TmpKyufujissekiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.TmpSyuturyokuYoRelateEntity;
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
 *
 * 給付実績集計データ取得、「給付実績データ一時TBL」に登録するEditクラスです。
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
public class KyufujissekiEdit {

    private static final RString 訪問通所計 = new RString("■訪問通所系サービス");
    private static final RString 短期入所系 = new RString("■短期入所系サービス");
    private static final RString 標準的居宅 = new RString("■標準的居宅サービス(訪問通所系サービス＋短期入所計サービス＋居宅療養管理指導)");
    private static final RString 居宅 = new RString("■居宅サービス計(標準的居宅サービス＋特定施設生活介護)");
    private static final RString 施設 = new RString("■施設サービス計");
    private static final RString 地域密着 = new RString("■地域密着サービス計");
    private static final RString 総合計 = new RString("■総合計");
    private static final RString 訪問介護 = new RString("(介護予防)訪問介護");
    private static final RString 訪問入浴介護 = new RString("(介護予防)訪問入浴介護");
    private static final RString 訪問看護 = new RString("(介護予防)訪問看護");
    private static final RString 訪問リハビリ = new RString("(介護予防)訪問リハビリ");
    private static final RString 通所介護 = new RString("(介護予防)通所介護");
    private static final RString 通所リハビリ = new RString("(介護予防)通所リハビリ");
    private static final RString 福祉用具貸与 = new RString("(介護予防)福祉用具貸与");
    private static final RString 短期入所生活介護 = new RString("(介護予防)短期入所生活介護");
    private static final RString 短期入所老健施設 = new RString("(介護予防)短期入所老健施設");
    private static final RString 短期入所医療施設 = new RString("(介護予防)短期入所医療施設");
    private static final RString 居宅療養管理指導 = new RString("(介護予防)居宅療養管理指導");
    private static final RString 特定施設生活介護 = new RString("(介護予防)特定施設生活介護(短期以外)");
    private static final RString 特定施設生活介護短期 = new RString("(介護予防)特定施設生活介護(短期)");
    private static final RString 夜間対応型訪問介護 = new RString("夜間対応型訪問介護");
    private static final RString 認知症対応型通所介護 = new RString("(介護予防)認知症対応型通所介護");
    private static final RString 小規模多機能型居宅介護 = new RString("(介護予防)小規模多機能型居宅介護(短期以外)");
    private static final RString 小規模多機能型居宅介護短期 = new RString("小規模多機能型居宅介護(短期)");
    private static final RString 認知症対応型共同生活 = new RString("(介護予防)認知症対応型共同生活");
    private static final RString 地域密着型短期以外 = new RString("地域密着型特定施設入居者生活（短期以外）");
    private static final RString 地域密着型短期 = new RString("地域密着型特定施設入居者生活（短期）");
    private static final RString 認知症対応型共同生活短期 = new RString("(介護予防)認知症対応型共同生活(短期)");
    private static final RString 随時対応型訪問介護看護 = new RString("定期巡回・随時対応型訪問介護看護");
    private static final RString 複合型サービス = new RString("看護小規模多機能型(短期以外)");
    private static final RString 看護小規模多機能型居宅介護短期 = new RString("看護小規模多機能型居宅介護(短期)");
    private static final RString 地域密着型通所介護 = new RString("地域密着型通所介護");
    private static final RString 地域密着型介護老人福祉施設 = new RString("地域密着型介護老人福祉施設");
    private static final RString 特定福祉用具販売費 = new RString("(介護予防)特定福祉用具販売費");
    private static final RString 住宅改修費 = new RString("(介護予防)住宅改修費");
    private static final RString 介護予防支援 = new RString("居宅介護支援・介護予防支援");
    private static final RString 介護福祉施設 = new RString("介護福祉施設");
    private static final RString 介護老健施設 = new RString("介護老健施設");
    private static final RString 介護医療施設 = new RString("介護医療施設");
    private static final RString 市町村特別給付 = new RString("市町村特別給付");
    private static final RString 特定入所者介護食費 = new RString("(介護予防)特定入所者介護サービス費(食費)");
    private static final RString 特定入所者介護居住費 = new RString("(介護予防)特定入所者介護サービス費(居住費)");
    private static final RString 年齢階級1 = new RString("40歳～49歳");
    private static final RString 年齢階級2 = new RString("50歳～59歳");
    private static final RString 年齢階級3 = new RString("60歳～64歳");
    private static final RString 年齢階級4 = new RString("２号計");
    private static final RString 年齢階級5 = new RString("65歳～69歳");
    private static final RString 年齢階級6 = new RString("70歳～74歳");
    private static final RString 年齢階級7 = new RString("75歳～79歳");
    private static final RString 年齢階級8 = new RString("80歳～84歳");
    private static final RString 年齢階級9 = new RString("85歳～89歳");
    private static final RString 年齢階級10 = new RString("90歳～94歳");
    private static final RString 年齢階級11 = new RString("95歳～99歳");
    private static final RString 年齢階級12 = new RString("100歳以上");
    private static final RString 年齢階級13 = new RString("１号計");
    private static final RString 年齢階級14 = new RString("総合計");
    private static final RString RSTRING_01 = new RString("01");
    private static final RString RSTRING_02 = new RString("02");
    private static final RString RSTRING_03 = new RString("03");
    private static final RString RSTRING_04 = new RString("04");
    private static final RString RSTRING_05 = new RString("05");
    private static final RString RSTRING_06 = new RString("06");
    private static final RString RSTRING_07 = new RString("07");
    private static final RString RSTRING_11 = new RString("11");
    private static final RString RSTRING_12 = new RString("12");
    private static final RString RSTRING_13 = new RString("13");
    private static final RString RSTRING_14 = new RString("14");
    private static final RString RSTRING_15 = new RString("15");
    private static final RString RSTRING_16 = new RString("16");
    private static final RString RSTRING_17 = new RString("17");
    private static final RString RSTRING_18 = new RString("18");
    private static final RString RSTRING_19 = new RString("19");
    private static final RString RSTRING_20 = new RString("20");
    private static final RString RSTRING_21 = new RString("21");
    private static final RString RSTRING_22 = new RString("22");
    private static final RString RSTRING_23 = new RString("23");
    private static final RString RSTRING_24 = new RString("24");
    private static final RString RSTRING_25 = new RString("25");
    private static final RString RSTRING_26 = new RString("26");
    private static final RString RSTRING_27 = new RString("27");
    private static final RString RSTRING_28 = new RString("28");
    private static final RString RSTRING_29 = new RString("29");
    private static final RString RSTRING_30 = new RString("30");
    private static final RString RSTRING_31 = new RString("31");
    private static final RString RSTRING_32 = new RString("32");
    private static final RString RSTRING_33 = new RString("33");
    private static final RString RSTRING_34 = new RString("34");
    private static final RString RSTRING_35 = new RString("35");
    private static final RString RSTRING_36 = new RString("36");
    private static final RString RSTRING_37 = new RString("37");
    private static final RString RSTRING_38 = new RString("38");
    private static final RString RSTRING_39 = new RString("39");
    private static final RString RSTRING_40 = new RString("40");
    private static final RString RSTRING_41 = new RString("41");
    private static final RString RSTRING_42 = new RString("42");
    private static final RString RSTRING_43 = new RString("43");
    private static final RString RSTRING_51 = new RString("51");
    private static final RString RSTRING_52 = new RString("52");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private boolean first = true;

    /**
     * editEntityメッソドです。
     *
     * @param entity NenreikaikyuRiyojokyoRelateEntity
     * @return TmpKyufujissekiRelateEntity
     */
    public TmpKyufujissekiRelateEntity editEntity(TmpKyufujissekiRelateEntity entity) {
        TmpKyufujissekiRelateEntity tmpEntity = new TmpKyufujissekiRelateEntity();
        RString serviceSyuruiCode = entity.getServiceSyuruiCode();
        tmpEntity.setHiHokenshaNo(entity.getHiHokenshaNo());
        tmpEntity.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        tmpEntity.setYoKaigoJotaiKubunCode(entity.getYoKaigoJotaiKubunCode());
        tmpEntity.setUmareYMD(entity.getUmareYMD());
        tmpEntity.setServiceSyuruiCode(serviceSyuruiCode);
        tmpEntity.setServiceKomokuCode(entity.getServiceKomokuCode());
        tmpEntity.setMeisho(entity.getMeisho());
        if (!RString.isNullOrEmpty(serviceSyuruiCode)) {
            set集計番号(serviceSyuruiCode, tmpEntity);
        }
        return tmpEntity;

    }

    private void set集計番号(RString serviceSyuruiCode, TmpKyufujissekiRelateEntity tmpEntity) {
        tmpEntity.setShuukeibangou(RSTRING_43);
        set集計番号1(serviceSyuruiCode, tmpEntity);
        set集計番号2(serviceSyuruiCode, tmpEntity);
        set集計番号3(serviceSyuruiCode, tmpEntity);
        set集計番号4(serviceSyuruiCode, tmpEntity);
    }

    private void set集計番号1(RString serviceSyuruiCode, TmpKyufujissekiRelateEntity tmpEntity) {
        if (ServiceCategoryShurui.訪問介護.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予訪介護.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_11);
        } else if (ServiceCategoryShurui.訪問入浴.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予訪入浴.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_12);
        } else if (ServiceCategoryShurui.訪問看護.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予訪看護.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_13);
        } else if (ServiceCategoryShurui.訪問リハ.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予訪リハ.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_14);
        } else if (ServiceCategoryShurui.通所介護.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予通介護.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_15);
        } else if (ServiceCategoryShurui.通所リハ.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予通リハ.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_16);
        } else if (ServiceCategoryShurui.用具貸与.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予用貸与.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_17);
        } else if (ServiceCategoryShurui.短期生活.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予短介護.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_18);
        } else if (ServiceCategoryShurui.短期老健.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予短老健.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_19);
        }
    }

    private void set集計番号2(RString serviceSyuruiCode, TmpKyufujissekiRelateEntity tmpEntity) {
        if (ServiceCategoryShurui.短期医療.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予短医療.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_20);
        } else if (ServiceCategoryShurui.療養指導.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予療養指.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_21);
        } else if (ServiceCategoryShurui.特施短外.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予特施設.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_22);
        } else if (ServiceCategoryShurui.特施短期.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_23);
        } else if (ServiceCategoryShurui.地夜間訪.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_24);
        } else if (ServiceCategoryShurui.地通所介.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.地予通所.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_25);
        } else if (ServiceCategoryShurui.地小短外.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.地予小外.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_26);
        } else if (ServiceCategoryShurui.地小規単.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.地予小短.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_27);
        }
    }

    private void set集計番号3(RString serviceSyuruiCode, TmpKyufujissekiRelateEntity tmpEntity) {
        if (ServiceCategoryShurui.地共同介.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.地予共同.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_28);
        } else if (ServiceCategoryShurui.地施短外.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_29);
        } else if (ServiceCategoryShurui.地施短期.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_30);
        } else if (ServiceCategoryShurui.地共同短.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.地予共短.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_31);
        } else if (ServiceCategoryShurui.定期随時.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_32);
        } else if (ServiceCategoryShurui.看小短外.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_33);
        } else if (ServiceCategoryShurui.看小規短.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_34);
        } else if (ServiceCategoryShurui.地域通所.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_35);
        } else if (ServiceCategoryShurui.地福祉生.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_36);
        }
    }

    private void set集計番号4(RString serviceSyuruiCode, TmpKyufujissekiRelateEntity tmpEntity) {
        if (ServiceCategoryShurui.用具販売.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予用販売.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_37);
        } else if (ServiceCategoryShurui.住宅改修.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予住改修.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_38);
        } else if (ServiceCategoryShurui.居宅支援.getコード().equals(serviceSyuruiCode) || ServiceCategoryShurui.予防支援.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_39);
        } else if (ServiceCategoryShurui.福祉施設.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_40);
        } else if (ServiceCategoryShurui.老健施設.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_41);
        } else if (ServiceCategoryShurui.医療施設.getコード().equals(serviceSyuruiCode)) {
            tmpEntity.setShuukeibangou(RSTRING_42);
        }
    }

    /**
     * set出力用一時TBL
     *
     * @return List<TmpSyuturyokuYoRelateEntity>
     */
    public List<TmpSyuturyokuYoRelateEntity> set出力用一時TBL() {
        List<TmpSyuturyokuYoRelateEntity> 一時EntityList = new ArrayList<>();
        List<RString> nenreiKaikyuList = new ArrayList<>();
        nenreiKaikyuList.add(年齢階級1);
        nenreiKaikyuList.add(年齢階級2);
        nenreiKaikyuList.add(年齢階級3);
        nenreiKaikyuList.add(年齢階級4);
        nenreiKaikyuList.add(年齢階級5);
        nenreiKaikyuList.add(年齢階級6);
        nenreiKaikyuList.add(年齢階級7);
        nenreiKaikyuList.add(年齢階級8);
        nenreiKaikyuList.add(年齢階級9);
        nenreiKaikyuList.add(年齢階級10);
        nenreiKaikyuList.add(年齢階級11);
        nenreiKaikyuList.add(年齢階級12);
        nenreiKaikyuList.add(年齢階級13);
        nenreiKaikyuList.add(年齢階級14);
        List<RString> serviceshuruiList = new ArrayList<>();
        serviceshuruiList.add(訪問通所計);
        serviceshuruiList.add(短期入所系);
        serviceshuruiList.add(標準的居宅);
        serviceshuruiList.add(居宅);
        serviceshuruiList.add(施設);
        serviceshuruiList.add(地域密着);
        serviceshuruiList.add(総合計);
        serviceshuruiList.add(訪問介護);
        serviceshuruiList.add(訪問入浴介護);
        serviceshuruiList.add(訪問看護);
        serviceshuruiList.add(訪問リハビリ);
        serviceshuruiList.add(通所介護);
        serviceshuruiList.add(通所リハビリ);
        serviceshuruiList.add(福祉用具貸与);
        serviceshuruiList.add(短期入所生活介護);
        serviceshuruiList.add(短期入所老健施設);
        serviceshuruiList.add(短期入所医療施設);
        serviceshuruiList.add(居宅療養管理指導);
        serviceshuruiList.add(特定施設生活介護);
        serviceshuruiList.add(特定施設生活介護短期);
        serviceshuruiList.add(夜間対応型訪問介護);
        serviceshuruiList.add(認知症対応型通所介護);
        serviceshuruiList.add(小規模多機能型居宅介護);
        serviceshuruiList.add(小規模多機能型居宅介護短期);
        serviceshuruiList.add(認知症対応型共同生活);
        serviceshuruiList.add(地域密着型短期以外);
        serviceshuruiList.add(地域密着型短期);
        serviceshuruiList.add(認知症対応型共同生活短期);
        serviceshuruiList.add(随時対応型訪問介護看護);
        serviceshuruiList.add(複合型サービス);
        serviceshuruiList.add(看護小規模多機能型居宅介護短期);
        serviceshuruiList.add(地域密着型通所介護);
        serviceshuruiList.add(地域密着型介護老人福祉施設);
        serviceshuruiList.add(特定福祉用具販売費);
        serviceshuruiList.add(住宅改修費);
        serviceshuruiList.add(介護予防支援);
        serviceshuruiList.add(介護福祉施設);
        serviceshuruiList.add(介護老健施設);
        serviceshuruiList.add(介護医療施設);
        serviceshuruiList.add(市町村特別給付);
        serviceshuruiList.add(特定入所者介護食費);
        serviceshuruiList.add(特定入所者介護居住費);
        for (int i = 0; i < serviceshuruiList.size(); i++) {
            set一時Entity(一時EntityList, nenreiKaikyuList, i, serviceshuruiList);
        }
        return 一時EntityList;
    }

    private void set一時Entity(List<TmpSyuturyokuYoRelateEntity> 一時EntityList,
            List<RString> nenreiKaikyuList, int i, List<RString> serviceshuruiList) {
        for (int j = 0; j < nenreiKaikyuList.size(); j++) {
            TmpSyuturyokuYoRelateEntity 一時Entity = new TmpSyuturyokuYoRelateEntity();
            RString サービス種類コード名 = serviceshuruiList.get(i);
            一時Entity.setServiceSyuruiCodeMei(サービス種類コード名);
            一時Entity.setHiGaitou(Decimal.ZERO);
            一時Entity.setYoSien1(Decimal.ZERO);
            一時Entity.setYoSien2(Decimal.ZERO);
            一時Entity.setKeikatekiYoSien(Decimal.ZERO);
            一時Entity.setYouKaigo1(Decimal.ZERO);
            一時Entity.setYouKaigo2(Decimal.ZERO);
            一時Entity.setYouKaigo3(Decimal.ZERO);
            一時Entity.setYouKaigo4(Decimal.ZERO);
            一時Entity.setYouKaigo5(Decimal.ZERO);
            一時Entity.setGoikei(Decimal.ZERO);
            一時Entity.setBikou(RString.EMPTY);
            一時Entity.setKubun(nenreiKaikyuList.get(j));
            set集番1(サービス種類コード名, 一時Entity);
            set集番2(サービス種類コード名, 一時Entity);
            set集番3(サービス種類コード名, 一時Entity);
            一時Entity.setNenrenCd(j + 1);
            一時EntityList.add(一時Entity);
        }
    }

    private void set集番1(RString サービス種類コード名, TmpSyuturyokuYoRelateEntity 一時Entity) {
        if (訪問通所計.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_01);
        } else if (短期入所系.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_02);
        } else if (標準的居宅.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_03);
        } else if (居宅.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_04);
        } else if (施設.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_05);
        } else if (地域密着.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_06);
        } else if (総合計.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_07);
        } else if (訪問介護.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_11);
        } else if (訪問入浴介護.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_12);
        } else if (訪問看護.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_13);
        } else if (訪問リハビリ.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_14);
        } else if (通所介護.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_15);
        } else if (通所リハビリ.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_16);
        } else if (福祉用具貸与.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_17);
        }
    }

    private void set集番2(RString サービス種類コード名, TmpSyuturyokuYoRelateEntity 一時Entity) {
        if (短期入所生活介護.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_18);
        } else if (短期入所老健施設.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_19);
        } else if (短期入所医療施設.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_20);
        } else if (居宅療養管理指導.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_21);
        } else if (特定施設生活介護.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_22);
        } else if (特定施設生活介護短期.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_23);
        } else if (夜間対応型訪問介護.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_24);
        } else if (認知症対応型通所介護.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_25);
        } else if (小規模多機能型居宅介護.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_26);
        } else if (小規模多機能型居宅介護短期.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_27);
        } else if (認知症対応型共同生活.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_28);
        } else if (地域密着型短期以外.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_29);
        } else if (地域密着型短期.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_30);
        } else if (認知症対応型共同生活短期.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_31);
        }
    }

    private void set集番3(RString サービス種類コード名, TmpSyuturyokuYoRelateEntity 一時Entity) {
        if (随時対応型訪問介護看護.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_32);
        } else if (複合型サービス.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_33);
        } else if (看護小規模多機能型居宅介護短期.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_34);
        } else if (地域密着型通所介護.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_35);
        } else if (地域密着型介護老人福祉施設.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_36);
        } else if (特定福祉用具販売費.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_37);
        } else if (住宅改修費.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_38);
        } else if (介護予防支援.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_39);
        } else if (介護福祉施設.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_40);
        } else if (介護老健施設.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_41);
        } else if (介護医療施設.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_42);
        } else if (市町村特別給付.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_43);
        } else if (特定入所者介護食費.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_51);
        } else if (特定入所者介護居住費.equals(サービス種類コード名)) {
            一時Entity.setShuukeiBangouCd(RSTRING_52);
        }
    }

    /**
     * ファイル出力(処理結果確認リスト)です
     *
     * @param entity SyorikekkatempTblEntity
     * @return SyorikekkaCyouHyouEucCsvEntity
     */
    public SyorikekkaCyouHyouEucCsvEntity setCsvEntity(SyorikekkatempTblEntity entity) {
        SyorikekkaCyouHyouEucCsvEntity csvEntity = new SyorikekkaCyouHyouEucCsvEntity();
        if (first) {
            first = false;
            csvEntity.set作成日時(setDateFormat(RDateTime.now()));
        }
        csvEntity.set処理名(entity.getShoriMei());
        csvEntity.set証記載保険者番号(RString.EMPTY);
        csvEntity.set被保険者番号(entity.getHiHokenshaNo());
        csvEntity.set被保険者氏名(entity.getHiHokenshaKana());
        csvEntity.setサービス提供年月(entity.getServiceTeikyoYM().toDateString());
        csvEntity.set事業者番号(RString.EMPTY);
        csvEntity.set入力識別番号(RString.EMPTY);
        csvEntity.set通し番号(RString.EMPTY);
        csvEntity.setサービス種類コード(RString.EMPTY);
        csvEntity.setエラー内容(entity.getErrorMsg());
        csvEntity.set備考(entity.getBikou());
        return csvEntity;

    }

    private RString setDateFormat(RDateTime printdate) {
        RStringBuilder printTimeStampSb = new RStringBuilder();
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
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append("作成");

        return printTimeStampSb.toRString();
    }
}
