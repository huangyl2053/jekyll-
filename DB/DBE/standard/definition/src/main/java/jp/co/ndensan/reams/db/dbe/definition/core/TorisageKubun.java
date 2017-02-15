/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定申請の取下げ区分を表す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum TorisageKubun {

    /**
     * 認定申請有効。
     */
    認定申請有効(new Code(new RString("1"))),
    /**
     * 却下。
     */
    却下(new Code(new RString("2"))),
    /**
     * 取下げ。
     */
    取下げ(
            new Code(new RString("3"))),
    /**
     * 区分変更却下。
     */
    区分変更却下(new Code(new RString("4")));
    private final Code 取下げ区分コード;
    private final RString aName;

    private TorisageKubun(Code 取下げ区分コード) {
        this.取下げ区分コード = 取下げ区分コード;
        this.aName = new RString(name());
    }

    /**
     * 取下げ区分コードを返します。
     *
     * @return 取下げ区分コード
     */
    public Code get取下げ区分コード() {
        return 取下げ区分コード;
    }

    /**
     * @return 名称
     */
    public RString getName() {
        return this.aName;
    }

    /**
     * 引数から渡された取下げ区分コードを元に、対応した取下げ区分を返します。<br/>
     * 対応していないコードを渡した場合はnullが返ります。
     *
     * @param 取下げ区分コード 取下げ区分コード
     * @return 取下げ区分
     */
    public static TorisageKubun toValue(Code 取下げ区分コード) {
        for (TorisageKubun kubun : values()) {
            if (kubun.取下げ区分コード.equals(取下げ区分コード)) {
                return kubun;
            }
        }
        return null;
    }

    private static final int 更新申請可能日数 = 61;

    /**
     *
     * @param 申請時の申請区分
     * @param 前回二次判定結果
     * @param 前回有効期間終了日
     * @param 今回二次判定結果
     * @param 申請日
     * @return
     */
    public static TorisageKubun toValue(
            NinteiShinseiKubunShinsei 申請時の申請区分,
            YokaigoJotaiKubun09 前回二次判定結果,
            FlexibleDate 前回有効期間終了日,
            YokaigoJotaiKubun09 今回二次判定結果,
            FlexibleDate 申請日) {
        if (申請時の申請区分 != NinteiShinseiKubunShinsei.区分変更申請) {
            return TorisageKubun.認定申請有効;
        }
        if (!Objects.equals(前回二次判定結果, 今回二次判定結果)) {
            return TorisageKubun.認定申請有効;
        }
        if (前回有効期間終了日.getBetweenDays(申請日) < 更新申請可能日数) {
            return TorisageKubun.認定申請有効;
        }
        return TorisageKubun.区分変更却下;
    }
}
