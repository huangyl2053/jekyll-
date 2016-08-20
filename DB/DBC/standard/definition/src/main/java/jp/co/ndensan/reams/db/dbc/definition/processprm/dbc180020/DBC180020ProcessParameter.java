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
    private boolean testMode;
    private List<RString> hanteiKijunbi;
    private List<RString> taishoGetsu;
    private Integer chushutuKaisu;
    private int hanteiKijunbiIndex;
    private List<RString> 対象開始日;
    private List<RString> 対象終了日;
    private int index;
    private boolean 異動;

    /**
     * DBC180020ProcessParameterのコンストラクタです。
     *
     * @param taishoNendo 対象年度
     * @param 異動 boolean
     * @param 対象開始日 List<RString>
     * @param 対象終了日 List<RString>
     * @param taishoGetsu List<RString>
     * @param index Integer
     */
    public DBC180020ProcessParameter(RYear taishoNendo,
            boolean 異動,
            List<RString> 対象開始日,
            List<RString> 対象終了日,
            List<RString> taishoGetsu,
            Integer index) {
        this.taishoNendo = taishoNendo;
        this.異動 = 異動;
        this.index = index;
        this.taishoGetsu = taishoGetsu;
        this.対象開始日 = 対象開始日;
        this.対象終了日 = 対象終了日;
    }

    /**
     * DBC180020ProcessParameterのコンストラクタです。
     *
     * @param taishoNendo 対象年度
     * @param kijunbi 基準日
     * @param shoriKubun 処理区分
     * @param testMode テストモード
     * @param hanteiKijunbi 判定基準日
     * @param taishoGetsu 対象月
     * @param 対象開始日 List<RString>
     * @param 対象終了日 List<RString>
     * @param chushutuKaisu ループ回数
     */
    public DBC180020ProcessParameter(RYear taishoNendo,
            RString kijunbi,
            RString shoriKubun,
            boolean testMode,
            List<RString> hanteiKijunbi,
            List<RString> taishoGetsu,
            List<RString> 対象開始日,
            List<RString> 対象終了日,
            Integer chushutuKaisu) {
        this.taishoNendo = taishoNendo;
        this.kijunbi = kijunbi;
        this.shoriKubun = shoriKubun;
        this.testMode = testMode;
        this.hanteiKijunbi = hanteiKijunbi == null ? new ArrayList<RString>() : hanteiKijunbi;
        this.taishoGetsu = taishoGetsu;
        this.chushutuKaisu = chushutuKaisu;
        this.対象開始日 = 対象開始日;
        this.対象終了日 = 対象終了日;
    }

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
     * @param 対象開始日 List<RString>
     * @param 対象終了日 List<RString>
     */
    public DBC180020ProcessParameter(RYear taishoNendo,
            RString kijunbi,
            RString shoriKubun,
            boolean testMode,
            List<RString> hanteiKijunbi,
            List<RString> taishoGetsu,
            List<RString> 対象開始日,
            List<RString> 対象終了日,
            Integer chushutuKaisu,
            int hanteiKijunbiIndex) {
        this.taishoNendo = taishoNendo;
        this.kijunbi = kijunbi;
        this.shoriKubun = shoriKubun;
        this.testMode = testMode;
        this.hanteiKijunbi = hanteiKijunbi == null ? new ArrayList<RString>() : hanteiKijunbi;
        this.taishoGetsu = taishoGetsu;
        this.chushutuKaisu = chushutuKaisu;
        this.hanteiKijunbiIndex = hanteiKijunbiIndex;
        this.対象開始日 = 対象開始日;
        this.対象終了日 = 対象終了日;
    }

    /**
     * toMyBatisParameter
     *
     * @return DBC180020MyBatisParameter
     */
    public DBC180020MyBatisParameter toMyBatisParameter() {
        return new DBC180020MyBatisParameter(hanteiKijunbi.get(hanteiKijunbiIndex),
                taishoNendo == null ? RString.EMPTY
                : new RString(taishoNendo.toString()), taishoGetsu.get(hanteiKijunbiIndex),
                対象開始日.get(hanteiKijunbiIndex), 対象終了日.get(hanteiKijunbiIndex));
    }

    /**
     * toMyBatisParameter
     *
     * @param index int
     * @return DBC180020MyBatisParameter
     */
    public DBC180020MyBatisParameter toMyBatisParameter(int index) {
        return new DBC180020MyBatisParameter(hanteiKijunbi.get(index),
                taishoNendo == null ? RString.EMPTY
                : new RString(taishoNendo.toString()), taishoGetsu.get(index),
                対象開始日.get(index), 対象終了日.get(index));
    }

    /**
     * toMyBatisParameter
     *
     * @param 異動 boolean
     * @return DBC180020MyBatisParameter
     */
    public DBC180020MyBatisParameter toMyBatisParameter(boolean 異動) {
        DBC180020MyBatisParameter param;
        if (異動) {
            param = new DBC180020MyBatisParameter(
                    対象開始日.get(index), 対象終了日.get(index), this.taishoGetsu.get(index));
        } else {
            param = new DBC180020MyBatisParameter(対象開始日.get(0), 対象終了日.get(0), this.taishoGetsu.get(index));
        }
        param.set対象年度(taishoNendo == null ? RString.EMPTY : taishoNendo.toDateString());
        return param;
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
                : new RString(taishoNendo.toString()), taishoGetsu.get(hanteiKijunbiIndex),
                対象開始日.get(hanteiKijunbiIndex), 対象終了日.get(hanteiKijunbiIndex), taishoShuryoYMD);
    }
}
