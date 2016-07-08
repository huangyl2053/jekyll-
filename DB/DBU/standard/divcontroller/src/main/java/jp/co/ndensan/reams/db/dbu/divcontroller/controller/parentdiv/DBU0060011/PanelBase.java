package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0060011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokunenpo.JigyoHokokuNenpoResult;
import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokunenpo.ShichosonCodeNameResult;
import jp.co.ndensan.reams.db.dbu.definition.core.zigyouhoukokunenpou.ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060011.DBU0060011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060011.PanelBaseDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060011.dgHoseitaishoYoshiki_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0060011.PanelBaseHandler;
import jp.co.ndensan.reams.db.dbu.service.core.jigyohokokunenpo.JigyoHokokuNenpoHoseiHakoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.JigyohokokuNenpoHoseiHyoji;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 事業報告（年報）補正、発行_検索を表示するDivControllerです。
 *
 * @reamsid_L DBU-1060-010 lijia
 *
 */
public class PanelBase {

    private static final RString 処理種別_修正 = new RString("修正");
    private static final RString 処理種別_削除 = new RString("削除");

    private static final int 統計対象区分_1 = 1;
    private static final int 統計対象区分_2 = 2;
    private static final int 統計対象区分_3 = 3;

    private static final int 表番号_01 = 1;
    private static final int 表番号_02 = 2;
    private static final int 表番号_08 = 8;
    private static final int 表番号_11 = 11;
    private static final int 表番号_12 = 12;
    private static final int 表番号_18 = 18;

    private static final int 集計番号_0400 = 400;
    private static final int 集計番号_0601 = 601;
    private static final int 集計番号_0602 = 602;
    private static final int 集計番号_0603 = 603;
    private static final int 集計番号_0100 = 100;
    private static final int 集計番号_0200 = 200;
    private static final int 保険者区分_るく = 6;
    private static final int 保険者区分_なな = 7;
    private List<JigyoHokokuNenpoResult> 事業報告集計一覧データリスト;

    /**
     * 事業報告（年報）補正、発行_検索画面の初期処理を表します。
     *
     * @param baseDiv 事業報告（年報）補正、発行_検索Div
     * @return ResponseData
     */
    public ResponseData<PanelBaseDiv> onLoad(PanelBaseDiv baseDiv) {
        init初期状態(baseDiv);
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity
                = ViewStateHolder.get(ViewStateKeys.補正検索画面情報, ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity.class);
        if ((null != entity) && (!baseDiv.getTaishokensaku().getDdlShichoson().getDataSource().isEmpty())) {
            baseDiv.getTaishokensaku().getDdlShichoson().setSelectedKey(entity.get選択した市町村コード());

            if (entity.get画面報告年度().isEmpty()) {
                baseDiv.getTaishokensaku().getTxtHokokuY().setValue(FlexibleDate.EMPTY);
            } else {
                baseDiv.getTaishokensaku().getTxtHokokuY().setValue(new FlexibleDate(Integer.parseInt(entity.get画面報告年度().toString()),
                        RDate.getNowDate().getMonthValue(),
                        RDate.getNowDate().getDayValue()));
            }
            if (entity.get画面集計年度().isEmpty()) {
                baseDiv.getTaishokensaku().getTxtshukeiY().setValue(FlexibleDate.EMPTY);
            } else {
                baseDiv.getTaishokensaku().getTxtshukeiY().setValue(new FlexibleDate(Integer.parseInt(entity.get画面集計年度().toString()),
                        RDate.getNowDate().getMonthValue(),
                        RDate.getNowDate().getDayValue()));
            }
            ViewStateHolder.clear();
        }
        return ResponseData.of(baseDiv).respond();
    }

    /**
     * 報告年度からフォーカス外す時、集計年度の取得を行います。
     *
     * @param baseDiv 事業報告（年報）補正、発行_検索Div
     * @return ResponseData
     */
    public ResponseData<PanelBaseDiv> onBlur_txtHokokuY(PanelBaseDiv baseDiv) {
        getHandler(baseDiv).set集計年度();
        return ResponseData.of(baseDiv).respond();
    }

