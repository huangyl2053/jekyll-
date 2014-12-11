/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.jushochitokureirirekilist;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JushochiTokureiRirekiListHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ViewExecutionStatus;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共有子Div「住所地特例履歴List」のイベントを定義したDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class JushochiTokureiRirekiList {

    /**
     * 追加ボタンが押下された際に実行されます。<br/>
     * 住所地特例の情報を追加するための前処理を行います。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onClick_btnAdd(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        //TODO #55852
        //１）「追加する」ボタンを押下不可にする。
        //２）「住所地特例履歴一覧」をreadOnlyにする。
        //３）住所地特例入力明細エリアの項目をクリアし
        //3.5),入力可にする。
        //４）共有子Divが持つ処理判定区分に、追加を設定する。
        jutokuRirekiDiv.getBtnAdd().setDisabled(true);
        jutokuRirekiDiv.getDgJutoku().setReadOnly(true);

        jutokuRirekiDiv.clearInputData();
        JushochiTokureiRirekiListHandler handler = new JushochiTokureiRirekiListHandler(jutokuRirekiDiv);
        handler.setMeisaiInputMode();

        jutokuRirekiDiv.setExecutionStatus(ViewExecutionStatus.Add.getValue());
        return createSettingData(jutokuRirekiDiv);
    }

    /**
     * 住所地特例履歴上の1行を選択した際に実行されます。<br/>
     * 選択行の内容を明細エリアに表示し、選択行の状態に応じて、修正・照会の前処理を行います。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onSelect_dgJutoku(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        //TODO #55852
        //１）「追加する」ボタンを押下不可にする。
        //２）「住所地特例履歴一覧」をreadOnlyにする。
        jutokuRirekiDiv.getBtnAdd().setDisabled(true);
        jutokuRirekiDiv.getDgJutoku().setReadOnly(true);
        //３）住所地特例入力明細エリアに選択行の内容を表示する。
        //４）選択行の状態によって、以下のように処理を行う。
        //４－１）状態が「追加」・「修正」である行を選択している場合、明細エリアの項目を入力可にして「確定する」ボタンを押下可能にする。
        //４－１－１）選択行と処理内容によって以下の処理に分岐する。
        //４－１－１－１）選択している行が適用の行である場合、MeisaiDisplayModeにtekiyoInputを設定する。
        //４－１－１－２）選択している行が解除の行である場合、MeisaiDisplayModeにkaijoInputを設定する。
        //４－１－１－３）訂正処理を行っている場合は、MeisaiDisplayModeにteiseiInputを設定する。
        //４－１－２）共有子Divが持つ処理判定区分に、修正を設定する。
        //４－２）状態が「削除」である行を選択した場合、明細エリアの項目を入力不可にして「確定する」ボタンを押下可能にする。
        //４－２－１）訂正処理を行っている場合は、MeisaiDisplayModeにteiseiShokaiを設定する。
        //４－２－２）共有子Divが持つ処理判定区分に、削除を設定する。
        //４－３）状態が空白である行を選択した場合、明細エリアの項目を入力不可にして「確定する」ボタンを押下不可にする。
        //４－３－１）選択している行が適用の行である場合、MeisaiDisplayModeにtekiyoShokaiを設定する。
        //４－３－２）選択している行が解除の行である場合、MeisaiDisplayModeにkaijoShokaiを設定する。
        //４－３－２）訂正処理を行っている場合は、MeisaiDisplayModeにteiseiShokaiを設定する。

        return createSettingData(jutokuRirekiDiv);
    }

    /**
     * 住所地特例履歴上の修正ボタンを押下した際に実行されます。<br/>
     * 選択行の内容を明細エリアに表示し、選択行の状態に応じて、住所地特例情報を修正するための前処理を行います。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onSelectByModifyButton_dgJutoku(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        //TODO #55852
        //１）「追加する」ボタンを押下不可にする。
        //２）「住所地特例履歴一覧」をreadOnlyにする。
        //３）住所地特例入力明細エリアに選択行の内容を表示する。
        //４）選択行と処理内容によって以下の処理に分岐する。
        //４－１）選択している行が適用の行である場合、MeisaiDisplayModeにtekiyoInputを設定する。
        //４－２）選択している行が解除の行である場合、MeisaiDisplayModeにkaijoInputを設定する。
        //４－３）訂正処理を行っている場合は、MeisaiDisplayModeにteiseiInputを設定する。
        //５）共有子Divが持つ処理判定区分に、修正を設定する。
        jutokuRirekiDiv.getBtnAdd().setDisabled(true);
        jutokuRirekiDiv.getDgJutoku().setReadOnly(true);

        jutokuRirekiDiv.setMode_BtnDisplayMode(JushochiTokureiRirekiListDiv.BtnDisplayMode.SetDisplay);
        return createSettingData(jutokuRirekiDiv);
    }

    /**
     * 住所地特例履歴上の削除ボタンを押下した際に実行されます。<br/>
     * 選択行の内容を明細エリアに表示し、選択行の状態に応じて、住所地特例情報を削除するための前処理を行います。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onSelectByDeleteButton_dgJutoku(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        //TODO #55852
        //１）「追加する」ボタンを押下不可にする。
        //２）「住所地特例履歴一覧」をreadOnlyにする。
        //３）住所地特例入力明細エリアに選択行の内容を表示する。
        //４）選択行と処理内容によって以下の処理に分岐する。
        //４－１）選択している行が適用の行である場合、MeisaiDisplayModeにtekiyoShokaiを設定する。
        //４－２）選択している行が解除の行である場合、MeisaiDisplayModeにkaijoShokaiを設定する。
        //４－３）訂正処理を行っている場合は、MeisaiDisplayModeにteiseiShokaiを設定する。
        //５）共有子Divが持つ処理判定区分に、削除を設定する。
        return createSettingData(jutokuRirekiDiv);
    }

    /**
     * 取消ボタンが押下された際に実行します。<br/>
     * 入力を取りやめる際、明細エリアに入力した情報を初期化してよいか確認するダイアログを表示します。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onClick_btnJutokuTorikeshi(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        //TODO #55852
        //１）明細エリアの情報が変更されているかを確認する。
        //１－１）変更がない場合は、onClick_btnJutokuTorikeshi_onYesの処理を実行する。
        //１－２）変更が存在する場合は、２）の処理を実行する。
        //メッセージID：URZQ00007（入力された値を破棄します。よろしいですか？）
        //      Yes：２の処理に進む。（明細エリアの値を破棄する）
        //      No : ダイアログを閉じる

        return createSettingData(jutokuRirekiDiv);
    }

    /**
     * 取消ボタンを押下した時に表示される、ダイアログ上のはいを選択した際に実行されます。<br/>
     * 明細エリアの情報を破棄し、追加・修正等の処理が可能な状態にします。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onClick_btnJutokuTorikeshi_onYes(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        //TODO #55852
        //１）住所地特例入力明細エリアの各項目の値をクリアする。
        //２）「住所地特例履歴一覧」のReadOnlyを外す。
        //３）共有子Divが持つ処理判定区分に、処理無しを設定する。

        return createSettingData(jutokuRirekiDiv);
    }

    /**
     * 確定ボタンが押下された際に実行される、onClickイベントの前に実行されます。<br/>
     * 明細エリアに入力した値のバリデーションチェックを行います。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onBeforeClick_btnJutokuKakutei(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        ResponseData<JushochiTokureiRirekiListDiv> response = new ResponseData<>();
        //TODO #55852
        //１）JuchochiTokureiValidatorを用いて、バリデーションをチェックする。
        //２）適用処理を行う場合、さらにJuchochiTokureiTekiyoTorokuValidatorを用いてチェックを行う。
        //３）解除処理を行う場合、さらにJuchochiTokureiKaijoTorokuValidatorを用いてチェックを行う。
        //４）JushochiTokureiDuplicateValidatorを用いて、
        //    住所地特例情報・他市町村住所地特例・適用除外者それぞれの情報に対して、期間の重複がないかをチェックします。
        //５）ValidationHelper.appendMessagesを使用して、responseにバリデーションメッセージを付加する。
        response.data = jutokuRirekiDiv;
        return response;
    }

    /**
     * 確定ボタンが押下された際に実行されます。<br/>
     * 明細エリアの情報を、住所地特例履歴Listに反映させます。
     *
     * @param jutokuRirekiDiv
     * {@link JushochiTokureiRirekiListDiv 住所地特例履歴ListDiv}
     * @return 住所地特例履歴ListDivを持つResponseData
     */
    public ResponseData<JushochiTokureiRirekiListDiv> onClick_btnJutokuKakutei(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        //TODO #55852
        //１）明細エリアの入力内容を住所地特例履歴一覧に反映させる。
        //２）追加を確定する場合は、以下のように処理を行う。
        //    入力した内容を元に、新規行を作成してグリッドに追加する。
        //    状態列には「追加」を設定する。
        //３）修正を確定する場合は、以下の処理を行う。
        //    選択している行に対して、明細に入力した内容を反映させる。
        //    修正対象の状態行が「追加」だった場合は「追加」、それ以外の場合は「修正」を設定する。
        //４）削除を確定する場合は、以下の処理を行う。
        //    選択している行の状態列を「削除」に変更する。
        //    新規に追加した行に対して削除する場合は、追加行をグリッドから取り除く。
        //５）明細に設定されている内容をクリアする。
        //６）明細をReadOnlyにする。
        //７）「住所地特例履歴一覧」のReadOnlyを外す。
        return createSettingData(jutokuRirekiDiv);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }

}
