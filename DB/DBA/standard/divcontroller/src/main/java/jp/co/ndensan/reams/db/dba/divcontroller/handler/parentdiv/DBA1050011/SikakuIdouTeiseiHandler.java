/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.sikakuidouteisei.ShikakuRirekiJoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011.SikakuIdouTeiseiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryoHokenRirekiState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RofukuNenkinState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshashikakuteisei.HihokenshaShikakuTeiseiManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 資格異動訂正の画面処理Handlerクラスです。
 *
 * @reamsid_L DBA-0521-010 dongyabin
 */
public class SikakuIdouTeiseiHandler {

    private static final RString 認定履歴ボタン = new RString("HihokenrirekiNashiMode");
    private static final RString 被保履歴ボタン = new RString("NinteirirekiNashiMode");
    private static final RString 表示モード = new RString("HihokenrirekiNashiMode");
    private final SikakuIdouTeiseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public SikakuIdouTeiseiHandler(SikakuIdouTeiseiDiv div) {
        this.div = div;
    }

    /**
     * 画面を初期化します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     */
    public void onLoad(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        kaigoShikakuKihon_onload(被保険者番号, 表示モード);
        kaigoNinteiAtenaInfo_onload(識別コード);

        HihokenshaDaichoManager manager = HihokenshaDaichoManager.createInstance();
        List<HihokenshaDaicho> hihoDaichoList = manager.get最新被保険者台帳(被保険者番号);
        initialize資格得喪失履歴(hihoDaichoList);

        ArrayList<HihokenshaDaicho> serialHihoDaicho = new ArrayList<>();
        serialHihoDaicho.addAll(hihoDaichoList);
        ViewStateHolder.put(ViewStateKeys.対象者_被保険者台帳情報, serialHihoDaicho);
        setButtonDisable();

        div.getCcdIryoHokenDialogButton().initialize(被保険者番号, 識別コード, IryoHokenRirekiState.登録);
        div.getCcdRofukuNenkinDialogButton().initialize(被保険者番号, 識別コード, RofukuNenkinState.登録);
    }

    /**
     * 資格の取得・喪失履歴を初期化します。
     *
     * @param hihoDaichoList 初期化する際の元データとなるリスト
     */
    public void initialize資格得喪失履歴(List<HihokenshaDaicho> hihoDaichoList) {
        HihokenshaDaichoList sortedHihoDaichoList = new HihokenshaDaichoList(ItemList.of(hihoDaichoList));
        IItemList<HihokenshaDaicho> tokusoList = sortedHihoDaichoList.to論理削除データ除外List();
        tokusoList = new HihokenshaDaichoList(tokusoList).to資格得喪List();
        div.getShikakuShutokuJoho().getCcdShikakuTokusoRireki().initialize(tokusoList);
    }

    /**
     * 資格の取得・喪失履歴に表示されている項目を、詳細画面での入力結果に合わせて最新化します。
     *
     * @param hihoDaichoList 初期化する際の元データとなるリスト
     */
    public void update資格得喪失履歴(List<HihokenshaDaicho> hihoDaichoList) {
        FlexibleDate shikakuShutokuDate = ViewStateHolder.get(ViewStateKeys.対象者_資格取得日, FlexibleDate.class);
        FlexibleDate changedShikakuShutokuDate = ViewStateHolder.get(ViewStateKeys.対象者_変更後資格取得日, FlexibleDate.class);
        ArrayList<FlexibleDate> sakujoHihoDataShutokuDateList = ViewStateHolder.get(ViewStateKeys.対象者_削除対象取得日, ArrayList.class);

        HihokenshaDaichoList sortedHihoDaichoList = new HihokenshaDaichoList(ItemList.of(hihoDaichoList));
        IItemList<HihokenshaDaicho> tokusoList = sortedHihoDaichoList.to論理削除データ除外List();
        tokusoList = new HihokenshaDaichoList(tokusoList).toOneSeasonList(changedShikakuShutokuDate);
        tokusoList = new HihokenshaDaichoList(tokusoList).to資格得喪List();

        HihokenshaDaicho daicho = tokusoList.findJustOne().get();
        div.getShikakuShutokuJoho().getCcdShikakuTokusoRireki().updateGridData(daicho, shikakuShutokuDate, sakujoHihoDataShutokuDateList);
    }

    /**
     * ボタンの有効無効設定をおこないます。
     */
    public void setButtonDisable() {
        div.getShikakuShutokuJoho().getCcdShikakuTokusoRireki().set追加するボタン(false);
        List<dgShikakuShutokuRireki_Row> dataSource = new ArrayList<>();
        for (dgShikakuShutokuRireki_Row row : div.getShikakuShutokuJoho()
                .getCcdShikakuTokusoRireki().getDataGridDataSource()) {
            row.setDeleteButtonState(DataGridButtonState.Enabled);
            row.setModifyButtonState(DataGridButtonState.Enabled);
            dataSource.add(row);
        }
        div.getShikakuShutokuJoho().getCcdShikakuTokusoRireki().setDataGridDataSource(dataSource);
    }

