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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 共同処理用受給者異動償還送付のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyodoShoriyoJukyushaIdoShokanSofuModel implements Serializable {

    private DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity;

    /**
     * コンストラクタです。
     */
    public KyodoShoriyoJukyushaIdoShokanSofuModel() {
        entity = new DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity
     */
    public KyodoShoriyoJukyushaIdoShokanSofuModel(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityを返します。
     *
     * @return DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity
     */
    public DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity getEntity() {
        return entity;
    }

    /**
     * DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityを設定します。
     *
     * @param entity DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity
     */
    public void setEntity(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity) {
        this.entity = entity;
    }

    /**
     * 異動年月日を返します。
     *
     * @return 異動年月日
     */
    public FlexibleDate get異動年月日() {
        return entity.getIdoYMD();
    }

    /**
     * 異動区分コードを返します。
     *
     * @return 異動区分コード
     */
    public RString get異動区分コード() {
        return entity.getIdoKubunCode();
    }

    /**
     * 受給者異動事由を返します。
     *
     * @return 受給者異動事由
     */
    public RString get受給者異動事由() {
        return entity.getJukyushaIdoJiyu();
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getSyoriTimestamp();
    }

    /**
     * 保険給付支払一時差止開始年月日を返します。
     *
     * @return 保険給付支払一時差止開始年月日
     */
    public FlexibleDate get保険給付支払一時差止開始年月日() {
        return entity.getHokenKyufuIchijiSashitomeKaishiYMD();
    }

    /**
     * 保険給付支払一時差止終了年月日を返します。
     *
     * @return 保険給付支払一時差止終了年月日
     */
    public FlexibleDate get保険給付支払一時差止終了年月日() {
        return entity.getHokenKyufuIchijiSashitomeShuryoYMD();
    }

    /**
     * 保険給付支払一時差止区分コードを返します。
     *
     * @return 保険給付支払一時差止区分コード
     */
    public RString get保険給付支払一時差止区分コード() {
        return entity.getHokenkyufuIchijiSashitomeKubunCode();
    }

    /**
     * 保険給付支払一時差止金額を返します。
     *
     * @return 保険給付支払一時差止金額
     */
    public Decimal get保険給付支払一時差止金額() {
        return entity.getHokenkyufuIchijiSashitomeKingaku();
    }

    /**
     * 訂正連絡票フラグを返します。
     *
     * @return 訂正連絡票フラグ
     */
    public boolean get訂正連絡票フラグ() {
        return entity.getTeiseiRenrakuhyoFlag();
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
     * 異動年月日を設定します。
     *
     * @param 異動年月日 異動年月日
     */
    public void set異動年月日(FlexibleDate 異動年月日) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        entity.setIdoYMD(異動年月日);
    }

    /**
     * 異動区分コードを設定します。
     *
     * @param 異動区分コード 異動区分コード
     */
    public void set異動区分コード(RString 異動区分コード) {
        requireNonNull(異動区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分コード"));
        entity.setIdoKubunCode(異動区分コード);
    }

    /**
     * 受給者異動事由を設定します。
     *
     * @param 受給者異動事由 受給者異動事由
     */
    public void set受給者異動事由(RString 受給者異動事由) {
        requireNonNull(受給者異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動事由"));
        entity.setJukyushaIdoJiyu(受給者異動事由);
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
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setSyoriTimestamp(処理日時);
    }

    /**
     * 保険給付支払一時差止開始年月日を設定します。
     *
     * @param 保険給付支払一時差止開始年月日 保険給付支払一時差止開始年月日
     */
    public void set保険給付支払一時差止開始年月日(FlexibleDate 保険給付支払一時差止開始年月日) {
        requireNonNull(保険給付支払一時差止開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付支払一時差止開始年月日"));
        entity.setHokenKyufuIchijiSashitomeKaishiYMD(保険給付支払一時差止開始年月日);
    }

    /**
     * 保険給付支払一時差止終了年月日を設定します。
     *
     * @param 保険給付支払一時差止終了年月日 保険給付支払一時差止終了年月日
     */
    public void set保険給付支払一時差止終了年月日(FlexibleDate 保険給付支払一時差止終了年月日) {
        requireNonNull(保険給付支払一時差止終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付支払一時差止終了年月日"));
        entity.setHokenKyufuIchijiSashitomeShuryoYMD(保険給付支払一時差止終了年月日);
    }

    /**
     * 保険給付支払一時差止区分コードを設定します。
     *
     * @param 保険給付支払一時差止区分コード 保険給付支払一時差止区分コード
     */
    public void set保険給付支払一時差止区分コード(RString 保険給付支払一時差止区分コード) {
        requireNonNull(保険給付支払一時差止区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付支払一時差止区分コード"));
        entity.setHokenkyufuIchijiSashitomeKubunCode(保険給付支払一時差止区分コード);
    }

    /**
     * 保険給付支払一時差止金額を設定します。
     *
     * @param 保険給付支払一時差止金額 保険給付支払一時差止金額
     */
    public void set保険給付支払一時差止金額(Decimal 保険給付支払一時差止金額) {
        requireNonNull(保険給付支払一時差止金額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付支払一時差止金額"));
        entity.setHokenkyufuIchijiSashitomeKingaku(保険給付支払一時差止金額);
    }

    /**
     * 訂正連絡票フラグを設定します。
     *
     * @param 訂正連絡票フラグ 訂正連絡票フラグ
     */
    public void set訂正連絡票フラグ(boolean 訂正連絡票フラグ) {
        requireNonNull(訂正連絡票フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("訂正連絡票フラグ"));
        entity.setTeiseiRenrakuhyoFlag(訂正連絡票フラグ);
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
