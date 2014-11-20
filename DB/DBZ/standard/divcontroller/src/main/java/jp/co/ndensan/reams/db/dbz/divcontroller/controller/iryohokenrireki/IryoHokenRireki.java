/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.iryohokenrireki;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki.IryoHokenRirekiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「医療保険履歴」のイベントを定義したDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class IryoHokenRireki {

    /**
     * 追加ボタンが押下された際に実行します。<br/>
     * 追加処理のための前準備を行います。
     *
     * @param iryoHokenDiv {@link IryoHokenRirekiDiv 医療保険履歴Div}
     * @return 医療保険履歴Divを持つResponseData
     */
    public ResponseData<IryoHokenRirekiDiv> onClick_btnAddIryoHoken(IryoHokenRirekiDiv iryoHokenDiv) {
        //TODO
        //１）「追加する」ボタンを押下不可にする。
        //２）「医療保険履歴一覧」をreadOnlyにする。
        //３）医療保険情報入力明細エリアの項目をクリアし、入力可にする。
        //３－１）MeisaiModeにtorokuを設定する。

        return createSettingData(iryoHokenDiv);
    }

    /**
     * 医療保険履歴上の一行が押下された際に実行します。<br/>
     * 選択行の状態に応じて、修正・照会などの処理のための前準備を行います。
     *
     * @param iryoHokenDiv {@link IryoHokenRirekiDiv 医療保険履歴Div}
     * @return 医療保険履歴Divを持つResponseData
     */
    public ResponseData<IryoHokenRirekiDiv> onSelect_dgIryoHokenRireki(IryoHokenRirekiDiv iryoHokenDiv) {
        //TODO
        //１）「追加する」ボタンを押下不可にする。
        //２）「医療保険履歴一覧」をreadOnlyにする。
        //３）医療保険入力明細エリアに選択行の内容を表示する。
        //４）選択行の状態に合わせて、以下のように処理を分岐する。
        //４－１）「追加」「修正」行を選択している場合、明細エリアの項目を入力可にする。
        //４－１－１）MeisaiModeにtorokuを設定する。
        //４－２）状態が空白の行を選択した場合、明細エリアの項目を入力不可にして「確定する」ボタンを押下不可にする。
        //４－２－１）MeisaiModeにsetReadOnlyを設定する。
        return createSettingData(iryoHokenDiv);
    }

    /**
     * 医療保険履歴上の修正アイコンが押下された際に実行します。<br/>
     * 修正・変更処理のための前準備を行います。
     *
     * @param iryoHokenDiv {@link IryoHokenRirekiDiv 医療保険履歴Div}
     * @return 医療保険履歴Divを持つResponseData
     */
    public ResponseData<IryoHokenRirekiDiv> onSelectByModifyButton_dgIryoHokenRireki(IryoHokenRirekiDiv iryoHokenDiv) {
        //TODO
        //１）「追加する」ボタンを押下不可にする。
        //２）「医療保険履歴一覧」をreadOnlyにする。
        //３）明細エリアに選択行の内容を表示する。
        //３－１）MeisaiModeにtorokuを設定する。

        return createSettingData(iryoHokenDiv);
    }

    /**
     * 医療保険履歴上の削除アイコンが押下された際に実行します。<br/>
     * 削除処理のための前準備を行います。
     *
     * @param iryoHokenDiv {@link IryoHokenRirekiDiv 医療保険履歴Div}
     * @return 医療保険履歴Divを持つResponseData
     */
    public ResponseData<IryoHokenRirekiDiv> onSelectByDeleteButton_dgIryoHokenRireki(IryoHokenRirekiDiv iryoHokenDiv) {
        //TODO
        //１）「追加する」ボタンを押下不可にする。
        //２）「医療保険履歴一覧」をreadOnlyにする。
        //３）明細エリアに選択行の内容を表示する。
        //４）確定する ボタンと取り消し ボタン以外の、明細エリア内のコントロールをreadOnlyにする。
        //４－１）MeisaiModeにsakujoを設定する。
        return createSettingData(iryoHokenDiv);
    }

    /**
     * 確定ボタンを押下した際に、onClick処理の前に実行されます。<br/>
     * 入力した情報について、バリデーションチェックを行います。
     *
     * @param iryoHokenDiv {@link IryoHokenRirekiDiv 医療保険履歴Div}
     * @return 医療保険履歴Divを持つResponseData
     */
    public ResponseData<IryoHokenRirekiDiv> onBeforeClick_btnIryoHokenKakutei(IryoHokenRirekiDiv iryoHokenDiv) {
        //TODO
        //１）加入日 ＞ 脱退日 のとき、エラーメッセージを表示する。
        //　メッセージID：URZE00027（期間が不正です。%1－%2）
        //　　　　%1：加入日
        //　　　　%2：脱退日

        //２）修正処理の場合のみ、以下のチェックを行う。
        //：脱退日 ≧ 次の履歴データの加入日 のとき、エラーメッセージを表示
        //　メッセージID：URZE00025（期間が重複しています。）
        //
        //３）追加処理・修正処理の場合に、以下のチェックを行う。
        //：加入日 ≦ 前の履歴データの脱退日 のとき、エラーメッセージを表示
        //　メッセージID：URZE00025（期間が重複しています。）
        return createSettingData(iryoHokenDiv);
    }

    /**
     * 確定ボタンを押下した時に実行されます。<br/>
     * 明細エリアの入力内容を医療保険履歴一覧に反映します。
     *
     * @param iryoHokenDiv {@link IryoHokenRirekiDiv 医療保険履歴Div}
     * @return 医療保険履歴Divを持つResponseData
     */
    public ResponseData<IryoHokenRirekiDiv> onClick_btnIryoHokenKakutei(IryoHokenRirekiDiv iryoHokenDiv) {
        //TODO
        //１）追加を確定する場合以下の処理を行う。
        //  →入力した内容を元に、新規行を追加する。新規行に明細エリアの情報を設定し、状態列には「追加」を設定する。
        //２）修正を確定する場合
        //　→選択している行に対して、明細に入力した内容を反映させる。
        // 修正対象の状態行が「新規」だった場合は「新規」、それ以外の場合は「修正」を設定する。
        //３）・削除を確定する場合
        //　→選択している行の状態列を"削除"に変更する。
        //    新規に追加した行に対して削除する場合は、追加行をグリッドから取り除く。
        //４）「医療保険履歴一覧」のReadOnlyを外す。
        //５）MeisaiModeにsetReadOnlyを設定する。
        //６）「追加する」ボタンを押下可能にする。

        return createSettingData(iryoHokenDiv);
    }

    /**
     * 明細エリアの取消ボタンが押下された際に実行します。<br/>
     * 入力した情報を破棄してもよいかの確認メッセージを表示します。
     *
     * @param iryoHokenDiv {@link IryoHokenRirekiDiv 医療保険履歴Div}
     * @return 医療保険履歴Divを持つResponseData
     */
    public ResponseData<IryoHokenRirekiDiv> onClick_btnIryoHokenTorikeshi(IryoHokenRirekiDiv iryoHokenDiv) {
        //TODO
        //１）明細エリアの情報が変更されているかを確認する。
        //１－１）変更がない場合は、onClick_btnIryoHokenTorikeshi_onYesの処理を実行する。
        //１－２）変更が存在する場合は、２）の処理を実行する。
        //２）以下のメッセージを表示し、入力した値の破棄を行ってもよいかの確認をする。
        //メッセージID：URZQ00007（入力された値を破棄します。よろしいですか？）
        //      Yes：onClick_btnIryoHokenTorikeshi_onYesの処理を実行する。
        //      No:ダイアログを閉じる

        return createSettingData(iryoHokenDiv);
    }

    /**
     * 取消ボタンを押下した際に表示されるダイアログで、はいを選択した際に実行されます。<br/>
     * 明細エリアに入力した情報を破棄し、追加・修正・削除が可能な状態に戻します。
     *
     * @param iryoHokenDiv {@link IryoHokenRirekiDiv 医療保険履歴Div}
     * @return 医療保険履歴Divを持つResponseData
     */
    public ResponseData<IryoHokenRirekiDiv> onClick_btnIryoHokenTorikeshi_onYes(IryoHokenRirekiDiv iryoHokenDiv) {
        //TODO
        //１）明細エリアの各項目の値をクリアする。
        //２）「医療保険履歴一覧」のReadOnlyを外す。
        //３）MeisaiModeにsetReadOnlyを設定する。
        //４）「追加する」ボタンを押下可能にする。

        return createSettingData(iryoHokenDiv);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }
}
