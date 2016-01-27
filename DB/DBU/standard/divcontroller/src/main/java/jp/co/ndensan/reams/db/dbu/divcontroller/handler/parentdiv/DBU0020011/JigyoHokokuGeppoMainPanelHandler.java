/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokugeppo.JigyoHokokuGeppoResult;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020011.JigyoHokokuGeppoMainPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020011.dgHoseitaishoYoshiki_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoHoseiHako;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyohokokuGeppoHoseiHyoji;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author huangyanan
 */
public class JigyoHokokuGeppoMainPanelHandler {
    
    private final JigyoHokokuGeppoMainPanelDiv div;

    private JigyoHokokuGeppoMainPanelHandler(JigyoHokokuGeppoMainPanelDiv div) {
        this.div = div;
}

    /**
     *
     * @param div
     * @return
     */
    public static JigyoHokokuGeppoMainPanelHandler of(JigyoHokokuGeppoMainPanelDiv div) {
        return new JigyoHokokuGeppoMainPanelHandler(div);
    }

//    public JigyoHokokuGeppoParameter createParameter() {
//        return JigyoHokokuGeppoParameter.createParameter( null, null, null, null);
//}
    
    /**
     * 遷移先画面を取得します。
     *
     *
     * @param 市町村情報リスト 市町村情報リスト
     */
    public void set市町村情報(List<KeyValueDataSource> 市町村情報リスト) {
        div.getTaishokensaku().getDdlShichoson().setDataSource(市町村情報リスト);
        if (1 < 市町村情報リスト.size()) {
            div.getTaishokensaku().getDdlShichoson().setIsBlankLine(true);
        } else if (市町村情報リスト.size() == 1) {
            div.getTaishokensaku().getDdlShichoson().setDisplayNone(true);
            div.getTaishokensaku().getDdlShichoson().setSelectedIndex(1);
        }
    }

    /**
     * Gridデータの取得するメッソド
     *
     * @param businessList
     */
    public void initializeDgList(List<JigyoHokokuGeppoResult> businessList) {
        List<dgHoseitaishoYoshiki_Row> lists = new ArrayList<>();
        for (JigyoHokokuGeppoResult result : businessList) {
            dgHoseitaishoYoshiki_Row row = new dgHoseitaishoYoshiki_Row();
            RStringBuilder builder = new RStringBuilder();
            builder.append(result.get報告年().toDateString());
            builder.append(result.get報告月());
            row.getTxtHokokuYM().setValue(new FlexibleDate(builder.toRString()));
            RStringBuilder builder1 = new RStringBuilder();
            builder1.append(result.get集計対象年().toDateString());
            builder1.append(result.get集計対象月());
            row.getTxtShukeiTaishoYM().setValue(new FlexibleDate(builder1.toRString()));
            row.setTxtShichosonCode(result.get市町村コード().value());
            row.setHdnYoshikiCode(result.get様式コード().value());
            RString 様式コード = result.get様式コード().value();
            RString 様式種類 = get様式種類(様式コード);
            row.setTxtToukeiTaishoKubun(様式種類);
            lists.add(row);
        }
        div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().setDataSource(lists);
    }
    
