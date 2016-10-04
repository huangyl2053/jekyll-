/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashikakuteisei.IryoHokenJoho;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashikakuteisei.RoreiFukushiJoho;
import jp.co.ndensan.reams.db.dba.business.core.sikakuidouteisei.ShikakuRirekiJoho;
import jp.co.ndensan.reams.db.dba.business.core.sikakuidouteisei.SikakuIdouTeiseiJoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011.SikakuIdouTeiseiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryoHokenRirekiState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RofukuNenkinState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 資格異動訂正の画面処理Handlerクラスです。
 *
 * @reamsid_L DBA-0521-010 dongyabin
 */
public class SikakuIdouTeiseiHandler {

    private static final RString 認定履歴ボタン = new RString("HihokenrirekiNashiMode");
    private static final RString 被保履歴ボタン = new RString("NinteirirekiNashiMode");
//    private static final RString チェックNG = new RString("チェックNG");
//    private static final RString 状態_登録 = new RString("登録");
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
     * @return SikakuIdouTeiseiJoho
     */
    public SikakuIdouTeiseiJoho onLoad(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        kaigoShikakuKihon_onload(被保険者番号, 表示モード);
        kaigoNinteiAtenaInfo_onload(識別コード);

        //新初期化
        HihokenshaDaichoManager manager = HihokenshaDaichoManager.createInstance();
        List<HihokenshaDaicho> hihoDaichoList = manager.get最新被保険者台帳(被保険者番号);
        HihokenshaDaichoList sortedHihoDaichoList = new HihokenshaDaichoList(ItemList.of(hihoDaichoList));
        IItemList<HihokenshaDaicho> tokusoList = sortedHihoDaichoList.to資格得喪List();
        div.getShikakuShutokuJoho().getCcdShikakuTokusoRireki().initialize(tokusoList);

        ArrayList<HihokenshaDaicho> serialHihoDaicho = new ArrayList<>();
        serialHihoDaicho.addAll(hihoDaichoList);
        ViewStateHolder.put(ViewStateKeys.対象者_被保険者台帳情報, serialHihoDaicho);

        if (div.getShikakuShutokuJoho().getCcdShikakuTokusoRireki().getDataGridDataSource().isEmpty()) {
            div.setReadOnly(true);
            throw new ApplicationException(
                    UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace("被保履歴情報"));
        }

        setButtonDisable();

        div.getCcdIryoHokenDialogButton().initialize(被保険者番号, 識別コード, IryoHokenRirekiState.登録);
        div.getCcdRofukuNenkinDialogButton().initialize(被保険者番号, 識別コード, RofukuNenkinState.登録);

        SikakuIdouTeiseiJoho joho = new SikakuIdouTeiseiJoho();
        joho.setIryoHokenJohoList(set初期化時の医療保険情報());
        joho.setRoreiFukushiJohoList(set初期化時の老福年金情報(識別コード));
        return joho;
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

    private List<IryoHokenJoho> set初期化時の医療保険情報() {
        List<IryoHokenJoho> oldList = new ArrayList<>();
        //初期化はダイアログ内で行うので不要
//        for (dgIryohokenIchiran_Row row : div.getShikakuShutokuJoho().getTplIryoHoken()
//                .getIryoHokenRirekii().getCcdIryoHokenRireki().getDataGridList()) {
//            IryoHokenJoho joho = new IryoHokenJoho();
//            joho.set医療保険加入年月日(row.getKanyuDate().getValue());
//            joho.set医療保険種別コード(row.getShubetsuCode());
//            joho.set医療保険者名称(row.getHokenshaName());
//            joho.set医療保険者番号(row.getHokenshaCode());
//            joho.set医療保険脱退年月日(row.getDattaiDate().getValue());
//            joho.set医療保険記号番号(row.getKigoNo());
//            joho.set履歴番号(row.getRirekiNo().getValue().intValue());
//            joho.set市町村コード(new LasdecCode(row.getShichosonCode()));
//            joho.set識別コード(new ShikibetsuCode(row.getShikibetsuCode()));
//            oldList.add(joho);
//        }
        return oldList;
    }

    private List<RoreiFukushiJoho> set初期化時の老福年金情報(ShikibetsuCode 識別コード) {
        List<RoreiFukushiJoho> roreiFukushiJohoList = new ArrayList<>();
        //初期化はダイアログ内で行うので不要
//        for (datagridRireki_Row row : div.getShikakuShutokuJoho()
//                .getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin().getDataGridList()) {
//            RoreiFukushiJoho joho = new RoreiFukushiJoho();
//            joho.set識別コード(識別コード);
//            joho.set状態(row.getJotai());
//            joho.set受給開始年月日(rdateToFlexibleDate(row.getStartDate().getValue()));
//            joho.set受給廃止年月日(rdateToFlexibleDate(row.getEndDate().getValue()));
//            roreiFukushiJohoList.add(joho);
//        }
        return roreiFukushiJohoList;
    }
//
//    private FlexibleDate stringToFlexibleDate(RString date) {
//        FlexibleDate flexDate = FlexibleDate.EMPTY;
//        if (!RString.isNullOrEmpty(date)) {
//            RDate date_tmp = new RDate(date.toString());
//            flexDate = new FlexibleDate(date_tmp.toDateString());
//        }
//        return flexDate;
//    }
//
//    private FlexibleDate rdateToFlexibleDate(RDate date) {
//        FlexibleDate flexDate = FlexibleDate.EMPTY;
//        if (date != null) {
//            flexDate = new FlexibleDate(date.toDateString());
//        }
//        return flexDate;
//    }

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

            //選択した行の資格取得日を保持する。
            ViewStateHolder.put(ViewStateKeys.対象者_資格取得日, row.getShutokuDate().getValue());
        }

        return joho;
    }

    /**
     * 保存処理します。
     *
     * @param 識別コード 識別コード
     * @param joho 初期化時の医療保険情報
     */
    public void save(ShikibetsuCode 識別コード, SikakuIdouTeiseiJoho joho) {
        //TODO 城間 ここでは資格の訂正情報が存在するかのチェックが本来必要。以下の情報はメインではない為、チェック不要で更新して良い
//        HihokenshaShikakuTeiseiManager service = HihokenshaShikakuTeiseiManager.createInstance();
//        if (チェックNG.equals(service.checkIryoHoken(joho.getIryoHokenJohoList(), set初期化時の医療保険情報()))
//                && チェックNG.equals(service.checkRofukuNenkin(joho.getRoreiFukushiJohoList(), set初期化時の老福年金情報(識別コード)))) {
//            throw new ApplicationException(UrErrorMessages.保存データなし.getMessage());
//        }
        //div.getShikakuShutokuJoho().getTplIryoHoken().getIryoHokenRirekii().getCcdIryoHokenRireki().save();
        //div.getShikakuShutokuJoho().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin().click_Save();
        div.getCcdIryoHokenDialogButton().save();
        div.getCcdRofukuNenkinDialogButton().save();
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

}
