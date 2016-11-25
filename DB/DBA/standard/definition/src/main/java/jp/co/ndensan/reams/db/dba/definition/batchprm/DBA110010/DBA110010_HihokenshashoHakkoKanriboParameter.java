/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.DBA110010;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba110010.HihokenshashoHakkoKanriboProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 被保険者証発行管理簿_バッチ用のパラメータです。
 *
 * @reamsid_L DBA-0600-020 zhangguopeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class DBA110010_HihokenshashoHakkoKanriboParameter extends BatchParameterBase {

    private static final String AKASIHAKOU_MOD = "akasihakoumod";
    private static final String SIYUTURIYOKU_TAYSYOU = "siyuturiyokudaysyou";
    private static final String KOUFU_KAYISIHI = "koufukayisihi";
    private static final String KOUFU_SIURYOUHI = "koufusiuryouhi";
    private static final String KASYUU_KAYISIHI = "kasyuukayisihi";
    private static final String KASYUU_SIURYOUHI = "kasyuusiuryouhi";
    private static final String SEYISIN_JYOHO_FLG = "seyisinjyohoflg";
    private static final String RENBAN_FUKA_FLG = "renbanfukaflg";
    private static final String KOUMUKUMEYI_FUKA_FLG = "koumukumeyifukaflg";
    private static final String HIZIKE_HENSYUU_FLG = "hizikehensyuuflg";
    private static final String KAYUU_JIYUU_LIST = "kayuujiyuulist";
    private static final String KASYUU_JIYUU_LIST = "kasyuujiyuulist";
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
    @BatchParameter(key = SEYISIN_JYOHO_FLG, name = "最新情報フラグ")
    private boolean seyisinjyohoflg;
    @BatchParameter(key = RENBAN_FUKA_FLG, name = "連番付加フラグ")
    private boolean renbanfukaflg;
    @BatchParameter(key = KOUMUKUMEYI_FUKA_FLG, name = "項目名付加フラグ")
    private boolean koumukumeyifukaflg;
    @BatchParameter(key = HIZIKE_HENSYUU_FLG, name = "日付編集フラグ")
    private boolean hizikehensyuuflg;
    @BatchParameter(key = KAYUU_JIYUU_LIST, name = "交付事由List")
    private List<RString> kayuujiyuulist;
    @BatchParameter(key = KASYUU_JIYUU_LIST, name = "回収事由List")
    private List<RString> kasyuujiyuulist;
    @BatchParameter(key = SYUTURYOKUJUN_ID, name = "出力順ID")
    private Long syuturyokujunid;

    /**
     * 被保険者証発行管理簿_バッチ用のパラメータラス作成
     *
     * @param jobId ジョブID
     * @return 被保険者証発行管理簿_バッチ用のパラメータラス
     */
    public HihokenshashoHakkoKanriboProcessParameter toAkasiHakouKanriProcessParameter(long jobId) {
        return HihokenshashoHakkoKanriboProcessParameter.processParameter(
                this.akasihakoumod,
                this.siyuturiyokudaysyou,
                this.koufukayisihi,
                this.koufusiuryouhi,
                this.kasyuukayisihi,
                this.kasyuusiuryouhi,
                this.seyisinjyohoflg,
                this.renbanfukaflg,
                this.koumukumeyifukaflg,
                this.hizikehensyuuflg,
                this.kayuujiyuulist,
                this.kasyuujiyuulist,
                this.syuturyokujunid,
                jobId
        );
    }
}