    /**
     * 「検索する」ボタンを押下した時の処理を表します。
     *
     * @param baseDiv 事業報告（年報）補正、発行_検索Div
     * @return ResponseData
     */
    public ResponseData<PanelBaseDiv> onClick_btnSearch(PanelBaseDiv baseDiv) {
        RString 市町村 = null;
        RString 保険者区分 = null;
        RString 報告年度;
        LasdecCode 市町村コード;
        RString key = baseDiv.getTaishokensaku().getDdlShichoson().getSelectedKey();
        baseDiv.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getDataSource().clear();
        if (!key.isEmpty()) {
            市町村 = key.substring(0, 保険者区分_るく);
            保険者区分 = key.substring(保険者区分_るく, 保険者区分_なな);
        }
        if (baseDiv.getTaishokensaku().getTxtHokokuY().getValue() == null) {
            報告年度 = RString.EMPTY;
        } else {
            報告年度 = baseDiv.getTaishokensaku().getTxtHokokuY().getValue().seireki().getYear();
        }
        if (null != 市町村) {
            市町村コード = new LasdecCode(市町村);
        } else {
            市町村コード = LasdecCode.EMPTY;
        }
        事業報告集計一覧データリスト = new ArrayList<>();
        事業報告集計一覧データリスト = createInstanceOfFinder().getJigyoHokokuNenpoList(new FlexibleYear(報告年度), 市町村コード, 保険者区分).records();
        検索一覧データの設定(baseDiv, 事業報告集計一覧データリスト);
        return ResponseData.of(baseDiv).respond();
    }

    /**
     * 条件クリアボタンを押した時の処理を表します。
     *
     * @param baseDiv 事業報告（年報）補正、発行_検索Div
     * @return ResponseData
     */
    public ResponseData<PanelBaseDiv> onClick_btnClear(PanelBaseDiv baseDiv) {
        baseDiv.getTaishokensaku().getDdlShichoson().setSelectedKey(RString.EMPTY);
        init初期状態(baseDiv);
        if (null != baseDiv.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki()) {
            baseDiv.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getDataSource().clear();
        }
        return ResponseData.of(baseDiv).respond();
    }

