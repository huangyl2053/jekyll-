/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2010001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoShinseiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShoriKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010001.ShiharaiHohoHenkoKanriDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010001.dgShiharaiHohoHenkoRireki_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 支払方法変更管理のハンドラークラスです。
 *
 * @reamsid_L DBD-3620-040 xuyue
 */
public class ShiharaiHohoHenkoKanriHandler {

    private static final RString 発行済 = new RString("発行済");
    private static final RString 非該当 = new RString("非該当");
    private static final RString 対象者以外 = new RString("対象者以外");
    private static final RString 対象者 = new RString("対象者");
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
    private static final RString 変更状態_追加 = new RString("追加");
    private static final RString 変更状態_修正 = new RString("修正");
    private static final RString 変更状態_削除 = new RString("削除");

    private final ShiharaiHohoHenkoKanriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 支払方法変更管理のコントロールdiv
     */
    public ShiharaiHohoHenkoKanriHandler(ShiharaiHohoHenkoKanriDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化処理処理です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param dataList ViewStateに保持するList<支払方法変更の情報>
     */
    public void 画面初期化(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, ArrayList<ShiharaiHohoHenko> dataList) {

        List<dgShiharaiHohoHenkoRireki_Row> rowList = new ArrayList<>();
        dgShiharaiHohoHenkoRireki_Row row;
        for (ShiharaiHohoHenko data : dataList) {
            row = new dgShiharaiHohoHenkoRireki_Row();
            setRow(row, data);
            rowList.add(row);
        }
        div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().setDataSource(rowList);

        画面項目の制御();

        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        PersonalData personalData = PersonalData.of(識別コード, expandedInfo);
        AccessLogger.log(AccessLogType.照会, personalData);
        前排他の設定(被保険者番号);
    }

    /**
     * 「受給情報を表示する」ボタン、支払変更管理一覧(ﾃﾞｰﾀｸﾞﾘｯﾄﾞ)、ボタン群、「保存する」ボタンを非活性とします。
     */
    public void 処理不可の非活性設定() {
        div.getShiharaiHohoHenkoKanriMain().getBtnJukyuJohoDialog().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().setDisabled(true);
        ボタン群の非活性();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), true);
    }

    /**
     * List<支払方法変更の情報>に、選択された明細行に対応するデータを取得します。
     *
     * @param dataList 支払方法変更の情報リスト
     * @return 該当の支払方法変更情報
     */
    public ShiharaiHohoHenko get支払方法変更情報FromViewState(ArrayList<ShiharaiHohoHenko> dataList) {
        dgShiharaiHohoHenkoRireki_Row row = div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow();
        for (ShiharaiHohoHenko joho : dataList) {
            if (joho.get証記載保険者番号().getColumnValue().equals(row.getHdnShoKisaiHokenshaNo())
                    && joho.get被保険者番号().getColumnValue().equals(row.getHdnHihokenshaNo())
                    && joho.get管理区分().equals(row.getHdnKanriKubun())
                    && joho.get履歴番号() == Integer.valueOf(row.getHdnRirekiNo().toString())) {
                return joho;
            }
        }
        return null;
    }

    /**
     * List<支払方法変更の情報>に、選択された明細行に対応するデータを取得します。
     *
     * @param dataList 支払方法変更の情報リスト
     * @param joho 支払方法変更
     * @return 該当の支払方法変更情報
     */
    public ShiharaiHohoHenko get支払方法変更情報FromViewState(ArrayList<ShiharaiHohoHenko> dataList, ShiharaiHohoHenko joho) {
        for (ShiharaiHohoHenko data : dataList) {
            if (joho.get証記載保険者番号().getColumnValue().equals(data.get証記載保険者番号().getColumnValue())
                    && joho.get被保険者番号().getColumnValue().equals(data.get被保険者番号().getColumnValue())
                    && joho.get管理区分().equals(data.get管理区分())
                    && joho.get履歴番号() == data.get履歴番号()) {
                return data;
            }
        }
        return null;
    }

    /**
     * 最大履歴番号+1 の値を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param dataList 支払方法変更の情報リスト
     * @param 支払方法変更登録区分 支払方法変更登録区分
     * @return 最大履歴番号+1
     */
    public RString get最大履歴番号plus1By支払方法変更登録区分(HihokenshaNo 被保険者番号,
            ArrayList<ShiharaiHohoHenko> dataList, RString 支払方法変更登録区分) {
        int 履歴番号Max = 0;
        for (ShiharaiHohoHenko joho : dataList) {
            if (被保険者番号.getColumnValue().equals(joho.get被保険者番号().getColumnValue())
                    && 支払方法変更登録区分.equals(joho.get管理区分())) {
                履歴番号Max = joho.get履歴番号();
            }
        }
        return new RString(履歴番号Max + 1);
    }

    /**
     * ダイアログ画面に追加されたデータを支払変更管理一覧に追加します。
     *
     * @param dialog支払方法変更 ダイアログ画面に追加された支払方法変更
     */
    public void 支払変更管理一覧に追加(ShiharaiHohoHenko dialog支払方法変更) {
        dgShiharaiHohoHenkoRireki_Row row = new dgShiharaiHohoHenkoRireki_Row();
        row.setJotai(変更状態_追加);
        setRow(row, dialog支払方法変更);

        List<dgShiharaiHohoHenkoRireki_Row> rowList = div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getDataSource();
        rowList.add(row);
        Collections.sort(rowList, new ShiharaiHohoHenkoKanriRowComparator());
        div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().setDataSource(rowList);
    }

    /**
     * ダイアログ画面に変更されたデータを支払変更管理一覧に反映します。
     *
     * @param dialog支払方法変更 ダイアログ画面に変更された支払方法変更
     */
    public void 支払変更管理一覧に更新(ShiharaiHohoHenko dialog支払方法変更) {
        List<dgShiharaiHohoHenkoRireki_Row> rowList = div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getDataSource();
        for (dgShiharaiHohoHenkoRireki_Row row : rowList) {
            if (dialog支払方法変更.get証記載保険者番号().getColumnValue().equals(row.getHdnShoKisaiHokenshaNo())
                    && dialog支払方法変更.get被保険者番号().getColumnValue().equals(row.getHdnHihokenshaNo())
                    && dialog支払方法変更.get管理区分().equals(row.getHdnKanriKubun())
                    && dialog支払方法変更.get履歴番号() == Integer.valueOf(row.getHdnRirekiNo().toString())) {
                row.setJotai(変更状態_修正);
                setRow(row, dialog支払方法変更);
            }
        }
        Collections.sort(rowList, new ShiharaiHohoHenkoKanriRowComparator());
        div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().setDataSource(rowList);
    }

    /**
     * 選択された明細行を支払変更管理一覧に削除します。
     */
    public void 支払変更管理一覧に削除() {
        dgShiharaiHohoHenkoRireki_Row deleteRow = div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getActiveRow();
        List<dgShiharaiHohoHenkoRireki_Row> rowList = div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().getDataSource();

        if (変更状態_追加.equals(deleteRow.getJotai())) {
            rowList.remove(deleteRow);
        } else {
            for (dgShiharaiHohoHenkoRireki_Row row : rowList) {
                if (deleteRow.getHdnShoKisaiHokenshaNo().equals(row.getHdnShoKisaiHokenshaNo())
                        && deleteRow.getHdnHihokenshaNo().equals(row.getHdnHihokenshaNo())
                        && deleteRow.getHdnKanriKubun().equals(row.getHdnKanriKubun())
                        && deleteRow.getHdnRirekiNo().equals(row.getHdnRirekiNo())) {
                    row.setJotai(変更状態_削除);
                }
            }
        }
        div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().setDataSource(rowList);
    }

    /**
     * 押下されたボタンに対応するDBDEnum.支払方法変更処理区分のコードを取得します。
     *
     * @return DBDEnum.支払方法変更処理区分のコード
     */
    public RString getボタンの支払方法変更処理区分() {
        RString 方法変更処理区分コード = RString.EMPTY;
        if (ボタン１号予告者登録.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun._1号予告者登録.getコード();
        } else if (ボタン１号弁明書受理.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun._1号弁明書受理.getコード();
        } else if (ボタン１償還払い化登録.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun.償還払い化登録.getコード();
        } else if (ボタン１償還払い化終了申請.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun.償還払い化終了申請.getコード();
        } else if (ボタン１給付一時差止登録.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun.給付一時差止登録.getコード();
        } else if (ボタン１保険料控除登録.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun.保険料控除登録.getコード();
        } else if (ボタン１給付額減額登録.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun.給付額減額登録.getコード();
        } else if (ボタン１減額免除申請.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun.減額免除申請.getコード();
        } else if (ボタン１免除解除再転入.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun.免除解除_再転入.getコード();
        } else if (ボタン２号予告者登録.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun._2号予告者登録.getコード();
        } else if (ボタン２号弁明書受理.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun._2号弁明書受理.getコード();
        } else if (ボタン２号一時差止登録.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun._2号一時差止登録.getコード();
        } else if (ボタン２号一時差止解除.equals(div.getFocusPositionID())) {
            方法変更処理区分コード = ShoriKubun._2号一時差止解除.getコード();
        }
        return 方法変更処理区分コード;
    }

    /**
     * 選択データによるボタン群の制御を行います。
     *
     * @param data 支払方法変更情報
     */
    public void ボタン群の制御(ShiharaiHohoHenko data) {
        ボタン群の非活性();
        if (ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(data.get管理区分())) {
            管理区分が2の時ボタン群の設定(data);
        } else if (ShiharaiHenkoKanriKubun._１号給付額減額.getコード().equals(data.get管理区分())) {
            管理区分が3の時ボタン群の設定(data);
        } else if (ShiharaiHenkoKanriKubun._２号差止.getコード().equals(data.get管理区分())) {
            管理区分が1の時ボタン群の設定(data);
        }
    }

    /**
     * ボタン群を非活性とします。
     */
    public void ボタン群の非活性() {
        div.getShiharaiHohoHenkoKanriMain().getBtnGengakuMenjoShinsei().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getBtnHokenryoKojoToroku().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getBtnIchigoBemmeishoJuri().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getBtnIchigoYokokushaToroku1().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getBtnKyufuIchijiSashitomeToroku().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getBtnKyufugakuGengakuToroku().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getBtnMenjoKaijoAndSaitennyu().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getBtnNigoBemmeishoJuri().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getBtnNigoIchijiSashitomeKaijo().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getBtnNigoIchijiSashitomeToroku().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getBtnNigoYokokushaToroku().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getBtnShokanBaraikaShuryoShinsei().setDisabled(true);
        div.getShiharaiHohoHenkoKanriMain().getBtnShokanBaraikaToroku().setDisabled(true);
    }

    /**
     * 初期化の時、画面項目の制御を行います。
     * <br>支払変更管理一覧のレコードは未選択状態とする
     * <br>「１号予告者登録」・「給付額減額登録」・「２号予告者登録」を押下可能とする
     */
    public void 画面項目の制御() {
        ボタン群の非活性();
        div.getShiharaiHohoHenkoKanriMain().getDgShiharaiHohoHenkoRireki().setSelectedItems(Collections.<dgShiharaiHohoHenkoRireki_Row>emptyList());
        div.getShiharaiHohoHenkoKanriMain().getBtnIchigoYokokushaToroku1().setDisabled(false);
        div.getShiharaiHohoHenkoKanriMain().getBtnKyufugakuGengakuToroku().setDisabled(false);
        div.getShiharaiHohoHenkoKanriMain().getBtnNigoYokokushaToroku().setDisabled(false);
    }

    private void setRow(dgShiharaiHohoHenkoRireki_Row row, ShiharaiHohoHenko data) {
        row.setHdnShoKisaiHokenshaNo(data.get証記載保険者番号().getColumnValue());
        row.setHdnHihokenshaNo(data.get被保険者番号().getColumnValue());
        row.setHdnKanriKubun(data.get管理区分());
        row.setHdnRirekiNo(new RString(data.get履歴番号()));
        row.setTorokuJokyo(data.get登録区分().isNullOrEmpty() ? RString.EMPTY : ShiharaiHenkoTorokuKubun.toValue(data.get登録区分()).get名称());
        row.setShuryoJokyo(data.get終了区分().isNullOrEmpty() ? RString.EMPTY : ShiharaiHenkoShuryoKubun.toValue(data.get終了区分()).get名称());
        row.getTxtTekiyoKiashiYMD().setValue(data.get適用開始年月日());
        row.getTxtTekiyoShuryoYMD().setValue(data.get適用終了年月日());
        if (data.get予告通知書発行年月日() == null || data.get予告通知書発行年月日().isEmpty()) {
            row.setYokokuTsuchiHakko(RString.EMPTY);
        } else {
            row.setYokokuTsuchiHakko(発行済);
        }
        if (data.get償還払化通知書発行年月日() == null || data.get償還払化通知書発行年月日().isEmpty()) {
            row.setHenkoTsuchiHakko(RString.EMPTY);
        } else {
            row.setHenkoTsuchiHakko(発行済);
        }
        row.setSashitomeTsuchiHakko(get差止通知(data));
        row.setKojoTsuchiHakko(get控除通知(data));
        if (data.get減額通知書発行年月日() == null || data.get減額通知書発行年月日().isEmpty()) {
            row.setGengakuTsuchiHakko(RString.EMPTY);
        } else {
            row.setGengakuTsuchiHakko(発行済);
        }
    }

    private RString get差止通知(ShiharaiHohoHenko joho) {
        List<ShiharaiHohoHenkoSashitome> 支払方法変更差止List = joho.getShiharaiHohoHenkoSashitomeList();
        if (支払方法変更差止List != null) {
            for (ShiharaiHohoHenkoSashitome 支払方法変更差止 : 支払方法変更差止List) {
                if (支払方法変更差止.get差止通知書発行年月日() != null
                        && !支払方法変更差止.get差止通知書発行年月日().isEmpty()) {
                    return 発行済;
                }
            }
        }
        return RString.EMPTY;
    }

    private RString get控除通知(ShiharaiHohoHenko joho) {
        List<ShiharaiHohoHenkoSashitome> 支払方法変更差止List = joho.getShiharaiHohoHenkoSashitomeList();
        if (支払方法変更差止List != null) {
            for (ShiharaiHohoHenkoSashitome 支払方法変更差止 : 支払方法変更差止List) {
                if (支払方法変更差止.get控除通知書発行年月日() != null
                        && !支払方法変更差止.get控除通知書発行年月日().isEmpty()) {
                    return 発行済;
                }
            }
        }
        return RString.EMPTY;
    }

    private void 管理区分が2の時ボタン群の設定(ShiharaiHohoHenko data) {
        if (!data.get終了区分().isNullOrEmpty()) {
            return;
        }
        if (data.get差止対象決定年月日() != null && !data.get差止対象決定年月日().isEmpty()) {
            div.getShiharaiHohoHenkoKanriMain().getBtnHokenryoKojoToroku().setDisabled(false);
        } else if (data.get償還払化決定年月日() != null && !data.get償還払化決定年月日().isEmpty()) {
            div.getShiharaiHohoHenkoKanriMain().getBtnShokanBaraikaShuryoShinsei().setDisabled(false);
            div.getShiharaiHohoHenkoKanriMain().getBtnKyufuIchijiSashitomeToroku().setDisabled(false);
        } else {
            div.getShiharaiHohoHenkoKanriMain().getBtnIchigoYokokushaToroku1().setDisabled(false);
            if (data.get予告登録年月日() != null && !data.get予告登録年月日().isEmpty()) {
                div.getShiharaiHohoHenkoKanriMain().getBtnKyufuIchijiSashitomeToroku().setDisabled(false);
                div.getShiharaiHohoHenkoKanriMain().getBtnIchigoBemmeishoJuri().setDisabled(false);
            }
        }
    }

    private void 管理区分が3の時ボタン群の設定(ShiharaiHohoHenko data) {
        if (ShiharaiHenkoShuryoShinseiShinsaKekkaKubun._空.getコード().equals(data.get終了申請審査結果区分())) {
            div.getShiharaiHohoHenkoKanriMain().getBtnKyufugakuGengakuToroku().setDisabled(false);
            div.getShiharaiHohoHenkoKanriMain().getBtnGengakuMenjoShinsei().setDisabled(false);
        } else if (ShiharaiHenkoShuryoShinseiShinsaKekkaKubun.申請却下.getコード().equals(data.get終了申請審査結果区分())
                || ShiharaiHenkoShuryoShinseiShinsaKekkaKubun.申請受理.getコード().equals(data.get終了申請審査結果区分())) {
            div.getShiharaiHohoHenkoKanriMain().getBtnKyufugakuGengakuToroku().setDisabled(false);
            div.getShiharaiHohoHenkoKanriMain().getBtnMenjoKaijoAndSaitennyu().setDisabled(false);
        } else {
            div.getShiharaiHohoHenkoKanriMain().getBtnKyufugakuGengakuToroku().setDisabled(false);
        }
    }

    private void 管理区分が1の時ボタン群の設定(ShiharaiHohoHenko data) {
        if (!data.get終了区分().isNullOrEmpty()) {
            return;
        }
        if (data.get差止対象決定年月日() != null && !data.get差止対象決定年月日().isEmpty()) {
            div.getShiharaiHohoHenkoKanriMain().getBtnNigoIchijiSashitomeKaijo().setDisabled(false);
        } else {
            div.getShiharaiHohoHenkoKanriMain().getBtnNigoYokokushaToroku().setDisabled(false);
            if (data.get予告登録年月日() != null && !data.get予告登録年月日().isEmpty()) {
                div.getShiharaiHohoHenkoKanriMain().getBtnNigoBemmeishoJuri().setDisabled(false);
                div.getShiharaiHohoHenkoKanriMain().getBtnNigoIchijiSashitomeToroku().setDisabled(false);
            }
        }
    }

    private void 前排他の設定(HihokenshaNo 被保険者番号) {
        LockingKey 排他キー = new LockingKey(GyomuCode.DB介護保険.getColumnValue()
                .concat(被保険者番号.getColumnValue()).concat(new RString("ShinseishoKanriNo")));
        RealInitialLocker.lock(排他キー);
    }

    /**
     * 支払方法変更管理のenumクラスです。
     */
    public enum ShiharaiHohoHenkoKanriEnum {

        /**
         * 支払方法変更の情報リスト
         */
        支払方法変更の情報リスト,
        /**
         * 初期の支払方法変更の情報リスト
         */
        初期の支払方法変更の情報リスト
    }

    /**
     * 支払変更管理一覧(ﾃﾞｰﾀｸﾞﾘｯﾄﾞ)のComparatorです。（支払方法変更．管理区分(昇順)＞履歴番号(降順)で表示する）
     */
    public static class ShiharaiHohoHenkoKanriRowComparator implements Comparator<dgShiharaiHohoHenkoRireki_Row> {

        @Override
        public int compare(dgShiharaiHohoHenkoRireki_Row row1, dgShiharaiHohoHenkoRireki_Row row2) {

            return row1.getHdnKanriKubun().compareTo(row2.getHdnKanriKubun()) > 0
                    ? 1 : (row1.getHdnRirekiNo().compareTo(row2.getHdnRirekiNo()) > 0 ? -1 : 1);

        }
    }

}
