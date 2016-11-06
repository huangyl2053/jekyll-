/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshashohakkokanribo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者証発行管理簿_マッパー用のパラメータです。
 *
 * @reamsid_L DBA-0600-020 zhangguopeng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihokenshashoHakkoKanriboMybatisParameter implements IMyBatisParameter {

    private final RString akasihakouMod;
    private final FlexibleDate koufukayisihi;
    private final FlexibleDate koufusiuryouhi;
    private final FlexibleDate kasyuukayisihi;
    private final FlexibleDate kasyuusiuryouhi;
    private final boolean iskoufukayisihi;
    private final boolean iskoufuShuryouhi;
    private final boolean iskaisyuKayisihi;
    private final boolean iskaisyuShuryouhi;
    private final List<RString> kofuJiyulist;
    private final List<RString> kaishuJiyulist;
    private final RString psmShikibetsuTaisho;
    private final RString 出力順;

    /**
     * 非公開コンストラクタです。
     *
     * @param 証発行モード 証発行モード
     * @param 交付開始日 交付開始日
     * @param 交付終了日 交付終了日
     * @param 回収開始日 回収開始日
     * @param 回収終了日 回収終了日
     * @param 交付開始日あり 交付開始日あり
     * @param 交付終了日あり 交付終了日あり
     * @param 回収開始日あり 回収開始日あり
     * @param 回収終了日あり 回収終了日あり
     * @param 交付事由 交付事由リスト
     * @param 回収事由 回収事由リスト
     * @param psmShikibetsuTaisho 宛名識別対象取得キー
     * @param 出力順 出力順
     */
    private HihokenshashoHakkoKanriboMybatisParameter(
            RString 証発行モード,
            FlexibleDate 交付開始日,
            FlexibleDate 交付終了日,
            FlexibleDate 回収開始日,
            FlexibleDate 回収終了日,
            boolean 交付開始日あり,
            boolean 交付終了日あり,
            boolean 回収開始日あり,
            boolean 回収終了日あり,
            List<RString> 交付事由,
            List<RString> 回収事由,
            RString psmShikibetsuTaisho,
            RString 出力順) {
        this.akasihakouMod = 証発行モード;
        this.koufukayisihi = 交付開始日;
        this.koufusiuryouhi = 交付終了日;
        this.kasyuukayisihi = 回収開始日;
        this.kasyuusiuryouhi = 回収終了日;
        this.iskoufukayisihi = 交付開始日あり;
        this.iskoufuShuryouhi = 交付終了日あり;
        this.iskaisyuKayisihi = 回収開始日あり;
        this.iskaisyuShuryouhi = 回収終了日あり;
        this.kofuJiyulist = 交付事由;
        this.kaishuJiyulist = 回収事由;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.出力順 = 出力順;
    }

    /**
     * 被保険者証発行管理簿_バッチ用のパラメータクラス作成
     *
     * @param 証発行モード 証発行モード
     * @param 交付開始日 交付開始日
     * @param 交付終了日 交付終了日
     * @param 回収開始日 回収開始日
     * @param 回収終了日 回収終了日
     * @param 交付事由 交付事由リスト
     * @param 回収事由 回収事由リスト
     * @param psmShikibetsuTaisho 宛名識別対象取得キー
     * @param 出力順 出力順
     * @return 被保険者証発行管理簿_バッチ用のパラメータ
     */
    public static HihokenshashoHakkoKanriboMybatisParameter create_Param(
            RString 証発行モード,
            FlexibleDate 交付開始日,
            FlexibleDate 交付終了日,
            FlexibleDate 回収開始日,
            FlexibleDate 回収終了日,
            List<RString> 交付事由,
            List<RString> 回収事由,
            RString psmShikibetsuTaisho,
            RString 出力順) {
        boolean 交付開始日あり = false;
        boolean 交付終了日あり = false;
        boolean 回収開始日あり = false;
        boolean 回収終了日あり = false;
        if (交付開始日 != null && !交付開始日.isEmpty()) {
            交付開始日あり = true;
        }
        if (交付終了日 != null && !交付終了日.isEmpty()) {
            交付終了日あり = true;
        }
        if (回収開始日 != null && !回収開始日.isEmpty()) {
            回収開始日あり = true;
        }
        if (回収終了日 != null && !回収終了日.isEmpty()) {
            回収終了日あり = true;
        }
        return new HihokenshashoHakkoKanriboMybatisParameter(
                証発行モード,
                交付開始日,
                交付終了日,
                回収開始日,
                回収終了日,
                交付開始日あり,
                交付終了日あり,
                回収開始日あり,
                回収終了日あり,
                交付事由,
                回収事由,
                psmShikibetsuTaisho,
                出力順);
    }

}
