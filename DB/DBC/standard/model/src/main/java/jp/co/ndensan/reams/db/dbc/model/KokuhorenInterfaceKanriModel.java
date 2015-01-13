/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 国保連インターフェース管理のモデルクラスです。
 *
 * @author n2810 久保里史
 */
public class KokuhorenInterfaceKanriModel implements Serializable {

    private DbT3104KokuhorenInterfaceKanriEntity entity;

    /**
     * コンストラクタです。
     */
    public KokuhorenInterfaceKanriModel() {
        entity = new DbT3104KokuhorenInterfaceKanriEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3104KokuhorenInterfaceKanriEntity
     */
    public KokuhorenInterfaceKanriModel(DbT3104KokuhorenInterfaceKanriEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3104KokuhorenInterfaceKanriEntityを返します。
     *
     * @return DbT3104KokuhorenInterfaceKanriEntity
     */
    public DbT3104KokuhorenInterfaceKanriEntity getEntity() {
        return entity;
    }

    /**
     * DbT3104KokuhorenInterfaceKanriEntityを設定します。
     *
     * @param entity DbT3104KokuhorenInterfaceKanriEntity
     */
    public void setEntity(DbT3104KokuhorenInterfaceKanriEntity entity) {
        this.entity = entity;
    }

    /**
     * 処理年月を返します。
     *
     * @return 処理年月
     */
    public RYearMonth get処理年月() {
        return entity.getShoriYM();
    }

    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public RString get交換情報識別番号() {
        return entity.getKokanShikibetsuNo();
    }

    /**
     * 送付取込区分を返します。
     *
     * @return 送付取込区分
     */
    public RString get送付取込区分() {
        return entity.getSofuTorikomiKubun();
    }

    /**
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    public RString get処理状態区分() {
        return entity.getShoriJotaiKubun();
    }

    /**
     * 処理実施日時を返します。
     *
     * @return 処理実施日時
     */
    public YMDHMS get処理実施日時() {
        return entity.getShoriJisshiTimestamp();
    }

    /**
     * 抽出開始日時を返します。
     *
     * @return 抽出開始日時
     */
    public YMDHMS get抽出開始日時() {
        return entity.getChushutsuKaishiTimestamp();
    }

    /**
     * 抽出終了日時を返します。
     *
     * @return 抽出終了日時
     */
    public YMDHMS get抽出終了日時() {
        return entity.getChushutsuShuryoTimestamp();
    }

    /**
     * 再処理可能区分を返します。
     *
     * @return 再処理可能区分
     */
    public boolean get再処理可能区分() {
        return entity.getSaiShoriKahiKubun();
    }

    /**
     * 処理実行回数を返します。
     *
     * @return 処理実行回数
     */
    public Decimal get処理実行回数() {
        return entity.getShoriJikkoKaisu();
    }

    /**
     * ファイル名称１を返します。
     *
     * @return ファイル名称１
     */
    public RString getファイル名称１() {
        return entity.getFileName1();
    }

    /**
     * ファイル名称２を返します。
     *
     * @return ファイル名称２
     */
    public RString getファイル名称２() {
        return entity.getFileName2();
    }

    /**
     * ファイル名称３を返します。
     *
     * @return ファイル名称３
     */
    public RString getファイル名称３() {
        return entity.getFileName3();
    }

    /**
     * ファイル名称４を返します。
     *
     * @return ファイル名称４
     */
    public RString getファイル名称４() {
        return entity.getFileName4();
    }

    /**
     * ファイル名称５を返します。
     *
     * @return ファイル名称５
     */
    public RString getファイル名称５() {
        return entity.getFileName5();
    }

    /**
     * ファイル件数１を返します。
     *
     * @return ファイル件数１
     */
    public Integer getファイル件数１() {
        return entity.getFileKensu1();
    }

    /**
     * ファイル件数２を返します。
     *
     * @return ファイル件数２
     */
    public Integer getファイル件数２() {
        return entity.getFileKensu2();
    }

    /**
     * ファイル件数３を返します。
     *
     * @return ファイル件数３
     */
    public Integer getファイル件数３() {
        return entity.getFileKensu3();
    }

    /**
     * ファイル件数４を返します。
     *
     * @return ファイル件数４
     */
    public Integer getファイル件数４() {
        return entity.getFileKensu4();
    }

    /**
     * ファイル件数５を返します。
     *
     * @return ファイル件数５
     */
    public Integer getファイル件数５() {
        return entity.getFileKensu5();
    }

    /**
     * 再処理設定不可区分を返します。
     *
     * @return 再処理設定不可区分
     */
    public Boolean get再処理設定不可区分() {
        return entity.getSaiShoriFukaKubun();
    }

    /**
     * コントロール上レコード件数を返します。
     *
     * @return コントロール上レコード件数
     */
    public Integer getコントロール上レコード件数() {
        return entity.getCtrlRecordKensu();
    }

    /**
     * コントロール上処理年月を返します。
     *
     * @return コントロール上処理年月
     */
    public RYearMonth getコントロール上処理年月() {
        return entity.getCtrlShoriYM();
    }

    /**
     * 過誤コントロール上レコード件数を返します。
     *
     * @return 過誤コントロール上レコード件数
     */
    public Integer get過誤コントロール上レコード件数() {
        return entity.getKagoCtrlRecordKensu();
    }

    /**
     * 過誤コントロール上処理年月を返します。
     *
     * @return 過誤コントロール上処理年月
     */
    public RYearMonth get過誤コントロール上処理年月() {
        return entity.getKagoCtrlShoriYM();
    }

    /**
     * 実績データ上審査年月を返します。
     *
     * @return 実績データ上審査年月
     */
    public RYearMonth get実績データ上審査年月() {
        return entity.getJissekiDataShinsaYM();
    }

    /**
     * 処理年月を設定します。
     *
     * @param 処理年月 処理年月
     */
    public void set処理年月(RYearMonth 処理年月) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        entity.setShoriYM(処理年月);
    }

    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     */
    public void set交換情報識別番号(RString 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanShikibetsuNo(交換情報識別番号);
    }

    /**
     * 送付取込区分を設定します。
     *
     * @param 送付取込区分 送付取込区分
     */
    public void set送付取込区分(RString 送付取込区分) {
        requireNonNull(送付取込区分, UrSystemErrorMessages.値がnull.getReplacedMessage("送付取込区分"));
        entity.setSofuTorikomiKubun(送付取込区分);
    }

    /**
     * 処理状態区分を設定します。
     *
     * @param 処理状態区分 処理状態区分
     */
    public void set処理状態区分(RString 処理状態区分) {
        requireNonNull(処理状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("処理状態区分"));
        entity.setShoriJotaiKubun(処理状態区分);
    }

    /**
     * 処理実施日時を設定します。
     *
     * @param 処理実施日時 処理実施日時
     */
    public void set処理実施日時(YMDHMS 処理実施日時) {
        requireNonNull(処理実施日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理実施日時"));
        entity.setShoriJisshiTimestamp(処理実施日時);
    }

    /**
     * 抽出開始日時を設定します。
     *
     * @param 抽出開始日時 抽出開始日時
     */
    public void set抽出開始日時(YMDHMS 抽出開始日時) {
        requireNonNull(抽出開始日時, UrSystemErrorMessages.値がnull.getReplacedMessage("抽出開始日時"));
        entity.setChushutsuKaishiTimestamp(抽出開始日時);
    }

    /**
     * 抽出終了日時を設定します。
     *
     * @param 抽出終了日時 抽出終了日時
     */
    public void set抽出終了日時(YMDHMS 抽出終了日時) {
        requireNonNull(抽出終了日時, UrSystemErrorMessages.値がnull.getReplacedMessage("抽出終了日時"));
        entity.setChushutsuShuryoTimestamp(抽出終了日時);
    }

    /**
     * 再処理可能区分を設定します。
     *
     * @param 再処理可能区分 再処理可能区分
     */
    public void set再処理可能区分(boolean 再処理可能区分) {
        requireNonNull(再処理可能区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再処理可能区分"));
        entity.setSaiShoriKahiKubun(再処理可能区分);
    }

    /**
     * 処理実行回数を設定します。
     *
     * @param 処理実行回数 処理実行回数
     */
    public void set処理実行回数(Decimal 処理実行回数) {
        requireNonNull(処理実行回数, UrSystemErrorMessages.値がnull.getReplacedMessage("処理実行回数"));
        entity.setShoriJikkoKaisu(処理実行回数);
    }

    /**
     * ファイル名称１を設定します。
     *
     * @param ファイル名称１ ファイル名称１
     */
    public void setファイル名称１(RString ファイル名称１) {
        requireNonNull(ファイル名称１, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル名称１"));
        entity.setFileName1(ファイル名称１);
    }

    /**
     * ファイル名称２を設定します。
     *
     * @param ファイル名称２ ファイル名称２
     */
    public void setファイル名称２(RString ファイル名称２) {
        requireNonNull(ファイル名称２, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル名称２"));
        entity.setFileName2(ファイル名称２);
    }

    /**
     * ファイル名称３を設定します。
     *
     * @param ファイル名称３ ファイル名称３
     */
    public void setファイル名称３(RString ファイル名称３) {
        requireNonNull(ファイル名称３, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル名称３"));
        entity.setFileName3(ファイル名称３);
    }

    /**
     * ファイル名称４を設定します。
     *
     * @param ファイル名称４ ファイル名称４
     */
    public void setファイル名称４(RString ファイル名称４) {
        requireNonNull(ファイル名称４, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル名称４"));
        entity.setFileName4(ファイル名称４);
    }

    /**
     * ファイル名称５を設定します。
     *
     * @param ファイル名称５ ファイル名称５
     */
    public void setファイル名称５(RString ファイル名称５) {
        requireNonNull(ファイル名称５, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル名称５"));
        entity.setFileName5(ファイル名称５);
    }

    /**
     * ファイル件数１を設定します。
     *
     * @param ファイル件数１ ファイル件数１
     */
    public void setファイル件数１(Integer ファイル件数１) {
        requireNonNull(ファイル件数１, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル件数１"));
        entity.setFileKensu1(ファイル件数１);
    }

    /**
     * ファイル件数２を設定します。
     *
     * @param ファイル件数２ ファイル件数２
     */
    public void setファイル件数２(Integer ファイル件数２) {
        requireNonNull(ファイル件数２, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル件数２"));
        entity.setFileKensu2(ファイル件数２);
    }

    /**
     * ファイル件数３を設定します。
     *
     * @param ファイル件数３ ファイル件数３
     */
    public void setファイル件数３(Integer ファイル件数３) {
        requireNonNull(ファイル件数３, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル件数３"));
        entity.setFileKensu3(ファイル件数３);
    }

    /**
     * ファイル件数４を設定します。
     *
     * @param ファイル件数４ ファイル件数４
     */
    public void setファイル件数４(Integer ファイル件数４) {
        requireNonNull(ファイル件数４, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル件数４"));
        entity.setFileKensu4(ファイル件数４);
    }

    /**
     * ファイル件数５を設定します。
     *
     * @param ファイル件数５ ファイル件数５
     */
    public void setファイル件数５(Integer ファイル件数５) {
        requireNonNull(ファイル件数５, UrSystemErrorMessages.値がnull.getReplacedMessage("ファイル件数５"));
        entity.setFileKensu5(ファイル件数５);
    }

    /**
     * 再処理設定不可区分を設定します。
     *
     * @param 再処理設定不可区分 再処理設定不可区分
     */
    public void set再処理設定不可区分(Boolean 再処理設定不可区分) {
        requireNonNull(再処理設定不可区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再処理設定不可区分"));
        entity.setSaiShoriFukaKubun(再処理設定不可区分);
    }

    /**
     * コントロール上レコード件数を設定します。
     *
     * @param コントロール上レコード件数 コントロール上レコード件数
     */
    public void setコントロール上レコード件数(Integer コントロール上レコード件数) {
        requireNonNull(コントロール上レコード件数, UrSystemErrorMessages.値がnull.getReplacedMessage("コントロール上レコード件数"));
        entity.setCtrlRecordKensu(コントロール上レコード件数);
    }

    /**
     * コントロール上処理年月を設定します。
     *
     * @param コントロール上処理年月 コントロール上処理年月
     */
    public void setコントロール上処理年月(RYearMonth コントロール上処理年月) {
        requireNonNull(コントロール上処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("コントロール上処理年月"));
        entity.setCtrlShoriYM(コントロール上処理年月);
    }

    /**
     * 過誤コントロール上レコード件数を設定します。
     *
     * @param 過誤コントロール上レコード件数 過誤コントロール上レコード件数
     */
    public void set過誤コントロール上レコード件数(Integer 過誤コントロール上レコード件数) {
        requireNonNull(過誤コントロール上レコード件数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤コントロール上レコード件数"));
        entity.setKagoCtrlRecordKensu(過誤コントロール上レコード件数);
    }

    /**
     * 過誤コントロール上処理年月を設定します。
     *
     * @param 過誤コントロール上処理年月 過誤コントロール上処理年月
     */
    public void set過誤コントロール上処理年月(RYearMonth 過誤コントロール上処理年月) {
        requireNonNull(過誤コントロール上処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤コントロール上処理年月"));
        entity.setKagoCtrlShoriYM(過誤コントロール上処理年月);
    }

    /**
     * 実績データ上審査年月を設定します。
     *
     * @param 実績データ上審査年月 実績データ上審査年月
     */
    public void set実績データ上審査年月(RYearMonth 実績データ上審査年月) {
        requireNonNull(実績データ上審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("実績データ上審査年月"));
        entity.setJissekiDataShinsaYM(実績データ上審査年月);
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
