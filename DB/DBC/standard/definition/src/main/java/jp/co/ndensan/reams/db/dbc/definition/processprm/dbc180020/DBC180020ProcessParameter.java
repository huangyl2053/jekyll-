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
import jp.co.ndensan.reams.uz.uza.lang.RYear;
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

    private RYear taishoNendo;
    private RString kijunbi;
    private RString shoriKubun;
    private RString testMode;
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
     * @param testMode テストモード
     * @param hanteiKijunbi 判定基準日
     * @param taishoGetsu 対象月
     * @param chushutuKaisu ループ回数
     * @param hanteiKijunbiIndex int
     * @param taishoGetsuIndex int
     */
    public DBC180020ProcessParameter(RYear taishoNendo,
            RString kijunbi,
            RString shoriKubun,
            RString testMode,
            List<RString> hanteiKijunbi,
            List<RString> taishoGetsu,
            Integer chushutuKaisu,
            int hanteiKijunbiIndex,
            int taishoGetsuIndex) {
        this.taishoNendo = taishoNendo;
        this.kijunbi = kijunbi;
        this.shoriKubun = shoriKubun;
        this.testMode = testMode;
        this.hanteiKijunbi = hanteiKijunbi == null ? new ArrayList<RString>() : hanteiKijunbi;
        this.taishoGetsu = taishoGetsu;
        this.chushutuKaisu = chushutuKaisu;
        this.hanteiKijunbiIndex = hanteiKijunbiIndex;
        this.taishoGetsuIndex = taishoGetsuIndex;
    }

    /**
     * toMyBatisParameter
     *
     * @param taishoShuryoYMD List<RString>
     * @return DBC180020MyBatisParameter
     */
    public DBC180020MyBatisParameter toMyBatisParameter(List<RString> taishoShuryoYMD) {
        return new DBC180020MyBatisParameter(hanteiKijunbi.get(hanteiKijunbiIndex),
                taishoNendo == null ? RString.EMPTY
                : new RString(taishoNendo.toString()), taishoGetsu.get(taishoGetsuIndex), taishoShuryoYMD);
    }
}
