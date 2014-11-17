/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.shikakuhenkorireki;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.ShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「資格変更履歴」のイベントを定義したDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class ShikakuHenkoRireki {

    /**
     * 追加ボタンを押下した際に実行します。<br/>
     * 追加処理をための前準備を行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnAdd(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        //TODO
        //１）「追加する」ボタンを押下不可にする。
        //２）「資格変更履歴一覧」をreadOnlyにする。
        //３）資格変更入力明細エリアの項目をクリアし、入力可にする。
        //３－１）MeisaiModeに、torokuを設定する。

        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 資格変更履歴上の一行が押下された際に実行します。<br/>
     * 選択行の状態に応じて、修正・照会などの処理のための前準備を行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onSelect_dgHenko(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        //TODO
        //１）「追加する」ボタンを押下不可にする。
        //２）「資格変更履歴一覧」をreadOnlyにする。
        //３）資格変更入力明細エリアに選択行の内容を表示する。
        //４）行の状態によって、以下の処理を行う。
        //４－１）「追加」「修正」行を選択している場合、明細エリアの項目を入力可にする。
        //４－１－１）MeisaiModeに、torokuを設定する。
        //４－２）状態が空白の行を選択した場合、明細エリアの項目を入力不可にして「確定する」ボタンを押下不可にする。
        //４－２－１）MeisaiModeに、shokaiを設定する。

        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 資格変更履歴上の修正アイコンが押下された際に実行します。<br/>
     * 修正・変更処理のための前準備を行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onSelectByModifyButton_dgHenko(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        //TODO
        //１）「追加する」ボタンを押下不可にする。
        //２）「資格変更履歴一覧」をreadOnlyにする。
        //３）明細エリアに選択行の内容を表示し、入力可とする。
        //３－１）MeisaiModeに、torokuを設定する。

        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 資格変更履歴上の削除アイコンが押下された際に実行します。<br/>
     * 削除処理のための前準備を行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onSelectByDeleteButton_dgHenko(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        //TODO
        //１）「追加する」ボタンを押下不可にする。
        //２）「資格変更履歴一覧」をreadOnlyにする。
        //３）明細エリアに選択行の内容を表示し、入力不可とする。
        //３－１）MeisaiModeに、sakujoを設定する。
        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 明細エリアの取消ボタンが押下された際に実行します。<br/>
     * 入力した情報を破棄してもよいかの確認メッセージを表示します。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnHenkoTorikeshi(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        //TODO
        //１）明細エリアの情報が変更されているかを確認する。
        //１－１）変更がない場合は、onClick_btnHenkoKakutei_onYesの処理を実行する。
        //１－２）変更が存在する場合は、２）の処理を実行する。
        //２）以下のメッセージを表示し、入力した値の破棄を行ってもよいかの確認をする。
        //メッセージID：URZQ00007（入力された値を破棄します。よろしいですか？）
        //      Yes：onClick_btnHenkoKakutei_onYesの処理を実行する。
        //      No:ダイアログを閉じる

        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 取消ボタンを押下した際に表示されるダイアログで、はいを選択した際に実行されます。<br/>
     * 明細エリアに入力した情報を破棄し、追加・修正・削除が可能な状態に戻します。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnHenkoTorikeshi_onYes(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        //TODO
        //１）入力した値を初期化する。
        //２）「追加する」ボタンを押下可能にする。
        //３）「資格変更履歴一覧」のreadOnlyを解除する。
        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 確定ボタンを押下した際に、onClick処理の前に実行されます。<br/>
     * 入力した情報について、バリデーションチェックを行います。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onBeforeClick_btnHenkoKakutei(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        //TODO
        //１）変更日 < 資格得喪情報の取得日のとき、エラーメッセージを表示する。
        //メッセージID：URZE00028（大小関係が不正です。(%1)）
        //%1：変更日 － 取得日

        //２）変更日 > 資格得喪情報の喪失日のとき、エラーメッセージを表示する。
        //メッセージID：URZE00028（大小関係が不正です。(%1)）
        //%1：変更日 － 取得日
        //"３）修正時のみ
        //：変更日 > 次の履歴データの変更日 のとき、エラーメッセージを表示する。
        //メッセージID：URZE00028（大小関係が不正です。(%1)）
        //%1：変更日 － 次履歴の変更日
        //４）修正時のみ
        //：変更日 < 一つ前の履歴データの変更日 のとき、エラーメッセージを表示する。
        //メッセージID：URZE00028（大小関係が不正です。(%1)）
        //%1：変更日 － 前履歴の変更日
        //５）入力した変更日と、住所地特例履歴一覧内全データの適用日と解除日の期間との比較で重複がある場合、エラーメッセージを表示する。
        //メッセージID：URZE00025（期間が重複しています。）
        //６）被保履歴一覧の最新履歴を修正している場合
        //：追加時
        //変更日 ≧ 資格変更履歴一覧 最新履歴.変更日の場合、エラーメッセージを表示する。
        //メッセージID：DBAE00003（最新の資格変更情報として追加することはできません。）
        //７）年齢チェックを行う。
        //７－１）変更事由が「１号到達」の場合、変更日と生年月日をもとに年齢を算出して、算出した年齢＜65歳の場合、エラーメッセージを表示する。
        //７－２）変更事由が「１号到達」以外の場合、変更日と生年月日をもとに年齢を算出して、算出した年齢40歳の場合、エラーメッセージを表示する。
        //メッセージID：DBZE00001（%1のため確定できません。）
        //７－１の場合　　%1：変更日時点での年齢が65歳未満
        //７－２の場合　　%1：変更日時点での年齢が40歳未満
        return createSettingData(henkoRirekiDiv);
    }

    /**
     * 確定ボタンを押下した時に実行されます。<br/>
     * 明細エリアの入力内容を資格変更履歴一覧に反映します。
     *
     * @param henkoRirekiDiv {@link ShikakuHenkoRirekiDiv 資格変更履歴Div}
     * @return 資格変更履歴Divを持つResponseData
     */
    public ResponseData<ShikakuHenkoRirekiDiv> onClick_btnHenkoKakutei(ShikakuHenkoRirekiDiv henkoRirekiDiv) {
        //TODO
        //１）明細エリアの入力内容を資格変更履歴一覧に反映させる。
        //１－１）追加の場合、以下の処理を行う。
        //１－１－１）入力した情報を履歴一覧の先頭に新規行を追加し、その行に情報を反映させる。
        //１－１－２）新規に追加した行の状態列に、「追加」を設定する。
        //１－２）修正の場合、以下の処理を行う
        //１－２－１）入力した情報を、現在選択中の行に反映させる。
        //１－２－２）修正した行の状態列に、「修正」を設定する。（ただし、状態に既に「追加」が設定されている場合は「追加」のままとする。
        //１－３）削除の場合、以下の処理を行う
        //１－３－１）新規に追加した行を削除する場合、その行を履歴一覧上から取り除く
        //１－３－２）その他の行を削除する場合、選択行の状態を削除に変更する。
        //２）「資格変更履歴一覧」のReadOnlyを外す。
        //３）「追加する」ボタンを押下可にする。

        return createSettingData(henkoRirekiDiv);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }
}
