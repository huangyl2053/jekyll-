/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0020011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHakoResult;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020011.JigyoJokyoHokokuHoseiKensakuDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020011.dgHoseitaishoYoshiki_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.JigyoHokokuGeppoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyohokokuGeppoHoseiHyoji;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 事業報告（月報）補正発行検索.
 */
public class JigyoJokyoHokokuHoseiKensakuHandler {
    
    private final JigyoJokyoHokokuHoseiKensakuDiv div;
    
    private JigyoJokyoHokokuHoseiKensakuHandler(JigyoJokyoHokokuHoseiKensakuDiv div) {
        this.div = div;
    }

    /**
     *
     * @param div
     * @return JigyoJokyoHokokuHoseiKensakuHandler
     */
    public static JigyoJokyoHokokuHoseiKensakuHandler of(JigyoJokyoHokokuHoseiKensakuDiv div) {
        return new JigyoJokyoHokokuHoseiKensakuHandler(div);
    }

    public void disabledJigyoHokokuGeppo() {
        div.setDisabled(true);
    }

    /**
     * 遷移先画面を取得します。
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
    
    public void initializeDgList(List<JigyoHokokuGeppoHoseiHakoResult> businessList) {
        List<dgHoseitaishoYoshiki_Row> lists = new ArrayList<>();
         for (JigyoHokokuGeppoHoseiHakoResult result : businessList) {
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
            row.setHdnYoshikiCode(result.get様式コード());
            RString 様式コード = result.get様式コード();
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
        else if("002".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_総括.get名称();
        }
        else if("003".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_再掲_第２号分.get名称();
        }
        else if("004".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_総括.get名称();
        }
        else if("005".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_再掲_第２号分.get名称();
        }
        else if("006".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括.get名称();
        }
        else if("007".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.get名称();
        }
        else if("008".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.get名称();
        }
        else if("009".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_利用者負担第４段階食費_居住費の特例減額措置.get名称();
        }
        else if("010".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_要介護_要支援_認定者数.get名称();
        }
        else if("011".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_居宅介護_介護予防_サービス受給者数.get名称();
        }
        else if("012".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数.get名称();
        }
        else if("013".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数.get名称();
        }
        else if("014".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_地域密着型_介護予防_サービス受給者数.get名称();
        }
        else if("015".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数.get名称();
        }
        else if("016".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数.get名称();
        }
        else if("017".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_施設介護サービス受給者数.get名称();
        }
        else if("018".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__施設介護サービス受給者数.get名称();
        }
        else if("019".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__施設介護サービス受給者数.get名称();
        }
        else if("020".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者__別紙_第１号被保険者のいる世帯.get名称();
        }
        else if("021".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付1総数.get名称();
        }
        else if("022".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        else if("023".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付3総数特例分.get名称();
        }
        else if("024".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        else if("025".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付1総数.get名称();
        }
        else if("026".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        else if("027".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付3総数特例分.get名称();
        }
        else if("028".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        else if("029".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付1総数.get名称();
        }
        else if("030".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        else if("031".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付3総数特例分.get名称();
        }
        else if("032".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        else if("033".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        else if("034".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        else if("035".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        else if("036".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        else if("037".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        else if("038".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        else if("039".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_高額介護_介護予防_サービス費.get名称();
        }
        else if("040".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.保険者_高額医療合算介護_介護予防_サービス費.get名称();
        }
        else if("101".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_第１号被保険者数_第１号被保険者増減内訳.get名称();
        }
        else if("102".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_総括.get名称();
        }
        else if("103".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.get名称();
        }
        else if("104".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_総括.get名称();
        }
        else if("105".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_再掲_第２号分.get名称();
        }
        else if("106".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.get名称();
        }
        else if("107".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.get名称();
        }
        else if("108".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.get名称();
        }
        else if("109".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担第４段階食費_居住費の特例減額措置.get名称();
        }
        else if("110".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_要介護_要支援_認定者数.get名称();
        }
        else if("111".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_居宅介護_介護予防_サービス受給者数.get名称();
        }
        else if("112".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.get名称();
        }
        else if("113".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.get名称();
        }
        else if("114".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_地域密着型_介護予防_サービス受給者数.get名称();
        }
        else if("115".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.get名称();
        }
        else if("116".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.get名称();
        }
        else if("117".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_施設介護サービス受給者数.get名称();
        }
        else if("118".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__施設介護サービス受給者数.get名称();
        }
        else if("119".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__施設介護サービス受給者数.get名称();
        }
        else if("120".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村__別紙_第１号被保険者のいる世帯.get名称();
        }
        else if("121".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付1総数.get名称();
        }
        else if("122".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        else if("123".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付3総数特例分.get名称();
        }
        else if("124".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        else if("125".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付1総数.get名称();
        }
        else if("126".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        else if("127".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付3総数特例分.get名称();
        }
        else if("128".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        else if("129".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付1総数.get名称();
        }
        else if("130".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        else if("131".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付3総数特例分.get名称();
        }
        else if("132".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        else if("133".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        else if("134".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        else if("135".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        else if("136".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        else if("137".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        else if("138".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        else if("139".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_高額介護_介護予防_サービス費.get名称();
        }
        else if("140".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.構成市町村_高額医療合算介護_介護予防_サービス費.get名称();
        }
        else if("201".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_第１号被保険者数_第１号被保険者増減内訳.get名称();
        }
        else if("202".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_総括.get名称();
        }
        else if("203".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.get名称();
        }
        else if("204".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_総括.get名称();
        }
        else if("205".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_再掲_第２号分.get名称();
        }
        else if("206".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.get名称();
        }
        else if("207".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.get名称();
        }
        else if("208".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.get名称();
        }
        else if("209".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担第４段階食費_居住費の特例減額措置.get名称();
        }
        else if("210".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_要介護_要支援_認定者数.get名称();
        }
        else if("211".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_居宅介護_介護予防_サービス受給者数.get名称();
        }
        else if("212".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.get名称();
        }
        else if("213".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.get名称();
        }
        else if("214".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_地域密着型_介護予防_サービス受給者数.get名称();
        }
        else if("215".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.get名称();
        }
        else if("216".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.get名称();
        }
        else if("217".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_施設介護サービス受給者数.get名称();
        }
        else if("218".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__施設介護サービス受給者数.get名称();
        }
        else if("219".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__施設介護サービス受給者数.get名称();
        }
        else if("220".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村__別紙_第１号被保険者のいる世帯.get名称();
        }
        else if("221".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付1総数.get名称();
        }
        else if("222".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        else if("223".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付3総数特例分.get名称();
        }
        else if("224".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        else if("225".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付1総数.get名称();
        }
        else if("226".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        else if("227".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付3総数特例分.get名称();
        }
        else if("228".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        else if("229".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付1総数.get名称();
        }
        else if("230".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.get名称();
        }
        else if("231".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付3総数特例分.get名称();
        }
        else if("232".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.get名称();
        }
        else if("233".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        else if("234".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        else if("235".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        else if("236".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        else if("237".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.get名称();
        }
        else if("238".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.get名称();
        }
        else if("239".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_高額介護_介護予防_サービス費.get名称();
        }
        else if("240".equals(様式コード)) {
            様式種類 = JigyohokokuGeppoHoseiHyoji.旧市町村_高額医療合算介護_介護予防_サービス費.get名称();
        }
         
        return 様式種類;
    }
    
    public void putViewStateHolder(RString 状態) {
        dgHoseitaishoYoshiki_Row row = div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getClickedItem();
        JigyoHokokuGeppoParameter parameter = new JigyoHokokuGeppoParameter();
        parameter.set行報告年(new RString(row.getTxtHokokuYM().toString().substring(0, 4)));
        parameter.set行報告月(new RString(row.getTxtHokokuYM().toString().substring(4, 6)));
        parameter.set行集計対象年(new RString(row.getTxtShukeiTaishoYM().toString().substring(0, 4)));
        parameter.set行集計対象月(new RString(row.getTxtShukeiTaishoYM().toString().substring(4, 6)));
        parameter.set行統計対象区分(row.getHdnTokeiTaishoKubun());
        parameter.set行市町村コード(row.getTxtShichosonCode());
        parameter.set行表番号(row.getHdnHyoNo());
        parameter.set行集計番号(row.getHdnShukeiNo());
        parameter.set報告年月(div.getTaishokensaku().getTxtHokokuYM().getText());
        parameter.set集計年月(row.getTxtShukeiTaishoYM().getText());
        parameter.set行様式種類コード(row.getHdnYoshikiCode());
        parameter.set市町村名称(div.getTaishokensaku().getDdlShichoson().getSelectedValue());
        parameter.set選択した市町村コード(div.getTaishokensaku().getDdlShichoson().getSelectedKey());
        if (div.getTaishokensaku().getDdlShichoson().getSelectedKey().isEmpty()) {
            parameter.set保険者コード(RString.EMPTY);
        } else {
            // TODO
//            parameter.set保険者コード(div.getTaishokensaku().getDdlShichoson().getSelectedKey().substring(7));
            parameter.set保険者コード(new RString("8888"));
        }
        
//        JigyoHokokuGeppoParameter parameter = new JigyoHokokuGeppoParameter(new FlexibleYear(hokokuYSeireki), hokokuM, new FlexibleYear(shukeiTaishoYSeireki), shukeiTaishoM,
//                row.getHdnTokeiTaishoKubun(),  new LasdecCode(row.getTxtShichosonCode()), new Code(row.getHdnHyoNo()), new Code(row.getHdnShukeiNo()),
//                div.getTaishokensaku().getTxtHokokuYM(), row.getTxtShukeiTaishoYM(), div.getTaishokensaku().getDdlShichoson().getSelectedValue(),
//                div.getTaishokensaku().getDdlShichoson().getSelectedKey().split("-").get(2), row.getHdnYoshikiCode());
        ViewStateHolder.put(ViewStateKeys.事業報告基本, parameter);
        ViewStateHolder.put(ViewStateKeys.状態, 状態);
     }
    
}
