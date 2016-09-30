/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200016;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200001.FutanGendogakuNinteiGaitoshaIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 負担限度額認定者リストEditorです。
 *
 * @reamsid_L DBD-3960-060 donghj
 */
public class FutanGendogakuNinteiGaitoshaIchiranEditor implements IFutanGendogakuNinteiGaitoshaIchiranEditor {

    private final Association 導入団体;
    private final IOutputOrder 帳票出力順;
    private UaFt200FindShikibetsuTaishoEntity entity;

    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final RString 却下 = new RString("却下");
    private static final RString 承認 = new RString("承認");
    private static final RString 該当 = new RString("該当");
    private static final RString 旧措置者 = new RString("旧措置者");
    private static final RString 旧措軽減 = new RString("旧措軽減");
    private static final RString 課 = new RString("課");
    private static final RString 星 = new RString("＊");
    private static final RString 有 = new RString("有");

    /**
     * インスタンスを生成します。
     *
     * @param 導入団体 Association
     * @param 帳票出力順 IOutputOrder
     */
    public FutanGendogakuNinteiGaitoshaIchiranEditor(Association 導入団体, IOutputOrder 帳票出力順) {
        this.導入団体 = 導入団体;
        this.帳票出力順 = 帳票出力順;
    }

    @Override
    public FutanGendogakuNinteiGaitoshaIchiranReportSource edit(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
        return editSource(source);
    }

    private FutanGendogakuNinteiGaitoshaIchiranReportSource editSource(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
        editHead(source);
        edit被保険者情報(source);
        return source;
    }

    private void editHead(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
        source.printTimeStamp = get印刷日時();
        source.title = new RString("介護保険 負担限度額認定者リスト");
        source.title = new RString("介護保険 負担限度額該当者リスト");//TODO

        if (null != 導入団体) {
            source.hokenshaNo = 導入団体.get地方公共団体コード().value();
            source.hokenshaNo = 導入団体.getShichosonName_();
        }
        if (null != 帳票出力順) {
            set出力順改頁(source);
        }
    }

    private void edit被保険者情報(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
        IKojin iKojin = ShikibetsuTaishoFactory.createKojin(entity);
        setListUpper(source, iKojin);
        setListCenter(source, iKojin);
        setListLower(source);

    }

    private void setListUpper(FutanGendogakuNinteiGaitoshaIchiranReportSource source, IKojin iKojin) {
//        source.listUpper_1 =;
//        if (null != iKojin) {
//            source.listUpper_2 = iKojin.get名称().getName().value();
//            source.listUpper_3 = iKojin.get年齢算出().get年齢();
//        }
//        if () {
//            source.listUpper_4 = 承認;
//        } else if () {
//            source.listUpper_4 = 却下;
//        } else {
//            source.listUpper_4 = RString.EMPTY;
//        }
//        source.listUpper_5 =;
//        source.listUpper_6 =;
//        if () {
//            source.listUpper_7 = 該当;
//        } else {
//            source.listUpper_7 = RString.EMPTY;
//        }
//        source.listUpper_8 =;
//        if () {
//            source.listUpper_9 = 星;
//        } else {
//            source.listUpper_9 = RString.EMPTY;
//        }
//        if () {
//            source.listUpper_10 = 課;
//        } else {
//            source.listUpper_10 = RString.EMPTY;
//        }
//        if () {
//            source.listUpper_11 = 課;
//        } else {
//            source.listUpper_11 = RString.EMPTY;
//        }
//        if () {
//            source.listUpper_12 = 星;
//        } else {
//            source.listUpper_12 = RString.EMPTY;
//        }
//        source.listUpper_13 =;
//        source.listUpper_14 =;
//        if () {
//            source.listUpper_15 = 星;
//        } else {
//            source.listUpper_15 = RString.EMPTY;
//        }
//
//        source.listUpper_16 =;
//        source.listUpper_17 =;
//        source.listUpper_20 =;
    }

