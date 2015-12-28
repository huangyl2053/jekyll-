/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.core.hihokenshashohakkokanribo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * バッチ用のパラメータです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public final class AkasiHakouKanriParameter extends BatchParameterBase {

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
    private final RString akasihakoumod;
    @BatchParameter(key = SIYUTURIYOKU_TAYSYOU, name = "出力対象")
    private final RString siyuturiyokudaysyou;
    @BatchParameter(key = KOUFU_KAYISIHI, name = "交付開始日")
    private final FlexibleDate koufukayisihi;
    @BatchParameter(key = KOUFU_SIURYOUHI, name = "交付終了日")
    private final FlexibleDate koufusiuryouhi;
    @BatchParameter(key = KASYUU_KAYISIHI, name = "回収開始日")
    private final FlexibleDate kasyuukayisihi;
    @BatchParameter(key = KASYUU_SIURYOUHI, name = "回収終了日")
    private final FlexibleDate kasyuusiuryouhi;
    @BatchParameter(key = HAKOU_KANNRI_RISUTOFLG, name = "発行管理リストフラグ")
    private final boolean hakoukannririsutoflg;
    @BatchParameter(key = SEYISIN_JYOHO_FLG, name = "最新情報フラグ")
    private final boolean seyisinjyohoflg;
    @BatchParameter(key = SUBEDE_SENTAKU_FLG, name = "すべて選択フラグ")
    private final boolean subedesentakuflg;
    @BatchParameter(key = RENBAN_FUKA_FLG, name = "連番付加フラグ")
    private final boolean renbanfukaflg;
    @BatchParameter(key = KOUMUKUMEYI_FUKA_FLG, name = "項目名付加フラグ")
    private final boolean koumukumeyifukaflg;
    @BatchParameter(key = HIZIKE_HENSYUU_FLG, name = "日付編集フラグ")
    private final boolean hizikehensyuuflg;
    @BatchParameter(key = KAYUU_JIYUU_LIST, name = "交付事由List")
    private final List<UzT0007CodeEntity> kayuujiyuulist;
    @BatchParameter(key = KASYUU_JIYUU_LIST, name = "回収事由List")
    private final List<UzT0007CodeEntity> kasyuujiyuulist;
    @BatchParameter(key = SYUTURYOKUJUN_ID, name = "出力順ID")
    private final RString syuturyokujunid;

    /**
     * {@link AkasiHakouKanriParameter}で利用するパラメータクラスに変換して返します。
     *
     * @return バッチ用のパラメータです
     */
    public AkasiHakouKanriParameter toAkasiHakouKanriParameter() {
        return new AkasiHakouKanriParameter(
                akasihakoumod,
                siyuturiyokudaysyou,
                koufukayisihi,
                koufusiuryouhi,
                kasyuukayisihi,
                kasyuusiuryouhi,
                hakoukannririsutoflg,
                seyisinjyohoflg,
                subedesentakuflg,
                renbanfukaflg,
                koumukumeyifukaflg,
                hizikehensyuuflg,
                kayuujiyuulist,
                kasyuujiyuulist,
                syuturyokujunid);
    }

    /**
     * 非公開コンストラクタです。
     *
     * @param 証発行モード RString
     * @param 交付開始日 FlexibleDate
     * @param 交付終了日 FlexibleDate
     * @param 回収開始日 FlexibleDate
     * @param 回収終了日 FlexibleDate
     * @param 発行管理リストフラグ boolean
     * @param 最新情報フラグ boolean
     * @param すべて選択フラグ boolean
     * @param 連番付加フラグ boolean
     * @param 項目名付加フラグ boolean
     * @param 日付編集フラグ boolean
     * @param 交付事由 List<UzT0007CodeEntity>
     * @param 回収事由 List<UzT0007CodeEntity>
     * @param 出力順ID RString
     * @param 出力対象 RString
     */
    private AkasiHakouKanriParameter(
            RString 証発行モード,
            RString 出力対象,
            FlexibleDate 交付開始日,
            FlexibleDate 交付終了日,
            FlexibleDate 回収開始日,
            FlexibleDate 回収終了日,
            boolean 発行管理リストフラグ,
            boolean 最新情報フラグ,
            boolean すべて選択フラグ,
            boolean 連番付加フラグ,
            boolean 項目名付加フラグ,
            boolean 日付編集フラグ,
            List<UzT0007CodeEntity> 交付事由,
            List<UzT0007CodeEntity> 回収事由,
            RString 出力順ID
    ) {
        this.akasihakoumod = 証発行モード;
        this.siyuturiyokudaysyou = 出力対象;
        this.koufukayisihi = 交付開始日;
        this.koufusiuryouhi = 交付終了日;
        this.kasyuukayisihi = 回収開始日;
        this.kasyuusiuryouhi = 回収終了日;
        this.hakoukannririsutoflg = 発行管理リストフラグ;
        this.seyisinjyohoflg = 最新情報フラグ;
        this.subedesentakuflg = すべて選択フラグ;
        this.renbanfukaflg = 連番付加フラグ;
        this.koumukumeyifukaflg = 項目名付加フラグ;
        this.hizikehensyuuflg = 日付編集フラグ;
        this.kayuujiyuulist = 交付事由;
        this.kasyuujiyuulist = 回収事由;
        this.syuturyokujunid = 出力順ID;
    }

    /**
     * 被保険者台帳管理（資格取得）情報用のパラメータを生成します。
     *
     * @param 証発行モード RString
     * @param 出力対象 RString
     * @param 交付開始日 FlexibleDate
     * @param 交付終了日 FlexibleDate
     * @param 回収開始日 FlexibleDate
     * @param 回収終了日 FlexibleDate
     * @param 最新情報フラグ boolean
     * @param 連番付加フラグ boolean
     * @param 項目名付加フラグ boolean
     * @param 日付編集フラグ boolean
     * @param 交付事由 List<UzT0007CodeEntity>
     * @param 回収事由 List<UzT0007CodeEntity>
     * @param 出力順ID RString
     * @return バッチ用のパラメータです
     */
    public static AkasiHakouKanriParameter createParam_Batch(
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
            List<UzT0007CodeEntity> 交付事由,
            List<UzT0007CodeEntity> 回収事由,
            RString 出力順ID) {
        return new AkasiHakouKanriParameter(
                証発行モード,
                出力対象,
                交付開始日,
                交付終了日,
                回収開始日,
                回収終了日,
                true,
                最新情報フラグ,
                true,
                連番付加フラグ,
                項目名付加フラグ,
                日付編集フラグ,
                交付事由,
                回収事由,
                出力順ID
        );
    }
}
