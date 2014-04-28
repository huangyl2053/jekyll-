package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Apr 25 16:54:46 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgShisetsuRereki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShisetsuRereki_Row extends DataRow {

    private Button editButton;
    private RString name;
    private TextBoxDate startDate;
    private TextBoxDate endDate;

    public dgShisetsuRereki_Row() {
        super();
    }

    public dgShisetsuRereki_Row(Button editButton, RString name, TextBoxDate startDate, TextBoxDate endDate) {
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

    public TextBoxDate getStartDate() {
        return startDate;
    }

    public TextBoxDate getEndDate() {
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

    public void setStartDate(TextBoxDate startDate) {
        this.setOriginalData("startDate", startDate);
        this.startDate = startDate;
    }

    public void setEndDate(TextBoxDate endDate) {
        this.setOriginalData("endDate", endDate);
        this.endDate = endDate;
    }

}