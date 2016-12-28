/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1030001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1030001.KanryoShoriShinsaUketsukeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1030001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKeTuKeBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteitasklist.YokaigoNinteiTaskListFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 完了処理・審査受付のHandlerクラスです。
 *
 * @reamsid_L DBE-2060-010 wangrenze
 */
public class KanryoShoriShinsaUketsukeHandler {

    private final KanryoShoriShinsaUketsukeDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KanryoShoriShinsaUketsukeDiv
     */
    public KanryoShoriShinsaUketsukeHandler(KanryoShoriShinsaUketsukeDiv div) {
        this.div = div;
    }

    /**
     * 完了処理・審査受付の初期化です。
     *
     */
    public void initialize() {
        set最大表示件数();
        initDataGrid();
    }

    /**
     * 要介護認定完了情報追加の処理です。
     *
     * @param 申請書管理番号 RString
     * @return NinteiKanryoJoho
     */
    public NinteiKanryoJoho 要介護認定完了情報が追加(RString 申請書管理番号) {
        NinteiKanryoJoho ninteiKanryoJoho = new NinteiKanryoJoho(new ShinseishoKanriNo(申請書管理番号));
        return ninteiKanryoJoho.createBuilderForEdit().set認定申請情報登録完了年月日(FlexibleDate.getNowDate()).build();
    }

    /**
     * 要介護認定完了情報更新の処理です。
     *
     * @param ninteiKanryoJoho NinteiKanryoJoho
     * @return NinteiKanryoJoho
     */
    public NinteiKanryoJoho 要介護認定完了情報更新(NinteiKanryoJoho ninteiKanryoJoho) {

        return ninteiKanryoJoho.createBuilderForEdit().set認定申請情報登録完了年月日(FlexibleDate.getNowDate()).build();
    }

    private void set最大表示件数() {
        div.getTxtMaxCount().setMaxValue(new Decimal(
                DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtMaxCount().setMaxLength(Integer.toString(div.getTxtMaxCount().getMaxValue().intValue()).length());
        div.getTxtMaxCount().setValue(
                new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * DataGridを更新します。
     */
    public void initDataGrid() {
        List<dgNinteiTaskList_Row> rows = new ArrayList<>();
        SearchResult<ShinSaKeTuKeBusiness> 審査受付 = get審査受付List();
        List<ShinSaKeTuKeBusiness> リスト = 審査受付.records();
        int totalCount = 審査受付.totalCount();
        put審査受付List(リスト);
        for (ShinSaKeTuKeBusiness value : リスト) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(value.get保険者() == null ? RString.EMPTY : value.get保険者());
            if (value.get認定申請年月日() != null && !value.get認定申請年月日().isEmpty()) {
                row.getNinteiShinseiDay().setValue(new RDate(value.get認定申請年月日().toString()));
            }
            row.setHihoNumber(value.get被保険者番号() == null ? RString.EMPTY : value.get被保険者番号());
            row.setHihoShimei(value.get被保険者氏名() == null ? RString.EMPTY : value.get被保険者氏名().value());
            row.setShinseiKubunShinseiji(value.get認定申請区分_申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(value.get認定申請区分_申請時コード().getKey()).get名称());
            row.setShinseishoKanriNo(value.get申請書管理番号() == null ? RString.EMPTY : value.get申請書管理番号().value());
            setAccessLog(row.getShinseishoKanriNo());
            rows.add(row);
        }
        div.getDgNinteiTaskList().setDataSource(rows);
        div.getDgNinteiTaskList().getGridSetting().setSelectedRowCount(totalCount);
        div.getDgNinteiTaskList().getGridSetting().setLimitRowCount(div.getTxtMaxCount().getValue().intValue());
        div.getTxtCompleteCount().setValue(new Decimal(totalCount));
    }

    private SearchResult<ShinSaKeTuKeBusiness> get審査受付List() {
        Decimal 最大件数 = div.getTxtMaxCount().getValue();
        LasdecCode 市町村コード = get市町村コード();
        SearchResult<ShinSaKeTuKeBusiness> 審査受付List = YokaigoNinteiTaskListFinder.createInstance().
                get審査受付モード(
                        YokaigoNinteiTaskListParameter.createParameter(
                                ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), RString.EMPTY, 最大件数, 市町村コード));
        return 審査受付List;
    }

    private void put審査受付List(List<ShinSaKeTuKeBusiness> list) {
        if (!list.isEmpty()) {
            ShinSaKaiBusiness 前審査受付Model = YokaigoNinteiTaskListFinder.createInstance().
                    get前審査受付(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
            if (前審査受付Model.get要介護認定完了情報Lsit() == null) {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
            } else {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前審査受付Model.get要介護認定完了情報Lsit()));
            }
        } else {
            ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
        }
    }

    private void setAccessLog(RString 申請書管理番号) {
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                new RString("申請書管理番号"), 申請書管理番号));
        AccessLogger.log(AccessLogType.照会, personalData);
    }

    private LasdecCode get市町村コード() {
        List<HokenshaSummary> hokenshaList = new ArrayList<>(
                HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護認定).getAll());
        if (!hokenshaList.isEmpty() && hokenshaList.size() == 1) {
            return hokenshaList.get(0).get市町村コード();
        }
        return LasdecCode.EMPTY;
    }
}
