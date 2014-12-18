/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.shokaishukirokukanri;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.ShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「証回収記録管理」のイベントを定義した共有子Divです。
 *
 * @author n8178 城間篤人
 */
public class ShoKaishuKirokuKanri {

    /**
     * 証回収状況Listの1行を選択した際に実行されます。<br/>
     * 選択行の情報を明細エリアに表示します。
     *
     * @param shoKaishuDiv {@link ShoKaishuKirokuKanriDiv 証回収記録管理Div}
     * @return 証回収記録管理Divを持つResponseData
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onSelect_dgShoKaishuJokyo(ShoKaishuKirokuKanriDiv shoKaishuDiv) {
        //TODO
        //１）明細エリアに選択行の内容を表示する。(照会のためreadOnly)
        //１－１）表示方法モードに、照会を設定する。

        return createSettingData(shoKaishuDiv);
    }

    /**
     * 証回収状況Listの選択ボタンを押下した際に実行されます。<br/>
     * 選択行の情報を、回収情報について追記可能な状態で明細エリアに表示します。
     *
     * @param shoKaishuDiv {@link ShoKaishuKirokuKanriDiv 証回収記録管理Div}
     * @return 証回収記録管理Divを持つResponseData
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onSelectBySelectButton_dgShoKaishuJokyo(ShoKaishuKirokuKanriDiv shoKaishuDiv) {
        //TODO
        //１）明細エリアに選択行の内容を表示する。
        //２）表示方法モードに、入力を設定する。
        return createSettingData(shoKaishuDiv);
    }

    /**
     * 確定ボタンを押下した際に、onClick処理の前に実行されます。<br/>
     * 入力した情報について、バリデーションチェックを行います。
     *
     * @param shoKaishuDiv {@link ShoKaishuKirokuKanriDiv 証回収記録管理Div}
     * @return 証回収記録管理Divを持つResponseData
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onBeforeClick_btnShoKaishuKakutei(ShoKaishuKirokuKanriDiv shoKaishuDiv) {
        ResponseData<ShoKaishuKirokuKanriDiv> response = new ResponseData<>();
        //TODO
        //１）交付日 ＞ 回収日 のとき、エラーメッセージを表示する。
        //メッセージID：URZE00027（期間が不正です。%1－%2）
        //　　　　%1：交付日
        //　　　　%2：回収日

        //２）回収日 ≧ 次の履歴データの交付日 のとき、エラーメッセージを表示する。
        //　メッセージID：URZE00025（期間が重複しています。）
        //３）回収日 ≦ 前の履歴データの回収日 のとき、エラーメッセージを表示する。
        //　メッセージID：URZE00025（期間が重複しています。）
        //４）ValidationHelper.appendMessagesを使用して、responseにバリデーションメッセージを付加する。
        response.data = shoKaishuDiv;
        return response;
    }

    /**
     * 確定ボタンを押下した時に実行されます。<br/>
     * 明細エリアの入力内容を証回収状況履歴一覧に反映します。
     *
     * @param shoKaishuDiv {@link ShoKaishuKirokuKanriDiv 証回収記録管理Div}
     * @return 証回収記録管理Divを持つResponseData
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_btnShoKaishuKakutei(ShoKaishuKirokuKanriDiv shoKaishuDiv) {
        //TODO
        //１）明細エリアの入力内容を証回収記録一覧に反映させる。
        //２）修正した行の状態カラムを「修正」に変更する。
        //３）「証回収記録一覧」のReadOnlyを外す。
        //４）表示方法モードに、照会を設定する。

        return createSettingData(shoKaishuDiv);
    }

    /**
     * 明細エリアの取消ボタンが押下された際に実行します。<br/>
     * 入力した情報を破棄してもよいかの確認メッセージを表示します。
     *
     * @param shoKaishuDiv {@link ShoKaishuKirokuKanriDiv 証回収記録管理Div}
     * @return 証回収記録管理Divを持つResponseData
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_btnShoKaishuTorikeshi(ShoKaishuKirokuKanriDiv shoKaishuDiv) {
        //TODO
        //１）明細エリアの情報が変更されているかを確認する。
        //１－１）変更がない場合は、onClick_btnShoKaishuTorikeshi_onYesの処理を実行する。
        //１－２）変更が存在する場合は、２）の処理を実行する。
        //２）以下のメッセージを表示し、入力した値の破棄を行ってもよいかの確認をする。
        //メッセージID：URZQ00007（入力された値を破棄します。よろしいですか？）
        //      Yes：onClick_btnShoKaishuTorikeshi_onYesの処理を実行する。
        //      No:ダイアログを閉じる

        return createSettingData(shoKaishuDiv);
    }

    /**
     * 取消ボタンを押下した際に表示されるダイアログで、はいを選択した際に実行されます。<br/>
     * 明細エリアに入力した情報を破棄し、別処理が可能となる状態に戻します。
     *
     * @param shoKaishuDiv {@link ShoKaishuKirokuKanriDiv 証回収記録管理Div}
     * @return 証回収記録管理Divを持つResponseData
     */
    public ResponseData<ShoKaishuKirokuKanriDiv> onClick_btnShoKaishuTorikeshi_onYes(ShoKaishuKirokuKanriDiv shoKaishuDiv) {
        //TODO
        //１）明細エリアの各項目をクリアする。
        //２）「証回収記録一覧」のReadOnlyを外す。
        //３）表示方法モードに、照会を設定する。

        return createSettingData(shoKaishuDiv);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }

}
