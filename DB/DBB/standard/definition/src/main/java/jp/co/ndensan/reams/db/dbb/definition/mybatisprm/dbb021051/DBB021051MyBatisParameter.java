/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb021051;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
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

    private RString 抽出対象者;
    private RYearMonth 基準年月;
    private RString 資格区分;
    private RString 市町村指定;
    private RString 最優先住所;
    private RString 敬称;
    private RString 被保番号表示;
    private RString 宛先住所設定;
    private RString 出力順ID;
    private List<RString> 出力順設定リスト;
    private RString 業務コード;

}
