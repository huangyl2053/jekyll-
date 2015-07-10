/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3098TandokuJoseikinKyufuShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 市町村単独助成金給付申請のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class TandokuJoseikinKyufuShinseiModel implements Serializable {

    private DbT3098TandokuJoseikinKyufuShinseiEntity entity;

    /**
     * コンストラクタです。
     */
    public TandokuJoseikinKyufuShinseiModel() {
        entity = new DbT3098TandokuJoseikinKyufuShinseiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3098TandokuJoseikinKyufuShinseiEntity
     */
    public TandokuJoseikinKyufuShinseiModel(DbT3098TandokuJoseikinKyufuShinseiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3098TandokuJoseikinKyufuShinseiEntityを返します。
     *
     * @return DbT3098TandokuJoseikinKyufuShinseiEntity
     */
    public DbT3098TandokuJoseikinKyufuShinseiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3098TandokuJoseikinKyufuShinseiEntityを設定します。
     *
     * @param entity DbT3098TandokuJoseikinKyufuShinseiEntity
     */
    public void setEntity(DbT3098TandokuJoseikinKyufuShinseiEntity entity) {
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
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
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
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 申請者区分を返します。
     *
     * @return 申請者区分
     */
    public RString get申請者区分() {
        return entity.getShinseishaKubun();
    }

    /**
     * 申請代行事業者番号を返します。
     *
     * @return 申請代行事業者番号
     */
    public JigyoshaNo get申請代行事業者番号() {
        return entity.getDaikoJigyoshaNo();
    }

    /**
     * 事業者区分を返します。
     *
     * @return 事業者区分
     */
    public RString get事業者区分() {
        return entity.getJigyoshaKubun();
    }

    /**
     * 申請者郵便番号を返します。
     *
     * @return 申請者郵便番号
     */
    public YubinNo get申請者郵便番号() {
        return entity.getShinseishaYubinNo();
    }

    /**
     * 申請者住所を返します。
     *
     * @return 申請者住所
     */
    public RString get申請者住所() {
        return entity.getShinseishaJusho();
    }

    /**
     * 申請者電話番号を返します。
     *
     * @return 申請者電話番号
     */
    public TelNo get申請者電話番号() {
        return entity.getShinseishaTelNo();
    }

    /**
     * 申請理由を返します。
     *
     * @return 申請理由
     */
    public RString get申請理由() {
        return entity.getShinseiRiyu();
    }

    /**
     * 市町村単独助成種類を返します。
     *
     * @return 市町村単独助成種類
     */
    public RString get市町村単独助成種類() {
        return entity.getTandokuJoseiShuruiCode();
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
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     */
    public void set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
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
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     */
    public void set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
    }

    /**
     * 申請者区分を設定します。
     *
     * @param 申請者区分 申請者区分
     */
    public void set申請者区分(RString 申請者区分) {
        requireNonNull(申請者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者区分"));
        entity.setShinseishaKubun(申請者区分);
    }

    /**
     * 申請代行事業者番号を設定します。
     *
     * @param 申請代行事業者番号 申請代行事業者番号
     */
    public void set申請代行事業者番号(JigyoshaNo 申請代行事業者番号) {
        requireNonNull(申請代行事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請代行事業者番号"));
        entity.setDaikoJigyoshaNo(申請代行事業者番号);
    }

    /**
     * 事業者区分を設定します。
     *
     * @param 事業者区分 事業者区分
     */
    public void set事業者区分(RString 事業者区分) {
        requireNonNull(事業者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者区分"));
        entity.setJigyoshaKubun(事業者区分);
    }

    /**
     * 申請者郵便番号を設定します。
     *
     * @param 申請者郵便番号 申請者郵便番号
     */
    public void set申請者郵便番号(YubinNo 申請者郵便番号) {
        requireNonNull(申請者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者郵便番号"));
        entity.setShinseishaYubinNo(申請者郵便番号);
    }

    /**
     * 申請者住所を設定します。
     *
     * @param 申請者住所 申請者住所
     */
    public void set申請者住所(RString 申請者住所) {
        requireNonNull(申請者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者住所"));
        entity.setShinseishaJusho(申請者住所);
    }

    /**
     * 申請者電話番号を設定します。
     *
     * @param 申請者電話番号 申請者電話番号
     */
    public void set申請者電話番号(TelNo 申請者電話番号) {
        requireNonNull(申請者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者電話番号"));
        entity.setShinseishaTelNo(申請者電話番号);
    }

    /**
     * 申請理由を設定します。
     *
     * @param 申請理由 申請理由
     */
    public void set申請理由(RString 申請理由) {
        requireNonNull(申請理由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請理由"));
        entity.setShinseiRiyu(申請理由);
    }

    /**
     * 市町村単独助成種類を設定します。
     *
     * @param 市町村単独助成種類 市町村単独助成種類
     */
    public void set市町村単独助成種類(RString 市町村単独助成種類) {
        requireNonNull(市町村単独助成種類, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成種類"));
        entity.setTandokuJoseiShuruiCode(市町村単独助成種類);
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
