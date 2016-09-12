package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Aug 04 11:39:56 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsakaiIinIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIinIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString code;
    private RString shinsakaiIinName;
    private RString shinsakaiIinKanaName;
    private RString seibetsu;
    private RString shinsakaiIinShikaku;

    public dgShinsakaiIinIchiran_Row() {
        super();
        this.code = RString.EMPTY;
        this.shinsakaiIinName = RString.EMPTY;
        this.shinsakaiIinKanaName = RString.EMPTY;
        this.seibetsu = RString.EMPTY;
        this.shinsakaiIinShikaku = RString.EMPTY;
        this.setOriginalData("code", code);
        this.setOriginalData("shinsakaiIinName", shinsakaiIinName);
        this.setOriginalData("shinsakaiIinKanaName", shinsakaiIinKanaName);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("shinsakaiIinShikaku", shinsakaiIinShikaku);
    }

    public dgShinsakaiIinIchiran_Row(RString code, RString shinsakaiIinName, RString shinsakaiIinKanaName, RString seibetsu, RString shinsakaiIinShikaku) {
        super();
        this.setOriginalData("code", code);
        this.setOriginalData("shinsakaiIinName", shinsakaiIinName);
        this.setOriginalData("shinsakaiIinKanaName", shinsakaiIinKanaName);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("shinsakaiIinShikaku", shinsakaiIinShikaku);
        this.code = code;
        this.shinsakaiIinName = shinsakaiIinName;
        this.shinsakaiIinKanaName = shinsakaiIinKanaName;
        this.seibetsu = seibetsu;
        this.shinsakaiIinShikaku = shinsakaiIinShikaku;
    }

    public RString getCode() {
        return code;
    }

    public RString getShinsakaiIinName() {
        return shinsakaiIinName;
    }

    public RString getShinsakaiIinKanaName() {
        return shinsakaiIinKanaName;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public RString getShinsakaiIinShikaku() {
        return shinsakaiIinShikaku;
    }

    public void setCode(RString code) {
        this.setOriginalData("code", code);
        this.code = code;
    }

    public void setShinsakaiIinName(RString shinsakaiIinName) {
        this.setOriginalData("shinsakaiIinName", shinsakaiIinName);
        this.shinsakaiIinName = shinsakaiIinName;
    }

    public void setShinsakaiIinKanaName(RString shinsakaiIinKanaName) {
        this.setOriginalData("shinsakaiIinKanaName", shinsakaiIinKanaName);
        this.shinsakaiIinKanaName = shinsakaiIinKanaName;
    }

    public void setSeibetsu(RString seibetsu) {
        this.setOriginalData("seibetsu", seibetsu);
        this.seibetsu = seibetsu;
    }

    public void setShinsakaiIinShikaku(RString shinsakaiIinShikaku) {
        this.setOriginalData("shinsakaiIinShikaku", shinsakaiIinShikaku);
        this.shinsakaiIinShikaku = shinsakaiIinShikaku;
    }

    // </editor-fold>
}
