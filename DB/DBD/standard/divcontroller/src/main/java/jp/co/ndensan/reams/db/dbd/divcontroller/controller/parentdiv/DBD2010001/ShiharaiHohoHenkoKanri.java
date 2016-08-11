/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenkoBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.ShiharaiHohoHenkoGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.ShiharaiHohoHenkoGengakuBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTaino;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShoriKubun;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010001.DBD2010001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010001.DBD2010001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010001.ShiharaiHohoHenkoKanriDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010001.dgShiharaiHohoHenkoRireki_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2010001.ShiharaiHohoHenkoKanriHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2010001.ShiharaiHohoHenkoKanriHandler.ShiharaiHohoHenkoKanriEnum;
import jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko.ShiharaiHohoHenkoService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 支払方法変更管理のクラスです．
 *
 * @reamsid_L DBD-3620-040 xuyue
 */
public class ShiharaiHohoHenkoKanri {

    private static final RString ボタン１号予告者登録 = new RString("btnIchigoYokokushaToroku1");
    private static final RString ボタン１号弁明書受理 = new RString("btnIchigoBemmeishoJuri");
    private static final RString ボタン１償還払い化登録 = new RString("btnShokanBaraikaToroku");
    private static final RString ボタン１償還払い化終了申請 = new RString("btnShokanBaraikaShuryoShinsei");
    private static final RString ボタン１給付一時差止登録 = new RString("btnKyufuIchijiSashitomeToroku");
    private static final RString ボタン１保険料控除登録 = new RString("btnHokenryoKojoToroku");
    private static final RString ボタン１給付額減額登録 = new RString("btnKyufugakuGengakuToroku");
    private static final RString ボタン１減額免除申請 = new RString("btnGengakuMenjoShinsei");
    private static final RString ボタン１免除解除再転入 = new RString("btnMenjoKaijoAndSaitennyu");
    private static final RString ボタン２号予告者登録 = new RString("btnNigoYokokushaToroku");
    private static final RString ボタン２号弁明書受理 = new RString("btnNigoBemmeishoJuri");
    private static final RString ボタン２号一時差止登録 = new RString("btnNigoIchijiSashitomeToroku");
    private static final RString ボタン２号一時差止解除 = new RString("btnNigoIchijiSashitomeKaijo");

