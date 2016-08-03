/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5220001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.enkitsuchisho.EnkiTsuchishohakenIchiranhyoJyohoProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
    private FlexibleDate 処理見込み日From;
    private FlexibleDate 処理見込み日To;
    private FlexibleDate 通知書発行日;
    private List<ShinseishoKanriNo> 申請書管理番号リスト;

    /**
     * バーチのパラメータを作成します。
     *
     * @return EnkiTsuchishohakenIchiranhyoJyohoProcessParameter
     */
    public EnkiTsuchishohakenIchiranhyoJyohoProcessParameter toEnkiTsuchishohakenIchiranhyoJyohoProcessParameter() {
        return new EnkiTsuchishohakenIchiranhyoJyohoProcessParameter(画面モード,
                処理見込み日From, 処理見込み日To, 通知書発行日, 申請書管理番号リスト);
    }

}
