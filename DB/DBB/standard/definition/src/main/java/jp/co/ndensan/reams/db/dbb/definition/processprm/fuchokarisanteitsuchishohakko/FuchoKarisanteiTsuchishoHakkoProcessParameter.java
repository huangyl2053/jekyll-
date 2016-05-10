/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.fuchokarisanteitsuchishohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fuchokarisanteitsuchishohakko.BatchFuchoKariSanteiEntity;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokarisanteitsuchishohakko.FuchoKarisanteiTsuchishoHakkoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定通知書一括発行のprocessパラメーターです。
 *
 * @reamsid_L DBC-0710-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuchoKarisanteiTsuchishoHakkoProcessParameter {

    private RDateTime システム日時;
    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private List<BatchFuchoKariSanteiEntity> 出力帳票一覧List;
    private FlexibleDate 発行日;
    private RString 出力方法;
    private RString 出力期の表示方法;
    private RString 出力期;
    private RString 対象者;
    private RString 生活保護対象者をまとめて先頭に出力;
    private RString ページごとに山分け;
    private boolean 一括発行起動フラグ;

    /**
     * コンストラクタです。
     */
    public FuchoKarisanteiTsuchishoHakkoProcessParameter() {
    }

    /**
     * コンストラクタです
     *
     * @param システム日時 RDate
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 出力帳票一覧List List<BatchFuchoKariSanteiEntity>
     * @param 発行日 FlexibleDate
     * @param 出力方法 RString
     * @param 出力期の表示方法 RString
     * @param 出力期 RString
     * @param 対象者 RString
     * @param 生活保護対象者をまとめて先頭に出力 RString
     * @param ページごとに山分け RString
     * @param 一括発行起動フラグ boolean
     */
    public FuchoKarisanteiTsuchishoHakkoProcessParameter(
            RDateTime システム日時,
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            List<BatchFuchoKariSanteiEntity> 出力帳票一覧List,
            FlexibleDate 発行日,
            RString 出力方法,
            RString 出力期の表示方法,
            RString 出力期,
            RString 対象者,
            RString 生活保護対象者をまとめて先頭に出力,
            RString ページごとに山分け,
            boolean 一括発行起動フラグ) {
        this.システム日時 = システム日時;
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.出力帳票一覧List = 出力帳票一覧List;
        this.発行日 = 発行日;
        this.出力方法 = 出力方法;
        this.出力期の表示方法 = 出力期の表示方法;
        this.出力期 = 出力期;
        this.対象者 = 対象者;
        this.生活保護対象者をまとめて先頭に出力 = 生活保護対象者をまとめて先頭に出力;
        this.ページごとに山分け = ページごとに山分け;
        this.一括発行起動フラグ = 一括発行起動フラグ;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public FuchoKarisanteiTsuchishoHakkoMybatisParameter toMybatisParam() {
        return new FuchoKarisanteiTsuchishoHakkoMybatisParameter(
                システム日時,
                調定年度,
                賦課年度,
                出力帳票一覧List,
                発行日,
                出力方法,
                出力期の表示方法,
                出力期,
                対象者,
                生活保護対象者をまとめて先頭に出力,
                ページごとに山分け,
                一括発行起動フラグ
        );
    }

}
