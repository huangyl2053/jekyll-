/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0050011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.TaishokensakuJyoukenDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050011.dgHoseitaishoYoshiki_Row;
import jp.co.ndensan.reams.db.dbu.entity.insuranceinformation.InsuranceInformationEntity;
import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenJigyoHokokuNenpoEntity;
import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.ShichosonEntity;
import jp.co.ndensan.reams.db.dbu.service.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 *
 * 介護保険特別会計経理状況登録_検索ハンドラクラスです。
 */
public class TaishokensakuJyoukenHandler {

    public static final RString UPDATE = new RString("modify");
    public static final RString DELETE = new RString("delete");
    public static final RString ADD = new RString("add");
    public static final RString 入力済 = new RString("入力済");
    public static final RString 入力未 = new RString("入力未");
    private final Code CODE_0100 = new Code("0100");
    private final Code CODE_0200 = new Code("0200");
    private final Code CODE_0301 = new Code("0301");
    private final Code CODE_0302 = new Code("0302");
    private final Code CODE_0303 = new Code("0303");
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
     */
    public void onload() {
        boolean is詳細画面から = false;//TODO ViewStateHolder.get(DBU0050011ViewStateKey.is詳細画面から, Boolean.class);
        if (is詳細画面から) {
            onLoadFromDetail();
        } else {
            onLoadFromMain();
        }
    }

