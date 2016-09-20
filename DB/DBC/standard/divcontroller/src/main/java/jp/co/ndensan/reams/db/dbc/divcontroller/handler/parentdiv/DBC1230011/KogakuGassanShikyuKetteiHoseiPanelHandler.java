/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1230011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.KogakuGassanShikyuKetteiHoseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.ShoriModeHanteiResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.KogakuGassanShikyuKetteiHoseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1230011.dgKogakuGassanShikyuFushikyuKettei_Row;
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
    private static final RString 被保番号 = new RString("被保険者番号");
    private static final RString 新規 = new RString("新規");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
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
                FlexibleYear 対象年度 = entity.get事業高額合算決定entity().get対象年度();
                RString 保険者番号 = entity.get事業高額合算決定entity().get保険者番号().value();
                RString 連絡票整理番号 = entity.get事業高額合算決定entity().get支給申請書整理番号();
                RString 履歴番号 = new RString(entity.get事業高額合算決定entity().get履歴番号());
                Decimal 自己負担額 = entity.get事業高額合算決定entity().get自己負担総額();
                RString 支給区分 = entity.get事業高額合算決定entity().get支払方法区分();
                Decimal 支給額 = entity.get事業高額合算決定entity().get支給額();
                FlexibleYearMonth 受取年月 = entity.get事業高額合算決定entity().get受取年月();
                row.getTxtTaishoNendo().setValue(new FlexibleDate(対象年度.toDateString()));
                row.setTxtShokisaiNo(保険者番号);
                row.setTxtRenrakuhyoSeiriNo(連絡票整理番号);
                row.setTxtRirekiNo(履歴番号);
                row.setTxtJikoFutangaku(new RString(自己負担額.intValue()));
                row.setTxtShikyuKubun(支給区分);
                row.setTxtShikyugaku(new RString(支給額.intValue()));
                row.getTxtUketoriNengetsu().setValue(new FlexibleDate(受取年月.toDateString()));
                row.setChkisDeleted(new RString(Boolean.TRUE.toString()));
                rowList.add(row);
            } else {
                FlexibleYear 対象年度 = entity.get高額合算決定entity().get対象年度();
                RString 保険者番号 = entity.get高額合算決定entity().get保険者番号().value();
                RString 連絡票整理番号 = entity.get高額合算決定entity().get支給申請書整理番号();
                RString 履歴番号 = new RString(entity.get高額合算決定entity().get履歴番号());
                Decimal 自己負担額 = entity.get高額合算決定entity().get自己負担総額();
                RString 支給区分 = entity.get高額合算決定entity().get支払方法区分();
                Decimal 支給額 = entity.get高額合算決定entity().get支給額();
                FlexibleYearMonth 受取年月 = entity.get高額合算決定entity().get受取年月();
                row.getTxtTaishoNendo().setValue(new FlexibleDate(対象年度.toDateString()));
                row.setTxtShokisaiNo(保険者番号);
                row.setTxtRenrakuhyoSeiriNo(連絡票整理番号);
                row.setTxtRirekiNo(履歴番号);
                row.setTxtJikoFutangaku(new RString(自己負担額.intValue()));
                row.setTxtShikyuKubun(支給区分);
                row.setTxtShikyugaku(new RString(支給額.intValue()));
                row.getTxtUketoriNengetsu().setValue(new FlexibleDate(受取年月.toDateString()));
                row.setChkisDeleted(new RString(Boolean.FALSE.toString()));
                rowList.add(row);
            }
        }
        div.getDgKogakuGassanShikyuFushikyuKettei().setDataSource(rowList);
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
                    div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue(),
                    new FlexibleYear(div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue().toDateString()),
                    FlexibleYearMonth.EMPTY, RString.EMPTY, ONE);
        } else if (修正.equals(モード) || 削除.equals(モード)) {
            //TODO
            shmoResult = KogakuGassanShikyuKetteiHosei.createInstance().shoriModeHantei(
                    被保険者番号, new HokenshaNo(div.getShinkiPanel().getTxtShinkiHihokenshaNo().getValue()),
                    div.getSearchPanel().getTxtKensakuShikyuSeiriNo().getValue(),
                    new FlexibleYear(div.getShinkiPanel().getTxtShinkiTaishoNendo().getValue().toDateString()),
                    FlexibleYearMonth.EMPTY, RString.EMPTY, ONE);
        }
        return shmoResult.getWkモード();
    }

}
