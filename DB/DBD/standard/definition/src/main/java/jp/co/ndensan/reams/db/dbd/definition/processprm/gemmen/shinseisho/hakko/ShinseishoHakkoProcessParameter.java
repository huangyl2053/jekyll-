/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.gemmen.shinseisho.hakko;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmen.shinseisho.hakko.FutanGendogakuMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * DBDBZ12021_4_介護保険負担限度額認定申請書パラメタークラスです．
 *
 * @reamsid_L DBD-3530-080 mawy
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseishoHakkoProcessParameter implements IBatchProcessParameter {

    private UUID 発行処理ID;
    private boolean 出力フラグ;
    private long 改頁出力順ID;
    private FlexibleDate 基準日;
    private ReportId 帳票ID;
    private FlexibleDate 発行日;

    /**
     * コンストラクタです。
     *
     * @param 発行処理ID 発行処理ID
     * @param 出力フラグ 出力フラグ
     * @param 改頁出力順ID 改頁出力順ID
     * @param 基準日 基準日
     * @param 帳票ID 帳票ID
     * @param 発行日 発行日
     */
    public ShinseishoHakkoProcessParameter(
            UUID 発行処理ID,
            boolean 出力フラグ,
            long 改頁出力順ID,
            FlexibleDate 基準日,
            ReportId 帳票ID,
            FlexibleDate 発行日) {
        this.発行処理ID = 発行処理ID;
        this.出力フラグ = 出力フラグ;
        this.改頁出力順ID = 改頁出力順ID;
        this.基準日 = 基準日;
        this.帳票ID = 帳票ID;
        this.発行日 = 発行日;
    }

    /**
     * バーチのパラメータを作成します。
     *
     * @param 出力順 出力順
     * @return FutanGendogakuMybatisParameter
     */
    public FutanGendogakuMybatisParameter toFutanGendogakuMybatisParameter(RString 出力順) {
        return new FutanGendogakuMybatisParameter(発行処理ID, 出力フラグ, 出力順, 基準日, 発行日);
    }

}