    /**
     * 画面初期化です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onLoad(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();

        div.getShiharaiHohoHenkoKanriMain().getCcdTaishoshaInfo().initialize(識別コード);
        div.getShiharaiHohoHenkoKanriMain().getCcdShikakuKihon().initialize(被保険者番号);

        boolean 処理可能 = true;
        ShiharaiHohoHenkoService service = ShiharaiHohoHenkoService.createIntance();
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            処理可能 = false;
        } else if (!service.is受給者Or事業対象者(被保険者番号, new FlexibleDate(RDate.getNowDate().toDateString()))) {
            処理可能 = false;
        }

        if (!ResponseHolder.isReRequest() && !処理可能) {
            getHandler(div).処理不可の非活性設定();
            InformationMessage message = new InformationMessage(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode(),
                    DbdInformationMessages.受給共通_被保データなし.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        } else if (new RString(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).forwardWithEventName(DBD2010001TransitionEventName.検索条件へ).respond();
        }

        ArrayList<ShiharaiHohoHenko> dataList = service.find支払方法変更(被保険者番号);
        ViewStateHolder.put(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, dataList);
        ViewStateHolder.put(ShiharaiHohoHenkoKanriEnum.初期の支払方法変更の情報リスト, dataList);
        getHandler(div).画面初期化(識別コード, 被保険者番号, dataList);
        return ResponseData.of(div).setState(DBD2010001StateName.支払方法変更管理);
    }

    /**
     * 支払変更管理一覧の「選択」ボタンを押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onClick_btnModify(ShiharaiHohoHenkoKanriDiv div) {
        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);
        ShiharaiHohoHenko data = getHandler(div).get支払方法変更情報FromViewState(dataList);
        getHandler(div).ボタン群の制御(data);

        return ResponseData.of(div).respond();
    }

    /**
     * 支払変更管理一覧の「削除」ボタンを押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onClick_btnDelete(ShiharaiHohoHenkoKanriDiv div) {
        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);
        ShiharaiHohoHenko deleteData = getHandler(div).
                get支払方法変更情報FromViewState(ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.初期の支払方法変更の情報リスト, ArrayList.class));
        dataList.remove(getHandler(div).get支払方法変更情報FromViewState(dataList, deleteData));
        deleteData = setDeleteState(deleteData);
        dataList.add(deleteData);
        ViewStateHolder.put(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, dataList);
        getHandler(div).支払変更管理一覧に削除();

        return ResponseData.of(div).respond();
    }

    /**
     * 「受給情報を表示する」ボタン押下の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnJukyuJohoDialog(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン群開く前、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_dataPassing(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(getHandler(div).getボタンの支払方法変更処理区分());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);

            if (ボタン１号予告者登録.equals(div.getFocusPositionID())) {
                div.setKey_MaxRirekiNo(getHandler(div).
                        get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._１号償還払い化.getコード()));
            } else if (ボタン１給付額減額登録.equals(div.getFocusPositionID())) {
                div.setKey_MaxRirekiNo(getHandler(div).
                        get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._１号給付額減額.getコード()));
            } else if (ボタン２号予告者登録.equals(div.getFocusPositionID())) {
                div.setKey_MaxRirekiNo(getHandler(div).
                        get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._２号差止.getコード()));
            } else {
                div.setKey_MaxRirekiNo(RString.EMPTY);
            }

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));

            if (ボタン１号予告者登録.equals(div.getFocusPositionID()) || ボタン１償還払い化登録.equals(div.getFocusPositionID())) {
                div.setKey_MaxRirekiNo(getHandler(div).
                        get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._１号償還払い化.getコード()));
            } else if (ボタン１給付額減額登録.equals(div.getFocusPositionID())) {
                div.setKey_MaxRirekiNo(getHandler(div).
                        get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._１号給付額減額.getコード()));
            } else if (ボタン２号予告者登録.equals(div.getFocusPositionID())
                    || ボタン２号一時差止登録.equals(div.getFocusPositionID())) {
                div.setKey_MaxRirekiNo(getHandler(div).
                        get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._２号差止.getコード()));
            } else {
                div.setKey_MaxRirekiNo(RString.EMPTY);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * １号予告者登録、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnIchigoYokokushaToroku1(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun._1号予告者登録.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(getHandler(div).
                    get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._１号償還払い化.getコード()));

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(getHandler(div).
                    get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._１号償還払い化.getコード()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * １号弁明書受理、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnIchigoBemmeishoJuri(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun._1号弁明書受理.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(RString.EMPTY);

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 償還払い化登録、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnShokanBaraikaToroku(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun.償還払い化登録.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(RString.EMPTY);

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(getHandler(div).
                    get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._１号償還払い化.getコード()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 償還払い化終了申請、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnShokanBaraikaShuryoShinsei(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun.償還払い化終了申請.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(RString.EMPTY);

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 給付一時差止登録、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnKyufuIchijiSashitomeToroku(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun.給付一時差止登録.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(RString.EMPTY);

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 保険料控除登録、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnHokenryoKojoToroku(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun.保険料控除登録.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(RString.EMPTY);

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 給付額減額登録、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnKyufugakuGengakuToroku(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun.給付額減額登録.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(getHandler(div).
                    get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._１号給付額減額.getコード()));

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(getHandler(div).
                    get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._１号給付額減額.getコード()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 減額免除申請、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnGengakuMenjoShinsei(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun.減額免除申請.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(RString.EMPTY);

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 免除解除／再転入、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnMenjoKaijoAndSaitennyu(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun.免除解除_再転入.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(RString.EMPTY);

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ２号予告者登録、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnNigoYokokushaToroku(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun._2号予告者登録.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(getHandler(div).
                    get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._２号差止.getコード()));

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(getHandler(div).
                    get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._２号差止.getコード()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ２号弁明書受理、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnNigoBemmeishoJuri(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun._2号弁明書受理.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(RString.EMPTY);

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ２号一時差止登録、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnNigoIchijiSashitomeToroku(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun._2号一時差止登録.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(RString.EMPTY);

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(getHandler(div).
                    get最大履歴番号plus1By支払方法変更登録区分(被保険者番号, dataList, ShiharaiHenkoKanriKubun._２号差止.getコード()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ２号一時差止解除、データパッシング用データ生成します。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onBeforeOpenDialog_btnNigoIchijiSashitomeKaijo(ShiharaiHohoHenkoKanriDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);

        div.setKey_HihokenshaNo(被保険者番号.getColumnValue());
        div.setKey_Button(ShoriKubun._2号一時差止解除.getコード());
        if (div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow() == null) {
            div.setKey_ShiharaiHohoHenkoKanri(RString.EMPTY);
            div.setKey_MaxRirekiNo(RString.EMPTY);

        } else {
            div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(getHandler(div).get支払方法変更情報FromViewState(dataList)));
            div.setKey_MaxRirekiNo(RString.EMPTY);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログ画面が閉じる処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onOkClose_dataPassing(ShiharaiHohoHenkoKanriDiv div) {
        ShiharaiHohoHenko dialog支払方法変更 = DataPassingConverter.deserialize(div.getKey_ShiharaiHohoHenkoKanri(), ShiharaiHohoHenko.class);

        ArrayList<ShiharaiHohoHenko> dataList = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);
        if (EntityDataState.Added.equals(dialog支払方法変更.getState())) {
            dataList.add(dialog支払方法変更);
            ViewStateHolder.put(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, dataList);
            getHandler(div).支払変更管理一覧に追加(dialog支払方法変更);
        } else if (EntityDataState.Modified.equals(dialog支払方法変更.getState())) {
            dataList.remove(getHandler(div).get支払方法変更情報FromViewState(dataList));
            dataList.add(dialog支払方法変更);
            ViewStateHolder.put(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, dataList);
            getHandler(div).支払変更管理一覧に更新(dialog支払方法変更);
        }

        getHandler(div).画面項目の制御();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタン押下時の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onClick_btnUpdate(ShiharaiHohoHenkoKanriDiv div) {
        boolean is変更あり = false;
        for (dgShiharaiHohoHenkoRireki_Row row : div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getDataSource()) {
            if (row.getJotai() != null && !row.getJotai().isEmpty()) {
                is変更あり = true;
            }
        }
        if (!ResponseHolder.isReRequest() && !is変更あり) {
            return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
        } else if (new RString(DbzInformationMessages.内容変更なしで保存不可.getMessage().getCode()).equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }

        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        PersonalData personalData = PersonalData.of(識別コード, expandedInfo);
        AccessLogger.log(AccessLogType.更新, personalData);

        ShiharaiHohoHenkoService service = ShiharaiHohoHenkoService.createIntance();
        ArrayList<ShiharaiHohoHenko> 支払方法変更の情報List = ViewStateHolder.get(ShiharaiHohoHenkoKanriEnum.支払方法変更の情報リスト, ArrayList.class);
        service.save支払方法変更(支払方法変更の情報List);
        前排他キーの解除();
        div.getCcdKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
        return ResponseData.of(div).setState(DBD2010001StateName.完了);
    }

    /**
     * 「再検索する」ボタン押下時の処理です。
     *
     * @param div ShiharaiHohoHenkoKanriDiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onClick_btnReSearch(ShiharaiHohoHenkoKanriDiv div) {
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBD2010001TransitionEventName.検索条件へ).respond();
    }

    /**
     * 「検索結果一覧へ」ボタン押下時の処理です。
     *
     * @param div ShiharaiHohoHenkoKanriDiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHohoHenkoKanriDiv> onClick_btnToSearchResult(ShiharaiHohoHenkoKanriDiv div) {
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBD2010001TransitionEventName.検索結果一覧へ).respond();
    }

    private ShiharaiHohoHenko setDeleteState(ShiharaiHohoHenko deleteData) {
        deleteData = deleteData.createBuilderForEdit().set論理削除フラグ(true).build();
        ShiharaiHohoHenkoBuilder 支払方法変更Builder = deleteData.createBuilderForEdit();
        支払方法変更Builder.setState(EntityDataState.Modified);

        List<ShiharaiHohoHenkoTaino> 滞納List = deleteData.getShiharaiHohoHenkoTainoList();
        for (ShiharaiHohoHenkoTaino 滞納 : 滞納List) {
            滞納 = 滞納.createBuilderForEdit().setState(EntityDataState.Modified).build();
            滞納 = 滞納.createBuilderForEdit().set論理削除フラグ(true).build();
            支払方法変更Builder.setShiharaiHohoHenkoTaino(滞納);
        }

        List<ShiharaiHohoHenkoSashitome> 差止List = deleteData.getShiharaiHohoHenkoSashitomeList();
        for (ShiharaiHohoHenkoSashitome 差止 : 差止List) {
            差止 = 差止.createBuilderForEdit().setState(EntityDataState.Modified).build();
            差止 = 差止.createBuilderForEdit().set論理削除フラグ(true).build();
            支払方法変更Builder.setShiharaiHohoHenkoSashitome(差止);
        }

        List<ShiharaiHohoHenkoGengaku> 減額List = deleteData.getShiharaiHohoHenkoGengakuList();
        for (ShiharaiHohoHenkoGengaku 減額 : 減額List) {
            ShiharaiHohoHenkoGengakuBuilder 減額build = 減額.createBuilderForEdit();
            減額build.set論理削除フラグ(true);
            減額 = 減額build.setState(EntityDataState.Modified).build();
            支払方法変更Builder.setShiharaiHohoHenkoGengaku(減額);
        }
        deleteData = 支払方法変更Builder.build();
        return deleteData;
    }

    private void 前排他キーの解除() {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("ShinseishoKanriNo")));
        RealInitialLocker.release(排他キー);
    }

    private ShiharaiHohoHenkoKanriHandler getHandler(ShiharaiHohoHenkoKanriDiv div) {
        return new ShiharaiHohoHenkoKanriHandler(div);
    }

}
