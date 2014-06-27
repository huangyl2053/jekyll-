package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 27 16:02:58 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShisetsuRereki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShisetsuRereki_Row extends DataRow {

    private Button editButton;
    private RString name;
    private TextBoxFlexibleDate startDate;
    private TextBoxFlexibleDate endDate;

    public dgShisetsuRereki_Row() {
        super();
        this.editButton = new Button();
        this.name = RString.EMPTY;
        this.startDate = new TextBoxFlexibleDate();
        this.endDate = new TextBoxFlexibleDate();
    }

    public dgShisetsuRereki_Row(Button editButton, RString name, TextBoxFlexibleDate startDate, TextBoxFlexibleDate endDate) {
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

    public TextBoxFlexibleDate getStartDate() {
        return startDate;
    }

    public TextBoxFlexibleDate getEndDate() {
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

    public void setStartDate(TextBoxFlexibleDate startDate) {
        this.setOriginalData("startDate", startDate);
        this.startDate = startDate;
    }

    public void setEndDate(TextBoxFlexibleDate endDate) {
        this.setOriginalData("endDate", endDate);
        this.endDate = endDate;
    }

}