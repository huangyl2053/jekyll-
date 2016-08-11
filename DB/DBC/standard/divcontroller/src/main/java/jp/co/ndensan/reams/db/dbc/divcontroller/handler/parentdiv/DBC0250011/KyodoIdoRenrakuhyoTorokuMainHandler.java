/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0250011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoKihonSofu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoKogakuSofu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyodoShoriyoJukyushaIdoShokanSofu;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyoutuuEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshoriyojukyushaidorenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0250011.KyodoIdoRenrakuhyoTorokuMainDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kyodoshorijukyushaidorenrakuhyo.KyodoshoriyoJukyushaIdoRenrakuhyoToroku;
import jp.co.ndensan.reams.db.dbc.service.report.kyodoshorijukyushaidorenrakuhyo.KyodoShoriJukyushaIdoRenrakuhyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBCMN81003_共同処理用受給者異動連絡票登録のハンドラクラスです。
 *
 * @reamsid_L DBC-1950-010 wangkanglei
 */
public class KyodoIdoRenrakuhyoTorokuMainHandler {

    private final KyodoIdoRenrakuhyoTorokuMainDiv div;
    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private static final RString 個人番号_利用有無名称 = new RString("個人番号 利用有無");
    private static final RString 法人番号_利用有無名称 = new RString("法人番号 利用有無");
    private static final RString 業務固有の識別情報名称 = new RString("業務固有の識別情報");
    private static final Code 個人番号 = new Code("0001");
    private static final Code 法人番号 = new Code("0002");
    private static final Code 業務固有 = new Code("0003");
    private static final RString 無し = new RString("無し");
    private static final RString 被保険者番号_なし = new RString("被保険者番号なし");
    private static final RString 完了メッセージメイン = new RString("共同処理用受給者異動連絡票の登録が完了しました。");
    private static final RString 連絡票を保存 = new RString("btnSave");
    private static final RString 新規モード = new RString("新規");
    private static final int 履歴番号 = 1;
    private static final int NUM_ZERO = 0;
    private static final RString チェックボックス_KEY = new RString("key0");

    /**
     * コンストラクタです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     */
    public KyodoIdoRenrakuhyoTorokuMainHandler(KyodoIdoRenrakuhyoTorokuMainDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ハンドラ
     */
    public static KyodoIdoRenrakuhyoTorokuMainHandler of(KyodoIdoRenrakuhyoTorokuMainDiv div) {
        return new KyodoIdoRenrakuhyoTorokuMainHandler(div);
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     */
    public void initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {

        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace(
                    被保険者番号_なし.toString()));
        } else if (!get前排他(被保険者番号.getColumnValue())) {
            throw new PessimisticLockingException();
        }
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        div.getKyodoIdoRenrakuhyoTorokuInfo().initialize(新規モード, 被保険者番号, nowDate, false, nowDate.getYearMonth());
        div.setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(連絡票を保存, false);
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
    }

    /**
     * 「共同処理用受給者異動連絡票を発行する」チェックボックスの状態。
     *
     * @return チェック状態
     */
    public List<RString> getチェックボックス状態() {
        return div.getKyodoIdoRenrakuhyoTorokuPrint().getChkRensakuhyoHakko().getSelectedKeys();
    }

