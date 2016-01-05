/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.hihokenshashohakkokanribo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 *
 * 被保険者証発行管理簿_バッチ用のパラメータです。
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
    private final boolean hakoukannririsutoflg;
    private final boolean seyisinjyohoflg;
    private final boolean subedesentakuflg;
    private final boolean renbanfukaflg;
    private final boolean koumukumeyifukaflg;
    private final boolean hizikehensyuuflg;
    private final List<UzT0007CodeEntity> kayuujiyuulist;
    private final List<UzT0007CodeEntity> kasyuujiyuulist;
    private final RString syuturyokujunid;

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
    private HihokenshashoHakkoKanriboProcessParameter(
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
     * 医療機関・主治医一覧表作成Mybatisパラメータークラス作成
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
     * @return 医療機関・主治医一覧表作成Mybatisパラメータークラス
     */
    public static HihokenshashoHakkoKanriboProcessParameter ProcessParameter(
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
            RString 出力順ID) {

        return new HihokenshashoHakkoKanriboProcessParameter(
                証発行モード,
                出力対象,
                交付開始日,
                交付終了日,
                回収開始日,
                回収終了日,
                発行管理リストフラグ,
                最新情報フラグ,
                すべて選択フラグ,
                連番付加フラグ,
                項目名付加フラグ,
                日付編集フラグ,
                交付事由,
                回収事由,
                出力順ID);
    }

    /**
     * 被保険者証発行管理簿_バッチ用のMybatisパラメータクラス作成
     *
     * @return 被保険者証発行管理簿_バッチ用のMybatisパラメータクラス
     */
    public HihokenshashoHakkoKanriboMybatisParameter toMybatisParameter() {

        return HihokenshashoHakkoKanriboMybatisParameter.RelateParameter_証発行管理リスト情報の取得(
                akasihakoumod,
                koufukayisihi,
                koufusiuryouhi,
                kasyuukayisihi,
                kasyuusiuryouhi,
                kayuujiyuulist,
                kasyuujiyuulist);
    }
}
