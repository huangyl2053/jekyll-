/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
                    return !div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().getSelectedKey().isNullOrEmpty();
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
                    return !div.getCcdChosaJisshishaJoho().getDdlKinyusha().getSelectedKey().isNullOrEmpty();
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
                    ArrayList<KihonChosaInput> 第1群List = ViewStateHolder.
                    get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class);
                    if (第1群List == null) {
                        return false;
                    }
                    int size = 0;
                    int 連番;
                    for (KihonChosaInput joho : 第1群List) {
                        連番 = joho.get調査連番();
                        if (連番 != 1 && 連番 != 2 && 連番 != 3 && 連番 != 4 && 連番 != 5
                        && 連番 != 6 && 連番 != 7 && 連番 != 8 && 連番 != 9) {
                            size++;
                        }

                    }
                    return size == 11;
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
                    ArrayList<KihonChosaInput> 第2群List = ViewStateHolder.
                    get(ViewStateKeys.第二群認定調査基本情報リスト, ArrayList.class);
                    if (第2群List == null || 第2群List.size() != 12) {
                        return false;
                    }
                    return true;
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
                    ArrayList<KihonChosaInput> 第3群List = ViewStateHolder.
                    get(ViewStateKeys.第三群認定調査基本情報リスト, ArrayList.class);
                    if (第3群List == null || 第3群List.size() != 9) {
                        return false;
                    }
                    return true;
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
                    ArrayList<KihonChosaInput> 第4群List = ViewStateHolder.
                    get(ViewStateKeys.第四群認定調査基本情報リスト, ArrayList.class);
                    if (第4群List == null || 第4群List.size() != 15) {
                        return false;
                    }
                    return true;
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
                    ArrayList<KihonChosaInput> 第5群List = ViewStateHolder.
                    get(ViewStateKeys.第五群認定調査基本情報リスト, ArrayList.class);
                    if (第5群List == null || 第5群List.size() != 6) {
                        return false;
                    }
                    return true;
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
                    ArrayList<KihonChosaInput> 生活自立度List = ViewStateHolder.
                    get(ViewStateKeys.第七群認定調査基本情報リスト, ArrayList.class);

                    boolean 障害高齢者の日常生活自立度_選択 = false;
                    boolean 認知症高齢者の日常生活自立度_選択 = false;
                    if (生活自立度List == null) {
                        return false;
                    }
                    for (KihonChosaInput joho : 生活自立度List) {
                        if (!joho.get認知症高齢者自立度().isEmpty()) {
                            障害高齢者の日常生活自立度_選択 = true;
                        }
                        if (!joho.get障害高齢者自立度().isEmpty()) {
                            認知症高齢者の日常生活自立度_選択 = true;
                        }
                    }
                    return 障害高齢者の日常生活自立度_選択 && 認知症高齢者の日常生活自立度_選択;
                }
            }

}
