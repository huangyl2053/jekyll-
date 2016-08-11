/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishokattokami;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaishohakko.FutanwariaishoHakkoProcessParameter;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 出力条件のエヂテクラスです。
 *
 * @reamsid_L DBC-4990-030 pengxingyi
 */
public class FutanWariaiShoOutputJokenhyo {

    private static final RString 年度 = new RString("【年度】　");
    private static final RString 発行区分 = new RString("【発行区分】　");
    private static final RString 出力対象 = new RString("【出力対象】　　");
    private static final RString 交付年月日 = new RString("【交付年月日】　　");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString 未発行 = new RString("未発行");
    private static final RString 発行済み = new RString("発行済み");
    private static final RString 全て = new RString("全て");
    private static final RString 全件 = new RString("全件");
    private static final RString 異動分 = new RString("異動分");
    private static final RString 新規認定分 = new RString("新規認定分s");

    private final FutanwariaishoHakkoProcessParameter parameter;
    private final IOutputOrder 出力順;

    /**
     * インスタンスを生成します。
     *
     * @param parameter parameter
     * @param 出力順 出力順
     */
    public FutanWariaiShoOutputJokenhyo(FutanwariaishoHakkoProcessParameter parameter, IOutputOrder 出力順) {
        this.parameter = parameter;
        this.出力順 = 出力順;
    }

    /**
     * 出力条件取得です。
     *
     * @return List<RString>
     */
    public List<RString> getOutputJokenhyoParam() {
        List<RString> outputJokenhyo = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(年度.concat(parameter.get年度().wareki().toDateString()));
        outputJokenhyo.add(builder.toRString());
        builder = new RStringBuilder();
        RString temp = RString.EMPTY;
        if (ZERO.equals(parameter.get発行区分())) {
            temp = 未発行;
        } else if (ONE.equals(parameter.get発行区分())) {
            temp = 発行済み;
        } else if (TWO.equals(parameter.get発行区分())) {
            temp = 全て;
        }
        builder.append(発行区分.concat(temp));
        outputJokenhyo.add(builder.toRString());
        builder = new RStringBuilder();
        temp = RString.EMPTY;
        if (ZERO.equals(parameter.get出力対象())) {
            temp = 全件;
        } else if (ONE.equals(parameter.get出力対象())) {
            temp = 異動分;
        } else if (TWO.equals(parameter.get出力対象())) {
            temp = 新規認定分;
        }
        builder.append(出力対象.concat(temp));
        outputJokenhyo.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(交付年月日.concat(parameter.get交付年月日().wareki().toDateString()));
        outputJokenhyo.add(builder.toRString());
        if (出力順 != null) {
            builder = new RStringBuilder();
            builder.append(出力順.getFormated出力順名());
            outputJokenhyo.add(builder.toRString());
        }
        return outputJokenhyo;
    }

    /**
     * 出力条件取得です。
     *
     * @return List<RString>
     */
    public List<RString> getDaikoParam() {
        List<RString> outputJokenhyo = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(年度.concat(parameter.get年度().wareki().toDateString()));
        outputJokenhyo.add(builder.toRString());
        builder = new RStringBuilder();
        RString temp = RString.EMPTY;
        if (ZERO.equals(parameter.get発行区分())) {
            temp = 未発行;
        } else if (ONE.equals(parameter.get発行区分())) {
            temp = 発行済み;
        } else if (TWO.equals(parameter.get発行区分())) {
            temp = 全て;
        }
        builder.append(発行区分.concat(temp));
        outputJokenhyo.add(builder.toRString());
        builder = new RStringBuilder();
        temp = RString.EMPTY;
        if (ZERO.equals(parameter.get出力対象())) {
            temp = 全件;
        } else if (ONE.equals(parameter.get出力対象())) {
            temp = 異動分;
        } else if (TWO.equals(parameter.get出力対象())) {
            temp = 新規認定分;
        }
        builder.append(出力対象.concat(temp));
        outputJokenhyo.add(builder.toRString());
        return outputJokenhyo;
    }
}
