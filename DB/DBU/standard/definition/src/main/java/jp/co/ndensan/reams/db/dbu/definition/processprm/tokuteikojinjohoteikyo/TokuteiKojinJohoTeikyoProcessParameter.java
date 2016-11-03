/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタの更新バッチ処理parameterクラスです。
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiKojinJohoTeikyoProcessParameter implements IBatchProcessParameter {

    private RString ワークフローID;
    private RString 新規異動区分;
    private RDateTime 対象開始日時;
    private RDateTime 対象終了日時;
}
