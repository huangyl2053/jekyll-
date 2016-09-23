/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dankaibetsushunoritsu;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dankaibetsushunoritsu.PrtDankaibetsuShunoritsuIchiranhyoMybatisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 保険料段階別収納率一覧表作成用ProcessParameterクラスです。
 *
 * @reamsid_L DBB-1630-020 tianshuai
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PrtDankaibetsuShunoritsuIchiranhyoParameter implements IBatchProcessParameter {

    private FlexibleYear 開始調定年度;
    private FlexibleYear 終了調定年度;
    private FlexibleYear 開始賦課年度;
    private FlexibleYear 終了賦課年度;
    private FlexibleYear 会計年度;
    private FlexibleYearMonth 調定基準年月;
    private RString 抽出条件;
    private FlexibleYearMonth 基準年月;
    private RString 生年月日年齢区分;
    private FlexibleDate 開始生年月日;
    private FlexibleDate 終了生年月日;
    private int 開始年齢;
    private int 終了年齢;
    private FlexibleDate 年齢基準日;
    private RString 広域判定区分;
    private RString 選択対象区分;
    private Map<RString, RString> 選択対象リスト;
    private RString 市町村情報;
    private RString 市町村情報名称;
    private RString 旧市町村情報;
    private RString 旧市町村情報名称;
    private List<RString> 完納出力区分;

    /**
     * MYBATIS用パラメータを作成します。
     *
     * @return MYBATIS用パラメータ
     */
    public PrtDankaibetsuShunoritsuIchiranhyoMybatisParamter toMybatisParamter() {
        return new PrtDankaibetsuShunoritsuIchiranhyoMybatisParamter(広域判定区分,
                抽出条件,
                市町村情報);
    }
}
