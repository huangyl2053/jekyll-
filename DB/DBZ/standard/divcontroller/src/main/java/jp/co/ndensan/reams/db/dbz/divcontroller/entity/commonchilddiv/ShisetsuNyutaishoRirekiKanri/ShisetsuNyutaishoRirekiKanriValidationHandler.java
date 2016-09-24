/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.validations.TextBoxFlexibleDateValidator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 施設入退所履歴のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBA-0360-030 linghuhang
 */
public class ShisetsuNyutaishoRirekiKanriValidationHandler {

    private final ShisetsuNyutaishoRirekiKanriDiv div;
    private final RString 追加 = new RString("追加");
    private final RString 更新 = new RString("修正");
    private final RString RS_ICHI = new RString("1");
    private final RString KEY = new RString("key0");

    /**
     * コンストラクタです。
     *
     * @param div 施設入退所履歴DivKyokaisoGaitoshaPanelHandler
     */
    public ShisetsuNyutaishoRirekiKanriValidationHandler(ShisetsuNyutaishoRirekiKanriDiv div) {
        this.div = div;
    }

    /**
     * 「確認する」ボタンを押下します。
     *
     * @param 住所地特例フラグ 住所地特例フラグ
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate(RString 住所地特例フラグ) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日(div.getTxtNyushoDate()));
        validPairs.add(TextBoxFlexibleDateValidator.validate暦上日OrEmpty(div.getTxtTaishoDate()));

        if (div.getTxtNyushoDate().getValue() == null
                || div.getTxtNyushoDate().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.入所日, div.getTxtNyushoDate()));
        } else {
            if (div.getTxtTaishoDate().getValue() != null
                    && !div.getTxtTaishoDate().getValue().isEmpty()
                    && !div.getTxtNyushoDate().getValue().
                    isBeforeOrEquals(div.getTxtTaishoDate().getValue())) {
                validPairs.add(new ValidationMessageControlPair(
                        RRVMessages.前後関係逆転,
                        div.getTxtTaishoDate(),
                        div.getTxtNyushoDate()));
            }
        }
        if (RString.isNullOrEmpty(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.入所施設コード));
        }
        if (RString.isNullOrEmpty(div.getCcdShisetsuJoho().get施設種類())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.施設種類));
        }

        List<dgShisetsuNyutaishoRireki_Row> rowList = div.getDgShisetsuNyutaishoRireki().getDataSource();
        Collections.sort(rowList, new Comparator<dgShisetsuNyutaishoRireki_Row>() {
            @Override
            public int compare(dgShisetsuNyutaishoRireki_Row o1, dgShisetsuNyutaishoRireki_Row o2) {
                return o1.getNyushoDate().getValue().compareTo(o2.getNyushoDate().getValue()) - 1;
            }
        });
        Collections.reverse(rowList);
        if (追加.equals(div.getInputMode())) {
            if (div.getTxtNyushoDate().getValue().isEmpty()) {
                return validPairs;
            }
            if (rowList.isEmpty()) {
                return validPairs;
            }
            if (div.getTxtNyushoDate().getValue()
                    .compareTo(rowList.get(0).getTaishoDate().getValue()) <= 0) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.施設入所期間重複_入所日,
                        div.getTxtNyushoDate()));
            }
        }
        if (更新.equals(div.getInputMode())) {
            int rowId = div.getDgShisetsuNyutaishoRireki().getClickedItem().getId();

            if (div.getTxtNyushoDate().getValue().isEmpty()) {
                return validPairs;
            } else if (rowList.size() == 1) {
                return validPairs;
            } else {
                if (rowId == 0) {
                    if (rowList.get(1).getTaishoDate().getValue().isEmpty()) {
                        if (div.getTxtNyushoDate().getValue()
                                .compareTo(rowList.get(1).getNyushoDate().getValue()) <= 0) {
                            validPairs.add(new ValidationMessageControlPair(RRVMessages.施設入所期間重複_入所日,
                                    div.getTxtNyushoDate()));
                        }
                    } else {
                        if (div.getTxtNyushoDate().getValue()
                                .compareTo(rowList.get(1).getTaishoDate().getValue()) <= 0) {
                            validPairs.add(new ValidationMessageControlPair(RRVMessages.施設入所期間重複_入所日,
                                    div.getTxtNyushoDate()));
                        }
                    }
                } else if (rowId == rowList.size() - 1) {
                    if (div.getTxtTaishoDate().getValue().isEmpty()) {
                        if (div.getTxtNyushoDate().getValue()
                                .compareTo(rowList.get(rowList.size() - 2).getNyushoDate().getValue()) >= 0) {
                            validPairs.add(new ValidationMessageControlPair(RRVMessages.施設入所期間重複_入所日,
                                    div.getTxtNyushoDate()));
                        }
                    } else {
                        if (div.getTxtTaishoDate().getValue()
                                .compareTo(rowList.get(rowList.size() - 2).getNyushoDate().getValue()) >= 0) {
                            validPairs.add(new ValidationMessageControlPair(RRVMessages.施設入所期間重複_退所日,
                                    div.getTxtTaishoDate()));
                        }
                    }
                } else {
                    if (rowList.get(rowId + 1).getTaishoDate().getValue().isEmpty()) {
                        if (div.getTxtNyushoDate().getValue()
                                .compareTo(rowList.get(rowId + 1).getNyushoDate().getValue()) <= 0) {
                            validPairs.add(new ValidationMessageControlPair(RRVMessages.施設入所期間重複_入所日,
                                    div.getTxtNyushoDate()));
                        }
                    } else {
                        if (div.getTxtNyushoDate().getValue()
                                .compareTo(rowList.get(rowId + 1).getTaishoDate().getValue()) <= 0) {
                            validPairs.add(new ValidationMessageControlPair(RRVMessages.施設入所期間重複_入所日,
                                    div.getTxtNyushoDate()));
                        }
                    }

                    if (div.getTxtTaishoDate().getValue().isEmpty()) {
                        if (div.getTxtNyushoDate().getValue()
                                .compareTo(rowList.get(rowId - 1).getNyushoDate().getValue()) >= 0) {
                            validPairs.add(new ValidationMessageControlPair(RRVMessages.施設入所期間重複_入所日,
                                    div.getTxtNyushoDate()));
                        }
                    } else {
                        if (div.getTxtTaishoDate().getValue()
                                .compareTo(rowList.get(rowId - 1).getNyushoDate().getValue()) >= 0) {
                            validPairs.add(new ValidationMessageControlPair(RRVMessages.施設入所期間重複_退所日,
                                    div.getTxtTaishoDate()));
                        }
                    }

                }
            }

            if (div.getTxtTaishoDate().getValue().isEmpty() && rowId != 0) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.退所日,
                        div.getTxtTaishoDate()));
            }
        }

        return check保険者番号(validPairs, 住所地特例フラグ);
    }

    private ValidationMessageControlPairs check保険者番号(ValidationMessageControlPairs validPairs, RString 住所地特例フラグ) {
        if (!ShisetsuNyutaishoRirekiKanriDiv.Riyou.適用除外者対象機能.equals(div.getMode_Riyou())
                && !ShisetsuNyutaishoRirekiKanriDiv.Riyou.他市町村住所地特例者対象機能.equals(div.getMode_Riyou())
                && (DaichoType.被保険者.getコード().equals(div.getCcdShisetsuJoho().getDaichoShubetsu())
                || KEY.equals(div.getCcdShisetsuJoho().getDaichoShubetsu()))
                && (ShisetsuType.介護保険施設.getコード().equals(div.getCcdShisetsuJoho().get施設種類())
                || ShisetsuType.住所地特例対象施設.getコード().equals(div.getCcdShisetsuJoho().get施設種類()))
                && RString.isNullOrEmpty(div.getTxtHokensha().getValue()) && RS_ICHI.equals(住所地特例フラグ)) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.保険者番号, div.getTxtHokensha()));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        入所日(UrErrorMessages.必須, "入所日"),
        退所日(UrErrorMessages.必須, "退所日"),
        入所施設コード(UrErrorMessages.必須, "入所施設コード"),
        施設種類(UrErrorMessages.必須, "施設種類"),
        前後関係逆転(UrErrorMessages.前後関係逆転, "入所日", "退所日"),
        施設入所期間重複_入所日(DbzErrorMessages.施設入所期間重複, "入所日"),
        施設入所期間重複_退所日(DbzErrorMessages.施設入所期間重複, "退所日"),
        保険者番号(UrErrorMessages.必須, "保険者番号");
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
