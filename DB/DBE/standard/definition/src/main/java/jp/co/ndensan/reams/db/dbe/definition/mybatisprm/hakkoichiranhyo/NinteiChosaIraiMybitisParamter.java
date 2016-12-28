/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査依頼発行一覧表ですためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0080-160 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class NinteiChosaIraiMybitisParamter implements IMyBatisParameter {

    private static final RString 未印刷 = new RString("1");
    private static final RString 印刷済 = new RString("2");
    private final RString 通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 延期 = ShoriJotaiKubun.延期.getコード();
    private final RString 転入 = NinteiShinseiShinseijiKubunCode.転入申請.getコード();
    private final RString 喪失 = NinteiShinseiShinseijiKubunCode.資格喪失_死亡.getコード();
    private final RString iraiFromYMD;
    private final RString iraiToYMD;
    private final RString shujiiIkenshoSakuseiIraisho;
    private final RString shujiiIkensho;
    private final List<GridParameter> ninteiChosaIraiList;
    private final boolean is認定調査依頼書未印刷;
    private final boolean is認定調査依頼書印刷済;
    private final boolean is認定調査票未印刷;
    private final boolean is認定調査票印刷済;
    private final boolean is依頼日From;
    private final boolean is依頼日To;

    /**
     * コンストラクタです。
     *
     * @param 依頼日From 依頼日From
     * @param 依頼日To 依頼日To
     * @param 認定調査依頼書 認定調査依頼書
     * @param 認定調査票 認定調査票
     * @param 認定調査依頼リスト 認定調査依頼リスト
     * @param is認定調査依頼書未印刷 is認定調査依頼書未印刷
     * @param is認定調査依頼書印刷済 is認定調査依頼書印刷済
     * @param is認定調査票未印刷 is認定調査票未印刷
     * @param is認定調査票印刷済 is認定調査票印刷済
     * @param is依頼日From is依頼日From
     * @param is依頼日To is依頼日To
     */
    private NinteiChosaIraiMybitisParamter(
            RString 依頼日From,
            RString 依頼日To,
            RString 認定調査依頼書,
            RString 認定調査票,
            List<GridParameter> 認定調査依頼リスト,
            boolean is認定調査依頼書未印刷,
            boolean is認定調査依頼書印刷済,
            boolean is認定調査票未印刷,
            boolean is認定調査票印刷済,
            boolean is依頼日From,
            boolean is依頼日To) {
        this.iraiFromYMD = 依頼日From;
        this.iraiToYMD = 依頼日To;
        this.shujiiIkenshoSakuseiIraisho = 認定調査依頼書;
        this.shujiiIkensho = 認定調査票;
        this.ninteiChosaIraiList = 認定調査依頼リスト;
        this.is認定調査依頼書未印刷 = is認定調査依頼書未印刷;
        this.is認定調査依頼書印刷済 = is認定調査依頼書印刷済;
        this.is認定調査票未印刷 = is認定調査票未印刷;
        this.is認定調査票印刷済 = is認定調査票印刷済;
        this.is依頼日From = is依頼日From;
        this.is依頼日To = is依頼日To;
    }

    /**
     * コンストラクタです。
     *
     * @param 依頼日From 依頼日From
     * @param 依頼日To 依頼日To
     * @param 認定調査依頼書 認定調査依頼書
     * @param 認定調査票 認定調査票
     * @param 認定調査依頼リスト 認定調査依頼リスト
     *
     * @return NinteiChosaIraiMybitisParamter
     */
    public static NinteiChosaIraiMybitisParamter createSelectByKeyParam(
            RString 依頼日From,
            RString 依頼日To,
            RString 認定調査依頼書,
            RString 認定調査票,
            List<GridParameter> 認定調査依頼リスト) {

        boolean is認定調査依頼書未印刷 = false;
        boolean is認定調査依頼書印刷済 = false;
        boolean is認定調査票未印刷 = false;
        boolean is認定調査票印刷済 = false;
        boolean is依頼日From = false;
        boolean is依頼日To = false;

        if (!RString.isNullOrEmpty(依頼日From)) {
            is依頼日From = true;
        }
        if (!RString.isNullOrEmpty(依頼日To)) {
            is依頼日To = true;
        }
        if (!RString.isNullOrEmpty(認定調査依頼書) && 認定調査依頼書.equals(未印刷)) {
            is認定調査依頼書未印刷 = true;
        }
        if (!RString.isNullOrEmpty(認定調査依頼書) && 認定調査依頼書.equals(印刷済)) {
            is認定調査依頼書印刷済 = true;
        }
        if (!RString.isNullOrEmpty(認定調査票) && 認定調査票.equals(未印刷)) {
            is認定調査票未印刷 = true;
        }
        if (!RString.isNullOrEmpty(認定調査票) && 認定調査票.equals(印刷済)) {
            is認定調査票印刷済 = true;
        }
        return new NinteiChosaIraiMybitisParamter(依頼日From,
                依頼日To,
                認定調査依頼書,
                認定調査票,
                認定調査依頼リスト,
                is認定調査依頼書未印刷,
                is認定調査依頼書印刷済,
                is認定調査票未印刷,
                is認定調査票印刷済,
                is依頼日From,
                is依頼日To);
    }
}
