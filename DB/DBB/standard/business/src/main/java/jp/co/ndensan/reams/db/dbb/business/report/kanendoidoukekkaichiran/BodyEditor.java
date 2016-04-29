/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendofuka.HonSanteiIdoKanendoFukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidoukekkaichiran.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaTorokuKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt310FindKozaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0310KozaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表 BodyEditorです。
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
public class BodyEditor implements IKanendoIdouKekkaIchiranEditor {

    private final HonSanteiIdoKanendoFukaBatchParameter バッチパラメータ;
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

    private static final RString スペース = new RString(" ");
    private static final RString 更正前後区分_更正前 = new RString("1");
    private static final RString 更正前後区分_更正後 = new RString("2");

    /**
     * インスタンスを生成します。
     *
     * @param inputEntity {@link KanendoIdouKekkaIchiranInputEntity}
     */
    protected BodyEditor(KanendoIdouKekkaIchiranInputEntity inputEntity) {
        バッチパラメータ = inputEntity.getバッチパラメータ();
        調定日時 = inputEntity.get調定日時();
        計算後情報_宛名_口座_更正前Entity = inputEntity.get計算後情報_宛名_口座_更正前Entity();
        計算後情報_宛名_口座_更正後Entity = inputEntity.get計算後情報_宛名_口座_更正後Entity();
        association = inputEntity.getAssociation();
    }

