/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3082DaisanshaKoiKyushoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護第三者行為求償のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DaisanshaKoiKyushoModel implements Serializable {

    private DbT3082DaisanshaKoiKyushoEntity entity;

    /**
     * コンストラクタです。
     */
    public DaisanshaKoiKyushoModel() {
        entity = new DbT3082DaisanshaKoiKyushoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3082DaisanshaKoiKyushoEntity
     */
    public DaisanshaKoiKyushoModel(DbT3082DaisanshaKoiKyushoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3082DaisanshaKoiKyushoEntityを返します。
     *
     * @return DbT3082DaisanshaKoiKyushoEntity
     */
    public DbT3082DaisanshaKoiKyushoEntity getEntity() {
        return entity;
    }

    /**
     * DbT3082DaisanshaKoiKyushoEntityを設定します。
     *
     * @param entity DbT3082DaisanshaKoiKyushoEntity
     */
    public void setEntity(DbT3082DaisanshaKoiKyushoEntity entity) {
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
     * 給付額合計を返します。
     *
     * @return 給付額合計
     */
    public Decimal get給付額合計() {
        return entity.getKyufuGakuGokei();
    }

    /**
     * 過失相殺額を返します。
     *
     * @return 過失相殺額
     */
    public Decimal get過失相殺額() {
        return entity.getKashitsuSosatsuGaku();
    }

    /**
     * 保険給付請求額を返します。
     *
     * @return 保険給付請求額
     */
    public Decimal get保険給付請求額() {
        return entity.getHokenKyufuSeikyuGaku();
    }

    /**
     * 損害賠償金納入期限を返します。
     *
     * @return 損害賠償金納入期限
     */
    public FlexibleDate get損害賠償金納入期限() {
        return entity.getSongaiBaishoKinNonyuYMD();
    }

    /**
     * 請求先郵便番号を返します。
     *
     * @return 請求先郵便番号
     */
    public YubinNo get請求先郵便番号() {
        return entity.getSeikyusakiYubinNo();
    }

    /**
     * 請求先住所を返します。
     *
     * @return 請求先住所
     */
    public RString get請求先住所() {
        return entity.getSeikyusakiJusho();
    }

    /**
     * 請求先名称を返します。
     *
     * @return 請求先名称
     */
    public AtenaMeisho get請求先名称() {
        return entity.getSeikyusakiMeisho();
    }

    /**
     * 請求先部署を返します。
     *
     * @return 請求先部署
     */
    public RString get請求先部署() {
        return entity.getSeikyusakiBusho();
    }

    /**
     * 請求先担当者を返します。
     *
     * @return 請求先担当者
     */
    public AtenaMeisho get請求先担当者() {
        return entity.getSeikyusakiTantosha();
    }

    /**
     * 請求先電話番号を返します。
     *
     * @return 請求先電話番号
     */
    public TelNo get請求先電話番号() {
        return entity.getSeikyusakiTelNo();
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
     * 給付額合計を設定します。
     *
     * @param 給付額合計 給付額合計
     */
    public void set給付額合計(Decimal 給付額合計) {
        requireNonNull(給付額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額合計"));
        entity.setKyufuGakuGokei(給付額合計);
    }

    /**
     * 過失相殺額を設定します。
     *
     * @param 過失相殺額 過失相殺額
     */
    public void set過失相殺額(Decimal 過失相殺額) {
        requireNonNull(過失相殺額, UrSystemErrorMessages.値がnull.getReplacedMessage("過失相殺額"));
        entity.setKashitsuSosatsuGaku(過失相殺額);
    }

    /**
     * 保険給付請求額を設定します。
     *
     * @param 保険給付請求額 保険給付請求額
     */
    public void set保険給付請求額(Decimal 保険給付請求額) {
        requireNonNull(保険給付請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付請求額"));
        entity.setHokenKyufuSeikyuGaku(保険給付請求額);
    }

    /**
     * 損害賠償金納入期限を設定します。
     *
     * @param 損害賠償金納入期限 損害賠償金納入期限
     */
    public void set損害賠償金納入期限(FlexibleDate 損害賠償金納入期限) {
        requireNonNull(損害賠償金納入期限, UrSystemErrorMessages.値がnull.getReplacedMessage("損害賠償金納入期限"));
        entity.setSongaiBaishoKinNonyuYMD(損害賠償金納入期限);
    }

    /**
     * 請求先郵便番号を設定します。
     *
     * @param 請求先郵便番号 請求先郵便番号
     */
    public void set請求先郵便番号(YubinNo 請求先郵便番号) {
        requireNonNull(請求先郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("請求先郵便番号"));
        entity.setSeikyusakiYubinNo(請求先郵便番号);
    }

    /**
     * 請求先住所を設定します。
     *
     * @param 請求先住所 請求先住所
     */
    public void set請求先住所(RString 請求先住所) {
        requireNonNull(請求先住所, UrSystemErrorMessages.値がnull.getReplacedMessage("請求先住所"));
        entity.setSeikyusakiJusho(請求先住所);
    }

    /**
     * 請求先名称を設定します。
     *
     * @param 請求先名称 請求先名称
     */
    public void set請求先名称(AtenaMeisho 請求先名称) {
        requireNonNull(請求先名称, UrSystemErrorMessages.値がnull.getReplacedMessage("請求先名称"));
        entity.setSeikyusakiMeisho(請求先名称);
    }

    /**
     * 請求先部署を設定します。
     *
     * @param 請求先部署 請求先部署
     */
    public void set請求先部署(RString 請求先部署) {
        requireNonNull(請求先部署, UrSystemErrorMessages.値がnull.getReplacedMessage("請求先部署"));
        entity.setSeikyusakiBusho(請求先部署);
    }

    /**
     * 請求先担当者を設定します。
     *
     * @param 請求先担当者 請求先担当者
     */
    public void set請求先担当者(AtenaMeisho 請求先担当者) {
        requireNonNull(請求先担当者, UrSystemErrorMessages.値がnull.getReplacedMessage("請求先担当者"));
        entity.setSeikyusakiTantosha(請求先担当者);
    }

    /**
     * 請求先電話番号を設定します。
     *
     * @param 請求先電話番号 請求先電話番号
     */
    public void set請求先電話番号(TelNo 請求先電話番号) {
        requireNonNull(請求先電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("請求先電話番号"));
        entity.setSeikyusakiTelNo(請求先電話番号);
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
