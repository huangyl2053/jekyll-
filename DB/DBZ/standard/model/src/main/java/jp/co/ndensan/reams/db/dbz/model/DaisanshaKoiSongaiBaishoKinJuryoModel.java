/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護第三者行為損害賠償金受領のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DaisanshaKoiSongaiBaishoKinJuryoModel implements Serializable {

    private DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity;

    /**
     * コンストラクタです。
     */
    public DaisanshaKoiSongaiBaishoKinJuryoModel() {
        entity = new DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity
     */
    public DaisanshaKoiSongaiBaishoKinJuryoModel(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityを返します。
     *
     * @return DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity
     */
    public DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity getEntity() {
        return entity;
    }

    /**
     * DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityを設定します。
     *
     * @param entity DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity
     */
    public void setEntity(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity) {
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
     * 第三者行為届出管理番号を返します。
     *
     * @return 第三者行為届出管理番号
     */
    public RString get第三者行為届出管理番号() {
        return entity.getTodokedeKanriNo();
    }

    /**
     * 第三者行為求償請求番号を返します。
     *
     * @return 第三者行為求償請求番号
     */
    public RString get第三者行為求償請求番号() {
        return entity.getKyushoSeikyuNo();
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
     * 入金確認年月日を返します。
     *
     * @return 入金確認年月日
     */
    public FlexibleDate get入金確認年月日() {
        return entity.getNyukinKakuninYMD();
    }

    /**
     * 領収年月日を返します。
     *
     * @return 領収年月日
     */
    public FlexibleDate get領収年月日() {
        return entity.getRyoshuYMD();
    }

    /**
     * 領収金額を返します。
     *
     * @return 領収金額
     */
    public Decimal get領収金額() {
        return entity.getRyoshuKingaku();
    }

    /**
     * 過不足金有無を返します。
     *
     * @return 過不足金有無
     */
    public RString get過不足金有無() {
        return entity.getMabusokuKinUMU();
    }

    /**
     * 過不足額を返します。
     *
     * @return 過不足額
     */
    public Decimal get過不足額() {
        return entity.getKabusokuGaku();
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
     * 第三者行為届出管理番号を設定します。
     *
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     */
    public void set第三者行為届出管理番号(RString 第三者行為届出管理番号) {
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        entity.setTodokedeKanriNo(第三者行為届出管理番号);
    }

    /**
     * 第三者行為求償請求番号を設定します。
     *
     * @param 第三者行為求償請求番号 第三者行為求償請求番号
     */
    public void set第三者行為求償請求番号(RString 第三者行為求償請求番号) {
        requireNonNull(第三者行為求償請求番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償請求番号"));
        entity.setKyushoSeikyuNo(第三者行為求償請求番号);
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
     * 入金確認年月日を設定します。
     *
     * @param 入金確認年月日 入金確認年月日
     */
    public void set入金確認年月日(FlexibleDate 入金確認年月日) {
        requireNonNull(入金確認年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("入金確認年月日"));
        entity.setNyukinKakuninYMD(入金確認年月日);
    }

    /**
     * 領収年月日を設定します。
     *
     * @param 領収年月日 領収年月日
     */
    public void set領収年月日(FlexibleDate 領収年月日) {
        requireNonNull(領収年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("領収年月日"));
        entity.setRyoshuYMD(領収年月日);
    }

    /**
     * 領収金額を設定します。
     *
     * @param 領収金額 領収金額
     */
    public void set領収金額(Decimal 領収金額) {
        requireNonNull(領収金額, UrSystemErrorMessages.値がnull.getReplacedMessage("領収金額"));
        entity.setRyoshuKingaku(領収金額);
    }

    /**
     * 過不足金有無を設定します。
     *
     * @param 過不足金有無 過不足金有無
     */
    public void set過不足金有無(RString 過不足金有無) {
        requireNonNull(過不足金有無, UrSystemErrorMessages.値がnull.getReplacedMessage("過不足金有無"));
        entity.setMabusokuKinUMU(過不足金有無);
    }

    /**
     * 過不足額を設定します。
     *
     * @param 過不足額 過不足額
     */
    public void set過不足額(Decimal 過不足額) {
        requireNonNull(過不足額, UrSystemErrorMessages.値がnull.getReplacedMessage("過不足額"));
        entity.setKabusokuGaku(過不足額);
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
