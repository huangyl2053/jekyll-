/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome1go.IchijiSashitome1Go;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenkoBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShokanHaraiShikyu;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTaino;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResultKohen;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoKiSummary;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoJohoBunruiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoSashitomeKojoJotaiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShoriKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TainoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TaishoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko.ShiharaiHohoHenkoService;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellDetails;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 【共有子Div】1号一時差止ダイアログのハンドラクラスです。
 *
 * @reamsid_L DBD-3620-042 panxiaobo
 */
public class IchijiSashitome1GoHandler {

    private final IchijiSashitome1GoDiv div;
    private final RString _給付一時差止登録 = new RString("給付一時差止登録");
    private final RString _保険料控除登録 = new RString("保険料控除登録");
    private final RString 登録PTN = new RString("登録PTN");
    private final RString 更新PTN = new RString("更新PTN");
    private final RString 差止登録 = new RString("差止登録");
    private final RString 控除登録 = new RString("控除登録");
    private final RString 削除アイコン押下 = new RString("削除アイコン押下");
    private final RString 解除アイコン押下 = new RString("解除アイコン押下");

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】 1号一時差止ダイアログDiv
     */
    public IchijiSashitome1GoHandler(IchijiSashitome1GoDiv div) {
        this.div = div;
    }

    /**
     * 二号一時差止ダイアロググキーのEnum
     */
    private enum 一号一時差止ダイアロググキー {

        /**
         * 画面更新用情報
         */
        支払方法変更管理業務概念,
        /**
         * 画面取得情報List
         */
        償還払支給の情報List,
        /**
         * 画面表示用
         */
        支払方法変更差止レコード;
    }

