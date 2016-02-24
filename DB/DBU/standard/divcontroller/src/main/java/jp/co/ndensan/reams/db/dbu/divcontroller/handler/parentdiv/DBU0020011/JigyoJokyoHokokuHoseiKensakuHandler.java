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
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyohokokuGeppoHoseiHyoji;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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

    public static JigyoJokyoHokokuHoseiKensakuHandler of(JigyoJokyoHokokuHoseiKensakuDiv div) {
        return new JigyoJokyoHokokuHoseiKensakuHandler(div);
    }

    /**
     * 遷移先画面を取得します。
     *
     * @param 市町村情報リスト 市町村情報リスト
     */
    public void set市町村情報(List<KeyValueDataSource> 市町村情報リスト) {
        div.getTaishokensaku().getDdlShichoson().setDataSource(市町村情報リスト);
        if (市町村情報リスト.size() > 1) {
            div.getTaishokensaku().getDdlShichoson().setSelectedIndex(1);
        } else if (市町村情報リスト.size() == 1) {
            div.getTaishokensaku().getDdlShichoson().setSelectedIndex(0);
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
            RString 様式種類 = JigyohokokuGeppoHoseiHyoji.toValue(様式コード).get名称();
            row.setTxtToukeiTaishoKubun(様式種類);
            lists.add(row);
        }
        div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().setDataSource(lists);
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
            parameter.set保険者コード(TokeiTaishoKubun.保険者分.getコード());
        }
        ViewStateHolder.put(ViewStateKeys.事業報告基本, parameter);
        ViewStateHolder.put(ViewStateKeys.状態, 状態);
    }

}
