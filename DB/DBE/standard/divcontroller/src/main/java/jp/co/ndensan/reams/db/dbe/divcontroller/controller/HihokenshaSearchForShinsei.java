/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaSearchForShinseiDiv;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.HihokenshaFinder;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.HihokenshaForSearchResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.IHihokenshaForSearchResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.SearchResultOfHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 要介護認定申請時に、対象となる被保険者を検索するDviを制御します。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaSearchForShinsei {

    /**
     * 検索ボタン押下時の処理です。
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onClickBtnToSearch(HihokenshaSearchForShinseiDiv panel) {
        ResponseData<HihokenshaSearchForShinseiDiv> response = new ResponseData<>();

        SearchResultOfHihokensha.setSearchResult(panel.getSearchResultForShinsei(), ForDemo.getHihokenshaList());

        response.data = panel;
        return response;
    }

    /**
     * 検索条件クリアボタン押下時の処理です。
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onClickBtnToClear(HihokenshaSearchForShinseiDiv panel) {
        ResponseData<HihokenshaSearchForShinseiDiv> response = new ResponseData<>();

        HihokenshaFinder.clear(panel.getSearchCriteriaForShinsei());

        response.data = panel;
        return response;
    }

    /**
     * 再建策ボタン押下時の処理です。
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onClickBtnToResearch(HihokenshaSearchForShinseiDiv panel) {
        ResponseData<HihokenshaSearchForShinseiDiv> response = new ResponseData<>();

        HihokenshaFinder.clear(panel.getSearchCriteriaForShinsei());
        SearchResultOfHihokensha.clear(panel.getSearchResultForShinsei());

        response.data = panel;
        return response;
    }

    /**
     * データグリッド内の確定ボタン押下時の処理です。
     *
     * @param panel HihokenshaSearchForShinseiDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshaSearchForShinseiDiv> onClickBtnToDecideOfGridData(HihokenshaSearchForShinseiDiv panel) {
        ResponseData<HihokenshaSearchForShinseiDiv> response = new ResponseData<>();

        response.data = panel;
        return response;
    }

    /**
     * テスト用の被保険者情報のリストを保持します。
     */
    static class ForDemo {

        private static final List<IHihokenshaForSearchResult> HIHOKENSHA_LIST;
        private static final Map<RString, LatestNinteiResult> LATEST_NINTEI_MAP;
        private static final int ICHIRO = 0;
        private static final int JIRO = 1;
        private static final int SABURO = 2;
        private static final int SHIRO = 3;

        /**
         * 被保険者区分です。
         */
        enum HihokenshaKubun {

            第1号被保険者, 第2号被保険者, その他;
            private final RString theName;

            private HihokenshaKubun() {
                this.theName = new RString(name());
            }

            public RString toRString() {
                return theName;
            }

            /**
             * 名称から、該当するHihokenshaKubunを返します。
             *
             * @param name 名称
             * @return 引数に該当するHihokenshaKubun
             */
            public static HihokenshaKubun toValue(RString name) {
                for (HihokenshaKubun kubun : values()) {
                    if (kubun.toRString().equals(name)) {
                        return kubun;
                    }
                }
                return その他;
            }
        }

        static {
            HIHOKENSHA_LIST = new ArrayList<>();
            HIHOKENSHA_LIST.add(ICHIRO, new HihokenshaForSearchResult(
                    new KaigoHihokenshaNo(new RString("0000000001")), new ShikibetsuCode("000000000000001"),
                    HihokenshaKubun.第1号被保険者.toRString(),
                    new RString("要介護 一郎"), new RString("ヨウカイゴ イチロウ"), Gender.MALE, new RDate("19410101"),
                    new YubinNo("381-0041"), new AtenaJusho("長野市1丁目"),
                    new RString("000000000001"), JuminShubetsu.日本人, new SetaiCode("000000000000001")));
            HIHOKENSHA_LIST.add(JIRO, new HihokenshaForSearchResult(
                    new KaigoHihokenshaNo(new RString("0000000002")), new ShikibetsuCode("000000000000002"),
                    HihokenshaKubun.第1号被保険者.toRString(),
                    new RString("要支援 二郎"), new RString("ヨウシエン ジロウ"), Gender.MALE, new RDate("19420202"),
                    new YubinNo("381-0042"), new AtenaJusho("長野市2丁目"),
                    new RString("000000000002"), JuminShubetsu.日本人, new SetaiCode("000000000000002")));
            HIHOKENSHA_LIST.add(SABURO, new HihokenshaForSearchResult(
                    new KaigoHihokenshaNo(new RString("0000000003")), new ShikibetsuCode("000000000000003"),
                    HihokenshaKubun.第1号被保険者.toRString(),
                    new RString("未該当 三郎"), new RString("ミガイトウ サブロウ"), Gender.MALE, new RDate("19430303"),
                    new YubinNo("381-0043"), new AtenaJusho("長野市3丁目"),
                    new RString("000000000003"), JuminShubetsu.日本人, new SetaiCode("000000000000003")));
            HIHOKENSHA_LIST.add(SHIRO, new HihokenshaForSearchResult(
                    new KaigoHihokenshaNo(new RString("0000000004")), new ShikibetsuCode("000000000000004"),
                    HihokenshaKubun.第2号被保険者.toRString(),
                    new RString("二号 四郎"), new RString("ニゴウ シロウ"), Gender.MALE, new RDate("19440404"),
                    new YubinNo("381-0044"), new AtenaJusho("長野市4丁目"),
                    new RString("000000000004"), JuminShubetsu.日本人, new SetaiCode("000000000000004")));
        }

        static {
            LATEST_NINTEI_MAP = new HashMap<>(HIHOKENSHA_LIST.size());
            LATEST_NINTEI_MAP.put(HIHOKENSHA_LIST.get(ICHIRO).hihokenshaNo(),
                    new LatestNinteiResult(YokaigoJotaiKubun.要介護1, new RDate("20130401"),
                            new Range<>(new RDate("20131101"), new RDate("20140430"))));
            LATEST_NINTEI_MAP.put(HIHOKENSHA_LIST.get(JIRO).hihokenshaNo(),
                    new LatestNinteiResult(YokaigoJotaiKubun.要支援2, new RDate("20130401"),
                            new Range<>(new RDate("20131101"), new RDate("20140430"))));
            LATEST_NINTEI_MAP.put(HIHOKENSHA_LIST.get(SABURO).hihokenshaNo(), LatestNinteiResult.NOTHING);
            LATEST_NINTEI_MAP.put(HIHOKENSHA_LIST.get(SHIRO).hihokenshaNo(),
                    new LatestNinteiResult(YokaigoJotaiKubun.要介護1, new RDate("20130401"),
                            new Range<>(new RDate("20131101"), new RDate("20140430"))));
        }

        static List<IHihokenshaForSearchResult> getHihokenshaList() {
            return Collections.unmodifiableList(ForDemo.HIHOKENSHA_LIST);
        }

        static Map<RString, LatestNinteiResult> getLatestNinteiResultMap() {
            return Collections.unmodifiableMap(ForDemo.LATEST_NINTEI_MAP);
        }

        /**
         * 要介護状態区分です。
         */
        enum YokaigoJotaiKubun {

            未該当(false),
            要支援1(false),
            要支援2(false),
            要介護1(true),
            要介護2(true),
            要介護3(true),
            要介護4(true),
            要介護5(true);

            private final RString theName;
            private final boolean isYokaigo;

            private YokaigoJotaiKubun(boolean isYokaigo) {
                this.theName = new RString(name());
                this.isYokaigo = isYokaigo;
            }

            /**
             * name()と同じ文字列を持ったRStringを返します。
             *
             * @return name()と同じ文字列を持ったRString
             */
            public RString toRString() {
                return theName;
            }

            /**
             * 要介護ならtrueを返します。
             *
             * @return 要介護ならtrue
             */
            public boolean is要介護() {
                return isYokaigo;
            }
        }

        /**
         * 前回認定結果です。
         */
        static class LatestNinteiResult {

            static final LatestNinteiResult NOTHING;

            static {
                NOTHING = new LatestNinteiResult(YokaigoJotaiKubun.未該当, RDate.MIN, new Range<>(RDate.MIN, RDate.MIN));
            }

            private final YokaigoJotaiKubun theYokaigodo;
            private final RDate theNinteiDate;
            private final Range<RDate> theYukoKikan;

            LatestNinteiResult(YokaigoJotaiKubun theYokaigodo, RDate theNinteiDate, Range<RDate> theYukoKikan) {
                this.theYokaigodo = theYokaigodo;
                this.theNinteiDate = theNinteiDate;
                this.theYukoKikan = theYukoKikan;
            }

            YokaigoJotaiKubun yokaigodo() {
                return this.theYokaigodo;
            }

            RDate ninteiDate() {
                return this.theNinteiDate;
            }

            Range<RDate> yukoKikan() {
                return this.theYukoKikan;
            }
        }
    }
}
