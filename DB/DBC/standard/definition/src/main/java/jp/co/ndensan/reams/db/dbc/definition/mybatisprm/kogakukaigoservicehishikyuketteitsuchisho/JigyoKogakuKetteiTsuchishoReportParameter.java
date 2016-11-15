/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 高額サービス費支給（不支給）決定通知書作成の帳票出力用のパラメータです
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoKogakuKetteiTsuchishoReportParameter extends _JigyoKogakuKetteiTsuchishoReportParameter implements IMyBatisParameter {

    private RString 出力順;
    private RString 支払方法抽出区分;

    /**
     * コンストラクタです。
     *
     * @param 出力順 RString
     * @param 支払方法抽出区分 RString
     * @param kozaSearchKey 口座検索用の検索キークラス
     * @param list 科目コードリスト
     * @param atesakiPSMSearchKey 宛先検索用の検索キークラス
     * @param shikibetsuTaishoPSMSearchKey 宛名検索用の検索キークラス
     */
    public JigyoKogakuKetteiTsuchishoReportParameter(RString 出力順, RString 支払方法抽出区分, IKozaSearchKey kozaSearchKey, List<KamokuCode> list,
            IAtesakiPSMSearchKey atesakiPSMSearchKey, IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey) {
        super(kozaSearchKey, atesakiPSMSearchKey, list, shikibetsuTaishoPSMSearchKey);
        this.出力順 = 出力順;
        this.支払方法抽出区分 = 支払方法抽出区分;
    }

}
