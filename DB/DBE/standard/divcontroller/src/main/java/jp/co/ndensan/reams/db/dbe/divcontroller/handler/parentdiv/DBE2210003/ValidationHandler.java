/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210003;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.gaikyotokkiyichirannyuroku.GaikyoTokkiYichiranNyurokuBusiness;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査結果登録3のチェッククラスです。
 *
 * @reamsid_L DBE-0040-030 huangh
 */
public class ValidationHandler {

    private static final int INT8 = 8;

    /**
     * 特記事項番号入力チェックします。
     *
     * @param validPairs ValidationMessageControlPairs
     * @param texBox TextBox
     * @return ValidationMessageControlPairs
     */
    @SuppressWarnings("unchecked")
    public ValidationMessageControlPairs 特記事項番号入力チェック(
            ValidationMessageControlPairs validPairs,
            TextBox texBox) {

        RString 特記事項番号 = RString.EMPTY;
        if (texBox.getValue() != null) {
            特記事項番号 = texBox.getValue();
        }
        try {
            NinteichosaKomoku09B.toValue(texBox.getValue());
        } catch (IllegalArgumentException e) {
            validPairs.add(new ValidationMessageControlPair(
                    new RRVMessages(UrErrorMessages.不正, "特記事項番号(" + 特記事項番号 + ")"),
                    texBox));
        }

        return validPairs;
    }

    /**
     * 既存同じ特記事項番号チェックします。
     *
     * @param validPairs ValidationMessageControlPairs
     * @param map HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness>
     * @param key RString
     * @param texBox TextBox
     * @return ValidationMessageControlPairs
     */
    @SuppressWarnings("unchecked")
    public ValidationMessageControlPairs 既存同じ特記事項番号チェック(
            ValidationMessageControlPairs validPairs,
            HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness> map,
            RString key,
            TextBox texBox) {

        Set<Map.Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = map.entrySet();
        Iterator<Map.Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();

        while (it.hasNext()) {
            Map.Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (texBox.getValue().equals(value.getTemp_認定調査特記事項番号())
                    && (value.getTemp_特記事項() == null || value.getTemp_特記事項().isEmpty())) {

                validPairs.add(new ValidationMessageControlPair(new RRVMessages(DbeErrorMessages.特記事項番号が追加不可),
                        texBox));
            }
        }

        return validPairs;
    }

    /**
     * 連番最大値超過チェックします。
     *
     * @param validPairs ValidationMessageControlPairs
     * @param map HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness>
     * @param key RString
     * @param texBox TextBox
     * @return ValidationMessageControlPairs
     */
    @SuppressWarnings("unchecked")
    public ValidationMessageControlPairs 連番最大値超過チェック(
            ValidationMessageControlPairs validPairs,
            HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness> map,
            RString key,
            TextBox texBox) {

        Set<Map.Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = map.entrySet();
        Iterator<Map.Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();

        int renban = 0;
        while (it.hasNext()) {
            Map.Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (texBox.getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= INT8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());

            }
            if (texBox.getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) > INT8) {
                validPairs.add(new ValidationMessageControlPair(new RRVMessages(DbeErrorMessages.連番最大値を超過),
                        texBox));
            }
        }

        return validPairs;
    }

    private static final class RRVMessages implements IValidationMessage {

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
