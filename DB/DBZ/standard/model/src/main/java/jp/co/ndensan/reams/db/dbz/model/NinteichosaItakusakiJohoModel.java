/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査委託先情報　継承のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class NinteichosaItakusakiJohoModel implements Serializable {

    private DbT7010NinteichosaItakusakiJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public NinteichosaItakusakiJohoModel() {
        entity = new DbT7010NinteichosaItakusakiJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7010NinteichosaItakusakiJohoEntity
     */
    public NinteichosaItakusakiJohoModel(DbT7010NinteichosaItakusakiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7010NinteichosaItakusakiJohoEntityを返します。
     *
     * @return DbT7010NinteichosaItakusakiJohoEntity
     */
    public DbT7010NinteichosaItakusakiJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7010NinteichosaItakusakiJohoEntityを設定します。
     *
     * @param entity DbT7010NinteichosaItakusakiJohoEntity
     */
    public void setEntity(DbT7010NinteichosaItakusakiJohoEntity entity) {
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
     * 介護事業者番号を返します。
     *
     * @return 介護事業者番号
     */
    public RString get介護事業者番号() {
        return entity.getKaigoJigyoshaNo();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public RString get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 介護事業者状況を返します。
     *
     * @return 介護事業者状況
     */
    public RString get介護事業者状況() {
        return entity.getKaigoJigyoshaJokyo();
    }

    /**
     * 調査委託区分コードを返します。
     *
     * @return 調査委託区分コード
     */
    public Code get調査委託区分コード() {
        return entity.getChosaItakuKubunCode();
    }

    /**
     * 割付定員を返します。
     *
     * @return 割付定員
     */
    public int get割付定員() {
        return entity.getWaritsukeTeiin();
    }

    /**
     * 割付地区を返します。
     *
     * @return 割付地区
     */
    public ChikuCode get割付地区() {
        return entity.getWaritsukeChiku();
    }

    /**
     * 機関の区分コードを返します。
     *
     * @return 機関の区分コード
     */
    public Code get機関の区分コード() {
        return entity.getKikanKubunCode();
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
     * 介護事業者番号を設定します。
     *
     * @param 介護事業者番号 介護事業者番号
     */
    public void set介護事業者番号(RString 介護事業者番号) {
        requireNonNull(介護事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者番号"));
        entity.setKaigoJigyoshaNo(介護事業者番号);
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     */
    public void set事業者番号(RString 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
    }

    /**
     * 介護事業者状況を設定します。
     *
     * @param 介護事業者状況 介護事業者状況
     */
    public void set介護事業者状況(RString 介護事業者状況) {
        requireNonNull(介護事業者状況, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者状況"));
        entity.setKaigoJigyoshaJokyo(介護事業者状況);
    }

    /**
     * 調査委託区分コードを設定します。
     *
     * @param 調査委託区分コード 調査委託区分コード
     */
    public void set調査委託区分コード(Code 調査委託区分コード) {
        requireNonNull(調査委託区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査委託区分コード"));
        entity.setChosaItakuKubunCode(調査委託区分コード);
    }

    /**
     * 割付定員を設定します。
     *
     * @param 割付定員 割付定員
     */
    public void set割付定員(int 割付定員) {
        requireNonNull(割付定員, UrSystemErrorMessages.値がnull.getReplacedMessage("割付定員"));
        entity.setWaritsukeTeiin(割付定員);
    }

    /**
     * 割付地区を設定します。
     *
     * @param 割付地区 割付地区
     */
    public void set割付地区(ChikuCode 割付地区) {
        requireNonNull(割付地区, UrSystemErrorMessages.値がnull.getReplacedMessage("割付地区"));
        entity.setWaritsukeChiku(割付地区);
    }

    /**
     * 機関の区分コードを設定します。
     *
     * @param 機関の区分コード 機関の区分コード
     */
    public void set機関の区分コード(Code 機関の区分コード) {
        requireNonNull(機関の区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("機関の区分コード"));
        entity.setKikanKubunCode(機関の区分コード);
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
