package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 08 16:34:20 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgImageMaskShoriTaishosha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgImageMaskShoriTaishosha_Row extends DataRow {

    private Button 処理;
    private RString 保険者;
    private RString 被保番号;
    private RString 氏名;
    private RString 申請日;
    private RString 申請区分;
    private RString 審査予定日;
    private RString マスク区分;

    public dgImageMaskShoriTaishosha_Row() {
        super();
    }

    public dgImageMaskShoriTaishosha_Row(Button 処理, RString 保険者, RString 被保番号, RString 氏名, RString 申請日, RString 申請区分, RString 審査予定日, RString マスク区分) {
        super();
        this.setOriginalData("処理", 処理);
        this.setOriginalData("保険者", 保険者);
        this.setOriginalData("被保番号", 被保番号);
        this.setOriginalData("氏名", 氏名);
        this.setOriginalData("申請日", 申請日);
        this.setOriginalData("申請区分", 申請区分);
        this.setOriginalData("審査予定日", 審査予定日);
        this.setOriginalData("マスク区分", マスク区分);
        this.処理 = 処理;
        this.保険者 = 保険者;
        this.被保番号 = 被保番号;
        this.氏名 = 氏名;
        this.申請日 = 申請日;
        this.申請区分 = 申請区分;
        this.審査予定日 = 審査予定日;
        this.マスク区分 = マスク区分;
    }

    public Button get処理() {
        return 処理;
    }

    public RString get保険者() {
        return 保険者;
    }

    public RString get被保番号() {
        return 被保番号;
    }

    public RString get氏名() {
        return 氏名;
    }

    public RString get申請日() {
        return 申請日;
    }

    public RString get申請区分() {
        return 申請区分;
    }

    public RString get審査予定日() {
        return 審査予定日;
    }

    public RString getマスク区分() {
        return マスク区分;
    }

    public void set処理(Button 処理) {
        this.setOriginalData("処理", 処理);
        this.処理 = 処理;
    }

    public void set保険者(RString 保険者) {
        this.setOriginalData("保険者", 保険者);
        this.保険者 = 保険者;
    }

    public void set被保番号(RString 被保番号) {
        this.setOriginalData("被保番号", 被保番号);
        this.被保番号 = 被保番号;
    }

    public void set氏名(RString 氏名) {
        this.setOriginalData("氏名", 氏名);
        this.氏名 = 氏名;
    }

    public void set申請日(RString 申請日) {
        this.setOriginalData("申請日", 申請日);
        this.申請日 = 申請日;
    }

    public void set申請区分(RString 申請区分) {
        this.setOriginalData("申請区分", 申請区分);
        this.申請区分 = 申請区分;
    }

    public void set審査予定日(RString 審査予定日) {
        this.setOriginalData("審査予定日", 審査予定日);
        this.審査予定日 = 審査予定日;
    }

    public void setマスク区分(RString マスク区分) {
        this.setOriginalData("マスク区分", マスク区分);
        this.マスク区分 = マスク区分;
    }

}