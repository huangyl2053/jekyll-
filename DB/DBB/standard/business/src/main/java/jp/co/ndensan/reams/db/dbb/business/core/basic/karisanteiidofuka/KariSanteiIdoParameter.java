/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.karisanteiidofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.TyouhyouEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力帳票一覧のクラスです。
 *
 * @reamsid_L DBB-0890-020 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KariSanteiIdoParameter {

    private RString 調定年度;
    private RString 賦課年度;
    private RString 処理対象;
    private RString 普徴仮算定異動方法;
    private RString 抽出開始日時;
    private RString 抽出終了日時;
    private RString 帳票グループ;
    private List<TyouhyouEntity> 出力帳票一覧List;
    private RString 特徴_発行日;
    private RString 仮算定額変更_発行日;
    private RString 文書番号;
    private RString 納入_出力期;
    private RString 納入_出力方式;
    private RString 納入_発行日;
    private RString 納入_対象者;
    private RString 納入_生活保護対象者;
    private RString 納入_ページごとに山分け;
    private RString 特徴仮算定賦課処理日時;
    private RString 普徴仮算定賦課処理日時;
    private boolean 一括発行起動フラグ;
    private RString 仮算定異動賦課メニューからの場合;
    private RString 算定期;
    private boolean バッチ起動フラグ;
}
