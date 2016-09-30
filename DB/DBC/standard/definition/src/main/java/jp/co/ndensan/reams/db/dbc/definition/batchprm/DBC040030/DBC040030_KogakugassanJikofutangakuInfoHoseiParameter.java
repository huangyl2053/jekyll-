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

    private static final String KEY_KAKUNIN_UKETORIYM = "kakunin_UketoriYM";
    private static final String KEY_KAISHIYMD = "kaishiYMD";
    private static final String KEY_KAISHIWEEK = "kaishiWeek";
    private static final String KEY_KAISHIHHMM = "kaishiHHMM";
    private static final String KEY_SHURYOYMD = "shuryoYMD";
    private static final String KEY_SHURYOWEEK = "shuryoWeek";
    private static final String KEY_SHURYOHHMM = "shuryoHHMM";
    private static final String KEY_SHUTSURYOKUJUNID = "shutsuryokujunId";
    private static final String KEY_TREATMENTTYPE = "treatmentType";
    //private static final String KEY_DANTAICD = "dantaiCd";
    private static final String KEY_HANDLETIMESTAMP = "handleTimestamp";

    @BatchParameter(key = KEY_KAKUNIN_UKETORIYM, name = "確認情報受取年月")
    private RString kakunin_UketoriYM;
    @BatchParameter(key = KEY_KAISHIYMD, name = "開始年月日")
    private RString kaishiYMD;
    @BatchParameter(key = KEY_KAISHIWEEK, name = "開始曜日")
    private RString kaishiWeek;
    @BatchParameter(key = KEY_KAISHIHHMM, name = "開始時間")
    private RString kaishiHHMM;
    @BatchParameter(key = KEY_SHURYOYMD, name = "終了年月日")
    private RString shuryoYMD;
    @BatchParameter(key = KEY_SHURYOWEEK, name = "終了曜日")
    private RString shuryoWeek;
    @BatchParameter(key = KEY_SHURYOHHMM, name = "終了時間")
    private RString shuryoHHMM;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = "改頁出力順ID")
    private RString shutsuryokujunId;
    @BatchParameter(key = KEY_TREATMENTTYPE, name = "国保連共同処理受託区分(償還)")
    private RString treatmentType;
    //@BatchParameter(key = KEY_DANTAICD, name = "市町村コード")
    // private LasdecCode dantaiCd;
    @BatchParameter(key = KEY_HANDLETIMESTAMP, name = "処理日時")
    private RDateTime handleTimestamp;

}
