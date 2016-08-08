/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.seikatsuhogorireki;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 生活保護履歴情報のパラメータクラスです。
 *
 * @reamsid_L DBZ-4520-010 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SeikaatsuhogoDataModel implements Serializable {

    private static final long serialVersionUID = 936271027658983885L;
    private RDate 受給開始日;
    private RDate 受給廃止日;
    private RString 受給者番号;
    private RString 納付区分;
    private RDate 納付年月;
    private RString 入退所区分;
    private RDate 入所日;
    private RString 扶助種類コード;
    private RString 扶助種類;
    private RString 表示モード;
    private RString 受給停止期間;
}
