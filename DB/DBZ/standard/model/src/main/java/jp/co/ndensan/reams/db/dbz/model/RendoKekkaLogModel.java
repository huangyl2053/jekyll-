/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7036RendoKekkaLogEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 連動結果ログのモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class RendoKekkaLogModel implements Serializable {

    private DbT7036RendoKekkaLogEntity entity;

    /**
     * コンストラクタです。
     */
    public RendoKekkaLogModel() {
        entity = new DbT7036RendoKekkaLogEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7036RendoKekkaLogEntity
     */
    public RendoKekkaLogModel(DbT7036RendoKekkaLogEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7036RendoKekkaLogEntityを返します。
     *
     * @return DbT7036RendoKekkaLogEntity
     */
    public DbT7036RendoKekkaLogEntity getEntity() {
        return entity;
    }

    /**
     * DbT7036RendoKekkaLogEntityを設定します。
     *
     * @param entity DbT7036RendoKekkaLogEntity
     */
    public void setEntity(DbT7036RendoKekkaLogEntity entity) {
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
     * 種別を返します。
     *
     * @return 種別
     */
    public RString get種別() {
        return entity.getShubetsu();
    }

    /**
     * 処理ＩＤを返します。
     *
     * @return 処理ＩＤ
     */
    public RString get処理ＩＤ() {
        return entity.getShoriID();
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
     * 結果区分を返します。
     *
     * @return 結果区分
     */
    public RString get結果区分() {
        return entity.getKekkaKubun();
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
     * 処理開始時刻を返します。
     *
     * @return 処理開始時刻
     */
    public YMDHM get処理開始時刻() {
        return entity.getShoriKaishiTimestamp();
    }

    /**
     * 処理終了時刻を返します。
     *
     * @return 処理終了時刻
     */
    public YMDHM get処理終了時刻() {
        return entity.getShoriShuryoTimestamp();
    }

    /**
     * ログファイル名を返します。
     *
     * @return ログファイル名
     */
    public RString getログファイル名() {
        return entity.getLogFileMei();
    }

    /**
     * 表示用条件を返します。
     *
     * @return 表示用条件
     */
    public RString get表示用条件() {
        return entity.getHyojiJoken();
    }

    /**
     * メッセージを返します。
     *
     * @return メッセージ
     */
    public RString getメッセージ() {
        return entity.getMesseage();
    }

    /**
     * 連動形態を返します。
     *
     * @return 連動形態
     */
    public RString get連動形態() {
        return entity.getRendoKeitai();
    }

    /**
     * UL_受信結果区分を返します。
     *
     * @return UL_受信結果区分
     */
    public RString getUL_受信結果区分() {
        return entity.getUpLoad_JushinKekkaKubun();
    }

    /**
     * UL_文字コード変換結果区分を返します。
     *
     * @return UL_文字コード変換結果区分
     */
    public RString getUL_文字コード変換結果区分() {
        return entity.getUpLoad_MojiCodeHenkanKekkaKubun();
    }

    /**
     * UL_処理１結果区分を返します。
     *
     * @return UL_処理１結果区分
     */
    public RString getUL_処理１結果区分() {
        return entity.getUpLoad_Shori1KekkaKubun();
    }

    /**
     * UL_処理２結果区分を返します。
     *
     * @return UL_処理２結果区分
     */
    public RString getUL_処理２結果区分() {
        return entity.getUpLoad_Shori2kekkaKubun();
    }

    /**
     * UL_処理３結果区分を返します。
     *
     * @return UL_処理３結果区分
     */
    public RString getUL_処理３結果区分() {
        return entity.getUpLoad_Shori3KekkaKubun();
    }

    /**
     * DL_処理１結果区分を返します。
     *
     * @return DL_処理１結果区分
     */
    public RString getDL_処理１結果区分() {
        return entity.getDownLoad_Shori1KekkaKubun();
    }

    /**
     * DL_コード変換結果区分を返します。
     *
     * @return DL_コード変換結果区分
     */
    public RString getDL_コード変換結果区分() {
        return entity.getDownLoad_CodeHenkanKekkaKubun();
    }

    /**
     * DL_文字コード変換結果区分を返します。
     *
     * @return DL_文字コード変換結果区分
     */
    public RString getDL_文字コード変換結果区分() {
        return entity.getDownLoad_MojiCodeHenkanKekkaKubun();
    }

    /**
     * DL_送信１結果区分を返します。
     *
     * @return DL_送信１結果区分
     */
    public RString getDL_送信１結果区分() {
        return entity.getDownLoad_Soshin1KekkaKubun();
    }

    /**
     * DL_処理２結果区分を返します。
     *
     * @return DL_処理２結果区分
     */
    public RString getDL_処理２結果区分() {
        return entity.getDownLoad_shori2KekkaKubun();
    }

    /**
     * DL_受信１結果区分を返します。
     *
     * @return DL_受信１結果区分
     */
    public RString getDL_受信１結果区分() {
        return entity.getDownLoad_Jushon1KekkaKubun();
    }

    /**
     * 処理メッセージ１を返します。
     *
     * @return 処理メッセージ１
     */
    public RString get処理メッセージ１() {
        return entity.getShoriMessage1();
    }

    /**
     * 処理メッセージ２を返します。
     *
     * @return 処理メッセージ２
     */
    public RString get処理メッセージ２() {
        return entity.getShoriMessage2();
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
     * 種別を設定します。
     *
     * @param 種別 種別
     */
    public void set種別(RString 種別) {
        requireNonNull(種別, UrSystemErrorMessages.値がnull.getReplacedMessage("種別"));
        entity.setShubetsu(種別);
    }

    /**
     * 処理ＩＤを設定します。
     *
     * @param 処理ＩＤ 処理ＩＤ
     */
    public void set処理ＩＤ(RString 処理ＩＤ) {
        requireNonNull(処理ＩＤ, UrSystemErrorMessages.値がnull.getReplacedMessage("処理ＩＤ"));
        entity.setShoriID(処理ＩＤ);
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
     * 結果区分を設定します。
     *
     * @param 結果区分 結果区分
     */
    public void set結果区分(RString 結果区分) {
        requireNonNull(結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("結果区分"));
        entity.setKekkaKubun(結果区分);
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
     * 処理開始時刻を設定します。
     *
     * @param 処理開始時刻 処理開始時刻
     */
    public void set処理開始時刻(YMDHM 処理開始時刻) {
        requireNonNull(処理開始時刻, UrSystemErrorMessages.値がnull.getReplacedMessage("処理開始時刻"));
        entity.setShoriKaishiTimestamp(処理開始時刻);
    }

    /**
     * 処理終了時刻を設定します。
     *
     * @param 処理終了時刻 処理終了時刻
     */
    public void set処理終了時刻(YMDHM 処理終了時刻) {
        requireNonNull(処理終了時刻, UrSystemErrorMessages.値がnull.getReplacedMessage("処理終了時刻"));
        entity.setShoriShuryoTimestamp(処理終了時刻);
    }

    /**
     * ログファイル名を設定します。
     *
     * @param ログファイル名 ログファイル名
     */
    public void setログファイル名(RString ログファイル名) {
        requireNonNull(ログファイル名, UrSystemErrorMessages.値がnull.getReplacedMessage("ログファイル名"));
        entity.setLogFileMei(ログファイル名);
    }

    /**
     * 表示用条件を設定します。
     *
     * @param 表示用条件 表示用条件
     */
    public void set表示用条件(RString 表示用条件) {
        requireNonNull(表示用条件, UrSystemErrorMessages.値がnull.getReplacedMessage("表示用条件"));
        entity.setHyojiJoken(表示用条件);
    }

    /**
     * メッセージを設定します。
     *
     * @param メッセージ メッセージ
     */
    public void setメッセージ(RString メッセージ) {
        requireNonNull(メッセージ, UrSystemErrorMessages.値がnull.getReplacedMessage("メッセージ"));
        entity.setMesseage(メッセージ);
    }

    /**
     * 連動形態を設定します。
     *
     * @param 連動形態 連動形態
     */
    public void set連動形態(RString 連動形態) {
        requireNonNull(連動形態, UrSystemErrorMessages.値がnull.getReplacedMessage("連動形態"));
        entity.setRendoKeitai(連動形態);
    }

    /**
     * UL_受信結果区分を設定します。
     *
     * @param UL_受信結果区分 UL_受信結果区分
     */
    public void setUL_受信結果区分(RString UL_受信結果区分) {
        requireNonNull(UL_受信結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("UL_受信結果区分"));
        entity.setUpLoad_JushinKekkaKubun(UL_受信結果区分);
    }

    /**
     * UL_文字コード変換結果区分を設定します。
     *
     * @param UL_文字コード変換結果区分 UL_文字コード変換結果区分
     */
    public void setUL_文字コード変換結果区分(RString UL_文字コード変換結果区分) {
        requireNonNull(UL_文字コード変換結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("UL_文字コード変換結果区分"));
        entity.setUpLoad_MojiCodeHenkanKekkaKubun(UL_文字コード変換結果区分);
    }

    /**
     * UL_処理１結果区分を設定します。
     *
     * @param UL_処理１結果区分 UL_処理１結果区分
     */
    public void setUL_処理１結果区分(RString UL_処理１結果区分) {
        requireNonNull(UL_処理１結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("UL_処理１結果区分"));
        entity.setUpLoad_Shori1KekkaKubun(UL_処理１結果区分);
    }

    /**
     * UL_処理２結果区分を設定します。
     *
     * @param UL_処理２結果区分 UL_処理２結果区分
     */
    public void setUL_処理２結果区分(RString UL_処理２結果区分) {
        requireNonNull(UL_処理２結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("UL_処理２結果区分"));
        entity.setUpLoad_Shori2kekkaKubun(UL_処理２結果区分);
    }

    /**
     * UL_処理３結果区分を設定します。
     *
     * @param UL_処理３結果区分 UL_処理３結果区分
     */
    public void setUL_処理３結果区分(RString UL_処理３結果区分) {
        requireNonNull(UL_処理３結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("UL_処理３結果区分"));
        entity.setUpLoad_Shori3KekkaKubun(UL_処理３結果区分);
    }

    /**
     * DL_処理１結果区分を設定します。
     *
     * @param DL_処理１結果区分 DL_処理１結果区分
     */
    public void setDL_処理１結果区分(RString DL_処理１結果区分) {
        requireNonNull(DL_処理１結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("DL_処理１結果区分"));
        entity.setDownLoad_Shori1KekkaKubun(DL_処理１結果区分);
    }

    /**
     * DL_コード変換結果区分を設定します。
     *
     * @param DL_コード変換結果区分 DL_コード変換結果区分
     */
    public void setDL_コード変換結果区分(RString DL_コード変換結果区分) {
        requireNonNull(DL_コード変換結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("DL_コード変換結果区分"));
        entity.setDownLoad_CodeHenkanKekkaKubun(DL_コード変換結果区分);
    }

    /**
     * DL_文字コード変換結果区分を設定します。
     *
     * @param DL_文字コード変換結果区分 DL_文字コード変換結果区分
     */
    public void setDL_文字コード変換結果区分(RString DL_文字コード変換結果区分) {
        requireNonNull(DL_文字コード変換結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("DL_文字コード変換結果区分"));
        entity.setDownLoad_MojiCodeHenkanKekkaKubun(DL_文字コード変換結果区分);
    }

    /**
     * DL_送信１結果区分を設定します。
     *
     * @param DL_送信１結果区分 DL_送信１結果区分
     */
    public void setDL_送信１結果区分(RString DL_送信１結果区分) {
        requireNonNull(DL_送信１結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("DL_送信１結果区分"));
        entity.setDownLoad_Soshin1KekkaKubun(DL_送信１結果区分);
    }

    /**
     * DL_処理２結果区分を設定します。
     *
     * @param DL_処理２結果区分 DL_処理２結果区分
     */
    public void setDL_処理２結果区分(RString DL_処理２結果区分) {
        requireNonNull(DL_処理２結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("DL_処理２結果区分"));
        entity.setDownLoad_shori2KekkaKubun(DL_処理２結果区分);
    }

    /**
     * DL_受信１結果区分を設定します。
     *
     * @param DL_受信１結果区分 DL_受信１結果区分
     */
    public void setDL_受信１結果区分(RString DL_受信１結果区分) {
        requireNonNull(DL_受信１結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("DL_受信１結果区分"));
        entity.setDownLoad_Jushon1KekkaKubun(DL_受信１結果区分);
    }

    /**
     * 処理メッセージ１を設定します。
     *
     * @param 処理メッセージ１ 処理メッセージ１
     */
    public void set処理メッセージ１(RString 処理メッセージ１) {
        requireNonNull(処理メッセージ１, UrSystemErrorMessages.値がnull.getReplacedMessage("処理メッセージ１"));
        entity.setShoriMessage1(処理メッセージ１);
    }

    /**
     * 処理メッセージ２を設定します。
     *
     * @param 処理メッセージ２ 処理メッセージ２
     */
    public void set処理メッセージ２(RString 処理メッセージ２) {
        requireNonNull(処理メッセージ２, UrSystemErrorMessages.値がnull.getReplacedMessage("処理メッセージ２"));
        entity.setShoriMessage2(処理メッセージ２);
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
