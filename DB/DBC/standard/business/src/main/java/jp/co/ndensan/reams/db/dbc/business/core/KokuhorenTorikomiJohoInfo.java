/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連取込情報を管理するクラスです。
 *
 * @reamsid_L DBC-0980-460 wangkanglei
 */
public class KokuhorenTorikomiJohoInfo {

    private DbV3104KokuhorenTorikomiJohoEntity entity;
    private RString 処理名;
    private RString バッチID;
    private RString 一覧表示順;
    private RString 交換識別番号;

    /**
     * デフォルトコンストラクタです。
     */
    public KokuhorenTorikomiJohoInfo() {
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
    public KokuhorenTorikomiJohoInfo(DbV3104KokuhorenTorikomiJohoEntity 国保連取込管理エンティティ) {
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

    /**
     *
     * 前々月処理状態を取得します。
     *
     * @return 前々月処理状態
     */
    public RString get前々月処理状態() {
        return this.entity.getZenzen_shorijotaikubun();
    }

    /**
     *
     * 前月処理状態を取得します。
     *
     * @return 前月処理状態
     */
    public RString get前月処理状態() {
        return this.entity.getZen_shorijotaikubun();
    }

    /**
     *
     * 当月処理状態を取得します。
     *
     * @return 前月処理状態
     */
    public RString get当月処理状態() {
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
     *
     * 再処理可否区分を取得します。
     *
     * @return 再処理可否区分
     */
    public boolean is再処理可否区分() {
        return this.entity.getSaiShoriKanoKubun();
    }

    /**
     * 処理名を取得します。
     *
     * @return 処理名
     */
    public RString get処理名() {
        return 処理名;
    }

    /**
     * 処理名を設定します。
     *
     * @param 処理名 RString
     */
    public void set処理名(RString 処理名) {
        this.処理名 = 処理名;
    }

    /**
     * バッチIDを取得します。
     *
     * @return バッチID
     */
    public RString getバッチID() {
        return バッチID;
    }

    /**
     * バッチIDを設定します。
     *
     * @param バッチID RString
     */
    public void setバッチID(RString バッチID) {
        this.バッチID = バッチID;
    }

    /**
     * 一覧表示順を取得します。
     *
     * @return 一覧表示順
     */
    public RString get一覧表示順() {
        return 一覧表示順;
    }

    /**
     * 一覧表示順を設定します。
     *
     * @param 一覧表示順 RString
     */
    public void set一覧表示順(RString 一覧表示順) {
        this.一覧表示順 = 一覧表示順;
    }

    /**
     * 交換識別番号を取得します。
     *
     * @return 交換識別番号
     */
    public RString get交換識別番号() {
        return 交換識別番号;
    }

    /**
     * 交換識別番号を設定します。
     *
     * @param 交換識別番号 RString
     */
    public void set交換識別番号(RString 交換識別番号) {
        this.交換識別番号 = 交換識別番号;
    }

}
