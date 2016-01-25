package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0060011;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060011.PanelBaseDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060011.dgHoseitaishoYoshiki_Row;
import jp.co.ndensan.reams.db.dbu.definition.core.zigyouhoukokunenpou.ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyohokokuNenpoHoseiHyoji;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 事業報告（年報）補正、発行_検索のHandlerクラスです。
 */
public class PanelBaseHandler {

    private final PanelBaseDiv div;
    private static final int 日付の月_06 = 6;

    /**
     * コンストラクタです。
     *
     * @param div 名義人・車両検索Div
     */
    public PanelBaseHandler(PanelBaseDiv div) {
        this.div = div;
    }

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
     * 報告年度と集計年度を設定です。
     *
     */
    public void set報告年度と集計年度() {
        if (RDate.getNowDate().getMonthValue() < 日付の月_06) {
            div.getTaishokensaku().getTxtHokokuY().setValue(
                    new FlexibleDate(RDate.getNowDate().getYearValue() - 1,
                            RDate.getNowDate().getMonthValue(),
                            RDate.getNowDate().getDayValue()));
            div.getTaishokensaku().getTxtshukeiY().setValue(
                    new FlexibleDate(RDate.getNowDate().getYearValue() - 2,
                            RDate.getNowDate().getMonthValue(),
                            RDate.getNowDate().getDayValue()));
        } else {
            div.getTaishokensaku().getTxtHokokuY().setValue(
                    new FlexibleDate(RDate.getNowDate().toDateString()));
            div.getTaishokensaku().getTxtshukeiY().setValue(
                    new FlexibleDate(RDate.getNowDate().getYearValue() - 1,
                            RDate.getNowDate().getMonthValue(),
                            RDate.getNowDate().getDayValue()));
        }
    }

    /**
     * 報告年度からフォーカス外す時、集計年度を設定です。
     *
     */
    public void set集計年度() {
        if (!div.getTaishokensaku().getTxtHokokuY().getValue().isEmpty()) {
            set集計年度の設定();
        } else {
            div.getTaishokensaku().getTxtshukeiY().setValue(FlexibleDate.EMPTY);
        }
    }

    /**
     * 報告年度はnull以外時、集計年度を設定です。
     *
     */
    public void set集計年度の設定() {
        if (RDate.getNowDate().getYear().toString().equals(div.getTaishokensaku().getTxtHokokuY().getValue().toString())) {
            if (RDate.getNowDate().getMonthValue() < 日付の月_06) {
                div.getTaishokensaku().getTxtshukeiY().setValue(
                        new FlexibleDate(RDate.getNowDate().getYearValue() - 2,
                                RDate.getNowDate().getMonthValue(),
                                RDate.getNowDate().getDayValue()));

            } else {
                div.getTaishokensaku().getTxtshukeiY().setValue(
                        new FlexibleDate(RDate.getNowDate().getYearValue() - 1,
                                RDate.getNowDate().getMonthValue(),
                                RDate.getNowDate().getDayValue()));
            }
        } else {
            FlexibleDate hokokuYMD = div.getTaishokensaku().getTxtHokokuY().getValue();
            div.getTaishokensaku().getTxtshukeiY().setValue(
                    new FlexibleDate(Integer.parseInt(hokokuYMD.seireki().getYear().toString()) - 1,
                            RDate.getNowDate().getMonthValue(),
                            RDate.getNowDate().getDayValue()));
        }
    }

