/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.JyutakuGaisyunaiyoListParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.dgGaisyuList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * {@link JutakuKaishuShinseiJyohoTorokuDiv}の仕様クラスです。
 * <br> {@link JutakuKaishuShinseiJyohoTorokuDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public enum JutakuKaishuShinseiJyohoTorokuSpec implements IPredicate<JutakuKaishuShinseiJyohoTorokuDiv> {

    /**
     * 提供着工年月入力必須チェック
     */
    提供着工年月が入力 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is提供着工年月が入力(div);
                }
            },
    /**
     * 領収日入力必須チェック
     */
    領収日が入力 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is領収日が入力(div);
                }
            },
    /**
     * 受給認定が無効チェック
     */
    受給認定が無効チェック {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    if (div.getCommHeadPanel().get要介護認定情報() == null) {
                        return false;
                    } else {
                        List<RString> 要介護認定状態区分コードリスト = new ArrayList<>();
                        RString 要介護認定状態区分コード = div.getCommHeadPanel().get要介護認定情報();
                        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要支援_経過的要介護.getCode());
                        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要支援1.getCode());
                        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要支援2.getCode());
                        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護1.getCode());
                        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護2.getCode());
                        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護3.getCode());
                        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護4.getCode());
                        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護5.getCode());
                        if (要介護認定状態区分コードリスト.contains(要介護認定状態区分コード)) {
                            return true;
                        }
                        if (YoKaigoJotaiKubun.非該当.getCode().equals(要介護認定状態区分コード)
                        && new RString("1").equals(div.getCommHeadPanel().getIs旧措置者フラグ())) {
                            return true;
                        }
                    }
                    return false;
                }
            },
    /**
     * 申請日入力必須チェック
     */
    申請日が入力 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is申請日が入力(div);
                }
            },
    /**
     * 住宅所有者入力必須チェック
     */
    住宅所有者が入力 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is住宅所有者が入力(div);
                }
            },
    /**
     * 証明書入力必須チェック
     */
    証明書が入力 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is証明書が入力(div);
                }
            },
    /**
     * 住宅改修内容一覧が妥当チェック
     */
    住宅改修内容一覧が妥当 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is住宅改修内容一覧妥当(div);
                }
            },
    /**
     * 給付率入力必須チェック
     */
    給付率が入力 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is給付率が入力(div);
                }
            },
    /**
     * 領収日変更チェック
     */
    領収日変更 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is領収日変更(div);
                }
            },
    /**
     * 住宅所有者入力必須チェック
     */
    提供着工年月が申請日の年月と一致しない {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is提供着工年月が申請日の年月と一致しない(div);

                }
            };

    private static class SpecHelper {

        public static boolean is提供着工年月が入力(JutakuKaishuShinseiJyohoTorokuDiv div) {
            return div.getTxtTeikyoYM().getValue() != null;
        }

        public static boolean is住宅所有者が入力(JutakuKaishuShinseiJyohoTorokuDiv div) {
            return !div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().getValue().isEmpty();
        }

        public static boolean is領収日が入力(JutakuKaishuShinseiJyohoTorokuDiv div) {
            return div.getJutakuKaishuShinseiContents().getTxtJigyoshaNo().getValue() != null || !div.getJutakuKaishuShinseiContents().getTxtJigyoshaNo().getValue().isEmpty();
        }

        public static boolean is申請日が入力(JutakuKaishuShinseiJyohoTorokuDiv div) {
            return div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD().getValue() != null;
        }

        public static boolean is証明書が入力(JutakuKaishuShinseiJyohoTorokuDiv div) {
            return !div.getCommHeadPanel().getDdlSyomeisyo().getSelectedKey().isEmpty();
        }

        public static boolean is給付率が入力(JutakuKaishuShinseiJyohoTorokuDiv div) {
            return div.getCommHeadPanel().getTxtKyufuritsu().getValue() != null;
        }

        public static boolean is領収日変更(JutakuKaishuShinseiJyohoTorokuDiv div) {
            RDate 領収日 = div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().getValue();
            RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
            return 領収日 == null || 領収日.getYearMonth().equals(画面提供着工年月.getYearMonth());
        }

        public static boolean is住宅改修内容一覧妥当(JutakuKaishuShinseiJyohoTorokuDiv div) {
            List<dgGaisyuList_Row> gridList = div.getCcdJutakugaisyunaiyoList()
                    .get住宅改修内容一覧();
            List<JyutakuGaisyunaiyoListParameter> paramList = new ArrayList<>();
            JyutakuGaisyunaiyoListParameter param;
            for (dgGaisyuList_Row row : gridList) {
                RString 状態 = new RString(row.getRowState().toString());
                param = JyutakuGaisyunaiyoListParameter.createSelectByKeyParam(
                        状態, row.getTxtJutakuAddress(),
                        new FlexibleDate(new RDate(row.getTxtChakkoYoteibi().toString()).toDateString()));
                paramList.add(param);
            }
            RString 住宅改修内容一覧チェック = JutakukaishuSikyuShinseiManager.createInstance()
                    .checkJyutakuGaisyunaiyoList(paramList,
                            new FlexibleYearMonth(div.getTxtTeikyoYM().getValue().getYearMonth().toDateString()));
            return RString.isNullOrEmpty(住宅改修内容一覧チェック);
        }

        public static boolean is提供着工年月が申請日の年月と一致しない(JutakuKaishuShinseiJyohoTorokuDiv div) {
            RString 給付実績連動_受託なし = new RString("1");
            RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
            if (画面提供着工年月 == null) {
                return true;
            }
            RDate 申請日 = div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                    .getTxtShinseiYMD().getValue();
            RYearMonth 申請日年月 = null;
            if (申請日 != null) {
                申請日年月 = div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                        .getTxtShinseiYMD().getValue().getYearMonth();
            }
            RString 償還 = DbBusinessConfig.get(
                    ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            if (給付実績連動_受託なし.equals(償還) && ((申請日 == null)
                    || (!画面提供着工年月.getYearMonth().equals(申請日年月)))) {
                return false;
            }
            return true;
        }
    }
}
