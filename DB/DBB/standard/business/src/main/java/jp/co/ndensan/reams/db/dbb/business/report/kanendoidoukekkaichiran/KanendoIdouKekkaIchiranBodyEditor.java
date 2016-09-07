/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidoukekkaichiran.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表 KanendoIdouKekkaIchiranBodyEditorです。
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
public class KanendoIdouKekkaIchiranBodyEditor implements IKanendoIdouKekkaIchiranEditor {

    private final KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity;
    private final KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity;
    private final YMDHMS 調定日時;
    private final Association association;

    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_10 = 10;
    private static final int NUM_11 = 11;
    private static final int NUM_12 = 12;
    private static final char CHAR_0 = '0';
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 更正前後区分_更正後 = new RString("2");
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final List<RString> 改頁項目List;

    /**
     * インスタンスを生成します。
     *
     * @param inputEntity {@link KanendoIdouKekkaIchiranInputEntity}
     */
    protected KanendoIdouKekkaIchiranBodyEditor(KanendoIdouKekkaIchiranInputEntity inputEntity) {
        this.並び順の１件目 = inputEntity.get並び順の１件目();
        this.並び順の２件目 = inputEntity.get並び順の２件目();
        this.並び順の３件目 = inputEntity.get並び順の３件目();
        this.並び順の４件目 = inputEntity.get並び順の４件目();
        this.並び順の５件目 = inputEntity.get並び順の５件目();
        this.改頁項目List = inputEntity.get改頁項目List();
        調定日時 = inputEntity.get調定日時();
        計算後情報_宛名_口座_更正前Entity = inputEntity.get計算後情報_宛名_口座_更正前Entity();
        if (null != 計算後情報_宛名_口座_更正前Entity) {
            計算後情報_宛名_口座_更正前Entity.set更正前後区分(更正前後区分_更正前);
        }
        計算後情報_宛名_口座_更正後Entity = inputEntity.get計算後情報_宛名_口座_更正後Entity();
        計算後情報_宛名_口座_更正後Entity.set更正前後区分(更正前後区分_更正後);
        association = inputEntity.getAssociation();
    }

    @Override
    public KanendoIdouKekkaIchiranSource edit(KanendoIdouKekkaIchiranSource source) {
        if (association.get地方公共団体コード() != null) {
            source.hokenshaNo = association.get地方公共団体コード().value();
        }
        if (association.get市町村名() != null) {
            source.hokenshaName = association.get市町村名();
        }
        set出力順And改ページ(source);
        if (null != 計算後情報_宛名_口座_更正前Entity) {
            if (null != 計算後情報_宛名_口座_更正前Entity.get通知書番号()) {
                source.list1_1 = 計算後情報_宛名_口座_更正前Entity.get通知書番号().value();
            }
            set宛名口座_更正前(source);
            if (null != 計算後情報_宛名_口座_更正前Entity.get調定年度()) {
                source.list2_1 = 計算後情報_宛名_口座_更正前Entity.get調定年度().toDateString();
            }
            if (null != 計算後情報_宛名_口座_更正前Entity.get賦課年度()) {
                source.list2_2 = 計算後情報_宛名_口座_更正前Entity.get賦課年度().toDateString();
            }
            if (null != 計算後情報_宛名_口座_更正前Entity.get確定介護保険料_年額()) {
                source.list2_3 = new RString(計算後情報_宛名_口座_更正前Entity.get確定介護保険料_年額().toString());
            }
            if (null != 計算後情報_宛名_口座_更正前Entity.get減免前介護保険料_年額()) {
                source.list2_4 = new RString(計算後情報_宛名_口座_更正前Entity.get減免前介護保険料_年額().toString());
            }
            if (null != 計算後情報_宛名_口座_更正前Entity.get減免額()) {
                source.list2_5 = new RString(計算後情報_宛名_口座_更正前Entity.get減免額().toString());
            }
            set月別取得段階(計算後情報_宛名_口座_更正前Entity, source);
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴歳出還付額()) {
            source.list2_18 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴歳出還付額().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get調定年度()) {
            source.list3_1 = 計算後情報_宛名_口座_更正後Entity.get調定年度().toDateString();
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get賦課年度()) {
            source.list3_2 = 計算後情報_宛名_口座_更正後Entity.get賦課年度().toDateString();
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get確定介護保険料_年額()) {
            source.list3_3 = new RString(計算後情報_宛名_口座_更正後Entity.get確定介護保険料_年額().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get減免前介護保険料_年額()) {
            source.list3_4 = new RString(計算後情報_宛名_口座_更正後Entity.get減免前介護保険料_年額().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get減免額()) {
            source.list3_5 = new RString(計算後情報_宛名_口座_更正後Entity.get減免額().toString());
        }
        set月別取得段階(計算後情報_宛名_口座_更正後Entity, source);
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴歳出還付額()) {
            source.list3_18 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴歳出還付額().toString());
        }

        source.list4_1 = 調定日時.getDate().wareki().toDateString();
        set特徴期別金額_更正前(source);
        set普徴期別金額_更正前1(source);

        source.list5_1 = 調定日時.getDate().wareki().toDateString();
        set特徴期別金額_更正後(source);
        set普徴期別金額_更正後1(source);

        source.list6_1 = 計算後情報_宛名_口座_更正後Entity.get調定事由1();
        source.list7_1 = 計算後情報_宛名_口座_更正後Entity.get調定事由2();
        source.list8_1 = 計算後情報_宛名_口座_更正後Entity.get調定事由3();
        source.list9_1 = 計算後情報_宛名_口座_更正後Entity.get調定事由4();
        source.list10_1 = RString.EMPTY;
        return source;
    }

