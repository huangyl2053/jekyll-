/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関&主治医入力のビジネスクラスです
 */
public class ShujiiIryokikanAndShujiiInputResult implements Serializable {

    private RString 主治医医療機関名称;
    private AtenaMeisho 主治医氏名;
    private RString 主治医医療機関コード;
    private RString 主治医コード;
    private boolean 指定医フラグ;

    /**
     * 主治医医療機関名称を取得します。
     *
     * @return 主治医医療機関名称
     */
    public RString get主治医医療機関名称() {
        return this.主治医医療機関名称;
    }

    /**
     * 主治医氏名を取得します。
     *
     * @return 主治医氏名
     */
    public AtenaMeisho get主治医氏名() {
        return this.主治医氏名;
    }

    /**
     * 主治医医療機関コードを取得します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return this.主治医医療機関コード;
    }

    /**
     * 主治医コードを取得します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return this.主治医コード;
    }

    /**
     * 指定医フラグを取得します。
     *
     * @return 指定医フラグ
     */
    public boolean is指定医フラグ() {
        return 指定医フラグ;
    }

    /**
     * 指定医フラグを設定します。
     *
     * @param 指定医フラグ 指定医フラグ
     */
    public void set指定医フラグ(boolean 指定医フラグ) {
        this.指定医フラグ = 指定医フラグ;
    }

    /**
     * 主治医医療機関名称を設定します。
     *
     * @param 主治医医療機関名称 主治医医療機関名称
     */
    public void set主治医医療機関名称(RString 主治医医療機関名称) {
        this.主治医医療機関名称 = 主治医医療機関名称;
    }

    /**
     * 主治医氏名を設定します。
     *
     * @param 主治医氏名 主治医氏名
     */
    public void set主治医氏名(AtenaMeisho 主治医氏名) {
        this.主治医氏名 = 主治医氏名;
    }

    /**
     * 主治医医療機関コードを設定します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     */
    public void set主治医医療機関コード(RString 主治医医療機関コード) {
        this.主治医医療機関コード = 主治医医療機関コード;
    }

    /**
     * 主治医コードを設定します。
     *
     * @param 主治医コード 主治医コード
     */
    public void set主治医コード(RString 主治医コード) {
        this.主治医コード = 主治医コード;
    }
}
