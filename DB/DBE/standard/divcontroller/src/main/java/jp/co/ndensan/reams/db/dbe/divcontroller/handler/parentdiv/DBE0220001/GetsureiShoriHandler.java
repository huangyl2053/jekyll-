/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0220001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.KanryoShoriStatus;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.GetsureiShoriDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.GeTuReiSyoRiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 完了処理・センター送信のHandlerクラスです。
 *
 * @reamsid_L DBE-1520-010 lishengli
 */
public class GetsureiShoriHandler {

    private static final String JotaiColumnName = "jyotai";
    private final GetsureiShoriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div GetsureiShoriDiv
     */
    public GetsureiShoriHandler(GetsureiShoriDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・センター送信の初期化です。
     *
     * @param 状態区分 状態区分
     * @param 最大取得件数 最大取得件数
     * @param 最大取得件数上限 最大取得件数上限
     */
    public void initialize(RString 状態区分, Decimal 最大取得件数, Decimal 最大取得件数上限) {
        div.getRadJyotaiKubun().setSelectedKey(状態区分);
        div.getTxtDispMax().setValue(最大取得件数);
        div.getTxtDispMax().setMaxValue(最大取得件数上限);
    }

    /**
     * 画面の内容で検索条件を生成します。
     *
     * @param 状態区分 状態区分
     * @param 最大取得件数 最大取得件数
     * @return 検索条件
     */
    public YokaigoNinteiTaskListParameter create検索条件(RString 状態区分, Decimal 最大取得件数) {
        return YokaigoNinteiTaskListParameter.createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), 状態区分, 最大取得件数);
    }

    /**
     * 検索結果表示時の状態を設定します。
     *
     * @param 状態区分 状態区分
     */
    public void set検索結果表示時の制御(RString 状態区分) {

        KanryoShoriStatus 状態 = KanryoShoriStatus.toValue(状態区分);
        if (状態 == KanryoShoriStatus.未処理) {
            div.getTxtMisyori().setDisplayNone(false);
            div.getTxtKanryouKano().setDisplayNone(true);
            div.getTxtGokei().setDisplayNone(true);
        } else if (状態 == KanryoShoriStatus.完了可能) {
            div.getTxtMisyori().setDisplayNone(true);
            div.getTxtKanryouKano().setDisplayNone(false);
            div.getTxtGokei().setDisplayNone(true);
        } else {
            div.getTxtMisyori().setDisplayNone(false);
            div.getTxtKanryouKano().setDisplayNone(false);
            div.getTxtGokei().setDisplayNone(false);
        }
    }

    /**
     * 検索結果から対象者一覧を設定します。
     *
     * @param 検索結果 検索結果
     */
    public void set対象者一覧(SearchResult<GeTuReiSyoRiBusiness> 検索結果) {
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        int notCount = 0;
        for (GeTuReiSyoRiBusiness business : 検索結果.records()) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();

            if (business.getセンター送信情報抽出年月日() == null || business.getセンター送信情報抽出年月日().isEmpty()) {
                row.setJyotai(KanryoShoriStatus.未処理.get略称());
                row.setCellBgColor(JotaiColumnName, DataGridCellBgColor.bgColorRed);
                notCount++;
            } else if (business.getセンター送信情報抽出年月日() != null || !business.getセンター送信情報抽出年月日().isEmpty()) {
                row.setJyotai(KanryoShoriStatus.完了可能.get略称());
                row.setCellBgColor(JotaiColumnName, DataGridCellBgColor.bgColorNormal);
                completeCount++;
            }
            row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
            if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
                row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
            }
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null || RString.isNullOrEmpty(business.get認定申請区分申請時コード().value())
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().value()).get名称());
            row.setShinseiKubunHorei(business.get認定申請区分法令コード() == null || RString.isNullOrEmpty(business.get認定申請区分法令コード().value())
                    ? RString.EMPTY : NinteiShinseiHoreiCode.toValue(business.get認定申請区分法令コード().value()).get名称());
            if (business.getセンター送信年月日() != null && RDate.canConvert(business.getセンター送信年月日().seireki().toDateString())) {
                row.getGetsureiShoriKanryoDay().setValue(new RDate(business.getセンター送信年月日().toString()));
            }
            if (business.getセンター送信情報抽出年月日() != null && RDate.canConvert(business.getセンター送信情報抽出年月日().seireki().toDateString())) {
                row.getCenterSoshinDay().setValue(new RDate(business.getセンター送信情報抽出年月日().toString()));
            }
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            rowList.add(row);
        }
        Decimal 最大表示件数 = div.getTxtDispMax().getValue();
        div.getTxtMisyori().setValue(new RString(String.valueOf(notCount)));
        div.getTxtKanryouKano().setValue(new RString(String.valueOf(completeCount)));
        div.getTxtGokei().setValue(new RString(String.valueOf(検索結果.records().size())));
        div.getDgNinteiTaskList().setDataSource(rowList);
        div.getDgNinteiTaskList().getGridSetting().setLimitRowCount(最大表示件数.intValue());
        div.getDgNinteiTaskList().getGridSetting().setSelectedRowCount(検索結果.totalCount());
    }

    /**
     * 要介護認定完了情報更新の処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     * @return 要介護認定完了情報
     */
    public NinteiKanryoJoho 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {
        return ninteiKanryoJoho.createBuilderForEdit().setセンター送信年月日(
                new FlexibleDate(RDate.getNowDate().toDateString())).build();
    }

}