    private RString get様式種類(RString 様式コード) {
        RString 様式種類 = RString.EMPTY;
        if("001".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_第１号被保険者数_第１号被保険者増減内訳.get名称();
        }
        if("002".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_総括.get名称();
        }
        if("003".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_再掲_第２号分.get名称();
        }
        if("004".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_総括.get名称();
        }
        if("005".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_再掲_第２号分.get名称();
        }
        if("006".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括.get名称();
        }
        if("007".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.get名称();
        }
        if("008".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.get名称();
        }
        if("009".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_利用者負担第４段階食費_居住費の特例減額措置.get名称();
        }
        if("010".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_要介護_要支援_認定者数.get名称();
        }
        if("011".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_居宅介護_介護予防_サービス受給者数.get名称();
        }
        if("012".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数.get名称();
        }
        if("013".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数.get名称();
        }
        if("014".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_地域密着型_介護予防_サービス受給者数.get名称();
        }
        if("015".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数.get名称();
        }
        if("016".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数.get名称();
        }
        if("017".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_施設介護サービス受給者数.get名称();
        }
        if("018".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__施設介護サービス受給者数.get名称();
        }
        if("019".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__施設介護サービス受給者数.get名称();
        }
        if("020".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者__別紙_第１号被保険者のいる世帯.get名称();
        }
        if("021".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付1総数.get名称();
        }
        if("022".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        if("023".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付3総数特例分.get名称();
        }
        if("024".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        if("025".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付1総数.get名称();
        }
        if("026".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        if("027".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付3総数特例分.get名称();
        }
        if("028".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        if("029".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付1総数.get名称();
        }
        if("030".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        if("031".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付3総数特例分.get名称();
        }
        if("032".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        if("033".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        if("034".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        if("035".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        if("036".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        if("037".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        if("038".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        if("039".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_高額介護_介護予防_サービス費.get名称();
        }
        if("040".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_高額医療合算介護_介護予防_サービス費.get名称();
        }
        if("101".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_第１号被保険者数_第１号被保険者増減内訳.get名称();
        }
        if("102".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_総括.get名称();
        }
        if("103".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.get名称();
        }
        if("104".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_総括.get名称();
        }
        if("105".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_再掲_第２号分.get名称();
        }
        if("106".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.get名称();
        }
        if("107".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.get名称();
        }
        if("108".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.get名称();
        }
        if("109".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担第４段階食費_居住費の特例減額措置.get名称();
        }
        if("110".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_要介護_要支援_認定者数.get名称();
        }
        if("111".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_居宅介護_介護予防_サービス受給者数.get名称();
        }
        if("112".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.get名称();
        }
        if("113".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.get名称();
        }
        if("114".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_地域密着型_介護予防_サービス受給者数.get名称();
        }
        if("115".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.get名称();
        }
        if("116".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.get名称();
        }
        if("117".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_施設介護サービス受給者数.get名称();
        }
        if("118".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__施設介護サービス受給者数.get名称();
        }
        if("119".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__施設介護サービス受給者数.get名称();
        }
        if("120".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村__別紙_第１号被保険者のいる世帯.get名称();
        }
        if("121".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付1総数.get名称();
        }
        if("122".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        if("123".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付3総数特例分.get名称();
        }
        if("124".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        if("125".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付1総数.get名称();
        }
        if("126".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        if("127".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付3総数特例分.get名称();
        }
        if("128".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        if("129".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付1総数.get名称();
        }
        if("130".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        if("131".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付3総数特例分.get名称();
        }
        if("132".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        if("133".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        if("134".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        if("135".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        if("136".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        if("137".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        if("138".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        if("139".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_高額介護_介護予防_サービス費.get名称();
        }
        if("140".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_高額医療合算介護_介護予防_サービス費.get名称();
        }
        if("201".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_第１号被保険者数_第１号被保険者増減内訳.get名称();
        }
        if("202".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_総括.get名称();
        }
        if("203".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.get名称();
        }
        if("204".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_総括.get名称();
        }
        if("205".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_再掲_第２号分.get名称();
        }
        if("206".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.get名称();
        }
        if("207".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.get名称();
        }
        if("208".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.get名称();
        }
        if("209".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担第４段階食費_居住費の特例減額措置.get名称();
        }
        if("210".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_要介護_要支援_認定者数.get名称();
        }
        if("211".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_居宅介護_介護予防_サービス受給者数.get名称();
        }
        if("212".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.get名称();
        }
        if("213".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.get名称();
        }
        if("214".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_地域密着型_介護予防_サービス受給者数.get名称();
        }
        if("215".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.get名称();
        }
        if("216".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.get名称();
        }
        if("217".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_施設介護サービス受給者数.get名称();
        }
        if("218".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__施設介護サービス受給者数.get名称();
        }
        if("219".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__施設介護サービス受給者数.get名称();
        }
        if("220".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村__別紙_第１号被保険者のいる世帯.get名称();
        }
        if("221".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付1総数.get名称();
        }
        if("222".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        if("223".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付3総数特例分.get名称();
        }
        if("224".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        if("225".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付1総数.get名称();
        }
        if("226".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        if("227".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付3総数特例分.get名称();
        }
        if("228".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        if("229".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付1総数.get名称();
        }
        if("230".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        if("231".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付3総数特例分.get名称();
        }
        if("232".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        if("233".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        if("234".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        if("235".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        if("236".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        if("237".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        if("238".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        if("239".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_高額介護_介護予防_サービス費.get名称();
        }
        if("240".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_高額医療合算介護_介護予防_サービス費.get名称();
        }
         
        return 様式種類;
    }

     public void putViewStateHolder(RString 状態) {
        dgHoseitaishoYoshiki_Row row = div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getClickedItem();
        JigyoHokokuGeppoHoseiHako parameter = new JigyoHokokuGeppoHoseiHako(row.getTxtHokokuYM().getValue().getYear(), row.getTxtHokokuYM().getText(),
                row.getTxtShukeiTaishoYM().getValue().getYear(), row.getTxtShukeiTaishoYM().getText(), row.getHdnTokeiTaishoKubun(), 
                new LasdecCode(row.getTxtShichosonCode()), new Code(row.getHdnHyoNo()), new Code(row.getHdnShukeiNo()),
                div.getTaishokensaku().getTxtHokokuYM(), row.getTxtShukeiTaishoYM(), div.getTaishokensaku().getDdlShichoson().getSelectedValue(), div.getTaishokensaku().getDdlShichoson().getSelectedKey().split("-").get(2), 
                row.getHdnYoshikiCode());
        ViewStateHolder.put(ViewStateKeys.事業報告基本, parameter);
        ViewStateHolder.put(ViewStateKeys.状態, 状態);
     }
 

}