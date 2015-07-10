/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付管理票200004のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyufuKanrihyo200004Model implements Serializable {

    private DbT3014KyufuKanrihyo200004Entity entity;

    /**
     * コンストラクタです。
     */
    public KyufuKanrihyo200004Model() {
        entity = new DbT3014KyufuKanrihyo200004Entity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3014KyufuKanrihyo200004Entity
     */
    public KyufuKanrihyo200004Model(DbT3014KyufuKanrihyo200004Entity entity) {
        this.entity = entity;
    }

    /**
     * DbT3014KyufuKanrihyo200004Entityを返します。
     *
     * @return DbT3014KyufuKanrihyo200004Entity
     */
    public DbT3014KyufuKanrihyo200004Entity getEntity() {
        return entity;
    }

    /**
     * DbT3014KyufuKanrihyo200004Entityを設定します。
     *
     * @param entity DbT3014KyufuKanrihyo200004Entity
     */
    public void setEntity(DbT3014KyufuKanrihyo200004Entity entity) {
        this.entity = entity;
    }

    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return entity.getShinsaYM();
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
    }

    /**
     * 居宅支援事業所番号を返します。
     *
     * @return 居宅支援事業所番号
     */
    public JigyoshaNo get居宅支援事業所番号() {
        return entity.getKyotakushienJigyoshoNo();
    }

    /**
     * 給付管理票情報作成区分コードを返します。
     *
     * @return 給付管理票情報作成区分コード
     */
    public RString get給付管理票情報作成区分コード() {
        return entity.getKyufuKanrihyoSakuseiKubunCode();
    }

    /**
     * 給付管理票作成年月日を返します。
     *
     * @return 給付管理票作成年月日
     */
    public FlexibleDate get給付管理票作成年月日() {
        return entity.getKyufuKanrihyoSakuseiYMD();
    }

    /**
     * 給付管理票種別区分コードを返します。
     *
     * @return 給付管理票種別区分コード
     */
    public RString get給付管理票種別区分コード() {
        return entity.getKyufuKanrihyoShubetsuKubunCode();
    }

    /**
     * 給付管理票明細行番号を返します。
     *
     * @return 給付管理票明細行番号
     */
    public RString get給付管理票明細行番号() {
        return entity.getKyufuKanrihyoMeisaiLineNo();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return entity.getHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * 被保険者生年月日を返します。
     *
     * @return 被保険者生年月日
     */
    public FlexibleDate get被保険者生年月日() {
        return entity.getHiHokenshaUmareYMD();
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return entity.getSeibetsuCode();
    }

    /**
     * 要介護状態区分コードを返します。
     *
     * @return 要介護状態区分コード
     */
    public RString get要介護状態区分コード() {
        return entity.getYoKaigoJotaiKubunCode();
    }

    /**
     * 限度額適用期間_開始を返します。
     *
     * @return 限度額適用期間_開始
     */
    public FlexibleDate get限度額適用期間_開始() {
        return entity.getGendogakuTekiyoKaishiYMD();
    }

    /**
     * 限度額適用期間_終了を返します。
     *
     * @return 限度額適用期間_終了
     */
    public FlexibleDate get限度額適用期間_終了() {
        return entity.getGendogakuTekiyoShuryoYMD();
    }

    /**
     * 居宅_介護予防支給限度額を返します。
     *
     * @return 居宅_介護予防支給限度額
     */
    public Decimal get居宅_介護予防支給限度額() {
        return entity.getKyotakuKaigoYoboShikyuGendogaku();
    }

    /**
     * 居宅サービス計画作成区分コードを返します。
     *
     * @return 居宅サービス計画作成区分コード
     */
    public RString get居宅サービス計画作成区分コード() {
        return entity.getKyotakuServicePlanSakuseiKubunCode();
    }

    /**
     * サービス事業所番号を返します。
     *
     * @return サービス事業所番号
     */
    public JigyoshaNo getサービス事業所番号() {
        return entity.getServiceJigyoshoNo();
    }

    /**
     * 指定_基準該当_地域密着型サービス識別コードを返します。
     *
     * @return 指定_基準該当_地域密着型サービス識別コード
     */
    public RString get指定_基準該当_地域密着型サービス識別コード() {
        return entity.getShiteiKijungaitoChiikimitchakuServiceShikibetsuCode();
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
     * 給付計画単位数を返します。
     *
     * @return 給付計画単位数
     */
    public Decimal get給付計画単位数() {
        return entity.getKyufuKeikakuTanisuNissu();
    }

    /**
     * 限度額管理期間における前月までの給付計画日数を返します。
     *
     * @return 限度額管理期間における前月までの給付計画日数
     */
    public Decimal get限度額管理期間における前月までの給付計画日数() {
        return entity.getKyufuKeikakuNissu();
    }

    /**
     * 指定サービス分小計を返します。
     *
     * @return 指定サービス分小計
     */
    public Decimal get指定サービス分小計() {
        return entity.getShiteiServiceSubTotal();
    }

    /**
     * 基準該当サービス分小計を返します。
     *
     * @return 基準該当サービス分小計
     */
    public Decimal get基準該当サービス分小計() {
        return entity.getKijyunGaitoServiceSubTotal();
    }

    /**
     * 給付計画合計単位数_日数を返します。
     *
     * @return 給付計画合計単位数_日数
     */
    public Decimal get給付計画合計単位数_日数() {
        return entity.getKyufuKeikakuTotalTanisuNissu();
    }

    /**
     * 当初登録年月日を返します。
     *
     * @return 当初登録年月日
     */
    public FlexibleDate get当初登録年月日() {
        return entity.getToshoTorokuYMD();
    }

    /**
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.getTorikomiYM();
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     */
    public void set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    public void setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 居宅支援事業所番号を設定します。
     *
     * @param 居宅支援事業所番号 居宅支援事業所番号
     */
    public void set居宅支援事業所番号(JigyoshaNo 居宅支援事業所番号) {
        requireNonNull(居宅支援事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅支援事業所番号"));
        entity.setKyotakushienJigyoshoNo(居宅支援事業所番号);
    }

    /**
     * 給付管理票情報作成区分コードを設定します。
     *
     * @param 給付管理票情報作成区分コード 給付管理票情報作成区分コード
     */
    public void set給付管理票情報作成区分コード(RString 給付管理票情報作成区分コード) {
        requireNonNull(給付管理票情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票情報作成区分コード"));
        entity.setKyufuKanrihyoSakuseiKubunCode(給付管理票情報作成区分コード);
    }

    /**
     * 給付管理票作成年月日を設定します。
     *
     * @param 給付管理票作成年月日 給付管理票作成年月日
     */
    public void set給付管理票作成年月日(FlexibleDate 給付管理票作成年月日) {
        requireNonNull(給付管理票作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票作成年月日"));
        entity.setKyufuKanrihyoSakuseiYMD(給付管理票作成年月日);
    }

    /**
     * 給付管理票種別区分コードを設定します。
     *
     * @param 給付管理票種別区分コード 給付管理票種別区分コード
     */
    public void set給付管理票種別区分コード(RString 給付管理票種別区分コード) {
        requireNonNull(給付管理票種別区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票種別区分コード"));
        entity.setKyufuKanrihyoShubetsuKubunCode(給付管理票種別区分コード);
    }

    /**
     * 給付管理票明細行番号を設定します。
     *
     * @param 給付管理票明細行番号 給付管理票明細行番号
     */
    public void set給付管理票明細行番号(RString 給付管理票明細行番号) {
        requireNonNull(給付管理票明細行番号, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票明細行番号"));
        entity.setKyufuKanrihyoMeisaiLineNo(給付管理票明細行番号);
    }

    /**
     * 保険者番号を設定します。
     *
     * @param 保険者番号 保険者番号
     */
    public void set保険者番号(HokenshaNo 保険者番号) {
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        entity.setHokenshaNo(保険者番号);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
    }

    /**
     * 被保険者生年月日を設定します。
     *
     * @param 被保険者生年月日 被保険者生年月日
     */
    public void set被保険者生年月日(FlexibleDate 被保険者生年月日) {
        requireNonNull(被保険者生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者生年月日"));
        entity.setHiHokenshaUmareYMD(被保険者生年月日);
    }

    /**
     * 性別コードを設定します。
     *
     * @param 性別コード 性別コード
     */
    public void set性別コード(RString 性別コード) {
        requireNonNull(性別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("性別コード"));
        entity.setSeibetsuCode(性別コード);
    }

    /**
     * 要介護状態区分コードを設定します。
     *
     * @param 要介護状態区分コード 要介護状態区分コード
     */
    public void set要介護状態区分コード(RString 要介護状態区分コード) {
        requireNonNull(要介護状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分コード"));
        entity.setYoKaigoJotaiKubunCode(要介護状態区分コード);
    }

    /**
     * 限度額適用期間_開始を設定します。
     *
     * @param 限度額適用期間_開始 限度額適用期間_開始
     */
    public void set限度額適用期間_開始(FlexibleDate 限度額適用期間_開始) {
        requireNonNull(限度額適用期間_開始, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額適用期間_開始"));
        entity.setGendogakuTekiyoKaishiYMD(限度額適用期間_開始);
    }

    /**
     * 限度額適用期間_終了を設定します。
     *
     * @param 限度額適用期間_終了 限度額適用期間_終了
     */
    public void set限度額適用期間_終了(FlexibleDate 限度額適用期間_終了) {
        requireNonNull(限度額適用期間_終了, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額適用期間_終了"));
        entity.setGendogakuTekiyoShuryoYMD(限度額適用期間_終了);
    }

    /**
     * 居宅_介護予防支給限度額を設定します。
     *
     * @param 居宅_介護予防支給限度額 居宅_介護予防支給限度額
     */
    public void set居宅_介護予防支給限度額(Decimal 居宅_介護予防支給限度額) {
        requireNonNull(居宅_介護予防支給限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅_介護予防支給限度額"));
        entity.setKyotakuKaigoYoboShikyuGendogaku(居宅_介護予防支給限度額);
    }

    /**
     * 居宅サービス計画作成区分コードを設定します。
     *
     * @param 居宅サービス計画作成区分コード 居宅サービス計画作成区分コード
     */
    public void set居宅サービス計画作成区分コード(RString 居宅サービス計画作成区分コード) {
        requireNonNull(居宅サービス計画作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画作成区分コード"));
        entity.setKyotakuServicePlanSakuseiKubunCode(居宅サービス計画作成区分コード);
    }

    /**
     * サービス事業所番号を設定します。
     *
     * @param サービス事業所番号 サービス事業所番号
     */
    public void setサービス事業所番号(JigyoshaNo サービス事業所番号) {
        requireNonNull(サービス事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所番号"));
        entity.setServiceJigyoshoNo(サービス事業所番号);
    }

    /**
     * 指定_基準該当_地域密着型サービス識別コードを設定します。
     *
     * @param 指定_基準該当_地域密着型サービス識別コード 指定_基準該当_地域密着型サービス識別コード
     */
    public void set指定_基準該当_地域密着型サービス識別コード(RString 指定_基準該当_地域密着型サービス識別コード) {
        requireNonNull(指定_基準該当_地域密着型サービス識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("指定_基準該当_地域密着型サービス識別コード"));
        entity.setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(指定_基準該当_地域密着型サービス識別コード);
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
     * 給付計画単位数を設定します。
     *
     * @param 給付計画単位数 給付計画単位数
     */
    public void set給付計画単位数(Decimal 給付計画単位数) {
        requireNonNull(給付計画単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("給付計画単位数")
        );
        entity.setKyufuKeikakuTanisuNissu(給付計画単位数);
    }

    /**
     * 限度額管理期間における前月までの給付計画日数を設定します。
     *
     * @param 限度額管理期間における前月までの給付計画日数 限度額管理期間における前月までの給付計画日数
     */
    public void set限度額管理期間における前月までの給付計画日数(Decimal 限度額管理期間における前月までの給付計画日数) {
        requireNonNull(限度額管理期間における前月までの給付計画日数, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額管理期間における前月までの給付計画日数"));
        entity.setKyufuKeikakuNissu(限度額管理期間における前月までの給付計画日数);
    }

    /**
     * 指定サービス分小計を設定します。
     *
     * @param 指定サービス分小計 指定サービス分小計
     */
    public void set指定サービス分小計(Decimal 指定サービス分小計) {
        requireNonNull(指定サービス分小計, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス分小計"));
        entity.setShiteiServiceSubTotal(指定サービス分小計);
    }

    /**
     * 基準該当サービス分小計を設定します。
     *
     * @param 基準該当サービス分小計 基準該当サービス分小計
     */
    public void set基準該当サービス分小計(Decimal 基準該当サービス分小計) {
        requireNonNull(基準該当サービス分小計, UrSystemErrorMessages.値がnull.getReplacedMessage("基準該当サービス分小計"));
        entity.setKijyunGaitoServiceSubTotal(基準該当サービス分小計);
    }

    /**
     * 給付計画合計単位数_日数を設定します。
     *
     * @param 給付計画合計単位数_日数 給付計画合計単位数_日数
     */
    public void set給付計画合計単位数_日数(Decimal 給付計画合計単位数_日数) {
        requireNonNull(給付計画合計単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("給付計画合計単位数_日数"));
        entity.setKyufuKeikakuTotalTanisuNissu(給付計画合計単位数_日数);
    }

    /**
     * 当初登録年月日を設定します。
     *
     * @param 当初登録年月日 当初登録年月日
     */
    public void set当初登録年月日(FlexibleDate 当初登録年月日) {
        requireNonNull(当初登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("当初登録年月日"));
        entity.setToshoTorokuYMD(当初登録年月日);
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     */
    public void set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
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
