/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021021;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 保険料段階別収納率一覧表作成のバッチパラメタークラスです。
 *
 * @reamsid_L DBB-1630-010 wangxingpeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter extends BatchParameterBase {

    @BatchParameter(key = "調定年度_開始", name = "調定年度_開始")
    private FlexibleYear 調定年度_開始;
    @BatchParameter(key = "調定年度_終了", name = "調定年度_終了")
    private FlexibleYear 調定年度_終了;
    @BatchParameter(key = "賦課年度_開始", name = "賦課年度_開始")
    private FlexibleYear 賦課年度_開始;
    @BatchParameter(key = "賦課年度_終了", name = "賦課年度_終了")
    private FlexibleYear 賦課年度_終了;
    @BatchParameter(key = "会計年度", name = "会計年度")
    private FlexibleYear 会計年度;
    @BatchParameter(key = "調定基準年月", name = "調定基準年月")
    private FlexibleYearMonth 調定基準年月;
    @BatchParameter(key = "抽出条件", name = "抽出条件")
    private RString 抽出条件;
    @BatchParameter(key = "基準年月", name = "基準年月")
    private FlexibleYearMonth 基準年月;
    @BatchParameter(key = "生年月日年齢区分", name = "生年月日年齢区分")
    private RString 生年月日年齢区分;
    @BatchParameter(key = "生年月日_開始", name = "生年月日_開始")
    private FlexibleDate 生年月日_開始;
    @BatchParameter(key = "生年月日_終了", name = "生年月日_終了")
    private FlexibleDate 生年月日_終了;
    @BatchParameter(key = "年齢_開始", name = "年齢_開始")
    private Decimal 年齢_開始;
    @BatchParameter(key = "年齢_終了", name = "年齢_終了")
    private Decimal 年齢_終了;
    @BatchParameter(key = "年齢基準日", name = "年齢基準日")
    private FlexibleDate 年齢基準日;
    @BatchParameter(key = "広域判定区分", name = "広域判定区分")
    private RString 広域判定区分;
    @BatchParameter(key = "選択対象区分", name = "選択対象区分")
    private RString 選択対象区分;
    @BatchParameter(key = "選択対象リスト", name = "選択対象リスト")
    private Map<RString, RString> 選択対象リスト;
    @BatchParameter(key = "市町村情報", name = "市町村情報")
    private DankaibetsuShunoritsuEntity 市町村情報;
    @BatchParameter(key = "旧市町村情報", name = "旧市町村情報")
    private DankaibetsuShunoritsuEntity 旧市町村情報;
    @BatchParameter(key = "完納出力区分", name = "完納出力区分")
    private List<RString> 完納出力区分;
}
