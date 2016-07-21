/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0050011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.InsuranceInformation;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenJigyoHokokuNenpo;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist.Shichoson;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.TaishokensakuJyoukenDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.dgHoseitaishoYoshiki_Row;
import jp.co.ndensan.reams.db.dbu.service.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 *
 * 介護保険特別会計経理状況登録_検索ハンドラクラスです。
 *
 * @reamsid_L DBU-1130-010 wangjie2
 */
public class TaishokensakuJyoukenHandler {

    private static final RString UPDATE = new RString("modify");
    private static final RString DELETE = new RString("delete");
    private static final RString 入力済 = new RString("入力済");
    private static final RString 入力未 = new RString("入力未");
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT6 = 6;
    private static final Code CODE0100 = new Code("0100");
    private static final Code CODE0200 = new Code("0200");
    private static final Code CODE0301 = new Code("0301");
    private static final Code CODE0302 = new Code("0302");
    private static final Code CODE0303 = new Code("0303");
    private final TaishokensakuJyoukenDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護保険特別会計経理状況登録_検索情報Div
     */
    public TaishokensakuJyoukenHandler(TaishokensakuJyoukenDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param is詳細画面から is詳細画面から
     * @param 市町村名称 市町村名称
     */
    public void onload(Boolean is詳細画面から, RString 市町村名称) {
        if (null == is詳細画面から) {
            onLoadFromMain();
        } else if (is詳細画面から) {
            onLoadFromDetail(市町村名称);
        } else {
            onLoadFromMain();
        }
    }

    /**
     * メニューから遷移の場合、画面初期化処理です。
     */
    public void onLoadFromMain() {
        List<Shichoson> 市町村Lst = get市町村Lst();
        if (市町村Lst.isEmpty()) {
            throw new ApplicationException(DbaErrorMessages.広域構成市町村からの補正処理.getMessage());
        }
        List<KeyValueDataSource> dataSource = getDataSourceFrom市町村Lst(市町村Lst);
        RDate date = RDate.getNowDate();
        FlexibleDate 報告年度;
        FlexibleDate 集計年度;
        if (date.getMonthValue() < INT6) {
            報告年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 2, date.getMonthValue(), date.getDayValue());
        } else {
            報告年度 = new FlexibleDate(date.getYear().getYearValue(), date.getMonthValue(), date.getDayValue());
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
        }
        div.getDdlShichoson().setDataSource(dataSource);
        div.getTxtHoukokuY().setValue(報告年度);
        div.getTxtShukeiY().setValue(集計年度);
        div.getTxtShukeiY().setReadOnly(true);
        div.getTxtHoukokuY().setReadOnly(false);
        div.getDdlShichoson().setSelectedIndex(0);
        div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().init();
        div.getDdlShichoson().setDisplayNone(is単一合併なし());
        div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getGridSetting().getColumn("txtShichosonCode").setVisible(!is単一合併なし());
    }

