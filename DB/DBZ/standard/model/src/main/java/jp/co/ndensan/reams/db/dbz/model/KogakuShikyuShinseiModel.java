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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額介護サービス費支給申請のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuShikyuShinseiModel implements Serializable {

    private DbT3056KogakuShikyuShinseiEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuShikyuShinseiModel() {
        entity = new DbT3056KogakuShikyuShinseiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3056KogakuShikyuShinseiEntity
     */
    public KogakuShikyuShinseiModel(DbT3056KogakuShikyuShinseiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3056KogakuShikyuShinseiEntityを返します。
     *
     * @return DbT3056KogakuShikyuShinseiEntity
     */
    public DbT3056KogakuShikyuShinseiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3056KogakuShikyuShinseiEntityを設定します。
     *
     * @param entity DbT3056KogakuShikyuShinseiEntity
     */
    public void setEntity(DbT3056KogakuShikyuShinseiEntity entity) {
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
        return entity.getShoKisaiHokenshaNo();
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
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
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
     * 申請理由を返します。
     *
     * @return 申請理由
     */
    public RString get申請理由() {
        return entity.getShinseiRiyu();
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
     * 申請者氏名を返します。
     *
     * @return 申請者氏名
     */
    public AtenaMeisho get申請者氏名() {
        return entity.getShinseishaShimei();
    }

    /**
     * 申請者氏名カナを返します。
     *
     * @return 申請者氏名カナ
     */
    public AtenaKanaMeisho get申請者氏名カナ() {
        return entity.getShinseishaShimeiKana();
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
     * 申請事業者番号を返します。
     *
     * @return 申請事業者番号
     */
    public JigyoshaNo get申請事業者番号() {
        return entity.getShinseiJigyoshaNo();
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
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
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
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     */
    public void set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
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
     * 申請理由を設定します。
     *
     * @param 申請理由 申請理由
     */
    public void set申請理由(RString 申請理由) {
        requireNonNull(申請理由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請理由"));
        entity.setShinseiRiyu(申請理由);
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
     * 申請者氏名を設定します。
     *
     * @param 申請者氏名 申請者氏名
     */
    public void set申請者氏名(AtenaMeisho 申請者氏名) {
        requireNonNull(申請者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名"));
        entity.setShinseishaShimei(申請者氏名);
    }

    /**
     * 申請者氏名カナを設定します。
     *
     * @param 申請者氏名カナ 申請者氏名カナ
     */
    public void set申請者氏名カナ(AtenaKanaMeisho 申請者氏名カナ) {
        requireNonNull(申請者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請者氏名カナ"));
        entity.setShinseishaShimeiKana(申請者氏名カナ);
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
     * 申請事業者番号を設定します。
     *
     * @param 申請事業者番号 申請事業者番号
     */
    public void set申請事業者番号(JigyoshaNo 申請事業者番号) {
        requireNonNull(申請事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事業者番号"));
        entity.setShinseiJigyoshaNo(申請事業者番号);
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
