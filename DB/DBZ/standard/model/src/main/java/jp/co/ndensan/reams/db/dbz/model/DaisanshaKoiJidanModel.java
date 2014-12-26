/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3080DaisanshaKoiJidanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護第三者行為示談のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DaisanshaKoiJidanModel implements Serializable {

    private DbT3080DaisanshaKoiJidanEntity entity;

    /**
     * コンストラクタです。
     */
    public DaisanshaKoiJidanModel() {
        entity = new DbT3080DaisanshaKoiJidanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3080DaisanshaKoiJidanEntity
     */
    public DaisanshaKoiJidanModel(DbT3080DaisanshaKoiJidanEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3080DaisanshaKoiJidanEntityを返します。
     *
     * @return DbT3080DaisanshaKoiJidanEntity
     */
    public DbT3080DaisanshaKoiJidanEntity getEntity() {
        return entity;
    }

    /**
     * DbT3080DaisanshaKoiJidanEntityを設定します。
     *
     * @param entity DbT3080DaisanshaKoiJidanEntity
     */
    public void setEntity(DbT3080DaisanshaKoiJidanEntity entity) {
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
     * 示談報告書受付年月日を返します。
     *
     * @return 示談報告書受付年月日
     */
    public FlexibleDate get示談報告書受付年月日() {
        return entity.getJidanHokokushoUketukeYMD();
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
     * 第三者行為求償協議区分を返します。
     *
     * @return 第三者行為求償協議区分
     */
    public RString get第三者行為求償協議区分() {
        return entity.getKyushoKyogiKubun();
    }

    /**
     * 示談報告書提出年月日を返します。
     *
     * @return 示談報告書提出年月日
     */
    public FlexibleDate get示談報告書提出年月日() {
        return entity.getJidanHokokushoTeishutsuYMD();
    }

    /**
     * 示談成立年月日を返します。
     *
     * @return 示談成立年月日
     */
    public FlexibleDate get示談成立年月日() {
        return entity.getJidanSeiritsuYMD();
    }

    /**
     * 給付期間開始年月を返します。
     *
     * @return 給付期間開始年月
     */
    public FlexibleYearMonth get給付期間開始年月() {
        return entity.getKyufuKaishiYMD();
    }

    /**
     * 給付期間終了年月を返します。
     *
     * @return 給付期間終了年月
     */
    public FlexibleYearMonth get給付期間終了年月() {
        return entity.getKyufuShuryoYMD();
    }

    /**
     * 過失割合_加害者を返します。
     *
     * @return 過失割合_加害者
     */
    public RString get過失割合_加害者() {
        return entity.getKashitsuWariai_Kagaisha();
    }

    /**
     * 過失割合_被害者を返します。
     *
     * @return 過失割合_被害者
     */
    public RString get過失割合_被害者() {
        return entity.getKashitsuWariai_Higaisha();
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
     * 示談報告書受付年月日を設定します。
     *
     * @param 示談報告書受付年月日 示談報告書受付年月日
     */
    public void set示談報告書受付年月日(FlexibleDate 示談報告書受付年月日) {
        requireNonNull(示談報告書受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("示談報告書受付年月日"));
        entity.setJidanHokokushoUketukeYMD(示談報告書受付年月日);
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
     * 第三者行為求償協議区分を設定します。
     *
     * @param 第三者行為求償協議区分 第三者行為求償協議区分
     */
    public void set第三者行為求償協議区分(RString 第三者行為求償協議区分) {
        requireNonNull(第三者行為求償協議区分, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償協議区分"));
        entity.setKyushoKyogiKubun(第三者行為求償協議区分);
    }

    /**
     * 示談報告書提出年月日を設定します。
     *
     * @param 示談報告書提出年月日 示談報告書提出年月日
     */
    public void set示談報告書提出年月日(FlexibleDate 示談報告書提出年月日) {
        requireNonNull(示談報告書提出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("示談報告書提出年月日"));
        entity.setJidanHokokushoTeishutsuYMD(示談報告書提出年月日);
    }

    /**
     * 示談成立年月日を設定します。
     *
     * @param 示談成立年月日 示談成立年月日
     */
    public void set示談成立年月日(FlexibleDate 示談成立年月日) {
        requireNonNull(示談成立年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("示談成立年月日"));
        entity.setJidanSeiritsuYMD(示談成立年月日);
    }

    /**
     * 給付期間開始年月を設定します。
     *
     * @param 給付期間開始年月 給付期間開始年月
     */
    public void set給付期間開始年月(FlexibleYearMonth 給付期間開始年月) {
        requireNonNull(給付期間開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("給付期間開始年月"));
        entity.setKyufuKaishiYMD(給付期間開始年月);
    }

    /**
     * 給付期間終了年月を設定します。
     *
     * @param 給付期間終了年月 給付期間終了年月
     */
    public void set給付期間終了年月(FlexibleYearMonth 給付期間終了年月) {
        requireNonNull(給付期間終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("給付期間終了年月"));
        entity.setKyufuShuryoYMD(給付期間終了年月);
    }

    /**
     * 過失割合_加害者を設定します。
     *
     * @param 過失割合_加害者 過失割合_加害者
     */
    public void set過失割合_加害者(RString 過失割合_加害者) {
        requireNonNull(過失割合_加害者, UrSystemErrorMessages.値がnull.getReplacedMessage("過失割合_加害者"));
        entity.setKashitsuWariai_Kagaisha(過失割合_加害者);
    }

    /**
     * 過失割合_被害者を設定します。
     *
     * @param 過失割合_被害者 過失割合_被害者
     */
    public void set過失割合_被害者(RString 過失割合_被害者) {
        requireNonNull(過失割合_被害者, UrSystemErrorMessages.値がnull.getReplacedMessage("過失割合_被害者"));
        entity.setKashitsuWariai_Higaisha(過失割合_被害者);
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
