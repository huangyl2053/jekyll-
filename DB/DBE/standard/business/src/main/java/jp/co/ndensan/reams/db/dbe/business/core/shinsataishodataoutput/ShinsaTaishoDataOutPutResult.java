/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsataishodataoutput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput.ShinsaTaishoDataOutPutProcessParammeter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 認定審査会割当委員情報（モバイル）CSVEntity設定のビジネスです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
public class ShinsaTaishoDataOutPutResult {

    /**
     * 出力件数を取得するメソッドです。
     *
     * @param 出力件数 出力件数
     * @return RString
     */
    public RString get出力件数(Decimal 出力件数) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
        return builder.toRString();
    }

    /**
     * 出力条件を作成するメソッドです。
     *
     * @param processParamter processParamter
     * @return List<RString> 出力条件List
     */
    public List<RString> get出力条件(ShinsaTaishoDataOutPutProcessParammeter processParamter) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(new RString("【開催番号】"));
        jokenBuilder.append(processParamter.getKaisaiBangou());
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }
}
