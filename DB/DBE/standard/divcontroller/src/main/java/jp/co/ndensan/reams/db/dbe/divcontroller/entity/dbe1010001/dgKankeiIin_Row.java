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


/**
 * dgKankeiIin_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKankeiIin_Row extends DataRow {

    private Button editButton;
    private RString code;
    private RString name;
    private RString shozokuKikan;

    public dgKankeiIin_Row() {
        super();
        this.editButton = new Button();
        this.code = RString.EMPTY;
        this.name = RString.EMPTY;
        this.shozokuKikan = RString.EMPTY;
    }

    public dgKankeiIin_Row(Button editButton, RString code, RString name, RString shozokuKikan) {
        super();
        this.setOriginalData("editButton", editButton);
        this.setOriginalData("code", code);
        this.setOriginalData("name", name);
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.editButton = editButton;
        this.code = code;
        this.name = name;
        this.shozokuKikan = shozokuKikan;
    }

    public Button getEditButton() {
        return editButton;
    }

    public RString getCode() {
        return code;
    }

    public RString getName() {
        return name;
    }

    public RString getShozokuKikan() {
        return shozokuKikan;
    }

    public void setEditButton(Button editButton) {
        this.setOriginalData("editButton", editButton);
        this.editButton = editButton;
    }

    public void setCode(RString code) {
        this.setOriginalData("code", code);
        this.code = code;
    }

    public void setName(RString name) {
        this.setOriginalData("name", name);
        this.name = name;
    }

    public void setShozokuKikan(RString shozokuKikan) {
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.shozokuKikan = shozokuKikan;
    }

}