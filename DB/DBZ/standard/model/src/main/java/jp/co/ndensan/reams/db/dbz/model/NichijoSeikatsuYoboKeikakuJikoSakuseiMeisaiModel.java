/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 日常生活予防給付計画自己作成明細のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel implements Serializable {

    private DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity;

    /**
     * コンストラクタです。
     */
    public NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel() {
        entity = new DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity
     */
    public NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiModel(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityを返します。
     *
     * @return DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity
     */
    public DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityを設定します。
     *
     * @param entity DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity
     */
    public void setEntity(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 対象年月を返します。
     *
     * @return 対象年月
     */
    public FlexibleYearMonth get対象年月() {
        return entity.getTaishoYM();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 居宅サービス区分を返します。
     *
     * @return 居宅サービス区分
     */
    public RString get居宅サービス区分() {
        return entity.getKyotakuServiceKubun();
    }

    /**
     * サービス提供事業者番号を返します。
     *
     * @return サービス提供事業者番号
     */
    public JigyoshaNo getサービス提供事業者番号() {
        return entity.getServiceTeikyoJigyoshaNo();
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getサービス項目コード() {
        return entity.getServiceKomokuCode();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public Decimal get単位数() {
        return entity.getTaniSu();
    }

    /**
     * 回数_日数を返します。
     *
     * @return 回数_日数
     */
    public Decimal get回数_日数() {
        return entity.getKaisu_Nissu();
    }

    /**
     * 種類限度内単位数_日数を返します。
     *
     * @return 種類限度内単位数_日数
     */
    public Decimal get種類限度内単位数_日数() {
        return entity.getShuruiGendoNaiTaniSu_Nissu();
    }

    /**
     * 種類限度超過単位数_日数を返します。
     *
     * @return 種類限度超過単位数_日数
     */
    public Decimal get種類限度超過単位数_日数() {
        return entity.getShuruiGendoChokaTaniSu_Nissu();
    }

    /**
     * 区分限度内単位数_日数を返します。
     *
     * @return 区分限度内単位数_日数
     */
    public Decimal get区分限度内単位数_日数() {
        return entity.getKubunGendoNaiTaniSu_Nissu();
    }

    /**
     * 区分限度超過単位数_日数を返します。
     *
     * @return 区分限度超過単位数_日数
     */
    public Decimal get区分限度超過単位数_日数() {
        return entity.getKubunGendoChokaTaniSu_Nissu();
    }

    /**
     * 単位数単価を返します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価() {
        return entity.getTaniSuTanka();
    }

    /**
     * 給付率を返します。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu get給付率() {
        return entity.getKyufuRitsu();
    }

    /**
     * 割引後適用率を返します。
     *
     * @return 割引後適用率
     */
    public HokenKyufuRitsu get割引後適用率() {
        return entity.getWaribikiGoTekiyoRitsu();
    }

    /**
     * 割引後適用単位数を返します。
     *
     * @return 割引後適用単位数
     */
    public Decimal get割引後適用単位数() {
        return entity.getWaribikiGoTekiyoTaniSu();
    }

    /**
     * 定額利用者負担単価金額を返します。
     *
     * @return 定額利用者負担単価金額
     */
    public Decimal get定額利用者負担単価金額() {
        return entity.getTeigakuRiyoshaFutanTankaKingaku();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     */
    public void set対象年月(FlexibleYearMonth 対象年月) {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        entity.setTaishoYM(対象年月);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 居宅サービス区分を設定します。
     *
     * @param 居宅サービス区分 居宅サービス区分
     */
    public void set居宅サービス区分(RString 居宅サービス区分) {
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        entity.setKyotakuServiceKubun(居宅サービス区分);
    }

    /**
     * サービス提供事業者番号を設定します。
     *
     * @param サービス提供事業者番号 サービス提供事業者番号
     */
    public void setサービス提供事業者番号(JigyoshaNo サービス提供事業者番号) {
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     */
    public void setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     */
    public void setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     */
    public void set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTaniSu(単位数);
    }

    /**
     * 回数_日数を設定します。
     *
     * @param 回数_日数 回数_日数
     */
    public void set回数_日数(Decimal 回数_日数) {
        requireNonNull(回数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("回数_日数"));
        entity.setKaisu_Nissu(回数_日数);
    }

    /**
     * 種類限度内単位数_日数を設定します。
     *
     * @param 種類限度内単位数_日数 種類限度内単位数_日数
     */
    public void set種類限度内単位数_日数(Decimal 種類限度内単位数_日数) {
        requireNonNull(種類限度内単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("種類限度内単位数_日数"));
        entity.setShuruiGendoNaiTaniSu_Nissu(種類限度内単位数_日数);
    }

    /**
     * 種類限度超過単位数_日数を設定します。
     *
     * @param 種類限度超過単位数_日数 種類限度超過単位数_日数
     */
    public void set種類限度超過単位数_日数(Decimal 種類限度超過単位数_日数) {
        requireNonNull(種類限度超過単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("種類限度超過単位数_日数"));
        entity.setShuruiGendoChokaTaniSu_Nissu(種類限度超過単位数_日数);
    }

    /**
     * 区分限度内単位数_日数を設定します。
     *
     * @param 区分限度内単位数_日数 区分限度内単位数_日数
     */
    public void set区分限度内単位数_日数(Decimal 区分限度内単位数_日数) {
        requireNonNull(区分限度内単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("区分限度内単位数_日数"));
        entity.setKubunGendoNaiTaniSu_Nissu(区分限度内単位数_日数);
    }

    /**
     * 区分限度超過単位数_日数を設定します。
     *
     * @param 区分限度超過単位数_日数 区分限度超過単位数_日数
     */
    public void set区分限度超過単位数_日数(Decimal 区分限度超過単位数_日数) {
        requireNonNull(区分限度超過単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("区分限度超過単位数_日数"));
        entity.setKubunGendoChokaTaniSu_Nissu(区分限度超過単位数_日数);
    }

    /**
     * 単位数単価を設定します。
     *
     * @param 単位数単価 単位数単価
     */
    public void set単位数単価(Decimal 単位数単価) {
        requireNonNull(単位数単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数単価"));
        entity.setTaniSuTanka(単位数単価);
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     */
    public void set給付率(HokenKyufuRitsu 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuRitsu(給付率);
    }

    /**
     * 割引後適用率を設定します。
     *
     * @param 割引後適用率 割引後適用率
     */
    public void set割引後適用率(HokenKyufuRitsu 割引後適用率) {
        requireNonNull(割引後適用率, UrSystemErrorMessages.値がnull.getReplacedMessage("割引後適用率"));
        entity.setWaribikiGoTekiyoRitsu(割引後適用率);
    }

    /**
     * 割引後適用単位数を設定します。
     *
     * @param 割引後適用単位数 割引後適用単位数
     */
    public void set割引後適用単位数(Decimal 割引後適用単位数) {
        requireNonNull(割引後適用単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("割引後適用単位数"));
        entity.setWaribikiGoTekiyoTaniSu(割引後適用単位数);
    }

    /**
     * 定額利用者負担単価金額を設定します。
     *
     * @param 定額利用者負担単価金額 定額利用者負担単価金額
     */
    public void set定額利用者負担単価金額(Decimal 定額利用者負担単価金額) {
        requireNonNull(定額利用者負担単価金額, UrSystemErrorMessages.値がnull.getReplacedMessage("定額利用者負担単価金額"));
        entity.setTeigakuRiyoshaFutanTankaKingaku(定額利用者負担単価金額);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
