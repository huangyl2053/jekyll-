/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.shokanbaraika1go.ShokanBaraiKa1Go;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenkoBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTaino;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResultKohen;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoKiSummary;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoBenmeiRiyuCode;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoBenmeiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoShinseiRiyuCode;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoShinseiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TainoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TaishoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko.ShiharaiHohoHenkoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoMukoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.JikoKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 【共有子Div】 1号償還払い化ダイアログのハンドラクラスです。
 *
 * @reamsid_L DBD-3620-041 mawy
 */
public class ShokanBaraiKa1GoHandler {

    private final ShokanBaraiKa1GoDiv div;

    private final RString _１号予告者登録 = new RString("１号予告者登録");
    private final RString _１号弁明書受理 = new RString("１号弁明書受理");
    private final RString 償還払い化登録 = new RString("償還払い化登録");
    private final RString 新規登録 = new RString("新規登録");
    private final RString 新規区分_空 = new RString("空");

    /**
     * 一号償還払い化ダイアログキーのEnum
     */
    private enum 一号償還払い化ダイアログキー {

        /**
         * 画面更新用情報
         */
        支払方法変更管理業務概念;
    }

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】 1号償還払い化ダイアログDiv
     */
    public ShokanBaraiKa1GoHandler(ShokanBaraiKa1GoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        RString 押下ボタン = div.getKey_Button();
        List<ShiharaiHohoHenko> 支払方法変更管理業務概念List = DataPassingConverter.deserialize(div.getKey_ShiharaiHohoHenkoKanri(), List.class);
        List<ShiharaiHohoHenko> 支払方法データ = new ArrayList();
        ViewStateHolder.put(一号償還払い化ダイアログキー.支払方法変更管理業務概念, null);
        if (支払方法変更管理業務概念List != null) {
            for (ShiharaiHohoHenko shiharaiHohoHenko : 支払方法変更管理業務概念List) {
                if (shiharaiHohoHenko.get被保険者番号().value().equals(div.getKey_HihokenshaNo())
                        && shiharaiHohoHenko.get管理区分().equals(ShiharaiHenkoKanriKubun._１号償還払い化.getコード())
                        && shiharaiHohoHenko.get登録区分().equals(get登録区分())) {
                    if ((押下ボタン.equals(_１号予告者登録) && shiharaiHohoHenko.get予告登録年月日() == null)
                            || (押下ボタン.equals(償還払い化登録) && shiharaiHohoHenko.get償還払化決定年月日() == null)) {
                        div.setShinkiKubun(新規登録);
                    } else if (押下ボタン.equals(_１号予告者登録) || 押下ボタン.equals(償還払い化登録)) {
                        div.setShinkiKubun(新規区分_空);
                    }
                    支払方法データ.add(shiharaiHohoHenko);
                }
            }
        }
        if (支払方法データ.isEmpty()) {
            if (div.getKey_Button().equals(_１号予告者登録)) {
                div.setShinkiKubun(新規登録);
            } else {
                throw new ApplicationException(UrErrorMessages.対象ファイルが存在しない.getMessage().replace("支払方法変更"));
            }
        } else {
            ViewStateHolder.put(一号償還払い化ダイアログキー.支払方法変更管理業務概念, 支払方法データ.get(0));
        }
        initializeDisplayData(ViewStateHolder.get(一号償還払い化ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class));
    }

    /**
     * 「取消」ボタンの処理です。
     *
     * @return ［画面］登録状況が空(Empty)か否か
     */
    public boolean onClick_BtnTorikeshi() {
        return !div.getShinkiKubun().equals(新規区分_空);
    }

