/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040030;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBCMN62002_高額合算自己負担額情報補正（一括）のクラスです。
 *
 * @reamsid_L DBC-2320-010 chenyadong
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC040030_KogakugassanJikofutangakuInfoHoseiParameter extends BatchParameterBase {

    @BatchParameter(key = "kakunin_UketoriYM", name = "確認情報受取年月")
    private RString kakunin_UketoriYM;
    @BatchParameter(key = "kaishiYMD", name = "開始年月日")
    private RString kaishiYMD;
    @BatchParameter(key = "kaishiWeek", name = "開始曜日")
    private RString kaishiWeek;
    @BatchParameter(key = "kaishiHHMM", name = "開始時間")
    private RString kaishiHHMM;
    @BatchParameter(key = "shuryoYMD", name = "終了年月日")
    private RString shuryoYMD;
    @BatchParameter(key = "shuryoWeek", name = "終了曜日")
    private RString shuryoWeek;
    @BatchParameter(key = "shuryoHHMM", name = "終了時間")
    private RString shuryoHHMM;
    @BatchParameter(key = "shutsuryokujunId", name = "改頁出力順ID")
    private RString shutsuryokujunId;
    @BatchParameter(key = "treatmentType", name = "国保連共同処理受託区分(償還)")
    private RString treatmentType;
    @BatchParameter(key = "handleTimestamp", name = "処理日時")
    private RDateTime handleTimestamp;
    @BatchParameter(key = "出力フラグが", name = "出力フラグが")
    private boolean 出力フラグが;

}
