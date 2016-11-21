/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB8110001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001.KakushuTsuchishoSakuseiKobetsuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001.dgChohyoSentaku_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBBGM12001_3_各種通知書作成（個別）のハンドラクラスです。
 *
 * @reamsid_L DBB-0740-010 wangkanglei
 */
public class KakushuTsuchishoSakuseiKobetsuCheckHandler {

    private final KakushuTsuchishoSakuseiKobetsuDiv div;
    private static final RString 特徴開始通知書 = new RString("特徴開始通知書");
    private static final RString 決定通知書 = new RString("決定通知書");
    private static final RString 納入通知書 = new RString("納入通知書");
    private static final RString 賦課台帳 = new RString("賦課台帳");
    private static final RString 郵便振替納付書 = new RString("郵便振替納付書");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString STR_0 = new RString("0");
    private static final RString 発行する = new RString("btnReportPublish");

    /**
     * コンストラクタです。
     *
     * @param div KakushuTsuchishoSakuseiKobetsuDiv
     */
    public KakushuTsuchishoSakuseiKobetsuCheckHandler(KakushuTsuchishoSakuseiKobetsuDiv div) {
        this.div = div;
    }

    /**
     * 特徴開始通知書チェックのメソッドます。
     *
     * @param map 賦課の情報
     */
    public void check特徴開始通知書(Map<RString, FukaJoho> map) {
        List<RString> publish = div.getTsuchishoSakuseiKobetsu().getWrapTokuKaishiTsuchiKobetsu()
                .getChkPublishTokuKaishiTsuchiKobetsu().getSelectedKeys();
        if (publish.isEmpty()) {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) - 1)));
            div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().setDisplayNone(true);
            set通知書(false, 特徴開始通知書, map);
        } else {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) + 1)));
            div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().setDisplayNone(false);
            set通知書(true, 特徴開始通知書, map);
        }
    }

    /**
     * 決定通知書チェックのメソッドます。
     *
     * @param map 賦課の情報
     */
    public void check決定通知書(Map<RString, FukaJoho> map) {
        List<RString> publish = div.getTsuchishoSakuseiKobetsu().getWrapKetteiTsuchiKobetsu()
                .getChkPublishKetteiTsuchiKobetsu().getSelectedKeys();
        if (publish.isEmpty()) {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) - 1)));
            div.getTsuchishoSakuseiKobetsu().getKetteiTsuchiKobetsu().setDisplayNone(true);
            set通知書(false, 決定通知書, map);
            div.getTsuchishoSakuseiKobetsu().getWrapHenkoTsuchiKobetsu().getChkPublishHenkoTsuchiKobetsu().setDisabled(false);
        } else {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) + 1)));
            div.getTsuchishoSakuseiKobetsu().getKetteiTsuchiKobetsu().setDisplayNone(false);
            set通知書(true, 決定通知書, map);
            div.getTsuchishoSakuseiKobetsu().getWrapHenkoTsuchiKobetsu().getChkPublishHenkoTsuchiKobetsu().setDisabled(true);
        }
    }

    /**
     * 変更通知書チェックのメソッドます。
     *
     * @param map 賦課の情報
     * @param 変更通知書略称 RString
     */
    public void check変更通知書(Map<RString, FukaJoho> map, RString 変更通知書略称) {
        List<RString> publish = div.getTsuchishoSakuseiKobetsu().getWrapHenkoTsuchiKobetsu()
                .getChkPublishHenkoTsuchiKobetsu().getSelectedKeys();
        if (publish.isEmpty()) {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) - 1)));
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setDisplayNone(true);
            set通知書(false, 変更通知書略称, map);
            div.getTsuchishoSakuseiKobetsu().getWrapKetteiTsuchiKobetsu().getChkPublishKetteiTsuchiKobetsu().setDisabled(false);
        } else {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) + 1)));
            div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setDisplayNone(false);
            set通知書(true, 変更通知書略称, map);
            div.getTsuchishoSakuseiKobetsu().getWrapKetteiTsuchiKobetsu().getChkPublishKetteiTsuchiKobetsu().setDisabled(true);
        }
    }

    /**
     * 納入通知書チェックのメソッドます。
     *
     * @param map 賦課の情報
     */
    public void check納入通知書(Map<RString, FukaJoho> map) {
        List<RString> publish = div.getTsuchishoSakuseiKobetsu().getWrapNotsuKobetsu()
                .getChkPublishNotsuKobetsu().getSelectedKeys();
        if (publish.isEmpty()) {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) - 1)));
            div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().setDisplayNone(true);
            set通知書(false, 納入通知書, map);
        } else {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) + 1)));
            div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().setDisplayNone(false);
            set通知書(true, 納入通知書, map);
        }
    }

    /**
     * 郵便納付書チェックのメソッドます。
     *
     * @param map 賦課の情報
     */
    public void check郵便納付書(Map<RString, FukaJoho> map) {
        List<RString> publish = div.getTsuchishoSakuseiKobetsu().getWrapYufuriKobetsu()
                .getChkPublishYufuriKobetsu().getSelectedKeys();
        if (publish.isEmpty()) {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) - 1)));
            div.getTsuchishoSakuseiKobetsu().getYufuriKobetsu().setDisplayNone(true);
            set通知書(false, 郵便振替納付書, map);
        } else {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) + 1)));
            div.getTsuchishoSakuseiKobetsu().getYufuriKobetsu().setDisplayNone(false);
            set通知書(true, 郵便振替納付書, map);
        }
    }

    /**
     * 減免通知書チェックのメソッドます。
     *
     * @param map 賦課の情報
     * @param 減免通知書略称 RString
     */
    public void check減免通知書(Map<RString, FukaJoho> map, RString 減免通知書略称) {
        List<RString> publish = div.getTsuchishoSakuseiKobetsu().getWrapGemmenTsuchiKobetsu()
                .getChkPublishGemmenTsuchiKobetsu().getSelectedKeys();
        if (publish.isEmpty()) {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) - 1)));
            div.getTsuchishoSakuseiKobetsu().getGemmenTsuchiKobetsu().setDisplayNone(true);
            set通知書(false, 減免通知書略称, map);
        } else {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) + 1)));
            div.getTsuchishoSakuseiKobetsu().getGemmenTsuchiKobetsu().setDisplayNone(false);
            set通知書(true, 減免通知書略称, map);
        }
    }

    /**
     * 徴収猶予通知書チェックのメソッドます。
     *
     * @param map 賦課の情報
     * @param 徴収猶予通知書略称 RString
     */
    public void check徴収猶予通知書(Map<RString, FukaJoho> map, RString 徴収猶予通知書略称) {
        List<RString> publish = div.getTsuchishoSakuseiKobetsu().getWrapChoshuYuyoTsuchiKobetsu()
                .getChkPublishChoshuYuyoTsuchiKobetsu().getSelectedKeys();
        if (publish.isEmpty()) {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) - 1)));
            div.getTsuchishoSakuseiKobetsu().getChoshuYuyoTsuchiKobetsu().setDisplayNone(true);
            set通知書(false, 徴収猶予通知書略称, map);
        } else {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) + 1)));
            div.getTsuchishoSakuseiKobetsu().getChoshuYuyoTsuchiKobetsu().setDisplayNone(false);
            set通知書(true, 徴収猶予通知書略称, map);
        }
    }

    /**
     * 賦課台帳チェックのメソッドます。
     *
     * @param map 賦課の情報
     */
    public void check賦課台帳(Map<RString, FukaJoho> map) {
        List<RString> publish = div.getTsuchishoSakuseiKobetsu().getWrapFukadaichoKobetsu()
                .getChkPublishFukadaichoKobetsu().getSelectedKeys();
        if (publish.isEmpty()) {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) - 1)));
            div.getTsuchishoSakuseiKobetsu().getFukadaichoKobetsu().setDisplayNone(true);
            set通知書(false, 賦課台帳, map);
        } else {
            div.setHdnPublishFlag(new RString(String.valueOf(Integer.parseInt(div.getHdnPublishFlag().toString()) + 1)));
            div.getTsuchishoSakuseiKobetsu().getFukadaichoKobetsu().setDisplayNone(false);
            set通知書(true, 賦課台帳, map);
        }
    }

    private void set通知書(boolean flag, RString 通知書, Map<RString, FukaJoho> map) {
        List<dgChohyoSentaku_Row> dgRowList = div.getTsuchishoSakuseiKobetsu().getDgChohyoSentaku().getDataSource();
        List<dgChohyoSentaku_Row> rowList = new ArrayList<>();
        rowList.addAll(dgRowList);
        if (flag) {
            dgChohyoSentaku_Row row = new dgChohyoSentaku_Row();
            row.setTxtChohyoSentaku(通知書);
            rowList.add(row);
        } else {
            for (dgChohyoSentaku_Row dgRow : dgRowList) {
                if (通知書.equals(dgRow.getTxtChohyoSentaku())) {
                    rowList.remove(dgRow);
                }
            }
        }
        div.getTsuchishoSakuseiKobetsu().getDgChohyoSentaku().setDataSource(rowList);
        if (div.getHdnPublishFlag().equals(STR_0)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, true);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(発行する, false);
        }
        if ((!div.getTsuchishoSakuseiKobetsu().getKetteiTsuchiKobetsu().isDisplayNone()
                || !div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().isDisplayNone())
                && (div.getTsuchishoSakuseiKobetsu().getTokuKaishiTsuchiKobetsu().isDisplayNone()
                && div.getTsuchishoSakuseiKobetsu().getNotsuKobetsu().isDisplayNone()
                && div.getTsuchishoSakuseiKobetsu().getGemmenTsuchiKobetsu().isDisplayNone()
                && div.getTsuchishoSakuseiKobetsu().getChoshuYuyoTsuchiKobetsu().isDisplayNone()
                && div.getTsuchishoSakuseiKobetsu().getYufuriKobetsu().isDisplayNone()
                && div.getTsuchishoSakuseiKobetsu().getFukadaichoKobetsu().isDisplayNone())) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().setDisabled(false);
        } else {
            onChange調定事由印字方法(KEY0, map);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().setDisabled(true);
        }
    }

    /**
     * 調定事由印字方法を変更のメソッドます。
     *
     * @param key 調定事由の印字方法
     * @param map 賦課の情報
     */
    public void onChange調定事由印字方法(RString key, Map<RString, FukaJoho> map) {
        if (key.isEmpty()) {
            key = div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu()
                    .getRadKobetsuHakkoChoteiJiyu().getSelectedKey();
        }
        if (KEY0.equals(key)) {
            FukaJoho info = map.get(div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoZengoSentaku()
                    .getDdlInjiKouseiAto().getSelectedKey());
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setDisabled(true);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setDisabled(true);
            if (info.get調定事由1() != null && !info.get調定事由1().isEmpty()) {
                div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setValue(
                        ChoteiJiyuCode.toValue(info.get調定事由1()).get名称());
            }
            if (info.get調定事由2() != null && !info.get調定事由2().isEmpty()) {
                div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setValue(
                        ChoteiJiyuCode.toValue(info.get調定事由2()).get名称());
            }
            if (info.get調定事由3() != null && !info.get調定事由3().isEmpty()) {
                div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setValue(
                        ChoteiJiyuCode.toValue(info.get調定事由3()).get名称());
            }
            if (info.get調定事由4() != null && !info.get調定事由4().isEmpty()) {
                div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setValue(
                        ChoteiJiyuCode.toValue(info.get調定事由4()).get名称());
            }
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu()
                    .getRadKobetsuHakkoChoteiJiyu().setSelectedKey(key);
        } else if (KEY1.equals(key)) {
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setDisabled(false);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setDisabled(false);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setDisabled(false);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setDisabled(false);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu1().setValue(RString.EMPTY);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu2().setValue(RString.EMPTY);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu3().setValue(RString.EMPTY);
            div.getFukaShokaiGrandsonTsuchisho().getKobetsuHakkoChoteiJiyu().getTxtChoteiJiyu4().setValue(RString.EMPTY);
        }
    }

}
