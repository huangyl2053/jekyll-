/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 連動保留特定住所マスタのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class RendoHoryuTokuteiJushoModel implements Serializable {

    private DbT7023RendoHoryuTokuteiJushoEntity entity;

    /**
     * コンストラクタです。
     */
    public RendoHoryuTokuteiJushoModel() {
        entity = new DbT7023RendoHoryuTokuteiJushoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7023RendoHoryuTokuteiJushoEntity
     */
    public RendoHoryuTokuteiJushoModel(DbT7023RendoHoryuTokuteiJushoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7023RendoHoryuTokuteiJushoEntityを返します。
     *
     * @return DbT7023RendoHoryuTokuteiJushoEntity
     */
    public DbT7023RendoHoryuTokuteiJushoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7023RendoHoryuTokuteiJushoEntityを設定します。
     *
     * @param entity DbT7023RendoHoryuTokuteiJushoEntity
     */
    public void setEntity(DbT7023RendoHoryuTokuteiJushoEntity entity) {
        this.entity = entity;
    }

    /**
     * 管理番号を返します。
     *
     * @return 管理番号
     */
    public RString get管理番号() {
        return entity.getKanriNo();
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
     * 住所コードを返します。
     *
     * @return 住所コード
     */
    public ChoikiCode get住所コード() {
        return entity.getJushoCode();
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
     * 番地コード１を返します。
     *
     * @return 番地コード１
     */
    public BanchiCode get番地コード１() {
        return entity.getBanchiCode1();
    }

    /**
     * 番地コード２を返します。
     *
     * @return 番地コード２
     */
    public BanchiCode get番地コード２() {
        return entity.getBanchiCode2();
    }

    /**
     * 番地コード３を返します。
     *
     * @return 番地コード３
     */
    public BanchiCode get番地コード３() {
        return entity.getBanchiCode3();
    }

    /**
     * 番地を返します。
     *
     * @return 番地
     */
    public AtenaBanchi get番地() {
        return entity.getBanchi();
    }

    /**
     * 施設種類を返します。
     *
     * @return 施設種類
     */
    public RString get施設種類() {
        return entity.getShisetsuShurui();
    }

    /**
     * 施設コードを返します。
     *
     * @return 施設コード
     */
    public RString get施設コード() {
        return entity.getShisetsuCode();
    }

    /**
     * 管理番号を設定します。
     *
     * @param 管理番号 管理番号
     */
    public void set管理番号(RString 管理番号) {
        requireNonNull(管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("管理番号"));
        entity.setKanriNo(管理番号);
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
     * 住所コードを設定します。
     *
     * @param 住所コード 住所コード
     */
    public void set住所コード(ChoikiCode 住所コード) {
        requireNonNull(住所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住所コード"));
        entity.setJushoCode(住所コード);
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
     * 番地コード１を設定します。
     *
     * @param 番地コード１ 番地コード１
     */
    public void set番地コード１(BanchiCode 番地コード１) {
        requireNonNull(番地コード１, UrSystemErrorMessages.値がnull.getReplacedMessage("番地コード１"));
        entity.setBanchiCode1(番地コード１);
    }

    /**
     * 番地コード２を設定します。
     *
     * @param 番地コード２ 番地コード２
     */
    public void set番地コード２(BanchiCode 番地コード２) {
        requireNonNull(番地コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("番地コード２"));
        entity.setBanchiCode2(番地コード２);
    }

    /**
     * 番地コード３を設定します。
     *
     * @param 番地コード３ 番地コード３
     */
    public void set番地コード３(BanchiCode 番地コード３) {
        requireNonNull(番地コード３, UrSystemErrorMessages.値がnull.getReplacedMessage("番地コード３"));
        entity.setBanchiCode3(番地コード３);
    }

    /**
     * 番地を設定します。
     *
     * @param 番地 番地
     */
    public void set番地(AtenaBanchi 番地) {
        requireNonNull(番地, UrSystemErrorMessages.値がnull.getReplacedMessage("番地"));
        entity.setBanchi(番地);
    }

    /**
     * 施設種類を設定します。
     *
     * @param 施設種類 施設種類
     */
    public void set施設種類(RString 施設種類) {
        requireNonNull(施設種類, UrSystemErrorMessages.値がnull.getReplacedMessage("方書コード"));
        entity.setShisetsuShurui(施設種類);
    }

    /**
     * 施設コードを設定します。
     *
     * @param 施設コード 施設コード
     */
    public void set方書(RString 施設コード) {
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("方書"));
        entity.setShisetsuCode(施設コード);
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
