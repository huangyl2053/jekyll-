/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt13011;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbddt13011.GeneralPurposeListOutputMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBDBT13011_汎用リスト出力(施設入退所)バッチパラメタークラスです．
 *
 * @reamsid_L DBD-1570-030 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GeneralPurposeListOutputProcessParameter implements IBatchProcessParameter {

    private RString 抽出方法区分;
    private RString 抽出項目区分;
    private FlexibleDate 基準日;
    private FlexibleDate 日付範囲From;
    private FlexibleDate 日付範囲To;
    private boolean 直近データ抽出;
    private RString 喪失区分;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付スラッシュ付加;
    private AtenaSelectBatchParameter 宛名抽出条件;
    private Long 出力順;
    private RString 出力項目;

    /**
     * コンストラクタです。
     *
     * @param 抽出方法区分 抽出方法区分
     * @param 抽出項目区分 抽出項目区分
     * @param 基準日 基準日
     * @param 日付範囲From 日付範囲From
     * @param 日付範囲To 日付範囲To
     * @param 直近データ抽出 直近データ抽出
     * @param 喪失区分 喪失区分
     * @param 項目名付加 項目名付加
     * @param 連番付加 連番付加
     * @param 日付スラッシュ付加 日付スラッシュ付加
     * @param 宛名抽出条件 宛名抽出条件
     * @param 出力順 出力順
     * @param 出力項目 出力項目
     */
    public GeneralPurposeListOutputProcessParameter(RString 抽出方法区分,
            RString 抽出項目区分,
            FlexibleDate 基準日,
            FlexibleDate 日付範囲From,
            FlexibleDate 日付範囲To,
            boolean 直近データ抽出,
            RString 喪失区分,
            boolean 項目名付加,
            boolean 連番付加,
            boolean 日付スラッシュ付加,
            AtenaSelectBatchParameter 宛名抽出条件,
            Long 出力順,
            RString 出力項目) {
        this.抽出方法区分 = 抽出方法区分;
        this.抽出項目区分 = 抽出項目区分;
        this.基準日 = 基準日;
        this.日付範囲From = 日付範囲From;
        this.日付範囲To = 日付範囲To;
        this.直近データ抽出 = 直近データ抽出;
        this.喪失区分 = 喪失区分;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付スラッシュ付加 = 日付スラッシュ付加;
        this.宛名抽出条件 = 宛名抽出条件;
        this.出力順 = 出力順;
        this.出力項目 = 出力項目;
    }

    /**
     * ＳＱＬ使用された情報を作成します．
     *
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param psmAtesaki 宛先PSM
     * @return ＳＱＬ使用されたパラメター情報
     */
    public GeneralPurposeListOutputMybatisParameter toGeneralPurposeListOutputMybatisParameter(RString psmShikibetsuTaisho, RString psmAtesaki) {

        return new GeneralPurposeListOutputMybatisParameter(抽出方法区分,
                抽出項目区分,
                基準日,
                日付範囲From,
                日付範囲To,
                直近データ抽出,
                喪失区分,
                項目名付加,
                連番付加,
                日付スラッシュ付加,
                宛名抽出条件,
                出力順,
                出力項目,
                psmShikibetsuTaisho,
                psmAtesaki);
    }
}
