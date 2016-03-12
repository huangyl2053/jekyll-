/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteifuka;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ用パラメータのクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BatchresultParameter implements Serializable {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private FlexibleDate 資格基準日;
    private List<BatchTyouhyouResult> 出力帳票一覧;
    private RString 特徴_出力対象;
    private FlexibleDate 特徴_発行日;
    private RString 決定変更_文書番号;
    private FlexibleDate 決定変更_発行日;
    private RString 納入_出力方法;
    private FlexibleDate 納入_出力期;
    private RString 納入_対象者;
    private FlexibleDate 納入_発行日;
    private RString 納入_出力対象;
    private RString 納入_ページごとに山分け;
    private RString 打分け条件情報;
    private FlexibleDate 処理日時;
    private boolean 一括発行起動フラグ;

}
