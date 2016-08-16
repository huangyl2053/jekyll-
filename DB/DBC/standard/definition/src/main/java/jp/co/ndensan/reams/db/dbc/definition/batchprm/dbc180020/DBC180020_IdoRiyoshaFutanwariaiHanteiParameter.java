/*
 * To change this license header,
 choose License Headers in Project Properties.
 * To change this template file,
 choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc180020;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBCMNK1002_異動分利用者負担割合判定のバッチパラメータです。
 *
 * @reamsid_L DBC-4950-010 liuyang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC180020_IdoRiyoshaFutanwariaiHanteiParameter extends BatchParameterBase {

    @BatchParameter(key = "taishoNendo", name = "対象年度")
    private FlexibleYear taishoNendo;
    @BatchParameter(key = "kijunbi", name = "基準日")
    private FlexibleDate kijunbi;
    @BatchParameter(key = "shoriKubun", name = "処理区分")
    private RString shoriKubun;
    @BatchParameter(key = "chushutsuKaishiNichiji", name = "抽出開始日時")
    private RDateTime chushutsuKaishiNichiji;
    @BatchParameter(key = "chushutsuShuryonichiNichiji", name = "抽出終了日時")
    private RDateTime chushutsuShuryonichiNichiji;
    @BatchParameter(key = "testMode", name = "テストモード")
    private RString testMode;
    @BatchParameter(key = "nendoShuryoNengappi", name = "年度終了年月日")
    private FlexibleDate nendoShuryoNengappi;
    @BatchParameter(key = "shoriNichiji", name = "処理日時")
    private RDateTime shoriNichiji;
    @BatchParameter(key = "hanteiKijunbi", name = "判定基準日")
    private List<RString> hanteiKijunbi;
    @BatchParameter(key = "taishoGetsu", name = "対象月")
    private List<RString> taishoGetsu;
    @BatchParameter(key = "chushutuKaisu", name = "抽出回数")
    private Integer chushutuKaisu;
}
