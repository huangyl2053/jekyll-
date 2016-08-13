/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5320001;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5320001.TsutishoMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定結果通知書発行_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBD-1430-020 lit
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiKekkaTsutishoProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 発行日;
    private Boolean 単票発行済み;
    private RString 出力順;
    private RString 文書番号;
    private FlexibleDate 開始日;
    private FlexibleDate 終了日;
    private RTime 開始日時;
    private RTime 終了日時;
    private IShikibetsuTaishoPSMSearchKey searchKey;

    /**
     * コンストラクスです。
     *
     * @param 発行日 発行日
     * @param 単票発行済み 単票発行済み
     * @param 出力順 出力順
     * @param 文書番号 文書番号
     * @param 開始日 FlexibleDate
     * @param 終了日 FlexibleDate
     * @param 開始日時 RTime
     * @param 終了日時 RTime
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public NinteiKekkaTsutishoProcessParameter(FlexibleDate 発行日, Boolean 単票発行済み,
            RString 出力順, RString 文書番号,
            FlexibleDate 開始日, FlexibleDate 終了日,
            RTime 開始日時, RTime 終了日時,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        this.発行日 = 発行日;
        this.単票発行済み = 単票発行済み;
        this.出力順 = 出力順;
        this.文書番号 = 文書番号;
        this.開始日 = 開始日;
        this.終了日 = 終了日;
        this.開始日時 = 開始日時;
        this.終了日時 = 終了日時;
        this.searchKey = searchKey;
    }

    /**
     * MybatisParameterを取得する。
     *
     * @return MybatisParameter
     */
    public TsutishoMybatisParameter toTsutishoMybatisParameter() {
        return new TsutishoMybatisParameter(searchKey, 発行日, 単票発行済み, 出力順);
    }
}
