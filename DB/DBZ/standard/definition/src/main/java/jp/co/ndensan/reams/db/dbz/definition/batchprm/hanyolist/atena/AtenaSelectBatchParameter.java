/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛名抽出条件の共通バッチパラメータです。
 *
 * @reamsid_L DBA-1610-040 dingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AtenaSelectBatchParameter {

    private static final String AGESELECTKIJUN = "ageSelectKijun";
    private static final String NENREIRANGE = "nenreiRange";
    private static final String NENREIKIJUNBI = "nenreiKijunbi";
    private static final String SEINENGAPPIRANGE = "seinengappiRange";
    private static final String SHICHOSON_CODE = "shichoson_Code";
    private static final String SHICHOSON_MESHO = "shichoson_Mesho";
    private static final String CHIKU_KUBUN = "chiku_Kubun";
    private static final String JUSHO_FROM = "jusho_From";
    private static final String JUSHO_FROMMESHO = "jusho_FromMesho";
    private static final String JUSHO_TO = "jusho_To";
    private static final String JUSHO_TOMESHO = "jusho_ToMesho";
    private static final String GYOSEIKU_FROM = "gyoseiku_From";
    private static final String GYOSEIKU_FROMMESHO = "gyoseiku_FromMesho";
    private static final String GYOSEIKU_TO = "gyoseiku_To";
    private static final String GYOSEIKU_TOMESHO = "gyoseiku_ToMesho";
    private static final String CHIKU1_FROM = "chiku1_From";
    private static final String CHIKU1_FROMMESHO = "chiku1_FromMesho";
    private static final String CHIKU1_TO = "chiku1_To";
    private static final String CHIKU1_TOMESHO = "chiku1_ToMesho";
    private static final String CHIKU2_FROM = "chiku2_From";
    private static final String CHIKU2_FROMMESHO = "chiku2_FromMesho";
    private static final String CHIKU2_TO = "chiku2_To";
    private static final String CHIKU2_TOMESHO = "chiku2_ToMesho";
    private static final String CHIKU3_FROM = "chiku3_From";
    private static final String CHIKU3_FROMMESHO = "chiku3_FromMesho";
    private static final String CHIKU3_TO = "chiku3_To";
    private static final String CHIKU3_TOMESHO = "chiku3_ToMesho";

    @BatchParameter(key = AGESELECTKIJUN, name = "年齢層抽出方法")
    private NenreiSoChushutsuHoho ageSelectKijun;
    @BatchParameter(key = NENREIRANGE, name = "年齢範囲")
    private Range<Decimal> nenreiRange;
    @BatchParameter(key = NENREIKIJUNBI, name = "年齢基準日")
    private RDate nenreiKijunbi;
    @BatchParameter(key = SEINENGAPPIRANGE, name = "生年月日範囲")
    private Range<RDate> seinengappiRange;
    @BatchParameter(key = SHICHOSON_CODE, name = "市町村コード")
    private LasdecCode shichoson_Code;
    @BatchParameter(key = SHICHOSON_MESHO, name = "市町村名称")
    private RString shichoson_Mesho;
    @BatchParameter(key = CHIKU_KUBUN, name = "地区区分")
    private Chiku chiku_Kubun;
    @BatchParameter(key = JUSHO_FROM, name = "町域From")
    private RString jusho_From;
    @BatchParameter(key = JUSHO_FROMMESHO, name = "町域From名称")
    private RString jusho_FromMesho;
    @BatchParameter(key = JUSHO_TO, name = "町域To")
    private RString jusho_To;
    @BatchParameter(key = JUSHO_TOMESHO, name = "町域To名称")
    private RString jusho_ToMesho;
    @BatchParameter(key = GYOSEIKU_FROM, name = "行政区From")
    private RString gyoseiku_From;
    @BatchParameter(key = GYOSEIKU_FROMMESHO, name = "行政区From名称")
    private RString gyoseiku_FromMesho;
    @BatchParameter(key = GYOSEIKU_TO, name = "行政区To")
    private RString gyoseiku_To;
    @BatchParameter(key = GYOSEIKU_TOMESHO, name = "行政区To名称")
    private RString gyoseiku_ToMesho;
    @BatchParameter(key = CHIKU1_FROM, name = "地区１From")
    private RString chiku1_From;
    @BatchParameter(key = CHIKU1_FROMMESHO, name = "地区１From名称")
    private RString chiku1_FromMesho;
    @BatchParameter(key = CHIKU1_TO, name = "地区１To")
    private RString chiku1_To;
    @BatchParameter(key = CHIKU1_TOMESHO, name = "地区１To名称")
    private RString chiku1_ToMesho;
    @BatchParameter(key = CHIKU2_FROM, name = "地区２From")
    private RString chiku2_From;
    @BatchParameter(key = CHIKU2_FROMMESHO, name = "地区２From名称")
    private RString chiku2_FromMesho;
    @BatchParameter(key = CHIKU2_TO, name = "地区２To")
    private RString chiku2_To;
    @BatchParameter(key = CHIKU2_TOMESHO, name = "地区２To名称")
    private RString chiku2_ToMesho;
    @BatchParameter(key = CHIKU3_FROM, name = "地区３From")
    private RString chiku3_From;
    @BatchParameter(key = CHIKU3_FROMMESHO, name = "地区３From名称")
    private RString chiku3_FromMesho;
    @BatchParameter(key = CHIKU3_TO, name = "地区３To")
    private RString chiku3_To;
    @BatchParameter(key = CHIKU3_TOMESHO, name = "地区３To名称")
    private RString chiku3_ToMesho;

}
