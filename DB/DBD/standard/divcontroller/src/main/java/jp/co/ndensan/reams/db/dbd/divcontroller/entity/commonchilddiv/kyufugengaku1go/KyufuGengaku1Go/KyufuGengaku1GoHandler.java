/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.kyufugengaku1go.KyufuGengaku1Go;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenkoBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.ShiharaiHohoHenkoGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.meisai.ShiharaiHohoHenkoGengakuMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTaino;
import jp.co.ndensan.reams.db.dbd.business.core.taino.KyufugakuGengakuInfo;
import jp.co.ndensan.reams.db.dbd.business.core.taino.KyufugakuGengakuMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResultKohen;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoKiSummary;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoBenmeiRiyuCode;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoBenmeiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoShinseiRiyuCode;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoShinseiShinsaKekkaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TainoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TaishoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoGengakuEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 【共有子Div】1号給付額減額ダイアログのハンドラクラスです。
 *
 * @reamsid_L DBD-3620-043 panxiaobo
 */
public class KyufuGengaku1GoHandler {

    private final KyufuGengaku1GoDiv div;
    private final RString 新規登録 = new RString("新規登録");
    private final RString _減額免除申請 = new RString("減額免除申請");
    private final RString _給付額減額 = new RString("給付額減額");
    private final ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo("209007");

    /**
     * コンストラクタです。
     *
     * @param div【共有子Div】 1号給付額減額ダイアログDiv
     */
    public KyufuGengaku1GoHandler(KyufuGengaku1GoDiv div) {
        this.div = div;
    }

    /**
     * 一号給付額減額ダイアログキーのEnum
     */
    private enum 一号給付額減額ダイアログキー {

