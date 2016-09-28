/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書督促対象者一覧表を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class ShujiiIkenTokusokujoHakkoMybitisParamter implements IMyBatisParameter {

    private final RString temp_印刷期間開始日;
    private final RString temp_印刷期間終了日;
    private final RString temp_保険者コード;
    private final RString temp_主治医医療機関コード;
    private final RString temp_主治医コード;
    private final boolean uses印刷期間;
    private final boolean uses印刷期間開始日;
    private final boolean uses印刷期間終了日;
    private final boolean uses保険者コード;
    private final boolean uses主治医医療機関コード;
    private final boolean uses主治医コード;
    private final RString 取下 = ShoriJotaiKubun.取下.getコード();
    private final RString 却下 = ShoriJotaiKubun.却下.getコード();

    private ShujiiIkenTokusokujoHakkoMybitisParamter(RString temp_印刷期間開始日, RString temp_印刷期間終了日,
            RString temp_保険者コード, RString temp_主治医医療機関コード, RString temp_主治医コード,
            boolean uses印刷期間, boolean uses印刷期間開始日, boolean uses印刷期間終了日, boolean uses保険者コード,
            boolean uses主治医医療機関コード, boolean uses主治医コード) {
        this.temp_印刷期間開始日 = temp_印刷期間開始日;
        this.temp_印刷期間終了日 = temp_印刷期間終了日;
        this.temp_保険者コード = temp_保険者コード;
        this.temp_主治医医療機関コード = temp_主治医医療機関コード;
        this.temp_主治医コード = temp_主治医コード;
        this.uses印刷期間 = uses印刷期間;
        this.uses印刷期間開始日 = uses印刷期間開始日;
        this.uses印刷期間終了日 = uses印刷期間終了日;
        this.uses保険者コード = uses保険者コード;
        this.uses主治医医療機関コード = uses主治医医療機関コード;
        this.uses主治医コード = uses主治医コード;
    }

    /**
     * コンストラクタです。
     *
     * @param temp_印刷期間開始日 temp_印刷期間開始日
     * @param temp_印刷期間終了日 temp_印刷期間終了日
     * @param temp_保険者コード temp_保険者コード
     * @param temp_主治医医療機関コード temp_主治医医療機関コード
     * @param temp_主治医コード temp_主治医コード
     * @param uses印刷期間 uses印刷期間
     * @param uses印刷期間開始日 uses印刷期間開始日
     * @param uses印刷期間終了日 uses印刷期間終了日
     * @param uses主治医医療機関コード uses主治医医療機関コード
     * @param uses保険者コード uses保険者コード
     * @param uses主治医コード uses主治医コード
     * @return ShujiiIkenTokusokujoHakkoMybitisParamter
     */
    public static ShujiiIkenTokusokujoHakkoMybitisParamter createParam(
            RString temp_印刷期間開始日,
            RString temp_印刷期間終了日,
            RString temp_保険者コード,
            RString temp_主治医医療機関コード,
            RString temp_主治医コード,
            boolean uses印刷期間,
            boolean uses印刷期間開始日,
            boolean uses印刷期間終了日,
            boolean uses保険者コード,
            boolean uses主治医医療機関コード,
            boolean uses主治医コード) {
        uses印刷期間 = false;
        uses印刷期間開始日 = false;
        uses印刷期間終了日 = false;
        uses保険者コード = false;
        uses主治医医療機関コード = false;
        uses主治医コード = false;
        if (temp_印刷期間開始日 != null && temp_印刷期間終了日 != null) {
            uses印刷期間 = true;
        }
        if (temp_印刷期間開始日 != null && temp_印刷期間終了日 == null) {
            uses印刷期間開始日 = true;
        }
        if (temp_印刷期間開始日 == null && temp_印刷期間終了日 != null) {
            uses印刷期間終了日 = true;
        }
        if (temp_保険者コード != null && !temp_保険者コード.isEmpty()) {
            uses保険者コード = true;
        }
        if (temp_主治医医療機関コード != null && !temp_主治医医療機関コード.isEmpty()) {
            uses主治医医療機関コード = true;
        }
        if (temp_主治医コード != null && !temp_主治医コード.isEmpty()) {
            uses主治医コード = true;
        }
        return new ShujiiIkenTokusokujoHakkoMybitisParamter(temp_印刷期間開始日, temp_印刷期間終了日, temp_保険者コード,
                temp_主治医医療機関コード, temp_主治医コード, uses印刷期間, uses印刷期間開始日, uses印刷期間終了日,
                uses保険者コード, uses主治医医療機関コード, uses主治医コード);
    }
}
