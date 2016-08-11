package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.YokaigoninteiJigyotaishoRirekiList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jul 27 19:25:41 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * dgJigyoTaishoshaList_Row のクラスファイル
 *
 * @reamsid_L DBC-4350-010 wangxingpeng
 */
public class dgJigyoTaishoshaList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private TextBoxFlexibleDate tekiyoKaishiYMD;
    private TextBoxFlexibleDate tekiyoShuryoYMD;
    private TextBoxFlexibleDate ketteiYMD;
    private TextBoxFlexibleDate checklistJisshiYMD;

    public dgJigyoTaishoshaList_Row() {
        super();
        this.tekiyoKaishiYMD = new TextBoxFlexibleDate();
        this.tekiyoShuryoYMD = new TextBoxFlexibleDate();
        this.ketteiYMD = new TextBoxFlexibleDate();
        this.checklistJisshiYMD = new TextBoxFlexibleDate();
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("ketteiYMD", ketteiYMD);
        this.setOriginalData("checklistJisshiYMD", checklistJisshiYMD);
    }

    public dgJigyoTaishoshaList_Row(TextBoxFlexibleDate tekiyoKaishiYMD, TextBoxFlexibleDate tekiyoShuryoYMD, TextBoxFlexibleDate ketteiYMD, TextBoxFlexibleDate checklistJisshiYMD) {
        super();
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("ketteiYMD", ketteiYMD);
        this.setOriginalData("checklistJisshiYMD", checklistJisshiYMD);
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
        this.ketteiYMD = ketteiYMD;
        this.checklistJisshiYMD = checklistJisshiYMD;
    }

    public TextBoxFlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    public TextBoxFlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    public TextBoxFlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    public TextBoxFlexibleDate getChecklistJisshiYMD() {
        return checklistJisshiYMD;
    }

    public void setTekiyoKaishiYMD(TextBoxFlexibleDate tekiyoKaishiYMD) {
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    public void setTekiyoShuryoYMD(TextBoxFlexibleDate tekiyoShuryoYMD) {
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    public void setKetteiYMD(TextBoxFlexibleDate ketteiYMD) {
        this.setOriginalData("ketteiYMD", ketteiYMD);
        this.ketteiYMD = ketteiYMD;
    }

    public void setChecklistJisshiYMD(TextBoxFlexibleDate checklistJisshiYMD) {
        this.setOriginalData("checklistJisshiYMD", checklistJisshiYMD);
        this.checklistJisshiYMD = checklistJisshiYMD;
    }

    // </editor-fold>
}
