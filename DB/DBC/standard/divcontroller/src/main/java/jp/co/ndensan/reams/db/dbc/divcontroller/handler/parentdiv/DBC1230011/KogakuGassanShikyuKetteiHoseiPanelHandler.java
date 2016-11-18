/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1230011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.HihokenshaDaichoResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.KogakuGassanKyufuJissekiResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.KogakuGassanShikyuKetteiHoseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.KoshinShoriResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.ShoriModeHanteiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteihosei.KogakuGassanShikyuGakuKeisanKekkaUpdateParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.DBC1230011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.KogakuGassanShikyuKetteiHoseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.dgKogakuGassanShikyuFushikyuKettei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc1230011.KogakuGassanShikyuKetteiHoseiDetailParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassanshikyuketteihosei.KogakuGassanShikyuKetteiHosei;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 画面設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class KogakuGassanShikyuKetteiHoseiPanelHandler {

    private final KogakuGassanShikyuKetteiHoseiPanelDiv div;
    private static final RString 事業分支給決定情報補正 = new RString("DBCMNN1005");
    private static final RString 決定情報を = new RString("btnSave");
    private static final RString CODE_ミ = new RString("003");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString 被保番号 = new RString("被保険者番号");
    private static final RString 新規 = new RString("新規");
    private static final RString 登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 照会 = new RString("照会");
    private static final RString 支給 = new RString("支給");
    private static final RString 備考 = new RString("備考");
    private static final RString 不支給の理由 = new RString("不支給の理由");
    private static final RString 不支給 = new RString("不支給");
    private static final RString 定値_日付1 = new RString("0401");
    private static final RString 定値_日付2 = new RString("0801");
    private static final RString 定値_日付3 = new RString("0731");
    private static final RString 定値_喪失事由コード = new RString("52");
    private static final RDate 定値_年度年度 = new RDate("2008");
    private static final RString アンダーライン = new RString("_");
    private static final RString 支給決定情報補正判定MSG1 = new RString("支給決定情報補正判定Msg1");
    private static final RString 支給決定情報補正判定MSG2 = new RString("支給決定情報補正判定Msg2");
    private static final RString 支給決定情報補正判定MSG3 = new RString("支給決定情報補正判定Msg3");
    private static final RString 支給決定情報補正判定MSG4 = new RString("支給決定情報補正判定Msg4");
    private static final RString 支給決定情報補正判定MSG5 = new RString("支給決定情報補正判定Msg5");
    private static final RString 支給決定情報補正判定MSG6 = new RString("支給決定情報補正判定Msg6");
    private static final int NUM_0 = 0;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_5 = 5;
    private static final int NUM_8 = 8;
    private static final int NUM_7 = 7;

    /**
     * 初期化
     *
     * @param div KogakuSabisuhiShikyuShinseiPanel
     */
    public KogakuGassanShikyuKetteiHoseiPanelHandler(KogakuGassanShikyuKetteiHoseiPanelDiv div) {
        this.div = div;
    }

    /**
     * 事業分フラグの変更設定です。
     */
    public void set事業分フラグ() {
        if (事業分支給決定情報補正.equals(ResponseHolder.getMenuID())) {
            div.set事業分フラグ(new RString(Boolean.TRUE.toString()));
        } else {
            div.set事業分フラグ(new RString(Boolean.FALSE.toString()));
        }
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
     * データ存在チェックです。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void getデータ存在チェック(HihokenshaNo 被保険者番号) {
        List<JukyushaDaicho> 受給者台帳データ = KogakuGassanShikyuKetteiHosei.
                createInstance().get受給者台帳データ(被保険者番号);
        if (div.get事業分フラグ().equals(new RString(Boolean.TRUE.toString()))) {
            List<SogoJigyoTaishosha> 総合事業対象者データ = KogakuGassanShikyuKetteiHosei.
                    createInstance().get総合事業対象者データ(被保険者番号);
            if ((受給者台帳データ == null || 受給者台帳データ.isEmpty())
                    && (総合事業対象者データ == null || 総合事業対象者データ.isEmpty())) {
                throw new ApplicationException(DbdErrorMessages.受給共通_受給者_事業対象者登録なし.getMessage());
            }
        } else {
            if (受給者台帳データ == null || 受給者台帳データ.isEmpty()) {
                throw new ApplicationException(DbcInformationMessages.被保険者でないデータ.getMessage());
            }
        }
    }

    /**
     * 新規と検索条件登録パネル設定です。
     */
    public void set新規と検索条件登録パネル() {
        RDate システムタイム = RDate.getNowDate();
        RYear システム年度 = システムタイム.getYear();
        if (NUM_8 <= システムタイム.getMonthValue()) {
            システム年度 = システム年度.minusYear(1);
        } else if (システムタイム.getMonthValue() <= NUM_7) {
            システム年度 = システム年度.minusYear(2);
        }
        div.getShinkiPanel().getTxtShinkiTaishoNendo().setValue(new RDate(システム年度.toString()));
        div.getSearchPanel().getTxtKensakuTaishoNendo().setValue(new RDate(システム年度.toString()));
        LasdecCode 地方公共団体コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        div.getShinkiPanel().getTxtShinkiHihokenshaNo().setValue(地方公共団体コード.value());
        div.getSearchPanel().getTxtKensakuHihokenshaNo().setValue(地方公共団体コード.value());
    }

    /**
     * 決定情報一覧グリッド設定です。
     *
     * @param result List<KogakuGassanShikyuKetteiHoseiResult>
     */
    public void set決定情報一覧グリッド(List<KogakuGassanShikyuKetteiHoseiResult> result) {
        List<dgKogakuGassanShikyuFushikyuKettei_Row> rowList = new ArrayList<>();
        boolean 事業分フラグ = false;
        if (div.get事業分フラグ().equals(new RString(Boolean.TRUE.toString()))) {
            事業分フラグ = true;
        }
        for (KogakuGassanShikyuKetteiHoseiResult entity : result) {
            dgKogakuGassanShikyuFushikyuKettei_Row row = new dgKogakuGassanShikyuFushikyuKettei_Row();
            if (事業分フラグ) {
                row.setHihokenshaNo(entity.get事業高額合算決定entity().get被保険者番号().value());
                row.getTxtTaishoNendo().setValue(new RDate(entity.get事業高額合算決定entity().
                        get対象年度().toString()));
                row.setTxtShokisaiNo(entity.get事業高額合算決定entity().get保険者番号().value());
                row.setTxtRenrakuhyoSeiriNo(entity.get事業高額合算決定entity().get支給申請書整理番号());
                row.setTxtRirekiNo(new RString(entity.get事業高額合算決定entity().get履歴番号()));
                if (entity.get事業高額合算決定entity().get自己負担総額() != null) {
                    row.getTxtJikoFutangaku().setValue(entity.get事業高額合算決定entity().get自己負担総額());
                }
                row.setTxtShikyuKubun(entity.get事業高額合算決定entity().get支給区分コード());
                if (entity.get事業高額合算決定entity().get支給額() != null) {
                    row.getTxtShikyugaku().setValue(entity.get事業高額合算決定entity().get支給額());
                }
                if (entity.get事業高額合算決定entity().get受取年月() != null
                        && !entity.get事業高額合算決定entity().get受取年月().isEmpty()) {
                    row.getTxtUketoriNengetsu().setValue(new FlexibleDate(entity.
                            get事業高額合算決定entity().get受取年月().toDateString()));
                }
                row.setChkisDeleted(new RString(Boolean.TRUE.toString()));
                row.setKozaID(new RString(entity.get事業高額合算決定entity().get口座ID()));
                row.getKeisanKaishiYMD().setValue(entity.get事業高額合算決定entity().get対象計算期間開始年月日());
                row.getKeisanShuryoYMD().setValue(entity.get事業高額合算決定entity().get対象計算期間終了年月日());
                row.setJikoFutanSeiriNo(entity.get事業高額合算決定entity().get自己負担額証明書整理番号());
                row.getShinseiYMD().setValue(entity.get事業高額合算決定entity().get申請年月日());
                row.getKetteiYMD().setValue(entity.get事業高額合算決定entity().get決定年月日());
                row.setKyufuShurui(entity.get事業高額合算決定entity().get給付の種類());
                row.setBiko(entity.get事業高額合算決定entity().get備考());
                row.setFushikyuRiyu(entity.get事業高額合算決定entity().get不支給理由());
                row.getKetteiTsuchiSakuseiYMD().setValue(entity.get事業高額合算決定entity().get決定通知書作成年月日());
                row.getFurikomiTsuchiSakuseiYMD().setValue(entity.get事業高額合算決定entity().get振込通知書作成年月日());
                row.setShiharaiHohoKubun(entity.get事業高額合算決定entity().get支払方法区分());
                rowList.add(row);
            } else {
                row.setHihokenshaNo(entity.get高額合算決定entity().get被保険者番号().value());
                row.getTxtTaishoNendo().setValue(new RDate(
                        entity.get高額合算決定entity().get対象年度().toString()));
                row.setTxtShokisaiNo(entity.get高額合算決定entity().get保険者番号().value());
                row.setTxtRenrakuhyoSeiriNo(entity.get高額合算決定entity().get支給申請書整理番号());
                row.setTxtRirekiNo(new RString(entity.get高額合算決定entity().get履歴番号()));
                if (entity.get高額合算決定entity().get自己負担総額() != null) {
                    row.getTxtJikoFutangaku().setValue(entity.get高額合算決定entity().get自己負担総額());
                }
                row.setTxtShikyuKubun(entity.get高額合算決定entity().get支給区分コード());
                if (entity.get高額合算決定entity().get支給額() != null) {
                    row.getTxtShikyugaku().setValue(entity.get高額合算決定entity().get支給額());
                }
                if (entity.get高額合算決定entity().get受取年月() != null
                        && !entity.get高額合算決定entity().get受取年月().isEmpty()) {
                    row.getTxtUketoriNengetsu().setValue(new FlexibleDate(entity.get高額合算決定entity().
                            get受取年月().toDateString()));
                }
                row.setChkisDeleted(new RString(Boolean.FALSE.toString()));
                row.setKozaID(new RString(entity.get高額合算決定entity().get口座ID()));
                row.getKeisanKaishiYMD().setValue(entity.get高額合算決定entity().get対象計算期間開始年月日());
                row.getKeisanShuryoYMD().setValue(entity.get高額合算決定entity().get対象計算期間終了年月日());
                row.setJikoFutanSeiriNo(entity.get高額合算決定entity().get自己負担額証明書整理番号());
                row.getShinseiYMD().setValue(entity.get高額合算決定entity().get申請年月日());
                row.getKetteiYMD().setValue(entity.get高額合算決定entity().get決定年月日());
                row.setKyufuShurui(entity.get高額合算決定entity().get給付の種類());
                row.setBiko(entity.get高額合算決定entity().get備考());
                row.setFushikyuRiyu(entity.get高額合算決定entity().get不支給理由());
                row.getKetteiTsuchiSakuseiYMD().setValue(entity.get高額合算決定entity().get決定通知書作成年月日());
                row.getFurikomiTsuchiSakuseiYMD().setValue(entity.get高額合算決定entity().get振込通知書作成年月日());
                row.setShiharaiHohoKubun(entity.get高額合算決定entity().get支払方法区分());
                rowList.add(row);
            }
        }
        div.getDgKogakuGassanShikyuFushikyuKettei().setDataSource(rowList);
    }

    /**
     * 新規決定情報初期値取得設定です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     */
    public void set新規決定情報初期値(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtStatusFlg().setValue(新規);
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtTaishoNendo().setValue(div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue());
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtHihokenshaNo().
                setValue(div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue());
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyuSeiriNo().
                setValue(div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue());
        RDate システム日付 = RDate.getNowDate();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShinseiYMD().setValue(システム日付);
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKetteiYMD().setValue(システム日付);
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSogaku().setValue(Decimal.ZERO);
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyugaku().setValue(Decimal.ZERO);
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtTaishoNendo().getValue().getYear().equals(定値_年度年度.getYear())) {
            RString 開始計算対象期間 = div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtTaishoNendo().getValue().getYear().toDateString().concat(定値_日付1);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKeisanYMD().setFromValue(new RDate(開始計算対象期間.toString()));
        } else {
            RString 開始計算対象期間 = div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtTaishoNendo().getValue().getYear().toDateString().concat(定値_日付2);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKeisanYMD().setFromValue(new RDate(開始計算対象期間.toString()));
        }
        RString 終了計算対象期間 = div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtTaishoNendo().getValue().getYear().plusYear(1).toDateString().concat(定値_日付3);
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtKeisanYMD().setToValue(new RDate(終了計算対象期間.toString()));
        HihokenshaDaichoResult 被保険者台帳管理情報 = KogakuGassanShikyuKetteiHosei.
                createInstance().getHihokenshaDaicho(被保険者番号);
        if (被保険者台帳管理情報 != null && 被保険者台帳管理情報.get資格喪失年月日() != null
                && (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().
                getFromValue().isBefore(被保険者台帳管理情報.get資格喪失年月日().minusDay(1))
                || div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().
                getFromValue().equals(被保険者台帳管理情報.get資格喪失年月日().minusDay(1)))
                && (被保険者台帳管理情報.get資格喪失年月日().minusDay(1).
                isBefore(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getToValue())
                || 被保険者台帳管理情報.get資格喪失年月日().minusDay(1).
                equals(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getToValue()))
                && 定値_喪失事由コード.equals(被保険者台帳管理情報.get喪失事由コード())) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().
                    setToValue(被保険者台帳管理情報.get資格喪失年月日().minusDay(1));
        }
        boolean 事業分フラグ = false;
        if (div.get事業分フラグ().equals(new RString(Boolean.TRUE.toString()))) {
            事業分フラグ = true;
        }
        RString 給付の種類 = KogakuGassanShikyuKetteiHosei.createInstance().getYokaigoJotaiKubun(
                被保険者番号, new FlexibleDate(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                        getTxtKeisanYMD().getFromValue().toString()), new FlexibleDate(
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                        getTxtKeisanYMD().getToValue().toString()), 事業分フラグ);
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKyufuShurui().setValue(給付の種類);
        set支払方法タブ(被保険者番号, 新規, 識別コード, null);
    }

    /**
     * 新規以外の決定情報初期値取得設定です。
     *
     *
     * @param 処理モデル RString
     * @param 識別コード ShikibetsuCode
     */
    public void set新規以外の決定情報初期値(RString 処理モデル, ShikibetsuCode 識別コード) {
        dgKogakuGassanShikyuFushikyuKettei_Row row = div.getDgKogakuGassanShikyuFushikyuKettei().getClickedItem();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtStatusFlg().setValue(処理モデル);
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtTaishoNendo().setValue(new RDate(row.getTxtTaishoNendo().getValue().toString()));
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtHihokenshaNo().setValue(row.getTxtShokisaiNo());
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyuSeiriNo().setValue(row.getTxtRenrakuhyoSeiriNo());
        if (row.getKeisanKaishiYMD().getValue() != null && !row.getKeisanKaishiYMD().getValue().isEmpty()) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKeisanYMD().setFromValue(new RDate(row.getKeisanKaishiYMD().getValue().toString()));
        }
        if (row.getKeisanShuryoYMD().getValue() != null && !row.getKeisanShuryoYMD().getValue().isEmpty()) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKeisanYMD().setToValue(new RDate(row.getKeisanShuryoYMD().getValue().toString()));
        }
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSeiriNo().setValue(row.getJikoFutanSeiriNo());
        if (row.getShinseiYMD().getValue() != null && !row.getShinseiYMD().getValue().isEmpty()) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShinseiYMD().
                    setValue(new RDate(row.getShinseiYMD().getValue().toString()));
        }
        if (row.getKetteiYMD().getValue() != null && !row.getKetteiYMD().getValue().isEmpty()) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKetteiYMD().
                    setValue(new RDate(row.getKetteiYMD().getValue().toString()));
        }
        if (row.getTxtJikoFutangaku().getValue() != null) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtJikoFutanSogaku().setValue(row.getTxtJikoFutangaku().getValue());
        }
        set新規以外の決定情報初期値_Two(row);
        set支払方法タブ(HihokenshaNo.EMPTY, 処理モデル, 識別コード, row);
    }

    private void set新規以外の決定情報初期値_Two(dgKogakuGassanShikyuFushikyuKettei_Row row) {
        if (row.getTxtShikyuKubun() != null && !row.getTxtShikyuKubun().isEmpty()
                && ShikyuFushikyuKubun.支給.getコード().equals(row.getTxtShikyuKubun())) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getRadShikyuKubunCode().setSelectedValue(支給);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getLabel2().setText(備考);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().setValue(row.getBiko());
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKyufuShurui().setDisabled(false);
        } else if (row.getTxtShikyuKubun() != null && !row.getTxtShikyuKubun().isEmpty()
                && ShikyuFushikyuKubun.不支給.getコード().equals(row.getTxtShikyuKubun())) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getRadShikyuKubunCode().setSelectedValue(不支給);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getLabel2().setText(不支給の理由);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().setValue(row.getFushikyuRiyu());
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKyufuShurui().setDisabled(true);
        }
        if (row.getTxtShikyugaku().getValue() != null) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtShikyugaku().setValue(row.getTxtShikyugaku().getValue());
        }
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKyufuShurui().setValue(row.getKyufuShurui());
        if (row.getTxtUketoriNengetsu().getValue() != null && !row.getTxtUketoriNengetsu().getValue().isEmpty()) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtUketoriYM().setValue(new RDate(row.getTxtUketoriNengetsu().
                                    getValue().getYearMonth().toString()));
        }
        if (row.getKetteiTsuchiSakuseiYMD().getValue() != null
                && !row.getKetteiTsuchiSakuseiYMD().getValue().isEmpty()) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKetteiTsuchiSakuseiYMD().
                    setValue(new RDate(row.getKetteiTsuchiSakuseiYMD().getValue().toString()));
        }
        if (row.getFurikomiTsuchiSakuseiYMD().getValue() != null
                && !row.getFurikomiTsuchiSakuseiYMD().getValue().isEmpty()) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtFurikomiTsuchiSakuseiYMD().
                    setValue(new RDate(row.getFurikomiTsuchiSakuseiYMD().getValue().toString()));
        }
    }

    /**
     * 決定情報保存処理クリアです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 RString
     * @param 画面モード RString
     * @param 決定情報list List<KogakuGassanShikyuKetteiHoseiResult>
     * @param para KogakuGassanShikyuKetteiHoseiDetailParameter
     */
    public void save決定情報(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            RString 画面モード,
            List<KogakuGassanShikyuKetteiHoseiResult> 決定情報list,
            KogakuGassanShikyuKetteiHoseiDetailParameter para) {
        boolean 事業分フラグ = false;
        Map<RString, KogakuGassanShikyuFushikyuKettei> 高額合算決定map = new HashMap<>();
        Map<RString, JigyoKogakuGassanShikyuFushikyuKettei> 事業高額合算決定map = new HashMap<>();
        if (div.get事業分フラグ().equals(new RString(Boolean.TRUE.toString()))) {
            事業分フラグ = true;
        }
        RString 処理モード = RString.EMPTY;
        if (事業分フラグ) {
            if (新規.equals(画面モード)) {
                int 履歴番号 = KogakuGassanShikyuKetteiHosei.createInstance().get事業高額決定Max履歴番号(
                        被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号);
                JigyoKogakuGassanShikyuFushikyuKettei 事業高額決定result = new JigyoKogakuGassanShikyuFushikyuKettei(
                        被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号);
                事業高額決定result = buid事業高額決定(事業高額決定result);
                事業高額決定result = 事業高額決定result.added();
                処理モード = ONE;
                KogakuGassanShikyuKetteiHosei.createInstance().isKoshinShoriJigyo(事業高額決定result, 処理モード);
                return;
            }
            for (KogakuGassanShikyuKetteiHoseiResult 決定情報 : 決定情報list) {
                RStringBuilder builder = new RStringBuilder();
                builder.append(決定情報.get事業高額合算決定entity().get被保険者番号().value());
                builder.append(アンダーライン);
                builder.append(決定情報.get事業高額合算決定entity().get対象年度().toDateString());
                builder.append(アンダーライン);
                builder.append(決定情報.get事業高額合算決定entity().get保険者番号().value());
                builder.append(アンダーライン);
                builder.append(決定情報.get事業高額合算決定entity().get支給申請書整理番号());
                builder.append(アンダーライン);
                builder.append(決定情報.get事業高額合算決定entity().get履歴番号());
                事業高額合算決定map.put(builder.toRString(), 決定情報.get事業高額合算決定entity());
            }
            dgKogakuGassanShikyuFushikyuKettei_Row row = div.
                    getDgKogakuGassanShikyuFushikyuKettei().getClickedItem();
            RStringBuilder rowBuilder = new RStringBuilder();
            rowBuilder.append(row.getHihokenshaNo());
            rowBuilder.append(アンダーライン);
            rowBuilder.append(row.getTxtTaishoNendo().getValue().getYear().toString());
            rowBuilder.append(アンダーライン);
            rowBuilder.append(row.getTxtShokisaiNo());
            rowBuilder.append(アンダーライン);
            rowBuilder.append(row.getTxtRenrakuhyoSeiriNo());
            rowBuilder.append(アンダーライン);
            rowBuilder.append(row.getTxtRirekiNo());
            JigyoKogakuGassanShikyuFushikyuKettei 事業高額合算決定entity = 事業高額合算決定map.
                    get(rowBuilder.toRString());
            if (事業高額合算決定entity == null) {
                return;
            }
            if (修正.equals(画面モード)) {
                事業高額合算決定entity = buid事業高額決定(事業高額合算決定entity);
                事業高額合算決定entity = 事業高額合算決定entity.modified();
                処理モード = TWO;
            } else if (削除.equals(画面モード) || 照会.equals(画面モード)) {
                事業高額合算決定entity = 事業高額合算決定entity.deleted();
                処理モード = THREE;
            }
            KogakuGassanShikyuKetteiHosei.createInstance().isKoshinShoriJigyo(事業高額合算決定entity, 処理モード);
        } else {
            KogakuGassanShikyuGakuKeisanKekkaUpdateParameter parameter = new KogakuGassanShikyuGakuKeisanKekkaUpdateParameter();
            parameter.set更新後被保険者番号(被保険者番号);
            parameter.set更新後支給申請書整理番号(支給申請書整理番号);
            parameter.set更新後証記載保険者番号(保険者番号);
            get高額合算給付実績(parameter);
            ShoriModeHanteiResult modelResult = get処理モード(被保険者番号, 画面モード);
            if (新規.equals(画面モード)) {
                int 履歴番号 = KogakuGassanShikyuKetteiHosei.createInstance().get高額決定Max履歴番号(
                        被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号);
                KogakuGassanShikyuFushikyuKettei 高額決定result = new KogakuGassanShikyuFushikyuKettei(
                        被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, 履歴番号);
                高額決定result = buid高額決定(高額決定result).added();
                処理モード = ONE;
                KogakuGassanKyufuJissekiResult kogakuResult = KogakuGassanShikyuKetteiHosei.createInstance().get更新方法と作成区分(
                        被保険者番号, 支給申請書整理番号, 処理モード, div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                        getRadShikyuKubunCode().getSelectedValue(), is支給金額フラグ(para), is支給区分フラグ(para), false);
                KoshinShoriResult result = new KoshinShoriResult();
                Decimal 支給額 = KogakuGassanShikyuKetteiHosei.createInstance().get支給額(
                        div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue()).add(
                                div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                                getTxtShikyugaku().getValue());
                parameter.set更新後支給額(支給額);
                parameter.set更新後保険制度コード(THREE);
                result.setUpdate合算給付実績パラメータ(parameter);
                result.set高額合算支給不支給決定Entity(高額決定result);
                result.setWkモード(modelResult.getWkモード());
                result.set更新方法(kogakuResult.get更新方法());
                result.set作成区分(kogakuResult.get作成区分());
                KogakuGassanShikyuKetteiHosei.createInstance().isKoshinShori(result, 処理モード);
                return;
            }
            for (KogakuGassanShikyuKetteiHoseiResult 決定情報 : 決定情報list) {
                RStringBuilder builder = new RStringBuilder();
                builder.append(決定情報.get高額合算決定entity().get被保険者番号().value());
                builder.append(アンダーライン);
                builder.append(決定情報.get高額合算決定entity().get対象年度().toDateString());
                builder.append(アンダーライン);
                builder.append(決定情報.get高額合算決定entity().get保険者番号().value());
                builder.append(アンダーライン);
                builder.append(決定情報.get高額合算決定entity().get支給申請書整理番号());
                builder.append(アンダーライン);
                builder.append(決定情報.get高額合算決定entity().get履歴番号());
                高額合算決定map.put(builder.toRString(), 決定情報.get高額合算決定entity());
            }
            dgKogakuGassanShikyuFushikyuKettei_Row row = div.
                    getDgKogakuGassanShikyuFushikyuKettei().getClickedItem();
            RStringBuilder rowBuilder = new RStringBuilder();
            rowBuilder.append(row.getHihokenshaNo());
            rowBuilder.append(アンダーライン);
            rowBuilder.append(row.getTxtTaishoNendo().getValue().getYear().toString());
            rowBuilder.append(アンダーライン);
            rowBuilder.append(row.getTxtShokisaiNo());
            rowBuilder.append(アンダーライン);
            rowBuilder.append(row.getTxtRenrakuhyoSeiriNo());
            rowBuilder.append(アンダーライン);
            rowBuilder.append(row.getTxtRirekiNo());
            Decimal 更新前支給額 = Decimal.ZERO;
            if (row.getTxtShikyugaku() != null) {
                更新前支給額 = row.getTxtShikyugaku().getValue();
            }
            Decimal 支給額 = KogakuGassanShikyuKetteiHosei.createInstance().get支給額(
                    row.getTxtRenrakuhyoSeiriNo()).add(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                            getTxtShikyugaku().getValue()).subtract(更新前支給額);
            parameter.set更新後支給額(支給額);
            KogakuGassanShikyuFushikyuKettei 高額合算決定entity = 高額合算決定map.get(rowBuilder.toRString());
            if (高額合算決定entity == null) {
                return;
            }
            if (修正.equals(画面モード)) {
                処理モード = TWO;
            } else {
                処理モード = THREE;
            }
            KogakuGassanKyufuJissekiResult kogakuResult = KogakuGassanShikyuKetteiHosei.
                    createInstance().get更新方法と作成区分(被保険者番号, 支給申請書整理番号, 処理モード,
                            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                            getRadShikyuKubunCode().getSelectedValue(), is支給金額フラグ(para),
                            is支給区分フラグ(para), is支給データ(決定情報list, 高額合算決定entity));
            if (修正.equals(画面モード)) {
                高額合算決定entity = buid高額決定(高額合算決定entity);
                高額合算決定entity = 高額合算決定entity.modified();
            } else if (削除.equals(画面モード) || 照会.equals(画面モード)) {
                高額合算決定entity = 高額合算決定entity.deleted();
            }
            KoshinShoriResult result = new KoshinShoriResult();
            result.set高額合算支給不支給決定Entity(高額合算決定entity);
            result.setUpdate合算給付実績パラメータ(parameter);
            result.setWkモード(modelResult.getWkモード());
            result.set更新方法(kogakuResult.get更新方法());
            result.set作成区分(kogakuResult.get作成区分());
            KogakuGassanShikyuKetteiHosei.createInstance().isKoshinShori(result, 処理モード);
        }
    }

    private boolean is支給データ(List<KogakuGassanShikyuKetteiHoseiResult> 決定情報list,
            KogakuGassanShikyuFushikyuKettei 高額合算決定entity) {
        boolean 支給データの有無 = false;
        List<KogakuGassanShikyuKetteiHoseiResult> list = new ArrayList<>();
        for (KogakuGassanShikyuKetteiHoseiResult 決定情報 : 決定情報list) {
            if (!(決定情報.get高額合算決定entity().get保険者番号().equals(高額合算決定entity.get保険者番号())
                    && 決定情報.get高額合算決定entity().get対象年度().equals(高額合算決定entity.get対象年度())
                    && 決定情報.get高額合算決定entity().get保険者番号().equals(高額合算決定entity.get保険者番号())
                    && 決定情報.get高額合算決定entity().get支給申請書整理番号().equals(高額合算決定entity.get支給申請書整理番号())
                    && 決定情報.get高額合算決定entity().get履歴番号() == (高額合算決定entity.get履歴番号()))) {
                list.add(決定情報);
            }
        }
        for (KogakuGassanShikyuKetteiHoseiResult result : list) {
            if (result.get高額合算決定entity().get支給申請書整理番号().equals(高額合算決定entity.get支給申請書整理番号())
                    && ONE.equals(result.get高額合算決定entity().get支給区分コード())) {
                支給データの有無 = true;
                break;
            }
        }
        return 支給データの有無;
    }

    private void get高額合算給付実績(KogakuGassanShikyuGakuKeisanKekkaUpdateParameter parameter) {
        parameter.set更新後自己負担額証明書整理番号(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtJikoFutanSeiriNo().getValue());
        parameter.set更新後申請年月日(new FlexibleDate(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtShinseiYMD().getValue().toDateString()));
        parameter.set更新後決定年月日(new FlexibleDate(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtKetteiYMD().getValue().toDateString()));
        parameter.set更新後自己負担総額(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtJikoFutanSogaku().getValue());
        IUrControlData controlData = UrControlDataFactory.createInstance();
        parameter.setLoginId(controlData.getLoginInfo().getUserId());

    }

    private boolean is支給金額フラグ(KogakuGassanShikyuKetteiHoseiDetailParameter para) {
        return is比較変更数字(para.get支給額(),
                div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyugaku().getValue());
    }

    private boolean is支給区分フラグ(KogakuGassanShikyuKetteiHoseiDetailParameter para) {
        return is比較変更文字列(para.get支給区分(),
                div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getRadShikyuKubunCode().getSelectedValue());
    }

    /**
     * 決定情報項目クリアです。
     */
    public void clear決定情報() {
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtStatusFlg().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtTaishoNendo().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtHihokenshaNo().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyuSeiriNo().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().clearFromValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().clearToValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSeiriNo().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShinseiYMD().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKetteiYMD().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSogaku().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyugaku().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKyufuShurui().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtUketoriYM().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKetteiTsuchiSakuseiYMD().clearValue();
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtFurikomiTsuchiSakuseiYMD().clearValue();
    }

    /**
     * 処理モードの判定です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param モード RString
     * @return RString
     */
    public ShoriModeHanteiResult get処理モード(HihokenshaNo 被保険者番号, RString モード) {
        ShoriModeHanteiResult shmoResult = new ShoriModeHanteiResult();
        if (new RString(Boolean.TRUE.toString()).equals(div.get事業分フラグ())) {
            return shmoResult;
        }
        FlexibleYearMonth 受取年月 = FlexibleYearMonth.EMPTY;
        if (新規.equals(モード)) {
            shmoResult = KogakuGassanShikyuKetteiHosei.createInstance().shoriModeHantei(
                    被保険者番号, new HokenshaNo(div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue()),
                    div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue(),
                    new FlexibleYear(div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue().getYear().toDateString()),
                    FlexibleYearMonth.EMPTY, RString.EMPTY, ONE);
        } else if (修正.equals(モード)) {
            dgKogakuGassanShikyuFushikyuKettei_Row 選択行データ
                    = div.getDgKogakuGassanShikyuFushikyuKettei().getClickedItem();
            if (選択行データ == null) {
                return shmoResult;
            }
            if (選択行データ.getTxtUketoriNengetsu().getValue() != null && !選択行データ.
                    getTxtUketoriNengetsu().getValue().isEmpty()) {
                受取年月 = 選択行データ.getTxtUketoriNengetsu().getValue().getYearMonth();
            }
            shmoResult = KogakuGassanShikyuKetteiHosei.createInstance().shoriModeHantei(
                    被保険者番号, new HokenshaNo(選択行データ.getTxtShokisaiNo()),
                    選択行データ.getTxtRenrakuhyoSeiriNo(),
                    new FlexibleYear(選択行データ.getTxtTaishoNendo().getValue().getYear().toDateString()),
                    受取年月, 選択行データ.getTxtShikyuKubun(), TWO);
        } else if (削除.equals(モード)) {
            dgKogakuGassanShikyuFushikyuKettei_Row 選択行データ
                    = div.getDgKogakuGassanShikyuFushikyuKettei().getClickedItem();
            if (選択行データ == null) {
                return shmoResult;
            }
            if (選択行データ.getTxtUketoriNengetsu().getValue() != null && !選択行データ.
                    getTxtUketoriNengetsu().getValue().isEmpty()) {
                受取年月 = 選択行データ.getTxtUketoriNengetsu().getValue().getYearMonth();
            }
            shmoResult = KogakuGassanShikyuKetteiHosei.createInstance().shoriModeHantei(被保険者番号, new HokenshaNo(
                    選択行データ.getTxtShokisaiNo()), 選択行データ.getTxtRenrakuhyoSeiriNo(),
                    new FlexibleYear(選択行データ.getTxtTaishoNendo().getValue().getYear().toDateString()),
                    受取年月, 選択行データ.getTxtShikyuKubun(), THREE);
        }
        return shmoResult;
    }

    /**
     * エラーメッセージ取得
     *
     * @param メッセージ RString
     * @return Message
     */
    public Message getエラーメッセージ(RString メッセージ) {
        Message message = Message.NO_MESSAGE;
        if (メッセージ != null && !メッセージ.isEmpty() && ResponseHolder.getState().
                equals(DBC1230011StateName.支給決定情報補正.getName())) {
            if (支給決定情報補正判定MSG1.equals(メッセージ)) {
                message = DbcInformationMessages.支給決定情報補正判定Msg1.getMessage();
            } else if (支給決定情報補正判定MSG2.equals(メッセージ)) {
                message = DbcInformationMessages.支給決定情報補正判定Msg2.getMessage();
            } else if (支給決定情報補正判定MSG3.equals(メッセージ)) {
                message = DbcInformationMessages.支給決定情報補正判定Msg3.getMessage();
            } else if (支給決定情報補正判定MSG4.equals(メッセージ)) {
                message = DbcInformationMessages.支給決定情報補正判定Msg4.getMessage();
            } else if (支給決定情報補正判定MSG5.equals(メッセージ)) {
                message = DbcInformationMessages.支給決定情報補正判定Msg5.getMessage();
            } else if (支給決定情報補正判定MSG6.equals(メッセージ)) {
                message = DbcInformationMessages.支給決定情報補正判定Msg6.getMessage();
            }
        }
        return message;
    }

    /**
     * 状態1の設定です。
     */
    public void set状態_One() {
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().setFromDisabled(true);
        if (不支給.equals(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getRadShikyuKubunCode().getSelectedValue())) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKyufuShurui().setDisabled(true);
        }
    }

    /**
     * 状態2の設定です。
     *
     * @param flag boolean
     */
    public void set状態_Two(boolean flag) {
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTplKettei().setDisabled(flag);
    }

    /**
     * 状態3の設定です。
     */
    public void set状態_Three() {
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTplKettei().setDisabled(true);
    }

    /**
     * 状態4の設定です。
     */
    public void set状態_Four() {
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().setFromDisabled(true);
    }

    /**
     * 状態5の設定です。
     */
    public void set状態_Five() {
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().setFromDisabled(true);
    }

    /**
     * 支払方法タブ設定です。
     *
     */
    public void release支払方法タブ() {
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTplShiharai().setDisabled(false);
    }

    /**
     * 支給区分連動の設定です。
     */
    public void set支給区分連動() {
        if (ShikyuFushikyuKubun.支給.get名称().equals(
                div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getRadShikyuKubunCode().getSelectedValue())) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getLabel2().setText(備考);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKyufuShurui().setDisabled(false);
        } else if (ShikyuFushikyuKubun.不支給.get名称().equals(
                div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getRadShikyuKubunCode().getSelectedValue())) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getLabel2().setText(不支給の理由);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKyufuShurui().setDisabled(true);
        }
    }

    /**
     * 決定情報タブ初期化データです。
     *
     * @return KogakuGassanShikyuKetteiHoseiDetailParameter
     */
    public KogakuGassanShikyuKetteiHoseiDetailParameter get決定情報タブ() {
        KogakuGassanShikyuKetteiHoseiDetailParameter parameter = new KogakuGassanShikyuKetteiHoseiDetailParameter();
        parameter.set対象計算期間開始年月日(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtKeisanYMD().getFromValue());
        parameter.set対象計算期間終了年月日(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtKeisanYMD().getToValue());
        parameter.set自己負担額証明書整理番号(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtJikoFutanSeiriNo().getText());
        parameter.set申請日(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtShinseiYMD().getValue());
        parameter.set決定日(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtKetteiYMD().getValue());
        parameter.set自己負担総額(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtJikoFutanSogaku().getValue());
        parameter.set支給区分(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getRadShikyuKubunCode().getSelectedValue());
        parameter.set支給額(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtShikyugaku().getValue());
        parameter.set給付の種類(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtKyufuShurui().getText());
        parameter.set備考(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtBiko().getText());
        parameter.set受取年月(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtUketoriYM().getValue());
        parameter.set決定通知書作成日(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtKetteiTsuchiSakuseiYMD().getValue());
        parameter.set振込明細書作成日(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtFurikomiTsuchiSakuseiYMD().getValue());
        parameter.set窓口払い_支払場所(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getCcdShiharaiHohoJoho().getShiharaiBasho());
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getStartYMD() != null) {
            parameter.set窓口払い_開始日(new RString(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getCcdShiharaiHohoJoho().getStartYMD().toString()));
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getEndYMD() != null) {
            parameter.set窓口払い_終了日(new RString(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getCcdShiharaiHohoJoho().getEndYMD().toString()));
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getStartHHMM() != null) {
            parameter.set窓口払い_開始時間(new RString(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getCcdShiharaiHohoJoho().getStartHHMM().toString()));
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getEndHHMM() != null) {
            parameter.set窓口払い_終了時間(new RString(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getCcdShiharaiHohoJoho().getEndHHMM().toString()));
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getKozaNo() != null) {
            parameter.set口座払い_口座ＩＤ(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getCcdShiharaiHohoJoho().getKozaNo());
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getKeiyakuNo() != null) {
            parameter.set受領委任払い_契約番号(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getCcdShiharaiHohoJoho().getKeiyakuNo());
        }
        return parameter;
    }

    /**
     * 画面tap設定です。
     */
    public void set画面tap() {
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTabKogakuGassanShikyuFushikyuKettei().setSelectedItem(
                div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTplKettei());
    }

    /**
     * 保存ボタン。
     */
    public void set保存ボタン() {
        if (照会.equals(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtStatusFlg().getValue())
                && ResponseHolder.getState().equals(DBC1230011StateName.支給決定情報補正.getName())) {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(決定情報を, false);
        }
    }

    /**
     * 決定情報内容変更状態です。
     *
     * @param parameter KogakuGassanShikyuKetteiHoseiDetailParameter
     * @return is申請情報登録内容変更状態
     */
    public boolean is決定情報内容変更状態(KogakuGassanShikyuKetteiHoseiDetailParameter parameter) {
        return is比較変更年月日(parameter.get対象計算期間開始年月日(),
                div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getFromValue())
                || is比較変更年月日(parameter.get対象計算期間終了年月日(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getToValue())
                || is比較変更文字列(parameter.get自己負担額証明書整理番号(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSeiriNo().getText())
                || is比較変更年月日(parameter.get申請日(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShinseiYMD().getValue())
                || is比較変更年月日(parameter.get決定日(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKetteiYMD().getValue())
                || is比較変更数字(parameter.get自己負担総額(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSogaku().getValue())
                || is比較変更文字列(parameter.get支給区分(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getRadShikyuKubunCode().getSelectedValue())
                || is比較変更数字(parameter.get支給額(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyugaku().getValue())
                || is比較変更文字列(parameter.get給付の種類(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKyufuShurui().getValue())
                || is比較変更文字列(parameter.get備考(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().getText())
                || is比較変更年月日(parameter.get受取年月(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtUketoriYM().getValue())
                || is比較変更年月日(parameter.get決定通知書作成日(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKetteiTsuchiSakuseiYMD().getValue())
                || is比較変更年月日(parameter.get振込明細書作成日(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtFurikomiTsuchiSakuseiYMD().getValue())
                || is支払方法タブ(parameter);
    }

    private JigyoKogakuGassanShikyuFushikyuKettei buid事業高額決定(JigyoKogakuGassanShikyuFushikyuKettei entity) {
        entity = entity.createBuilderForEdit().set保険制度コード(THREE)
                .set自己負担総額(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                        getTxtJikoFutanSogaku().getValue())
                .set支給区分コード(ShikyuFushikyuKubun.valueOf(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                                getRadShikyuKubunCode().getSelectedValue().toString()).getコード())
                .set支給額(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyugaku().getValue())
                .set自己負担額証明書整理番号(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                        getTxtJikoFutanSeiriNo().getText())
                .build();
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getFromValue() != null) {
            entity = entity.createBuilderForEdit().set対象計算期間開始年月日(new FlexibleDate(
                    div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKeisanYMD().getFromValue().toDateString())).build();
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getToValue() != null) {
            entity = entity.createBuilderForEdit().set対象計算期間終了年月日(new FlexibleDate(
                    div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKeisanYMD().getToValue().toDateString())).build();
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShinseiYMD().getValue() != null) {
            entity = entity.createBuilderForEdit().set申請年月日(new FlexibleDate(
                    div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtShinseiYMD().getValue().toDateString())).build();
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKetteiYMD().getValue() != null) {
            entity = entity.createBuilderForEdit().set決定年月日(new FlexibleDate(
                    div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKetteiYMD().getValue().toDateString())).build();
        }
        if (支給.equals(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getRadShikyuKubunCode().getSelectedValue())) {
            entity = entity.createBuilderForEdit().set給付の種類(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKyufuShurui().getValue())
                    .set備考(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                            getTxtBiko().getText())
                    .build();
        } else {
            entity = entity.createBuilderForEdit().set不支給理由(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtBiko().getText()).build();
        }
        entity = entity.createBuilderForEdit().set支払方法区分(div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getShiharaiHohoRad())
                .set支払場所(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                        getCcdShiharaiHohoJoho().getShiharaiBasho()).build();
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getStartYMD() != null) {
            entity = entity.createBuilderForEdit().set支払期間開始年月日(new FlexibleDate(div.
                    getKogakuGassanShikyuKetteiHoseiDetailPanel()
                    .getCcdShiharaiHohoJoho().getStartYMD().toString())).build();
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getEndYMD() != null) {
            entity = entity.createBuilderForEdit().set支払期間終了年月日(new FlexibleDate(div.
                    getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().
                    getEndYMD().toString())).build();

        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getStartHHMM() != null) {
            RString 時間 = new RString(div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                    .getCcdShiharaiHohoJoho().getStartHHMM().toString());
            entity = entity.createBuilderForEdit().set支払期間開始時間(
                    時間.substring(NUM_0, NUM_2).concat(時間.substring(NUM_3, NUM_5))).build();
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getEndHHMM() != null) {
            RString 時間 = new RString(div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                    .getCcdShiharaiHohoJoho().getEndHHMM().toString());
            entity = entity.createBuilderForEdit().set支払期間終了時間(
                    時間.substring(NUM_0, NUM_2).concat(時間.substring(NUM_3, NUM_5))).build();
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getKozaNo() != null
                && !div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getKozaNo().isEmpty()) {
            entity = entity.createBuilderForEdit().set口座ID(
                    Long.parseLong(div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                            .getCcdShiharaiHohoJoho().getKozaNo().toString())).build();
        }
        return entity;
    }

    private KogakuGassanShikyuFushikyuKettei buid高額決定(KogakuGassanShikyuFushikyuKettei entity) {
        entity = entity.createBuilderForEdit().set保険制度コード(THREE)
                .set自己負担総額(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                        getTxtJikoFutanSogaku().getValue())
                .set支給区分コード(ShikyuFushikyuKubun.valueOf(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                                getRadShikyuKubunCode().getSelectedValue().toString()).getコード())
                .set支給額(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyugaku().getValue())
                .set自己負担額証明書整理番号(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                        getTxtJikoFutanSeiriNo().getText())
                .build();
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getFromValue() != null) {
            entity = entity.createBuilderForEdit().set対象計算期間開始年月日(new FlexibleDate(
                    div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKeisanYMD().getFromValue().toDateString())).build();
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getToValue() != null) {
            entity = entity.createBuilderForEdit().set対象計算期間終了年月日(new FlexibleDate(
                    div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKeisanYMD().getToValue().toDateString())).build();
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShinseiYMD().getValue() != null) {
            entity = entity.createBuilderForEdit().set申請年月日(new FlexibleDate(
                    div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtShinseiYMD().getValue().toDateString())).build();
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKetteiYMD().getValue() != null) {
            entity = entity.createBuilderForEdit().set決定年月日(new FlexibleDate(
                    div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKetteiYMD().getValue().toDateString())).build();
        }
        if (支給.equals(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getRadShikyuKubunCode().getSelectedValue())) {
            entity = entity.createBuilderForEdit().set給付の種類(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKyufuShurui().getValue())
                    .set備考(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                            getTxtBiko().getText())
                    .build();
        } else {
            entity = entity.createBuilderForEdit().set不支給理由(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtBiko().getText()).build();
        }
        entity = entity.createBuilderForEdit().set支払方法区分(div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getShiharaiHohoRad())
                .set支払場所(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                        getCcdShiharaiHohoJoho().getShiharaiBasho()).build();
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getStartYMD() != null) {
            entity = entity.createBuilderForEdit().set支払期間開始年月日(new FlexibleDate(div.
                    getKogakuGassanShikyuKetteiHoseiDetailPanel()
                    .getCcdShiharaiHohoJoho().getStartYMD().toString())).build();
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getEndYMD() != null) {
            entity = entity.createBuilderForEdit().set支払期間終了年月日(new FlexibleDate(div.
                    getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().
                    getEndYMD().toString())).build();

        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getStartHHMM() != null) {
            RString 時間 = new RString(div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                    .getCcdShiharaiHohoJoho().getStartHHMM().toString());
            entity = entity.createBuilderForEdit().set支払期間開始時間(
                    時間.substring(NUM_0, NUM_2).concat(時間.substring(NUM_3, NUM_5))).build();
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getEndHHMM() != null) {
            RString 時間 = new RString(div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                    .getCcdShiharaiHohoJoho().getEndHHMM().toString());
            entity = entity.createBuilderForEdit().set支払期間終了時間(
                    時間.substring(NUM_0, NUM_2).concat(時間.substring(NUM_3, NUM_5))).build();
        }
        if (div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getKozaNo() != null
                && !div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                .getCcdShiharaiHohoJoho().getKozaNo().isEmpty()) {
            entity = entity.createBuilderForEdit().set口座ID(
                    Long.parseLong(div.getKogakuGassanShikyuKetteiHoseiDetailPanel()
                            .getCcdShiharaiHohoJoho().getKozaNo().toString())).build();
        }
        return entity;
    }

    private boolean is支払方法タブ(KogakuGassanShikyuKetteiHoseiDetailParameter parameter) {
        return is比較変更文字列(parameter.get窓口払い_支払場所(),
                div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getShiharaiBasho())
                || is比較変更日(parameter.get窓口払い_開始日(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getStartYMD())
                || is比較変更日(parameter.get窓口払い_終了日(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getEndYMD())
                || is比較変更時間(parameter.get窓口払い_開始時間(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getStartHHMM())
                || is比較変更時間(parameter.get窓口払い_終了時間(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getEndHHMM())
                || is比較変更文字列(parameter.get口座払い_口座ＩＤ(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getKozaNo())
                || is比較変更文字列(parameter.get受領委任払い_契約番号(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().getKeiyakuNo());
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

    private boolean is比較変更日(RString s1, RDate s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(new RString(s2.toString()));
        }
    }

    private boolean is比較変更時間(RString s1, RTime s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(new RString(s2.toString()));
        }
    }

    private boolean is比較変更年月日(RDate s1, RDate s2) {
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

    private void set支払方法タブ(
            HihokenshaNo 被保険者番号,
            RString 処理モデル,
            ShikibetsuCode 識別コード,
            dgKogakuGassanShikyuFushikyuKettei_Row row) {
        SikyuSinseiJyohoParameter para = new SikyuSinseiJyohoParameter();
        para.setShikibetsuCode(識別コード);
        if (新規.equals(処理モデル)) {
            para.setHihokenshaNo(被保険者番号);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().initialize(para, 登録);
        } else if (修正.equals(処理モデル)) {
            para.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(row.getShiharaiHohoKubun()));
            para.setKozaId(Long.parseLong(row.getKozaID().toString()));
            para.setHihokenshaNo(new HihokenshaNo(row.getHihokenshaNo()));
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().initialize(para, 修正);
        } else if (削除.equals(処理モデル) || 照会.equals(処理モデル)) {
            para.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(row.getShiharaiHohoKubun()));
            para.setHihokenshaNo(new HihokenshaNo(row.getHihokenshaNo()));
            para.setKozaId(Long.parseLong(row.getKozaID().toString()));
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().initialize(para, 照会);
        }
    }

}
