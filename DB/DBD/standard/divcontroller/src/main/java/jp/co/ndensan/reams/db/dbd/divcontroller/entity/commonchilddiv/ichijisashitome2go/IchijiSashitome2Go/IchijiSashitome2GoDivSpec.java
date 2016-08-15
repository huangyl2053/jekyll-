/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome2go.IchijiSashitome2Go;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 【共有子Div】2号一時差止ダイアログのSpecクラスです。
 *
 * @reamsid_L DBD-3620-045 panxiaobo
 */
public enum IchijiSashitome2GoDivSpec implements IPredicate<IchijiSashitome2GoDiv> {

    依頼受理日入力チェック {
                /**
                 * 依頼受理日の必須入力です。
                 *
                 * @param div IchijiSashitome2GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return div.getTxtNigoYokokushaTorokuIraiJuribi().getValue() != null;
                }
            },
    予告登録日入力チェック {
                /**
                 * 予告登録日の必須入力です。
                 *
                 * @param div IchijiSashitome2GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return div.getTxtNigoYokokushaTorokuYokokuTorokubi().getValue() != null;
                }
            },
    弁明書提出期限入力チェック {
                /**
                 * 予告登録日の必須入力です。
                 *
                 * @param div IchijiSashitome2GoDiv
                 * @return true:出力対象が入力、false:画面に出力対象が入力しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return div.getTxtBemmeishoTeishutsuKigenYMD().getValue() != null;
                }
            },
    弁明審査結果選択チェック {
                /**
                 * 弁明審査結果の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return !div.getDdlNigoBenmeishoJuriBenmeiShinsakekka().getSelectedValue().isEmpty();
                }
            },
    弁明受付日未入力 {
                /**
                 * 弁明受付日の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return div.getTxtNigoBenmeishoJuriBenmeishoUketsukebi().getValue() != null;
                }
            },
    弁明理由未選択 {
                /**
                 * 弁明理由未選択の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return !div.getDdlNigoBenmeishoJuriBenmeiRiyu().getSelectedValue().isEmpty();
                }
            },
    弁明内容決定日未入力 {
                /**
                 * 弁明受付日の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return div.getTxtBemmeiNaiyoKetteiYMD().getValue() != null;
                }
            },
    適用期間開始未入力 {
                /**
                 * 弁明受付日の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return div.getTxtTekiyoKaishi().getValue() != null;
                }
            },
    差止決定日未入力 {
                /**
                 * 弁明受付日の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return div.getTxtSashitomeKetteiYMD().getValue() != null;
                }
            },
    保険証提出期限未入力 {
                /**
                 * 保険証提出期限の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return div.getTxtHokenshaTeishutsuKigenYMD().getValue() != null;
                }
            },
    適用期間チェック {
                /**
                 * 適用期間のチェックです。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:期間が正確、false:期間が不正
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    if (!div.getTxtTekiyoKaishi().getValue().isEmpty() && !div.getTxtTekiyoShuryo().getValue().isEmpty()) {
                        return div.getTxtTekiyoKaishi().getValue().isBefore(div.getTxtTekiyoShuryo().getValue());
                    } else {
                        return !div.getTxtTekiyoKaishi().getValue().isEmpty() || !div.getTxtTekiyoShuryo().getValue().isEmpty();
                    }
                }
            },
    依頼審査結果未選択 {
                /**
                 * 弁明理由未選択の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return !div.getDdlIraiShinsaKekka().getSelectedValue().isEmpty();
                }
            },
    適用期間終了未入力 {
                /**
                 * 保険証提出期限の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return !div.getDdlIraiShinsaKekka().getSelectedValue().equals(getValue_申請受理()) || div.getTxtTekiyoShuryo().getValue() != null;
                }
            },
    終了状況未選択 {
                /**
                 * 終了状況未選択の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return !div.getDdlIraiShinsaKekka().getSelectedValue().equals(getValue_申請受理()) || !div.getDdlShuryoJokyo().getSelectedValue().isEmpty();
                }
            },
    依頼受付日未入力 {
                /**
                 * 保険証提出期限の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return !div.getDdlIraiShinsaKekka().getSelectedValue().equals(getValue_申請不要()) || div.getTxtIraiUketsukeYMD().getValue() != null;
                }
            },
    依頼日未入力 {
                /**
                 * 保険証提出期限の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return !div.getDdlIraiShinsaKekka().getSelectedValue().equals(getValue_申請不要()) || div.getTxtIraiYMD().getValue() != null;
                }
            },
    依頼理由未選択 {
                /**
                 * 終了状況未選択の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return !div.getDdlIraiShinsaKekka().getSelectedValue().equals(getValue_申請不要()) || !div.getDdlIraiRiyu().getSelectedValue().isEmpty();
                }
            },
    依頼内容決定日未入力 {
                /**
                 * 保険証提出期限の必須入力です。
                 *
                 * @param div ShokanBaraiKa1GoDiv
                 * @return true:出力対象が選択、false:画面に出力対象が選択しない、エラーとする
                 */
                @Override
                public boolean apply(IchijiSashitome2GoDiv div) {
                    return !div.getDdlIraiShinsaKekka().getSelectedValue().equals(getValue_申請不要()) || div.getTxtIraiNaiyoKetteiYMD().getValue() != null;
                }
            };

    private static RString getValue_申請受理() {
        return new RString("申請受理");
    }

    private static RString getValue_申請不要() {
        return new RString("申請不要");
    }
}
