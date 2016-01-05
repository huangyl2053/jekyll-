/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.hihokenshashohakkokanribo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.processprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 被保険者証発行管理簿_バッチ用のパラメータです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihokenshashoHakkoKanriboBatchParameter extends BatchParameterBase {

    /**
     * 証発行モードです。
     */
    private static final String AKASIHAKOU_MOD = "akasihakoumod";
    /**
     * 出力対象です。
     */
    private static final String SIYUTURIYOKU_TAYSYOU = "siyuturiyokudaysyou";
    /**
     * 交付開始日です。
     */
    private static final String KOUFU_KAYISIHI = "koufukayisihi";
    /**
     * 交付終了日です。
     */
    private static final String KOUFU_SIURYOUHI = "koufusiuryouhi";
    /**
     * 回収開始日です。
     */
    private static final String KASYUU_KAYISIHI = "kasyuukayisihi";
    /**
     * 回収終了日です。
     */
    private static final String KASYUU_SIURYOUHI = "kasyuusiuryouhi";
    /**
     * 発行管理リストフラグです。
     */
    private static final String HAKOU_KANNRI_RISUTOFLG = "hakoukannririsutoflg";
    /**
     * 最新情報フラグです。
     */
    private static final String SEYISIN_JYOHO_FLG = "seyisinjyohoflg";
    /**
     * すべて選択フラグです。
     */
    private static final String SUBEDE_SENTAKU_FLG = "subedesentakuflg";
    /**
     * 連番付加フラグです。
     */
    private static final String RENBAN_FUKA_FLG = "renbanfukaflg";
    /**
     * 項目名付加フラグです。
     */
    private static final String KOUMUKUMEYI_FUKA_FLG = "koumukumeyifukaflg";
    /**
     * 日付編集フラグです。
     */
    private static final String HIZIKE_HENSYUU_FLG = "hizikehensyuuflg";
    /**
     * 交付事由Listです。
     */
    private static final String KAYUU_JIYUU_LIST = "kayuujiyuulist";
    /**
     * 回収事由Listです。
     */
    private static final String KASYUU_JIYUU_LIST = "kasyuujiyuulist";
    /**
     * 出力順IDです。
     */
    private static final String SYUTURYOKUJUN_ID = "syuturyokujunid";

    @BatchParameter(key = AKASIHAKOU_MOD, name = "証発行モード")
    private RString akasihakoumod;
    @BatchParameter(key = SIYUTURIYOKU_TAYSYOU, name = "出力対象")
    private RString siyuturiyokudaysyou;
    @BatchParameter(key = KOUFU_KAYISIHI, name = "交付開始日")
    private FlexibleDate koufukayisihi;
    @BatchParameter(key = KOUFU_SIURYOUHI, name = "交付終了日")
    private FlexibleDate koufusiuryouhi;
    @BatchParameter(key = KASYUU_KAYISIHI, name = "回収開始日")
    private FlexibleDate kasyuukayisihi;
    @BatchParameter(key = KASYUU_SIURYOUHI, name = "回収終了日")
    private FlexibleDate kasyuusiuryouhi;
    @BatchParameter(key = HAKOU_KANNRI_RISUTOFLG, name = "発行管理リストフラグ")
    private boolean hakoukannririsutoflg;
    @BatchParameter(key = SEYISIN_JYOHO_FLG, name = "最新情報フラグ")
    private boolean seyisinjyohoflg;
    @BatchParameter(key = SUBEDE_SENTAKU_FLG, name = "すべて選択フラグ")
    private boolean subedesentakuflg;
    @BatchParameter(key = RENBAN_FUKA_FLG, name = "連番付加フラグ")
    private boolean renbanfukaflg;
    @BatchParameter(key = KOUMUKUMEYI_FUKA_FLG, name = "項目名付加フラグ")
    private boolean koumukumeyifukaflg;
    @BatchParameter(key = HIZIKE_HENSYUU_FLG, name = "日付編集フラグ")
    private boolean hizikehensyuuflg;
    @BatchParameter(key = KAYUU_JIYUU_LIST, name = "交付事由List")
    private List<UzT0007CodeEntity> kayuujiyuulist;
    @BatchParameter(key = KASYUU_JIYUU_LIST, name = "回収事由List")
    private List<UzT0007CodeEntity> kasyuujiyuulist;
    @BatchParameter(key = SYUTURYOKUJUN_ID, name = "出力順ID")
    private RString syuturyokujunid;

    /**
     * 被保険者証発行管理簿_バッチ用のパラメータラス作成
     *
     * @return 被保険者証発行管理簿_バッチ用のパラメータラス
     */
    public HihokenshashoHakkoKanriboProcessParameter toAkasiHakouKanriProcessParameter() {
        return HihokenshashoHakkoKanriboProcessParameter.ProcessParameter(
                this.akasihakoumod,
                this.siyuturiyokudaysyou,
                this.koufukayisihi,
                this.koufusiuryouhi,
                this.kasyuukayisihi,
                this.kasyuusiuryouhi,
                this.hakoukannririsutoflg,
                this.seyisinjyohoflg,
                this.subedesentakuflg,
                this.renbanfukaflg,
                this.koumukumeyifukaflg,
                this.hizikehensyuuflg,
                this.kayuujiyuulist,
                this.kasyuujiyuulist,
                this.syuturyokujunid);
    }
}
