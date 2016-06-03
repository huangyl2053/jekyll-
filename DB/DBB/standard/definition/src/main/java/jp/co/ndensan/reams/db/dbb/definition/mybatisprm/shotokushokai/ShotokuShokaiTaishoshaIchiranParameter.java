/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.shotokushokai;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBBGM51001_所得照会状況一覧のMapperのパラメータです。<br>
 *
 * @reamsid_L DBB-1700-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuShokaiTaishoshaIchiranParameter implements IMyBatisParameter {

    private Boolean is住民税減免前後表示;
    private RYear 基準年度;
    private RString 抽出期間FROM;
    private RString 抽出期間TO;
    private RString システム日付;

    /**
     * コンストラクタ
     *
     * @param is住民税減免前後表示 boolean
     * @param 基準年度 RYear
     * @param 抽出期間FROM RString
     * @param 抽出期間TO RString
     * @param システム日付 RString
     */
    public ShotokuShokaiTaishoshaIchiranParameter(boolean is住民税減免前後表示, RYear 基準年度,
            RString 抽出期間FROM, RString 抽出期間TO, RString システム日付) {
        this.is住民税減免前後表示 = is住民税減免前後表示;
        this.基準年度 = 基準年度;
        this.抽出期間FROM = 抽出期間FROM;
        this.抽出期間TO = 抽出期間TO;
        this.システム日付 = システム日付;
    }

    /**
     * コンストラクタ
     */
    public ShotokuShokaiTaishoshaIchiranParameter() {
    }

}
