/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc100020;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private final RString psmShikibetsuTaisho;
    private RString 出力順;
    private Long 出力順id;
    private LasdecCode 市町村コード;
    private final RString サブ業務コード = new RString("DBC");
    private final RString 処理名 = ShoriName.住宅改修理由書作成手数料支給不支給決定通知書作成.get名称();
    private final RString 処理枝番 = new RString("0000");
    private final FlexibleYear 年度 = new FlexibleYear("0000");
    private final RString 年度内連番 = new RString("0001");

    /**
     * ンストラクタです。
     *
     * @param 決定開始日 決定開始日
     * @param 決定終了日 決定終了日
     * @param 指定事業者のみフラグ 指定事業者のみフラグ
     * @param 事業者コード 事業者コード
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 出力順 出力順
     * @param 市町村コード 市町村コード
     */
    public KaishuriyushoShikyuKetteitsuchishoParameter(FlexibleDate 決定開始日, FlexibleDate 決定終了日,
            boolean 指定事業者のみフラグ, JigyoshaNo 事業者コード, RString 出力順, RString psmShikibetsuTaisho, LasdecCode 市町村コード) {
        this.決定開始日 = 決定開始日;
        this.決定終了日 = 決定終了日;
        this.指定事業者のみフラグ = 指定事業者のみフラグ;
        this.事業者コード = 事業者コード;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.出力順 = 出力順;
        this.市町村コード = 市町村コード;
    }
}
