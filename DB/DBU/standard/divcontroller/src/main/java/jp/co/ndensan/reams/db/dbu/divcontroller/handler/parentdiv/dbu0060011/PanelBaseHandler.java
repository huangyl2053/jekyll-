package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0060011;

import java.util.List;
import java.util.regex.Pattern;
import jp.co.ndensan.reams.db.dbu.definition.core.zigyouhoukokunenpou.ZigyouHoukokuNenpouHoseihakouKensakuRelateEntity;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060011.PanelBaseDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060011.dgHoseitaishoYoshiki_Row;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyohokokuNenpoHoseiHyoji;
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
            Pattern pattern = Pattern.compile("[0-9]*");
            if (pattern.matcher(div.getTaishokensaku().getTxtHokokuY().getValue().toString()).matches()) {
                set集計年度の設定();
            }
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
