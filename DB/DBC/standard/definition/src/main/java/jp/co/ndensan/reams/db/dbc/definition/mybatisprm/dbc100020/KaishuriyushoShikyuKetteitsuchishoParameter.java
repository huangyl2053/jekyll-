/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc100020;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 住宅改修理由書作成手数料請求取得のパラメータです。
 *
 * @reamsid_L DBC-2850-030 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaishuriyushoShikyuKetteitsuchishoParameter implements IMyBatisParameter {

    private FlexibleDate 決定開始日;
    private FlexibleDate 決定終了日;
    private boolean 指定事業者のみフラグ;
    private JigyoshaNo 事業者コード;

    /**
     * ンストラクタです。
     *
     * @param 決定開始日 決定開始日
     * @param 決定終了日 決定終了日
     * @param 指定事業者のみフラグ 指定事業者のみフラグ
     * @param 事業者コード 事業者コード
     */
    public KaishuriyushoShikyuKetteitsuchishoParameter(FlexibleDate 決定開始日, FlexibleDate 決定終了日, boolean 指定事業者のみフラグ, JigyoshaNo 事業者コード) {
        this.決定開始日 = 決定開始日;
        this.決定終了日 = 決定終了日;
        this.指定事業者のみフラグ = 指定事業者のみフラグ;
        this.事業者コード = 事業者コード;
    }
}
