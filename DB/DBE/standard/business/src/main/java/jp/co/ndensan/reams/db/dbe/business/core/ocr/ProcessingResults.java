/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 複数の{@link IProcessingResult}を保持します。
 */
public final class ProcessingResults {

    private final List<IProcessingResult> list;
    private boolean hasErrorFlag;

    /**
     * インスタンスを生成します。
     */
    public ProcessingResults() {
        list = new ArrayList<>();
        hasErrorFlag = false;
    }

    /**
     * @param pr 追加する{@link IProcessingResult}
     * @return 追加した{@link IProcessingResult}
     */
    public boolean add(IProcessingResult pr) {
        this.list.add(pr);
        this.hasErrorFlag |= pr.type().isError();
        return true;
    }

    /**
     * @return
     * 保持する要素に{@link IProcessingResult.Type#ERROR ERROR}を含む場合、{@code true}.
     */
    public boolean hasError() {
        return this.hasErrorFlag;
    }

    /**
     * @return 保持する全要素
     */
    public List<IProcessingResult> values() {
        return new ArrayList<>(this.list);
    }

    /**
     * 保持する{@link IProcessingResult}を結合して返します。
     * <p/>
     * {@link IProcessingResult.Type#ERROR ERROR}を含む場合、その{@link IProcessingResult}を返します。
     * {@link IProcessingResult.Type#ERROR ERROR}以外は、全要素の備考を結合し、新たな{@link IProcessingResult}を返します。
     * その際{@link IProcessingResult.Type#WARNING WARNING}を含めば、結果は{@link IProcessingResult.Type#WARNING WARNING}になります。
     * 含まなければ、結果は{@link IProcessingResult.Type#SUCCESS SUCCESS}となります。
     *
     * @return 保持する{@link IProcessingResult}を結合した結果
     */
    public IProcessingResult get() {
        if (hasError()) {
            IProcessingResult error = findErrorFrom(this.list);
            if (error != null) {
                return error;
            }
        }
        RStringBuilder builder = new RStringBuilder();
        boolean hasWarning = false;
        for (IProcessingResult pr : this.list) {
            hasWarning |= pr.type().isWarning();
            if (builder.length() != 0) {
                builder.append(";");
            }
            builder.append(pr.note());
        }
        return hasWarning ? ProcessingResultFactory.warning(builder.toRString())
                : ProcessingResultFactory.success(builder.toRString());
    }

    private static IProcessingResult findErrorFrom(List<IProcessingResult> list) {
        for (IProcessingResult pr : list) {
            if (pr.type().isError()) {
                return pr;
            }
        }
        return null;
    }
}
