/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.hikazeinenkintaishosha;

import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(非課税年金対象者)のProcess用パラメータクラスです。
 *
 * @reamsid_L DBD-5820-030 zhengsongling
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HikazeiNenkinTaishoshaProcessParameter implements IBatchProcessParameter {

    private RString 抽出方法;
    private RString 抽出年度;
    private RString 被保険者抽出方法;
    private boolean 最新情報;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付編集;
    private AtenaSelectBatchParameter 宛名抽出条件;
    private Long 出力順;
    private RString 出力項目;
    private RDate date;

    /**
     *
     * @param 抽出方法 抽出方法
     * @param 抽出年度 抽出年度
     * @param 被保険者抽出方法 被保険者抽出方法
     * @param 最新情報 最新情報
     * @param 項目名付加 項目名付加
     * @param 連番付加 連番付加
     * @param 日付編集 日付編集
     * @param 宛名抽出条件 宛名抽出条件
     * @param 出力順 出力順
     * @param 出力項目 出力項目
     * @param date date
     */
    public HikazeiNenkinTaishoshaProcessParameter(
            RString 抽出方法,
            RString 抽出年度,
            RString 被保険者抽出方法,
            boolean 最新情報,
            boolean 項目名付加,
            boolean 連番付加,
            boolean 日付編集,
            AtenaSelectBatchParameter 宛名抽出条件,
            Long 出力順,
            RString 出力項目,
            RDate date) {
        this.抽出方法 = 抽出方法;
        this.抽出年度 = 抽出年度;
        this.被保険者抽出方法 = 被保険者抽出方法;
        this.最新情報 = 最新情報;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付編集 = 日付編集;
        this.宛名抽出条件 = 宛名抽出条件;
        this.出力順 = 出力順;
        this.出力項目 = 出力項目;
        this.date = date;
    }

}
