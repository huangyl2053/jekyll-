/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLogEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 広域外字変換エラーログのモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class KoikiGaijiHenkanErrorLogModel implements Serializable {

    private DbT7034KoikiGaijiHenkanErrorLogEntity entity;

    /**
     * コンストラクタです。
     */
    public KoikiGaijiHenkanErrorLogModel() {
        entity = new DbT7034KoikiGaijiHenkanErrorLogEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7034KoikiGaijiHenkanErrorLogEntity
     */
    public KoikiGaijiHenkanErrorLogModel(DbT7034KoikiGaijiHenkanErrorLogEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7034KoikiGaijiHenkanErrorLogEntityを返します。
     *
     * @return DbT7034KoikiGaijiHenkanErrorLogEntity
     */
    public DbT7034KoikiGaijiHenkanErrorLogEntity getEntity() {
        return entity;
    }

    /**
     * DbT7034KoikiGaijiHenkanErrorLogEntityを設定します。
     *
     * @param entity DbT7034KoikiGaijiHenkanErrorLogEntity
     */
    public void setEntity(DbT7034KoikiGaijiHenkanErrorLogEntity entity) {
        this.entity = entity;
    }

    /**
     * 処理番号を返します。
     *
     * @return 処理番号
     */
    public RString get処理番号() {
        return entity.getShoriNo();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public RString get連番() {
        return entity.getRenNo();
    }

    /**
     * 市町村番号を返します。
     *
     * @return 市町村番号
     */
    public LasdecCode get市町村番号() {
        return entity.getShichosonCode();
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
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return entity.getShoriTimestamp();
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
     * 送信元市町村名称を返します。
     *
     * @return 送信元市町村名称
     */
    public RString get送信元市町村名称() {
        return entity.getMotoShichosonMeisho();
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
     * 送信先市町村名称を返します。
     *
     * @return 送信先市町村名称
     */
    public RString get送信先市町村名称() {
        return entity.getSakiShichosonMeisho();
    }

    /**
     * 住基識別コードを返します。
     *
     * @return 住基識別コード
     */
    public ShikibetsuCode get住基識別コード() {
        return entity.getJukiShikibetsuCode();
    }

    /**
     * 確認区分を返します。
     *
     * @return 確認区分
     */
    public RString get確認区分() {
        return entity.getKakuninKubun();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
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
     * レコードＮｏを返します。
     *
     * @return レコードＮｏ
     */
    public RString getレコードＮｏ() {
        return entity.getRecoadNo();
    }

    /**
     * 変換エラーフィールド名称を返します。
     *
     * @return 変換エラーフィールド名称
     */
    public RString get変換エラーフィールド名称() {
        return entity.getErrorKomokuMeisho();
    }

    /**
     * 変換エラーフィールドＮｏを返します。
     *
     * @return 変換エラーフィールドＮｏ
     */
    public RString get変換エラーフィールドＮｏ() {
        return entity.getErrorKomokuNo();
    }

    /**
     * 変換エラーコードを返します。
     *
     * @return 変換エラーコード
     */
    public RString get変換エラーコード() {
        return entity.getErrorCode();
    }

    /**
     * エラー表示連番を返します。
     *
     * @return エラー表示連番
     */
    public RString getエラー表示連番() {
        return entity.getErrorHyojiRenban();
    }

    /**
     * エラー表示フィールド名称を返します。
     *
     * @return エラー表示フィールド名称
     */
    public RString getエラー表示フィールド名称() {
        return entity.getErrorHyojiKomokuMeisho();
    }

    /**
     * エラー表示フィールドを返します。
     *
     * @return エラー表示フィールド
     */
    public RString getエラー表示フィールド() {
        return entity.getErrorHyojiKomoku();
    }

    /**
     * 処理番号を設定します。
     *
     * @param 処理番号 処理番号
     */
    public void set処理番号(RString 処理番号) {
        requireNonNull(処理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("処理番号"));
        entity.setShoriNo(処理番号);
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     */
    public void set連番(RString 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenNo(連番);
    }

    /**
     * 市町村番号を設定します。
     *
     * @param 市町村番号 市町村番号
     */
    public void set市町村番号(LasdecCode 市町村番号) {
        requireNonNull(市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村番号"));
        entity.setShichosonCode(市町村番号);
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
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(RDateTime 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
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
     * 送信元市町村名称を設定します。
     *
     * @param 送信元市町村名称 送信元市町村名称
     */
    public void set送信元市町村名称(RString 送信元市町村名称) {
        requireNonNull(送信元市町村名称, UrSystemErrorMessages.値がnull.getReplacedMessage("送信元市町村名称"));
        entity.setMotoShichosonMeisho(送信元市町村名称);
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
     * 送信先市町村名称を設定します。
     *
     * @param 送信先市町村名称 送信先市町村名称
     */
    public void set送信先市町村名称(RString 送信先市町村名称) {
        requireNonNull(送信先市町村名称, UrSystemErrorMessages.値がnull.getReplacedMessage("送信先市町村名称"));
        entity.setSakiShichosonMeisho(送信先市町村名称);
    }

    /**
     * 住基識別コードを設定します。
     *
     * @param 住基識別コード 住基識別コード
     */
    public void set住基識別コード(ShikibetsuCode 住基識別コード) {
        requireNonNull(住基識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住基識別コード"));
        entity.setJukiShikibetsuCode(住基識別コード);
    }

    /**
     * 確認区分を設定します。
     *
     * @param 確認区分 確認区分
     */
    public void set確認区分(RString 確認区分) {
        requireNonNull(確認区分, UrSystemErrorMessages.値がnull.getReplacedMessage("確認区分"));
        entity.setKakuninKubun(確認区分);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
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
     * レコードＮｏを設定します。
     *
     * @param レコードＮｏ レコードＮｏ
     */
    public void setレコードＮｏ(RString レコードＮｏ) {
        requireNonNull(レコードＮｏ, UrSystemErrorMessages.値がnull.getReplacedMessage("レコードＮｏ"));
        entity.setRecoadNo(レコードＮｏ);
    }

    /**
     * 変換エラーフィールド名称を設定します。
     *
     * @param 変換エラーフィールド名称 変換エラーフィールド名称
     */
    public void set変換エラーフィールド名称(RString 変換エラーフィールド名称) {
        requireNonNull(変換エラーフィールド名称, UrSystemErrorMessages.値がnull.getReplacedMessage("変換エラーフィールド名称"));
        entity.setErrorKomokuMeisho(変換エラーフィールド名称);
    }

    /**
     * 変換エラーフィールドＮｏを設定します。
     *
     * @param 変換エラーフィールドＮｏ 変換エラーフィールドＮｏ
     */
    public void set変換エラーフィールドＮｏ(RString 変換エラーフィールドＮｏ) {
        requireNonNull(変換エラーフィールドＮｏ, UrSystemErrorMessages.値がnull.getReplacedMessage("変換エラーフィールドＮｏ"));
        entity.setErrorKomokuNo(変換エラーフィールドＮｏ);
    }

    /**
     * 変換エラーコードを設定します。
     *
     * @param 変換エラーコード 変換エラーコード
     */
    public void set変換エラーコード(RString 変換エラーコード) {
        requireNonNull(変換エラーコード, UrSystemErrorMessages.値がnull.getReplacedMessage("変換エラーコード"));
        entity.setErrorCode(変換エラーコード);
    }

    /**
     * エラー表示連番を設定します。
     *
     * @param エラー表示連番 エラー表示連番
     */
    public void setエラー表示連番(RString エラー表示連番) {
        requireNonNull(エラー表示連番, UrSystemErrorMessages.値がnull.getReplacedMessage("エラー表示連番"));
        entity.setErrorHyojiRenban(エラー表示連番);
    }

    /**
     * エラー表示フィールド名称を設定します。
     *
     * @param エラー表示フィールド名称 エラー表示フィールド名称
     */
    public void setエラー表示フィールド名称(RString エラー表示フィールド名称) {
        requireNonNull(エラー表示フィールド名称, UrSystemErrorMessages.値がnull.getReplacedMessage("エラー表示フィールド名称"));
        entity.setErrorHyojiKomokuMeisho(エラー表示フィールド名称);
    }

    /**
     * エラー表示フィールドを設定します。
     *
     * @param エラー表示フィールド エラー表示フィールド
     */
    public void setエラー表示フィールド(RString エラー表示フィールド) {
        requireNonNull(エラー表示フィールド, UrSystemErrorMessages.値がnull.getReplacedMessage("エラー表示フィールド"));
        entity.setErrorHyojiKomoku(エラー表示フィールド);
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
