package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jan 21 15:07:46 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShokanBaraisyokai_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShokanBaraisyokai_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">

    private TextBoxDate data1;
    private TextBoxDate data2;
    private RString data3;
    private TextBoxDate data4;
    private TextBoxDate data5;

    public dgShokanBaraisyokai_Row() {
        super();
        this.data1 = new TextBoxDate();
        this.data2 = new TextBoxDate();
        this.data3 = RString.EMPTY;
        this.data4 = new TextBoxDate();
        this.data5 = new TextBoxDate();
        this.setOriginalData("data1", data1);
        this.setOriginalData("data2", data2);
        this.setOriginalData("data3", data3);
        this.setOriginalData("data4", data4);
        this.setOriginalData("data5", data5);
    }

    public dgShokanBaraisyokai_Row(TextBoxDate data1, TextBoxDate data2, RString data3, TextBoxDate data4, TextBoxDate data5) {
        super();
        this.setOriginalData("data1", data1);
        this.setOriginalData("data2", data2);
        this.setOriginalData("data3", data3);
        this.setOriginalData("data4", data4);
        this.setOriginalData("data5", data5);
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.data5 = data5;
    }

    public TextBoxDate getData1() {
        return data1;
    }

    public TextBoxDate getData2() {
        return data2;
    }

    public RString getData3() {
        return data3;
    }

    public TextBoxDate getData4() {
        return data4;
    }

    public TextBoxDate getData5() {
        return data5;
    }

    public void setData1(TextBoxDate data1) {
        this.setOriginalData("data1", data1);
        this.data1 = data1;
    }

    public void setData2(TextBoxDate data2) {
        this.setOriginalData("data2", data2);
        this.data2 = data2;
    }

    public void setData3(RString data3) {
        this.setOriginalData("data3", data3);
        this.data3 = data3;
    }

    public void setData4(TextBoxDate data4) {
        this.setOriginalData("data4", data4);
        this.data4 = data4;
    }

    public void setData5(TextBoxDate data5) {
        this.setOriginalData("data5", data5);
        this.data5 = data5;
    }

    // </editor-fold>
}
