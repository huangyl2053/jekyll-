/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.jushochitokureirirekilist;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

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
        //TODO
        //１）「追加する」ボタンを押下不可にする。
        //２）「住所地特例履歴一覧」をreadOnlyにする。
        //３）住所地特例入力明細エリアの項目をクリアし、入力可にする。

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
        //TODO
        //１）「追加する」ボタンを押下不可にする。
        //２）「住所地特例履歴一覧」をreadOnlyにする。
        //３）住所地特例入力明細エリアに選択行の内容を表示する。
        //４）追加行を選択している場合、明細エリアの項目を入力可にする。
        //以外の行を選択した場合、明細エリアの項目を入力不可にして「確定する」ボタンを押下不可にする。

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
        //TODO
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
        //TODO
        //１）住所地特例入力明細エリアの各項目の値をクリアする。
        //２）「住所地特例履歴一覧」のReadOnlyを外す。
        //３）追加行が存在しない場合は、「追加する」ボタンを押下可能にし、
        //    存在する場合は、「追加する」ボタンを押下不可の状態にする。

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
        //TODO
        //１）適用処理を行う場合、以下のバリデーションチェックを行う。
        //適用日 ＜ 最新履歴データの資格取得日
        //適用日 ＜ 最新履歴データの資格変更日
        //適用日 ＜ 最新履歴データの住所地特例解除日
        //１－１）チェックに当てはまった場合、以下のメッセージを表示する。
        //　メッセージID：URZE00025（期間が重複しています。）

        //２）解除処理を行い場合、以下のバリデーションチェックを行う。
        //解除日 ＜ 最新履歴データの資格取得日
        //解除日 ＜ 最新履歴データの資格変更日
        //解除日 ＜ 最新履歴データの住所地特例適用日
        //２－１）チェックに当てはまった場合、以下のメッセージを表示する。
        //メッセージID：URZE00025（期間が重複しています。）
        return createSettingData(jutokuRirekiDiv);
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
        //TODO
        //１）明細エリアの入力内容を住所地特例履歴一覧に反映させる。
        //２）「住所地特例履歴一覧」のReadOnlyを外す。
        //３）「追加する」ボタンを押下不可の状態にする。

        return createSettingData(jutokuRirekiDiv);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }
}
