/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core;

import jp.co.ndensan.reams.db.dbc.business.core.hihokenshajohosoufudatasakuseyi.KokuhorenSofuJohoResult;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者情報送付データ作成
 *
 * @reamsid_L DBC-3300-010 wangxingpeng
 */
public class KokuhorenSofuJohoInfo {

    private KokuhorenSofuJohoResult result;
    private RString 処理名;
    private RString 一覧表示順;
    private RString 交換識別番号;

    /**
     * デフォルトコンストラクタです。
     */
    public KokuhorenSofuJohoInfo() {
        this.result = new KokuhorenSofuJohoResult();
        処理名 = RString.EMPTY;
        一覧表示順 = RString.EMPTY;
        交換識別番号 = RString.EMPTY;
    }

    /**
     * コンストラクタです。
     *
     * @param 国保連送付情報 KokuhorenSofuJohoResult
     */
    public KokuhorenSofuJohoInfo(KokuhorenSofuJohoResult 国保連送付情報) {
        this.result = 国保連送付情報;
        処理名 = RString.EMPTY;
        一覧表示順 = RString.EMPTY;
        交換識別番号 = RString.EMPTY;
    }

    /**
     * 国保連送付情報モデルを返します。
     *
     * @return 国保連送付情報
     */
    public KokuhorenSofuJohoResult get国保連送付情報() {
        return result;
    }

    /**
     * 国保連送付情報モデルを設定します。
     *
     * @param 国保連送付情報 国保連送付情報
     */
    public void set国保連送付情報(KokuhorenSofuJohoResult 国保連送付情報) {
        this.result = 国保連送付情報;
    }

    /**
     * 処理年月を取得します。
     *
     * @return 処理年月
     */
    public FlexibleYearMonth get処理年月() {
        return this.result.get処理年月();
    }

    /**
     * 前々月処理状態を取得します。
     *
     * @return 前々月処理状態
     */
    public RString get前々月処理状態() {
        return this.result.get前々月処理状態区分();
    }

    /**
     * 前月処理状態を取得します。
     *
     * @return 前月処理状態
     */
    public RString get前月処理状態() {
        return this.result.get前月処理状態区分();
    }

    /**
     * 当月処理実施日時を取得します。
     *
     * @return 当月処理実施日時
     */
    public YMDHMS get当月処理実施日時() {
        return this.result.get当月処理実施日時();
    }

    /**
     * 処理状態区分を取得します。
     *
     * @return 処理状態区分
     */
    public RString get処理状態区分() {
        return this.result.get処理状態区分();
    }

    /**
     *
     * 再処理可能区分を取得します。
     *
     * @return 再処理可能区分
     */
    public boolean is再処理可能区分() {
        return this.result.is再処理可能区分();
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
