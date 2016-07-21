/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 本算定異動（現年度）通知書一括発行のパラメータクラスです。
 *
 * @reamsid_L DBB-0880-030 xicongwang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiIdoProcessParameter implements IBatchProcessParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final RString 処理対象;
    private final ChohyoResult 出力帳票一覧;
    private final RString 特徴_出力対象;
    private final FlexibleDate 特徴_発行日;
    private final RString 決定_チェックボックス;
    private final RString 決定_文書番号;
    private final FlexibleDate 決定_発行日;
    private final RString 変更_チェックボックス;
    private final RString 変更_対象者;
    private final RString 変更_文書番号;
    private final FlexibleDate 変更_発行日;
    private final RString 納入_出力方法;
    private final RString 納入_出力期;
    private final RString 納入_対象者;
    private final FlexibleDate 納入_発行日;
    private final RString 納入_口座振替者今回出力様式;
    private final RString 納入_ページごとに山分け;
    private final boolean 随時期フラグ;
    private final boolean 一括発行起動フラグ;
    private final YMDHMS 帳票作成日時;
    private RString 納入_生活保護対象者をまとめて先頭に出力;

    /**
     * コンストラクタ
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 処理対象 RString
     * @param 出力帳票一覧 ChohyoResult
     * @param 特徴_出力対象 RString
     * @param 特徴_発行日 FlexibleDate
     * @param 決定_チェックボックス RString
     * @param 決定_文書番号 RString
     * @param 決定_発行日 FlexibleDate
     * @param 変更_チェックボックス RString
     * @param 変更_対象者 RString
     * @param 変更_文書番号 RString
     * @param 変更_発行日 FlexibleDate
     * @param 納入_出力方法 RString
     * @param 納入_出力期 RString
     * @param 納入_対象者 RString
     * @param 納入_発行日 FlexibleDate
     * @param 納入_口座振替者今回出力様式 RString
     * @param 納入_ページごとに山分け RString
     * @param 随時期フラグ boolean
     * @param 一括発行起動フラグ boolean
     * @param 帳票作成日時 YMDHMS
     * @param 納入_生活保護対象者をまとめて先頭に出力 RString
     */
    public HonsanteiIdoProcessParameter(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 処理対象,
            ChohyoResult 出力帳票一覧,
            RString 特徴_出力対象,
            FlexibleDate 特徴_発行日,
            RString 決定_チェックボックス,
            RString 決定_文書番号,
            FlexibleDate 決定_発行日,
            RString 変更_チェックボックス,
            RString 変更_対象者,
            RString 変更_文書番号,
            FlexibleDate 変更_発行日,
            RString 納入_出力方法,
            RString 納入_出力期,
            RString 納入_対象者,
            FlexibleDate 納入_発行日,
            RString 納入_口座振替者今回出力様式,
            RString 納入_ページごとに山分け,
            boolean 随時期フラグ,
            boolean 一括発行起動フラグ,
            YMDHMS 帳票作成日時,
            RString 納入_生活保護対象者をまとめて先頭に出力) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.処理対象 = 処理対象;
        this.出力帳票一覧 = 出力帳票一覧;
        this.特徴_出力対象 = 特徴_出力対象;
        this.特徴_発行日 = 特徴_発行日;
        this.決定_チェックボックス = 決定_チェックボックス;
        this.決定_文書番号 = 決定_文書番号;
        this.決定_発行日 = 決定_発行日;
        this.変更_チェックボックス = 変更_チェックボックス;
        this.変更_対象者 = 変更_対象者;
        this.変更_文書番号 = 変更_文書番号;
        this.変更_発行日 = 変更_発行日;
        this.納入_出力方法 = 納入_出力方法;
        this.納入_出力期 = 納入_出力期;
        this.納入_対象者 = 納入_対象者;
        this.納入_発行日 = 納入_発行日;
        this.納入_口座振替者今回出力様式 = 納入_口座振替者今回出力様式;
        this.納入_ページごとに山分け = 納入_ページごとに山分け;
        this.随時期フラグ = 随時期フラグ;
        this.一括発行起動フラグ = 一括発行起動フラグ;
        this.帳票作成日時 = 帳票作成日時;
        this.納入_生活保護対象者をまとめて先頭に出力 = 納入_生活保護対象者をまとめて先頭に出力;
    }
}
