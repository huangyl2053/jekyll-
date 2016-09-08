/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TaishoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TanpyoHakkoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担限度額認定の通知書発行_SQL使用パラメタークラスです.
 *
 * @reamsid_L DBD-3981-050 x_miaocl
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class FutanGenndoGakuNinnteiTsuuchishoMybatisParameter implements IMyBatisParameter {

    private FlexibleDate 年度開始日;
    private FlexibleDate 年度終了日;
    private FlexibleDate 対象日FROM;
    private FlexibleDate 対象日TO;
    private RString 旧措置者;
    private RString 負担限度額認定;
    private boolean is旧措置者区分_旧措置者のみ;
    private boolean is旧措置者区分_旧措置者以外;
    private boolean is対象区分_決定日;
    private boolean is対象区分_申請日;
    private boolean is年度開始日_不空白;
    private boolean is年度終了日_不空白;
    private boolean is単票発行区分_出力しない;
    private RString 旧措置者実質的負担軽減者;
    private RString psmShikibetsuTaisho;
    private RString psmAtesaki;
    private RString 出力順;
    private RString 非該当;
    private RString 被保番号;
    private RString 業務コード_介護受給;
    private RString 減免適用開始日;
    private RString 発行履歴固有情報_被保番号;
    private RString 発行履歴固有情報_減免適用開始日;
    private ReportId 帳票ID;

    /**
     * 負担限度額認定の通知書発行の引数を返します。
     *
     * @param 出力順 出力順
     * @param 旧措置者区分 旧措置者区分
     * @param 対象区分 対象区分
     * @param 年度開始日 年度開始日
     * @param 年度終了日 年度終了日
     * @param 単票発行区分 単票発行区分
     */
    /**
     * 負担限度額認定の通知書発行の引数を返します。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmAtesaki psmAtesaki
     * @param 出力順 出力順
     * @param 旧措置者区分 旧措置者区分
     * @param 対象区分 対象区分
     * @param 年度開始日 年度開始日
     * @param 年度終了日 年度終了日
     * @param 単票発行区分 単票発行区分
     * @param 対象日FROM 対象日FROM
     * @param 対象日TO 対象日TO
     * @param 被保番号 被保番号
     * @param 減免適用開始日 減免適用開始日
     * @param 帳票ID 帳票ID
     * @param 発行履歴固有情報_減免適用開始日 発行履歴固有情報_減免適用開始日
     * @param 発行履歴固有情報_被保番号 発行履歴固有情報_被保番号
     */
    public FutanGenndoGakuNinnteiTsuuchishoMybatisParameter(RString psmShikibetsuTaisho,
            RString psmAtesaki,
            RString 出力順,
            KyusochishaKubun 旧措置者区分, TaishoKubun 対象区分, FlexibleDate 年度開始日, FlexibleDate 年度終了日, TanpyoHakkoKubun 単票発行区分,
            FlexibleDate 対象日FROM,
            FlexibleDate 対象日TO,
            RString 被保番号,
            RString 減免適用開始日,
            ReportId 帳票ID,
            RString 発行履歴固有情報_減免適用開始日,
            RString 発行履歴固有情報_被保番号) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
        this.出力順 = 出力順;
        this.対象日FROM = 対象日FROM;
        this.対象日TO = 対象日TO;
        this.被保番号 = 被保番号;
        this.減免適用開始日 = 減免適用開始日;
        this.帳票ID = 帳票ID;
        this.業務コード_介護受給 = SubGyomuCode.DBD介護受給.value();
        this.旧措置者 = KyuSochishaKubun.旧措置者.getコード();
        this.発行履歴固有情報_減免適用開始日 = 発行履歴固有情報_減免適用開始日;
        this.発行履歴固有情報_被保番号 = 発行履歴固有情報_被保番号;

        edit旧措置者区分_バッチ(旧措置者区分);
        edit対象区分(対象区分);
        edit年度開始日(年度開始日);
        edit年度終了日(年度終了日);
        edit減免減額種類();
        edit旧措置者実質的負担軽減者();
        edit旧措置者区分_非該当();
        editis単票発行区分_出力しない(単票発行区分);
    }

    private void edit旧措置者区分_バッチ(KyusochishaKubun 旧措置者区分) {
        if (KyusochishaKubun.旧措置者.getコード().equals(旧措置者区分.getコード())) {
            is旧措置者区分_旧措置者のみ = true;
        }
        if (KyusochishaKubun.旧措置者以外.getコード().equals(旧措置者区分.getコード())) {
            is旧措置者区分_旧措置者以外 = true;
        }
    }

    private void edit対象区分(TaishoKubun 対象区分) {
        if (TaishoKubun.決定日.getコード().equals(対象区分.getコード())) {
            is対象区分_決定日 = true;
        }

        if (TaishoKubun.申請日.getコード().equals(対象区分.getコード())) {
            is対象区分_申請日 = true;
        }
    }

    private void edit年度開始日(FlexibleDate 年度開始日) {
        if (年度開始日 != null && !年度開始日.isEmpty()) {
            is年度開始日_不空白 = true;
            this.年度開始日 = 年度開始日;
        }
    }

    private void edit年度終了日(FlexibleDate 年度終了日) {
        if (年度終了日 != null && !年度終了日.isEmpty()) {
            is年度終了日_不空白 = true;
            this.年度終了日 = 年度終了日;
        }
    }

    private void edit減免減額種類() {
        負担限度額認定 = GemmenGengakuShurui.負担限度額認定.getコード();
    }

    private void edit旧措置者実質的負担軽減者() {
        旧措置者実質的負担軽減者 = KyuSochishaKubun.旧措置者実質的負担軽減者.getコード();
    }

    private void edit旧措置者区分_非該当() {
        非該当 = KyuSochishaKubun.非該当.getコード();
    }

    private void editis単票発行区分_出力しない(TanpyoHakkoKubun 単票発行区分) {
        if (TanpyoHakkoKubun.出力しない.getコード().equals(単票発行区分.getコード())) {
            is単票発行区分_出力しない = true;
        }
    }

}
