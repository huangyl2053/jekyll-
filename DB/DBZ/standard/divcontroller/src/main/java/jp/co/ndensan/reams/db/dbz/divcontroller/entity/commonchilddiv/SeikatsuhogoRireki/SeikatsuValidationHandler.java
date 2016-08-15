/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoRireki;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.seikatsuhogorireki.SeikaatsuhogoDataModel;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 共有子Div生活保護履歴画面の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBZ-4520-010 zhangzhiming
 */
public class SeikatsuValidationHandler {

    private final SeikatsuhogoRirekiDiv div;
    private final RString 表示モード_修正 = new RString("修正");
    private final RString 表示モード_追加 = new RString("追加");

    /**
     * コンストラクタです。
     *
     * @param div 生活保護履歴Div
     */
    public SeikatsuValidationHandler(SeikatsuhogoRirekiDiv div) {
        this.div = div;
    }

    /**
     * データチェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        SeikaatsuhogoDataModel 判定モデル = DataPassingConverter.deserialize(div.getHdnDataPass(), SeikaatsuhogoDataModel.class);
        if (表示モード_追加.equals(判定モデル.get表示モード()) && 判定モデル.get受給廃止日() == null && 履歴廃止年月日() != null
                && (判定モデル.get受給開始日().isBefore(履歴開始年月日()) || (判定モデル.get受給開始日().isBefore(履歴廃止年月日())
                && 履歴開始年月日().isBeforeOrEquals(判定モデル.get受給開始日())))) {
            validationMessages.add(new ValidationMessageControlPair(new SeikatsuValidationHandler.RRVMessages(
                    UrErrorMessages.期間が重複)));
        }
        if (表示モード_修正.equals(判定モデル.get表示モード()) && 判定モデル.get受給廃止日() == null && 履歴一覧廃止年月日() != null
                && (判定モデル.get受給開始日().isBefore(履歴一覧開始年月日()) || (判定モデル.get受給開始日().isBefore(履歴一覧廃止年月日())
                && 履歴一覧開始年月日().isBeforeOrEquals(判定モデル.get受給開始日())))) {
            validationMessages.add(new ValidationMessageControlPair(new SeikatsuValidationHandler.RRVMessages(
                    UrErrorMessages.期間が重複)));
        }
        if (表示モード_追加.equals(判定モデル.get表示モード()) && 判定モデル.get受給廃止日() == null && 履歴廃止年月日() == null) {
            validationMessages.add(new ValidationMessageControlPair(new SeikatsuValidationHandler.RRVMessages(
                    UrErrorMessages.期間が重複)));
        }
        if (表示モード_追加.equals(判定モデル.get表示モード()) && 判定モデル.get受給廃止日() != null && 履歴廃止年月日() != null
                && ((履歴開始年月日().isBeforeOrEquals(判定モデル.get受給開始日()) && 判定モデル.get受給廃止日().isBefore(履歴廃止年月日()))
                || (履歴開始年月日().isBeforeOrEquals(判定モデル.get受給廃止日())
                && 判定モデル.get受給開始日().isBeforeOrEquals(履歴開始年月日()))
                || (履歴廃止年月日().isBeforeOrEquals(判定モデル.get受給廃止日())
                && 判定モデル.get受給開始日().isBeforeOrEquals(履歴廃止年月日()))
                || (履歴廃止年月日().isBeforeOrEquals(判定モデル.get受給廃止日())
                && 判定モデル.get受給開始日().isBeforeOrEquals(履歴開始年月日())))) {
            validationMessages.add(new ValidationMessageControlPair(new SeikatsuValidationHandler.RRVMessages(
                    UrErrorMessages.期間が重複)));
        }
        if (表示モード_修正.equals(判定モデル.get表示モード()) && 判定モデル.get受給廃止日() != null && 履歴一覧廃止年月日() != null
                && ((履歴一覧開始年月日().isBeforeOrEquals(判定モデル.get受給開始日()) && 判定モデル.get受給廃止日().isBefore(履歴一覧廃止年月日()))
                || (履歴一覧開始年月日().isBeforeOrEquals(判定モデル.get受給廃止日())
                && 判定モデル.get受給開始日().isBeforeOrEquals(履歴一覧開始年月日()))
                || (履歴一覧廃止年月日().isBeforeOrEquals(判定モデル.get受給廃止日())
                && 判定モデル.get受給開始日().isBeforeOrEquals(履歴一覧廃止年月日()))
                || (履歴一覧廃止年月日().isBeforeOrEquals(判定モデル.get受給廃止日())
                && 判定モデル.get受給開始日().isBeforeOrEquals(履歴一覧開始年月日())))) {
            validationMessages.add(new ValidationMessageControlPair(new SeikatsuValidationHandler.RRVMessages(
                    UrErrorMessages.期間が重複)));
        }
        if ((表示モード_追加.equals(判定モデル.get表示モード()) && 判定モデル.get受給廃止日() != null && 履歴廃止年月日() == null)
                && ((履歴開始年月日().isBefore(判定モデル.get受給廃止日()) && 判定モデル.get受給開始日().isBefore(履歴開始年月日()))
                || 履歴開始年月日().isBefore(判定モデル.get受給開始日()))) {
            validationMessages.add(new ValidationMessageControlPair(new SeikatsuValidationHandler.RRVMessages(
                    UrErrorMessages.期間が重複)));
        }
        if ((表示モード_修正.equals(判定モデル.get表示モード()) && 判定モデル.get受給廃止日() != null && 履歴一覧廃止年月日() == null)
                && ((履歴一覧開始年月日().isBefore(判定モデル.get受給廃止日()) && 判定モデル.get受給開始日().isBefore(履歴一覧開始年月日()))
                || 履歴一覧開始年月日().isBefore(判定モデル.get受給開始日()))) {
            validationMessages.add(new ValidationMessageControlPair(new SeikatsuValidationHandler.RRVMessages(
                    UrErrorMessages.期間が重複)));
        }
        return validationMessages;
    }

    private RDate 履歴開始年月日() {
        List<dgSeikatsuhogoRireki_Row> rowList = div.getDgSeikatsuhogoRireki().getDataSource();
        RDate kaishi = RDate.MAX;
        for (dgSeikatsuhogoRireki_Row list : rowList) {
            if (list.getTxtKaishiYMD().getValue().isBefore(kaishi)) {
                kaishi = list.getTxtKaishiYMD().getValue();
            }
        }
        return kaishi;
    }

    private RDate 履歴一覧開始年月日() {
        dgSeikatsuhogoRireki_Row dgRow = div.getDgSeikatsuhogoRireki().getSelectedItems().get(0);
        return dgRow.getTxtKaishiYMD().getValue();
    }

    private RDate 履歴一覧廃止年月日() {
        dgSeikatsuhogoRireki_Row dgRow = div.getDgSeikatsuhogoRireki().getSelectedItems().get(0);
        return dgRow.getTxtHaishiYMD().getValue();
    }

    private RDate 履歴廃止年月日() {
        List<dgSeikatsuhogoRireki_Row> rowList = div.getDgSeikatsuhogoRireki().getDataSource();
        RDate haishi = RDate.MIN;
        for (dgSeikatsuhogoRireki_Row list : rowList) {
            if (list.getTxtHaishiYMD().getValue() == null) {
                return haishi;
            }
            if (haishi.isBefore(list.getTxtHaishiYMD().getValue())) {
                haishi = list.getTxtHaishiYMD().getValue();
            }
        }
        return haishi;
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
