/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chkichijihanteikekka;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyoa4.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyo.ServiceJokyo02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyo.ServiceJokyo06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyo.ServiceJokyo09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyo.ServiceJokyo09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyo.ServiceJokyo99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser21;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.IsJutakuKaishu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 一次判定結果の作成クラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
public final class ChkIchijiHanteiKekkaBusiness {

    private static final RString 識別コード09B = new RString("09B");
    private static final RString 識別コード06A = new RString("06A");
    private static final RString 識別コード02A = new RString("02A");
    private static final RString 識別コード09A = new RString("09A");
    private static final RString 識別コード99A = new RString("99A");
    private static final RString 印刷する = new RString("1");
    private static final RString 印刷しない = new RString("2");
    private static final RString 差分のみ印刷 = new RString("3");
    private static final RString 特記事項番号_101 = new RString("101");
    private static final RString 特記事項番号_102 = new RString("102");
    private static final RString 特記事項番号_103 = new RString("103");
    private static final RString 特記事項番号_104 = new RString("104");
    private static final RString 特記事項番号_105 = new RString("105");
    private static final RString 特記事項番号_106 = new RString("106");
    private static final RString 特記事項番号_107 = new RString("107");
    private static final RString 特記事項番号_108 = new RString("108");
    private static final RString 特記事項番号_109 = new RString("109");
    private static final RString 特記事項番号_110 = new RString("110");
    private static final RString 特記事項番号_111 = new RString("111");
    private static final RString 特記事項番号_112 = new RString("112");
    private static final RString 特記事項番号_113 = new RString("113");
    private static final RString 特記事項番号_201 = new RString("201");
    private static final RString 特記事項番号_202 = new RString("202");
    private static final RString 特記事項番号_203 = new RString("203");
    private static final RString 特記事項番号_204 = new RString("204");
    private static final RString 特記事項番号_205 = new RString("205");
    private static final RString 特記事項番号_206 = new RString("206");
    private static final RString 特記事項番号_207 = new RString("207");
    private static final RString 特記事項番号_208 = new RString("208");
    private static final RString 特記事項番号_209 = new RString("209");
    private static final RString 特記事項番号_210 = new RString("210");
    private static final RString 特記事項番号_211 = new RString("211");
    private static final RString 特記事項番号_212 = new RString("212");
    private static final RString 特記事項番号_301 = new RString("301");
    private static final RString 特記事項番号_302 = new RString("302");
    private static final RString 特記事項番号_303 = new RString("303");
    private static final RString 特記事項番号_304 = new RString("304");
    private static final RString 特記事項番号_305 = new RString("305");
    private static final RString 特記事項番号_306 = new RString("306");
    private static final RString 特記事項番号_307 = new RString("307");
    private static final RString 特記事項番号_308 = new RString("308");
    private static final RString 特記事項番号_309 = new RString("309");
    private static final RString 特記事項番号_401 = new RString("401");
    private static final RString 特記事項番号_402 = new RString("402");
    private static final RString 特記事項番号_403 = new RString("403");
    private static final RString 特記事項番号_404 = new RString("404");
    private static final RString 特記事項番号_405 = new RString("405");
    private static final RString 特記事項番号_406 = new RString("406");
    private static final RString 特記事項番号_407 = new RString("407");
    private static final RString 特記事項番号_408 = new RString("408");
    private static final RString 特記事項番号_409 = new RString("409");
    private static final RString 特記事項番号_410 = new RString("410");
    private static final RString 特記事項番号_411 = new RString("411");
    private static final RString 特記事項番号_412 = new RString("412");
    private static final RString 特記事項番号_413 = new RString("413");
    private static final RString 特記事項番号_414 = new RString("414");
    private static final RString 特記事項番号_415 = new RString("415");
    private static final RString 特記事項番号_501 = new RString("501");
    private static final RString 特記事項番号_502 = new RString("502");
    private static final RString 特記事項番号_503 = new RString("503");
    private static final RString 特記事項番号_504 = new RString("504");
    private static final RString 特記事項番号_505 = new RString("505");
    private static final RString 特記事項番号_506 = new RString("506");
    private static final RString 特記事項番号_507 = new RString("507");
    private static final RString 特記事項番号_510 = new RString("510");
    private static final RString 特記事項番号_511 = new RString("511");
    private static final RString 特記事項番号_512 = new RString("512");
    private static final RString 特記事項番号_601 = new RString("601");
    private static final RString 特記事項番号_602 = new RString("602");
    private static final RString 特記事項番号_603 = new RString("603");
    private static final RString 特記事項番号_604 = new RString("604");
    private static final RString 特記事項番号_605 = new RString("605");
    private static final RString 特記事項番号_606 = new RString("606");
    private static final RString 特記事項番号_607 = new RString("607");
    private static final RString 特記事項番号_608 = new RString("608");
    private static final RString 特記事項番号_609 = new RString("609");
    private static final RString 特記事項番号_610 = new RString("610");
    private static final RString 特記事項番号_611 = new RString("611");
    private static final RString 特記事項番号_612 = new RString("612");
    private static final RString 特記事項番号_801 = new RString("801");
    private static final RString 特記事項番号_802 = new RString("802");
    private static final RString 特記事項番号_803 = new RString("803");
    private static final RString 特記事項番号_804 = new RString("804");
    private static final RString 特記事項番号_805 = new RString("805");
    private static final RString 特記事項番号_806 = new RString("806");
    private static final RString 特記事項番号_807 = new RString("807");
    private static final RString 特記事項番号_808 = new RString("808");
    private static final RString 特記事項番号_809 = new RString("809");
    private static final RString 特記事項番号_810 = new RString("810");
    private static final RString 特記事項番号_811 = new RString("811");
    private static final RString 特記事項番号_812 = new RString("812");
    private static final RString 特記事項番号_701 = new RString("701");
    private static final RString 特記事項番号_702 = new RString("702");
    private static final RString 特記事項番号_901 = new RString("901");
    private static final RString 特記事項番号_902 = new RString("902");
    private static final RString 特記事項番号_704 = new RString("704");
    private static final RString 特記事項番号_705 = new RString("705");
    private static final RString 特記事項番号_707 = new RString("707");
    private static final RString 特記事項番号_708 = new RString("708");
    private static final RString 特記事項番号_709 = new RString("709");
    private static final RString 特記事項番号_710 = new RString("710");
    private static final RString 特記事項番号_711 = new RString("711");
    private static final RString 特記事項番号_712 = new RString("712");
    private static final RString 特記事項番号_713 = new RString("713");
    private static final RString 特記事項番号_714 = new RString("714");
    private static final RString 特記事項番号_716 = new RString("716");
    private static final RString 特記事項番号_719 = new RString("719");
    private static final RString 特記事項番号_1002 = new RString("1002");
    private static final RString 特記事項番号_5011 = new RString("5011");
    private static final RString 特記事項番号_5012 = new RString("5012");
    private static final RString 特記事項番号_5013 = new RString("5013");
    private static final RString 特記事項番号_5014 = new RString("5014");
    private static final RString 特記事項番号_5021 = new RString("5021");
    private static final RString 特記事項番号_5022 = new RString("5022");
    private static final RString 特記事項番号_6051 = new RString("6051");
    private static final RString 特記事項番号_6052 = new RString("6052");
    private static final RString 特記事項番号_6053 = new RString("6053");
    private static final RString 特記事項番号_6054 = new RString("6054");
    private static final RString 特記事項番号_6055 = new RString("6055");
    private static final RString 特記事項番号_6056 = new RString("6056");
    private static final int 連番1 = 1;
    private static final int 連番2 = 2;
    private static final int 連番3 = 3;
    private static final int 連番4 = 4;
    private static final int 連番5 = 5;
    private static final int 連番6 = 6;
    private static final int 連番7 = 7;
    private static final int 連番8 = 8;
    private static final int 連番9 = 9;
    private static final int 連番10 = 10;
    private static final int 連番11 = 11;
    private static final int 連番12 = 12;
    private static final int 連番13 = 13;
    private static final int 連番14 = 14;
    private static final int 連番15 = 15;
    private static final int 連番16 = 16;
    private static final int 連番17 = 17;
    private static final int 連番18 = 18;
    private static final int 連番19 = 19;
    private static final int 連番20 = 20;
    private static final int 連番21 = 21;
    private static final int 連番31 = 31;
    private static final int 連番32 = 32;
    private static final int 連番33 = 33;
    private static final int 連番34 = 34;
    private static final int 連番35 = 35;
    private static final int 連番36 = 36;
    private static final int 連番37 = 37;
    private static final int 連番38 = 38;
    private static final int 連番39 = 39;
    private static final int 連番40 = 40;
    private static final int 連番42 = 42;
    private static final int 連番43 = 43;
    private static final int 連番44 = 44;
    private static final int 連番45 = 45;
    private static final int 連番46 = 46;
    private static final int 連番47 = 47;
    private static final int 連番48 = 48;
    private static final int 連番49 = 49;
    private static final int 連番50 = 50;
    private static final int 連番51 = 51;
    private static final int 連番52 = 52;
    private static final int 連番53 = 53;
    private static final int 連番57 = 57;
    private static final int 連番59 = 59;
    private static final int 連番63 = 63;
    private static final int 連番65 = 65;
    private static final int 連番68 = 68;

    private ChkIchijiHanteiKekkaBusiness() {
    }

