/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5220001;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 延期通知書出力のバッチパラメータクラスです。
 *
 * @reamsid_L DBD-1410-010 wangjie2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiEnkiTsuchishoHakkoParameter extends BatchParameterBase {

    private RString 画面モード;
    private RDate 処理見込み日From;
    private RDate 処理見込み日To;
    private RDate 通知書発行日;
    private List<RString> 申請書管理番号リスト;

}
