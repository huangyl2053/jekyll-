/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kanri;

import java.util.NoSuchElementException;
import jp.co.ndensan.reams.db.dbx.definition.core.ITsukiShorkiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期と月の対応を扱います。
 *
 * @reamsid_L DBB-9020-080 sunhaidi
 */
public class Kitsuki {

    private final Tsuki 月;
    private final RString 期;
    private final ITsukiShorkiKubun 月処理区分;
    private final boolean 実在フラグ;
    private final KitsukiHyoki 期月表記;

    /**
     * コンストラクタです。
     *
     * @param 月 月
     * @param 期 期
     * @param 月処理区分 月処理区分
     * @param 実在フラグ 実在フラグ
     * @param 期月表記 期月表記
     */
    public Kitsuki(Tsuki 月, RString 期, ITsukiShorkiKubun 月処理区分, boolean 実在フラグ, KitsukiHyoki 期月表記) {
        this.月 = 月;
        this.期 = 期;
        this.月処理区分 = 月処理区分;
        this.実在フラグ = 実在フラグ;
        this.期月表記 = 期月表記;
    }

    /**
     * 期月が保持する期をint型で返します。
     *
     * @return 期(int)
     * @throws NumberFormatException 保持する期がint型に変換できない場合
     */
    public int get期AsInt() {
        if (RString.isNullOrEmpty(期)) {
            return 0;
        }
        return Integer.parseInt(期.toString());
    }

    /**
     * 保持する期を返します。
     *
     * @return 期
     */
    public RString get期() {
        return 期;
    }

    /**
     * 月をint型で返します。
     *
     * @return 月(int)
     * @throws NoSuchElementException 期月が月を保持しない場合
     */
    public int get月AsInt() {
        if (月 == null) {
            throw new NoSuchElementException();
        }
        return Integer.parseInt(月.getコード().toString());
    }

    /**
     * 保持する月を返します。
     *
     * @return 月
     * @throws NoSuchElementException 期月が月を保持しない場合
     */
    public Tsuki get月() {
        if (月 == null) {
            throw new NoSuchElementException();
        }
        return 月;
    }

    /**
     * 保持する表記を返します。
     *
     * @return 期月表記
     */
    public KitsukiHyoki get表記() {
        return 期月表記;
    }

    /**
     * 月処理区分を返します。
     *
     * @return 月処理区分
     */
    public ITsukiShorkiKubun get月処理区分() {
        return 月処理区分;
    }

    /**
     * 保持する実在フラグを返します。
     *
     * @return 実在フラグ(存在する期であれば場合はtrue、存在しない期であればfalseを返します)
     */
    public boolean isPresent() {
        return 実在フラグ;
    }
}
