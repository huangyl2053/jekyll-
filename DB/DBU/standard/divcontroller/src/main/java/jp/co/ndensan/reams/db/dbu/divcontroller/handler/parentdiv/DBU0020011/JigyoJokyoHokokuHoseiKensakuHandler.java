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
public final class JigyoJokyoHokokuHoseiKensakuHandler {

    private final JigyoJokyoHokokuHoseiKensakuDiv div;
    private static final int 設定_0 = 0;
    private static final int 設定_4 = 4;
    private static final int 設定_6 = 6;
    private static final RString 画面の様式種類_1 = new RString("様式1-2");
    private static final RString 画面の様式種類_2 = new RString("様式1-5");
    private static final RString 画面の様式種類_3 = new RString("様式2");
    private static final RString 画面の様式種類_4 = new RString("様式2-5");
    private static final RString 画面の様式種類_5 = new RString("様式1-4");
    private static final RString 画面の様式種類_6 = new RString("様式2-7");
    private static final RString 画面の様式種類_7 = new RString("様式1別紙");
    private static final RString 画面の様式種類_8 = new RString("様式1");

    private JigyoJokyoHokokuHoseiKensakuHandler(JigyoJokyoHokokuHoseiKensakuDiv div) {
        this.div = div;
    }

    /**
     * 事業報告
     *
     * @param div div
     * @return JigyoJokyoHokokuHoseiKensakuHandler
     */
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

    /**
     * 検索する取得処理
     *
     * @param businessList 検索List
     */
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

