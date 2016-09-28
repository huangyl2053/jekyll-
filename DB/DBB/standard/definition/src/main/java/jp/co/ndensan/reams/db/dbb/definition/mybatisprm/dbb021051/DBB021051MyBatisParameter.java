/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb021051;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）のMyBatisパラメタークラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBB021051MyBatisParameter implements IMyBatisParameter {

    private RString 資格区分;
    private RString 市町村指定;
    private RString 抽出対象者;
    private RString 市町村指定に市町村コード;
    private RString 基準年月の年;
    private RString 基準年月の月;
    private RString 最優先住所;
    private RString 出力順;

}
