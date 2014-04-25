package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Apr 25 14:05:39 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShisetsuRereki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShisetsuRereki_Row extends DataRow {

    private Button editButton;
    private RString name;
    private RString startDate;
    private RString endDate;

    public dgShisetsuRereki_Row() {
        super();
    }

    public dgShisetsuRereki_Row(Button editButton, RString name, RString startDate, RString endDate) {
        super();
        this.setOriginalData("editButton", editButton);
        this.setOriginalData("name", name);
        this.setOriginalData("startDate", startDate);
        this.setOriginalData("endDate", endDate);
        this.editButton = editButton;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Button getEditButton() {
        return editButton;
    }

    public RString getName() {
        return name;
    }

    public RString getStartDate() {
        return startDate;
    }

    public RString getEndDate() {
        return endDate;
    }

    public void setEditButton(Button editButton) {
        this.setOriginalData("editButton", editButton);
        this.editButton = editButton;
    }

    public void setName(RString name) {
        this.setOriginalData("name", name);
        this.name = name;
    }

    public void setStartDate(RString startDate) {
        this.setOriginalData("startDate", startDate);
        this.startDate = startDate;
    }

    public void setEndDate(RString endDate) {
        this.setOriginalData("endDate", endDate);
        this.endDate = endDate;
    }

}