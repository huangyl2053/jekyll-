/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.gamendiv;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
/**
 *
 * 画面divEntity
 */

public class KaigoFukaTokuchoHeijunkaEntity {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private RString 増額平準化方法;
    private RString 減額平準化方法;
    private RString 帳票グループ;
    private ReportId 帳票分類ＩＤ;
    private RString 帳票名;
    private RString 改頁出力順ID;
    private RString 出力対象指示フラグ;
    private FlexibleDate 発行日;
    private RString 文書番号;
    private RString 遷移元区分;
    private RString 項目名;

    /**
     * 調定年度のgetメソッドです。
     *
     * @return 調定年度
     */
    public FlexibleYear get調定年度() {
        return 調定年度;
    }

    /**
     * 調定年度のsetメソッドです。
     *
     * @param 調定年度
     */
    public void set調定年度(FlexibleYear 調定年度) {
        this.調定年度 = 調定年度;
    }

    /**
     * 賦課年度のgetメソッドです。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return 賦課年度;
    }

    /**
     * 賦課年度のsetメソッドです。
     *
     * @param 賦課年度
     */
    public void set賦課年度(FlexibleYear 賦課年度) {
        this.賦課年度 = 賦課年度;
    }



    /**
     * 増額平準化方法のgetメソッドです。
     *
     * @return 増額平準化方法
     */
    public RString get増額平準化方法() {
        return 増額平準化方法;
    }

    /**
     * 増額平準化方法のsetメソッドです。
     *
     * @param 増額平準化方法
     */
    public void set増額平準化方法(RString 増額平準化方法) {
        this.増額平準化方法 = 増額平準化方法;
    }

    /**
     * 減額平準化方法のgetメソッドです。
     *
     * @return 減額平準化方法
     */
    public RString get減額平準化方法() {
        return 減額平準化方法;
    }

    /**
     * 減額平準化方法のsetメソッドです。
     *
     * @param 減額平準化方法
     */
    public void set減額平準化方法(RString 減額平準化方法) {
        this.減額平準化方法 = 減額平準化方法;
    }

    /**
     * 帳票グループのgetメソッドです。
     *
     * @return 帳票グループ
     */
    public RString get帳票グループ() {
        return 帳票グループ;
    }

    /**
     * 帳票グループのsetメソッドです。
     *
     * @param 帳票グループ
     */
    public void set帳票グループ(RString 帳票グループ) {
        this.帳票グループ = 帳票グループ;
    }

    /**
     * 帳票分類ＩＤのgetメソッドです。
     *
     * @return 帳票分類ＩＤ
     */
    public ReportId get帳票分類ＩＤ() {
        return 帳票分類ＩＤ;
    }

    /**
     * 帳票分類ＩＤのsetメソッドです。
     *
     * @param 帳票分類ＩＤ
     */
    public void set帳票分類ＩＤ(ReportId 帳票分類ＩＤ) {
        this.帳票分類ＩＤ = 帳票分類ＩＤ;
    }

    /**
     * 帳票名のgetメソッドです。
     *
     * @return 帳票名
     */
    public RString get帳票名() {
        return 帳票名;
    }

    /**
     * 帳票名のsetメソッドです。
     *
     * @param 帳票名
     */
    public void set帳票名(RString 帳票名) {
        this.帳票名 = 帳票名;
    }

    /**
     * 改頁出力順IDのgetメソッドです。
     *
     * @return 改頁出力順ID
     */
    public RString get改頁出力順ID() {
        return 改頁出力順ID;
    }

    /**
     * 改頁出力順IDのsetメソッドです。
     *
     * @param 改頁出力順ID
     */
    public void set改頁出力順ID(RString 改頁出力順ID) {
        this.改頁出力順ID = 改頁出力順ID;
    }

    /**
     * 出力対象指示フラグのgetメソッドです。
     *
     * @return 出力対象指示フラグ
     */
    public RString get出力対象指示フラグ() {
        return 出力対象指示フラグ;
    }

    /**
     * 出力対象指示フラグのsetメソッドです。
     *
     * @param 出力対象指示フラグ
     */
    public void set出力対象指示フラグ(RString 出力対象指示フラグ) {
        this.出力対象指示フラグ = 出力対象指示フラグ;
    }

    /**
     * 発行日のgetメソッドです。
     *
     * @return 発行日
     */
    public FlexibleDate get発行日() {
        return 発行日;
    }

    /**
     * 発行日のsetメソッドです。
     *
     * @param 発行日
     */
    public void set発行日(FlexibleDate 発行日) {
        this.発行日 = 発行日;
    }

    /**
     * 文書番号のgetメソッドです。
     *
     * @return 文書番号
     */
    public RString get文書番号() {
        return 文書番号;
    }

    /**
     * 文書番号のsetメソッドです。
     *
     * @param 文書番号
     */
    public void set文書番号(RString 文書番号) {
        this.文書番号 = 文書番号;
    }

    /**
     * 遷移元区分のgetメソッドです。
     *
     * @return 遷移元区分
     */
    public RString get遷移元区分() {
        return 遷移元区分;
    }

    /**
     * 遷移元区分のsetメソッドです。
     *
     * @param 遷移元区分
     */
    public void set遷移元区分(RString 遷移元区分) {
        this.遷移元区分 = 遷移元区分;
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



}
