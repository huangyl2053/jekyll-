/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7013ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 調査員情報　継承のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class ChosainJohoModel implements Serializable {

    private DbT7013ChosainJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public ChosainJohoModel() {
        entity = new DbT7013ChosainJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7013ChosainJohoEntity
     */
    public ChosainJohoModel(DbT7013ChosainJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7013ChosainJohoEntityを返します。
     *
     * @return DbT7013ChosainJohoEntity
     */
    public DbT7013ChosainJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7013ChosainJohoEntityを設定します。
     *
     * @param entity DbT7013ChosainJohoEntity
     */
    public void setEntity(DbT7013ChosainJohoEntity entity) {
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
     * 介護調査員番号を返します。
     *
     * @return 介護調査員番号
     */
    public RString get介護調査員番号() {
        return entity.getKaigoChosainNo();
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
     * 介護調査員状況を返します。
     *
     * @return 介護調査員状況
     */
    public RString get介護調査員状況() {
        return entity.getKaigoChosainJokyo();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public AtenaMeisho get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 調査員氏名カナを返します。
     *
     * @return 調査員氏名カナ
     */
    public AtenaKanaMeisho get調査員氏名カナ() {
        return entity.getChosainKanaShimei();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 調査員資格コードを返します。
     *
     * @return 調査員資格コード
     */
    public Code get調査員資格コード() {
        return entity.getChosainShikakuCode();
    }

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    public ChikuCode get地区コード() {
        return entity.getChikuCode();
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
     * 介護調査員番号を設定します。
     *
     * @param 介護調査員番号 介護調査員番号
     */
    public void set介護調査員番号(RString 介護調査員番号) {
        requireNonNull(介護調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護調査員番号"));
        entity.setKaigoChosainNo(介護調査員番号);
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
     * 介護調査員状況を設定します。
     *
     * @param 介護調査員状況 介護調査員状況
     */
    public void set介護調査員状況(RString 介護調査員状況) {
        requireNonNull(介護調査員状況, UrSystemErrorMessages.値がnull.getReplacedMessage("介護調査員状況"));
        entity.setKaigoChosainJokyo(介護調査員状況);
    }

    /**
     * 調査員氏名を設定します。
     *
     * @param 調査員氏名 調査員氏名
     */
    public void set調査員氏名(AtenaMeisho 調査員氏名) {
        requireNonNull(調査員氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員氏名"));
        entity.setChosainShimei(調査員氏名);
    }

    /**
     * 調査員氏名カナを設定します。
     *
     * @param 調査員氏名カナ 調査員氏名カナ
     */
    public void set調査員氏名カナ(AtenaKanaMeisho 調査員氏名カナ) {
        requireNonNull(調査員氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員氏名カナ"));
        entity.setChosainKanaShimei(調査員氏名カナ);
    }

    /**
     * 性別を設定します。
     *
     * @param 性別 性別
     */
    public void set性別(RString 性別) {
        requireNonNull(性別, UrSystemErrorMessages.値がnull.getReplacedMessage("性別"));
        entity.setSeibetsu(性別);
    }

    /**
     * 調査員資格コードを設定します。
     *
     * @param 調査員資格コード 調査員資格コード
     */
    public void set調査員資格コード(Code 調査員資格コード) {
        requireNonNull(調査員資格コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員資格コード"));
        entity.setChosainShikakuCode(調査員資格コード);
    }

    /**
     * 地区コードを設定します。
     *
     * @param 地区コード 地区コード
     */
    public void set地区コード(ChikuCode 地区コード) {
        requireNonNull(地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("地区コード"));
        entity.setChikuCode(地区コード);
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
