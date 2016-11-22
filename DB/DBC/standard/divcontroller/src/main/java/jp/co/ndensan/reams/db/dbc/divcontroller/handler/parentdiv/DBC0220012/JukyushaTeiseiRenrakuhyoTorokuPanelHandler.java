/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220012;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushateiseirenrakuhyotorokufinder.JukyushaTeiseiRenrakuhyoTorokuFinderResult;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TeiseiKubunCode;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220012.JukyushaTeiseiRenrakuhyoTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.jukyushateiseirenrakuhyotorokufinder.JukyushaTeiseiRenrakuhyoTorokuFinder;
import jp.co.ndensan.reams.db.dbc.service.core.jukyushateiseirenrakuhyotorokumanager.JukyushaTeiseiRenrakuhyoTorokuManager;
import jp.co.ndensan.reams.db.dbc.service.report.jukyushateiseirenrakuhyo.JukyushaTeiseiRenrakuhyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 画面設計_DBCMN81002_受給者訂正連絡票登録
 *
 * @reamsid_L DBC-2101-020 quxiaodong
 */
public class JukyushaTeiseiRenrakuhyoTorokuPanelHandler {

    private final JukyushaTeiseiRenrakuhyoTorokuPanelDiv div;
    private static final RString CODE_ミ = new RString("0003");
    private static final RString 半角アスタリスク = new RString("*");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final Decimal NUM_ZERO = new Decimal(0);
    private static final RString 修正モード_TWO = new RString("修正モード2");
    private static final RString 修正モード_THREE = new RString("修正モード3");
    private static final RString 照会モード = new RString("照会モード");
    private static final RString 被保番号 = new RString("被保険者番号");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final RString 空KEY = new RString(" ");

    /**
     * 初期化です。
     *
     * @param div JukyushaTeiseiRenrakuhyoTorokuPanelDiv
     */
    public JukyushaTeiseiRenrakuhyoTorokuPanelHandler(JukyushaTeiseiRenrakuhyoTorokuPanelDiv div) {
        this.div = div;
    }

    /**
     * 前排他を設定のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return Boolean
     */
    public Boolean is前排他キーのセット(HihokenshaNo 被保険者番号) {
        LockingKey 排他キー = new LockingKey(被保険者番号);
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他キーの解除のンメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void 前排他キーの解除(HihokenshaNo 被保険者番号) {
        LockingKey 排他キー = new LockingKey(被保険者番号);
        RealInitialLocker.release(排他キー);
    }

    /**
     * アクセスログの出力です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 RString
     * @return PersonalData
     */
    public PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo3 = new ExpandedInformation(new Code(CODE_ミ), 被保番号, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo3);
    }

    /**
     * 受給者訂正連絡票保存です。
     *
     * @param 受給者訂正連絡票登録画面Div JukyushaIdoRenrakuhyo
     * @param 訂正対象データ JukyushaIdoRenrakuhyo
     * @param 初期化データ JukyushaIdoRenrakuhyo
     * @param 処理モード RString
     * @return int
     */
    public int save受給者訂正連絡票(
            JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div,
            JukyushaIdoRenrakuhyo 訂正対象データ,
            JukyushaIdoRenrakuhyo 初期化データ,
            RString 処理モード) {
        RDate システムタイム = RDate.getNowDate();
        if (受給者訂正連絡票登録画面Div != null) {
            if (div.getOutputJukyushaIdoRenrakuhyo().getChkJukyushaTeiseiRearakuhyoHakkou().isAllSelected()) {
                受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                        createBuilderForEdit().set訂正連絡票フラグ(true).build();
            } else {
                受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                        createBuilderForEdit().set訂正連絡票フラグ(false).build();
            }
            if (処理モード.equals(修正モード_TWO)) {
                RString 訂正区分コード = JukyushaIF_TeiseiKubunCode.修正.getコード();
                受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.createBuilderForEdit().
                        set履歴番号(訂正対象データ.get履歴番号() + 1).build();
                受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.createBuilderForEdit().
                        set送付年月(new FlexibleYearMonth(システムタイム.getYearMonth().toDateString())).build();
                受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.createBuilderForEdit().
                        set訂正年月日(new FlexibleDate(システムタイム.toDateString())).build();
                受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.createBuilderForEdit().
                        set訂正区分コード(訂正区分コード).build();
                受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.added();
            } else if (処理モード.equals(修正モード_THREE)) {
                受給者訂正連絡票登録画面Div = get登録用Entity(受給者訂正連絡票登録画面Div, 訂正対象データ);
                受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.added();
            } else if (処理モード.equals(照会モード)) {
                RString 訂正区分コード = 受給者訂正連絡票登録画面Div.get訂正区分コード();
                FlexibleDate 訂正年月日 = 受給者訂正連絡票登録画面Div.get訂正年月日();
                初期化データ = 初期化データ.createBuilderForEdit().
                        set送付年月(new FlexibleYearMonth(システムタイム.getYearMonth().toDateString()))
                        .set訂正区分コード(訂正区分コード)
                        .set論理削除フラグ(true)
                        .set訂正年月日(訂正年月日).build();
                初期化データ = 初期化データ.modified();
                return JukyushaTeiseiRenrakuhyoTorokuManager.createInstance().
                        insert受給者異動送付(初期化データ);
            }
            return JukyushaTeiseiRenrakuhyoTorokuManager.createInstance().
                    insert受給者異動送付(受給者訂正連絡票登録画面Div);
        } else {
            return 0;
        }
    }

