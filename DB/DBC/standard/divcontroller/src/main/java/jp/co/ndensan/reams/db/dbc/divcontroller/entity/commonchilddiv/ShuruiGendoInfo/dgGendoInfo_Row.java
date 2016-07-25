package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShuruiGendoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jul 20 14:54:12 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgGendoInfo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgGendoInfo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString サービス種類;
    private RString 限度額;
    private RString 合計単位数;
    private RString 限度超過単位数;

    public dgGendoInfo_Row() {
        super();
        this.サービス種類 = RString.EMPTY;
        this.限度額 = RString.EMPTY;
        this.合計単位数 = RString.EMPTY;
        this.限度超過単位数 = RString.EMPTY;
        this.setOriginalData("サービス種類", サービス種類);
        this.setOriginalData("限度額", 限度額);
        this.setOriginalData("合計単位数", 合計単位数);
        this.setOriginalData("限度超過単位数", 限度超過単位数);
    }

    public dgGendoInfo_Row(RString サービス種類, RString 限度額, RString 合計単位数, RString 限度超過単位数) {
        super();
        this.setOriginalData("サービス種類", サービス種類);
        this.setOriginalData("限度額", 限度額);
        this.setOriginalData("合計単位数", 合計単位数);
        this.setOriginalData("限度超過単位数", 限度超過単位数);
        this.サービス種類 = サービス種類;
        this.限度額 = 限度額;
        this.合計単位数 = 合計単位数;
        this.限度超過単位数 = 限度超過単位数;
    }

    public RString getサービス種類() {
        return サービス種類;
    }

    public RString get限度額() {
        return 限度額;
    }

    public RString get合計単位数() {
        return 合計単位数;
    }

    public RString get限度超過単位数() {
        return 限度超過単位数;
    }

    public void setサービス種類(RString サービス種類) {
        this.setOriginalData("サービス種類", サービス種類);
        this.サービス種類 = サービス種類;
    }

    public void set限度額(RString 限度額) {
        this.setOriginalData("限度額", 限度額);
        this.限度額 = 限度額;
    }

    public void set合計単位数(RString 合計単位数) {
        this.setOriginalData("合計単位数", 合計単位数);
        this.合計単位数 = 合計単位数;
    }

    public void set限度超過単位数(RString 限度超過単位数) {
        this.setOriginalData("限度超過単位数", 限度超過単位数);
        this.限度超過単位数 = 限度超過単位数;
    }

    // </editor-fold>
}
