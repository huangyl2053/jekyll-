/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7024KoikiShichosonCodeHenkanPatternEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 広域市町村管理コード変換パターンのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KoikiShichosonCodeHenkanPatternModel implements Serializable {

    private DbT7024KoikiShichosonCodeHenkanPatternEntity entity;

    /**
     * コンストラクタです。
     */
    public KoikiShichosonCodeHenkanPatternModel() {
        entity = new DbT7024KoikiShichosonCodeHenkanPatternEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7024KoikiShichosonCodeHenkanPatternEntity
     */
    public KoikiShichosonCodeHenkanPatternModel(DbT7024KoikiShichosonCodeHenkanPatternEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7024KoikiShichosonCodeHenkanPatternEntityを返します。
     *
     * @return DbT7024KoikiShichosonCodeHenkanPatternEntity
     */
    public DbT7024KoikiShichosonCodeHenkanPatternEntity getEntity() {
        return entity;
    }

    /**
     * DbT7024KoikiShichosonCodeHenkanPatternEntityを設定します。
     *
     * @param entity DbT7024KoikiShichosonCodeHenkanPatternEntity
     */
    public void setEntity(DbT7024KoikiShichosonCodeHenkanPatternEntity entity) {
        this.entity = entity;
    }

    /**
     * 広域内市町村番号を返します。
     *
     * @return 広域内市町村番号
     */
    public RString get広域内市町村番号() {
        return entity.getKoikiShichosonNo();
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
     * コード区分を返します。
     *
     * @return コード区分
     */
    public RString getコード区分() {
        return entity.getCodeKubun();
    }

    /**
     * コード変換テーブル使用区分を返します。
     *
     * @return コード変換テーブル使用区分
     */
    public RString getコード変換テーブル使用区分() {
        return entity.getCodeHenkanTableShiyoUmu();
    }

    /**
     * 自動採番区分を返します。
     *
     * @return 自動採番区分
     */
    public RString get自動採番区分() {
        return entity.getJidoSaibanKubun();
    }

    /**
     * 市町村用コード桁数を返します。
     *
     * @return 市町村用コード桁数
     */
    public int get市町村用コード桁数() {
        return entity.getShichosonCodeKetasu();
    }

    /**
     * 市町村用コード開始位置を返します。
     *
     * @return 市町村用コード開始位置
     */
    public int get市町村用コード開始位置() {
        return entity.getShichosonCodeKaishiIchi();
    }

    /**
     * 市町村用コード使用桁数を返します。
     *
     * @return 市町村用コード使用桁数
     */
    public int get市町村用コード使用桁数() {
        return entity.getShichosonCodeShiyoKetasu();
    }

    /**
     * 市町村用チェックディジット有無区分を返します。
     *
     * @return 市町村用チェックディジット有無区分
     */
    public RString get市町村用チェックディジット有無区分() {
        return entity.getShichosonNinshoNoUmu();
    }

    /**
     * 広域用コード桁数を返します。
     *
     * @return 広域用コード桁数
     */
    public int get広域用コード桁数() {
        return entity.getKoikiCodeKetasu();
    }

    /**
     * 広域用コード開始位置を返します。
     *
     * @return 広域用コード開始位置
     */
    public int get広域用コード開始位置() {
        return entity.getKoikiCodeKaishiIchi();
    }

    /**
     * 広域用コード使用桁数を返します。
     *
     * @return 広域用コード使用桁数
     */
    public int get広域用コード使用桁数() {
        return entity.getKoikiCodeShiyoKetasu();
    }

    /**
     * 広域用チェックディジット有無区分を返します。
     *
     * @return 広域用チェックディジット有無区分
     */
    public RString get広域用チェックディジット有無区分() {
        return entity.getKoikiNinshoNoUmu();
    }

    /**
     * 広域内市町村番号付加区分を返します。
     *
     * @return 広域内市町村番号付加区分
     */
    public RString get広域内市町村番号付加区分() {
        return entity.getShichosonNoFukaKubun();
    }

    /**
     * 広域内市町村番号を設定します。
     *
     * @param 広域内市町村番号 広域内市町村番号
     */
    public void set広域内市町村番号(RString 広域内市町村番号) {
        requireNonNull(広域内市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内市町村番号"));
        entity.setKoikiShichosonNo(広域内市町村番号);
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
     * コード区分を設定します。
     *
     * @param コード区分 コード区分
     */
    public void setコード区分(RString コード区分) {
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));
        entity.setCodeKubun(コード区分);
    }

    /**
     * コード変換テーブル使用区分を設定します。
     *
     * @param コード変換テーブル使用区分 コード変換テーブル使用区分
     */
    public void setコード変換テーブル使用区分(RString コード変換テーブル使用区分) {
        requireNonNull(コード変換テーブル使用区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード変換テーブル使用区分"));
        entity.setCodeHenkanTableShiyoUmu(コード変換テーブル使用区分);
    }

    /**
     * 自動採番区分を設定します。
     *
     * @param 自動採番区分 自動採番区分
     */
    public void set自動採番区分(RString 自動採番区分) {
        requireNonNull(自動採番区分, UrSystemErrorMessages.値がnull.getReplacedMessage("自動採番区分"));
        entity.setJidoSaibanKubun(自動採番区分);
    }

    /**
     * 市町村用コード桁数を設定します。
     *
     * @param 市町村用コード桁数 市町村用コード桁数
     */
    public void set市町村用コード桁数(int 市町村用コード桁数) {
        requireNonNull(市町村用コード桁数, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村用コード桁数"));
        entity.setShichosonCodeKetasu(市町村用コード桁数);
    }

    /**
     * 市町村用コード開始位置を設定します。
     *
     * @param 市町村用コード開始位置 市町村用コード開始位置
     */
    public void set市町村用コード開始位置(int 市町村用コード開始位置) {
        requireNonNull(市町村用コード開始位置, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村用コード開始位置"));
        entity.setShichosonCodeKaishiIchi(市町村用コード開始位置);
    }

    /**
     * 市町村用コード使用桁数を設定します。
     *
     * @param 市町村用コード使用桁数 市町村用コード使用桁数
     */
    public void set市町村用コード使用桁数(int 市町村用コード使用桁数) {
        requireNonNull(市町村用コード使用桁数, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村用コード使用桁数"));
        entity.setShichosonCodeShiyoKetasu(市町村用コード使用桁数);
    }

    /**
     * 市町村用チェックディジット有無区分を設定します。
     *
     * @param 市町村用チェックディジット有無区分 市町村用チェックディジット有無区分
     */
    public void set市町村用チェックディジット有無区分(RString 市町村用チェックディジット有無区分) {
        requireNonNull(市町村用チェックディジット有無区分, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村用チェックディジット有無区分"));
        entity.setShichosonNinshoNoUmu(市町村用チェックディジット有無区分);
    }

    /**
     * 広域用コード桁数を設定します。
     *
     * @param 広域用コード桁数 広域用コード桁数
     */
    public void set広域用コード桁数(int 広域用コード桁数) {
        requireNonNull(広域用コード桁数, UrSystemErrorMessages.値がnull.getReplacedMessage("広域用コード桁数"));
        entity.setKoikiCodeKetasu(広域用コード桁数);
    }

    /**
     * 広域用コード開始位置を設定します。
     *
     * @param 広域用コード開始位置 広域用コード開始位置
     */
    public void set広域用コード開始位置(int 広域用コード開始位置) {
        requireNonNull(広域用コード開始位置, UrSystemErrorMessages.値がnull.getReplacedMessage("広域用コード開始位置"));
        entity.setKoikiCodeKaishiIchi(広域用コード開始位置);
    }

    /**
     * 広域用コード使用桁数を設定します。
     *
     * @param 広域用コード使用桁数 広域用コード使用桁数
     */
    public void set広域用コード使用桁数(int 広域用コード使用桁数) {
        requireNonNull(広域用コード使用桁数, UrSystemErrorMessages.値がnull.getReplacedMessage("広域用コード使用桁数"));
        entity.setKoikiCodeShiyoKetasu(広域用コード使用桁数);
    }

    /**
     * 広域用チェックディジット有無区分を設定します。
     *
     * @param 広域用チェックディジット有無区分 広域用チェックディジット有無区分
     */
    public void set広域用チェックディジット有無区分(RString 広域用チェックディジット有無区分) {
        requireNonNull(広域用チェックディジット有無区分, UrSystemErrorMessages.値がnull.getReplacedMessage("広域用チェックディジット有無区分"));
        entity.setKoikiNinshoNoUmu(広域用チェックディジット有無区分);
    }

    /**
     * 広域内市町村番号付加区分を設定します。
     *
     * @param 広域内市町村番号付加区分 広域内市町村番号付加区分
     */
    public void set広域内市町村番号付加区分(RString 広域内市町村番号付加区分) {
        requireNonNull(広域内市町村番号付加区分, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内市町村番号付加区分"));
        entity.setShichosonNoFukaKubun(広域内市町村番号付加区分);
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
