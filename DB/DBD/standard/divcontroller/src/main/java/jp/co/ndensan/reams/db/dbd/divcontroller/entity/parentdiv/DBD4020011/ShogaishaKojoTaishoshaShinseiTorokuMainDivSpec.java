/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011;

import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4020011.ShogaishaKojoTaishoshaShinseiTorokuMainHandler;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 障がい者控除対象者申請登録バリデーションクラスです。
 *
 * @reamsid_L DBD-3840-010 wangjie2
 */
public enum ShogaishaKojoTaishoshaShinseiTorokuMainDivSpec implements IPredicate<ShogaishaKojoTaishoshaShinseiTorokuMainDiv> {

    申請日の非空チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 障がい者控除対象者申請登録Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
                    return div.getTxtShinseiYMD().getValue() != null && !div.getTxtShinseiYMD().getValue().isEmpty();
                }
            },
    決定日の非空チェック {
                /**
                 * 決定日の非空チェックです。
                 *
                 * @param div 障がい者控除対象者申請登録Div
                 * @return true:決定日が非空です、false:決定日が空です。
                 */
                @Override
                public boolean apply(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
                    return div.getTxtKettaiYMD().getValue() != null && !div.getTxtKettaiYMD().getValue().isEmpty();
                }
            },
    対象年度の非空チェック {
                /**
                 * 対象年度の非空チェックです。
                 *
                 * @param div 障がい者控除対象者申請登録Div
                 * @return true:対象年度が非空です、false:対象年度が空です。
                 */
                @Override
                public boolean apply(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
                    return div.getTxtTaishoNendo().getDomain() != null && !div.getTxtTaishoNendo().getDomain().isEmpty();
                }
            },
    認知証高齢者自立度の非空チェック {
                /**
                 * 認知証高齢者自立度の非空チェックです。
                 *
                 * @param div 障がい者控除対象者申請登録Div
                 * @return true:認知証高齢者自立度が非空です、false:認知証高齢者自立度が空です。
                 */
                @Override
                public boolean apply(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
                    return div.getDdlNinchishoKoreishaJiritsudo().getSelectedKey() != null
                    && !div.getDdlNinchishoKoreishaJiritsudo().getSelectedKey().isEmpty();
                }
            },
    障がい高齢者自立度の非空チェック {
                /**
                 * 障がい高齢者自立度の非空チェックです。
                 *
                 * @param div 障がい者控除対象者申請登録Div
                 * @return true:障がい高齢者自立度が非空です、false:障がい高齢者自立度が空です。
                 */
                @Override
                public boolean apply(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
                    return div.getDdlShogaiKoreishaJiritsudo().getSelectedKey() != null
                    && !div.getDdlShogaiKoreishaJiritsudo().getSelectedKey().isEmpty();
                }
            },
    認定区分の非空チェック {
                /**
                 * 認定区分の非空チェックです。
                 *
                 * @param div 障がい者控除対象者申請登録Div
                 * @return true:認定区分が非空です、false:認定区分が空です。
                 */
                @Override
                public boolean apply(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
                    return div.getDdlNinteiKubun().getSelectedKey() != null
                    && !div.getDdlNinteiKubun().getSelectedKey().isEmpty();
                }
            },
    認定内容の非空チェック {
                /**
                 * 認定内容の非空チェックです。
                 *
                 * @param div 障がい者控除対象者申請登録Div
                 * @return true:認定内容が非空です、false:認定内容が空です。
                 */
                @Override
                public boolean apply(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
                    return div.getDdlNinteiNaiyo().getSelectedKey() != null
                    && !div.getDdlNinteiNaiyo().getSelectedKey().isEmpty();
                }
            },
    対象年度重複チェック {
                /**
                 * 対象年度の非空チェックです。
                 *
                 * @param div 障がい者控除対象者申請登録Div
                 * @return true:対象年度が非空です、false:対象年度が空です。
                 */
                @Override
                public boolean apply(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
                    ShogaishaKojoTaishoshaShinseiTorokuMainHandler handler = new ShogaishaKojoTaishoshaShinseiTorokuMainHandler(div);
                    return !handler.対象年度重複チェック();
                }
            }

}