    /**
     * ParameterをViewStateに書き込みます。
     *
     * @param 状態 状態
     */
    public void putViewStateHolder(RString 状態) {
        dgHoseitaishoYoshiki_Row row = div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getClickedItem();
        JigyoHokokuGeppoParameter parameter = new JigyoHokokuGeppoParameter();
        parameter.set行報告年(new RString(row.getTxtHokokuYM().toString().substring(設定_0, 設定_4)));
        parameter.set行報告月(new RString(row.getTxtHokokuYM().toString().substring(設定_4, 設定_6)));
        parameter.set行集計対象年(new RString(row.getTxtShukeiTaishoYM().toString().substring(設定_0, 設定_4)));
        parameter.set行集計対象月(new RString(row.getTxtShukeiTaishoYM().toString().substring(設定_4, 設定_6)));
        parameter.set行統計対象区分(row.getHdnTokeiTaishoKubun());
        parameter.set行市町村コード(row.getTxtShichosonCode());
        parameter.set行表番号(row.getHdnHyoNo());
        parameter.set行集計番号(row.getHdnShukeiNo());
        parameter.set報告年月(div.getTaishokensaku().getTxtHokokuYM().getLabelLText());
        parameter.set集計年月(row.getTxtShukeiTaishoYM().getLabelLText());
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

    /**
     * 画面1の様式種類
     *
     * @param hdnYoshikiCode hdnYoshikiCode
     * @return 画面の様式種類_1
     */
    public RString 画面1の様式種類(RString hdnYoshikiCode) {
        if ((JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_総括.getコード())
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_総括.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_利用者負担減額_免除認定_再掲_第２号分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_総括.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_総括.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担減額_免除認定_再掲_第２号分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_総括.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費に係る負担限度額認定_再掲_第２号分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_総括.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担減額_免除認定_再掲_第２号分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_総括.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_介護老人福祉施設旧措置入所者減額_免除認定_再掲_第２号分.getコード()
                .equals(hdnYoshikiCode)) {
            return 画面の様式種類_1;
        }
        return null;
    }

    /**
     * 画面2の様式種類
     *
     * @param hdnYoshikiCode hdnYoshikiCode
     * @return 画面2の様式種類
     */
    public RString 画面2の様式種類(RString hdnYoshikiCode) {
        if ((JigyohokokuGeppoHoseiHyoji.保険者_要介護_要支援_認定者数.getコード()).equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_居宅介護_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_地域密着型_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_施設介護サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__施設介護サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__施設介護サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_要介護_要支援_認定者数.getコード().equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_居宅介護_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_地域密着型_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_施設介護サービス受給者数.getコード()
                .equals(hdnYoshikiCode)) {
            return 画面の様式種類_2;
        }
        return null;
    }

    /**
     * 画面2の様式種類の1
     *
     * @param hdnYoshikiCode hdnYoshikiCode
     * @return 画面2の様式種類の1
     */
    public RString 画面2の様式種類の1(RString hdnYoshikiCode) {
        if (JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__施設介護サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__施設介護サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_要介護_要支援_認定者数.getコード().equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_居宅介護_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__居宅介護_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__居宅介護_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_地域密着型_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__地域密着型_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__地域密着型_介護予防_サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_施設介護サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__施設介護サービス受給者数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__施設介護サービス受給者数.getコード()
                .equals(hdnYoshikiCode)) {
            return 画面の様式種類_2;
        }
        return null;

    }

    /**
     * 画面3の様式種類
     *
     * @param hdnYoshikiCode hdnYoshikiCode
     * @return 画面3の様式種類
     */
    public RString 画面3の様式種類(RString hdnYoshikiCode) {
        if ((JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付1総数.getコード()).equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付3総数特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付3総数特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付3総数特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付3総数特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(hdnYoshikiCode)) {
            return 画面の様式種類_3;
        }
        return null;
    }

    /**
     * 画面3の様式種類の1
     *
     * @param hdnYoshikiCode hdnYoshikiCode
     * @return 画面3の様式種類の1
     */
    public RString 画面3の様式種類の1(RString hdnYoshikiCode) {
        if (JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付3総数特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付3総数特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付3総数特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付3総数特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付2第２号被保険者分_再掲.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付3総数特例分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__介護給付_予防給付4第２号被保険者分_再掲_特例分.getコード()
                .equals(hdnYoshikiCode)) {
            return 画面の様式種類_3;
        }
        return null;
    }

    /**
     * 画面4の様式種類
     *
     * @param hdnYoshikiCode hdnYoshikiCode
     * @return 画面4の様式種類
     */
    public RString 画面4の様式種類(RString hdnYoshikiCode) {
        if ((JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費1総数.getコード())
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_現物分_特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_審査年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費1総数.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_償還_決定年月__特定入所者介護_介護予防_サービス費2第２号被保険者分.getコード()
                .equals(hdnYoshikiCode)) {
            return 画面の様式種類_4;
        }
        return null;
    }

    /**
     * 画面5の様式種類
     *
     * @param hdnYoshikiCode hdnYoshikiCode
     * @return 画面5の様式種類
     */
    public RString 画面5の様式種類(RString hdnYoshikiCode) {
        if ((JigyohokokuGeppoHoseiHyoji.保険者_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード())
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_利用者負担第４段階食費_居住費の特例減額措置.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_利用者負担第４段階食費_居住費の特例減額措置.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_食費_居住費負担限度額認定_再掲_税制改正激変緩和者.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_利用者負担第４段階食費_居住費の特例減額措置.getコード()
                .equals(hdnYoshikiCode)) {
            return 画面の様式種類_5;
        } else if ((JigyohokokuGeppoHoseiHyoji.保険者_高額介護_介護予防_サービス費.getコード()).equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.保険者_高額医療合算介護_介護予防_サービス費.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_高額介護_介護予防_サービス費.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_高額医療合算介護_介護予防_サービス費.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_高額介護_介護予防_サービス費.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_高額医療合算介護_介護予防_サービス費.getコード()
                .equals(hdnYoshikiCode)) {
            return 画面の様式種類_6;
        } else if ((JigyohokokuGeppoHoseiHyoji.保険者__別紙_第１号被保険者のいる世帯.getコード()).equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村__別紙_第１号被保険者のいる世帯.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村__別紙_第１号被保険者のいる世帯.getコード()
                .equals(hdnYoshikiCode)) {
            return 画面の様式種類_7;
        } else if ((JigyohokokuGeppoHoseiHyoji.保険者_第１号被保険者数_第１号被保険者増減内訳.getコード())
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.構成市町村_第１号被保険者数_第１号被保険者増減内訳.getコード()
                .equals(hdnYoshikiCode)
                || JigyohokokuGeppoHoseiHyoji.旧市町村_第１号被保険者数_第１号被保険者増減内訳.getコード()
                .equals(hdnYoshikiCode)) {
            return 画面の様式種類_8;
        }
        return null;

    }
}