    @Override
    public KanendoIdouKekkaIchiranSource edit(KanendoIdouKekkaIchiranSource source) {
        source.hokenshaNo = association.get地方公共団体コード().value();
        source.hokenshaName = association.get市町村名();
        set出力順And改ページ(source);
        source.list1_1 = 計算後情報_宛名_口座_更正前Entity.get通知書番号().value();
        AtenaMeisho 氏名 = 計算後情報_宛名_口座_更正前Entity.get宛名Entity().getKanjiShimei();
        if (null != 氏名) {
            source.list1_2 = 氏名.value();
        }
        source.list1_3 = ShikibetsuTaishoFactory.createKojin(計算後情報_宛名_口座_更正前Entity
                .get宛名Entity()).get住所().get住所();
        source.list1_4 = 計算後情報_宛名_口座_更正前Entity.get口座Entity().get金融機関コード().value();
        IKoza koza = to口座(計算後情報_宛名_口座_更正前Entity.get口座Entity());
        source.list1_5 = koza.get預金種別().get預金種別略称();
        source.list1_6 = 計算後情報_宛名_口座_更正前Entity.get口座Entity().get口座番号();
        source.list2_1 = 計算後情報_宛名_口座_更正前Entity.get調定年度().toDateString();
        source.list2_2 = 計算後情報_宛名_口座_更正前Entity.get賦課年度().toDateString();
        source.list2_3 = new RString(計算後情報_宛名_口座_更正前Entity.get確定介護保険料_年額().toString());
        source.list2_4 = new RString(計算後情報_宛名_口座_更正前Entity.get減免前介護保険料_年額().toString());
        source.list2_5 = new RString(計算後情報_宛名_口座_更正前Entity.get減免額().toString());
        set月別取得段階(計算後情報_宛名_口座_更正前Entity, source);
        source.list2_18 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴歳出還付額().toString());
        source.list2_19 = 計算後情報_宛名_口座_更正後Entity.get口座Entity().get金融機関名称();
        source.list3_1 = 計算後情報_宛名_口座_更正後Entity.get調定年度().toDateString();
        source.list3_2 = 計算後情報_宛名_口座_更正後Entity.get賦課年度().toDateString();
        source.list2_3 = new RString(計算後情報_宛名_口座_更正後Entity.get確定介護保険料_年額().toString());
        source.list2_4 = new RString(計算後情報_宛名_口座_更正後Entity.get減免前介護保険料_年額().toString());
        source.list2_5 = new RString(計算後情報_宛名_口座_更正後Entity.get減免額().toString());
        set月別取得段階(計算後情報_宛名_口座_更正後Entity, source);
        source.list3_18 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴歳出還付額().toString());
        source.list3_19 = 計算後情報_宛名_口座_更正後Entity.get口座Entity().get口座名義人().value();
        source.list4_1 = 調定日時.wareki().toDateString();
        source.list4_2 = new RString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額01().toString());
        source.list4_3 = new RString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額02().toString());
        source.list4_4 = new RString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額03().toString());
        source.list4_5 = new RString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額04().toString());
        source.list4_6 = new RString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額05().toString());
        source.list4_7 = new RString(計算後情報_宛名_口座_更正前Entity.get特徴期別金額06().toString());
        source.list4_8 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額01().toString());
        source.list4_9 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額02().toString());
        source.list4_10 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額03().toString());
        source.list4_11 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額04().toString());
        source.list4_12 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額05().toString());
        source.list4_13 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額06().toString());
        source.list4_14 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額07().toString());
        source.list4_15 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額08().toString());
        source.list4_16 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額09().toString());
        source.list4_17 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額10().toString());
        source.list4_18 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額11().toString());
        source.list4_19 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額12().toString());
        source.list4_20 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額13().toString());
        source.list4_21 = new RString(計算後情報_宛名_口座_更正前Entity.get普徴期別金額14().toString());
        source.list5_1 = 調定日時.wareki().toDateString();
        source.list5_2 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額01().toString());
        source.list5_3 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額02().toString());
        source.list5_4 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額03().toString());
        source.list5_5 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額04().toString());
        source.list5_6 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額05().toString());
        source.list5_7 = new RString(計算後情報_宛名_口座_更正後Entity.get特徴期別金額06().toString());
        source.list5_8 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額01().toString());
        source.list5_9 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額02().toString());
        source.list5_10 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額03().toString());
        source.list5_11 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額04().toString());
        source.list5_12 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額05().toString());
        source.list5_13 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額06().toString());
        source.list5_14 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額07().toString());
        source.list5_15 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額08().toString());
        source.list5_16 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額09().toString());
        source.list5_17 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額10().toString());
        source.list5_18 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額11().toString());
        source.list5_19 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額12().toString());
        source.list5_20 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額13().toString());
        source.list5_21 = new RString(計算後情報_宛名_口座_更正後Entity.get普徴期別金額14().toString());
        source.list6_1 = 計算後情報_宛名_口座_更正後Entity.get調定事由1();
        source.list7_1 = 計算後情報_宛名_口座_更正後Entity.get調定事由2();
        source.list8_1 = 計算後情報_宛名_口座_更正後Entity.get調定事由3();
        source.list9_1 = 計算後情報_宛名_口座_更正後Entity.get調定事由4();
        source.list10_1 = スペース;
        return source;
    }

    private void set月別取得段階(KeisangojohoAtenaKozaEntity entity, KanendoIdouKekkaIchiranSource item) {
        RString 更正前後区分 = entity.get更正前後区分();
        FlexibleDate 月割開始年月1 = entity.get月割開始年月1();
        int 開始月1 = 月割開始年月1.getMonthValue();
        FlexibleDate 月割終了年月1 = entity.get月割終了年月1();
        int 終了月1 = 月割終了年月1.getMonthValue();
        RString 保険料算定段階1 = entity.get保険料算定段階1().substring(NUM_0, NUM_2);
        FlexibleDate 月割開始年月2 = entity.get月割開始年月2();
        int 開始月2 = 月割開始年月2.getMonthValue();
        FlexibleDate 月割終了年月2 = entity.get月割終了年月2();
        int 終了月2 = 月割終了年月2.getMonthValue();
        RString 保険料算定段階2 = entity.get保険料算定段階2().substring(NUM_0, NUM_2);

        set月別取得段階(item, 開始月1, 終了月1, 保険料算定段階1, 更正前後区分);
        set月別取得段階(item, 開始月2, 終了月2, 保険料算定段階2, 更正前後区分);
    }

    private void set月別取得段階(KanendoIdouKekkaIchiranSource item, int 開始月, int 終了月,
            RString 保険料算定段階, RString 更正前後区分) {
        for (int i = 開始月; i <= (開始月 > 終了月 ? (終了月 + NUM_12) : 終了月); i++) { //来年1月は1+12=13月
            int currentMonth = (i - 1) / NUM_12 + 1;
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
        if (バッチパラメータ.get出力帳票List() != null && バッチパラメータ.get出力帳票List().isEmpty()) {
            if (バッチパラメータ.get出力帳票List().size() > NUM_0) {
                source.shutsuryokujun1 = バッチパラメータ.get出力帳票List().get(NUM_0).get出力順ID();
                source.kaipage1 = バッチパラメータ.get出力帳票List().get(NUM_0).get出力順ID();
            }
            if (バッチパラメータ.get出力帳票List().size() > NUM_1) {
                source.shutsuryokujun2 = バッチパラメータ.get出力帳票List().get(NUM_1).get出力順ID();
                source.kaipage2 = バッチパラメータ.get出力帳票List().get(NUM_1).get出力順ID();
            }
            if (バッチパラメータ.get出力帳票List().size() > NUM_2) {
                source.shutsuryokujun3 = バッチパラメータ.get出力帳票List().get(NUM_2).get出力順ID();
                source.kaipage3 = バッチパラメータ.get出力帳票List().get(NUM_2).get出力順ID();
            }
            if (バッチパラメータ.get出力帳票List().size() > NUM_3) {
                source.shutsuryokujun4 = バッチパラメータ.get出力帳票List().get(NUM_3).get出力順ID();
                source.kaipage4 = バッチパラメータ.get出力帳票List().get(NUM_3).get出力順ID();
            }
            if (バッチパラメータ.get出力帳票List().size() > NUM_4) {
                source.shutsuryokujun5 = バッチパラメータ.get出力帳票List().get(NUM_4).get出力順ID();
                source.kaipage5 = バッチパラメータ.get出力帳票List().get(NUM_4).get出力順ID();
            }
        }
    }

    private IKoza to口座(UaFt310FindKozaEntity uaFt310Entity) {
        KozaRelateEntity relateEntity = new KozaRelateEntity();
        UaT0310KozaEntity kozaEntity = new UaT0310KozaEntity();
//      kozaEntity.setGyomubetsuPrimaryKey(); //ない  uaFt310EntityにUaFt310FindKozaEntityにとって必要な項目がない
        uaFt310Entity.getサブ業務コード();
        kozaEntity.setKozaId(uaFt310Entity.get口座ID().longValue());
        kozaEntity.setKozaMeiginin(uaFt310Entity.get口座名義人());
        kozaEntity.setKozaMeigininKanji(uaFt310Entity.get口座名義人漢字());
        kozaEntity.setKozaMeigininShikibetsuCode(uaFt310Entity.get口座名義人識別コード());
        kozaEntity.setKozaNo(uaFt310Entity.get口座番号());
        kozaEntity.setKozaTorokuKubunCode(new KozaTorokuKubunCodeValue(uaFt310Entity.get口座登録区分コード()));
        kozaEntity.setKozaTorokuYMD(new FlexibleDate(uaFt310Entity.get口座登録年月日().toDateString()));
        kozaEntity.setKozaTorokuNo(uaFt310Entity.get口座登録番号());
        kozaEntity.setKozaShuryoUketsukeYMD(new FlexibleDate(uaFt310Entity.get口座終了受付年月日().toDateString()));
        kozaEntity.setKozaHyojiKubun(uaFt310Entity.get口座表示区分());
        kozaEntity.setKozaKaishiUketsukeYMD(new FlexibleDate(uaFt310Entity.get口座開始受付年月日().toDateString()));
        kozaEntity.setTemban(uaFt310Entity.get店番());
        kozaEntity.setKinyuKikanShitenCode(uaFt310Entity.get支店コード());
        // uaFt310Entity.get支店名称();
        kozaEntity.setKensakuyoMeiginin(uaFt310Entity.get検索用名義人());
//        uaFt310Entity.get業務コード();
        kozaEntity.setGyomuKoyuKey(uaFt310Entity.get業務固有キー());
        kozaEntity.setYotoKubun(new KozaYotoKubunCodeValue(uaFt310Entity.get用途区分()));
//        uaFt310Entity.get用途区分名称();
//        uaFt310Entity.get科目コード();
        kozaEntity.setShuryoYMD(new FlexibleDate(uaFt310Entity.get終了年月日().toDateString()));
        kozaEntity.setShikibetsuCode(uaFt310Entity.get識別コード());
        kozaEntity.setTsuchoNo(uaFt310Entity.get通帳番号());
        kozaEntity.setTsuchoKigo(uaFt310Entity.get通帳記号());
        kozaEntity.setKinyuKikanCode(uaFt310Entity.get金融機関コード());
//        uaFt310Entity.get金融機関名称();
        kozaEntity.setKaishiYMD(new FlexibleDate(uaFt310Entity.get開始年月日().toDateString()));
        kozaEntity.setYokinShubetsu(uaFt310Entity.get預金種別());
//        uaFt310Entity.get預金種別名称();

        relateEntity.setUaT0310KozaEntity(kozaEntity);
        return new Koza(relateEntity);
    }

}
