/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0020011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHakoResult;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokunenpo.ShichosonCodeNameResult;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoSearchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020011.DBU0020011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020011.JigyoJokyoHokokuHoseiKensakuDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020011.dgHoseitaishoYoshiki_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020011.JigyoJokyoHokokuHoseiKensakuHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbu.service.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.TokeiTaishoKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 事業報告（月報）補正発行検索.
 */
public class JigyoJokyoHokokuHoseiKensaku {

    private static final RString 更新 = new RString("更新");
    private static final RString 削除 = new RString("削除");
    private static final RString 画面の様式種類_1 = new RString("様式1-2");
    private static final RString 画面の様式種類_2 = new RString("様式1-5");
    private static final RString 画面の様式種類_3 = new RString("様式2");
    private static final RString 画面の様式種類_4 = new RString("様式2-5");
    private static final RString 画面の様式種類_5 = new RString("様式1-4");
    private static final RString 画面の様式種類_6 = new RString("様式2-7");
    private static final RString 画面の様式種類_7 = new RString("様式1別紙");
    private static final RString 画面の様式種類_8 = new RString("様式1");

    /**
     * 画面初期化処理です。
     *
     * @param div div
     * @return ResponseData<JigyoJokyoHokokuHoseiKensakuDiv>
     */
    public ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> onLoad(JigyoJokyoHokokuHoseiKensakuDiv div) {
        JigyoHokokuGeppoParameter entity = ViewStateHolder.get(ViewStateKeys.事業報告明細,
                JigyoHokokuGeppoParameter.class);
        if ((null != entity) && (!div.getTaishokensaku().getDdlShichoson().getDataSource().isEmpty())) {
            div.getTaishokensaku().getDdlShichoson().setSelectedKey(entity.get選択した市町村コード());
            div.getTaishokensaku().getTxtHokokuYM().setValue(new FlexibleDate(entity.get報告年月()));
            ViewStateHolder.clear();
        } else {
            init初期状態(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索する取得処理。
     *
     * @param div div
     * @return ResponseData<JigyoJokyoHokokuHoseiKensakuDiv>
     */
    public ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> onClick_btnSearch(JigyoJokyoHokokuHoseiKensakuDiv div) {
        JigyoJokyoHokokuHoseiKensakuHandler handler = getHandler(div);
        FlexibleYear 報告年 = new FlexibleYear(div.getTaishokensaku().getTxtHokokuYM().getValue().seireki().getYear());
        RString 報告月 = div.getTaishokensaku().getTxtHokokuYM().getValue().seireki().getMonth();
        LasdecCode 市町村コード = null;
        RString 市町村名称 = null;
        if (!div.getTaishokensaku().getDdlShichoson().getSelectedValue().isEmpty()) {
            List<RString> 市町村 = div.getTaishokensaku().getDdlShichoson().getSelectedValue()
                    .split(RString.HALF_SPACE.toString());
            市町村コード = new LasdecCode(市町村.get(0));
            市町村名称 = 市町村.get(1);
        }
        JigyoHokokuGeppoSearchParameter jigyoHokokuGeppoParameter = JigyoHokokuGeppoSearchParameter.
                createParameterForJigyoHokokuGeppo(報告年,
                        報告月, 市町村コード, 市町村名称, TokeiTaishoKubun.保険者分.getコード());
        JigyoHokokuGeppoHoseiHako result = JigyoHokokuGeppoHoseiHako.createInstance();
        List<JigyoHokokuGeppoHoseiHakoResult> businessList = result.getJigyoHokokuGeppoList(jigyoHokokuGeppoParameter);
        handler.initializeDgList(businessList);
        return ResponseData.of(div).respond();
    }

    /**
     * 条件をクリアする取得処理。
     *
     * @param div div
     * @return ResponseData<JigyoJokyoHokokuHoseiKensakuDiv>
     */
    public ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> onClick_btnClear(JigyoJokyoHokokuHoseiKensakuDiv div) {
        init初期状態(div);
        if (null != div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki()) {
            div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getDataSource().clear();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 修正ボタン処理。
     *
     * @param div div
     * @return ResponseData<JigyoJokyoHokokuHoseiKensakuDiv>
     */
    public ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> onClick_dgList_modify(JigyoJokyoHokokuHoseiKensakuDiv div) {
        return 様式種類(div, 更新);
    }

    /**
     * 削除ボタン処理。
     *
     * @param div div
     * @return ResponseData<JigyoJokyoHokokuHoseiKensakuDiv>
     */
    public ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> onClick_dgList_delete(JigyoJokyoHokokuHoseiKensakuDiv div) {
        return 様式種類(div, 削除);
    }

    private ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> 様式種類(JigyoJokyoHokokuHoseiKensakuDiv div,
            RString 状態) {
        dgHoseitaishoYoshiki_Row row = div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getClickedItem();
        RString 画面モード_1 = getHandler(div).画面1の様式種類(row.getHdnYoshikiCode());
        if (画面の様式種類_1.equals(画面モード_1)) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式1-2"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式1-2"));
            }
        }

        RString 画面モード_2 = getHandler(div).画面2の様式種類(row.getHdnYoshikiCode());
        RString 画面モード_2_1 = getHandler(div).画面2の様式種類の1(row.getHdnYoshikiCode());
        if (画面の様式種類_2.equals(画面モード_2) || 画面の様式種類_2.equals(画面モード_2_1)) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式1-5"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式1-5"));

            }
        }

        RString 画面モード_3 = getHandler(div).画面3の様式種類(row.getHdnYoshikiCode());
        RString 画面モード_3_1 = getHandler(div).画面3の様式種類の1(row.getHdnYoshikiCode());
        if (画面の様式種類_3.equals(画面モード_3) || 画面の様式種類_3.equals(画面モード_3_1)) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式2"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式2"));
            }
        }

        RString 画面モード_4 = getHandler(div).画面4の様式種類(row.getHdnYoshikiCode());
        if (画面の様式種類_4.equals(画面モード_4)) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式2-5"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式2-5"));
            }
        }

        RString 画面モード_5 = getHandler(div).画面5の様式種類(row.getHdnYoshikiCode());
        if (画面の様式種類_5.equals(画面モード_5)) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式1-4"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式1-4"));
            }
        }
        if (画面の様式種類_6.equals(画面モード_5)) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式2-7"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式2-7"));
            }
        }
        if (画面の様式種類_7.equals(画面モード_5)) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式1別紙"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式1別紙"));
            }
        }
        if (画面の様式種類_8.equals(画面モード_5)) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式1"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式1"));
            }
        }
        return ResponseData.of(div).respond();
    }

    private void init初期状態(JigyoJokyoHokokuHoseiKensakuDiv div) throws ApplicationException {
        div.getTaishokensaku().getTxtHokokuYM().setValue(FlexibleDate.getNowDate());
        JigyoJokyoHokokuHoseiKensakuHandler handler = getHandler(div);
        JigyoHokokuGeppoHoseiHako result = new JigyoHokokuGeppoHoseiHako();
        List<ShichosonCodeNameResult> 市町村List = result.getShichosonCodeNameList();
        if (市町村List == null || 市町村List.isEmpty()) {
            div.getTaishokensaku().getDdlShichoson().setDisplayNone(true);
            throw new ApplicationException(DbaErrorMessages.広域構成市町村からの補正処理.getMessage());
        }
        List<KeyValueDataSource> shichosonList = new ArrayList<>();
        if (市町村List.size() > 1) {
            shichosonList.add(new KeyValueDataSource(new RString("key0"), new RString("")));
            div.getTaishokensaku().getDdlShichoson().setDataSource(shichosonList);
        }
        for (ShichosonCodeNameResult shichosonCodeNameResult : 市町村List) {
            shichosonList.add(setDdlShichoson(shichosonCodeNameResult));
        }
        getHandler(div).set市町村情報(shichosonList);
        List<JigyoHokokuGeppoHoseiHakoResult> 事業報告集計一覧データリスト = new ArrayList<>();
        handler.initializeDgList(事業報告集計一覧データリスト);
    }

    private KeyValueDataSource setDdlShichoson(ShichosonCodeNameResult shichosonCodeNameResult) {
        RString 市町村 = new RString(
                shichosonCodeNameResult.get市町村コード().toString()
                + RString.HALF_SPACE
                + shichosonCodeNameResult.get市町村名称());
        return new KeyValueDataSource(市町村, 市町村);
    }

    private JigyoJokyoHokokuHoseiKensakuHandler getHandler(JigyoJokyoHokokuHoseiKensakuDiv div) {
        return JigyoJokyoHokokuHoseiKensakuHandler.of(div);
    }

}
