/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0110011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujigyoshasakusei.KyotakuKeikakuJigyoshaSakusei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujigyoshasakusei.KyotakuKeikakuJigyoshaSakuseiBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujigyoshasakusei.KyotakuKeikakuJigyoshaSakuseiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakuseiBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakuseiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakuserviceriyohyomain.KaigoJigyoshaResult;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.TodokedeshaKankeiKBN;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokedeMapperParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011.DBC0110011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011.KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011.dgKyotakuServiceIchiran_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.SogoJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.kaigojigyosha.KaigoJigyoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokedeManager;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.KyotakuservicekeikakuSakuseikubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.service.core.basic.JukyushaDaichoManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 画面設計_DBC0110011_居宅サービス計画作成依頼届出情報登録のHandler
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public class KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler {

    private final KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div;
    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private static final RString 業務固有の識別情報名称 = new RString("被保険者番号");
    private static final RString 居宅介護支援事業者 = new RString("居宅介護支援事業者");
    private static final RString 介護予防支援事業者_地域包括支援センター = new RString("介護予防支援事業者・地域包括支援センター");
    private static final RString 自己作成 = new RString("自己作成");
    private static final Code 業務固有 = new Code("0003");
    private static final RString メニューID_事業者作成 = new RString("DBCMN21001");
    private static final RString メニューID_自己作成 = new RString("DBCMN21002");
    private static final RString TEXT_追加_計画作成依頼 = new RString("追加・計画作成依頼");
    private static final RString TEXT_追加_自己作成 = new RString("追加・自己作成");
    private static final RString TEXT_新規登録 = new RString("新規登録");
    private static final RString TEXT_直近照会 = new RString("直近照会");
    private static final RString TEXT_履歴照会 = new RString("履歴照会");
    private static final RString TEXT_直近訂正 = new RString("直近訂正");
    private static final RString TEXT_履歴訂正 = new RString("履歴訂正");
    private static final RString TEXT_直近削除 = new RString("直近削除");
    private static final RString TEXT_履歴削除 = new RString("履歴削除");
    private static final RString FLAG_直近履歴 = new RString("有効");
    private static final RString FLAG_履歴 = new RString("無効");
    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString 保存する = new RString("btnSave");
    private static final Code CODE_12 = new Code("12");
    private static final Code CODE_13 = new Code("13");
    private static final Code CODE_21 = new Code("21");
    private static final Code CODE_25 = new Code("25");
    private static final RString 届出区分_新規 = new RString("1");
    private static final RString 届出区分_変更 = new RString("2");
    private static final RString 居宅 = new RString("1");
    private static final RString 総合事業 = new RString("2");
    private static final RString RSTRING_0 = new RString("0");
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final RString 計画追加モード = new RString("add");
    private static final RString 計画修正モード = new RString("modify");
    private static final RString 計画削除モード = new RString("delete");
    private static final RString 計画照会モード = new RString("rireki");
    private static final RString 居宅介護 = new RString("居宅介護");
    private static final RString 居宅予防 = new RString("居宅予防");
    private static final RString 小規模介護 = new RString("小規模介護");
    private static final RString 小規模予防 = new RString("小規模予防");
    private static final RString ケアマネジメント = new RString("ケアマネジメント");

    /**
     * コンストラクタです。
     *
     * @param div KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv
     */
    public KyotakuSabisuKeikakuIraiTodokedeJohoTorokuHandler(KyotakuSabisuKeikakuIraiTodokedeJohoTorokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 居宅給付計画届出履歴一覧 居宅給付計画届出履歴一覧
     */
    public void initialize(HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            List<KyotakuKeikakuTodokede> 居宅給付計画届出履歴一覧) {
        div.getKihonJoho().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        if (!get前排他(被保険者番号.getColumnValue())) {
            throw new PessimisticLockingException();
        }
        set履歴一覧エリ(居宅給付計画届出履歴一覧);
        JigyoshaMode mode = new JigyoshaMode();
        mode.setJigyoshaShubetsu(ShisetsuType.介護保険施設.getコード());
        div.setJigyoshaMode(DataPassingConverter.serialize(mode));
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
    }

    /**
     * 保存する設定です。
     */
    public void set保存する() {
        if (!DBC0110011StateName.追加状態.getName().equals(ResponseHolder.getState())) {
            return;
        }
        if (計画照会モード.equals(div.getMode())) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, true);
        } else {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, false);
        }
    }

    /**
     * 居宅サービス一覧Grid「選択」ボタン押下時のメソッドです。
     *
     * @param 居宅給付計画届出 居宅給付計画届出
     */
    public void onSelect居宅サービス一覧(KyotakuKeikakuTodokede 居宅給付計画届出) {
        div.setMode(計画照会モード);
        dgKyotakuServiceIchiran_Row 選択行 = div.getRireki().getDgKyotakuServiceIchiran().getClickedItem();
        if (FLAG_直近履歴.equals(選択行.getYukoMuko())) {
            div.getServiceAddAndServicePlanCreate().getTxtTorokuState().setValue(TEXT_直近照会);
        } else {
            div.getServiceAddAndServicePlanCreate().getTxtTorokuState().setValue(TEXT_履歴照会);
        }
        set認定申請中状況を活性制御(居宅給付計画届出.get被保険者番号());
        set届出内容エリア照会(居宅給付計画届出);
        if (is事業者作成の場合()) {
            set計画事業者エリア照会(居宅給付計画届出);
        }
        if (is自己作成の場合()) {
            div.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setDisplayNone(true);
        }
        div.getServiceAddAndServicePlanCreate().setReadOnly(true);
    }

    /**
     * 居宅サービス一覧Grid「修正」ボタン押下時のメソッドです。
     *
     * @param 居宅給付計画届出 居宅給付計画届出
     */
    public void onModify居宅サービス一覧(KyotakuKeikakuTodokede 居宅給付計画届出) {
        div.setMode(計画修正モード);
        dgKyotakuServiceIchiran_Row 選択行 = div.getRireki().getDgKyotakuServiceIchiran().getClickedItem();
        if (FLAG_直近履歴.equals(選択行.getYukoMuko())) {
            div.getServiceAddAndServicePlanCreate().getTxtTorokuState().setValue(TEXT_直近訂正);
        } else {
            div.getServiceAddAndServicePlanCreate().getTxtTorokuState().setValue(TEXT_履歴訂正);
        }
        set認定申請中状況を活性制御(居宅給付計画届出.get被保険者番号());
        set届出内容エリア照会(居宅給付計画届出);
        if (is事業者作成の場合()) {
            set計画事業者エリア照会(居宅給付計画届出);
        }
        if (is自己作成の場合()) {
            div.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setDisplayNone(true);
        }
        div.getServiceAddAndServicePlanCreate().setReadOnly(false);
    }

    /**
     * 居宅サービス一覧Grid「削除」ボタン押下時のメソッドです。
     *
     * @param 居宅給付計画届出 居宅給付計画届出
     */
    public void onDelete居宅サービス一覧(KyotakuKeikakuTodokede 居宅給付計画届出) {
        div.setMode(計画削除モード);
        dgKyotakuServiceIchiran_Row 選択行 = div.getRireki().getDgKyotakuServiceIchiran().getClickedItem();
        if (FLAG_直近履歴.equals(選択行.getYukoMuko())) {
            div.getServiceAddAndServicePlanCreate().getTxtTorokuState().setValue(TEXT_直近削除);
        } else {
            div.getServiceAddAndServicePlanCreate().getTxtTorokuState().setValue(TEXT_履歴削除);
        }
        set認定申請中状況を活性制御(居宅給付計画届出.get被保険者番号());
        set届出内容エリア照会(居宅給付計画届出);
        if (is事業者作成の場合()) {
            set計画事業者エリア照会(居宅給付計画届出);
        }
        if (is自己作成の場合()) {
            div.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setDisplayNone(true);
        }
        div.getServiceAddAndServicePlanCreate().setReadOnly(true);
    }

    /**
     * 「追加」ボタン押下時のメソッドです。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void add居宅サービス(HihokenshaNo 被保険者番号) {
        div.setMode(計画追加モード);
        div.getServiceAddAndServicePlanCreate().getTxtTorokuState().setValue(TEXT_新規登録);
        set認定申請中状況を活性制御(被保険者番号);
        div.getServiceAddAndServicePlanCreate().getRadTodokedeKubun().setSelectedKey(KEY_0);
        if (is事業者作成の場合()) {
            div.getRadTodokedeKubun().setSelectedKey(KEY_1);
            div.getRadKeikakuKubun().setDisplayNone(true);
            div.getRadServiceShurui().setDataSource(getサービス種類DataSource());
            div.getRadKeikakuSakuseiKubun().setDataSource(get事業者作成計画作成区分DataSource());
            div.getRadKeikakuSakuseiKubun().setSelectedKey(get計画作成区分(被保険者番号));
            div.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setDisplayNone(false);
            set追加計画事業者エリア();
        }
        if (is自己作成の場合()) {
            div.getRadTodokedeKubun().setSelectedKey(KEY_0);
            div.getRadKeikakuKubun().setDisplayNone(true);
            div.getRadKeikakuKubun().setSelectedKey(KEY_0);
            div.getRadKeikakuSakuseiKubun().setDataSource(get自己作成DataSource());
            div.getRadKeikakuSakuseiKubun().setSelectedIndex(0);
            div.getServiceAddAndServicePlanCreate().getJigyoshaJoho().setDisplayNone(true);
        }
        div.getTxtKeikakuTekiyoStartYMD().clearValue();
        div.getTxtKeikakuTekiyoEndYMD().clearValue();
        div.getTxtTodokedeYMD().clearValue();
        div.getTxtTodokedeshaName().clearValue();
        div.getTxtTodokedeshaNameKana().clearValue();
        div.getTxtTodokedeshaYubinNo().clearValue();
        div.getTxtTodokedeshaJusho().clearValue();
        div.getTxtTodokedeshaTelNo().clearValue();
        div.getDdlTodokedeshaKankeiKubun().setDataSource(get届出者関係区分DataSource());
    }

    /**
     * 「計画作成区分」ラジオボタンが変更時のメソッドです。
     *
     */
    public void onChange計画作成区分() {
        if (JukyushaIF_KeikakuSakuseiKubunCode.居宅介護支援事業所作成.getコード().equals(div.getRadKeikakuSakuseiKubun().
                getSelectedKey())) {
            div.getTxtItakusakiJigyoshaNo().setReadOnly(true);
        } else {
            div.getTxtItakusakiJigyoshaNo().setReadOnly(false);
        }
    }

    /**
     * 居宅給付計画届出を管理作成のメソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @return 居宅給付計画届出
     */
    public KyotakuKeikakuTodokede create居宅給付計画届出(HihokenshaNo 被保険者番号, int 履歴番号) {
        FlexibleYearMonth 対象年月 = new FlexibleYearMonth(div.getTxtKeikakuTekiyoStartYMD().getValue().getYearMonth().toDateString());
        KyotakuKeikakuTodokede 居宅給付計画届出 = new KyotakuKeikakuTodokede(被保険者番号, 対象年月, 履歴番号);
        if (is事業者作成の場合()) {
            KyotakuKeikakuJigyoshaSakusei 居宅給付計画事業者作成 = new KyotakuKeikakuJigyoshaSakusei(被保険者番号, 対象年月, 履歴番号);
            居宅給付計画届出.createBuilderForEdit().setKyotakuKeikakuJigyoshaSakusei(居宅給付計画事業者作成);
        }
        if (is自己作成の場合()) {
            KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 = new KyotakuKeikakuJikoSakusei(被保険者番号, 対象年月, 履歴番号);
            居宅給付計画届出.createBuilderForEdit().setKyotakuKeikakuJikoSakusei(居宅給付計画自己作成);
        }
        return 居宅給付計画届出;
    }

    /**
     * 画面入力項目設定のメソッドです。
     *
     * @param 居宅給付計画届出 居宅給付計画届出
     * @return KyotakuKeikakuTodokede 居宅給付計画届出
     */
    public KyotakuKeikakuTodokede set保存処理(KyotakuKeikakuTodokede 居宅給付計画届出) {
        if (計画削除モード.equals(div.getMode())) {
            居宅給付計画届出 = 居宅給付計画届出.deleted();
        } else {
            居宅給付計画届出 = set入力項目(居宅給付計画届出);
        }
        return 居宅給付計画届出;
    }

    /**
     * 小規模多機能チェックのメソッドです。
     *
     * @return Boolean
     */
    public boolean get小規模多機能チェック() {
        if (!計画修正モード.equals(div.getMode()) || !is事業者作成の場合()) {
            return Boolean.FALSE;
        }
        if (ServiceCategoryShurui.地小短外.getコード().equals(div.getServiceShurui())
                && ServiceCategoryShurui.地小短外.getコード().equals(div.getRadServiceShurui().getSelectedKey())
                && div.getTxtKeikakuTekiyoStartYMD().getValue().getDayValue() != ONE) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 介護度・サービス種類チェックのメソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @return Boolean
     */
    public boolean get介護度サービス種類チェック(HihokenshaNo 被保険者番号) {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        JukyushaDaicho jukyushaDaicho = manager.get受給申請事由認定完了(被保険者番号);
        if (jukyushaDaicho != null
                && CODE_21.compareTo(jukyushaDaicho.get要介護認定状態区分コード()) <= 0
                && CODE_25.compareTo(jukyushaDaicho.get要介護認定状態区分コード()) >= 0
                && JukyushaIF_KeikakuSakuseiKubunCode.介護予防支援事業所_地域包括支援センター作成.getコード().equals(
                        div.getRadKeikakuSakuseiKubun().getSelectedKey())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 地域包括支援センターチェックのメソッドです。
     *
     * @return Boolean
     */
    public boolean get地域包括支援センターチェック() {
        if (!is事業者作成の場合()) {
            return Boolean.FALSE;
        }
        if (JukyushaIF_KeikakuSakuseiKubunCode.介護予防支援事業所_地域包括支援センター作成.getコード().equals(
                div.getRadKeikakuSakuseiKubun().getSelectedKey())
                && !RSTRING_0.equals(div.getTxtJigyoshaNo().getValue().substring(TWO, THREE))) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 計画適用開始日での認定状態をチェックのメソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @return Boolean
     */
    public boolean get計画適用開始日での認定状態をチェック(HihokenshaNo 被保険者番号) {
        FlexibleDate 計画適用開始日 = new FlexibleDate(div.getTxtKeikakuTekiyoStartYMD().getValue().toDateString());
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        List<JukyushaDaicho> list = manager.select受給者台帳情報(被保険者番号, 計画適用開始日);
        return list.isEmpty();
    }

    /**
     * 受給申請中をチェックのメソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @return Boolean
     */
    public boolean get受給申請中をチェック(HihokenshaNo 被保険者番号) {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        JukyushaDaicho jukyushaDaicho = manager.get受給申請事由(被保険者番号);
        return jukyushaDaicho == null;
    }

    /**
     * 項目が変更をチェックのメソッドです。
     *
     * @param 居宅給付計画届出 居宅給付計画届出
     * @return Boolean
     */
    public boolean is項目が変更(KyotakuKeikakuTodokede 居宅給付計画届出) {
        if (!DBC0110011StateName.追加状態.getName().equals(ResponseHolder.getState())) {
            return Boolean.FALSE;
        }
        if (計画削除モード.equals(div.getMode())
                || 計画照会モード.equals(div.getMode())) {
            return Boolean.FALSE;
        }
        居宅給付計画届出 = set保存処理(居宅給付計画届出);
        return 居宅給付計画届出.hasChanged();
    }

    /**
     * 拡張情報作成のメソッドです。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 拡張情報
     */
    public PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(業務固有, 業務固有の識別情報名称, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo);
    }

    private KyotakuKeikakuTodokede set入力項目(KyotakuKeikakuTodokede 居宅給付計画届出) {
        居宅給付計画届出 = 居宅給付計画届出.createBuilderForEdit().
                set届出区分(KEY_0.equals(div.getRadTodokedeKubun().getSelectedKey()) ? 届出区分_新規 : 届出区分_変更).
                set届出年月日(new FlexibleDate(div.getTxtTodokedeYMD().getValue().toDateString())).
                set届出者氏名(new AtenaMeisho(div.getTxtTodokedeshaName().getValue())).
                set届出者氏名カナ(new AtenaKanaMeisho(div.getTxtTodokedeshaNameKana().getValue())).
                set届出者郵便番号(new YubinNo(div.getTxtTodokedeshaYubinNo().getValue())).
                set届出者住所(div.getTxtTodokedeshaJusho().getValue()).
                set届出者電話番号(new TelNo(div.getTxtTodokedeshaTelNo().getValue())).
                set届出者関係区分(div.getDdlTodokedeshaKankeiKubun().getSelectedKey()).build();
        if (is事業者作成の場合()) {
            KyotakuKeikakuJigyoshaSakuseiIdentifier identifier = new KyotakuKeikakuJigyoshaSakuseiIdentifier(
                    居宅給付計画届出.get被保険者番号(), 居宅給付計画届出.get対象年月(), 居宅給付計画届出.get履歴番号());
            KyotakuKeikakuJigyoshaSakusei 居宅給付計画事業者作成 = 居宅給付計画届出.getKyotakuKeikakuJigyoshaSakusei(identifier);
            KyotakuKeikakuJigyoshaSakuseiBuilder builder = 居宅給付計画事業者作成.createBuilderForEdit().
                    set適用開始年月日(new FlexibleDate(div.getTxtKeikakuTekiyoStartYMD().getValue().toDateString())).
                    set適用終了年月日(new FlexibleDate(div.getTxtKeikakuTekiyoEndYMD().getValue().toDateString()));
            builder.set作成区分コード(div.getRadKeikakuSakuseiKubun().getSelectedKey()).
                    set計画事業者番号(new JigyoshaNo(div.getTxtJigyoshaNo().getValue())).
                    set委託先事業者番号(new JigyoshaNo(div.getTxtItakusakiJigyoshaNo().getValue()));
            if (div.getTxtJigyoshaHenkoYMD().getValue() != null && !div.getTxtJigyoshaHenkoYMD().isReadOnly()) {
                builder.set事業者変更年月日(new FlexibleDate(div.getTxtJigyoshaHenkoYMD().getValue().toDateString()));
            }
            if (!div.getTxtJigyoshaHenkoJiyu().isReadOnly()) {
                builder.set事業者変更事由(div.getTxtJigyoshaHenkoJiyu().getValue());
            }
            builder.setサービス種類コード(new ServiceShuruiCode(div.getRadServiceShurui().getSelectedKey()));
            居宅給付計画届出 = 居宅給付計画届出.createBuilderForEdit().setKyotakuKeikakuJigyoshaSakusei(builder.build()).build();
        }
        if (is自己作成の場合()) {
            KyotakuKeikakuJikoSakuseiIdentifier identifier = new KyotakuKeikakuJikoSakuseiIdentifier(
                    居宅給付計画届出.get被保険者番号(), 居宅給付計画届出.get対象年月(), 居宅給付計画届出.get履歴番号());
            KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 = 居宅給付計画届出.getKyotakuKeikakuJikoSakusei(identifier);
            KyotakuKeikakuJikoSakuseiBuilder builder = 居宅給付計画自己作成.createBuilderForEdit().
                    set居宅_総合事業区分(KEY_0.equals(div.getRadTodokedeKubun().getSelectedKey()) ? 居宅 : 総合事業).
                    set適用開始年月日(new FlexibleDate(div.getTxtKeikakuTekiyoStartYMD().getValue().toDateString())).
                    set適用終了年月日(new FlexibleDate(div.getTxtKeikakuTekiyoEndYMD().getValue().toDateString())).
                    set作成区分コード(div.getRadKeikakuSakuseiKubun().getSelectedKey());
            居宅給付計画届出 = 居宅給付計画届出.createBuilderForEdit().setKyotakuKeikakuJikoSakusei(builder.build()).build();
        }
        return 居宅給付計画届出;
    }

    private void set追加計画事業者エリア() {
        div.getTxtJigyoshaNo().clearValue();
        div.getTxtJigyoshaName().clearValue();
        div.getRadServiceShurui().clearSelectedItem();
        div.getTxtJigyoshaYubinNo().clearValue();
        div.getTxtJigyoshaJusho().clearValue();
        div.getTxtJigyoshaTelNo().clearValue();
        div.getTxtJigyoshaKanrishaName().clearValue();
        div.getTxtItakusakiJigyoshaNo().clearValue();
        div.getTxtItakusakiJigyoshaName().clearValue();
        div.getTxtJigyoshaHenkoYMD().clearValue();
        div.getTxtJigyoshaHenkoJiyu().clearValue();
        onChange計画作成区分();
        if (KEY_0.equals(div.getRadTodokedeKubun().getSelectedKey())) {
            div.getTxtJigyoshaHenkoYMD().setReadOnly(true);
            div.getTxtJigyoshaHenkoJiyu().setReadOnly(true);
        } else {
            div.getTxtJigyoshaHenkoYMD().setReadOnly(false);
            div.getTxtJigyoshaHenkoJiyu().setReadOnly(false);
        }
    }

    private RString get計画作成区分(HihokenshaNo 被保険者番号) {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        JukyushaDaicho jukyushaDaicho = manager.get受給申請事由認定完了(被保険者番号);
        if (jukyushaDaicho != null) {
            if (CODE_13.equals(jukyushaDaicho.get要介護認定状態区分コード())
                    || CODE_12.equals(jukyushaDaicho.get要介護認定状態区分コード())) {
                return JukyushaIF_KeikakuSakuseiKubunCode.介護予防支援事業所_地域包括支援センター作成.getコード();
            }
            if (CODE_21.compareTo(jukyushaDaicho.get要介護認定状態区分コード()) <= 0
                    && CODE_25.compareTo(jukyushaDaicho.get要介護認定状態区分コード()) >= 0) {
                return JukyushaIF_KeikakuSakuseiKubunCode.居宅介護支援事業所作成.getコード();
            }
        } else {
            SogoJigyoTaishoshaManager sogoJigyoTaishoshaManager = new SogoJigyoTaishoshaManager();
            if (sogoJigyoTaishoshaManager.get総合事業対象者(被保険者番号).isEmpty()) {
                return JukyushaIF_KeikakuSakuseiKubunCode.介護予防支援事業所_地域包括支援センター作成.getコード();
            } else {
                return JukyushaIF_KeikakuSakuseiKubunCode.居宅介護支援事業所作成.getコード();
            }
        }
        return RString.EMPTY;
    }

    private void set届出内容エリア照会(KyotakuKeikakuTodokede 居宅給付計画届出) {
        div.getServiceAddAndServicePlanCreate().getRadTodokedeKubun().setSelectedKey(KEY_1);
        if (届出区分_新規.equals(居宅給付計画届出.get届出区分())) {
            div.getRadTodokedeKubun().setSelectedKey(KEY_0);
        } else if (届出区分_変更.equals(居宅給付計画届出.get届出区分())) {
            div.getRadTodokedeKubun().setSelectedKey(KEY_1);
        }
        if (is事業者作成の場合()) {
            KyotakuKeikakuJigyoshaSakusei 居宅給付計画事業者作成 = 居宅給付計画届出.getKyotakuKeikakuJigyoshaSakuseiList().get(0);
            div.getRadTodokedeKubun().setSelectedKey(KEY_1);
            div.getRadKeikakuKubun().setDisplayNone(true);
            div.getTxtKeikakuTekiyoStartYMD().setValue(new RDate(居宅給付計画事業者作成.get適用開始年月日().toString()));
            div.getTxtKeikakuTekiyoEndYMD().setValue(new RDate(居宅給付計画事業者作成.get適用終了年月日().toString()));
            div.setKeikakuTekiyoStartYM(居宅給付計画事業者作成.get適用開始年月日().getYearMonth().toDateString());
            div.getRadKeikakuSakuseiKubun().setDataSource(get事業者作成計画作成区分DataSource());
            div.getRadKeikakuSakuseiKubun().setSelectedKey(居宅給付計画事業者作成.get作成区分コード());
        }
        if (is自己作成の場合()) {
            KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 = 居宅給付計画届出.getKyotakuKeikakuJikoSakuseiList().get(0);
            div.getRadKeikakuKubun().setDisplayNone(true);
            if (居宅.equals(居宅給付計画自己作成.get居宅_総合事業区分())) {
                div.getRadKeikakuKubun().setSelectedKey(KEY_0);
            } else if (総合事業.equals(居宅給付計画自己作成.get居宅_総合事業区分())) {
                div.getRadKeikakuKubun().setSelectedKey(KEY_1);
            }
            div.getTxtKeikakuTekiyoStartYMD().setValue(new RDate(居宅給付計画自己作成.get適用開始年月日().toString()));
            div.getTxtKeikakuTekiyoEndYMD().setValue(new RDate(居宅給付計画自己作成.get適用終了年月日().toString()));
            div.setKeikakuTekiyoStartYM(居宅給付計画自己作成.get適用開始年月日().getYearMonth().toDateString());
            div.getRadKeikakuSakuseiKubun().setDataSource(get自己作成DataSource());
            div.getRadKeikakuSakuseiKubun().setSelectedKey(居宅給付計画自己作成.get作成区分コード());
        }
        div.getTxtTodokedeYMD().setValue(new RDate(居宅給付計画届出.get届出年月日().toString()));
        div.getTxtTodokedeshaName().setValue(居宅給付計画届出.get届出者氏名() == null ? RString.EMPTY
                : 居宅給付計画届出.get届出者氏名().getColumnValue());
        div.getTxtTodokedeshaNameKana().setValue(居宅給付計画届出.get届出者氏名カナ() == null ? RString.EMPTY
                : 居宅給付計画届出.get届出者氏名カナ().getColumnValue());
        div.getTxtTodokedeshaYubinNo().setValue(居宅給付計画届出.get届出者郵便番号() == null ? RString.EMPTY
                : 居宅給付計画届出.get届出者郵便番号().getColumnValue());
        div.getTxtTodokedeshaJusho().setValue(居宅給付計画届出.get届出者住所() == null ? RString.EMPTY
                : 居宅給付計画届出.get届出者住所());
        div.getTxtTodokedeshaTelNo().setValue(居宅給付計画届出.get届出者電話番号() == null ? RString.EMPTY
                : 居宅給付計画届出.get届出者電話番号().getColumnValue());
        div.getDdlTodokedeshaKankeiKubun().setDataSource(get届出者関係区分DataSource());
        div.getDdlTodokedeshaKankeiKubun().setSelectedKey(居宅給付計画届出.get届出者関係区分());
    }

    private void set計画事業者エリア照会(KyotakuKeikakuTodokede 居宅給付計画届出) {
        KyotakuKeikakuJigyoshaSakusei 居宅給付計画事業者 = 居宅給付計画届出.getKyotakuKeikakuJigyoshaSakuseiList().get(0);
        dgKyotakuServiceIchiran_Row 選択行 = div.getRireki().getDgKyotakuServiceIchiran().getClickedItem();
        div.getTxtJigyoshaNo().setValue(選択行.getJigyoshaNo());
        div.getTxtJigyoshaName().setValue(選択行.getJigyoshaName());
        RString サービス種類コード = 居宅給付計画事業者.getサービス種類コード().getColumnValue();
        div.setServiceShurui(サービス種類コード);
        div.getRadServiceShurui().setDataSource(getサービス種類DataSource());
        div.getRadServiceShurui().setSelectedKey(サービス種類コード);
        KyotakuKeikakuTodokedeManager manager = KyotakuKeikakuTodokedeManager.createInstance();
        KyotakuKeikakuTodokedeMapperParameter parameter = KyotakuKeikakuTodokedeMapperParameter.createSelectByKeyParam(
                居宅給付計画届出.get被保険者番号(),
                居宅給付計画届出.get対象年月(),
                new Decimal(居宅給付計画届出.get履歴番号()));
        KaigoJigyoshaResult result = manager.select事業者の情報(parameter);
        div.getTxtJigyoshaYubinNo().setValue(result.get郵便番号() == null ? RString.EMPTY
                : result.get郵便番号());
        div.getTxtJigyoshaJusho().setValue(result.get住所() == null ? RString.EMPTY
                : result.get住所());
        div.getTxtJigyoshaTelNo().setValue(result.get電話番号() == null ? RString.EMPTY
                : result.get電話番号());
        div.getTxtJigyoshaKanrishaName().setValue(result.get管理者名() == null ? RString.EMPTY
                : result.get管理者名());
        div.getTxtItakusakiJigyoshaNo().setValue(居宅給付計画事業者.get委託先事業者番号() == null ? RString.EMPTY
                : 居宅給付計画事業者.get委託先事業者番号().getColumnValue());
        div.getTxtItakusakiJigyoshaName().setValue(result.get委託先事業者名() == null ? RString.EMPTY
                : result.get委託先事業者名());
        if (居宅給付計画事業者.get事業者変更年月日() != null) {
            div.getTxtJigyoshaHenkoYMD().setValue(new RDate(居宅給付計画事業者.get事業者変更年月日().toString()));
        } else {
            div.getTxtJigyoshaHenkoYMD().clearValue();
        }
        if (KEY_0.equals(div.getRadTodokedeKubun().getSelectedKey())) {
            div.getTxtItakusakiJigyoshaName().setReadOnly(false);
            div.getTxtJigyoshaHenkoYMD().setReadOnly(false);
        } else {
            div.getTxtItakusakiJigyoshaName().setReadOnly(true);
            div.getTxtJigyoshaHenkoYMD().setReadOnly(true);
        }
        div.getTxtJigyoshaHenkoJiyu().setValue(居宅給付計画事業者.get事業者変更事由());
    }

    private void set認定申請中状況を活性制御(HihokenshaNo 被保険者番号) {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        JukyushaDaicho jukyushaDaicho = manager.get受給申請事由(被保険者番号);
        if (jukyushaDaicho == null) {
            return;
        }
        if (JukyuShinseiJiyu.初回申請.getコード().equals(jukyushaDaicho.get申請理由())) {
            div.getServiceAddAndServicePlanCreate().getTxtNinteiShinseiShinki().setReadOnly(false);
        } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(jukyushaDaicho.get申請理由())
                || JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(jukyushaDaicho.get申請理由())) {
            div.getServiceAddAndServicePlanCreate().getTxtNinteiShinseiSaishinsei().setReadOnly(false);
        } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(jukyushaDaicho.get申請理由())) {
            div.getServiceAddAndServicePlanCreate().getTxtNinteiShinseiHenkoShinsei().setReadOnly(false);
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(jukyushaDaicho.get申請理由())) {
            div.getServiceAddAndServicePlanCreate().getTxtNinteiShinseiServiceHenko().setReadOnly(false);
        }
    }

    private void set履歴一覧エリ(List<KyotakuKeikakuTodokede> 居宅給付計画届出履歴一覧) {
        boolean is事業者作成 = is事業者作成の場合();
        boolean is自己作成 = is自己作成の場合();
        if (is事業者作成) {
            div.getRireki().getBtnAdd().setText(TEXT_追加_計画作成依頼);
        }
        if (is自己作成) {
            div.getRireki().getBtnAdd().setText(TEXT_追加_自己作成);
        }
        List<dgKyotakuServiceIchiran_Row> rows = new ArrayList<>();
        for (int i = 0; i < 居宅給付計画届出履歴一覧.size(); i++) {
            boolean is直近履歴 = Boolean.FALSE;
            KyotakuKeikakuTodokede 居宅給付計画届出履歴 = 居宅給付計画届出履歴一覧.get(i);
            if (居宅給付計画届出履歴一覧.size() == i + 1) {
                is直近履歴 = Boolean.TRUE;
            } else {
                KyotakuKeikakuTodokede 居宅給付計画届出履歴NEXT = 居宅給付計画届出履歴一覧.get(i + 1);
                is直近履歴 = !居宅給付計画届出履歴.get対象年月().equals(居宅給付計画届出履歴NEXT.get対象年月());
            }
            if (is事業者作成) {
                set事業者作成Data(居宅給付計画届出履歴, rows, is直近履歴);
            }
            if (is自己作成) {
                set自己作成Data(居宅給付計画届出履歴, rows, is直近履歴);
            }
        }
        div.getRireki().getDgKyotakuServiceIchiran().setDataSource(rows);
    }

    private void set事業者作成Data(KyotakuKeikakuTodokede 居宅給付計画届出履歴,
            List<dgKyotakuServiceIchiran_Row> rows,
            boolean is直近履歴) {
        if (居宅給付計画届出履歴.getKyotakuKeikakuJigyoshaSakuseiList().isEmpty()) {
            return;
        }
        KyotakuKeikakuJigyoshaSakusei 居宅給付計画事業者 = 居宅給付計画届出履歴.getKyotakuKeikakuJigyoshaSakuseiList().get(0);
        dgKyotakuServiceIchiran_Row row = new dgKyotakuServiceIchiran_Row();
        if (is事業者作成(居宅給付計画事業者.get作成区分コード())) {
            row.setSelectButtonState(DataGridButtonState.Enabled);
            row.setModifyButtonState(DataGridButtonState.Enabled);
            row.setDeleteButtonState(DataGridButtonState.Enabled);
        } else {
            row.setSelectButtonState(DataGridButtonState.Disabled);
            row.setModifyButtonState(DataGridButtonState.Disabled);
            row.setDeleteButtonState(DataGridButtonState.Disabled);
        }
        row.setTekiyoKaishiYMD(居宅給付計画事業者.get適用開始年月日().getYearMonth().wareki().toDateString());
        row.setTaishoYM(居宅給付計画届出履歴.get対象年月().toDateString());
        row.setKeikakuSakuseiKubun(KyotakuservicekeikakuSakuseikubunCode.toValue(居宅給付計画事業者.get作成区分コード()).get名称());
        row.setJigyoshaNo(居宅給付計画事業者.get被保険者番号().getColumnValue());
        row.setJigyoshaName(get事業者名(居宅給付計画事業者.get計画事業者番号().getColumnValue()));
        row.setYukoMuko(is直近履歴 ? FLAG_直近履歴 : FLAG_履歴);
        row.setRirekiNo(new RString(居宅給付計画事業者.get履歴番号()));
        rows.add(row);
    }

    private void set自己作成Data(KyotakuKeikakuTodokede 居宅給付計画届出履歴,
            List<dgKyotakuServiceIchiran_Row> rows,
            boolean is直近履歴) {
        if (居宅給付計画届出履歴.getKyotakuKeikakuJikoSakuseiList().isEmpty()) {
            return;
        }
        KyotakuKeikakuJikoSakusei 居宅給付計画自己作成 = 居宅給付計画届出履歴.getKyotakuKeikakuJikoSakuseiList().get(0);
        dgKyotakuServiceIchiran_Row row = new dgKyotakuServiceIchiran_Row();
        if (KyotakuservicekeikakuSakuseikubunCode.自己作成.getコード().equals(
                居宅給付計画自己作成.get作成区分コード())) {
            row.setSelectButtonState(DataGridButtonState.Enabled);
            row.setModifyButtonState(DataGridButtonState.Enabled);
            row.setDeleteButtonState(DataGridButtonState.Enabled);
        } else {
            row.setSelectButtonState(DataGridButtonState.Disabled);
            row.setModifyButtonState(DataGridButtonState.Disabled);
            row.setDeleteButtonState(DataGridButtonState.Disabled);
        }
        row.setTekiyoKaishiYMD(居宅給付計画自己作成.get適用開始年月日().getYearMonth().wareki().toDateString());
        row.setTaishoYM(居宅給付計画届出履歴.get対象年月().toDateString());
        row.setKeikakuSakuseiKubun(KyotakuservicekeikakuSakuseikubunCode.toValue(居宅給付計画自己作成.get作成区分コード()).get名称());
        row.setJigyoshaNo(RString.EMPTY);
        row.setJigyoshaName(RString.EMPTY);
        row.setYukoMuko(is直近履歴 ? FLAG_直近履歴 : FLAG_履歴);
        row.setRirekiNo(new RString(居宅給付計画届出履歴.get履歴番号()));
        rows.add(row);
    }

    private boolean is事業者作成(RString 計画作成区分) {
        return KyotakuservicekeikakuSakuseikubunCode.介護予防支援事業者作成.getコード().equals(計画作成区分)
                || KyotakuservicekeikakuSakuseikubunCode.基準該当居宅介護支援事業者作成.getコード().equals(計画作成区分)
                || KyotakuservicekeikakuSakuseikubunCode.指定居宅介護支援事業者作成.getコード().equals(計画作成区分);
    }

    /**
     * 前排他のンメソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @return boolean
     */
    public boolean get前排他(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 事業者名称を取得するメソッドです。
     *
     * @param 事業者番号 事業者番号
     * @return 事業者名
     */
    public RString get事業者名(RString 事業者番号) {
        if (!事業者番号.isNullOrEmpty()) {
            KaigoJigyosha 事業者 = get事業者(new JigyoshaNo(事業者番号));
            return 事業者 == null ? RString.EMPTY : 事業者.get事業者名称().getColumnValue();
        }
        return RString.EMPTY;
    }

    private KaigoJigyosha get事業者(JigyoshaNo 事業者番号) {
        KaigoJigyoshaManager manager = KaigoJigyoshaManager.createInstance();
        return manager.get介護事業者(事業者番号);
    }

    private boolean is事業者作成の場合() {
        return メニューID_事業者作成.equals(ResponseHolder.getMenuID());
    }

    private boolean is自己作成の場合() {
        return メニューID_自己作成.equals(ResponseHolder.getMenuID());
    }

    private List<KeyValueDataSource> get届出者関係区分DataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (TodokedeshaKankeiKBN 届出者関係区分 : TodokedeshaKankeiKBN.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(届出者関係区分.getコード(), 届出者関係区分.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> get事業者作成計画作成区分DataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KeyValueDataSource dataSource = new KeyValueDataSource(
                JukyushaIF_KeikakuSakuseiKubunCode.居宅介護支援事業所作成.getコード(), 居宅介護支援事業者);
        dataSourceList.add(dataSource);
        dataSource = new KeyValueDataSource(
                JukyushaIF_KeikakuSakuseiKubunCode.介護予防支援事業所_地域包括支援センター作成.getコード(),
                介護予防支援事業者_地域包括支援センター);
        dataSourceList.add(dataSource);
        return dataSourceList;
    }

    private List<KeyValueDataSource> get自己作成DataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KeyValueDataSource dataSource = new KeyValueDataSource(
                JukyushaIF_KeikakuSakuseiKubunCode.自己作成.getコード(), 自己作成);
        dataSourceList.add(dataSource);
        return dataSourceList;
    }

    private List<KeyValueDataSource> getサービス種類DataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KeyValueDataSource dataSource = new KeyValueDataSource(
                ServiceCategoryShurui.居宅支援.getコード(), 居宅介護);
        dataSourceList.add(dataSource);
        dataSource = new KeyValueDataSource(
                ServiceCategoryShurui.予防支援.getコード(), 居宅予防);
        dataSourceList.add(dataSource);
        dataSource = new KeyValueDataSource(
                ServiceCategoryShurui.地小短外.getコード(), 小規模介護);
        dataSourceList.add(dataSource);
        dataSource = new KeyValueDataSource(
                ServiceCategoryShurui.地予小外.getコード(), 小規模予防);
        dataSourceList.add(dataSource);
        dataSource = new KeyValueDataSource(
                ServiceCategoryShurui.予防ケア.getコード(), ケアマネジメント);
        dataSourceList.add(dataSource);
        return dataSourceList;
    }
}
