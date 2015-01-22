/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7105KaigoninteiJukyuFlagEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定受給フラグのモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class KaigoninteiJukyuFlagModel implements Serializable {

    private DbT7105KaigoninteiJukyuFlagEntity entity;

    /**
     * コンストラクタです。
     */
    public KaigoninteiJukyuFlagModel() {
        entity = new DbT7105KaigoninteiJukyuFlagEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7105KaigoninteiJukyuFlagEntity
     */
    public KaigoninteiJukyuFlagModel(DbT7105KaigoninteiJukyuFlagEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7105KaigoninteiJukyuFlagEntityを返します。
     *
     * @return DbT7105KaigoninteiJukyuFlagEntity
     */
    public DbT7105KaigoninteiJukyuFlagEntity getEntity() {
        return entity;
    }

    /**
     * DbT7105KaigoninteiJukyuFlagEntityを設定します。
     *
     * @param entity DbT7105KaigoninteiJukyuFlagEntity
     */
    public void setEntity(DbT7105KaigoninteiJukyuFlagEntity entity) {
        this.entity = entity;
    }

    /**
     * 基本情報状況フラグを返します。
     *
     * @return 基本情報状況フラグ
     */
    public boolean get基本情報状況フラグ() {
        return entity.getKihonJokyoFlag();
    }

    /**
     * モバイルデータ出力フラグを返します。
     *
     * @return モバイルデータ出力フラグ
     */
    public boolean getモバイルデータ出力フラグ() {
        return entity.getMobileDataFlag();
    }

    /**
     * 認定情報提供希望有フラグを返します。
     *
     * @return 認定情報提供希望有フラグ
     */
    public boolean get認定情報提供希望有フラグ() {
        return entity.getNinteiJohoTeikyoKiboAriFlag();
    }

    /**
     * 介護認定審査会審査順確定フラグを返します。
     *
     * @return 介護認定審査会審査順確定フラグ
     */
    public boolean get介護認定審査会審査順確定フラグ() {
        return entity.getShinsakaiShinsajunKakuteiFlag();
    }

    /**
     * 合議体ダミーフラグを返します。
     *
     * @return 合議体ダミーフラグ
     */
    public boolean get合議体ダミーフラグ() {
        return entity.getGogitaiDummyFlag();
    }

    /**
     * 合議体精神科医存在フラグを返します。
     *
     * @return 合議体精神科医存在フラグ
     */
    public boolean get合議体精神科医存在フラグ() {
        return entity.getGogitaiSeishinkaiFlag();
    }

    /**
     * 介護認定審査会休会フラグを返します。
     *
     * @return 介護認定審査会休会フラグ
     */
    public boolean get介護認定審査会休会フラグ() {
        return entity.getShinsakaiKyukaiFlag();
    }

    /**
     * 基本情報状況フラグを設定します。
     *
     * @param 基本情報状況フラグ 基本情報状況フラグ
     */
    public void set基本情報状況フラグ(boolean 基本情報状況フラグ) {
        requireNonNull(基本情報状況フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("基本情報状況フラグ"));
        entity.setKihonJokyoFlag(基本情報状況フラグ);
    }

    /**
     * モバイルデータ出力フラグを設定します。
     *
     * @param モバイルデータ出力フラグ モバイルデータ出力フラグ
     */
    public void setモバイルデータ出力フラグ(boolean モバイルデータ出力フラグ) {
        requireNonNull(モバイルデータ出力フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("モバイルデータ出力フラグ"));
        entity.setMobileDataFlag(モバイルデータ出力フラグ);
    }

    /**
     * 認定情報提供希望有フラグを設定します。
     *
     * @param 認定情報提供希望有フラグ 認定情報提供希望有フラグ
     */
    public void set認定情報提供希望有フラグ(boolean 認定情報提供希望有フラグ) {
        requireNonNull(認定情報提供希望有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("認定情報提供希望有フラグ"));
        entity.setNinteiJohoTeikyoKiboAriFlag(認定情報提供希望有フラグ);
    }

    /**
     * 介護認定審査会審査順確定フラグを設定します。
     *
     * @param 介護認定審査会審査順確定フラグ 介護認定審査会審査順確定フラグ
     */
    public void set介護認定審査会審査順確定フラグ(boolean 介護認定審査会審査順確定フラグ) {
        requireNonNull(介護認定審査会審査順確定フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会審査順確定フラグ"));
        entity.setShinsakaiShinsajunKakuteiFlag(介護認定審査会審査順確定フラグ);
    }

    /**
     * 合議体ダミーフラグを設定します。
     *
     * @param 合議体ダミーフラグ 合議体ダミーフラグ
     */
    public void set合議体ダミーフラグ(boolean 合議体ダミーフラグ) {
        requireNonNull(合議体ダミーフラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体ダミーフラグ"));
        entity.setGogitaiDummyFlag(合議体ダミーフラグ);
    }

    /**
     * 合議体精神科医存在フラグを設定します。
     *
     * @param 合議体精神科医存在フラグ 合議体精神科医存在フラグ
     */
    public void set合議体精神科医存在フラグ(boolean 合議体精神科医存在フラグ) {
        requireNonNull(合議体精神科医存在フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体精神科医存在フラグ"));
        entity.setGogitaiSeishinkaiFlag(合議体精神科医存在フラグ);
    }

    /**
     * 介護認定審査会休会フラグを設定します。
     *
     * @param 介護認定審査会休会フラグ 介護認定審査会休会フラグ
     */
    public void set介護認定審査会休会フラグ(boolean 介護認定審査会休会フラグ) {
        requireNonNull(介護認定審査会休会フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会休会フラグ"));
        entity.setShinsakaiKyukaiFlag(介護認定審査会休会フラグ);
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
