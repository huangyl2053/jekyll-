/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB514001;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 *
 * 納付額データ作成で使用するバッチパラメータクラスです。
 *
 * @reamsid_L DBB-1890-010 chenhui
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB514001_NofugakuDataSakuseiTandokuShichosonParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    private static final String KEY_対象年 = "対象年";
    private static final String KEY_抽出条件LIST = "抽出条件List";
    private static final String KEY_IS非課税年金のみ作成フラグ = "is非課税年金のみ作成フラグ";
    private static final String KEY_出力順ID = "出力順ID";
    @BatchParameter(key = KEY_対象年, name = "対象年")
    private RYear 対象年;
    @BatchParameter(key = KEY_抽出条件LIST, name = "抽出条件List")
    private List<NofugakuDataTsushutsuJoken> 抽出条件List;
    @BatchParameter(key = KEY_IS非課税年金のみ作成フラグ, name = "is非課税年金のみ作成フラグ")
    private boolean is非課税年金のみ作成フラグ;
    @BatchParameter(key = KEY_出力順ID, name = "出力順ID")
    private long 出力順ID;

}