    private boolean is単一合併なし() {
        ShichosonSecurityJoho shichosonsecurityjoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード;
        if (shichosonsecurityjoho != null && shichosonsecurityjoho.get市町村情報() != null) {
            導入形態コード = shichosonsecurityjoho.get導入形態コード();
        } else {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("市町村セキュリティ情報"));
        }
        RString 合併情報区分 = GappeiCityJohoBFinder.createInstance().getGappeijohokubun();
        return new RString("0").equals(合併情報区分)
                && !(DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getColumnValue())
                || DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード.getColumnValue()));
    }

    /**
     * 市町村Lst取得処理です。
     *
     * @return List<Shichoson>
     */
    private List<Shichoson> get市町村Lst() {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<Shichoson> 市町村Lst = 介護保険特別会計経理状況登録Manager.getShichosonCodeNameList();
        return 市町村Lst;
    }

    /**
     * 市町村のDataSource取得処理です。
     *
     * @param 市町村Lst 市町村Lst
     * @return DataSource
     */
    private List<KeyValueDataSource> getDataSourceFrom市町村Lst(List<Shichoson> 市町村Lst) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (Shichoson shichoson : 市町村Lst) {
            KeyValueDataSource keyValueDataSource
                    = new KeyValueDataSource(create市町村Key(shichoson), shichoson.get市町村名称());
            dataSource.add(keyValueDataSource);
        }
        return dataSource;
    }

    private RString create市町村Key(Shichoson shichoson) {
        return new RStringBuilder().append(shichoson.get市町村コード().getColumnValue()).append("_")
                .append(shichoson.get保険者コード().getColumnValue()).append("_").append(shichoson.get保険者区分().getコード()).toRString();
    }

    /**
     * 市町村コード取得処理です。
     *
     * @param 市町村Key 市町村Key
     * @return 市町村コード
     */
    public LasdecCode get市町村コード(RString 市町村Key) {
        if (市町村Key.split("_").size() < 1) {
            return LasdecCode.EMPTY;
        } else {
            return new LasdecCode(市町村Key.split("_").get(0));
        }
    }

    private TokeiTaishoKubun get保険者区分(RString 市町村Key) {
        if (市町村Key.split("_").size() < INT3) {
            return TokeiTaishoKubun.空;
        } else {
            return TokeiTaishoKubun.toValue(市町村Key.split("_").get(2));
        }
    }

    /**
     * 「報告年度」フォーカスロスト処理です。
     */
    public void lostFocus() {
        div.getTxtShukeiY().clearValue();
        FlexibleDate 報告年度 = div.getTxtHoukokuY().getValue();
        if (!報告年度.isEmpty()) {
            報告年度 = new FlexibleDate(報告年度.toString().substring(0, INT4).concat("0101"));
        }
        if (報告年度.isValid() && !報告年度.isEmpty()) {
            int 報告年度Year = 報告年度.getYearValue();
            set集計年度(報告年度Year);
        }
    }

    private void set集計年度(int 報告年度Year) {
        FlexibleDate 集計年度;
        RDate date = RDate.getNowDate();
        if (報告年度Year == date.getYearValue()) {
            set集計年度_報告年度がシステム日付の年();
        } else {
            集計年度 = new FlexibleDate(報告年度Year - 1, date.getMonthValue(), date.getDayValue());
            div.getTxtShukeiY().setValue(集計年度);
        }
    }

    private void set集計年度_報告年度がシステム日付の年() {
        FlexibleDate 集計年度;
        RDate date = RDate.getNowDate();
        if (date.getMonthValue() >= INT6) {
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
        } else {
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 2, date.getMonthValue(), date.getDayValue());
        }
        div.getTxtShukeiY().setValue(集計年度);
    }

    /**
     * 詳細画面から遷移の場合、画面初期化処理です。
     *
     * @param 市町村名称 市町村名称
     */
    public void onLoadFromDetail(RString 市町村名称) {
        List<Shichoson> 市町村Lst = get市町村Lst();
        if (市町村Lst.isEmpty()) {
            throw new ApplicationException(DbaErrorMessages.広域構成市町村からの補正処理.getMessage());
        }
        List<KeyValueDataSource> dataSource = getDataSourceFrom市町村Lst(市町村Lst);
        div.getDdlShichoson().setDataSource(dataSource);
        set報告年度And集計年度();
        div.getDdlShichoson().setSelectedValue(市町村名称);
        div.getDdlShichoson().setDisplayNone(is単一合併なし());
        onClick_btnSearch();
    }

    /**
     * 「検索する」ボタンを押下すること処理です。
     */
    public void onClick_btnSearch() {
        RString 報告年度String = div.getTxtHoukokuY().getText();
        RString 報告年度Year = RString.EMPTY;
        if (報告年度String.length() >= INT4) {
            報告年度Year = 報告年度String.substring(0, INT4);
        }
        TokeiTaishoKubun 保険者区分 = get保険者区分(div.getDdlShichoson().getSelectedKey());
        LasdecCode 市町村コード = get市町村コード(div.getDdlShichoson().getSelectedKey());
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<KaigoHokenJigyoHokokuNenpo> 一覧データLst
                = 介護保険特別会計経理状況登録Manager.getJigyoHokokuNenpoList(
                        RString.isNullOrEmpty(報告年度Year) ? null : new FlexibleYear(報告年度Year),
                        市町村コード,
                        保険者区分);
        List<dgHoseitaishoYoshiki_Row> dgHoseitaishoYoshiki_RowLst = new ArrayList<>();
        LasdecCode 一覧データの市町村コード = LasdecCode.EMPTY;
        FlexibleYear 一覧データの報告年 = FlexibleYear.EMPTY;
        FlexibleYear 集計対象年 = FlexibleYear.EMPTY;
        RString 様式4入力状況 = 入力未;
        RString 様式4の2入力状況 = 入力未;
        RString 様式4の3入力状況 = 入力未;
        RString 統計対象区分 = RString.EMPTY;
        Code 表番号 = Code.EMPTY;
        Code 集計番号 = Code.EMPTY;
        for (KaigoHokenJigyoHokokuNenpo 一覧データ : 一覧データLst) {
            if (LasdecCode.EMPTY.equals(一覧データの市町村コード) || FlexibleYear.EMPTY.equals(一覧データの報告年)) {
                一覧データの市町村コード = 一覧データ.get市町村コード();
                一覧データの報告年 = 一覧データ.get報告年();
                統計対象区分 = 一覧データ.get統計対象区分();
                表番号 = 一覧データ.get表番号();
                集計番号 = 一覧データ.get集計番号();
                集計対象年 = 一覧データ.get集計対象年();
            } else if (!一覧データの市町村コード.equals(一覧データ.get市町村コード()) || !一覧データの報告年.equals(一覧データ.get報告年())) {
                TextBoxDate 報告年textBoxDate = new TextBoxDate();
                TextBoxDate 集計対象年textBoxDate = new TextBoxDate();
                報告年textBoxDate.setValue(new RDate(一覧データの報告年.getYearValue()));
                集計対象年textBoxDate.setValue(new RDate(集計対象年.getYearValue()));
                dgHoseitaishoYoshiki_Row dgHoseitaishoYoshiki_Row
                        = new dgHoseitaishoYoshiki_Row(一覧データの市町村コード.getColumnValue(), 報告年textBoxDate,
                                集計対象年textBoxDate, 様式4入力状況, 様式4の2入力状況, 様式4の3入力状況, 統計対象区分,
                                表番号.getColumnValue(), 集計番号.getColumnValue());
                dgHoseitaishoYoshiki_RowLst.add(dgHoseitaishoYoshiki_Row);
                一覧データの市町村コード = 一覧データ.get市町村コード();
                一覧データの報告年 = 一覧データ.get報告年();
                統計対象区分 = 一覧データ.get統計対象区分();
                表番号 = 一覧データ.get表番号();
                集計番号 = 一覧データ.get集計番号();
                集計対象年 = 一覧データ.get集計対象年();
                様式4入力状況 = 入力未;
                様式4の2入力状況 = 入力未;
                様式4の3入力状況 = 入力未;
            }
            if (CODE0100.equals(一覧データ.get集計番号())) {
                様式4入力状況 = 入力済;
            }
            if (CODE0200.equals(一覧データ.get集計番号())) {
                様式4の2入力状況 = 入力済;
            }
            if (CODE0301.equals(一覧データ.get集計番号())
                    || CODE0302.equals(一覧データ.get集計番号())
                    || CODE0303.equals(一覧データ.get集計番号())) {
                様式4の3入力状況 = 入力済;
            }
        }
        if (!一覧データLst.isEmpty()) {
            TextBoxDate 報告年textBoxDate = new TextBoxDate();
            TextBoxDate 集計対象年textBoxDate = new TextBoxDate();
            if (!一覧データの報告年.isEmpty()) {
                報告年textBoxDate.setValue(new RDate(一覧データの報告年.getYearValue()));
            }
            if (!集計対象年.isEmpty()) {
                集計対象年textBoxDate.setValue(new RDate(集計対象年.getYearValue()));
            }
            dgHoseitaishoYoshiki_Row dgHoseitaishoYoshiki_Row
                    = new dgHoseitaishoYoshiki_Row(一覧データの市町村コード.getColumnValue(), 報告年textBoxDate,
                            集計対象年textBoxDate, 様式4入力状況, 様式4の2入力状況, 様式4の3入力状況, 統計対象区分,
                            表番号.getColumnValue(), 集計番号.getColumnValue());
            dgHoseitaishoYoshiki_RowLst.add(dgHoseitaishoYoshiki_Row);
        }
        div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().setDataSource(dgHoseitaishoYoshiki_RowLst);
        div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getGridSetting().getColumn("txtShichosonCode").setVisible(!is単一合併なし());
        div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().setVisible(true);

    }

    /**
     * 「条件をクリアする」ボタンを押下すること処理です。
     */
    @SuppressWarnings("empty-statement")
    public void onClick_btnClear() {
        set報告年度And集計年度();
        List<Shichoson> 市町村Lst = get市町村Lst();
        List<KeyValueDataSource> dataSource = getDataSourceFrom市町村Lst(市町村Lst);
        div.getDdlShichoson().setDataSource(dataSource);
        div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().setDataSource(new ArrayList<dgHoseitaishoYoshiki_Row>());
        div.getDdlShichoson().setSelectedIndex(0);
        div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getGridSetting().getColumn("txtShichosonCode").setVisible(!is単一合併なし());
    }

    /**
     * 「修正」ボタンを押下すること処理です。
     *
     * @return 遷移先渡す項目
     */
    public InsuranceInformation onClick_btnModify() {
        return onClick_btnModifyOrDelete(true);
    }

    /**
     * 「削除」ボタンを押下すること処理です。
     *
     * @return 遷移先渡す項目
     */
    public InsuranceInformation onClick_btnDelete() {
        return onClick_btnModifyOrDelete(false);
    }

    private void set報告年度And集計年度() {
        RDate date = RDate.getNowDate();
        FlexibleDate 報告年度;
        FlexibleDate 集計年度;
        if (date.getMonthValue() < INT6) {
            報告年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 2, date.getMonthValue(), date.getDayValue());
        } else {
            報告年度 = new FlexibleDate(date.getYear().getYearValue(), date.getMonthValue(), date.getDayValue());
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
        }
        div.getTxtHoukokuY().setValue(報告年度);
        div.getTxtShukeiY().setValue(集計年度);
    }

    private InsuranceInformation onClick_btnModifyOrDelete(Boolean modifyOrDeleteFlg) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        dgHoseitaishoYoshiki_Row dgHoseitaishoYoshiki_Row = div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getClickedItem();
        RString 市町村コード = dgHoseitaishoYoshiki_Row.getTxtShichosonCode();
        RString 様式４入力状況 = dgHoseitaishoYoshiki_Row.getTxtStateYoshikiyon();
        RString 様式４の２入力状況 = dgHoseitaishoYoshiki_Row.getTxtStateYoShikiyonnoni();
        RString 様式４の３入力状況 = dgHoseitaishoYoshiki_Row.getTxtStateYoskiyonosan();
        RString 統計対象区分 = dgHoseitaishoYoshiki_Row.getTxtObjectclassification();
        RString 表番号 = dgHoseitaishoYoshiki_Row.getTxtListNumber();
        Shichoson 市町村 = 介護保険特別会計経理状況登録Manager.getHokenshaJoho(new LasdecCode(市町村コード));
        if (null == 市町村) {
            市町村 = new Shichoson(LasdecCode.EMPTY, RString.EMPTY, ShoKisaiHokenshaNo.EMPTY, TokeiTaishoKubun.空);
        }
        InsuranceInformation insuranceInformation
                = new InsuranceInformation(new FlexibleYear(dgHoseitaishoYoshiki_Row.getTxtHokokuY().getValue().getYear().toString()),
                        new FlexibleYear(dgHoseitaishoYoshiki_Row.getTxtShukeiY().getValue().getYear().toString()), 統計対象区分,
                        new LasdecCode(市町村コード), new Code(表番号), modifyOrDeleteFlg ? UPDATE : DELETE,
                        市町村.get保険者コード(), 市町村.get市町村名称(),
                        様式４入力状況, 様式４の２入力状況, 様式４の３入力状況);
        return insuranceInformation;
    }

    /**
     * 引数定義<br/>
     *
     */
    public enum DBU0050011ViewStateKey {

        /**
         * 遷移の前画面です。
         */
        is詳細画面から,
        /**
         * 遷移前の選択市町村名称です。
         */
        選択市町村名称;
    }
}
