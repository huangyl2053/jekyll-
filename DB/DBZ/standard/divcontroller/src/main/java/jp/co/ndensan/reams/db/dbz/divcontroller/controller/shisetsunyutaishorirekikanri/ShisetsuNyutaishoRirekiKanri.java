/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.shisetsunyutaishorirekikanri;

import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;

import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoMapper;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.db.dbz.model.validation.ShisetsuNyutaishoValidationMessage;
import jp.co.ndensan.reams.db.dbz.divcontroller.messagemapping.ShisetsuNyutaishoValidationMessageMapping;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.model.shisetsunyutaisho.ShisetsuNyutaishoModel;
import jp.co.ndensan.reams.db.dbz.model.shisetsunyutaisho.ShisetsuNyutaishoRirekiKanriContext;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrQuestionMessages;
//import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationHelper;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.DivcontrollerMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICallbackMethod;
import jp.co.ndensan.reams.uz.uza.ui.servlets.SingleButtonType;

/**
 * 共有子Div「施設入退所履歴管理」のイベントを定義した共有子Divです。
 *
 * @author n8178 城間篤人
 * @author n8223 朴義一
 */
public class ShisetsuNyutaishoRirekiKanri {

    private static final RString MODE_INSERT = new RString("追加");
    private static final RString MODE_UPDATE = new RString("修正");
    private static final RString MODE_DELETE = new RString("削除");

