/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100020;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc100020.KaishuriyushoShikyuKetteitsuchishoParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 決定通知書発行のProcessパラメータクラスです。
 *
 * @reamsid_L DBC-2850-030 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaishuriyushoShikyuKetteitsuchishoProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 決定開始日;
    private FlexibleDate 決定終了日;
    private boolean 指定事業者のみフラグ;
    private JigyoshaNo 事業者コード;
    private FlexibleDate 作成日;
    private RString 文書番号;

    /**
     * 住宅改修理由書作成手数料請求取得のパラメータを作成します
     *
     * @return 住宅改修理由書作成手数料請求取得のパラメータ
     */
    public KaishuriyushoShikyuKetteitsuchishoParameter toMybatisPatameter() {
        return new KaishuriyushoShikyuKetteitsuchishoParameter(決定開始日, 決定終了日, 指定事業者のみフラグ, 事業者コード);
    }
}
