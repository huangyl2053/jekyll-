/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0220001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.GetsureiShoriDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.GeTuReiSyoRiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Icon;
import jp.co.ndensan.reams.uz.uza.ui.binding.IconType;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 完了処理・センター送信のHandlerクラスです。
 *
 * @reamsid_L DBE-1520-010 lishengli
 */
public class GetsureiShoriHandler {

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
     * @param 最大取得件数 最大取得件数
     * @param 最大取得件数上限 最大取得件数上限
     */
    public void initialize(Decimal 最大取得件数, Decimal 最大取得件数上限) {
        div.getTxtDispMax().setValue(最大取得件数);
        div.getTxtDispMax().setMaxValue(最大取得件数上限);
    }

    /**
     * 画面の内容で検索条件を生成します。
     *
     * @param 最大取得件数 最大取得件数
     * @param 市町村コード LasdecCode
     * @return 検索条件
     */
    public YokaigoNinteiTaskListParameter create検索条件(Decimal 最大取得件数, LasdecCode 市町村コード) {
        return YokaigoNinteiTaskListParameter.createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), new RString(""), 最大取得件数, 市町村コード);
    }

    /**
     * 検索結果から対象者一覧を設定します。
     *
     * @param 検索結果 検索結果
     */
    public void set対象者一覧(SearchResult<GeTuReiSyoRiBusiness> 検索結果) {
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        Icon warningIcon = new Icon();
        warningIcon.setIcon(IconType.Warning);
        Icon noIcon = new Icon();
        noIcon.setVisible(false);
        for (GeTuReiSyoRiBusiness business : 検索結果.records()) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            if (business.is遅延()) {
                row.setDelay(warningIcon);
            } else {
                row.setDelay(noIcon);
            }
            row.setShoKisaiHokenshaNo(business.get証記載保険者番号().value());
            if (business.getセンター送信情報抽出年月日() != null || !business.getセンター送信情報抽出年月日().isEmpty()) {
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
        div.getTxtKanryouKano().setValue(new RString(String.valueOf(completeCount)));
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
