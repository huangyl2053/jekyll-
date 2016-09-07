/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5610001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5610001.KoshinTaishoshaKanriProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 更新対象者抽出のバッチパラメータクラスです。
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoshinTaishoshaKanriParameter extends BatchParameterBase {

    @BatchParameter(key = "条件指定", name = "条件指定")
    private RString 条件指定;
    @BatchParameter(key = "有効期間終了日From", name = "有効期間終了日")
    private FlexibleDate 有効期間終了日From;
    @BatchParameter(key = "有効期間終了日To", name = "有効期間終了日")
    private FlexibleDate 有効期間終了日To;
    @BatchParameter(key = "対象月", name = "対象月")
    private FlexibleYearMonth 対象月;
    @BatchParameter(key = "市町村コード", name = "市町村コード")
    private LasdecCode 市町村コード;
    @BatchParameter(key = "年度", name = "年度")
    private FlexibleYear 年度;
    @BatchParameter(key = "年度内連番", name = "年度内連番")
    private RString 年度内連番;

    /**
     * Processのパラメータを作成します。
     *
     * @return KoshinTaishoshaKanriProcessParameter
     */
    public KoshinTaishoshaKanriProcessParameter toKoshinTaishoshaKanriProcessParameter() {
        return new KoshinTaishoshaKanriProcessParameter(条件指定, 有効期間終了日From,
                有効期間終了日To, 対象月, 市町村コード, 年度, 年度内連番);
    }
}
