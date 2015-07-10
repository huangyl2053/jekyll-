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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 過誤申立のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KagoMoshitateModel implements Serializable {

    private DbT3059KagoMoshitateEntity entity;

    /**
     * コンストラクタです。
     */
    public KagoMoshitateModel() {
        entity = new DbT3059KagoMoshitateEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3059KagoMoshitateEntity
     */
    public KagoMoshitateModel(DbT3059KagoMoshitateEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3059KagoMoshitateEntityを返します。
     *
     * @return DbT3059KagoMoshitateEntity
     */
    public DbT3059KagoMoshitateEntity getEntity() {
        return entity;
    }

    /**
     * DbT3059KagoMoshitateEntityを設定します。
     *
     * @param entity DbT3059KagoMoshitateEntity
     */
    public void setEntity(DbT3059KagoMoshitateEntity entity) {
        this.entity = entity;
    }

    /**
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
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
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
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
     * 申立年月日を返します。
     *
     * @return 申立年月日
     */
    public FlexibleDate get申立年月日() {
        return entity.getMoshitateYMD();
    }

    /**
     * 申立者区分コードを返します。
     *
     * @return 申立者区分コード
     */
    public RString get申立者区分コード() {
        return entity.getMoshitateshaKubunCode();
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
     * 申立事由コードを返します。
     *
     * @return 申立事由コード
     */
    public RString get申立事由コード() {
        return entity.getMoshitateJiyuCode();
    }

    /**
     * 国保連送付年月を返します。
     *
     * @return 国保連送付年月
     */
    public FlexibleYearMonth get国保連送付年月() {
        return entity.getKokuhorenSofuYM();
    }

    /**
     * 国保連再送付有フラグを返します。
     *
     * @return 国保連再送付有フラグ
     */
    public boolean get国保連再送付有フラグ() {
        return entity.getKokuhirenSaiSofuAriFlag();
    }

    /**
     * 同月審査有フラグを返します。
     *
     * @return 同月審査有フラグ
     */
    public boolean get同月審査有フラグ() {
        return entity.getDogetsuShinsaAriFlag();
    }

    /**
     * 申立書区分コードを返します。
     *
     * @return 申立書区分コード
     */
    public RString get申立書区分コード() {
        return entity.getMoshitateshoKubunCode();
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     */
    public void set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
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
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    public void setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
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
     * 申立年月日を設定します。
     *
     * @param 申立年月日 申立年月日
     */
    public void set申立年月日(FlexibleDate 申立年月日) {
        requireNonNull(申立年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申立年月日"));
        entity.setMoshitateYMD(申立年月日);
    }

    /**
     * 申立者区分コードを設定します。
     *
     * @param 申立者区分コード 申立者区分コード
     */
    public void set申立者区分コード(RString 申立者区分コード) {
        requireNonNull(申立者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申立者区分コード"));
        entity.setMoshitateshaKubunCode(申立者区分コード);
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
     * 申立事由コードを設定します。
     *
     * @param 申立事由コード 申立事由コード
     */
    public void set申立事由コード(RString 申立事由コード) {
        requireNonNull(申立事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申立事由コード"));
        entity.setMoshitateJiyuCode(申立事由コード);
    }

    /**
     * 国保連送付年月を設定します。
     *
     * @param 国保連送付年月 国保連送付年月
     */
    public void set国保連送付年月(FlexibleYearMonth 国保連送付年月) {
        requireNonNull(国保連送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連送付年月"));
        entity.setKokuhorenSofuYM(国保連送付年月);
    }

    /**
     * 国保連再送付有フラグを設定します。
     *
     * @param 国保連再送付有フラグ 国保連再送付有フラグ
     */
    public void set国保連再送付有フラグ(boolean 国保連再送付有フラグ) {
        requireNonNull(国保連再送付有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連再送付有フラグ"));
        entity.setKokuhirenSaiSofuAriFlag(国保連再送付有フラグ);
    }

    /**
     * 同月審査有フラグを設定します。
     *
     * @param 同月審査有フラグ 同月審査有フラグ
     */
    public void set同月審査有フラグ(boolean 同月審査有フラグ) {
        requireNonNull(同月審査有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("同月審査有フラグ"));
        entity.setDogetsuShinsaAriFlag(同月審査有フラグ);
    }

    /**
     * 申立書区分コードを設定します。
     *
     * @param 申立書区分コード 申立書区分コード
     */
    public void set申立書区分コード(RString 申立書区分コード) {
        requireNonNull(申立書区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申立書区分コード"));
        entity.setMoshitateshoKubunCode(申立書区分コード);
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
