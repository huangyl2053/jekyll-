/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.TashichosonJushochiTokureiModel;
import jp.co.ndensan.reams.db.dbz.model.TekiyoJogaishaModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.validation.JushochiTokureiValidationMessage;
import jp.co.ndensan.reams.db.dbz.persistence.relate.TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.realservice.TashichosonJushochiTokureiManager;
import jp.co.ndensan.reams.db.dbz.realservice.TekiyoJogaishaManager;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import static jp.co.ndensan.reams.ur.urz.model.validation.ValidationChain.validateFollowingItems;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;

/**
 * 登録する住所地特例情報の期間が、他市町村住所地特例テーブルの情報や適用除外者テーブルに登録されている情報と重複していないかをチェックします。
 *
 * @author n8178 城間篤人
 */
public final class JushochiTokureiUnduplicateValidator {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private JushochiTokureiUnduplicateValidator() {
    }

    /**
     * 住所地特例情報を設定します。
     *
     * @param hihoDaicho 被保険者台帳Model
     * @return バリデーションクラスを扱うインターフェース
     */
    public static IValidatable setHihokenshaDaichoData(HihokenshaDaichoModel hihoDaicho) {
        return new _JushochiTokureiDuplicateValidator(hihoDaicho);
    }

    /**
     * テスト用の設定クラスです。DacのMockなどを引数から渡して、バリデーションクラスを生成します。
     *
     * @param jushochiTokureiManager 他市町村住所地特例Manager
     * @param tekiyoJogiaManager 適用除外Manager
     * @param hihoDaicho 被保険者台帳情報
     * @return バリデーションクラスを扱うインターフェース
     */
    static IValidatable setHihokenshaDaichoData(TashichosonJushochiTokureiManager jushochiTokureiManager,
            TekiyoJogaishaManager tekiyoJogiaManager, HihokenshaDaichoModel hihoDaicho) {
        return new _JushochiTokureiDuplicateValidator(jushochiTokureiManager, tekiyoJogiaManager, hihoDaicho);
    }

    private static class _JushochiTokureiDuplicateValidator implements IValidatable {

        private final TashichosonJushochiTokureiManager tatokureiManager;
        private final TekiyoJogaishaManager tekiyoJogiaManager;
        private final HihokenshaDaichoModel hihoDaicho;

        /**
         * コンストラクタです。他テーブルを参照するために必要なDacを受け取ります。
         *
         * @param hihoDaicho 住所地特例情報
         */
        public _JushochiTokureiDuplicateValidator(HihokenshaDaichoModel hihoDaicho) {
            requireNonNull(hihoDaicho, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳情報"));
            this.hihoDaicho = hihoDaicho;

            this.tatokureiManager = new TashichosonJushochiTokureiManager();
            this.tekiyoJogiaManager = new TekiyoJogaishaManager();
        }

        /**
         * テスト用コンストラクタです。外部からDacのMockを受け取ります。
         *
         * @param tatokureiDac 他市町村住所地特例Dac
         * @param tekiyoJogaiDac 適用除外Dac
         * @param jushochiTokureiData 住所地特例情報
         */
        _JushochiTokureiDuplicateValidator(TashichosonJushochiTokureiManager tatokureiManager,
                TekiyoJogaishaManager tekiyoJogiaManager, HihokenshaDaichoModel hihoDaicho) {
            this.tatokureiManager = tatokureiManager;
            this.tekiyoJogiaManager = tekiyoJogiaManager;
            this.hihoDaicho = hihoDaicho;
        }

        @Override
        public IValidationMessages validate() {

            return validateFollowingItems()
                    .then(check住所地特例期間が_他市町村住所地特例期間と重複())
                    .then(check住所地特例期間が_適用除外期間と重複())
                    .end();
        }

        private IValidationMessages check住所地特例期間が_他市町村住所地特例期間と重複() {
            IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();

            IItemList<TashichosonJushochiTokureiModel> tatokuList
                    = tatokureiManager.get他市町村住所地特例List(hihoDaicho.get市町村コード(), hihoDaicho.get識別コード());
            if (tatokuList.isEmpty()) {
                return validationMessages;
            }

            for (TashichosonJushochiTokureiModel tatoku : tatokuList) {
                tatoku.get解除年月日();
                if (tatoku.get適用年月日().isBeforeOrEquals(hihoDaicho.get適用年月日())
                        && hihoDaicho.get適用年月日().isBeforeOrEquals(tatoku.get解除年月日())) {
                    validationMessages.add(JushochiTokureiValidationMessage.住所地特例期間と他市町村住所地特例期間が重複する履歴がある);
                } else if (!(hihoDaicho.get解除年月日() == null || hihoDaicho.get解除年月日().isEmpty())
                        && tatoku.get適用年月日().isBeforeOrEquals(hihoDaicho.get解除年月日())
                        && hihoDaicho.get解除年月日().isBeforeOrEquals(tatoku.get解除年月日())) {
                    validationMessages.add(JushochiTokureiValidationMessage.住所地特例期間と他市町村住所地特例期間が重複する履歴がある);
                }

            }
            return validationMessages;
        }

        private IValidationMessages check住所地特例期間が_適用除外期間と重複() {
            IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();

            IItemList<TekiyoJogaishaModel> tekijoList
                    = tekiyoJogiaManager.get適用除外者情報List(hihoDaicho.get市町村コード(), hihoDaicho.get識別コード());
            if (tekijoList.isEmpty()) {
                return validationMessages;
            }

            for (TekiyoJogaishaModel tatoku : tekijoList) {
                tatoku.get解除年月日();
                if (tatoku.get適用年月日().isBeforeOrEquals(hihoDaicho.get適用年月日())
                        && hihoDaicho.get適用年月日().isBeforeOrEquals(tatoku.get解除年月日())) {
                    validationMessages.add(JushochiTokureiValidationMessage.住所地特例期間と適用除外期間が重複する履歴がある);
                } else if (tatoku.get適用年月日().isBeforeOrEquals(hihoDaicho.get解除年月日())
                        && hihoDaicho.get解除年月日().isBeforeOrEquals(tatoku.get解除年月日())) {
                    validationMessages.add(JushochiTokureiValidationMessage.住所地特例期間と適用除外期間が重複する履歴がある);
                }

            }
            return validationMessages;
        }
    }
}
