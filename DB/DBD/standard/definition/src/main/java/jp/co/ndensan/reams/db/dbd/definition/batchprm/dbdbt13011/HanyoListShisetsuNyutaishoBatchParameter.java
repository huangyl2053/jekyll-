/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdbt13011;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.SoshitsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt13011.GeneralPurposeListOutputProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBDBT13011_汎用リスト出力(施設入退所)バッチパラメタークラスです．
 *
 * @reamsid_L DBD-1570-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListShisetsuNyutaishoBatchParameter extends BatchParameterBase {

    private static final String CHUSHUTSUHOHOKUBUN = "chushutsuHohoKubun";
    private static final String CHUSHUTSUITEMKUBUN = "chushutsuItemKubun";
    private static final String KIJUNYMD = "kijunYMD";
    private static final String HIDUKEHANNIFROM = "hidukeHanniFrom";
    private static final String HIDUKEHANNITO = "hidukeHanniTo";
    private static final String CHOKKINDATACHUSHUTSU = "chokkinDataChushutsu";
    private static final String SOUSITUKUBUN = "sousituKubun";
    private static final String ITEMNAMEFUKA = "itemNameFuka";
    private static final String NOFUKA = "noFuka";
    private static final String HIDUKESYSTEMFUKA = "hidukeSystemFuka";
    private static final String ATENACHUSHUTSUJOUKENN = "atenaChushutsuJoukenn";
    private static final String SHUTURYOKUJUNN = "shuturyokuJunn";
    private static final String SHUTURYOKUITEM = "shuturyokuItem";

    @BatchParameter(key = CHUSHUTSUHOHOKUBUN, name = "抽出方法区分")
    private ChushutsuHohoKubun 抽出方法区分;
    @BatchParameter(key = CHUSHUTSUITEMKUBUN, name = "抽出項目区分")
    private RString 抽出項目区分;
    @BatchParameter(key = KIJUNYMD, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = HIDUKEHANNIFROM, name = "日付範囲From")
    private FlexibleDate 日付範囲From;
    @BatchParameter(key = HIDUKEHANNITO, name = "日付範囲To")
    private FlexibleDate 日付範囲To;
    @BatchParameter(key = CHOKKINDATACHUSHUTSU, name = "直近データ抽出")
    private boolean 直近データ抽出;
    @BatchParameter(key = SOUSITUKUBUN, name = "喪失区分")
    private SoshitsuKubun 喪失区分;
    @BatchParameter(key = ITEMNAMEFUKA, name = "項目名付加")
    private boolean 項目名付加;
    @BatchParameter(key = NOFUKA, name = "連番付加")
    private boolean 連番付加;
    @BatchParameter(key = HIDUKESYSTEMFUKA, name = "日付スラッシュ付加")
    private boolean 日付スラッシュ付加;
    @BatchParameter(key = ATENACHUSHUTSUJOUKENN, name = "宛名抽出条件")
    private AtenaSelectBatchParameter 宛名抽出条件;
    @BatchParameter(key = SHUTURYOKUJUNN, name = "出力順")
    private Long 出力順;
    @BatchParameter(key = SHUTURYOKUITEM, name = "出力項目")
    private RString 出力項目;

    /**
     * バッチProcessパラメターを取得します．
     *
     * @return バッチProcessパラメター情報
     */
    public GeneralPurposeListOutputProcessParameter toGeneralPurposeListOutputProcessParameter() {
        return new GeneralPurposeListOutputProcessParameter(抽出方法区分,
                抽出項目区分,
                基準日,
                日付範囲From,
                日付範囲To,
                直近データ抽出,
                喪失区分,
                項目名付加,
                連番付加,
                日付スラッシュ付加,
                宛名抽出条件,
                出力順,
                出力項目);
    }

}
