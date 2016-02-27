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
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihokenshashoHakkoKanriboMybatisParameter implements IMyBatisParameter {

    private final RString akasihakouMod;
    private final FlexibleDate koufukayisihi;
    private final FlexibleDate koufusiuryouhi;
    private final FlexibleDate kasyuukayisihi;
    private final FlexibleDate kasyuusiuryouhi;
    private final boolean isKoufukayisihi;
    private final boolean isKoufuSiuryouhi;
    private final boolean isKasyuuKayisihi;
    private final boolean isKasyuuSiuryouhi;
    private final List<RString> kofuJiyulist;
    private final List<RString> kaishuJiyulist;
    private final RString psmShikibetsuTaisho;

    /**
     * 非公開コンストラクタです。
     *
     * @param 証発行モード RString
     * @param 交付開始日 FlexibleDate
     * @param 交付終了日 FlexibleDate
     * @param 回収開始日 FlexibleDate
     * @param 回収終了日 FlexibleDate
     * @param isKoufukayisihi 交付開始日あり
     * @param isKoufuSiuryouhi 交付終了日あり
     * @param isKasyuuKayisihi 回収年月日あり
     * @param isKasyuuSiuryouhi 回収年月日あり
     * @param 交付事由 List<RString>
     * @param 回収事由 List<RString>
     */
    private HihokenshashoHakkoKanriboMybatisParameter(
            RString 証発行モード,
            FlexibleDate 交付開始日,
            FlexibleDate 交付終了日,
            FlexibleDate 回収開始日,
            FlexibleDate 回収終了日,
            boolean isKoufukayisihi,
            boolean isKoufuSiuryouhi,
            boolean isKasyuuKayisihi,
            boolean isKasyuuSiuryouhi,
            List<RString> 交付事由,
            List<RString> 回収事由,
            RString psmShikibetsuTaisho) {
        this.akasihakouMod = 証発行モード;
        this.koufukayisihi = 交付開始日;
        this.koufusiuryouhi = 交付終了日;
        this.kasyuukayisihi = 回収開始日;
        this.kasyuusiuryouhi = 回収終了日;
        this.isKoufukayisihi = isKoufukayisihi;
        this.isKoufuSiuryouhi = isKoufuSiuryouhi;
        this.isKasyuuKayisihi = isKasyuuKayisihi;
        this.isKasyuuSiuryouhi = isKasyuuSiuryouhi;
        this.kofuJiyulist = 交付事由;
        this.kaishuJiyulist = 回収事由;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 被保険者証発行管理簿_バッチ用のパラメータクラス作成
     *
     * @param 証発行モード RString
     * @param 交付開始日 FlexibleDate
     * @param 交付終了日 FlexibleDate
     * @param 回収開始日 FlexibleDate
     * @param 回収終了日 FlexibleDate
     * @param 交付事由 List<RString>
     * @param 回収事由 List<RString>
     * @param psmShikibetsuTaisho PSM
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
            RString psmShikibetsuTaisho) {
        boolean isKoufukayisihi = false;
        boolean isKoufuSiuryouhi = false;
        boolean isKasyuuKayisihi = false;
        boolean isKasyuuSiuryouhi = false;
        if (交付開始日 != null && !交付開始日.isEmpty()) {
            isKoufukayisihi = true;
        }
        if (交付終了日 != null && !交付終了日.isEmpty()) {
            isKoufuSiuryouhi = true;
        }
        if (交付終了日 != null && !回収開始日.isEmpty()) {
            isKasyuuKayisihi = true;
        }
        if (回収終了日 != null && !回収終了日.isEmpty()) {
            isKasyuuSiuryouhi = true;
        }
        return new HihokenshashoHakkoKanriboMybatisParameter(
                証発行モード,
                交付開始日,
                交付終了日,
                回収開始日,
                回収終了日,
                isKoufukayisihi,
                isKoufuSiuryouhi,
                isKasyuuKayisihi,
                isKasyuuSiuryouhi,
                交付事由,
                回収事由,
                psmShikibetsuTaisho);
    }

}
