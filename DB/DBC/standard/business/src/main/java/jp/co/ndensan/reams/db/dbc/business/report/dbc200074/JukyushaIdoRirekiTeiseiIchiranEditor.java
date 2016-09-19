/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200074;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200074.JukyushaIdoRirekiTeiseiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200074.JukyushaIdoRirekiTeiseiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBCMNF1001_1_国保連受給者異動情報履歴訂正リストBodyEditor
 *
 * @reamsid_L DBC-2720-050 jiangxiaolong
 */
public class JukyushaIdoRirekiTeiseiIchiranEditor
        implements IJukyushaIdoRirekiTeiseiIchiranEditor {

    private final JukyushaIdoRirekiTeiseiIchiranEntity entity;
    private final RString 市町村コード;
    private final RString 市町村名称;
    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param entity JukyushaIdoRirekiTeiseiIchiranEntity
     * @param 市町村コード RString
     * @param 市町村名称 RString
     */
    public JukyushaIdoRirekiTeiseiIchiranEditor(
            JukyushaIdoRirekiTeiseiIchiranEntity entity,
            RString 市町村コード, RString 市町村名称) {
        this.entity = entity;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
    }

    @Override
    public JukyushaIdoRirekiTeiseiIchiranSource edit(
            JukyushaIdoRirekiTeiseiIchiranSource source) {
        if (null == entity) {
            return source;
        }
        editSource(source);
        return source;
    }

    private void editSource(JukyushaIdoRirekiTeiseiIchiranSource source) {
        RDateTime 作成日時 = RDateTime.now();
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.shichosonCd = 市町村コード;
        source.shichosonName = 市町村名称;
        source.listUpperL_1 = entity.get被保険者番号();
        source.listUpperL_2 = entity.get被保険者氏名();
        source.listUpperL_3 = getパターン4(entity.get異動年月日());
        source.listUpperL_4 = entity.get訂正情報の項目名1();
        source.listUpperL_5 = entity.get訂正情報の項目名2();
        source.listUpperL_6 = entity.get訂正情報の項目名3();
        source.listUpperL_7 = entity.get訂正情報の項目名4();
        source.listUpperL_8 = entity.get訂正情報の項目名5();
        source.listUpperL_9 = entity.get訂正情報の項目名6();
        source.listUpperL_10 = entity.get訂正情報の項目名7();
        source.listUpperL_11 = entity.get訂正情報の項目名8();
        source.listUpperL_12 = entity.get訂正情報の項目名9();
        source.listUpperL_13 = entity.get訂正情報の項目名10();
        source.listUpperL_14 = RString.EMPTY;
        source.listUpperS_1 = RString.EMPTY;
        source.listCenterL_1 = RString.EMPTY;
        source.listCenterL_2 = RString.EMPTY;
        source.listCenterL_3 = RString.EMPTY;
        source.listCenterL_4 = entity.get送付済内容1();
        source.listCenterL_5 = entity.get送付済内容2();
        source.listCenterL_6 = entity.get送付済内容3();
        source.listCenterL_7 = entity.get送付済内容4();
        source.listCenterL_8 = entity.get送付済内容5();
        source.listCenterL_9 = entity.get送付済内容6();
        source.listCenterL_10 = entity.get送付済内容7();
        source.listCenterL_11 = entity.get送付済内容8();
        source.listCenterL_12 = entity.get送付済内容9();
        source.listCenterL_13 = entity.get送付済内容10();
        source.listCenterL_14 = RString.EMPTY;
        source.listCenterS_1 = RString.EMPTY;
        source.listLowerL_1 = RString.EMPTY;
        source.listLowerL_2 = RString.EMPTY;
        source.listLowerL_3 = RString.EMPTY;
        source.listLowerL_4 = entity.get訂正内容1();
        source.listLowerL_5 = entity.get訂正内容2();
        source.listLowerL_6 = entity.get訂正内容3();
        source.listLowerL_7 = entity.get訂正内容4();
        source.listLowerL_8 = entity.get訂正内容5();
        source.listLowerL_9 = entity.get訂正内容6();
        source.listLowerL_10 = entity.get訂正内容7();
        source.listLowerL_11 = entity.get訂正内容8();
        source.listLowerL_12 = entity.get訂正内容9();
        source.listLowerL_13 = entity.get訂正内容10();
        source.listLowerL_14 = RString.EMPTY;
        source.listLowerS_1 = RString.EMPTY;
    }

    private static RString getパターン4(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }
}
