/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報編集(標準)バッチ処理parameterクラスです。
 *
 * @reamsid_L DBU-4880-100 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiKojinJohoHensyuProcessParameter implements IBatchProcessParameter {

    private RString 中間DBテーブル名;
    private RString 新規異動区分;
    private RString 特定個人情報名コード;
    private RString データセット番号;
    private RString 版番号;
    private FlexibleDate 基準日;
}
