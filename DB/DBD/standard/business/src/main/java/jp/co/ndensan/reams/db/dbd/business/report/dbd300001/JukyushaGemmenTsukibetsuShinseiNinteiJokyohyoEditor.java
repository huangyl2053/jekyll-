/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushagemmenjisshijokyo.JukyushaGemmenJisshiJokyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300001.JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 受給者減免月別申請・認定状況表Editorです。
 *
 * @reamsid_L DBD-3770-040 b_liuyang2
 */
public class JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoEditor implements IJukyushaGemmenTsukibetsuShinseiNinteiJokyohyoEditor {

    private final Association association;
    private final FlexibleYear 対象年度;
    private final JukyushaGemmenJisshiJokyoEntity データリスト;

    /**
     * インスタンスを生成します。
     *
     * @param association Association
     * @param 対象年度 FlexibleDate
     * @param データリスト JukyushaGemmenJisshiJokyoEntity
     */
    public JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoEditor(Association association, FlexibleYear 対象年度,
            JukyushaGemmenJisshiJokyoEntity データリスト) {
        this.association = association;
        this.対象年度 = 対象年度;
        this.データリスト = データリスト;
    }

    @Override
    public JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource edit(JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource source) {
        setHeader(source);
        set出力内容(source);
        return source;
    }

    private void setHeader(JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource source) {
        source.shichosonName = this.association.get市町村名();
        if (null != this.対象年度) {
            source.nendo = this.対象年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
        }
        source.printTimeStamp = get印刷日時();
        //TODO バッチが実装していない、完成したら、この分はバッチで実装します。
//        if (全て.equals(this.市町村コード.value()) || this.市町村コード.isEmpty()) {
//            source.hokenshaNo = this.association.getLasdecCode_().value();
//            source.hokenshaName = this.association.get市町村名();
//        } else {
//            source.hokenshaNo = this.市町村コード.value();
//            source.hokenshaName = AssociationFinderFactory.createInstance().getAssociation(this.市町村コード).get市町村名();
//        }
    }

    private void set出力内容(JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource source) {
        if (null != this.データリスト) {
            if (null != this.データリスト.getタイトル()) {
                source.list_1 = this.データリスト.getタイトル();
            }
            if (null != this.データリスト.get四月()) {
                source.list_2 = this.データリスト.get四月();
            }
            if (null != this.データリスト.get五月()) {
                source.list_3 = this.データリスト.get五月();
            }
            if (null != this.データリスト.get六月()) {
                source.list_4 = this.データリスト.get六月();
            }
            if (null != this.データリスト.get七月()) {
                source.list_5 = this.データリスト.get七月();
            }
            if (null != this.データリスト.get八月()) {
                source.list_6 = this.データリスト.get八月();
            }
            if (null != this.データリスト.get九月()) {
                source.list_7 = this.データリスト.get九月();
            }
            if (null != this.データリスト.get十月()) {
                source.list_8 = this.データリスト.get十月();
            }
            if (null != this.データリスト.get十一月()) {
                source.list_9 = this.データリスト.get十一月();
            }
            if (null != this.データリスト.get十二月()) {
                source.list_10 = this.データリスト.get十二月();
            }
            if (null != this.データリスト.get一月()) {
                source.list_11 = this.データリスト.get一月();
            }
            if (null != this.データリスト.get二月()) {
                source.list_12 = this.データリスト.get二月();
            }
            if (null != this.データリスト.get三月()) {
                source.list_13 = this.データリスト.get三月();
            }
            if (null != this.データリスト.get合計()) {
                source.list_14 = this.データリスト.get合計();
            }
        }
    }

    private RString get印刷日時() {
        FlexibleDate システム日 = FlexibleDate.getNowDate();
        RTime システム日時 = RTime.now();
        RString 年月日 = システム日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 時分秒 = システム日時.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        return 年月日.concat(時分秒);
    }
}
