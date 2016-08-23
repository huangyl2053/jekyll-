/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TanpyoHakkoKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.ShakaiFukushiHoujinnKeigenListMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人軽減確認証・決定通知書発行一覧表発行_processパラメタークラスです.
 *
 * @reamsid_L DBD-3981-030 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShakaiFukushiHoujinnKeigenListProcessParameter implements IBatchProcessParameter {

    private TanpyoHakkoKubun 単票発行区分;
    private FlexibleDate 年度開始日;
    private FlexibleDate 年度終了日;
    private FlexibleDate 決定日FROM;
    private FlexibleDate 決定日TO;
    private boolean 認定証発行フラグ;
    private FlexibleDate 認定証の交付日;
    private boolean 通知書発行フラグ;
    private FlexibleDate 通知書の発行日;
    private Long 改頁出力順ID;

    /**
     * 社会福祉法人軽減確認証・決定通知書発行一覧の引数を返します。
     *
     * @param 単票発行区分 単票発行区分
     * @param 年度開始日 年度開始日
     * @param 年度終了日 年度終了日
     * @param 決定日FROM 対象日FROM
     * @param 決定日TO 対象日TO
     * @param 認定証発行フラグ 認定証発行フラグ
     * @param 認定証の交付日 認定証の交付日
     * @param 通知書発行フラグ 通知書発行フラグ
     * @param 通知書の発行日 通知書の発行日
     * @param 改頁出力順ID 改頁出力順ID
     */
    public ShakaiFukushiHoujinnKeigenListProcessParameter(TanpyoHakkoKubun 単票発行区分, FlexibleDate 年度開始日,
            FlexibleDate 年度終了日, FlexibleDate 決定日FROM, FlexibleDate 決定日TO, boolean 認定証発行フラグ, FlexibleDate 認定証の交付日,
            boolean 通知書発行フラグ,
            FlexibleDate 通知書の発行日, Long 改頁出力順ID) {
        this.単票発行区分 = 単票発行区分;
        this.年度開始日 = 年度開始日;
        this.年度終了日 = 年度終了日;
        this.決定日FROM = 決定日FROM;
        this.決定日TO = 決定日TO;
        this.認定証発行フラグ = 認定証発行フラグ;
        this.認定証の交付日 = 認定証の交付日;
        this.通知書発行フラグ = 通知書発行フラグ;
        this.通知書の発行日 = 通知書の発行日;
        this.改頁出力順ID = 改頁出力順ID;
    }

    /**
     * 非課税年金対象者情報_該当一覧の引数を返します。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 出力順 出力順
     * @return 非課税年金対象者情報_該当一覧
     */
    public ShakaiFukushiHoujinnKeigenListMybatisParameter toShakaiFukushiHoujinnKeigenListMybatisParameter(RString psmShikibetsuTaisho, RString 出力順) {
        return new ShakaiFukushiHoujinnKeigenListMybatisParameter(psmShikibetsuTaisho, 出力順);
    }
}
