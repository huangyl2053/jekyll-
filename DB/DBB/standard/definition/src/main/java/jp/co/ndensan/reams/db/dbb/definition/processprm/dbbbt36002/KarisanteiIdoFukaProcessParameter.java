/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt36002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB015003.TyouhyouEntity;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 仮算定異動通知書一括発行する用パラメータのクラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiIdoFukaProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private TyouhyouEntity 出力帳票一覧;
    private RDate 特徴_発行日;
    private RDate 仮算定額変更_発行日;
    private RString 仮算定額変更_文書番号;
    private RString 納入_出力期;
    private RString 納入_出力方式;
    private RDate 納入_発行日;
    private RString 納入_対象者;
    private RString 納入_生活保護対象者;
    private RString 納入_ページごとに山分け;
    private boolean 一括発行起動フラグ;
    private YMDHMS 帳票作成日時;
    private YMDHMS 最新調定日時;

    /**
     * コンストラクタ
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 出力帳票一覧 TyouhyouEntity
     * @param 特徴_発行日 RDate
     * @param 仮算定額変更_発行日 RDate
     * @param 仮算定額変更_文書番号 RString
     * @param 納入_出力期 RString
     * @param 納入_出力方式 RString
     * @param 納入_発行日 RDate
     * @param 納入_対象者 RString
     * @param 納入_生活保護対象者 RString
     * @param 納入_ページごとに山分け RString
     * @param 一括発行起動フラグ boolean
     * @param 帳票作成日時 YMDHMS
     * @param 最新調定日時 YMDHMS
     */
    public KarisanteiIdoFukaProcessParameter(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TyouhyouEntity 出力帳票一覧,
            RDate 特徴_発行日,
            RDate 仮算定額変更_発行日,
            RString 仮算定額変更_文書番号,
            RString 納入_出力期,
            RString 納入_出力方式,
            RDate 納入_発行日,
            RString 納入_対象者,
            RString 納入_生活保護対象者,
            RString 納入_ページごとに山分け,
            boolean 一括発行起動フラグ,
            YMDHMS 帳票作成日時,
            YMDHMS 最新調定日時) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.出力帳票一覧 = 出力帳票一覧;
        this.特徴_発行日 = 特徴_発行日;
        this.仮算定額変更_発行日 = 仮算定額変更_発行日;
        this.仮算定額変更_文書番号 = 仮算定額変更_文書番号;
        this.納入_出力期 = 納入_出力期;
        this.納入_出力方式 = 納入_出力方式;
        this.納入_発行日 = 納入_発行日;
        this.納入_対象者 = 納入_対象者;
        this.納入_生活保護対象者 = 納入_生活保護対象者;
        this.納入_ページごとに山分け = 納入_ページごとに山分け;
        this.一括発行起動フラグ = 一括発行起動フラグ;
        this.帳票作成日時 = 帳票作成日時;
        this.最新調定日時 = 最新調定日時;
    }
}
