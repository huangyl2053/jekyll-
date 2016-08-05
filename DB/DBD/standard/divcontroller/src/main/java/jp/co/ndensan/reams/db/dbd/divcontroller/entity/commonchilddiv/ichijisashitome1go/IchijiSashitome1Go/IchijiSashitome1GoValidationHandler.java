/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome1go.IchijiSashitome1Go;

import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoJohoBunruiKubun;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 【共有子Div】1号一時差止ダイアログのValidationHandlerクラスです。
 *
 * @reamsid_L DBD-0620-042 panxiaobo
 */
public class IchijiSashitome1GoValidationHandler {

    private final RString 給付一時差止登録 = new RString("給付一時差止登録");
    private final RString 保険料控除登録 = new RString("保険料控除登録");
    private final RString 登録PTN = new RString("登録PTN");
    private final RString 更新PTN = new RString("更新PTN");

    /**
     * 1号一時差止ダイアログの給付一時差止選択データチェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @param shiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor給付一時差止選択データチェック(ValidationMessageControlPairs pairs, IchijiSashitome1GoDiv div,
            ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome) {
        if (div.getKey_Button().equals(給付一時差止登録)
                && (!div.getDgSashitomeKojoIchiran().getClickedItem().getTxtSashitomeKaijoYMD().getValue().isEmpty()
                || shiharaiHohoHenkoSashitome.is論理削除フラグ())) {
            pairs.add(new ValidationMessageControlPair(IchijiSashitome1GoMessages.給付一時差止選択データチェック));
        }
        return pairs;
    }

    /**
     * 1号一時差止ダイアログの保険料控除選択データチェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @param shiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor保険料控除選択データチェック(ValidationMessageControlPairs pairs, IchijiSashitome1GoDiv div,
            ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome) {
        if (div.getKey_Button().equals(保険料控除登録) && shiharaiHohoHenkoSashitome.is論理削除フラグ()) {
            pairs.add(new ValidationMessageControlPair(IchijiSashitome1GoMessages.保険料控除選択データチェック));
        }
        return pairs;
    }

    /**
     * 1号一時差止ダイアログの滞納状況情報チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @param shiharaiHohoHenko shiharaiHohoHenko
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor滞納状況情報チェック(ValidationMessageControlPairs pairs, IchijiSashitome1GoDiv div, ShiharaiHohoHenko shiharaiHohoHenko) {
        if ((div.getKey_Button().equals(給付一時差止登録) || div.getKey_Button().equals(保険料控除登録))
                && (div.getPTN().equals(登録PTN) || div.getPTN().equals(更新PTN))
                && (shiharaiHohoHenko.getShiharaiHohoHenkoTainoList().isEmpty() || div.getTainoHanteiKekka().isEmpty())) {
            pairs.add(new ValidationMessageControlPair(IchijiSashitome1GoMessages.支払方法変更_要滞納状況確定));
        }
        return pairs;
    }

    /**
     * 1号一時差止ダイアログの給付一時差止未解除データチェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @param shiharaiHohoHenko
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor給付一時差止未解除データチェック(ValidationMessageControlPairs pairs, IchijiSashitome1GoDiv div,
            ShiharaiHohoHenko shiharaiHohoHenko) {
        if (div.getKey_Button().equals(給付一時差止登録)) {
            for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : shiharaiHohoHenko.getShiharaiHohoHenkoSashitomeList()) {
                if (shiharaiHohoHenkoSashitome.get情報分類区分().equals(ShiharaiHenkoJohoBunruiKubun.差止情報.getコード())
                        && shiharaiHohoHenkoSashitome.get差止解除年月日().isEmpty()
                        && !shiharaiHohoHenkoSashitome.is論理削除フラグ()) {
                    pairs.add(new ValidationMessageControlPair(IchijiSashitome1GoMessages.給付一時差止未解除データチェック));
                }
            }
        }
        return pairs;
    }

    /**
     * 1号一時差止ダイアログの保険料控除未解除データチェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @param shiharaiHohoHenko
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor保険料控除未解除データチェック(ValidationMessageControlPairs pairs, IchijiSashitome1GoDiv div,
            ShiharaiHohoHenko shiharaiHohoHenko) {
        if (div.getKey_Button().equals(保険料控除登録)) {
            for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : shiharaiHohoHenko.getShiharaiHohoHenkoSashitomeList()) {
                if (shiharaiHohoHenkoSashitome.get情報分類区分().equals(ShiharaiHenkoJohoBunruiKubun.保険料控除情報.getコード())
                        && !shiharaiHohoHenkoSashitome.is論理削除フラグ()) {
                    pairs.add(new ValidationMessageControlPair(IchijiSashitome1GoMessages.保険料控除未解除データチェック));
                }
            }
        }
        return pairs;
    }

    private static enum IchijiSashitome1GoMessages implements IValidationMessage {

        支払方法変更_要滞納状況確定(DbdErrorMessages.支払方法変更_要滞納状況確定),
        給付一時差止選択データチェック(UrErrorMessages.設定不可, "解除・削除データの"),
        保険料控除選択データチェック(UrErrorMessages.設定不可, "解除データの"),
        給付一時差止未解除データチェック(UrErrorMessages.設定不可, "未解除・未削除データが存在する"),
        保険料控除未解除データチェック(UrErrorMessages.設定不可, "未解除データが存在する"),
        滞納状況情報チェック(UrErrorMessages.選択されていない, "弁明審査結果");
        private final Message message;

        private IchijiSashitome1GoMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }

}
