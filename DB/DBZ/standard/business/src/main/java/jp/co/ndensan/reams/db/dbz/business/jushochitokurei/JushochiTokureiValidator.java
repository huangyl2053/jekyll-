/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.jushochitokurei;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validation.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 被保険者台帳に対して、住所地特例の情報を登録する際に必要なバリデーションです。
 *
 * @author n8178 城間篤人
 */
public final class JushochiTokureiValidator {

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
    public static IJushochiTokureiListSetter setJushochiTokureiData(HihokenshaDaicho jushochiTokureiData) {
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
        IValidatable setJushochiTokureiList(IItemList<HihokenshaDaicho> jushochiTokureiList);
    }

    private static class _JushochiTokureiValidator implements IValidatable, IJushochiTokureiListSetter {

        private final HihokenshaDaicho jushochiTokureiData;
        //private IItemList<HihokenshaDaicho> jushochiTokureiList;

        /**
         * コンストラクタです。
         *
         * @param jushochiTokureiData 住所地特例情報
         */
        public _JushochiTokureiValidator(HihokenshaDaicho jushochiTokureiData) {
            requireNonNull(jushochiTokureiData, UrSystemErrorMessages.値がnull.getReplacedMessage("登録する住所地特例情報"));
            this.jushochiTokureiData = jushochiTokureiData;
        }

        @Override
        public IValidatable setJushochiTokureiList(IItemList<HihokenshaDaicho> jushochiTokureiList) {
            requireNonNull(jushochiTokureiList, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例List"));
            //this.jushochiTokureiList = jushochiTokureiList;
            return this;
        }

        @Override
        public IValidationMessages validate() {
            IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();
            validationMessages.add(
                    ValidateChain.validateStart(jushochiTokureiData)
                    .ifNot(JushochiTokureiSpec.住特適用日が資格取得日より前)
                    .thenAdd(JushochiTokureiValidatorMessage.住特適用日が資格取得日より前)
                    .ifNot(JushochiTokureiSpec.住特適用日が資格喪失日以降)
                    .thenAdd(JushochiTokureiValidatorMessage.住特適用日が資格喪失日以降)
                    .ifNot(JushochiTokureiSpec.住特解除日が資格取得日より前)
                    .thenAdd(JushochiTokureiValidatorMessage.住特解除日が資格取得日より前)
                    .ifNot(JushochiTokureiSpec.住特解除日が資格喪失日以降)
                    .thenAdd(JushochiTokureiValidatorMessage.住特解除日が資格喪失日以降)
                    .ifNot(JushochiTokureiSpec.住所地特例期間が不正_適用日が解除日の後)
                    .thenAdd(JushochiTokureiValidatorMessage.住所地特例期間が不正_適用日が解除日の後)
                    .messages());
            return validationMessages;
        }
    }
}
