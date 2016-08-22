/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome2go.IchijiSashitome2Go;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenkoBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoBenmeiRiyuCode;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoBenmeiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoJohoBunruiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoSashitomeKojoJotaiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoShinseiRiyuCode;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoShinseiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShoriKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoMukoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 【共有子Div】2号一時差止ダイアログのハンドラクラスです。
 *
 * @reamsid_L DBD-3620-045 panxiaobo
 */
public class IchijiSashitome2GoHandler {

    private final IchijiSashitome2GoDiv div;
    private final RString 新規登録 = new RString("新規登録");
    private final RString 新規区分_空 = new RString("空");
    private final RString _２号一時差止登録 = new RString("２号一時差止登録");
    private final RString _２号予告者登録 = new RString("２号予告者登録");
    private final RString _２号一時差止解除 = new RString("２号一時差止解除");
    private final RString _２号弁明書受理 = new RString("２号弁明書受理");

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】 2号一時差止ダイアログDiv
     *
     */
    public IchijiSashitome2GoHandler(IchijiSashitome2GoDiv div) {
        this.div = div;
    }

    /**
     * 二号一時差止ダイアロググキーのEnum
     */
    private enum 二号一時差止ダイアロググキー {

        /**
         * 画面更新用情報
         */
        支払方法変更管理業務概念,
        /**
         * 画面表示用
         */
        支払方法変更差止;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        RString 押下ボタン = ShoriKubun.toValue(div.getKey_Button()).get名称();
        ShiharaiHohoHenko 支払方法変更管理業務概念 = DataPassingConverter.deserialize(div.getKey_ShiharaiHohoHenkoKanri(), ShiharaiHohoHenko.class);
        List<ShiharaiHohoHenko> 支払方法データ = new ArrayList();
        List<ShiharaiHohoHenko> 支払方法変更レコード = new ArrayList();
        ViewStateHolder.put(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, 支払方法変更管理業務概念);
        if (支払方法変更管理業務概念 != null
                && 支払方法変更管理業務概念.get被保険者番号().value().equals(div.getKey_HihokenshaNo())
                && 支払方法変更管理業務概念.get管理区分().equals(ShiharaiHenkoKanriKubun._２号差止.getコード())
                && 支払方法変更管理業務概念.get登録区分().equals(get登録区分(押下ボタン))) {
            if (押下ボタン.equals(_２号一時差止登録) || 押下ボタン.equals(_２号一時差止解除)) {
                for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList()) {
                    if (shiharaiHohoHenkoSashitome.get証記載保険者番号().equals(支払方法変更管理業務概念.get証記載保険者番号())
                            && shiharaiHohoHenkoSashitome.get被保険者番号().value().equals(div.getKey_HihokenshaNo())
                            && shiharaiHohoHenkoSashitome.get管理区分().equals(ShiharaiHenkoKanriKubun._２号差止.getコード())
                            && shiharaiHohoHenkoSashitome.get履歴番号() == 支払方法変更管理業務概念.get履歴番号()
                            && shiharaiHohoHenkoSashitome.get情報分類区分().equals(ShiharaiHenkoJohoBunruiKubun.差止情報.getコード())) {
                        支払方法データ.add(支払方法変更管理業務概念);
                        ViewStateHolder.put(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更差止, shiharaiHohoHenkoSashitome);
                        break;
                    }
                }
                if (支払方法データ.isEmpty()) {
                    throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace("支払方法変更"));
                } else {
                    ViewStateHolder.put(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, 支払方法変更管理業務概念);
                }
            }
            if ((押下ボタン.equals(_２号予告者登録) && 支払方法変更管理業務概念.get予告登録年月日() == null
                    || (押下ボタン.equals(_２号一時差止登録) && 支払方法変更管理業務概念.get差止対象決定年月日() == null))) {
                div.setShinkiKubun(新規登録);
            } else if (押下ボタン.equals(_２号予告者登録) || 押下ボタン.equals(_２号一時差止登録)) {
                div.setShinkiKubun(新規区分_空);
            }
            支払方法変更レコード.add(支払方法変更管理業務概念);
        }
        if (支払方法変更管理業務概念 == null || 支払方法変更レコード.isEmpty()) {
            if (押下ボタン.equals(_２号弁明書受理) || 押下ボタン.equals(_２号一時差止登録) || 押下ボタン.equals(_２号一時差止解除)) {
                throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace("支払方法変更"));
            } else {
                div.setShinkiKubun(新規登録);
            }
            ViewStateHolder.put(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, 支払方法変更管理業務概念);
        }
        initializeDisplayData(押下ボタン, ViewStateHolder.get(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class));
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
        RString 押下ボタン = ShoriKubun.toValue(div.getKey_Button()).get名称();
        ValidationMessageControlPairs pairs = getValidationMessages();
        if (pairs.iterator().hasNext()) {
            return pairs;
        }
        ShiharaiHohoHenkoEntity 支払方法変更Entity = new ShiharaiHohoHenkoEntity();
        switch (押下ボタン.toString()) {
            case "２号予告者登録":
                if (div.getShinkiKubun().equals(新規登録)) {
                    支払方法変更Entity.set支払方法変更Entity(get２号予告者登録の登録Entity());
                    ViewStateHolder.put(二号一時差止ダイアロググキー.支払方法変更管理業務概念, new ShiharaiHohoHenko(支払方法変更Entity));
                } else {
                    update支払方法変更_２号予告者();
                }
                break;
            case "２号弁明書受理":
                update支払方法変更_２号弁明書受理();
                break;
            case "２号一時差止登録":
                if (div.getShinkiKubun().equals(新規登録)) {
                    支払方法変更Entity.set支払方法変更Entity(get２号一時差止の登録の登録Entity());
                    支払方法変更Entity.set支払方法変更差止Entity(get２号一時差止の登録Entity());
                    ViewStateHolder.put(二号一時差止ダイアロググキー.支払方法変更管理業務概念, new ShiharaiHohoHenko(支払方法変更Entity));
                } else {
                    update支払方法変更_２号一時差止();
                    update支払方法変更差止_２号一時差止();
                }
                break;
            case "２号一時差止解除":
                update支払方法変更_２号一時差止解除();
                update支払方法変更差止_２号一時差止解除();
                break;
            default:
                break;
        }
        div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(ViewStateHolder.get(二号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class)));
        return pairs;
    }

    private void initializeDisplayData(RString 押下ボタン, ShiharaiHohoHenko shiharaiHohoHenko) {
        div.setTitle(押下ボタン);
        List<KeyValueDataSource> shiryoJokyoSource = new ArrayList();
        List<ShiharaiHenkoShuryoKubun> shuyoKubunList = ShiharaiHenkoShuryoKubun.valuesAt２号弁明書受理();
        for (ShiharaiHenkoShuryoKubun shuyoKubun : shuyoKubunList) {
            shiryoJokyoSource.add(new KeyValueDataSource(shuyoKubun.getコード(), shuyoKubun.get名称()));
        }
        div.getDdlShuryoJokyo().setDataSource(shiryoJokyoSource);
        div.getDdlShuryoJokyo().setSelectedKey(ShiharaiHenkoShuryoKubun._空.getコード());
        setStatus(押下ボタン, shiryoJokyoSource);
        setValue(押下ボタン, shiharaiHohoHenko);
    }

    private RString get登録区分(RString 押下ボタン) {
        RString torokuKubun = new RString("");
        switch (押下ボタン.toString()) {
            case "２号予告者登録":
            case "２号弁明書受理":
                torokuKubun = ShiharaiHenkoTorokuKubun._２号予告登録者.getコード();
                break;
            case "２号一時差止登録":
            case "２号一時差止解除":
                torokuKubun = ShiharaiHenkoTorokuKubun._２号差止登録.getコード();
                break;
            default:
                break;
        }
        return torokuKubun;
    }

    private void setStatus(RString 押下ボタン, List<KeyValueDataSource> shiryoJokyoSource) {
        switch (押下ボタン.toString()) {
            case "２号予告者登録":
                div.getTxtTorokuJokyo().setReadOnly(true);
                div.getTxtTekiyoKaishi().setReadOnly(true);
                div.getTxtTekiyoShuryo().setReadOnly(true);
                div.getDdlShuryoJokyo().setReadOnly(true);
                div.getTxtNigoYokokushaTorokuIraiJuribi().setDisabled(false);
                div.getTxtNigoYokokushaTorokuYokokuTorokubi().setDisabled(false);
                div.getTxtBemmeishoTeishutsuKigenYMD().setDisabled(false);
                div.getTxtYokokuTsuchiHakkoYMD().setReadOnly(true);
                DisplayNone_２号弁明書受理項目(true);
                DisplayNone_２号一時差止登録(true);
                DisplayNone_２号一時差止解除(true);
                break;
            case "２号弁明書受理":
                div.getTxtTorokuJokyo().setReadOnly(true);
                div.getTxtTekiyoKaishi().setReadOnly(true);
                div.getTxtTekiyoShuryo().setReadOnly(true);
                div.getDdlShuryoJokyo().setDisabled(false);
                div.getTxtNigoBenmeishoJuriBenmeishoUketsukebi().setDisabled(false);
                div.getDdlNigoBenmeishoJuriBenmeiRiyu().setDisabled(false);
                div.getTxtBemmeiNaiyoKetteiYMD().setDisabled(false);
                div.getDdlNigoBenmeishoJuriBenmeiShinsakekka().setDisabled(false);
                div.getDdlNigoBenmeishoJuriBenmeiRiyu().setDataSource(shiryoJokyoSource);
                div.getDdlNigoBenmeishoJuriBenmeiRiyu().setSelectedKey(ShiharaiHenkoShuryoKubun._空.getコード());
                List<KeyValueDataSource> bemmeiShinsaKekkaSource = new ArrayList();
                for (ShiharaiHenkoBenmeiShinsaKekkaKubun bemmeiShinsaKekka : ShiharaiHenkoBenmeiShinsaKekkaKubun.values()) {
                    bemmeiShinsaKekkaSource.add(new KeyValueDataSource(bemmeiShinsaKekka.getコード(), bemmeiShinsaKekka.get名称()));
                }
                div.getDdlNigoBenmeishoJuriBenmeiShinsakekka().setDataSource(bemmeiShinsaKekkaSource);
                div.getDdlNigoBenmeishoJuriBenmeiShinsakekka().setSelectedKey(ShiharaiHenkoBenmeiShinsaKekkaKubun._空.getコード());
                DisplayNone_２号予告者登録項目(true);
                DisplayNone_２号一時差止登録(true);
                DisplayNone_２号一時差止解除(true);
                break;
            case "２号一時差止登録":
                div.getTxtTorokuJokyo().setReadOnly(true);
                div.getTxtTekiyoKaishi().setDisabled(false);
                div.getTxtTekiyoShuryo().setReadOnly(true);
                div.getDdlShuryoJokyo().setReadOnly(true);
                div.getTxtSashitomeKetteiYMD().setDisabled(false);
                div.getTxtHokenshaTeishutsuKigenYMD().setDisabled(false);
                div.getTxtSashitomeTsuchiHakkoYMD().setReadOnly(true);
                DisplayNone_２号予告者登録項目(true);
                DisplayNone_２号弁明書受理項目(true);
                DisplayNone_２号一時差止解除(true);
                break;
            case "２号一時差止解除":
                div.getTxtTorokuJokyo().setReadOnly(true);
                div.getTxtTekiyoKaishi().setReadOnly(true);
                div.getTxtTekiyoShuryo().setDisabled(false);
                div.getDdlShuryoJokyo().setDisabled(false);
                div.getTxtIraiUketsukeYMD().setDisabled(false);
                div.getDdlIraiRiyu().setDisabled(false);
                div.getTxtIraiYMD().setDisabled(false);
                div.getTxtIraiNaiyoKetteiYMD().setDisabled(false);
                div.getDdlIraiShinsaKekka().setDisabled(false);
                List<KeyValueDataSource> shinseiRiyuSource = new ArrayList();
                for (ShiharaiHenkoShuryoShinseiRiyuCode shinseRriyuCode : ShiharaiHenkoShuryoShinseiRiyuCode.values()) {
                    shinseiRiyuSource.add(new KeyValueDataSource(shinseRriyuCode.getコード(), shinseRriyuCode.get名称()));
                }
                div.getDdlIraiRiyu().setDataSource(shinseiRiyuSource);
                div.getDdlIraiRiyu().setSelectedKey(ShiharaiHenkoShuryoShinseiRiyuCode._空.getコード());
                List<KeyValueDataSource> shinsaKekkaSource = new ArrayList();
                for (ShiharaiHenkoBenmeiShinsaKekkaKubun shinsaKekka : ShiharaiHenkoBenmeiShinsaKekkaKubun.values()) {
                    shinsaKekkaSource.add(new KeyValueDataSource(shinsaKekka.getコード(), shinsaKekka.get名称()));
                }
                div.getDdlIraiShinsaKekka().setDataSource(shinsaKekkaSource);
                div.getDdlIraiShinsaKekka().setSelectedKey(ShiharaiHenkoBenmeiShinsaKekkaKubun._空.getコード());
                DisplayNone_２号予告者登録項目(true);
                DisplayNone_２号弁明書受理項目(true);
                DisplayNone_２号一時差止登録(true);
                break;
            default:
                break;
        }
    }

    private void setValue(RString 押下ボタン, ShiharaiHohoHenko shiharaiHohoHenko) {
        if (div.getShinkiKubun().equals(新規登録)) {
            switch (押下ボタン.toString()) {
                case "２号予告者登録":
                    div.getTxtTorokuJokyo().setValue(ShiharaiHenkoTorokuKubun._２号予告登録者.get名称());
                    div.getTxtTekiyoKaishi().setValue(null);
                    div.getTxtTekiyoShuryo().setValue(null);
                    div.getTxtNigoYokokushaTorokuIraiJuribi().setValue(FlexibleDate.getNowDate());
                    div.getTxtNigoYokokushaTorokuYokokuTorokubi().setValue(FlexibleDate.getNowDate());
                    div.getTxtBemmeishoTeishutsuKigenYMD().setValue(FlexibleDate.getNowDate());
                    div.getTxtYokokuTsuchiHakkoYMD().setValue(null);
                    break;
                case "２号一時差止登録":
                    div.getTxtTorokuJokyo().setValue(ShiharaiHenkoTorokuKubun._２号予告登録者.get名称());
                    div.getTxtTekiyoKaishi().setValue(FlexibleDate.getNowDate());
                    div.getTxtTekiyoShuryo().setValue(null);
                    div.getTxtSashitomeKetteiYMD().setValue(FlexibleDate.getNowDate());
                    div.getTxtHokenshaTeishutsuKigenYMD().setValue(FlexibleDate.getNowDate());
                    div.getTxtSashitomeTsuchiHakkoYMD().setValue(null);
                    break;
                default:
                    break;
            }
        } else if (shiharaiHohoHenko != null) {
            div.getTxtTorokuJokyo().setValue(ShiharaiHenkoTorokuKubun.toValue(shiharaiHohoHenko.get登録区分()).get名称());
            div.getTxtTekiyoKaishi().setValue(shiharaiHohoHenko.get適用開始年月日());
            div.getTxtTekiyoShuryo().setValue(shiharaiHohoHenko.get適用終了年月日());
            if (shiharaiHohoHenko.get終了区分() == null) {
                div.getDdlShuryoJokyo().setSelectedKey(ShiharaiHenkoShuryoKubun._空.getコード());
            } else {
                div.getDdlShuryoJokyo().setSelectedKey(shiharaiHohoHenko.get終了区分());
            }
            switch (押下ボタン.toString()) {
                case "２号予告者登録":
                    div.getTxtNigoYokokushaTorokuIraiJuribi().setValue(shiharaiHohoHenko.get差止依頼書受理年月日());
                    div.getTxtNigoYokokushaTorokuYokokuTorokubi().setValue(shiharaiHohoHenko.get予告登録年月日());
                    div.getTxtBemmeishoTeishutsuKigenYMD().setValue(shiharaiHohoHenko.get弁明書提出期限());
                    div.getTxtYokokuTsuchiHakkoYMD().setValue(shiharaiHohoHenko.get予告通知書発行年月日());
                    break;
                case "２号弁明書受理":
                    div.getTxtNigoBenmeishoJuriBenmeishoUketsukebi().setValue(shiharaiHohoHenko.get弁明書受付年月日());
                    if (shiharaiHohoHenko.get弁明理由コード() == null) {
                        div.getDdlNigoBenmeishoJuriBenmeiRiyu().setSelectedKey(ShiharaiHenkoShuryoKubun._空.getコード());
                    } else {
                        div.getDdlNigoBenmeishoJuriBenmeiRiyu().setSelectedKey(shiharaiHohoHenko.get弁明理由コード());
                    }
                    div.getTxtBemmeiNaiyoKetteiYMD().setValue(shiharaiHohoHenko.get弁明審査決定年月日());
                    if (shiharaiHohoHenko.get弁明審査結果区分() == null) {
                        div.getDdlNigoBenmeishoJuriBenmeiShinsakekka().setSelectedKey(ShiharaiHenkoBenmeiShinsaKekkaKubun._空.getコード());
                    } else {
                        div.getDdlNigoBenmeishoJuriBenmeiShinsakekka().setSelectedKey(shiharaiHohoHenko.get弁明審査結果区分());
                    }
                    break;
                case "２号一時差止登録":
                    div.getTxtSashitomeKetteiYMD().setValue(ViewStateHolder.get(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更差止,
                            ShiharaiHohoHenkoSashitome.class).get差止決定年月日());
                    div.getTxtHokenshaTeishutsuKigenYMD().setValue(shiharaiHohoHenko.get被保険者証提出期限());
                    div.getTxtSashitomeTsuchiHakkoYMD().setValue(ViewStateHolder.get(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更差止,
                            ShiharaiHohoHenkoSashitome.class).get差止通知書発行年月日());
                    break;
                case "２号一時差止解除":
                    div.getTxtIraiUketsukeYMD().setValue(shiharaiHohoHenko.get終了申請書受付年月日());
                    div.getDdlIraiRiyu().setSelectedKey(shiharaiHohoHenko.get終了申請理由コード());
                    div.getTxtIraiYMD().setValue(shiharaiHohoHenko.get終了申請年月日());
                    div.getTxtIraiNaiyoKetteiYMD().setValue(shiharaiHohoHenko.get終了申請審査決定年月日());
                    div.getDdlIraiShinsaKekka().setSelectedKey(shiharaiHohoHenko.get終了申請審査結果区分());
                    break;
                default:
                    break;
            }
        }

    }

    private void DisplayNone_２号予告者登録項目(boolean displayNone) {
        div.getTxtNigoYokokushaTorokuIraiJuribi().setDisplayNone(displayNone);
        div.getTxtNigoYokokushaTorokuYokokuTorokubi().setDisplayNone(displayNone);
        div.getTxtBemmeishoTeishutsuKigenYMD().setDisplayNone(displayNone);
        div.getTxtYokokuTsuchiHakkoYMD().setDisplayNone(displayNone);
    }

    private void DisplayNone_２号弁明書受理項目(boolean displayNone) {
        div.getTxtNigoBenmeishoJuriBenmeishoUketsukebi().setDisplayNone(displayNone);
        div.getDdlNigoBenmeishoJuriBenmeiRiyu().setDisplayNone(displayNone);
        div.getTxtBemmeiNaiyoKetteiYMD().setDisplayNone(displayNone);
        div.getDdlNigoBenmeishoJuriBenmeiShinsakekka().setDisplayNone(displayNone);
    }

    private void DisplayNone_２号一時差止登録(boolean displayNone) {
        div.getTxtSashitomeKetteiYMD().setDisplayNone(displayNone);
        div.getTxtHokenshaTeishutsuKigenYMD().setDisplayNone(displayNone);
        div.getTxtSashitomeTsuchiHakkoYMD().setDisplayNone(displayNone);
    }

    private void DisplayNone_２号一時差止解除(boolean displayNone) {
        div.getTxtIraiUketsukeYMD().setDisplayNone(displayNone);
        div.getDdlIraiRiyu().setDisplayNone(displayNone);
        div.getTxtIraiYMD().setDisplayNone(displayNone);
        div.getTxtIraiNaiyoKetteiYMD().setDisplayNone(displayNone);
        div.getDdlIraiShinsaKekka().setDisplayNone(displayNone);
    }

    private ValidationMessageControlPairs getValidationMessages() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor依頼受理日入力チェック(pairs, div);
        getValidationHandler().validateFor予告登録日入力チェック(pairs, div);
        getValidationHandler().validateFor弁明書提出期限入力チェック(pairs, div);
        getValidationHandler().validateFor弁明審査結果選択チェック(pairs, div);
        getValidationHandler().validateFor弁明受付日入力チェック(pairs, div);
        getValidationHandler().validateFor弁明理由選択チェック(pairs, div);
        getValidationHandler().validateFor弁明内容決定日未入力チェック(pairs, div);
        getValidationHandler().validateFor適用期間開始未入力チェック(pairs, div);
        getValidationHandler().validateFor差止決定日未入力チェック(pairs, div);
        getValidationHandler().validateFor保険証提出期限未入力チェック(pairs, div);
        getValidationHandler().validateFor適用期間チェック(pairs, div);
        getValidationHandler().validateFor依頼審査結果未選択チェック(pairs, div);
        getValidationHandler().validateFor適用期間終了未入力チェック(pairs, div);
        getValidationHandler().validateFor終了状況未選択チェック(pairs, div);
        getValidationHandler().validateFor依頼受付日未入力チェック(pairs, div);
        getValidationHandler().validateFor依頼日未入力チェック(pairs, div);
        getValidationHandler().validateFor依頼理由未選択チェック(pairs, div);
        getValidationHandler().validateFor依頼内容決定日未入力チェック(pairs, div);
        return pairs;
    }

    private IchijiSashitome2GoValidationHandler getValidationHandler() {
        return new IchijiSashitome2GoValidationHandler();
    }

    private DbT4021ShiharaiHohoHenkoEntity get２号予告者登録の登録Entity() {
        DbT4021ShiharaiHohoHenkoEntity entity = new DbT4021ShiharaiHohoHenkoEntity();
        entity.setShoKisaiHokenshaNo(証記載保険者番号());
        entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
        entity.setKanriKubun(ShiharaiHenkoKanriKubun._２号差止.getコード());
        entity.setRirekiNo(get最大履歴番号() + 1);
        entity.setTorokuKubun(ShiharaiHenkoTorokuKubun._２号予告登録者.getコード());
        entity.setShuryoKubun(ShiharaiHenkoShuryoKubun._空.getコード());
        entity.setYokoku_TorokuYMD(div.getTxtNigoYokokushaTorokuYokokuTorokubi().getValue());
        entity.setSashitome_IraiJuriYMD(div.getTxtNigoYokokushaTorokuIraiJuribi().getValue());
        entity.setYokoku_TsuchiSaiHakkoFlag(false);
        entity.setBemmei_TeishutsuYMD(div.getTxtBemmeishoTeishutsuKigenYMD().getValue());
        entity.setBemmei_RiyuCode(ShiharaiHenkoBenmeiRiyuCode._空.getコード());
        entity.setBemmei_ShinsaKekkaKubun(ShiharaiHenkoBenmeiShinsaKekkaKubun._空.getコード());
        entity.setShokan_TsuchiSaiHakkoFlag(false);
        entity.setSashitome_Flag(false);
        entity.setGemmen_TsuchiSaiHakkoFlag(false);
        entity.setShuryoShinsei_RiyuCode(ShiharaiHenkoShuryoShinseiRiyuCode._空.getコード());
        entity.setShuryoShinsei_ShinsaKekkaKubun(ShiharaiHenkoShuryoShinseiShinsaKekkaKubun._空.getコード());
        entity.setMukoKubun(ShiharaiHenkoMukoKubun.有効.getコード());
        entity.setLogicalDeletedFlag(false);
        return entity;
    }

    private DbT4021ShiharaiHohoHenkoEntity get２号一時差止の登録の登録Entity() {
        DbT4021ShiharaiHohoHenkoEntity entity = new DbT4021ShiharaiHohoHenkoEntity();
        entity.setShoKisaiHokenshaNo(証記載保険者番号());
        entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
        entity.setKanriKubun(ShiharaiHenkoKanriKubun._２号差止.getコード());
        entity.setRirekiNo(get最大履歴番号() + 1);
        entity.setTorokuKubun(ShiharaiHenkoTorokuKubun._２号差止登録.getコード());
        entity.setTekiyoKaishiYMD(div.getTxtTekiyoKaishi().getValue());
        entity.setShuryoKubun(ShiharaiHenkoShuryoKubun._空.getコード());
        entity.setYokoku_TsuchiSaiHakkoFlag(false);
        entity.setBemmei_RiyuCode(ShiharaiHenkoBenmeiRiyuCode._空.getコード());
        entity.setBemmei_ShinsaKekkaKubun(ShiharaiHenkoBenmeiShinsaKekkaKubun._空.getコード());
        entity.setShokan_TsuchiSaiHakkoFlag(false);
        entity.setHihokenshaShoTeishutsuYMD(div.getTxtHokenshaTeishutsuKigenYMD().getValue());
        entity.setSashitome_Flag(true);
        entity.setSashitome_KetteiYMD(div.getTxtSashitomeKetteiYMD().getValue());
        entity.setGemmen_TsuchiSaiHakkoFlag(false);
        entity.setShuryoShinsei_RiyuCode(ShiharaiHenkoShuryoShinseiRiyuCode._空.getコード());
        entity.setShuryoShinsei_ShinsaKekkaKubun(ShiharaiHenkoShuryoShinseiShinsaKekkaKubun._空.getコード());
        entity.setMukoKubun(ShiharaiHenkoMukoKubun.有効.getコード());
        entity.setLogicalDeletedFlag(false);
        return entity;
    }

    private List<DbT4024ShiharaiHohoHenkoSashitomeEntity> get２号一時差止の登録Entity() {
        List<DbT4024ShiharaiHohoHenkoSashitomeEntity> list = new ArrayList();
        DbT4024ShiharaiHohoHenkoSashitomeEntity entity = new DbT4024ShiharaiHohoHenkoSashitomeEntity();
        int 連番 = 0;
        entity.setShoKisaiHokenshaNo(証記載保険者番号());
        entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
        entity.setKanriKubun(ShiharaiHenkoKanriKubun._２号差止.getコード());
        entity.setRirekiNo(get最大履歴番号());
        entity.setJohoBunruiKubun(ShiharaiHenkoJohoBunruiKubun.差止情報.getコード());
        entity.setRenNo(連番);
        entity.setSashitomeKojoJotaiKubun(ShiharaiHenkoSashitomeKojoJotaiKubun.登録.getコード());
        entity.setSashitome_KetteiYMD(div.getTxtSashitomeKetteiYMD().getValue());
        entity.setSashitome_TsuchiSaiHakkoFlag(false);
        entity.setLogicalDeletedFlag(false);
        list.add(entity);
        return list;
    }

    private void update支払方法変更_２号予告者() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        builder.set予告登録年月日(div.getTxtNigoYokokushaTorokuYokokuTorokubi().getValue())
                .set差止依頼書受理年月日(div.getTxtNigoYokokushaTorokuIraiJuribi().getValue())
                .set弁明書提出期限(div.getTxtBemmeishoTeishutsuKigenYMD().getValue())
                .setState(EntityDataState.Modified);
        ViewStateHolder.put(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());

    }

    private void update支払方法変更_２号弁明書受理() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        builder.set終了区分(div.getDdlShuryoJokyo().getSelectedKey())
                .set弁明書受付年月日(div.getTxtNigoBenmeishoJuriBenmeishoUketsukebi().getValue())
                .set弁明理由コード(div.getDdlNigoBenmeishoJuriBenmeiRiyu().getSelectedKey())
                .set弁明審査決定年月日(div.getTxtBemmeiNaiyoKetteiYMD().getValue())
                .set弁明審査結果区分(div.getDdlNigoBenmeishoJuriBenmeiShinsakekka().getSelectedKey())
                .setState(EntityDataState.Modified);
        ViewStateHolder.put(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void update支払方法変更_２号一時差止() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        builder.set適用開始年月日(div.getTxtTekiyoKaishi().getValue())
                .set被保険者証提出期限(div.getTxtHokenshaTeishutsuKigenYMD().getValue())
                .set差止対象フラグ(true)
                .set差止対象決定年月日(div.getTxtSashitomeKetteiYMD().getValue())
                .setState(EntityDataState.Modified);
        ViewStateHolder.put(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void update支払方法変更_２号一時差止解除() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        builder.set適用終了年月日(div.getTxtTekiyoShuryo().getValue())
                .set終了区分(div.getDdlShuryoJokyo().getSelectedKey())
                .set差止対象フラグ(false)
                .set差止対象解除年月日(FlexibleDate.getNowDate())
                .set終了申請書受付年月日(div.getTxtIraiUketsukeYMD().getValue())
                .set終了申請年月日(div.getTxtIraiYMD().getValue())
                .set終了申請理由コード(div.getDdlIraiRiyu().getSelectedKey())
                .set終了申請審査決定年月日(div.getTxtIraiNaiyoKetteiYMD().getValue())
                .set終了申請審査結果区分(div.getDdlIraiShinsaKekka().getSelectedKey())
                .setState(EntityDataState.Modified);
        ViewStateHolder.put(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());
    }

    private void update支払方法変更差止_２号一時差止解除() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList()) {
            builder.setShiharaiHohoHenkoSashitome(shiharaiHohoHenkoSashitome.createBuilderForEdit()
                    .set差止控除状態区分(ShiharaiHenkoSashitomeKojoJotaiKubun.解除.getコード())
                    .set差止通知書発行年月日(FlexibleDate.EMPTY)
                    .set差止通知書再発行フラグ(false)
                    .set差止控除番号(RString.EMPTY)
                    .set差止解除年月日(FlexibleDate.getNowDate())
                    .setState(EntityDataState.Modified).build())
                    .setState(EntityDataState.Modified);
        }
        ViewStateHolder.put(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, builder.build());

    }

    private void update支払方法変更差止_２号一時差止() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        for (ShiharaiHohoHenkoSashitome shiharaiHohoHenkoSashitome : 支払方法変更管理業務概念.getShiharaiHohoHenkoSashitomeList()) {
            builder.setShiharaiHohoHenkoSashitome(shiharaiHohoHenkoSashitome.createBuilderForEdit()
                    .set差止決定年月日(div.getTxtSashitomeKetteiYMD().getValue())
                    .set差止納付期限(div.getTxtHokenshaTeishutsuKigenYMD().getValue())
                    .setState(EntityDataState.Modified).build())
                    .setState(EntityDataState.Modified);
        }
        ViewStateHolder.put(IchijiSashitome2GoHandler.二号一時差止ダイアロググキー.支払方法変更管理業務概念, 支払方法変更管理業務概念);

    }

    private int get最大履歴番号() {
        if (div.getKey_MaxRirekiNo().isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(div.getKey_MaxRirekiNo().toString());
        }
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