    /**
     * メニューから遷移の場合、画面初期化処理です。
     */
    public void onLoadFromMain() {
        List<ShichosonEntity> 市町村Lst = get市町村Lst();
        if (市町村Lst.isEmpty()) {
            throw new ApplicationException(DbaErrorMessages.広域構成市町村からの補正処理.getMessage());
        }
        List<KeyValueDataSource> dataSource = getDataSourceFrom市町村Lst(市町村Lst);
        RDate date = RDate.getNowDate();
        FlexibleDate 報告年度;
        FlexibleDate 集計年度;
        if (date.getMonthValue() < 6) {
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
        if (div.getHoseitaishoYoshikiIchiran() != null && div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki() != null) {
            div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().init();
        }
    }

    /**
     * 市町村Lst取得処理です。
     *
     * @return List<ShichosonEntity>
     */
    private List<ShichosonEntity> get市町村Lst() {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<ShichosonEntity> 市町村Lst = 介護保険特別会計経理状況登録Manager.getShichosonCodeNameList();
        return 市町村Lst;
    }

    /**
     * 市町村のDataSource取得処理です。
     *
     * @param 市町村Lst 市町村Lst
     * @return DataSource
     */
    private List<KeyValueDataSource> getDataSourceFrom市町村Lst(List<ShichosonEntity> 市町村Lst) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ShichosonEntity shichosonEntity : 市町村Lst) {
            KeyValueDataSource keyValueDataSource
                    = new KeyValueDataSource(shichosonEntity.get市町村コード().getColumnValue(), shichosonEntity.get市町村名称());
            dataSource.add(keyValueDataSource);
        }
        return dataSource;
    }

    /**
     * 「報告年度」フォーカスロスト処理です。
     */
    public void lostFocus() {
        RString 報告年度String = div.getTxtHoukokuY().getText();
        if (報告年度String.length() >= 4) {
            FlexibleDate 報告年度 = div.getTxtHoukokuY().getValue();
            int 報告年度Year = Integer.parseInt(報告年度String.substring(0, 4).toString());
            if (!報告年度.isEmpty()) {
                FlexibleDate 集計年度;
                RDate date = RDate.getNowDate();
                if (報告年度Year == date.getYearValue()) {
                    if (date.getMonthValue() >= 6) {
                        集計年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
                    } else {
                        集計年度 = new FlexibleDate(date.getYear().getYearValue() - 2, date.getMonthValue(), date.getDayValue());
                    }
                } else {
                    集計年度 = new FlexibleDate(報告年度Year, date.getMonthValue(), date.getDayValue());
                }
                div.getTxtShukeiY().setValue(集計年度);
            }
        }
    }

    /**
     * 詳細画面から遷移の場合、画面初期化処理です。
     */
    public void onLoadFromDetail() {
        List<ShichosonEntity> 市町村Lst = get市町村Lst();
        if (市町村Lst.isEmpty()) {
            throw new ApplicationException(DbaErrorMessages.広域構成市町村からの補正処理.getMessage());
        }
        List<KeyValueDataSource> dataSource = getDataSourceFrom市町村Lst(市町村Lst);
        div.getDdlShichoson().setDataSource(dataSource);
        RString 市町村名称 = RString.EMPTY;//遷移前の選択
        RDate date = RDate.getNowDate();
        //TODO 本画面に開始年月と終了年月がありません
        FlexibleDate 報告年度;
        FlexibleDate 集計年度;
        if (date.getMonthValue() < 6) {
            報告年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 2, date.getMonthValue(), date.getDayValue());
        } else {
            報告年度 = new FlexibleDate(date.getYear().getYearValue(), date.getMonthValue(), date.getDayValue());
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
        }
        div.getTxtHoukokuY().setValue(報告年度);
        div.getTxtShukeiY().setValue(集計年度);
        div.getDdlShichoson().setSelectedValue(市町村名称);
        onClick_btnSearch();
    }

    /**
     * 「検索する」ボタンを押下すること処理です。
     */
    public void onClick_btnSearch() {
        List<ShichosonEntity> 市町村Lst = get市町村Lst();
        RString 報告年度String = div.getTxtHoukokuY().getText();
        RString 報告年度Year = null;
        if (報告年度String.length() >= 4) {
            報告年度Year = 報告年度String.substring(0, 4);
        }
        int choice = div.getDdlShichoson().getSelectedIndex();
        ShichosonEntity 市町村 = choice > 0 ? 市町村Lst.get(choice - 1) : new ShichosonEntity();
        TokeiTaishoKubun 保険者区分 = choice > 0 ? 市町村.get保険者区分() : null;
        LasdecCode 市町村コード = choice > 0 ? 市町村.get市町村コード() : null;
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<KaigoHokenJigyoHokokuNenpoEntity> 一覧データLst
                = 介護保険特別会計経理状況登録Manager.getJigyoHokokuNenpoList(
                        RString.isNullOrEmpty(報告年度Year) ? FlexibleYear.EMPTY : new FlexibleYear(報告年度Year),
                        市町村コード == null ? LasdecCode.EMPTY : 市町村コード,
                        保険者区分 == null ? TokeiTaishoKubun.空 : 保険者区分);
        List<dgHoseitaishoYoshiki_Row> dgHoseitaishoYoshiki_RowLst = new ArrayList<>();
        for (KaigoHokenJigyoHokokuNenpoEntity 一覧データ : 一覧データLst) {
            TextBoxDate 報告年textBoxDate = new TextBoxDate();
            TextBoxDate 集計対象年textBoxDate = new TextBoxDate();
            報告年textBoxDate.setValue(new RDate(一覧データ.get報告年().getYearValue()));
            集計対象年textBoxDate.setValue(new RDate(一覧データ.get集計対象年().getYearValue()));
            dgHoseitaishoYoshiki_Row dgHoseitaishoYoshiki_Row
                    = new dgHoseitaishoYoshiki_Row(一覧データ.get市町村コード().getColumnValue(), 報告年textBoxDate,
                            集計対象年textBoxDate, null, null, null, 一覧データ.get統計対象区分(),
                            一覧データ.get表番号().getColumnValue(), 一覧データ.get集計番号().getColumnValue());
            dgHoseitaishoYoshiki_Row.setTxtStateYoshikiyon(CODE_0100.equals(一覧データ.get集計番号()) ? 入力済 : 入力未);
            dgHoseitaishoYoshiki_Row.setTxtStateYoShikiyonnoni(CODE_0200.equals(一覧データ.get集計番号()) ? 入力済 : 入力未);
            if (CODE_0301.equals(一覧データ.get集計番号())
                    || CODE_0302.equals(一覧データ.get集計番号())
                    || CODE_0303.equals(一覧データ.get集計番号())) {
                dgHoseitaishoYoshiki_Row.setTxtStateYoskiyonosan(入力済);
            } else {
                dgHoseitaishoYoshiki_Row.setTxtStateYoskiyonosan(入力未);
            }
            dgHoseitaishoYoshiki_RowLst.add(dgHoseitaishoYoshiki_Row);
        }
        div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().setDataSource(dgHoseitaishoYoshiki_RowLst);
        div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().setVisible(true);

    }

    /**
     * 「条件をクリアする」ボタンを押下すること処理です。
     */
    public void onClick_btnClear() {
        RDate date = RDate.getNowDate();
        FlexibleDate 報告年度;
        FlexibleDate 集計年度;
        if (date.getMonthValue() < 6) {
            報告年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 2, date.getMonthValue(), date.getDayValue());
        } else {
            報告年度 = new FlexibleDate(date.getYear().getYearValue(), date.getMonthValue(), date.getDayValue());
            集計年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
        }
        List<ShichosonEntity> 市町村Lst = new ArrayList<>();
        List<KeyValueDataSource> dataSource = getDataSourceFrom市町村Lst(市町村Lst);
        div.getTxtHoukokuY().setValue(報告年度);
        div.getTxtShukeiY().setValue(集計年度);
        div.getDdlShichoson().setDataSource(dataSource);
        div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().setDataSource(new ArrayList<dgHoseitaishoYoshiki_Row>());
        div.getDdlShichoson().setSelectedIndex(0);
    }

    /**
     * 「修正」ボタンを押下すること処理です。
     *
     * @param isuranceInfEntity
     */
    public void onClick_btnModify(InsuranceInformationEntity isuranceInfEntity) {
        onClick_btnModifyOrDelete(true, isuranceInfEntity);
    }

    /**
     * 「削除」ボタンを押下すること処理です。
     *
     * @param isuranceInfEntity
     */
    public void onClick_btnDelete(InsuranceInformationEntity isuranceInfEntity) {
        onClick_btnModifyOrDelete(false, isuranceInfEntity);
    }

    private void onClick_btnModifyOrDelete(Boolean ModifyOrDeleteFlg, InsuranceInformationEntity isuranceInfEntity) {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        dgHoseitaishoYoshiki_Row dgHoseitaishoYoshiki_Row = div.getHoseitaishoYoshikiIchiran().getDgHoseitaishoYoshiki().getClickedItem();
        RString 市町村コード = dgHoseitaishoYoshiki_Row.getTxtShichosonCode();
        RString 様式４入力状況 = dgHoseitaishoYoshiki_Row.getTxtStateYoshikiyon();
        RString 様式４の２入力状況 = dgHoseitaishoYoshiki_Row.getTxtStateYoShikiyonnoni();
        RString 様式４の３入力状況 = dgHoseitaishoYoshiki_Row.getTxtStateYoskiyonosan();
        RString 統計対象区分 = dgHoseitaishoYoshiki_Row.getTxtObjectclassification();
        RString 表番号 = dgHoseitaishoYoshiki_Row.getTxtListNumber();
        ShichosonEntity 市町村 = 介護保険特別会計経理状況登録Manager.getHokenshaJoho(new LasdecCode(市町村コード));
        isuranceInfEntity.set報告年(new FlexibleYear(dgHoseitaishoYoshiki_Row.getTxtHokokuY().getValue().getYear().toString()));
        isuranceInfEntity.set集計対象年(new FlexibleYear(dgHoseitaishoYoshiki_Row.getTxtShukeiY().getValue().getYear().toString()));
        isuranceInfEntity.set統計対象区分(統計対象区分);
        isuranceInfEntity.set市町村コード(new LasdecCode(市町村コード));
        isuranceInfEntity.set表番号(new Code(表番号));
        isuranceInfEntity.set処理フラグ(ModifyOrDeleteFlg ? UPDATE : DELETE);
        isuranceInfEntity.set保険者コード(市町村.get保険者コード());
        isuranceInfEntity.set市町村名称(市町村.get市町村名称());
        isuranceInfEntity.set様式４入力状況(様式４入力状況);
        isuranceInfEntity.set様式４の２入力状況(様式４の２入力状況);
        isuranceInfEntity.set様式４の３入力状況(様式４の３入力状況);
    }

    public enum DBU0050011ViewStateKey {

        is詳細画面から;
    }
}
