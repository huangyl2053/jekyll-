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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算給付実績のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuGassanKyufuJissekiModel implements Serializable {

    private DbT3075KogakuGassanKyufuJissekiEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuGassanKyufuJissekiModel() {
        entity = new DbT3075KogakuGassanKyufuJissekiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3075KogakuGassanKyufuJissekiEntity
     */
    public KogakuGassanKyufuJissekiModel(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3075KogakuGassanKyufuJissekiEntityを返します。
     *
     * @return DbT3075KogakuGassanKyufuJissekiEntity
     */
    public DbT3075KogakuGassanKyufuJissekiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3075KogakuGassanKyufuJissekiEntityを設定します。
     *
     * @param entity DbT3075KogakuGassanKyufuJissekiEntity
     */
    public void setEntity(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        this.entity = entity;
    }

    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo get交換情報識別番号() {
        return entity.getKokanJohoShikibetsuNo();
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
     * 支給申請書整理番号を返します。
     *
     * @return 支給申請書整理番号
     */
    public RString get支給申請書整理番号() {
        return entity.getShikyuShinseiSeiriNo();
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
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
     * 自己負担額証明書整理番号を返します。
     *
     * @return 自己負担額証明書整理番号
     */
    public RString get自己負担額証明書整理番号() {
        return entity.getJikoFutanSeiriNo();
    }

    /**
     * 保険制度コードを返します。
     *
     * @return 保険制度コード
     */
    public RString get保険制度コード() {
        return entity.getHokenSeidoCode();
    }

    /**
     * 給付実績作成区分コードを返します。
     *
     * @return 給付実績作成区分コード
     */
    public RString get給付実績作成区分コード() {
        return entity.getKyufuJissekiSakuseiKubunCode();
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
     * 国保_被保険者証記号を返します。
     *
     * @return 国保_被保険者証記号
     */
    public RString get国保_被保険者証記号() {
        return entity.getKokuho_HihokenshaShoKigo();
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 自己負担総額を返します。
     *
     * @return 自己負担総額
     */
    public Decimal get自己負担総額() {
        return entity.getJikoFutanSogaku();
    }

    /**
     * 支給額を返します。
     *
     * @return 支給額
     */
    public Decimal get支給額() {
        return entity.getShikyuGaku();
    }

    /**
     * 処理年月を返します。
     *
     * @return 処理年月
     */
    public FlexibleYearMonth get処理年月() {
        return entity.getShoriYM();
    }

    /**
     * 受取年月を返します。
     *
     * @return 受取年月
     */
    public FlexibleYearMonth get受取年月() {
        return entity.getUketoriYM();
    }

    /**
     * 送付年月を返します。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get送付年月() {
        return entity.getSofuYM();
    }

    /**
     * データ区分を返します。
     *
     * @return データ区分
     */
    public RString getデータ区分() {
        return entity.getDataKubun();
    }

    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     */
    public void set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
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
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     */
    public void set支給申請書整理番号(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        entity.setShikyuShinseiSeiriNo(支給申請書整理番号);
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    public void set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
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
     * 自己負担額証明書整理番号を設定します。
     *
     * @param 自己負担額証明書整理番号 自己負担額証明書整理番号
     */
    public void set自己負担額証明書整理番号(RString 自己負担額証明書整理番号) {
        requireNonNull(自己負担額証明書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書整理番号"));
        entity.setJikoFutanSeiriNo(自己負担額証明書整理番号);
    }

    /**
     * 保険制度コードを設定します。
     *
     * @param 保険制度コード 保険制度コード
     */
    public void set保険制度コード(RString 保険制度コード) {
        requireNonNull(保険制度コード, UrSystemErrorMessages.値がnull.getReplacedMessage("保険制度コード"));
        entity.setHokenSeidoCode(保険制度コード);
    }

    /**
     * 給付実績作成区分コードを設定します。
     *
     * @param 給付実績作成区分コード 給付実績作成区分コード
     */
    public void set給付実績作成区分コード(RString 給付実績作成区分コード) {
        requireNonNull(給付実績作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績作成区分コード"));
        entity.setKyufuJissekiSakuseiKubunCode(給付実績作成区分コード);
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
     * 国保_被保険者証記号を設定します。
     *
     * @param 国保_被保険者証記号 国保_被保険者証記号
     */
    public void set国保_被保険者証記号(RString 国保_被保険者証記号) {
        requireNonNull(国保_被保険者証記号, UrSystemErrorMessages.値がnull.getReplacedMessage("国保_被保険者証記号"));
        entity.setKokuho_HihokenshaShoKigo(国保_被保険者証記号);
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     */
    public void set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     */
    public void set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
    }

    /**
     * 自己負担総額を設定します。
     *
     * @param 自己負担総額 自己負担総額
     */
    public void set自己負担総額(Decimal 自己負担総額) {
        requireNonNull(自己負担総額, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担総額"));
        entity.setJikoFutanSogaku(自己負担総額);
    }

    /**
     * 支給額を設定します。
     *
     * @param 支給額 支給額
     */
    public void set支給額(Decimal 支給額) {
        requireNonNull(支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額"));
        entity.setShikyuGaku(支給額);
    }

    /**
     * 処理年月を設定します。
     *
     * @param 処理年月 処理年月
     */
    public void set処理年月(FlexibleYearMonth 処理年月) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        entity.setShoriYM(処理年月);
    }

    /**
     * 受取年月を設定します。
     *
     * @param 受取年月 受取年月
     */
    public void set受取年月(FlexibleYearMonth 受取年月) {
        requireNonNull(受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("受取年月"));
        entity.setUketoriYM(受取年月);
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     */
    public void set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
    }

    /**
     * データ区分を設定します。
     *
     * @param データ区分 データ区分
     */
    public void setデータ区分(RString データ区分) {
        requireNonNull(データ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("データ区分"));
        entity.setDataKubun(データ区分);
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