        /**
         * 画面更新用情報
         */
        支払方法変更管理業務概念,
        /**
         * 画面取得情報List
         */
        支払方法変更管理業務概念List,
        /**
         * 画面表示用
         */
        支払方法変更減額;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        RString 押下ボタン = div.getKey_Button();
        ShiharaiHohoHenko 支払方法変更管理業務概念 = DataPassingConverter.deserialize(div.getKey_ShiharaiHohoHenkoKanri(), ShiharaiHohoHenko.class);
        List<ShiharaiHohoHenko> 支払方法データ = new ArrayList();
        List<ShiharaiHohoHenko> 支払方法変更レコード = new ArrayList();
        ViewStateHolder.put(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, new ShiharaiHohoHenko(new ShiharaiHohoHenkoEntity()));
        if (支払方法変更管理業務概念 != null
                && 支払方法変更管理業務概念.get被保険者番号().value().equals(div.getKey_HihokenshaNo())
                && 支払方法変更管理業務概念.get管理区分().equals(ShiharaiHenkoKanriKubun._１号給付額減額.getコード())
                && 支払方法変更管理業務概念.get登録区分().equals(ShiharaiHenkoTorokuKubun._１号給付額減額登録.getコード())) {
            for (ShiharaiHohoHenkoGengaku shiharaiHohoHenkoGengaku : 支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList()) {
                if (shiharaiHohoHenkoGengaku.get証記載保険者番号().equals(支払方法変更管理業務概念.get証記載保険者番号())
                        && shiharaiHohoHenkoGengaku.get被保険者番号().value().equals(div.getKey_HihokenshaNo())
                        && shiharaiHohoHenkoGengaku.get管理区分().equals(ShiharaiHenkoKanriKubun._１号給付額減額.getコード())
                        && shiharaiHohoHenkoGengaku.get履歴番号() == 支払方法変更管理業務概念.get履歴番号()) {
                    支払方法データ.add(支払方法変更管理業務概念);
                    ViewStateHolder.put(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更減額, shiharaiHohoHenkoGengaku);
                    break;
                }
            }
            if (支払方法データ.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.対象ファイルが存在しない.getMessage().replace("支払方法変更"));
            }
            支払方法変更レコード.add(支払方法変更管理業務概念);

        }
        if (支払方法変更管理業務概念 == null || 支払方法変更レコード.isEmpty()) {
            if (押下ボタン.equals(_減額免除申請)) {
                throw new ApplicationException(UrErrorMessages.対象ファイルが存在しない.getMessage().replace("支払方法変更"));
            } else {
                div.setShinkiKubun(新規登録);
            }
        }
        initializeDisplayData(ViewStateHolder.get(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class));
    }

    /**
     * 「取消」ボタンの処理です。
     *
     * @return ［画面］登録状況が空(Empty)か否か
     */
    public boolean onClick_BtnTorikeshi() {
        return !div.getTxtTorokuJokyo().getValue().isNullOrEmpty();
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
        TainoHanteiResultKohen 滞納判定結果 = DataPassingConverter.deserialize(div.getTainoHanteiKekka(), TainoHanteiResultKohen.class);
        ShiharaiHohoHenkoEntity 支払方法変更Entity = new ShiharaiHohoHenkoEntity();
        switch (div.getKey_Button().toString()) {
            case "給付額減額":
                if (div.getShinkiKubun().equals(新規登録)) {
                    支払方法変更Entity.set支払方法変更Entity(get給付額減額の登録Entity());
                    支払方法変更Entity.set支払方法変更滞納Entity(get支払方法変更滞納Entity(滞納判定結果));
                    支払方法変更Entity.set支払方法変更減額Entity(get支払方法変更減額Entity(滞納判定結果));
                    支払方法変更Entity.get支払方法変更減額Entity().get(0).set支払方法変更減額明細Entity(get支払方法変更減額明細Entity(滞納判定結果));
                    ViewStateHolder.put(一号給付額減額ダイアログキー.支払方法変更管理業務概念, new ShiharaiHohoHenko(支払方法変更Entity));
                } else {
                    update支払方法変更_UPD001();
                    update支払方法変更滞納_UPD003(滞納判定結果);
                    update支払方法変更減額_UPD004();
                    update支払方法変更減額明細_UPD006(滞納判定結果);
                }
                break;
            case "減額免除申請":
                update支払方法変更_UPD002();
                update支払方法変更減額_UPD005();
                break;
            default:
                break;
        }
        div.setKey_ShiharaiHohoHenkoKanri(DataPassingConverter.serialize(ViewStateHolder.get(一号給付額減額ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class)));
        return pairs;
    }

    /**
     * 滞納状況ダイアログを開く前に実行されるイベントを設定します。
     */
    public void onBeforeOpenDialog_BtnTainoJokyo() {
        div.setHihokenshaNo(div.getKey_HihokenshaNo());
        div.setKanriKubun(ShiharaiHenkoKanriKubun._１号給付額減額.getコード());
        div.setTainoHanteiKubun(TainoHanteiKubun.給付額減額登録.getコード());
        div.setRirekiNo(RString.EMPTY);
    }

    /**
     * 滞納状況ダイアログが確定クローズイベントで閉じられたときにダイアログが完全に閉じた後に実行されるイベントを設定します。
     */
    public void onOkClose_BtnTainoJokyo() {
        TainoHanteiResultKohen 滞納判定結果 = ViewStateHolder.get(ViewStateKeys.滞納判定結果, TainoHanteiResultKohen.class);
        if (滞納判定結果 != null && 滞納判定結果.get滞納情報() != null) {
            div.setTainoHanteiKekka(DataPassingConverter.serialize(滞納判定結果));
            if (div.getKey_Button().equals(_給付額減額)) {
                div.getBtnTainoJokyo().setIconNameEnum(IconName.Check);
            }
        }
    }

    private void initializeDisplayData(ShiharaiHohoHenko shiharaiHohoHenko) {
        div.setTitle(div.getKey_Button());
        setStatus();
        setValue(shiharaiHohoHenko);
    }

    private void setStatus() {
        if (div.getKey_Button().equals(_給付額減額)) {
            給付額減額_Status();
            DisplayNone_減額免除申請(true);
        } else if (div.getKey_Button().equals(_減額免除申請)) {
            減額免除申請_Status();
            DisplayNone_給付額減額(true);
        }
    }

    private void 給付額減額_Status() {
        div.getTxtTorokuJokyo().setReadOnly(true);
        div.getTxtKyufugakuGengakuKikan().setReadOnly(true);
        div.getTxtGengakuTekiyoKikanKaishiYMD().setReadOnly(true);
        div.getTxtGengakuTekiyoKikanShuryoYMD().setReadOnly(true);
        div.getTxtChoshukenShometsuKikan().setReadOnly(true);
        div.getTxtNofuzumiKikan().setReadOnly(true);
        div.getBtnTainoJokyo().setDisabled(false);
        div.getTxtGengakuKetteiYMD().setDisabled(false);
        div.getTxtZenkaiKikanKaishiYMD().setReadOnly(true);
        div.getTxtZenkaiKikanShuryoYMD().setReadOnly(true);
        div.getTxtKyufuGengakuTsuchiHakkoYMD().setReadOnly(true);
        div.getTxtKonkaiKikanKaishiYMD().setDisabled(false);
        div.getTxtKonkaiKikanShuryoYMD().setDisabled(false);
    }

    private void 減額免除申請_Status() {
        div.getTxtTorokuJokyo().setReadOnly(true);
        div.getTxtKyufugakuGengakuKikan().setReadOnly(true);
        div.getTxtGengakuTekiyoKikanKaishiYMD().setReadOnly(true);
        div.getTxtGengakuTekiyoKikanShuryoYMD().setDisabled(false);
        div.getTxtChoshukenShometsuKikan().setReadOnly(true);
        div.getTxtNofuzumiKikan().setReadOnly(true);
        div.getBtnTainoJokyo().setDisabled(false);
        div.getDdlMenjoShinseiJokyo().setDisabled(false);
        div.getTxtMenjoShinseiUketsukeYMD().setDisabled(false);
        div.getTxtMenjoShinseiYMD().setDisabled(false);
        div.getDdlIMenjoShinseiRiyu().setDisabled(false);
        div.getTxtMenjoNaiyoKetteiYMD().setDisabled(false);
        div.getDdlMenjoShinseiShinsaKekka().setDisabled(false);
    }

    private void DisplayNone_減額免除申請(boolean displayNone) {
        div.getDdlMenjoShinseiJokyo().setDisplayNone(displayNone);
        div.getTxtMenjoShinseiUketsukeYMD().setDisplayNone(displayNone);
        div.getTxtMenjoShinseiYMD().setDisplayNone(displayNone);
        div.getDdlIMenjoShinseiRiyu().setDisplayNone(displayNone);
        div.getTxtMenjoNaiyoKetteiYMD().setDisplayNone(displayNone);
        div.getDdlMenjoShinseiShinsaKekka().setDisplayNone(displayNone);
    }

    private void DisplayNone_給付額減額(boolean displayNone) {
        div.getTxtGengakuKetteiYMD().setDisplayNone(displayNone);
        div.getTxtZenkaiKikanKaishiYMD().setDisplayNone(displayNone);
        div.getTxtZenkaiKikanShuryoYMD().setDisplayNone(displayNone);
        div.getTxtKyufuGengakuTsuchiHakkoYMD().setDisplayNone(displayNone);
        div.getTxtKonkaiKikanKaishiYMD().setDisplayNone(displayNone);
        div.getTxtKonkaiKikanShuryoYMD().setDisplayNone(displayNone);
    }

    private void setValue(ShiharaiHohoHenko shiharaiHohoHenko) {
        ShiharaiHohoHenkoGengaku shiharaiHohoHenkoGengaku = ViewStateHolder.get(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更減額, ShiharaiHohoHenkoGengaku.class);
        if (div.getShinkiKubun().equals(新規登録)) {
            div.getTxtTorokuJokyo().setValue(ShiharaiHenkoTorokuKubun._１号予告登録者.get名称());
            div.getTxtGengakuTekiyoKikanKaishiYMD().setValue(null);
            div.getTxtGengakuTekiyoKikanShuryoYMD().setValue(null);
        } else {
            div.getTxtTorokuJokyo().setValue(shiharaiHohoHenko.get登録区分());
            div.getTxtKyufugakuGengakuKikan().setValue(get給付額減額期間(div.getTxtChoshukenShometsuKikan().getValue(), div.getTxtNofuzumiKikan().getValue()));
            div.getTxtGengakuTekiyoKikanKaishiYMD().setValue(shiharaiHohoHenkoGengaku.get確定減額期間開始年月日());
            div.getTxtGengakuTekiyoKikanShuryoYMD().setValue(shiharaiHohoHenkoGengaku.get確定減額期間終了年月日());
            div.getTxtChoshukenShometsuKikan().setValue(shiharaiHohoHenkoGengaku.get徴収権消滅期間());
            div.getTxtNofuzumiKikan().setValue(shiharaiHohoHenkoGengaku.get納付済期間());
        }
        if (div.getKey_Button().equals(_給付額減額)) {
            給付額減額_setValue(shiharaiHohoHenko, shiharaiHohoHenkoGengaku);
        } else if (div.getKey_Button().equals(_減額免除申請)) {
            減額免除申請__setValue(shiharaiHohoHenko);
        }
    }

    private void 給付額減額_setValue(ShiharaiHohoHenko shiharaiHohoHenko, ShiharaiHohoHenkoGengaku shiharaiHohoHenkoGengaku) {
        div.getBtnTainoJokyo().setIconNameEnum(IconName.Incomplete);
        if (div.getShinkiKubun().equals(新規登録)) {
            div.getTxtGengakuKetteiYMD().setValue(FlexibleDate.getNowDate());
            div.getTxtZenkaiKikanKaishiYMD().setValue(null);
            div.getTxtZenkaiKikanShuryoYMD().setValue(null);
            div.getTxtKyufuGengakuTsuchiHakkoYMD().setValue(null);
            div.getTxtKonkaiKikanKaishiYMD().setValue(null);
            div.getTxtKonkaiKikanShuryoYMD().setValue(FlexibleDate.getNowDate());
        } else {
            div.getTxtGengakuKetteiYMD().setValue(shiharaiHohoHenko.get減額決定年月日());
            div.getTxtZenkaiKikanKaishiYMD().setValue(shiharaiHohoHenkoGengaku.get確定減額期間開始年月日());
            div.getTxtZenkaiKikanShuryoYMD().setValue(shiharaiHohoHenkoGengaku.get確定減額期間終了年月日());
            div.getTxtKyufuGengakuTsuchiHakkoYMD().setValue(shiharaiHohoHenko.get減額通知書発行年月日());
            div.getTxtKonkaiKikanKaishiYMD().setValue(shiharaiHohoHenkoGengaku.get確定減額期間開始年月日());
            div.getTxtKonkaiKikanShuryoYMD().setValue(shiharaiHohoHenkoGengaku.get確定減額期間終了年月日());
        }
    }

    private void 減額免除申請__setValue(ShiharaiHohoHenko shiharaiHohoHenko) {
        div.getBtnTainoJokyo().setIconNameEnum(IconName.Info);
        List<KeyValueDataSource> jokyoCodeSource = new ArrayList();
        for (JokyoCode jokyoCode : JokyoCode.values()) {
            jokyoCodeSource.add(new KeyValueDataSource(jokyoCode.getコード(), jokyoCode.get名称()));
        }
        div.getDdlMenjoShinseiJokyo().setDataSource(jokyoCodeSource);
        div.getDdlMenjoShinseiJokyo().setSelectedKey(jokyoCodeSource.get(0).getKey());
        div.getTxtMenjoShinseiUketsukeYMD().setValue(shiharaiHohoHenko.get終了申請書受付年月日());
        div.getTxtMenjoShinseiYMD().setValue(shiharaiHohoHenko.get終了申請年月日());
        List<KeyValueDataSource> shinseiRiyuSource = new ArrayList();
        for (ShiharaiHenkoShuryoShinseiRiyuCode shinseRriyuCode : ShiharaiHenkoShuryoShinseiRiyuCode.values()) {
            shinseiRiyuSource.add(new KeyValueDataSource(shinseRriyuCode.getコード(), shinseRriyuCode.get名称()));
        }
        div.getDdlIMenjoShinseiRiyu().setDataSource(shinseiRiyuSource);
        div.getDdlIMenjoShinseiRiyu().setSelectedKey(shinseiRiyuSource.get(0).getKey());
        div.getTxtMenjoNaiyoKetteiYMD().setValue(shiharaiHohoHenko.get終了申請審査決定年月日());
        List<KeyValueDataSource> shinsaKekkaSource = new ArrayList();
        for (ShiharaiHenkoBenmeiShinsaKekkaKubun shinsaKekka : ShiharaiHenkoBenmeiShinsaKekkaKubun.values()) {
            shinsaKekkaSource.add(new KeyValueDataSource(shinsaKekka.getコード(), shinsaKekka.get名称()));
        }
        div.getDdlMenjoShinseiShinsaKekka().setDataSource(shinsaKekkaSource);
        div.getDdlMenjoShinseiShinsaKekka().setSelectedKey(shinsaKekkaSource.get(0).getKey());
    }

    private DbT4021ShiharaiHohoHenkoEntity get給付額減額の登録Entity() {
        DbT4021ShiharaiHohoHenkoEntity entity = new DbT4021ShiharaiHohoHenkoEntity();
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
        entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号給付額減額.getコード());
        entity.setRirekiNo(get最大履歴番号() + 1);
        entity.setTorokuKubun(ShiharaiHenkoTorokuKubun._１号給付額減額登録.getコード());
        entity.setShuryoKubun(ShiharaiHenkoShuryoKubun._空.getコード());
        entity.setYokoku_TsuchiSaiHakkoFlag(false);
        entity.setBemmei_RiyuCode(ShiharaiHenkoBenmeiRiyuCode._空.getコード());
        entity.setBemmei_ShinsaKekkaKubun(ShiharaiHenkoBenmeiShinsaKekkaKubun._空.getコード());
        entity.setShokan_TsuchiSaiHakkoFlag(false);
        entity.setSashitome_Flag(false);
        entity.setGemmen_KetteiYMD(div.getTxtGengakuKetteiYMD().getValue());
        entity.setGemmen_TsuchiSaiHakkoFlag(false);
        entity.setShuryoShinsei_RiyuCode(ShiharaiHenkoShuryoShinseiRiyuCode._空.getコード());
        entity.setShuryoShinsei_ShinsaKekkaKubun(ShiharaiHenkoShuryoShinseiShinsaKekkaKubun._空.getコード());
        entity.setMukoKubun(ShiharaiHenkoMukoKubun.有効.getコード());
        entity.setLogicalDeletedFlag(false);
        return entity;
    }

    private List<DbT4022ShiharaiHohoHenkoTainoEntity> get支払方法変更滞納Entity(TainoHanteiResultKohen 滞納判定結果) {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        List<DbT4022ShiharaiHohoHenkoTainoEntity> 支払方法変更滞納Entity = new ArrayList();
        List<ShiharaiHohoHenkoTaino> 支払方法変更滞納情報 = new ArrayList();
        List<TainoKiSummary> tainoKiSummary = 滞納判定結果.get滞納情報();
        int 連番 = 支払方法変更滞納連番(証記載保険者番号, new HihokenshaNo(div.getKey_HihokenshaNo()),
                ShiharaiHenkoKanriKubun._１号給付額減額.getコード(), 支払方法変更管理業務概念.get履歴番号(),
                TainoHanteiKubun.給付額減額登録.getコード(), 支払方法変更管理業務概念);
        for (TainoKiSummary summary : tainoKiSummary) {
            TaishoHanteiKubun 対象管理区分 = get対象管理区分(連番++, summary.get時効区分().getコード(), 支払方法変更滞納情報);
            DbT4022ShiharaiHohoHenkoTainoEntity entity = new DbT4022ShiharaiHohoHenkoTainoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
            entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号給付額減額.getコード());
            entity.setRirekiNo(get最大履歴番号() + 1);
            entity.setTainoHanteiKubun(TainoHanteiKubun.給付額減額登録.getコード());
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

    private List<ShiharaiHohoHenkoGengakuEntity> get支払方法変更減額Entity(TainoHanteiResultKohen 滞納判定結果) {
        List<ShiharaiHohoHenkoGengakuEntity> shiharaiHohoHenkoGengakuList = new ArrayList();
        ShiharaiHohoHenkoGengakuEntity shiharaiHohoHenkoGengakuEntity = new ShiharaiHohoHenkoGengakuEntity();
        Map<FlexibleYear, KyufugakuGengakuMeisai> 給付額減額明細マップ = 滞納判定結果.get給付額減額().get給付額減額明細マップ();
        DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity 支払方法変更減額明細Entity = new DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity();
        List<DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity> 支払方法変更減額明細EntityList = new ArrayList();
        KyufugakuGengakuInfo kyufugakuGengakuInfo = 滞納判定結果.get給付額減額();
        DbT4025ShiharaiHohoHenkoGengakuEntity 支払方法変更減額Entity = new DbT4025ShiharaiHohoHenkoGengakuEntity();
        支払方法変更減額Entity.setShoKisaiHokenshaNo(証記載保険者番号);
        支払方法変更減額Entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
        支払方法変更減額Entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号給付額減額.getコード());
        支払方法変更減額Entity.setRirekiNo(get最大履歴番号() + 1);
        支払方法変更減額Entity.setTainoHanteiYMD(FlexibleDate.getNowDate());
        支払方法変更減額Entity.setHanteiKijunYMD(滞納判定結果.get滞納判定基準日());
        支払方法変更減額Entity.setChoshukenShometsuKikan(kyufugakuGengakuInfo.get徴収権消滅期間());
        支払方法変更減額Entity.setNofusumiKikan(kyufugakuGengakuInfo.get納付済期間());
        支払方法変更減額Entity.setNofusumiGengakuKikan(new Decimal(kyufugakuGengakuInfo.get給付額減額期間()));
        支払方法変更減額Entity.setKakutei_GengakuKaishiYMD(div.getTxtKonkaiKikanKaishiYMD().getValue());
        支払方法変更減額Entity.setKakutei_GengakuShuryoYMD(div.getTxtKonkaiKikanShuryoYMD().getValue());
        支払方法変更減額Entity.setLogicalDeletedFlag(false);
        支払方法変更減額明細Entity.setShoKisaiHokenshaNo(証記載保険者番号);
        支払方法変更減額明細Entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
        支払方法変更減額明細Entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号給付額減額.getコード());
        支払方法変更減額明細Entity.setRirekiNo(get最大履歴番号() + 1);
        支払方法変更減額明細Entity.setTaishoNendo(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get調定年度());
        支払方法変更減額明細Entity.setMino_JikoShometsuGengaku(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get時効到来未納額());
        支払方法変更減額明細Entity.setNofugaku(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get収入額());
        支払方法変更減額明細Entity.setNenFukagaku(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get調定額());
        支払方法変更減額明細EntityList.add(支払方法変更減額明細Entity);
        shiharaiHohoHenkoGengakuEntity.set支払方法変更減額Entity(支払方法変更減額Entity);
        shiharaiHohoHenkoGengakuEntity.set支払方法変更減額明細Entity(支払方法変更減額明細EntityList);
        shiharaiHohoHenkoGengakuList.add(shiharaiHohoHenkoGengakuEntity);
        return shiharaiHohoHenkoGengakuList;
    }

    private List<DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity> get支払方法変更減額明細Entity(TainoHanteiResultKohen 滞納判定結果) {
        List<DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity> 支払方法変更減額明細Entity = new ArrayList();
        Map<FlexibleYear, KyufugakuGengakuMeisai> 給付額減額明細マップ = 滞納判定結果.get給付額減額().get給付額減額明細マップ();
        DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity entity = new DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity();
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        entity.setHihokenshaNo(new HihokenshaNo(div.getKey_HihokenshaNo()));
        entity.setKanriKubun(ShiharaiHenkoKanriKubun._１号給付額減額.getコード());
        entity.setRirekiNo(get最大履歴番号() + 1);
        entity.setTaishoNendo(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get調定年度());
        entity.setMino_JikoShometsuGengaku(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get時効到来未納額());
        entity.setNofugaku(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get収入額());
        entity.setNenFukagaku(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get調定額());
        支払方法変更減額明細Entity.add(entity);
        return 支払方法変更減額明細Entity;
    }

    private void update支払方法変更_UPD001() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        builder.set減額決定年月日(div.getTxtGengakuKetteiYMD().getValue()).setState(EntityDataState.Modified);
        ViewStateHolder.put(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, builder.build());
    }

    private void update支払方法変更_UPD002() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        builder.set終了申請書受付年月日(div.getTxtMenjoShinseiUketsukeYMD().getValue())
                .set終了申請年月日(div.getTxtMenjoShinseiYMD().getValue())
                .set終了申請理由コード(div.getDdlIMenjoShinseiRiyu().getSelectedKey())
                .set終了申請審査決定年月日(div.getTxtMenjoNaiyoKetteiYMD().getValue())
                .set終了申請審査結果区分(div.getDdlMenjoShinseiShinsaKekka().getSelectedKey());
        if (div.getDdlMenjoShinseiJokyo().getSelectedKey().equals(JokyoCode.無効.getコード())) {
            builder.set無効区分(ShiharaiHenkoMukoKubun.無効.getコード());
        }
        builder.setState(EntityDataState.Modified);
        ViewStateHolder.put(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, builder.build());
    }

    private void update支払方法変更滞納_UPD003(TainoHanteiResultKohen 滞納判定結果) {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
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
        ViewStateHolder.put(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, builder.build());
    }

    private void update支払方法変更減額_UPD004() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        for (ShiharaiHohoHenkoGengaku shiharaiHohoHenkoGengaku : 支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList()) {
            builder.setShiharaiHohoHenkoGengaku(shiharaiHohoHenkoGengaku.createBuilderForEdit()
                    .set確定減額期間終了年月日(div.getTxtKonkaiKikanShuryoYMD().getValue())
                    .set確定減額期間開始年月日(div.getTxtKonkaiKikanKaishiYMD().getValue()).build());
        }
        ViewStateHolder.put(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, builder.build());
    }

    private void update支払方法変更減額_UPD005() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        for (ShiharaiHohoHenkoGengaku shiharaiHohoHenkoGengaku : 支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList()) {
            builder.setShiharaiHohoHenkoGengaku(shiharaiHohoHenkoGengaku.createBuilderForEdit()
                    .set確定減額期間終了年月日(div.getTxtGengakuTekiyoKikanShuryoYMD().getValue()).build());
        }
        ViewStateHolder.put(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, builder.build());
    }

    private void update支払方法変更減額明細_UPD006(TainoHanteiResultKohen 滞納判定結果) {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        Map<FlexibleYear, KyufugakuGengakuMeisai> 給付額減額明細マップ = 滞納判定結果.get給付額減額().get給付額減額明細マップ();
        ShiharaiHohoHenkoBuilder builder = 支払方法変更管理業務概念.createBuilderForEdit();
        for (ShiharaiHohoHenkoGengaku shiharaiHohoHenkoGengaku : 支払方法変更管理業務概念.getShiharaiHohoHenkoGengakuList()) {
            for (ShiharaiHohoHenkoGengakuMeisai shiharaiHohoHenkoGengakuMeisai : shiharaiHohoHenkoGengaku.getShiharaiHohoHenkoGengakuMeisaiList()) {
                shiharaiHohoHenkoGengakuMeisai.createBuilderForEdit().set年賦課額(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get調定額())
                        .set納付額(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get収入額())
                        .set未納_時効消滅減額(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get時効到来未納額());
                builder.setShiharaiHohoHenkoGengaku(shiharaiHohoHenkoGengaku.createBuilderForEdit().setShiharaiHohoHenkoGengakuMeisai(shiharaiHohoHenkoGengakuMeisai.createBuilderForEdit()
                        .set年賦課額(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get調定額())
                        .set納付額(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get収入額())
                        .set未納_時効消滅減額(給付額減額明細マップ.get(滞納判定結果.get滞納判定基準日().getYear()).get時効到来未納額()).build()).build());
            }
            builder.setShiharaiHohoHenkoGengaku(shiharaiHohoHenkoGengaku.createBuilderForEdit()
                    .set確定減額期間終了年月日(div.getTxtGengakuTekiyoKikanShuryoYMD().getValue()).build());
        }
        ViewStateHolder.put(KyufuGengaku1GoHandler.一号給付額減額ダイアログキー.支払方法変更管理業務概念, builder.build());
    }

    private Decimal get給付額減額期間(Decimal value, Decimal value0) {
        Decimal valueNum;
        valueNum = value.multiply(value).divide(value.add(value0)).divide(2).multiply(12);
        if (valueNum.intValue() == 0) {
            return null;
        }
        return valueNum;
    }

    private int get最大履歴番号() {
        if (div.getKey_MaxRirekiNo().isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(div.getKey_MaxRirekiNo().toString());
        }
    }

    private ValidationMessageControlPairs getValidationMessages() {
        ShiharaiHohoHenko 支払方法変更管理業務概念 = ViewStateHolder.get(一号給付額減額ダイアログキー.支払方法変更管理業務概念, ShiharaiHohoHenko.class);
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor滞納状況情報(pairs, div, 支払方法変更管理業務概念);
        getValidationHandler().validateFor減額適用期間チェック(pairs, div);
        getValidationHandler().validateFor減額適用期間終了入力チェック(pairs, div);
        getValidationHandler().validateFor申請理由未選択チェック(pairs, div);
        getValidationHandler().validateFor減額適用期間2チェック(pairs, div);
        return pairs;
    }

    private KyufuGengaku1GoValidationHandler getValidationHandler() {
        return new KyufuGengaku1GoValidationHandler();
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

    public enum JokyoCode {

        /**
         * コード:00 名称:空 略称:定義なし
         */
        _空(RString.EMPTY.toString(), RString.EMPTY.toString()),
        /**
         * コード:2 名称:期間短縮 略称:定義なし
         */
        期間短縮("2", "期間短縮"),
        /**
         * コード:3 名称:無効 略称:定義なし
         */
        無効("3", "無効");
        private final RString code;
        private final RString fullName;

        private JokyoCode(String code, String fullname) {
            this.code = new RString(code);
            this.fullName = new RString(fullname);
        }

        /**
         * 状況のコードを返します。
         *
         * @return 状況のコード
         */
        public RString getコード() {
            return code;
        }

        /**
         * 状況のコードの名称を返します。
         *
         * @return 状況のコードの名称
         */
        public RString get名称() {
            return fullName;
        }
    }
}
