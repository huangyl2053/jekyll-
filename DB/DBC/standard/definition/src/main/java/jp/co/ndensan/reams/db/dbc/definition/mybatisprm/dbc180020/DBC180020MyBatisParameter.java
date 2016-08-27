/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180020;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * DBC180020MyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBC180020MyBatisParameter implements IMyBatisParameter {

    private static final RString 開始 = new RString("0801");
    private static final RString 終了 = new RString("0731");
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM5 = 5;
    private static final int NUM7 = 7;
    private static final int NUM8 = 8;
    private static final int NUM9 = 9;
    private static final int NUM10 = 10;
    private static final int NUM11 = 11;
    private static final int NUM4 = 4;
    private static final int NUM6 = 6;
    private RString 判定基準日;
    private RString 判定基準日の月;
    private RString 対象年度;
    private RString 対象年度開始日;
    private RString 対象年度終了日;
    private RString 対象開始日;
    private RString 対象終了日;
    private RString 対象月;
    private RString 対象終了日八月;
    private RString 対象終了日九月;
    private RString 対象終了日十月;
    private RString 対象終了日十一月;
    private RString 対象終了日十二月;
    private RString 対象終了日一月;
    private RString 対象終了日二月;
    private RString 対象終了日三月;
    private RString 対象終了日四月;
    private RString 対象終了日五月;
    private RString 対象終了日六月;
    private RString 対象終了日七月;

    /**
     * DBC180020MyBatisParameterのコンストラクタです。
     */
    public DBC180020MyBatisParameter() {
    }

    /**
     * DBC180020MyBatisParameterのコンストラクタです。
     *
     * @param 判定基準日 RString
     * @param 対象年度 RString
     * @param 対象月 RString
     * @param 対象開始日 RString
     * @param 対象終了日 RString
     */
    public DBC180020MyBatisParameter(RString 判定基準日, RString 対象年度, RString 対象月, RString 対象開始日,
            RString 対象終了日) {
        this.判定基準日 = 判定基準日;
        this.判定基準日の月 = RString.isNullOrEmpty(判定基準日) ? RString.EMPTY : 判定基準日.substring(NUM4, NUM6);
        this.対象年度 = 対象年度;
        this.対象月 = 対象月;
        this.対象開始日 = 対象開始日;
        this.対象終了日 = 対象終了日;
        if (対象年度 != null) {
            this.対象年度開始日 = 対象年度.concat(new RString("0801"));
            this.対象年度終了日 = new RString(Integer.parseInt(対象年度.trim().toString()) + 1).concat(new RString("0731"));
        }
    }

    /**
     * DBC180020MyBatisParameterのコンストラクタです。
     *
     * @param 対象開始日 RString
     * @param 対象終了日 RString
     * @param 対象月 RString
     */
    public DBC180020MyBatisParameter(RString 対象開始日, RString 対象終了日, RString 対象月) {
        this.対象開始日 = 対象開始日;
        this.対象終了日 = 対象終了日;
        this.対象月 = 対象月;
    }

    /**
     * DBC180020MyBatisParameterのコンストラクタです。
     *
     * @param 判定基準日 RString
     * @param 対象年度 RString
     * @param 対象月 RString
     * @param 対象終了日リスト List<RString>
     * @param 対象開始日 RString
     * @param 対象終了日 RString
     */
    public DBC180020MyBatisParameter(RString 判定基準日, RString 対象年度, RString 対象月, RString 対象開始日,
            RString 対象終了日, List<RString> 対象終了日リスト) {
        this.判定基準日 = 判定基準日;
        this.判定基準日の月 = RString.isNullOrEmpty(判定基準日) ? RString.EMPTY : 判定基準日.substring(NUM4, NUM6);
        this.対象年度 = 対象年度;
        this.対象月 = 対象月;
        this.対象終了日 = 対象終了日;
        this.対象開始日 = 対象開始日;
        if (対象年度 != null) {
            this.対象年度開始日 = 対象年度.concat(開始);
            this.対象年度終了日 = new RString(Integer.parseInt(対象年度.trim().toString()) + 1).concat(終了);
        }
        if (対象終了日リスト == null || 対象終了日リスト.isEmpty()) {
            return;
        }
        対象終了日八月 = 対象終了日リスト.get(0);
        対象終了日九月 = 対象終了日リスト.get(1);
        対象終了日十月 = 対象終了日リスト.get(NUM2);
        対象終了日十一月 = 対象終了日リスト.get(NUM3);
        対象終了日十二月 = 対象終了日リスト.get(NUM4);
        対象終了日一月 = 対象終了日リスト.get(NUM5);
        対象終了日二月 = 対象終了日リスト.get(NUM6);
        対象終了日三月 = 対象終了日リスト.get(NUM7);
        対象終了日四月 = 対象終了日リスト.get(NUM8);
        対象終了日五月 = 対象終了日リスト.get(NUM9);
        対象終了日六月 = 対象終了日リスト.get(NUM10);
        対象終了日七月 = 対象終了日リスト.get(NUM11);
    }
}
