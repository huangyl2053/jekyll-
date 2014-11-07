/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.model;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;

/**
 * 資格取得の際、1トランザクションでまとめて登録したい情報を保持するModelです。
 *
 * @author n8178 城間篤人
 */
public class ShikakuShutokuKanrenJohoModel {

    //TODO #52997
    //更新対象となるModelのListをメンバとして保持している。
    //以下のように、各メンバを宣言していく。
    //
    //※genericsに指定しているModelの型は仮に設定しています。
    //Modelの自動生成後に、それぞれ対応する型に変更してください。
    //
    private List<HihokenshaDaichoModel> 被保険者台帳ModelList;
    //private List<IryoHokenKanyuJokyoModel> 医療保険加入状況ModelList;
    //private List<SeikatsuHogoModel> 生活保護ModelList;
    //private List<RoreiHukusiModel> 老齢福祉ModelList;
    //private List<ShisetsuNyutaisho> 施設入退所ModelList;

    /**
     * コンストラクタです。
     *
     * @param 被保険者台帳ModelList 被保険者台帳ModelList
     * @param 医療保険加入状況ModelList 医療保険加入状況ModelList
     * @param 生活保護ModelList 生活保護ModelList
     * @param 老齢福祉ModelList 老齢福祉ModelList
     * @param 施設入退所ModelList 施設入退所ModelList
     */
    public ShikakuShutokuKanrenJohoModel(List<HihokenshaDaichoModel> 被保険者台帳ModelList) {// List 医療保険加入状況ModelList ... ) {
        //TODO #52997
        //コンストラクタで、各メンバの値を引数から受け取るように実装してください。
        //受け取る引数は、全てnullチェックをお願いします。
    }

    /**
     * 被保険者台帳ModelのListを取得します。
     *
     * @return 被保険者台帳ModelList
     */
    public List<HihokenshaDaichoModel> get被保険者台帳ModelList() {
        return Collections.unmodifiableList(被保険者台帳ModelList);
    }

    //TODO #52997
    //get被保険者台帳Modelを参考に、各メンバのgetterを以下に実装してください。
    //戻り値は必ず、Collestions.ummodifiableListを使用して、変更不可のListにして返すようにしてください。
}
