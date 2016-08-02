/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.enkitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.enkitsuchisho.EnkiTsuchishohakenIchiranhyoJyohoProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBD522001_延期通知書出力バッチパラメタークラスです．
 *
 * @reamsid_L DBD-5220-001 chenxin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class EnkiTsuchishoBatchParameter extends BatchParameterBase {

    private static final String 画面モード = "gamenmodo";
    private static final String 処理見込み日From = "shorimikomibiFrom";
    private static final String 処理見込み日To = "shorimikomibiTo";
    private static final String 通知書発行日 = "tsuchishohakkonbi";
    private static final String 申請書管理番号リスト = "shinseishokanribangorisuto";

    @BatchParameter(key = 画面モード, name = "画面モード")
    private RString gamenmodo;
    @BatchParameter(key = 処理見込み日From, name = "処理見込み日From")
    private FlexibleDate shorimikomibiFrom;
    @BatchParameter(key = 処理見込み日To, name = "処理見込み日To")
    private FlexibleDate shorimikomibiTo;
    @BatchParameter(key = 通知書発行日, name = "通知書発行日")
    private FlexibleDate tsuchishohakkonbi;
    @BatchParameter(key = 申請書管理番号リスト, name = "申請書管理番号リスト")
    private List<ShinseishoKanriNo> shinseishokanribangorisuto;

    /**
     * バーチのパラメータを作成します。
     *
     * @return EnkiTsuchishohakenIchiranhyoJyohoProcessParameter
     */
    public EnkiTsuchishohakenIchiranhyoJyohoProcessParameter toEnkiTsuchishohakenIchiranhyoJyohoProcessParameter() {
        return new EnkiTsuchishohakenIchiranhyoJyohoProcessParameter(gamenmodo, shorimikomibiFrom, shorimikomibiTo, tsuchishohakkonbi, shinseishokanribangorisuto);
    }

}
