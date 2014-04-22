/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBCommonInfoPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaInfoPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ReamsCommonInfoPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.DateRoundingType;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Wareki;

/**
 * 被保険者照会画面上部の、被保険者情報を表示するパネルを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaInfoPanel {
    //TODO n8178 城間篤人 検索画面ができた後、そこから遷移するように修正予定。現在は決めうちでテストデータを用意している。 2014年5月

    /**
     * Panelに表示される情報に対して値を設定します。
     *
     * @param Panel Panel
     * @return response
     */
    public ResponseData<HihokenshaInfoPanelDiv> getOnLoadDivData(HihokenshaInfoPanelDiv Panel) {
        ResponseData<HihokenshaInfoPanelDiv> response = new ResponseData<>();

        setReamsCommonInfoData(Panel.getReamsCommonInfoPanel());
        setDBCommonInfoData(Panel.getDBCommonInfoPanel());
        response.data = Panel;

        return response;
    }

    private void setReamsCommonInfoData(ReamsCommonInfoPanelDiv reamsCommonData) {
        reamsCommonData.getAgeText().setValue(new RString("20"));
        reamsCommonData.getDateOfBirthText().setValue(new RString("19990101"));
        reamsCommonData.getGenderText().setValue(new RString("男"));
        reamsCommonData.getGyoseikuText().setValue(new RString("電算"));
        reamsCommonData.getShimeiText().setValue(new RString("電算太郎"));
        reamsCommonData.getHurikanaText().setValue(new RString("ﾃﾞﾝｻﾝ ﾀﾛｳ"));
        reamsCommonData.getJuminShubetsuText().setValue(new RString("住民"));
        reamsCommonData.getJuminhyoCodeText().setValue(new RString("012314"));
        reamsCommonData.getJushoCodeText().setValue(new RString("303"));
        reamsCommonData.getJushoText().setValue(new RString("電算市高松2201-1"));
        reamsCommonData.getKumiaiText().setValue(new RString("組合"));
        reamsCommonData.getRenrakusaki1Text().setValue(new RString("098-123-1234"));
        reamsCommonData.getRenrakusaki2Text().setValue(new RString("098-345-3456"));
        reamsCommonData.getSetaiCodeText().setValue(new RString("1234"));
    }

    private void setDBCommonInfoData(DBCommonInfoPanelDiv dbCommonData) {
        dbCommonData.getHihokenshaNoText().setValue(new RString("0000708123"));
        dbCommonData.getYokaigodoText().setValue(new RString("要支援2"));
        dbCommonData.getNinteiKikanText().setFromValue(createDateString("20120912"));
        dbCommonData.getNinteiKikanText().setToValue(createDateString(""));
        dbCommonData.getKyuHihokenshaNoText().setValue(new RString("0100012345"));
        dbCommonData.getKyuShichosonCodeText().setValue(new RString("301"));
        dbCommonData.getKyuShichosonText().setValue(new RString("電算市伝山村田賛2201-1"));
    }

    private RString createDateString(String str) {
        FlexibleDate ymd = new FlexibleDate(str);
        return createDateString(ymd);
    }

    private RString createDateString(FlexibleDate ymd) {
        Wareki wareki = ymd.wareki(DateRoundingType.同月の暦上日);
        wareki.separator(Separator.PERIOD);
        wareki.eraType(EraType.KANJI_RYAKU);
        return wareki.toDateString();
    }
}