    /**
     * 「確定」ボタンの処理です。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs onClick_BtnKakutei() {
        ValidationMessageControlPairs pairs = getValidationMessages();
        if (pairs.iterator().hasNext()) {
            return pairs;
        }
        ShiharaiHohoHenkoManager manager = ShiharaiHohoHenkoManager.createInstance();
        TainoHanteiResultKohen 滞納判定結果 = DataPassingConverter.deserialize(div.getTainoHanteiKekka(), TainoHanteiResultKohen.class);
        ShiharaiHohoHenkoEntity 支払方法変更Entity = new ShiharaiHohoHenkoEntity();
        switch (div.getKey_Button().toString()) {
            case "１号予告者登録":
                if (div.getShinkiKubun().equals(新規登録)) {
                    支払方法変更Entity.set支払方法変更Entity(get1号予告者登録の登録Entity());
                    支払方法変更Entity.set支払方法変更滞納Entity(get支払方法変更滞納Entity(滞納判定結果, TainoHanteiKubun.予告登録.getコード()));
                    ViewStateHolder.put(一号償還払い化ダイアログキー.支払方法変更管理業務概念, new ShiharaiHohoHenko(支払方法変更Entity));
                } else {
                    update支払方法変更_1号予告者();
                    update支払方法変更滞納(滞納判定結果, TainoHanteiKubun.予告登録.getコード());
                }
                break;
            case "１号弁明書受理":
                update支払方法変更_1号弁明書受理();
                break;
            case "償還払い化登録":
                if (div.getShinkiKubun().equals(新規登録)) {
                    支払方法変更Entity.set支払方法変更Entity(get償還払い化登録の登録Entity());
                    支払方法変更Entity.set支払方法変更滞納Entity(get支払方法変更滞納Entity(滞納判定結果, TainoHanteiKubun.償還払化登録.getコード()));
                    ViewStateHolder.put(一号償還払い化ダイアログキー.支払方法変更管理業務概念, new ShiharaiHohoHenko(支払方法変更Entity));
                } else {
                    update支払方法変更_償還払い化登録();
                    update支払方法変更滞納(滞納判定結果, TainoHanteiKubun.償還払化登録.getコード());
                }
                break;
            case "償還払い化終了申請":
                update支払方法変更_償還払い化終了申請();
                break;
            default:
                break;
        }
        manager.save(ViewStateHolder.get(一号償還払い化ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class));
        return pairs;
    }

    /**
     * 滞納状況ダイアログを開く前に実行されるイベントを設定します。
     */
    public void onBeforeOpenDialog_BtnTainoJokyo() {
        div.setHihokenshaNo(div.getKey_HihokenshaNo());
        div.setKanriKubun(ShiharaiHenkoKanriKubun._１号償還払い化.getコード());
        if ((div.getKey_Button().equals(_１号予告者登録) || div.getKey_Button().equals(_１号弁明書受理))) {
            div.setTainoHanteiKubun(TainoHanteiKubun.予告登録.getコード());
        } else {
            div.setTainoHanteiKubun(TainoHanteiKubun.償還払化登録.getコード());
        }
        div.setRirekiNo(RString.EMPTY);
    }

    /**
     * 滞納状況ダイアログが確定クローズイベントで閉じられたときにダイアログが完全に閉じた後に実行されるイベントを設定します。
     */
    public void onOkClose_BtnTainoJokyo() {
        TainoHanteiResultKohen 滞納判定結果 = ViewStateHolder.get(ViewStateKeys.滞納判定結果, TainoHanteiResultKohen.class);
        if (滞納判定結果 != null && 滞納判定結果.get滞納情報() != null) {
            div.setTainoHanteiKekka(DataPassingConverter.serialize(滞納判定結果));
            if (div.getKey_Button().equals(_１号予告者登録) || div.getKey_Button().equals(償還払い化登録)) {
                div.getBtnTainoJokyo().setIconNameEnum(IconName.Check);
            }
        }
    }

    private void initializeDisplayData(ShiharaiHohoHenko shiharaiHohoHenko) {
        div.setTitle(div.getKey_Button());
        List<KeyValueDataSource> shiryoJokyoSource = new ArrayList();
        List<ShiharaiHenkoShuryoKubun> shuyoKubunList = ShiharaiHenkoShuryoKubun.valuesAt償還払い化終了申請();
        for (ShiharaiHenkoShuryoKubun shuyoKubun : shuyoKubunList) {
            shiryoJokyoSource.add(new KeyValueDataSource(shuyoKubun.getコード(), shuyoKubun.get名称()));
        }
        div.getDdlShuryoJokyo().setDataSource(shiryoJokyoSource);
        setStatus();
        setValue(shiharaiHohoHenko);
    }

    private void DisplayNone_１号予告者登録(boolean displayNone) {
        div.getTxtIraiJuriYMD().setDisplayNone(displayNone);
        div.getTxtYokokuTorokuYMD().setDisplayNone(displayNone);
        div.getTxtBemmeishoTeishutsuKigenYMD().setDisplayNone(displayNone);
        div.getTxtYokokuTsuchiHakkoYMD().setDisplayNone(displayNone);
    }