    /**
     * 共同処理用受給者異動連絡票データ作成です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 int
     * @param 論理削除フラグ boolean
     * @param 異動年月日 FlexibleDate
     * @param 受給者子Div JukyushaIdoRenrakuhyo
     * @param 処理モード RString
     * @return SourceDataCollection
     */
    public SourceDataCollection to帳票発行処理(
            HihokenshaNo 被保険者番号,
            int 履歴番号,
            boolean 論理削除フラグ,
            FlexibleDate 異動年月日,
            JukyushaIdoRenrakuhyo 受給者子Div,
            RString 処理モード) {
        RString 氏名_性別_生年月日を印字す = ZERO;
        if (div.getOutputJukyushaIdoRenrakuhyo().getChkJukyushaIdoRenrakuhyo().isAllSelected()) {
            氏名_性別_生年月日を印字す = ONE;
        }
        FlexibleDate 作成年月日 = new FlexibleDate(div.getOutputJukyushaIdoRenrakuhyo()
                .getJukyushaIdoRenrakuhyoHenkoPrintSetting().getIssueDate().toDateString());
        int 変更前履歴番号 = 1;
        if (TWO.equals(div.getOutputJukyushaIdoRenrakuhyo().getRadTeiseiKomokuHantei().getSelectedKey())) {
            変更前履歴番号 = 履歴番号;
        }
        JukyushaTeiseiRenrakuhyoTorokuFinderResult 変更前の訂正情報 = JukyushaTeiseiRenrakuhyoTorokuFinder.
                createInstance().editHenkomaeTeiseiJoho(被保険者番号, 変更前履歴番号,
                        異動年月日, 作成年月日, 氏名_性別_生年月日を印字す);
        履歴番号 = get履歴番号(処理モード, 履歴番号);
        JukyushaTeiseiRenrakuhyoTorokuFinderResult 変更後の訂正情報 = JukyushaTeiseiRenrakuhyoTorokuFinder.
                createInstance().editHenkoGoTeiseiJoho(被保険者番号, 履歴番号,
                        異動年月日, 作成年月日, 氏名_性別_生年月日を印字す);
        JukyushaTeiseiRenrakuhyoTorokuFinderResult 受給者訂正情報 = JukyushaTeiseiRenrakuhyoTorokuFinder.
                createInstance().judgeHenkokasho(論理削除フラグ, 受給者子Div, 変更前の訂正情報, 変更後の訂正情報);
        JukyushaIdoRenrakuhyoTorokuEntity 受給者訂正連絡票Entity = new JukyushaIdoRenrakuhyoTorokuEntity();
        if (受給者訂正情報 != null && 受給者訂正情報.get受給者異動送付entity() != null) {
            get受給者訂正連絡票Entity(受給者訂正連絡票Entity, 受給者訂正情報);
            if (受給者訂正情報.get受給者異動送付entity().
                    get広域連合_政令市_保険者番号() != null && !受給者訂正情報.get受給者異動送付entity().
                    get広域連合_政令市_保険者番号().isEmpty()) {
                受給者訂正連絡票Entity.set広域保険者番号(受給者訂正情報.get受給者異動送付entity().
                        get広域連合_政令市_保険者番号().value());
            }
            受給者訂正連絡票Entity.set老人保健市町村番号(受給者訂正情報.get受給者異動送付entity().
                    get老人保健市町村番号());
            受給者訂正連絡票Entity.set老人保健受給者番号(受給者訂正情報.get受給者異動送付entity().
                    get老人保健受給者番号());
            受給者訂正連絡票Entity.set老人保健公費負担者番号(受給者訂正情報.get受給者異動送付entity().
                    get施設所在保険者番号());
            if (null != 受給者訂正情報.get受給者異動送付entity().get軽減率()
                    && !受給者訂正情報.get受給者異動送付entity().get軽減率().isEmpty()) {
                int count = 受給者訂正情報.get受給者異動送付entity().get軽減率().length();
                switch (count) {
                    case INT_1:
                        受給者訂正連絡票Entity.set軽減率(ZERO.concat(ZERO).concat(ZERO).concat(受給者訂正情報.get受給者異動送付entity().get軽減率()));
                        break;
                    case INT_2:
                        受給者訂正連絡票Entity.set軽減率(ZERO.concat(ZERO).concat(受給者訂正情報.get受給者異動送付entity().get軽減率()));
                        break;
                    case INT_3:
                        受給者訂正連絡票Entity.set軽減率(ZERO.concat(受給者訂正情報.get受給者異動送付entity().get軽減率()));
                        break;
                    default:
                        受給者訂正連絡票Entity.set軽減率(受給者訂正情報.get受給者異動送付entity().get軽減率());
                        break;
                }
            }

            if (受給者訂正情報.get受給者異動送付entity().
                    get軽減率適用開始年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                    get軽減率適用開始年月日().isEmpty()) {
                受給者訂正連絡票Entity.set軽減率適用開始年月日(受給者訂正情報.get受給者異動送付entity().
                        get軽減率適用開始年月日());
            }
            if (受給者訂正情報.get受給者異動送付entity().
                    get軽減率適用終了年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                    get軽減率適用終了年月日().isEmpty()) {
                受給者訂正連絡票Entity.set軽減率適用終了年月日(受給者訂正情報.get受給者異動送付entity().
                        get軽減率適用終了年月日());
            }
            if (受給者訂正情報.get小多機能居宅介護利用開始月利用有フラグ() == null) {
                受給者訂正連絡票Entity.set小規模居宅ｻｰﾋﾞｽ利用(RString.EMPTY);
            } else if (!受給者訂正情報.get小多機能居宅介護利用開始月利用有フラグ()) {
                受給者訂正連絡票Entity.set小規模居宅ｻｰﾋﾞｽ利用(ONE);
            } else {
                受給者訂正連絡票Entity.set小規模居宅ｻｰﾋﾞｽ利用(TWO);
            }
            受給者訂正連絡票Entity.set二次予防事業区分(受給者訂正情報.get受給者異動送付entity().
                    get二次予防事業区分コード());
            受給者訂正連絡票Entity.set二次予防有効期間開始年月日(受給者訂正情報.get受給者異動送付entity().
                    get二次予防事業有効期間開始年月日());
            受給者訂正連絡票Entity.set二次予防有効期間終了年月日(受給者訂正情報.get受給者異動送付entity().
                    get二次予防事業有効期間終了年月日());
            受給者訂正連絡票Entity.set申請種別(受給者訂正情報.get受給者異動送付entity().
                    get申請種別コード());
            受給者訂正連絡票Entity.set変更申請中区分(受給者訂正情報.get受給者異動送付entity().
                    get変更申請中区分コード());
            受給者訂正連絡票Entity.set申請年月日(受給者訂正情報.get受給者異動送付entity().
                    get申請年月日());
            受給者訂正連絡票Entity.set国保保険者番号(受給者訂正情報.get受給者異動送付entity().
                    get国民健康保険保険者番号());
            受給者訂正連絡票Entity.set国保被保険者証番号(受給者訂正情報.get受給者異動送付entity().
                    get国民健康保険被保険者証番号());
            受給者訂正連絡票Entity.set国保個人番号(受給者訂正情報.get受給者異動送付entity().
                    get国民健康保険個人番号());
            受給者訂正連絡票Entity.set後期高齢保険者番号(受給者訂正情報.get受給者異動送付entity().
                    get後期高齢者医療保険者番号());
            受給者訂正連絡票Entity.set後期高齢被保険者番号(受給者訂正情報.get受給者異動送付entity().
                    get後期高齢者医療被保険者番号());
            受給者訂正連絡票Entity.set住特対象者区分(受給者訂正情報.get受給者異動送付entity().
                    get住所地特例対象者区分コード());
            受給者訂正連絡票Entity.set住特施設所在保険者番号(受給者訂正情報.get受給者異動送付entity().
                    get施設所在保険者番号());
            受給者訂正連絡票Entity = set二割負担適用終了年月日(受給者訂正連絡票Entity, 受給者訂正情報);
            受給者訂正連絡票Entity.set訂正年月日(受給者訂正情報.get受給者異動送付entity().
                    get訂正年月日());
            受給者訂正連絡票Entity.set訂正区分コード(受給者訂正情報.get受給者異動送付entity().
                    get訂正区分コード());
        }
        JukyushaTeiseiRenrakuhyoPrintService printService = new JukyushaTeiseiRenrakuhyoPrintService();
        return printService.printSingle(受給者訂正連絡票Entity);
    }

