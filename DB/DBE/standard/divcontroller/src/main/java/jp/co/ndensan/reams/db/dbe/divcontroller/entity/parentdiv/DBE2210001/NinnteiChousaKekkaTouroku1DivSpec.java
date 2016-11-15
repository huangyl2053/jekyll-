/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果登録1バリデーションクラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum NinnteiChousaKekkaTouroku1DivSpec implements IPredicate<NinnteiChousaKekkaTouroku1Div> {

    調査実施日の非空チェック {
                /**
                 * 調査実施日の非空チェックです。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:調査実施日が非空です、false:調査実施日が空です。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate() != null;
                }
            },
    調査実施日の妥当性チェック {
                /**
                 * 調査実施日の妥当性チェックです。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:調査実施日が妥当です、false:調査実施日が妥当でないです。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    FlexibleDate 調査実施日 = new FlexibleDate(div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getText());
                    if (div.getCcdChosaJisshishaJoho().getTxtNinteiShinseiDate().getValue().isBeforeOrEquals(調査実施日)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            },
    実施場所の非空チェック {
                /**
                 * 実施場所の非空チェックです。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:実施場所が非空です、false:実施場所が空です。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return !div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey().isNullOrEmpty();
                }
            },
    所属機関の非空チェック {
                /**
                 * 所属機関の非空チェックです。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:所属機関が非空です、false:所属機関が空です。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return !div.getCcdChosaJisshishaJoho().getTxtShozokuKikanCode().getText().isNullOrEmpty();
                }
            },
    記入者の非空チェック {
                /**
                 * 記入者の非空チェックです。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:記入者が非空です、false:記入者が空です。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return !div.getCcdChosaJisshishaJoho().getTxtKinyushaCode().getText().isNullOrEmpty();
                }
            },
    第1群の非空チェック {
                /**
                 * 第1群の非空チェックです。
                 *
                 * @param div NinnteiChousaKekkaTouroku1Div
                 * @return true:第1群に未入力項目がない、false:第1群に未入力項目がある。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    RString 基本調査入力OK = new RString("1");
                    return 基本調査入力OK.equals(div.getHiddenKihonChosaInput1Flag());
                }
            },
    第2群の非空チェック {
                /**
                 * 第2群の非空チェックです。
                 *
                 * @param div NinnteiChousaKekkaTouroku1Div
                 * @return true:第2群に未入力項目がない、false:第2群に未入力項目がある。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    RString 基本調査入力OK = new RString("1");
                    return 基本調査入力OK.equals(div.getHiddenKihonChosaInput2Flag());
                }
            },
    第3群の非空チェック {
                /**
                 * 第3群の非空チェックです。
                 *
                 * @param div NinnteiChousaKekkaTouroku1Div
                 * @return true:第3群に未入力項目がない、false:第3群に未入力項目がある。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    RString 基本調査入力OK = new RString("1");
                    return 基本調査入力OK.equals(div.getHiddenKihonChosaInput3Flag());
                }
            },
    第4群の非空チェック {
                /**
                 * 第4群の非空チェックです。
                 *
                 * @param div NinnteiChousaKekkaTouroku1Div
                 * @return true:第4群に未入力項目がない、false:第4群に未入力項目がある。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    RString 基本調査入力OK = new RString("1");
                    return 基本調査入力OK.equals(div.getHiddenKihonChosaInput4Flag());
                }
            },
    第5群の非空チェック {
                /**
                 * 第5群の非空チェックです。
                 *
                 * @param div NinnteiChousaKekkaTouroku1Div
                 * @return true:第5群のに未入力項目がない、false:第5群のに未入力項目がある。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    RString 基本調査入力OK = new RString("1");
                    return 基本調査入力OK.equals(div.getHiddenKihonChosaInput5Flag());
                }
            },
    生活自立度の非空チェック {
                /**
                 * 生活自立度の非空チェックです。
                 *
                 * @param div NinnteiChousaKekkaTouroku1Div
                 * @return true:生活自立度に未入力項目がない、false:生活自立度に未入力項目がある。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    RString 基本調査入力OK = new RString("1");
                    return 基本調査入力OK.equals(div.getHiddenKihonChosaInput7Flag());
                }
            },
    実施場所名称の非空チェック {
                /**
                 * 実施場所名称の非空チェックです。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:実施場所名称が非空です、false:実施場所名称が空です。
                 */
                @Override
                public boolean apply(NinnteiChousaKekkaTouroku1Div div) {
                    return !div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().getValue().isNullOrEmpty();
                }
            }
}
