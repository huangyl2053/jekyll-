package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 20 20:32:12 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgChosakekka1_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosakekka1_Row extends DataRow {

    private Button 編集;
    private RString チェック;
    private RString 群;
    private RString 内容;
    private RString 結果;
    private RString 選択肢;

    public dgChosakekka1_Row() {
        super();
        this.編集 = new Button();
        this.チェック = RString.EMPTY;
        this.群 = RString.EMPTY;
        this.内容 = RString.EMPTY;
        this.結果 = RString.EMPTY;
        this.選択肢 = RString.EMPTY;
    }

    public dgChosakekka1_Row(Button 編集, RString チェック, RString 群, RString 内容, RString 結果, RString 選択肢) {
        super();
        this.setOriginalData("編集", 編集);
        this.setOriginalData("チェック", チェック);
        this.setOriginalData("群", 群);
        this.setOriginalData("内容", 内容);
        this.setOriginalData("結果", 結果);
        this.setOriginalData("選択肢", 選択肢);
        this.編集 = 編集;
        this.チェック = チェック;
        this.群 = 群;
        this.内容 = 内容;
        this.結果 = 結果;
        this.選択肢 = 選択肢;
    }

    public Button get編集() {
        return 編集;
    }

    public RString getチェック() {
        return チェック;
    }

    public RString get群() {
        return 群;
    }

    public RString get内容() {
        return 内容;
    }

    public RString get結果() {
        return 結果;
    }

    public RString get選択肢() {
        return 選択肢;
    }

    public void set編集(Button 編集) {
        this.setOriginalData("編集", 編集);
        this.編集 = 編集;
    }

    public void setチェック(RString チェック) {
        this.setOriginalData("チェック", チェック);
        this.チェック = チェック;
    }

    public void set群(RString 群) {
        this.setOriginalData("群", 群);
        this.群 = 群;
    }

    public void set内容(RString 内容) {
        this.setOriginalData("内容", 内容);
        this.内容 = 内容;
    }

    public void set結果(RString 結果) {
        this.setOriginalData("結果", 結果);
        this.結果 = 結果;
    }

    public void set選択肢(RString 選択肢) {
        this.setOriginalData("選択肢", 選択肢);
        this.選択肢 = 選択肢;
    }

}