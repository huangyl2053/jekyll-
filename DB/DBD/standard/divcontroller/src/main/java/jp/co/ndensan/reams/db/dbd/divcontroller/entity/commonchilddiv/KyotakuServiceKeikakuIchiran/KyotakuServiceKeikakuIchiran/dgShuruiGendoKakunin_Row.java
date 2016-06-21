package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 21 20:01:56 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgShuruiGendoKakunin_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShuruiGendoKakunin_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString serviceShurui;
    private TextBoxNum gendoGaku;
    private TextBoxNum gokeiTansu;
    private TextBoxNum gendoChokaTanisu;

    public dgShuruiGendoKakunin_Row() {
        super();
        this.serviceShurui = RString.EMPTY;
        this.gendoGaku = new TextBoxNum();
        this.gokeiTansu = new TextBoxNum();
        this.gendoChokaTanisu = new TextBoxNum();
        this.setOriginalData("serviceShurui", serviceShurui);
        this.setOriginalData("gendoGaku", gendoGaku);
        this.setOriginalData("gokeiTansu", gokeiTansu);
        this.setOriginalData("gendoChokaTanisu", gendoChokaTanisu);
    }

    public dgShuruiGendoKakunin_Row(RString serviceShurui, TextBoxNum gendoGaku, TextBoxNum gokeiTansu, TextBoxNum gendoChokaTanisu) {
        super();
        this.setOriginalData("serviceShurui", serviceShurui);
        this.setOriginalData("gendoGaku", gendoGaku);
        this.setOriginalData("gokeiTansu", gokeiTansu);
        this.setOriginalData("gendoChokaTanisu", gendoChokaTanisu);
        this.serviceShurui = serviceShurui;
        this.gendoGaku = gendoGaku;
        this.gokeiTansu = gokeiTansu;
        this.gendoChokaTanisu = gendoChokaTanisu;
    }

    public RString getServiceShurui() {
        return serviceShurui;
    }

    public TextBoxNum getGendoGaku() {
        return gendoGaku;
    }

    public TextBoxNum getGokeiTansu() {
        return gokeiTansu;
    }

    public TextBoxNum getGendoChokaTanisu() {
        return gendoChokaTanisu;
    }

    public void setServiceShurui(RString serviceShurui) {
        this.setOriginalData("serviceShurui", serviceShurui);
        this.serviceShurui = serviceShurui;
    }

    public void setGendoGaku(TextBoxNum gendoGaku) {
        this.setOriginalData("gendoGaku", gendoGaku);
        this.gendoGaku = gendoGaku;
    }

    public void setGokeiTansu(TextBoxNum gokeiTansu) {
        this.setOriginalData("gokeiTansu", gokeiTansu);
        this.gokeiTansu = gokeiTansu;
    }

    public void setGendoChokaTanisu(TextBoxNum gendoChokaTanisu) {
        this.setOriginalData("gendoChokaTanisu", gendoChokaTanisu);
        this.gendoChokaTanisu = gendoChokaTanisu;
    }

    // </editor-fold>
}
