/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 本算定通知書一括発行のパラメータクラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteifukaProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private FlexibleDate 資格基準日;
    private HonsanteifukaBatchTyouhyou 出力帳票一覧;
    private RString 特徴_出力対象;
    private RDate 特徴_発行日;
    private RString 決定変更_文書番号;
    private RDate 決定変更_発行日;
    private RString 納入_出力方法;
    private RString 納入_出力期;
    private RString 納入_対象者;
    private RDate 納入_発行日;
    private RString 納入_ページごとに山分け;
    private RString 打分け条件情報;
    private RDateTime 処理日時;
    private boolean 一括発行起動フラグ;
    private YMDHMS 帳票作成日時;
    private RString 納入_生活保護対象者をまとめて先頭に出力;
    private YMDHMS 最新調定日時;

    /**
     * コンストラクタ
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 資格基準日 FlexibleDate
     * @param 出力帳票一覧 HonsanteifukaBatchTyouhyou
     * @param 特徴_出力対象 RString
     * @param 特徴_発行日 RDate
     * @param 決定変更_文書番号 RString
     * @param 決定変更_発行日 RDate
     * @param 納入_出力方法 RString
     * @param 納入_出力期 RString
     * @param 納入_対象者 RString
     * @param 納入_発行日 RDate
     * @param 納入_ページごとに山分け RString
     * @param 打分け条件情報 RString
     * @param 処理日時 RDateTime
     * @param 一括発行起動フラグ boolean
     * @param 帳票作成日時 YMDHMS
     * @param 納入_生活保護対象者をまとめて先頭に出力 RString
     * @param 最新調定日時 YMDHMS
     */
    public HonsanteifukaProcessParameter(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            FlexibleDate 資格基準日,
            HonsanteifukaBatchTyouhyou 出力帳票一覧,
            RString 特徴_出力対象,
            RDate 特徴_発行日,
            RString 決定変更_文書番号,
            RDate 決定変更_発行日,
            RString 納入_出力方法,
            RString 納入_出力期,
            RString 納入_対象者,
            RDate 納入_発行日,
            RString 納入_ページごとに山分け,
            RString 打分け条件情報,
            RDateTime 処理日時,
            boolean 一括発行起動フラグ,
            YMDHMS 帳票作成日時,
            RString 納入_生活保護対象者をまとめて先頭に出力,
            YMDHMS 最新調定日時) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.資格基準日 = 資格基準日;
        this.出力帳票一覧 = 出力帳票一覧;
        this.特徴_出力対象 = 特徴_出力対象;
        this.特徴_発行日 = 特徴_発行日;
        this.決定変更_文書番号 = 決定変更_文書番号;
        this.決定変更_発行日 = 決定変更_発行日;
        this.納入_出力方法 = 納入_出力方法;
        this.納入_出力期 = 納入_出力期;
        this.納入_対象者 = 納入_対象者;
        this.納入_発行日 = 納入_発行日;
        this.納入_ページごとに山分け = 納入_ページごとに山分け;
        this.打分け条件情報 = 打分け条件情報;
        this.処理日時 = 処理日時;
        this.一括発行起動フラグ = 一括発行起動フラグ;
        this.帳票作成日時 = 帳票作成日時;
        this.納入_生活保護対象者をまとめて先頭に出力 = 納入_生活保護対象者をまとめて先頭に出力;
        this.最新調定日時 = 最新調定日時;
    }
}
