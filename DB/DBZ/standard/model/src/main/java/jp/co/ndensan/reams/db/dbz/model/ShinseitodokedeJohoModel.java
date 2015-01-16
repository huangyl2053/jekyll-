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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7053ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 申請届出情報のモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class ShinseitodokedeJohoModel implements Serializable {

    private DbT7053ShinseitodokedeJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public ShinseitodokedeJohoModel() {
        entity = new DbT7053ShinseitodokedeJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7053ShinseitodokedeJohoEntity
     */
    public ShinseitodokedeJohoModel(DbT7053ShinseitodokedeJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7053ShinseitodokedeJohoEntityを返します。
     *
     * @return DbT7053ShinseitodokedeJohoEntity
     */
    public DbT7053ShinseitodokedeJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7053ShinseitodokedeJohoEntityを設定します。
     *
     * @param entity DbT7053ShinseitodokedeJohoEntity
     */
    public void setEntity(DbT7053ShinseitodokedeJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 申請届出年月日を返します。
     *
     * @return 申請届出年月日
     */
    public RDate get申請届出年月日() {
        return entity.getShinseiTodokedeYMD();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 申請届出種別コードを返します。
     *
     * @return 申請届出種別コード
     */
    public RString get申請届出種別コード() {
        return entity.getShinseiTodokedeShubetsuCode();
    }

    /**
     * 申請届出代行区分コードを返します。
     *
     * @return 申請届出代行区分コード
     */
    public Code get申請届出代行区分コード() {
        return entity.getShinseiTodokedeDaikoKubunCode();
    }

    /**
     * 申請届出者氏名を返します。
     *
     * @return 申請届出者氏名
     */
    public AtenaMeisho get申請届出者氏名() {
        return entity.getShinseiTodokedeshaShimei();
    }

    /**
     * 申請届出者氏名カナを返します。
     *
     * @return 申請届出者氏名カナ
     */
    public AtenaKanaMeisho get申請届出者氏名カナ() {
        return entity.getShinseiTodokedeshaKanaShimei();
    }

    /**
     * 申請届出者続柄コードを返します。
     *
     * @return 申請届出者続柄コード
     */
    public RString get申請届出者続柄コード() {
        return entity.getShinseiTodokedeshaTsuzukigaraCode();
    }

    /**
     * 申請届出代行事業者番号を返します。
     *
     * @return 申請届出代行事業者番号
     */
    public JigyoshaNo get申請届出代行事業者番号() {
        return entity.getShinseiTodokedeDaikoJigyoshaNo();
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
     * 申請届出者郵便番号を返します。
     *
     * @return 申請届出者郵便番号
     */
    public YubinNo get申請届出者郵便番号() {
        return entity.getShinseiTodokedeshaYubinNo();
    }

    /**
     * 申請届出者住所を返します。
     *
     * @return 申請届出者住所
     */
    public AtenaJusho get申請届出者住所() {
        return entity.getShinseiTodokedeshaJusho();
    }

    /**
     * 申請届出者電話番号を返します。
     *
     * @return 申請届出者電話番号
     */
    public TelNo get申請届出者電話番号() {
        return entity.getShinseiTodokedeshaTelNo();
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
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
     * 申請届出年月日を設定します。
     *
     * @param 申請届出年月日 申請届出年月日
     */
    public void set申請届出年月日(RDate 申請届出年月日) {
        requireNonNull(申請届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出年月日"));
        entity.setShinseiTodokedeYMD(申請届出年月日);
    }

    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public void set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
    }

    /**
     * 申請届出種別コードを設定します。
     *
     * @param 申請届出種別コード 申請届出種別コード
     */
    public void set申請届出種別コード(RString 申請届出種別コード) {
        requireNonNull(申請届出種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出種別コード"));
        entity.setShinseiTodokedeShubetsuCode(申請届出種別コード);
    }

    /**
     * 申請届出代行区分コードを設定します。
     *
     * @param 申請届出代行区分コード 申請届出代行区分コード
     */
    public void set申請届出代行区分コード(Code 申請届出代行区分コード) {
        requireNonNull(申請届出代行区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出代行区分コード"));
        entity.setShinseiTodokedeDaikoKubunCode(申請届出代行区分コード);
    }

    /**
     * 申請届出者氏名を設定します。
     *
     * @param 申請届出者氏名 申請届出者氏名
     */
    public void set申請届出者氏名(AtenaMeisho 申請届出者氏名) {
        requireNonNull(申請届出者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者氏名"));
        entity.setShinseiTodokedeshaShimei(申請届出者氏名);
    }

    /**
     * 申請届出者氏名カナを設定します。
     *
     * @param 申請届出者氏名カナ 申請届出者氏名カナ
     */
    public void set申請届出者氏名カナ(AtenaKanaMeisho 申請届出者氏名カナ) {
        requireNonNull(申請届出者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者氏名カナ"));
        entity.setShinseiTodokedeshaKanaShimei(申請届出者氏名カナ);
    }

    /**
     * 申請届出者続柄コードを設定します。
     *
     * @param 申請届出者続柄コード 申請届出者続柄コード
     */
    public void set申請届出者続柄コード(RString 申請届出者続柄コード) {
        requireNonNull(申請届出者続柄コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者続柄コード"));
        entity.setShinseiTodokedeshaTsuzukigaraCode(申請届出者続柄コード);
    }

    /**
     * 申請届出代行事業者番号を設定します。
     *
     * @param 申請届出代行事業者番号 申請届出代行事業者番号
     */
    public void set申請届出代行事業者番号(JigyoshaNo 申請届出代行事業者番号) {
        requireNonNull(申請届出代行事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出代行事業者番号"));
        entity.setShinseiTodokedeDaikoJigyoshaNo(申請届出代行事業者番号);
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
     * 申請届出者郵便番号を設定します。
     *
     * @param 申請届出者郵便番号 申請届出者郵便番号
     */
    public void set申請届出者郵便番号(YubinNo 申請届出者郵便番号) {
        requireNonNull(申請届出者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者郵便番号"));
        entity.setShinseiTodokedeshaYubinNo(申請届出者郵便番号);
    }

    /**
     * 申請届出者住所を設定します。
     *
     * @param 申請届出者住所 申請届出者住所
     */
    public void set申請届出者住所(AtenaJusho 申請届出者住所) {
        requireNonNull(申請届出者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者住所"));
        entity.setShinseiTodokedeshaJusho(申請届出者住所);
    }

    /**
     * 申請届出者電話番号を設定します。
     *
     * @param 申請届出者電話番号 申請届出者電話番号
     */
    public void set申請届出者電話番号(TelNo 申請届出者電話番号) {
        requireNonNull(申請届出者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出者電話番号"));
        entity.setShinseiTodokedeshaTelNo(申請届出者電話番号);
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
