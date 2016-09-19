/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE309003;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 一次判定データ出力MybitisParamterです。
 *
 * @reamsid_L DBE-1610-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBE309003_IchijihanteiSumidataIfParameter extends BatchParameterBase {

    private static final String SHINSEISHOKANRINOLIST = "shinseishoKanriNoList";
    private static final String JYOKEN = "Jyoken";
    private static final String SHINSEIBIFROM = "ShinseibiFrom";
    private static final String SHINSEIBITO = "ShinseibiTo";
    private static final String ICHIJIHANTEIBIFROM = "IchijiHanteibiFrom";
    private static final String ICHIJIHANTEIBITO = "IchijiHanteibiTo";

    @BatchParameter(key = SHINSEISHOKANRINOLIST, name = "申請書管理番号リスト")
    private List<RString> 申請書管理番号リスト;
    @BatchParameter(key = JYOKEN, name = "日付指定")
    private RString 日付指定;
    @BatchParameter(key = SHINSEIBIFROM, name = "申請日From")
    private RString 申請日From;
    @BatchParameter(key = SHINSEIBITO, name = "申請日To")
    private RString 申請日To;
    @BatchParameter(key = ICHIJIHANTEIBIFROM, name = "一次判定日From")
    private RString 一次判定日From;
    @BatchParameter(key = ICHIJIHANTEIBITO, name = "一次判定日To")
    private RString 一次判定日To;
}
