/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.dba110010;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者証発行管理簿バッチ処理パラメータークラスです。
 *
 * @reamsid_L DBA-0600-020 zhangguopeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihokenshashoHakkoKanriboProcessParameter implements IBatchProcessParameter {

    private final RString akasihakoumod;
    private final RString siyuturiyokudaysyou;
    private final FlexibleDate koufukayisihi;
    private final FlexibleDate koufusiuryouhi;
    private final FlexibleDate kasyuukayisihi;
    private final FlexibleDate kasyuusiuryouhi;
    private final boolean seyisinjyohoflg;
    private final boolean renbanfukaflg;
    private final boolean koumukumeyifukaflg;
    private final boolean hizikehensyuuflg;
    private final List<RString> kofuJiyulist;
    private final List<RString> kaishuJiyulist;
    private final Long syuturyokujunid;
    private final long jobId;

    /**
     * 非公開コンストラクタです。
     *
     * @param 証発行モード RString
     * @param 交付開始日 FlexibleDate
     * @param 交付終了日 FlexibleDate
     * @param 回収開始日 FlexibleDate
     * @param 回収終了日 FlexibleDate
     * @param 最新情報フラグ boolean
     * @param 連番付加フラグ boolean
     * @param 項目名付加フラグ boolean
     * @param 日付編集フラグ boolean
     * @param 交付事由 List<RString>
     * @param 回収事由 List<RString>
     * @param 出力順ID RString
     * @param 出力対象 RString
     * @param jobId ジョブID
     */
    private HihokenshashoHakkoKanriboProcessParameter(
            RString 証発行モード,
            RString 出力対象,
            FlexibleDate 交付開始日,
            FlexibleDate 交付終了日,
            FlexibleDate 回収開始日,
            FlexibleDate 回収終了日,
            boolean 最新情報フラグ,
            boolean 連番付加フラグ,
            boolean 項目名付加フラグ,
            boolean 日付編集フラグ,
            List<RString> 交付事由,
            List<RString> 回収事由,
            Long 出力順ID,
            long jobId
    ) {
        this.akasihakoumod = 証発行モード;
        this.siyuturiyokudaysyou = 出力対象;
        this.koufukayisihi = 交付開始日;
        this.koufusiuryouhi = 交付終了日;
        this.kasyuukayisihi = 回収開始日;
        this.kasyuusiuryouhi = 回収終了日;
        this.seyisinjyohoflg = 最新情報フラグ;
        this.renbanfukaflg = 連番付加フラグ;
        this.koumukumeyifukaflg = 項目名付加フラグ;
        this.hizikehensyuuflg = 日付編集フラグ;
        this.kofuJiyulist = 交付事由;
        this.kaishuJiyulist = 回収事由;
        this.syuturyokujunid = 出力順ID;
        this.jobId = jobId;
    }

    /**
     * 被保険者証発行管理簿バッチ処理パラメータークラス作成
     *
     * @param 証発行モード RString
     * @param 交付開始日 FlexibleDate
     * @param 交付終了日 FlexibleDate
     * @param 回収開始日 FlexibleDate
     * @param 回収終了日 FlexibleDate
     * @param 最新情報フラグ boolean
     * @param 連番付加フラグ boolean
     * @param 項目名付加フラグ boolean
     * @param 日付編集フラグ boolean
     * @param 交付事由 List<RString>
     * @param 回収事由 List<RString>
     * @param 出力順ID RString
     * @param 出力対象 RString
     * @param jobId long
     * @return 被保険者証発行管理簿バッチ処理パラメータークラス
     */
    public static HihokenshashoHakkoKanriboProcessParameter processParameter(
            RString 証発行モード,
            RString 出力対象,
            FlexibleDate 交付開始日,
            FlexibleDate 交付終了日,
            FlexibleDate 回収開始日,
            FlexibleDate 回収終了日,
            boolean 最新情報フラグ,
            boolean 連番付加フラグ,
            boolean 項目名付加フラグ,
            boolean 日付編集フラグ,
            List<RString> 交付事由,
            List<RString> 回収事由,
            Long 出力順ID,
            long jobId) {

        return new HihokenshashoHakkoKanriboProcessParameter(
                証発行モード,
                出力対象,
                交付開始日,
                交付終了日,
                回収開始日,
                回収終了日,
                最新情報フラグ,
                連番付加フラグ,
                項目名付加フラグ,
                日付編集フラグ,
                交付事由,
                回収事由,
                出力順ID,
                jobId
        );
    }
}
