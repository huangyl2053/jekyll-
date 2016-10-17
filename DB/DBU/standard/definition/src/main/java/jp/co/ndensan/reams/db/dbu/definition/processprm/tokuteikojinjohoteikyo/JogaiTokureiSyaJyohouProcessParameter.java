/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例者情報のプロセスクラスです。
 *
 * @reamsid_L DBU-4880-040 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JogaiTokureiSyaJyohouProcessParameter implements IBatchProcessParameter {

    private RString 新規異動区分;
    private RDateTime 対象開始日時;
    private RDateTime 対象終了日時;
    private RString 連携先団体内統合宛名_連携方式;
    private HihokenshaNo 個人番号付替対象者被保険者番号;
    private RString 版番号;
    private RString 特定個人情報名コード;
}
