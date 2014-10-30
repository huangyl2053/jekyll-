/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.dba1010011;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.KihonJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba1010011.ShikakuShutokuJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ResponseDataCreator;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 資格取得処理を行うDivControllerです。<br/>
 * 資格情報以外にも、医療保険や生活保護などの情報を表示し、修正や追加なども行うことができます。
 *
 * @author n8178 城間篤人
 */
public class ShikakuShutokuJoho {

    /**
     * 画面の初期化処理を行います。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> initialize(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 以下のデータを取得し、それぞれの履歴一覧に設定する。
        //      被保険者台帳、医療保険加入、生活保護、老齢福祉年金、施設入退所
        //
        //2, 保険者情報表示制御、幅調整のモード設定を行う。
        //   保険者の情報を取得し、その情報を元に以下のようにグリッドの表示を変更する。
        //2-1, 介護共通 業務Configの保険者情報が「単一保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併なし」の保険者である場合、「所在保険者」「措置元保険者」「旧保険者」列を非表示にする。
        //      (HokenshaJohoDisplayMode=TanitsuGappeiNashi)
        //      (DataGridWidth=Size5)"
        //2-2, 介護共通 業務Configの保険者情報が「単一保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併あり」の保険者である場合、「所在保険者」「措置元保険者」列を非表示、「旧保険者」列を表示する。
        //      (HokenshaJohoDisplayMode=TanitsuGappeiAri)
        //      (DataGridWidth=Size3)"
        //2-3, 介護共通 業務Configの保険者情報が「広域保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併なし」の保険者である場合、「所在保険者」「措置元保険者」列を表示、「旧保険者」列を非表示にする。
        //      (HokenshaJohoDisplayMode=KoikiGappeiNashi)
        //      (DataGridWidth=Size1)"
        //2-4, 介護共通 業務Configの保険者情報が「広域保険者」で被保険者台帳の証記載保険者番号より取得した保険者が「合併あり」の保険者である場合、「所在保険者」「措置元保険者」「旧保険者」列を表示する。
        //      (HokenshaJohoDisplayMode=KoikiGappeiAri)
        //      (DataGridWidth=Size1)"
        //3, 被保険者台帳管理の最新レコードの状態が「資格未取得」であることをチェックする。(レコードが存在しない、または資格喪失年月日が空白でない)
        //3-1, 被保険者台帳管理が資格未取得の状態でない場合は、資格得喪履歴パネルをReadOnlyに設定し、入力不可の状態にする。"
        //
        //4, 取得事由ドロップダウンリストに、コード種別:0117(介護資格取得事由（被保険者）)のデータを設定する。
        //
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 資格得喪の追加ボタンを押下した際に実行します。<br/>
     * 選択したメニューに合わせて、明細エリアの初期値設定などを行います。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnAddShikakuTokuso(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //TODO #52997
        //1, 「追加する」ボタンを押下不可にする。
        //2, 「資格得喪履歴一覧」をreadOnlyにする。
        //3, 明細エリアの項目を入力可にする。
        //4, 「取得日」、「届出日」のデフォルト設定を行う。
        //4-1, メニューID == DBAMN21001(転入により取得) の場合
        //      取得日 = 銃器情報の転入日
        //      届出日 = 銃器情報の転入届出日
        //4-2, メニューID == DBAMN21004(年齢到達により取得) の場合
        //      取得日、届出日 = 65歳到達時の誕生日の前日
        //4-3, 4-1、4-2以外 の場合
        //      取得日、届出日 = システム日付
        //5, 取得事由をメニューIDにより任意の項目を選択状態とし、非活性にする。
        //(※ただし「その他事由により取得」から遷移してきた場合のみ非活性にはしない)
        //  メニューID == DBAMN21001(転入により取得):「転入」
        //  メニューID == DBAMN21002(第２号被保険者取得申請により取得):「２号申請」
        //  メニューID == DBAMN21003(外国人申請により取得):「外国人」
        //  メニューID == DBAMN21004(年齢到達により取得):「年齢到達」
        //  メニューID == DBAMN21005(転居により取得):「合併内転居」
        //  メニューID == DBAMN21006(帰化により取得):「帰化」
        //  メニューID == DBAMN21007(職権により取得):「職権取得」
        //  メニューID == DBAMN21008(その他事由により取得):「その他」
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 被保険者履歴一覧グリッドから1行選択した際に実行されます。<br/>
     * 選択した行の内容を、明細エリアに表示します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onSelect_ccdShikakuTokusoRireki(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 「追加する」ボタンを押下不可にする。
        //2, 「資格得喪履歴一覧」をreadOnlyにする。
        //3, 明細エリアに選択行の内容を表示する。
        //4, 追加行を選択している場合、明細エリアの項目を入力可にする。(※取得事由は除く)。
        //  以外の行を選択した場合、明細エリアの項目を入力不可にして「確定する」ボタンを押下不可にする。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 被保険者履歴一覧グリッドの詳細ボタンをクリックした際に実行されます。<br/>
     * 資格詳細画面へ遷移する前に、選択している被保険者履歴の情報をViewStateに保存します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnShikakuShosai(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 選択行の情報を取得する。
        //2, 選択行の情報をModel化し、ViewStateに保存する。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 資格取得情報の入力を確定する前に実行するイベントです。<br/>
     * バリデーションチェックを行います。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onBeforeClick_btnDecideShikakuShutokuInput(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //バリデーションチェックを実装します。
        //以下のサンプルを参考に実装を行ってください。
        ResponseData<ShikakuShutokuJohoDiv> response = new ResponseData<>();
        //IValidationMessages validationMessages = validate(div);
        //ValidationHelper.appendMessages(response, validationMessages, ShikakuShutokuValidationMessageMapping.class);
        //response.data = div;
        return response;
    }

    private IValidationMessages validate(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 被保険者履歴一覧グリッドのデータを、Listで取得する。
        //2, 介護基本情報から、生年月日を取得する。
        //3, HihokenshaDaichoValidatorに、グリッドから取得したListと生年月日を渡してインスタンスを生成する。
        //4, HihokenshaDaichoValidatorのvalidate()メソッドを実行し、IValidationMessagesを取得する。
        //5, IValidationMessagesを返す。
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 資格取得情報の入力を確定する際に実行するイベントです。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnDecideShikakuShutokuInput(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 明細エリアの入力内容を被保履歴一覧 に反映させる。
        //2, 「被保険者履歴一覧」のReadOnlyを外す。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 資格取得情報入力のキャンセルボタンが押下された際に実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnCancelShikakuShutoku(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //以下のページの、6.1.3質問を参考に実装を行う。
        //http://zrtechwiki/techwiki/index.php/メッセージ・例外制御ガイドライン
        //
        //1, 以下のメッセージを持つダイアログを表示する。
        //      メッセージID：URZQ00007（入力された値を破棄します。よろしいですか？）
        //2, 表示されたダイアログのボタンをクリックした後、以下の処理に分岐する。
        //      はい：onYesの処理に進む。（明細エリアの値を破棄する）
        //      いいえ: ダイアログを閉じる
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * onClick_btnCanselShikakuShutoku実行時に表示される質問ダイアログで、Yesを選択した場合に実行される。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnCancelShikakuShutoku_onYes(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 明細エリアの各項目の値をクリアする。
        //2, 「被保険者履歴一覧」のReadOnlyを外す。
        //3, 最新履歴として追加行が存在し、追加行の退所日が空白の場合、「追加する」ボタンを押下不可の状態にして、以外の場合は押下可能にする。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 医療保険履歴の追加ボタンが押下された際に実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnAddIryoHokenRirekiIchiran(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 「追加する」ボタンを押下不可にする。
        //2, 「医療保険履歴一覧」をreadOnlyにする。
        //3, 明細エリアの項目を空白で表示する。【入力可】
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 医療保険履歴から1行選択した際に実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onSelect_ccdIryoHokenRireki(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 「追加する」ボタンを押下不可にする。
        //2, 「医療保険履歴一覧」をreadOnlyにする。
        //3, 明細エリアに選択行の内容を表示する。
        //4, 「確定する」ボタンを押下不可にする。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 医療保険履歴の修正ボタンが押下されたときに実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onSelectByModifyButton_ccdIryoHokenRireki(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 「追加する」ボタンを押下不可にする。
        //2, 「医療保険履歴一覧」をreadOnlyにする。
        //3, 明細エリアに選択行の内容を表示する。
        //4, 加入日を入力不可にする。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 医療保険履歴の削除ボタンが押下されたとき実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onSelectByDeleteButton_ccdIryoHokenRireki(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 「追加する」ボタンを押下不可にする。
        //2, 「医療保険履歴一覧」をreadOnlyにする。
        //3, 明細エリアに選択行の内容を表示する。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 医療保険情報の入力を確定するボタンが押下されたとき、onClickイベントの前に実行されるバリデーションチェックを行います。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onBeforeClick_btnDecideIryoHokenInput(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 加入日 ＞ 脱退日 のとき、エラーメッセージを表示する。
        // メッセージID：URZE00027（期間が不正です。%1－%2） %1:加入日, %2:脱退日
        //2, 修正時のみ 脱退日 ≧ 次の履歴データの加入日 のとき、エラーメッセージを表示する。
        // メッセージID：URZE00025（期間が重複しています。）
        //3, 追加時のみ 加入日 ≦ 前の履歴データの脱退日 のとき、エラーメッセージを表示する。
        // メッセージID：URZE00025（期間が重複しています。）
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 医療保険情報の入力を確定するボタンが押下されたときに実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnDecideIryoHokenInput(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 明細エリアの入力内容を医療保険履歴一覧 に反映させる。
        //2, 「医療保険履歴一覧」のReadOnlyを外す。
        //3, 最新履歴として追加行が存在し、追加行の脱退日が空白の場合、「追加する」ボタンを押下不可の状態にして、以外の場合は押下可能にする。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 医療保険情報の入力をキャンセルするボタンが押下されたときに実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnCancelIryoHokenInput(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //以下のページの、6.1.3質問を参考に実装を行う。
        //http://zrtechwiki/techwiki/index.php/メッセージ・例外制御ガイドライン
        //
        //1, 以下のメッセージを持つダイアログを表示する。
        //      メッセージID：URZQ00007（入力された値を破棄します。よろしいですか？）
        //2, 表示されたダイアログのボタンをクリックした後、以下の処理に分岐する。
        //      はい：onYesの処理に進む。（明細エリアの値を破棄する）
        //      いいえ: ダイアログを閉じる
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 医療保険情報の入力をキャンセルするボタンが押下された際に表示される質問ダイアログで、Yesが押下されたときに実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onBlick_btnCancelIryoHokenInput_onYes(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 明細エリアの各項目の値をクリアする。
        //2,「医療保険履歴一覧」のReadOnlyを外す。
        //3, 最新履歴として追加行が存在し、追加行の脱退日が空白の場合、「追加する」ボタンを押下不可の状態にして、以外の場合は押下可能にする。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 施設入退所の追加するボタンを押下した際に実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnAddShisetsuNyutaishoRireki(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 「追加する」ボタンを押下不可にする。
        //2, 「施設入退所履歴一覧」をreadOnlyにする。
        //3, 明細エリアの項目を空白で表示する。【入力可】
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 施設入退所履歴から1行選択した際に実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onSelect_ShisetsuNyutaishoRireki(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 「追加する」ボタンを押下不可にする。
        //2, 「施設入退所履歴一覧」をreadOnlyにする。
        //3, 明細エリアに選択行の内容を表示する。
        //4, 履歴から選択した行の状態により、処理を以下のように分岐する。
        //4-1, 状態が「追加」の場合、明細エリアの項目を入力可にする。
        //4-2, 状態が「修正」の場合、明細エリアの項目を入力可にする。(※入所日は入力不可)
        //4-3, 状態が「削除」の場合、明細エリアの項目を入力不可にする。
        //4-4, 状態が「空白」の場合、明細エリアの項目を入力不可にして「確定する」ボタンを押下不可にする。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 施設入退所履歴の修正ボタンが押下された際に実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onSelectByModifyButton_ShisetsuNyutaishoRireki(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 「追加する」ボタンを押下不可にする。
        //2, 「施設入退所履歴一覧」をreadOnlyにする。
        //3, 明細エリアに選択行の内容を表示する。
        //4, 入所日を入力不可にする。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 施設入退所履歴の削除ボタンが押下された際に実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onSelectByDeleteButton_ShisetsuNyutaishoRireki(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 「追加する」ボタンを押下不可にする。
        //2, 「施設入退所履歴一覧」をreadOnlyにする。
        //3, 明細エリアに選択行の内容を表示する。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 施設入退所情報入力の確定ボタンを押下した際に、onClickイベント前に実行されるバリデーションチェック処理です。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onBeforeClick_btnDecideShisetsuNyutaishoInput(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 入所日 ＞ 退所日 のとき、エラーメッセージを表示する。
        // メッセージID：URZE00027（期間が不正です。%1－%2） %1:入所日, %2:退所日
        //2, 修正時のみ 退所日 ≧ 次の履歴データの入所日 のとき、エラーメッセージを表示する。
        // メッセージID：URZE00025（期間が重複しています。）
        //3, 追加時のみ 入所日 ≦ 前の履歴データの退所日 のとき、エラーメッセージを表示する。
        // メッセージID：URZE00025（期間が重複しています。）
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 施設入退所情報入力の確定ボタンを押下した際に実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnDecideShisetsuNyutaishoInput(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1,  明細エリアの入力内容を施設入退所履歴一覧 に反映させる。
        //2,  「施設入退所履歴一覧」のReadOnlyを外す。
        //3,  最新履歴として追加行が存在し、追加行の退所日が空白の場合、「追加する」ボタンを押下不可の状態にして、以外の場合は押下可能にする。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 施設入退所情報入力でキャンセルボタンを押下した際に実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnCancelShisetsuNyutaishoInput(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //以下のページの、6.1.3質問を参考に実装を行う。
        //http://zrtechwiki/techwiki/index.php/メッセージ・例外制御ガイドライン
        //
        //1, 以下のメッセージを持つダイアログを表示する。
        //      メッセージID：URZQ00007（入力された値を破棄します。よろしいですか？）
        //2, 表示されたダイアログのボタンをクリックした後、以下の処理に分岐する。
        //      はい：onYesの処理に進む。（明細エリアの値を破棄する）
        //      いいえ: ダイアログを閉じる
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 施設入退所情報入力のキャンセルボタンを押下した際に表示される質問ダイアログで、yesを選択した場合に実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnCancelShisetsuNyutaishoInput_onYes(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 明細エリアの各項目の値をクリアする。
        //2, 「施設入退所履歴一覧」のReadOnlyを外す。
        //3, 最新履歴として追加行が存在し、追加行の退所日が空白の場合、「追加する」ボタンを押下不可の状態にして、以外の場合は押下可能にする。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 共通ボタンエリアの保存ボタンを押下した際に、onClickイベントの発火前に実行し、バリデーションチェック処理を行います。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onBeforeClick_btnSave(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 編集がない場合、エラーメッセージを表示する。
        //      メッセージID：URZE00045（編集されていないため、更新できません。）
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 共通ボタンエリアの保存ボタンを押下した際に実行します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnSave(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //以下のページの、6.1.3質問を参考に実装を行う。
        //http://zrtechwiki/techwiki/index.php/メッセージ・例外制御ガイドライン
        //
        //1, 以下のメッセージを持つダイアログを表示する。
        //      メッセージID：URZQ00001（保存します。よろしいですか？）
        //2, 表示されたダイアログのボタンをクリックした後、以下の処理に分岐する。
        //      はい：onYesの処理に進む。（明細エリアの値を破棄する）
        //      いいえ: ダイアログを閉じる
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * onClick_btnSaveで表示した質問ダイアログでyesを選択した場合に実行します。<br/>
     * 画面で入力した情報を保存します。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnSave_onYes(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 業務Configの被保険者番号方法を使用して、以下の分岐処理を実装する。
        //1-1, 被保険者番号方法が「自動連番付番」である場合
        //      採番マスタの被保番号の値＋１した前ゼロ10桁の値とする。
        //1-2, 被保険者番号方法が「識別コード付番」である場合
        //      識別コードの前ゼロ10桁の値とする。
        //1-3, 被保険者番号方法が「手入力付番」である場合
        //      資格取得の入力明細エリアで手入力した値（ShikakuShutokuInput.hihokenshaNo）とする。
        //1-4, 被保険者番号方法が「カスタマイズ付番」である場合
        //      １～３の取得方法を組み合わせて任意の10桁の値を設定する。
        //1-5, 被保険者番号方法が「自動連番付番チェックデジットあり」である場合
        //      採番マスタの被保番号の値＋１した前ゼロ9桁の値と、チェックデジットによって決まった１桁を末尾に設定した10桁の値とする。
        //
        //2, 入力された内容に応じて、被保険者台帳、医療保険加入、老齢福祉、生活保護、施設入退所の情報をそれぞれDBに登録する。
        //それぞれのグリッドの情報をmodelのListに変換し、ShikakuShutokuKanrenJohoRegisterに引き渡して保存を行います。
        //insert, update, deleteは、グリッドの状態列を元に決定します。
        //
        //3, 更新後の内容で再表示を行います。
        //   各履歴の表示モードを「照会」に変更し、追加するボタンがある場合はそれぞれ非表示にします。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 共通ボタンエリアの該当者一覧へ戻るボタンが押下されたときに実行します。<br/>
     * 質問ダイアログを表示し、はいを選択した場合画面遷移を行います。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnBackGaitoshaIchiran(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //以下のページの、6.1.3質問を参考に実装を行う。
        //http://zrtechwiki/techwiki/index.php/メッセージ・例外制御ガイドライン
        //
        //1, 編集が行われていた場合、以下のメッセージを持つダイアログを表示する。
        //   メッセージID：URZQ00004（編集されています。画面遷移してもよろしいですか？）
        //      1-1, 表示されたダイアログのボタンをクリックした後、以下の処理に分岐する。
        //          はい：入力を破棄し、該当者一覧画面へ遷移する。
        //          いいえ: ダイアログを閉じる
        //2, 編集が行われていない場合、該当者一覧画面へ遷移する。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

    /**
     * 共通ボタンエリアの検索画面へ戻るボタンが押下されたときに実行します。<br/>
     * 質問ダイアログを表示し、はいを選択した場合画面遷移を行う。
     *
     * @param shikakuShutokuDiv {@link ShikakuShutokuJohoDiv 資格取得情報Div}
     * @param kihonDiv {@link KihonJohoDiv 基本情報Div}
     * @return 資格取得情報Divを持つResponseData
     */
    public ResponseData<ShikakuShutokuJohoDiv> onClick_btnReserch(ShikakuShutokuJohoDiv shikakuShutokuDiv, KihonJohoDiv kihonDiv) {
        //1, 編集が行われていた場合、以下のメッセージを持つダイアログを表示する。
        //   メッセージID：URZQ00003（編集されています。検索画面へ遷移してもよろしいですか？）
        //      1-1, 表示されたダイアログのボタンをクリックした後、以下の処理に分岐する。
        //          はい：入力を破棄し、検索画面へ遷移する。
        //          いいえ: ダイアログを閉じる
        //2, 編集が行われていない場合、検索画面へ遷移する。
        return ResponseDataCreator.create(shikakuShutokuDiv);
    }

}
