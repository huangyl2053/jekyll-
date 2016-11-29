/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1230011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.KogakuGassanShikyuKetteiHoseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassanshikyuketteihosei.KogakuGassanShikyuKetteiHosei;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public enum KogakuGassanShikyuKetteiHoseiPanelSpec implements IPredicate<KogakuGassanShikyuKetteiHoseiPanelDiv> {

    /**
     * 新規登録_対象年度必須チェック
     */
    新規登録_対象年度入力値が不正 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is新規登録_対象年度入力値が不正(div);
        }
    },
    /**
     * 新規登録_対象年度必須チェック
     */
    新規登録_対象年度_未指定 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is新規登録_対象年度_未指定(div);
        }
    },
    /**
     * 新規登録_証記載保険者番号必須チェック
     */
    新規登録_証記載保険者番号入力値が不正 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is新規登録_証記載保険者番号が不正(div);
        }
    },
    /**
     * 新規登録_証記載保険者番号必須チェック
     */
    新規登録_証記載保険者番号存在しない {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is新規登録_証記載保険者番号存在しない(div);
        }
    },
    /**
     * 新規登録_連絡票整理番号必須チェック
     */
    新規登録_連絡票整理番号入力値が不正 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is新規登録_連絡票整理番号入力値が不正(div);
        }
    },
    /**
     * 新規登録_連絡票整理番号必須チェック
     */
    新規登録_連絡票整理番号不一致_先頭3桁 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is新規登録_連絡票整理番号不一致_先頭3桁(div);
        }
    },
    /**
     * 新規登録_連絡票整理番号必須チェック
     */
    新規登録_連絡票整理番号不一致_先頭6桁目から11桁目 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is新規登録_連絡票整理番号不一致_先頭6桁目から11桁目(div);
        }
    },
    /**
     * 検索条件_対象年度必須チェック
     */
    検索条件_対象年度入力値が不正 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is検索条件_対象年度入力値が不正(div);
        }
    },
    /**
     * 検索条件_対象年度必須チェック
     */
    検索条件_対象年度_未指定 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is検索条件_対象年度_未指定(div);
        }
    },
    /**
     * 検索条件_証記載保険者番号必須チェック
     */
    検索条件_証記載保険者番号入力値が不正 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is検索条件_証記載保険者番号入力値が不正(div);
        }
    },
    /**
     * 検索条件_証記載保険者番号必須チェック
     */
    検索条件_証記載保険者番号存在しない {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is検索条件_証記載保険者番号存在しない(div);
        }
    },
    /**
     * 検索条件_連絡票整理番号必須チェック
     */
    検索条件_連絡票整理番号入力値が不正 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is検索条件_連絡票整理番号入力値が不正(div);
        }
    },
    /**
     * 検索条件_連絡票整理番号必須チェック
     */
    検索条件_連絡票整理番号不一致_先頭3桁 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is検索条件_連絡票整理番号不一致_先頭3桁(div);
        }
    },
    /**
     * 検索条件_連絡票整理番号必須チェック
     */
    検索条件_連絡票整理番号不一致_先頭6桁目から11桁目 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is検索条件_連絡票整理番号不一致_先頭6桁目から11桁目(div);
        }
    },
    /**
     * 対象年度必須入力必須チェック
     */
    対象年度必須入力 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is対象年度必須入力(div);
        }
    },
    /**
     * 証記載保険者番号必須入力必須チェック
     */
    証記載保険者番号必須入力 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is証記載保険者番号(div);
        }
    },
    /**
     * 証記載保険者番号必須入力必須チェック
     */
    支給申請書整理番号必須入力 {
        @Override
        public boolean apply(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return SpecHelper.is支給申請書整理番号(div);
        }
    };

    private static class SpecHelper {

        private static final RDate 定値_年度年度1 = new RDate("2008");
        private static final RString 定値導入形態コード1 = new RString("111");
        private static final RString 定値導入形態コード2 = new RString("112");
        private static final RString 定値導入形態コード3 = new RString("120");
        private static final RString ONE = new RString("1");
        private static final RString TWO = new RString("2");
        private static final int NUM_THREE = 3;
        private static final int NUM_FIVE = 5;
        private static final int NUM_SIX = 6;
        private static final int NUM_ELEVEN = 11;
        private static final int NUM_SEVENTEEN = 17;

        public static boolean is対象年度必須入力(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return !(div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue() == null);
        }

        public static boolean is証記載保険者番号(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return !(div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue() == null
                    || div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue().isEmpty());
        }

        public static boolean is支給申請書整理番号(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return !(div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue() == null
                    || div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().isEmpty());
        }

        public static boolean is新規登録_対象年度入力値が不正(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return !(div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue() != null
                    && !RStringUtil.isHalfsizeNumberOnly(
                            div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue().toDateString()));
        }

        public static boolean is新規登録_対象年度_未指定(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            if (div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue() != null
                    && !RStringUtil.isHalfsizeNumberOnly(
                            div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue().toDateString())) {
                return true;
            }
            return !(div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue() != null
                    && div.getShinkiPanel().getTxtShinkiTaishoNendo().
                    getValue().isBefore(定値_年度年度1));
        }

        public static boolean is新規登録_証記載保険者番号が不正(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return !((div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue() != null
                    && !div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue().isEmpty()
                    && !RStringUtil.isHalfsizeNumberOnly(
                            div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue()))
                    || (div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue() != null
                    && !div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue().isEmpty()
                    && RStringUtil.isHalfsizeNumberOnly(
                            div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue())
                    && NUM_SIX != div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue().length()));
        }

        public static boolean is新規登録_証記載保険者番号存在しない(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            boolean flag = true;
            if (div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue() == null
                    || div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue().isEmpty()) {
                return true;
            }
            RString wk保険者構成 = get保険者構成();
            TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
            List<ShichosonCodeYoriShichoson> yoriShichosonList = KoikiShichosonJohoFinder.createInstance().shichosonCodeYoriShichosonJoho(
                    KogakuGassanShikyuKetteiHosei.createInstance().get市町村コード(被保険者番号)).records();
            if (ONE.equals(wk保険者構成)) {
                RString 保険者番号 = DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                if (div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue() != null
                        && !div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue().isEmpty()
                        && !RString.isNullOrEmpty(保険者番号)
                        && !div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue().
                        equals(保険者番号)) {
                    flag = false;
                }
            } else if (TWO.equals(wk保険者構成) && yoriShichosonList != null) {
                flag = false;
                for (ShichosonCodeYoriShichoson entity : yoriShichosonList) {
                    if (div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue() != null
                            && !div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue().isEmpty()
                            && div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue().
                            equals(entity.get証記載保険者番号().value())) {
                        return true;
                    }
                }
            }
            return flag;
        }

        public static boolean is新規登録_連絡票整理番号入力値が不正(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return !(div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue() != null
                    && !div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().isEmpty()
                    && !RStringUtil.isHalfsizeNumberOnly(
                            div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue())
                    || div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue() != null
                    && !div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().isEmpty()
                    && NUM_SEVENTEEN != div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().length());
        }

        public static boolean is新規登録_連絡票整理番号不一致_先頭3桁(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            if (div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue() != null
                    && !div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().isEmpty()
                    && !RStringUtil.isHalfsizeNumberOnly(
                            div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue())) {
                return true;
            }
            return !(div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue() != null
                    && NUM_THREE <= div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue().toString().length()
                    && div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue() != null
                    && !div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().isEmpty()
                    && NUM_THREE <= div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().length()
                    && !div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().
                    substring(0, NUM_THREE).equals(trimYear(div.getShinkiPanel().
                    getTxtShinkiTaishoNendo().getValue().getYear())));
        }

        public static boolean is新規登録_連絡票整理番号不一致_先頭6桁目から11桁目(
                KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            if (div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue() != null
                    && !div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().isEmpty()
                    && !RStringUtil.isHalfsizeNumberOnly(
                            div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue())) {
                return true;
            }
            return !(div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue() != null
                    && !div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue().isEmpty()
                    && div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue() != null
                    && !div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().isEmpty()
                    && NUM_ELEVEN <= div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().length()
                    && !div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue().
                    substring(NUM_FIVE, NUM_ELEVEN).equals(div.getShinkiPanel().
                    getTxtShinkiHihokenshaNo().getValue()));
        }

        public static boolean is検索条件_対象年度入力値が不正(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return !(div.getSearchPanel().getTxtKensakuTaishoNendo().getValue() != null
                    && !RStringUtil.isHalfsizeNumberOnly(
                            div.getSearchPanel().getTxtKensakuTaishoNendo().getValue().toDateString()));
        }

        public static boolean is検索条件_対象年度_未指定(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            if (div.getSearchPanel().getTxtKensakuTaishoNendo().getValue() != null
                    && !RStringUtil.isHalfsizeNumberOnly(
                            div.getSearchPanel().getTxtKensakuTaishoNendo().getValue().toDateString())) {
                return true;
            }
            return !(div.getSearchPanel().getTxtKensakuTaishoNendo().getValue() != null
                    && div.getSearchPanel().getTxtKensakuTaishoNendo().getValue().isBefore(定値_年度年度1));
        }

        public static boolean is検索条件_証記載保険者番号入力値が不正(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return !((div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue() != null
                    && !div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue().isEmpty()
                    && !RStringUtil.isHalfsizeNumberOnly(
                            div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue()))
                    || (div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue() != null
                    && !div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue().isEmpty()
                    && RStringUtil.isHalfsizeNumberOnly(
                            div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue())
                    && NUM_SIX != div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue().length()));
        }

        public static boolean is検索条件_証記載保険者番号存在しない(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            boolean flag = true;
            if (div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue() == null
                    || div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue().isEmpty()) {
                return true;
            }
            RString wk保険者構成 = get保険者構成();
            TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
            List<ShichosonCodeYoriShichoson> yoriShichosonList = KoikiShichosonJohoFinder.createInstance().shichosonCodeYoriShichosonJoho(
                    KogakuGassanShikyuKetteiHosei.createInstance().get市町村コード(被保険者番号)).records();
            if (ONE.equals(wk保険者構成)) {
                RString 保険者番号 = DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                if (div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue() != null
                        && !div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue().isEmpty()
                        && !RString.isNullOrEmpty(保険者番号)
                        && !div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue().
                        equals(保険者番号)) {
                    flag = false;
                }
            } else if (TWO.equals(wk保険者構成) && yoriShichosonList != null) {
                flag = false;
                for (ShichosonCodeYoriShichoson entity : yoriShichosonList) {
                    if (div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue() != null
                            && !div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue().isEmpty()
                            && div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue().
                            equals(entity.get証記載保険者番号().value())) {
                        return true;
                    }
                }
            }
            return flag;
        }

        private static RString get保険者構成() {
            RString wk保険者構成 = RString.EMPTY;
            ShichosonSecurityJoho shseJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
            if (shseJoho != null && (定値導入形態コード2.equals(shseJoho.get導入形態コード().value())
                    || 定値導入形態コード3.equals(shseJoho.get導入形態コード().value()))) {
                wk保険者構成 = ONE;
            } else if (shseJoho != null && 定値導入形態コード1.equals(shseJoho.get導入形態コード().value())) {
                wk保険者構成 = TWO;
            }
            return wk保険者構成;
        }

        public static boolean is検索条件_連絡票整理番号入力値が不正(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            return !(div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue() != null
                    && !div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue().isEmpty()
                    && !RStringUtil.isHalfsizeNumberOnly(
                            div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue())
                    || div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue() != null
                    && !div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue().isEmpty()
                    && NUM_SEVENTEEN != div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue().length());
        }

        public static boolean is検索条件_連絡票整理番号不一致_先頭3桁(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            if (div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue() != null
                    && !div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue().isEmpty()
                    && !RStringUtil.isHalfsizeNumberOnly(
                            div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue())) {
                return true;
            }
            return !(div.getSearchPanel().getTxtKensakuTaishoNendo().getValue() != null
                    && NUM_THREE <= div.getSearchPanel().getTxtKensakuTaishoNendo().getValue().toString().length()
                    && div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue() != null
                    && !div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue().isEmpty()
                    && NUM_THREE <= div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue().length()
                    && !div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue().
                    substring(0, NUM_THREE).equals(trimYear(div.getSearchPanel().getTxtKensakuTaishoNendo().
                    getValue().getYear())));
        }

        public static boolean is検索条件_連絡票整理番号不一致_先頭6桁目から11桁目(
                KogakuGassanShikyuKetteiHoseiPanelDiv div) {
            if (div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue() != null
                    && !div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue().isEmpty()
                    && !RStringUtil.isHalfsizeNumberOnly(
                            div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue())) {
                return true;
            }
            return !(div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue() != null
                    && !div.getSearchPanel().getTxtKensakuHihokenshaNo().getValue().isEmpty()
                    && div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue() != null
                    && !div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue().isEmpty()
                    && NUM_ELEVEN <= div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue().length()
                    && !div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue().
                    substring(NUM_FIVE, NUM_ELEVEN).equals(div.getSearchPanel().
                    getTxtKensakuHihokenshaNo().getValue()));
        }

        private static RString trimYear(RYear year) {
            if (year == null) {
                return RString.EMPTY;
            } else {
                return year.wareki().eraType(EraType.NUMBER).firstYear(FirstYear.GAN_NEN).toDateString();
            }
        }
    }

}
