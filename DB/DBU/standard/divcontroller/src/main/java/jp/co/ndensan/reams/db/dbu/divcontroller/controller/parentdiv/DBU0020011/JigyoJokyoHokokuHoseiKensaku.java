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
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHakoEntity;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyohokokuGeppoHoseiHyoji;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
        JigyoHokokuGeppoSearchParameter parameter = ViewStateHolder.get(ViewStateKeys.事業報告基本, JigyoHokokuGeppoSearchParameter.class);
        if ((null != parameter) && (!div.getTaishokensaku().getDdlShichoson().getDataSource().isEmpty())) {
            div.getTaishokensaku().getDdlShichoson().setSelectedKey(parameter.get市町村コード().value());
            div.getTaishokensaku().getTxtHokokuYM().setValue(new FlexibleDate(Integer.parseInt(parameter.get報告年().toString()), RDate.getNowDate().getMonthValue(), RDate.getNowDate().getDayValue()));
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
        // TODO 「ビジネス設計_DBUMN91003_事業報告（月報）補正発行.xlsx」の「事業報告集計一覧データの取得」
//        JigyoJokyoHokokuHoseiKensakuHandler handler = getHandler(div);
//        JigyoHokokuGeppoSearchParameter jigyoHokokuGeppoParameter = ViewStateHolder.get(ViewStateKeys.事業報告基本, JigyoHokokuGeppoSearchParameter.class);
//        List<JigyoHokokuGeppoHoseiHakoResult> businessList = new ArrayList<>();
//        JigyoHokokuGeppoHoseiHako result = new JigyoHokokuGeppoHoseiHako();
//        businessList = result.getJigyoHokokuGeppoList(jigyoHokokuGeppoParameter);
//        handler.initializeDgList(businessList);
        JigyoJokyoHokokuHoseiKensakuHandler handler = getHandler(div);
        List<JigyoHokokuGeppoHoseiHakoResult> businessList = new ArrayList<>();
        JigyoHokokuGeppoHoseiHakoEntity entity = new JigyoHokokuGeppoHoseiHakoEntity(new DbT7021JigyoHokokuTokeiDataEntity(), new RString(""), new RString(""));
        entity.getEntity().setHokokuYSeireki(new FlexibleYear("2016"));
        entity.getEntity().setHokokuM(new RString ("22"));
        entity.getEntity().setShukeiTaishoYSeireki(new FlexibleYear("2015"));
        entity.getEntity().setShukeiTaishoM(new RString ("33"));
        entity.getEntity().setShichosonCode(new LasdecCode("001001"));
        entity.setYoshiCode(new RString("002"));
        entity.getEntity().setToukeiTaishoKubun(new RString("123123"));
        JigyoHokokuGeppoHoseiHakoResult res1 = new JigyoHokokuGeppoHoseiHakoResult(entity);
        businessList.add(res1);
        handler.initializeDgList(businessList);
        return ResponseData.of(div).respond();
    }
    
    
   /**
     * 条件をクリアする取得処理。
     * 
     * @param div
     * @return
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
     * 修正ボタン。
     * 
     * @param div
     * @return 
     */
     public ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> onClick_dgList_modify(JigyoJokyoHokokuHoseiKensakuDiv div) {
         // TODO 
        dgHoseitaishoYoshiki_Row row = div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getClickedItem();
        if ((JigyohokokuGeppoHoseiHyoji.保険者_第１号被保険者数_第１号被保険者増減内訳.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_第１号被保険者数_第１号被保険者増減内訳.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_第１号被保険者数_第１号被保険者増減内訳.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(更新);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式1"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_総括.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(更新);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式1-2"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_利用者負担第４段階食費_居住費の特例減額措置.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担第４段階食費_居住費の特例減額措置.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担第４段階食費_居住費の特例減額措置.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(更新);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式1-4"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_要介護_要支援_認定者数.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_要介護_要支援_認定者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_要介護_要支援_認定者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(更新);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式1-5"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者__別紙_第１号被保険者のいる世帯.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村__別紙_第１号被保険者のいる世帯.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村__別紙_第１号被保険者のいる世帯.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(更新);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式1別紙"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付1総数.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(更新);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式2"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費1総数.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(更新);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式2-5"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_高額介護_介護予防_サービス費.getコード()).equals(row.getHdnYoshikiCode())
            || JigyohokokuGeppoHoseiHyoji.保険者_高額医療合算介護_介護予防_サービス費.getコード().equals(row.getHdnYoshikiCode())
            || JigyohokokuGeppoHoseiHyoji.構成市町村_高額介護_介護予防_サービス費.getコード().equals(row.getHdnYoshikiCode())
            || JigyohokokuGeppoHoseiHyoji.構成市町村_高額医療合算介護_介護予防_サービス費.getコード().equals(row.getHdnYoshikiCode())
            || JigyohokokuGeppoHoseiHyoji.旧市町村_高額介護_介護予防_サービス費.getコード().equals(row.getHdnYoshikiCode())
            || JigyohokokuGeppoHoseiHyoji.旧市町村_高額医療合算介護_介護予防_サービス費.getコード().equals(row.getHdnYoshikiCode())) {
        getHandler(div).putViewStateHolder(更新);
        return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式2-7"));
    }
        return ResponseData.of(div).respond();
    }

    /**
     * 削除ボタン。
     * 
     * @param div
     * @return 
     */
     public ResponseData<JigyoJokyoHokokuHoseiKensakuDiv> onClick_dgList_delete(JigyoJokyoHokokuHoseiKensakuDiv div) {
         dgHoseitaishoYoshiki_Row row = div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getClickedItem();
        if ((JigyohokokuGeppoHoseiHyoji.保険者_第１号被保険者数_第１号被保険者増減内訳.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_第１号被保険者数_第１号被保険者増減内訳.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_第１号被保険者数_第１号被保険者増減内訳.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(削除);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式1"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_総括.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(削除);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式1-2"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_利用者負担第４段階食費_居住費の特例減額措置.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担第４段階食費_居住費の特例減額措置.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担第４段階食費_居住費の特例減額措置.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(削除);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式1-4"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_要介護_要支援_認定者数.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_要介護_要支援_認定者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_要介護_要支援_認定者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__施設介護サービス受給者数.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(削除);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式1-5"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者__別紙_第１号被保険者のいる世帯.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村__別紙_第１号被保険者のいる世帯.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村__別紙_第１号被保険者のいる世帯.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(削除);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式1別紙"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付1総数.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付3総数特例分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(削除);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式2"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費1総数.getコード()).equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード().equals(row.getHdnYoshikiCode())
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード().equals(row.getHdnYoshikiCode())) {
            getHandler(div).putViewStateHolder(削除);
            return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式2-5"));
        }
        if ((JigyohokokuGeppoHoseiHyoji.保険者_高額介護_介護予防_サービス費.getコード()).equals(row.getHdnYoshikiCode())
            || JigyohokokuGeppoHoseiHyoji.保険者_高額医療合算介護_介護予防_サービス費.getコード().equals(row.getHdnYoshikiCode())
            || JigyohokokuGeppoHoseiHyoji.構成市町村_高額介護_介護予防_サービス費.getコード().equals(row.getHdnYoshikiCode())
            || JigyohokokuGeppoHoseiHyoji.構成市町村_高額医療合算介護_介護予防_サービス費.getコード().equals(row.getHdnYoshikiCode())
            || JigyohokokuGeppoHoseiHyoji.旧市町村_高額介護_介護予防_サービス費.getコード().equals(row.getHdnYoshikiCode())
            || JigyohokokuGeppoHoseiHyoji.旧市町村_高額医療合算介護_介護予防_サービス費.getコード().equals(row.getHdnYoshikiCode())) {
        getHandler(div).putViewStateHolder(削除);
        return ResponseData.of(div).forwardWithEventName(DBU0020011TransitionEventName.補正発行修正).parameter(new RString("様式2-7"));
    }
        return ResponseData.of(div).respond();
    }

    
     private void init初期状態(JigyoJokyoHokokuHoseiKensakuDiv div) {
        JigyoJokyoHokokuHoseiKensakuHandler handler = getHandler(div);
        // TODO 「ビジネス設計_DBUMN91003_事業報告（月報）補正発行.xlsx」の「市町村のリスト取得」
//        JigyoHokokuGeppoHoseiHako result = new JigyoHokokuGeppoHoseiHako();
//        List<ShichosonCodeNameResult> 市町村List = result.getShichosonCodeNameList();
//        if(市町村List == null || 市町村List.isEmpty()) {
//            // TODO
//            div.getTaishokensaku().getDdlShichoson().setVisible(false);
//            throw new ApplicationException(DbaErrorMessages.該当資格異動情報なし.getMessage().replace("広域構成市町村からの補正処理は行えません。"));
//        }
//        List<KeyValueDataSource> shichosonList = new ArrayList<>();
//        for (ShichosonCodeNameResult shichosonCodeNameResult : 市町村List) {
//            shichosonList.add(setDdlShichoson(shichosonCodeNameResult));
//        }
//        getHandler(div).set市町村情報(shichosonList);
        RString 市町村コード = new RString("100001");
        RString 市町村名称 = new RString("100001 市町村名称1");
        RString 保険者コード = new RString("1010");
        RString 保険者区分 = new RString("保険者区分");
        List<KeyValueDataSource> sources = new ArrayList<>();
        List<RString> list = new ArrayList<>();
        list.add(市町村名称);
        if (list.isEmpty()) {
            div.getTaishokensaku().getDdlShichoson().setVisible(false);
//            throw new ApplicationException(DbaErrorMessages.該当資格異動情報なし.getMessage().replace("広域構成市町村からの補正処理は行えません。"));
        }
        sources.add(new KeyValueDataSource(市町村コード, 市町村名称));
        div.getTaishokensaku().getDdlShichoson().setDataSource(sources);
        div.getTaishokensaku().getDdlShichoson().setSelectedKey(市町村コード);
		
        List<JigyoHokokuGeppoHoseiHakoResult> 事業報告集計一覧データリスト = new ArrayList<>();
        handler.initializeDgList(事業報告集計一覧データリスト);
    }

     private KeyValueDataSource setDdlShichoson(ShichosonCodeNameResult shichosonCodeNameResult) {
        RString 市町村コード = new RString(
                shichosonCodeNameResult.get市町村コード().toString()
                + shichosonCodeNameResult.get保険者区分()
                + shichosonCodeNameResult.get保険者コード());
        return new KeyValueDataSource(市町村コード, shichosonCodeNameResult.get市町村名称());
    }
     
    private JigyoJokyoHokokuHoseiKensakuHandler getHandler(JigyoJokyoHokokuHoseiKensakuDiv div) {
        return JigyoJokyoHokokuHoseiKensakuHandler.of(div);
    }
    
}
