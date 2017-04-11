/*
 * To change this license header,
 choose License Headers in Project Properties.
 * To change this template file,
 choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD180025;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD180022.DBD180022_RiyoshaFutanwariaiHanteiSubParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMNK1002_利用者負担割合判定（共通）のバッチパラメータです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD180025_RiyoshaFutanwariaiHanteiSubGetsujiShoriParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
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
    private boolean testMode;
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
    private List<RString> 対象開始日;
    private List<RString> 対象終了日;

    /**
     * toDBD180022_RiyoshaFutanwariaiHanteiSubParameterのメソッドです。
     *
     * @return DBD180022_RiyoshaFutanwariaiHanteiSubParameter
     */
    public DBD180022_RiyoshaFutanwariaiHanteiSubParameter toDBD180022_RiyoshaFutanwariaiHanteiSubParameter() {
        DBD180022_RiyoshaFutanwariaiHanteiSubParameter parameter = new DBD180022_RiyoshaFutanwariaiHanteiSubParameter();
        parameter.setTaishoNendo(this.getTaishoNendo());
        parameter.setKijunbi(this.getKijunbi());
        parameter.setShoriKubun(this.getShoriKubun());
        parameter.setChushutsuKaishiNichiji(this.getChushutsuKaishiNichiji());
        parameter.setChushutsuShuryonichiNichiji(this.getChushutsuShuryonichiNichiji());
        parameter.setTestMode(this.isTestMode());
        parameter.setNendoShuryoNengappi(this.getNendoShuryoNengappi());
        parameter.setShoriNichiji(this.getShoriNichiji());
        parameter.setHanteiKijunbi(this.getHanteiKijunbi());
        parameter.setTaishoGetsu(this.getTaishoGetsu());
        parameter.setChushutuKaisu(this.getChushutuKaisu());
        parameter.set対象開始日(this.get対象開始日());
        parameter.set対象終了日(this.get対象終了日());
        return parameter;
    }
}
