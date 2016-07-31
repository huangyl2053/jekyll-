/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再発行対象者Tempへ出力のパラメタ
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaihaqkouTaishoupParameter {

    private FlexibleYear 処理年度;
    private List<YMDHMS> 作成日時;
    private List<RString> 発行ユーザーID;
}
