/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1230011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.HihokenshaDaichoResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.KogakuGassanShikyuKetteiHoseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.ShoriModeHanteiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.KogakuGassanShikyuKetteiHoseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.dgKogakuGassanShikyuFushikyuKettei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc1230011.KogakuGassanShikyuKetteiHoseiDetailParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassanshikyuketteihosei.KogakuGassanShikyuKetteiHosei;
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
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 画面設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-010 quxiaodong
 */
public class KogakuGassanShikyuKetteiHoseiPanelHandler {

    private final KogakuGassanShikyuKetteiHoseiPanelDiv div;
    private static final RString 事業分支給決定情報補正 = new RString("DBCMNN1005");
    private static final RString CODE_ミ = new RString("0003");
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
    private static final RString 支給決定情報補正判定MSG1 = new RString("支給決定情報補正判定Msg1");
    private static final RString 支給決定情報補正判定MSG2 = new RString("支給決定情報補正判定Msg2");
    private static final RString 支給決定情報補正判定MSG3 = new RString("支給決定情報補正判定Msg3");
    private static final RString 支給決定情報補正判定MSG4 = new RString("支給決定情報補正判定Msg4");
    private static final RString 支給決定情報補正判定MSG5 = new RString("支給決定情報補正判定Msg5");
    private static final RString 支給決定情報補正判定MSG6 = new RString("支給決定情報補正判定Msg6");
    private static final int NUM_EIGHT = 8;
    private static final int NUM_SEVEN = 7;

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
        IUrControlData controlData = UrControlDataFactory.createInstance();
        LockingKey 排他キー = new LockingKey(controlData.getMenuID());
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
                throw new ApplicationException(DbcInformationMessages.被保険者または事業対象者でないデータ.getMessage());
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
        if (NUM_EIGHT <= システムタイム.getMonthValue()) {
            システム年度 = システム年度.minusYear(1);
        } else if (システムタイム.getMonthValue() <= NUM_SEVEN) {
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
                row.getTxtTaishoNendo().setValue(new FlexibleDate(entity.get事業高額合算決定entity().
                        get対象年度().toDateString()));
                row.setTxtShokisaiNo(entity.get事業高額合算決定entity().get保険者番号().value());
                row.setTxtRenrakuhyoSeiriNo(entity.get事業高額合算決定entity().get支給申請書整理番号());
                row.setTxtRirekiNo(new RString(entity.get事業高額合算決定entity().get履歴番号()));
                row.setTxtJikoFutangaku(new RString(entity.get事業高額合算決定entity().get自己負担総額().intValue()));
                row.setTxtShikyuKubun(entity.get事業高額合算決定entity().get支払方法区分());
                row.setTxtShikyugaku(new RString(entity.get事業高額合算決定entity().get支給額().intValue()));
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
                rowList.add(row);
            } else {
                row.setHihokenshaNo(entity.get高額合算決定entity().get被保険者番号().value());
                row.getTxtTaishoNendo().setValue(new FlexibleDate(
                        entity.get高額合算決定entity().get対象年度().toDateString()));
                row.setTxtShokisaiNo(entity.get高額合算決定entity().get保険者番号().value());
                row.setTxtRenrakuhyoSeiriNo(entity.get高額合算決定entity().get支給申請書整理番号());
                row.setTxtRirekiNo(new RString(entity.get高額合算決定entity().get履歴番号()));
                row.setTxtJikoFutangaku(new RString(entity.get高額合算決定entity().get自己負担総額().intValue()));
                row.setTxtShikyuKubun(entity.get高額合算決定entity().get支払方法区分());
                row.setTxtShikyugaku(new RString(entity.get高額合算決定entity().get支給額().intValue()));
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
                getTxtTaishoNendo().getValue().equals(定値_年度年度)) {
            RString 開始計算対象期間 = div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtTaishoNendo().getValue().toDateString().concat(定値_日付1);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKeisanYMD().setFromValue(new RDate(開始計算対象期間.toString()));
        } else {
            RString 開始計算対象期間 = div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtTaishoNendo().getValue().toDateString().concat(定値_日付2);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKeisanYMD().setFromValue(new RDate(開始計算対象期間.toString()));
        }
        RString 終了計算対象期間 = div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtTaishoNendo().getValue().plusYear(1).toDateString().concat(定値_日付3);
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtKeisanYMD().setToValue(new RDate(終了計算対象期間.toString()));
        HihokenshaDaichoResult 被保険者台帳管理情報 = KogakuGassanShikyuKetteiHosei.
                createInstance().getHihokenshaDaicho(被保険者番号);
        if (被保険者台帳管理情報 != null && 被保険者台帳管理情報.get資格喪失年月日() != null
                && (div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().
                getFromValue().isBefore(被保険者台帳管理情報.get資格喪失年月日().plusDay(1))
                || div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().
                getFromValue().equals(被保険者台帳管理情報.get資格喪失年月日().plusDay(1)))
                && (被保険者台帳管理情報.get資格喪失年月日().plusDay(1).
                isBefore(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getToValue())
                || 被保険者台帳管理情報.get資格喪失年月日().plusDay(1).
                equals(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().getToValue()))
                && 定値_喪失事由コード.equals(被保険者台帳管理情報.get喪失事由コード())) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKeisanYMD().
                    setToValue(被保険者台帳管理情報.get資格喪失年月日().plusDay(1));
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
        set高額口座情報エリア(被保険者番号, 新規, 識別コード, null);
    }

    /**
     * 新規以外の決定情報初期値取得設定です。
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
        if (row.getKeisanKaishiYMD().getValue() != null) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKeisanYMD().setFromValue(new RDate(row.getKeisanKaishiYMD().getValue().toString()));
        }
        if (row.getKeisanShuryoYMD().getValue() != null) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtKeisanYMD().setToValue(new RDate(row.getKeisanShuryoYMD().toString()));
        }
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSeiriNo().setValue(row.getJikoFutanSeiriNo());
        if (row.getShinseiYMD().getValue() != null) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShinseiYMD().
                    setValue(new RDate(row.getShinseiYMD().getValue().toString()));
        }
        if (row.getKetteiYMD().getValue() != null) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKetteiYMD().
                    setValue(new RDate(row.getKetteiYMD().getValue().toString()));
        }
        if (row.getTxtJikoFutangaku() != null && !row.getTxtJikoFutangaku().isEmpty()) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtJikoFutanSogaku().setValue(new Decimal(row.getTxtJikoFutangaku().toString()));
        }
        if (row.getTxtShikyuKubun() != null && !row.getTxtShikyuKubun().isEmpty()
                && ShikyuFushikyuKubun.支給.getコード().equals(row.getTxtShikyuKubun())) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getRadShikyuKubunCode().setSelectedValue(支給);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().setLabelLText(備考);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().setValue(row.getBiko());
        } else if (row.getTxtShikyuKubun() != null && !row.getTxtShikyuKubun().isEmpty()
                && ShikyuFushikyuKubun.不支給.getコード().equals(row.getTxtShikyuKubun())) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getRadShikyuKubunCode().setSelectedValue(不支給);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().setLabelLText(不支給の理由);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().setValue(row.getFushikyuRiyu());
        }
        if (row.getTxtShikyugaku() != null && !row.getTxtShikyugaku().isEmpty()) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtShikyugaku().setValue(new Decimal(row.getTxtShikyugaku().toString()));
        }
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKyufuShurui().setValue(row.getKyufuShurui());
        if (row.getTxtUketoriNengetsu().getValue() != null) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                    getTxtUketoriYM().setValue(new RDate(row.getTxtUketoriNengetsu().getValue().toString()));
        }
        if (row.getKetteiTsuchiSakuseiYMD().getValue() != null) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKetteiTsuchiSakuseiYMD().
                    setValue(new RDate(row.getKetteiTsuchiSakuseiYMD().getValue().toString()));
        }
        if (row.getFurikomiTsuchiSakuseiYMD().getValue() != null) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtFurikomiTsuchiSakuseiYMD().
                    setValue(new RDate(row.getFurikomiTsuchiSakuseiYMD().getValue().toString()));
        }
        set高額口座情報エリア(HihokenshaNo.EMPTY, 処理モデル, 識別コード, row);
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
    public RString get処理モード(HihokenshaNo 被保険者番号, RString モード) {
        ShoriModeHanteiResult shmoResult = new ShoriModeHanteiResult();
        if (新規.equals(モード)) {
            shmoResult = KogakuGassanShikyuKetteiHosei.createInstance().shoriModeHantei(
                    被保険者番号, new HokenshaNo(div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue()),
                    div.getShinkiPanel().getTxtShinkiShikyuSeiriNo().getValue(),
                    new FlexibleYear(div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue().toDateString()),
                    FlexibleYearMonth.EMPTY, RString.EMPTY, ONE);
        } else if (修正.equals(モード)) {
            dgKogakuGassanShikyuFushikyuKettei_Row 選択行データ
                    = div.getDgKogakuGassanShikyuFushikyuKettei().getClickedItem();
            shmoResult = KogakuGassanShikyuKetteiHosei.createInstance().shoriModeHantei(
                    被保険者番号, new HokenshaNo(選択行データ.getTxtShokisaiNo()),
                    選択行データ.getTxtRenrakuhyoSeiriNo(),
                    選択行データ.getTxtTaishoNendo().getValue().getYear(),
                    選択行データ.getTxtUketoriNengetsu().getValue().getYearMonth(),
                    選択行データ.getTxtShikyuKubun(), TWO);
        } else if (削除.equals(モード)) {
            dgKogakuGassanShikyuFushikyuKettei_Row 選択行データ
                    = div.getDgKogakuGassanShikyuFushikyuKettei().getClickedItem();
            shmoResult = KogakuGassanShikyuKetteiHosei.createInstance().shoriModeHantei(被保険者番号, new HokenshaNo(
                    選択行データ.getTxtShokisaiNo()), 選択行データ.getTxtRenrakuhyoSeiriNo(),
                    選択行データ.getTxtTaishoNendo().getValue().getYear(),
                    選択行データ.getTxtUketoriNengetsu().getValue().getYearMonth(),
                    選択行データ.getTxtShikyuKubun(), THREE);
        }
        if (shmoResult.getWkメッセージ() != null && !shmoResult.getWkメッセージ().isEmpty()) {
            getErrorMessage(shmoResult.getWkメッセージ());
        }
        return shmoResult.getWkモード();
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
     */
    public void set状態_Two() {
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTplKettei().setDisabled(true);
    }

    /**
     * 状態3の設定です。
     */
    public void set状態_Three() {
        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTplKettei().setDisabled(true);
    }

    /**
     * 支給区分連動の設定です。
     */
    public void set支給区分連動() {
        if (ShikyuFushikyuKubun.支給.get名称().equals(
                div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getRadShikyuKubunCode().getSelectedValue())) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().setLabelLText(備考);
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKyufuShurui().setDisabled(false);
        } else if (ShikyuFushikyuKubun.不支給.get名称().equals(
                div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getRadShikyuKubunCode().getSelectedValue())) {
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().setLabelLText(不支給の理由);
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
                getTxtJikoFutanSeiriNo().getValue());
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
                getTxtKyufuShurui().getValue());
        parameter.set備考(div.getKogakuGassanShikyuKetteiHoseiDetailPanel().
                getTxtBiko().getValue());
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
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSeiriNo().getValue())
                || is比較変更年月日(parameter.get申請日(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShinseiYMD().getValue())
                || is比較変更年月日(parameter.get決定日(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShinseiYMD().getValue())
                || is比較変更数字(parameter.get自己負担総額(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtJikoFutanSogaku().getValue())
                || is比較変更文字列(parameter.get支給区分(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getRadShikyuKubunCode().getSelectedValue())
                || is比較変更数字(parameter.get支給額(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtShikyugaku().getValue())
                || is比較変更文字列(parameter.get給付の種類(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKyufuShurui().getValue())
                || is比較変更文字列(parameter.get備考(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtBiko().getValue())
                || is比較変更年月日(parameter.get受取年月(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtUketoriYM().getValue())
                || is比較変更年月日(parameter.get決定通知書作成日(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtKetteiTsuchiSakuseiYMD().getValue())
                || is比較変更年月日(parameter.get振込明細書作成日(),
                        div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getTxtFurikomiTsuchiSakuseiYMD().getValue())
                || is支払方法タブ(parameter);
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

    private void set高額口座情報エリア(
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
            para.setKozaId(Long.parseLong(row.getKozaID().toString()));
            para.setHihokenshaNo(new HihokenshaNo(row.getHihokenshaNo()));
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().initialize(para, 修正);
        } else if (削除.equals(処理モデル) || 照会.equals(処理モデル)) {
            para.setHihokenshaNo(new HihokenshaNo(row.getHihokenshaNo()));
            para.setKozaId(Long.parseLong(row.getKozaID().toString()));
            div.getKogakuGassanShikyuKetteiHoseiDetailPanel().getCcdShiharaiHohoJoho().initialize(para, 照会);
        }
    }

    private void getErrorMessage(RString メッセージ) {
        if (支給決定情報補正判定MSG1.equals(メッセージ)) {
            throw new ApplicationException(
                    DbcErrorMessages.支給決定情報補正判定Msg1.getMessage());
        } else if (支給決定情報補正判定MSG2.equals(メッセージ)) {
            throw new ApplicationException(
                    DbcErrorMessages.支給決定情報補正判定Msg2.getMessage());
        } else if (支給決定情報補正判定MSG3.equals(メッセージ)) {
            throw new ApplicationException(
                    DbcErrorMessages.支給決定情報補正判定Msg3.getMessage());
        } else if (支給決定情報補正判定MSG4.equals(メッセージ)) {
            throw new ApplicationException(
                    DbcErrorMessages.支給決定情報補正判定Msg4.getMessage());
        } else if (支給決定情報補正判定MSG5.equals(メッセージ)) {
            throw new ApplicationException(
                    DbcErrorMessages.支給決定情報補正判定Msg5.getMessage());
        } else if (支給決定情報補正判定MSG6.equals(メッセージ)) {
            throw new ApplicationException(
                    DbcErrorMessages.支給決定情報補正判定Msg6.getMessage());
        }
    }

}
