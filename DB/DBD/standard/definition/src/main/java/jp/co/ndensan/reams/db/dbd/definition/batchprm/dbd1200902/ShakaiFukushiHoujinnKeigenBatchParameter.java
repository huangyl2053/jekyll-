/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd1200902;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TanpyoHakkoKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902.ShakaiFukushiHoujinnKeigenListProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902.ShakaiFukushiHoujinnKeigenNinnteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902.ShakaiFukushiHoujinnKeigenTsuuchishoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人等利用者負担額軽減確認証・通知書一括発行フローバッチパラメタークラスです．
 *
 * @reamsid_L DBD-3981-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShakaiFukushiHoujinnKeigenBatchParameter extends BatchParameterBase {

    private static final String TANPYOHAKKOKUBUN = "tanpyoHakkoKubun";
    private static final String STARTYMD = "startYMD";
    private static final String ENDYMD = "endYMD";
    private static final String TAISHOFROM = "taishoFrom";
    private static final String TAISHOTO = "taishoTo";
    private static final String NINNTEIPUBLISHFLG = "ninnteiPublishFlg";
    private static final String NINNTEICOMYMD = "ninnteiComYMD";
    private static final String TSUUCHISHOPUBLISHFLG = "tsuuchishoPublishFlg";
    private static final String TSUUCHISHOCOMYMD = "tsuuchishoComYMD";
    private static final String TSUCHISHONO = "tsuchishoNo";
    private static final String CHANGEPAGEID = "changePageID";

    @BatchParameter(key = TANPYOHAKKOKUBUN, name = "単票発行区分")
    private TanpyoHakkoKubun 単票発行区分;
    @BatchParameter(key = STARTYMD, name = "年度開始日")
    private FlexibleDate 年度開始日;
    @BatchParameter(key = ENDYMD, name = "年度終了日")
    private FlexibleDate 年度終了日;
    @BatchParameter(key = TAISHOFROM, name = "対象日FROM")
    private FlexibleDate 対象日FROM;
    @BatchParameter(key = TAISHOTO, name = "対象日TO")
    private FlexibleDate 対象日TO;
    @BatchParameter(key = NINNTEIPUBLISHFLG, name = "認定証発行フラグ")
    private boolean 認定証発行フラグ;
    @BatchParameter(key = NINNTEICOMYMD, name = "認定証の交付日")
    private FlexibleDate 認定証の交付日;
    @BatchParameter(key = TSUUCHISHOPUBLISHFLG, name = "通知書発行フラグ")
    private boolean 通知書発行フラグ;
    @BatchParameter(key = TSUUCHISHOCOMYMD, name = "通知書の発行日")
    private FlexibleDate 通知書の発行日;
    @BatchParameter(key = TSUCHISHONO, name = "通知書の文書番号")
    private RString 通知書の文書番号;
    @BatchParameter(key = CHANGEPAGEID, name = "改頁出力順ID")
    private Long 改頁出力順ID;

    /**
     * 社会福祉法人軽減確認証・決定通知書発行一覧表発行_processパラメターを取得します．
     *
     * @return 社会福祉法人軽減確認証・決定通知書発行一覧表発行_processパラメター
     */
    public ShakaiFukushiHoujinnKeigenListProcessParameter toShakaiFukushiHoujinnKeigenListProcessParameter() {
        return new ShakaiFukushiHoujinnKeigenListProcessParameter(単票発行区分, 年度開始日,
                年度終了日, 対象日FROM, 対象日TO, 認定証発行フラグ, 認定証の交付日,
                通知書発行フラグ,
                通知書の発行日, 改頁出力順ID);
    }

    /**
     * 社会福祉法人等軽減の認定証発行_processパラメターを取得します．
     *
     * @return 社会福祉法人等軽減の認定証発行_processパラメター
     */
    public ShakaiFukushiHoujinnKeigenNinnteiProcessParameter toShakaiFukushiHoujinnKeigenNinnteiProcessParameter() {
        return new ShakaiFukushiHoujinnKeigenNinnteiProcessParameter(単票発行区分,
                年度開始日,
                年度終了日,
                対象日FROM,
                対象日TO,
                認定証の交付日,
                改頁出力順ID);
    }

    /**
     * 社会福祉法人等軽減の通知書発行_processパラメターを取得します．
     *
     * @return 社会福祉法人等軽減の通知書発行_processパラメター
     */
    public ShakaiFukushiHoujinnKeigenTsuuchishoProcessParameter toShakaiFukushiHoujinnKeigenTsuuchishoProcessParameter() {
        return new ShakaiFukushiHoujinnKeigenTsuuchishoProcessParameter(単票発行区分,
                年度開始日,
                年度終了日,
                対象日FROM,
                対象日TO,
                通知書の発行日,
                通知書の文書番号,
                改頁出力順ID
        );
    }
}