    private void DisplayNone_１号弁明書受理(boolean displayNone) {
        div.getTxtBemmeiUketsukeYMD().setDisplayNone(displayNone);
        div.getDdlBemmeiRiyu().setDisplayNone(displayNone);
        div.getTxtBemmeiNaiyoKetteiYMD().setDisplayNone(displayNone);
        div.getDdlBemmeiShinsaKekka().setDisplayNone(displayNone);
    }

    private void DisplayNone_償還払い化登録(boolean displayNone) {
        div.getTxtHenkoKetteiYMD().setDisplayNone(displayNone);
        div.getTxtHokenshoTeishutsuKigenYMD().setDisplayNone(displayNone);
        div.getTxtHenkoTsuchiHakkoYMD().setDisplayNone(displayNone);
    }

    private void DisplayNone_償還払い化終了申請(boolean displayNone) {
        div.getTxtShinseiUketsukeYMD().setDisplayNone(displayNone);
        div.getDdlShinseiRiyu().setDisplayNone(displayNone);
        div.getTxtShinseiYMD().setDisplayNone(displayNone);
        div.getTxtShinseiNaiyoKetteiYMD().setDisplayNone(displayNone);
        div.getDdlShinseiShinsaKekka().setDisplayNone(displayNone);
    }

    private RString get登録区分() {
        RString torokuKubun = new RString("");
        switch (div.getKey_Button().toString()) {
            case "１号予告者登録":
            case "１号弁明書受理":
                torokuKubun = ShiharaiHenkoTorokuKubun._１号予告登録者.getコード();
                break;
            case "償還払い化登録":
            case "償還払い化終了申請":
                torokuKubun = ShiharaiHenkoTorokuKubun._１号償還払い化登録.getコード();
                break;
            default:
                break;
        }
        return torokuKubun;
    }

    private int get最大履歴番号() {
        if (div.getKey_MaxRirekiNo().isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(div.getKey_MaxRirekiNo().toString());
        }
    }

