/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0260012;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoKihonSofu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoKogakuSofu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoShokanSofu;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyoutuuEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TeiseiKubunCode;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260012.KyodoIdoRenrakuhyoHenkoMainDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kyodoshoriyojukyushaidorenrakuhyo.KyodoshoriyoJukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.service.core.kyodoshoriyojukyushateiseirenrakuhyotoroku.KyodoshoriyoJukyushaTeiseiRenrakuhyoToroku;
import jp.co.ndensan.reams.db.dbc.service.report.kyodoshorijukyushateiseirenrakuhyo.KyodoShoriJukyushaTeiseiRenrakuhyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 共同処理用受給者訂正連絡票登録のハンドラクラスです。
 *
 * @reamsid_L DBC-1951-020 wangkanglei
 */
public class KyodoIdoRenrakuhyoHenkoMainHandler {

    private final KyodoIdoRenrakuhyoHenkoMainDiv div;
    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private static final RString 業務固有の識別情報名称 = new RString("業務固有の識別情報");
    private static final Code 業務固有 = new Code("0003");
    private static final RString 連絡票を保存 = new RString("btnSave");
    private static final RString 訂正モード = new RString("訂正");
    private static final RString 削除モード = new RString("削除");
    private static final RString 完了メッセージメイン = new RString("共同処理用受給者訂正連絡票の登録が完了しました。");
    private static final RString チェックボックス_KEY = new RString("key0");
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final RString 修正KEY = new RString("修正");
    private static final RString 削除KEY = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public KyodoIdoRenrakuhyoHenkoMainHandler(KyodoIdoRenrakuhyoHenkoMainDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     * @return ハンドラ
     */
    public static KyodoIdoRenrakuhyoHenkoMainHandler of(KyodoIdoRenrakuhyoHenkoMainDiv div) {
        return new KyodoIdoRenrakuhyoHenkoMainHandler(div);
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 FlexibleDate
     * @param 論理削除フラグ boolean
     * @param 対象年月 FlexibleYearMonth
     * @param 識別コード ShikibetsuCode
     * @return entity 共同処理用受給者異動情報Entity
     */
    public KyodoshoriyoJukyushaIdoRenrakuhyoParam initialize(HihokenshaNo 被保険者番号, FlexibleDate 異動日, boolean 論理削除フラグ,
            FlexibleYearMonth 対象年月, ShikibetsuCode 識別コード) {

        if (!get前排他(被保険者番号.getColumnValue())) {
            throw new PessimisticLockingException();
        }
        RString 処理モード;
        if (論理削除フラグ) {
            処理モード = 削除モード;
        } else {
            処理モード = 訂正モード;
        }
        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().initialize(
                処理モード, 被保険者番号, 異動日, 論理削除フラグ, 対象年月);
        div.setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(連絡票を保存, false);
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        return entity;
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo3 = new ExpandedInformation(業務固有, 業務固有の識別情報名称, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo3);
    }

    /**
     * 前排他のンメソッドです。
     *
     * @param 被保険者番号 RString
     * @return boolean
     */
    public boolean get前排他(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他キーの解除のンメソッドです。
     *
     * @param 被保険者番号 RString
     */
    public void 前排他キーの解除(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        RealInitialLocker.release(排他キー);
    }

    /**
     * 共同処理用受給者訂正連絡票データ作成です。
     *
     * @return 異動連絡票データ
     */
    public SourceDataCollection to帳票発行処理() {
        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().getNewデータ();
        KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity 異動連絡票データ = KyodoshoriyoJukyushaTeiseiRenrakuhyoToroku
                .createInstance().editKyodoshoriyoJukyushaTeiseiRenrakuhyo(entity, RString.EMPTY, entity, true, true, true);
        KyodoShoriJukyushaTeiseiRenrakuhyoPrintService printService = new KyodoShoriJukyushaTeiseiRenrakuhyoPrintService();
        return printService.printSingle(異動連絡票データ);
    }

    /**
     * 更新完了メッセージ設定です。
     */
    public void set更新完了メッセージ() {
        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().getNewデータ();
        div.getKanryoMessage().setMessage(完了メッセージメイン,
                entity.get共通項目Entity().get被保険者番号().getColumnValue(),
                entity.get基本情報Entity().get被保険者氏名(),
                true);
    }

    /**
     * チェックボックスの状態。
     *
     * @return チェック状態
     */
    public List<RString> getチェックボックス状態() {
        return div.getKyodoIdoRenrakuhyoHenkoPrint().getChkRensakuhyoHakko().getSelectedKeys();
    }

    /**
     * データの登録処理を実行です。
     *
     * @param 初期受給者異動情報 KyodoshoriyoJukyushaIdoRenrakuhyoParam
     * @param 識別コード ShikibetsuCode
     * @param 論理削除フラグ boolean
     */
    public void データの登録(KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期受給者異動情報,
            ShikibetsuCode 識別コード,
            boolean 論理削除フラグ) {
        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().getNewデータ();
        KyoutuuEntity 共通項目Entity = entity.get共通項目Entity();
        HihokenshaNo 被保険者番号 = 共通項目Entity.get被保険者番号();
        List<RString> 基本送付_追加チェックボックス = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get基本送付情報を追加する();
        List<RString> 償還送付_追加チェックボックス = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get償還送付情報を追加する();
        List<RString> 高額送付_追加チェックボックス = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get高額送付情報を追加する();
        List<RString> 基本送付_削除チェックボックス = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get基本送付情報を削除する();
        List<RString> 償還送付_削除チェックボックス = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get償還送付情報を削除する();
        List<RString> 高額送付_削除チェックボックス = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get高額送付情報を削除する();
        boolean is基本送付活性 = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get基本送付情報を追加活性();
        boolean is償還送付活性 = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get償還送付情報を追加活性();
        boolean is高額送付活性 = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get高額送付情報を追加活性();
        Decimal 基本送付_履歴番号 = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get基本送付_履歴番号();
        Decimal 償還送付_履歴番号 = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get償還送付_履歴番号();
        Decimal 高額送付_履歴番号 = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get高額送付_履歴番号();
        int 基本_履歴番号;
        int 償還_履歴番号;
        int 高額_履歴番号;
        if (基本送付_履歴番号 != null) {
            基本_履歴番号 = 基本送付_履歴番号.add(Decimal.ONE).intValue();
        } else {
            基本_履歴番号 = NUM_ONE;
        }
        if (償還送付_履歴番号 != null) {
            償還_履歴番号 = 償還送付_履歴番号.add(Decimal.ONE).intValue();
        } else {
            償還_履歴番号 = NUM_ONE;
        }
        if (高額送付_履歴番号 != null) {
            高額_履歴番号 = 高額送付_履歴番号.add(Decimal.ONE).intValue();
        } else {
            高額_履歴番号 = NUM_ONE;
        }
        boolean is基本送付_追加 = false;
        boolean is償還送付_追加 = false;
        boolean is高額送付_追加 = false;
        boolean is基本送付_削除 = false;
        boolean is償還送付_削除 = false;
        boolean is高額送付_削除 = false;
        if (!基本送付_追加チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(基本送付_追加チェックボックス.get(NUM_ZERO))) {
            is基本送付_追加 = true;
        }
        if (!償還送付_追加チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(償還送付_追加チェックボックス.get(NUM_ZERO))) {
            is償還送付_追加 = true;
        }
        if (!高額送付_追加チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(高額送付_追加チェックボックス.get(NUM_ZERO))) {
            is高額送付_追加 = true;
        }
        if (!基本送付_削除チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(基本送付_削除チェックボックス.get(NUM_ZERO))) {
            is基本送付_削除 = true;
        }
        if (!償還送付_削除チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(償還送付_削除チェックボックス.get(NUM_ZERO))) {
            is償還送付_削除 = true;
        }
        if (!高額送付_削除チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(高額送付_削除チェックボックス.get(NUM_ZERO))) {
            is高額送付_削除 = true;
        }
        List<RString> チェック状態 = getチェックボックス状態();
        if (論理削除フラグ) {
            save論理削除フラグ_TRUE(entity, 共通項目Entity, 被保険者番号, チェック状態, is基本送付_追加, is償還送付_追加,
                    is高額送付_追加, 基本_履歴番号, 償還_履歴番号, 高額_履歴番号);
        } else {
            set論理削除フラグ_FALSE(初期受給者異動情報, entity, チェック状態, 共通項目Entity, 被保険者番号,
                    基本_履歴番号, 償還_履歴番号, 高額_履歴番号, is基本送付活性, is償還送付活性, is高額送付活性,
                    is基本送付_追加, is償還送付_追加, is高額送付_追加, is基本送付_削除, is償還送付_削除, is高額送付_削除);
        }
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        前排他キーの解除(被保険者番号.getColumnValue());
    }

    private void set論理削除フラグ_FALSE(KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期受給者異動情報,
            KyodoshoriyoJukyushaIdoRenrakuhyoParam entity,
            List<RString> チェック状態,
            KyoutuuEntity 共通項目Entity,
            HihokenshaNo 被保険者番号,
            int 基本_履歴番号,
            int 償還_履歴番号,
            int 高額_履歴番号,
            boolean is基本送付活性,
            boolean is償還送付活性,
            boolean is高額送付活性,
            boolean is基本送付_追加,
            boolean is償還送付_追加,
            boolean is高額送付_追加,
            boolean is基本送付_削除,
            boolean is償還送付_削除,
            boolean is高額送付_削除) {
        RString 訂正区分 = div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get訂正区分();
        FlexibleDate 訂正年月日 = new FlexibleDate(div.getKyodoIdoRenrakuhyoHenkoDetailInfo().get訂正年月日().toDateString());
        RString 区分 = JukyushaIF_TeiseiKubunCode.valueOf(訂正区分.toString()).getコード();
        if (修正KEY.equals(訂正区分)) {
            KyodoJukyushaIdoRenrakuhyoHandler handler = new KyodoJukyushaIdoRenrakuhyoHandler();
            boolean 基本_活性 = false;
            boolean 償還_活性 = false;
            boolean 高額_活性 = false;
            if (is基本送付_追加 && is基本送付活性) {
                基本_活性 = true;
            }
            if (is償還送付_追加 && is償還送付活性) {
                償還_活性 = true;
            }
            if (is高額送付_追加 && is高額送付活性) {
                高額_活性 = true;
            }
            boolean is基本送付情報 = handler.is基本送付情報変更あり(初期受給者異動情報, entity, 基本_活性);
            boolean is償還送付情報 = handler.is償還送付情報変更あり(初期受給者異動情報, entity, 償還_活性);
            boolean is高額送付情報 = handler.is高額送付情報変更あり(初期受給者異動情報, entity, 高額_活性);
            save訂正区分_修正(entity, 共通項目Entity, 被保険者番号, チェック状態, is基本送付情報, is償還送付情報,
                    is高額送付情報, 基本_履歴番号, 償還_履歴番号, 高額_履歴番号, 区分, 訂正年月日);
        } else if (削除KEY.equals(訂正区分)) {
            save訂正区分_削除(entity, is基本送付_削除, is償還送付_削除, is高額送付_削除, 訂正年月日, 区分);
        }
    }

    private void save訂正区分_修正(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity,
            KyoutuuEntity 共通項目Entity,
            HihokenshaNo 被保険者番号,
            List<RString> チェック状態,
            boolean is基本送付情報,
            boolean is償還送付情報,
            boolean is高額送付情報,
            int 基本送付_履歴番号,
            int 償還送付_履歴番号,
            int 高額送付_履歴番号,
            RString 訂正区分,
            FlexibleDate 訂正年月日) {

        KyodoShoriyoJukyushaIdoKihonSofu 異動基本送付Entity = null;
        if (is基本送付情報) {
            異動基本送付Entity = new KyodoShoriyoJukyushaIdoKihonSofu(
                    共通項目Entity.get異動年月日(),
                    共通項目Entity.get異動区分(),
                    共通項目Entity.get異動事由(),
                    共通項目Entity.get証記載保険者番号(),
                    被保険者番号,
                    基本送付_履歴番号);
            異動基本送付Entity = 異動基本送付Entity.createBuilderForEdit()
                    .set被保険者氏名(entity.get基本情報Entity().get被保険者氏名())
                    .set郵便番号(entity.get基本情報Entity().get郵便番号())
                    .set住所カナ(entity.get基本情報Entity().get住所カナ())
                    .set住所(entity.get基本情報Entity().get住所())
                    .set電話番号(entity.get基本情報Entity().get電話番号())
                    .set帳票出力順序コード(entity.get基本情報Entity().get帳票出力順序コード())
                    .set送付年月(FlexibleYearMonth.EMPTY)
                    .set訂正区分コード(訂正区分)
                    .set訂正年月日(訂正年月日)
                    .set論理削除フラグ(false)
                    .build();
            if (!チェック状態.isEmpty()) {
                異動基本送付Entity = 異動基本送付Entity.createBuilderForEdit().set訂正連絡票フラグ(true).build();
            } else {
                異動基本送付Entity = 異動基本送付Entity.createBuilderForEdit().set訂正連絡票フラグ(false).build();
            }
        }

        KyodoShoriyoJukyushaIdoShokanSofu 異動償還送付Entity = null;
        if (is償還送付情報) {
            異動償還送付Entity = new KyodoShoriyoJukyushaIdoShokanSofu(
                    共通項目Entity.get異動年月日(),
                    共通項目Entity.get異動区分(),
                    共通項目Entity.get異動事由(),
                    共通項目Entity.get証記載保険者番号(),
                    被保険者番号,
                    償還送付_履歴番号);
            異動償還送付Entity = 異動償還送付Entity.createBuilderForEdit()
                    .set保険給付支払一時差止開始年月日(entity.get償還情報Entity().get保険給付支払一時差止開始年月日())
                    .set保険給付支払一時差止終了年月日(entity.get償還情報Entity().get保険給付支払一時差止終了年月日())
                    .set保険給付支払一時差止区分コード(entity.get償還情報Entity().get保険給付支払一時差止区分コード())
                    .set保険給付支払一時差止金額(entity.get償還情報Entity().get保険給付支払一時差止金額())
                    .set送付年月(FlexibleYearMonth.EMPTY)
                    .set訂正区分コード(訂正区分)
                    .set訂正年月日(訂正年月日)
                    .set論理削除フラグ(false)
                    .build();
            if (!チェック状態.isEmpty()) {
                異動償還送付Entity = 異動償還送付Entity.createBuilderForEdit().set訂正連絡票フラグ(true).build();
            } else {
                異動償還送付Entity = 異動償還送付Entity.createBuilderForEdit().set訂正連絡票フラグ(false).build();
            }
        }

        KyodoShoriyoJukyushaIdoKogakuSofu 異動高額送付 = null;
        if (is高額送付情報) {
            異動高額送付 = new KyodoShoriyoJukyushaIdoKogakuSofu(
                    共通項目Entity.get異動年月日(),
                    共通項目Entity.get異動区分(),
                    共通項目Entity.get異動事由(),
                    共通項目Entity.get証記載保険者番号(),
                    被保険者番号,
                    高額送付_履歴番号);
            異動高額送付 = 異動高額送付.createBuilderForEdit()
                    .set世帯集約番号(entity.get高額情報Entity().get世帯集約番号())
                    .set世帯所得区分コード(entity.get高額情報Entity().get世帯所得区分コード())
                    .set所得区分コード(entity.get高額情報Entity().get所得区分コード())
                    .set老齢福祉年金受給有フラグ(entity.get高額情報Entity().is老齢福祉年金受給有フラグ())
                    .set利用者負担第２段階有フラグ(entity.get高額情報Entity().is利用者負担第２段階有フラグ())
                    .set支給申請書出力有フラグ(entity.get高額情報Entity().is支給申請書出力有フラグ())
                    .set送付年月(FlexibleYearMonth.EMPTY)
                    .set訂正区分コード(訂正区分)
                    .set訂正年月日(訂正年月日)
                    .set論理削除フラグ(false)
                    .build();
            if (!チェック状態.isEmpty()) {
                異動高額送付 = 異動高額送付.createBuilderForEdit().set訂正連絡票フラグ(true).build();
            } else {
                異動高額送付 = 異動高額送付.createBuilderForEdit().set訂正連絡票フラグ(false).build();
            }
        }
        KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().save異動情報(
                異動基本送付Entity,
                異動償還送付Entity,
                異動高額送付);
    }

    private void save訂正区分_削除(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity,
            boolean is基本送付情報,
            boolean is償還送付情報,
            boolean is高額送付情報,
            FlexibleDate 訂正年月日,
            RString 訂正区分) {

        KyodoShoriyoJukyushaIdoKihonSofu 異動基本送付Entity = null;
        if (is基本送付情報) {
            異動基本送付Entity = entity.get基本情報Entity();
            異動基本送付Entity = 異動基本送付Entity.createBuilderForEdit()
                    .set送付年月(new FlexibleYearMonth(RDate.getNowDate().toDateString()))
                    .set訂正区分コード(訂正区分)
                    .set訂正年月日(訂正年月日)
                    .set論理削除フラグ(true)
                    .build();
        }
        KyodoShoriyoJukyushaIdoShokanSofu 異動償還送付Entity = null;
        if (is償還送付情報) {
            異動償還送付Entity = entity.get償還情報Entity();
            異動償還送付Entity = 異動償還送付Entity.createBuilderForEdit()
                    .set送付年月(new FlexibleYearMonth(RDate.getNowDate().toDateString()))
                    .set訂正区分コード(訂正区分)
                    .set訂正年月日(訂正年月日)
                    .set論理削除フラグ(true)
                    .build();
        }
        KyodoShoriyoJukyushaIdoKogakuSofu 異動高額送付Entity = null;
        if (is高額送付情報) {
            異動高額送付Entity = entity.get高額情報Entity();
            異動高額送付Entity = 異動高額送付Entity.createBuilderForEdit()
                    .set送付年月(new FlexibleYearMonth(RDate.getNowDate().toDateString()))
                    .set訂正区分コード(訂正区分)
                    .set訂正年月日(訂正年月日)
                    .set論理削除フラグ(true)
                    .build();
        }
        KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().update異動情報(
                異動基本送付Entity,
                異動償還送付Entity,
                異動高額送付Entity);
    }

    private void save論理削除フラグ_TRUE(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity,
            KyoutuuEntity 共通項目Entity,
            HihokenshaNo 被保険者番号,
            List<RString> チェック状態,
            boolean is基本送付情報,
            boolean is償還送付情報,
            boolean is高額送付情報,
            int 基本送付_履歴番号,
            int 償還送付_履歴番号,
            int 高額送付_履歴番号) {

        KyodoShoriyoJukyushaIdoKihonSofu 異動基本送付Entity = null;
        if (is基本送付情報) {
            異動基本送付Entity = new KyodoShoriyoJukyushaIdoKihonSofu(
                    共通項目Entity.get異動年月日(),
                    共通項目Entity.get異動区分(),
                    共通項目Entity.get異動事由(),
                    共通項目Entity.get証記載保険者番号(),
                    被保険者番号,
                    基本送付_履歴番号);
            異動基本送付Entity = 異動基本送付Entity.createBuilderForEdit()
                    .set被保険者氏名(entity.get基本情報Entity().get被保険者氏名())
                    .set郵便番号(entity.get基本情報Entity().get郵便番号())
                    .set住所カナ(entity.get基本情報Entity().get住所カナ())
                    .set住所(entity.get基本情報Entity().get住所())
                    .set電話番号(entity.get基本情報Entity().get電話番号())
                    .set帳票出力順序コード(entity.get基本情報Entity().get帳票出力順序コード())
                    .set送付年月(entity.get基本情報Entity().get送付年月())
                    .set訂正区分コード(JukyushaIF_TeiseiKubunCode.修正.getコード())
                    .set訂正年月日(FlexibleDate.getNowDate())
                    .set論理削除フラグ(false)
                    .build();
            if (!チェック状態.isEmpty()) {
                異動基本送付Entity = 異動基本送付Entity.createBuilderForEdit().set訂正連絡票フラグ(true).build();
            } else {
                異動基本送付Entity = 異動基本送付Entity.createBuilderForEdit().set訂正連絡票フラグ(false).build();
            }
        }

        KyodoShoriyoJukyushaIdoShokanSofu 異動償還送付Entity = null;
        if (is償還送付情報) {
            異動償還送付Entity = new KyodoShoriyoJukyushaIdoShokanSofu(
                    共通項目Entity.get異動年月日(),
                    共通項目Entity.get異動区分(),
                    共通項目Entity.get異動事由(),
                    共通項目Entity.get証記載保険者番号(),
                    被保険者番号,
                    償還送付_履歴番号);
            異動償還送付Entity = 異動償還送付Entity.createBuilderForEdit()
                    .set保険給付支払一時差止開始年月日(entity.get償還情報Entity().get保険給付支払一時差止開始年月日())
                    .set保険給付支払一時差止終了年月日(entity.get償還情報Entity().get保険給付支払一時差止終了年月日())
                    .set保険給付支払一時差止区分コード(entity.get償還情報Entity().get保険給付支払一時差止区分コード())
                    .set保険給付支払一時差止金額(entity.get償還情報Entity().get保険給付支払一時差止金額())
                    .set送付年月(entity.get償還情報Entity().get送付年月())
                    .set訂正区分コード(JukyushaIF_TeiseiKubunCode.修正.getコード())
                    .set訂正年月日(FlexibleDate.getNowDate())
                    .set論理削除フラグ(false)
                    .build();
            if (!チェック状態.isEmpty()) {
                異動償還送付Entity = 異動償還送付Entity.createBuilderForEdit().set訂正連絡票フラグ(true).build();
            } else {
                異動償還送付Entity = 異動償還送付Entity.createBuilderForEdit().set訂正連絡票フラグ(false).build();
            }
        }

        KyodoShoriyoJukyushaIdoKogakuSofu 異動高額送付 = null;
        if (is高額送付情報) {
            異動高額送付 = new KyodoShoriyoJukyushaIdoKogakuSofu(
                    共通項目Entity.get異動年月日(),
                    共通項目Entity.get異動区分(),
                    共通項目Entity.get異動事由(),
                    共通項目Entity.get証記載保険者番号(),
                    被保険者番号,
                    高額送付_履歴番号);
            異動高額送付 = 異動高額送付.createBuilderForEdit()
                    .set世帯集約番号(entity.get高額情報Entity().get世帯集約番号())
                    .set世帯所得区分コード(entity.get高額情報Entity().get世帯所得区分コード())
                    .set所得区分コード(entity.get高額情報Entity().get所得区分コード())
                    .set老齢福祉年金受給有フラグ(entity.get高額情報Entity().is老齢福祉年金受給有フラグ())
                    .set利用者負担第２段階有フラグ(entity.get高額情報Entity().is利用者負担第２段階有フラグ())
                    .set支給申請書出力有フラグ(entity.get高額情報Entity().is支給申請書出力有フラグ())
                    .set送付年月(entity.get高額情報Entity().get送付年月())
                    .set訂正区分コード(JukyushaIF_TeiseiKubunCode.修正.getコード())
                    .set訂正年月日(FlexibleDate.getNowDate())
                    .set論理削除フラグ(false)
                    .build();
            if (!チェック状態.isEmpty()) {
                異動高額送付 = 異動高額送付.createBuilderForEdit().set訂正連絡票フラグ(true).build();
            } else {
                異動高額送付 = 異動高額送付.createBuilderForEdit().set訂正連絡票フラグ(false).build();
            }
        }
        KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().save異動情報(
                異動基本送付Entity,
                異動償還送付Entity,
                異動高額送付);
    }
}
