package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon May 26 17:50:49 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShinsakaiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIchiran_Row extends DataRow {

    private Button toroku;
    private RString 審査会名;
    private RString 合議体;
    private RString 審査会会場;
    private TextBoxFlexibleDate 審査開催日;
    private RString 審査開始;
    private RString 審査終了;
    private RString 対象人数;
    private RString 審査会状況;

    public dgShinsakaiIchiran_Row() {
        super();
    }

    public dgShinsakaiIchiran_Row(Button toroku, RString 審査会名, RString 合議体, RString 審査会会場, TextBoxFlexibleDate 審査開催日, RString 審査開始, RString 審査終了, RString 対象人数, RString 審査会状況) {
        super();
        this.setOriginalData("toroku", toroku);
        this.setOriginalData("審査会名", 審査会名);
        this.setOriginalData("合議体", 合議体);
        this.setOriginalData("審査会会場", 審査会会場);
        this.setOriginalData("審査開催日", 審査開催日);
        this.setOriginalData("審査開始", 審査開始);
        this.setOriginalData("審査終了", 審査終了);
        this.setOriginalData("対象人数", 対象人数);
        this.setOriginalData("審査会状況", 審査会状況);
        this.toroku = toroku;
        this.審査会名 = 審査会名;
        this.合議体 = 合議体;
        this.審査会会場 = 審査会会場;
        this.審査開催日 = 審査開催日;
        this.審査開始 = 審査開始;
        this.審査終了 = 審査終了;
        this.対象人数 = 対象人数;
        this.審査会状況 = 審査会状況;
    }

    public Button getToroku() {
        return toroku;
    }

    public RString get審査会名() {
        return 審査会名;
    }

    public RString get合議体() {
        return 合議体;
    }

    public RString get審査会会場() {
        return 審査会会場;
    }

    public TextBoxFlexibleDate get審査開催日() {
        return 審査開催日;
    }

    public RString get審査開始() {
        return 審査開始;
    }

    public RString get審査終了() {
        return 審査終了;
    }

    public RString get対象人数() {
        return 対象人数;
    }

    public RString get審査会状況() {
        return 審査会状況;
    }

    public void setToroku(Button toroku) {
        this.setOriginalData("toroku", toroku);
        this.toroku = toroku;
    }

    public void set審査会名(RString 審査会名) {
        this.setOriginalData("審査会名", 審査会名);
        this.審査会名 = 審査会名;
    }

    public void set合議体(RString 合議体) {
        this.setOriginalData("合議体", 合議体);
        this.合議体 = 合議体;
    }

    public void set審査会会場(RString 審査会会場) {
        this.setOriginalData("審査会会場", 審査会会場);
        this.審査会会場 = 審査会会場;
    }

    public void set審査開催日(TextBoxFlexibleDate 審査開催日) {
        this.setOriginalData("審査開催日", 審査開催日);
        this.審査開催日 = 審査開催日;
    }

    public void set審査開始(RString 審査開始) {
        this.setOriginalData("審査開始", 審査開始);
        this.審査開始 = 審査開始;
    }

    public void set審査終了(RString 審査終了) {
        this.setOriginalData("審査終了", 審査終了);
        this.審査終了 = 審査終了;
    }

    public void set対象人数(RString 対象人数) {
        this.setOriginalData("対象人数", 対象人数);
        this.対象人数 = 対象人数;
    }

    public void set審査会状況(RString 審査会状況) {
        this.setOriginalData("審査会状況", 審査会状況);
        this.審査会状況 = 審査会状況;
    }

}