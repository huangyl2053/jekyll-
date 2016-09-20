/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd571001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd571001.IdoChushutsuDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者台帳のバッチパラメータクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD571001Parameter extends BatchParameterBase {

    private static final String CHUSHUTSUJYOHENSETEIKUBUN = "chushutsuJyohenSeteiKubun";
    private static final String HIHOKENSHANOFROM = "hihokenshaNoFrom";
    private static final String HIHOKENSHANOTO = "hihokenshaNoTo";
    private static final String KONKAICHUSHUTSUYMDFROM = "konkaiChushutsuYMDFrom";
    private static final String KONKAICHUSHUTSUTIMEFROM = "konkaiChushutsuTimeFrom";
    private static final String KONKAICHUSHUTSUYMDTO = "konkaiChushutsuYMDTo";
    private static final String KONKAICHUSHUTSUTIMETO = "konkaiChushutsuTimeTo";
    private static final String IDOUCHUSHUTSUTAISHOU = "idouChushutsuTaishou";
    private static final String SHUTSURYOKUOPTION = "shutsuryokuOption";
    private static final String SHUTSURYOKUJUNSETEI = "shutsuryokujunSetei";
    private static final String SHICHOSONCODE = "shichosonCode";
    @BatchParameter(key = "CHUSHUTSUJYOHENSETEIKUBUN", name = "抽出条件設定区分")
    private RString chushutsuJyohenSeteiKubun;
    @BatchParameter(key = "HIHOKENSHANOFROM", name = "被保険者番号（From）")
    private HihokenshaNo hihokenshaNoFrom;
    @BatchParameter(key = "HIHOKENSHANOTO", name = "被保険者番号（To）")
    private HihokenshaNo hihokenshaNoTo;
    @BatchParameter(key = "KONKAICHUSHUTSUYMDFROM", name = "今回抽出開始年月日")
    private RDate konkaiChushutsuYMDFrom;
    @BatchParameter(key = "KONKAICHUSHUTSUTIMEFROM", name = "今回抽出開始時分秒")
    private RTime konkaiChushutsuTimeFrom;
    @BatchParameter(key = "KONKAICHUSHUTSUYMDTO", name = "今回抽出終了年月日")
    private RDate konkaiChushutsuYMDTo;
    @BatchParameter(key = "KONKAICHUSHUTSUTIMETO", name = "今回抽出終了時分秒")
    private RTime konkaiChushutsuTimeTo;
    @BatchParameter(key = "IDOUCHUSHUTSUTAISHOU", name = "異動抽出対象リスト")
    private List<RString> idouChushutsuTaishou;
    @BatchParameter(key = "SHUTSURYOKUOPTION", name = "出力オプション区分")
    private RString shutsuryokuOption;
    @BatchParameter(key = "SHUTSURYOKUJUNSETEI", name = "出力順設定リスト")
    private RString shutsuryokujunSetei;
    @BatchParameter(key = "SHICHOSONCODE", name = "市町村コード")
    private RString shichosonCode;

    /**
     * バーチのパラメータを作成します。
     *
     * @return IdoChushutsuDaichoProcessParameter
     */
    public IdoChushutsuDaichoProcessParameter toIdoChushutsuDaichoProcessParameter() {
        return new IdoChushutsuDaichoProcessParameter(
                chushutsuJyohenSeteiKubun,
                hihokenshaNoFrom,
                hihokenshaNoTo,
                konkaiChushutsuYMDFrom,
                konkaiChushutsuTimeFrom,
                konkaiChushutsuYMDTo,
                konkaiChushutsuTimeTo,
                idouChushutsuTaishou,
                shutsuryokuOption,
                shutsuryokujunSetei,
                shichosonCode);
    }
}
