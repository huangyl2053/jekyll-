/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 主治医意見書督促状を特定するためのバッチ用パラメータクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenTokusokujoBatchParamter extends BatchParameterBase {

    private static final String IKENSHOSAKUSEIKIGENYMD = "ikenshoSakuseiKigenYMD";
    private static final String IKENSHOSAKUSEITOKUSOKUYMD = "ikenshoSakuseiTokusokuYMD";
    private static final String SHOKISAIHOKENSHANO = "shoKisaiHokenshaNo";
    private static final String SHUJIIIRYOKIKANCODE = "shujiiIryokikanCode";
    private static final String SHUJIICODE = "shujiiCode";
    private static final long serialVersionUID = -7679989107029577591L;

    @BatchParameter(key = IKENSHOSAKUSEIKIGENYMD, name = "基準日")
    private RString ikenshoSakuseiKigenYMD;
    @BatchParameter(key = IKENSHOSAKUSEITOKUSOKUYMD, name = "印刷済対象者")
    private RString ikenshoSakuseiTokusokuYMD;
    @BatchParameter(key = SHOKISAIHOKENSHANO, name = "保険者コード")
    private RString shoKisaiHokenshaNo;
    @BatchParameter(key = SHUJIIIRYOKIKANCODE, name = "主治医医療機関コード")
    private RString shujiiIryokikanCode;
    @BatchParameter(key = SHUJIICODE, name = "主治医コード")
    private RString shujiiCode;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     * @param 印刷済対象者 印刷済対象者
     * @param 保険者コード 保険者コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     */
    public ShujiiIkenTokusokujoBatchParamter(
            RString 基準日,
            RString 印刷済対象者,
            RString 保険者コード,
            RString 主治医医療機関コード,
            RString 主治医コード) {
        this.ikenshoSakuseiKigenYMD = 基準日;
        this.ikenshoSakuseiTokusokuYMD = 印刷済対象者;
        this.shoKisaiHokenshaNo = 保険者コード;
        this.shujiiIryokikanCode = 主治医医療機関コード;
        this.shujiiCode = 主治医コード;
    }
}