    /**
     * データの登録処理を実行です。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void データの登録(ShikibetsuCode 識別コード) {
        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = div.getKyodoIdoRenrakuhyoTorokuInfo().getNewデータ();
        KyoutuuEntity 共通項目Entity = entity.get共通項目Entity();
        HihokenshaNo 被保険者番号 = 共通項目Entity.get被保険者番号();
        List<RString> 基本送付情報チェックボックス = div.getKyodoIdoRenrakuhyoTorokuInfo().get基本送付情報を追加する();
        List<RString> 償還送付情報チェックボックス = div.getKyodoIdoRenrakuhyoTorokuInfo().get償還送付情報を追加する();
        List<RString> 高額送付情報チェックボックス = div.getKyodoIdoRenrakuhyoTorokuInfo().get高額送付情報を追加する();
        boolean is基本送付情報 = false;
        boolean is償還送付情報 = false;
        boolean is高額送付情報 = false;
        if (!基本送付情報チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(基本送付情報チェックボックス.get(NUM_ZERO))) {
            is基本送付情報 = true;
        }
        if (!償還送付情報チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(償還送付情報チェックボックス.get(NUM_ZERO))) {
            is償還送付情報 = true;
        }
        if (!高額送付情報チェックボックス.isEmpty()
                && チェックボックス_KEY.equals(高額送付情報チェックボックス.get(NUM_ZERO))) {
            is高額送付情報 = true;
        }
        List<RString> チェック状態 = getチェックボックス状態();

        KyodoShoriyoJukyushaIdoKihonSofu 異動基本送付Entity = new KyodoShoriyoJukyushaIdoKihonSofu(
                共通項目Entity.get異動年月日(),
                共通項目Entity.get異動区分(),
                共通項目Entity.get異動事由(),
                共通項目Entity.get証記載保険者番号(),
                被保険者番号,
                履歴番号);
        if (is基本送付情報) {
            異動基本送付Entity = 異動基本送付Entity.createBuilderForEdit()
                    .set被保険者氏名(entity.get基本情報Entity().get被保険者氏名())
                    .set郵便番号(entity.get基本情報Entity().get郵便番号())
                    .set住所カナ(entity.get基本情報Entity().get住所カナ())
                    .set住所(entity.get基本情報Entity().get住所())
                    .set電話番号(entity.get基本情報Entity().get電話番号())
                    .set帳票出力順序コード(entity.get基本情報Entity().get帳票出力順序コード())
                    .set送付年月(FlexibleYearMonth.EMPTY)
                    .set訂正区分コード(RString.EMPTY)
                    .set訂正年月日(FlexibleDate.EMPTY)
                    .set論理削除フラグ(false)
                    .build();
            if (!チェック状態.isEmpty()) {
                異動基本送付Entity = 異動基本送付Entity.createBuilderForEdit().set訂正連絡票フラグ(true).build();
            } else {
                異動基本送付Entity = 異動基本送付Entity.createBuilderForEdit().set訂正連絡票フラグ(false).build();
            }
        }

        KyodoShoriyoJukyushaIdoShokanSofu 異動償還送付Entity = new KyodoShoriyoJukyushaIdoShokanSofu(
                共通項目Entity.get異動年月日(),
                共通項目Entity.get異動区分(),
                共通項目Entity.get異動事由(),
                共通項目Entity.get証記載保険者番号(),
                被保険者番号,
                履歴番号);
        if (is償還送付情報) {
            異動償還送付Entity = 異動償還送付Entity.createBuilderForEdit()
                    .set保険給付支払一時差止開始年月日(entity.get償還情報Entity().get保険給付支払一時差止開始年月日())
                    .set保険給付支払一時差止終了年月日(entity.get償還情報Entity().get保険給付支払一時差止終了年月日())
                    .set保険給付支払一時差止区分コード(entity.get償還情報Entity().get保険給付支払一時差止区分コード())
                    .set保険給付支払一時差止金額(entity.get償還情報Entity().get保険給付支払一時差止金額())
                    .set送付年月(FlexibleYearMonth.EMPTY)
                    .set訂正区分コード(RString.EMPTY)
                    .set訂正年月日(FlexibleDate.EMPTY)
                    .set論理削除フラグ(false)
                    .build();
            if (!チェック状態.isEmpty()) {
                異動償還送付Entity = 異動償還送付Entity.createBuilderForEdit().set訂正連絡票フラグ(true).build();
            } else {
                異動償還送付Entity = 異動償還送付Entity.createBuilderForEdit().set訂正連絡票フラグ(false).build();
            }
        }

        KyodoShoriyoJukyushaIdoKogakuSofu 異動高額送付 = new KyodoShoriyoJukyushaIdoKogakuSofu(
                共通項目Entity.get異動年月日(),
                共通項目Entity.get異動区分(),
                共通項目Entity.get異動事由(),
                共通項目Entity.get証記載保険者番号(),
                被保険者番号,
                履歴番号);
        if (is高額送付情報) {
            異動高額送付 = 異動高額送付.createBuilderForEdit()
                    .set世帯集約番号(entity.get高額情報Entity().get世帯集約番号())
                    .set世帯所得区分コード(entity.get高額情報Entity().get世帯所得区分コード())
                    .set所得区分コード(entity.get高額情報Entity().get所得区分コード())
                    .set老齢福祉年金受給有フラグ(entity.get高額情報Entity().is老齢福祉年金受給有フラグ())
                    .set利用者負担第２段階有フラグ(entity.get高額情報Entity().is利用者負担第２段階有フラグ())
                    .set支給申請書出力有フラグ(entity.get高額情報Entity().is支給申請書出力有フラグ())
                    .set送付年月(FlexibleYearMonth.EMPTY)
                    .set訂正区分コード(RString.EMPTY)
                    .set訂正年月日(FlexibleDate.EMPTY)
                    .set論理削除フラグ(false)
                    .build();
            if (!チェック状態.isEmpty()) {
                異動高額送付 = 異動高額送付.createBuilderForEdit().set訂正連絡票フラグ(true).build();
            } else {
                異動高額送付 = 異動高額送付.createBuilderForEdit().set訂正連絡票フラグ(false).build();
            }
        }
        KyodoshoriyoJukyushaIdoRenrakuhyoToroku.createInstance().save異動情報(
                異動基本送付Entity,
                異動償還送付Entity,
                異動高額送付,
                is基本送付情報,
                is償還送付情報,
                is高額送付情報);
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        前排他キーの解除(被保険者番号.getColumnValue());
    }

    /**
     * 共同処理用受給者異動連絡票データ作成です。
     *
     * @return 異動連絡票データ
     */
    public SourceDataCollection to帳票発行処理() {
        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = div.getKyodoIdoRenrakuhyoTorokuInfo().getNewデータ();
        KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity 異動連絡票データ = KyodoshoriyoJukyushaIdoRenrakuhyoToroku
                .createInstance().editKyodoshoriyoJukyushaIdoRenrakuhyo(entity);
        KyodoShoriJukyushaIdoRenrakuhyoPrintService printService = new KyodoShoriJukyushaIdoRenrakuhyoPrintService();
        return printService.printSingle(異動連絡票データ);
    }

    /**
     * 更新完了メッセージ設定です。
     */
    public void set更新完了メッセージ() {
        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = div.getKyodoIdoRenrakuhyoTorokuInfo().getNewデータ();
        div.getKanryoMessage().setMessage(完了メッセージメイン,
                entity.get共通項目Entity().get被保険者番号().getColumnValue(),
                entity.get基本情報Entity().get被保険者氏名(),
                true);
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo1 = new ExpandedInformation(個人番号, 個人番号_利用有無名称, 無し);
        ExpandedInformation expandedInfo2 = new ExpandedInformation(法人番号, 法人番号_利用有無名称, 無し);
        ExpandedInformation expandedInfo3 = new ExpandedInformation(業務固有, 業務固有の識別情報名称, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo1, expandedInfo2, expandedInfo3);
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
}