    /**
     * 意見書認知症を設定します。
     *
     * @param dbt5304Entity 意見書項目
     * @param bodyItem 一次判定結果Entity
     * @return 意見書認知症
     */
    public static RString set意見書認知症(List<DbT5304ShujiiIkenshoIkenItemEntity> dbt5304Entity,
            IchijihanteikekkahyoEntity bodyItem) {
        RString 意見書認知症 = RString.EMPTY;
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())
                || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            意見書認知症 = get意見書名称03(dbt5304Entity, 連番13);
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            意見書認知症 = get意見書名称03(dbt5304Entity, 連番14);
        }
        return 意見書認知症;
    }

    /**
     * 身体機能起居動作1リストを設定します。
     *
     * @param dbt5211Entity 調査項目
     * @param bodyItem 一次判定結果Entity
     * @return 身体機能起居動作1リスト
     */
    public static List<RString> set身体機能_起居動作1リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity,
            IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 身体機能_起居動作1リスト = new ArrayList<>();
        身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 0));
        身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番1));
        身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番2));
        身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番3));
        身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番4));
        身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番5));
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番6));
            身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番7));
            身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番8));
            身体機能_起居動作1リスト.add(get名称02(dbt5211Entity, 連番9));
            身体機能_起居動作1リスト.add(get名称02(dbt5211Entity, 連番10));
            身体機能_起居動作1リスト.add(get名称03(dbt5211Entity, 連番11));
            身体機能_起居動作1リスト.add(get名称04(dbt5211Entity, 連番12));
            身体機能_起居動作1リスト.add(get名称02(dbt5211Entity, 連番13));
            身体機能_起居動作1リスト.add(get名称02(dbt5211Entity, 連番14));
            身体機能_起居動作1リスト.add(get名称04(dbt5211Entity, 連番15));
            身体機能_起居動作1リスト.add(get名称06(dbt5211Entity, 連番16));
            身体機能_起居動作1リスト.add(get名称07(dbt5211Entity, 連番17));
            身体機能_起居動作1リスト.add(get名称08(dbt5211Entity, 連番18));
            身体機能_起居動作1リスト.add(get名称09(dbt5211Entity, 連番19));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番7));
            身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番8));
            身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番10));
            身体機能_起居動作1リスト.add(get名称02(dbt5211Entity, 連番11));
            身体機能_起居動作1リスト.add(get名称02(dbt5211Entity, 連番12));
            身体機能_起居動作1リスト.add(get名称03(dbt5211Entity, 連番13));
            身体機能_起居動作1リスト.add(get名称04(dbt5211Entity, 連番14));
            身体機能_起居動作1リスト.add(get名称02(dbt5211Entity, 連番15));
            身体機能_起居動作1リスト.add(get名称02(dbt5211Entity, 連番18));
            身体機能_起居動作1リスト.add(get名称04(dbt5211Entity, 連番19));
            身体機能_起居動作1リスト.add(get名称21(dbt5211Entity, 連番20));
            身体機能_起居動作1リスト.add(get名称22(dbt5211Entity, 連番31));
            身体機能_起居動作1リスト.add(get名称08(dbt5211Entity, 連番38));
            身体機能_起居動作1リスト.add(get名称09(dbt5211Entity, 連番39));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番7));
            身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番8));
            身体機能_起居動作1リスト.add(get名称01(dbt5211Entity, 連番10));
            身体機能_起居動作1リスト.add(get名称02(dbt5211Entity, 連番11));
            身体機能_起居動作1リスト.add(get名称02(dbt5211Entity, 連番12));
            身体機能_起居動作1リスト.add(get名称03(dbt5211Entity, 連番13));
            身体機能_起居動作1リスト.add(get名称04(dbt5211Entity, 連番15));
            身体機能_起居動作1リスト.add(get名称02(dbt5211Entity, 連番16));
            身体機能_起居動作1リスト.add(get名称02(dbt5211Entity, 連番18));
            身体機能_起居動作1リスト.add(get名称04(dbt5211Entity, 連番19));
            身体機能_起居動作1リスト.add(get名称21(dbt5211Entity, 連番21));
            身体機能_起居動作1リスト.add(get名称22(dbt5211Entity, 連番34));
            身体機能_起居動作1リスト.add(get名称08(dbt5211Entity, 連番44));
            身体機能_起居動作1リスト.add(get名称09(dbt5211Entity, 連番45));
        }
        return 身体機能_起居動作1リスト;
    }

    /**
     * 認知機能4リストを設定します。
     *
     * @param dbt5211Entity 調査項目
     * @param 前回調査項目 前回調査項目
     * @param bodyItem 一次判定結果Entity
     * @return 認知機能4リスト
     */
    public static List<RString> set認知機能4リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            return 認知機能(dbt5211Entity, 前回調査項目, bodyItem);
        }
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
                認知機能4リスト.add(get名称14(dbt5211Entity, 連番32));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番33));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番34));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番35));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番36));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番37));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番38));
                認知機能4リスト.add(get名称16(dbt5211Entity, 連番39));
                認知機能4リスト.add(get名称16(dbt5211Entity, 連番40));
            }
            if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
                認知機能4リスト.add(get名称14(dbt5211Entity, 連番40));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番42));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番43));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番44));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番45));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番46));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番47));
                認知機能4リスト.add(get名称16(dbt5211Entity, 連番57));
                認知機能4リスト.add(get名称16(dbt5211Entity, 連番59));
            }
            if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
                認知機能4リスト.add(get名称14(dbt5211Entity, 連番46));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番48));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番49));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番50));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番51));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番52));
                認知機能4リスト.add(get名称15(dbt5211Entity, 連番53));
                認知機能4リスト.add(get名称16(dbt5211Entity, 連番63));
                認知機能4リスト.add(get名称16(dbt5211Entity, 連番65));
            }
        }
        return 認知機能4リスト;
    }

    /**
     * 認知機能3リストを設定します。
     *
     * @param 調査項目 調査項目
     * @param 前回調査項目 前回調査項目
     * @param bodyItem 一次判定結果Entity
     * @return 認知機能3リスト
     */
    public static List<RString> set認知機能3リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 認知機能3リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番32));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番33));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番34));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番35));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番36));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番37));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番38));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番39));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番40));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番40));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番42));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番43));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番44));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番45));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番46));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番47));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番57));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番59));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番46));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番48));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番49));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番50));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番51));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番52));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番53));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番63));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番65));
        }
        return 認知機能3リスト;
    }

    /**
     * 認知機能2リストを設定します。
     *
     * @param 調査項目 調査項目
     * @param 前回調査項目 前回調査項目
     * @param bodyItem 一次判定結果Entity
     * @return 認知機能2リスト
     */
    public static List<RString> set認知機能2リスト(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 認知機能2リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番32));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番33));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番34));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番35));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番36));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番37));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番38));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番39));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番40));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番40));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番42));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番43));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番44));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番45));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番46));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番47));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番57));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番59));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番46));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番48));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番49));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番50));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番51));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番52));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番53));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番63));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番65));
        }
        return 認知機能2リスト;
    }

    /**
     * 認知機能1リストを設定します。
     *
     * @param dbt5211Entity 調査項目
     * @param bodyItem 一次判定結果Entity
     * @return 認知機能1リスト
     */
    public static List<RString> set認知機能1リスト(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity,
            IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 認知機能1リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            認知機能1リスト.add(get名称14(dbt5211Entity, 連番32));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番33));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番34));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番35));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番36));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番37));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番38));
            認知機能1リスト.add(get名称16(dbt5211Entity, 連番39));
            認知機能1リスト.add(get名称16(dbt5211Entity, 連番40));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            認知機能1リスト.add(get名称14(dbt5211Entity, 連番40));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番42));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番43));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番44));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番45));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番46));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番47));
            認知機能1リスト.add(get名称16(dbt5211Entity, 連番57));
            認知機能1リスト.add(get名称16(dbt5211Entity, 連番59));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            認知機能1リスト.add(get名称14(dbt5211Entity, 連番46));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番48));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番49));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番50));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番51));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番52));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番53));
            認知機能1リスト.add(get名称16(dbt5211Entity, 連番63));
            認知機能1リスト.add(get名称16(dbt5211Entity, 連番65));
        }
        return 認知機能1リスト;
    }

    /**
     * 主治医意見書項目3リストを設定します。
     *
     * @param 意見書項目 意見書項目
     * @param 前回意見書項目 前回意見書項目
     * @param bodyItem 一次判定結果Entity
     * @return 主治医意見書項目3リスト
     */
    public static List<RString> set主治医意見書項目3リスト(List<DbT5304ShujiiIkenshoIkenItemEntity> 意見書項目,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前回意見書項目, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 主治医意見書項目3リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())
                || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番13));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番14));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番15));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番16));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番68));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番14));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番15));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番16));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番17));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番18));
        }
        return 主治医意見書項目3リスト;
    }

    /**
     * 主治医意見書項目4リストを設定します。
     *
     * @param 意見書項目 意見書項目
     * @param dbt5304Entity 前回意見書項目
     * @param bodyItem 一次判定結果Entity
     * @return 主治医意見書項目4リスト
     */
    public static List<RString> set主治医意見書項目4リスト(List<DbT5304ShujiiIkenshoIkenItemEntity> 意見書項目,
            List<DbT5304ShujiiIkenshoIkenItemEntity> dbt5304Entity, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 主治医意見書項目4リスト = new ArrayList<>();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            return 主治医差分(意見書項目, dbt5304Entity, bodyItem);
        }
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())
                    || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
                主治医意見書項目4リスト.add(get意見書名称03(dbt5304Entity, 連番13));
                主治医意見書項目4リスト.add(get意見書名称04(dbt5304Entity, 連番14));
                主治医意見書項目4リスト.add(get意見書名称05(dbt5304Entity, 連番15));
                主治医意見書項目4リスト.add(get意見書名称06(dbt5304Entity, 連番16));
                主治医意見書項目4リスト.add(get意見書名称14(dbt5304Entity, 連番68));
            }
            if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
                主治医意見書項目4リスト.add(get意見書名称03(dbt5304Entity, 連番14));
                主治医意見書項目4リスト.add(get意見書名称04(dbt5304Entity, 連番15));
                主治医意見書項目4リスト.add(get意見書名称05(dbt5304Entity, 連番16));
                主治医意見書項目4リスト.add(get意見書名称06(dbt5304Entity, 連番17));
                主治医意見書項目4リスト.add(get意見書名称14(dbt5304Entity, 連番18));
            }
        }
        return 主治医意見書項目4リスト;
    }

    /**
     * 主治医意見書項目2リストを設定します。
     *
     * @param 意見書項目 意見書項目
     * @param 前回意見書項目 前回意見書項目
     * @param bodyItem 一次判定結果Entity
     * @return 主治医意見書項目2リスト
     */
    public static List<RString> set主治医意見書項目2リスト(List<DbT5304ShujiiIkenshoIkenItemEntity> 意見書項目,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前回意見書項目, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 主治医意見書項目2リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())
                || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番13));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番14));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番15));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番16));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番68));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番14));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番15));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番16));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番17));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番18));
        }
        return 主治医意見書項目2リスト;
    }

    /**
     * 主治医意見書項目2リストを設定します。
     *
     * @param dbt5304Entity 意見書項目
     * @param bodyItem 一次判定結果Entity
     * @return 主治医意見書項目2リスト
     */
    public static List<RString> set主治医意見書項目1リスト(List<DbT5304ShujiiIkenshoIkenItemEntity> dbt5304Entity,
            IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 主治医意見書項目1リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())
                || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            主治医意見書項目1リスト.add(get意見書名称03(dbt5304Entity, 連番13));
            主治医意見書項目1リスト.add(get意見書名称04(dbt5304Entity, 連番14));
            主治医意見書項目1リスト.add(get意見書名称05(dbt5304Entity, 連番15));
            主治医意見書項目1リスト.add(get意見書名称06(dbt5304Entity, 連番16));
            主治医意見書項目1リスト.add(get意見書名称14(dbt5304Entity, 連番68));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            主治医意見書項目1リスト.add(get意見書名称03(dbt5304Entity, 連番14));
            主治医意見書項目1リスト.add(get意見書名称04(dbt5304Entity, 連番15));
            主治医意見書項目1リスト.add(get意見書名称05(dbt5304Entity, 連番16));
            主治医意見書項目1リスト.add(get意見書名称06(dbt5304Entity, 連番17));
            主治医意見書項目1リスト.add(get意見書名称14(dbt5304Entity, 連番18));
        }
        return 主治医意見書項目1リスト;
    }

    /**
     * 日常生活自立度リストを設定します。
     *
     * @param list 特記事項番号
     * @param bodyItem 一次判定結果Entity
     * @return 日常生活自立度リスト
     */
    public static List<RString> set日常生活自立度リスト(List<RString> list, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 日常生活自立度リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            日常生活自立度リスト.add(get特記事項有無(list, 特記事項番号_701));
            日常生活自立度リスト.add(get特記事項有無(list, 特記事項番号_702));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード99A.equals(bodyItem.get厚労省IF識別コード())
                || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            日常生活自立度リスト.add(get特記事項有無(list, 特記事項番号_901));
            日常生活自立度リスト.add(get特記事項有無(list, 特記事項番号_902));
        }
        return 日常生活自立度リスト;
    }

    /**
     * 特別な医療2リストを設定します。
     *
     * @param list 特記事項番号
     * @param bodyItem 一次判定結果Entity
     * @return 特別な医療2リスト
     */
    public static List<RString> set特別な医療2リスト(List<RString> list, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 特別な医療2リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_607));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_608));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_609));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_610));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_611));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_612));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード99A.equals(bodyItem.get厚労省IF識別コード())
                || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_807));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_808));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_809));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_810));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_811));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_812));
        }
        return 特別な医療2リスト;
    }

    /**
     * 特別な医療1リストを設定します。
     *
     * @param list 特記事項番号
     * @param bodyItem 一次判定結果Entity
     * @return 特別な医療1リスト
     */
    public static List<RString> set特別な医療1リスト(List<RString> list, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 特別な医療1リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_601));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_602));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_603));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_604));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_605));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_606));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード99A.equals(bodyItem.get厚労省IF識別コード())
                || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_801));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_802));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_803));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_804));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_805));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_806));
        }
        return 特別な医療1リスト;
    }

    /**
     * 社会生活への適応リストを設定します。
     *
     * @param list 特記事項番号
     * @param bodyItem 一次判定結果Entity
     * @return 社会生活への適応リスト
     */
    public static List<RString> set社会生活への適応リスト(List<RString> list, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 社会生活への適応リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_501));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_502));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_503));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_504));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_505));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_506));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_503));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_504));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_506));
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_510));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_511));
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
        }
        return 社会生活への適応リスト;
    }

    /**
     * 精神行動障害リストを設定します。
     *
     * @param list 特記事項番号
     * @param bodyItem 一次判定結果Entity
     * @return 精神行動障害リスト
     */
    public static List<RString> set精神_行動障害リスト(List<RString> list, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 精神_行動障害リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_401));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_402));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_403));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_404));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_405));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_406));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_407));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_408));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_409));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_410));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_411));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_412));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_413));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_414));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_415));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_701));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_702));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_704));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_705));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_707));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_708));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_709));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_711));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_713));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_714));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_716));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_719));
            精神_行動障害リスト.add(RString.EMPTY);
            精神_行動障害リスト.add(RString.EMPTY);
            精神_行動障害リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_701));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_702));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_704));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_705));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_707));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_708));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_709));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_711));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_713));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_714));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_716));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_512));
            精神_行動障害リスト.add(RString.EMPTY);
            精神_行動障害リスト.add(RString.EMPTY);
            精神_行動障害リスト.add(RString.EMPTY);
        }
        return 精神_行動障害リスト;
    }

    /**
     * 認知機能リストを設定します。
     *
     * @param list 特記事項番号
     * @param bodyItem 一次判定結果Entity
     * @return 認知機能リスト
     */
    public static List<RString> set認知機能リスト(List<RString> list, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 認知機能リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_301));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_302));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_303));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_304));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_305));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_306));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_307));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_308));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_309));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード99A.equals(bodyItem.get厚労省IF識別コード())
                || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_603));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6051));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6052));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6053));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6054));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6055));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6056));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_710));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_712));
        }
        return 認知機能リスト;
    }

    /**
     * 生活機能リストを設定します。
     *
     * @param list 特記事項番号
     * @param bodyItem 一次判定結果Entity
     * @return 生活機能リスト
     */
    public static List<RString> set生活機能リスト(List<RString> list, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 生活機能リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_201));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_202));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_203));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_204));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_205));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_206));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_207));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_208));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_209));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_210));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_211));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_212));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_206));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_207));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_402));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_403));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_405));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_406));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5011));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5012));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5013));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5021));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5022));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_1002));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_206));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_207));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_402));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_403));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_405));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_406));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5011));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5012));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5013));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5021));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5022));
            生活機能リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_207));
            生活機能リスト.add(RString.EMPTY);
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_404));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_409));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_405));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_406));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_501));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_502));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_503));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_506));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_507));
            生活機能リスト.add(RString.EMPTY);
        }
        return 生活機能リスト;
    }

    /**
     * 身体機能起居動作リストを設定します。
     *
     * @param list 特記事項番号
     * @param bodyItem 一次判定結果Entity
     * @return 身体機能起居動作リスト
     */
    public static List<RString> set身体機能_起居動作リスト(List<RString> list, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 身体機能_起居動作リスト = new ArrayList<>();
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101));
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101));
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101));
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101));
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101));
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_102));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_102));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_102));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_102));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_103));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_104));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_105));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_106));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_107));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_108));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_109));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_110));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_111));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_112));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_113));
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_201));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_202));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_203));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_204));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_205));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_301));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_302));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_303));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_5014));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_601));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_602));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_201));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_202));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_203));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_204));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_205));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_301));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_302));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_303));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_504));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_601));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_602));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_201));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_202));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_203));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_205));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_206));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_301));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_302));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_304));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_504));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_601));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_602));
        }
        return 身体機能_起居動作リスト;
    }

    /**
     * サービス状況を設定します。
     *
     * @param dbt5207Entity サービス状況
     * @param dbt5208Entity 調査票フラグ
     * @param bodyItem 一次判定結果Entity
     * @return サービス状況
     */
    public static RString setサービス状況(List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity, IchijihanteikekkahyoEntity bodyItem) {
        RStringBuilder builder = new RStringBuilder();
        if (ServiceKubunCode.予防給付サービス.get名称().equals(bodyItem.get現在のサービス利用状況名()) && 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            set現在のサービス利用状況_予防給付_06A(bodyItem, dbt5207Entity, dbt5208Entity);
        } else if (ServiceKubunCode.予防給付サービス.get名称().equals(bodyItem.get現在のサービス利用状況名()) && 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            set現在のサービス利用状況_予防給付_09A(bodyItem, dbt5207Entity, dbt5208Entity);
        } else if (ServiceKubunCode.予防給付サービス.get名称().equals(bodyItem.get現在のサービス利用状況名()) && 識別コード09B.equals(bodyItem.get厚労省IF識別コード())) {
            set現在のサービス利用状況_予防給付_09B(bodyItem, dbt5207Entity, dbt5208Entity);
        }
        if (ServiceKubunCode.予防給付サービス.get名称().equals(bodyItem.get現在のサービス利用状況名()) && 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            set現在のサービス利用状況_予防給付_02A(bodyItem, dbt5207Entity, dbt5208Entity);
        } else if (ServiceKubunCode.予防給付サービス.get名称().equals(bodyItem.get現在のサービス利用状況名()) && 識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            set現在のサービス利用状況_予防給付_99A(bodyItem, dbt5207Entity, dbt5208Entity);
        }
        getサービス状況(dbt5207Entity, dbt5208Entity, bodyItem);
        getサービス状況01(dbt5207Entity, dbt5208Entity, bodyItem);
        return builder.toRString();
    }

    private static void set現在のサービス利用状況_予防給付_99A(IchijihanteikekkahyoEntity bodyItem,
            List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity) {
        bodyItem.setサービス名称1(ServiceJokyo99A.訪問介護.get帳票上の名称());
        bodyItem.setサービス名称2(ServiceJokyo99A.訪問入浴介護.get帳票上の名称());
        bodyItem.setサービス名称3(ServiceJokyo99A.訪問看護.get帳票上の名称());
        bodyItem.setサービス名称4(ServiceJokyo99A.訪問リハビリ.get帳票上の名称());
        bodyItem.setサービス名称5(ServiceJokyo99A.居宅療養管理指導.get帳票上の名称());
        bodyItem.setサービス名称6(ServiceJokyo99A.通所介護.get帳票上の名称());
        bodyItem.setサービス名称7(ServiceJokyo99A.通所リハビリ.get帳票上の名称());
        bodyItem.setサービス名称8(ServiceJokyo99A.短期入所生活介護.get帳票上の名称());
        bodyItem.setサービス名称9(ServiceJokyo99A.短期入所療養介護.get帳票上の名称());
        bodyItem.setサービス名称10(ServiceJokyo99A.特定施設入所者生活介護.get帳票上の名称());
        bodyItem.setサービス名称11(ServiceJokyo99A.福祉用具貸与.get帳票上の名称());
        bodyItem.setサービス名称12(ServiceJokyo99A.福祉用具購入.get帳票上の名称());
        bodyItem.setサービス名称13(ServiceJokyo99A.住宅改修.get帳票上の名称());
        bodyItem.setサービス名称14(RString.EMPTY);
        bodyItem.setサービス名称15(RString.EMPTY);
        bodyItem.setサービス名称16(RString.EMPTY);
        bodyItem.setサービス回数1(文字数揃え(getサービス連番の状況(dbt5207Entity, 0).concat(ServiceJokyo99A.訪問介護.get単位())));
        bodyItem.setサービス回数2(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番1).concat(ServiceJokyo99A.訪問入浴介護.get単位())));
        bodyItem.setサービス回数3(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番2).concat(ServiceJokyo99A.訪問看護.get単位())));
        bodyItem.setサービス回数4(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番3).concat(ServiceJokyo99A.訪問リハビリ.get単位())));
        bodyItem.setサービス回数5(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番4).concat(ServiceJokyo99A.居宅療養管理指導.get単位())));
        bodyItem.setサービス回数6(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番5).concat(ServiceJokyo99A.通所介護.get単位())));
        bodyItem.setサービス回数7(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番6).concat(ServiceJokyo99A.通所リハビリ.get単位())));
        bodyItem.setサービス回数8(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番8).concat(ServiceJokyo99A.短期入所生活介護.get単位())));
        bodyItem.setサービス回数9(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番9).concat(ServiceJokyo99A.短期入所療養介護.get単位())));
        bodyItem.setサービス回数10(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番11).concat(ServiceJokyo99A.特定施設入所者生活介護.get単位())));
        bodyItem.setサービス回数11(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番7).concat(ServiceJokyo99A.福祉用具貸与.get単位())));
        bodyItem.setサービス回数12(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番11).concat(ServiceJokyo99A.福祉用具購入.get単位())));
        bodyItem.setサービス回数13((dbt5208Entity != null && !dbt5208Entity.isEmpty() && dbt5208Entity.get(0).getServiceJokyoFlag())
                ? 文字数揃え(IsJutakuKaishu.あり.get名称()) : 文字数揃え(IsJutakuKaishu.なし.get名称()));
        bodyItem.setサービス回数14(RString.EMPTY);
        bodyItem.setサービス回数15(RString.EMPTY);
        bodyItem.setサービス回数16(RString.EMPTY);
    }

    private static void set現在のサービス利用状況_予防給付_02A(IchijihanteikekkahyoEntity bodyItem,
            List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity) {
        bodyItem.setサービス名称1(ServiceJokyo02A.訪問介護.get帳票上のラベル名称());
        bodyItem.setサービス名称2(ServiceJokyo02A.訪問入浴介護.get帳票上のラベル名称());
        bodyItem.setサービス名称3(ServiceJokyo02A.訪問看護.get帳票上のラベル名称());
        bodyItem.setサービス名称4(ServiceJokyo02A.訪問リハビリ.get帳票上のラベル名称());
        bodyItem.setサービス名称5(ServiceJokyo02A.居宅療養管理指導.get帳票上のラベル名称());
        bodyItem.setサービス名称6(ServiceJokyo02A.通所介護.get帳票上のラベル名称());
        bodyItem.setサービス名称7(ServiceJokyo02A.通所リハビリ.get帳票上のラベル名称());
        bodyItem.setサービス名称8(ServiceJokyo02A.短期入所生活介護.get帳票上のラベル名称());
        bodyItem.setサービス名称9(ServiceJokyo02A.短期入所療養介護.get帳票上のラベル名称());
        bodyItem.setサービス名称10(ServiceJokyo02A.特定施設入所者生活介護.get帳票上のラベル名称());
        bodyItem.setサービス名称11(ServiceJokyo02A.福祉用具貸与.get帳票上のラベル名称());
        bodyItem.setサービス名称12(ServiceJokyo02A.福祉用具購入.get帳票上のラベル名称());
        bodyItem.setサービス名称13(ServiceJokyo02A.住宅改修.get帳票上のラベル名称());
        bodyItem.setサービス名称14(RString.EMPTY);
        bodyItem.setサービス名称15(RString.EMPTY);
        bodyItem.setサービス名称16(RString.EMPTY);
        bodyItem.setサービス回数1(文字数揃え(getサービス連番の状況(dbt5207Entity, 0).concat(ServiceJokyo02A.訪問介護.get単位())));
        bodyItem.setサービス回数2(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番1).concat(ServiceJokyo02A.訪問入浴介護.get単位())));
        bodyItem.setサービス回数3(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番2).concat(ServiceJokyo02A.訪問看護.get単位())));
        bodyItem.setサービス回数4(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番3).concat(ServiceJokyo02A.訪問リハビリ.get単位())));
        bodyItem.setサービス回数5(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番4).concat(ServiceJokyo02A.居宅療養管理指導.get単位())));
        bodyItem.setサービス回数6(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番5).concat(ServiceJokyo02A.通所介護.get単位())));
        bodyItem.setサービス回数7(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番6).concat(ServiceJokyo02A.通所リハビリ.get単位())));
        bodyItem.setサービス回数8(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番8).concat(ServiceJokyo02A.短期入所生活介護.get単位())));
        bodyItem.setサービス回数9(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番9).concat(ServiceJokyo02A.短期入所療養介護.get単位())));
        bodyItem.setサービス回数10(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番11).concat(ServiceJokyo02A.特定施設入所者生活介護.get単位())));
        bodyItem.setサービス回数11(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番7).concat(ServiceJokyo02A.福祉用具貸与.get単位())));
        bodyItem.setサービス回数12(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番11).concat(ServiceJokyo02A.福祉用具購入.get単位())));
        bodyItem.setサービス回数13((dbt5208Entity != null && !dbt5208Entity.isEmpty() && dbt5208Entity.get(0).getServiceJokyoFlag())
                ? 文字数揃え(IsJutakuKaishu.あり.get名称()) : 文字数揃え(IsJutakuKaishu.なし.get名称()));
        bodyItem.setサービス回数14(RString.EMPTY);
        bodyItem.setサービス回数15(RString.EMPTY);
        bodyItem.setサービス回数16(RString.EMPTY);
    }

    private static void set現在のサービス利用状況_予防給付_09B(IchijihanteikekkahyoEntity bodyItem,
            List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity) {
        bodyItem.setサービス名称1(ServiceJokyo09B.訪問介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称2(ServiceJokyo09B.訪問入浴介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称3(ServiceJokyo09B.訪問看護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称4(ServiceJokyo09B.訪問リハビリ.get帳票上の名称_予防給付());
        bodyItem.setサービス名称5(ServiceJokyo09B.居宅療養管理指導.get帳票上の名称_予防給付());
        bodyItem.setサービス名称6(ServiceJokyo09B.通所介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称7(ServiceJokyo09B.通所リハビリ.get帳票上の名称_予防給付());
        bodyItem.setサービス名称8(ServiceJokyo09B.短期入所生活介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称9(ServiceJokyo09B.短期入所療養介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称10(ServiceJokyo09B.特定施設入所者生活介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称11(ServiceJokyo09B.福祉用具貸与.get帳票上の名称_予防給付());
        bodyItem.setサービス名称12(ServiceJokyo09B.福祉用具購入.get帳票上の名称_予防給付());
        bodyItem.setサービス名称13(ServiceJokyo09B.住宅改修.get帳票上の名称_予防給付());
        bodyItem.setサービス名称14(ServiceJokyo09B.認知症対応型通所介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称15(ServiceJokyo09B.小規模多機能型居宅介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称16(ServiceJokyo09B.認知症対応型共同生活介護.get帳票上の名称_予防給付());
        bodyItem.setサービス回数1(文字数揃え(getサービス連番の状況(dbt5207Entity, 0).concat(ServiceJokyo09B.訪問介護.get単位())));
        bodyItem.setサービス回数2(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番1).concat(ServiceJokyo09B.訪問入浴介護.get単位())));
        bodyItem.setサービス回数3(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番2).concat(ServiceJokyo09B.訪問看護.get単位())));
        bodyItem.setサービス回数4(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番3).concat(ServiceJokyo09B.訪問リハビリ.get単位())));
        bodyItem.setサービス回数5(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番4).concat(ServiceJokyo09B.居宅療養管理指導.get単位())));
        bodyItem.setサービス回数6(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番5).concat(ServiceJokyo09B.通所介護.get単位())));
        bodyItem.setサービス回数7(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番6).concat(ServiceJokyo09B.通所リハビリ.get単位())));
        bodyItem.setサービス回数8(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番7).concat(ServiceJokyo09B.短期入所生活介護.get単位())));
        bodyItem.setサービス回数9(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番8).concat(ServiceJokyo09B.短期入所療養介護.get単位())));
        bodyItem.setサービス回数10(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番9).concat(ServiceJokyo09B.特定施設入所者生活介護.get単位())));
        bodyItem.setサービス回数11(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番10).concat(ServiceJokyo09B.福祉用具貸与.get単位())));
        bodyItem.setサービス回数12(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番11).concat(ServiceJokyo09B.福祉用具購入.get単位())));
        bodyItem.setサービス回数13((dbt5208Entity != null && !dbt5208Entity.isEmpty() && dbt5208Entity.get(0).getServiceJokyoFlag())
                ? 文字数揃え(IsJutakuKaishu.あり.get名称()) : 文字数揃え(IsJutakuKaishu.なし.get名称()));
        bodyItem.setサービス回数14(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番13).concat(ServiceJokyo09B.認知症対応型通所介護.get単位())));
        bodyItem.setサービス回数15(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番14).concat(ServiceJokyo09B.小規模多機能型居宅介護.get単位())));
        bodyItem.setサービス回数16(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番15).concat(ServiceJokyo09B.認知症対応型共同生活介護.get単位())));
    }

    private static void set現在のサービス利用状況_予防給付_09A(IchijihanteikekkahyoEntity bodyItem,
            List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity) {
        bodyItem.setサービス名称1(ServiceJokyo09A.訪問介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称2(ServiceJokyo09A.訪問入浴介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称3(ServiceJokyo09A.訪問看護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称4(ServiceJokyo09A.訪問リハビリ.get帳票上の名称_予防給付());
        bodyItem.setサービス名称5(ServiceJokyo09A.居宅療養管理指導.get帳票上の名称_予防給付());
        bodyItem.setサービス名称6(ServiceJokyo09A.通所介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称7(ServiceJokyo09A.通所リハビリ.get帳票上の名称_予防給付());
        bodyItem.setサービス名称8(ServiceJokyo09A.短期入所生活介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称9(ServiceJokyo09A.短期入所療養介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称10(ServiceJokyo09A.特定施設入所者生活介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称11(ServiceJokyo09A.福祉用具貸与.get帳票上の名称_予防給付());
        bodyItem.setサービス名称12(ServiceJokyo09A.福祉用具購入.get帳票上の名称_予防給付());
        bodyItem.setサービス名称13(ServiceJokyo09A.住宅改修.get帳票上の名称_予防給付());
        bodyItem.setサービス名称14(ServiceJokyo09A.認知症対応型通所介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称15(ServiceJokyo09A.小規模多機能型居宅介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称16(ServiceJokyo09A.認知症対応型共同生活介護.get帳票上の名称_予防給付());
        bodyItem.setサービス回数1(文字数揃え(getサービス連番の状況(dbt5207Entity, 0).concat(ServiceJokyo09A.訪問介護.get単位())));
        bodyItem.setサービス回数2(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番1).concat(ServiceJokyo09A.訪問入浴介護.get単位())));
        bodyItem.setサービス回数3(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番2).concat(ServiceJokyo09A.訪問看護.get単位())));
        bodyItem.setサービス回数4(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番3).concat(ServiceJokyo09A.訪問リハビリ.get単位())));
        bodyItem.setサービス回数5(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番4).concat(ServiceJokyo09A.居宅療養管理指導.get単位())));
        bodyItem.setサービス回数6(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番5).concat(ServiceJokyo09A.通所介護.get単位())));
        bodyItem.setサービス回数7(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番6).concat(ServiceJokyo09A.通所リハビリ.get単位())));
        bodyItem.setサービス回数8(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番7).concat(ServiceJokyo09A.短期入所生活介護.get単位())));
        bodyItem.setサービス回数9(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番8).concat(ServiceJokyo09A.短期入所療養介護.get単位())));
        bodyItem.setサービス回数10(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番9).concat(ServiceJokyo09A.特定施設入所者生活介護.get単位())));
        bodyItem.setサービス回数11(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番10).concat(ServiceJokyo09A.福祉用具貸与.get単位())));
        bodyItem.setサービス回数12(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番11).concat(ServiceJokyo09A.福祉用具購入.get単位())));
        bodyItem.setサービス回数13((dbt5208Entity != null && !dbt5208Entity.isEmpty() && dbt5208Entity.get(0).getServiceJokyoFlag())
                ? 文字数揃え(IsJutakuKaishu.あり.get名称()) : 文字数揃え(IsJutakuKaishu.なし.get名称()));
        bodyItem.setサービス回数14(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番13).concat(ServiceJokyo09A.認知症対応型通所介護.get単位())));
        bodyItem.setサービス回数15(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番14).concat(ServiceJokyo09A.小規模多機能型居宅介護.get単位())));
        bodyItem.setサービス回数16(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番15).concat(ServiceJokyo09A.認知症対応型共同生活介護.get単位())));
    }

    private static void set現在のサービス利用状況_予防給付_06A(IchijihanteikekkahyoEntity bodyItem,
            List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity) {
        bodyItem.setサービス名称1(ServiceJokyo06A.訪問介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称2(ServiceJokyo06A.訪問入浴介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称3(ServiceJokyo06A.訪問看護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称4(ServiceJokyo06A.訪問リハビリ.get帳票上の名称_予防給付());
        bodyItem.setサービス名称5(ServiceJokyo06A.居宅療養管理指導.get帳票上の名称_予防給付());
        bodyItem.setサービス名称6(ServiceJokyo06A.通所介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称7(ServiceJokyo06A.通所リハビリ.get帳票上の名称_予防給付());
        bodyItem.setサービス名称8(ServiceJokyo06A.短期入所生活介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称9(ServiceJokyo06A.短期入所療養介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称10(ServiceJokyo06A.特定施設入所者生活介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称11(ServiceJokyo06A.福祉用具貸与.get帳票上の名称_予防給付());
        bodyItem.setサービス名称12(ServiceJokyo06A.福祉用具購入.get帳票上の名称_予防給付());
        bodyItem.setサービス名称13(ServiceJokyo06A.住宅改修.get帳票上の名称_予防給付());
        bodyItem.setサービス名称14(ServiceJokyo06A.認知症対応型通所介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称15(ServiceJokyo06A.小規模多機能型居宅介護.get帳票上の名称_予防給付());
        bodyItem.setサービス名称16(ServiceJokyo06A.認知症対応型共同生活介護.get帳票上の名称_予防給付());
        bodyItem.setサービス回数1(文字数揃え(getサービス連番の状況(dbt5207Entity, 0).concat(ServiceJokyo06A.訪問介護.get単位())));
        bodyItem.setサービス回数2(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番1).concat(ServiceJokyo06A.訪問入浴介護.get単位())));
        bodyItem.setサービス回数3(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番2).concat(ServiceJokyo06A.訪問看護.get単位())));
        bodyItem.setサービス回数4(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番3).concat(ServiceJokyo06A.訪問リハビリ.get単位())));
        bodyItem.setサービス回数5(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番4).concat(ServiceJokyo06A.居宅療養管理指導.get単位())));
        bodyItem.setサービス回数6(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番5).concat(ServiceJokyo06A.通所介護.get単位())));
        bodyItem.setサービス回数7(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番6).concat(ServiceJokyo06A.通所リハビリ.get単位())));
        bodyItem.setサービス回数8(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番7).concat(ServiceJokyo06A.短期入所生活介護.get単位())));
        bodyItem.setサービス回数9(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番8).concat(ServiceJokyo06A.短期入所療養介護.get単位())));
        bodyItem.setサービス回数10(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番9).concat(ServiceJokyo06A.特定施設入所者生活介護.get単位())));
        bodyItem.setサービス回数11(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番10).concat(ServiceJokyo06A.福祉用具貸与.get単位())));
        bodyItem.setサービス回数12(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番11).concat(ServiceJokyo06A.福祉用具購入.get単位())));
        bodyItem.setサービス回数13((dbt5208Entity != null && !dbt5208Entity.isEmpty() && dbt5208Entity.get(0).getServiceJokyoFlag())
                ? 文字数揃え(IsJutakuKaishu.あり.get名称()) : 文字数揃え(IsJutakuKaishu.なし.get名称()));
        bodyItem.setサービス回数14(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番13).concat(ServiceJokyo06A.認知症対応型通所介護.get単位())));
        bodyItem.setサービス回数15(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番14).concat(ServiceJokyo06A.小規模多機能型居宅介護.get単位())));
        bodyItem.setサービス回数16(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番15).concat(ServiceJokyo06A.認知症対応型共同生活介護.get単位())));
    }

    private static void getサービス状況(List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity, IchijihanteikekkahyoEntity bodyItem) {
        if (!ServiceKubunCode.予防給付サービス.get名称().equals(bodyItem.get現在のサービス利用状況名())
                && !ServiceKubunCode.介護給付サービス.get名称().equals(bodyItem.get現在のサービス利用状況名())) {
            bodyItem.setサービス名称10(new RString("                                      (なし)"));
        }
        if (ServiceKubunCode.介護給付サービス.get名称().equals(bodyItem.get現在のサービス利用状況名()) && 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            set現在のサービス利用状況_介護給付_06A(bodyItem, dbt5207Entity, dbt5208Entity);
        } else if (ServiceKubunCode.介護給付サービス.get名称().equals(bodyItem.get現在のサービス利用状況名()) && 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            set現在のサービス利用状況_介護給付_09A(bodyItem, dbt5207Entity, dbt5208Entity);
        } else if (ServiceKubunCode.介護給付サービス.get名称().equals(bodyItem.get現在のサービス利用状況名()) && 識別コード09B.equals(bodyItem.get厚労省IF識別コード())) {
            set現在のサービス利用状況_介護給付_09B(bodyItem, dbt5207Entity, dbt5208Entity);
        }
    }

    private static void set現在のサービス利用状況_介護給付_09B(IchijihanteikekkahyoEntity bodyItem,
            List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity) {
        bodyItem.setサービス名称1(ServiceJokyo09B.訪問介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称2(ServiceJokyo09B.訪問入浴介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称3(ServiceJokyo09B.訪問看護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称4(ServiceJokyo09B.訪問リハビリ.get帳票上の名称_介護給付());
        bodyItem.setサービス名称5(ServiceJokyo09B.居宅療養管理指導.get帳票上の名称_介護給付());
        bodyItem.setサービス名称6(ServiceJokyo09B.通所介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称7(ServiceJokyo09B.通所リハビリ.get帳票上の名称_介護給付());
        bodyItem.setサービス名称8(ServiceJokyo09B.短期入所生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称9(ServiceJokyo09B.短期入所療養介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称10(ServiceJokyo09B.特定施設入所者生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称11(ServiceJokyo09B.福祉用具貸与.get帳票上の名称_介護給付());
        bodyItem.setサービス名称12(ServiceJokyo09B.福祉用具購入.get帳票上の名称_介護給付());
        bodyItem.setサービス名称13(ServiceJokyo09B.住宅改修.get帳票上の名称_介護給付());
        bodyItem.setサービス名称14(ServiceJokyo09B.夜間対応型訪問介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称15(ServiceJokyo09B.認知症対応型通所介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称16(ServiceJokyo09B.小規模多機能型居宅介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称17(ServiceJokyo09B.認知症対応型共同生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称18(ServiceJokyo09B.地域密着型特定施設入居者生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称19(ServiceJokyo09B.地域密着型介護老人福祉施設入所者生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称20(ServiceJokyo09B.定期巡回_随時対応型訪問介護看護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称21(ServiceJokyo09B.看護小規模多機能型居宅介護.get帳票上の名称_介護給付());
        bodyItem.setサービス回数1(文字数揃え(getサービス連番の状況(dbt5207Entity, 0).concat(ServiceJokyo09B.訪問介護.get単位())));
        bodyItem.setサービス回数2(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番1).concat(ServiceJokyo09B.訪問入浴介護.get単位())));
        bodyItem.setサービス回数3(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番2).concat(ServiceJokyo09B.訪問看護.get単位())));
        bodyItem.setサービス回数4(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番3).concat(ServiceJokyo09B.訪問リハビリ.get単位())));
        bodyItem.setサービス回数5(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番4).concat(ServiceJokyo09B.居宅療養管理指導.get単位())));
        bodyItem.setサービス回数6(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番5).concat(ServiceJokyo09B.通所介護.get単位())));
        bodyItem.setサービス回数7(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番6).concat(ServiceJokyo09B.通所リハビリ.get単位())));
        bodyItem.setサービス回数8(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番7).concat(ServiceJokyo09B.短期入所生活介護.get単位())));
        bodyItem.setサービス回数9(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番8).concat(ServiceJokyo09B.短期入所療養介護.get単位())));
        bodyItem.setサービス回数10(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番9).concat(ServiceJokyo09B.特定施設入所者生活介護.get単位())));
        bodyItem.setサービス回数11(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番10).concat(ServiceJokyo09B.福祉用具貸与.get単位())));
        bodyItem.setサービス回数12(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番11).concat(ServiceJokyo09B.福祉用具購入.get単位())));
        bodyItem.setサービス回数13((dbt5208Entity != null && !dbt5208Entity.isEmpty() && dbt5208Entity.get(0).getServiceJokyoFlag())
                ? 文字数揃え(IsJutakuKaishu.あり.get名称()) : 文字数揃え(IsJutakuKaishu.なし.get名称()));
        bodyItem.setサービス回数14(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番12).concat(ServiceJokyo09B.夜間対応型訪問介護.get単位())));
        bodyItem.setサービス回数15(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番13).concat(ServiceJokyo09B.認知症対応型通所介護.get単位())));
        bodyItem.setサービス回数16(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番14).concat(ServiceJokyo09B.小規模多機能型居宅介護.get単位())));
        bodyItem.setサービス回数17(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番15).concat(ServiceJokyo09B.認知症対応型共同生活介護.get単位())));
        bodyItem.setサービス回数18(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番16).concat(ServiceJokyo09B.地域密着型特定施設入居者生活介護.get単位())));
        bodyItem.setサービス回数19(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番17).concat(ServiceJokyo09B.地域密着型介護老人福祉施設入所者生活介護.get単位())));
        bodyItem.setサービス回数20(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番18).concat(ServiceJokyo09B.定期巡回_随時対応型訪問介護看護.get単位())));
        bodyItem.setサービス回数21(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番19).concat(ServiceJokyo09B.看護小規模多機能型居宅介護.get単位())));
    }

    private static void set現在のサービス利用状況_介護給付_09A(IchijihanteikekkahyoEntity bodyItem,
            List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity) {
        bodyItem.setサービス名称1(ServiceJokyo09A.訪問介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称2(ServiceJokyo09A.訪問入浴介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称3(ServiceJokyo09A.訪問看護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称4(ServiceJokyo09A.訪問リハビリ.get帳票上の名称_介護給付());
        bodyItem.setサービス名称5(ServiceJokyo09A.居宅療養管理指導.get帳票上の名称_介護給付());
        bodyItem.setサービス名称6(ServiceJokyo09A.通所介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称7(ServiceJokyo09A.通所リハビリ.get帳票上の名称_介護給付());
        bodyItem.setサービス名称8(ServiceJokyo09A.短期入所生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称9(ServiceJokyo09A.短期入所療養介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称10(ServiceJokyo09A.特定施設入所者生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称11(ServiceJokyo09A.福祉用具貸与.get帳票上の名称_介護給付());
        bodyItem.setサービス名称12(ServiceJokyo09A.福祉用具購入.get帳票上の名称_介護給付());
        bodyItem.setサービス名称13(ServiceJokyo09A.住宅改修.get帳票上の名称_介護給付());
        bodyItem.setサービス名称14(ServiceJokyo09A.夜間対応型訪問介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称15(ServiceJokyo09A.認知症対応型通所介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称16(ServiceJokyo09A.小規模多機能型居宅介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称17(ServiceJokyo09A.認知症対応型共同生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称18(ServiceJokyo09A.地域密着型特定施設入居者生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称19(ServiceJokyo09A.地域密着型介護老人福祉施設入所者生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称20(RString.EMPTY);
        bodyItem.setサービス名称21(RString.EMPTY);
        bodyItem.setサービス回数1(文字数揃え(getサービス連番の状況(dbt5207Entity, 0).concat(ServiceJokyo09A.訪問介護.get単位())));
        bodyItem.setサービス回数2(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番1).concat(ServiceJokyo09A.訪問入浴介護.get単位())));
        bodyItem.setサービス回数3(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番2).concat(ServiceJokyo09A.訪問看護.get単位())));
        bodyItem.setサービス回数4(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番3).concat(ServiceJokyo09A.訪問リハビリ.get単位())));
        bodyItem.setサービス回数5(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番4).concat(ServiceJokyo09A.居宅療養管理指導.get単位())));
        bodyItem.setサービス回数6(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番5).concat(ServiceJokyo09A.通所介護.get単位())));
        bodyItem.setサービス回数7(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番6).concat(ServiceJokyo09A.通所リハビリ.get単位())));
        bodyItem.setサービス回数8(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番7).concat(ServiceJokyo09A.短期入所生活介護.get単位())));
        bodyItem.setサービス回数9(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番8).concat(ServiceJokyo09A.短期入所療養介護.get単位())));
        bodyItem.setサービス回数10(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番9).concat(ServiceJokyo09A.特定施設入所者生活介護.get単位())));
        bodyItem.setサービス回数11(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番10).concat(ServiceJokyo09A.福祉用具貸与.get単位())));
        bodyItem.setサービス回数12(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番11).concat(ServiceJokyo09A.福祉用具購入.get単位())));
        bodyItem.setサービス回数13((dbt5208Entity != null && !dbt5208Entity.isEmpty() && dbt5208Entity.get(0).getServiceJokyoFlag())
                ? 文字数揃え(IsJutakuKaishu.あり.get名称()) : 文字数揃え(IsJutakuKaishu.なし.get名称()));
        bodyItem.setサービス回数14(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番12).concat(ServiceJokyo09A.夜間対応型訪問介護.get単位())));
        bodyItem.setサービス回数15(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番13).concat(ServiceJokyo09A.認知症対応型通所介護.get単位())));
        bodyItem.setサービス回数16(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番14).concat(ServiceJokyo09A.小規模多機能型居宅介護.get単位())));
        bodyItem.setサービス回数17(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番15).concat(ServiceJokyo09A.認知症対応型共同生活介護.get単位())));
        bodyItem.setサービス回数18(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番16).concat(ServiceJokyo09A.地域密着型特定施設入居者生活介護.get単位())));
        bodyItem.setサービス回数19(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番17).concat(ServiceJokyo09A.地域密着型介護老人福祉施設入所者生活介護.get単位())));
        bodyItem.setサービス回数20(RString.EMPTY);
        bodyItem.setサービス回数21(RString.EMPTY);
    }

    private static void set現在のサービス利用状況_介護給付_06A(IchijihanteikekkahyoEntity bodyItem,
            List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity) {
        bodyItem.setサービス名称1(ServiceJokyo06A.訪問介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称2(ServiceJokyo06A.訪問入浴介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称3(ServiceJokyo06A.訪問看護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称4(ServiceJokyo06A.訪問リハビリ.get帳票上の名称_介護給付());
        bodyItem.setサービス名称5(ServiceJokyo06A.居宅療養管理指導.get帳票上の名称_介護給付());
        bodyItem.setサービス名称6(ServiceJokyo06A.通所介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称7(ServiceJokyo06A.通所リハビリ.get帳票上の名称_介護給付());
        bodyItem.setサービス名称8(ServiceJokyo06A.短期入所生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称9(ServiceJokyo06A.短期入所療養介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称10(ServiceJokyo06A.特定施設入所者生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称11(ServiceJokyo06A.福祉用具貸与.get帳票上の名称_介護給付());
        bodyItem.setサービス名称12(ServiceJokyo06A.福祉用具購入.get帳票上の名称_介護給付());
        bodyItem.setサービス名称13(ServiceJokyo06A.住宅改修.get帳票上の名称_介護給付());
        bodyItem.setサービス名称14(ServiceJokyo06A.夜間対応型訪問介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称15(ServiceJokyo06A.認知症対応型通所介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称16(ServiceJokyo06A.小規模多機能型居宅介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称17(ServiceJokyo06A.認知症対応型共同生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称18(ServiceJokyo06A.地域密着型特定施設入居者生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称19(ServiceJokyo06A.地域密着型介護老人福祉施設入所者生活介護.get帳票上の名称_介護給付());
        bodyItem.setサービス名称20(RString.EMPTY);
        bodyItem.setサービス名称21(RString.EMPTY);
        bodyItem.setサービス回数1(文字数揃え(getサービス連番の状況(dbt5207Entity, 0).concat(ServiceJokyo06A.訪問介護.get単位())));
        bodyItem.setサービス回数2(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番1).concat(ServiceJokyo06A.訪問入浴介護.get単位())));
        bodyItem.setサービス回数3(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番2).concat(ServiceJokyo06A.訪問看護.get単位())));
        bodyItem.setサービス回数4(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番3).concat(ServiceJokyo06A.訪問リハビリ.get単位())));
        bodyItem.setサービス回数5(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番4).concat(ServiceJokyo06A.居宅療養管理指導.get単位())));
        bodyItem.setサービス回数6(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番5).concat(ServiceJokyo06A.通所介護.get単位())));
        bodyItem.setサービス回数7(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番6).concat(ServiceJokyo06A.通所リハビリ.get単位())));
        bodyItem.setサービス回数8(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番7).concat(ServiceJokyo06A.短期入所生活介護.get単位())));
        bodyItem.setサービス回数9(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番8).concat(ServiceJokyo06A.短期入所療養介護.get単位())));
        bodyItem.setサービス回数10(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番9).concat(ServiceJokyo06A.特定施設入所者生活介護.get単位())));
        bodyItem.setサービス回数11(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番10).concat(ServiceJokyo06A.福祉用具貸与.get単位())));
        bodyItem.setサービス回数12(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番11).concat(ServiceJokyo06A.福祉用具購入.get単位())));
        bodyItem.setサービス回数13((dbt5208Entity != null && !dbt5208Entity.isEmpty() && dbt5208Entity.get(0).getServiceJokyoFlag())
                ? 文字数揃え(IsJutakuKaishu.あり.get名称()) : 文字数揃え(IsJutakuKaishu.なし.get名称()));
        bodyItem.setサービス回数14(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番12).concat(ServiceJokyo06A.夜間対応型訪問介護.get単位())));
        bodyItem.setサービス回数15(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番13).concat(ServiceJokyo06A.認知症対応型通所介護.get単位())));
        bodyItem.setサービス回数16(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番14).concat(ServiceJokyo06A.小規模多機能型居宅介護.get単位())));
        bodyItem.setサービス回数17(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番15).concat(ServiceJokyo06A.認知症対応型共同生活介護.get単位())));
        bodyItem.setサービス回数18(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番16).concat(ServiceJokyo06A.地域密着型特定施設入居者生活介護.get単位())));
        bodyItem.setサービス回数19(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番17).concat(ServiceJokyo06A.地域密着型介護老人福祉施設入所者生活介護.get単位())));
        bodyItem.setサービス回数20(RString.EMPTY);
        bodyItem.setサービス回数21(RString.EMPTY);
    }

    private static void getサービス状況01(List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity, IchijihanteikekkahyoEntity bodyItem) {
        if (ServiceKubunCode.介護給付サービス.get名称().equals(bodyItem.get現在のサービス利用状況名()) && 識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            set現在のサービス利用状況_99A(bodyItem, dbt5207Entity, dbt5208Entity);
        } else if (ServiceKubunCode.介護給付サービス.get名称().equals(bodyItem.get現在のサービス利用状況名()) && 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            set現在のサービス利用状況_02A(bodyItem, dbt5207Entity, dbt5208Entity);
        }
    }

    private static void set現在のサービス利用状況_99A(IchijihanteikekkahyoEntity bodyItem,
            List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity) {
        bodyItem.setサービス名称1(ServiceJokyo99A.訪問介護.get帳票上の名称());
        bodyItem.setサービス名称2(ServiceJokyo99A.訪問入浴介護.get帳票上の名称());
        bodyItem.setサービス名称3(ServiceJokyo99A.訪問看護.get帳票上の名称());
        bodyItem.setサービス名称4(ServiceJokyo99A.訪問リハビリ.get帳票上の名称());
        bodyItem.setサービス名称5(ServiceJokyo99A.居宅療養管理指導.get帳票上の名称());
        bodyItem.setサービス名称6(ServiceJokyo99A.通所介護.get帳票上の名称());
        bodyItem.setサービス名称7(ServiceJokyo99A.通所リハビリ.get帳票上の名称());
        bodyItem.setサービス名称8(ServiceJokyo99A.短期入所生活介護.get帳票上の名称());
        bodyItem.setサービス名称9(ServiceJokyo99A.短期入所療養介護.get帳票上の名称());
        bodyItem.setサービス名称10(ServiceJokyo99A.特定施設入所者生活介護.get帳票上の名称());
        bodyItem.setサービス名称11(ServiceJokyo99A.福祉用具貸与.get帳票上の名称());
        bodyItem.setサービス名称12(ServiceJokyo99A.福祉用具購入.get帳票上の名称());
        bodyItem.setサービス名称13(ServiceJokyo99A.住宅改修.get帳票上の名称());
        bodyItem.setサービス名称14(RString.EMPTY);
        bodyItem.setサービス名称15(RString.EMPTY);
        bodyItem.setサービス名称16(RString.EMPTY);
        bodyItem.setサービス名称17(RString.EMPTY);
        bodyItem.setサービス名称18(RString.EMPTY);
        bodyItem.setサービス名称19(RString.EMPTY);
        bodyItem.setサービス名称20(RString.EMPTY);
        bodyItem.setサービス名称21(RString.EMPTY);
        bodyItem.setサービス回数1(文字数揃え(getサービス連番の状況(dbt5207Entity, 0).concat(ServiceJokyo99A.訪問介護.get単位())));
        bodyItem.setサービス回数2(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番1).concat(ServiceJokyo99A.訪問入浴介護.get単位())));
        bodyItem.setサービス回数3(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番2).concat(ServiceJokyo99A.訪問看護.get単位())));
        bodyItem.setサービス回数4(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番3).concat(ServiceJokyo99A.訪問リハビリ.get単位())));
        bodyItem.setサービス回数5(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番4).concat(ServiceJokyo99A.居宅療養管理指導.get単位())));
        bodyItem.setサービス回数6(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番5).concat(ServiceJokyo99A.通所介護.get単位())));
        bodyItem.setサービス回数7(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番6).concat(ServiceJokyo99A.通所リハビリ.get単位())));
        bodyItem.setサービス回数8(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番8).concat(ServiceJokyo99A.短期入所生活介護.get単位())));
        bodyItem.setサービス回数9(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番9).concat(ServiceJokyo99A.短期入所療養介護.get単位())));
        bodyItem.setサービス回数10(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番11).concat(ServiceJokyo99A.特定施設入所者生活介護.get単位())));
        bodyItem.setサービス回数11(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番7).concat(ServiceJokyo99A.福祉用具貸与.get単位())));
        bodyItem.setサービス回数12(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番12).concat(ServiceJokyo99A.福祉用具購入.get単位())));
        bodyItem.setサービス回数13((dbt5208Entity != null && !dbt5208Entity.isEmpty() && dbt5208Entity.get(0).getServiceJokyoFlag())
                ? 文字数揃え(IsJutakuKaishu.あり.get名称()) : 文字数揃え(IsJutakuKaishu.なし.get名称()));
        bodyItem.setサービス回数14(RString.EMPTY);
        bodyItem.setサービス回数15(RString.EMPTY);
        bodyItem.setサービス回数16(RString.EMPTY);
        bodyItem.setサービス回数17(RString.EMPTY);
        bodyItem.setサービス回数18(RString.EMPTY);
        bodyItem.setサービス回数19(RString.EMPTY);
        bodyItem.setサービス回数20(RString.EMPTY);
        bodyItem.setサービス回数21(RString.EMPTY);
    }

    private static void set現在のサービス利用状況_02A(IchijihanteikekkahyoEntity bodyItem,
            List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity,
            List<DbT5208NinteichosahyoServiceJokyoFlagEntity> dbt5208Entity) {
        bodyItem.setサービス名称1(ServiceJokyo02A.訪問介護.get帳票上のラベル名称());
        bodyItem.setサービス名称2(ServiceJokyo02A.訪問入浴介護.get帳票上のラベル名称());
        bodyItem.setサービス名称3(ServiceJokyo02A.訪問看護.get帳票上のラベル名称());
        bodyItem.setサービス名称4(ServiceJokyo02A.訪問リハビリ.get帳票上のラベル名称());
        bodyItem.setサービス名称5(ServiceJokyo02A.居宅療養管理指導.get帳票上のラベル名称());
        bodyItem.setサービス名称6(ServiceJokyo02A.通所介護.get帳票上のラベル名称());
        bodyItem.setサービス名称7(ServiceJokyo02A.通所リハビリ.get帳票上のラベル名称());
        bodyItem.setサービス名称8(ServiceJokyo02A.短期入所生活介護.get帳票上のラベル名称());
        bodyItem.setサービス名称9(ServiceJokyo02A.短期入所療養介護.get帳票上のラベル名称());
        bodyItem.setサービス名称10(ServiceJokyo02A.特定施設入所者生活介護.get帳票上のラベル名称());
        bodyItem.setサービス名称11(ServiceJokyo02A.福祉用具貸与.get帳票上のラベル名称());
        bodyItem.setサービス名称12(ServiceJokyo02A.福祉用具購入.get帳票上のラベル名称());
        bodyItem.setサービス名称13(ServiceJokyo02A.住宅改修.get帳票上のラベル名称());
        bodyItem.setサービス名称14(RString.EMPTY);
        bodyItem.setサービス名称15(RString.EMPTY);
        bodyItem.setサービス名称16(RString.EMPTY);
        bodyItem.setサービス名称17(RString.EMPTY);
        bodyItem.setサービス名称18(RString.EMPTY);
        bodyItem.setサービス名称19(RString.EMPTY);
        bodyItem.setサービス名称20(RString.EMPTY);
        bodyItem.setサービス名称21(RString.EMPTY);
        bodyItem.setサービス回数1(文字数揃え(getサービス連番の状況(dbt5207Entity, 0).concat(ServiceJokyo02A.訪問介護.get単位())));
        bodyItem.setサービス回数2(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番1).concat(ServiceJokyo02A.訪問入浴介護.get単位())));
        bodyItem.setサービス回数3(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番2).concat(ServiceJokyo02A.訪問看護.get単位())));
        bodyItem.setサービス回数4(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番3).concat(ServiceJokyo02A.訪問リハビリ.get単位())));
        bodyItem.setサービス回数5(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番4).concat(ServiceJokyo02A.居宅療養管理指導.get単位())));
        bodyItem.setサービス回数6(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番5).concat(ServiceJokyo02A.通所介護.get単位())));
        bodyItem.setサービス回数7(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番6).concat(ServiceJokyo02A.通所リハビリ.get単位())));
        bodyItem.setサービス回数8(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番8).concat(ServiceJokyo02A.短期入所生活介護.get単位())));
        bodyItem.setサービス回数9(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番9).concat(ServiceJokyo02A.短期入所療養介護.get単位())));
        bodyItem.setサービス回数10(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番11).concat(ServiceJokyo02A.特定施設入所者生活介護.get単位())));
        bodyItem.setサービス回数11(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番7).concat(ServiceJokyo02A.福祉用具貸与.get単位())));
        bodyItem.setサービス回数12(文字数揃え(getサービス連番の状況(dbt5207Entity, 連番12).concat(ServiceJokyo02A.福祉用具購入.get単位())));
        bodyItem.setサービス回数13((dbt5208Entity != null && !dbt5208Entity.isEmpty() && dbt5208Entity.get(0).getServiceJokyoFlag())
                ? 文字数揃え(IsJutakuKaishu.あり.get名称()) : 文字数揃え(IsJutakuKaishu.なし.get名称()));
        bodyItem.setサービス回数14(RString.EMPTY);
        bodyItem.setサービス回数15(RString.EMPTY);
        bodyItem.setサービス回数16(RString.EMPTY);
        bodyItem.setサービス回数17(RString.EMPTY);
        bodyItem.setサービス回数18(RString.EMPTY);
        bodyItem.setサービス回数19(RString.EMPTY);
        bodyItem.setサービス回数20(RString.EMPTY);
        bodyItem.setサービス回数21(RString.EMPTY);
    }

    private static RString 文字数揃え(RString target) {
        RStringBuilder rsb = new RStringBuilder(target);
        for (int i = rsb.length(); i < 現在のサービス利用状況_最大文字数; i++) {
            rsb.insert(0, RString.FULL_SPACE);
        }
        return rsb.toRString();
    }

    private static RString getサービス連番の状況(List<DbT5207NinteichosahyoServiceJokyoEntity> dbt5207Entity, int 連番) {
        if (連番 < dbt5207Entity.size()) {
            return new RString(dbt5207Entity.get(連番).getServiceJokyo());
        }
        return RString.EMPTY;
    }
    private static final int 現在のサービス利用状況_最大文字数 = 11;

    private static RString get意見書名称03(List<DbT5304ShujiiIkenshoIkenItemEntity> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).getIkenItem())) {
                return RString.EMPTY;
            }
            return IkenKomoku03.toValue(remove半角スペース(dbt5304Entity.get(連番).getIkenItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get特記事項有無(List<RString> list, RString 番号) {
        if (list.contains(番号)) {
            return new RString("※");
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称14(List<DbT5304ShujiiIkenshoIkenItemEntity> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).getIkenItem())) {
                return RString.EMPTY;
            }
            return IkenKomoku14.toValue(remove半角スペース(dbt5304Entity.get(連番).getIkenItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称06(List<DbT5304ShujiiIkenshoIkenItemEntity> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).getIkenItem())) {
                return RString.EMPTY;
            }
            return IkenKomoku06.toValue(remove半角スペース(dbt5304Entity.get(連番).getIkenItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称05(List<DbT5304ShujiiIkenshoIkenItemEntity> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).getIkenItem())) {
                return RString.EMPTY;
            }
            return IkenKomoku05.toValue(remove半角スペース(dbt5304Entity.get(連番).getIkenItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称04(List<DbT5304ShujiiIkenshoIkenItemEntity> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).getIkenItem())) {
                return RString.EMPTY;
            }
            return IkenKomoku04.toValue(remove半角スペース(dbt5304Entity.get(連番).getIkenItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get状況改善(List<DbT5304ShujiiIkenshoIkenItemEntity> 調査項目,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前回調査項目, int 連番) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).getIkenItem())) {
            今回調査 = 調査項目.get(連番).getIkenItem();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).getIkenItem())) {
            前回調査 = 前回調査項目.get(連番).getIkenItem();
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private static RString get意見書状況結果(List<DbT5304ShujiiIkenshoIkenItemEntity> 調査項目,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前回調査項目, int 連番) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).getIkenItem())) {
            今回調査 = 調査項目.get(連番).getIkenItem();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).getIkenItem())) {
            前回調査 = 前回調査項目.get(連番).getIkenItem();
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    private static List<RString> 主治医差分(List<DbT5304ShujiiIkenshoIkenItemEntity> 意見書項目,
            List<DbT5304ShujiiIkenshoIkenItemEntity> dbt5304Entity, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 主治医意見書項目4リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())
                || 識別コード06A.equals(bodyItem.get厚労省IF識別コード())) {
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番13, 連番1).isEmpty() ? RString.EMPTY : get意見書名称03(dbt5304Entity, 連番13));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番14, 連番2).isEmpty() ? RString.EMPTY : get意見書名称04(dbt5304Entity, 連番14));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番15, 連番3).isEmpty() ? RString.EMPTY : get意見書名称05(dbt5304Entity, 連番15));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番16, 連番4).isEmpty() ? RString.EMPTY : get意見書名称06(dbt5304Entity, 連番16));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番68, 連番5).isEmpty() ? RString.EMPTY : get意見書名称14(dbt5304Entity, 連番68));
        }
        if (識別コード02A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番14, 連番1).isEmpty() ? RString.EMPTY : get意見書名称04(dbt5304Entity, 連番14));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番15, 連番2).isEmpty() ? RString.EMPTY : get意見書名称05(dbt5304Entity, 連番15));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番16, 連番3).isEmpty() ? RString.EMPTY : get意見書名称06(dbt5304Entity, 連番16));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番17, 連番4).isEmpty() ? RString.EMPTY : get意見書名称04(dbt5304Entity, 連番17));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番18, 連番5).isEmpty() ? RString.EMPTY : get意見書名称05(dbt5304Entity, 連番18));
        }
        return 主治医意見書項目4リスト;
    }

    private static RString 差分結果(List<DbT5304ShujiiIkenshoIkenItemEntity> 意見書項目,
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前回意見書項目, int 連番, int 項目連番) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).getIkenItem())) {
            今回調査 = 意見書項目.get(連番).getIkenItem();
        }
        if (連番 < 前回意見書項目.size()) {
            RString 前回厚労省IF識別コード
                    = 前回意見書項目.get(0).getKoroshoIfShikibetsuCode() == null || 前回意見書項目.get(0).getKoroshoIfShikibetsuCode().isEmpty()
                    ? RString.EMPTY : 前回意見書項目.get(0).getKoroshoIfShikibetsuCode().value();
            int 前回連番 = change主治医差分連番(前回厚労省IF識別コード, 項目連番);
            前回連番 = 前回連番 == 0 ? 連番 : 前回連番;
            if (!RString.isNullOrEmpty(前回意見書項目.get(前回連番).getIkenItem())) {
                RString 前回調査 = 前回意見書項目.get(前回連番).getIkenItem();
                if (!今回調査.equals(前回調査)) {
                    return 前回調査;
                }
            }
        }
        return RString.EMPTY;
    }

    private static int change主治医差分連番(RString 前回厚労省IF識別コード, int 連番) {
        if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)
                || 識別コード06A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番13;
            } else if (連番 == 連番2) {
                return 連番14;
            } else if (連番 == 連番3) {
                return 連番15;
            } else if (連番 == 連番4) {
                return 連番16;
            } else if (連番 == 連番5) {
                return 連番68;
            }
        } else if (識別コード02A.equals(前回厚労省IF識別コード) || 識別コード99A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番14;
            } else if (連番 == 連番2) {
                return 連番15;
            } else if (連番 == 連番3) {
                return 連番16;
            } else if (連番 == 連番4) {
                return 連番17;
            } else if (連番 == 連番5) {
                return 連番18;
            }
        }
        return 0;
    }

    private static RString get名称16(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser16.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称15(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser15.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称14(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser14.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString remove半角スペース(RString 編集前コード) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(編集前コード);
        builder.replace(" ", "");
        return builder.toRString();
    }

    private static RString get調査連番(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目, int 連番) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).getResearchItem())) {
            今回調査 = 調査項目.get(連番).getResearchItem();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).getResearchItem())) {
            前回調査 = 前回調査項目.get(連番).getResearchItem();
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private static RString get状況結果(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目, int 連番) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).getResearchItem())) {
            今回調査 = 調査項目.get(連番).getResearchItem();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).getResearchItem())) {
            前回調査 = 前回調査項目.get(連番).getResearchItem();
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    private static List<RString> 認知機能(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, IchijihanteikekkahyoEntity bodyItem) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        if (識別コード09B.equals(bodyItem.get厚労省IF識別コード()) || 識別コード09A.equals(bodyItem.get厚労省IF識別コード())) {
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番32, 連番1).isEmpty() ? RString.EMPTY : get名称14(dbt5211Entity, 連番32));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番33, 連番2).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番33));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番34, 連番3).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番34));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番35, 連番4).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番35));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番36, 連番5).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番36));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番37, 連番6).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番37));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番38, 連番7).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番38));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番39, 連番8).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番39));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番40, 連番9).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番40));
        }
        if (識別コード99A.equals(bodyItem.get厚労省IF識別コード())) {
            return set認知機能差分99A(調査項目, dbt5211Entity);
        }
        if (識別コード06A.equals(bodyItem.get厚労省IF識別コード()) || 識別コード02A.equals(bodyItem.get厚労省IF識別コード())) {
            return set認知機能差分02A(調査項目, dbt5211Entity);
        }
        return 認知機能4リスト;
    }

    private static List<RString> set認知機能差分02A(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番40, 連番1).isEmpty() ? RString.EMPTY : get名称14(dbt5211Entity, 連番40));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番42, 連番2).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番42));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番43, 連番3).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番43));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番44, 連番4).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番44));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番45, 連番5).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番45));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番46, 連番6).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番46));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番47, 連番7).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番47));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番57, 連番8).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番57));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番59, 連番9).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番59));
        return 認知機能4リスト;
    }

    private static List<RString> set認知機能差分99A(List<DbT5211NinteichosahyoChosaItemEntity> 調査項目,
            List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番46, 連番1).isEmpty() ? RString.EMPTY : get名称14(dbt5211Entity, 連番46));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番48, 連番2).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番48));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番49, 連番3).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番49));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番50, 連番4).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番50));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番51, 連番5).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番51));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番52, 連番6).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番52));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番53, 連番7).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番53));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番63, 連番8).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番63));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番65, 連番9).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番65));
        return 認知機能4リスト;
    }

    private static RString 機能差分結果(List<DbT5211NinteichosahyoChosaItemEntity> 意見書項目,
            List<DbT5211NinteichosahyoChosaItemEntity> 前回意見書項目, int 連番, int 項目連番) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).getResearchItem())) {
            今回調査 = 意見書項目.get(連番).getResearchItem();
        }
        if (連番 < 前回意見書項目.size()) {
            RString 前回厚労省IF識別コード
                    = 前回意見書項目.get(0).getKoroshoIfShikibetsuCode() == null || 前回意見書項目.get(0).getKoroshoIfShikibetsuCode().isEmpty()
                    ? RString.EMPTY : 前回意見書項目.get(0).getKoroshoIfShikibetsuCode().value();
            int 前回連番 = change連番(前回厚労省IF識別コード, 項目連番);
            前回連番 = 前回連番 == 0 ? 連番 : 前回連番;
            if (!RString.isNullOrEmpty(前回意見書項目.get(前回連番).getResearchItem())) {
                RString 前回調査 = 前回意見書項目.get(前回連番).getResearchItem();
                if (!今回調査.equals(前回調査)) {
                    return 前回調査;
                }
            }
        }
        return RString.EMPTY;
    }

    private static int change連番(RString 前回厚労省IF識別コード, int 連番) {
        if (識別コード09B.equals(前回厚労省IF識別コード) || 識別コード09A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番32;
            } else if (連番 == 連番2) {
                return 連番33;
            } else if (連番 == 連番3) {
                return 連番34;
            } else if (連番 == 連番4) {
                return 連番35;
            } else if (連番 == 連番5) {
                return 連番36;
            } else if (連番 == 連番6) {
                return 連番37;
            } else if (連番 == 連番7) {
                return 連番38;
            } else if (連番 == 連番8) {
                return 連番39;
            } else if (連番 == 連番9) {
                return 連番40;
            }
        } else if (識別コード99A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番46;
            } else if (連番 == 連番2) {
                return 連番48;
            } else if (連番 == 連番3) {
                return 連番49;
            } else if (連番 == 連番4) {
                return 連番50;
            } else if (連番 == 連番5) {
                return 連番51;
            } else if (連番 == 連番6) {
                return 連番52;
            } else if (連番 == 連番7) {
                return 連番53;
            } else if (連番 == 連番8) {
                return 連番63;
            } else if (連番 == 連番9) {
                return 連番65;
            }
        } else if (識別コード06A.equals(前回厚労省IF識別コード) || 識別コード02A.equals(前回厚労省IF識別コード)) {
            if (連番 == 連番1) {
                return 連番40;
            } else if (連番 == 連番2) {
                return 連番42;
            } else if (連番 == 連番3) {
                return 連番43;
            } else if (連番 == 連番4) {
                return 連番44;
            } else if (連番 == 連番5) {
                return 連番45;
            } else if (連番 == 連番6) {
                return 連番46;
            } else if (連番 == 連番7) {
                return 連番47;
            } else if (連番 == 連番8) {
                return 連番57;
            } else if (連番 == 連番9) {
                return 連番59;
            }
        }
        return 0;
    }

    private static RString get名称04(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser04.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称03(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser03.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称02(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser02.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称01(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser01.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称22(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser22.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称21(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser21.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称09(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser09.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称08(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser08.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称07(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser07.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称06(List<DbT5211NinteichosahyoChosaItemEntity> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).getResearchItem())) {
                return RString.EMPTY;
            }
            return ChosaAnser06.toValue(remove半角スペース(dbt5211Entity.get(連番).getResearchItem())).get名称();
        }
        return RString.EMPTY;
    }
}
