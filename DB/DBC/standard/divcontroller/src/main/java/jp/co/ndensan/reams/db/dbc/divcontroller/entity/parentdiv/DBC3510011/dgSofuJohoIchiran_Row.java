package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 20 14:14:50 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgSofuJohoIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSofuJohoIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString sofuJohoMeisho;
    private RString baitaisu;
    private RString jotai;
    private TextBoxNum hdnHyojiJun;
    private RString hdnHokenshaJoHoList;

    public dgSofuJohoIchiran_Row() {
        super();
        this.sofuJohoMeisho = RString.EMPTY;
        this.baitaisu = RString.EMPTY;
        this.jotai = RString.EMPTY;
        this.hdnHyojiJun = new TextBoxNum();
        this.hdnHokenshaJoHoList = RString.EMPTY;
        this.setOriginalData("sofuJohoMeisho", sofuJohoMeisho);
        this.setOriginalData("baitaisu", baitaisu);
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("hdnHyojiJun", hdnHyojiJun);
        this.setOriginalData("hdnHokenshaJoHoList", hdnHokenshaJoHoList);
    }

    public dgSofuJohoIchiran_Row(RString sofuJohoMeisho, RString baitaisu, RString jotai, TextBoxNum hdnHyojiJun, RString hdnHokenshaJoHoList) {
        super();
        this.setOriginalData("sofuJohoMeisho", sofuJohoMeisho);
        this.setOriginalData("baitaisu", baitaisu);
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("hdnHyojiJun", hdnHyojiJun);
        this.setOriginalData("hdnHokenshaJoHoList", hdnHokenshaJoHoList);
        this.sofuJohoMeisho = sofuJohoMeisho;
        this.baitaisu = baitaisu;
        this.jotai = jotai;
        this.hdnHyojiJun = hdnHyojiJun;
        this.hdnHokenshaJoHoList = hdnHokenshaJoHoList;
    }

    public RString getSofuJohoMeisho() {
        return sofuJohoMeisho;
    }

    public RString getBaitaisu() {
        return baitaisu;
    }

    public RString getJotai() {
        return jotai;
    }

    public TextBoxNum getHdnHyojiJun() {
        return hdnHyojiJun;
    }

    public RString getHdnHokenshaJoHoList() {
        return hdnHokenshaJoHoList;
    }

    public void setSofuJohoMeisho(RString sofuJohoMeisho) {
        this.setOriginalData("sofuJohoMeisho", sofuJohoMeisho);
        this.sofuJohoMeisho = sofuJohoMeisho;
    }

    public void setBaitaisu(RString baitaisu) {
        this.setOriginalData("baitaisu", baitaisu);
        this.baitaisu = baitaisu;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setHdnHyojiJun(TextBoxNum hdnHyojiJun) {
        this.setOriginalData("hdnHyojiJun", hdnHyojiJun);
        this.hdnHyojiJun = hdnHyojiJun;
    }

    public void setHdnHokenshaJoHoList(RString hdnHokenshaJoHoList) {
        this.setOriginalData("hdnHokenshaJoHoList", hdnHokenshaJoHoList);
        this.hdnHokenshaJoHoList = hdnHokenshaJoHoList;
    }

    // </editor-fold>
}