    private void setListCenter(FutanGendogakuNinteiGaitoshaIchiranReportSource source, IKojin iKojin) {
        if (null != iKojin) {
            source.listCenter_1 = iKojin.get住所().get全国住所コード().value();
            source.listCenter_2 = iKojin.get住所().get郵便番号().value();
            source.listCenter_3 = iKojin.get住所().get住所();
            source.listCenter_4 = iKojin.get住民状態().住民状態略称();
        }

//        source.listCenter_5 =;
//        source.listCenter_6 =;
//        source.listCenter_7 =;
//        source.listCenter_8 =;
//        source.listCenter_9 =;
//        if () {
//            source.listCenter_10 = 旧措置者;
//        } else if () {
//            source.listCenter_10 = 旧措軽減;
//        }
//        if () {
//            source.listCenter_11 = 星;
//        } else {
//            source.listCenter_11 = RString.EMPTY;
//        }
//
//        source.listCenter_12 = YokaigoJotaiKubunSupport.toValue(厚労省IF識別コード, 要介護認定状態区分コード).getName();
//        source.listCenter_13 =;
//        if () {
//            source.listCenter_14 = 星;
//        } else {
//            source.listCenter_14 = RString.EMPTY;
//        }
//
//        source.listCenter_14 =;
//        source.listCenter_15 =;
//        source.listCenter_16 =;
//        source.listCenter_19 =;
    }

    private void setListLower(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {

//        source.listLower_1 =;
//        source.listLower_2 =;
//        source.listLower_3 =;
//        source.listLower_4 =;
//        source.listLower_5 =;
//        source.listLower_6 =;
//        source.listLower_7 =;
//        source.listLower_8 =;
//        source.listLower_9 =;
//        source.listLower_10 =;
//        source.listLower_11 =;
//        source.listLower_12 =;
//        source.listLower_13 =;
//        source.listLower_14 =;
//        source.listLower_17 =;
    }

    private void set受給(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
//        if () {
//            source.listUpper_21 = 有;
//            source.listCenter_20 = 有;
//            source.listLower_18 = 有;
//        } else {
//            source.listUpper_21 = RString.EMPTY;
//            source.listCenter_20 = RString.EMPTY;
//            source.listLower_18 = RString.EMPTY;
//        }

    }

    private void set所税(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
//        if () {
//            source.listUpper_19 = 課;
//            source.listCenter_18 = 課;
//            source.listLower_16 = 課;
//        } else {
//            source.listUpper_19 = RString.EMPTY;
//            source.listCenter_18 = RString.EMPTY;
//            source.listLower_16 = RString.EMPTY;
//        }

    }

    private void set課税(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
//        if () {
//            source.listUpper_18 = 課;
//            source.listCenter_17 = 課;
//            source.listLower_15 = 課;
//        } else {
//            source.listUpper_18 = RString.EMPTY;
//            source.listCenter_17 = RString.EMPTY;
//            source.listLower_15 = RString.EMPTY;
//        }

    }

    private RString get印刷日時() {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        RString 時分秒 = datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(時分秒);
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        return systemDateTime.toRString();
    }

    private void set出力順改頁(FutanGendogakuNinteiGaitoshaIchiranReportSource source) {
        List<ISetSortItem> 設定項目リスト = this.帳票出力順.get設定項目リスト();
        if (設定項目リスト.size() > LISTINDEX_0) {
            source.shutsuryokujun1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            if (設定項目リスト.get(LISTINDEX_0).is改頁項目()) {
                source.kaiPege1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_1) {
            source.shutsuryokujun2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            if (設定項目リスト.get(LISTINDEX_1).is改頁項目()) {
                source.kaiPege2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_2) {
            source.shutsuryokujun3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            if (設定項目リスト.get(LISTINDEX_2).is改頁項目()) {
                source.kaiPege3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_3) {
            source.shutsuryokujun4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            if (設定項目リスト.get(LISTINDEX_3).is改頁項目()) {
                source.kaiPege4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_4) {
            source.shutsuryokujun5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            if (設定項目リスト.get(LISTINDEX_4).is改頁項目()) {
                source.kaiPege5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            }
        }
    }

}
