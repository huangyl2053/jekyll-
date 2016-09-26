/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD492001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.DBD492001.RendingJieguoLianxieProcessParameter;
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
    private static final String HOKENSHA = "hokensha";

    @BatchParameter(key = TORIKOMIDETAKUBUN, name = "取込みデータ区分")
    private RString 取込みデータ区分;
    @BatchParameter(key = GAIBUBAITAIKAKUNOPASU, name = "外部媒体格納パス")
    private RString 外部媒体格納パス;
    @BatchParameter(key = DETARISUTO, name = "データリスト")
    private List<RString> データリスト;
    @BatchParameter(key = HOKENSHA, name = "保険者")
    private RString 保険者;

    /**
     * 対象者管理情報登録_process処理のパラメターを取得します。
     *
     * @return TaishoShaKanriJohoProcessParameter
     */
    public RendingJieguoLianxieProcessParameter toRendingJieguoLianxieProcessParameter() {
        return new RendingJieguoLianxieProcessParameter(
                取込みデータ区分,
                外部媒体格納パス,
                データリスト,
                保険者);
    }
}
