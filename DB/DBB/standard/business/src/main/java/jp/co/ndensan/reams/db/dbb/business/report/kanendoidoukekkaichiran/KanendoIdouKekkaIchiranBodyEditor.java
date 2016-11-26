/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidoukekkaichiran.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表 KanendoIdouKekkaIchiranBodyEditorです。
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
public class KanendoIdouKekkaIchiranBodyEditor implements IKanendoIdouKekkaIchiranEditor {

    private final KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正前Entity;
    private final KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座_更正後Entity;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final YMDHMS 調定日時;
    private final Association association;

    private static final int NUMBER_0 = 0;
    private static final int NUMBER_1 = 1;
    private static final int NUMBER_2 = 2;
    private static final int NUMBER_3 = 3;
    private static final int NUMBER_4 = 4;
    private static final int NUMBER_5 = 5;
    private static final int NUMBER_6 = 6;
    private static final int NUMBER_7 = 7;
    private static final int NUMBER_8 = 8;
    private static final int NUMBER_9 = 9;
    private static final int NUMBER_10 = 10;
    private static final int NUMBER_11 = 11;
    private static final int NUMBER_12 = 12;
    private static final char CHAR_0 = '0';
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 更正前後区分_更正後 = new RString("2");
    private static final RString 年 = new RString("年");
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final List<RString> 改頁項目List;

    private static final RString 識別コード = new RString("識別コード");
    private static final RString 氏名５０音カナ = new RString("氏名５０音カナ");
    private static final RString 生年月日 = new RString("生年月日");
    private static final RString 性別 = new RString("性別");
    private static final RString 市町村コード = new RString("市町村コード");
    private static final RString 賦課年度 = new RString("賦課年度");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 年金コード = new RString("年金コード");
    private static final RString 年金番号 = new RString("年金番号");

