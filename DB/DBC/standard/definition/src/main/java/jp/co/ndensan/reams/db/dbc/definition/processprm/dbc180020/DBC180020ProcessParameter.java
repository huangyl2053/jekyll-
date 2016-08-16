/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180020.DBC180020MyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * DBCMNK1002利用者負担割合のプロセスパラメータです。
 *
 * @reamsid_L DBC-4950-031 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBC180020ProcessParameter implements IBatchProcessParameter {

    private RString taishoNendo;
    private RString kijunbi;
    private RString shoriKubun;
    private RString chushutsuKaishiNichiji;
    private RString chushutsuShuryonichiNichiji;
    private RString testMode;
    private RString nendoShuryoNengappi;
    private RString shoriNichiji;
    private List<RString> hanteiKijunbi;
    private List<RString> taishoGetsu;
    private Integer chushutuKaisu;
    private int hanteiKijunbiIndex;
    private int taishoGetsuIndex;

    /**
     * DBC180020ProcessParameterのコンストラクタです。
     *
     * @param taishoNendo 対象年度
     * @param kijunbi 基準日
     * @param shoriKubun 処理区分
     * @param chushutsuKaishiNichiji 抽出開始日時
     * @param chushutsuShuryonichiNichiji 抽出終了日時
     * @param testMode テストモード
     * @param nendoShuryoNengappi 年度終了年月日
     * @param shoriNichiji 処理日時
     * @param hanteiKijunbi 判定基準日
     * @param taishoGetsu 対象月
     * @param chushutuKaisu ループ回数
     * @param hanteiKijunbiIndex int
     * @param taishoGetsuIndex int
     */
    public DBC180020ProcessParameter(RString taishoNendo,
            RString kijunbi,
            RString shoriKubun,
            RString chushutsuKaishiNichiji,
            RString chushutsuShuryonichiNichiji,
            RString testMode,
            RString nendoShuryoNengappi,
            RString shoriNichiji,
            List<RString> hanteiKijunbi,
            List<RString> taishoGetsu,
            Integer chushutuKaisu,
            int hanteiKijunbiIndex,
            int taishoGetsuIndex) {
        this.taishoNendo = taishoNendo;
        this.kijunbi = kijunbi;
        this.shoriKubun = shoriKubun;
        this.chushutsuKaishiNichiji = chushutsuKaishiNichiji;
        this.chushutsuShuryonichiNichiji = chushutsuShuryonichiNichiji;
        this.testMode = testMode;
        this.nendoShuryoNengappi = nendoShuryoNengappi;
        this.shoriNichiji = shoriNichiji;
        this.hanteiKijunbi = hanteiKijunbi == null ? new ArrayList<RString>() : hanteiKijunbi;
        this.taishoGetsu = taishoGetsu;
        this.chushutuKaisu = chushutuKaisu;
        this.hanteiKijunbiIndex = hanteiKijunbiIndex;
        this.taishoGetsuIndex = taishoGetsuIndex;
    }

    /**
     * toMyBatisParameter
     *
     * @return DBC180020MyBatisParameter
     */
    public DBC180020MyBatisParameter toMyBatisParameter() {
        return new DBC180020MyBatisParameter(hanteiKijunbi.get(hanteiKijunbiIndex),
                taishoNendo, taishoGetsu.get(taishoGetsuIndex));
    }
}
