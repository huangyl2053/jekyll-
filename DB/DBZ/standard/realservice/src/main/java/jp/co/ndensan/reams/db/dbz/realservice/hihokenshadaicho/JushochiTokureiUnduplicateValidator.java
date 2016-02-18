/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.business.validation.JushochiTokureiValidationMessage;
import jp.co.ndensan.reams.db.dbz.realservice.TashichosonJushochiTokureiManager;
import jp.co.ndensan.reams.db.dbz.realservice.TekiyoJogaishaManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import static jp.co.ndensan.reams.uz.uza.core.validation.ValidationChain.validateFollowingItems;
import jp.co.ndensan.reams.ur.urz.definition.message.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

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
     * @param jushochiTokureiData 住所地特例情報
     * @return バリデーションクラスを扱うインターフェース
     */
    public static IValidatable setHihokenshaDaichoData(DbT1001HihokenshaDaichoEntity jushochiTokureiData) {
        return new _JushochiTokureiDuplicateValidator(jushochiTokureiData);
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
            TekiyoJogaishaManager tekiyoJogiaManager, DbT1001HihokenshaDaichoEntity hihoDaicho) {
        return new _JushochiTokureiDuplicateValidator(jushochiTokureiManager, tekiyoJogiaManager, hihoDaicho);
    }

    private static class _JushochiTokureiDuplicateValidator implements IValidatable {

        private final TashichosonJushochiTokureiManager tatokureiManager;
        private final TekiyoJogaishaManager tekiyoJogiaManager;
        private final DbT1001HihokenshaDaichoEntity hihoDaicho;

        /**
         * コンストラクタです。他テーブルを参照するために必要なDacを受け取ります。
         *
         * @param hihoDaicho 住所地特例情報
         */
        public _JushochiTokureiDuplicateValidator(DbT1001HihokenshaDaichoEntity hihoDaicho) {
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
                TekiyoJogaishaManager tekiyoJogiaManager, DbT1001HihokenshaDaichoEntity hihoDaicho) {
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

            IItemList<DbT1003TashichosonJushochiTokureiEntity> tatokuList
                    = tatokureiManager.get他市町村住所地特例List(hihoDaicho.getShichosonCode(), hihoDaicho.getShikibetsuCode());
            if (tatokuList.isEmpty()) {
                return validationMessages;
            }

            for (DbT1003TashichosonJushochiTokureiEntity tatoku : tatokuList) {
                tatoku.getTekiyoYMD();
                if (tatoku.getTekiyoYMD().isBeforeOrEquals(hihoDaicho.getJushochitokureiTekiyoYMD())
                        && hihoDaicho.getJushochitokureiTekiyoYMD().isBeforeOrEquals(tatoku.getKaijoYMD())) {
                    validationMessages.add(JushochiTokureiValidationMessage.住所地特例期間と他市町村住所地特例期間が重複する履歴がある);
                } else if (!(hihoDaicho.getJushochitokureiKaijoYMD() == null || hihoDaicho.getJushochitokureiKaijoYMD().isEmpty())
                        && tatoku.getTekiyoYMD().isBeforeOrEquals(hihoDaicho.getJushochitokureiKaijoYMD())
                        && hihoDaicho.getJushochitokureiKaijoYMD().isBeforeOrEquals(tatoku.getKaijoYMD())) {
                    validationMessages.add(JushochiTokureiValidationMessage.住所地特例期間と他市町村住所地特例期間が重複する履歴がある);
                }

            }
            return validationMessages;
        }

        private IValidationMessages check住所地特例期間が_適用除外期間と重複() {
            IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();

            IItemList<DbT1002TekiyoJogaishaEntity> tekijoList
                    = tekiyoJogiaManager.get適用除外者情報List(hihoDaicho.getShichosonCode(), hihoDaicho.getShikibetsuCode());
            if (tekijoList.isEmpty()) {
                return validationMessages;
            }

            for (DbT1002TekiyoJogaishaEntity tatoku : tekijoList) {
                tatoku.getKaijoYMD();
                if (tatoku.getTekiyoYMD().isBeforeOrEquals(hihoDaicho.getJushochitokureiTekiyoYMD())
                        && hihoDaicho.getJushochitokureiTekiyoYMD().isBeforeOrEquals(tatoku.getKaijoYMD())) {
                    validationMessages.add(JushochiTokureiValidationMessage.住所地特例期間と適用除外期間が重複する履歴がある);
                } else if (tatoku.getTekiyoYMD().isBeforeOrEquals(hihoDaicho.getJushochitokureiKaijoYMD())
                        && hihoDaicho.getJushochitokureiKaijoYMD().isBeforeOrEquals(tatoku.getKaijoYMD())) {
                    validationMessages.add(JushochiTokureiValidationMessage.住所地特例期間と適用除外期間が重複する履歴がある);
                }

            }
            return validationMessages;
        }
    }
}
