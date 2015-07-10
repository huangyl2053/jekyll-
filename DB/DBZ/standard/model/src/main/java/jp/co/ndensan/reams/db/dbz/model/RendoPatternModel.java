/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 連動パターンのモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class RendoPatternModel implements Serializable {

    private DbT7035RendoPatternEntity entity;

    /**
     * コンストラクタです。
     */
    public RendoPatternModel() {
        entity = new DbT7035RendoPatternEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7035RendoPatternEntity
     */
    public RendoPatternModel(DbT7035RendoPatternEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7035RendoPatternEntityを返します。
     *
     * @return DbT7035RendoPatternEntity
     */
    public DbT7035RendoPatternEntity getEntity() {
        return entity;
    }

    /**
     * DbT7035RendoPatternEntityを設定します。
     *
     * @param entity DbT7035RendoPatternEntity
     */
    public void setEntity(DbT7035RendoPatternEntity entity) {
        this.entity = entity;
    }

    /**
     * 送信元市町村コードを返します。
     *
     * @return 送信元市町村コード
     */
    public LasdecCode get送信元市町村コード() {
        return entity.getMotoShichosonCode();
    }

    /**
     * 送信先市町村コードを返します。
     *
     * @return 送信先市町村コード
     */
    public LasdecCode get送信先市町村コード() {
        return entity.getSakiShichosonCode();
    }

    /**
     * 種別を返します。
     *
     * @return 種別
     */
    public RString get種別() {
        return entity.getShubetsu();
    }

    /**
     * 有効開始年月日を返します。
     *
     * @return 有効開始年月日
     */
    public FlexibleDate get有効開始年月日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 有効終了年月日を返します。
     *
     * @return 有効終了年月日
     */
    public FlexibleDate get有効終了年月日() {
        return entity.getYukoShuryoYMD();
    }

    /**
     * 連動形態コードを返します。
     *
     * @return 連動形態コード
     */
    public RString get連動形態コード() {
        return entity.getRendoKeitaiCode();
    }

    /**
     * 送信元フォーマットバージョンを返します。
     *
     * @return 送信元フォーマットバージョン
     */
    public RString get送信元フォーマットバージョン() {
        return entity.getMotoFormatVersion();
    }

    /**
     * 送信元エンコーディングを返します。
     *
     * @return 送信元エンコーディング
     */
    public RString get送信元エンコーディング() {
        return entity.getMotoEncodeKeitai();
    }

    /**
     * 送信先フォーマットバージョンを返します。
     *
     * @return 送信先フォーマットバージョン
     */
    public RString get送信先フォーマットバージョン() {
        return entity.getSakiFormatVersion();
    }

    /**
     * 送信先エンコーディングを返します。
     *
     * @return 送信先エンコーディング
     */
    public RString get送信先エンコーディング() {
        return entity.getSakiEncodeKeitai();
    }

    /**
     * コード変換区分を返します。
     *
     * @return コード変換区分
     */
    public RString getコード変換区分() {
        return entity.getCodeHenkanKubun();
    }

    /**
     * 外字変換区分を返します。
     *
     * @return 外字変換区分
     */
    public RString get外字変換区分() {
        return entity.getGaijiHenkanKubun();
    }

    /**
     * 全件連動区分を返します。
     *
     * @return 全件連動区分
     */
    public RString get全件連動区分() {
        return entity.getZenkenRendoKubun();
    }

    /**
     * 連携区分を返します。
     *
     * @return 連携区分
     */
    public RString get連携区分() {
        return entity.getRendoKubun();
    }

    /**
     * 送信元市町村コードを設定します。
     *
     * @param 送信元市町村コード 送信元市町村コード
     */
    public void set送信元市町村コード(LasdecCode 送信元市町村コード) {
        requireNonNull(送信元市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("送信元市町村コード"));
        entity.setMotoShichosonCode(送信元市町村コード);
    }

    /**
     * 送信先市町村コードを設定します。
     *
     * @param 送信先市町村コード 送信先市町村コード
     */
    public void set送信先市町村コード(LasdecCode 送信先市町村コード) {
        requireNonNull(送信先市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("送信先市町村コード"));
        entity.setSakiShichosonCode(送信先市町村コード);
    }

    /**
     * 種別を設定します。
     *
     * @param 種別 種別
     */
    public void set種別(RString 種別) {
        requireNonNull(種別, UrSystemErrorMessages.値がnull.getReplacedMessage("種別"));
        entity.setShubetsu(種別);
    }

    /**
     * 有効開始年月日を設定します。
     *
     * @param 有効開始年月日 有効開始年月日
     */
    public void set有効開始年月日(FlexibleDate 有効開始年月日) {
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
        entity.setYukoKaishiYMD(有効開始年月日);
    }

    /**
     * 有効終了年月日を設定します。
     *
     * @param 有効終了年月日 有効終了年月日
     */
    public void set有効終了年月日(FlexibleDate 有効終了年月日) {
        requireNonNull(有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了年月日"));
        entity.setYukoShuryoYMD(有効終了年月日);
    }

    /**
     * 連動形態コードを設定します。
     *
     * @param 連動形態コード 連動形態コード
     */
    public void set連動形態コード(RString 連動形態コード) {
        requireNonNull(連動形態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("連動形態コード"));
        entity.setRendoKeitaiCode(連動形態コード);
    }

    /**
     * 送信元フォーマットバージョンを設定します。
     *
     * @param 送信元フォーマットバージョン 送信元フォーマットバージョン
     */
    public void set送信元フォーマットバージョン(RString 送信元フォーマットバージョン) {
        requireNonNull(送信元フォーマットバージョン, UrSystemErrorMessages.値がnull.getReplacedMessage("送信元フォーマットバージョン"));
        entity.setMotoFormatVersion(送信元フォーマットバージョン);
    }

    /**
     * 送信元エンコーディングを設定します。
     *
     * @param 送信元エンコーディング 送信元エンコーディング
     */
    public void set送信元エンコーディング(RString 送信元エンコーディング) {
        requireNonNull(送信元エンコーディング, UrSystemErrorMessages.値がnull.getReplacedMessage("送信元エンコーディング"));
        entity.setMotoEncodeKeitai(送信元エンコーディング);
    }

    /**
     * 送信先フォーマットバージョンを設定します。
     *
     * @param 送信先フォーマットバージョン 送信先フォーマットバージョン
     */
    public void set送信先フォーマットバージョン(RString 送信先フォーマットバージョン) {
        requireNonNull(送信先フォーマットバージョン, UrSystemErrorMessages.値がnull.getReplacedMessage("送信先フォーマットバージョン"));
        entity.setSakiFormatVersion(送信先フォーマットバージョン);
    }

    /**
     * 送信先エンコーディングを設定します。
     *
     * @param 送信先エンコーディング 送信先エンコーディング
     */
    public void set送信先エンコーディング(RString 送信先エンコーディング) {
        requireNonNull(送信先エンコーディング, UrSystemErrorMessages.値がnull.getReplacedMessage("送信先エンコーディング"));
        entity.setSakiEncodeKeitai(送信先エンコーディング);
    }

    /**
     * コード変換区分を設定します。
     *
     * @param コード変換区分 コード変換区分
     */
    public void setコード変換区分(RString コード変換区分) {
        requireNonNull(コード変換区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード変換区分"));
        entity.setCodeHenkanKubun(コード変換区分);
    }

    /**
     * 外字変換区分を設定します。
     *
     * @param 外字変換区分 外字変換区分
     */
    public void set外字変換区分(RString 外字変換区分) {
        requireNonNull(外字変換区分, UrSystemErrorMessages.値がnull.getReplacedMessage("外字変換区分"));
        entity.setGaijiHenkanKubun(外字変換区分);
    }

    /**
     * 全件連動区分を設定します。
     *
     * @param 全件連動区分 全件連動区分
     */
    public void set全件連動区分(RString 全件連動区分) {
        requireNonNull(全件連動区分, UrSystemErrorMessages.値がnull.getReplacedMessage("全件連動区分"));
        entity.setZenkenRendoKubun(全件連動区分);
    }

    /**
     * 連携区分を設定します。
     *
     * @param 連携区分 連携区分
     */
    public void set連携区分(RString 連携区分) {
        requireNonNull(連携区分, UrSystemErrorMessages.値がnull.getReplacedMessage("連携区分"));
        entity.setRendoKubun(連携区分);
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
