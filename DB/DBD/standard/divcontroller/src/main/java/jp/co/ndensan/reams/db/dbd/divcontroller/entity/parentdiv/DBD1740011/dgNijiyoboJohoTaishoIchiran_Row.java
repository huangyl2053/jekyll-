package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1740011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Apr 10 11:42:03 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgNijiyoboJohoTaishoIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNijiyoboJohoTaishoIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">

    private TextBoxDate tekiyoKaishiYMD;
    private TextBoxDate tekiyoShuryoYMD;
    private TextBoxDate chosaJisshiYMD;
    private TextBoxDate ketteiYMD;
    private RString rirekiNo;

    public dgNijiyoboJohoTaishoIchiran_Row() {
        super();
        this.tekiyoKaishiYMD = new TextBoxDate();
        this.tekiyoShuryoYMD = new TextBoxDate();
        this.chosaJisshiYMD = new TextBoxDate();
        this.ketteiYMD = new TextBoxDate();
        this.rirekiNo = RString.EMPTY;
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("chosaJisshiYMD", chosaJisshiYMD);
        this.setOriginalData("ketteiYMD", ketteiYMD);
        this.setOriginalData("rirekiNo", rirekiNo);
    }

    public dgNijiyoboJohoTaishoIchiran_Row(TextBoxDate tekiyoKaishiYMD, TextBoxDate tekiyoShuryoYMD, TextBoxDate chosaJisshiYMD, TextBoxDate ketteiYMD, RString rirekiNo) {
        super();
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("chosaJisshiYMD", chosaJisshiYMD);
        this.setOriginalData("ketteiYMD", ketteiYMD);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
        this.chosaJisshiYMD = chosaJisshiYMD;
        this.ketteiYMD = ketteiYMD;
        this.rirekiNo = rirekiNo;
    }

    public TextBoxDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    public TextBoxDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    public TextBoxDate getChosaJisshiYMD() {
        return chosaJisshiYMD;
    }

    public TextBoxDate getKetteiYMD() {
        return ketteiYMD;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public void setTekiyoKaishiYMD(TextBoxDate tekiyoKaishiYMD) {
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    public void setTekiyoShuryoYMD(TextBoxDate tekiyoShuryoYMD) {
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    public void setChosaJisshiYMD(TextBoxDate chosaJisshiYMD) {
        this.setOriginalData("chosaJisshiYMD", chosaJisshiYMD);
        this.chosaJisshiYMD = chosaJisshiYMD;
    }

    public void setKetteiYMD(TextBoxDate ketteiYMD) {
        this.setOriginalData("ketteiYMD", ketteiYMD);
        this.ketteiYMD = ketteiYMD;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    // </editor-fold>
}