    /**
     * 共有子Divのロード時に行う処理です。
     *
     * @param shisetsuNyutaishoRirekiDiv
     * @return レスポンス
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onLoad(ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {
        createHandlerOf(shisetsuNyutaishoRirekiDiv).initialize();
        return createSettingData(shisetsuNyutaishoRirekiDiv);
    }

    /**
     * 追加ボタンが押下された際に実行します。<br/>
     * 追加処理のための前準備を行います。
     *
     * @param shisetsuNyutaishoRirekiDiv
     * {@link ShisetsuNyutaishoRirekiKanriDiv 施設入退所履歴Div}
     * @return 施設入退所履歴Divを持つResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onClick_btnAddShisetsuNyutaisho(
            ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {

        //TODO
        //１）「追加する」ボタンを押下不可にする。
        shisetsuNyutaishoRirekiDiv.getBtnAddShisetsuNyutaisho().setDisabled(true);
        //２）「施設入退所履歴一覧」をreadOnlyにする。
        shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().setReadOnly(true);
        //３）明細エリアの項目を空白で表示する。【入力可】
        shisetsuNyutaishoRirekiDiv.clearInputData();
        //３－１）明細表示モードに、追加・修正を設定する。
        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getTxtNyushoDate().setReadOnly(false);
        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getTxtNyushoDate().setValue(FlexibleDate.getNowDate());
        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getTxtTaishoDate().setReadOnly(false);
        shisetsuNyutaishoRirekiDiv.setMode_明細表示モード(ShisetsuNyutaishoRirekiKanriDiv.明細表示モード.追加_修正);
        shisetsuNyutaishoRirekiDiv.setInputMode(ViewExecutionStatus.Add.getValue());

        return createSettingData(shisetsuNyutaishoRirekiDiv);
    }

    /**
     * 施設入退所履歴上の1行が選択された際に実行します。<br/>
     * 選択行の状態に応じて、修正・照会などの処理のための前準備を行います。
     *
     * @param shisetsuNyutaishoRirekiDiv
     * {@link ShisetsuNyutaishoRirekiKanriDiv 施設入退所履歴Div}
     * @return 施設入退所履歴Divを持つResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onSelect_dgShisetsuNyutaishoRireki(
            ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {

        dgShisetsuNyutaishoRireki_Row selectedRow = shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().getClickedItem();

        //TODO
        //１）「追加する」ボタンを押下不可にする。
        shisetsuNyutaishoRirekiDiv.getBtnAddShisetsuNyutaisho().setDisabled(true);
        //２）「施設入退所履歴一覧」をreadOnlyにする。
        shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().setReadOnly(true);

        //shisetsuNyutaishoRirekiDiv .setInputMode();
        //４）選択行の状態によって、以下のように処理する。
        RString rowState = shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().getClickedItem().getState();

        if (MODE_INSERT.equals(rowState) || MODE_UPDATE.equals(rowState)) {
            shisetsuNyutaishoRirekiDiv.setMode_明細表示モード(ShisetsuNyutaishoRirekiKanriDiv.明細表示モード.追加_修正);
            shisetsuNyutaishoRirekiDiv.setInputMode(ViewExecutionStatus.Modify.getValue());

        } else if (MODE_DELETE.equals(rowState)) {
            shisetsuNyutaishoRirekiDiv.setMode_明細表示モード(ShisetsuNyutaishoRirekiKanriDiv.明細表示モード.削除);
            shisetsuNyutaishoRirekiDiv.setInputMode(ViewExecutionStatus.Delete.getValue());

        } else {
            shisetsuNyutaishoRirekiDiv.getBtnAddShisetsuNyutaisho().setDisabled(false);
            shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().setReadOnly(false);
            shisetsuNyutaishoRirekiDiv.setMode_明細表示モード(ShisetsuNyutaishoRirekiKanriDiv.明細表示モード.選択不可);
            shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoKakutei().setDisabled(true);
            shisetsuNyutaishoRirekiDiv.setInputMode(ViewExecutionStatus.None.getValue());

        }
        //３）明細エリアに選択行の内容を表示する。
        createHandlerOf(shisetsuNyutaishoRirekiDiv).showSelectedData(selectedRow);

        //４－１）状態が「追加」の場合、明細エリアの項目を入力可にする。
        //４－１－１）明細表示モードに、追加・修正を設定する。
        //４－２）状態が「修正」の場合、明細エリアの項目を入力可にする。
        //４－２－１）明細表示モードに、追加・修正を設定する。
        //４ー３）状態が「削除」の場合、明細エリアの項目を入力不可にする。
        //４－３－１）明細表示モードに、削除を設定する。
        //４－４）状態が「空白」の場合、明細エリアの項目を入力不可にして「確定する」ボタンを押下不可にする。
        //４－４－１）明細表示モードに、選択不可を設定する。
        return createSettingData(shisetsuNyutaishoRirekiDiv);
    }

    /**
     * 施設入退所履歴上の修正アイコンが押下された際に実行します。<br/>
     * 修正・変更処理のための前準備を行います。
     *
     * @param shisetsuNyutaishoRirekiDiv
     * {@link ShisetsuNyutaishoRirekiKanriDiv 施設入退所履歴Div}
     * @return 施設入退所履歴Divを持つResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onSelectByModifyButton_dgShisetsuNyutaishoRireki(
            ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {

        dgShisetsuNyutaishoRireki_Row selectedRow = shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().getClickedItem();

        //TODO
        //１）「追加する」ボタンを押下不可にする。
        shisetsuNyutaishoRirekiDiv.getBtnAddShisetsuNyutaisho().setDisabled(true);
        //２）「施設入退所履歴一覧」をreadOnlyにする。
        shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().setReadOnly(true);

        //３－１）明細表示モードに、追加・修正を設定する。
        shisetsuNyutaishoRirekiDiv.setMode_明細表示モード(ShisetsuNyutaishoRirekiKanriDiv.明細表示モード.追加_修正);
        //３）明細エリアに選択行の内容を表示する。
        shisetsuNyutaishoRirekiDiv.setInputMode(ViewExecutionStatus.Modify.getValue());
        createHandlerOf(shisetsuNyutaishoRirekiDiv).showSelectedData(selectedRow);

        return createSettingData(shisetsuNyutaishoRirekiDiv);
    }

    /**
     * 施設入退所履歴上の削除アイコンが押下された際に実行します。<br/>
     * 削除処理のための前準備を行います。
     *
     * @param shisetsuNyutaishoRirekiDiv
     * {@link ShisetsuNyutaishoRirekiKanriDiv 施設入退所履歴Div}
     * @return 施設入退所履歴Divを持つResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onSelectByDeleteButton_dgShisetsuNyutaishoRireki(
            ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {

        dgShisetsuNyutaishoRireki_Row selectedRow = shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().getClickedItem();

        //TODO
        //１）「追加する」ボタンを押下不可にする。
        shisetsuNyutaishoRirekiDiv.getBtnAddShisetsuNyutaisho().setDisabled(true);
        //２）「施設入退所履歴一覧」をreadOnlyにする。
        shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().setReadOnly(true);

        //３）明細エリアに選択行の内容を表示する。
        //４）明細エリア上の、確定ボタンと取消ボタン以外の項目を全て非活性にする
        //４－１）明細表示モードに、削除を設定する。
        shisetsuNyutaishoRirekiDiv.setMode_明細表示モード(ShisetsuNyutaishoRirekiKanriDiv.明細表示モード.削除);
        shisetsuNyutaishoRirekiDiv.setInputMode(ViewExecutionStatus.Delete.getValue());
        shisetsuNyutaishoRirekiDiv.getShisetsuNyutaishoInput().setReadOnly(true);
        createHandlerOf(shisetsuNyutaishoRirekiDiv).showSelectedData(selectedRow);

        return createSettingData(shisetsuNyutaishoRirekiDiv);
    }

    /**
     * 確定ボタンを押下した際に、onClick処理の前に実行されます。<br/>
     * 入力した情報について、バリデーションチェックを行います。
     *
     * @param shisetsuNyutaishoRirekiDiv
     * {@link ShisetsuNyutaishoRirekiKanriDiv 施設入退所履歴Div}
     * @return 施設入退所履歴Divを持つResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onBeforeClick_btnShisetsuNyutaishoKakutei(
            ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {
        ResponseData<ShisetsuNyutaishoRirekiKanriDiv> response = new ResponseData<>();

        //TODO
        //１）入所日 ＞ 退所日 のとき、エラーメッセージを表示する。
        //       メッセージID：URZE00027（期間が不正です。%1－%2）
        //　　　　%1：入所日
        //　　　　%2：退所日
        //２）修正時のみ
        //：退所日 ≧ 次の履歴データの入所日 のとき、エラーメッセージを表示する。
        //       メッセージID：URZE00025（期間が重複しています。）
        //３）追加時・修正時のみ
        //：入所日 ≦ 前の履歴データの退所日 のとき、エラーメッセージを表示する。
        //       メッセージID：URZE00025（期間が重複しています。）
        IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();

        //※ 現在のリストにmodelへいれる。そして、stateによって「追加・変更・削除」をもとにバリデーションチェックを行います。※
        ShisetsuNyutaishoRelateModel model = ShisetsuNyutaishoMapper.toShisetsuNyutaishoRelateModel(shisetsuNyutaishoRirekiDiv);
        RString rowState = shisetsuNyutaishoRirekiDiv.getInputMode();

        Optional<ShisetsuNyutaishoModel> 前履歴;
        Optional<ShisetsuNyutaishoModel> 次履歴;
        IItemList<ShisetsuNyutaishoModel> 全履歴;

        switch (ViewExecutionStatus.toValue(rowState)) {

            case Add:
                前履歴 = Optional.empty();
                次履歴 = Optional.empty();
                全履歴 = createHandlerOf(shisetsuNyutaishoRirekiDiv).get施設入退所履歴().map(toShisetsuNyutaishoModel());
                break;
            case Modify:
                int rowIndex = Integer.valueOf(shisetsuNyutaishoRirekiDiv.getSelectRow().toString()).intValue();

                if (rowIndex != 0) {
                    int rdx = rowIndex - 1;
                    dgShisetsuNyutaishoRireki_Row row = shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().getDataSource().get(rdx);
                    次履歴 = createHandlerOf(shisetsuNyutaishoRirekiDiv).get施設入退所履歴()
                            .filter(ShisetsuNyutaishoMapper.createKey(row))
                            .findJustOne().map(toShisetsuNyutaishoModel());
                } else {
                    次履歴 = Optional.empty();
                }

                if (rowIndex + 1 <= shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().getDataSource().size() - 1) {
                    int rdx = rowIndex + 1;
                    dgShisetsuNyutaishoRireki_Row row = shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().getDataSource().get(rdx);
                    前履歴 = createHandlerOf(shisetsuNyutaishoRirekiDiv).get施設入退所履歴()
                            .filter(ShisetsuNyutaishoMapper.createKey(row))
                            .findJustOne().map(toShisetsuNyutaishoModel());
                } else {
                    前履歴 = Optional.empty();
                }

                全履歴 = ItemList.empty();
                break;
            case Delete:
            default:
                前履歴 = Optional.empty();
                次履歴 = Optional.empty();
                全履歴 = ItemList.empty();
                break;
        }
        ShisetsuNyutaishoRirekiKanriContext context = new ShisetsuNyutaishoRirekiKanriContext(ViewExecutionStatus.toValue(rowState), 前履歴, 次履歴, 全履歴);
        //バリデーションチェック
        validationMessages.add(model.get介護保険施設入退所モデル().validateIn(context));
        //バリデーションチェック
//        if (validationMessages.contains(ShisetsuNyutaishoValidationMessage.入所日が未入力)) {
//            //４）ValidationHelper.appendMessagesを使用して、responseにバリデーションメッセージを付加する。
//            ValidationHelper.appendMessages(response, validationMessages, ShisetsuNyutaishoValidationMessageMapping.class);
//        }
//        if (validationMessages.contains(ShisetsuNyutaishoValidationMessage.終了日設定なし)) {
//            //４）ValidationHelper.appendMessagesを使用して、responseにバリデーションメッセージを付加する。
//            ValidationHelper.appendMessages(response, validationMessages, ShisetsuNyutaishoValidationMessageMapping.class);
//        }
//
//        if (validationMessages.contains(ShisetsuNyutaishoValidationMessage.入所施設が未入力)) {
//            //４）ValidationHelper.appendMessagesを使用して、responseにバリデーションメッセージを付加する。
//            ValidationHelper.appendMessages(response, validationMessages, ShisetsuNyutaishoValidationMessageMapping.class);
//        }
//
//        if (validationMessages.contains(ShisetsuNyutaishoValidationMessage.入所年月日より前)) {
//            //４）ValidationHelper.appendMessagesを使用して、responseにバリデーションメッセージを付加する。
//            ValidationHelper.appendMessages(response, validationMessages, ShisetsuNyutaishoValidationMessageMapping.class);
//
//        }
//        if (validationMessages.contains(ShisetsuNyutaishoValidationMessage.退所日と次の履歴データの入所日の期間が重複)) {
//            //４）ValidationHelper.appendMessagesを使用して、responseにバリデーションメッセージを付加する。
//            ValidationHelper.appendMessages(response, validationMessages, ShisetsuNyutaishoValidationMessageMapping.class);
//
//        }
//        if (validationMessages.contains(ShisetsuNyutaishoValidationMessage.入所日と前の履歴データの退所日の期間が重複)) {
//            //４）ValidationHelper.appendMessagesを使用して、responseにバリデーションメッセージを付加する。
//            ValidationHelper.appendMessages(response, validationMessages, ShisetsuNyutaishoValidationMessageMapping.class);
//
//        }
//        if (validationMessages.contains(ShisetsuNyutaishoValidationMessage.入所日と期間が重複する履歴がある)) {
//            //４）ValidationHelper.appendMessagesを使用して、responseにバリデーションメッセージを付加する。
//            ValidationHelper.appendMessages(response, validationMessages, ShisetsuNyutaishoValidationMessageMapping.class);
//
//        }
//        if (validationMessages.contains(ShisetsuNyutaishoValidationMessage.退所日と期間が重複する履歴がある)) {
//            //４）ValidationHelper.appendMessagesを使用して、responseにバリデーションメッセージを付加する。
//            ValidationHelper.appendMessages(response, validationMessages, ShisetsuNyutaishoValidationMessageMapping.class);
//
//        }

        //４）ValidationHelper.appendMessagesを使用して、responseにバリデーションメッセージを付加する。
        response.data = shisetsuNyutaishoRirekiDiv;
        return response;
    }

    private IFunction<ShisetsuNyutaishoRelateModel, ShisetsuNyutaishoModel> toShisetsuNyutaishoModel() {
        return new IFunction<ShisetsuNyutaishoRelateModel, ShisetsuNyutaishoModel>() {
            @Override
            public ShisetsuNyutaishoModel apply(ShisetsuNyutaishoRelateModel t) {
                return t.get介護保険施設入退所モデル();
            }
        };
    }

    /**
     * 確定ボタンを押下した時に実行されます。<br/>
     * 明細エリアの入力内容を施設入退所履歴一覧に反映します。
     *
     * @param shisetsuNyutaishoRirekiDiv
     * {@link ShisetsuNyutaishoRirekiKanriDiv 施設入退所履歴Div}
     * @return 施設入退所履歴Divを持つResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onClick_btnShisetsuNyutaishoKakutei(ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {

        //TODO
        //１）追加を確定する場合以下の処理を行う。
        //  →入力した内容を元に、新規行を追加する。新規行に明細エリアの情報を設定し、状態列には「追加」を設定する。
        //１－１）追加を行う際、1つ前の施設入退所情報の「退所日」の項目が空白である場合
        //        新規に追加した情報の「入所日」の1日前の日付を、1つ前の施設入退所情報の「退所日」に設定する。
        //２）修正を確定する場合
        //　→選択している行に対して、明細に入力した内容を反映させる。
        // 修正対象の状態行が「新規」だった場合は「新規」、それ以外の場合は「修正」を設定する。
        //３）・削除を確定する場合
        //　→選択している行の状態列を"削除"に変更する。
        //新規に追加した行に対して削除する場合は、追加行をグリッドから取り除く。
        ShisetsuNyutaishoRelateModel model = ShisetsuNyutaishoMapper.toShisetsuNyutaishoRelateModel(shisetsuNyutaishoRirekiDiv);

        // 明細の入所年月日・退所年月日
        createHandlerOf(shisetsuNyutaishoRirekiDiv).update施設入退所履歴(model);

        //４）「施設入退所履歴一覧」のReadOnlyを外す。
        shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().setReadOnly(false);
        //５）明細表示モードに選択不可を設定する。
        shisetsuNyutaishoRirekiDiv.setMode_明細表示モード(ShisetsuNyutaishoRirekiKanriDiv.明細表示モード.選択不可);
        //６）「追加する」ボタンを押下可能にする。
        shisetsuNyutaishoRirekiDiv.getBtnAddShisetsuNyutaisho().setDisabled(false);
        //明細内容クリア
        createHandlerOf(shisetsuNyutaishoRirekiDiv).clearInputData();

        return createSettingData(shisetsuNyutaishoRirekiDiv);
    }

    /**
     * 明細エリアの取消ボタンが押下された際に実行します。<br/>
     * 入力した情報を破棄してもよいかの確認メッセージを表示します。
     *
     * @param shisetsuNyutaishoRirekiDiv
     * {@link ShisetsuNyutaishoRirekiKanriDiv 施設入退所履歴Div}
     * @return 施設入退所履歴Divを持つResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onClick_btnShisetsuNyutaishoTorikeshi(ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {

        ResponseData<ShisetsuNyutaishoRirekiKanriDiv> response = new ResponseData<>();
        //TODO
        //１）明細エリアの情報が変更されているかを確認する。
        //１－１）変更がない場合は、onClick_btnIryoHokenTorikeshi_onYesの処理を実行する。
        //１－２）変更が存在する場合は、２）の処理を実行する。
        //２）以下のメッセージを表示し、入力した値の破棄を行ってもよいかの確認をする。
        //メッセージID：URZQ00007（入力された値を破棄します。よろしいですか？）
        //      Yes：onClick_btnIryoHokenTorikeshi_onYesの処理を実行する。
        //      No:ダイアログを閉じる

        boolean flg = shisetsuNyutaishoRirekiDiv.hasChangedInMeisai();
        if (!flg) {
            return this.onClick_btnShisetsuNyutaishoTorikeshi_onYes(shisetsuNyutaishoRirekiDiv);
        }

        // DivController.onYesメソッドを呼ぶ
        ICallbackMethod methodYes = DivcontrollerMethod.method(SingleButtonType.Free, "onClick_btnShisetsuNyutaishoTorikeshi_onYes");

        QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                UrQuestionMessages.入力内容の破棄.getMessage().evaluate(), "はい", "いいえ");

        ICallbackMethod[] methods = {methodYes}; //ユーザー選択時の動作を規定する
        message.addInvokeMethod(methods);

        response.addMessage(message);
        response.data = shisetsuNyutaishoRirekiDiv;
        return response;
    }

    /**
     * 取消ボタンを押下した際に表示されるダイアログで、はいを選択した際に実行されます。<br/>
     * 明細エリアに入力した情報を破棄し、追加・修正・削除が可能な状態に戻します。
     *
     * @param shisetsuNyutaishoRirekiDiv
     * {@link ShisetsuNyutaishoRirekiKanriDiv 施設入退所履歴Div}
     * @return 施設入退所履歴Divを持つResponseData
     */
    public ResponseData<ShisetsuNyutaishoRirekiKanriDiv> onClick_btnShisetsuNyutaishoTorikeshi_onYes(
            ShisetsuNyutaishoRirekiKanriDiv shisetsuNyutaishoRirekiDiv) {

        //TODO
        //１）明細エリアの各項目の値をクリアする。
        // 施設入退所の明細
        createHandlerOf(shisetsuNyutaishoRirekiDiv).clearInputData();

        //２）「施設入退所履歴一覧」のReadOnlyを外す。
        shisetsuNyutaishoRirekiDiv.getDgShisetsuNyutaishoRireki().setReadOnly(false);
        shisetsuNyutaishoRirekiDiv.getBtnAddShisetsuNyutaisho().setDisabled(false);

        //３）明細表示モードに選択不可を設定する。
        shisetsuNyutaishoRirekiDiv.setMode_明細表示モード(ShisetsuNyutaishoRirekiKanriDiv.明細表示モード.選択不可);
        return createSettingData(shisetsuNyutaishoRirekiDiv);

    }

    private ShisetsuNyutaishoRirekiKanriHandler createHandlerOf(ShisetsuNyutaishoRirekiKanriDiv requestDiv) {
        return new ShisetsuNyutaishoRirekiKanriHandler(requestDiv);
    }

    private <T> ResponseData<T> createSettingData(T settingData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = settingData;
        return response;
    }

}
