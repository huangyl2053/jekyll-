/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医情報　継承のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class ShujiiJohoModel implements Serializable {

    private DbT7012ShujiiJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public ShujiiJohoModel() {
        entity = new DbT7012ShujiiJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7012ShujiiJohoEntity
     */
    public ShujiiJohoModel(DbT7012ShujiiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7012ShujiiJohoEntityを返します。
     *
     * @return DbT7012ShujiiJohoEntity
     */
    public DbT7012ShujiiJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7012ShujiiJohoEntityを設定します。
     *
     * @param entity DbT7012ShujiiJohoEntity
     */
    public void setEntity(DbT7012ShujiiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 介護医療機関コードを返します。
     *
     * @return 介護医療機関コード
     */
    public RString get介護医療機関コード() {
        return entity.getKaigoIryokikanCode();
    }

    /**
     * 介護医師コードを返します。
     *
     * @return 介護医師コード
     */
    public RString get介護医師コード() {
        return entity.getKaigoIshiCode();
    }

    /**
     * 医療機関コードを返します。
     *
     * @return 医療機関コード
     */
    public RString get医療機関コード() {
        return entity.getIryokikanCode();
    }

    /**
     * 医師コードを返します。
     *
     * @return 医師コード
     */
    public RString get医師コード() {
        return entity.getIshiShikibetsuNo();
    }

    /**
     * 医師の状況を返します。
     *
     * @return 医師の状況
     */
    public RString get医師の状況() {
        return entity.getShujiiJokyo();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    public TelNo getFAX番号() {
        return entity.getFaxNo();
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
    }

    /**
     * 介護医療機関コードを設定します。
     *
     * @param 介護医療機関コード 介護医療機関コード
     */
    public void set介護医療機関コード(RString 介護医療機関コード) {
        requireNonNull(介護医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護医療機関コード"));
        entity.setKaigoIryokikanCode(介護医療機関コード);
    }

    /**
     * 介護医師コードを設定します。
     *
     * @param 介護医師コード 介護医師コード
     */
    public void set介護医師コード(RString 介護医師コード) {
        requireNonNull(介護医師コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護医師コード"));
        entity.setKaigoIshiCode(介護医師コード);
    }

    /**
     * 医療機関コードを設定します。
     *
     * @param 医療機関コード 医療機関コード
     */
    public void set医療機関コード(RString 医療機関コード) {
        requireNonNull(医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("医療機関コード"));
        entity.setIryokikanCode(医療機関コード);
    }

    /**
     * 医師コードを設定します。
     *
     * @param 医師コード 医師コード
     */
    public void set医師コード(RString 医師コード) {
        requireNonNull(医師コード, UrSystemErrorMessages.値がnull.getReplacedMessage("医師コード"));
        entity.setIshiShikibetsuNo(医師コード);
    }

    /**
     * 医師の状況を設定します。
     *
     * @param 医師の状況 医師の状況
     */
    public void set医師の状況(RString 医師の状況) {
        requireNonNull(医師の状況, UrSystemErrorMessages.値がnull.getReplacedMessage("医師の状況"));
        entity.setShujiiJokyo(医師の状況);
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     */
    public void set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     */
    public void set住所(AtenaJusho 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     */
    public void set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
    }

    /**
     * FAX番号を設定します。
     *
     * @param FAX番号 FAX番号
     */
    public void setFAX番号(TelNo FAX番号) {
        requireNonNull(FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("FAX番号"));
        entity.setFaxNo(FAX番号);
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
