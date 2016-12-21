/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001;

import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE9030001.NinteichosaItakusakiMasterHandler;
import jp.co.ndensan.reams.db.dbe.service.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoManager;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.ServiceJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dbz.definition.core.kaigojigyoshano.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.jigyosha.JigyoshaInputGuideParameter;
import jp.co.ndensan.reams.db.dbz.service.core.jigyosha.JigyoshaInputGuideFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * 認定調査委託先マスタのSpecクラスです
 */
public enum NinteichosaItakusakiMasterDivSpec implements IPredicate<NinteichosaItakusakiMasterDiv> {

    調査委託先一覧データの存在チェック {
                /**
                 * 調査委託先一覧データの存在チェックです。
                 *
                 * @param div ServiceCodeCommonChildDivDiv
                 * @return true:調査委託先一覧データが存在する、false:調査委託先一覧データが存在しない
                 */
                @Override
                public boolean apply(NinteichosaItakusakiMasterDiv div) {
                    return div.getChosaitakusakichiran().getDgChosainIchiran().getTotalRecords() != 0;
                }
            },
    調査委託先一覧データの編集しないチェック {
                /**
                 * 調査委託先一覧データの編集状態チェックです。
                 *
                 * @param div ServiceCodeCommonChildDivDiv
                 * @return true:調査委託先一覧が編集がない、false:調査委託先一覧が編集中です
                 */
                @Override
                public boolean apply(NinteichosaItakusakiMasterDiv div) {
                    for (dgChosainIchiran_Row row : div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource()) {
                        if (!row.getJotai().isEmpty()) {
                            return false;
                        }
                    }
                    return true;
                }
            },
    調査委託先一覧データの編集中チェック {
                /**
                 * 調査委託先一覧データの編集状態チェックです。
                 *
                 * @param div ServiceCodeCommonChildDivDiv
                 * @return true:調査委託先一覧が編集中です、false:調査委託先一覧が編集がない
                 */
                @Override
                public boolean apply(NinteichosaItakusakiMasterDiv div) {
                    for (dgChosainIchiran_Row row : div.getChosaitakusakichiran().getDgChosainIchiran().getDataSource()) {
                        if (!row.getJotai().isEmpty()) {
                            return true;
                        }
                    }
                    return false;
                }
            },
    調査委託先情報登録エリアの編集状態チェック {
                /**
                 * 調査委託先情報登録エリアの編集状態チェックです。
                 *
                 * @param div ServiceCodeCommonChildDivDiv
                 * @return true:調査委託先情報登録エリアが編集中です、false:調査委託先情報登録エリアが編集がない
                 */
                @Override
                public boolean apply(NinteichosaItakusakiMasterDiv div) {
                    if (div.get状態().equals(new RString("追加")) || div.get状態().equals(new RString("修正"))) {
                        return getHandler(div).is調査委託先情報登録エリア編集有り();
                    }
                    return true;
                }
            },
    市町村の合法性チェック {
                /**
                 * 市町村の合法性チェックです。
                 *
                 * @param div ServiceCodeCommonChildDivDiv
                 * @return true:市町村が合法です、false:市町村が不合法です
                 */
                @Override
                public boolean apply(NinteichosaItakusakiMasterDiv div) {
                    return !(!div.getChosaitakusakiJohoInput().getTxtShichoson().getValue().isEmpty()
                    && div.getChosaitakusakiJohoInput().getTxtShichosonmei().getValue().isEmpty());

                }
            },
    調査委託先コードの重複チェック {
                /**
                 * 調査委託先コードの重複チェックです。
                 *
                 * @param div ServiceCodeCommonChildDivDiv
                 * @return true:調査委託先コードが重複しない、false:調査委託先コードが重複する
                 */
                @Override
                public boolean apply(NinteichosaItakusakiMasterDiv div) {
                    if (div.get状態().equals(new RString("追加"))) {
                        NinteichosaItakusakiJohoManager manager = NinteichosaItakusakiJohoManager.createInstance();
                        int 件数 = manager.countByKey(new LasdecCode(div.getChosaitakusakiJohoInput().getTxtShichoson().getValue()),
                                div.getChosaitakusakiJohoInput().getTxtChosaItakusaki().getValue());
                        return 0 == 件数;
                    }
                    return true;
                }
            },
    事業者番号存在チェック {
                /**
                 * 事業者番号存在チェックです。
                 *
                 * @param div ServiceCodeCommonChildDivDiv
                 * @return true:事業者番号存在、false:事業者番号存在しない
                 */
                @Override
                public boolean apply(NinteichosaItakusakiMasterDiv div) {
                    SearchResult<ServiceJigyoshaInputGuide> Jigyosha = JigyoshaInputGuideFinder.createInstance().getServiceJigyoshaInputGuide(
                            JigyoshaInputGuideParameter.createParam_ServiceJigyoshaInputGuide(new KaigoJigyoshaNo(div.getChosaitakusakiJohoInput().getTxtjigyoshano().getText()),
                                    FlexibleDate.EMPTY,
                                    FlexibleDate.EMPTY,
                                    new AtenaMeisho(RString.EMPTY),
                                    new YubinNo(RString.EMPTY),
                                    RString.EMPTY,
                                    RString.EMPTY,
                                    RString.EMPTY,
                                    RString.EMPTY,
                                    RString.EMPTY,
                                    FlexibleDate.getNowDate(),
                                    RString.EMPTY,
                                    1));
                    if (Jigyosha.totalCount() > 0) {
                        return true;
                    } else {
                        return false;
                    }
                }

            },
    口座情報入力有り時必須項目チェック {
                /**
                 * 口座情報入力有り時必須項目チェックです。
                 *
                 * @param div NinteichosaItakusakiMasterDiv
                 * @return true:口座情報必須入力不備なし、false:口座情報必須不備あり
                 */
                @Override
                public boolean apply(NinteichosaItakusakiMasterDiv div) {
                    if (!div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode().isEmpty()
                    || !div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanShitenCode().isEmpty()
                    || !div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShubetsu().getSelectedValue().isEmpty()
                    || !div.getChosaitakusakiJohoInput().getKozaJoho().getTxtGinkoKozaNo().getValue().isEmpty()
                    || !div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKozaMeiginin().getValue().isEmpty()) {
                        return !div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode().isEmpty()
                        && !div.getChosaitakusakiJohoInput().getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanShitenCode().isEmpty()
                        && !div.getChosaitakusakiJohoInput().getKozaJoho().getDdlYokinShubetsu().getSelectedValue().isEmpty()
                        && !div.getChosaitakusakiJohoInput().getKozaJoho().getTxtGinkoKozaNo().getValue().isEmpty()
                        && !div.getChosaitakusakiJohoInput().getKozaJoho().getTxtKozaMeiginin().getValue().isEmpty();
                    }
                    return true;
                }
            };

    private static NinteichosaItakusakiMasterHandler getHandler(NinteichosaItakusakiMasterDiv div) {
        return new NinteichosaItakusakiMasterHandler(div);
    }
}
