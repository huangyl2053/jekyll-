/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteitsuchishohakko;

import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TokuchoKaishiTsuhishoKariOutputJoken;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko.KarisanteiBatchEntity;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴仮算定通知書一括発行（バッチ）する用ProcessParameterクラスです。
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoKaishiTsuchishoProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private FlexibleDate 発行日;
    private YMDHMS 帳票作成日時;
    private KarisanteiBatchEntity 出力帳票一覧Entity;
    private RString 出力対象;
    private boolean 一括発行起動フラグ;
    private FlexibleYear 調定年度minus1;
    private RString 科目コード;
    private RString 処理日;

    /**
     * toMyBatisParameter
     *
     * @return TokuchoKaishiTsuchishoMybatisParameter
     */
    public TokuchoKaishiTsuchishoMybatisParameter toMyBatisParameter() {
        return new TokuchoKaishiTsuchishoMybatisParameter(調定年度, 賦課年度, 発行日,
                帳票作成日時, 出力帳票一覧Entity, get出力対象(出力対象), 一括発行起動フラグ, 調定年度minus1, 科目コード, 処理日);
    }

    private RString get出力対象(RString 出力対象) {
        RString 出力対象code = null;
        if (TokuchoKaishiTsuhishoKariOutputJoken.全件_追加候補者含む.get名称().equals(出力対象)) {
            出力対象code = new RString("0");
        }
        if (TokuchoKaishiTsuhishoKariOutputJoken.全件_追加候補者含まない.get名称().equals(出力対象)) {
            出力対象code = new RString("1");
        }
        if (TokuchoKaishiTsuhishoKariOutputJoken.追加候補者のみ全て.get名称().equals(出力対象)) {
            出力対象code = new RString("2");
        }
        if (TokuchoKaishiTsuhishoKariOutputJoken._4月特別徴収開始の追加候補者のみ.get名称().equals(出力対象)) {
            出力対象code = new RString("3");
        }
        if (TokuchoKaishiTsuhishoKariOutputJoken._6月特別徴収開始の追加候補者のみ.get名称().equals(出力対象)) {
            出力対象code = new RString("4");
        }
        return 出力対象code;
    }

}
