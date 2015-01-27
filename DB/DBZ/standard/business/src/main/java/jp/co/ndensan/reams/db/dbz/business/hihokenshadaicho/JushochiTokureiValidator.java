/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.validation.JushochiTokureiValidationMessage;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validation.IValidatable;
import static jp.co.ndensan.reams.ur.urz.model.validation.ValidationChain.validateFollowingItems;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 被保険者台帳に対して、住所地特例の情報を登録する際に必要なバリデーションです。
 *
 * @author n8178 城間篤人
 */
public class JushochiTokureiValidator {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private JushochiTokureiValidator() {
    }

    /**
     * チェック対象の住所地特例データを設定します。
     *
     * @param jushochiTokureiData 住所地特例情報
     * @return 住所地特例のListを設定するためのインターフェース
     */
    public static IJushochiTokureiListSetter setJushochiTokureiData(HihokenshaDaichoModel jushochiTokureiData) {
        return new _JushochiTokureiValidator(jushochiTokureiData);
    }

    /**
     * 住所地特例のListを設定するための機能を提供するインターフェースです。
     */
    public interface IJushochiTokureiListSetter {

        /**
         * チェックに使用する住所地特例Listを設定します。
         *
         * @param jushochiTokureiList 住所地特例List
         * @return バリデーションクラスを扱うインターフェース
         */
        IValidatable setJushochiTokureiList(IItemList<HihokenshaDaichoModel> jushochiTokureiList);
    }

    private static class _JushochiTokureiValidator implements IValidatable, IJushochiTokureiListSetter {

        private final HihokenshaDaichoModel jushochiTokureiData;
        private IItemList<HihokenshaDaichoModel> jushochiTokureiList;

        /**
         * コンストラクタです。
         *
         * @param jushochiTokureiData 住所地特例情報
         */
        public _JushochiTokureiValidator(HihokenshaDaichoModel jushochiTokureiData) {
            requireNonNull(jushochiTokureiData, UrSystemErrorMessages.値がnull.getReplacedMessage("登録する住所地特例情報"));
            this.jushochiTokureiData = jushochiTokureiData;
        }

        @Override
        public IValidatable setJushochiTokureiList(IItemList<HihokenshaDaichoModel> jushochiTokureiList) {
            requireNonNull(jushochiTokureiList, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例List"));
            this.jushochiTokureiList = jushochiTokureiList;
            return this;
        }

        @Override
        public IValidationMessages validate() {
            return validateFollowingItems()
                    .then(is住所地特例の期間が不正())
                    .then(is住特適用日が資格取得日より前())
                    .then(is住特適用日が資格喪失日以降())
                    .then(is住特解除日が資格取得日より前())
                    .then(is住特解除日が資格喪失日以降())
                    .then(is住所地特例期間重複())
                    .end();
        }

        private IValidationMessages is住特適用日が資格取得日より前() {
            IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();

            if (jushochiTokureiData.get適用年月日().isBefore(jushochiTokureiData.get資格取得年月日())) {
                validationMessages.add(JushochiTokureiValidationMessage.住特適用日が資格取得日より前);
            }
            return validationMessages;
        }

        private IValidationMessages is住特適用日が資格喪失日以降() {
            IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();

            if (jushochiTokureiData.get資格喪失年月日().isBeforeOrEquals(jushochiTokureiData.get適用年月日())) {
                validationMessages.add(JushochiTokureiValidationMessage.住特適用日が資格喪失日以降);
            }
            return validationMessages;
        }

        private IValidationMessages is住特解除日が資格取得日より前() {
            IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();
            if (jushochiTokureiData.get解除年月日() == null || jushochiTokureiData.get解除年月日().isEmpty()) {
                return validationMessages;
            }

            if (jushochiTokureiData.get解除年月日().isBefore(jushochiTokureiData.get資格取得年月日())) {
                validationMessages.add(JushochiTokureiValidationMessage.住特解除日が資格取得日より前);
            }
            return validationMessages;
        }

        private IValidationMessages is住特解除日が資格喪失日以降() {
            IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();
            if (jushochiTokureiData.get解除年月日() == null || jushochiTokureiData.get解除年月日().isEmpty()) {
                return validationMessages;
            }

            if (jushochiTokureiData.get資格喪失年月日().isBefore(jushochiTokureiData.get解除年月日())) {
                validationMessages.add(JushochiTokureiValidationMessage.住特解除日が資格喪失日以降);
            }
            return validationMessages;
        }

        private IValidationMessages is住所地特例期間重複() {
            //TODO n8178 城間篤人 どのようにチェックを行うか考える必要がある。
            IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();
            //５）jushochiTokureiDataが持つ適用日・解除日の期間と、住所地特例履歴一覧内の全データの適用日・解除日との比較で重複が有る場合、
            //   エラーメッセージを表示する。
            //    メッセージID：URZE00025(期間が重複しています。）
            //５－１）もし、jushochiTokureiDataが修正処理によって生成されてものである場合、修正対象のレコードはチェック対象からはずす。
            return validationMessages;
        }

        private IValidationMessages is住所地特例の期間が不正() {
            IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();
            if (jushochiTokureiData.get解除年月日() == null || jushochiTokureiData.get解除年月日().isEmpty()) {
                return validationMessages;
            }

            if (jushochiTokureiData.get解除年月日().isBeforeOrEquals(jushochiTokureiData.get適用年月日())) {
                validationMessages.add(JushochiTokureiValidationMessage.住所地特例期間が不正_適用日が解除日の後);
            }
            return validationMessages;
        }

    }
}