    /**
     * 遷移先画面を取得します。
     *
     * @return 遷移先画面
     *
     */
    public ResponseData<PanelBaseDiv> get遷移先画面() {
        RString 様式種類 = div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getSelectedItems().get(0).getTxtToukeiTaishoKubun();
        RString enum事業報告年報補正表示_001 = JigyohokokuNenpoHoseiHyoji.保険者_所得段階別第１号被保険者数.get名称();
        RString enum事業報告年報補正表示_002 = JigyohokokuNenpoHoseiHyoji.保険者_現物分_市町村特別給付.get名称();
        RString enum事業報告年報補正表示_003 = JigyohokokuNenpoHoseiHyoji.保険者_保険料収納状況_保険給付支払状況.get名称();
        RString enum事業報告年報補正表示_101 = JigyohokokuNenpoHoseiHyoji.構成市町村_所得段階別第１号被保険者数.get名称();
        RString enum事業報告年報補正表示_102 = JigyohokokuNenpoHoseiHyoji.構成市町村_現物分_市町村特別給付.get名称();
        RString enum事業報告年報補正表示_103 = JigyohokokuNenpoHoseiHyoji.構成市町村_保険料収納状況_保険給付支払状況.get名称();
        RString enum事業報告年報補正表示_201 = JigyohokokuNenpoHoseiHyoji.旧市町村_所得段階別第１号被保険者数.get名称();
        RString enum事業報告年報補正表示_202 = JigyohokokuNenpoHoseiHyoji.旧市町村_現物分_市町村特別給付.get名称();
        RString enum事業報告年報補正表示_203 = JigyohokokuNenpoHoseiHyoji.旧市町村_保険料収納状況_保険給付支払状況.get名称();

        if ((0 == 様式種類.compareTo(enum事業報告年報補正表示_001))
                || (0 == 様式種類.compareTo(enum事業報告年報補正表示_101))
                || (0 == 様式種類.compareTo(enum事業報告年報補正表示_201))) {
            // TODO QA:555  UIContainerを存在しない
            throw new ApplicationException(UrErrorMessages.不正.getMessage().replace("様式１補正画面に遷移"));
        }
        if ((0 == 様式種類.compareTo(enum事業報告年報補正表示_002))
                || (0 == 様式種類.compareTo(enum事業報告年報補正表示_102))
                || (0 == 様式種類.compareTo(enum事業報告年報補正表示_202))) {
            // TODO QA:555  UIContainerを存在しない
            throw new ApplicationException(UrErrorMessages.不正.getMessage().replace("様式2の８画面に遷移"));
        }
        if ((0 == 様式種類.compareTo(enum事業報告年報補正表示_003))
                || (0 == 様式種類.compareTo(enum事業報告年報補正表示_103))
                || (0 == 様式種類.compareTo(enum事業報告年報補正表示_203))) {
            // TODO QA:555  UIContainerを存在しない
            throw new ApplicationException(UrErrorMessages.不正.getMessage().replace("様式３画面に遷移"));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * EntityをViewStateに書き込みます。
     *
     * @param 補正フラグ 補正フラグ
     * @return ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity
     *
     */
    public ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity saveEntityToViewState(RString 補正フラグ) {
        ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity entity = new ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity();
        List<dgHoseitaishoYoshiki_Row> resultList = div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getSelectedItems();
        entity.set行市町村コード(resultList.get(0).getTxtShichosonCode().getValue());
        entity.set行報告年(resultList.get(0).getTxtHokokuY().getValue().seireki().getYear());
        entity.set行集計対象年(resultList.get(0).getTxtShukeiY().getValue().seireki().getYear());
        entity.set事業報告年報補正表示のコード(get事業報告年報補正表示のコード(resultList.get(0).getTxtToukeiTaishoKubun()));
        entity.set画面報告年度(div.getTaishokensaku().getTxtHokokuY().getValue().seireki().getYear());
        entity.set画面集計年度(div.getTaishokensaku().getTxtshukeiY().getValue().seireki().getYear());
        entity.set市町村名称(div.getTaishokensaku().getDdlShichoson().getSelectedValue());
        entity.set補正フラグ(補正フラグ);
        if (div.getTaishokensaku().getDdlShichoson().getSelectedKey().isEmpty()) {
            entity.set保険者コード(RString.EMPTY);
        } else {
            entity.set保険者コード(div.getTaishokensaku().getDdlShichoson().getSelectedKey().split("-").get(2));
        }
        entity.set選択した市町村コード(div.getTaishokensaku().getDdlShichoson().getSelectedKey());
        return entity;
    }

    private RString get事業報告年報補正表示のコード(RString 事業報告年報補正表示の名称) {
        RString code = new RString("");
        if (JigyohokokuNenpoHoseiHyoji.保険者_所得段階別第１号被保険者数.get名称().equals(事業報告年報補正表示の名称)) {
            code = JigyohokokuNenpoHoseiHyoji.保険者_所得段階別第１号被保険者数.getコード();
        } else if (JigyohokokuNenpoHoseiHyoji.構成市町村_所得段階別第１号被保険者数.get名称().equals(事業報告年報補正表示の名称)) {
            code = JigyohokokuNenpoHoseiHyoji.構成市町村_所得段階別第１号被保険者数.getコード();
        } else if (JigyohokokuNenpoHoseiHyoji.旧市町村_所得段階別第１号被保険者数.get名称().equals(事業報告年報補正表示の名称)) {
            code = JigyohokokuNenpoHoseiHyoji.旧市町村_所得段階別第１号被保険者数.getコード();
        } else if (JigyohokokuNenpoHoseiHyoji.保険者_現物分_市町村特別給付.get名称().equals(事業報告年報補正表示の名称)) {
            code = JigyohokokuNenpoHoseiHyoji.保険者_現物分_市町村特別給付.getコード();
        } else if (JigyohokokuNenpoHoseiHyoji.構成市町村_現物分_市町村特別給付.get名称().equals(事業報告年報補正表示の名称)) {
            code = JigyohokokuNenpoHoseiHyoji.構成市町村_現物分_市町村特別給付.getコード();
        } else if (JigyohokokuNenpoHoseiHyoji.旧市町村_現物分_市町村特別給付.get名称().equals(事業報告年報補正表示の名称)) {
            code = JigyohokokuNenpoHoseiHyoji.旧市町村_現物分_市町村特別給付.getコード();
        } else if (JigyohokokuNenpoHoseiHyoji.保険者_保険料収納状況_保険給付支払状況.get名称().equals(事業報告年報補正表示の名称)) {
            code = JigyohokokuNenpoHoseiHyoji.保険者_保険料収納状況_保険給付支払状況.getコード();
        } else if (JigyohokokuNenpoHoseiHyoji.構成市町村_保険料収納状況_保険給付支払状況.get名称().equals(事業報告年報補正表示の名称)) {
            code = JigyohokokuNenpoHoseiHyoji.構成市町村_保険料収納状況_保険給付支払状況.getコード();
        } else if (JigyohokokuNenpoHoseiHyoji.旧市町村_保険料収納状況_保険給付支払状況.get名称().equals(事業報告年報補正表示の名称)) {
            code = JigyohokokuNenpoHoseiHyoji.旧市町村_保険料収納状況_保険給付支払状況.getコード();
        }
        return code;
    }
}
