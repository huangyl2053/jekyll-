/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome1go.IchijiSashitome1Go;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 *
 * 【共有子Div】1号一時差止ダイアログのSpecクラスです。
 *
 * @reamsid_L DBD-3620-042 panxiaobo
 */
public enum IchijiSashitome1GoDivSpec implements IPredicate<IchijiSashitome1GoDiv> {

    差止登録日入力チェック {
                /**
                 * 依頼受理日の必須入力です。
                 *
                 * @param div IchijiSashitome2GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome1GoDiv div) {
                    return div.getTxtSashitomeTorokuYMD().getValue() != null
                    && !div.getTxtSashitomeTorokuYMD().getValue().toString().isEmpty();
                }
            },
    差止納付期限入力チェック {
                /**
                 * 依頼受理日の必須入力です。
                 *
                 * @param div IchijiSashitome2GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome1GoDiv div) {
                    return div.getTxtSashitomeNofuKigenYMD().getValue() != null
                    && !div.getTxtSashitomeNofuKigenYMD().getValue().toString().isEmpty();
                }
            },
    差止解除日入力チェック {
                /**
                 * 依頼受理日の必須入力です。
                 *
                 * @param div IchijiSashitome2GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome1GoDiv div) {
                    return div.getTxtSashitomeKaijoYMD().getValue() != null
                    && !div.getTxtSashitomeKaijoYMD().getValue().toString().isEmpty();
                }
            },
    控除決定日入力チェック {
                /**
                 * 依頼受理日の必須入力です。
                 *
                 * @param div IchijiSashitome2GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome1GoDiv div) {
                    return div.getTxtKojoKetteiYMD().getValue() != null
                    && !div.getTxtKojoKetteiYMD().getValue().toString().isEmpty();
                }
            },
    保険証提出期限入力チェック {
                /**
                 * 依頼受理日の必須入力です。
                 *
                 * @param div IchijiSashitome2GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome1GoDiv div) {
                    return div.getTxtHokenshoTeishutsuKigenYMD().getValue() != null
                    && !div.getTxtHokenshoTeishutsuKigenYMD().getValue().toString().isEmpty();
                }
            },
    控除番号未選択 {
                /**
                 * 依頼受理日の必須入力です。
                 *
                 * @param div IchijiSashitome2GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome1GoDiv div) {
                    return !div.getDdlTorokuKojoNo().getSelectedValue().isEmpty();
                }
            };
}
