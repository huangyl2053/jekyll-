/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 概況調査データの前回情報(前々回情報)のマッピング用Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GaikyoChosaDataZenkaiJohoRelateEntity {

    private RString 審査会開催番号;
    private RString 認定有効開始年月日;
    private RString 認定有効終了年月日;
    private Decimal 認定期間;
    private RString 二次判定日;
    private RString 申請区分_申;
    private RString 申請区分_法;
    private RString 通知区分;
    private RString 特定疾病;
    private RString 一次判定;
    private RString 二次判定;
    private RString 状態像;
    private RString 審査会メモ;
    private RString 審査会意見;
    private RString 申請書管理番号;

}