    /**
     * 修正ボタンを押下する時の処理を行います。
     *
     * @param baseDiv 事業報告（年報）補正、発行_検索Div
     * @return ResponseData
     */
    public ResponseData<PanelBaseDiv> onSelectByModifyButton_dgHoseitaishoYoshiki(PanelBaseDiv baseDiv) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity = getHandler(baseDiv).saveEntityToViewState(処理種別_修正);
        ViewStateHolder.put(ViewStateKeys.補正検索画面情報, entity);
        return get遷移先画面(baseDiv);
    }

    /**
     * 削除ボタンを押下する時の処理を行います。
     *
     * @param baseDiv 事業報告（年報）補正、発行_検索Div
     * @return ResponseData
     */
    public ResponseData<PanelBaseDiv> onSelectByDeleteButton_dgHoseitaishoYoshiki(PanelBaseDiv baseDiv) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity = getHandler(baseDiv).saveEntityToViewState(処理種別_削除);
        ViewStateHolder.put(ViewStateKeys.補正検索画面情報, entity);
        return get遷移先画面(baseDiv);
    }

    /**
     * 遷移先画面を取得します。
     *
     * @param baseDiv 事業報告（年報）補正、発行_検索Div
     * @return 遷移先画面
     */
    private ResponseData<PanelBaseDiv> get遷移先画面(PanelBaseDiv baseDiv) {
        RString 様式種類 = baseDiv.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getSelectedItems().get(0).getTxtToukeiTaishoKubun();
        if ((0 == 様式種類.compareTo(JigyohokokuNenpoHoseiHyoji.保険者_所得段階別第１号被保険者数.get名称()))
                || (0 == 様式種類.compareTo(JigyohokokuNenpoHoseiHyoji.構成市町村_所得段階別第１号被保険者数.get名称()))
                || (0 == 様式種類.compareTo(JigyohokokuNenpoHoseiHyoji.旧市町村_所得段階別第１号被保険者数.get名称()))) {
            return ResponseData.of(baseDiv).forwardWithEventName(DBU0060011TransitionEventName.様式１に遷移).respond();
        }
        if ((0 == 様式種類.compareTo(JigyohokokuNenpoHoseiHyoji.保険者_現物分_市町村特別給付.get名称()))
                || (0 == 様式種類.compareTo(JigyohokokuNenpoHoseiHyoji.構成市町村_現物分_市町村特別給付.get名称()))
                || (0 == 様式種類.compareTo(JigyohokokuNenpoHoseiHyoji.旧市町村_現物分_市町村特別給付.get名称()))) {
            return ResponseData.of(baseDiv).forwardWithEventName(DBU0060011TransitionEventName.様式２の８に遷移).respond();
        }
        if ((0 == 様式種類.compareTo(JigyohokokuNenpoHoseiHyoji.保険者_保険料収納状況_保険給付支払状況.get名称()))
                || (0 == 様式種類.compareTo(JigyohokokuNenpoHoseiHyoji.構成市町村_保険料収納状況_保険給付支払状況.get名称()))
                || (0 == 様式種類.compareTo(JigyohokokuNenpoHoseiHyoji.旧市町村_保険料収納状況_保険給付支払状況.get名称()))) {
            return ResponseData.of(baseDiv).forwardWithEventName(DBU0060011TransitionEventName.様式３に遷移).respond();
        }
        return ResponseData.of(baseDiv).respond();
    }

    private void init初期状態(PanelBaseDiv baseDiv) {
        getHandler(baseDiv).set報告年度と集計年度();
        List<ShichosonCodeNameResult> 市町村情報リスト = createInstanceOfFinder().getShichosonCodeNameList().records();
        if (市町村情報リスト.isEmpty()) {
            baseDiv.getTaishokensaku().getDdlShichoson().setVisible(false);
        } else {
            List<KeyValueDataSource> shichosonList = new ArrayList<>();
            for (ShichosonCodeNameResult shichosonCodeNameResult : 市町村情報リスト) {
                shichosonList.add(setDdlShichoson(shichosonCodeNameResult));
            }
            getHandler(baseDiv).set市町村情報(shichosonList);
        }

        事業報告集計一覧データリスト = new ArrayList<>();
        検索一覧データの設定(baseDiv, 事業報告集計一覧データリスト);
    }

    private KeyValueDataSource setDdlShichoson(ShichosonCodeNameResult shichosonCodeNameResult) {
        RString 市町村コード = new RString(
                shichosonCodeNameResult.get市町村コード().toString()
                + shichosonCodeNameResult.get保険者区分()
                + shichosonCodeNameResult.get保険者コード().value());
        return new KeyValueDataSource(市町村コード, shichosonCodeNameResult.get市町村名称());
    }

    private ResponseData<PanelBaseDiv> 検索一覧データの設定(PanelBaseDiv baseDiv, List<JigyoHokokuNenpoResult> 事業報告一覧リスト) {
        List<dgHoseitaishoYoshiki_Row> 検索一覧データ = new ArrayList<>();
        for (JigyoHokokuNenpoResult result : 事業報告一覧リスト) {
            dgHoseitaishoYoshiki_Row row = new dgHoseitaishoYoshiki_Row();
            TextBox textBox = new TextBox();
            textBox.setValue(result.get市町村コード().value());
            row.setTxtShichosonCode(textBox);
            TextBoxDate 報告年textBoxDate = new TextBoxDate();
            RDate 報告年rDate = new RDate(result.get報告年().getYearValue(), 1, 1);
            報告年textBoxDate.setValue(報告年rDate);
            row.setTxtHokokuY(報告年textBoxDate);
            TextBoxDate 集計対象年TextBoxDate = new TextBoxDate();
            RDate 集計対象年RDate = new RDate(result.get集計対象年().getYearValue(), 1, 1);
            集計対象年TextBoxDate.setValue(集計対象年RDate);
            row.setTxtShukeiY(集計対象年TextBoxDate);
            RString 統計対象区分 = result.get統計対象区分();
            RString 表番号 = result.get表番号().value();
            RString 集計番号 = result.get集計番号().value();
            RString 様式種類 = get様式種類(統計対象区分, 表番号, 集計番号);
            row.setTxtToukeiTaishoKubun(様式種類);
            検索一覧データ.add(row);
        }
        baseDiv.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().setDataSource(検索一覧データ);
        return ResponseData.of(baseDiv).respond();
    }

    private RString get様式種類(RString 統計対象区分, RString 表番号, RString 集計番号) {
        int toketaishokubun = Integer.valueOf(統計対象区分.toString());
        int omoteBango = Integer.valueOf(表番号.toString());
        int shukekeBango = Integer.valueOf(集計番号.toString());
        RString 様式種類 = RString.EMPTY;
        switch (toketaishokubun) {
            case 統計対象区分_1:
                return get統計対象区分の1の様式種類(omoteBango, shukekeBango);
            case 統計対象区分_2:
                return get統計対象区分の2の様式種類(omoteBango, shukekeBango);
            case 統計対象区分_3:
                return get統計対象区分の3の様式種類(omoteBango, shukekeBango);
            default:
                return 様式種類;
        }
    }

    private RString get統計対象区分の1の様式種類(int omoteBango, int shukekeBango) {
        RString 様式種類 = RString.EMPTY;
        RString enum事業報告年報補正表示_001 = JigyohokokuNenpoHoseiHyoji.保険者_所得段階別第１号被保険者数.get名称();
        RString enum事業報告年報補正表示_002 = JigyohokokuNenpoHoseiHyoji.保険者_現物分_市町村特別給付.get名称();
        RString enum事業報告年報補正表示_003 = JigyohokokuNenpoHoseiHyoji.保険者_保険料収納状況_保険給付支払状況.get名称();
        switch (omoteBango) {
            case 表番号_01:
                switch (shukekeBango) {
                    case 集計番号_0400:
                        様式種類 = enum事業報告年報補正表示_001;
                        return 様式種類;
                    default:
                        return 様式種類;
                }
            case 表番号_02:
                switch (shukekeBango) {
                    case 集計番号_0601:
                    case 集計番号_0602:
                    case 集計番号_0603:
                        様式種類 = enum事業報告年報補正表示_002;
                        return 様式種類;
                    default:
                        return 様式種類;
                }
            case 表番号_08:
                switch (shukekeBango) {
                    case 集計番号_0100:
                    case 集計番号_0200:
                        様式種類 = enum事業報告年報補正表示_003;
                        return 様式種類;
                    default:
                        return 様式種類;
                }
            default:
                return 様式種類;
        }
    }

    private RString get統計対象区分の2の様式種類(int omoteBango, int shukekeBango) {
        RString 様式種類 = RString.EMPTY;
        RString enum事業報告年報補正表示_101 = JigyohokokuNenpoHoseiHyoji.構成市町村_所得段階別第１号被保険者数.get名称();
        RString enum事業報告年報補正表示_102 = JigyohokokuNenpoHoseiHyoji.構成市町村_現物分_市町村特別給付.get名称();
        RString enum事業報告年報補正表示_103 = JigyohokokuNenpoHoseiHyoji.構成市町村_保険料収納状況_保険給付支払状況.get名称();
        switch (omoteBango) {
            case 表番号_01:
                switch (shukekeBango) {
                    case 集計番号_0400:
                        様式種類 = enum事業報告年報補正表示_101;
                        return 様式種類;
                    default:
                        return 様式種類;
                }
            case 表番号_02:
                switch (shukekeBango) {
                    case 集計番号_0601:
                    case 集計番号_0602:
                    case 集計番号_0603:
                        様式種類 = enum事業報告年報補正表示_102;
                        return 様式種類;
                    default:
                        return 様式種類;
                }
            case 表番号_08:
                switch (shukekeBango) {
                    case 集計番号_0100:
                    case 集計番号_0200:
                        様式種類 = enum事業報告年報補正表示_103;
                        return 様式種類;
                    default:
                        return 様式種類;
                }
            default:
                return 様式種類;
        }
    }

    private RString get統計対象区分の3の様式種類(int omoteBango, int shukekeBango) {
        RString 様式種類 = RString.EMPTY;
        RString enum事業報告年報補正表示_201 = JigyohokokuNenpoHoseiHyoji.旧市町村_所得段階別第１号被保険者数.get名称();
        RString enum事業報告年報補正表示_202 = JigyohokokuNenpoHoseiHyoji.旧市町村_現物分_市町村特別給付.get名称();
        RString enum事業報告年報補正表示_203 = JigyohokokuNenpoHoseiHyoji.旧市町村_保険料収納状況_保険給付支払状況.get名称();
        switch (omoteBango) {
            case 表番号_11:
                switch (shukekeBango) {
                    case 集計番号_0400:
                        様式種類 = enum事業報告年報補正表示_201;
                        return 様式種類;
                    default:
                        return 様式種類;
                }
            case 表番号_12:
                switch (shukekeBango) {
                    case 集計番号_0601:
                    case 集計番号_0602:
                    case 集計番号_0603:
                        様式種類 = enum事業報告年報補正表示_202;
                        return 様式種類;
                    default:
                        return 様式種類;
                }
            case 表番号_18:
                switch (shukekeBango) {
                    case 集計番号_0100:
                    case 集計番号_0200:
                        様式種類 = enum事業報告年報補正表示_203;
                        return 様式種類;
                    default:
                        return 様式種類;
                }
            default:
                return 様式種類;
        }
    }

    private PanelBaseHandler getHandler(PanelBaseDiv baseDiv) {
        return new PanelBaseHandler(baseDiv);
    }

    private JigyoHokokuNenpoHoseiHakoManager createInstanceOfFinder() {
        return JigyoHokokuNenpoHoseiHakoManager.createInstance();
    }
}
