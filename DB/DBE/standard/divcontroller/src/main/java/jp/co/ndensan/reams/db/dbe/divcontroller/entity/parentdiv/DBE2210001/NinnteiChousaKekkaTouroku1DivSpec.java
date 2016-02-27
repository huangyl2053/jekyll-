/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 認定調査結果登録1バリデーションクラスです。
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
                    // TODO  return !div.getDgWaritsukeKohoshaIchiran().getDataSource().isEmpty();
                    return false;
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
                    // TODO
                    return false;
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
                    // TODO
                    return false;
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
                    // TODO
                    return false;
                }
            }

}