    /**
     * 画面遷移のパラメータの設定します。
     *
     * @param 状態 状態
     * @return ShikakuRirekiJoho
     */
    public ShikakuRirekiJoho setパラメータ(RString 状態) {
        ShikakuRirekiJoho joho = new ShikakuRirekiJoho();
        if (!new RString("追加").equals(状態)) {
            dgShikakuShutokuRireki_Row row = div.getShikakuShutokuJoho().getCcdShikakuTokusoRireki().getDataGridSelectItem();
            joho.setDaNo(row.getDaNo());
            joho.setHihokenshaKubun(row.getHihokenshaKubun());
            joho.setHihokenshaKubunKey(row.getHihokenshaKubunKey());
            joho.setHihokenshaNo(row.getHihokenshaNo());
            joho.setJutokuKubun(row.getJutokuKubun());
            joho.setKyuHokensha(row.getKyuHokenshaCode());
            joho.setShikakuShutokuJiyuCode(row.getShikakuShutokuJiyuCode());
            joho.setShikibetsuCode(row.getShikibetsuCode());
            joho.setShoriDateTime(row.getShoriDateTime());
            joho.setShozaiHokensha(row.getShozaiHokenshaCode());
            joho.setShutokuDate(row.getShutokuDate().getValue());
            joho.setShutokuJiyu(row.getShutokuJiyu());
            joho.setShutokuJiyuKey(row.getShutokuJiyuKey());
            joho.setShutokuTodokedeDate(row.getShutokuTodokedeDate().getValue());
            joho.setSochimotoHokensha(row.getSochimotoHokenshaCode());
            joho.setSoshitsuDate(row.getSoshitsuDate().getValue());
            joho.setSoshitsuJiyu(row.getSoshitsuJiyu());
            joho.setSoshitsuJiyuKey(row.getSoshitsuJiyuKey());
            joho.setSoshitsuTodokedeDate(row.getSoshitsuTodokedeDate().getValue());
            joho.setState(row.getState());

            ViewStateHolder.put(ViewStateKeys.対象者_資格取得日, row.getShutokuDate().getValue());
            ViewStateHolder.put(ViewStateKeys.対象者_変更後資格取得日, row.getShutokuDate().getValue());
        }

        return joho;
    }

    /**
     * 保存処理します。
     *
     * @param 識別コード 識別コード
     * @param joho 初期化時の医療保険情報
     * @param models 施設入退所情報Models
     */
    public void save(ShikibetsuCode 識別コード, List<HihokenshaDaicho> joho, Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> models) {
        List<IryohokenKanyuJokyo> iryoHokenList = div.getCcdIryoHokenDialogButton().get医療保険履歴();
        Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> rohukuNenkinJukyusha = div.getCcdRofukuNenkinDialogButton().get老福年金();
        HihokenshaShikakuTeiseiManager.createInstance().save資格異動訂正データ(識別コード, joho, models, iryoHokenList, rohukuNenkinJukyusha);
    }

    private void kaigoShikakuKihon_onload(HihokenshaNo 被保険者番号, RString 表示モード) {
        if (!RString.isNullOrEmpty(表示モード)) {
            if (認定履歴ボタン.equals(表示モード)) {
                div.getKihonJoho().getCcdKaigoShikakuKihon().set認定履歴ボタンDisable(false);
                div.getKihonJoho().getCcdKaigoShikakuKihon().set被保履歴ボタンDisable(true);
            } else if (被保履歴ボタン.equals(表示モード)) {
                div.getKihonJoho().getCcdKaigoShikakuKihon().set認定履歴ボタンDisable(true);
                div.getKihonJoho().getCcdKaigoShikakuKihon().set被保履歴ボタンDisable(false);
            }
        }
        if (!RString.isNullOrEmpty(被保険者番号.getColumnValue())) {
            div.getKihonJoho().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        }
    }

    private void kaigoNinteiAtenaInfo_onload(ShikibetsuCode 識別コード) {
        div.getKihonJoho().getCcdKaigoAtenaInfo().initialize(識別コード);
    }

    /**
     * 引数から受けとった被保険者台帳データのうち、削除対象の取得日を持つデータを全て論理削除します。
     *
     * @param 削除対象 削除対象の被保険者台帳List
     * @param 取得日List 削除対象の日付をまとめたList
     * @return 論理削除された被保険者台帳データ
     */
    public List<HihokenshaDaicho> delete被保険者(List<HihokenshaDaicho> 削除対象, List<FlexibleDate> 取得日List) {
        List<HihokenshaDaicho> deleteList = new ArrayList<>();
        for (HihokenshaDaicho daicho : 削除対象) {
            if (取得日List.contains(daicho.get資格取得年月日())) {
                deleteList.add(daicho.createBuilderForEdit().set論理削除フラグ(true).build());
            }
        }
        return deleteList;
    }

}
