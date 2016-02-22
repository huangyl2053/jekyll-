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
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyohokokuGeppoHoseiHyoji;
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

    /**
     * 画面初期化処理です。
     *
     * @param div
     * @return ResponseData<JigyoJokyoHokokuHoseiKensakuDiv>
     */
    public ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> onLoad(JigyoJokyoHokokuHoseiKensakuDiv div) {
        init初期状態(div);
        JigyoHokokuGeppoParameter entity = ViewStateHolder.get(ViewStateKeys.事業報告基本,
                JigyoHokokuGeppoParameter.class);
        if ((null != entity) && (!div.getTaishokensaku().getDdlShichoson().getDataSource().isEmpty())) {
            div.getTaishokensaku().getDdlShichoson().setSelectedKey(entity.get選択した市町村コード());
            div.getTaishokensaku().getTxtHokokuYM().setValue(new FlexibleDate(entity.get報告年月()));
            ViewStateHolder.clear();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索する取得処理。
     *
     * @param div
     * @return ResponseData<JigyoJokyoHokokuHoseiKensakuDiv>
     */
    public ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> onClick_btnSearch(JigyoJokyoHokokuHoseiKensakuDiv div) {
        JigyoJokyoHokokuHoseiKensakuHandler handler = getHandler(div);
        FlexibleYear 報告年 = new FlexibleYear(div.getTaishokensaku().getTxtHokokuYM().getValue().seireki().getYear());
        RString 報告月 = div.getTaishokensaku().getTxtHokokuYM().getValue().seireki().getMonth();
        String[] 市町村 = div.getTaishokensaku().getDdlShichoson().getSelectedValue().toString()
                .split(RString.HALF_SPACE.toString());
        LasdecCode 市町村コード = new LasdecCode(市町村[0]);
        RString 市町村名称 = new RString(市町村[1]);
        JigyoHokokuGeppoSearchParameter jigyoHokokuGeppoParameter = JigyoHokokuGeppoSearchParameter.
                createParameterForJigyoHokokuGeppo(報告年,
                        報告月, 市町村コード, 市町村名称, TokeiTaishoKubun.保険者分.getコード());
        JigyoHokokuGeppoHoseiHako result = new JigyoHokokuGeppoHoseiHako();
        List<JigyoHokokuGeppoHoseiHakoResult> businessList = result.getJigyoHokokuGeppoList(jigyoHokokuGeppoParameter);
        handler.initializeDgList(businessList);
        return ResponseData.of(div).respond();
    }

    /**
     * 条件をクリアする取得処理。
     *
     * @param div
     * @return ResponseData<JigyoJokyoHokokuHoseiKensakuDiv>
     */
    public ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> onClick_btnClear(JigyoJokyoHokokuHoseiKensakuDiv div) {
        div.getTaishokensaku().getDdlShichoson().setSelectedKey(RString.EMPTY);
        init初期状態(div);
        if (null != div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki()) {
            div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getDataSource().clear();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 修正ボタン処理。
     *
     * @param div
     * @return ResponseData<JigyoJokyoHokokuHoseiKensakuDiv>
     */
    public ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> onClick_dgList_modify(JigyoJokyoHokokuHoseiKensakuDiv div) {
        return 様式種類(div, 更新);
    }

    /**
     * 削除ボタン処理。
     *
     * @param div
     * @return ResponseData<JigyoJokyoHokokuHoseiKensakuDiv>
     */
    public ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> onClick_dgList_delete(JigyoJokyoHokokuHoseiKensakuDiv div) {
        return 様式種類(div, 削除);
    }

    private ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> 様式種類(JigyoJokyoHokokuHoseiKensakuDiv div, RString 状態) {
        dgHoseitaishoYoshiki_Row row = div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getClickedItem();
        if ((JigyohokokuGeppoHoseiHyoji.保険者_第１号被保険者数_第１号被保険者増減内訳.getコード())
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_第１号被保険者数_第１号被保険者増減内訳.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_第１号被保険者数_第１号被保険者増減内訳.getコード()
                .equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式1"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式1"));
            }
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_総括.getコード())
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_総括.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_再掲_第２号分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_総括.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_総括.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_再掲_第２号分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_総括.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_総括.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_再掲_第２号分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード()
                .equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式1-2"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式1-2"));
            }
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード())
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_利用者負担第４段階食費_居住費の特例減額措置.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担第４段階食費_居住費の特例減額措置.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担第４段階食費_居住費の特例減額措置.getコード()
                .equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式1-4"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式1-4"));
            }
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_要介護_要支援_認定者数.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_居宅介護_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_地域密着型_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_施設介護サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__施設介護サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__施設介護サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_要介護_要支援_認定者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_居宅介護_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_地域密着型_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_施設介護サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__施設介護サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__施設介護サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_要介護_要支援_認定者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_居宅介護_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_地域密着型_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_施設介護サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__施設介護サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__施設介護サービス受給者数.getコード()
                .equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式1-5"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式1-5"));

            }
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者__別紙_第１号被保険者のいる世帯.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村__別紙_第１号被保険者のいる世帯.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村__別紙_第１号被保険者のいる世帯.getコード()
                .equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式1別紙"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式1別紙"));
            }
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付1総数.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付3総数特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付3総数特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付3総数特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付3総数特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付3総数特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付3総数特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付3総数特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付3総数特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付3総数特例分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式2"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式2"));
            }
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費1総数.getコード())
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式2-5"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式2-5"));
            }
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_高額介護_介護予防_サービス費.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_高額医療合算介護_介護予防_サービス費.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_高額介護_介護予防_サービス費.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_高額医療合算介護_介護予防_サービス費.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_高額介護_介護予防_サービス費.getコード()
                .equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_高額医療合算介護_介護予防_サービス費.getコード()
                .equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(状態);
            if (更新.equals(状態)) {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正)
                        .parameter(new RString("様式2-7"));
            } else {
                return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行削除)
                        .parameter(new RString("様式2-7"));
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
