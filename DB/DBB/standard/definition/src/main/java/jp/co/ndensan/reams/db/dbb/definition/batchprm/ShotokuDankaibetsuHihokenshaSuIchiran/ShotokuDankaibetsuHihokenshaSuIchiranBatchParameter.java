/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.ShotokuDankaibetsuHihokenshaSuIchiran;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBBGM21004_段階別被保険者数一覧表作成
 *
 * @reamsid_L DBB-1820-010 chenyadong
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter extends BatchParameterBase {

    private static final String KEY_SETTINGNENDO = "settingnendo";
    private static final String KEY_TREATMENTDAY = "treatmentday";
    private static final String KEY_REGIONDIVISION = "regiondivision";
    private static final String KEY_DANTAICD = "dantaiCd";
    private static final String KEY_QKIJUND = "qkijund";
    private static final String KEY_ADJUSTEDKIJUND = "adjustedkijund";

    @BatchParameter(key = KEY_SETTINGNENDO, name = "調定年度")
    private RString settingnendo;
    @BatchParameter(key = KEY_TREATMENTDAY, name = "本算定賦課処理日")
    private RDate treatmentday;
    @BatchParameter(key = KEY_REGIONDIVISION, name = "広域分・市町村分区分")
    private RString regiondivision;
    @BatchParameter(key = KEY_DANTAICD, name = "市町村コード")
    private RString dantaiCd;
    @BatchParameter(key = KEY_QKIJUND, name = "資格基準日")
    private RDate qkijund;
    @BatchParameter(key = KEY_ADJUSTEDKIJUND, name = "調定基準日")
    private RDate adjustedkijund;
}
