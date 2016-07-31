/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.KoikiZenShichosonJohoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.SaiHakkoParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT51001_所得照会票一括発行のProcessParameter
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuShokaihyoHakkoProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 処理年度;
    private FlexibleDate 照会年月日;
    private RString 出力対象;
    private boolean テストプリント;
    private List<SaiHakkoParameter> 再発行対象リスト;
    private Long 出力順ID;
    private RString 導入形態コード;
    private List<KoikiZenShichosonJohoParameter> 構成市町村情報リスト;
    private RString 出力順;
    private RString 改頁項目ID;

    /**
     * コンストラクタです。
     *
     * @param 処理年度 FlexibleYear
     * @param 照会年月日 FlexibleDate
     * @param 出力対象 RString
     * @param テストプリント boolean
     * @param 再発行対象リスト List<SaiHakkoParameter>
     * @param 出力順ID Long
     * @param 導入形態コード RString
     * @param 構成市町村情報リスト List<KoikiZenShichosonJohoParameter>
     * @param 出力順 RString
     * @param 改頁項目ID RString
     */
    public ShotokuShokaihyoHakkoProcessParameter(FlexibleYear 処理年度,
            FlexibleDate 照会年月日,
            RString 出力対象,
            boolean テストプリント,
            List<SaiHakkoParameter> 再発行対象リスト,
            Long 出力順ID,
            RString 導入形態コード,
            List<KoikiZenShichosonJohoParameter> 構成市町村情報リスト,
            RString 出力順,
            RString 改頁項目ID) {
        this.処理年度 = 処理年度;
        this.照会年月日 = 照会年月日;
        this.出力対象 = 出力対象;
        this.テストプリント = テストプリント;
        this.再発行対象リスト = 再発行対象リスト;
        this.出力順ID = 出力順ID;
        this.導入形態コード = 導入形態コード;
        this.構成市町村情報リスト = 構成市町村情報リスト;
        this.出力順 = 出力順;
        this.改頁項目ID = 改頁項目ID;
    }

}