    private JukyushaIdoRenrakuhyoTorokuEntity set二割負担適用終了年月日(
            JukyushaIdoRenrakuhyoTorokuEntity 受給者訂正連絡票Entity,
            JukyushaTeiseiRenrakuhyoTorokuFinderResult 受給者訂正情報) {
        if (受給者訂正情報.get受給者異動送付entity().
                get利用者負担割合有効終了日() != null && !受給者訂正情報.get受給者異動送付entity().
                get利用者負担割合有効終了日().isEmpty()) {
            受給者訂正連絡票Entity.set二割負担適用終了年月日(受給者訂正情報.get受給者異動送付entity().
                    get利用者負担割合有効終了日());
        }

        return 受給者訂正連絡票Entity;
    }

    private int get履歴番号(RString 処理モード, int 履歴番号) {
        if (照会モード.equals(処理モード)) {
            return 履歴番号;
        }
        return 履歴番号 + 1;
    }

    private JukyushaIdoRenrakuhyo get登録用Entity(
            JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div,
            JukyushaIdoRenrakuhyo 訂正対象データ) {
        受給者訂正連絡票登録画面Div = get登録用Entity_one(受給者訂正連絡票登録画面Div, 訂正対象データ);

        受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                createBuilderForEdit().set履歴番号(訂正対象データ.get履歴番号() + 1).build();
        if (!RString.isNullOrEmpty(訂正対象データ.get特定入所者介護サービス区分コード())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get特定入所者介護サービス区分コード())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set特定入所者介護サービス区分コード(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get住所地特例対象者区分コード())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get住所地特例対象者区分コード())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set住所地特例対象者区分コード(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get施設所在保険者番号())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get施設所在保険者番号())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set施設所在保険者番号(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get住所地特例適用開始日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get住所地特例適用開始日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set住所地特例適用開始日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get住所地特例適用終了日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get住所地特例適用終了日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set住所地特例適用終了日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get居宅費_新１_負担限度額())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get居宅費_新１_負担限度額())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set居宅費_新１_負担限度額(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get居宅費_新２_負担限度額())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get居宅費_新２_負担限度額())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set居宅費_新２_負担限度額(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get居宅費_新３_負担限度額())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get居宅費_新３_負担限度額())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set居宅費_新３_負担限度額(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get利用者負担割合有効開始日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get利用者負担割合有効開始日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set利用者負担割合有効開始日(半角アスタリスク).build();
        }
        return 受給者訂正連絡票登録画面Div;
    }

    private JukyushaIdoRenrakuhyo get登録用Entity_one(
            JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div,
            JukyushaIdoRenrakuhyo 訂正対象データ) {
        if (!RString.isNullOrEmpty(訂正対象データ.get償還払化開始年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get償還払化開始年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set償還払化開始年月日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get償還払化終了年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get償還払化終了年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set償還払化終了年月日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get給付率引下げ開始年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get給付率引下げ開始年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set給付率引下げ開始年月日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get償還払化終了年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get償還払化終了年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set償還払化終了年月日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get利用者負担区分コード())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get利用者負担区分コード())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set利用者負担区分コード(半角アスタリスク).build();
        }
        if (訂正対象データ.get給付率() != null && 受給者訂正連絡票登録画面Div.get給付率() == null) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set給付率(NUM_ZERO).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get適用開始年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get適用開始年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set適用開始年月日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get適用終了年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get適用終了年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set適用終了年月日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get標準負担区分コード())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get標準負担区分コード())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set標準負担区分コード(半角アスタリスク).build();
        }
        return get登録用Entity_two(受給者訂正連絡票登録画面Div, 訂正対象データ);
    }

    private JukyushaIdoRenrakuhyo get登録用Entity_two(
            JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div,
            JukyushaIdoRenrakuhyo 訂正対象データ) {
        if (!RString.isNullOrEmpty(訂正対象データ.get訪問通所サービス上限管理適用期間終了年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get訪問通所サービス上限管理適用期間終了年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set訪問通所サービス上限管理適用期間終了年月日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get認定有効期間終了年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get認定有効期間終了年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set認定有効期間終了年月日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get居宅サービス計画作成区分コード())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get居宅サービス計画作成区分コード())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set居宅サービス計画作成区分コード(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get居宅介護支援事業所番号())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get居宅介護支援事業所番号())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set居宅介護支援事業所番号(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get居宅サービス計画適用開始年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get居宅サービス計画適用開始年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set居宅サービス計画適用開始年月日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get居宅サービス計画適用終了年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get居宅サービス計画適用終了年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set居宅サービス計画適用終了年月日(半角アスタリスク).build();
        }
        if (訂正対象データ.get負担額() != null && 受給者訂正連絡票登録画面Div.get負担額() == null) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set負担額(NUM_ZERO).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get負担額適用開始年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get負担額適用開始年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set負担額適用開始年月日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get負担限度額適用終了年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get負担限度額適用終了年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set負担限度額適用終了年月日(半角アスタリスク).build();
        }

        return get登録用Entity_three(受給者訂正連絡票登録画面Div, 訂正対象データ);
    }

    private JukyushaIdoRenrakuhyo get登録用Entity_three(
            JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div,
            JukyushaIdoRenrakuhyo 訂正対象データ) {
        if (!RString.isNullOrEmpty(訂正対象データ.is課税層の特例減額措置対象フラグ())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.is課税層の特例減額措置対象フラグ())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set課税層の特例減額措置対象フラグ(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.is課税層の特例減額措置対象フラグ())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.is課税層の特例減額措置対象フラグ())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set課税層の特例減額措置対象フラグ(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get食費負担限度額())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get食費負担限度額())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set食費負担限度額(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get居住費ユニット型個室負担限度額())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get居住費ユニット型個室負担限度額())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set居住費ユニット型個室負担限度額(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get居住費ユニット型準個室負担限度額())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get居住費ユニット型準個室負担限度額())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set居住費ユニット型準個室負担限度額(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get居住費従来型個室老健療養等負担限度額())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get居住費従来型個室老健療養等負担限度額())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set居住費従来型個室老健療養等負担限度額(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get居住費従来型個室特養等負担限度額())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get居住費従来型個室特養等負担限度額())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set居住費従来型個室特養等負担限度額(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get居住費多床室負担限度額())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get居住費多床室負担限度額())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set居住費多床室負担限度額(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get負担限度額適用開始年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get負担限度額適用開始年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set負担限度額適用開始年月日(半角アスタリスク).build();
        }
        return get登録用Entity_four(受給者訂正連絡票登録画面Div, 訂正対象データ);
    }

    private JukyushaIdoRenrakuhyo get登録用Entity_four(
            JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div,
            JukyushaIdoRenrakuhyo 訂正対象データ) {
        if (!RString.isNullOrEmpty(訂正対象データ.get負担額適用終了年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get負担額適用終了年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set負担額適用終了年月日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get軽減率())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get軽減率())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set軽減率(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get軽減率適用開始年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get軽減率適用開始年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set軽減率適用開始年月日(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get軽減率適用終了年月日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get軽減率適用終了年月日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set軽減率適用終了年月日(半角アスタリスク).build();
        }
        return get登録用Entity_five(受給者訂正連絡票登録画面Div, 訂正対象データ);
    }

    private JukyushaIdoRenrakuhyo get登録用Entity_five(
            JukyushaIdoRenrakuhyo 受給者訂正連絡票登録画面Div,
            JukyushaIdoRenrakuhyo 訂正対象データ) {
        if (!RString.isNullOrEmpty(訂正対象データ.get後期高齢者医療保険者番号())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get後期高齢者医療保険者番号())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set後期高齢者医療保険者番号(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get後期高齢者医療被保険者番号())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get後期高齢者医療被保険者番号())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set後期高齢者医療被保険者番号(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get国民健康保険保険者番号())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get国民健康保険保険者番号())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set国民健康保険保険者番号(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get国民健康保険個人番号())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get国民健康保険個人番号())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set国民健康保険個人番号(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get国民健康保険被保険者証番号())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get国民健康保険被保険者証番号())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set国民健康保険被保険者証番号(半角アスタリスク).build();
        }
        if (!RString.isNullOrEmpty(訂正対象データ.get利用者負担割合有効終了日())
                && RString.isNullOrEmpty(受給者訂正連絡票登録画面Div.get利用者負担割合有効終了日())) {
            受給者訂正連絡票登録画面Div = 受給者訂正連絡票登録画面Div.
                    createBuilderForEdit().set利用者負担割合有効終了日(半角アスタリスク).build();
        }
        return 受給者訂正連絡票登録画面Div;
    }

    private void get受給者訂正連絡票Entity(
            JukyushaIdoRenrakuhyoTorokuEntity 受給者訂正連絡票Entity,
            JukyushaTeiseiRenrakuhyoTorokuFinderResult 受給者訂正情報) {
        受給者訂正連絡票Entity.set性別コード(受給者訂正情報.get受給者異動送付entity().get性別コード());
        受給者訂正連絡票Entity.set作成年月日(受給者訂正情報.get作成年月日());
        受給者訂正連絡票Entity.set証記載保険者番号(受給者訂正情報.get受給者異動送付entity().get証記載保険者番号().value());
        受給者訂正連絡票Entity.set被保険者番号(受給者訂正情報.get受給者異動送付entity().get被保険者番号().value());
        受給者訂正連絡票Entity.set異動年月日(受給者訂正情報.get受給者異動送付entity().get異動年月日());
        受給者訂正連絡票Entity.set異動区分(受給者訂正情報.get受給者異動送付entity().get異動区分コード());
        受給者訂正連絡票Entity.set氏名性別生年月日を印字する(受給者訂正情報.get氏名_性別_生年月日を印字する());
        受給者訂正連絡票Entity.set異動事由(受給者訂正情報.get受給者異動送付entity().get受給者異動事由());
        受給者訂正連絡票Entity.set被保険者氏名カナ(受給者訂正情報.get受給者異動送付entity().get被保険者氏名カナ());
        受給者訂正連絡票Entity.set生年月日(受給者訂正情報.get受給者異動送付entity().get生年月日());
        受給者訂正連絡票Entity.set資格取得年月日(受給者訂正情報.get受給者異動送付entity().get資格取得年月日());
        受給者訂正連絡票Entity.set資格喪失年月日(受給者訂正情報.get受給者異動送付entity().get資格喪失年月日());
        受給者訂正連絡票Entity.set資格喪失年月日(受給者訂正情報.get受給者異動送付entity().get資格喪失年月日());
        受給者訂正連絡票Entity.setみなし区分(受給者訂正情報.get受給者異動送付entity().getみなし要介護状態区分コード());
        受給者訂正連絡票Entity.set要介護状態区分(受給者訂正情報.get受給者異動送付entity().get要介護状態区分コード());
        受給者訂正連絡票Entity.set有効期間開始年月日(受給者訂正情報.get受給者異動送付entity().get認定有効期間開始年月日());
        if (受給者訂正情報.get受給者異動送付entity().get認定有効期間終了年月日() != null
                && !受給者訂正情報.get受給者異動送付entity().get認定有効期間終了年月日().isEmpty()) {
            受給者訂正連絡票Entity.set有効期間終了年月日(受給者訂正情報.
                    get受給者異動送付entity().get認定有効期間終了年月日());
        }
        RString 支給限度基準額1 = new RString(受給者訂正情報.get受給者異動送付entity().
                get訪問通所サービス支給限度基準額());
        int countSuu = 支給限度基準額1.length();
        if (ZERO.equals(支給限度基準額1)) {
            受給者訂正連絡票Entity.set支給限度基準額1(支給限度基準額1);
        } else if (INT_1 == countSuu) {
            受給者訂正連絡票Entity.set支給限度基準額1(空KEY.concat(空KEY).concat(空KEY).concat(空KEY).concat(空KEY).concat(支給限度基準額1));
        } else if (INT_2 == countSuu) {
            受給者訂正連絡票Entity.set支給限度基準額1(空KEY.concat(空KEY).concat(空KEY).concat(空KEY).concat(支給限度基準額1));
        } else if (INT_3 == countSuu) {
            受給者訂正連絡票Entity.set支給限度基準額1(空KEY.concat(空KEY).concat(空KEY).concat(支給限度基準額1));
        } else if (INT_4 == countSuu) {
            受給者訂正連絡票Entity.set支給限度基準額1(空KEY.concat(空KEY).concat(支給限度基準額1));
        } else if (INT_5 == countSuu) {
            受給者訂正連絡票Entity.set支給限度基準額1(空KEY.concat(支給限度基準額1));
        } else {
            受給者訂正連絡票Entity.set支給限度基準額1(支給限度基準額1);
        }
        受給者訂正連絡票Entity.set上限管理適用開始年月日１(受給者訂正情報.get受給者異動送付entity().
                get訪問通所サービス上限管理適用期間開始年月日());
        if (受給者訂正情報.get受給者異動送付entity().
                get訪問通所サービス上限管理適用期間終了年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                get訪問通所サービス上限管理適用期間終了年月日().isEmpty()) {
            受給者訂正連絡票Entity.set上限管理終了年月日１(受給者訂正情報.get受給者異動送付entity().
                    get訪問通所サービス上限管理適用期間終了年月日());
        }
        受給者訂正連絡票Entity.set上限管理終了年月日２(受給者訂正情報.get受給者異動送付entity().
                get短期入所サービス上限管理適用期間終了年月日());

        受給者訂正連絡票Entity.set上限管理適用開始年月日２(受給者訂正情報.get受給者異動送付entity().
                get短期入所サービス上限管理適用期間開始年月日());
        if (受給者訂正情報.get受給者異動送付entity().
                get給付率引下げ開始年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                get給付率引下げ開始年月日().isEmpty()) {
            受給者訂正連絡票Entity.set給付率引下げ適用開始年月日(受給者訂正情報.get受給者異動送付entity().
                    get給付率引下げ開始年月日());
        }
        if (受給者訂正情報.get受給者異動送付entity().
                get給付率引下げ終了年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                get給付率引下げ終了年月日().isEmpty()) {
            受給者訂正連絡票Entity.set給付率引下げ適用終了年月日(受給者訂正情報.get受給者異動送付entity().
                    get給付率引下げ終了年月日());
        }
        受給者訂正連絡票Entity.set認定申請中区分(受給者訂正情報.get受給者異動送付entity().
                get特定入所者認定申請中区分コード());
        受給者訂正連絡票Entity.setｻｰﾋﾞｽ区分(受給者訂正情報.get受給者異動送付entity().
                get特定入所者介護サービス区分コード());
        受給者訂正連絡票Entity.set特例減額措置対象(受給者訂正情報.get受給者異動送付entity().
                is課税層の特例減額措置対象フラグ());
        受給者訂正連絡票Entity.set食費負担限度額(受給者訂正情報.get受給者異動送付entity().
                get食費負担限度額());
        受給者訂正連絡票Entity.setﾕﾆｯﾄ型個室(受給者訂正情報.get受給者異動送付entity().
                get居住費ユニット型個室負担限度額());
        受給者訂正連絡票Entity.setﾕﾆｯﾄ型準個室(受給者訂正情報.get受給者異動送付entity().
                get居住費ユニット型準個室負担限度額());
        受給者訂正連絡票Entity.set従来型個室特(受給者訂正情報.get受給者異動送付entity().
                get居住費従来型個室特養等負担限度額());
        受給者訂正連絡票Entity.set従来型個室老療(受給者訂正情報.get受給者異動送付entity().
                get居住費従来型個室老健療養等負担限度額());
        受給者訂正連絡票Entity.set多床室(受給者訂正情報.get受給者異動送付entity().
                get居住費多床室負担限度額());
        受給者訂正連絡票Entity.set新１(受給者訂正情報.get受給者異動送付entity().
                get居宅費_新１_負担限度額());
        受給者訂正連絡票Entity.set新２(受給者訂正情報.get受給者異動送付entity().
                get居宅費_新２_負担限度額());
        受給者訂正連絡票Entity.set新３(受給者訂正情報.get受給者異動送付entity().
                get居宅費_新３_負担限度額());
        if (受給者訂正情報.get受給者異動送付entity().
                get負担限度額適用開始年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                get負担限度額適用開始年月日().isEmpty()) {
            受給者訂正連絡票Entity.set特定入所者適用開始年月日(受給者訂正情報.get受給者異動送付entity().
                    get負担限度額適用開始年月日());
        }
        if (受給者訂正情報.get受給者異動送付entity().
                get負担限度額適用終了年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                get負担限度額適用終了年月日().isEmpty()) {
            受給者訂正連絡票Entity.set特定入所者適用終了年月日(受給者訂正情報.get受給者異動送付entity().
                    get負担限度額適用終了年月日());
        }
        get受給者訂正連絡票Entity_One(受給者訂正連絡票Entity, 受給者訂正情報);
    }

    private void get受給者訂正連絡票Entity_One(
            JukyushaIdoRenrakuhyoTorokuEntity 受給者訂正連絡票Entity,
            JukyushaTeiseiRenrakuhyoTorokuFinderResult 受給者訂正情報) {
        RString 支給限度基準額2 = new RString(受給者訂正情報.get受給者異動送付entity().
                get短期入所サービス支給限度基準額());
        int countSuu2 = 支給限度基準額2.length();
        if (ZERO.equals(支給限度基準額2)) {
            受給者訂正連絡票Entity.set支給限度基準額２(支給限度基準額2);
        } else if (INT_1 == countSuu2) {
            受給者訂正連絡票Entity.set支給限度基準額２(空KEY.concat(空KEY).concat(支給限度基準額2));
        } else if (INT_2 == countSuu2) {
            受給者訂正連絡票Entity.set支給限度基準額２(空KEY.concat(支給限度基準額2));
        } else {
            受給者訂正連絡票Entity.set支給限度基準額２(支給限度基準額2);
        }
        受給者訂正連絡票Entity.set計画作成区分(受給者訂正情報.get受給者異動送付entity().
                get居宅サービス計画作成区分コード());
        受給者訂正連絡票Entity.set居宅支援事業者番号(受給者訂正情報.get受給者異動送付entity().
                get居宅介護支援事業所番号());
        if (受給者訂正情報.get受給者異動送付entity().get居宅サービス計画適用開始年月日() != null
                && !受給者訂正情報.get受給者異動送付entity().get居宅サービス計画適用開始年月日().isEmpty()) {
            受給者訂正連絡票Entity.set居宅適用開始年月日(受給者訂正情報.
                    get受給者異動送付entity().get居宅サービス計画適用開始年月日());
        }
        if (受給者訂正情報.get受給者異動送付entity().get居宅サービス計画適用終了年月日() != null
                && !受給者訂正情報.get受給者異動送付entity().get居宅サービス計画適用終了年月日().isEmpty()) {
            受給者訂正連絡票Entity.set居宅適用終了年月日(受給者訂正情報.
                    get受給者異動送付entity().get居宅サービス計画適用終了年月日());
        }
        受給者訂正連絡票Entity.set減免申請中区分(受給者訂正情報.get受給者異動送付entity().
                get減免申請中区分コード());
        受給者訂正連絡票Entity.set利用者負担区分(受給者訂正情報.get受給者異動送付entity().
                get利用者負担区分コード());
        if (受給者訂正情報.get受給者異動送付entity().
                get給付率() != null) {
            受給者訂正連絡票Entity.set利用給付率(new RString(受給者訂正情報.get受給者異動送付entity().
                    get給付率().toString()));
        }
        if (受給者訂正情報.get受給者異動送付entity().
                get適用開始年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                get適用開始年月日().isEmpty()) {
            受給者訂正連絡票Entity.set利用適用開始年月日(受給者訂正情報.get受給者異動送付entity().
                    get適用開始年月日());
        }
        if (受給者訂正情報.get受給者異動送付entity().
                get適用開始年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                get適用開始年月日().isEmpty()) {
            受給者訂正連絡票Entity.set利用適用終了年月日(受給者訂正情報.get受給者異動送付entity().
                    get適用終了年月日());
        }
        受給者訂正連絡票Entity.set標準負担区分(受給者訂正情報.get受給者異動送付entity().
                get標準負担区分コード());
        if (受給者訂正情報.get受給者異動送付entity().
                get負担額() != null) {
            受給者訂正連絡票Entity.set標準負担額(new RString(受給者訂正情報.
                    get受給者異動送付entity().get負担額().toString()));
        }
        if (受給者訂正情報.get受給者異動送付entity().
                get償還払化終了年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                get償還払化終了年月日().isEmpty()) {
            受給者訂正連絡票Entity.set償還払化適用終了年月日(受給者訂正情報.get受給者異動送付entity().
                    get償還払化終了年月日());
        }
        get受給者訂正連絡票Entity_Two(受給者訂正連絡票Entity, 受給者訂正情報);
    }

    private void get受給者訂正連絡票Entity_Two(
            JukyushaIdoRenrakuhyoTorokuEntity 受給者訂正連絡票Entity,
            JukyushaTeiseiRenrakuhyoTorokuFinderResult 受給者訂正情報) {
        if (受給者訂正情報.get受給者異動送付entity().
                get住所地特例適用開始日() != null && !受給者訂正情報.get受給者異動送付entity().
                get住所地特例適用開始日().isEmpty()) {
            受給者訂正連絡票Entity.set住特適用開始年月日(受給者訂正情報.get受給者異動送付entity().
                    get住所地特例適用開始日());
        }
        if (受給者訂正情報.get受給者異動送付entity().
                get住所地特例適用終了日() != null && !受給者訂正情報.get受給者異動送付entity().
                get住所地特例適用終了日().isEmpty()) {
            受給者訂正連絡票Entity.set住特適用終了年月日(受給者訂正情報.get受給者異動送付entity().
                    get住所地特例適用終了日());
        }
        受給者訂正連絡票Entity.set送付年月(受給者訂正情報.get受給者異動送付entity().
                get送付年月());
        if (受給者訂正情報.get受給者異動送付entity().
                get利用者負担割合有効開始日() != null && !受給者訂正情報.get受給者異動送付entity().
                get利用者負担割合有効開始日().isEmpty()) {
            受給者訂正連絡票Entity.set二割負担適用開始年月日(受給者訂正情報.get受給者異動送付entity().
                    get利用者負担割合有効開始日());
        }
        if (受給者訂正情報.get受給者異動送付entity().
                get負担額適用開始年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                get負担額適用開始年月日().isEmpty()) {
            受給者訂正連絡票Entity.set標準適用開始年月日(受給者訂正情報.get受給者異動送付entity().
                    get負担額適用開始年月日());
        }
        if (受給者訂正情報.get受給者異動送付entity().
                get負担額適用終了年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                get負担額適用終了年月日().isEmpty()) {
            受給者訂正連絡票Entity.set標準適用終了年月日(受給者訂正情報.get受給者異動送付entity().
                    get負担額適用終了年月日());
        }
        if (受給者訂正情報.get公費負担上限額減額有フラグ() == null) {
            受給者訂正連絡票Entity.set公費負担上限額減額(RString.EMPTY);
        } else if (!受給者訂正情報.get公費負担上限額減額有フラグ()) {
            受給者訂正連絡票Entity.set公費負担上限額減額(ONE);
        } else {
            受給者訂正連絡票Entity.set公費負担上限額減額(TWO);
        }
        if (受給者訂正情報.get受給者異動送付entity().
                get償還払化開始年月日() != null && !受給者訂正情報.get受給者異動送付entity().
                get償還払化開始年月日().isEmpty()) {
            受給者訂正連絡票Entity.set償還払化適用開始年月日(受給者訂正情報.get受給者異動送付entity().
                    get償還払化開始年月日());
        }
    }

    /**
     * 「受給者異動連絡票を発行する」チェックボックスの状態。
     *
     * @return チェック状態
     */
    public List<RString> getチェックボックス状態() {
        return div.getOutputJukyushaIdoRenrakuhyo().getChkJukyushaTeiseiRearakuhyoHakkou().getSelectedKeys();
    }

    /**
     * 受給者異動連絡票内容変更状態です。
     *
     * @param 変更前entity JukyushaIdoRenrakuhyo
     * @param 変更後entity JukyushaIdoRenrakuhyo
     * @return boolean
     */
    public boolean is受給者異動連絡票内容変更状態(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is基本比較データ(変更前entity, 変更後entity)
                || is要介護認定エリア(変更前entity, 変更後entity)
                || is支給限度基準額エリア(変更前entity, 変更後entity)
                || is居宅サービス計画エリア(変更前entity, 変更後entity)
                || is住所地特例エリア(変更前entity, 変更後entity)
                || is減免_減額エリア(変更前entity, 変更後entity)
                || is後期高齢_国保エリア(変更前entity, 変更後entity)
                || is給付制限エリア(変更前entity, 変更後entity)
                || is殘りの比較データ(変更前entity, 変更後entity);
    }

    private boolean is基本比較データ(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更年月日(変更前entity.get異動年月日(), 変更後entity.get異動年月日())
                || is比較変更文字列(変更前entity.get異動区分コード(), 変更後entity.get異動区分コード())
                || is比較変更文字列(変更前entity.get受給者異動事由(), 変更後entity.get受給者異動事由())
                || is比較変更文字列(変更前entity.get被保険者氏名カナ(), 変更後entity.get被保険者氏名カナ())
                || is比較変更年月日(変更前entity.get生年月日(), 変更後entity.get生年月日())
                || is比較変更文字列(変更前entity.get性別コード(), 変更後entity.get性別コード())
                || is比較変更年月日(変更前entity.get資格取得年月日(), 変更後entity.get資格取得年月日())
                || is比較変更年月日(変更前entity.get資格喪失年月日(), 変更後entity.get資格喪失年月日())
                || is比較変更文字列(変更前entity.get証記載保険者番号().value(), 変更後entity.get証記載保険者番号().value())
                || is比較広域保険者番号(変更前entity.get広域連合_政令市_保険者番号(),
                        変更後entity.get広域連合_政令市_保険者番号())
                || is比較変更年月(変更前entity.get送付年月(), 変更後entity.get送付年月())
                || is比較変更年月日(変更前entity.get訂正年月日(), 変更後entity.get訂正年月日())
                || is比較変更文字列(変更前entity.get訂正区分コード(), 変更後entity.get訂正区分コード());
    }

    private boolean is要介護認定エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更年月日(変更前entity.get申請年月日(), 変更後entity.get申請年月日())
                || is比較変更文字列(変更前entity.get申請種別コード(), 変更後entity.get申請種別コード())
                || is比較変更文字列(変更前entity.get要介護状態区分コード(),
                        変更後entity.get要介護状態区分コード())
                || is比較変更文字列(変更前entity.get変更申請中区分コード(), 変更後entity.get変更申請中区分コード())
                || is比較変更年月日(変更前entity.get認定有効期間開始年月日(), 変更後entity.get認定有効期間開始年月日())
                || is比較変更文字列(変更前entity.get認定有効期間終了年月日(), 変更後entity.get認定有効期間終了年月日())
                || is比較変更文字列(変更前entity.getみなし要介護状態区分コード(),
                        変更後entity.getみなし要介護状態区分コード());
    }

    private boolean is支給限度基準額エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return 変更前entity.get訪問通所サービス支給限度基準額() != 変更後entity.get訪問通所サービス支給限度基準額()
                || is比較変更年月日(変更前entity.get訪問通所サービス上限管理適用期間開始年月日(),
                        変更後entity.get訪問通所サービス上限管理適用期間開始年月日())
                || is比較変更文字列(変更前entity.get訪問通所サービス上限管理適用期間終了年月日(),
                        変更後entity.get訪問通所サービス上限管理適用期間終了年月日())
                || 変更前entity.get短期入所サービス支給限度基準額() != 変更後entity.get短期入所サービス支給限度基準額()
                || is比較変更年月日(変更前entity.get短期入所サービス上限管理適用期間開始年月日(),
                        変更後entity.get短期入所サービス上限管理適用期間開始年月日())
                || is比較変更年月日(変更前entity.get短期入所サービス上限管理適用期間終了年月日(),
                        変更後entity.get短期入所サービス上限管理適用期間終了年月日());
    }

    private boolean is居宅サービス計画エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更文字列(変更前entity.get居宅サービス計画作成区分コード(),
                変更後entity.get居宅サービス計画作成区分コード())
                || is比較変更文字列(変更前entity.get居宅介護支援事業所番号(), 変更後entity.get居宅介護支援事業所番号())
                || is比較変更文字列(変更前entity.get居宅サービス計画適用開始年月日(),
                        変更後entity.get居宅サービス計画適用開始年月日())
                || is比較変更文字列(変更前entity.get居宅サービス計画適用終了年月日(),
                        変更後entity.get居宅サービス計画適用終了年月日())
                || 変更前entity.is小多機能居宅介護利用開始月利用有フラグ()
                != 変更後entity.is小多機能居宅介護利用開始月利用有フラグ();
    }

    private boolean is住所地特例エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更文字列(変更前entity.get住所地特例対象者区分コード(),
                変更後entity.get住所地特例対象者区分コード())
                || is比較変更文字列(変更前entity.get住所地特例適用開始日(), 変更後entity.get住所地特例適用開始日())
                || is比較変更文字列(変更前entity.get住所地特例適用終了日(), 変更後entity.get住所地特例適用終了日())
                || is比較変更文字列(変更前entity.get施設所在保険者番号(), 変更後entity.get施設所在保険者番号());
    }

    private boolean is減免_減額エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更文字列(変更前entity.get減免申請中区分コード(), 変更後entity.get減免申請中区分コード())
                || is比較変更文字列(変更前entity.get利用者負担区分コード(), 変更後entity.get利用者負担区分コード())
                || is比較変更数字(変更前entity.get給付率(), 変更後entity.get給付率())
                || is比較変更文字列(変更前entity.get適用開始年月日(), 変更後entity.get適用開始年月日())
                || is比較変更文字列(変更前entity.get適用終了年月日(), 変更後entity.get適用終了年月日())
                || is比較変更文字列(変更前entity.get軽減率(), 変更後entity.get軽減率())
                || is比較変更文字列(変更前entity.get軽減率適用開始年月日(), 変更後entity.get軽減率適用開始年月日())
                || is比較変更文字列(変更前entity.get軽減率適用終了年月日(), 変更後entity.get軽減率適用終了年月日())
                || is比較変更文字列(変更前entity.get標準負担区分コード(), 変更後entity.get標準負担区分コード())
                || is比較変更数字(変更前entity.get負担額(), 変更後entity.get負担額())
                || is比較変更文字列(変更前entity.get負担額適用開始年月日(), 変更後entity.get負担額適用開始年月日())
                || is比較変更文字列(変更前entity.get負担額適用終了年月日(), 変更後entity.get負担額適用終了年月日())
                || is比較変更文字列(変更前entity.get特定入所者認定申請中区分コード(),
                        変更後entity.get特定入所者認定申請中区分コード())
                || is比較変更文字列(変更前entity.get特定入所者介護サービス区分コード(),
                        変更後entity.get特定入所者介護サービス区分コード())
                || is比較変更文字列(変更前entity.is課税層の特例減額措置対象フラグ(),
                        変更後entity.is課税層の特例減額措置対象フラグ())
                || is減額エリア(変更前entity, 変更後entity);
    }

    private boolean is減額エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更文字列(変更前entity.get食費負担限度額(), 変更後entity.get食費負担限度額())
                || is比較変更文字列(変更前entity.get負担限度額適用開始年月日(), 変更後entity.get負担限度額適用開始年月日())
                || is比較変更文字列(変更前entity.get負担限度額適用終了年月日(), 変更後entity.get負担限度額適用終了年月日())
                || is比較変更文字列(変更前entity.get居住費従来型個室特養等負担限度額(),
                        変更後entity.get居住費従来型個室特養等負担限度額())
                || is比較変更文字列(変更前entity.get居住費従来型個室老健療養等負担限度額(),
                        変更後entity.get居住費従来型個室老健療養等負担限度額())
                || is比較変更文字列(変更前entity.get居住費多床室負担限度額(), 変更後entity.get居住費多床室負担限度額())
                || is比較変更文字列(変更前entity.get居住費ユニット型個室負担限度額(),
                        変更後entity.get居住費ユニット型個室負担限度額())
                || is比較変更文字列(変更前entity.get居住費ユニット型準個室負担限度額(),
                        変更後entity.get居住費ユニット型準個室負担限度額())
                || is比較変更文字列(変更前entity.get居宅費_新１_負担限度額(),
                        変更後entity.get居宅費_新１_負担限度額())
                || is比較変更文字列(変更前entity.get居宅費_新２_負担限度額(),
                        変更後entity.get居宅費_新２_負担限度額())
                || is比較変更文字列(変更前entity.get居宅費_新３_負担限度額(),
                        変更後entity.get居宅費_新３_負担限度額());
    }

    private boolean is後期高齢_国保エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更文字列(変更前entity.get後期高齢者医療保険者番号(), 変更後entity.get後期高齢者医療保険者番号())
                || is比較変更文字列(変更前entity.get後期高齢者医療被保険者番号(),
                        変更後entity.get後期高齢者医療被保険者番号())
                || is比較変更文字列(変更前entity.get後期高齢者医療被保険者番号(),
                        変更後entity.get後期高齢者医療被保険者番号())
                || is比較変更文字列(変更前entity.get国民健康保険保険者番号(),
                        変更後entity.get国民健康保険保険者番号())
                || is比較変更文字列(変更前entity.get国民健康保険被保険者証番号(),
                        変更後entity.get国民健康保険被保険者証番号())
                || is比較変更文字列(変更前entity.get国民健康保険個人番号(), 変更後entity.get国民健康保険個人番号());
    }

    private boolean is給付制限エリア(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return 変更前entity.is公費負担上限額減額有フラグ() != 変更後entity.is公費負担上限額減額有フラグ()
                || is比較変更文字列(変更前entity.get償還払化開始年月日(), 変更後entity.get償還払化開始年月日())
                || is比較変更文字列(変更前entity.get償還払化終了年月日(), 変更後entity.get償還払化終了年月日())
                || is比較変更文字列(変更前entity.get給付率引下げ開始年月日(), 変更後entity.get給付率引下げ開始年月日())
                || is比較変更文字列(変更前entity.get給付率引下げ終了年月日(), 変更後entity.get給付率引下げ終了年月日());
    }

    private boolean is殘りの比較データ(
            JukyushaIdoRenrakuhyo 変更前entity,
            JukyushaIdoRenrakuhyo 変更後entity) {
        return is比較変更文字列(変更前entity.get利用者負担割合有効開始日(), 変更後entity.get利用者負担割合有効開始日())
                || is比較変更文字列(変更前entity.get利用者負担割合有効終了日(), 変更後entity.get利用者負担割合有効終了日())
                || is比較変更文字列(変更前entity.get利用者負担割合有効終了日(), 変更後entity.get利用者負担割合有効終了日())
                || is比較変更文字列(変更前entity.get二次予防事業区分コード(), 変更後entity.get二次予防事業区分コード())
                || is比較変更年月日(変更前entity.get二次予防事業有効期間開始年月日(),
                        変更後entity.get二次予防事業有効期間開始年月日())
                || is比較変更年月日(変更前entity.get二次予防事業有効期間終了年月日(),
                        変更後entity.get二次予防事業有効期間終了年月日())
                || is比較変更文字列(変更前entity.get老人保健市町村番号(), 変更後entity.get老人保健市町村番号())
                || is比較変更文字列(変更前entity.get老人保健受給者番号(), 変更後entity.get老人保健受給者番号())
                || is比較変更文字列(変更前entity.get公費負担者番号(), 変更後entity.get公費負担者番号());
    }

    private boolean is比較変更文字列(RString s1, RString s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較変更年月日(FlexibleDate s1, FlexibleDate s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較変更年月(FlexibleYearMonth s1, FlexibleYearMonth s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較広域保険者番号(ShoKisaiHokenshaNo s1, ShoKisaiHokenshaNo s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較変更数字(Decimal s1, Decimal s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }
}
