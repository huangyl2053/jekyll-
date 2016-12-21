/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD522001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.enkitsuchisho.EnkiTsuchishohakenIchiranhyoJyohoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
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
public class DBD522001_EnkitsuchiParameter extends BatchParameterBase {

    @BatchParameter(key = "画面モード", name = "画面モード")
    private RString 画面モード;
    @BatchParameter(key = "処理見込み日From", name = "処理見込み日From")
    private FlexibleDate 処理見込み日From;
    @BatchParameter(key = "処理見込み日To", name = "処理見込み日To")
    private FlexibleDate 処理見込み日To;
    @BatchParameter(key = "通知書発行日", name = "通知書発行日")
    private List<FlexibleDate> 通知書発行日;
    @BatchParameter(key = "申請書管理番号リスト", name = "申請書管理番号リスト")
    private List<RString> 申請書管理番号リスト;
    @BatchParameter(key = "文書番号", name = "文書番号")
    private RString 文書番号;
    
    /**
     * バーチのパラメータを作成します。
     *
     * @return EnkiTsuchishohakenIchiranhyoJyohoProcessParameter
     */
    public EnkiTsuchishohakenIchiranhyoJyohoProcessParameter toEnkiTsuchishohakenIchiranhyoJyohoProcessParameter() {
        return new EnkiTsuchishohakenIchiranhyoJyohoProcessParameter(画面モード,
                処理見込み日From, 処理見込み日To, 通知書発行日, 申請書管理番号リスト,文書番号);
    }

}
