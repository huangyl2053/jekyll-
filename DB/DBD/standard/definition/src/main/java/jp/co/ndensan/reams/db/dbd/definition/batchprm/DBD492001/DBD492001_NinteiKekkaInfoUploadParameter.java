/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD492001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd492001.RendingJieguoLianxieProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定結果連携データ取込バッチパラメータ
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD492001_NinteiKekkaInfoUploadParameter extends BatchParameterBase {

    private static final String TORIKOMIDETAKUBUN = "torikomidetakubun";
    private static final String GAIBUBAITAIKAKUNOPASU = "gaibubaitaikakunopasu";
    private static final String DETARISUTO = "detarisuto";

    @BatchParameter(key = TORIKOMIDETAKUBUN, name = "取込みデータ区分")
    private RString 取込みデータ区分;
    @BatchParameter(key = GAIBUBAITAIKAKUNOPASU, name = "格納パス")
    private RString 格納パス;
    @BatchParameter(key = DETARISUTO, name = "保険者番号リスト")
    private List<RString> 保険者番号リスト;
    @BatchParameter(key = "被保番号リスト", name = "被保番号リスト")
    private List<RString> 被保番号リスト;
    @BatchParameter(key = "認定申請日リスト", name = "認定申請日リスト")
    private List<RString> 認定申請日リスト;
    @BatchParameter(key = "申請区分_申請時_コードリスト", name = "申請区分_申請時_コードリスト")
    private List<RString> 申請区分_申請時_コードリスト;
    @BatchParameter(key = "市町村コード", name = "市町村コード")
    private RString 市町村コード;
    @BatchParameter(key = "市町村名称", name = "市町村名称")
    private RString 市町村名称;
    @BatchParameter(key = "証記載保険者番号", name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @BatchParameter(key = "保険者区分", name = "保険者区分")
    private RString 保険者区分;

    /**
     * toProcessバッチパラメータ。
     *
     * @return RendingJieguoLianxieProcessParameter
     */
    public RendingJieguoLianxieProcessParameter toRendingJieguoLianxieProcessParameter() {
        return new RendingJieguoLianxieProcessParameter(取込みデータ区分, 格納パス, 被保番号リスト, 保険者区分);
    }
}
