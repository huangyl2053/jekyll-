/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書督促状発行を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class ShujiiIkenTokusokujoMybitisParamter implements IMyBatisParameter {

    private final FlexibleDate temp_基準日;
    private final RString temp_印刷済対象者;
    private final RString temp_保険者コード;
    private final RString temp_主治医医療機関コード;
    private final RString temp_主治医コード;
    private final boolean uses印刷済対象者;
    private final boolean uses保険者コード;
    private final boolean uses主治医医療機関コード;
    private final boolean uses主治医コード;
    private final LasdecCode temp_市町村コード;
    private final RString 取下 = ShoriJotaiKubun.取下.getコード();
    private final RString 却下 = ShoriJotaiKubun.却下.getコード();

    private ShujiiIkenTokusokujoMybitisParamter(FlexibleDate temp_基準日, RString temp_印刷済対象者, RString temp_保険者コード,
            RString temp_主治医医療機関コード, RString temp_主治医コード, boolean uses印刷済対象者, boolean uses保険者コード,
            boolean uses主治医医療機関コード, boolean uses主治医コード, LasdecCode temp_市町村コード) {
        this.temp_基準日 = temp_基準日;
        this.temp_印刷済対象者 = temp_印刷済対象者;
        this.temp_保険者コード = temp_保険者コード;
        this.temp_主治医医療機関コード = temp_主治医医療機関コード;
        this.temp_主治医コード = temp_主治医コード;
        this.uses印刷済対象者 = uses印刷済対象者;
        this.uses保険者コード = uses保険者コード;
        this.uses主治医医療機関コード = uses主治医医療機関コード;
        this.uses主治医コード = uses主治医コード;
        this.temp_市町村コード = temp_市町村コード;
    }

    /**
     * コンストラクタです。
     *
     * @param temp_基準日 temp_基準日
     * @param temp_印刷済対象者 temp_印刷済対象者
     * @param temp_保険者コード temp_保険者コード
     * @param temp_主治医医療機関コード temp_主治医医療機関コード
     * @param temp_主治医コード temp_主治医コード
     * @param uses印刷済対象者 uses印刷済対象者
     * @param uses保険者コード uses保険者コード
     * @param uses主治医医療機関コード uses主治医医療機関コード
     * @param uses主治医コード uses主治医コード
     * @param temp_市町村コード temp_市町村コード
     * @return ShujiiIkenTokusokujoMybitisParamter
     */
    public static ShujiiIkenTokusokujoMybitisParamter createParam(
            FlexibleDate temp_基準日,
            RString temp_印刷済対象者,
            RString temp_保険者コード,
            RString temp_主治医医療機関コード,
            RString temp_主治医コード,
            boolean uses印刷済対象者,
            boolean uses保険者コード,
            boolean uses主治医医療機関コード,
            boolean uses主治医コード,
            LasdecCode temp_市町村コード) {
        uses印刷済対象者 = false;
        uses保険者コード = false;
        uses主治医医療機関コード = false;
        uses主治医コード = false;
        if (temp_印刷済対象者.equals(new RString("1"))) {
            uses印刷済対象者 = true;
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
        return new ShujiiIkenTokusokujoMybitisParamter(temp_基準日, temp_印刷済対象者, temp_保険者コード, temp_主治医医療機関コード,
                temp_主治医コード, uses印刷済対象者, uses保険者コード, uses主治医医療機関コード, uses主治医コード, temp_市町村コード);
    }
}