    private int get最小連番(int 履歴番号, RString 滞納判定区分) {
        int 連番 = 1;
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号償還払い化ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        List<ShiharaiHohoHenkoTaino> 支払方法変更滞納情報 = 支払方法変更管理業務概念.getShiharaiHohoHenkoTainoList();
        List<ShiharaiHohoHenkoTaino> 連番確定支払方法変更滞納List = new ArrayList();
        for (ShiharaiHohoHenkoTaino shiharaiHohoHenkoTaino : 支払方法変更滞納情報) {
            if (shiharaiHohoHenkoTaino.get被保険者番号().equals(new HihokenshaNo(div.getKey_HihokenshaNo()))
                    && ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(shiharaiHohoHenkoTaino.get管理区分())
                    && shiharaiHohoHenkoTaino.get履歴番号() == 履歴番号
                    && 滞納判定区分.equals(shiharaiHohoHenkoTaino.get滞納判定区分())) {
                連番確定支払方法変更滞納List.add(shiharaiHohoHenkoTaino);
            }
        }
        if (!連番確定支払方法変更滞納List.isEmpty()) {
            Collections.sort(連番確定支払方法変更滞納List, new Comparator<ShiharaiHohoHenkoTaino>() {

                @Override
                public int compare(ShiharaiHohoHenkoTaino result1, ShiharaiHohoHenkoTaino result2) {
                    return result2.get連番() >= result1.get連番() ? 1 : -1;
                }
            });
            連番 = 連番確定支払方法変更滞納List.get(連番確定支払方法変更滞納List.size() - 1).get連番();
        }
        return 連番;
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
                    }
                }
            }
        } else {
            対象管理区分 = TaishoHanteiKubun.今回対象;
        }
        return 対象管理区分;
    }

    private ValidationMessageControlPairs getValidationMessages() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号償還払い化ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor滞納状況情報(pairs, div, 支払方法変更管理業務概念);
        getValidationHandler().validateFor適用期間チェック(pairs, div);
        getValidationHandler().validateFor弁明受付日入力チェック(pairs, div);
        getValidationHandler().validateFor弁明内容決定日入力チェック(pairs, div);
        getValidationHandler().validateFor適用期間終了入力チェック(pairs, div);
        getValidationHandler().validateFor申請受付日入力チェック(pairs, div);
        getValidationHandler().validateFor申請日入力チェック(pairs, div);
        getValidationHandler().validateFor申請内容決定日入力チェック(pairs, div);
        getValidationHandler().validateFor弁明審査結果選択チェック(pairs, div);
        getValidationHandler().validateFor弁明理由選択チェック(pairs, div);
        getValidationHandler().validateFor申請審査結果選択チェック(pairs, div);
        getValidationHandler().validateFor申請理由選択チェック(pairs, div);
        getValidationHandler().validateFor終了状況選択チェック(pairs, div);
        return pairs;
    }

    private ShokanBaraiKa1GoValidationHandler getValidationHandler() {
        return new ShokanBaraiKa1GoValidationHandler();
    }

    private DbT4021ShiharaiHohoHenkoEntity get1号予告者登録の登録Entity() {
        DbT4021ShiharaiHohoHenkoEntity entity = new DbT4021ShiharaiHohoHenkoEntity();
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo("209007"));
        entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
        entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号償還払い化.getコード());
        entity.setRirekiNo(get最大履歴番号() + 1);
        entity.setTorokuKubun(ShiharaiHenkoTorokuKubun._１号予告登録者.getコード());
        entity.setShuryoKubun(ShiharaiHenkoShuryoKubun._空.getコード());
        entity.setYokoku_TorokuYMD(div.getTxtYokokuTorokuYMD().getValue());
        entity.setYokoku_TsuchiSaiHakkoFlag(false);
        entity.setBemmei_TeishutsuYMD(div.getTxtBemmeishoTeishutsuKigenYMD().getValue());
        entity.setBemmei_RiyuCode(ShiharaiHenkoBenmeiRiyuCode._空.getコード());
        entity.setBemmei_ShinsaKekkaKubun(ShiharaiHenkoBenmeiShinsaKekkaKubun._空.getコード());
        entity.setShokan_TsuchiSaiHakkoFlag(false);
        entity.setSashitome_Flag(false);
        entity.setShuryoShinsei_RiyuCode(ShiharaiHenkoShuryoShinseiRiyuCode._空.getコード());
        entity.setShuryoShinsei_ShinsaKekkaKubun(ShiharaiHenkoShuryoShinseiShinsaKekkaKubun._空.getコード());
        entity.setMukoKubun(ShiharaiHenkoMukoKubun.有効.getコード());
        entity.setLogicalDeletedFlag(false);
        return entity;
    }

    private List<DbT4022ShiharaiHohoHenkoTainoEntity> get支払方法変更滞納Entity(TainoHanteiResultKohen 滞納判定結果, RString 滞納判定区分) {
        List<DbT4022ShiharaiHohoHenkoTainoEntity> 支払方法変更滞納Entity = new ArrayList();
        List<ShiharaiHohoHenkoTaino> 支払方法変更滞納情報 = new ArrayList();
        List<TainoKiSummary> tainoKiSummary = 滞納判定結果.get滞納情報();
        int 連番 = 0;
        for (TainoKiSummary summary : tainoKiSummary) {
            TaishoHanteiKubun 対象管理区分 = get対象管理区分(連番++, summary.get時効区分().getコード(), 支払方法変更滞納情報);
            DbT4022ShiharaiHohoHenkoTainoEntity entity = new DbT4022ShiharaiHohoHenkoTainoEntity();
            entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo("209007"));
            entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
            entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号償還払い化.getコード());
            entity.setRirekiNo(get最大履歴番号() + 1);
            entity.setTainoHanteiKubun(滞納判定区分);
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
            支払方法変更滞納Entity.add(entity);
            支払方法変更滞納情報.add(new ShiharaiHohoHenkoTaino(entity));
        }
        return 支払方法変更滞納Entity;
    }

    private void update支払方法変更_1号弁明書受理() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号償還払い化ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        if (支払方法変更管理業務概念.get証記載保険者番号().isEmpty()
                && 支払方法変更管理業務概念.get被保険者番号().equals(new HihokenshaNo(div.getKey_HihokenshaNo()))
                && ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(支払方法変更管理業務概念.get管理区分())
                && 支払方法変更管理業務概念.get履歴番号() == get最大履歴番号()) {
            builder.set終了区分(ShiharaiHenkoShuryoKubun.弁明書受理.getコード())
                    .set弁明書受付年月日(div.getTxtBemmeiUketsukeYMD().getValue())
                    .set弁明理由コード(div.getDdlBemmeiRiyu().getSelectedKey())
                    .set弁明審査決定年月日(div.getTxtBemmeiNaiyoKetteiYMD().getValue())
                    .set弁明審査結果区分(div.getDdlBemmeiShinsaKekka().getSelectedKey());
            ViewStateHolder.put(一号償還払い化ダイアログキー.支払方法変更管理業務概念, builder.build());
        }
    }

    private void update支払方法変更_1号予告者() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号償還払い化ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        if (支払方法変更管理業務概念.get証記載保険者番号().isEmpty()
                && 支払方法変更管理業務概念.get被保険者番号().equals(new HihokenshaNo(div.getKey_HihokenshaNo()))
                && ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(支払方法変更管理業務概念.get管理区分())
                && 支払方法変更管理業務概念.get履歴番号() == get最大履歴番号()) {
            builder.set予告登録年月日(div.getTxtYokokuTorokuYMD().getValue())
                    .set弁明書提出期限(div.getTxtBemmeishoTeishutsuKigenYMD().getValue());
            ViewStateHolder.put(一号償還払い化ダイアログキー.支払方法変更管理業務概念, builder.build());
        }
    }

    private void update支払方法変更滞納(TainoHanteiResultKohen 滞納判定結果, RString 滞納判定区分) {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号償還払い化ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        List<TainoKiSummary> tainoKiSummary = 滞納判定結果.get滞納情報();
        int 最小連番 = get最小連番(get最大履歴番号(), 滞納判定区分);
        for (int i = 0; i < tainoKiSummary.size(); i++) {
            TainoKiSummary summary = tainoKiSummary.get(i);
            int 連番 = 最小連番 + i;
            TaishoHanteiKubun 対象管理区分 = get対象管理区分(連番, summary.get時効区分().getコード(), 支払方法変更管理業務概念.getShiharaiHohoHenkoTainoList());
            for (ShiharaiHohoHenkoTaino shiharaiHohoHenkoTaino : 支払方法変更管理業務概念.getShiharaiHohoHenkoTainoList()) {
                if (shiharaiHohoHenkoTaino.get証記載保険者番号().equals(new ShoKisaiHokenshaNo("209007"))
                        && shiharaiHohoHenkoTaino.get被保険者番号().equals(new HihokenshaNo(div.getKey_HihokenshaNo()))
                        && shiharaiHohoHenkoTaino.get履歴番号() == get最大履歴番号()
                        && shiharaiHohoHenkoTaino.get連番() == 連番
                        && shiharaiHohoHenkoTaino.get調定年度().equals(summary.get調定年度())
                        && shiharaiHohoHenkoTaino.get賦課年度().equals(summary.get賦課年度())
                        && shiharaiHohoHenkoTaino.get通知書番号().equals(summary.get通知書番号())
                        && shiharaiHohoHenkoTaino.get特徴_普徴区分().equals(summary.get徴収方法().getコード())
                        && shiharaiHohoHenkoTaino.get収納期_月().equals(summary.get期())) {
                    shiharaiHohoHenkoTaino.createBuilderForEdit()
                            .set滞納判定年月日(FlexibleDate.getNowDate())
                            .set判定基準年月日(滞納判定結果.get滞納判定基準日())
                            .set完納_未納区分(summary.get未納完納区分().getコード())
                            .set対象管理区分(対象管理区分.getコード())
                            .set控除額(summary.get控除額())
                            .set時効区分(summary.get時効区分().getコード())
                            .set時効後収入区分(summary.get時効後収入区分().getコード())
                            .set時効起算年月日(summary.get時効起算日())
                            .set滞納額(summary.get滞納額())
                            .set納期限(new FlexibleDate(summary.get納期限().toDateString()))
                            .set調定額(summary.get調定額());
                    shiharaiHohoHenkoTaino.createBuilderForEdit().build();
                    builder.setShiharaiHohoHenkoTaino(shiharaiHohoHenkoTaino);
                    break;
                }
            }
        }
        ViewStateHolder.put(一号償還払い化ダイアログキー.支払方法変更管理業務概念, builder.build());
    }

    private DbT4021ShiharaiHohoHenkoEntity get償還払い化登録の登録Entity() {
        DbT4021ShiharaiHohoHenkoEntity entity = new DbT4021ShiharaiHohoHenkoEntity();
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo("209007"));
        entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
        entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号償還払い化.getコード());
        entity.setRirekiNo(get最大履歴番号() + 1);
        entity.setTorokuKubun(ShiharaiHenkoTorokuKubun._１号償還払い化登録.getコード());
        entity.setTekiyoKaishiYMD(div.getTxtTekiyoKikanKaishi().getValue());
        entity.setShuryoKubun(ShiharaiHenkoShuryoKubun._空.getコード());
        entity.setYokoku_TsuchiSaiHakkoFlag(false);
        entity.setBemmei_RiyuCode(ShiharaiHenkoBenmeiRiyuCode._空.getコード());
        entity.setBemmei_ShinsaKekkaKubun(ShiharaiHenkoBenmeiShinsaKekkaKubun._空.getコード());
        entity.setShokan_KetteiYMD(div.getTxtHenkoKetteiYMD().getValue());
        entity.setShokan_TsuchiSaiHakkoFlag(false);
        entity.setHihokenshaShoTeishutsuYMD(div.getTxtHokenshoTeishutsuKigenYMD().getValue());
        entity.setSashitome_Flag(false);
        entity.setShuryoShinsei_RiyuCode(ShiharaiHenkoShuryoShinseiRiyuCode._空.getコード());
        entity.setShuryoShinsei_ShinsaKekkaKubun(ShiharaiHenkoShuryoShinseiShinsaKekkaKubun._空.getコード());
        entity.setMukoKubun(ShiharaiHenkoMukoKubun.有効.getコード());
        entity.setLogicalDeletedFlag(false);
        return entity;
    }

    private void update支払方法変更_償還払い化登録() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号償還払い化ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        if (支払方法変更管理業務概念.get証記載保険者番号().isEmpty()
                && 支払方法変更管理業務概念.get被保険者番号().equals(new HihokenshaNo(div.getKey_HihokenshaNo()))
                && ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(支払方法変更管理業務概念.get管理区分())
                && 支払方法変更管理業務概念.get履歴番号() == get最大履歴番号()) {
            builder.set適用開始年月日(div.getTxtTekiyoKikanKaishi().getValue())
                    .set償還払化決定年月日(div.getTxtHenkoKetteiYMD().getValue())
                    .set被保険者証提出期限(div.getTxtHokenshoTeishutsuKigenYMD().getValue());
            ViewStateHolder.put(一号償還払い化ダイアログキー.支払方法変更管理業務概念, builder.build());
        }
    }

    private void update支払方法変更_償還払い化終了申請() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号償還払い化ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        if (支払方法変更管理業務概念.get証記載保険者番号().isEmpty()
                && 支払方法変更管理業務概念.get被保険者番号().equals(new HihokenshaNo(div.getKey_HihokenshaNo()))
                && ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(支払方法変更管理業務概念.get管理区分())
                && 支払方法変更管理業務概念.get履歴番号() == get最大履歴番号()) {
            builder.set適用終了年月日(div.getTxtTekiyoKikanShuryo().getValue())
                    .set終了区分(div.getDdlShuryoJokyo().getSelectedKey())
                    .set終了申請書受付年月日(div.getTxtShinseiUketsukeYMD().getValue())
                    .set終了申請年月日(div.getTxtShinseiYMD().getValue())
                    .set終了申請理由コード(div.getDdlShinseiRiyu().getSelectedKey())
                    .set終了申請審査決定年月日(div.getTxtShinseiNaiyoKetteiYMD().getValue())
                    .set終了申請審査結果区分(div.getDdlShinseiShinsaKekka().getSelectedKey());
            ViewStateHolder.put(一号償還払い化ダイアログキー.支払方法変更管理業務概念, builder.build());
        }
    }

    private void setStatus() {
        switch (div.getKey_Button().toString()) {
            case "１号予告者登録":
                div.getTxtTorokuJokyo().setReadOnly(true);
                div.getTxtTekiyoKikanKaishi().setReadOnly(true);
                div.getTxtTekiyoKikanShuryo().setReadOnly(true);
                div.getDdlShuryoJokyo().setReadOnly(true);
                div.getBtnTainoJokyo().setIconNameEnum(IconName.Incomplete);
                div.getTxtIraiJuriYMD().setReadOnly(true);
                div.getTxtYokokuTsuchiHakkoYMD().setReadOnly(true);
                DisplayNone_１号弁明書受理(true);
                DisplayNone_償還払い化登録(true);
                DisplayNone_償還払い化終了申請(true);
                break;
            case "１号弁明書受理":
                div.getTxtTorokuJokyo().setReadOnly(true);
                div.getTxtTekiyoKikanKaishi().setReadOnly(true);
                div.getTxtTekiyoKikanShuryo().setReadOnly(true);
                div.getDdlShuryoJokyo().setReadOnly(true);
                div.getBtnTainoJokyo().setIconNameEnum(IconName.Info);
                List<KeyValueDataSource> bemmeiRiyuSource = new ArrayList();
                for (ShiharaiHenkoBenmeiRiyuCode riyuCode : ShiharaiHenkoBenmeiRiyuCode.values()) {
                    bemmeiRiyuSource.add(new KeyValueDataSource(riyuCode.getコード(), riyuCode.get名称()));
                }
                div.getDdlBemmeiRiyu().setDataSource(bemmeiRiyuSource);
                List<KeyValueDataSource> bemmeiShinsaKekkaSource = new ArrayList();
                for (ShiharaiHenkoBenmeiShinsaKekkaKubun bemmeiShinsaKekka : ShiharaiHenkoBenmeiShinsaKekkaKubun.values()) {
                    bemmeiShinsaKekkaSource.add(new KeyValueDataSource(bemmeiShinsaKekka.getコード(), bemmeiShinsaKekka.get名称()));
                }
                div.getDdlBemmeiShinsaKekka().setDataSource(bemmeiShinsaKekkaSource);
                DisplayNone_１号予告者登録(true);
                DisplayNone_償還払い化登録(true);
                DisplayNone_償還払い化終了申請(true);
                break;
            case "償還払い化登録":
                div.getTxtTorokuJokyo().setReadOnly(true);
                div.getTxtTekiyoKikanKaishi().setDisabled(false);
                div.getTxtTekiyoKikanShuryo().setReadOnly(true);
                div.getDdlShuryoJokyo().setDisabled(true);
                div.getBtnTainoJokyo().setIconNameEnum(IconName.Incomplete);
                div.getTxtHenkoTsuchiHakkoYMD().setDisabled(true);
                DisplayNone_１号予告者登録(true);
                DisplayNone_１号弁明書受理(true);
                DisplayNone_償還払い化終了申請(true);
                break;
            case "償還払い化終了申請":
                div.getTxtTorokuJokyo().setReadOnly(true);
                div.getTxtTekiyoKikanKaishi().setReadOnly(true);
                div.getTxtTekiyoKikanShuryo().setDisabled(false);
                div.getDdlShuryoJokyo().setDisabled(false);
                div.getBtnTainoJokyo().setIconNameEnum(IconName.Info);
                List<KeyValueDataSource> shinseiRiyuSource = new ArrayList();
                for (ShiharaiHenkoShuryoShinseiRiyuCode shinseRriyuCode : ShiharaiHenkoShuryoShinseiRiyuCode.values()) {
                    shinseiRiyuSource.add(new KeyValueDataSource(shinseRriyuCode.getコード(), shinseRriyuCode.get名称()));
                }
                div.getDdlShinseiRiyu().setDataSource(shinseiRiyuSource);
                List<KeyValueDataSource> shinsaKekkaSource = new ArrayList();
                for (ShiharaiHenkoBenmeiShinsaKekkaKubun shinsaKekka : ShiharaiHenkoBenmeiShinsaKekkaKubun.values()) {
                    shinsaKekkaSource.add(new KeyValueDataSource(shinsaKekka.getコード(), shinsaKekka.get名称()));
                }
                div.getDdlShinseiShinsaKekka().setDataSource(shinsaKekkaSource);
                DisplayNone_１号予告者登録(true);
                DisplayNone_１号弁明書受理(true);
                DisplayNone_償還払い化登録(true);
                break;
            default:
                break;
        }
    }

    private void setValue(ShiharaiHohoHenko shiharaiHohoHenko) {
        if (div.getShinkiKubun().equals(新規登録)) {
            div.getBtnTainoJokyo().setIconNameEnum(IconName.Incomplete);
            switch (div.getKey_Button().toString()) {
                case "１号予告者登録":
                    div.getTxtTorokuJokyo().setValue(ShiharaiHenkoTorokuKubun._１号予告登録者.get名称());
                    div.getTxtTekiyoKikanKaishi().setValue(null);
                    div.getTxtTekiyoKikanShuryo().setValue(null);
                    div.getTxtIraiJuriYMD().setValue(null);
                    div.getTxtYokokuTorokuYMD().setValue(FlexibleDate.getNowDate());
                    div.getTxtBemmeishoTeishutsuKigenYMD().setValue(FlexibleDate.getNowDate());
                    div.getTxtYokokuTsuchiHakkoYMD().setValue(null);
                    break;
                case "償還払い化登録":
                    div.getTxtTorokuJokyo().setValue(ShiharaiHenkoTorokuKubun._１号償還払い化登録.get名称());
                    div.getTxtTekiyoKikanKaishi().setValue(FlexibleDate.getNowDate());
                    div.getTxtTekiyoKikanShuryo().setValue(null);
                    div.getTxtHenkoKetteiYMD().setValue(FlexibleDate.getNowDate());
                    div.getTxtHokenshoTeishutsuKigenYMD().setValue(FlexibleDate.getNowDate());
                    div.getTxtHenkoTsuchiHakkoYMD().setValue(null);
                    break;
                default:
                    break;
            }
        } else if (shiharaiHohoHenko != null) {
            div.getDdlShuryoJokyo().setSelectedKey(shiharaiHohoHenko.get終了区分());
            div.getTxtTorokuJokyo().setValue(shiharaiHohoHenko.get登録区分());
            div.getTxtTekiyoKikanKaishi().setValue(shiharaiHohoHenko.get適用開始年月日());
            div.getTxtTekiyoKikanShuryo().setValue(shiharaiHohoHenko.get適用終了年月日());
            switch (div.getKey_Button().toString()) {
                case "１号予告者登録":
                    div.getTxtIraiJuriYMD().setValue(null);
                    div.getTxtYokokuTorokuYMD().setValue(shiharaiHohoHenko.get予告登録年月日());
                    div.getTxtBemmeishoTeishutsuKigenYMD().setValue(shiharaiHohoHenko.get弁明書提出期限());
                    div.getTxtYokokuTsuchiHakkoYMD().setValue(shiharaiHohoHenko.get予告通知書発行年月日());
                    break;
                case "１号弁明書受理":
                    div.getTxtBemmeiUketsukeYMD().setValue(shiharaiHohoHenko.get弁明書受付年月日());
                    div.getTxtBemmeiNaiyoKetteiYMD().setValue(shiharaiHohoHenko.get弁明審査決定年月日());
                    div.getDdlBemmeiRiyu().setSelectedKey(shiharaiHohoHenko.get弁明理由コード());
                    div.getDdlBemmeiShinsaKekka().setSelectedKey(shiharaiHohoHenko.get弁明審査結果区分());
                    break;
                case "償還払い化登録":
                    div.getTxtHenkoKetteiYMD().setValue(shiharaiHohoHenko.get償還払化決定年月日());
                    div.getTxtHokenshoTeishutsuKigenYMD().setValue(shiharaiHohoHenko.get被保険者証提出期限());
                    div.getTxtHenkoTsuchiHakkoYMD().setValue(shiharaiHohoHenko.get償還払化通知書発行年月日());
                    break;
                case "償還払い化終了申請":
                    div.getTxtShinseiUketsukeYMD().setValue(shiharaiHohoHenko.get終了申請書受付年月日());
                    div.getTxtShinseiYMD().setValue(shiharaiHohoHenko.get終了申請年月日());
                    div.getTxtShinseiNaiyoKetteiYMD().setValue(shiharaiHohoHenko.get終了申請審査決定年月日());
                    div.getDdlShinseiRiyu().setSelectedKey(shiharaiHohoHenko.get終了申請理由コード());
                    div.getDdlShinseiShinsaKekka().setSelectedKey(shiharaiHohoHenko.get終了申請審査結果区分());
                    break;
                default:
                    break;
            }
        }
    }

}
