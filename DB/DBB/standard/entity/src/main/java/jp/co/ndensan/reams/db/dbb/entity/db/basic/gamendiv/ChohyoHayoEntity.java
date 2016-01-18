/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.gamendiv;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 帳票制御汎用Entity
 */
public class ChohyoHayoEntity {

    private RString サブ業務コード;
    private RString 帳票分類ID;
    private FlexibleYear 管理年度;
    private RString 項目名;

    /**
     * サブ業務コードのgetメソッドです。
     *
     * @return サブ業務コード
     */
    public RString getサブ業務コード() {
        return サブ業務コード;

    }

    /**
     * サブ業務コードのsetメソッドです。
     *
     * @param サブ業務コード
     */
    public void setサブ業務コード(RString サブ業務コード) {

        this.サブ業務コード = サブ業務コード;
    }

    /**
     * 帳票分類IDのgetメソッドです。
     *
     * @return 帳票分類ID
     */
    public RString get帳票分類ID() {
        return 帳票分類ID;

    }

    /**
     * サブ業務コードのsetメソッドです。
     *
     * @param 帳票分類ID
     */
    public void set帳票分類ID(RString 帳票分類ID) {

        this.帳票分類ID = 帳票分類ID;
    }

    /**
     * 項目名のgetメソッドです。
     *
     * @return 項目名
     */
    public RString get項目名() {
        return 項目名;

    }

    /**
     * 項目名のsetメソッドです。
     *
     * @param 項目名
     */
    public void set項目名(RString 項目名) {

        this.項目名 = 項目名;
    }

    /**
     * 管理年度のgetメソッドです。
     *
     * @return 管理年度
     */
    public FlexibleYear get管理年度() {
        return 管理年度;
    }

    /**
     * 管理年度のsetメソッドです。
     *
     * @param 管理年度
     */
    public void set管理年度(FlexibleYear 管理年度) {
        this.管理年度 = 管理年度;
    }

}
