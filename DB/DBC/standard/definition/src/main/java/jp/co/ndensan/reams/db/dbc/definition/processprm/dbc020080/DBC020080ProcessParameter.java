/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のプロセスパラメタークラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBC020080ProcessParameter implements IBatchProcessParameter {

    private RDateTime 処理日時;
    private RDate 申請対象開始日;
    private RDate 申請対象日終了日;
    private boolean 出力フラグ;
    private Long 帳票出力順ID;
    private LasdecCode 市町村コード;
    private RString 出力順;
}
