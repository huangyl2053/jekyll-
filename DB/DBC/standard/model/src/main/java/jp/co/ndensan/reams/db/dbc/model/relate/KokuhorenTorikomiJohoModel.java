/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.model.relate;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 国保連取込情報モデルクラスです。
 *
 * @author n2810 久保　里史
 */
public class KokuhorenTorikomiJohoModel implements Serializable {

    private DbV3104KokuhorenTorikomiJohoEntity entity;
    private RString 処理名;
    private RString バッチID;
    private RString 一覧表示順;
    private RString 交換識別番号;

    /**
     * デフォルトコンストラクタです。
     */
    public KokuhorenTorikomiJohoModel() {
        this.entity = new DbV3104KokuhorenTorikomiJohoEntity();
        処理名 = RString.EMPTY;
        バッチID = RString.EMPTY;
        一覧表示順 = RString.EMPTY;
        交換識別番号 = RString.EMPTY;
    }

    /**
     * コンストラクタです。
     *
     * @param 国保連取込管理エンティティ KokuhorenInterfaceKanriEntity
     */
    public KokuhorenTorikomiJohoModel(DbV3104KokuhorenTorikomiJohoEntity 国保連取込管理エンティティ) {
        this.entity = 国保連取込管理エンティティ;
        処理名 = RString.EMPTY;
        バッチID = RString.EMPTY;
        一覧表示順 = RString.EMPTY;
        交換識別番号 = RString.EMPTY;
    }

    /**
     * 国保連インターフェース管理モデルを返します。
     *
     * @return 国保連取込管理エンティティ
     */
    public DbV3104KokuhorenTorikomiJohoEntity get国保連取込管理エンティティ() {
        return entity;
    }

    /**
     * 国保連インターフェース管理モデルを設定します。
     *
     * @param 国保連取込管理エンティティ 国保連インターフェース管理モデル
     */
    public void set国保連取込管理エンティティ(DbV3104KokuhorenTorikomiJohoEntity 国保連取込管理エンティティ) {
        this.entity = 国保連取込管理エンティティ;
    }

//    /**
//     *
//     * 名前を取得します。
//     *
//     * @return 名前
//     */
//    public RString get名前() {
//        return this.処理名;
//    }
    /**
     *
     * 前々月処理状態を取得します。
     *
     * @return 前々月処理状態
     */
    public RString get前々月処理状態() {
        if (this.entity == null
                || this.entity.getZenzen_shorijotaikubun() == null
                || this.entity.getZenzen_shorijotaikubun().isEmpty()) {
            return new RString("9");
        }

        return this.entity.getZenzen_shorijotaikubun();

    }

    /**
     *
     * 前月処理状態を取得します。
     *
     * @return 前月処理状態
     */
    public RString get前月処理状態() {
        if (this.entity == null
                || this.entity.getZen_shorijotaikubun() == null
                || this.entity.getZen_shorijotaikubun().isEmpty()) {
            return new RString("9");
        }

        return this.entity.getZen_shorijotaikubun();

    }

    /**
     *
     * 当月処理状態を取得します。
     *
     * @return 前月処理状態
     */
    public RString get当月処理状態() {
        if (this.entity == null
                || this.entity.getShoriJotaiKubun() == null
                || this.entity.getShoriJotaiKubun().isEmpty()) {
            return new RString("9");
        }

        return this.entity.getShoriJotaiKubun();

    }

    /**
     *
     * 当月処理日時を取得します。
     *
     * @return 当月処理日時
     */
    public YMDHMS get当月処理日時() {
        return this.entity.getTougetsushoridate();
    }

    /**
     * @return the 処理名
     */
    public RString get処理名() {
        return 処理名;
    }

    /**
     * @param 処理名 the 処理名 to set
     */
    public void set処理名(RString 処理名) {
        this.処理名 = 処理名;
    }

    /**
     * @return the バッチID
     */
    public RString getバッチID() {
        return バッチID;
    }

    /**
     * @param バッチID the バッチID to set
     */
    public void setバッチID(RString バッチID) {
        this.バッチID = バッチID;
    }

    /**
     * @return the 一覧表示順
     */
    public RString get一覧表示順() {
        return 一覧表示順;
    }

    /**
     * @param 一覧表示順 the 一覧表示順 to set
     */
    public void set一覧表示順(RString 一覧表示順) {
        this.一覧表示順 = 一覧表示順;
    }

    /**
     * @return the 交換識別番号
     */
    public RString get交換識別番号() {
        return 交換識別番号;
    }

    /**
     * @param 交換識別番号 the 交換識別番号 to set
     */
    public void set交換識別番号(RString 交換識別番号) {
        this.交換識別番号 = 交換識別番号;
    }

    /**
     * 国保連インターフェース管理としての状態を返します。<br />
     *
     * 親テーブルの状態がDB登録対象(Added、Modified、Deleted)の場合、その値を返します。<br />
     * 親テーブルの状態が変更無し(Unchanged)の場合、子テーブルのいずれかの状態がDB登録対象の場合、Modifiedを返します。<br />
     * 子テーブルのいずれも変更無しの場合、Unchangedを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }

}
