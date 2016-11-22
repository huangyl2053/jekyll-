/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kijunsyunyunenji;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 基準収入額適用申請書_年次分作成のInsTaishoSeitaiyinTempProcessのParameterです
 *
 * @reamsid_L DBC-4630-060 jiangwenkai
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class InsTaishoSeitaiyinTempProcessParameter implements IBatchProcessParameter {

    private RString 処理区分;
    private RString 出力順ID;
    private FlexibleYear 処理年度;
    private FlexibleDate 世帯員把握基準日;
    private FlexibleDate 世帯員把握基準日2;
    private RString 抽出条件;
    private FlexibleDate 作成日;
    private RString 文書番号;
    private LasdecCode 市町村コード;
    private RString 市町村名;
    private Boolean お知らせ通知書出力フラグ;
    private Boolean 一覧表CSV出力フラグ;
    private Boolean 申請書出力フラグ;
    private FlexibleDate 処理年月日;
    private RString 被保険者番号;
    private RString 抽出対象;
    private RString 提出期限;
}
