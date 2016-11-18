/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.kyufugengaku1go.KyufuGengaku1Go;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 *
 * 【共有子Div】1号給付額減額ダイアログのSpec。
 *
 * @reamsid_L DBD-3620-043 panxiaobo
 */
public enum KyufuGengaku1GoDivSpec implements IPredicate<KyufuGengaku1GoDiv> {

    減額適用期間チェック {
                /**
                 * 減額適用期間チェックです。
                 *
                 * @param div KyufuGengaku1GoDiv
                 * @return true:期間が正確、false:期間が不正
                 */
                @Override
                public boolean apply(KyufuGengaku1GoDiv div) {
                    if (div.getTxtKonkaiKikanKaishiYMD().getValue() != null && !div.getTxtKonkaiKikanKaishiYMD().getValue().toString().isEmpty() && !div.getTxtKonkaiKikanShuryoYMD().getValue().toString().isEmpty()) {
                        return div.getTxtKonkaiKikanKaishiYMD().getValue().isBeforeOrEquals(div.getTxtKonkaiKikanShuryoYMD().getValue());
                    } else {
                        return div.getTxtKonkaiKikanKaishiYMD().getValue() == null || !div.getTxtKonkaiKikanKaishiYMD().getValue().toString().isEmpty() || !div.getTxtKonkaiKikanShuryoYMD().getValue().toString().isEmpty();
                    }
                }
            },
    減額適用期間終了未入力 {
                /**
                 * 減額適用期間終了の必須入力です。
                 *
                 * @param div KyufuGengaku1GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(KyufuGengaku1GoDiv div) {
                    return div.getTxtGengakuTekiyoKikanShuryoYMD().getValue() != null
                    && !div.getTxtGengakuTekiyoKikanShuryoYMD().toString().isEmpty();
                }
            },
    申請理由未選択 {
                /**
                 * 申請理由未選択の必須入力です。
                 *
                 * @param div KyufuGengaku1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(KyufuGengaku1GoDiv div) {
                    return !div.getDdlIMenjoShinseiRiyu().getSelectedValue().isEmpty();
                }
            },
    状況未選択 {
                /**
                 * 申請理由未選択の必須入力です。
                 *
                 * @param div KyufuGengaku1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(KyufuGengaku1GoDiv div) {
                    return !div.getDdlMenjoShinseiJokyo().getSelectedValue().isEmpty();
                }
            },
    申請審査結果未選択 {
                /**
                 * 申請理由未選択の必須入力です。
                 *
                 * @param div KyufuGengaku1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(KyufuGengaku1GoDiv div) {
                    return !div.getDdlMenjoShinseiShinsaKekka().getSelectedValue().isEmpty();
                }
            },
    減額適用期間2チェック {
                /**
                 * 減額適用期間チェックです。
                 *
                 * @param div KyufuGengaku1GoDiv
                 * @return true:期間が正確、false:期間が不正
                 */
                @Override
                public boolean apply(KyufuGengaku1GoDiv div) {
                    if (div.getTxtGengakuTekiyoKikanKaishiYMD().getValue() != null && !div.getTxtGengakuTekiyoKikanKaishiYMD().getValue().toString().isEmpty() && !div.getTxtGengakuTekiyoKikanShuryoYMD().getValue().toString().isEmpty()) {
                        return div.getTxtGengakuTekiyoKikanKaishiYMD().getValue().isBeforeOrEquals(div.getTxtGengakuTekiyoKikanShuryoYMD().getValue());
                    } else {
                        return div.getTxtGengakuTekiyoKikanKaishiYMD().getValue() == null || !div.getTxtGengakuTekiyoKikanKaishiYMD().toString().isEmpty() || !div.getTxtGengakuTekiyoKikanShuryoYMD().toString().isEmpty();
                    }
                }
            },
}
