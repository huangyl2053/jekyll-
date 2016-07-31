/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.db.dbe.entity.report.source.saichekkuhyo.SaiChekkuhyoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査票差異チェック票(裏)のEditorです。
 *
 * @reamsid_L DBE-0080-060 xuyannan
 */
public class SaiChekkuhyoRyoumenUraEditorImpl implements ISaiChekkuhyoRyoumenEditor {

    private static final int 一回目 = 1;
    private static final int 二回目 = 2;
    private static final int 三回目 = 3;
    private static final int 四回目 = 4;
    private static final int 五回目 = 5;
    private static final int 六回目 = 6;
    private static final int 七回目 = 7;
    private static final int 八回目 = 8;
    private static final int 九回目 = 9;
    private static final int 十回目 = 10;
    private static final int 十一回目 = 11;
    private static final int 十二回目 = 12;
    private static final int 十三回目 = 13;
    private static final int 十四回目 = 14;
    private static final int 十五回目 = 15;
    private static final int 十六回目 = 16;
    private static final int 十七回目 = 17;
    private static final int 十八回目 = 18;
    private static final int 十九回目 = 19;
    private static final int 二十回目 = 20;
    private final SaiChekkuhyoItem item;
    private final int i;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link SaiChekkuhyoItem}
     * @param i 繰り返しCount
     */
    protected SaiChekkuhyoRyoumenUraEditorImpl(SaiChekkuhyoItem item, int i) {
        this.item = item;
        this.i = i;
    }

    /**
     * 帳票用データを編集します。
     *
     * @param source 要介護認定調査票差異チェック票のReportSource
     * @return SaiChekkuhyoReportSource
     */
    @Override
    public SaiChekkuhyoReportSource edit(SaiChekkuhyoReportSource source) {
        return editSource(source, i);
    }

    private SaiChekkuhyoReportSource editSource(SaiChekkuhyoReportSource source, int i) {
        switch (i) {
            case 一回目:
                source.listIchigun_1 = setChosaAnser01(item.getListIchigun_1());
                source.listNigun_1 = getChosaAnser10(item.getListNigun_1());
                source.listSangun_1 = getChosaAnser14(item.getListSangun_1());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_1());
                source.listGogun_1 = getChosaAnser12(item.getListGogun_1());
                source.listRokugun_1 = setChosaAnser01(item.getListRokugun_1());
                source.listJiritsudo_1 = item.getListJiritsudo_1();
                break;
            case 二回目:
                source.listIchigun_1 = setChosaAnser01(item.getListIchigun_2());
                source.listNigun_1 = getChosaAnser10(item.getListNigun_2());
                source.listSangun_1 = getChosaAnser15(item.getListSangun_2());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_2());
                source.listGogun_1 = getChosaAnser12(item.getListGogun_2());
                source.listRokugun_1 = setChosaAnser01(item.getListRokugun_2());
                source.listJiritsudo_1 = item.getListJiritsudo_2();
                break;
            case 三回目:
                source.listIchigun_1 = setChosaAnser01(item.getListIchigun_3());
                source.listNigun_1 = getChosaAnser11(item.getListNigun_3());
                source.listSangun_1 = getChosaAnser15(item.getListSangun_3());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_3());
                source.listGogun_1 = getChosaAnser17(item.getListGogun_3());
                source.listRokugun_1 = setChosaAnser01(item.getListRokugun_3());
                break;
            case 四回目:
                source.listIchigun_1 = setChosaAnser01(item.getListIchigun_4());
                source.listNigun_1 = getChosaAnser10(item.getListNigun_4());
                source.listSangun_1 = getChosaAnser15(item.getListSangun_4());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_4());
                source.listGogun_1 = setChosaAnser16(item.getListGogun_4());
                source.listRokugun_1 = setChosaAnser01(item.getListRokugun_4());
                break;
            case 五回目:
                source.listIchigun_1 = setChosaAnser01(item.getListIchigun_5());
                source.listNigun_1 = getChosaAnser10(item.getListNigun_5());
                source.listSangun_1 = getChosaAnser15(item.getListSangun_5());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_5());
                source.listGogun_1 = getChosaAnser10(item.getListGogun_5());
                source.listRokugun_1 = setChosaAnser01(item.getListRokugun_5());
                break;
            case 六回目:
                source.listIchigun_1 = setChosaAnser01(item.getListIchigun_6());
                source.listNigun_1 = getChosaAnser10(item.getListNigun_6());
                source.listSangun_1 = getChosaAnser15(item.getListSangun_6());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_6());
                source.listGogun_1 = getChosaAnser10(item.getListGogun_6());
                source.listRokugun_1 = setChosaAnser01(item.getListRokugun_6());
                break;
            case 七回目:
                source.listIchigun_1 = setChosaAnser01(item.getListIchigun_7());
                source.listNigun_1 = getChosaAnser12(item.getListNigun_7());
                source.listSangun_1 = getChosaAnser15(item.getListSangun_7());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_7());
                source.listRokugun_1 = setChosaAnser01(item.getListRokugun_7());
                break;
            case 八回目:
                source.listIchigun_1 = setChosaAnser01(item.getListIchigun_8());
                source.listNigun_1 = getChosaAnser12(item.getListNigun_8());
                source.listSangun_1 = setChosaAnser16(item.getListSangun_8());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_8());
                source.listRokugun_1 = setChosaAnser01(item.getListRokugun_8());
                break;
            case 九回目:
                source.listIchigun_1 = setChosaAnser01(item.getListIchigun_9());
                source.listNigun_1 = getChosaAnser12(item.getListNigun_9());
                source.listSangun_1 = setChosaAnser16(item.getListSangun_9());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_9());
                source.listRokugun_1 = setChosaAnser01(item.getListRokugun_9());
                break;
            case 十回目:
                source.listIchigun_1 = getChosaAnser02(item.getListIchigun_10());
                source.listNigun_1 = getChosaAnser10(item.getListNigun_10());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_10());
                source.listRokugun_1 = setChosaAnser01(item.getListRokugun_10());
                break;
            default:
                editOtherSource(source, i);
        }
        source.layout = Layouts.必須;
        return source;
    }

    private SaiChekkuhyoReportSource editOtherSource(SaiChekkuhyoReportSource source, int i) {
        switch (i) {
            case 十一回目:
                source.listIchigun_1 = getChosaAnser02(item.getListIchigun_11());
                source.listNigun_1 = getChosaAnser10(item.getListNigun_11());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_11());
                source.listRokugun_1 = setChosaAnser01(item.getListRokugun_11());
                break;
            case 十二回目:
                source.listIchigun_1 = getChosaAnser03(item.getListIchigun_12());
                source.listNigun_1 = getChosaAnser13(item.getListNigun_12());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_12());
                source.listRokugun_1 = setChosaAnser01(item.getListRokugun_12());
                break;
            case 十三回目:
                source.listIchigun_1 = getChosaAnser04(item.getListIchigun_13());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_13());
                break;
            case 十四回目:
                source.listIchigun_1 = getChosaAnser02(item.getListIchigun_14());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_14());
                break;
            case 十五回目:
                source.listIchigun_1 = getChosaAnser02(item.getListIchigun_15());
                source.listYongun_1 = setChosaAnser16(item.getListYongun_15());
                break;
            case 十六回目:
                source.listIchigun_1 = getChosaAnser04(item.getListIchigun_16());
                break;
            case 十七回目:
                source.listIchigun_1 = getChosaAnser06(item.getListIchigun_17());
                break;
            case 十八回目:
                source.listIchigun_1 = getChosaAnser07(item.getListIchigun_18());
                break;
            case 十九回目:
                source.listIchigun_1 = getChosaAnser08(item.getListIchigun_19());
                break;
            case 二十回目:
                source.listIchigun_1 = getChosaAnser09(item.getListIchigun_20());
                break;
            default:
                break;
        }
        return source;
    }

    private RString setChosaAnser01(RString chosakekkaNo) {
        RString chosaAnser;
        if (ChosaAnser01.あり.getコード().equals(chosakekkaNo)) {
            chosaAnser = ChosaAnser01.あり.get名称();
        } else {
            chosaAnser = ChosaAnser01.なし.get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser02(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser02.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser03(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser03.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser04(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser04.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser06(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser06.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser07(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser07.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser08(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser08.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser09(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser09.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser10(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser10.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser11(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser11.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser12(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser12.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser13(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser13.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser14(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser14.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser15(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser15.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }

    private RString setChosaAnser16(RString chosakekkaNo) {
        RString chosaAnser;
        if (ChosaAnser16.ある.getコード().equals(chosakekkaNo)) {
            chosaAnser = ChosaAnser16.ある.get名称();
        } else {
            chosaAnser = ChosaAnser16.ない.get名称();
        }
        return chosaAnser;
    }

    private RString getChosaAnser17(RString chosakekkaNo) {
        RString chosaAnser = RString.EMPTY;
        if (!RString.isNullOrEmpty(chosakekkaNo)) {
            chosaAnser = ChosaAnser17.toValue(chosakekkaNo).get名称();
        }
        return chosaAnser;
    }
}