    /**
     * 画面初期化処理です。
     *
     * @return Message エラーMSG
     */
    public Message onLoad() {
        Message message = null;
        RString 押下ボタン = ShoriKubun.toValue(div.getKey_Button()).get名称();
        ShiharaiHohoHenko 支払方法変更管理業務概念 = DataPassingConverter.deserialize(div.getKey_ShiharaiHohoHenkoKanri(), ShiharaiHohoHenko.class);
        ArrayList<ShiharaiHohoHenko> 支払方法変更レコード = new ArrayList();
        ArrayList<ShiharaiHohoHenkoSashitome> shiharaiHohoHenkoSashitomeList = new ArrayList();
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, 支払方法変更管理業務概念);
        if (支払方法変更管理業務概念 != null
                && 支払方法変更管理業務概念.get被保険者番号().value().equals(div.getKey_HihokenshaNo())
                && 支払方法変更管理業務概念.get管理区分().equals(ShiharaiHenkoKanriKubun._１号償還払い化.getコード())
                && 支払方法変更管理業務概念.get登録区分().equals(ShiharaiHenkoTorokuKubun._１号給付額減額登録.getコード())
                && 抽出条件(押下ボタン, 支払方法変更管理業務概念)) {
            for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList()) {
                if (shiharaiHohoHenkoSashitome.get証記載保険者番号().equals(支払方法変更管理業務概念.get証記載保険者番号())
                        && shiharaiHohoHenkoSashitome.get被保険者番号().value().equals(div.getKey_HihokenshaNo())
                        && shiharaiHohoHenkoSashitome.get管理区分().equals(ShiharaiHenkoKanriKubun._１号償還払い化.getコード())
                        && shiharaiHohoHenkoSashitome.get履歴番号() == 支払方法変更管理業務概念.get履歴番号()) {
                    shiharaiHohoHenkoSashitomeList.add(shiharaiHohoHenkoSashitome);
                    break;
                }
            }
            ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更差止レコード, shiharaiHohoHenkoSashitomeList);
            支払方法変更レコード.add(支払方法変更管理業務概念);
        }
        if (支払方法変更管理業務概念 == null || 支払方法変更レコード.isEmpty()) {
            return UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace("支払方法変更");
        }
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, 支払方法変更管理業務概念);
        ShiharaiHohoHenkoService service = ShiharaiHohoHenkoService.createIntance();
        ArrayList<ShokanHaraiShikyu> shokanHaraiShikyuList = service.find償還払い支給(new HihokenshaNo(div.getKey_HihokenshaNo()));
        ViewStateHolder.put(一号一時差止ダイアロググキー.償還払支給の情報List, shokanHaraiShikyuList);
        initializeDisplayData(押下ボタン);
        return message;
    }

    /**
     * 「確定」ボタン。
     */
    public void onClick_IchijiSashitome1GoKakutei() {
        div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class)));
    }

    /**
     * 滞納状況ダイアログを開く前に実行されるイベントを設定します。
     */
    public void onBeforeOpenDialog_BtnTainoJokyo() {
        RString 押下ボタン = ShoriKubun.toValue(div.getKey_Button()).get名称();
        div.setHihokenshaNo(div.getKey_HihokenshaNo());
        div.setKanriKubun(ShiharaiHenkoKanriKubun._１号給付額減額.getコード());
        if (押下ボタン.equals(_給付一時差止登録)) {
            div.setTainoHanteiKubun(TainoHanteiKubun.差止登録.getコード());
        } else if (押下ボタン.equals(_保険料控除登録)) {
            div.setTainoHanteiKubun(TainoHanteiKubun.控除登録.getコード());
        }
        div.setRirekiNo(RString.EMPTY);
    }

    /**
     * 滞納状況ダイアログが確定クローズイベントで閉じられたときにダイアログが完全に閉じた後に実行されるイベントを設定します。
     */
    public void onOkClose_BtnTainoJokyo() {
        RString 押下ボタン = ShoriKubun.toValue(div.getKey_Button()).get名称();
        TainoHanteiResultKohen 滞納判定結果 = ViewStateHolder.get(ViewStateKeys.滞納判定結果, TainoHanteiResultKohen.class);
        if (滞納判定結果 != null && 滞納判定結果.get滞納情報() != null) {
            div.setTainoHanteiKekka(DataPassingConverter.serialize(滞納判定結果));
            if (押下ボタン.equals(_給付一時差止登録)) {
                div.getBtnTainoJokyo().setIconNameEnum(IconName.Check);
            }
        }
    }

    /**
     * 「差止登録」ボタンの処理です。
     *
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs onClick_SashitomeToRoku() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor給付一時差止未解除データチェック(pairs, div, 支払方法変更管理業務概念);
        if (pairs.iterator().hasNext()) {
            return pairs;
        }
        div.getTxtSashitomeTorokuKubun().setDisabled(true);
        div.getTxtSashitomeTorokuYMD().setDisabled(false);
        div.getTxtSashitomeTorokuTsuchiHakkoYMD().setReadOnly(true);
        div.getTxtSashitomeNofuKigenYMD().setDisabled(false);
        div.getTxtSashitomeKaijoYMD().setDisplayNone(true);
        div.getBtnTainoJokyo().setDisabled(false);
        div.getBtnSashitomeOrKojoJokyoShokaiClose().setDisplayNone(true);
        div.getBtnSashitomeOrKojoTorokuTorikeshi().setDisabled(false);
        div.getBtnSashitomeOrKojoTorokuKakutei().setDisabled(false);
        div.getTxtSashitomeTorokuKubun().setValue(ShiharaiHenkoSashitomeKojoJotaiKubun.登録.get名称());
        div.getTxtSashitomeTorokuYMD().setValue(FlexibleDate.EMPTY);
        div.getTxtSashitomeTorokuTsuchiHakkoYMD().setValue(FlexibleDate.EMPTY);
        div.getTxtSashitomeNofuKigenYMD().setValue(FlexibleDate.EMPTY);
        div.setButton_Name(差止登録);
        div.setPTN(登録PTN);
        return pairs;
    }

    /**
     * 「控除登録」ボタンの処理です。
     *
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs onClick_KaijoToRoku() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor保険料控除未解除データチェック(pairs, div, 支払方法変更管理業務概念);
        if (pairs.iterator().hasNext()) {
            return pairs;
        }
        div.getTxtKojoTorokuKubun().setReadOnly(true);
        div.getTxtKojoKetteiYMD().setDisabled(false);
        div.getTxtKojoTorokuTsuchiHakkoYMD().setReadOnly(true);
        div.getTxtHokenshoTeishutsuKigenYMD().setDisabled(false);
        div.getDdlTorokuKojoNo().setDisabled(false);
        div.getBtnTainoJokyo().setDisabled(false);
        div.getBtnSashitomeOrKojoJokyoShokaiClose().setDisplayNone(true);
        div.getBtnSashitomeOrKojoTorokuTorikeshi().setDisabled(false);
        div.getBtnSashitomeOrKojoTorokuKakutei().setDisabled(false);
        div.getTxtKojoTorokuKubun().setValue(ShiharaiHenkoSashitomeKojoJotaiKubun.登録.get名称());
        div.getTxtKojoKetteiYMD().setValue(FlexibleDate.EMPTY);
        div.getTxtKojoTorokuTsuchiHakkoYMD().setValue(FlexibleDate.EMPTY);
        div.getTxtHokenshoTeishutsuKigenYMD().setValue(FlexibleDate.EMPTY);
        div.getDdlTorokuKojoNo().setSelectedKey(RString.EMPTY);
        div.setButton_Name(控除登録);
        div.setPTN(登録PTN);
        return pairs;
    }

    /**
     * 給付一時差止登録一覧(ﾃﾞｰﾀｸﾞﾘｯﾄﾞ)明細
     *
     * @return ValidationMessageControlPairs pairs
     */
    public ValidationMessageControlPairs onClick_SelectedItem() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ArrayList<ShokanHaraiShikyu> 償還払支給の情報List = ViewStateHolder.get(一号一時差止ダイアロググキー.償還払支給の情報List, ArrayList.class);
        int index = div.getDgSashitomeKojoIchiran().getClickedRowId();
        div.setKey_Index(new RString(String.valueOf(index)));
        ShiharaiHohoHenkoSashitome 支払方法変更差止 = 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(index);
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor給付一時差止選択データチェック(pairs, div, 支払方法変更差止);
        getValidationHandler().validateFor保険料控除選択データチェック(pairs, div, 支払方法変更差止);
        if (pairs.iterator().hasNext()) {
            return pairs;
        }
        List<dgShokanJoho_Row> rowList = new ArrayList();
        dgShokanJoho_Row row = new dgShokanJoho_Row();
        int sagakuKingakuGokei = 0;
        for (ShokanHaraiShikyu shokanHaraiShikyu : 償還払支給の情報List) {
            FlexibleYearMonth serviceTeikyoYM = shokanHaraiShikyu.get支払方法変更差止_Sashitome_ServiceTeikyoYM();
            RString shokanSeiriNo = shokanHaraiShikyu.get支払方法変更差止_Sashitome_ShokanSeiriNo();
            if (shokanHaraiShikyu.get支払方法変更差止_HihokenshaNo() != null
                    && serviceTeikyoYM != null
                    && shokanSeiriNo != null
                    && shokanHaraiShikyu.get支払方法変更差止_HihokenshaNo().equals(支払方法変更差止.get被保険者番号())
                    && serviceTeikyoYM.equals(支払方法変更差止.get差止サービス提供年月())
                    && shokanSeiriNo.equals(支払方法変更差止.get差止償還整理番号())) {
                row.setSeiriNo(shokanHaraiShikyu.get償還払支給申請_SeiriNo());
                row.getTxtTeikyoYM().setValue(new FlexibleDate(shokanHaraiShikyu.get償還払支給申請_ServiceTeikyoYM().toDateString()));
                row.setJigyoshaNo(shokanHaraiShikyu.get償還払請求集計_JigyoshaNo().value());
                row.setServiceShurui(shokanHaraiShikyu.get償還払請求集計_ServiceShuruiCode().value());
                row.getTxtShiharaiKingaku().setValue(new Decimal(shokanHaraiShikyu.get償還払請求集計_ShikyuKingaku()));
                sagakuKingakuGokei = sagakuKingakuGokei + shokanHaraiShikyu.get償還払請求集計_ShikyuKingaku();
                rowList.add(row);
            }
        }
        div.getDgShokanJoho().setDataSource(rowList);
        div.getTxtSagakuKingakuGokei().setValue(new Decimal(sagakuKingakuGokei));
        switch (ShoriKubun.toValue(div.getKey_Button()).get名称().toString()) {
            case "給付一時差止登録":
                div.getTxtSashitomeTorokuKubun().setReadOnly(true);
                div.getTxtSashitomeTorokuYMD().setDisabled(false);
                div.getTxtSashitomeTorokuTsuchiHakkoYMD().setReadOnly(true);
                div.getTxtSashitomeNofuKigenYMD().setDisabled(false);
                div.getTxtSashitomeKaijoYMD().setDisplayNone(true);
                div.getTxtSashitomeTorokuKubun().setValue(支払方法変更差止.get差止控除状態区分());
                div.getTxtSashitomeTorokuYMD().setValue(支払方法変更差止.get差止決定年月日());
                div.getTxtSashitomeTorokuTsuchiHakkoYMD().setValue(支払方法変更差止.get差止通知書発行年月日());
                div.getTxtSashitomeNofuKigenYMD().setValue(支払方法変更差止.get差止納付期限());
                div.getTxtSashitomeKaijoYMD().setValue(支払方法変更差止.get差止解除年月日());
                break;
            case "保険料控除登録":
                div.getTxtKojoTorokuKubun().setReadOnly(true);
                div.getTxtKojoKetteiYMD().setDisabled(false);
                div.getTxtKojoTorokuTsuchiHakkoYMD().setDisabled(false);
                div.getTxtHokenshoTeishutsuKigenYMD().setReadOnly(true);
                div.getDdlTorokuKojoNo().setDisabled(false);
                div.getTxtKojoTorokuKubun().setValue(支払方法変更差止.get差止控除状態区分());
                div.getTxtKojoKetteiYMD().setValue(支払方法変更差止.get控除決定年月日());
                div.getTxtKojoTorokuTsuchiHakkoYMD().setValue(支払方法変更管理業務概念.get被保険者証提出期限());
                div.getTxtHokenshoTeishutsuKigenYMD().setValue(支払方法変更差止.get控除通知書発行年月日());
                div.getDdlTorokuKojoNo().setSelectedKey(支払方法変更差止.get差止控除番号());
                break;
            default:
                break;
        }
        div.getBtnTainoJokyo().setDisabled(false);
        div.getBtnSashitomeOrKojoJokyoShokaiClose().setDisplayNone(true);
        div.getBtnSashitomeOrKojoTorokuTorikeshi().setDisabled(false);
        div.getBtnSashitomeOrKojoTorokuKakutei().setDisabled(false);
        div.setPTN(更新PTN);
        償還情報一覧初期表示();
        return pairs;
    }

    /**
     * 「削除」ボタン
     *
     */
    public void onClick_DeleteItem() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ArrayList<ShokanHaraiShikyu> 償還払支給の情報List = ViewStateHolder.get(一号一時差止ダイアロググキー.償還払支給の情報List, ArrayList.class);
        int index = div.getDgSashitomeKojoIchiran().getClickedRowId();
        div.setKey_Index(new RString(String.valueOf(index)));
        ShiharaiHohoHenkoSashitome 支払方法変更差止 = 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(index);
        List<dgShokanJoho_Row> rowList = new ArrayList();
        dgShokanJoho_Row row = new dgShokanJoho_Row();
        int sagakuKingakuGokei = 0;
        for (ShokanHaraiShikyu shokanHaraiShikyu : 償還払支給の情報List) {
            FlexibleYearMonth serviceTeikyoYM = shokanHaraiShikyu.get支払方法変更差止_Sashitome_ServiceTeikyoYM();
            RString shokanSeiriNo = shokanHaraiShikyu.get支払方法変更差止_Sashitome_ShokanSeiriNo();
            if (shokanHaraiShikyu.get支払方法変更差止_HihokenshaNo() != null
                    && serviceTeikyoYM != null
                    && shokanSeiriNo != null
                    && shokanHaraiShikyu.get支払方法変更差止_HihokenshaNo().equals(支払方法変更差止.get被保険者番号())
                    && serviceTeikyoYM.equals(支払方法変更差止.get差止サービス提供年月())
                    && shokanSeiriNo.equals(支払方法変更差止.get差止償還整理番号())) {
                row.setSeiriNo(shokanHaraiShikyu.get償還払支給申請_SeiriNo());
                row.getTxtTeikyoYM().setValue(new FlexibleDate(shokanHaraiShikyu.get償還払支給申請_ServiceTeikyoYM().toDateString()));
                row.setJigyoshaNo(shokanHaraiShikyu.get償還払請求集計_JigyoshaNo().value());
                row.setServiceShurui(shokanHaraiShikyu.get償還払請求集計_ServiceShuruiCode().value());
                row.getTxtShiharaiKingaku().setValue(new Decimal(shokanHaraiShikyu.get償還払請求集計_ShikyuKingaku()));
                sagakuKingakuGokei = sagakuKingakuGokei + shokanHaraiShikyu.get償還払請求集計_ShikyuKingaku();
                rowList.add(row);
            }
        }
        div.getDgShokanJoho().setDataSource(rowList);
        div.getTxtSagakuKingakuGokei().setValue(new Decimal(sagakuKingakuGokei));
        div.setButton_Name(削除アイコン押下);
        div.getTxtSashitomeTorokuKubun().setReadOnly(true);
        div.getTxtSashitomeTorokuYMD().setReadOnly(true);
        div.getTxtSashitomeTorokuTsuchiHakkoYMD().setReadOnly(true);
        div.getTxtSashitomeNofuKigenYMD().setReadOnly(true);
        div.getTxtSashitomeKaijoYMD().setDisplayNone(true);
    }

    /**
     * 「解除」ボタン
     *
     */
    public void onClick_KaijoItem() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ArrayList<ShokanHaraiShikyu> 償還払支給の情報List = ViewStateHolder.get(一号一時差止ダイアロググキー.償還払支給の情報List, ArrayList.class);
        int index = div.getDgSashitomeKojoIchiran().getClickedRowId();
        div.setKey_Index(new RString(String.valueOf(index)));
        ShiharaiHohoHenkoSashitome 支払方法変更差止 = 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(index);
        List<dgShokanJoho_Row> rowList = new ArrayList();
        dgShokanJoho_Row row = new dgShokanJoho_Row();
        int sagakuKingakuGokei = 0;
        for (ShokanHaraiShikyu shokanHaraiShikyu : 償還払支給の情報List) {
            FlexibleYearMonth serviceTeikyoYM = shokanHaraiShikyu.get支払方法変更差止_Sashitome_ServiceTeikyoYM();
            RString shokanSeiriNo = shokanHaraiShikyu.get支払方法変更差止_Sashitome_ShokanSeiriNo();
            if (shokanHaraiShikyu.get支払方法変更差止_HihokenshaNo() != null
                    && serviceTeikyoYM != null
                    && shokanSeiriNo != null
                    && shokanHaraiShikyu.get支払方法変更差止_HihokenshaNo().equals(支払方法変更差止.get被保険者番号())
                    && serviceTeikyoYM.equals(支払方法変更差止.get差止サービス提供年月())
                    && shokanSeiriNo.equals(支払方法変更差止.get差止償還整理番号())) {
                row.setSeiriNo(shokanHaraiShikyu.get償還払支給申請_SeiriNo());
                row.getTxtTeikyoYM().setValue(new FlexibleDate(shokanHaraiShikyu.get償還払支給申請_ServiceTeikyoYM().toDateString()));
                row.setJigyoshaNo(shokanHaraiShikyu.get償還払請求集計_JigyoshaNo().value());
                row.setServiceShurui(shokanHaraiShikyu.get償還払請求集計_ServiceShuruiCode().value());
                row.getTxtShiharaiKingaku().setValue(new Decimal(shokanHaraiShikyu.get償還払請求集計_ShikyuKingaku()));
                sagakuKingakuGokei = sagakuKingakuGokei + shokanHaraiShikyu.get償還払請求集計_ShikyuKingaku();
                rowList.add(row);
            }
        }
        div.getDgShokanJoho().setDataSource(rowList);
        div.setButton_Name(解除アイコン押下);
        if (ShoriKubun.toValue(div.getKey_Button()).get名称().equals(_給付一時差止登録)) {
            div.getShokanJoho().setTitle(new RString("差止解除"));
            div.getTxtSashitomeTorokuKubun().setReadOnly(true);
            div.getTxtSashitomeTorokuYMD().setReadOnly(true);
            div.getTxtSashitomeTorokuTsuchiHakkoYMD().setReadOnly(true);
            div.getTxtSashitomeNofuKigenYMD().setReadOnly(true);
            div.getTxtSashitomeKaijoYMD().setDisabled(true);
        } else if (ShoriKubun.toValue(div.getKey_Button()).get名称().equals(_保険料控除登録)) {
            div.getShokanJoho().setTitle(new RString("控除解除"));
            div.getTxtKojoTorokuKubun().setReadOnly(true);
            div.getTxtKojoKetteiYMD().setReadOnly(true);
            div.getTxtKojoTorokuTsuchiHakkoYMD().setReadOnly(true);
            div.getTxtHokenshoTeishutsuKigenYMD().setReadOnly(true);
            div.getDdlTorokuKojoNo().setReadOnly(true);
        }
    }

    /**
     * 「差止／控除状況照会」ボタン押下による表示
     *
     */
    public void onClick_SashitomeKojo() {
        int index = Integer.parseInt(div.getKey_Index().toString());
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoSashitome 支払方法変更差止 = 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(index);
        DisplayNone_控除登録用(true);
        DisplayNone_差止登録用(true);
        div.getSashitomeToroku().setDisplayNone(false);
        div.getSasitomeKaijo().setDisplayNone(false);
        div.getKojoToroku().setDisplayNone(false);
        div.getTxtShokaiSashitomeTorokuYMD().setDisplayNone(false);
        div.getTxtShokaiSashitomeNofuKigenYMD().setDisplayNone(false);
        div.getTxtShokaiSashitomeTorokuTsuchiHakkoYMD().setDisplayNone(false);
        div.getTxtShokaiSashitomeKaijoYMD().setDisplayNone(false);
        div.getTxtShokaiKojoKetteiYMD().setDisplayNone(false);
        div.getTxtShokaiHokenshoTeishutsuKigenYMD().setDisplayNone(false);
        div.getTxtShokaiKojoTorokuTsuchiHakkoYMD().setDisplayNone(false);
        div.getTxtShokaiKojoNo().setDisplayNone(false);
        div.getBtnTainoJokyo().setDisabled(false);
        div.getBtnSashitomeOrKojoJokyoShokaiClose().setDisabled(false);
        div.getBtnSashitomeOrKojoTorokuTorikeshi().setDisplayNone(true);
        div.getBtnSashitomeOrKojoTorokuKakutei().setDisplayNone(true);
        div.getTxtShokaiSashitomeTorokuYMD().setValue(支払方法変更差止.get差止決定年月日());
        div.getTxtShokaiSashitomeNofuKigenYMD().setValue(支払方法変更差止.get差止納付期限());
        div.getTxtShokaiSashitomeTorokuTsuchiHakkoYMD().setValue(支払方法変更差止.get差止通知書発行年月日());
        div.getTxtShokaiSashitomeKaijoYMD().setValue(支払方法変更差止.get差止解除年月日());
        div.getTxtShokaiKojoKetteiYMD().setValue(支払方法変更差止.get控除決定年月日());
        div.getTxtShokaiHokenshoTeishutsuKigenYMD().setValue(支払方法変更管理業務概念.get被保険者証提出期限());
        div.getTxtShokaiKojoTorokuTsuchiHakkoYMD().setValue(支払方法変更差止.get控除通知書発行年月日());
        div.getTxtShokaiKojoNo().setValue(支払方法変更差止.get差止控除番号());
        div.getShokanJoho().setTitle(new RString("差止／控除状況照会"));
    }

    /**
     * 「(差止登録)取消」ボタンの処理です。
     *
     *
     */
    public void onClick_SashitomeToRokuToRiKeShi() {
        onClick_KaijoItem();
    }

    /**
     * 「(差止登録)確定」ボタンの処理です。
     *
     *
     * @return
     */
    public ValidationMessageControlPairs onClick_SashitomeToRokuKaKuTei() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        TainoHanteiResultKohen 滞納判定結果 = DataPassingConverter.deserialize(div.getTainoHanteiKekka(), TainoHanteiResultKohen.class);
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor滞納状況情報チェック(pairs, div, 支払方法変更管理業務概念);
        if (pairs.iterator().hasNext()) {
            return pairs;
        }
        if (ShoriKubun.toValue(div.getKey_Button()).get名称().equals(_給付一時差止登録)) {
            if (div.getButton_Name().equals(差止登録)) {
                差止登録処理UPD001(滞納判定結果);
            } else if (div.getButton_Name().equals(削除アイコン押下)) {
                削除アイコン押下処理UPD005();
            } else if (div.getButton_Name().equals(解除アイコン押下)) {
                解除アイコン押下処理UPD002();
                UPD004();
            } else {
                UPD001();
                UPD003();
                UPD009(滞納判定結果);
            }
        } else if (ShoriKubun.toValue(div.getKey_Button()).get名称().equals(_保険料控除登録)) {
            if (div.getButton_Name().equals(控除登録)) {
                控除登録処理(滞納判定結果);
            } else if (div.getButton_Name().equals(解除アイコン押下)) {
                保険料控除登録解除アイコン押下処理UPD008();
            } else {
                UPD006();
                UPD007();
                UPD010(滞納判定結果);
            }
        }
        div.getBtnTainoJokyo().setDisabled(false);
        div.getBtnSashitomeOrKojoJokyoShokaiClose().setDisplayNone(true);
        div.getBtnSashitomeOrKojoTorokuTorikeshi().setDisabled(true);
        div.getBtnSashitomeOrKojoTorokuKakutei().setDisabled(true);
        div.getIchijiSashitome1GoKakutei().setDisabled(false);
        return pairs;
    }

    private TaishoHanteiKubun get対象管理区分(int 連番, RString 時効区分, List<ShiharaiHohoHenkoTaino> 支払方法変更滞納情報) {
        TaishoHanteiKubun 対象管理区分 = TaishoHanteiKubun._空;
        if (連番 > 1) {
            for (ShiharaiHohoHenkoTaino shiharaiHohoHenkoTaino : 支払方法変更滞納情報) {
                if (shiharaiHohoHenkoTaino.get連番() == 連番 - 1) {
                    if (JikoKubun.時効到来.getコード().equals(shiharaiHohoHenkoTaino.get時効区分())) {
                        対象管理区分 = TaishoHanteiKubun.前回対象;
                    } else if (JikoKubun.時効未到来.getコード().equals(shiharaiHohoHenkoTaino.get時効区分())
                            && JikoKubun.時効到来.getコード().equals(時効区分)) {
                        対象管理区分 = TaishoHanteiKubun.今回対象;
                    } else {
                        return 対象管理区分;
                    }
                }
            }
        } else {
            対象管理区分 = TaishoHanteiKubun.今回対象;
        }
        return 対象管理区分;
    }

    private IchijiSashitome1GoValidationHandler getValidationHandler() {
        return new IchijiSashitome1GoValidationHandler();
    }

    private boolean 抽出条件(RString 押下ボタン, ShiharaiHohoHenko shiharaiHohoHenko) {
        boolean 抽出条件 = false;
        if (押下ボタン.equals(_給付一時差止登録) && !shiharaiHohoHenko.get差止対象決定年月日().isEmpty()) {
            抽出条件 = true;
        } else if (押下ボタン.equals(_保険料控除登録)
                && (shiharaiHohoHenko.get差止対象決定年月日().isEmpty()
                && !shiharaiHohoHenko.get償還払化決定年月日().isEmpty())) {
            抽出条件 = true;
        }
        return 抽出条件;
    }

    private void initializeDisplayData(RString 押下ボタン) {
        div.setTitle(押下ボタン);
        setStatus(押下ボタン);
        setValue(押下ボタン);
    }

    private void setStatus(RString 押下ボタン) {
        if (押下ボタン.equals(_給付一時差止登録)) {
            給付一時差止登録_Status();
            DisplayNone_控除登録用(true);
        } else if (押下ボタン.equals(_保険料控除登録)) {
            ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
            List<ShiharaiHohoHenkoSashitome> sashitomeList = 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList();
            List<KeyValueDataSource> kojoNoSource = new ArrayList();
            Collections.sort(sashitomeList, new Comparator<ShiharaiHohoHenkoSashitome>() {
                @Override
                public int compare(ShiharaiHohoHenkoSashitome result1, ShiharaiHohoHenkoSashitome result2) {
                    return result2.get差止控除番号().compareTo(result1.get差止控除番号());
                }
            });
            kojoNoSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
            for (int i = sashitomeList.size() - 1; i >= 0; i--) {
                kojoNoSource.add(new KeyValueDataSource(new RString(String.valueOf(i)), new RString(String.valueOf(i))));
            }
            div.getDdlTorokuKojoNo().setDataSource(kojoNoSource);
            保険料控除登録_Status();
            DisplayNone_差止登録用(true);
        }
        償還情報一覧初期表示();
        共通初期表示();
        DisplayNone_照会用(true);
        div.getIchijiSashitome1GoKakutei().setDisabled(false);
        div.getIchijiSashitome1GoTorikeshi().setDisabled(true);
    }

    private void setValue(RString 押下ボタン) {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        div.getDgSashitomeKojoIchiran().setDataSource(creatDateSource(押下ボタン, 支払方法変更管理業務概念));
    }

    private List<dgSashitomeKojoIchiran_Row> creatDateSource(RString 押下ボタン, ShiharaiHohoHenko 支払方法変更管理業務概念) {
        List<dgSashitomeKojoIchiran_Row> rowList = new ArrayList();
        dgSashitomeKojoIchiran_Row row = new dgSashitomeKojoIchiran_Row();
        div.getTxtSagakuKingakuGokei().setValue(null);
        if (押下ボタン.equals(_給付一時差止登録)) {
            for (int i = 0; i < 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().size(); i++) {
                if (支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get情報分類区分()
                        .equals(ShiharaiHenkoJohoBunruiKubun.保険料控除情報.getコード())) {
                    row.setKojo(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止控除状態区分());
                }
                if (支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get情報分類区分()
                        .equals(ShiharaiHenkoJohoBunruiKubun.差止情報.getコード())) {
                    row.setSashitome(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止控除状態区分());
                    row.setSashitome2(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止控除状態区分());
                    row.setSeiriNo(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止償還整理番号());
                    row.getTxtTeikyoYM().setValue(new FlexibleDate(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止サービス提供年月().toString()));
                    row.getTxtSashitomeTorokuYMD().setValue(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止決定年月日());
                    row.getTxtSashitomeKaijoYMD().setValue(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止解除年月日());
                    row.getTxtNofuKigenYMD().setValue(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止納付期限());
                    if (支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止通知書発行年月日().isEmpty()) {
                        row.setSashitomeTsuchi(RString.EMPTY);
                    } else {
                        row.setSashitomeTsuchi(new RString("発行済"));
                    }
                }
                if (支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止控除状態区分()
                        .equals(ShiharaiHenkoSashitomeKojoJotaiKubun.登録.getコード().substring(1))
                        && 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止控除番号() == null) {
                    row.getKaijo().setDisabled(false);
                } else {
                    row.getKaijo().setDisabled(true);
                }
                row.setId(i);
                rowList.add(row);
            }
        } else if (押下ボタン.equals(_保険料控除登録)) {
            for (int i = 0; i < 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().size(); i++) {
                if (支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get情報分類区分().equals(ShiharaiHenkoJohoBunruiKubun.差止情報.getコード())) {
                    row.setSashitome2(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止控除状態区分());
                    row.setSeiriNo(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止償還整理番号());
                    row.getTxtTeikyoYM().setValue(new FlexibleDate(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止サービス提供年月().toString()));
                }
                row.setKojoNo(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止控除番号());
                row.getTxtKojoTorokuYMD().setValue(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get控除決定年月日());
                row.getTxtShoTeishutsuKigenYMD().setValue(支払方法変更管理業務概念.get被保険者証提出期限());
                if (支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get情報分類区分().equals(ShiharaiHenkoJohoBunruiKubun.保険料控除情報.getコード())) {
                    row.setKojo(支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止控除状態区分());
                    if (支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get控除通知書発行年月日().isEmpty()) {
                        row.setKaijoTsuchi(RString.EMPTY);
                    } else {
                        row.setKaijoTsuchi(new RString("発行済"));
                    }
                }
                if (支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList().get(i).get差止控除番号() != null) {
                    row.getKaijo().setDisabled(false);
                } else {
                    row.getKaijo().setDisabled(true);
                }
                row.setId(i);
                rowList.add(row);
            }
        }
        return rowList;
    }

    private void 給付一時差止登録_Status() {
        div.getBtnSashitomeToroku().setDisabled(false);
        div.getBtnKojoToroku().setDisabled(true);
        div.getBtnKojoToroku().setDisplayNone(true);
        div.getBtnSashitomeOrKojoJokyoShokai().setDisabled(false);
        div.getDgSashitomeKojoIchiran().setDisabled(false);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("sashitome").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("kojo").setCellDetails(new DataGridCellDetails());
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("kojo").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("sashitome2").setVisible(false);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("seiriNo").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("txtTeikyoYM").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("txtSashitomeTorokuYMD").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("txtSashitomeKaijoYMD").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("sashitomeTsuchi").setCellDetails(new DataGridCellDetails());
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("sashitomeTsuchi").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("txtNofuKigenYMD").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("kojoNo").setVisible(false);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("txtKojoTorokuYMD").setVisible(false);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("txtShoTeishutsuKigenYMD").setVisible(false);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("kaijoTsuchi").setVisible(false);
        div.getTxtSashitomeTorokuKubun().setReadOnly(true);
        div.getTxtSashitomeTorokuYMD().setReadOnly(true);
        div.getTxtSashitomeTorokuTsuchiHakkoYMD().setReadOnly(true);
        div.getTxtSashitomeNofuKigenYMD().setReadOnly(true);
        div.getTxtSashitomeKaijoYMD().setDisplayNone(true);
        div.getShokanJoho().setTitle(差止登録);
    }

    private void 保険料控除登録_Status() {
        div.getBtnSashitomeToroku().setDisplayNone(true);
        div.getBtnKojoToroku().setDisabled(true);
        div.getBtnKojoToroku().setDisabled(true);
        div.getDgSashitomeKojoIchiran().setDisabled(false);
        div.getDgSashitomeKojoIchiran().getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("sashitome").setVisible(false);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("kojo").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("sashitome2").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("seiriNo").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("txtTeikyoYM").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("txtSashitomeTorokuYMD").setVisible(false);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("txtSashitomeKaijoYMD").setVisible(false);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("txtNofuKigenYMD").setVisible(false);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("sashitomeTsuchi").setVisible(false);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("kojoNo").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("txtKojoTorokuYMD").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("txtShoTeishutsuKigenYMD").getCellDetails().setReadOnly(true);
        div.getDgSashitomeKojoIchiran().getGridSetting().getColumn("kaijoTsuchi").getCellDetails().setReadOnly(true);
        div.getTxtKojoTorokuKubun().setReadOnly(true);
        div.getTxtKojoKetteiYMD().setReadOnly(true);
        div.getTxtKojoTorokuTsuchiHakkoYMD().setReadOnly(true);
        div.getTxtHokenshoTeishutsuKigenYMD().setReadOnly(true);
        div.getDdlTorokuKojoNo().setReadOnly(true);
        div.getShokanJoho().setTitle(控除登録);
    }

    private void DisplayNone_差止登録用(boolean displayNone) {
        div.getTxtSashitomeTorokuKubun().setDisplayNone(displayNone);
        div.getTxtSashitomeTorokuYMD().setDisplayNone(displayNone);
        div.getTxtSashitomeTorokuTsuchiHakkoYMD().setDisplayNone(displayNone);
        div.getTxtSashitomeNofuKigenYMD().setDisplayNone(displayNone);
        div.getTxtSashitomeKaijoYMD().setDisplayNone(displayNone);
    }

    private void DisplayNone_控除登録用(boolean displayNone) {
        div.getTxtKojoTorokuKubun().setDisplayNone(displayNone);
        div.getTxtKojoKetteiYMD().setDisplayNone(displayNone);
        div.getTxtKojoTorokuTsuchiHakkoYMD().setDisplayNone(displayNone);
        div.getTxtHokenshoTeishutsuKigenYMD().setDisplayNone(displayNone);
        div.getDdlTorokuKojoNo().setDisplayNone(displayNone);
    }

    private void DisplayNone_照会用(boolean displayNone) {
        div.getSashitomeToroku().setDisplayNone(displayNone);
        div.getSasitomeKaijo().setDisplayNone(displayNone);
        div.getKojoToroku().setDisplayNone(displayNone);
        div.getTxtShokaiSashitomeTorokuYMD().setDisplayNone(displayNone);
        div.getTxtShokaiSashitomeNofuKigenYMD().setDisplayNone(displayNone);
        div.getTxtShokaiSashitomeTorokuTsuchiHakkoYMD().setDisplayNone(displayNone);
        div.getTxtShokaiSashitomeKaijoYMD().setDisplayNone(displayNone);
        div.getTxtShokaiKojoKetteiYMD().setDisplayNone(displayNone);
        div.getTxtShokaiHokenshoTeishutsuKigenYMD().setDisplayNone(displayNone);
        div.getTxtShokaiKojoTorokuTsuchiHakkoYMD().setDisplayNone(displayNone);
        div.getTxtShokaiKojoNo().setDisplayNone(displayNone);
    }

    private void 償還情報一覧初期表示() {
        div.getDgShokanJoho().setDisabled(false);
        div.getTxtSagakuKingakuGokei().setReadOnly(true);
        div.getDgShokanJoho().getGridSetting().getColumn("seiriNo").getCellDetails().setReadOnly(true);
        div.getDgShokanJoho().getGridSetting().getColumn("txtTeikyoYM").getCellDetails().setReadOnly(true);
        div.getDgShokanJoho().getGridSetting().getColumn("jigyoshaNo").getCellDetails().setReadOnly(true);
        div.getDgShokanJoho().getGridSetting().getColumn("serviceShurui").setCellDetails(new DataGridCellDetails());
        div.getDgShokanJoho().getGridSetting().getColumn("serviceShurui").getCellDetails().setReadOnly(true);
        div.getDgShokanJoho().getGridSetting().getColumn("txtShiharaiKingaku").getCellDetails().setReadOnly(true);
    }

    private void 共通初期表示() {
        div.getBtnTainoJokyo().setDisabled(false);
        div.getBtnSashitomeOrKojoJokyoShokaiClose().setDisplayNone(true);
        div.getBtnSashitomeOrKojoTorokuTorikeshi().setDisabled(true);
        div.getBtnSashitomeOrKojoTorokuKakutei().setDisabled(true);
    }

    private void UPD001() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        builder.set差止対象フラグ(true)
                .set差止対象決定年月日(div.getTxtSashitomeTorokuYMD().getValue());
        builder.setState(EntityDataState.Modified);
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void 差止登録処理UPD001(TainoHanteiResultKohen 滞納判定結果) {
        ShiharaiHohoHenkoSashitome 支払方法変更差止 = new ShiharaiHohoHenkoSashitome(INS001());
        List<ShiharaiHohoHenkoTaino> 支払方法変更滞納 = INS003(滞納判定結果);
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        builder.set差止対象フラグ(true)
                .set差止対象決定年月日(div.getTxtSashitomeTorokuYMD().getValue())
                .setShiharaiHohoHenkoSashitome(支払方法変更差止.createBuilderForEdit().setState(EntityDataState.Added).build());
        for (ShiharaiHohoHenkoTaino shiharaiHohoHenkoTaino : 支払方法変更滞納) {
            builder.setShiharaiHohoHenkoTaino(shiharaiHohoHenkoTaino.createBuilderForEdit().setState(EntityDataState.Added).build());
        }
        builder.setState(EntityDataState.Modified);
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void 解除アイコン押下処理UPD002() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        builder.set差止対象フラグ(false)
                .set差止対象解除年月日(div.getTxtSashitomeKaijoYMD().getValue())
                .setState(EntityDataState.Modified);
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void UPD003() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList()) {
            builder.setShiharaiHohoHenkoSashitome(shiharaiHohoHenkoSashitome.createBuilderForEdit()
                    .set差止決定年月日(div.getTxtSashitomeTorokuYMD().getValue())
                    .set差止納付期限(div.getTxtSashitomeNofuKigenYMD().getValue())
                    .setState(EntityDataState.Modified).build())
                    .setState(EntityDataState.Modified);
        }
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void UPD004() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList()) {
            builder.setShiharaiHohoHenkoSashitome(shiharaiHohoHenkoSashitome.createBuilderForEdit()
                    .set差止控除状態区分(ShiharaiHenkoSashitomeKojoJotaiKubun.解除.getコード())
                    .set差止通知書発行年月日(FlexibleDate.EMPTY)
                    .set差止通知書再発行フラグ(false)
                    .set差止控除番号(RString.EMPTY)
                    .set差止解除年月日(div.getTxtSashitomeKaijoYMD().getValue())
                    .setState(EntityDataState.Modified).build())
                    .setState(EntityDataState.Modified);
        }
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void 削除アイコン押下処理UPD005() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList()) {
            if (shiharaiHohoHenkoSashitome.get情報分類区分().equals(ShiharaiHenkoJohoBunruiKubun.差止情報.getコード())) {
                builder.setShiharaiHohoHenkoSashitome(shiharaiHohoHenkoSashitome.createBuilderForEdit()
                        .set論理削除フラグ(true)
                        .setState(EntityDataState.Modified).build())
                        .setState(EntityDataState.Modified);
            }
        }
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void 控除登録処理(TainoHanteiResultKohen 滞納判定結果) {
        ShiharaiHohoHenkoSashitome 支払方法変更差止 = new ShiharaiHohoHenkoSashitome(INS002());
        List<ShiharaiHohoHenkoTaino> 支払方法変更滞納 = INS004(滞納判定結果);
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        List<ShiharaiHohoHenkoSashitome> shiharaiHohoHenkoSashitomeList = new ArrayList();
        builder.setShiharaiHohoHenkoSashitome(支払方法変更差止.createBuilderForEdit().setState(EntityDataState.Added).build());
        for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList()) {
            if (shiharaiHohoHenkoSashitome.get情報分類区分().equals(ShiharaiHenkoJohoBunruiKubun.差止情報.getコード())) {
                shiharaiHohoHenkoSashitomeList.add(shiharaiHohoHenkoSashitome);
            }
        }
        if (!shiharaiHohoHenkoSashitomeList.isEmpty()) {
            Collections.sort(shiharaiHohoHenkoSashitomeList, new Comparator<ShiharaiHohoHenkoSashitome>() {
                @Override
                public int compare(ShiharaiHohoHenkoSashitome result1, ShiharaiHohoHenkoSashitome result2) {
                    return result2.get連番() >= result1.get連番() ? 1 : -1;
                }
            });
            builder.setShiharaiHohoHenkoSashitome(shiharaiHohoHenkoSashitomeList.get(0).createBuilderForEdit()
                    .set差止控除番号(div.getDdlTorokuKojoNo().getSelectedKey())
                    .setState(EntityDataState.Modified).build());
        }
        for (ShiharaiHohoHenkoTaino shiharaiHohoHenkoTaino : 支払方法変更滞納) {
            builder.setShiharaiHohoHenkoTaino(shiharaiHohoHenkoTaino.createBuilderForEdit().setState(EntityDataState.Added).build());
        }
        builder.setState(EntityDataState.Modified);
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void 保険料控除登録解除アイコン押下処理UPD008() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList()) {
            if (shiharaiHohoHenkoSashitome.get情報分類区分().equals(ShiharaiHenkoJohoBunruiKubun.保険料控除情報.getコード())) {
                builder.setShiharaiHohoHenkoSashitome(shiharaiHohoHenkoSashitome.createBuilderForEdit()
                        .set論理削除フラグ(true).build());
            }
        }
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void UPD006() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList()) {
            builder.setShiharaiHohoHenkoSashitome(shiharaiHohoHenkoSashitome.createBuilderForEdit()
                    .set差止控除番号(div.getDdlTorokuKojoNo().getSelectedKey())
                    .set控除決定年月日(FlexibleDate.MAX)
                    .set控除被保険者証提出期限(FlexibleDate.MAX)
                    .setState(EntityDataState.Modified).build())
                    .setState(EntityDataState.Modified);
        }
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void UPD007() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        List<ShiharaiHohoHenkoSashitome> shiharaiHohoHenkoSashitomeList = new ArrayList();
        for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList()) {
            if (shiharaiHohoHenkoSashitome.get情報分類区分().equals(ShiharaiHenkoJohoBunruiKubun.差止情報.getコード())) {
                shiharaiHohoHenkoSashitomeList.add(shiharaiHohoHenkoSashitome);
            }
        }
        if (!shiharaiHohoHenkoSashitomeList.isEmpty()) {
            Collections.sort(shiharaiHohoHenkoSashitomeList, new Comparator<ShiharaiHohoHenkoSashitome>() {
                @Override
                public int compare(ShiharaiHohoHenkoSashitome result1, ShiharaiHohoHenkoSashitome result2) {
                    return result2.get連番() >= result1.get連番() ? 1 : -1;
                }
            });
            builder.setShiharaiHohoHenkoSashitome(shiharaiHohoHenkoSashitomeList.get(0).createBuilderForEdit()
                    .set差止控除番号(div.getDdlTorokuKojoNo().getSelectedKey())
                    .setState(EntityDataState.Modified).build());
        }
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void UPD009(TainoHanteiResultKohen 滞納判定結果) {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        List<TainoKiSummary> tainoKiSummary = 滞納判定結果.get滞納情報();
        for (ShiharaiHohoHenkoTaino shiharaiHohoHenkoTaino : 支払方法変更管理業務概念.getShiharaiHohoHenkoTainoList()) {
            for (TainoKiSummary summary : tainoKiSummary) {
                TaishoHanteiKubun 対象管理区分 = get対象管理区分(shiharaiHohoHenkoTaino.get連番(), summary.get時効区分().getコード(), 支払方法変更管理業務概念.getShiharaiHohoHenkoTainoList());
                if (shiharaiHohoHenkoTaino.get調定年度().equals(summary.get調定年度())
                        && shiharaiHohoHenkoTaino.get賦課年度().equals(summary.get賦課年度())
                        && shiharaiHohoHenkoTaino.get通知書番号().equals(summary.get通知書番号())
                        && shiharaiHohoHenkoTaino.get特徴_普徴区分().equals(summary.get徴収方法().getコード())
                        && shiharaiHohoHenkoTaino.get収納期_月().equals(summary.get期())) {
                    builder.setShiharaiHohoHenkoTaino(shiharaiHohoHenkoTaino.createBuilderForEdit().set滞納判定年月日(FlexibleDate.getNowDate())
                            .set判定基準年月日(滞納判定結果.get滞納判定基準日())
                            .set時効起算年月日(summary.get時効起算日())
                            .set時効起算日区分(summary.get時効起算日区分().getコード())
                            .set完納_未納区分(summary.get未納完納区分().getコード())
                            .set時効区分(summary.get時効区分().getコード())
                            .set時効後収入区分(summary.get時効後収入区分().getコード())
                            .set対象管理区分(対象管理区分.getコード())
                            .set調定額(summary.get調定額())
                            .set納期限(new FlexibleDate(summary.get納期限().toDateString()))
                            .set滞納額(summary.get滞納額())
                            .set控除額(summary.get控除額())
                            .setState(EntityDataState.Modified).build())
                            .setState(EntityDataState.Modified);
                }
            }
        }
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void UPD010(TainoHanteiResultKohen 滞納判定結果) {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        List<ShiharaiHohoHenkoTaino> 支払方法変更滞納情報 = new ArrayList();
        List<TainoKiSummary> tainoKiSummary = 滞納判定結果.get滞納情報();
        for (ShiharaiHohoHenkoTaino shiharaiHohoHenkoTaino : 支払方法変更管理業務概念.getShiharaiHohoHenkoTainoList()) {
            for (TainoKiSummary summary : tainoKiSummary) {
                TaishoHanteiKubun 対象管理区分 = get対象管理区分(shiharaiHohoHenkoTaino.get連番(), summary.get時効区分().getコード(), 支払方法変更滞納情報);
                if (shiharaiHohoHenkoTaino.get調定年度().equals(summary.get調定年度())
                        && shiharaiHohoHenkoTaino.get賦課年度().equals(summary.get賦課年度())
                        && shiharaiHohoHenkoTaino.get通知書番号().equals(summary.get通知書番号())
                        && shiharaiHohoHenkoTaino.get特徴_普徴区分().equals(summary.get徴収方法().getコード())
                        && shiharaiHohoHenkoTaino.get収納期_月().equals(summary.get期())) {
                    builder.setShiharaiHohoHenkoTaino(shiharaiHohoHenkoTaino.createBuilderForEdit().set滞納判定年月日(FlexibleDate.getNowDate())
                            .set判定基準年月日(滞納判定結果.get滞納判定基準日())
                            .set時効起算年月日(summary.get時効起算日())
                            .set時効起算日区分(summary.get時効起算日区分().getコード())
                            .set完納_未納区分(summary.get未納完納区分().getコード())
                            .set時効区分(summary.get時効区分().getコード())
                            .set時効後収入区分(summary.get時効後収入区分().getコード())
                            .set対象管理区分(対象管理区分.getコード())
                            .set調定額(summary.get調定額())
                            .set納期限(new FlexibleDate(summary.get納期限().toDateString()))
                            .set滞納額(summary.get滞納額())
                            .set控除額(summary.get控除額())
                            .setState(EntityDataState.Modified).build());
                }
            }
        }
        ViewStateHolder.put(一号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private DbT4024ShiharaiHohoHenkoSashitomeEntity INS001() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        DbT4024ShiharaiHohoHenkoSashitomeEntity entity = new DbT4024ShiharaiHohoHenkoSashitomeEntity();
        entity.setShoKisaiHokenshaNo(証記載保険者番号());
        entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
        entity.setKanriKubun(ShiharaiHenkoKanriKubun._２号差止.getコード());
        entity.setRirekiNo(支払方法変更管理業務概念.get履歴番号());
        entity.setJohoBunruiKubun(ShiharaiHenkoJohoBunruiKubun.差止情報.getコード());
        entity.setRenNo(支払方法変更差止連番(entity.getShoKisaiHokenshaNo(), entity.getHihokenshaNo(), entity.getKanriKubun(),
                entity.getRirekiNo(), entity.getJohoBunruiKubun(), 支払方法変更管理業務概念));
        entity.setSashitomeKojoJotaiKubun(ShiharaiHenkoSashitomeKojoJotaiKubun.登録.getコード());
        entity.setSashitome_KetteiYMD(div.getTxtSashitomeTorokuYMD().getValue());
        entity.setSashitome_TsuchiSaiHakkoFlag(false);
        entity.setSashitome_NofuYMD(div.getTxtSashitomeNofuKigenYMD().getValue());
        entity.setSashitome_ServiceTeikyoYM(div.getDgSashitomeKojoIchiran().getClickedItem().getTxtTeikyoYM().getValue().getYearMonth());
        entity.setSashitome_ShokanSeiriNo(div.getDgSashitomeKojoIchiran().getClickedItem().getSeiriNo());
        entity.setLogicalDeletedFlag(false);
        return entity;
    }

    private DbT4024ShiharaiHohoHenkoSashitomeEntity INS002() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        DbT4024ShiharaiHohoHenkoSashitomeEntity entity = new DbT4024ShiharaiHohoHenkoSashitomeEntity();
        entity.setShoKisaiHokenshaNo(証記載保険者番号());
        entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
        entity.setKanriKubun(ShiharaiHenkoKanriKubun._２号差止.getコード());
        entity.setRirekiNo(支払方法変更管理業務概念.get履歴番号());
        entity.setJohoBunruiKubun(ShiharaiHenkoJohoBunruiKubun.保険料控除情報.getコード());
        entity.setRenNo(支払方法変更差止連番(entity.getShoKisaiHokenshaNo(), entity.getHihokenshaNo(), entity.getKanriKubun(),
                entity.getRirekiNo(), entity.getJohoBunruiKubun(), 支払方法変更管理業務概念));
        entity.setSashitomeKojoJotaiKubun(ShiharaiHenkoSashitomeKojoJotaiKubun.登録.getコード());
        entity.setSashitome_KetteiYMD(div.getTxtSashitomeTorokuYMD().getValue());
        entity.setSashitome_TsuchiSaiHakkoFlag(false);
        entity.setSashitome_NofuYMD(div.getTxtSashitomeNofuKigenYMD().getValue());
        entity.setSashitome_ServiceTeikyoYM(div.getDgSashitomeKojoIchiran().getClickedItem().getTxtTeikyoYM().getValue().getYearMonth());
        entity.setSashitome_ShokanSeiriNo(div.getDgSashitomeKojoIchiran().getClickedItem().getSeiriNo());
        entity.setLogicalDeletedFlag(false);
        return entity;
    }

    private List<ShiharaiHohoHenkoTaino> INS003(TainoHanteiResultKohen 滞納判定結果) {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        List<ShiharaiHohoHenkoTaino> 支払方法変更滞納情報 = new ArrayList();
        List<TainoKiSummary> tainoKiSummary = 滞納判定結果.get滞納情報();
        int 連番 = 支払方法変更滞納連番(証記載保険者番号(), new HihokenshaNo(div.getKey_HihokenshaNo()),
                ShiharaiHenkoKanriKubun._１号償還払い化.getコード(), 支払方法変更管理業務概念.get履歴番号(),
                TainoHanteiKubun.差止登録.getコード(), 支払方法変更管理業務概念);
        for (TainoKiSummary summary : tainoKiSummary) {
            TaishoHanteiKubun 対象管理区分 = get対象管理区分(連番++, summary.get時効区分().getコード(), 支払方法変更滞納情報);
            DbT4022ShiharaiHohoHenkoTainoEntity entity = new DbT4022ShiharaiHohoHenkoTainoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号());
            entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
            entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号償還払い化.getコード());
            entity.setRirekiNo(支払方法変更管理業務概念.get履歴番号());
            entity.setTainoHanteiKubun(TainoHanteiKubun.差止登録.getコード());
            entity.setRenNo(連番++);
            entity.setChoteiNendo(summary.get調定年度());
            entity.setFukaNendo(summary.get賦課年度());
            entity.setTsuchishoNo(summary.get通知書番号());
            entity.setTokucho_fuchoKubun(summary.get徴収方法().getコード());
            entity.setShuno_Ki_Tsuki(summary.get期());
            entity.setTainoHanteiYMD(FlexibleDate.getNowDate());
            entity.setHanteiKijunYMD(滞納判定結果.get滞納判定基準日());
            entity.setJikoKisanYMD(summary.get時効起算日());
            entity.setJikoKisanKubun(summary.get時効起算日区分().getコード());
            entity.setKanno_MinoKubun(summary.get未納完納区分().getコード());
            entity.setJikoKubun(summary.get時効区分().getコード());
            entity.setJikoAtoShunyuKubun(summary.get時効後収入区分().getコード());
            entity.setTaishoKanriKubun(対象管理区分.getコード());
            entity.setChoteigaku(summary.get調定額());
            entity.setKojoGaku(summary.get控除額());
            entity.setTainoGaku(summary.get滞納額());
            entity.setNokigen(new FlexibleDate(summary.get納期限().toDateString()));
            entity.setLogicalDeletedFlag(false);
            支払方法変更滞納情報.add(new ShiharaiHohoHenkoTaino(entity));
        }
        return 支払方法変更滞納情報;
    }

    private List<ShiharaiHohoHenkoTaino> INS004(TainoHanteiResultKohen 滞納判定結果) {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        List<ShiharaiHohoHenkoTaino> 支払方法変更滞納情報 = new ArrayList();
        List<TainoKiSummary> tainoKiSummary = 滞納判定結果.get滞納情報();
        int 連番 = 支払方法変更滞納連番(証記載保険者番号(), new HihokenshaNo(div.getKey_HihokenshaNo()),
                ShiharaiHenkoKanriKubun._１号償還払い化.getコード(), 支払方法変更管理業務概念.get履歴番号(),
                TainoHanteiKubun.控除登録.getコード(), 支払方法変更管理業務概念);
        for (TainoKiSummary summary : tainoKiSummary) {
            TaishoHanteiKubun 対象管理区分 = get対象管理区分(連番++, summary.get時効区分().getコード(), 支払方法変更滞納情報);
            DbT4022ShiharaiHohoHenkoTainoEntity entity = new DbT4022ShiharaiHohoHenkoTainoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号());
            entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
            entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号償還払い化.getコード());
            entity.setRirekiNo(支払方法変更管理業務概念.get履歴番号());
            entity.setTainoHanteiKubun(TainoHanteiKubun.控除登録.getコード());
            entity.setRenNo(連番++);
            entity.setChoteiNendo(summary.get調定年度());
            entity.setFukaNendo(summary.get賦課年度());
            entity.setTsuchishoNo(summary.get通知書番号());
            entity.setTokucho_fuchoKubun(summary.get徴収方法().getコード());
            entity.setShuno_Ki_Tsuki(summary.get期());
            entity.setTainoHanteiYMD(FlexibleDate.getNowDate());
            entity.setHanteiKijunYMD(滞納判定結果.get滞納判定基準日());
            entity.setJikoKisanYMD(summary.get時効起算日());
            entity.setJikoKisanKubun(summary.get時効起算日区分().getコード());
            entity.setKanno_MinoKubun(summary.get未納完納区分().getコード());
            entity.setJikoKubun(summary.get時効区分().getコード());
            entity.setJikoAtoShunyuKubun(summary.get時効後収入区分().getコード());
            entity.setTaishoKanriKubun(対象管理区分.getコード());
            entity.setChoteigaku(summary.get調定額());
            entity.setKojoGaku(summary.get控除額());
            entity.setTainoGaku(summary.get滞納額());
            entity.setNokigen(new FlexibleDate(summary.get納期限().toDateString()));
            entity.setLogicalDeletedFlag(false);
            支払方法変更滞納情報.add(new ShiharaiHohoHenkoTaino(entity));
        }
        return 支払方法変更滞納情報;
    }

    private int 支払方法変更差止連番(ShoKisaiHokenshaNo shoKisaiHokenshaNo, HihokenshaNo hihokenshaNo, RString kanriKubun, int rirekiNo,
            RString johoBunruiKubun, ShiharaiHohoHenko 支払方法変更管理業務概念) {
        int 連番 = 0;
        for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList()) {
            if (shiharaiHohoHenkoSashitome.get証記載保険者番号().equals(shoKisaiHokenshaNo)
                    && shiharaiHohoHenkoSashitome.get被保険者番号().equals(hihokenshaNo)
                    && shiharaiHohoHenkoSashitome.get管理区分().equals(kanriKubun)
                    && shiharaiHohoHenkoSashitome.get履歴番号() == rirekiNo
                    && shiharaiHohoHenkoSashitome.get情報分類区分().equals(johoBunruiKubun)) {
                連番 = shiharaiHohoHenkoSashitome.get連番();
            }
        }
        return 連番 + 1;
    }

    private int 支払方法変更滞納連番(ShoKisaiHokenshaNo shoKisaiHokenshaNo, HihokenshaNo hihokenshaNo, RString コード, int 履歴番号,
            RString コード0, ShiharaiHohoHenko 支払方法変更管理業務概念) {
        int 連番 = 0;
        for (ShiharaiHohoHenkoTaino shiharaiHohoHenkoTaino : 支払方法変更管理業務概念.getShiharaiHohoHenkoTainoList()) {
            if (shiharaiHohoHenkoTaino.get証記載保険者番号().equals(shoKisaiHokenshaNo)
                    && shiharaiHohoHenkoTaino.get被保険者番号().equals(hihokenshaNo)
                    && shiharaiHohoHenkoTaino.get管理区分().equals(コード)
                    && shiharaiHohoHenkoTaino.get履歴番号() == 履歴番号
                    && shiharaiHohoHenkoTaino.get滞納判定区分().equals(コード0)) {
                連番 = shiharaiHohoHenkoTaino.get連番();
            }
        }
        return 連番 + 1;
    }

    private ShoKisaiHokenshaNo 証記載保険者番号() {
        ShoKisaiHokenshaNo 証記載保険者番号 = ShoKisaiHokenshaNo.EMPTY;
        ShichosonSecurityJoho 市町村情報 = ShichosonSecurityJohoFinder.createInstance()
                .getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村情報 != null) {
            証記載保険者番号 = 市町村情報.get市町村情報().get証記載保険者番号();
        }

        return 証記載保険者番号;
    }
}
