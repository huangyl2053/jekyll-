/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.iraisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼書一括発行のパラメータクラス
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IraishoIkkatsuHakkoParameter {

    private final RString 依頼日From;
    private final RString 依頼日To;
    private final List<RString> 認定調査依頼書;
    private final ShoKisaiHokenshaNo 保険者;
    private final List<RString> 認定調査票;
    private final List<RString> 主治医意見書作成依頼書;
    private final List<RString> 主治医意見書;

    private final boolean is依頼日From;
    private final boolean is依頼日To;
    private final boolean is認定調査依頼書未印刷;
    private final boolean is認定調査依頼書印刷済;
    private final boolean is保険者;
    private final boolean is認定調査票未印刷;
    private final boolean is認定調査票印刷済;
    private final boolean is主治医意見書作成依頼書未印刷;
    private final boolean is主治医意見書作成依頼書印刷済;
    private final boolean is主治医意見書未印刷;
    private final boolean is主治医意見書印刷済;

    /**
     * コンストラクタです。
     *
     * @param 依頼日From 依頼日From
     * @param 依頼日To 依頼日To
     * @param 認定調査依頼書 認定調査依頼書
     * @param 保険者 保険者
     * @param 認定調査票 認定調査票
     * @param 主治医意見書作成依頼書 主治医意見書作成依頼書
     * @param 主治医意見書 主治医意見書
     * @param is依頼日From is依頼日From
     * @param is依頼日To is依頼日To
     * @param is認定調査依頼書未印刷 is認定調査依頼書未印刷
     * @param is認定調査依頼書印刷済 is認定調査依頼書印刷済
     * @param is保険者 is保険者
     * @param is認定調査票未印刷 is認定調査票未印刷
     * @param is認定調査票印刷済 is認定調査票印刷済
     * @param is主治医意見書作成依頼書未印刷 is主治医意見書作成依頼書未印刷
     * @param is主治医意見書作成依頼書印刷済 is主治医意見書作成依頼書印刷済
     * @param is主治医意見書未印刷 is主治医意見書未印刷
     * @param is主治医意見書印刷済 is主治医意見書印刷済
     */
    private IraishoIkkatsuHakkoParameter(
            RString 依頼日From,
            RString 依頼日To,
            List<RString> 認定調査依頼書,
            ShoKisaiHokenshaNo 保険者,
            List<RString> 認定調査票,
            List<RString> 主治医意見書作成依頼書,
            List<RString> 主治医意見書,
            boolean is依頼日From,
            boolean is依頼日To,
            boolean is認定調査依頼書未印刷,
            boolean is認定調査依頼書印刷済,
            boolean is保険者,
            boolean is認定調査票未印刷,
            boolean is認定調査票印刷済,
            boolean is主治医意見書作成依頼書未印刷,
            boolean is主治医意見書作成依頼書印刷済,
            boolean is主治医意見書未印刷,
            boolean is主治医意見書印刷済) {
        this.依頼日From = 依頼日From;
        this.依頼日To = 依頼日To;
        this.認定調査依頼書 = 認定調査依頼書;
        this.保険者 = 保険者;
        this.認定調査票 = 認定調査票;
        this.主治医意見書作成依頼書 = 主治医意見書作成依頼書;
        this.主治医意見書 = 主治医意見書;
        this.is依頼日From = is依頼日From;
        this.is依頼日To = is依頼日To;
        this.is認定調査依頼書未印刷 = is認定調査依頼書未印刷;
        this.is認定調査依頼書印刷済 = is認定調査依頼書印刷済;
        this.is保険者 = is保険者;
        this.is認定調査票未印刷 = is認定調査票未印刷;
        this.is認定調査票印刷済 = is認定調査票印刷済;
        this.is主治医意見書作成依頼書未印刷 = is主治医意見書作成依頼書未印刷;
        this.is主治医意見書作成依頼書印刷済 = is主治医意見書作成依頼書印刷済;
        this.is主治医意見書未印刷 = is主治医意見書未印刷;
        this.is主治医意見書印刷済 = is主治医意見書印刷済;
    }

    /**
     * 依頼書一括発行パラメータークラス作成
     *
     * @param 依頼日From 依頼日From
     * @param 依頼日To 依頼日To
     * @param 認定調査依頼書 認定調査依頼書
     * @param 保険者 保険者
     * @param 認定調査票 認定調査票
     * @param 主治医意見書作成依頼書 主治医意見書作成依頼書
     * @param 主治医意見書 主治医意見書
     * @return 依頼書一括発行パラメータークラス
     */
    public static IraishoIkkatsuHakkoParameter createIraishoIkkatsuHakkoParameter(
            RDate 依頼日From,
            RDate 依頼日To,
            List<RString> 認定調査依頼書,
            ShoKisaiHokenshaNo 保険者,
            List<RString> 認定調査票,
            List<RString> 主治医意見書作成依頼書,
            List<RString> 主治医意見書) {

        boolean is依頼日From = false;
        boolean is依頼日To = false;
        boolean is認定調査依頼書未印刷 = false;
        boolean is認定調査依頼書印刷済 = false;
        boolean is保険者 = false;
        boolean is認定調査票未印刷 = false;
        boolean is認定調査票印刷済 = false;
        boolean is主治医意見書作成依頼書未印刷 = false;
        boolean is主治医意見書作成依頼書印刷済 = false;
        boolean is主治医意見書未印刷 = false;
        boolean is主治医意見書印刷済 = false;

        RString key0 = new RString("key0");
        RString key1 = new RString("key1");
        if (依頼日From != null) {
            is依頼日From = true;
        }
        if (依頼日To != null) {
            is依頼日To = true;
        }
        if (!認定調査依頼書.isEmpty()) {
            if (認定調査依頼書.contains(key0)) {
                is認定調査依頼書未印刷 = true;
            }
            if (認定調査依頼書.contains(key1)) {
                is認定調査依頼書印刷済 = true;
            }
        }
        if (保険者 != null && !保険者.isEmpty()) {
            is保険者 = true;
        }
        if (!認定調査票.isEmpty()) {
            if (認定調査票.contains(key0)) {
                is認定調査票未印刷 = true;
            }
            if (認定調査票.contains(key1)) {
                is認定調査票印刷済 = true;
            }
        }
        if (!主治医意見書作成依頼書.isEmpty()) {
            if (主治医意見書作成依頼書.contains(key0)) {
                is主治医意見書作成依頼書未印刷 = true;
            }
            if (主治医意見書作成依頼書.contains(key1)) {
                is主治医意見書作成依頼書印刷済 = true;
            }
        }
        if (!主治医意見書.isEmpty()) {
            if (主治医意見書.contains(key0)) {
                is主治医意見書未印刷 = true;
            }
            if (主治医意見書.contains(key1)) {
                is主治医意見書印刷済 = true;
            }
        }

        return new IraishoIkkatsuHakkoParameter(
                依頼日From == null ? RString.EMPTY : 依頼日From.toDateString(),
                依頼日To == null ? RString.EMPTY : 依頼日To.toDateString(),
                認定調査依頼書,
                保険者, 認定調査票, 主治医意見書作成依頼書,
                主治医意見書, is依頼日From, is依頼日To,
                is認定調査依頼書未印刷, is認定調査依頼書印刷済,
                is保険者, is認定調査票未印刷, is認定調査票印刷済,
                is主治医意見書作成依頼書未印刷,
                is主治医意見書作成依頼書印刷済,
                is主治医意見書未印刷, is主治医意見書印刷済);
    }

}
