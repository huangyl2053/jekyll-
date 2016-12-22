/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 合議体情報作成一時テーブルクラスです。
 *
 * @author n3304 岡澤 政幸
 */
public class TempGogitaiJohoSakusei implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("TempGogitaiJohoSakusei");
    }
    @TempTableColumnOrder(10)
    @PrimaryKey
    private RString 合議体NO;
    @TempTableColumnOrder(20)
    @PrimaryKey
    private RString 有効開始日;
    @TempTableColumnOrder(30)
    @PrimaryKey
    private RString 有効終了日;
    @TempTableColumnOrder(40)
    private RString 合議体名称;
    @TempTableColumnOrder(50)
    private RString 合議体開始予定時刻;
    @TempTableColumnOrder(60)
    private RString 合議体終了予定時刻;
    @TempTableColumnOrder(70)
    private RString 審査会予定定員;
    @TempTableColumnOrder(80)
    private RString 審査会自動割当定員;
    @TempTableColumnOrder(90)
    private RString 審査会委員定員;
    @TempTableColumnOrder(100)
    private RString 開催場所コード;
    @TempTableColumnOrder(110)
    private RString 精神科医所属;
    @TempTableColumnOrder(120)
    private RString 合議体ダミーフラグ;
    @TempTableColumnOrder(130)
    private RString 審査会委員コード;
    @TempTableColumnOrder(140)
    private RString 補欠;
    @TempTableColumnOrder(150)
    private RString 合議体長区分コード;

    /**
     * 合議体NOを返します。
     *
     * @return 合議体NO
     */
    public RString get合議体NO() {
        return 合議体NO;
    }

    /**
     * 合議体NOを設定します。
     *
     * @param 合議体NO 合議体NO
     */
    public void set合議体NO(RString 合議体NO) {
        this.合議体NO = 合議体NO;
    }

    /**
     * 有効開始日を返します。
     *
     * @return 有効開始日
     */
    public RString get有効開始日() {
        return 有効開始日;
    }

    /**
     * 有効開始日を設定します。
     *
     * @param 有効開始日 有効開始日
     */
    public void set有効開始日(RString 有効開始日) {
        this.有効開始日 = 有効開始日;
    }

    /**
     * 有効終了日を返します。
     *
     * @return 有効終了日
     */
    public RString get有効終了日() {
        return 有効終了日;
    }

    /**
     * 有効終了日を設定します。
     *
     * @param 有効終了日 有効終了日
     */
    public void set有効終了日(RString 有効終了日) {
        this.有効終了日 = 有効終了日;
    }

    /**
     * 合議体名称を返します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return 合議体名称;
    }

    /**
     * 合議体名称を設定します。
     *
     * @param 合議体名称 合議体名称
     */
    public void set合議体名称(RString 合議体名称) {
        this.合議体名称 = 合議体名称;
    }

    /**
     * 合議体開始予定時刻を返します。
     *
     * @return 合議体開始予定時刻
     */
    public RString get合議体開始予定時刻() {
        return 合議体開始予定時刻;
    }

    /**
     * 合議体開始予定時刻を設定します。
     *
     * @param 合議体開始予定時刻 合議体開始予定時刻
     */
    public void set合議体開始予定時刻(RString 合議体開始予定時刻) {
        this.合議体開始予定時刻 = 合議体開始予定時刻;
    }

    /**
     * 合議体終了予定時刻を返します。
     *
     * @return 合議体終了予定時刻
     */
    public RString get合議体終了予定時刻() {
        return 合議体終了予定時刻;
    }

    /**
     * 合議体終了予定時刻を設定します。
     *
     * @param 合議体終了予定時刻 合議体終了予定時刻
     */
    public void set合議体終了予定時刻(RString 合議体終了予定時刻) {
        this.合議体終了予定時刻 = 合議体終了予定時刻;
    }

    /**
     * 審査会予定定員を返します。
     *
     * @return 審査会予定定員
     */
    public RString get審査会予定定員() {
        return 審査会予定定員;
    }

    /**
     * 審査会予定定員を設定します。
     *
     * @param 審査会予定定員 審査会予定定員
     */
    public void set審査会予定定員(RString 審査会予定定員) {
        this.審査会予定定員 = 審査会予定定員;
    }

    /**
     * 審査会自動割当定員を返します。
     *
     * @return 審査会自動割当定員
     */
    public RString get審査会自動割当定員() {
        return 審査会自動割当定員;
    }

    /**
     * 審査会自動割当定員を設定します。
     *
     * @param 審査会自動割当定員 審査会自動割当定員
     */
    public void set審査会自動割当定員(RString 審査会自動割当定員) {
        this.審査会自動割当定員 = 審査会自動割当定員;
    }

    /**
     * 審査会委員定員を返します。
     *
     * @return 審査会委員定員
     */
    public RString get審査会委員定員() {
        return 審査会委員定員;
    }

    /**
     * 審査会委員定員を設定します。
     *
     * @param 審査会委員定員 審査会委員定員
     */
    public void set審査会委員定員(RString 審査会委員定員) {
        this.審査会委員定員 = 審査会委員定員;
    }

    /**
     * 開催場所コードを返します。
     *
     * @return 開催場所コード
     */
    public RString get開催場所コード() {
        return 開催場所コード;
    }

    /**
     * 開催場所コードを設定します。
     *
     * @param 開催場所コード 開催場所コード
     */
    public void set開催場所コード(RString 開催場所コード) {
        this.開催場所コード = 開催場所コード;
    }

    /**
     * 精神科医所属を返します。
     *
     * @return 精神科医所属
     */
    public RString get精神科医所属() {
        return 精神科医所属;
    }

    /**
     * 精神科医所属を設定します。
     *
     * @param 精神科医所属 精神科医所属
     */
    public void set精神科医所属(RString 精神科医所属) {
        this.精神科医所属 = 精神科医所属;
    }

    /**
     * 合議体ダミーフラグを返します。
     *
     * @return 合議体ダミーフラグ
     */
    public RString get合議体ダミーフラグ() {
        return 合議体ダミーフラグ;
    }

    /**
     * 合議体ダミーフラグを設定します。
     *
     * @param 合議体ダミーフラグ 合議体ダミーフラグ
     */
    public void set合議体ダミーフラグ(RString 合議体ダミーフラグ) {
        this.合議体ダミーフラグ = 合議体ダミーフラグ;
    }

    /**
     * 審査会委員コードを返します。
     *
     * @return 審査会委員コード
     */
    public RString get審査会委員コード() {
        return 審査会委員コード;
    }

    /**
     * 審査会委員コードを設定します。
     *
     * @param 審査会委員コード 審査会委員コード
     */
    public void set審査会委員コード(RString 審査会委員コード) {
        this.審査会委員コード = 審査会委員コード;
    }

    /**
     * 補欠を返します。
     *
     * @return 補欠
     */
    public RString get補欠() {
        return 補欠;
    }

    /**
     * 補欠を設定します。
     *
     * @param 補欠 補欠
     */
    public void set補欠(RString 補欠) {
        this.補欠 = 補欠;
    }

    /**
     * 合議体長区分コードを返します。
     *
     * @return 合議体長区分コード
     */
    public RString get合議体長区分コード() {
        return 合議体長区分コード;
    }

    /**
     * 合議体長区分コードを設定します。
     *
     * @param 合議体長区分コード 合議体長区分コード
     */
    public void set合議体長区分コード(RString 合議体長区分コード) {
        this.合議体長区分コード = 合議体長区分コード;
    }

}
