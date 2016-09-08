/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TaishoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TanpyoHakkoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担限度額認定の認定証発行_SQL使用パラメタークラスです.
 *
 * @reamsid_L DBD-3981-050 x_xuliang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class FutanGenndoGakuNinnteiShouMybatisParameter implements IMyBatisParameter {

    private boolean is旧措置者区分_旧措置者;
    private boolean is旧措置者区分_旧措置者以外;
    private boolean is対象区分_決定日;
    private boolean is対象区分_申請日;
    private boolean is年度開始日_非空白;
    private boolean is年度終了日_非空白;
    private boolean is単票発行区分_出力しない;
    private boolean is対象日FROM;
    private boolean is対象日TO;
    private RString 帳票ID;
    private RString 出力順;
    private RString psmShikibetsuTaisho;
    private RString psmAtesaki;
    private final RString 決定区分_承認する;
    private final RString 減免減額種類_負担限度額認定;
    private final RString 旧措置者区分_旧措置者のみ;
    private final RString 旧措置者区分_旧措置者実質的負担軽減者;
    private final RString 空白;
    private final RString 業務コード_介護受給;
    private final RString 発行履歴固有情報_被保番号;
    private final RString 発行履歴固有情報_減免適用開始日;
    private final FlexibleDate 年度開始日;
    private final FlexibleDate 年度終了日;
    private final FlexibleDate 対象日_FROM;
    private final FlexibleDate 対象日_TO;

    /**
     * 負担限度額認定の認定証発行
     *
     * @param 単票発行区分 単票発行区分
     * @param 旧措置者区分 旧措置者区分
     * @param 年度開始日 年度開始日
     * @param 年度終了日 年度終了日
     * @param 対象区分 対象区分
     * @param 対象日FROM 対象日FROM
     * @param 対象日TO 対象日TO
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmAtesaki psmAtesaki
     * @param 出力順 出力順
     * @param 帳票ID 帳票ID
     * @param 発行履歴固有情報_減免適用開始日 発行履歴固有情報_減免適用開始日
     * @param 発行履歴固有情報_被保番号 発行履歴固有情報_被保番号
     */
    public FutanGenndoGakuNinnteiShouMybatisParameter(
            TanpyoHakkoKubun 単票発行区分,
            KyusochishaKubun 旧措置者区分,
            FlexibleDate 年度開始日,
            FlexibleDate 年度終了日,
            TaishoKubun 対象区分,
            FlexibleDate 対象日FROM,
            FlexibleDate 対象日TO,
            RString psmShikibetsuTaisho,
            RString psmAtesaki,
            RString 出力順,
            RString 帳票ID,
            RString 発行履歴固有情報_減免適用開始日,
            RString 発行履歴固有情報_被保番号) {
        this.年度開始日 = 年度開始日;
        this.年度終了日 = 年度終了日;
        this.対象日_FROM = 対象日FROM;
        this.対象日_TO = 対象日TO;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
        this.出力順 = 出力順;
        this.帳票ID = 帳票ID;
        this.決定区分_承認する = KetteiKubun.承認する.getコード();
        this.減免減額種類_負担限度額認定 = GemmenGengakuShurui.負担限度額認定.getコード();
        this.旧措置者区分_旧措置者のみ = KyuSochishaKubun.旧措置者.getコード();
        this.旧措置者区分_旧措置者実質的負担軽減者 = KyuSochishaKubun.旧措置者実質的負担軽減者.getコード();
        this.業務コード_介護受給 = SubGyomuCode.DBD介護受給.value();
        this.発行履歴固有情報_減免適用開始日 = 発行履歴固有情報_減免適用開始日;
        this.発行履歴固有情報_被保番号 = 発行履歴固有情報_被保番号;
        this.空白 = RString.EMPTY;
        if (KyusochishaKubun.旧措置者.getコード().equals(旧措置者区分.getコード())) {
            is旧措置者区分_旧措置者 = true;
        }
        if (KyusochishaKubun.旧措置者以外.getコード().equals(旧措置者区分.getコード())) {
            is旧措置者区分_旧措置者以外 = true;
        }
        if (TaishoKubun.決定日.getコード().equals(対象区分.getコード())) {
            is対象区分_決定日 = true;
            set対象区分(対象日FROM, 対象日TO);
        }
        if (TaishoKubun.申請日.getコード().equals(対象区分.getコード())) {
            is対象区分_申請日 = true;
            set対象区分(対象日FROM, 対象日TO);
        }
        if (年度開始日 != null && !年度開始日.isEmpty()) {
            is年度開始日_非空白 = true;
        }
        if (年度終了日 != null && !年度開始日.isEmpty()) {
            is年度終了日_非空白 = true;
        }
        if (TanpyoHakkoKubun.出力しない.getコード().equals(単票発行区分.getコード())) {
            is単票発行区分_出力しない = true;
        }
    }

    private void set対象区分(FlexibleDate 対象日FROM,
            FlexibleDate 対象日TO) {
        if (対象日FROM != null) {
            is対象日FROM = true;
        }
        if (対象日TO != null) {
            is対象日TO = true;
        }
    }
}