    /**
     * インスタンスを生成します。
     *
     * @param inputEntity {@link KanendoIdouKekkaIchiranInputEntity}
     * @param 帳票制御共通 帳票制御共通
     */
    protected KanendoIdouKekkaIchiranBodyEditor(KanendoIdouKekkaIchiranInputEntity inputEntity, ChohyoSeigyoKyotsu 帳票制御共通) {
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
        this.帳票制御共通 = 帳票制御共通;
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
            source.list2_1 = get年度(計算後情報_宛名_口座_更正前Entity.get調定年度());
            source.list2_2 = get年度(計算後情報_宛名_口座_更正前Entity.get賦課年度());
            if (null != 計算後情報_宛名_口座_更正前Entity.get確定介護保険料_年額()) {
                source.list2_3 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get確定介護保険料_年額());
            }
            if (null != 計算後情報_宛名_口座_更正前Entity.get減免前介護保険料_年額()) {
                source.list2_4 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get減免前介護保険料_年額());
            }
            if (null != 計算後情報_宛名_口座_更正前Entity.get減免額()) {
                source.list2_5 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get減免額());
            }
            set月別取得段階(計算後情報_宛名_口座_更正前Entity, source);
            set特徴期別金額_更正前(source);
            set普徴期別金額_更正前1(source);
            source.list4_1 = 計算後情報_宛名_口座_更正前Entity.get調定日時().getDate().wareki().toDateString();
        }
        set宛名口座_更正後(source);
        if (null != 計算後情報_宛名_口座_更正後Entity.get通知書番号()) {
            source.list1_1 = 計算後情報_宛名_口座_更正後Entity.get通知書番号().value();
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴歳出還付額()) {
            source.list2_18 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get特徴歳出還付額());
        }
        source.list3_1 = get年度(計算後情報_宛名_口座_更正後Entity.get調定年度());
        source.list3_2 = get年度(計算後情報_宛名_口座_更正後Entity.get賦課年度());
        if (null != 計算後情報_宛名_口座_更正後Entity.get確定介護保険料_年額()) {
            source.list3_3 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get確定介護保険料_年額());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get減免前介護保険料_年額()) {
            source.list3_4 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get減免前介護保険料_年額());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get減免額()) {
            source.list3_5 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get減免額());
        }
        set月別取得段階(計算後情報_宛名_口座_更正後Entity, source);
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴歳出還付額()) {
            source.list3_18 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴歳出還付額());
        }

        source.list5_1 = 計算後情報_宛名_口座_更正後Entity.get調定日時().getDate().wareki().toDateString();
        set特徴期別金額_更正後(source);
        set普徴期別金額_更正後1(source);

        source.list6_1 = RString.isNullOrEmpty(計算後情報_宛名_口座_更正後Entity.get調定事由1())
                ? RString.EMPTY : ChoteiJiyuCode.toValue(計算後情報_宛名_口座_更正後Entity.get調定事由1()).get名称();
        source.list7_1 = RString.isNullOrEmpty(計算後情報_宛名_口座_更正後Entity.get調定事由2())
                ? RString.EMPTY : ChoteiJiyuCode.toValue(計算後情報_宛名_口座_更正後Entity.get調定事由2()).get名称();
        source.list8_1 = RString.isNullOrEmpty(計算後情報_宛名_口座_更正後Entity.get調定事由3())
                ? RString.EMPTY : ChoteiJiyuCode.toValue(計算後情報_宛名_口座_更正後Entity.get調定事由3()).get名称();
        source.list9_1 = RString.isNullOrEmpty(計算後情報_宛名_口座_更正後Entity.get調定事由4())
                ? RString.EMPTY : ChoteiJiyuCode.toValue(計算後情報_宛名_口座_更正後Entity.get調定事由4()).get名称();
        source.list10_1 = RString.EMPTY;
        set追加項目(source);
        return source;
    }

    private RString get年度(FlexibleYear 年度) {
        return null == 年度 ? RString.EMPTY
                : 年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(年);
    }

    private void set宛名口座_更正後(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正後Entity.get宛名Entity()) {
            AtenaMeisho 氏名 = 計算後情報_宛名_口座_更正後Entity.get宛名Entity().getKanjiShimei();
            if (null != 氏名) {
                source.list1_2 = 氏名.value();
            }
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(計算後情報_宛名_口座_更正後Entity.get宛名Entity());
            if (null != kojin) {
                source.list1_3 = JushoHenshu.editJusho(帳票制御共通, kojin, association);
            }
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get口座Entity()) {
            IKoza koza = new Koza(計算後情報_宛名_口座_更正後Entity.get口座Entity());
            if (null != koza.get金融機関コード()) {
                source.list1_4 = koza.getCombined金融機関コードand支店コード();
            }
            if (null != koza.get預金種別()) {
                source.list1_5 = koza.get預金種別().get預金種別略称().substringReturnAsPossible(NUMBER_0, NUMBER_2);
            }
            source.list1_6 = koza.get口座番号();
            if (null != koza.get金融機関()) {
                source.list2_19 = koza.getCombined金融機関名and支店名();
            }
            if (null != koza.get口座名義人()) {
                source.list3_19 = koza.get口座名義人().value();
            }
        }
    }

    private void set特徴期別金額_更正前(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正前Entity.get特徴期別金額01()) {
            source.list4_2 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get特徴期別金額01());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get特徴期別金額02()) {
            source.list4_3 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get特徴期別金額02());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get特徴期別金額03()) {
            source.list4_4 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get特徴期別金額03());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get特徴期別金額04()) {
            source.list4_5 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get特徴期別金額04());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get特徴期別金額05()) {
            source.list4_6 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get特徴期別金額05());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get特徴期別金額06()) {
            source.list4_7 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get特徴期別金額06());
        }
    }

    private void set普徴期別金額_更正前1(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額01() && !source.listFuchoKi_1.isEmpty()) {
            source.list4_8 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額01());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額02() && !source.listFuchoKi_2.isEmpty()) {
            source.list4_9 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額02());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額03() && !source.listFuchoKi_3.isEmpty()) {
            source.list4_10 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額03());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額04() && !source.listFuchoKi_4.isEmpty()) {
            source.list4_11 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額04());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額05() && !source.listFuchoKi_5.isEmpty()) {
            source.list4_12 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額05());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額06() && !source.listFuchoKi_6.isEmpty()) {
            source.list4_13 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額06());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額07() && !source.listFuchoKi_7.isEmpty()) {
            source.list4_14 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額07());
        }
        set普徴期別金額_更正前2(source);
    }

    private void set普徴期別金額_更正前2(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額08() && !source.listFuchoKi_8.isEmpty()) {
            source.list4_15 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額08());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額09() && !source.listFuchoKi_9.isEmpty()) {
            source.list4_16 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額09());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額10() && !source.listFuchoKi_10.isEmpty()) {
            source.list4_17 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額10());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額11() && !source.listFuchoKi_11.isEmpty()) {
            source.list4_18 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額11());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額12() && !source.listFuchoKi_12.isEmpty()) {
            source.list4_19 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額12());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額13() && !source.listFuchoKi_13.isEmpty()) {
            source.list4_20 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額13());
        }
        if (null != 計算後情報_宛名_口座_更正前Entity.get普徴期別金額14() && !source.listFuchoKi_14.isEmpty()) {
            source.list4_21 = toカンマ編集(計算後情報_宛名_口座_更正前Entity.get普徴期別金額14());
        }
    }

    private void set特徴期別金額_更正後(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴期別金額01()) {
            source.list5_2 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get特徴期別金額01());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴期別金額02()) {
            source.list5_3 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get特徴期別金額02());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴期別金額03()) {
            source.list5_4 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get特徴期別金額03());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴期別金額04()) {
            source.list5_5 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get特徴期別金額04());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴期別金額05()) {
            source.list5_6 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get特徴期別金額05());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get特徴期別金額06()) {
            source.list5_7 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get特徴期別金額06());
        }
    }

    private void set普徴期別金額_更正後1(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額01() && !source.listFuchoKi_1.isEmpty()) {
            source.list5_8 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額01());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額02() && !source.listFuchoKi_2.isEmpty()) {
            source.list5_9 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額02());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額03() && !source.listFuchoKi_3.isEmpty()) {
            source.list5_10 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額03());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額04() && !source.listFuchoKi_4.isEmpty()) {
            source.list5_11 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額04());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額05() && !source.listFuchoKi_5.isEmpty()) {
            source.list5_12 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額05());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額06() && !source.listFuchoKi_6.isEmpty()) {
            source.list5_13 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額06());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額07() && !source.listFuchoKi_7.isEmpty()) {
            source.list5_14 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額07());
        }
        set普徴期別金額_更正後2(source);
    }

    private void set普徴期別金額_更正後2(KanendoIdouKekkaIchiranSource source) {
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額08() && !source.listFuchoKi_8.isEmpty()) {
            source.list5_15 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額08());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額09() && !source.listFuchoKi_9.isEmpty()) {
            source.list5_16 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額09());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額10() && !source.listFuchoKi_10.isEmpty()) {
            source.list5_17 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額10());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額11() && !source.listFuchoKi_11.isEmpty()) {
            source.list5_18 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額11());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額12() && !source.listFuchoKi_12.isEmpty()) {
            source.list5_19 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額12());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額13() && !source.listFuchoKi_13.isEmpty()) {
            source.list5_20 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額13());
        }
        if (null != 計算後情報_宛名_口座_更正後Entity.get普徴期別金額14() && !source.listFuchoKi_14.isEmpty()) {
            source.list5_21 = toカンマ編集(計算後情報_宛名_口座_更正後Entity.get普徴期別金額14());
        }
    }

    private void set月別取得段階(KeisangojohoAtenaKozaEntity entity, KanendoIdouKekkaIchiranSource item) {
        RString 更正前後区分 = entity.get更正前後区分();

        FlexibleYearMonth 月割開始年月1 = entity.get月割開始年月1();
        FlexibleYearMonth 月割終了年月1 = entity.get月割終了年月1();
        if (null != 月割開始年月1 && !月割開始年月1.isEmpty() && null != 月割終了年月1 && !月割終了年月1.isEmpty()) {
            int 開始月1 = 月割開始年月1.getMonthValue();
            int 終了月1 = 月割終了年月1.getMonthValue();
            RString 保険料算定段階1 = entity.get保険料算定段階1().substring(NUMBER_0, NUMBER_2).trimStart(CHAR_0);
            set月別取得段階(item, 開始月1, 終了月1, 保険料算定段階1, 更正前後区分);
        }

        FlexibleYearMonth 月割開始年月2 = entity.get月割開始年月2();
        FlexibleYearMonth 月割終了年月2 = entity.get月割終了年月2();
        if (null != 月割開始年月2 && !月割開始年月2.isEmpty() && null != 月割終了年月2 && !月割終了年月2.isEmpty()) {
            int 開始月2 = 月割開始年月2.getMonthValue();
            int 終了月2 = 月割終了年月2.getMonthValue();
            RString 保険料算定段階2 = entity.get保険料算定段階2().substring(NUMBER_0, NUMBER_2).trimStart(CHAR_0);
            if (!月割開始年月2.isEmpty() && !月割終了年月2.isEmpty() && !保険料算定段階2.isEmpty()) {
                set月別取得段階(item, 開始月2, 終了月2, 保険料算定段階2, 更正前後区分);
            }
        }
    }

    private void set月別取得段階(KanendoIdouKekkaIchiranSource item, int 開始月, int 終了月,
            RString 保険料算定段階, RString 更正前後区分) {
        for (int i = 開始月; i <= (開始月 > 終了月 ? (終了月 + NUMBER_12) : 終了月); i++) {
            int currentMonth = (i - 1) % NUMBER_12 + 1;
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
            case NUMBER_1:
                item.list2_15 = 保険料算定段階;
                break;
            case NUMBER_2:
                item.list2_16 = 保険料算定段階;
                break;
            case NUMBER_3:
                item.list2_17 = 保険料算定段階;
                break;
            case NUMBER_4:
                item.list2_6 = 保険料算定段階;
                break;
            case NUMBER_5:
                item.list2_7 = 保険料算定段階;
                break;
            case NUMBER_6:
                item.list2_8 = 保険料算定段階;
                break;
            case NUMBER_7:
                item.list2_9 = 保険料算定段階;
                break;
            case NUMBER_8:
                item.list2_10 = 保険料算定段階;
                break;
            case NUMBER_9:
                item.list2_11 = 保険料算定段階;
                break;
            case NUMBER_10:
                item.list2_12 = 保険料算定段階;
                break;
            case NUMBER_11:
                item.list2_13 = 保険料算定段階;
                break;
            case NUMBER_12:
                item.list2_14 = 保険料算定段階;
                break;
            default:
                break;
        }
    }

    private void set更正後_保険料算定段階(KanendoIdouKekkaIchiranSource item,
            int currentMonth, RString 保険料算定段階) {
        switch (currentMonth) {
            case NUMBER_1:
                item.list3_15 = 保険料算定段階;
                break;
            case NUMBER_2:
                item.list3_16 = 保険料算定段階;
                break;
            case NUMBER_3:
                item.list3_17 = 保険料算定段階;
                break;
            case NUMBER_4:
                item.list3_6 = 保険料算定段階;
                break;
            case NUMBER_5:
                item.list3_7 = 保険料算定段階;
                break;
            case NUMBER_6:
                item.list3_8 = 保険料算定段階;
                break;
            case NUMBER_7:
                item.list3_9 = 保険料算定段階;
                break;
            case NUMBER_8:
                item.list3_10 = 保険料算定段階;
                break;
            case NUMBER_9:
                item.list3_11 = 保険料算定段階;
                break;
            case NUMBER_10:
                item.list3_12 = 保険料算定段階;
                break;
            case NUMBER_11:
                item.list3_13 = 保険料算定段階;
                break;
            case NUMBER_12:
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
            if (改頁項目List.size() > NUMBER_0) {
                source.kaipage1 = set改頁項目(改頁項目List.get(NUMBER_0));
            }
            if (改頁項目List.size() > NUMBER_1) {
                source.kaipage2 = set改頁項目(改頁項目List.get(NUMBER_1));
            }
            if (改頁項目List.size() > NUMBER_2) {
                source.kaipage3 = set改頁項目(改頁項目List.get(NUMBER_2));
            }
            if (改頁項目List.size() > NUMBER_3) {
                source.kaipage4 = set改頁項目(改頁項目List.get(NUMBER_3));
            }
            if (改頁項目List.size() > NUMBER_4) {
                source.kaipage5 = set改頁項目(改頁項目List.get(NUMBER_4));
            }
        }
    }

    private void set追加項目(KanendoIdouKekkaIchiranSource source) {
        UaFt200FindShikibetsuTaishoEntity 宛名 = 計算後情報_宛名_口座_更正後Entity.get宛名Entity();
        source.shikibetsuCode = getColumnValue(宛名.getShikibetsuCode());
        source.kanaMeisho = getColumnValue(宛名.getKanaMeisho());
        FlexibleDate 生年月日 = 宛名.getSeinengappiYMD();
        if (null != 生年月日) {
            source.seinengappiYMD = 生年月日.seireki().toDateString();
        } else {
            source.seinengappiYMD = RString.EMPTY;
        }
        source.seibetsuCode = 宛名.getSeibetsuCode() == null ? RString.EMPTY : 宛名.getSeibetsuCode();
        source.shichosonCode = getColumnValue(計算後情報_宛名_口座_更正後Entity.get賦課市町村コード());
        source.hihokenshaNo = getColumnValue(計算後情報_宛名_口座_更正後Entity.get被保険者番号());
        source.nenkinCode = 計算後情報_宛名_口座_更正後Entity.get本徴収_年金コード() == null
                ? RString.EMPTY : 計算後情報_宛名_口座_更正後Entity.get本徴収_年金コード();
        source.nenkinNo = 計算後情報_宛名_口座_更正後Entity.get本徴収_基礎年金番号() == null
                ? RString.EMPTY : 計算後情報_宛名_口座_更正後Entity.get本徴収_基礎年金番号();
    }

    private RString getColumnValue(IDbColumnMappable column) {
        if (null == column) {
            return RString.EMPTY;
        }
        return column.getColumnValue();
    }

    private RString toカンマ編集(Decimal 金額) {
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

    private RString set改頁項目(RString 改頁項目) {
        RString 改頁 = RString.EMPTY;
        if (氏名５０音カナ.equals(改頁項目)) {
            AtenaKanaMeisho kanaMeisho = 計算後情報_宛名_口座_更正後Entity.get宛名Entity().getKanaMeisho();
            if (kanaMeisho != null) {
                改頁 = kanaMeisho.value();
            }
        }
        if (識別コード.equals(改頁項目)) {
            改頁 = 計算後情報_宛名_口座_更正後Entity.get識別コード().value();
        }
        if (市町村コード.equals(改頁項目)) {
            改頁 = 計算後情報_宛名_口座_更正後Entity.get賦課市町村コード().value();
        }
        if (被保険者番号.equals(改頁項目)) {
            改頁 = 計算後情報_宛名_口座_更正後Entity.get被保険者番号().value();
        }
        if (生年月日.equals(改頁項目)) {
            FlexibleDate seinengappiYMD = 計算後情報_宛名_口座_更正後Entity.get宛名Entity().getSeinengappiYMD();
            if (seinengappiYMD != null) {
                改頁 = new RString(seinengappiYMD.toString());
            }
        }
        if (性別.equals(改頁項目)) {
            改頁 = 計算後情報_宛名_口座_更正後Entity.get宛名Entity().getSeibetsuCode();
        }
        if (賦課年度.equals(改頁項目)) {
            改頁 = 計算後情報_宛名_口座_更正後Entity.get賦課年度().toDateString();
        }
        if (年金コード.equals(改頁項目)) {
            改頁 = 計算後情報_宛名_口座_更正後Entity.get本徴収_年金コード();
        }
        if (年金番号.equals(改頁項目)) {
            改頁 = 計算後情報_宛名_口座_更正後Entity.get本徴収_基礎年金番号();
        }
        return 改頁;
    }
}
