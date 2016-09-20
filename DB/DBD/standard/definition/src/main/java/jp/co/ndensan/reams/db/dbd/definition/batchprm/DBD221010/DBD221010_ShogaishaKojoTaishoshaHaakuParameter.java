/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD221010;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 障がい者控除対象者認定のDivControllerのバッチパラメタークラスです。
 *
 * @reamsid_L DBD-3850-010 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD221010_ShogaishaKojoTaishoshaHaakuParameter extends BatchParameterBase {

    private static final String KIJUNRI = "kijinhi";
    private static final String TAISHONANDU = "taishonandu";
    private static final String SINSEIYMD = "sinseiymd";
    private static final String KETEIYMD = "keteiymd";
    private static final String ZENKAIKAIGO = "zenkaikaigo";
    private static final String KIJUNRIYOLI = "kijunruyoli";

    @BatchParameter(key = KIJUNRI, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = TAISHONANDU, name = "対象年度")
    private FlexibleYear 対象年度;
    @BatchParameter(key = SINSEIYMD, name = "申請年月日")
    private FlexibleDate 申請年月日;
    @BatchParameter(key = KETEIYMD, name = "決定年月日")
    private FlexibleDate 決定年月日;
    @BatchParameter(key = ZENKAIKAIGO, name = "前回把握時の非該当者")
    private boolean 前回把握時の非該当者;
    @BatchParameter(key = KIJUNRIYOLI, name = "基準日より後に資格喪失した者")
    private boolean 基準日より後に資格喪失した者;

}