    private void set宛名口座_更正前(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正前Entity.get宛名Entity()) {
            AtenaMeisho 氏名 = 計算後情報_宛名_口座_更正前Entity.get宛名Entity().getKanjiShimei();
            if (null != 氏名) {
                source.list1_2 = 氏名.value();
            }
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(計算後情報_宛名_口座_更正前Entity.get宛名Entity());
            if (null != kojin && null != kojin.get住所()) {
                source.list1_3 = kojin.get住所().get住所();
            }
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get口座Entity()) {
            IKoza koza = new Koza(計算後情報_宛名_口座_更正前Entity.get口座Entity());
            if (null != koza.get金融機関コード()) {
                source.list1_4 = koza.get金融機関コード().value();
            }
            if (null != koza.get預金種別()) {
                source.list1_5 = koza.get預金種別().get預金種別略称().substringReturnAsPossible(NUM_0, NUM_2);
            }
            source.list1_6 = koza.get口座番号();
            if (null != koza.get金融機関()) {
                source.list2_19 = koza.get金融機関().get金融機関名称();
            }
            if (null != koza.get口座名義人()) {
                source.list3_19 = koza.get口座名義人().value();
            }
        }
    }

    private void set特徴期別金額_更正前(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正前Entity.get特徴期別金額01()) {
            source.list4_2 = new RString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額01().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get特徴期別金額02()) {
            source.list4_3 = new RString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額02().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get特徴期別金額03()) {
            source.list4_4 = new RString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額03().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get特徴期別金額04()) {
            source.list4_5 = new RString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額04().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get特徴期別金額05()) {
            source.list4_6 = new RString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額05().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get特徴期別金額06()) {
            source.list4_7 = new RString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額06().toString());
        }
    }

    private void set普徴期別金額_更正前1(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額01() && !source.listFuchoKi_1.isEmpty()) {
            source.list4_8 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額01().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額02() && !source.listFuchoKi_2.isEmpty()) {
            source.list4_9 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額02().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額03() && !source.listFuchoKi_3.isEmpty()) {
            source.list4_10 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額03().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額04() && !source.listFuchoKi_4.isEmpty()) {
            source.list4_11 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額04().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額05() && !source.listFuchoKi_5.isEmpty()) {
            source.list4_12 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額05().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額06() && !source.listFuchoKi_6.isEmpty()) {
            source.list4_13 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額06().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額07() && !source.listFuchoKi_7.isEmpty()) {
            source.list4_14 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額07().toString());
        }
        set普徴期別金額_更正前2(source);
    }

    private void set普徴期別金額_更正前2(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額08() && !source.listFuchoKi_8.isEmpty()) {
            source.list4_15 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額08().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額09() && !source.listFuchoKi_9.isEmpty()) {
            source.list4_16 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額09().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額10() && !source.listFuchoKi_10.isEmpty()) {
            source.list4_17 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額10().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額11() && !source.listFuchoKi_11.isEmpty()) {
            source.list4_18 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額11().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額12() && !source.listFuchoKi_12.isEmpty()) {
            source.list4_19 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額12().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額13() && !source.listFuchoKi_13.isEmpty()) {
            source.list4_20 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額13().toString());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額14() && !source.listFuchoKi_14.isEmpty()) {
            source.list4_21 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額14().toString());
        }
    }

    private void set特徴期別金額_更正後(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴期別金額01()) {
            source.list5_2 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額01().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴期別金額02()) {
            source.list5_3 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額02().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴期別金額03()) {
            source.list5_4 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額03().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴期別金額04()) {
            source.list5_5 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額04().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴期別金額05()) {
            source.list5_6 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額05().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴期別金額06()) {
            source.list5_7 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額06().toString());
        }
    }

    private void set普徴期別金額_更正後1(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額01() && !source.listFuchoKi_1.isEmpty()) {
            source.list5_8 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額01().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額02() && !source.listFuchoKi_2.isEmpty()) {
            source.list5_9 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額02().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額03() && !source.listFuchoKi_3.isEmpty()) {
            source.list5_10 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額03().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額04() && !source.listFuchoKi_4.isEmpty()) {
            source.list5_11 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額04().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額05() && !source.listFuchoKi_5.isEmpty()) {
            source.list5_12 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額05().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額06() && !source.listFuchoKi_6.isEmpty()) {
            source.list5_13 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額06().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額07() && !source.listFuchoKi_7.isEmpty()) {
            source.list5_14 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額07().toString());
        }
        set普徴期別金額_更正後2(source);
    }

    private void set普徴期別金額_更正後2(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額08() && !source.listFuchoKi_8.isEmpty()) {
            source.list5_15 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額08().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額09() && !source.listFuchoKi_9.isEmpty()) {
            source.list5_16 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額09().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額10() && !source.listFuchoKi_10.isEmpty()) {
            source.list5_17 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額10().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額11() && !source.listFuchoKi_11.isEmpty()) {
            source.list5_18 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額11().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額12() && !source.listFuchoKi_12.isEmpty()) {
            source.list5_19 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額12().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額13() && !source.listFuchoKi_13.isEmpty()) {
            source.list5_20 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額13().toString());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額14() && !source.listFuchoKi_14.isEmpty()) {
            source.list5_21 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額14().toString());
        }
    }

    private void set月別取得段階(KeisangojohoAtenaKozaEntity entity, KanendoIdouKekkaIchiranSource item) {
        RString 更正前後区分 = entity.get更正前後区分();

        FlexibleYearMonth 月割開始年月1 = entity.get月割開始年月1();
        FlexibleYearMonth 月割終了年月1 = entity.get月割終了年月1();
        if (null != 月割開始年月1 && null != 月割終了年月1) {
            int 開始月1 = 月割開始年月1.getMonthValue();
            int 終了月1 = 月割終了年月1.getMonthValue();
            RString 保険料算定段階1 = entity.get保険料算定段階1().substring(NUM_0, NUM_2).trimStart(CHAR_0);
            set月別取得段階(item, 開始月1, 終了月1, 保険料算定段階1, 更正前後区分);
        }

        FlexibleYearMonth 月割開始年月2 = entity.get月割開始年月2();
        FlexibleYearMonth 月割終了年月2 = entity.get月割終了年月2();
        if (null != 月割開始年月2 && null != 月割終了年月2) {
            int 開始月2 = 月割開始年月2.getMonthValue();
            int 終了月2 = 月割終了年月2.getMonthValue();
            RString 保険料算定段階2 = entity.get保険料算定段階2().substring(NUM_0, NUM_2).trimStart(CHAR_0);
            if (!月割開始年月2.isEmpty() && !月割終了年月2.isEmpty() && !保険料算定段階2.isEmpty()) {
                set月別取得段階(item, 開始月2, 終了月2, 保険料算定段階2, 更正前後区分);
            }
        }

    }

    private void set月別取得段階(KanendoIdouKekkaIchiranSource item, int 開始月, int 終了月,
            RString 保険料算定段階, RString 更正前後区分) {
        for (int i = 開始月; i <= (開始月 > 終了月 ? (終了月 + NUM_12) : 終了月); i++) {
            int currentMonth = (i - 1) % NUM_12 + 1;
            if (更正前後区分_更正前.equals(更正前後区分)) {
                set更正前_保険料算定段階(item, currentMonth, 保険料算定段階);
            } else if (更正前後区分_更正後.equals(更正前後区分)) {
                set更正後_保険料算定段階(item, currentMonth, 保険料算定段階);
            }
        }
    }

    private void set更正前_保険料算定段階(KanendoIdouKekkaIchiranSource item,
            int currentMonth, RString 保険料算定段階) {
        switch (currentMonth) {
            case NUM_1:
                item.list2_15 = 保険料算定段階;
                break;
            case NUM_2:
                item.list2_16 = 保険料算定段階;
                break;
            case NUM_3:
                item.list2_17 = 保険料算定段階;
                break;
            case NUM_4:
                item.list2_6 = 保険料算定段階;
                break;
            case NUM_5:
                item.list2_7 = 保険料算定段階;
                break;
            case NUM_6:
                item.list2_8 = 保険料算定段階;
                break;
            case NUM_7:
                item.list2_9 = 保険料算定段階;
                break;
            case NUM_8:
                item.list2_10 = 保険料算定段階;
                break;
            case NUM_9:
                item.list2_11 = 保険料算定段階;
                break;
            case NUM_10:
                item.list2_12 = 保険料算定段階;
                break;
            case NUM_11:
                item.list2_13 = 保険料算定段階;
                break;
            case NUM_12:
                item.list2_14 = 保険料算定段階;
                break;
            default:
                break;
        }
    }

    private void set更正後_保険料算定段階(KanendoIdouKekkaIchiranSource item,
            int currentMonth, RString 保険料算定段階) {
        switch (currentMonth) {
            case NUM_1:
                item.list3_15 = 保険料算定段階;
                break;
            case NUM_2:
                item.list3_16 = 保険料算定段階;
                break;
            case NUM_3:
                item.list3_17 = 保険料算定段階;
                break;
            case NUM_4:
                item.list3_6 = 保険料算定段階;
                break;
            case NUM_5:
                item.list3_7 = 保険料算定段階;
                break;
            case NUM_6:
                item.list3_8 = 保険料算定段階;
                break;
            case NUM_7:
                item.list3_9 = 保険料算定段階;
                break;
            case NUM_8:
                item.list3_10 = 保険料算定段階;
                break;
            case NUM_9:
                item.list3_11 = 保険料算定段階;
                break;
            case NUM_10:
                item.list3_12 = 保険料算定段階;
                break;
            case NUM_11:
                item.list3_13 = 保険料算定段階;
                break;
            case NUM_12:
                item.list3_14 = 保険料算定段階;
                break;
            default:
                break;
        }
    }

    private void set出力順And改ページ(KanendoIdouKekkaIchiranSource source) {
        source.shutsuryokujun1 = 並び順の１件目;
        source.shutsuryokujun2 = 並び順の２件目;
        source.shutsuryokujun3 = 並び順の３件目;
        source.shutsuryokujun4 = 並び順の４件目;
        source.shutsuryokujun5 = 並び順の５件目;
        if (null != 改頁項目List && !改頁項目List.isEmpty()) {
            if (改頁項目List.size() > NUM_0) {
                source.kaipage1 = 改頁項目List.get(NUM_0);
            }
            if (改頁項目List.size() > NUM_1) {
                source.kaipage2 = 改頁項目List.get(NUM_1);
            }
            if (改頁項目List.size() > NUM_2) {
                source.kaipage3 = 改頁項目List.get(NUM_2);
            }
            if (改頁項目List.size() > NUM_3) {
                source.kaipage4 = 改頁項目List.get(NUM_3);
            }
            if (改頁項目List.size() > NUM_4) {
                source.kaipage5 = 改頁項目List.get(NUM_4);
            }
        }
    }

}
