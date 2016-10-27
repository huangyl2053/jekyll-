/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021;

import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 特別地域加算軽減実績管理画面の入力チェックです
 *
 * @reamsid_L DBD-3880-010 xuejm
 */
public enum TokubetsuPanelDivSpec implements IPredicate<TokubetsuPanelDiv> {

    年月範囲開始が非空必須チェック {
                /**
                 * 年月範囲開始が非空必須チェック .
                 *
                 * @param div TokubetsuPanelDiv
                 * @return true:年月範囲開始が非空です、false:年月範囲開始が空白の場合。
                 */

                @Override
                public boolean apply(TokubetsuPanelDiv div) {
                    RDate ymrangefrom = div.getTxtRangeYM().getFromValue();
                    return ymrangefrom != null && !ymrangefrom.toDateString().isEmpty();
                }

            },
    年月範囲終了が非空必須チェック {
                /**
                 * 年月範囲開始が非空必須チェック .
                 *
                 * @param div 受給者台帳リストDiv
                 * @return true:年月範囲開始が非空です、false:年月範囲開始が空白の場合。
                 */
                @Override
                public boolean apply(TokubetsuPanelDiv div) {
                    RDate ymrangeto = div.getTxtRangeYM().getToValue();
                    return ymrangeto != null && !ymrangeto.toDateString().isEmpty();
                }
            },
    行政区コードが大小関係チェック {
                /**
                 * 行政区コードが大小関係チェック .
                 *
                 * @param div 受給者台帳リストDiv
                 * @return true:開始行政区コード>終了行政区コードの場合がない,false:開始行政区コード>終了行政区コードの場合。
                 */
                @Override
                public boolean apply(TokubetsuPanelDiv div) {
                    GyoseikuCode gyoseikuCodeStart = div.getCcdGyouseiStart().get行政区コード();
                    GyoseikuCode gyoseikuCodeEnd = div.getCcdGyouseiEnd().get行政区コード();
                    return gyoseikuCodeStart.compareTo(gyoseikuCodeEnd) <= 0;
                }
            },
    地区２コードが大小関係チェック {
                /**
                 * 地区２コードが大小関係チェック .
                 *
                 * @param div 受給者台帳リストDiv
                 * @return true:開始地区２コード＞終了地区２コードの場合がない,false:開始地区２コード＞終了地区２コードの場合。
                 */
                @Override
                public boolean apply(TokubetsuPanelDiv div) {
                    ChikuCode Chiku2CodeStart = div.getCcdChikuStart().get地区2コード();
                    ChikuCode Chiku2CodeEnd = div.getCcdChikuEnd().get地区2コード();
                    return Chiku2CodeStart.compareTo(Chiku2CodeEnd) <= 0;
                }
            },
    住所コードが大小関係チェック {
                /**
                 * 地区２コードが大小関係チェック .
                 *
                 * @param div 受給者台帳リストDiv
                 * @return true:開始住所コード＞終了住所コードの場合がない,false:開始住所コード＞終了住所コードの場合。
                 */
                @Override
                public boolean apply(TokubetsuPanelDiv div) {
                    ChoikiCode JyuusyoCodeStart = div.getCcdJyuusyoStart().get町域コード();
                    ChoikiCode JyuusyoCodeEnd = div.getCcdJyuusyoEnd().get町域コード();
                    return JyuusyoCodeStart.compareTo(JyuusyoCodeEnd) <= 0;
                }
            }
}
